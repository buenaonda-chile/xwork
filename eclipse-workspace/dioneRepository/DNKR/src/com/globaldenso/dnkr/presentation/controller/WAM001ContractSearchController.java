package com.globaldenso.dnkr.presentation.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.ContractService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.OrderService;
import com.globaldenso.dnkr.domain.ContractDomain;
import com.globaldenso.dnkr.domain.OrderDomain;
import com.globaldenso.dnkr.domain.OrderQtyDomain;
import com.globaldenso.dnkr.domain.db2.OrderDb2Domain;
import com.globaldenso.dnkr.presentation.form.basic.WAM001ContractSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisExcelFileUtil;
import com.globaldenso.dnkr.uxis.UxisFileMngUtil;
import com.globaldenso.dnkr.uxis.UxisObjectUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;

/**
 * [KR] 메뉴관리 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAM001Contract")
@ViewId(value = "WAM001")
public class WAM001ContractSearchController {
    /**
     * [KR] 즐겨찾기서비스 <br>     
     */
    @Autowired
    private OrderService orderService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAM001ContractSearchController() {
        // no process
    }
    
    
    private String[] excelRow = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    		, "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", "AY", "AZ"};
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAP001ContractSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAM001")
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAM001ContractSearchForm") WAM001ContractSearchForm form)  throws Exception {
        ModelAndView mv = new ModelAndView();
        //System.out.println("WAP001Contract/init.do");

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        //ContractDomain domain = new ContractDomain();
        //List<ContractDomain> ContractList = contractService.searchByCondition(domain);

        //mv.addObject("ContractList", ContractList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAM001Contract.jsp");
        mv.setViewName(".tiles.page.WAM001");
        return mv;
    }
    
    /**
     * 
     * 
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @param multiRequest  MultipartHttpServletRequest
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/procExcelUpload", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView procExcelUpload(HttpServletRequest request, 
        HttpServletResponse response, 
        MultipartHttpServletRequest multiRequest) throws Exception{

        System.out.println("-------------------------------------------------");
        String result = "";
        String fileName = "";   //파일명을 담을 변수 선언
        UxisExcelFileUtil efUtil = new UxisExcelFileUtil();
        OrderDomain domain = new OrderDomain();
        domain.setSucList(new ArrayList<OrderDomain>());
        domain.setFailList(new ArrayList<OrderDomain>());
        /** 파일 업로드 처리 **/
        //파일 업로드 처리를 하고 그 결과 내용을 받는다.
        String uploadResult = efUtil.uploadFileData(multiRequest.getFileMap(), "xls;xlsx", new UxisFileMngUtil());
        System.out.println("uploadResult : " + uploadResult);
        try{
            //파일업로드 결과 내용이 없을 경우 메소드내에서 오류가 발생한 것이기때문에 업로드 실패로 강주하고 첨부파일 업로드 실패 처리를 한다.
            if(UxisStringUtil.isEmpty(uploadResult)){ 
                //return UxisCmmUtil.jsonMessage("첨부파일 업로드에 실패했습니다.", "N");
            }else{  //파일 업로드 결과 내용이 있을 경우 내용에 따라 처리한다.
                String[] splitStr = uploadResult.split("§");                        //결과 내용이 § 구분자로 하여 성공여부, 메세지로 나눠진다. 
                if(splitStr.length <= 0){
                    //return UxisCmmUtil.jsonMessage("첨부파일 업로드에 실패했습니다.", "N");     //§ 구분자로 나눠지지 않을 경우 메소드 내에서 오류가 발생한 것이기 때문에 업로드 실패로 강주하고 첨부파일 업로드 실패 처리한다.
                }else{
                    String type = splitStr[0];                                      //성공여부
                    if("Y".equals(type)){
                        fileName = splitStr[1];                                     //성공일 경우 파일명을 변수에 담는다.
                    }else{
                        //return UxisCmmUtil.jsonMessage(splitStr[1],"N");          //실패일 경우 처리실패로 메세지를 담아서 json형태의 값을 리턴한다.
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        /** 액셀 내용 읽기 및 데이터 등록 **/
        //파일명 값이 있을 경우 업로드 된 액셀내용을 읽어서 데이터 등록/수정 처리를 한다.
        if(!UxisStringUtil.isEmpty(fileName)){
            System.out.println("=================Excel Data===============");
            System.out.println(fileName);
            //fileName의 엑셀 파일을 읽어서 변수에 데이터를 담는다.
            List<Map<String, String>> excelData = efUtil.getExcelData(fileName, "order");
            System.out.println("=================Excel Data===============");
            System.out.println(excelData);
            System.out.println("=================Excel Data===============");
            //엑셀에서 읽은 데이터를 가지고  등록 또는 수정 처리를 한다.해당 처리 결과를 Json형태로 리턴 처리 한다.
            domain = excelDataProcess(excelData, domain);
            
            /*if(failList == null){
            	result = "첨부파일이 잘못되었습니다.";
            	System.out.println(result);
            }else{
            	result = "업로드 성공하였습니다.";
            }*/
            result = "업로드 성공하였습니다.";
            //return "";
        }else{
            //return UxisCmmUtil.jsonMessage("첨부파일 읽어오기에 실패하였습니다.","N");
        } 

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        ModelAndView mv = new ModelAndView();
        mv.setViewName(".tiles.page.WAM001");
        mv.addObject("tabId", tabId);
        mv.addObject("result", result);
        mv.addObject("titleList", domain.getTitleList());
        /*mv.addObject("sucList", orderDomainListToJsonString(domain.getSucList()));
        mv.addObject("failList", orderDomainListToJsonString(domain.getFailList()));*/
        mv.addObject("sucList", orderDomainToJsonString(domain.getSucList()));
        mv.addObject("failList", orderDomainToJsonString(domain.getFailList()));
        return mv;
    }

    private OrderDomain excelDataProcess(List<Map<String, String>> excelData, OrderDomain domain) throws ApplicationException, IOException, ParseException, java.text.ParseException{
    	List<String> titleList = new ArrayList<String>();
    	
        //엑셀데이터가 없을 경우 오류 처리 
        if(excelData == null || excelData.size() <= 0){
        	
        	System.out.println("excelDataProcess > excelData.size () : " + excelData.size());
            return domain;
        }

        int rowNum = 0;
        
        for(Map<String, String> tempMap : excelData){
        	
        	if(rowNum == 0){//엑셀의 첫번째 데이터를 titleList에 담는다
        		titleList = getFirstData(tempMap);
        		
        		System.out.println("excelDataProcess > getFirstData size : " + titleList.size());
        		if(titleList.size() < 1){
        			
        			return domain;
        		}
        		domain.setTitleList(titleList);
        	}else{	//나머지 데이터를 densoNumber 여부에 따라 구분하여 담는다.
        		getData(tempMap, domain);
        		
        	}
        	
        	rowNum++;
        }
        
        System.out.println("excelDataProcess > sucCount : " + domain.getSucList().size() + "  failCnt : " + domain.getFailList().size() + "   titleCnt : " + domain.getTitleList().size());
        //분류가 끝난 후 성공한 데이터만 입력한다.
        
        String urlStr = "";
    	String paramStr = "";
        
        urlStr = "http://winus.logisall.com/IF_DENSO_STOCK_QRY.if";
    	paramStr = "login_id=dnkr01";
    	paramStr += "&password=d1234";
    	paramStr += "&lc_id=0000001102";
    	paramStr += "&cust_cd=DENSO";
    	//System.out.println("urlStr : " + urlStr + "   param : " + paramStr);
    	String stockQry = getWinusData(urlStr, paramStr);
    	
    	//System.out.println("stockQry : " + stockQry);
    	
    	urlStr = "http://winus.logisall.com/IF_DENSO_STOCK_DAILY_QRY.if";
    	paramStr = "login_id=dnkr01";
    	paramStr += "&password=d1234";
    	paramStr += "&lc_id=0000001101";
    	paramStr += "&cust_cd=DENSO";
    	
    	//UxisStringUtil.getWeekOfYear(orderDate); 데이터를 5주씩 시프트하여 처리하여야함
    	
    	String fromDate = titleList.get(4);
    	String toDate = (titleList.get(titleList.size() - 2));
    	
    	Calendar cal = Calendar.getInstance();
    	Calendar cal2 = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(fromDate);
        Date date2 = sdf.parse(toDate);
        cal.setTime(date);
        cal2.setTime(date2);
        cal.add(Calendar.WEEK_OF_MONTH, -5);  //조회시작일 5주전
        cal2.add(Calendar.DATE, 7);				//조회 종료일 7일 후
        
        fromDate = sdf.format(cal.getTime());
        toDate = sdf.format(cal2.getTime());
        
        //System.out.println("조회 시작일자 : " + fromDate + "  , 조회 종료일자 : " + toDate);
        
    	/*paramStr += "&time_from=" + titleList.get(4);
		paramStr += "&time_to=" + (titleList.get(titleList.size() - 2));
		*/
		
        paramStr += "&time_from=" + fromDate;
		paramStr += "&time_to=" + toDate;
    	/*paramStr += "&time_from=2018-04-23";
		paramStr += "&time_to=2018-07-31";*/
		
		
		String stockDailyQry = getWinusData(urlStr, paramStr);
		
		//System.out.println("stockDailyQry : " + stockDailyQry + " , "  + titleList.get(4) + "," + titleList.get(titleList.size() - 1));
		
		if(domain.getSucList().size() > 0){
			orderService.orderCreateAll(domain.getSucList(), stockQry, stockDailyQry);
		}
        
        /*
        for(int i=0 ; i<domain.getSucList().size() ; i++){
        	System.out.println("create start : i : " + i);
        	OrderDomain orderDomain = domain.getSucList().get(i);
        	orderDomain.setOrderDateStr(getOrderDateStr(domain));
        	System.out.println("create i : " + rowNum + " , size : " + orderDomain.getQtyList().size() + ", shortText : " + orderDomain.getShortText());
			orderService.orderCreate(orderDomain);
			System.out.println("controller complete i : " + i);
        }*/
        
        return domain;
    }

    
    //엑셀 타이틀 리스트 반환 성공시 칼럼내역 포함 실패시 비어있는 리스트 반환
    private List<String> getFirstData(Map<String, String> map){
    	List<String> titleList = new ArrayList<String>();
    	List<String> emptyList = new ArrayList<String>();
    	
    	for(int i=0 ; i<excelRow.length ; i++){
    		titleList.add(UxisStringUtil.isNullToString(map.get(excelRow[i]))) ;
    		
    		//if(UxisStringUtil.isNullToString(map.get(excelRow[i])).indexOf("0000-00-00") > -1){
    		if(UxisStringUtil.isNullToString(map.get(excelRow[i])).indexOf("Measure") > -1 || UxisStringUtil.isNullToString(map.get(excelRow[i])).indexOf("0000-00-00") > -1){
    			return titleList;	//마지막 칼럼 확인되면 리턴
    		}
    	}
    	
    	return emptyList;	//마지막 칼럼이 확인 안되면 빈리스트 반환
    }

    //읽어온 엑셀 데이터(1 raw)의 Meterial Number로 DensoNumber를 조회하여 있으면 성공한 리스트에 담고 실패하면 실패 리스트에 담는다.
    private OrderDomain getData(Map<String, String> map, OrderDomain domain) throws ApplicationException{
    	
        OrderDomain resultDomain = new OrderDomain();
        OrderDb2Domain orderDb2Domain = null;
        
        //densoNumber 를 가져온다.
        for(int i=1 ; i <= domain.getTitleList().size() ; i++){
        	
        	if(i == 1){//Meterial Number

        		OrderDb2Domain db2Domain = new OrderDb2Domain();
    			db2Domain.setCprtn(UxisStringUtil.isNullToString(map.get(excelRow[i])));
    			db2Domain.setCusno("3700");
    			
    			orderDb2Domain = orderService.getDensoNumber(db2Domain);
    			
    			System.out.println("getData > densoNumber : " + orderDb2Domain.getPrtno());
        	}
    		
        }
        
        //orderDomain에 엑셀 데이터를 담는다
        resultDomain = setExcelToDomain(map, domain.getTitleList());
        
        //System.out.println("getData > resultDomain short TExt : " + resultDomain.getShortText());
        if(orderDb2Domain.getPrtno() == null || "".equals(orderDb2Domain.getPrtno())){
        
        	domain.getFailList().add(resultDomain);
        	System.out.println(" == fail == ");
        
        }else{
        	
        	resultDomain.setDensoNumber(orderDb2Domain.getPrtno());
        	resultDomain.setAlc(orderDb2Domain.getMkalc());
        	resultDomain.setCustomerNumber(orderDb2Domain.getCusno());
        	resultDomain.setDensoStockQty(orderDb2Domain.getMohtq());
        	resultDomain.setMaterialDesc(orderDb2Domain.getItdsc());
        	
        	domain.getSucList().add(resultDomain);
        	
        	System.out.println(" == suc == ");
        }
    	
        return domain;
    }
    
    //엑셀 데이터를 도메인에 담아서 반환
    private OrderDomain setExcelToDomain(Map<String, String> map, List<String> titleList ){
    	OrderDomain domain = new OrderDomain();
    	List<OrderQtyDomain> qtyList = new ArrayList<OrderQtyDomain>();
    	
    	//System.out.println("setExcelToDomain > in titleList.size : " + titleList.size());
    	for(int i=0 ; i <= titleList.size() - 1 ; i++){
    		
    		if(i == 0){
    			domain.setNo(UxisStringUtil.isNullToString(map.get(excelRow[i])));
    		}else if(i == 1){
    			domain.setMeterialNumber(UxisStringUtil.isNullToString(map.get(excelRow[i])));
    		}else if(i == 2){
    			domain.setShortText(UxisStringUtil.isNullToString(map.get(excelRow[i])));
    		}else if(i == 3){
    			domain.setReleaseDate(UxisStringUtil.isNullToString(map.get(excelRow[i])));
    		}else if(i == titleList.size() - 1){
    			domain.setBaseUnitOfMeasure(UxisStringUtil.isNullToString(map.get(excelRow[i])));
    			
    			//System.out.println("qtyDomain in baseunit : " + domain.getBaseUnitOfMeasure());
    		}else{
    			OrderQtyDomain qtyDomainData = new OrderQtyDomain();
    			qtyDomainData.setOrderDate(titleList.get(i));
    			qtyDomainData.setOrderQty(UxisStringUtil.isNullToString(map.get(excelRow[i])));
    			
    			//System.out.println("qtyDomain in orderDate : " + qtyDomainData.getOrderDate() + "  , orderQty : " + qtyDomainData.getOrderQty());
    			qtyList.add(qtyDomainData);
    		}
    	}
    	domain.setQtyList(qtyList);
    	
    	//System.out.println("setExcelToDomain return size : " + domain.getQtyList().size());
    	return domain;
    	
    }
    
    //입력된 날짜반환
    private String getOrderDateStr(OrderDomain domain){
    	
    	String result = "";
    	List<String> titleList = domain.getTitleList();
    	for(int i=0 ; i<titleList.size() - 1; i++){
    		if(i > 3){
    			
    			if("".equals(result)){
    				result += titleList.get(i);
    			}else{
    				result += "§" + titleList.get(i);
    			}
    			
    		}
    	}
    	
    	return result;
    }
    
    private String orderDomainToJsonString(List<OrderDomain> domainList){
    	
    	JSONArray json_arr = new JSONArray();
    	
    	for(int i=0; i<domainList.size() ; i++){
    		JSONObject json_obj = new JSONObject();
    		OrderDomain domain = new OrderDomain();
    		domain = domainList.get(i);
    		int j = 0;
    		
    		json_obj.put(j, domain.getNo());
    		j++;
    		json_obj.put(j , domain.getMeterialNumber());
    		j++;
    		json_obj.put(j, domain.getShortText());
    		j++;
    		json_obj.put(j, domain.getReleaseDate());
    		j++;
    		/*json_obj.put(j, domain.getOrderDateStr());
    		j++;
    		json_obj.put(j, domain.getDensoNumber());
    		j++;*/
    		List<OrderQtyDomain> qtyList = domain.getQtyList();
    		for(int k=0; k<qtyList.size() ; k++){
    			OrderQtyDomain qtyDomain = qtyList.get(k);
    			/*json_obj.put(j, qtyDomain.getOrderDate());
    			j++;*/
    			json_obj.put(j, qtyDomain.getOrderQty());
    			j++;
    		}
    		json_obj.put(j, domain.getBaseUnitOfMeasure());
    		j++;
    		
    		/*json_obj.put("orderKey", domain.getOrderKey());
    		json_obj.put("meterialNumber" , domain.getMeterialNumber());
    		json_obj.put("shortText", domain.getShortText());
    		json_obj.put("releaseDate", domain.getReleaseDate());
    		json_obj.put("orderDateStr", domain.getOrderDateStr());
    		json_obj.put("baseUnitOfMeasure", domain.getBaseUnitOfMeasure());
    		json_obj.put("densoNumber", domain.getDensoNumber());
    		JSONArray json_qty_arr = new JSONArray();
    		List<OrderQtyDomain> qtyList = domain.getQtyList();
    		for(int j=0; j<qtyList.size() ; j++){
    			OrderQtyDomain qtyDomain = qtyList.get(j);
    			JSONObject json_qty_obj = new JSONObject();
    			json_qty_obj.put("orderDate", qtyDomain.getOrderDate());
    			json_qty_obj.put("orderQty", qtyDomain.getOrderQty());
    			json_qty_arr.add(json_qty_obj);
    		}
    		
    		json_obj.put("qtyList", json_qty_arr.toString());*/
    		
    		
    		json_arr.add(json_obj);
    		
    	}
    	
    	return json_arr.toString().replace("\\", "");
    }
    
    
    //도메인 리스트를 json으로 변환하여 반환
    private String orderDomainListToJsonString(List<OrderDomain> domainList) throws IOException, SQLException, Exception{
    	
    	JSONArray json_arr = new JSONArray();
    	
    	List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
    	
    	for(int i=0; i<domainList.size() ; i++){
    		Map<String, Object> domainMap = UxisObjectUtil.convertObjectToMap(domainList.get(i));
    		
    		mapList.add(domainMap);
    		
    	}
    	
    	for(Map<String, Object> map : mapList){
    		JSONObject json_obj = new JSONObject();
    		for(Map.Entry<String, Object> entry : map.entrySet()){
    			String key = entry.getKey();
    			Object value = entry.getValue();
    			if(!"qtyList".equals(key) && !"titleList".equals(key) && !"sucList".equals(key)  && !"failList".equals(key)  ){
    				json_obj.put(key, value);
    			}
    			
    			if("qtyList".equals(key)){
    				System.out.println(value);
    				
    				
    			}
    			
    		}
    		
    		json_arr.add(json_obj);
    	}
    	
    	System.out.println(json_arr.toString());
    	
    	return json_arr.toString().replace("\\", "");
    }
    
    
 private String getWinusData(String urlStr, String paramStr) throws IOException{
    	
    	String resultStr = "";
    	if(urlStr == null || !"".equals(urlStr)){
    		URL url = new URL(urlStr);
        	
        	HttpURLConnection con = (HttpURLConnection) url.openConnection();
        	
        	con.setDoInput(true);
        	con.setDoOutput(true);
        	con.setUseCaches(false);
        	con.setReadTimeout(200000);
        	con.setRequestMethod("GET");
        	
        	OutputStream out = con.getOutputStream();
        	
        	
        	Writer writer = new OutputStreamWriter(out);
        	writer.write(paramStr);
        	writer.flush();
        	
        	StringBuffer sb = new StringBuffer();
        	
        	BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        	
        	for(;;){
        		String line = br.readLine();
        		if(line == null)break;
        		//System.out.println(line);
        		sb.append(line + "\n");
        	}
        	
        	
        	br.close();
        	con.disconnect();
        	
        	resultStr = sb.toString();
    		
    	}
    	
    	return resultStr;
    }
}
