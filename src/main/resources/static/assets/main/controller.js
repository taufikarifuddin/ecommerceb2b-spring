app.controller('PageController',function(ErrorHandlerFactory,DataAttributFactory,RestFactory,$scope,$timeout){
	
	$scope.isShowLoader = true;
	
	$scope.getAction = function(newVal,oldVal){
			switch( newVal ){
			case 'getAll' : 				
				RestFactory.rest($scope.link).getAll({},{},function(response){
					if( response.baseResponse.data.length > 0 ){
						$scope.data = response.baseResponse.data;						
						console.log($scope.data);
					}else{
						$scope.isShowLoader = false;
					}
				})
				break;
			case 'add' : 
				$scope.isShowLoader = false;
				break;
			case 'edit' : 
				$scope.isShowLoader = false;
			case 'remove' :
				$scope.isShowLoader = false;
				RestFactory.rest($scope.link).getDetail({ id : $scope.id },{},function(response){					
					if( response.baseResponse.data === null ){
						window.location.href="/eror/notfound";
					}					
					$scope.form = response.baseResponse.data;						
				})				
				break;
		}		
	}
	
	$scope.$watch('action',$scope.getAction);
	
	$scope.remove = function(){
		
		if( window.confirm( "Apakah anda yakin ? " ) ){
			RestFactory.rest($scope.link).remove({id : $scope.id},{},function(response){						
				if( response.baseResponse.error === false ){
					window.location.href="/admin/"+$scope.link;
				}
			})
		}
	}
	
	$scope.submit = function(data){
		DataAttributFactory.remove($scope.error);
		$scope.isShowLoader = true;
		if( typeof data === 'undefined' ){
			data = {};
		}
		
		RestFactory.rest($scope.link).update({},DataAttributFactory.trim(data),function(response){						
			var data = response.baseResponse;			
			$scope.isShowLoader = false;			
			if( data.error === false){
				window.location.href="/admin/"+$scope.link;
			}else{
				$scope.error = ErrorHandlerFactory.getErrorData(response);
			}
		})
	}

	
	$scope.onEndRepeat = function(){
		$('#table-content').DataTable();
		$scope.isShowLoader = false;
	}
})

/*
 * Product controller
 * product,discount,image dan tag
 * */

app.controller('ProductFormController',function(RestFactory,$scope,$resource){
	
	$scope.$parent.isShowLoader = false;
//	$scope.isValid = true;
	
	RestFactory.rest('productCategory').getAll({},{},function(response){
		$scope.productCategory = response.baseResponse.data;
	})
	
	$scope.submit = function(data){
		console.log(data);
		$scope.$parent.link = $scope.link;
		$scope.$parent.submit(data);
	}
	
	$scope.$watch('action',function(newVal,oldVal){
		$scope.$parent.link = $scope.link;
		$scope.$parent.action = $scope.action;
		$scope.$parent.id = $scope.id;		
	})
	
	
})

app.controller('DiscountController',function(ErrorHandlerFactory,DataAttributFactory,RestFactory,$scope){
	
	$scope.$watch('$parent.id',function(newVal,oldVal){
		RestFactory.rest("productDiscount").getAll({ id : newVal },{},function(response){
			$scope.listDiscount = response.baseResponse.data;
		})
	})
	
	$scope.remove = function(data){		
		
		if( window.confirm("Apakah anda yakin ?") ){
			RestFactory.rest("productDiscount").remove({ id : data.id},{},function(response){
				ErrorHandlerFactory.responseHandler(response,function(isSuccess,data){
					if( isSuccess ){		
						//splice data dari index ke index sebanyak 1
						$scope.listDiscount.splice($scope.listDiscount.indexOf(data),1);
						alert('Data berhasil di hapus');
					}else{
						console.log(data);
					}
				})
			})
		}
	}
	
	
	$scope.submit = function(data){
		if( typeof data == 'undefined' )
			data = {};
		data['productId'] = $scope.$parent.id;
		DataAttributFactory.remove($scope.errordiscount);	
		
		RestFactory.rest("productDiscount").update({},DataAttributFactory.trim(data),function(response){
			ErrorHandlerFactory.responseHandler(response,function(isSuccess,dataVal){
				if( isSuccess ){
					$scope.formdiscount = {};
					$scope.listDiscount.push(dataVal);
				}else{
					console.log(response);
					$scope.errordiscount= dataVal;
				}
			})
		});
	}	
})

