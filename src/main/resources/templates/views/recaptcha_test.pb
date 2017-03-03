
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src='https://www.google.com/recaptcha/api.js'></script>
<div class="g-recaptcha" data-sitekey="{{siteKey}}"></div>
<input type="button" value="인증" onClick="auth()"/>

<script>
	function auth(){
		
		$.ajax({      
        	type:"POST",  
        	url:"/test/recaptcha",      
        	data:"g-recaptcha-response="+grecaptcha.getResponse(),      
        	success:function(response){ 
        		if(response.code == 0){
        			alert("You are Human!");
        		}else{
        			alert("You are Not Human!");
        		}
            	
        	},   
        	error:function(e){  
            	alert("You are Not Human!");
        	}  
    });  
	}
</script>
