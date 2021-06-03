package com.denso.max5250;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tobesoft.platform.data.ColumnInfo;

class ConvertXml
{
	StringBuffer strbuf = null;
	public ConvertXml(){
		
	}
	
	public static  Comparator codeKeySort = new Comparator() {
		  public int compare (Object s1,  Object s2){
		   String ss1 =  (String)s1;
		   String ss2 =  (String)s2;
		   return (-1) * ss2.compareTo(ss1);
		  }
	};

	/*   속성값 변경
         "20: 녹색",
		 "21: 녹색/반전",
		 "22: 흰색",
		 "23: 흰색/반전",
		 "24: 녹색/밑줄",
		 "25: 녹색/밑줄/반전",
		 "26: 흰색/밑줄",
		 "27: 비표시",
		 "28: 적색",
		 "29: 적색/반전",
		 "2a: 적색/명멸",
		 "2b: 적색/반전/명멸",
		 "2c: 적색/밑줄",
		 "2d: 적색/밑줄/반전",
		 "2e: 적색/밑줄/명멸",
		 "2f: 비표시",
		 "30: 하늘색/열분리기",
		 "31: 하늘색/열분리기/반전",
		 "32: 황색/열분리기",
		 "33: 황색/열분리기/반전",
		 "34: 하늘색/밑줄/열분리기",
		 "35: 하늘색/밑줄/반전/열분리기",
		 "36: 황색/밑줄/열분리기",
		 "37: 비표시/열분리기",
		 "38: 분홍색",
		 "39: 분홍색/반전",
		 "3a: 청색",
		 "3b: 청색/반전",
		 "3c: 분홍색/밑줄",
		 "3d: 분홍색/밑줄/반전",
		 "3e: 청색/밑줄",
		 "3f: 비표시/열분리기"
	 */
	public static String convertToAttribute(String str,int gbn){
		String returnStr = "";
		HashMap<String,String> cmap = new HashMap<String,String>();
		HashMap<String,String> bmap = new HashMap<String,String>();
		HashMap<String,String> fmap = new HashMap<String,String>();
		
		//Color 설정한다.
		cmap.put("32", "");
		cmap.put("33", "");
		cmap.put("34", "blue");
		cmap.put("35", "blue");
		cmap.put("36", "");
		cmap.put("37", "");
		cmap.put("38", "blue");
		cmap.put("39", "");
		cmap.put("40", "red");
		cmap.put("41", "red");
		cmap.put("42", "red");
		cmap.put("43", "red");
		cmap.put("44", "red");
		cmap.put("45", "red");
		cmap.put("46", "red");
		cmap.put("47", "");
		cmap.put("48", "");
		cmap.put("49", "");
		cmap.put("50", "orange");
		cmap.put("51", "orange");
		cmap.put("52", "");
		cmap.put("53", "");
		cmap.put("54", "orange");
		cmap.put("55", "");
		cmap.put("56", "fuchia");
		cmap.put("57", "fuchia");
		cmap.put("58", "bule");
		cmap.put("59", "blue");
		cmap.put("60", "fuchia");
		cmap.put("61", "fuchia");
		cmap.put("62", "blue");
		cmap.put("63", "");



		bmap.put("32", "default" );
		bmap.put("33", "gold");	//반전
		bmap.put("34", "");
		bmap.put("35", "gold");	//반전	
		bmap.put("36", "");
		bmap.put("37", "red");	//반전
		bmap.put("38", "");
		bmap.put("39", "");
		bmap.put("40", "");
		bmap.put("41", "cyan");	//반전
		bmap.put("42", "");
		bmap.put("43", "");
		bmap.put("44", "");
		bmap.put("45", "cyan");	//반전
		bmap.put("46", "");
		bmap.put("47", "");
		bmap.put("48", "");
		bmap.put("49", "cyan");	//반전
		bmap.put("50", "");
		bmap.put("51", "darkblue");
		bmap.put("52", "");
		bmap.put("53", "cyan");
		bmap.put("54", "");
		bmap.put("55", "");
		bmap.put("56", "");
		bmap.put("57", "cyan");	//반전
		bmap.put("58", "");
		bmap.put("59", "");
		bmap.put("60", "");
		bmap.put("61", "cyan");	//반전
		bmap.put("62", "");
		bmap.put("63", "");



		fmap.put("32", "Default,9");
		fmap.put("33", "Default,9");
		fmap.put("34", "Default,9");
		fmap.put("35", "Default,9");
		fmap.put("36", "Default,9,Underline");
		fmap.put("37", "Default,9,Underline");
		fmap.put("38", "Default,9,Underline");
		fmap.put("39", "Default,9");
		fmap.put("40", "Default,9");
		fmap.put("41", "Default,9");
		fmap.put("42", "Default,9");
		fmap.put("43", "Default,9");
		fmap.put("44", "Default,9,Underline");
		fmap.put("45", "Default,9,Underline");
		fmap.put("46", "Default,9,Underline");
		fmap.put("47", "Default,9");
		fmap.put("48", "Default,9");
		fmap.put("49", "Default,9");
		fmap.put("50", "Default,9");
		fmap.put("51", "Default,9");
		fmap.put("52", "Default,9,Underline");
		fmap.put("53", "Default,9,Underline");
		fmap.put("54", "Default,9,Underline");
		fmap.put("55", "Default,9");
		fmap.put("56", "Default,9");
		fmap.put("57", "Default,9");
		fmap.put("58", "Default,9");
		fmap.put("59", "Default,9");
		fmap.put("60", "Default,9,Underline");
		fmap.put("61", "Default,9,Underline");
		fmap.put("62", "Default,9,Underline");
		fmap.put("63", "Default,9");
		
		if(gbn == 1){
			returnStr = cmap.get(str).toString();  //Color
		}else if(gbn == 2){
			returnStr = bmap.get(str).toString();  //BkColor
		}else if(gbn == 3){
			returnStr = fmap.get(str).toString();  //Font
		}else if(gbn == 4){
			if(str.equals("P")) returnStr = "flase";
			else returnStr = "true";
		}
		return returnStr;
	}
	
