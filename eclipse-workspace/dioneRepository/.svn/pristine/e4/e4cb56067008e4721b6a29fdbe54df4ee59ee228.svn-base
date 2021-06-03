

var TGRD_ARR_OBJ_GRID        = array();
var TGRD_ARR_OBJ_COMPONENT   = array();
var TGRD_ARR_STR_FILTER_COND = array();
var TGRD_ARR_NUM_TREECELL    = array();
var TGRD_ARR_STR_TEXTCOL     = array();
var TGRD_ARR_STR_LEVELNOCOL  = array();
var TGRD_ARR_STR_ITEMLEVEL   = array();
var TGRD_STR_EXPCOL          = "__EXP";
var TGRD_STR_IDCOL           = "__INID";
var TGRD_STR_PARENTIDCOL     = "__INPARENTID";
var TGRD_ARR_BOL_TRANS       = array();
var TGRD_ARR_BOL_EXPAND      = array();
var TGRD_ARR_STR_MASK        = array();

var TGRD_ARR_STR_GRID_CELL_EXPR = array();

var TGRD_ARR_GRID_ON_CELL_CLICK = array();
var TGRD_ARR_GRID_ON_H_SCROLL   = array();
var TGRD_ARR_GRID_ON_V_SCROLL   = array();

var TGRD_ARR_DATASET_ON_LOAD_COMPLETED  = array();
var TGRD_ARR_DATASET_ON_COLUMN_CHANGED  = array();
var TGRD_ARR_DATASET_ON_ROW_INSERTED    = array();
var TGRD_ARR_DATASET_ON_ROW_DELETING    = array();
var TGRD_ARR_DATASET_ON_ROW_DELETED     = array();
var TGRD_ARR_DATASET_ON_ROW_POS_CHANGED = array();







/////////////////////////////////////////////////////////////////////////////////////
// ##### Public Function
/////////////////////////////////////////////////////////////////////////////////////


function tgrd_fn_GetParentRowNF(obj,nRow)
{
	var objDataset = eval(obj.BindDataset);
	var nFindRow = tgrd_fn_GetParentRow(obj,nRow);
	if(nFindRow < 0) return nFindRow;
	nFindRow = objDataset.GetRowIndexNF(nFindRow);

	return nFindRow;
}

function tgrd_fn_GetParentRow(obj,nRow)
{
	var objDataset = eval(obj.BindDataset);

	if(nRow == null || nRow < 0) nRow = objDataset.row;

	var strParentID = objDataset.GetColumn(nRow,TGRD_STR_PARENTIDCOL);

	return objDataset.FindRow(TGRD_STR_IDCOL,strParentID);
}


function tgrd_fn_GetChildRowNF(obj,nRow)
{
	var objDataset = eval(obj.BindDataset);
	var nFindRow = tgrd_fn_GetChildRow(obj,nRow);
	if(nFindRow < 0) return nFindRow;
	nFindRow = objDataset.GetRowIndexNF(nFindRow);

	return nFindRow;
}

function tgrd_fn_GetChildRow(obj,nRow)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);
	var objDataset = eval(obj.BindDataset);

	if(nRow == null || nRow < 0) nRow = objDataset.row;

	var strLevelNo   = objDataset.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]);
	var strCurrentID = objDataset.GetColumn(nRow,TGRD_STR_IDCOL);

	var nRtnRow = -1;

	// trace(objDataset.GetColumn(nRow+1,TGRD_ARR_STR_LEVELNOCOL[nIndex])+" > "+strLevelNo);
	// Child 가 펼쳐져 있을 경우 자기 보다 아래 로우의 Level이 크기때문에 자기row + 1을 한다.
	if(objDataset.GetColumn(nRow+1,TGRD_ARR_STR_LEVELNOCOL[nIndex]) > strLevelNo) {
		nRtnRow = nRow+1;
	} else {
		// trace(objDataset.GetColumn(objDataset.GetRowIndexNF(nRow)+1,TGRD_STR_PARENTIDCOL)+" == "+strCurrentID);
		// Child 가 닫혀있을 때는 자기의 절대row+1한 row로 GetColumnNF()를 하여 parentid와 자기의 id를 비교하여
		// 같을 경우(Child가 있을 경우) 자기row + 1을 한다.
		// 만약 이 조건에 맞지 않다면 Child가 없는 것이므로 디폴트값 -1을 리턴한다.
		if(objDataset.GetColumnNF(objDataset.GetRowIndexNF(nRow)+1,TGRD_STR_PARENTIDCOL) == strCurrentID ) {
			nRtnRow = nRow+1;
		}
	}

	return nRtnRow;
}


function tgrd_fn_GetSiblingRowNF(obj,nRow,nOffset)
{
	var objDataset = eval(obj.BindDataset);
	var nFindRow = tgrd_fn_GetSiblingRow(obj,nRow,nOffset);
	if(nFindRow < 0) return nFindRow;
	nFindRow = objDataset.GetRowIndexNF(nFindRow);

	return nFindRow;
}

function tgrd_fn_GetSiblingRow(obj,nRow,nOffset)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);
	var objDataset = eval(obj.BindDataset);

	if(nRow == null || nRow < 0) nRow = objDataset.row;

	var strLevelNo  = objDataset.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]);
	var strParentID = objDataset.GetColumn(nRow,TGRD_STR_PARENTIDCOL);

	var nRtnRow = -1;

	if(nOffset == -1) {
	
		for(var i = nRow-1; i >= 0; i--) {
			if(	objDataset.GetColumn(i,TGRD_ARR_STR_LEVELNOCOL[nIndex]) == strLevelNo &&
				(	objDataset.GetColumn(i,TGRD_STR_PARENTIDCOL) == strParentID ||
					length(objDataset.GetColumn(i,TGRD_STR_PARENTIDCOL)) == 0 && length(strParentID) == 0) ) {
				nRtnRow = i;
				i = 0;
			}
		}

	} else {

		for(var i = nRow+1; i < objDataset.GetRowCount(); i++) {
			if(	objDataset.GetColumn(i,TGRD_ARR_STR_LEVELNOCOL[nIndex]) == strLevelNo &&
				(	objDataset.GetColumn(i,TGRD_STR_PARENTIDCOL) == strParentID ||
					length(objDataset.GetColumn(i,TGRD_STR_PARENTIDCOL)) == 0 && length(strParentID) == 0) ) {
				nRtnRow = i;
				i = objDataset.GetRowCount();
			}
		}
	}

	return nRtnRow;
}


function tgrd_fn_GetLevelIndex(obj,nRow,nOffset)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);
	var objDataset = eval(obj.BindDataset);

	if(nRow == null || nRow < 0) nRow = objDataset.row;

	var strLevelNo  = objDataset.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]);
	var strParentID = objDataset.GetColumn(nRow,TGRD_STR_PARENTIDCOL);

	var nRtnRow = nRow;

	if(nOffset == -1) {
	
		for(var i = nRow-1; i >= 0; i--) {
			if(	objDataset.GetColumn(i,TGRD_STR_PARENTIDCOL) == strParentID ||
				(length(objDataset.GetColumn(i,TGRD_STR_PARENTIDCOL)) == 0 && length(strParentID) == 0) ) {
				nRtnRow = i;
			} else if(toNumber(objDataset.GetColumn(i,TGRD_ARR_STR_LEVELNOCOL[nIndex])) < toNumber(strLevelNo)) {
				i = 0;
			}
		}

	} else {

		for(var i = nRow+1; i < objDataset.GetRowCount(); i++) {
			if(	objDataset.GetColumn(i,TGRD_STR_PARENTIDCOL) == strParentID ||
				(length(objDataset.GetColumn(i,TGRD_STR_PARENTIDCOL)) == 0 && length(strParentID) == 0) ) {
				nRtnRow = i;
			} else if(toNumber(objDataset.GetColumn(i,TGRD_ARR_STR_LEVELNOCOL[nIndex])) < toNumber(strLevelNo)) {
				i = objDataset.GetRowCount();
			}
		}
	}

	return nRtnRow;
}


