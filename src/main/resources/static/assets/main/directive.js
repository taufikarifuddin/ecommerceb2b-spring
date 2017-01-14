app.directive('uploadFile', function($parse) {
	return {
		restrict : 'A',
		link : function($scope, $elem, $attrs) {
			var model = $parse($attrs.fileModel);
			var modelAssign = model.assign;

			$elem.bind('change', function() {
				$scope.$apply(function() {
					modelAssign($scope, $elem[0].files[0]);
				})
			})
		}
	};
})

app.directive('repeatEnd', function() {
	return {
		restrict : 'A',
		link : function($scope, element, attr) {
			if ($scope.$last === true) {
				$scope.$eval(attr.repeatEnd);
			}
		}
	}
})

app.directive('productDetail', function(BASE_TEMPLATE) {
	return {
		restrict : 'E',
		scope : {
			'detail' : '=detail'
		},
		templateUrl : BASE_TEMPLATE + "/product-detail.html",
		link : function($scope, element, attr) {
			console.log($scope.detail);
		}
	}
})

app.directive('stringToNumber', function() {
	return {
		require : 'ngModel',
		link : function(scope, element, attrs, ngModel) {
			ngModel.$parsers.push(function(value) {
				return '' + value;
			});
			ngModel.$formatters.push(function(value) {
				return parseFloat(value);
			});
		}
	};
});