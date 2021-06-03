$(document).ready(function(){
 
	selectBox();


	$(".fileFind_wrap .close").click(function(){
		var inputAdd = "<input type='file' onchange='upFile($(this));' name='"+$(this).parent().parent().attr("data-name")+"' />";
		$(this).parent().parent().find("label").prepend(inputAdd);  
		$(this).parent().parent().find("input[type=file]").eq(1).remove();
		$(this).parent().parent().find(".image").hide();
		$(this).parent().parent().find(".close").hide();
		$(this).parent().parent().find(".zoom").hide();
		$(this).parent().parent().find("label").show();
		$(this).parent().parent().find(".imgPrev").hide();
		return false;
	});

	// 파일찾기
	$(".fileFind_wrap .fileFind input").change(function(){	
		$(this).parent().parent().prev().val($(this).val());
	});

	var scrHeight=$(".scroll_table_wrap .table_scroll_type01").height();
	$(".scroll_table_wrap").height(scrHeight+21);

	$(".entry_calendar").find("input").focus(function(){
		$(".monthPicker").hide();
	})

});
// e: document.ready
 
/* s: funciton
--------------------------------------------------------- */

function selectBox() { 
	var selectBoxState;
	$(".selectBox select").width( function(){ return $(this).prev().width()+35});
	$(".selectBox label").html(function(){return $("option:selected", $(this).next()).html()});
	$(".selectBox select").not("[disabled=disabled]").on({
		click : function(){
			if(selectBoxState !== null){
				$(this).parent().addClass("on"); 
			}else {
				selectBoxState = undefined;
			}
		},	
		change : function(){
			selectBoxState=null;
			$(this).parent().removeClass("on");
			$(this).prev().html($("option:selected", $(this)).text()); 
		},								
		blur : function(){
			$(this).parent().removeClass("on");  
		}									
	});
	$(".selectBox select").width( function(){ return $(this).prev().width()+34});
}



 
	
	function PreviewImg(imgFile)
	{							
		var newPreview = imgFile.parent().parent().find('.image .img');
		newPreview.attr("src", imgFile.val());
		newPreview.parent().show(); 
		imgFile.parent().parent().find(".close").show();
		imgFile.parent().parent().find(".zoom").show();		
		imgFile.parent().parent().find(".zoom").attr("href", imgFile.val());
		
		imgFile.parent().parent().find("label").hide();
		imgFile.parent().parent().find(".imgPrev").show();
	}

	function readURL(input) { 
		 input.each(function() {
			var $input = $(this);
			var inputFiles = this.files;
			if(inputFiles == undefined || inputFiles.length == 0) return;
			var inputFile = inputFiles[0];

			var reader = new FileReader();
			reader.onload = function(event) {
				$input.parent().parent().find('.image .img').attr("src", event.target.result);
				$input.parent().parent().find(".image").show();
				$input.parent().parent().find(".close").show();
				$input.parent().parent().find(".zoom").show();		
				$input.parent().parent().find(".zoom").attr("href", event.target.result);
				$input.parent().parent().find("label").hide();
				$input.parent().parent().find(".imgPrev").show(); 
			};
			reader.onerror = function(event) {
				alert("error: " + event.target.error.code);
			};
			reader.readAsDataURL(inputFile);
		});

	}
	//2014-03-03
	function upFile(obj){   
		if(navigator.userAgent.toLowerCase().indexOf("trident") <  0){
			if(navigator.userAgent.toLowerCase().indexOf("ie 7") <  0){				
				readURL(obj);  
			}else{		
				PreviewImg(obj);   
			}
		}else{
			PreviewImg(obj);   
		}
		return false;
	}
 

