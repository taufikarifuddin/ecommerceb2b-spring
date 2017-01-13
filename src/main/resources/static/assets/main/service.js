app.service('MemberService', function($resource, RestFactory,
		DataAttributFactory, ErrorHandlerFactory) {

	var controllerName = "member"

	var customResource = $resource("", {}, {
		'checkEmail' : {
			url : '/api/' + controllerName + '/checkUserEmail',
			method : 'POST',
			headers : {
				'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
			}
		},
		'getLoggedUser' : {
			url : '/user/api/'+controllerName+'/get',
			method : 'POST',
			headers : {
				'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
			}
		}
	})
	
	return {

		checkEmail : function(email, fn) {

			customResource.checkEmail({
				email : email
			}, {}, function(resource) {
				fn(resource.baseResponse.data);
			})
		},
		getLoggedUser : function(fn){
			customResource.getLoggedUser({}, {}, function(response) {
				ErrorHandlerFactory.responseHandler(response, function(
						isSuccess, data) {
					fn(isSuccess, data);
				})
			})		
		},
		update : function(data, fn) {
			RestFactory.rest("member").update(
					{},
					DataAttributFactory.trim(data),
					function(response) {
						ErrorHandlerFactory.responseHandler(response, function(
								isSuccess, data) {
							fn(isSuccess, data);
						});
					})
		}

	};

})

app.service('MemberAddressService', function($resource, RestFactory,
		DataAttributFactory, ErrorHandlerFactory,USER_API_PREFIX) {
	
	var controllerName = "memberAddress";
	
	return {
		update : function(data,fn){
			RestFactory.rest(controllerName,USER_API_PREFIX).update({},DataAttributFactory.trim(data),function(response){
				console.log(response);
				ErrorHandlerFactory
				.defaultResponseHandler(response, fn);
			})
		}
	}
	
})


app.service('ProductService', function($resource, RestFactory,
		DataAttributFactory, ErrorHandlerFactory) {

	var controllerName = "product";

	var customResource = $resource("", {}, {
		'search' : {
			url : '/api/'+controllerName+'/search',
			method : 'POST',
			headers : {
				'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
			}
		}
	})
	
	return {
		getAll : function(data, fn) {
			customResource.search(data,{},function(response){
				ErrorHandlerFactory.responseHandler(response, function(
						isSuccess, data) {
					fn(isSuccess, data);
				});				
			})
		},
		getDetail : function(id, fn) {
			RestFactory.rest(controllerName).getDetail(
					{
						id : id
					},
					{},
					function(response) {
						ErrorHandlerFactory.responseHandler(response, function(
								isSuccess, data) {
							fn(isSuccess, data);
						});
					});
		}
	};

})

app.service('CartService', function($resource, RestFactory,
		DataAttributFactory, ErrorHandlerFactory, USER_API_PREFIX) {

	var controllerName = "cart";

	return {
		update : function(data, fn) {
			RestFactory.rest(controllerName, USER_API_PREFIX).update(
					{},
					data,
					function(response) {
						ErrorHandlerFactory
								.defaultResponseHandler(response, fn);
					});
		},
		getAll : function(fn) {
			RestFactory.rest(controllerName, USER_API_PREFIX).getAll(
					{},
					{},
					function(response) {
						ErrorHandlerFactory
								.defaultResponseHandler(response, fn);
					});
		},
		remove : function(id, fn) {
			RestFactory.rest(controllerName, USER_API_PREFIX).remove({
				id : id
			}, {}, function(response) {
				ErrorHandlerFactory.defaultResponseHandler(response, fn);
			});
		}
	};
})

app.service('OrderService', function($resource, RestFactory,
		DataAttributFactory, ErrorHandlerFactory, USER_API_PREFIX) {

	var controllerName = "order";
	
	var customResource = $resource("", {}, {
		'checkout' : {
			url : '/user/api/'+controllerName+'/checkout',
			method : 'POST',
			headers : {
				'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
			},
		},
		'getOrder' : {
			url : '/user/api/'+controllerName+'/history',
			method : 'GET',
			headers : {
				'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
			},			
		}

	})

	return {		
		checkout : function(data,fn){
			customResource.checkout({}, data, function(response) {
				ErrorHandlerFactory.responseHandler(response, function(
						isSuccess, data) {
					fn(isSuccess, data);
				})
			})			
		},
		getOrder : function(fn){
			customResource.getOrder({},{},function(response){
				ErrorHandlerFactory.responseHandler(response, function(
						isSuccess, data) {
					fn(isSuccess, data);
				})				
			});
		},
		updateStatus : function(data,fn){
			RestFactory.rest(controllerName).update(data,{},function(response){
				ErrorHandlerFactory.responseHandler(response, function(
						isSuccess, data) {
					fn(isSuccess, data);
				})
			});
		},
		detail : function(id,fn){
			RestFactory.rest(controllerName).getDetail({ id : id },{},function(response){
				ErrorHandlerFactory.responseHandler(response, function(
						isSuccess, data) {
					fn(isSuccess, data);
				})
			});			
		}
	};

});
