package com.globaldenso.dnkr.presentation.controller.ajax;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.BkmkService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.OrderService;
import com.globaldenso.dnkr.business.service.SheetService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.BkmkDomain;
import com.globaldenso.dnkr.domain.MenuDomain;
import com.globaldenso.dnkr.domain.OrderDomain;
import com.globaldenso.dnkr.domain.OrderQtyDomain;
import com.globaldenso.dnkr.domain.SheetDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisNumberUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;

/**
 * [KO] 공통코드의  ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing of common code (WAF001).<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxSheet")
public class AjaxSheetController {

    
    /**
     * [KR] 과부족시트서비스 <br>     
     */
    @Autowired
    private SheetService sheetService;
    
    /**
     * [KR] 과부족시트서비스 <br>     
     */
    @Autowired
    private OrderService orderService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxSheetController() {
        // no process
    }
    
    
    /**
     * [KO] 주 처리과정.<br>
     * [KO] winus 데이터 수정.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] BookMark to DB information you have modified the screen.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest 
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/getWinusData", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAM002")
    public void getWinusData(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /**
         * <pre>
         * 1.[KO] winus 데이터 수정 처리.
         *   [KO]   winus 데이터로 수정한다.
         * 1.[EN] Sheet update process.
         *   [EN]   I update an BookMark with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */
        JSONObject jsonObj = new JSONObject();

        String searchDate = ServletRequestUtils.getStringParameter(request, "searchDate");
        
        /*String type = ServletRequestUtils.getStringParameter(request, "type");
        String login_id = ServletRequestUtils.getStringParameter(request, "login_id");
        String password = ServletRequestUtils.getStringParameter(request, "password");
        String lc_id = ServletRequestUtils.getStringParameter(request, "lc_id");
        String cust_cd = ServletRequestUtils.getStringParameter(request, "cust_cd");
        
        String time_to = ServletRequestUtils.getStringParameter(request, "time_to");
        String ritem_id = ServletRequestUtils.getStringParameter(request, "ritem_id");
        int result = 0;
        String resultStr ="";*/
        
        JSONArray columns_arr = new JSONArray();
        JSONObject columns_obj = new JSONObject();
        JSONArray json_arr = new JSONArray();
        List<OrderDomain> orderList = new ArrayList<OrderDomain>();
    	
        try{
        	org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        	
        	String urlStr = "";
        	String paramStr = "";
        	
        	OrderDomain domain = new OrderDomain();
        	domain.setStockFlag("0010");
        	domain.setSearchDate(searchDate);
            orderList = orderService.searchByCondition(domain);
            
            
            //타이틀 세팅
            
            JSONArray arr = new JSONArray();
            JSONObject obj = new JSONObject();
            JSONArray arr2 = new JSONArray();
            JSONObject obj2 = new JSONObject();
            
            columns_obj.put("label", searchDate);
            columns_obj.put("align", "right");
            
            obj.put("label", "CUSTOMER");
            obj.put("key", "mode");
            obj.put("width", 80);
            arr.add(obj);
            
            obj = new JSONObject();
            obj.put("label", "ALC");
            obj.put("key", "alc");
            obj.put("width", 80);
            arr.add(obj);
            
            obj = new JSONObject();
            obj.put("label", "CUSTOMER P/N");
            obj.put("key", "customer");
            obj.put("width", 100);
            arr.add(obj);
            
            obj = new JSONObject();
            obj.put("label", "DENSO P/N");
            obj.put("key", "pn");
            obj.put("width", 100);
            arr.add(obj);
            
            obj = new JSONObject();
            obj.put("label", "MATERIAL DESC");
            obj.put("key", "materialDesc");
            obj.put("width", 150);
            arr.add(obj);
            
            obj = new JSONObject();
            obj.put("label", "KR STOCK");
            obj.put("key", "densoStock");
            obj.put("width", 100);
            arr.add(obj);
            
            obj = new JSONObject();
            obj.put("label", "US STOCK");
            obj.put("key", "stock");
            obj.put("width", 100);
            arr.add(obj);
            
            columns_obj.put("columns", arr);
            columns_arr.add(columns_obj);
            
            columns_obj = new JSONObject();
            arr = new JSONArray();
            obj = new JSONObject();
            
            columns_obj.put("label", "");
            columns_obj.put("key", "Delevery");
            columns_obj.put("align", "center");
            columns_obj.put("width", 80);
            
            obj2.put("label", "");
            obj2.put("key", "Shortage");
            obj2.put("align", "center");
            obj2.put("width", 80);
            arr2.add(obj2);
            
            obj.put("label", "");
            obj.put("key", "receiving");
            obj.put("align", "center");
            obj.put("width", 80);
            obj.put("columns", arr2);
            arr.add(obj);
            
            columns_obj.put("columns", arr);
            columns_arr.add(columns_obj);
            
            if(orderList != null && orderList.size() > 0){
            	
            	for(int i = 0; i < orderList.size(); i++){
            		JSONObject json_obj = new JSONObject();
            		
                	OrderDomain orderDomain = orderList.get(i);
                	String orderKey = orderDomain.getOrderKey();
                	String meterialNumber = orderDomain.getMeterialNumber();
                	String densoNumber = orderDomain.getDensoNumber();
                	String alc = orderDomain.getAlc();
                	String customerNumber = orderDomain.getCustomerNumber();
                	String materialDesc = orderDomain.getMaterialDesc();
                	String densoStockQty = orderDomain.getDensoStockQty();
                	
                	
                	String totalStockQty = orderDomain.getTotalStockQty();
                	int totalStockQtyNum = 0;
                	if(totalStockQty != null && !"".equals(totalStockQty)){
                		totalStockQtyNum = UxisNumberUtil.nullConvertToInt(totalStockQty);
            		}
                	
                	OrderQtyDomain qtyDomain = new OrderQtyDomain();
                	qtyDomain.setOrderKey(orderKey);
                	qtyDomain.setSearchDate(searchDate);
                	
                	List<OrderQtyDomain> qtyList = orderService.searchByQtyCondition(qtyDomain);
                	json_obj.put("mode", customerNumber);
                	json_obj.put("materialDesc", materialDesc);
            		json_obj.put("alc", alc);
            		json_obj.put("customer", meterialNumber);
            		json_obj.put("pn", densoNumber);
            		json_obj.put("densoStock", densoStockQty);
            		json_obj.put("stock", totalStockQty);
            		json_obj.put("Delevery", "Delevery");
            		json_obj.put("receiving", "receiving");
            		json_obj.put("Shortage", "Shortage");
                	
            		if(qtyList.size() > 0){
            			int weekCnt = 0;
                    	int lastWeekCnt = 0;
                    	String startDate = qtyList.get(0).getOrderDate();
                    	String endDate = qtyList.get(qtyList.size() - 1).getOrderDate();
                    	weekCnt = UxisNumberUtil.nullConvertToInt(UxisStringUtil.getWeekOfYear(startDate));
                    	lastWeekCnt = UxisNumberUtil.nullConvertToInt(UxisStringUtil.getWeekOfYear(endDate));
                		
                		int cnt = 0;
                    	for(int j=weekCnt ; j<=lastWeekCnt; j++){
                    		
                    		String orderDate = "";
                    		String orderQty = "";
                    		String stockQty = "";
                    		
                    		for(int k=0; k < qtyList.size() ; k++){
                    			OrderQtyDomain tempDomain = qtyList.get(k);
                        		String orderDateTmp = tempDomain.getOrderDate();
                        		String orderQtyTmp = tempDomain.getOrderQty();
                        		String stockQtyTmp = tempDomain.getStockQty();
                        		String tmpWeek = UxisStringUtil.getWeekOfYear(orderDateTmp);
                        		
                        		if(tmpWeek.equals(UxisStringUtil.isNullToString(j))){
                        			orderDate = orderDateTmp;
                        			orderQty = orderQtyTmp;
                        			stockQty = stockQtyTmp;
                        		}
                    		}
                    		
                    		if("".equals(orderDate)){
                    			
                    			Calendar cal = Calendar.getInstance();
                    	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    	        Date date = sdf.parse(startDate);
                    	        cal.setTime(date);
                    	        cal.add(Calendar.WEEK_OF_MONTH, j - weekCnt);
                    	        
                    	        orderDate = sdf.format(cal.getTime());
                    			orderQty = "0";
                    			stockQty = "0";
                    			
                    			//System.out.println("orderDate  null  : " + orderDate);
                    		}
                    		
                    		int orderQtyNum = 0;
                    		int stockQtyNum = 0;
                    		
                    		if(i == 0){
                    			columns_obj = new JSONObject();
                                arr = new JSONArray();
                                obj = new JSONObject();
                                arr2 = new JSONArray();
                                obj2 = new JSONObject();
                                
                                obj2.put("label", orderDate.substring(5, 10));
                                obj2.put("key", "w" + j + "s");
                                obj2.put("align", "center");
                                obj2.put("width", 70);
                                obj.put("styleClass", "styleClass");
                                arr2.add(obj2);
                                
                                obj.put("label", "W + " + UxisStringUtil.getWeekOfYear(orderDate));
                                obj.put("key", "w" + j + "r");
                                obj.put("align", "center");
                                obj.put("width", 80);
                                obj.put("columns", arr2);
                                arr.add(obj);
                                
                                columns_obj.put("label", "");
                                columns_obj.put("key", "w" + j + "d");
                                columns_obj.put("align", "center");
                                columns_obj.put("width", 80);
                                columns_obj.put("columns", arr);
                                columns_arr.add(columns_obj);
                    		}
                    		
                            
                    		if(orderQty != null && !"".equals(orderQty)){
                    			orderQtyNum = UxisNumberUtil.nullConvertToInt(orderQty);
                    		}
                    		
                    		if(stockQty != null && !"".equals(stockQty)){
                    			stockQtyNum = UxisNumberUtil.nullConvertToInt(stockQty);
                    		}
                    		
                    		
                    		json_obj.put("w" + j + "d", orderQtyNum);
                    		json_obj.put("w" + j + "r", stockQtyNum);
                    		json_obj.put("w" + j + "s", totalStockQtyNum + stockQtyNum - orderQtyNum );
                    		
                    		totalStockQtyNum = totalStockQtyNum + stockQtyNum - orderQtyNum;
                    	}
            		}
            		
                	
                	json_arr.add(json_obj);
                	
                }
            /*
            if(orderList != null && orderList.size() > 0){
            	
            	int weekCnt = 0;
            	int lastWeekCnt = 0;
            	String startDate = orderList.get(0).getQtyList().get(0).getOrderDate();
            	int rastRow = orderList.get(0).getQtyList().size();
            	String endDate = orderList.get(0).getQtyList().get(rastRow).getOrderDate();
            	weekCnt = UxisNumberUtil.nullConvertToInt(UxisStringUtil.getWeekOfYear(startDate));
            	lastWeekCnt = UxisNumberUtil.nullConvertToInt(UxisStringUtil.getWeekOfYear(endDate));
            	
            	
            	
            	for(int i=0; i<orderList.size();i++){
            		JSONObject json_obj = new JSONObject();
            		
                	OrderDomain orderDomain = orderList.get(i);
                	String orderKey = orderDomain.getOrderKey();
                	String meterialNumber = orderDomain.getMeterialNumber();
                	String densoNumber = orderDomain.getDensoNumber();
                	String totalStockQty = orderDomain.getTotalStockQty();
                	int totalStockQtyNum = 0;
                	if(totalStockQty != null && !"".equals(totalStockQty)){
                		totalStockQtyNum = UxisNumberUtil.nullConvertToInt(totalStockQty);
            		}
                	
                	OrderQtyDomain qtyDomain = new OrderQtyDomain();
                	qtyDomain.setOrderKey(orderKey);
                	qtyDomain.setSearchDate(searchDate);
                	
                	List<OrderQtyDomain> qtyList = orderService.searchByQtyCondition(qtyDomain);
                	json_obj.put("mode", "TMA");
            		json_obj.put("alc", "E010");
            		json_obj.put("customer", meterialNumber);
            		json_obj.put("pn", densoNumber);
            		json_obj.put("opt", "STD");
            		json_obj.put("stock", totalStockQty);
            		json_obj.put("Delevery", "Delevery");
            		json_obj.put("receiving", "receiving");
            		json_obj.put("Shortage", "Shortage");
                	
            		
                	for(int j=0 ; j<qtyList.size(); j++){
                		
                		OrderQtyDomain tempDomain = qtyList.get(j);
                		String orderDate = tempDomain.getOrderDate();
                		String orderQty = tempDomain.getOrderQty();
                		String stockQty = tempDomain.getStockQty();
                		
                		int orderQtyNum = 0;
                		int stockQtyNum = 0;
                		
                		if(i == 0){
                			columns_obj = new JSONObject();
                            arr = new JSONArray();
                            obj = new JSONObject();
                            arr2 = new JSONArray();
                            obj2 = new JSONObject();
                            
                            obj2.put("label", orderDate.substring(5, 10));
                            obj2.put("key", "w" + j + "s");
                            obj2.put("align", "center");
                            obj2.put("width", 70);
                            arr2.add(obj2);
                            
                            obj.put("label", "W + " + UxisStringUtil.getWeekOfYear(orderDate));
                            obj.put("key", "w" + j + "r");
                            obj.put("align", "center");
                            obj.put("width", 80);
                            obj.put("columns", arr2);
                            arr.add(obj);
                            
                            columns_obj.put("label", "");
                            columns_obj.put("key", "w" + j + "d");
                            columns_obj.put("align", "center");
                            columns_obj.put("width", 80);
                            columns_obj.put("columns", arr);
                            columns_arr.add(columns_obj);
                		}
                		
                        
                		if(orderQty != null && !"".equals(orderQty)){
                			orderQtyNum = UxisNumberUtil.nullConvertToInt(orderQty);
                		}
                		
                		if(stockQty != null && !"".equals(stockQty)){
                			stockQtyNum = UxisNumberUtil.nullConvertToInt(stockQty);
                		}
                		
                		
                		json_obj.put("w" + j+ "d", orderQtyNum);
                		json_obj.put("w" + j+ "r", stockQtyNum);
                		json_obj.put("w" + j+ "s", totalStockQtyNum + stockQtyNum - orderQtyNum );
                		
                		
                		totalStockQtyNum = totalStockQtyNum + stockQtyNum - orderQtyNum;
                	}
                	
                	json_arr.add(json_obj);
                	
                }*/
            	
            }
            
            
    		
        }catch (Exception e){
        	e.printStackTrace();
        }
        
        //System.out.println("columns_arr : " + columns_arr);
        //System.out.println("json_arr : " + json_arr);
        jsonObj.put("cnt", orderList.size());
        jsonObj.put("columns_arr", columns_arr);
        jsonObj.put("data", json_arr);
        response.getWriter().print(jsonObj);
        return;
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
        	
        	//Socket con = new Socket(url.getHost(), 80);
        	
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
    
    /**
     * [KO] 주 처리과정.<br>
     * [KO] winus 데이터 수정.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] BookMark to DB information you have modified the screen.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest 
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAM002")
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /**
         * <pre>
         * 1.[KO] winus 데이터 수정 처리.
         *   [KO]   winus 데이터로 수정한다.
         * 1.[EN] Sheet update process.
         *   [EN]   I update an BookMark with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */
        JSONObject jsonObj = new JSONObject();

        String jsonDataStr = ServletRequestUtils.getStringParameter(request, "resultData");
        int result = 0;
        
        try{
        	org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        	
        	JSONObject obj = (JSONObject) jsonParser.parse(jsonDataStr);
        	JSONArray objArr = (JSONArray) obj.get("DATA");
        	
        	SheetDomain delDomain = new SheetDomain();
        	sheetService.delete(delDomain);
        	
        	for(int i=0 ; i < objArr.size(); i++){
        		
        		JSONObject tempObj = (JSONObject) objArr.get(i);
        		SheetDomain domain = new SheetDomain();
        		domain.setAsQty(UxisStringUtil.isNullToString(tempObj.get("as_qty")));
        		domain.setBeforeStockQty(UxisStringUtil.isNullToString(tempObj.get("before_stock_qty")));
        		domain.setBadQty(UxisStringUtil.isNullToString(tempObj.get("bad_qty")));
        		domain.setBlNo(UxisStringUtil.isNullToString(tempObj.get("bl_no")));
        		domain.setCustCd(UxisStringUtil.isNullToString(tempObj.get("cust_cd")));
        		domain.setCustLotNo(UxisStringUtil.isNullToString(tempObj.get("cust_lot_no")));
        		domain.setCustNm(UxisStringUtil.isNullToString(tempObj.get("cust_nm")));
        		domain.setInQty(UxisStringUtil.isNullToString(tempObj.get("in_qty")));
        		domain.setItemBestDateEnd(UxisStringUtil.isNullToString(tempObj.get("item_best_date_end")));
        		domain.setItemGrpNm(UxisStringUtil.isNullToString(tempObj.get("item_grp_nm")));
        		domain.setLocCd(UxisStringUtil.isNullToString(tempObj.get("loc_cd")));
        		domain.setMakeDt(UxisStringUtil.isNullToString(tempObj.get("make_dt")));
        		domain.setOutQty(UxisStringUtil.isNullToString(tempObj.get("out_qty")));
        		domain.setPropChk(UxisStringUtil.isNullToString(tempObj.get("prop_chk")));
        		domain.setPropQty(UxisStringUtil.isNullToString(tempObj.get("prop_qty")));
        		domain.setRealPltQty(UxisStringUtil.isNullToString(tempObj.get("real_plt_qty")));
        		domain.setRitemId(UxisStringUtil.isNullToString(tempObj.get("ritem_id")));
        		domain.setRitemCd(UxisStringUtil.isNullToString(tempObj.get("ritem_cd")));
        		domain.setRitemNm(UxisStringUtil.isNullToString(tempObj.get("ritem_nm")));
        		domain.setStockQty(UxisStringUtil.isNullToString(tempObj.get("stock_qty")));
        		domain.setStockWeight(UxisStringUtil.isNullToString(tempObj.get("stock_weight")));
        		domain.setUomNm(UxisStringUtil.isNullToString(tempObj.get("uom_nm")));
        		domain.setWhNm(UxisStringUtil.isNullToString(tempObj.get("wh_nm")));
        		domain.setInDt(UxisStringUtil.isNullToString(tempObj.get("in_dt")));
        		//System.out.println(i + " 번째  ritem_id : " + tempObj.get("ritem_id") + "  cust_nm : " + tempObj.get("cust_nm"));
        		sheetService.create(domain);
        		
        		result++;
        	}
        
        }catch (Exception e){
        	e.printStackTrace();
        }
        
        
        jsonObj.put("result", result);
        response.getWriter().print(jsonObj);
        return;
    }
    
}
