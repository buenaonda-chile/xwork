/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
"use strict";

/**
 * [ko]메인 메뉴코드 객체
 */
function McdObj(mcdCode, mcdUse, mcdUrl, mcdName, mcdIcon, mcdNewWindow, mcdAddCert, mcdMobile) {
	this.mcdCode = mcdCode;
	this.mcdUse = mcdUse;
	this.mcdUrl = mcdUrl;
	this.mcdName = mcdName;
	this.mcdIcon = mcdIcon;
	this.mcdNewWindow = mcdNewWindow;
	this.mcdAddCert = mcdAddCert;
	this.mcdMobile = mcdMobile;
	
	/*this.toString = function () {
		console.log("mcdCode:" + this.mcdCode + ", mcdUse:" + this.mcdUse + ", mcdUrl:" + mcdUrl + ", mcdName:" + mcdName + "mcdIcon:" + this.mcdIcon + "mcdNewWindow:" + this.mcdNewWindow);
	}*/
}

/**
 * [ko]메인 메뉴코드 등록하는 함수
 */
function insertMenu(mcdObj) {
	$.ajax({
		method : "post",
		url : "/ajaxMenu/create.do",
		data : mcdObj,
		success : function(res) {
			var data = JSON.parse(res);
				location.reload()
//				setTimeout(function() {
//					mask.close();
//				}, 500);
		},
		error : function(res) {
			console.log("error")
			console.log(res)
		},
		completed : function(res) {
			setTimeout(function() {
				mask.close();
			}, 500);
			console.log("completed")
			console.log(res)
		}
	});
}

/**
 * [ko] 메뉴 위치이동
 * @param cEl 현재 드래그되는 Element
 * @param target 삽입되는 Element
 * @param 현재 드래그메뉴의 변경되는 order(=sort)
 */
function updateMoveMenu(cEl, targetEl, cEl_moved_order){
	var mcdCode = $(cEl).attr('id');
	var newRefMcd = $(targetEl).attr('id');
	if(newRefMcd === undefined){
		newRefMcd = 0;
	}
	
	$.ajax({
		method : "post",
		url : "/ajaxMenu/updateMove.do",
		data : {
			"mcdCode" : mcdCode,
			"newMcdSort" : cEl_moved_order,
			"newRefMcd" : newRefMcd,
			"countChild" : $(cEl).attr('data-hassub')
		},
		success : function(res) {
			var data = JSON.parse(res);
			if(data.result === RESULT_OK){
				location.reload();
			}
		},
		error : function(res) {
			console.log("error")
			console.log(res)
		},
		completed : function(res) {
			setTimeout(function() {
				mask.close();
			}, 500);
			console.log("completed")
			console.log(res)
		}
	});
}

/**
 * [ko] 메뉴 정보 업데이트
 * @param McdObj
 * @param 메뉴정보 Elements([0]:메뉴정보 수정 Elements, [1]:메뉴정보 Elements)
 */
function updateMenu(mcdObj, arrTargetDiv){
	
	$.ajax({
		method : "post",
		url : "/ajaxMenu/update.do",
		data : mcdObj,
		success : function(res) {
			console.log("res:" + res);
			var data = JSON.parse(res);
			
			if(data.result === RESULT_OK){
				setData(arrTargetDiv[1], mcdObj);
				$(arrTargetDiv[0]).css('display', 'none')
				$(arrTargetDiv[1]).css('display', 'block')
				setTimeout(function() {
					toastMsg("수정되었습니다.");
					mask.close();
				}, 500);
			}
				
		},
		error : function(res) {
			console.log("error")
			console.log(res)
		},
		completed : function(res) {
			setTimeout(function() {
				mask.close();
			}, 500);
			console.log("completed")
			console.log(res)
		}
	});
}

/**
 * 메뉴 데이터 수정 후 수정된 데이터를 화면에 셋팅해주는 메소드
 * @param 변경할 Elements  
 * @param 변경할 값 McdObj
 */
