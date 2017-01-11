var app = angular.module('app',['ngResource']);

app.value('BASE_TEMPLATE',"/assets/main/template")
app.value('USER_API_PREFIX',"/user");
app.value('ADMIN_API_PREFIX',"/admin");
app.value('EVALUATE_DISC',function(total,listDisc,price){	
	
	var discount = price;
	for(var i =0; i < listDisc.length; i++){		
		if( total >= listDisc[i].tracehold ){
			discount = listDisc[i].discount;
			console.log(discount);
		}else{
			break;
		};
	}
	return discount;
});

app.factory('responseObserver', function responseObserver($q, $window) {
	console.log('called');
    return {
        'responseError': function(errorResponse) {
        	console.log(errorResponse);
            switch (errorResponse.status) {
            case 403:
                $window.location = '/error/forbiden';
                break;
            case 404:
                $window.location = '/error/asdasd';            	
            case 400:;
            case 500:
                $window.location = '/error/server';
                break;               
            case 401 : 
            	$window.location = "/user/login";
            	break;
            }
            return $q.reject(errorResponse);
        }
    };
});


app.config(function($httpProvider){
//	$httpProvider.interceptors.push('responseObserver');
})

app.factory('RestFactory',function($resource,$http){
	
    var service = {};

    var getRestResponse = function(controllerName,prefix){
    	
    	if( typeof prefix  == 'undefined')
    		prefix = "";
    		
        return $resource("",{},{
            'getDetail' : {
                url : prefix+'/api/'+controllerName+'/get',
                method : 'GET',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }

            },
            'getAll' : {
                url : prefix+'/api/'+controllerName+'/getAll',
                method : 'GET',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }
            },
            'update' : {
                url : prefix+'/api/'+controllerName+'/update',
                method : 'POST',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }
            },
            'remove' : {
                url : prefix+'/api/'+controllerName+'/remove',
                method : 'POST',
                headers : {
                	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
                }
            }
        });
    }    

    var uploadFileHandler = function(file,fn){
    	
    	var DEFAULT_MESSAGE_FAIL_UPLOAD = "File gagal di upload";
    	
    	if( typeof file === 'undefined' ){
    		fn(false,"",DEFAULT_MESSAGE_FAIL_UPLOAD)
    	}
    	
		var formData = new FormData();
		formData.append('file',file);

    	
    	return $http.post("/api/image/upload",formData,{
			transformRequest: angular.identity,
            headers: {
            	'Content-Type': undefined,            	
            	'X-CSRF-TOKEN' : $('meta[name="_csrf"]').attr('content')
            }
		}).success(function(response){			
		
			if( response.baseResponse.error === false){		
				fn(true,response.baseResponse.message);
			}else{
				fn(false,"",DEFAULT_MESSAGE_FAIL_UPLOAD);
			}
			
		})
    }
    
    service.rest = getRestResponse;
    service.uploadFile = uploadFileHandler;
    
    return service;

})

app.factory('DataAttributFactory',function(){
	var service = {};
	
	var removeData = function(errorData){
		if( typeof errorData !== 'undefined' )
			delete errorData;	
	}
	
	var trimData = function(data){
		
		if( typeof data === 'undefined' )
			return {};
			
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
                url : '/user/login',
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
	
	var defaultResponseHandler = function(response,fn){
		isSuccess(response,function(isSuccess,data){					
			fn(isSuccess,data);
		});	
	}
	
	var isSuccess = function(data,fn){
		var dataResponse = data.baseResponse;		
		
		
		if( typeof dataResponse === 'undefined' ){
			fn(false,null);
			return;
		}
			
		
		if( dataResponse.error === false ){			
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
	service.defaultResponseHandler = defaultResponseHandler;
	
	return service;

})

app.factory('ParserFactory',function(){
	return {
		parse : function(data){
			var dataParse = data.baseResponse;
			return {
				data : dataParse.data,
				msg : dataParse.msg,
				isError : dataParse.error
			}
		}
	};
})