app.controller('GaleryController',function(ErrorHandlerFactory,DataAttributFactory,RestFactory,$scope,$http){
	
	$scope.allowExt = ['png','jpg','bmp','gif','jpeg'];
	$scope.isValidExt = false;
	
	$scope.$watch('$parent.id',function(newVal,oldVal){
		RestFactory.rest('productImage').getAll({ id : newVal },{},function(response){
			$scope.listImage = response.baseResponse.data;
			console.log($scope.listImage);
		})
	})
	
	$scope.$watch('productgalery',function(newValue,oldValue){				
		if( typeof newValue != "undefined" ){	
			$scope.productGalery = newValue;
			var dataImage = newValue.type.split("/");
			if( dataImage.length == 2 && $scope.allowExt.indexOf(dataImage[1]) > -1){
				$scope.isValidExt = true;
			}else{								
				$scope.isValidExt = false;
			}
		}
	})
	
	$scope.remove = function(data){
		if( window.confirm('Apakah anda yakin ? ') ){
			
			RestFactory.rest('productImage').remove({ id : data.id },{},function(response){
				ErrorHandlerFactory.responseHandler(response,function(isSuccess){
					if( isSuccess ){
						$scope.listImage.splice($scope.listImage.indexOf(data),1);
					}else{
						alert('Hapus data gagal');
					}
				})
			})
			
		}
	}
	
	$scope.submit = function(data){
		if( typeof data == 'undefined' )
			data = {};
		data['image'] = $scope.productgalery.name;
		data.productId = $scope.$parent.id;
		
		RestFactory.uploadFile($scope.productgalery,function(isSuccess,name,message){
			if( isSuccess ){
				data['image'] = name;				
				RestFactory.rest('productImage').update({},data,function(response){							
					ErrorHandlerFactory.responseHandler(response,function(isSuccess,dataVal){
						if( isSuccess ){
							$scope.listImage.push(dataVal);
						}else{
							$scope.errorimage = ErrorHandlerFactory.getErrorData(response);
						}
					})
				})				
			}else{
				alert(message);
			}
		})
		/*
		var formData = new FormData();
		formData.append('file',$scope.productgalery);
		
		$http.post("/api/productImage/upload",formData,{
			transformRequest: angular.identity,
            headers: {
            	'Content-Type': undefined,            	
            	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
            }
		}).success(function(response){			
		
			if( response.baseResponse.error === false){		
				data['image'] = response.baseResponse.message;				
				RestFactory.rest('productImage').update({},data,function(response){							
					ErrorHandlerFactory.responseHandler(response,function(isSuccess,dataVal){
						if( isSuccess ){
							$scope.listImage.push(dataVal);
						}else{
							$scope.errorimage = ErrorHandlerFactory.getErrorData(response);
						}
					})
				})
			}
			
		})*/
		
	}
	
})

app.controller('BannerController',function($scope,RestFactory){
	$scope.allowExt = ['png','jpg','bmp','gif','jpeg'];
	$scope.isValidExt = false;
	

	$scope.$watch('action',function(newVal,oldVal){
		$scope.$parent.link = $scope.link;
		$scope.$parent.action = $scope.action;
	})
	
	$scope.$watch('bannerImage',function(newVal,oldVal){
		$scope.bannerImage = newVal;
	});
	
	$scope.submit = function(data){
		
		RestFactory.uploadFile($scope.bannerImage,function(isSuccess,name,message){
			if( isSuccess){				
				if( typeof $scope.form == 'undefined' )
					$scope.form = {};
				$scope.form['image'] = name;
				$scope.$parent.link = $scope.link;
				$scope.$parent.submit(data);				
			}else{
				alert(message);
			}
		})
		
	}

})

/*
 * user controller
 * 
 * */
app.controller('SideBarController',function($scope,RestFactory){
	RestFactory.rest('productCategory').getAll({},{},function(response){
		$scope.categories = response.baseResponse.data;
	})
	
	$scope.categoryClick = function(category){
		$scope.$parent.categoryChoosen = category;
	}
	
	$scope.removeSearch = function(data){
		switch(data){
		case 'category':
			delete $scope.$parent.categoryChoosen;
			break;
		case 'name' :  
			delete $scope.$parent.nameSearch;
			break;
		}
	}
	
})


app.controller("SliderController",function($scope,RestFactory){
	RestFactory.rest('banner').getAll({},{},function(response){
		$scope.banners = response.baseResponse.data;
	})	
})