function tgrd_fn_InsertSiblingRow(obj,nRow)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);
	var objDataset = eval(obj.BindDataset);

	var strLevelNo     = objDataset.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]);
	var nParentRow     = tgrd_fn_GetParentRow(obj,nRow);
	var nParentLevel   = objDataset.GetColumn(nParentRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]);
	var nNextParentRow = tgrd_fn_GetSiblingRow(obj,nParentRow);

	if(nParentRow < 0) {
		nNextParentRow = -1;
	} else if(nNextParentRow < 0) {
		for(var i = nRow; i < objDataset.GetRowCount(); i++) {
			if(toNumber(objDataset.GetColumn(i,TGRD_ARR_STR_LEVELNOCOL[nIndex])) < toNumber(strLevelNo)) {
				nNextParentRow = i;
				i = objDataset.GetRowCount();
			}
		}
	}

	var nNewRow = objDataset.InsertRow(nNextParentRow);
	objDataset.SetColumn(nNewRow,TGRD_ARR_STR_LEVELNOCOL[nIndex],strLevelNo);

	return nNewRow;
}


function tgrd_fn_InsertChildRow(obj,nRow)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);
	var objDataset = eval(obj.BindDataset);

	if(tgrd_fn_IsExpanded(obj,nRow) == "+") {
		tgrd_fn_ExpandItem(obj,nRow);
	}

	var strLevelNo = objDataset.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]);
	var nNewRow    = objDataset.InsertRow(nRow+1);
	objDataset.SetColumn(nNewRow,TGRD_ARR_STR_LEVELNOCOL[nIndex],(toNumber(strLevelNo)+1));

	return nNewRow;
}


function tgrd_fn_SetTreeGrid(obj,nTreeCell,strTextCol,strLevelNOCol,bTrans,bExpand,strItemLevel)
{
	obj.Font = "굴림체,9";

	// obj.Redraw = false;
	var nIndex = length(TGRD_ARR_OBJ_GRID);
	obj.UserData = nIndex;

	TGRD_ARR_OBJ_GRID[nIndex]        = obj;
	TGRD_ARR_NUM_TREECELL[nIndex]    = nTreeCell;
	TGRD_ARR_STR_TEXTCOL[nIndex]     = strTextCol;
	TGRD_ARR_STR_LEVELNOCOL[nIndex]  = strLevelNOCol;
	TGRD_ARR_STR_ITEMLEVEL[nIndex]   = toString(strItemLevel);
	TGRD_ARR_BOL_TRANS[nIndex]       = bTrans;
	TGRD_ARR_BOL_EXPAND[nIndex]      = bExpand;
	TGRD_ARR_STR_MASK[nIndex]        = obj.GetCellProp("body",TGRD_ARR_NUM_TREECELL[nIndex],"mask");

	var objDataset = eval(obj.BindDataset);

	// Grid Event Change
	TGRD_ARR_GRID_ON_CELL_CLICK[nIndex] = obj.OnCellClick;
	TGRD_ARR_GRID_ON_H_SCROLL[nIndex]   = obj.OnHScroll;
	TGRD_ARR_GRID_ON_V_SCROLL[nIndex]   = obj.OnVScroll;
	obj.OnCellClick = "tgrd_fn_TreeGrid_Event_OnCellClick";
	obj.OnHScroll   = "tgrd_fn_TreeGrid_Event_OnHScroll";
	obj.OnVScroll   = "tgrd_fn_TreeGrid_Event_OnVScroll";

	// Dataset Event Change
	TGRD_ARR_DATASET_ON_LOAD_COMPLETED[nIndex]  = objDataset.OnLoadCompleted;
	TGRD_ARR_DATASET_ON_COLUMN_CHANGED[nIndex]  = objDataset.OnColumnChanged;
	TGRD_ARR_DATASET_ON_ROW_INSERTED[nIndex]    = objDataset.OnRowInserted;
	TGRD_ARR_DATASET_ON_ROW_DELETING[nIndex]    = objDataset.OnRowDeleting;
	TGRD_ARR_DATASET_ON_ROW_DELETED[nIndex]     = objDataset.OnRowDeleted;
	TGRD_ARR_DATASET_ON_ROW_POS_CHANGED[nIndex] = objDataset.OnRowPosChanged;

	objDataset.OnLoadCompleted = "tgrd_fn_Dataset_Event_OnLoadCompleted";
	objDataset.OnColumnChanged = "tgrd_fn_Dataset_Event_OnColumnChanged";
	objDataset.OnRowInserted   = "tgrd_fn_Dataset_Event_OnRowInserted";
	objDataset.OnRowDeleting   = "tgrd_fn_Dataset_Event_OnRowDeleting";
	objDataset.OnRowDeleted    = "tgrd_fn_Dataset_Event_OnRowDeleted";
	objDataset.OnRowPosChanged = "tgrd_fn_Dataset_Event_OnRowPosChanged";

	obj.FixedColSizing = true;
	for(var i = 0; i <= TGRD_ARR_NUM_TREECELL[nIndex]; i++) {
		obj.SetColProp(i,"fix","true");
	}
	obj.SetCellProp("body",TGRD_ARR_NUM_TREECELL[nIndex],"bkimagealign","left");

	// 트리 형태로 보여지는 셀의 에디트 형태를 가공한다.
	tgrd_fn_SetEditable(obj,nTreeCell);
}


function tgrd_fn_IsExpanded(obj,nRow)
{
	var objDataset = eval(obj.BindDataset);
	return objDataset.GetColumn(nRow,TGRD_STR_EXPCOL);
}


function tgrd_fn_Expand(obj,bExpand)
{
	tgrd_fn_SetTreeExpand(eval(obj.BindDataset),bExpand);
}


