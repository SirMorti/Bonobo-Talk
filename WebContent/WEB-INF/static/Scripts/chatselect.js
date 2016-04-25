// JavaScript Document
$(document).ready(function(){
	$(".subTreeCap").click(function(event) {
		var curr = $(this).next();
		$(".subTreeCap").each(function(){
			if ($(this).next().css("display") == "block" && $(this).next()!==curr) {
				$(this).next().slideToggle(250);
			}
		});
		if(curr.css("display")!="block"){
			curr.slideToggle(250);
		}
	});
});