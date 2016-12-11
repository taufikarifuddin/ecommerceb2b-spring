var app = angular.module('app',['ngResource']);

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

