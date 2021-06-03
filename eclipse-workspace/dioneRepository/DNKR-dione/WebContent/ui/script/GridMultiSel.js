
var gv_Shift = false;
var gv_Ctrl = false;
var gv_SelRow1 = 0;
var gv_SelRow2 = -1;
var gv_arrSelRow = "0;";

function gf_FreeMultiSel(nRow) 
{
	gv_Shift = false;
	gv_Ctrl = false;
	gv_SelRow1 = nRow;
	gv_SelRow2 = -1;
	gv_arrSelRow = nRow + ";";
}

function gf_OnCellPosChanged(nRow,nOldRow)
{
	if(gv_Shift == true) {
		if(gv_SelRow1 == nOldRow || gv_SelRow2 == nOldRow) 
			gv_SelRow2 = nRow;
		
		gv_arrSelRow = "";
		
		gv_Ctrl = false;
	} else if(gv_Ctrl == true) {
		if(gv_SelRow2 != -1) {
			var nStart = gv_SelRow1;
			var nEnd = gv_SelRow2;
			if(gv_SelRow2 < gv_SelRow1) {
				nStart = gv_SelRow2;
				nEnd = gv_SelRow1;
			}
			for(var i = nStart; i <= nEnd; i++) {
				gv_arrSelRow += i + ";";
			}
			
			gv_SelRow2 = -1;
		} 	
		
		var nPos = pos(gv_arrSelRow, nRow + ";");
		if(nPos == 0) {
			gv_arrSelRow = mid(gv_arrSelRow, length(nRow + ";"));
			return;
		}
	
		nPos = pos(gv_arrSelRow, ";" + nRow + ";");
		if(nPos >= 0) {
			gv_arrSelRow = mid(gv_arrSelRow, 0, nPos) + mid(gv_arrSelRow, nPos + length(nRow + ";"));
			return;
		}

		gv_SelRow1 = nRow;	
		gv_arrSelRow  += nRow + ";";
		gv_Shift = false;
	} 
}

function gfn_GetSelRow(bFreeMultiSel) {
	var rtn = null;
	if(gv_Shift) {
		var nStart = gv_SelRow1;
		var nEnd = gv_SelRow2;
		if(gv_SelRow2 < gv_SelRow1) {
			nStart = gv_SelRow2;
			nEnd = gv_SelRow1;
		}
		
		rtn = array(nEnd - nStart + 1);
		for(var i = nStart; i <= nEnd; i++) {		
			rtn[i - nStart] = i;
		}
		
		if(bFreeMultiSel == true) gf_FreeMultiSel(nStart);
	} else if(gv_Ctrl == true) {
		var arr = split(gv_arrSelRow, ";");
		var arrLank = array(arr.length);
		var arrLank2 = array(arr.length);
	
		for(var i = 0; i < arr.length; i++) {		
			arrLank[i] = 0;
			for(var j = 0; j < i; j++) {
				if(toNumber(arr[j]) > toNumber(arr[i])) {
					arrLank[j]++;
					arrLank2[toNumber(arrLank[j])] = j;
				} else { 
					arrLank[i]++;
				}
			}
			
			arrLank2[toNumber(arrLank[i])] = i;
		}
			
		rtn = array(arrLank2.length);		
		for(i = 0; i < arrLank2.length; i++) {			
			rtn[i] = toNumber(arr[toNumber(arrLank2[i])]);
		}
		if(bFreeMultiSel == true) gf_FreeMultiSel(rtn[0]);		
	} else {
		rtn = split(gv_arrSelRow, ";");
	}

	return rtn;
}