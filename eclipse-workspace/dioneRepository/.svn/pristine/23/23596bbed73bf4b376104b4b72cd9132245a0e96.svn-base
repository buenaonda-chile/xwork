package com.denso.max5250;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import com.denso.max5250.ConvertXml;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.denso.common.converter.DataConverter;
import com.denso.common.converter.MiPlatformView;
import com.denso.common.dao.CommonDAO;
import com.tobesoft.platform.PlatformRequest;

public class Max5250Controller extends MultiActionController {

	
/*
 * 데이타셋 생성
 * 화면에 표현되는 값  ....
 */
	public void convertxmlData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		
		//miplatform 에서 전송한 파라메타 값
		Map pArg = DataConverter.getMiPlatformData(pReq);
		ModelMap rtn_map = new ModelMap();
		String str = 	(String)pArg.get("str");
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			//DocumentBuilder는 생성자가 protect이다.
			DocumentBuilder builder = factory.newDocumentBuilder(); 
			StringBuffer srtb = new StringBuffer();
			HashMap<String,String> map = null;
			 List<Object> alist =  new ArrayList<Object>();  //화면 테이터를 담을 리스트 생성
			 List<Object> attrlist =  new ArrayList<Object>();  //화면 속성을 담을 리스트 생성
			
			 Document xmlDoc = builder.parse(new InputSource(new StringReader(str))); 
		     StringBuffer sb = new StringBuffer();
		     Element root = xmlDoc.getDocumentElement(); 
		     NodeList list = root.getElementsByTagName("TextItem"); 
		     NodeList list2 = root.getElementsByTagName("Field"); 
		      map = new HashMap<String,String>();
		    
		      System.out.println("-----------------------" + str);
		     for(int i=0; i<list.getLength();i++){ 
		    	 Element element = (Element)list.item(i); 
		    	 map.put(element.getAttribute("ID"),getData1(element,"Value"));
		    	 map.put("color",ConvertXml.convertToAttribute(element.getAttribute("Attribute"),1));
		    	 map.put("bkcolor",ConvertXml.convertToAttribute(element.getAttribute("Attribute"),2));
		    	 map.put("font",ConvertXml.convertToAttribute(element.getAttribute("Attribute"),3));
		       } 
		     