function tgrd_fn_ExpandItem(obj,nRow,bExpand)
{
	var strEXP = decode(bExpand,true,'+',false,'-','');

	if(bExpand == null) {
		strEXP = tgrd_fn_IsExpanded(obj,nRow);
	}

	if(strEXP != tgrd_fn_IsExpanded(obj,nRow)) return;

	if(length(nRow) < 0 || length(strEXP) <= 0) return;

	var nIndex = tgrd_fn_GetArrayIndex(obj);
	var objDataset = eval(obj.BindDataset);

	// Child를 조회해서 구하는 경우
	if(TGRD_ARR_BOL_TRANS[nIndex]) {

		// Item Level을 직접 사용한 경우와 ColumnID로 사용했을때를 구분한다.
		var varItemLevel = TGRD_ARR_STR_ITEMLEVEL[nIndex];
		if(isdigit(varItemLevel) == false) varItemLevel = objDataset.GetColumn(nRow,varItemLevel);

		// 현재 Level과 Item으로 표현되는 Level보다 작을 경우(폴더) 일때만 조회함수를 호출한다.
		if(objDataset.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]) < toNumber(varItemLevel)) {

			// 만약 이미 Child가 조회되었있을 경우 다시 조회하지 않고 Child를 펼친다.
			if(tgrd_fn_GetChildRow(obj,nRow) < 0) {
				var objInsertDS = fn_GetLowerData(objDataset.GetColumn(nRow,TGRD_ARR_STR_TEXTCOL[nIndex]),nRow);
				tgrd_fn_SetTreeExpandItemTrans(obj,nRow,objInsertDS);
			} else {
				tgrd_fn_SetTreeExpandItem(obj,nRow,strEXP);
			}
		}
	} else {
		tgrd_fn_SetTreeExpandItem(obj,nRow,strEXP);
	}
}





/////////////////////////////////////////////////////////////////////////////////////
// ##### Private Function
/////////////////////////////////////////////////////////////////////////////////////

function tgrd_fn_ArrangeCondition(strCond)
{
	for(; indexOf(strCond,"||||") > -1;) {
		strCond = replace(strCond,"||||","||");
	}

	for(; indexOf(strCond,"&&&&") > -1;) {
		strCond = replace(strCond,"&&&&","&&");
	}

	return strCond;
}


function tgrd_fn_IsExistColumn(dsObj, strColID)
{
	var isExist = false;
	for(var nCol = 0; nCol < dsObj.GetColCount(); nCol++) {
		if(toUpper(dsObj.GetColID(nCol)) == toUpper(strColID)) {
			isExist = true;
			nCol = dsObj.GetColCount();
		}
	}

	return isExist;
}


function tgrd_fn_GetArrayIndex(obj)
{
	var nRtnIdx = -1;

	if(toLower(obj.GetType()) == "grid") {
		for(var i = 0; i < length(TGRD_ARR_OBJ_GRID); i++) {
			if(obj.id == TGRD_ARR_OBJ_GRID[i].id) {
				nRtnIdx = i;
				i = length(TGRD_ARR_OBJ_GRID);
			}
		}
	} else if(toLower(obj.GetType()) == "dataset") {
		for(var i = 0; i < length(TGRD_ARR_OBJ_GRID); i++) {
			if(obj.id == TGRD_ARR_OBJ_GRID[i].BindDataset) {
				nRtnIdx = i;
				i = length(TGRD_ARR_OBJ_GRID);
			}
		}
	}

	return nRtnIdx;
}


function tgrd_fn_SetTreeText(obj)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	var objDataset = eval(obj.BindDataset);

	var nMaxDep = toNumber(objDataset.MaxNF(TGRD_ARR_STR_LEVELNOCOL[nIndex]));
	if(indexOf(obj.GetCellProp("body",TGRD_ARR_NUM_TREECELL[nIndex],"expr"),","+nMaxDep+",") < 0) {

		var strExpr = "decode("+TGRD_ARR_STR_LEVELNOCOL[nIndex];
		for(var i = 1; i <= (nMaxDep+1); i++) {

			var strSpace = "      ";
			for(var j = 1; j < i; j++) {
				strSpace += "   ";
			}
			strExpr += ","+i+",'"+strSpace+"'";
		}

		// Mask 처리가 필요한 경우
		var strMask = TGRD_ARR_STR_MASK[nIndex];
		if(length(strMask) > 0) {
			obj.SetCellProp("body",TGRD_ARR_NUM_TREECELL[nIndex],"expr",strExpr+",'')+toString("+TGRD_ARR_STR_TEXTCOL[nIndex]+",'"+strMask+"')");
			obj.SetCellProp("body",TGRD_ARR_NUM_TREECELL[nIndex],"mask","");
		} else {
			obj.SetCellProp("body",TGRD_ARR_NUM_TREECELL[nIndex],"expr",strExpr+",'')+"+TGRD_ARR_STR_TEXTCOL[nIndex]);
		}

		// var bkimageid = "expr:iif("+TGRD_ARR_STR_LEVELNOCOL[nIndex]+" > 0,'tree_'+"+TGRD_ARR_STR_LEVELNOCOL[nIndex]+"+iif(rowpos==row,'s','')+'_'+decode("+TGRD_STR_EXPCOL+",'+','close','-','open','item'),'')";
		var bkimageid = "";
		// Item을 표현할 Level을 사용했을 때와 사용하지 않고 default로 사용했을 때를 구분한다.
		if(length(TGRD_ARR_STR_ITEMLEVEL[nIndex]) > 0) {
			bkimageid = "expr:iif("+TGRD_ARR_STR_LEVELNOCOL[nIndex]+" > 0,'tree_'+"+TGRD_ARR_STR_LEVELNOCOL[nIndex]+"+'_'+decode("+TGRD_STR_EXPCOL+",'+','close','-','open',iif("+TGRD_ARR_STR_ITEMLEVEL[nIndex]+">"+TGRD_ARR_STR_LEVELNOCOL[nIndex]+",'close','item')),'')";
		} else {
			bkimageid = "expr:iif("+TGRD_ARR_STR_LEVELNOCOL[nIndex]+" > 0,'tree_'+"+TGRD_ARR_STR_LEVELNOCOL[nIndex]+"+'_'+decode("+TGRD_STR_EXPCOL+",'+','close','-','open','item'),'')";
		}
		// trace(bkimageid);
		obj.SetCellProp("body",TGRD_ARR_NUM_TREECELL[nIndex],"bkimageid",bkimageid);
	}
}


