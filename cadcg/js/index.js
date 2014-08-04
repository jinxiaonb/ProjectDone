// JavaScript Document
$(document).ready(function(e) {
	var screenwidth = screen.availWidth;
	var changeheight = 560;
	var changewidth = 900;

	$(".slide").css({"width":changewidth,"height":changeheight});
	$(".slide div").css({"width":changewidth,"height":changeheight});
	$(".slide div img").css({"width":changewidth,"height":changeheight});
	$(".PrevAndNext").css({"top":changeheight/2+60});
	$(".quickChange").css({"top":changeheight*999/1000+90});
	
	if(screenwidth > 1400){
		$(".prev").css({"margin-left":200});
		$(".next").css({"margin-right":200});
	}else{
		$(".prev").css({"margin-left":60});	
		$(".next").css({"margin-right":60});
	}
	
	var time = setInterval(function(){next()},6000);
	
	$(".prev").bind("click",function(){
		clearInterval(time);
		prev();
		time = setInterval(function(){next()},6000);
	});
	
	$(".next").bind("click",function(){
		clearInterval(time);
		next();
		time = setInterval(function(){next()},6000);
	});
	
	$("#slideimage1").bind("click",function(){
		$(".choice").removeClass();
		$("#slide1").attr("class","choice");
		$(".choiceimage").removeClass();
		$("#slideimage1").attr("class","choiceimage");
	});
	
	$("#slideimage2").bind("click",function(){
		$(".choice").removeClass();
		$("#slide2").attr("class","choice");
		$(".choiceimage").removeClass();
		$("#slideimage2").attr("class","choiceimage");
	});
	
	$("#slideimage3").bind("click",function(){
		$(".choice").removeClass();
		$("#slide3").attr("class","choice");
		$(".choiceimage").removeClass();
		$("#slideimage3").attr("class","choiceimage");
	});
	
	$("#slideimage4").bind("click",function(){
		$(".choice").removeClass();
		$("#slide4").attr("class","choice");
		$(".choiceimage").removeClass();
		$("#slideimage4").attr("class","choiceimage");
	});
	
	function prev(){
		var preChoiceID  = ($(".choice").attr("id"));
		if(preChoiceID == "slide1"){
			prev1();
		}else if(preChoiceID == "slide2"){
			prev2();
		}else if(preChoiceID == "slide3"){
			prev3();
		}else{
			prev4();
		}
	}
	
	function next(){
		var preChoiceID  = ($(".choice").attr("id"));
		if(preChoiceID == "slide1"){
			next1();
		}else if(preChoiceID == "slide2"){
			next2();
		}else if(preChoiceID == "slide3"){
			next3();
		}else{
			next4();
		}
	}
	
	function prev1(){
			$("#slide1").attr("class","");
			$("#slide4").attr("class","choice");
			$("#slide1").fadeOut("slow");
			$("#slide4").fadeIn("slow");
			$("#slideimage1").attr("class","");
			$("#slideimage4").attr("class","choiceimage");
	}
	
	function prev2(){
			$("#slide2").attr("class","");
			$("#slide1").attr("class","choice");
			$("#slide2").fadeOut("slow");
			$("#slide1").fadeIn("slow");
			$("#slideimage2").attr("class","");
			$("#slideimage1").attr("class","choiceimage");
	}
	
	function prev3(){
			$("#slide3").attr("class","");
			$("#slide2").attr("class","choice");
			$("#slide3").fadeOut("slow");
			$("#slide2").fadeIn("slow");
			$("#slideimage3").attr("class","");
			$("#slideimage2").attr("class","choiceimage");
	}
	
	function prev4(){
			$("#slide4").attr("class","");
			$("#slide3").attr("class","choice");
			$("#slide4").fadeOut("slow");
			$("#slide3").fadeIn("slow");
			$("#slideimage4").attr("class","");
			$("#slideimage3").attr("class","choiceimage");
	}
	
	function next1(){
			$("#slide1").attr("class","");
			$("#slide2").attr("class","choice");
			$("#slide1").fadeOut("slow");
			$("#slide2").fadeIn("slow");
			$("#slideimage1").attr("class","");
			$("#slideimage2").attr("class","choiceimage");	
	}
	
	function next2(){
			$("#slide2").attr("class","");
			$("#slide3").attr("class","choice");
			$("#slide2").fadeOut("slow");
			$("#slide3").fadeIn("slow");
			$("#slideimage2").attr("class","");
			$("#slideimage3").attr("class","choiceimage");	
	}
	
	function next3(){
			$("#slide3").attr("class","");
			$("#slide4").attr("class","choice");
			$("#slide3").fadeOut("slow");
			$("#slide4").fadeIn("slow");
			$("#slideimage3").attr("class","");
			$("#slideimage4").attr("class","choiceimage");	
	}
	
	function next4(){
			$("#slide4").attr("class","");
			$("#slide1").attr("class","choice");
			$("#slide4").fadeOut("slow");
			$("#slide1").fadeIn("slow");
			$("#slideimage4").attr("class","");
			$("#slideimage1").attr("class","choiceimage");	
	}
});