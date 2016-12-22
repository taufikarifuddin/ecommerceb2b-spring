var app = angular.module('app',['ngResource']);

app.config(function($httpProvider){
//	$httpProvider.interceptors.push('responseObserver');
})

app.factory('responseObserver', function responseObserver($q, $window) {
    return {
        'responseError': function(errorResponse) {
            switch (errorResponse.status) {
            case 403:
                $window.location = '/error/forbiden';
                break;
            case 404:
                $window.location = '/error/notfound';            	
            case 400:;
            case 500:
                $window.location = '/error/server';
                break;
            }
            return $q.reject(errorResponse);
        }
    };
});

app.factory('RestFactory',function($resource){

    var service = {};

    var getRestResponse = function(controllerName){
       
        return $resource("",{},{
            'getDetail' : {
                url : '/api/'+controllerName+'/get',
                method : 'GET',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }

            },
            'getAll' : {
                url : '/api/'+controllerName+'/getAll',
                method : 'GET',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }
            },
            'update' : {
                url : '/api/'+controllerName+'/update',
                method : 'POST',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }
            },
            'remove' : {
                url : '/api/'+controllerName+'/remove',
                method : 'POST',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }
            }
        });
    }    

    service.rest = getRestResponse;

    return service;

})

app.factory('DataAttributFactory',function(){
	var service = {};
	
	var removeData = function(errorData){
		if( typeof errorData !== 'undefined' )
			delete errorData;	
	}
	
	var trimData = function(data){
        for( var k in data ){
            if( typeof data[k] === 'string' )
	            if( data[k].trim() == "" ){
	                delete data[k];
	            }
        }
        return data;
	}
	
	service.remove = removeData;
	service.trim = trimData;
	
	return service;
})


app.factory('LoginFactory',function($resource){

    var service = {};

    var getRestResponse = function(controllerName){
    	
        return $resource("",{},{
            'admin' : {
                url : '/admin/login',
                method : 'POST',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }
                // params : data,                
            },
            'user' : {
                url : '/login',
                method : 'POST',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }
            },
            
        });
    }    

    service.login = getRestResponse;

    return service;

})

app.factory('ErrorHandlerFactory',function(){
	
    var service = {};
	
	
	var errorData = function(data){
		var error = {};
		for( var i = 0; i < data.baseResponse.data.length; i++ ){
			error[data.baseResponse.data[i].field] = data.baseResponse.data[i].defaultMessage;
		}		
		return error;
	}
	
	var isSuccess = function(data,fn){
		var dataResponse = data.baseResponse;
		if(dataResponse.error === false ){			
			if( typeof dataResponse.data != 'undefined' ){
				fn(true,dataResponse.data);				
			}else{
				fn(true);
			}
			
		}else{
			if( typeof dataResponse.data != 'undefined'){
				fn(false,errorData(data));
			}else{
				fn(false);				
			}
		}
	}
	
	service.getErrorData = errorData;
	service.responseHandler = isSuccess;
	
	return service;

})