function tgrd_fn_SetTreeExpand(obj,bExpand)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	obj.fireevent = false;
	obj.SetUpdate(false);

	obj.UnFilter();
	TGRD_ARR_STR_FILTER_COND[nIndex] = "";

	// 함수 내부에서 사용하는 EXP를 세팅하기 위해 __EXP 컬럼을 생성한다.
	if(tgrd_fn_IsExistColumn(obj,TGRD_STR_EXPCOL) == false) {
		obj.AddColumn(TGRD_STR_EXPCOL,"String");
	}

	// 함수 내부에서 사용하는 ID를 세팅하기 위해 ID 컬럼을 생성한다.
	if(tgrd_fn_IsExistColumn(obj,TGRD_STR_IDCOL) == false) {
		obj.AddColumn(TGRD_STR_IDCOL,"String");
	}

	// 함수 내부에서 사용하는 Parent ID를 세팅하기 위해 Parent ID 컬럼을 생성한다.
	if(tgrd_fn_IsExistColumn(obj,TGRD_STR_PARENTIDCOL) == false) {
		obj.AddColumn(TGRD_STR_PARENTIDCOL,"String");
	}

	var strFilterCond = "";
	var strSpace = "";
	var strNewID;
	var nLevelID;
	var nPrevLevelID;
	var strFolderState = iif(bExpand,"-","+");

	// 0번째 row의 새로운(내부에서 사용하는) ID를 생성한다.
	strNewID = "IN_0_1";
	obj.SetColumn(0,TGRD_STR_IDCOL,strNewID);

	strFilterCond = "||"+TGRD_STR_PARENTIDCOL+"=='"+strNewID+"'";

	// ID 및 parent ID를 세팅한다.
	for(var i = 1; i < obj.GetRowCount(); i++) {

		nLevelID = toNumber(obj.GetColumn(i,TGRD_ARR_STR_LEVELNOCOL[nIndex]));
		nPrevLevelID = toNumber(obj.GetColumn((i-1),TGRD_ARR_STR_LEVELNOCOL[nIndex]));

		// 새로운(내부에서 사용하는) 자신의 ID를 생성한다.
		strNewID = "IN_"+i+"_"+nLevelID;
		obj.SetColumn(i,TGRD_STR_IDCOL,strNewID);

		// 하위 레벨을 가지고 있는 것이 있을때 '+' 값을 세팅한다.
		// 자신의 레벨보다 이전 레벨이 작을때 이전레벨의 TGRD_STR_EXPCOL 에 폴더상태('+'or '-') 를 세팅한다.
		if(nPrevLevelID < nLevelID) {
			obj.SetColumn((i-1),TGRD_STR_EXPCOL,strFolderState);
		}

		// 이전 레벨이 자기보다 작을때
		// 이전 레벨의 ID를 자신의 parent ID에 세팅한다.
		if(nPrevLevelID < nLevelID) {
			obj.SetColumn(i,TGRD_STR_PARENTIDCOL,obj.GetColumn((i-1),TGRD_STR_IDCOL));

		// 이전 레벨이 자기랑 같을때
		// 이전 레벨의 parent ID를 자신의 parent ID에 세팅한다.
		} else if(nPrevLevelID == nLevelID) {
			obj.SetColumn(i,TGRD_STR_PARENTIDCOL,obj.GetColumn((i-1),TGRD_STR_PARENTIDCOL));

		// 이전 레벨이 자기보다 클때
		// 위로 찾아가면서 자기랑 같은 레벨이 나올때까지 찾는다.
		} else if(nPrevLevelID > nLevelID) {
			for(var j = (i-2); j >= 0; j--) {
				nPrevLevelID = toNumber(obj.GetColumn(j,TGRD_ARR_STR_LEVELNOCOL[nIndex]));
				// 자기랑 같은 레벨을 찾으면 찾은 레벨의 parent ID를 자신의 parent ID에 세팅한다.
				if(nPrevLevelID == nLevelID) {
					obj.SetColumn(i,TGRD_STR_PARENTIDCOL,obj.GetColumn(j,TGRD_STR_PARENTIDCOL));
					j = 0;
				}
			}
		}

		strFilterCond += "||"+TGRD_STR_PARENTIDCOL+"=='"+strNewID+"'";
	}

	tgrd_fn_SetTreeText(TGRD_ARR_OBJ_GRID[nIndex]);

	if(bExpand) {
		TGRD_ARR_STR_FILTER_COND[nIndex] = TGRD_ARR_STR_LEVELNOCOL[nIndex]+"=='1'"+strFilterCond;
	} else {
		TGRD_ARR_STR_FILTER_COND[nIndex] = TGRD_ARR_STR_LEVELNOCOL[nIndex]+"=='1'";
	}

	obj.Filter(TGRD_ARR_STR_FILTER_COND[nIndex]);

	obj.SetUpdate(true);
	obj.fireevent = true;
}


function tgrd_fn_SetTreeExpandItemTrans(obj,nRow,objInsertDS)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	var objDataset = eval(obj.BindDataset);

	objDataset.fireevent = false;
	objDataset.SetUpdate(false);


	if(length(objDataset.GetColumn(nRow,TGRD_STR_EXPCOL)) == 0) {

		if(objInsertDS.GetRowCount() > 0) {

			objDataset.SetColumn(nRow,TGRD_STR_EXPCOL,"+");
			var strNewID;
			var strParentID = objDataset.GetColumn(nRow,TGRD_STR_IDCOL);
			var nInsertRow  = nRow;
			for(var nDataRow = 0; nDataRow < objInsertDS.GetRowCount(); nDataRow++) {

				nInsertRow = objDataset.InsertRow(nInsertRow+1);
				objDataset.CopyRow(nInsertRow,objInsertDS,nDataRow);

				// 추가한 row의 ID를 세팅한다.
				strNewID = strParentID+"_"+nDataRow;
				objDataset.SetColumn(nInsertRow,TGRD_STR_IDCOL,strNewID);

				// 클릭한 row의 ID를 Parent ID에 세팅한다.
				objDataset.SetColumn(nInsertRow,TGRD_STR_PARENTIDCOL,strParentID);
			}
		}
	}

	objDataset.SetUpdate(true);
	objDataset.fireevent = true;

	tgrd_fn_SetTreeExpandItem(obj,nRow);
}


