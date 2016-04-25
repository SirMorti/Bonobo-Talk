// JavaScript Document
$(document).ready(function(){
	$(".header").click(function(event) {
		var curr = $(this).next();
		$(".header").each(function(){
			if ($(this).next().css("display") == "block" && $(this).next()!==curr) {
				$(this).next().slideToggle(250);
			}
		});
		if(curr.css("display")!="block"){
			curr.slideToggle(250);
		}
	});
});