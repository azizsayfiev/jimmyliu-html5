function getTransport()
{
	var version = [
	               function()
	               {
	            	   return new XMLHttpRequest();
	               },
	               function()
	               {
	            	   return new ActiveXObject('Microsoft.XMLHTTP');  
	               }
	               ];
	var request;
	for(var i = 0; i < version.length; i++)
	{
	    var lambda = version[i];
	    try
	    {
	    	request = lambda();
	    	break;
	    }
	    catch(e){}
	}
	return request;
}


function ajaxRequest(url,option)
{
	var request = getTransport();
	if(typeof request == 'undefined')
	{
	    throw new Error('Your browser is too old!');
	    return;
	}
	
	var url = url;
	var method = (option.method || 'POST').toUpperCase();
	if(method != 'GET' && method != 'POST')
	{
	    method = 'POST';
	}
	
	var parameters = option.parameters || null;
	var headers = option.headers || {};
	
	var onLoadingEventHandler = option.onLoading || function(){};
	var onCompleteEventHandler = option.onComplete || function(){};
	var onSuccessEventHandler = option.onSuccess || function(){};
	var onFailureEventHandler = option.onFailure || function(){};
	
	if(method == 'GET')
	{
		if(url.indexOf('?') > -1)
		{
			url +='&' + parameters;
		}
		else
		{
			url += '?' + parameters;
			
		}
	}
	
	
	request.open(method,url,true);
	request.setRequestHeader('contentType','application/x-www-form-urlencoded');
	for(var name in headers)
	{
		request.setRequestHeader(name,headers[name]);
	}
	
	
	request.onreadystatechange = function()
	{
		if(request.readyState == 1)
		{
			onLoadingEventHandler(request);
		}
		if(request.readyState == 4)
		{
			onCompleteEventHandler(request);
			if(request.status && request.status >= 200 && request.status < 300)
			{
			    onSuccessEventHandler(request);
			}
			else
			{
				onFailureEventHandler(request);
			}
		}		
	};
	request.send(parameters);
	
}