function tgrd_fn_SetTreeExpandItem(obj,nRow,strEXP)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	var objDataset = eval(obj.BindDataset);

	objDataset.fireevent = false;
	objDataset.SetUpdate(false);

	tgrd_fn_SetTreeText(obj);


	var strParentID  = trim(objDataset.GetColumn(nRow,TGRD_STR_PARENTIDCOL));
	var strCurrentID = trim(objDataset.GetColumn(nRow,TGRD_STR_IDCOL));
	var nLevelNO     = toNumber(objDataset.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]));
	var strSubParentID = "";

	// EXP상태('+','-')를 임의로 조작하고 싶을때
	if(length(strEXP) > 0) {
		objDataset.SetColumn(nRow,TGRD_STR_EXPCOL,strEXP);
	}

	// 펼쳐진 상태이면, 하위까지 접는다.
	if(objDataset.GetColumn(nRow,TGRD_STR_EXPCOL) == "-") {

		objDataset.SetColumn(nRow,TGRD_STR_EXPCOL,"+");

		var strFilter = "||"+TGRD_STR_PARENTIDCOL+"=='"+strCurrentID+"'";
		TGRD_ARR_STR_FILTER_COND[nIndex] = replace(TGRD_ARR_STR_FILTER_COND[nIndex],strFilter,"");

		var strSubParentID = "";
		for(var nFindRow = objDataset.FindRow(TGRD_STR_PARENTIDCOL,strCurrentID)
			; nFindRow > -1
			&& nFindRow < objDataset.GetRowCount()
			&& trim(strParentID) != trim(objDataset.GetColumn(nFindRow,TGRD_STR_PARENTIDCOL))
			&& nLevelNO <= toNumber(objDataset.GetColumn(nFindRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]))
			; nFindRow++) {

			strSubParentID = trim(objDataset.GetColumn(nFindRow,TGRD_STR_IDCOL));

			strFilter = "||"+TGRD_STR_PARENTIDCOL+"=='"+strSubParentID+"'";
			TGRD_ARR_STR_FILTER_COND[nIndex] = replace(TGRD_ARR_STR_FILTER_COND[nIndex],strFilter,"");
		}

		TGRD_ARR_STR_FILTER_COND[nIndex] = tgrd_fn_ArrangeCondition(TGRD_ARR_STR_FILTER_COND[nIndex]);

	// 접힌 상태라면, 하위까지 이전상태 확인해서 모두 펼친다.
	} else {

		// 클릭한 위치를 펼친다.
		var varItemLevel = TGRD_ARR_STR_ITEMLEVEL[nIndex];
		if(isdigit(varItemLevel) == false) varItemLevel = objDataset.GetColumn(nRow,varItemLevel);

		if(length(objDataset.GetColumn(nRow,TGRD_STR_EXPCOL)) > 0 || nLevelNO < toNumber(varItemLevel)) {
			objDataset.SetColumn(nRow,TGRD_STR_EXPCOL,"-");
		}

		var strFilter = "||"+TGRD_STR_PARENTIDCOL+"=='"+strCurrentID+"'";
		if(indexOf(TGRD_ARR_STR_FILTER_COND[nIndex],strFilter) < 0) {
			TGRD_ARR_STR_FILTER_COND[nIndex] = TGRD_ARR_STR_FILTER_COND[nIndex]+strFilter;
		}

		// 클릭한 item 과 같은 레벨의 아이템이 나올때 까지 반복하면서
		// 하위 item 을 펼칠 수 있는 Filter 조건을 생성한다.
		for(var nFindRow = objDataset.FindRowNF(TGRD_STR_PARENTIDCOL,strCurrentID)
			; nFindRow > -1
			&& nFindRow < objDataset.GetRowCountNF()
			&& trim(strParentID) != trim(objDataset.GetColumnNF(nFindRow,TGRD_STR_PARENTIDCOL))
			;
			) {

			if(objDataset.GetColumnNF(nFindRow,TGRD_STR_EXPCOL) == "+") {

				// "+" 일경우 나와 같은레벨의 다음 item을 처리해야 한다.
				nFindRow = objDataset.FindRowNF(TGRD_STR_PARENTIDCOL,objDataset.GetColumnNF(nFindRow,TGRD_STR_PARENTIDCOL),(nFindRow+1));
				if(nFindRow < 0) {
					nFindRow = objDataset.GetRowCountNF();
				}

			} else {

				// "-" 또는 "" 일때 필터링 조건 추가
				strSubParentID = trim(objDataset.GetColumnNF(nFindRow,TGRD_STR_IDCOL));

				strFilter = "||"+TGRD_STR_PARENTIDCOL+"=='"+strSubParentID+"'";
				if(indexOf(TGRD_ARR_STR_FILTER_COND[nIndex],strFilter) < 0) {
					TGRD_ARR_STR_FILTER_COND[nIndex] = TGRD_ARR_STR_FILTER_COND[nIndex]+strFilter;
				}

				nFindRow++;
			}
		}

		TGRD_ARR_STR_FILTER_COND[nIndex] = tgrd_fn_ArrangeCondition(TGRD_ARR_STR_FILTER_COND[nIndex]);
	}

	if(tgrd_fn_IsExistColumn(objDataset,TGRD_STR_EXPCOL)      == true &&
	   tgrd_fn_IsExistColumn(objDataset,TGRD_STR_IDCOL)       == true &&
	   tgrd_fn_IsExistColumn(objDataset,TGRD_STR_PARENTIDCOL) == true) {

		objDataset.Filter(TGRD_ARR_STR_FILTER_COND[nIndex]);
	}

	objDataset.row = nRow;

	objDataset.SetUpdate(true);
	objDataset.fireevent = true;
}


function tgrd_fn_SetEditable(obj,nCell)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	if(length(TGRD_ARR_STR_GRID_CELL_EXPR[nIndex]) == 0) {
		TGRD_ARR_STR_GRID_CELL_EXPR[nIndex] = obj.GetCellProp("body",nCell,"edit");
		obj.SetCellProp("body",nCell,"edit","none");
	}

	var strValue;

	if(indexOf(TGRD_ARR_STR_GRID_CELL_EXPR[nIndex],"expr:") >= 0) {

		var strEditExpr = TGRD_ARR_STR_GRID_CELL_EXPR[nIndex];
		var arrEditExpr;
		var arrSyntax;
		var strSyntaxType;
		var strColumnID;

		if(indexOf(strEditExpr,"iif") > -1) strSyntaxType = "iif";
		if(indexOf(strEditExpr,"decode") > -1) strSyntaxType = "decode";

		strEditExpr = replace(strEditExpr,"expr:","");
		strEditExpr = replace(strEditExpr,strSyntaxType,"");
		strEditExpr = replace(strEditExpr,"length","");
		strEditExpr = replace(strEditExpr,"(","");
		strEditExpr = replace(strEditExpr,")","");

		if(indexOf(strEditExpr,"iif") > -1 || indexOf(strEditExpr,"decode") > -1) {
			alert("둘 이상의 복잡한 Syntax는 처리할 수 없습니다.");
			return;
		}

		arrEditExpr = split(strEditExpr,",","webstyle");

		if(indexOf(strEditExpr,"==") > -1) {
			arrSyntax = split(arrEditExpr[0],"==","webstyle");
		} else if(indexOf(strEditExpr,">=") > -1) {
			arrSyntax = split(arrEditExpr[0],">=","webstyle");
		} else if(indexOf(strEditExpr,"<=") > -1) {
			arrSyntax = split(arrEditExpr[0],"<=","webstyle");
		} else if(indexOf(strEditExpr,">") > -1) {
			arrSyntax = split(arrEditExpr[0],">","webstyle");
		} else if(indexOf(strEditExpr,"<") > -1) {
			arrSyntax = split(arrEditExpr[0],"<","webstyle");
		} else {
			arrSyntax[0] = arrEditExpr[0];
		}

		var objDataset = eval(obj.BindDataset);
		for(var i = 0; i < length(arrSyntax); i++) {

			strColumnID = trim(arrSyntax[i]);

			var bIsColumn = false;
			for(var nCol = 0; nCol < objDataset.GetColCount(); nCol++) {
				if(toLower(strColumnID) == toLower(objDataset.GetColID(nCol))) {
					strColumnID = objDataset.GetColID(nCol);
					nCol = objDataset.GetColCount();
					bIsColumn = true;
				}
			}

			switch(toLower(strColumnID)) {

				case "row" :
				case "rowpos" :
				case "rowposition" :
				case "currow" :
				case "nextrow" :
				case "prevrow" :
				case "firstrow" :
				case "lastrow" :
				case "rowlevel" :
				case "count" :
				case "rowcount" :
						TGRD_ARR_STR_GRID_CELL_EXPR[nIndex] = replace(TGRD_ARR_STR_GRID_CELL_EXPR[nIndex],strColumnID,objDataset.ID+"."+strColumnID);
						break;
				case "rowidx" :
				case "rowindex" :
						TGRD_ARR_STR_GRID_CELL_EXPR[nIndex] = replace(TGRD_ARR_STR_GRID_CELL_EXPR[nIndex],strColumnID,objDataset.ID+".row");
						break;
				case "countnf" :
				case "rowcountnf" :
						TGRD_ARR_STR_GRID_CELL_EXPR[nIndex] = replace(TGRD_ARR_STR_GRID_CELL_EXPR[nIndex],strColumnID,objDataset.ID+".GetRowCountNF()");
						break;
				case "curdataid" :
						TGRD_ARR_STR_GRID_CELL_EXPR[nIndex] = replace(TGRD_ARR_STR_GRID_CELL_EXPR[nIndex],strColumnID,objDataset.ID);
						break;
				case "rowtype" :
						TGRD_ARR_STR_GRID_CELL_EXPR[nIndex] = replace(TGRD_ARR_STR_GRID_CELL_EXPR[nIndex],"rowtype",objDataset.ID+".GetRowType(@)");
						break;
				default :
						if(bIsColumn) {
							TGRD_ARR_STR_GRID_CELL_EXPR[nIndex] = replace(TGRD_ARR_STR_GRID_CELL_EXPR[nIndex],strColumnID,objDataset.ID+".GetColumn(@,'"+strColumnID+"')");
						}
						break;
			}
		}
	}
}