function setData(objEl, mcdObj) {
	mcdObj.toString();
	var mcdIconEl = $($($(objEl).find('.mcdIcon')).children('span'));
	mcdIconEl.removeClass();
	mcdIconEl.addClass(mcdObj.mcdIcon);
	$(objEl).find('.mcdName').html(mcdObj.mcdName);
	if(mcdObj.mcdUse === 'Y'){
		$(objEl).find('.mcdUse').html('사용');
	} else {
		$(objEl).find('.mcdUse').html('미사용');
	}
	
	if(mcdObj.mcdNewWindow === 'Y'){
		console.log("if(mcdObj.mcdUse === 'Y')");
		$(objEl).find('.mcdNewWindow').html('사용');
	} else {
		console.log("} else {");
		$(objEl).find('.mcdNewWindow').html('미사용');
	}
	
	if(mcdObj.mcdAddCert === 'Y'){
		console.log("if(mcdObj.mcdAddCert === 'Y')");
		$(objEl).find('.mcdAddCert').html('사용');
	} else {
		console.log("} else {");
		$(objEl).find('.mcdAddCert').html('미사용');
	}
	
	if(mcdObj.mcdMobile === 'Y'){
		console.log("if(mcdObj.mcdMobile === 'Y')");
		$(objEl).find('.mcdMobile').html('사용');
	} else {
		console.log("} else {");
		$(objEl).find('.mcdMobile').html('미사용');
	}
	
	$(objEl).find('.mcdUrl').html(mcdObj.mcdUrl);
}


/**
 * @param 저장 버튼
 */
function menuSave(eventTagetEl) {
	//var check = confirm("저장하시겠습니까?");
	var check = confirm(LN_CONFIRM_SAVE);
	if(check){
		mask.open();
		var btnType = $(eventTagetEl).attr('data-click-target');
		var div = $($(eventTagetEl).closest('.menu_box')).children('div');
		var mcdCode = $($(eventTagetEl).closest('.menu_edit_box')).find('.mcdCode').val();
		var mcdName = $($(eventTagetEl).closest('.menu_edit_box')).find('.mcdName').val();
		var mcdIcon = $($(eventTagetEl).closest('.menu_edit_box')).find('.mcdIcon').val();
		var check_mcdUse = $($(eventTagetEl).closest('.menu_edit_box')).find('.mcdUse').is(':checked');
		var check_mcdNewWindow = $($(eventTagetEl).closest('.menu_edit_box')).find('.mcdNewWindow').is(':checked');
		var check_mcdAddCert = $($(eventTagetEl).closest('.menu_edit_box')).find('.mcdAddCert').is(':checked');
		var check_mcdMobile = $($(eventTagetEl).closest('.menu_edit_box')).find('.mcdMobile').is(':checked');
		var mcdUri = $($(eventTagetEl).closest('.menu_edit_box')).find('.mcdUrl').val();
		var mcdUse, 
			mcdNewWindow,
			mcdAddCert,
			mcdMobile;
		
		if(!val_chk(mcdName, "명칭")){
			mask.close();
			return false;
		}
		
		if(check_mcdUse){
			mcdUse = 'Y'
		} else {
			mcdUse = 'N'
		}
		
		if(check_mcdNewWindow){
			mcdNewWindow = 'Y'
		} else {
			mcdNewWindow = 'N'
		}
		
		if(check_mcdAddCert){
			mcdAddCert = 'Y'
		} else {
			mcdAddCert = 'N'
		}
		
		if(check_mcdMobile){
			mcdMobile = 'Y'
		} else {
			mcdMobile = 'N'
		}
		
		var mcdObj = new McdObj(mcdCode, mcdUse, mcdUri, mcdName, mcdIcon, mcdNewWindow, mcdAddCert, mcdMobile);
		mcdObj.toString();
		if(btnType === 'update'){
			updateMenu(mcdObj, div);
		} else {
			insertMenu(mcdObj);
		}
		
	}
}

/**
 * @param 취소 버튼
 */
function menuCancel(eventTagetEl) {
	if($(eventTagetEl).attr('data-click-target') === 'add_cancel') {
		$('#new_item').css('display', 'none');
	}else {
		var div = $($($($(eventTagetEl).parent()).parent()).parent()).children('div');
		$(div[0]).css('display', 'none');
		$(div[1]).css('display', 'block');	
	}
}
  


/**
 * [ko] 메뉴 삭제
 * @param obj 삭제버튼
 */
