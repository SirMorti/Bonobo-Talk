// JavaScript Document
$(document).ready(function(){
	var imgCount  = 2,
		currImgNr = 1;

	for (var count=imgCount; count>=1; count--){
		$(new Image())
		.attr('src', 'Pictures/Slideshow/SLSHOW_'+count+'.png')
		.attr('id', 'SLSHOW_'+count)
		.appendTo($('#imageContainer'));
	}

	$("#next").click(function(event) {
		$("#SLSHOW_"+currImgNr).fadeOut(200);
		if(currImgNr==imgCount) currImgNr = 1;
		else currImgNr++;
		$("#SLSHOW_"+currImgNr).fadeIn(200);
		resetImgTimer();
	});
	$("#prev").click(function(event) {
		$("#SLSHOW_"+currImgNr).fadeOut(200);
		if(currImgNr==1) currImgNr = imgCount;
		else currImgNr--;
		$("#SLSHOW_"+currImgNr).fadeIn(200);
		resetImgTimer();
	});

	function chngImg(){
		$("#next").trigger("click");
	};
	
	function resetImgTimer(){
		clearInterval(imgTimer);
		imgTimer = setInterval(chngImg, 8000);	
	};

	var imgTimer   = setInterval(chngImg, 8000);
});