function tgrd_fn_GetMaxRowSpan(obj,strBand)
{
	var nRowspan = 1;
	for(var i = 0; i <  obj.GetCellCount(strBand); i++) {
		if(nRowspan < toNumber(obj.GetCellProp(strBand,i,"rowspan"))) {
			nRowspan = toNumber(obj.GetCellProp(strBand,i,"rowspan"));
		}
	}
	return nRowspan;
}


function tgrd_fn_DisplayEditor(obj,nRow,nCell)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	var strValue = TGRD_ARR_STR_GRID_CELL_EXPR[nIndex];
	if(indexOf(strValue,"expr:") >= 0) {
		strValue = replace(strValue,"expr:","");
		strValue = eval(replace(strValue,"@",nRow));
	}

	if(toLower(strValue) != "none") {

		switch(toLower(strValue)) {

			case "combo" :
					break;
			default :
					if(isValidObject(TGRD_ARR_OBJ_COMPONENT[nIndex]) == false) {
						var strAttrib = 'AutoSelect="TRUE" '
									  + 'Border="flat" '
									  + 'BorderColor="black" '
									  + 'Color="black" '
									  + 'Style="ed_style" '
									  + 'Visible="FALSE" '
									  + 'OnKeyDown="tgrd_fn_CellEdit_Event_OnKeyDown" '
									  + 'OnKillFocus="tgrd_fn_CellEdit_Event_OnKillFocus"';
						create("Edit","edt_CellEdit"+nIndex,strAttrib);
						TGRD_ARR_OBJ_COMPONENT[nIndex] = object("edt_CellEdit"+nIndex);
					}
					break;
		}

		var nWidth = 1;
		for(var i = 0; i < nCell; i++) {
			nWidth += obj.GetColProp(i,"width");
		}

		var nRight = nWidth + obj.GetColProp(nCell,"width");

		// var nRowspan = toNumber(obj.GetCellProp("body",nCell,"rowspan"));
		var nRowspan = tgrd_fn_GetMaxRowSpan(obj,"head");

		var nHeight = 1;
		nHeight += obj.HeadHeight;

		nRowspan = tgrd_fn_GetMaxRowSpan(obj,"body");

		for(var i = 0; i < nRow; i++) {
			nHeight += obj.RowHeight * nRowspan;
		}

		nHeight = nHeight - ((obj.RowHeight * nRowspan) * obj.VScrollPos);

		// ====================
		//  TreeGrid Image 정보
		// --------------------
		//    :   Level간 간격
		// LV :----------------
		//    :  18 :  19 :  20
		// ---:-----:-----:----
		//  1 :  33 :  33 :  33
		//  2 :  51 :  52 :  53
		//  3 :  69 :  71 :  73
		//  4 :  87 :  90 :  93
		//  5 : 105 : 109 : 113
		//  6 : 123 : 128 : 133
		//  7 : 141 : 147 : 153
		//  8 : 159 : 166 : 173
		//  9 : 177 : 185 : 193
		// 10 : 195 : 204 : 213
		// --------------------
		var nBkImageWidth = 33+(18*(toNumber(eval(obj.BindDataset).GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]))-1))+5;

		var nCompPrevTop = TGRD_ARR_OBJ_COMPONENT[nIndex].Top;
		TGRD_ARR_OBJ_COMPONENT[nIndex].Top    = ScreenToClientY(global,obj.Top) + nHeight;
		TGRD_ARR_OBJ_COMPONENT[nIndex].Left   = ScreenToClientX(global,obj.Left) + nWidth + nBkImageWidth - 1;
		TGRD_ARR_OBJ_COMPONENT[nIndex].Right  = nRight + ScreenToClientX(global,obj.Left);
		TGRD_ARR_OBJ_COMPONENT[nIndex].Height = nRowspan * obj.RowHeight;	// - 1;

		if(TGRD_ARR_OBJ_COMPONENT[nIndex].bottom > ScreenToClientY(global,obj.bottom)) {
			TGRD_ARR_OBJ_COMPONENT[nIndex].Top = nCompPrevTop;
		}

		TGRD_ARR_OBJ_COMPONENT[nIndex].BindDataset = obj.BindDataset;
		TGRD_ARR_OBJ_COMPONENT[nIndex].Column      = obj.GetCellProp("body",nCell,"colid");

		TGRD_ARR_OBJ_COMPONENT[nIndex].SetFocus();

		switch(strValue) {

			case "normal" :
					TGRD_ARR_OBJ_COMPONENT[nIndex].LowerOnly   = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].UpperOnly   = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Number      = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Visible     = true;
					break;
			case "number" :
					TGRD_ARR_OBJ_COMPONENT[nIndex].LowerOnly   = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].UpperOnly   = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Number      = true;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Visible     = true;
					break;
			case "upper" :
					TGRD_ARR_OBJ_COMPONENT[nIndex].LowerOnly   = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].UpperOnly   = true;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Number      = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Visible     = true;
					break;
			case "uppernum" :
					TGRD_ARR_OBJ_COMPONENT[nIndex].LowerOnly   = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].UpperOnly   = true;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Number      = true;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Visible     = true;
					break;
			case "lower" :
					TGRD_ARR_OBJ_COMPONENT[nIndex].LowerOnly   = true;
					TGRD_ARR_OBJ_COMPONENT[nIndex].UpperOnly   = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Number      = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Visible     = true;
					break;
			case "lowernum" :
					TGRD_ARR_OBJ_COMPONENT[nIndex].LowerOnly   = true;
					TGRD_ARR_OBJ_COMPONENT[nIndex].UpperOnly   = false;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Number      = true;
					TGRD_ARR_OBJ_COMPONENT[nIndex].Visible     = true;
					break;
			case "combo" :
					// cmb_CellCombo.Visible    = true;
					// chk_CellCheckbox.Visible = false;
					break;
		}
	}
}





/////////////////////////////////////////////////////////////////////////////////////
// ##### Event Function
/////////////////////////////////////////////////////////////////////////////////////
function tgrd_fn_CellEdit_Event_OnKillFocus(obj)
{
	obj.Visible = false;
}

function tgrd_fn_CellEdit_Event_OnKeyDown(obj,nChar,bShift,bCtrl,bAlt,LLParam,HLParam)
{
	if(nChar == 38) {
		obj.Visible = false;
		var objDataset = eval(obj.BindDataset);
		if((objDataset.row - 1) >= 0) {
			objDataset.row = objDataset.row - 1;
		}
	} else if(nChar == 40) {
		obj.Visible = false;
		var objDataset = eval(obj.BindDataset);
		if((objDataset.row + 1) < objDataset.GetRowCount()) {
			objDataset.row = objDataset.row + 1;
		}
	}
}

