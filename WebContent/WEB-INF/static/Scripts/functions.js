// JavaScript Document
$(document).ready(function(){
	
	var mouseInside = false;
	
   	$('#navigation').load( cp+"/Templates/navigation" );
	$('#footer').load(cp+"/Templates/footer");
	$('#drdwSettings').load(cp+"/Templates/settings"); 
	$("#drdwSettings").hide();					
	
	$("#loginLink").click(function(event) {
		event.preventDefault();
    	$('#popupContainer').show();
		$('body').css("position","fixed");
		$('body').css("overflow-y","scroll");
		$('body').css("width","100%");
	});
	
	$(document.body).on("click", "#loginToggle", function(){
		if($("#login").is(":hidden")){
			$("#login").show();
			$("#signup").hide();
			$("#loginToggle").removeClass("inactiveBtn");
			$("#signupToggle").addClass("inactiveBtn");
		}
	});
	
	$(document.body).on("click", "#signupToggle", function(){
		if(!$("#signup").is(":visible")){
			$("#signup").show();
			$("#login").hide();
			$("#loginToggle").addClass("inactiveBtn");
			$("#signupToggle").removeClass("inactiveBtn");
		}
	});
	
	$(document.body).on("click", "#popupContainer", function(){
		event.stopPropagation();
		$('#popupContainer').hide();
		$('body').css("position","static");
	});
	
	$(window).keydown(function(event){
		if(event.keyCode === 27){
			$('#popupContainer').hide();
			$('body').css("position","static");
		}
	});
	
	$("body").delegate("#popupLogin, #popupContainer","DOMmousescroll mousewheel click", function(event){
		event.stopPropagation();
	});
	
	$(document.body).on("click", "#account", function(){
		$('#accLink')[0].click();
	});
	
	$("#settings").click(function(){
		if($("#drdwSettings").is(":hidden")) $("#drdwSettings").show();
		else $("#drdwSettings").hide();
	});
	
	$("#drdwSettings").hover(function(){ 
		mouseInside=true; 
    }, function(){ 
    	mouseInside=false; 
    });
	
	$(window).mouseup(function(){ 
        if(! mouseInside) $("#drdwSettings").hide();
    });
	
	$("#myForm").validate({
	      
        // Specify the validation rules
        rules: {
            firstname: "required",
            lastname: "required",
            username: {
            	required: true,
            	minlength: 3,
            	maxlength: 15
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5
        },
        dob: {
            required: true,
            date: true,
    },
        
        // Specify the validation error messages
        messages: {
            firstname: "Please enter your first name",
            lastname: "Please enter your last name",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            email: "Please enter a valid email address"
        },
        tooltip_options: {
        	firstname: {trigger:'focus'},
        	lastname: {placement:'right',html:true}
        	},
        }
        });
    
    });
	