function remove(obj) {
	console.log("remove()");
	var deleteCheck = confirm(LN_CONFIRM_DELETE);
	if(deleteCheck){
		
		var target = $($(obj).closest('li'));
		
		if(target.attr('data-hassub')>0) {
		
			danger(LN_EXIST_SUBMENU);
		
		} else {
		
			var deleteMcdCode = target.attr('id');
			var deleteMcdDepth = target.attr('data-depth');
			$(target.parent()).remove();
			deleteMenu(deleteMcdCode, deleteMcdDepth);
		}
	}
}

/**
 * @param 삭제할 메뉴코드 string
 * @param 삭제할 메뉴의 depth
 */
function deleteMenu(deleteMcdCode, deleteMcdDepth) {
	var stateMsg = '';
	mask.open();
	$.ajax({
		method : "post",
		url : "/ajaxMenu/delete.do",
		data : {
			"mcdCode" : deleteMcdCode,
			"mcdDepth" : deleteMcdDepth,
		},
		success : function(res) {
			var data = JSON.parse(res);
			location.reload();
//				setTimeout(function() {
//					mask.close();
//				}, 500);
		},
		error : function(res) {
			console.log("error")
			console.log(res)
			setTimeout(function() {
				toastMsg(msg)
				mask.close();
			}, 500);
		},
		completed : function(res) {
			setTimeout(function() {
				mask.close();
			}, 500);
			console.log("completed")
			console.log(res)
		}
	});
}