app.controller('RegisterController',function($scope,MemberService,DataAttributFactory){
	
	$scope.isValid = true;
	$scope.isValidPassword = true;
	$scope.isValidEmail = true;
	$scope.isLoad = false;
	$scope.form = {};
	$scope.isLoadingSubmit = false;
	$scope.isSuccessRegister = false;
	
	$scope.submit = function(data){
		$scope.$parent.parentLoader = true;

		if( $scope.form.error != 'undefined' )
			DataAttributFactory.remove($scope.form.error);
		$scope.isLoadingSubmit = true;
		MemberService.update(data,function(isSuccess,data){
			if( !isSuccess ){
				$scope.form.error = {};				
				$scope.form.error = data;
			}else{
				$scope.form = {};
				$scope.isSuccessRegister = true;
			}
			$scope.isLoadingSubmit = false;
			$scope.$parent.parentLoader = false;
		});
	}
	
	$scope.$watch('form.email',function(newVal,oldVal){
		$scope.isValidEmail = false;
		$scope.isLoad = true;
		MemberService.checkEmail(newVal,function(response){
			$scope.isValidEmail = response;
			$scope.isLoad = false;
		})
	})
	
	$scope.$watchGroup(['form.password','form.repassword'],function(newVal,oldVal,scope){
		if( newVal[0] === newVal[1] ){
			$scope.isValidPassword = true;
		}else{
			$scope.isValidPassword = false;			
		}
	});

	$scope.$watchGroup(['isValidPassword','isValidEmail'],function(newVal){
		$scope.isValid = $scope.isValidPassword && $scope.isValidEmail;
	})
	
})

app.controller('LoginUserController',function(LoginFactory,$scope){	
	$scope.status = "info";
	$scope.msg = "Silahkan masukkan username dan password";
	
	$scope.submit = function(data){
		$scope.$parent.parentLoader = true;

		LoginFactory.login().user(data,{},function(response){
			$scope.loginLoading = false;
			$scope.status = response.error === "true" ? "danger" : "success";
			$scope.msg = response.msg;
			console.log(response);
			if( response.error !== "true" ){
				setTimeout(function(){
					window.location.href=response.url;
				},1000);
			}
			$scope.$parent.parentLoader = false;
		})
	}
	
});

app.controller('ProductController',function($scope,ProductService){
	
	
	$scope.listBarang = [];
	
	$scope.$watchGroup(['categoryChoosen','nameSearch'],function(newVal,oldVal){
		$scope.$parent.parentLoader = true;
		var search = {};
		search.idCat = typeof newVal[0] == 'undefined' ?
				0:newVal[0].id;
		search.name = typeof newVal[1] == 'undefined' ? 
				'':newVal[1];
/*		search.offset = offset;
		search.start = 0;
	*/			
		ProductService.getAll(search,function(isSuccess,data){
			$scope.listBarang = data;
			$scope.$parent.parentLoader = false;
		});


	})
	
})


app.controller('DetailProductController',function($scope,ProductService,CartService,EVALUATE_DISC){
	

	$scope.form = {};
	
	$scope.form.qty = 0;
	
	$scope.cart = {
			type : '',
			msg : ''
	};
	
	$scope.$watch('id',function(newVal,oldVal){				
		$scope.form.productId = newVal;		
		
		ProductService.getDetail(newVal,function(isSuccess,data){
			$scope.image = data.images;
			$scope.discount = data.discounts;
			$scope.data = data;		
		});
		
	})
	
	$scope.$watch('form.qty',function(newVal,oldVal){
		if( typeof newVal !== 0 && typeof $scope.data !== 'undefined'){
			if( newVal < 0 || typeof newVal == 'undefined' || typeof newVal =='string' ){
				$scope.jumlah  = 0;
			}
			console.log(newVal);
			$scope.totalPembelian = EVALUATE_DISC(newVal,$scope.discount,$scope.data.price) * newVal;
		}else
			$scope.totalPembelian = 0;
		
	})
	
	$scope.getTotalImageContinaer = function(totalElem){
		if( typeof totalElem  == 'undefined'){
			totalElem = 0;
		}
		return new Array(Math.ceil( ( totalElem / 3 ) ));
	}
	
	$scope.submit = function(form){
		$scope.$parent.parentLoader = true;

		CartService.update(form,function(isSuccess,data){
			if( isSuccess ){
				$scope.form.qty = 0;
			}
			
			$scope.cart.type= isSuccess ? "success" : "danger";
			$scope.cart.msg= isSuccess ? "Barang berhasil di tambahkan" : 
				"Barang gagal di tambahkan";
			
			$scope.$parent.parentLoader = false;
		})
	}
		
})

