/**
 * ax5 UI 프레임워크의 Grid에 입력을 위한 row를 추가하기 이한 추가 기능
 * 생성 var mainCodeGridInputHandler = new GridInput(cmcGrid); //cmcGrid 는 ax5 grid 객체다
 * 
 */
function GridInput(gridObj,opt){
	this.options = {
		suffix:"",
		prefix:"",
		textInput:{}
	};
	$.extend(this.options,opt);//옵션 값에 변경이 있는 경우 변경된 값으로 업데이트	
	this.gridObject = gridObj;//그리드 객체를 내부변수에 저장
	
}

GridInput.prototype = {
	init:function(){//초기화 작업
		
	},
	addInput:function(){//입력을 위한 row 추가
		
		var items = this.getListItem();	
		if(!(items[0]) || !(items[0].rowType)){
			this.options.orgItems = $.extend([],items);
			var data = this.makeInputRow();
			items.unshift(data);
			this.reload(items);		
		}			
	},
	reload:function(items){//그리드 아이템 데이터를 이용해 그리드를 갱신한다.
		this.gridObject.target.setData({
			list : items,
			page : {
				currentPage : 0,
				pageSize : 50,
				totalElements : 500,
				totalPages : 100
			}
		});
		//기존 그리드의 onkeyup 이벤트를 차단
		$('._insertForm_').parent().on("keyup",function(e){
			return false;
		});
		//셀의 패딩을 설정
		$('._insertForm_').parent().css('padding',0);
		
	},
	clearInput:function(){//입력을 위해 추가된 row를 삭제한다.
		//this.saveData(function(data){
			//console.log(data);
		//});
		this.reload(this.options.orgItems);
	},
	saveData:function(callback){
		var data = this.getInputData();
		var state = false;
		if(data!==false){
			if(typeof callback == "function"){
				callback(data);
			}
			state = true;
		}
		return state;
	},
	getInputData:function(){//입력된 값을 json으로 반환
		var dataJson = false;
		if(this.gridObject.target.list.length > 0){
			var inputRow = this.gridObject.target.list[0];
			
			if(inputRow.rowType){
				dataJson = {};
				var preFidx = this.options.prefix;
				var sufFidx = this.options.suffix;
				
				for(var keyName in this.options.rtnJson){
					var name = preFidx+keyName+sufFidx
					if(document.getElementsByName(name)[0]){				
						dataJson[keyName] = document.getElementsByName(name)[0].value;
					}else{
						dataJson[keyName] = inputRow[keyName];
					}
				}
			}
		}
		//console.log(dataJson);
		return dataJson;
		
	},
	clearInputData:function(){//입력폼에 입력된 값을 초기화 한다.
		var preFidx = this.options.prefix;
		var sufFidx = this.options.suffix;		
		for(var keyName in this.options.rtnJson){
			var name = preFidx+keyName+sufFidx
			if(document.getElementsByName(name)[0]){	
				document.getElementsByName(name)[0].value = "";				
			}
		}
	},
	getListItem:function(){//그리드의 아이템 데이터를 반환 한다.
		return this.gridObject.target.list;
	},
	getColumns:function(){//그리드의 컬럼 정보를 반환한다.
		return this.gridObject.target.config.columns;
	},
	makeInputRow:function(){//입력폼을 생성해서 반환한다.
		var columnInfo = this.getColumns();
		var basicJson = {rowType:"insert"};
		var preFidx = this.options.prefix;
		var sufFidx = this.options.suffix;
		this.options.rtnJson = {};
		//-------------------------------------------------------------------//
		for(var i=0;i<columnInfo.length;i++){
			var keyName = columnInfo[i].key;
			if(columnInfo[i].editor.type==="text"){
				this.options.textInput[keyName] = "<input type='text' value='' class='_insertForm_' name='"+preFidx+keyName+sufFidx+"'>";
			}
			basicJson[keyName] = "";
			this.options.rtnJson[keyName] = "";
		}
		//console.log(basicJson);
		return basicJson;
	},
	getTextInput:function(obj){//각 셀에 들어갈 입력폼을 반환한다. (그리드 formatter에서 사용)
		var rtnStr = obj.value;
		if(obj.item.rowType==="insert"){
			rtnStr = this.options.textInput[obj.key];
		}
		return rtnStr;
	}
}

/**
 * 등록버튼을 누르면 등록버튼이 사라지고 저장버튼과 닫기버튼이 나타남
 * @param addBtnEl 등록버튼
 */
function saveBtnUiSet (addBtnEl) {
	var parentDiv = $(addBtnEl).parent('div');
	parentDiv.addClass("displayNone");
	parentDiv.removeClass("inlineBlock");
	parentDiv.next().addClass("inlineBlock");
	parentDiv.next().removeClass("displayNone");
}

/**
 * 닫기버튼을 누르면 등록버튼이 사라지고 저장버튼과 닫기버튼이 나타남
 * @param closeBtnEl 닫기버튼
 */
function addBtnUiSet (closeBtnEl) {
	var parentDiv = $(closeBtnEl).parent('div');
	parentDiv.addClass("displayNone");
	parentDiv.removeClass("inlineBlock");
	parentDiv.prev().addClass("inlineBlock");
	parentDiv.prev().removeClass("displayNone");
}

/**
 * [ko]그리드 버튼 초기화
 */
function gridBtnInit() {
	//console.log("gridBtnInit");
	/*var arrAddBtn = $('._addBtn_');*/
	var arrSaveBtn = $('._saveBtn_');
	for(var i=0; i<arrSaveBtn.length; i++){
		//console.log("i:" + i);
		addBtnUiSet(arrSaveBtn[i]);
		/*$(arrAddBtn[i]).css("display", "inline-block");
		$(arrSaveBtn[i]).css("display", "none");*/
	}
}