		     for(int i=0; i<list2.getLength();i++){ 
		    	 Element element = (Element)list2.item(i); 
		    	 //System.out.println("-----------------------" + element.getAttribute("Attribute"));
		    	 map.put(element.getAttribute("ID")+"_c",ConvertXml.convertToAttribute(element.getAttribute("Attribute"),1));
		    	 map.put(element.getAttribute("ID")+"_b",ConvertXml.convertToAttribute(element.getAttribute("Attribute"),2));
		    	 map.put(element.getAttribute("ID")+"_f",ConvertXml.convertToAttribute(element.getAttribute("Attribute"),3));
		    	 map.put(element.getAttribute("ID")+"_s",ConvertXml.convertToAttribute(element.getAttribute("Type"),4));
		    	 map.put(element.getAttribute("ID"),getData1(element,"Value"));
		       } 
		     alist.add(map);
		     System.out.println("-----------------------" + alist);
		     	rtn_map.addAttribute("ds_main", alist);
		     	rtn_map.addAttribute("rtnMsg","OK");
		    }catch(Exception e) 
		    { 
		    	e.printStackTrace(System.err); 
		    } 

			new MiPlatformView().render(rtn_map, request, response);
	}
	/*
	 * 디자인 컨버젼
	 */
	public void convertxml(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		//dao.startTransaction();
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map headMap =  DataConverter.setMiPlatformDataSet(pReq, "ds_head");
		Map attrMap =  DataConverter.setMiPlatformDataSet(pReq, "ds_screen");
		
		//miplatform 에서 전송한 파라메타 값
		Map pArg = DataConverter.getMiPlatformData(pReq);
		 ModelMap rtn_map = new ModelMap();
		String str = 	(String)pArg.get("str");
		String filepath = 	(String)pArg.get("filepath");
		String filename = 	(String)pArg.get("filename");
		String stype = 	(String)pArg.get("stype");
		System.out.println("------------"+filename);
		try{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		     //    DocumentBuilder는 생성자가 protect이다. 
		DocumentBuilder builder = factory.newDocumentBuilder(); 
		StringBuffer srtb = new StringBuffer();
		HashMap<String,String> map = null;
		 List<Object> alist =  new ArrayList<Object>();
	//	System.out.println(str);
		 Document xmlDoc = builder.parse(new InputSource(new StringReader(str))); 
	     StringBuffer sb = new StringBuffer();
	     Element root = xmlDoc.getDocumentElement(); 
	     NodeList list = root.getElementsByTagName("TextItem"); 
	     NodeList list2 = root.getElementsByTagName("Field"); 
	    
	     for(int i=0; i<list.getLength();i++){ 
	    	 Element element = (Element)list.item(i); 
	    	 map = new HashMap<String,String>();
//	    	 map.put("type","\"" + "1" + "\"");
	    	 map.put("type", "1");
	    	 map.put("column", element.getAttribute("Column"));
	    	 map.put("row", element.getAttribute("Row"));
	    	 map.put("field", element.getAttribute("ID"));
	    	 map.put("length", element.getAttribute("Length"));
//	    	 map.put("value","\"" +  getData1(element,"Value") + "\"");
	    	 map.put("value", getData1(element,"Value"));
	    	 sb.append(getData1(element,"Value")+"\n"); //java 1.8일경우 문제됨.
	    	 alist.add(map);
	       } 

	     for(int i=0; i<list2.getLength();i++){ 
	    	 Element element = (Element)list2.item(i); 
	    	 map = new HashMap<String,String>();
	    	 map.put("type", "2");
	    	 map.put("field", element.getAttribute("ID"));
	    	 map.put("column", element.getAttribute("Column"));
	    	 map.put("row", element.getAttribute("Row"));
	    	 map.put("length", element.getAttribute("Length"));
	    	 map.put("mode", element.getAttribute("type"));
	    	 map.put(element.getAttribute("color"),ConvertXml.convertToAttribute(element.getAttribute("Attribute"),1));
	    	 map.put(element.getAttribute("bkcolor"),ConvertXml.convertToAttribute(element.getAttribute("Attribute"),2));
	    	 map.put(element.getAttribute("font"),ConvertXml.convertToAttribute(element.getAttribute("Attribute"),3));
	    	 alist.add(map);
	       } 

	     System.out.println(alist.toString());
	     ConvertXml cxml = new ConvertXml();
	     makeXml(cxml.RpgToMiplatform(alist,headMap,attrMap,stype),filepath,filename);
	     rtn_map.addAttribute("rtnMsg","OK");
	    }catch(Exception e) 
	    { 
	    	e.printStackTrace(System.err); 
	    } 

	
	  
		
		new MiPlatformView().render(rtn_map, request, response);
		//dao.endTransaction();
		
	}	
	
	
	public void getScreenAttr(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("max5250.getScreen", pData);
		List list2 = dao.getListData("max5250.getAttr", pData);
		System.out.println("screen data : "+list.toString());

		ModelMap map = new ModelMap();
		map.addAttribute("ds_screen", list);
		map.addAttribute("ds_screenCopy", list2);
		new MiPlatformView().render(map, request, response);		
	}
	
	public void getSubFileList(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
	
		List list = dao.getListData("max5250.getSubFileList", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_menu", list);
		new MiPlatformView().render(map, request, response);		
	}

	public void setSubFile(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		List ds_list =  DataConverter.getMiPlatformMultiData(pReq, "ds_save");
		Map pData = DataConverter.getMiPlatformData(pReq);
		System.out.println("ds_save : " +ds_list.toString());
		HashMap<String, String> hmap =  null;
		for(int i = 0 ; i < ds_list.size(); i++){
			hmap = new HashMap<String, String>();
			hmap = (HashMap<String,String>)ds_list.get(i);
			if(hmap.get("ROW_TYPE").toString().equals("insert")){
				System.out.println("START INSERT");
				dao.insertData("max5250.insertScreen", hmap);
			}else if(hmap.get("ROW_TYPE").toString().equals("update")){
				System.out.println("START UPDATE");
				dao.insertData("max5250.updateScreen", hmap);
			}
		}		
			ModelMap map = new ModelMap();
			new MiPlatformView().render(map, request, response);		
	}
	
	public void deleteSubFile(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		List ds_list =  DataConverter.getMiPlatformMultiData(pReq, "ds_save");
		
		HashMap<String, String> hmap =  null;
		Map pArg = DataConverter.getMiPlatformData(pReq);
		String id = 	(String)pArg.get("id");
	System.out.println("screenid : "+id);
			hmap = new HashMap<String, String>();
			hmap.put("SCREEN_ID",id);
			dao.insertData("max5250.deleteScreen", hmap);
				
			ModelMap map = new ModelMap();
			new MiPlatformView().render(map, request, response);		
	}
	
	public static String getData1(Element element, String tagName){ 
		 NodeList list = element.getElementsByTagName(tagName);
		 String rtn = "";
		 StringBuffer sb = new StringBuffer();
		 for(int i =0 ; i < list.getLength(); i++){
			 Element cElement = (Element)list.item(i); 
			 if(cElement.getFirstChild()!=null){ 
			  rtn =  cElement.getFirstChild().getNodeValue(); 
			 }else{ 
			  rtn =  ""; 
			 }  
			 sb.append(rtn);	 //java 1.8일경우 문제됨.
	 }
		 
		
		return rtn;
	} 

		static void makeXml(StringBuffer sbr,String filepath,String filename){
			System.out.println(sbr.toString()); 
			String mPath = filepath+"\\"+filename+".xml";
			FileOutputStream fos = null;
			System.out.println(mPath);
			try{
			  File f = new File(mPath);
			  OutputStreamWriter oswxxx = new OutputStreamWriter(new FileOutputStream(new File (mPath)),"UTF-8");
		      fos = new FileOutputStream(mPath);   
		      if ( f.createNewFile() ) {
		    	  oswxxx.write(sbr.toString());
				  oswxxx.close();

			  //    fos.write(sbr.toString().getBytes());
			   //   fos.flush();

		      }else{
		    	  oswxxx.write(sbr.toString());
				  oswxxx.close();
		      }	
		         fos.close();
			  } catch (FileNotFoundException e) {
		          // TODO Auto-generated catch block
		          System.out.println("FileNotFoundException");
		      } catch (IOException e) {
		          // TODO Auto-generated catch block
		          e.printStackTrace();
		      } finally {
		           if (fos != null)
		              try {
		            	  fos.close();
		              } catch (IOException e) {
		                  // TODO Auto-generated catch block
		              }
		      } 
		}
		

}
