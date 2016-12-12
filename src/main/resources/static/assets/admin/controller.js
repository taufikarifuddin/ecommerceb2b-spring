

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
			console.log(response);
			if( $scope.status !== "true" ){
				setTimeout(function(){
					window.location.href=response.url;
				},1000);
			}
		})
	}	
})

app.controller('PageController',function(DataAttributFactory,RestFactory,$scope,$timeout){
	
	$scope.isShowLoader = true;
	$scope.$watch('action',function(newVal,oldVal){
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
					$scope.form = response.baseResponse.data;					
				})				
				break;
		}		
	})
	
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
				$scope.error = {};
				for( var i = 0; i < data.data.length; i++ ){
					$scope.error[data.data[i].field] = data.data[i].defaultMessage;
				}
			}
		})
	}

	
	$scope.onEndRepeat = function(){
		$('#table-content').DataTable();
		$scope.isShowLoader = false;
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