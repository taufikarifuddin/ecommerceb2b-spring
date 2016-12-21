app.directive('uploadFile',function($parse){
    return {
        restrict : 'A',
        link : function($scope,$elem,$attrs){
            var model = $parse($attrs.fileModel);
            var modelAssign = model.assign;
                      
            $elem.bind('change',function(){
                $scope.$apply(function(){
                    modelAssign($scope,$elem[0].files[0]);                   
                })
            })
        }
    };
})

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