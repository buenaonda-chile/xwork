$(document).ready(function(){
 
	selectBox();


	$(".fileFind_wrap .close").click(function(){
		var conf = confirm('이미지를 제거 하시겠습니까?');

		if(conf){	
		  var inputAdd = "<input type='file' onchange='upFile($(this));' name='"+$(this).parent().parent().attr("data-name")+"' />";
		  $(this).parent().parent().find("label").prepend(inputAdd);  
		  $(this).parent().parent().find("input[type=file]").eq(1).remove();		  
		  $(this).parent().parent().find(".old_file").val("");
		  $(this).parent().parent().find(".image").hide();
		  $(this).parent().parent().find(".close").hide();
		  $(this).parent().parent().find(".zoom").hide();
		  $(this).parent().parent().find("label").show();
		  $(this).parent().parent().find(".imgPrev").hide();
		  return false;		
		}
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

 