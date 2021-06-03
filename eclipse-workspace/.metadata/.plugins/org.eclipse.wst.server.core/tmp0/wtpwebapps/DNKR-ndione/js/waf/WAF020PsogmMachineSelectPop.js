var machineNo = null;
var machineNm = null;
var machineGrid = {
		initView : function() {
			this.target = new ax5.ui.grid();
			this.target.setConfig({
				target: $('#machineGrid'),
			rowSelectorColumnWidth : 25,
			body : {
				align : "left",
				columnHeight : 28,
				onClick : function() {
					machineNo = this.item.mshno;
					machineNm = this.item.mshnm;
					//console.log(this.item.mshno);
					this.self.clearSelect();
					this.self.select(this.dindex);
				},
			},
			page : {
				navigationItemCount : 1,
				height : 30,
				display : false,
				firstIcon : '<i class="fa fa-step-backward" aria-hidden="true"></i>',
				prevIcon : '<i class="fa fa-caret-left" aria-hidden="true"></i>',
				nextIcon : '<i class="fa fa-caret-right" aria-hidden="true"></i>',
				lastIcon : '<i class="fa fa-step-forward" aria-hidden="true"></i>',
				onChange : function() {
					gridView.setData(this.page.selectPage);
				}
			},
			columns : [{
				key : "mshno",
				label : "설비번호",
				//label : labels.relationCode.label,
				width : 180,
				styleClass : function() {
					return "ABC";
				},
				enableFilter : true,
				align : "center",
				editor : {
					type : "",
					disabled : function() {
						// item, value
						return false;
					}
				},
				formatter:function(){							
					return this.value;
				}
			}, {
				key : "mshnm",
				width : 275,
				label : "설비명",
				//label : labels.relationName.label,
				align : "center",
				editor : {
					type : ""
				},
				formatter:function(){							
					return this.value;
				}
			}],
		});
		return this;
	},
	setData : function(list) {
		/* this.target.setData({
            list: list,
            page: {
                currentPage: 0 || 0,
                pageSize: 50,
                totalElements: 500,
                totalPages: 100
            }
        }); */
		return this;
	}
}

/**
 *
 */
function setList() {
	var params = $("#machineSearchForm").serialize();;
	$.ajax({
		type    : "POST",
		//contentType : "application/json",
		url     : "/WAF003PsogmPerSearch/getMachineInfo.do",
		data    : params,
		//dataType : "json",
		success : function (data){
			//console.log(data);
			try{
    			var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				//console.log('aaa');
    				//console.log(parse.machineList);
    				//console.log(parse.machineList.length);
    				//console.log(machineGrid.target);
    				var arrlist = $.map(parse.machineList, function(value, index) {
    					return [value];
    				});
    				//console.log(typeof arrlist);
    				machineGrid.target.setData(arrlist);
    				//console.log("bbbb");
    			}else{
    				toastMsg('조회된 데이터가 없습니다.');
    				machineGrid.setData([]);
    			}
			}catch(e){
				toastMsg(e);
			}
		},
		error   : function(x,e){
			//console.log('error');
			ajaxError(x,e);
		}
	});
    		
}

/**
 * 라인코드셀렉트에 데이터 셋팅
 */
function setData(prtcd) {
	$.ajax({
		type    : "GET",
		//contentType : "application/json",
		url     : "/WAF003PsogmPerSearch/getLineInfo.do",
		data    : {"prtcd" : prtcd},
		//dataType : "json",
		success : function (resData){
			try{
    			var data = JSON.parse(resData);
    			var listStr = "<option value=''></option>";
    			if(data.result === RESULT_Y){
    				//console.log('if');
    				if(data.lineList.length > 0) {
    					data.lineList.forEach(function(item, index) {
    						listStr +='<option value="' + item.lincd + '">' + item.linnm + '</option>';
    					});
    					$('select#lincd').html(listStr);
    				}
    				
    			}else{
    				toastMsg('조회된 데이터가 없습니다.');
    				$('select#lincd').html(listStr);
    			}
			}catch(e){
				//console.log(e);
			}
		},
		error   : function(x,e){
			ajaxError(x,e);
		}
	});
}

$(document.body).ready(function() {
	machineGrid.initView().setData([]);
	$('#prtcd').change(function() {
		//console.log(this.value);
		setData(this.value);
	});
	
	$('#lincd').change(function() {
		setList();
	});
	
	$('._applyBtn_').on( 'click', function(e){
		if(machineNo === null){
			toastMsg("설비를 선택해 주세요")
			return false;
		} 
		var params = {
				mshno: machineNo,
				mshnm: machineNm,
		};
		window.opener.getReturnValue("jisno", JSON.stringify(params));
		window.close();
	});
});