function tgrd_fn_TreeGrid_Event_OnCellClick(obj,nRow,nCell,nX,nY)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);
	var objDataset = eval(obj.BindDataset);

	nClickCell = nCell;

	if(nRow == objDataset.row && TGRD_ARR_NUM_TREECELL[nIndex] == nCell) {

		// Child를 조회해서 구하는 경우
		if(TGRD_ARR_BOL_TRANS[nIndex]) {

			// Item Level을 직접 사용한 경우와 ColumnID로 사용했을때를 구분한다.
			var varItemLevel = TGRD_ARR_STR_ITEMLEVEL[nIndex];
			if(isdigit(varItemLevel) == false) varItemLevel = objDataset.GetColumn(nRow,varItemLevel);

			// 현재 Level과 Item으로 표현되는 Level보다 작을 경우(폴더) 일때만 조회함수를 호출한다.
			if(objDataset.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]) < toNumber(varItemLevel)) {

				// 만약 이미 Child가 조회되었있을 경우 다시 조회하지 않고 Child를 펼친다.
				if(tgrd_fn_GetChildRow(obj,nRow) < 0) {
					var objInsertDS = fn_GetLowerData(objDataset.GetColumn(nRow,TGRD_ARR_STR_TEXTCOL[nIndex]),nRow);
					tgrd_fn_SetTreeExpandItemTrans(obj,nRow,objInsertDS);
				} else {
					tgrd_fn_SetTreeExpandItem(obj,nRow);
				}
			}
		} else {
			tgrd_fn_SetTreeExpandItem(obj,nRow);
		}

		// 에디트 가능한 곳에 에디터를 표시한다.
		tgrd_fn_DisplayEditor(obj,nRow,nCell);
	}

	// 화면의 Grid OnCellClick 이벤트 호출
	if(length(TGRD_ARR_GRID_ON_CELL_CLICK[nIndex]) > 0) {
		eval(TGRD_ARR_GRID_ON_CELL_CLICK[nIndex]+"("+obj.id+","+nRow+","+nCell+","+nX+","+nY+")");
		// trace("tgrd_fn_TreeGrid_Event_OnCellClick("+obj+","+nRow+","+nCell+","+nX+","+nY+")");
	}
}

function tgrd_fn_TreeGrid_Event_OnHScroll(obj,strType,nPos)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	if(isValidObject(TGRD_ARR_OBJ_COMPONENT[nIndex]) == true) TGRD_ARR_OBJ_COMPONENT[nIndex].Visible = false;

	// 화면의 Grid OnHScroll 이벤트 호출
	if(length(TGRD_ARR_GRID_ON_H_SCROLL[nIndex]) > 0) {
		eval(TGRD_ARR_GRID_ON_H_SCROLL[nIndex]+"("+obj.id+",'"+strType+"',"+nPos+")");
	}
}

function tgrd_fn_TreeGrid_Event_OnVScroll(obj,strType,nPos)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	if(isValidObject(TGRD_ARR_OBJ_COMPONENT[nIndex]) == true) TGRD_ARR_OBJ_COMPONENT[nIndex].Visible = false;

	// 화면의 Grid OnVScroll 이벤트 호출
	if(length(TGRD_ARR_GRID_ON_V_SCROLL[nIndex]) > 0) {
		eval(TGRD_ARR_GRID_ON_V_SCROLL[nIndex]+"("+obj.id+",'"+strType+"',"+nPos+")");
	}
}

function tgrd_fn_Dataset_Event_OnLoadCompleted(obj,nErrorCode,strErrorMsg,nReason)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	if(nReason == 0 || nReason == 4) {
		tgrd_fn_SetTreeExpand(obj,TGRD_ARR_BOL_EXPAND[nIndex]);
		TGRD_ARR_OBJ_GRID[nIndex].Redraw = true;
		TGRD_ARR_OBJ_GRID[nIndex].SetFocus();
	}

	// 화면의 Dataset OnLoadCompleted 이벤트 호출
	if(length(TGRD_ARR_DATASET_ON_LOAD_COMPLETED[nIndex]) > 0) {
		eval(TGRD_ARR_DATASET_ON_LOAD_COMPLETED[nIndex]+"("+obj.id+","+nErrorCode+",'"+strErrorMsg+"',"+nReason+")");
	}
}

// Dataset 의 OnColumnChange 보다 Grid 의 OnCellClick 이 먼저 발생되어
// Tree 가 접혀지면서 엉뚱한 로우에(수정한 로우가 필터링되면) 값이 수정되는 문제 발생
// 그래서 Dataset 의 OnRowPosChanged 에서 처리
// 단, 자신의 로우에서 접히고 펼치는 작업을 위해 Grid 의 OnCellClick도 같이 사용
// (Grid 의 Row 와 Dataset 의 Row 가 같을때만)
var nClickCell;
function tgrd_fn_Dataset_Event_OnRowPosChanged(obj,nOldRow,nRow)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);
	var objDataset = eval(TGRD_ARR_OBJ_GRID[nIndex].BindDataset);

	if(objDataset.GetRowCount() > 0) {

		if(TGRD_ARR_OBJ_GRID[nIndex].Redraw = true) {

			// Row가 추가되면 OnRowPosChanged 이벤트에서 로직을 처리하지 않도록 하기위한 플래그
			if(nRowPosChangedFlag == true) {

				if(TGRD_ARR_NUM_TREECELL[nIndex] == nClickCell) {

					// Child를 조회해서 구하는 경우
					if(TGRD_ARR_BOL_TRANS[nIndex]) {

						// Item Level을 직접 사용한 경우와 ColumnID로 사용했을때를 구분한다.
						var varItemLevel = TGRD_ARR_STR_ITEMLEVEL[nIndex];
						if(isdigit(varItemLevel) == false) varItemLevel = toNumber(objDataset.GetColumn(nRow,varItemLevel));

						// 현재 Level과 Item으로 표현되는 Level보다 작을 경우(폴더) 일때만 조회함수를 호출한다.
						if(objDataset.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]) < toNumber(varItemLevel)) {

							// 만약 이미 Child가 조회되었있을 경우 다시 조회하지 않고 Child를 펼친다.
							if(tgrd_fn_GetChildRow(TGRD_ARR_OBJ_GRID[nIndex],nRow) < 0) {
								var objInsertDS = fn_GetLowerData(obj.GetColumn(nRow,TGRD_ARR_STR_TEXTCOL[nIndex]),nRow);
								tgrd_fn_SetTreeExpandItemTrans(TGRD_ARR_OBJ_GRID[nIndex],nRow,objInsertDS);
							} else {
								tgrd_fn_SetTreeExpandItem(TGRD_ARR_OBJ_GRID[nIndex],nRow);
							}
						}
					} else {
						tgrd_fn_SetTreeExpandItem(TGRD_ARR_OBJ_GRID[nIndex],nRow);
					}

					// 에디트 가능한 곳에 에디터를 표시한다.
					tgrd_fn_DisplayEditor(TGRD_ARR_OBJ_GRID[nIndex],nRow,TGRD_ARR_NUM_TREECELL[nIndex]);
				}
			}

			nRowPosChangedFlag = true;
		}
	}

	// 화면의 Dataset OnRowPosChanged 이벤트 호출
	if(length(TGRD_ARR_DATASET_ON_ROW_POS_CHANGED[nIndex]) > 0) {
		eval(TGRD_ARR_DATASET_ON_ROW_POS_CHANGED[nIndex]+"("+obj.id+","+nOldRow+","+nRow+")");
	}
}