app.controller('CartController',function($scope,CartService,EVALUATE_DISC){
	
	$scope.total = 0;
	
	CartService.getAll(function(isSuccess,data){
		$scope.data = data;
		
		for( var i = 0; i < data.length; i++ ){
			$scope.data[i].total =  EVALUATE_DISC(data[i].qty,
					data[i].product.discounts,data[i].product.price) * data[i].qty;
		}
		
	})	
	
	$scope.$watch('data',function(newVal,oldVal){
		if( typeof newVal === 'object' ){
			newVal.forEach(function(elem,itr){
				$scope.total += elem.total;
			})
		}else{
			$scope.total = 0;
		}
	})
	
	$scope.remove = function(dataDetail){

		$scope.$parent.parentLoader = true;
		CartService.remove(dataDetail.id,function(isSuccess,data){
			if( isSuccess ){				
				$scope.total = $scope.total - dataDetail.total;
				console.log(dataDetail.total);
				$scope.data.splice( $scope.data.indexOf(dataDetail) , 1 );
			}
			$scope.$parent.parentLoader = false;
		})
	}
})

app.controller('CheckoutFormController',function($scope,OrderService){
	
	$scope.date = new Date();
	$scope.loading = false;
	
	$scope.submit = function(alamat){
		$scope.$parent.parentLoader = true;
		OrderService.checkout({ address : alamat },function(isSuccess,data){	
			$scope.$parent.alreadyCheckout = true;
			if( isSuccess && data == true ){
				$scope.$parent.statusCheckout = true;
			}
			else{
				$scope.$parent.statusCheckout = false;				
			}
		})
	}
	
})

app.controller('ProfilController',function($scope,MemberService,DataAttributFactory,MemberAddressService){
	
	$scope.reinputpass = $scope.reinputrepass = '';
	$scope.address = {};
	$scope.profile = {};
	
	$scope.$watchGroup(['reinputpass','reinputrepass'],function(newVal,oldVal){
		$scope.valid = newVal[0] == newVal[1];
	})
		
	MemberService.getLoggedUser(function(isSuccess,data){
		if( typeof data.address != 'undefined' && data.address.length > 0){
			$scope.address = data.address[0];
			console.log($scope.address);
			delete data['address'];
		}
		
		$scope.profile = data;
	});
	
	$scope.submitProfile = function(data){
		
		if( typeof data === 'undefined' )
			data = {};
		

		if( $scope.reinputpass != '' && typeof $scope.reinputpass != 'undefined' )
			data.password = $scope.reinputpass;			
		

		$scope.$parent.parentLoader = true;
		
		MemberService.update(DataAttributFactory.trim(data),function(isSuccess,data){
			$scope.profileType = isSuccess ? 'success' : 'danger';
			$scope.profileMsg = isSuccess ? 'Berhasil memperbaharui' : 'Gagal memperbaharui';			
			if( !isSuccess ){
				$scope.profile.error = {};				
				$scope.profile.error = data;				
			}
			$scope.$parent.parentLoader = false;
		});
	}
	
	$scope.submitAddress = function(data){
		
		$scope.$parent.parentLoader = true;

		MemberAddressService.update(data,function(isSuccess,data){
			$scope.addressType = isSuccess ? 'success' : 'danger';
			$scope.addressMsg = isSuccess ? 'Berhasil memperbaharui' : 'Gagal memperbaharui';			
			if( !isSuccess ){
				$scope.address.error = {};				
				$scope.address.error = data;
				console.log(data);
			}
			console.log(isSuccess);
			$scope.$parent.parentLoader = false;
		})
	}
	
})

app.controller('OrderHistoryController',function($scope,OrderService){	
	OrderService.getOrder(function(isSuccess,data){		
		$scope.listData = data;
		for( var i = 0; i < $scope.listData.length; i++ ){
			$scope.listData[i].total = 0;
			for( var j = 0; j < $scope.listData[i].orderItems.length; j++ ){
				$scope.listData[i].total += $scope.listData[i].orderItems[j].finalPrice;
			}
		}
	})
})