var url = 'Badlog';

function init()
{
	document.getElementById('btnSubmit').onclick = submitMessage;
}
function submitMessage()
{
	var id = document.getElementById('txId').value;
	var score = document.getElementById('txScore').value;
	var options = {
			method:'GET',
	        parameters:'id='+ escapeHTML(id) + '&score=' + escapeHTML(score),
	        onLoading:function()
	        {	        	
	        },
	        onSuccess:function(x)
	        {
	        	var resBack = x.responseText;
	        	
	        	if(resBack == 'ok')
	        	{
	        	 alert("哈哈哈！！");
	        	}
	        	else
	        	{
	        		alert('Submit failure!');
	        	}
	        },
	        onFailure:function()
	        {
	        	alert('Request failure');
	        }       
	};
	ajaxRequest(url,options);
}

function escapeHTML(str)
{
	str = str.replace('<','&lt;');
	str = str.replace('>','&gt;');
	return str;
}
window.onload = init;