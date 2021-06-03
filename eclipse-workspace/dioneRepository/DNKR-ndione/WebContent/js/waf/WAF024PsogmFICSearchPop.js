var code = null;
var name1 = null;
var name2 = null;
var url = "";

var searchGrid = {
		initView : function() {
			this.target = new ax5.ui.grid();
			this.target.setConfig({
				target: $('#searchGrid'),
			rowSelectorColumnWidth : 25,
			body : {
				align : "left",
				columnHeight : 28,
				onClick : function() {
					code = this.item.code;
					name1 = this.item.name1;
					name2 = this.item.name2;
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
				key : "code",
				label : "CODE",
				//label : labels.relationCode.label,
				width : 100,
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
				key : "name1",
				width : 200,
				label : "NAME1",
				//label : labels.relationName.label,
				align : "center",
				editor : {
					type : ""
				},
				formatter:function(){							
					return this.value;
				}
			}, {
				key : "name2",
				width : 200,
				label : "NAME2",
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
 * 그리드에 데이터 바인드
 */
function setList(type) {
	var params = $("#searchForm").serialize();
	if (type === "prtno" || type === "prtno2") {
		url = "/WAF001PsogmSearch/getPartList.do";
	} else if (type === "vndnr" || type === "vndnr2") {
		url = "/WAF001PsogmSearch/getVndnrList.do";
	} else if (type === "maker") {
		url = "/WAF001PsogmSearch/getMakerList.do";
	} else if (type === "emp") {
		url = "/ajaxEmp/getDb2empList.do";
	} 
	//console.log(url);
	$.ajax({
		type    : "POST",
		//contentType : "application/json",
		url     : url,
		data    : params,
		//dataType : "json",
		success : function (data){
			console.log(data);
			try{
    			var parse = JSON.parse(data);
    			if(parse.result === RESULT_Y){
    				searchGrid.target.setData(parse.list);
    			}else{
    				toastMsg('조회된 데이터가 없습니다.');
    				searchGrid.target.setData([]);
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



$(document.body).ready(function() {
	var type = $('#type').val();
	searchGrid.initView().setData([]);
	setList(type);
	
	$('.searchBtn').on('click', function() {
		setList(type);
	});
	
	$('._applyBtn_').on( 'click', function(e){
		if(code === null){
			toastMsg("설비를 선택해 주세요")
			return false;
		} 
		var params = {
				code: code,
				name1: name1,
				name2: name2,
		};
		
		if(type !== "prtno2") {
			window.opener.getReturnValue(type, JSON.stringify(params));
		} else {
			window.opener.getReturnValue("prtno2", JSON.stringify(params));
		}
		window.close();
	});
});