	@SuppressWarnings("unchecked")
	public StringBuffer RpgToMiplatform(List<?> list,Map headMap,Map attrMap,String stype){
		//System.out.println("mapsize = " +headMap.size());
		//System.out.println("mapstring = " +headMap.toString());
		Set<String> ss = headMap.keySet();
		Object[] htmlkeys = ss.toArray();
		Arrays.sort(htmlkeys, codeKeySort ); // 정렬하기
		String ds_column = "ds_column";
		String ds_main = "ds_main";
		int designRow = 0;
		int designEnd = 0;
		if(!(attrMap.get("COL_START") == null || attrMap.get("COL_START").equals(""))){
			designRow = Integer.parseInt(attrMap.get("COL_START").toString());
			designEnd = Integer.parseInt(attrMap.get("REC_END").toString());
		}else{
			designRow = 23;
		}
		if(stype.equals("2")){
			ds_column ="ds_COL_p";
			ds_main ="ds_mainp";
		}
		strbuf =  new StringBuffer();
		strbuf.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		strbuf.append("<Window>\n");
		strbuf.append("	<Form Height=\"535\" OnLoadCompleted=\"form_OnLoadCompleted\" Id=\"form\" Left=\"8\" PidAttrib=\"7\" Title=\"autoConvert\" Top=\"8\" Ver=\"1.0\" Width=\"800\" WorkArea=\"true\" OnKeyDown=\"fnc_OnKeyDown\">\n");
		int chgrow = 0;
		strbuf.append("		<Image FillType=\"STRETCH\" Height=\"28\" Id=\"Image0\" ImageID=\"main_tit_bak\" TabOrder=\"344\" Width=\"798\" OnKeyDown=\"fnc_OnKeyDown\"></Image>");
		strbuf.append("		<Image Height=\"28\" Id=\"Image2\" ImageID=\"main_tit_icon\" Left=\"1\" TabOrder=\"343\" Width=\"29\" OnKeyDown=\"fnc_OnKeyDown\"></Image>");
		for(int i=0; i< list.size(); i++){
			HashMap<String,String> map = (HashMap<String,String>) list.get(i);
			int top = Integer.parseInt((String)map.get("row")) * 21 - 10;
			int left = Integer.parseInt((String)map.get("column")) * 10;
			int width = Integer.parseInt((String)map.get("length")) *10;
			if((designRow > Integer.parseInt((String)map.get("row")) || designEnd < Integer.parseInt((String)map.get("row")))&& Integer.parseInt((String)map.get("row")) < 24){
				if(map.get("type").equals("1")){   //static
					
					if(chgrow > 0 && chgrow != Integer.parseInt((String)map.get("row"))){
						strbuf.append("		<Static BKColor=\"white\" Border=\"Flat\" BorderColor=\"#b4b4b4\" Height=\"22\" Id=\"lineBar"+chgrow+"\"   Top=\""+top+"\" Width=\"798\"></Static>");
					}
					if(map.get("value").toString().indexOf(":") != -1){
						strbuf.append("		<Static BKColor=\"#dfdfdf\" Border=\"Flat\" BorderColor=\"#b4b4b4\" Height=\"22\" Id=\"Bar_"+map.get("field").toString()+"\" Left=\""+(left-20)+"\"  Top=\""+top+"\" Width=\"106\"></Static>");
						strbuf.append("		<Shape BKColor=\"#888888\" Bottom=\"44\" Height=\"5\" Id=\"Shape0_"+map.get("field").toString()+"\" Left=\""+(left-10)+"\" LineColor=\"#dceaf7\"  Top=\""+(top+10)+"\" Type=\"Ellipse\" Width=\"5\"></Shape>");
					}
					if(Integer.parseInt((String)map.get("row"))== 1){
						strbuf.append("		<Static Height=\"20\" Id=\""+map.get("field").toString()+"\" Left=\""+left+"\" TabOrder=\""+i+"\" Text=\""+map.get("value").toString()+"\" Top=\""+(top-7)+"\" Width=\""+width+"\" Valign=\"Middle\"></Static>\n");
					}else{
						strbuf.append("		<Static Height=\"20\" Id=\""+map.get("field").toString()+"\" Left=\""+left+"\" TabOrder=\""+i+"\" Text=\""+map.get("value").toString()+"\" Top=\""+top+"\" Width=\""+width+"\" Valign=\"Middle\"></Static>\n");
						
					}
				}else if(map.get("type").equals("2")){  //editbox
		
		
					
					String ImeMode = "none";
					String UseIme = "True";
					String Number = "False";
					if(map.get("mode").toString().equals("A")){ //영문만입력
						ImeMode = "english";
						UseIme = "false";
					}else if(map.get("mode").toString().equals("A")){ //한글만입력
						ImeMode = "native";
						UseIme = "True";
					}else if(map.get("mode").toString().equals("N")){ //숫자만입력
						Number = "True";			
					}
					strbuf.append("		<Edit AutoSelect=\"TRUE\" Border=\"Flat\" BorderColor=\"#b4b4b4\" Height=\"18\"  Id=\""+map.get("field").toString()+"\" Left=\""+left+"\" TabOrder=\""+i+"\" Text=\"\" Top=\""+(top+2)+"\" Width=\""+width+"\" ImeMode=\""+ImeMode+"\" UseIme=\""+UseIme+"\" Number=\""+Number+"\" OnKeyDown=\"fnc_OnKeyDown\"></Edit>\n");
				}
				
				chgrow = Integer.parseInt((String)map.get("row"));
			}
			if(Integer.parseInt((String)map.get("row")) == 24){
				strbuf.append("		<Button ButtonStyle=\"TRUE\" Height=\"23\" ImageID=\"7_btn\" Id=\""+map.get("field").toString()+"\" Left=\""+left+"\" TabOrder=\""+i+"\" Text=\""+map.get("value").toString()+"\" Top=\""+top+"\" Width=\"113\" Valign=\"Middle\" OnKeyDown=\"fnc_OnKeyDown\"></Button> \n");
			}
		}
		
	//	strbuf.append("		<MAX5250 Bottom=\"10\" Height=\"10\" Id=\"MAX5250\" Left=\"3\" Right=\"13\" Top=\"8\" Width=\"10\"></MAX5250>");
		strbuf.append("	<Datasets>\n");
		strbuf.append("	<Dataset DataSetType=\"Dataset\" Id=\"ds_main\"></Dataset>\n");
		strbuf.append("</Datasets>\n");

		/*
		 * 그리드 설정
		 */
		int grdTop = 0;
		int grdHeight = 0;
		int grdColumn = 0;
		System.out.println("attribute size == "+attrMap.toString());
		if(attrMap.size() > 1){
		strbuf.append("	<Datasets>\n");
		strbuf.append("	<Dataset DataSetType=\"Dataset\" Id=\"ds_list\"></Dataset>\n");
		strbuf.append("</Datasets>\n");
		if(!attrMap.get("COL_START").equals("") && !attrMap.get("REC_HEIGHT").equals("") && !attrMap.get("REC_LENGTH").equals("")){;
			grdTop = Integer.parseInt(attrMap.get("COL_START").toString());
			grdHeight = Integer.parseInt(attrMap.get("REC_HEIGHT").toString());
			grdColumn = 795 / Integer.parseInt(attrMap.get("REC_LENGTH").toString());
		}
		
		if(!attrMap.get("REC_HEIGHT").equals("")){
		   strbuf.append("<Grid AutoEnter=\"TRUE\" AutoFit=\"TRUE\" BindDataset=\""+ds_column+"\" BkColor2=\"default\" BoldHead=\"true\" Border=\"Flat\" BorderColor=\"#b4b4b4\" CellMoving=\"TRUE\" ColSizing=\"TRUE\" Editable=\"TRUE\" Enable=\"true\" EndLineColor=\"default\" RowHeight=\"21\" FillArea=\"TRUE\" HeadBorder=\"Flat\" HeadHeight=\"25\" Height=\""+(grdHeight*21+25)+"\" Id=\"MainGrid\" InputPanel=\"FALSE\" LineColor=\"#b4b4b4\" Right=\"1057\" ScrollCell=\"true\" TabStop=\"true\" Top=\""+grdTop*20+"\" UseDBuff=\"true\" UsePopupMenu=\"true\" UseSelColor=\"FALSE\" Visible=\"true\" VLineColor=\"#b4b4b4\" WheelScrollRow=\"1\" Width=\"798\" OnKeyDown=\"fnc_OnKeyDown\">\n");
		   strbuf.append(" <contents>\n");
		   strbuf.append("	<format id=\"Default\">\n");
		   strbuf.append("		<columns>\n");
	
	
			for( int i = 0 ;  i<  htmlkeys.length ; i++){
			   String key = (String)htmlkeys[i];		
			   strbuf.append("			<col width=\""+grdColumn+"\"/>\n");
			}
	
				strbuf.append("		</columns>\n");
				strbuf.append("			<head>\n");
			for( int i = 0 ;  i<  htmlkeys.length ; i++){
			   String key = (String)htmlkeys[i];
			   System.out.println(key + " : " + (String)headMap.get(key));
			   strbuf.append("			<cell bkcolor=\"#dfdfdf\" col=\""+i+"\" color=\"#002043\" display=\"text\" text=\""+(String)headMap.get(key)+"\"/>\n");
			}
				strbuf.append("			</head>\n");
				strbuf.append("			<body>\n");
			for( int i = 0 ;  i<  htmlkeys.length ; i++){
			   String key = (String)htmlkeys[i];
			   System.out.println(key + " : " + (String)headMap.get(key));
			   strbuf.append("			<cell bkcolor='expr:setBkColor(ds_attr.getColumn(currow,&quot;"+key+"_A&quot;))' color='expr:setColor(ds_attr.getColumn(currow,&quot;"+key+"_A&quot;))' align=\"left\" col=\""+i+"\" colid=\""+key+"\" edit=\"normal\" edit=\"expr:iif(ds_attr.getColumn(currow,&apos;"+key+"_T&apos;)&#32;==&apos;P&apos;&#32;,&apos;none&apos;,&apos;normal&apos;)\"/>\n");
			}
			
				strbuf.append("			</body>\n");
				strbuf.append("		</format>\n");
				strbuf.append("	</contents>\n");
				strbuf.append("</Grid>\n");
		}
		
		}
		strbuf.append("	</Form>\n");
		strbuf.append("	<script><![CDATA[#include \"script::lib_script_common.js\";\n");
		strbuf.append("function sendColumn(){\n");	
		for( int j = 0 ;  j<  htmlkeys.length ; j++){
			for(int i = 0 ; i < grdHeight ; i++){
				String key = (String)htmlkeys[j];
				strbuf.append("	Max5250.SendToColumn(\""+key+"\","+ds_column+".getColumn("+(i)+",\""+key+"\"),"+(i+1)+");\n");
			}
		}
		strbuf.append("}\n");
		strbuf.append("function sendField(){\n");
		for(int i=0; i< list.size(); i++){
			HashMap<String,String> map = (HashMap<String,String>) list.get(i);
			if(map.get("type").equals("2")){ 
				if(designRow > Integer.parseInt((String)map.get("row"))|| designEnd < Integer.parseInt((String)map.get("row"))){
					strbuf.append("	MAX5250.SendToField(\""+(String)map.get("field")+"\","+ (String)map.get("field")+".Text );\n");
				}
			}
		}
		strbuf.append("	MAX5250.SendKeys(\"[Enter]\");\n");
		strbuf.append("}\n");
		strbuf.append("function form_OnLoadCompleted(obj)\n");
		strbuf.append("{\n");
		strbuf.append("	if(IsValid(btn_pgdn))\n");
		strbuf.append("	chkPage(page); \n");
		strbuf.append("	var subStr = \"\";\n");
		strbuf.append("	var sKind		= \"CONVERTXMLDATA\";	\n");
		strbuf.append("	var sMethodName = \"service::max5250/convertxmlData.do\"; \n");
		strbuf.append("	var sInDataSet  = \"\"; 	\n");
		strbuf.append("	var sOutDataSet = \"ds_main=ds_main\"; 	\n");
		if(stype.equals("2")){
	//		strbuf.append("	var mainStr = max5250.PopupRange("+attrMap.get("POP_START_ROW").toString()+","+attrMap.get("POP_START_COL").toString()+","+attrMap.get("POP_END_ROW").toString()+","+attrMap.get("POP_END_COL").toString()+"); 	\n");
			strbuf.append("	var mainStr = max5250.GetScreenData(1,24); 	\n");
		}else{
			strbuf.append("	var mainStr = max5250.GetScreenData(1,24); 	\n");
		}
		strbuf.append("	var arg			= \" str=\" + quote(mainStr); 	\n");
		strbuf.append("	Transaction(sKind, sMethodName, sInDataSet, sOutDataSet, arg, \"fnc_callBack\"); 	\n");	
		strbuf.append("}\n");
		strbuf.append("function fnc_callBack(svcId,rntCode, errCode, errMsg){\n");
		strbuf.append("	if(svcId==\"CONVERTXMLDATA\"){\n");
		for(int i=0; i< list.size(); i++){
			HashMap<String,String> map = (HashMap<String,String>) list.get(i);
			if(designRow > Integer.parseInt((String)map.get("row"))|| designEnd < Integer.parseInt((String)map.get("row"))){
				strbuf.append("		"+(String)map.get("field")+".Text="+ds_main+".getColumn(0,\""+(String)map.get("field")+"\");\n");
				strbuf.append("		"+(String)map.get("field")+".Color="+ds_main+".getColumn(0,\""+(String)map.get("field")+"_c\");\n");
				strbuf.append("		"+(String)map.get("field")+".BkColor="+ds_main+".getColumn(0,\""+(String)map.get("field")+"_b\");\n");
				strbuf.append("		"+(String)map.get("field")+".Font="+ds_main+".getColumn(0,\""+(String)map.get("field")+"_f\");\n");
				if(map.get("type").toString().equals("2")) strbuf.append("		"+(String)map.get("field")+".Enable="+ds_main+".getColumn(0,\""+(String)map.get("field")+"_s\");\n");
			}
		}
		strbuf.append("	}\n");
		strbuf.append("}\n");
		strbuf.append("function fnc_OnKeyDown(obj,nChar,bShift,bCtrl, bAlt,LLParam,HLParam){\n");
		strbuf.append("	if(nChar == 13){\n");
		strbuf.append("		sendColumn();\n");
		strbuf.append("		sendField();\n");
		strbuf.append("	}\n");
		strbuf.append("}\n");
		strbuf.append("]]>");
		strbuf.append("	</script>\n");
		strbuf.append("</Window>");
		return strbuf;
	}
}