$(function(){
	mask.close();
	var targetEl = "";
	var options = {
		targetEl: targetEl,
		placeholderCss: {'background-color': '#ff8'},
		hintCss: {'background-color':'#bbf'},
		
		//타겟 드래그 시작시
		onDragStart: function(e, el)
		{
			console.log('onDragStart');
		},
		
		/**
         * @param cEl 현재 드래그된(변경된) Element
         */
        onChange: function( cEl )
        {
            console.log( 'onChange' );
            
            var menuMap = new HashMap();
			var listArray = $('#sTree2').sortableListsToArray();
			console.log("listArray:" + listArray[0].id);
			for(var i=0; i<listArray.length; i++){
				menuMap.put(listArray[i].id, listArray[i]);
			}
			var cEl_moved_order = menuMap.get($(cEl).attr('id')).order;
			mask.open();
			updateMoveMenu(cEl, targetEl, cEl_moved_order + 1);
        },

        /**
         * @param cEl 현재 드래그된 Element
         */
        complete: function( cEl )
        {
            console.log( 'complete' );
			
			setTimeout(function() {
				tabResize();
				mask.close();
			}, 500);
        },
        
        /**
         * @param cEl 현재 드래그되는 Element
         * @param hint 삽입되는 곳을 미리 알려주는 요소
         * @param target 삽입되는 Element
         */
		isAllowed: function( cEl, hint, target )
		{
			// Be carefull if you test some ul/ol elements here.
			// Sometimes ul/ols are dynamically generated and so they have not some attributes as natural ul/ols.
			// Be careful also if the hint is not visible. It has only display none so it is at the previouse place where it was before(excluding first moves before showing).
			if( $(cEl).attr('id') === 'new_item'
				|| target.data('depth') === 3
//				||(target.data('depth') === undefined && cEl.data('depth') === 1)
				||(target.data('depth') === 2 && cEl.data('depth') === 2 && cEl.data('hassub') > 0)
				||(target.data('depth') === 2 && cEl.data('depth') === 1 && cEl.data('hassub') > 0)
				||(target.data('depth') === 1 && cEl.data('depth') === 1 && cEl.data('haslastsub') > 0))
			{
				if($(cEl).attr('id') === 'new_item'){
					toastMsg('메뉴 등록을 먼져 해 주세요');
				}
				
				hint.css('background-color', '#ff9999');
				return false;
			}
			else
			{
				//option.onChange(cEl)에서 update 수행을 위해 target을 option.targetEl에 대입 
				targetEl = target;
				
				hint.css('background-color', '#99ff99');
				return true;
			}

		},
		opener: {
            active: false,
            
		},
		ignoreClass: 'clickable'
	};


	$('#sTree2').sortableLists( options );

	$('.descPicture').on( 'click', function(e) { $(this).toggleClass('descPictureClose'); } );

	$('.clickable').on('click', function(e)	{ console.log('Click works fine! IgnoreClass stopped onDragStart event.'); });

	/* Scrolling anchors */
	$('#toPictureAnch').on( 'mousedown', function( e ) { scrollToAnch( 'pictureAnch' ); return false; } );
	$('#toBaseElementAnch').on( 'mousedown', function( e ) { scrollToAnch( 'baseElementAnch' ); return false; } );
	$('#toBaseElementAnch2').on( 'mousedown', function( e ) { scrollToAnch( 'baseElementAnch' ); return false; } );
	$('#toCssPatternAnch').on( 'mousedown', function( e ) { scrollToAnch( 'cssPatternAnch' ); return false; } );

	function scrollToAnch( id )
	{
		console.log(id);
		return true;
		$('html, body').animate({
			scrollTop: '-=-' + $("#" + id).offset().top + 'px'
		}, 750);
		return false;
	}



	$('#addMenu').on('click', function() {
		if(document.getElementById('new_item') === null){
			$('#sTree2').prepend(
					'<li id="new_item" data-depth="1">'
					+ '<div class="menu_edit_box"> '
						+ '<div class="dd-edit-box" style="display: block;">'
						   + '<div style="display: inline-block">'
						     + 'ICON : <input type="text" placeholder="Icon 클래스명" class="clickable mcdIcon"> '
						   + '</div> '
						   + '<div style="display: inline-block">'
						     + '메뉴명 : <input type="text" placeholder="Menu name" class="clickable mcdName"> '
						   + '</div> '  
						   + '<div style="display: inline-block" class="width0p">'
						     + '<input type="hidden" class="clickable mcdCode" value="new_item"/> '
						   + '</div> '
						   + '<div class="menu_right_part">'
							   + '<div style="display: inline-block; visibility:hidden" class="width0p"></div> '
							   + '<div style="display: inline-block" class="mcdUrlDiv">'
							   	 + ' URL : '
							     + '<input type="url" placeholder="Url을 입력해주세요." class="clickable mcdUrl"> '
							   + '</div> '
							   + '<div style="display: inline-block" class="mcdUseDiv">'
							     + ' 새창여부 : '
							     + '<input type="checkbox" name="mcdNewWindow" class="clickable mcdNewWindow"> '
							   + '</div> ' 
							   + '<div style="display: inline-block" class="mcdUseDiv">'
							     + ' 사용여부 : '
							     + '<input type="checkbox" name="use" class="clickable mcdUse" checked> '
							   + '</div> ' 
							   + '<div style="display: inline-block" class="mcdUseDiv">'
							     + ' 추가인증: '
							     + '<input type="checkbox" name="use" class="clickable mcdAddCert"> '
							   + '</div> ' 
							   + '<div style="display: inline-block" class="mcdUseDiv">'
							     + ' 모바일여부: '
							     + '<input type="checkbox" name="use" class="clickable mcdMobile"> '
							   + '</div> '
							   + '<button type="button" class="AXButton Red _saveBtn_ clickable" style="" onclick = "menuSave(this)" data-click-target=""> '
							     + '저장'
							   + '</button> '
							   + '<button type="button" class="AXButton Normal _cancelBtn_ clickable" style="" onclick = "menuCancel(this)" data-click-target="add_cancel"> '
							     + '취소'
							   + '</button>'
						  + '</div>'	   
						+ '</div>'
					+ '</div>'
				  + '</li>'
			);
		} else {
			$('#new_item').css('display', 'block');
		}
		tabResize();
	});
	
	$('._modifyBtn_').on( 'click', function(e){
//		var div = $($($($(e.target).parent()).parent()).parent()).children('div');
		var div = $($(e.target).closest('.menu_box')).children('div');
		$(div[0]).css('display', 'block');
		$(div[1]).css('display', 'none');
	});
	
	$('._saveBtn_').on('click', function(e) {
		menuSave(e.target);	
	});
	
	$('._cancelBtn_').on('click', function(e) {
		menuCancel(e.target);
	});
	
	$('._iconSearchBtn_').on('click', function(e) {
		window.open("http://axicon.axisj.com/","new","width=800,height=500,scrollbars=yes,top=100,left=100");
	});
	
});