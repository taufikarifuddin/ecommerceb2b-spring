

app.controller('LoginController',function(LoginFactory,$scope){
	
	$scope.loginLoading = false;
	$scope.status = "info";
	$scope.msg = "Silahkan masukkan email dan password";
	
	
	$scope.submit = function(data){
		
		$scope.loginLoading = true;
		
		LoginFactory.login().admin(data,{},function(response){
			$scope.loginLoading = false;
			$scope.status = response.error === "true" ? "danger" : "success";
			$scope.msg = response.msg;
			if( $scope.status !== "true" ){
				setTimeout(function(){
					window.location.href=response.url;
				},1000);
			}
		})
	}	
})

app.controller('PageController',function(ErrorHandlerFactory,DataAttributFactory,RestFactory,$scope,$timeout){
	
	$scope.isShowLoader = true;
	
	$scope.getAction = function(newVal,oldVal){
			switch( newVal ){
			case 'getAll' : 				
				RestFactory.rest($scope.link).getAll({},{},function(response){
					if( response.baseResponse.data.length > 0 ){
						$scope.data = response.baseResponse.data;						
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
		console.log(data);
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
		console.log(data);		
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




/* directive */
app.directive('repeatEnd',function(){
	return {
		 restrict: 'A',
		 link: function ($scope, element, attr) {
            if ($scope.$last === true) {
            	$scope.$eval(attr.repeatEnd);
            }
        }		 
	}
})