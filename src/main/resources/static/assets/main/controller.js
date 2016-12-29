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
	
//	$scope.checkCode = function(data){
////		$scope.$parent.isShowLoader=true;
//		var resource = $resource("",{},{
//			'getCode' : {
//				url : '/api/product/isExistCode',
//                method : 'POST',
//                headers : {
//                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
//                }
//			}
//		});
//		
//		resource.getCode({ code : data },{},function(response){
//			
//			var data = response.baseResponse.data;
//			$scope.isValidCode = false;
//			
//			if( typeof data === 'boolean' ){
//				$scope.isValidCode = data;				
//			}
////			console.log(data);
////			$scope.$parent.isShowLoader=false;
//		})
//	}
//	
	
	$scope.$watch('action',function(newVal,oldVal){
		$scope.$parent.link = $scope.link;
		$scope.$parent.action = $scope.action;
		$scope.$parent.id = $scope.id;		
	})
//	console.log($scope.id);
//	if( typeof $scope. )
	
	
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
//			console.log(newValue);
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
		if( $scope.form.error != 'undefined' )
			DataAttributFactory.remove($scope.form.error);
		$scope.isLoadingSubmit = true;
		MemberService.update(data,function(isSuccess,data){
			if( !isSuccess ){
				$scope.form.error = {};				
				$scope.form.error = data;
			}else{
				$scope.isSuccessRegister = true;
			}
			$scope.isLoadingSubmit = false;
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
		})
	}
	
});

app.controller('ProductController',function($scope,ProductService){
	
	$scope.listBarang = [];
	ProductService.getAll(1,function(isSuccess,data){
		$scope.listBarang = data;
	});
	
})


app.controller('DetailProduct',function($scope,ProductService){
	
	$scope.$watch('id',function(newVal,oldVal){
		ProductService.getDetail(newVal,function(isSuccess,data){
			
			console.log(data);
			
		});
	})
	
})