function tgrd_fn_Dataset_Event_OnRowDeleting(obj,nRow,nCount)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	var nLevelNo = toNumber(obj.GetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex]));
	var strID = obj.GetColumn(nRow,TGRD_STR_IDCOL);
	var strParentID = obj.GetColumn(nRow,TGRD_STR_PARENTIDCOL);
	var nParentRow = -1;

	obj.fireevent = false;
	obj.SetUpdate(false);

	// 삭제될 Row의 하위를 찾으면서 Parent ID를 위에서찾은 Parent ID로 세팅한다.
	for(var i = (obj.GetRowIndexNF(nRow)+1); i < obj.GetRowCountNF(); i++) {
		if(nLevelNo < obj.GetColumnNF(i,TGRD_ARR_STR_LEVELNOCOL[nIndex])) {
			// level no를 줄여준다.
			obj.SetColumnNF(i,TGRD_ARR_STR_LEVELNOCOL[nIndex],toNumber(obj.GetColumnNF(i,TGRD_ARR_STR_LEVELNOCOL[nIndex]))-1);
			if(strID == obj.GetColumnNF(i,TGRD_STR_PARENTIDCOL)) {
				obj.SetColumnNF(i,TGRD_STR_PARENTIDCOL,strParentID);
			}
		} else {
			i = obj.GetRowCountNF();
		}
	}

	TGRD_ARR_STR_FILTER_COND[nIndex] = replace(TGRD_ARR_STR_FILTER_COND[nIndex],"||"+TGRD_STR_PARENTIDCOL+"=='"+strID+"'","");
	TGRD_ARR_STR_FILTER_COND[nIndex] = TGRD_ARR_STR_FILTER_COND[nIndex]+"||"+TGRD_STR_PARENTIDCOL+"=='"+strParentID+"'";

	obj.SetUpdate(true);
	obj.fireevent = true;

	tgrd_fn_SetTreeExpandItem(TGRD_ARR_OBJ_GRID[nIndex],nParentRow,"+");

	// Row가 추가되면 OnRowPosChanged 이벤트에서 로직을 처리하지 않도록 하기위한 플래그
	nRowPosChangedFlag = false;

	// 화면의 Dataset OnRowDeleting 이벤트 호출
	if(length(TGRD_ARR_DATASET_ON_ROW_DELETING[nIndex]) > 0) {
		eval(TGRD_ARR_DATASET_ON_ROW_DELETING[nIndex]+"("+obj.id+","+nRow+","+nCount+")");
	}
}

function tgrd_fn_Dataset_Event_OnRowDeleted(obj,nRow,nCount)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	if((obj.GetRowCount()-1) == nRow) {
		obj.row = nRow;
	} else {
		obj.row = nRow-1;
	}

	// 화면의 Dataset OnRowDeleted 이벤트 호출
	if(length(TGRD_ARR_DATASET_ON_ROW_DELETED[nIndex]) > 0) {
		eval(TGRD_ARR_DATASET_ON_ROW_DELETED[nIndex]+"("+obj.id+","+nRow+","+nCount+")");
	}
}

var nRowPosChangedFlag = true;
var nAddRowID = 0;
function tgrd_fn_Dataset_Event_OnRowInserted(obj,nRow,nCount)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	if(nAddRowID == 0) {
		nAddRowID = obj.GetRowCount();
	} else {
		++nAddRowID;
	}

	obj.fireevent = false;

	// Filtering 되는것을 방지하기 위해서 임의 값을 세팅한다.
	// 추가한 row의 ID를 세팅한다.
	obj.SetColumn(nRow,TGRD_ARR_STR_LEVELNOCOL[nIndex],"1");
	// 추가한 row의 ID를 세팅한다.
	obj.SetColumn(nRow,TGRD_STR_IDCOL,"");
	// 추가한 row의 Parent ID를 세팅한다.
	obj.SetColumn(nRow,TGRD_STR_PARENTIDCOL,"");

	obj.fireevent = true;

	// Row가 추가되면 OnRowPosChanged 이벤트에서 로직을 처리하지 않도록 하기위한 플래그
	nRowPosChangedFlag = false;

	// 화면의 Dataset OnRowInserted 이벤트 호출
	if(length(TGRD_ARR_DATASET_ON_ROW_INSERTED[nIndex]) > 0) {
		eval(TGRD_ARR_DATASET_ON_ROW_INSERTED[nIndex]+"("+obj.id+","+nRow+","+nCount+")");
	}
}

function tgrd_fn_Dataset_Event_OnColumnChanged(obj,nRow,strColumnID,varOldValue,varNewValue,nPivotIndex)
{
	var nIndex = tgrd_fn_GetArrayIndex(obj);

	obj.fireevent = false;

	// Level 컬럼의 값이 변경되었을때만 처리한다.
	if(TGRD_ARR_STR_LEVELNOCOL[nIndex] == strColumnID) {

		var strParentID = "";
		var nParentRow;
		for(var i = (nRow-1); i >= 0; i--) {

			// level 이 작으면 ID값을 Parent ID값으로 사용한다.
			if(toNumber(obj.GetColumn(i,TGRD_ARR_STR_LEVELNOCOL[nIndex])) < toNumber(varNewValue)) {
				strParentID = obj.GetColumn(i,TGRD_STR_IDCOL);
				nParentRow = i;
				i = -1;

			}
		}

		// Parent 상태를 세팅한다.
		obj.SetUpdate(false);
		obj.SetColumn(nParentRow,TGRD_STR_EXPCOL,"-");
		obj.SetUpdate(true);

		// 추가한 row의 ID를 세팅한다.
		var strNewID = strParentID+"_9"+nAddRowID;
		obj.SetColumn(nRow,TGRD_STR_IDCOL,strNewID);

		// 추가한 row의 Parent ID를 세팅한다.
		obj.SetColumn(nRow,TGRD_STR_PARENTIDCOL,strParentID);

		tgrd_fn_SetTreeExpandItem(TGRD_ARR_OBJ_GRID[nIndex],nParentRow,"+");

		// obj.FindRow(TGRD_STR_IDCOL,strNewID,nParentRow);
		// Row가 추가되면 OnRowPosChanged 이벤트에서 로직을 처리하지 않도록 하기위한 플래그
		// if(nRowPosChangedFlag == false) {
			// obj.MoveRow(obj.FindRow(TGRD_STR_IDCOL,strNewID,nParentRow),(nParentRow+1));
			// obj.row = (nParentRow+1);
		// } else {
			// obj.row = obj.FindRow(TGRD_STR_IDCOL,strNewID,nParentRow);
		// }
		obj.row = nRow;
	}

	obj.fireevent = true;

	// 화면의 Dataset OnColumnChanged 이벤트 호출
	if(length(TGRD_ARR_DATASET_ON_COLUMN_CHANGED[nIndex]) > 0) {
		eval(TGRD_ARR_DATASET_ON_COLUMN_CHANGED[nIndex]+"("+obj.id+","+nRow+",'"+strColumnID+"','"+varOldValue+"','"+varNewValue+"',"+nPivotIndex+")");
	}
}

