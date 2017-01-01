app.service('MemberService',function($resource,RestFactory,DataAttributFactory,ErrorHandlerFactory){
	
	var controllerName = "member"
	
	var customResource = $resource("",{},{
		'checkEmail' :  {
			url : '/api/'+controllerName+'/checkUserEmail',
            method : 'POST',
            headers : {
            	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
            }
		}
	})			

		
	return {
		
		checkEmail : function( email,fn ){
			
			customResource.checkEmail({ email : email },{},function(resource){				
				fn(resource.baseResponse.data);
			})
		},
		
		update : function(data,fn){
			RestFactory.rest("member").update({},DataAttributFactory.trim(data),function(response){				
				ErrorHandlerFactory.responseHandler(response,function(isSuccess,data){					
					fn(isSuccess,data);
				});
			})
		}
		
	};
			
})

app.service('ProductService',function($resource,RestFactory,DataAttributFactory,ErrorHandlerFactory){
	
	var controllerName = "product";		
	
	return {
		getAll : function(start,fn){			
			RestFactory.rest(controllerName).getAll({ start : start },{},function(response){
				ErrorHandlerFactory.responseHandler(response,function(isSuccess,data){					
					fn(isSuccess,data);
				});
			})
		},
		getDetail : function(id,fn){
			RestFactory.rest(controllerName).getDetail({ id : id },{},function(response){
				ErrorHandlerFactory.responseHandler(response,function(isSuccess,data){					
					fn(isSuccess,data);
				});				
			});
		}
	};
	
})


app.service('CartService',function($resource,RestFactory,DataAttributFactory,ErrorHandlerFactory,USER_API_PREFIX){
	
	var controllerName = "cart";
	
	return {
		update : function(data,fn){
			RestFactory.rest(controllerName,USER_API_PREFIX).update({}, data ,function(response){
				ErrorHandlerFactory.defaultResponseHandler(response,fn);
			});
		},
		getAll : function(fn){
			RestFactory.rest(controllerName,USER_API_PREFIX).getAll({},{},function(response){
				ErrorHandlerFactory.defaultResponseHandler(response,fn);
			});			
		},
		remove : function(id,fn){
			RestFactory.rest(controllerName,USER_API_PREFIX).remove({ id : id },{},function(response){
				ErrorHandlerFactory.defaultResponseHandler(response,fn);
			});			
		}
	};	
})