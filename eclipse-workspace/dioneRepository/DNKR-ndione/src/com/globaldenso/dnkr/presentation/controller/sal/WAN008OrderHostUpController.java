package com.globaldenso.dnkr.presentation.controller.sal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.OrderHostUpService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.domain.OrderHostUpDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisExcelFileUtil;
import com.globaldenso.dnkr.uxis.UxisFileMngUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;
import com.google.gson.Gson;

/**
 * [KR] 서열형 HOST UP 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN008OrderHostUp")
@ViewId(value = "WAN008")
public class WAN008OrderHostUpController {
    /**
     * [KR] 서열형 HOST UP 서비스 <br>     
     */
    @Autowired
    private OrderHostUpService orderHostUpService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN008OrderHostUpController() {
        // no process
    }
        
    
    private String[] excelRowP6 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
    		                       "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
    		                       "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", 
    		                       "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", 
    		                       "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", 
    		                       "AY", "AZ", "BA", "BB", "BC", "BD", "BE", "BF", "BG", "BH", 
    		                       "BI", "BJ", "BK", "BL", "BM", "BN", "BO", "BP", "BQ", "BR", 
    		                       "BS", "BT", "BU", "BV", "BW"};
    
    private String[] excelRowP7 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                                   "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
                                   "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", 
                                   "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL"};
    
	List sList = new ArrayList(); //정상 dataset return
	List fList = new ArrayList(); //error dataset return
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAM008")
    public ModelAndView init(HttpServletRequest request)  throws Exception {
        ModelAndView mv = new ModelAndView();

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        UxisCmmUtil.getSessionComCode(request, mv);
        
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        mv.addObject("comps", getComps); 
        
        String getSelchk = ServletRequestUtils.getStringParameter(request, "getSelchk");
        mv.addObject("selChk", getSelchk);
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "OrderHostUp.jsp");
        mv.setViewName(".tiles.page.WAN008");
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
    @ErrorBack(viewName = "forward:/WAN008OrderHostUp/init.do")
    public ModelAndView procExcelUpload(HttpServletRequest request, 
        HttpServletResponse response, 
        MultipartHttpServletRequest multiRequest) throws Exception{
        
        System.out.println("-------------------------------------------------");
        String result = "";
        String fileName = "";   //파일명을 담을 변수 선언
        UxisExcelFileUtil efUtil = new UxisExcelFileUtil();
        OrderHostUpDomain domain = new OrderHostUpDomain();
        
        String getSelchk = ServletRequestUtils.getStringParameter(request, "getSelchk");
        
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        domain.setComps(getComps);       

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
    	
        domain.setLib1(empInfo.getLib1());
        domain.setLib2(empInfo.getLib2());
        
        System.out.println("* 사업부 : " + domain.getComps());
        System.out.println("* LIB1 : " + domain.getLib1());
        System.out.println("* LIB2 : " + domain.getLib2());

        /** 파일 업로드 처리 **/
        //파일 업로드 처리를 하고 그 결과 내용을 받는다.
        String uploadResult = efUtil.uploadFileData(multiRequest.getFileMap(), "csv", new UxisFileMngUtil());
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
                        
                        fileName = csvToXLSX(fileName);
                    }else{
                        //return UxisCmmUtil.jsonMessage(splitStr[1],"N");          //실패일 경우 처리실패로 메세지를 담아서 json형태의 값을 리턴한다.
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
		//List sList = new ArrayList(); //정상 dataset return
		//List fList = new ArrayList(); //error dataset return
        sList.clear();
        fList.clear();
		
        /** 액셀 내용 읽기 및 데이터 등록 **/
        //파일명 값이 있을 경우 업로드 된 액셀내용을 읽어서 데이터 등록/수정 처리를 한다.
        if(!UxisStringUtil.isEmpty(fileName)){
            System.out.println("=================Excel Data===============");
            System.out.println(fileName);
            //fileName의 엑셀 파일을 읽어서 변수에 데이터를 담는다.
            List<Map<String, String>> excelData = efUtil.getExcelData(fileName, "order");
            //System.out.println("=================Excel Data===============");
            //System.out.println(excelData);
            //System.out.println("=================Excel Data===============");
                        
            //엑셀데이터가 없을 경우 오류 처리 
            if(excelData == null || excelData.size() <= 0){            	
            	 result = "첨부파일이 잘못되었습니다.";
            }else{
	            System.out.println("start excelDataProcess -----> " + getSelchk + " : " + excelData.get(0).size());
	            
	            boolean excelCheckYn = true;
	            if(getSelchk.equals("P6")) {
	            	System.out.println("excelRowP6.length -----> " + excelRowP6.length);
	            	if(excelRowP6.length != excelData.get(0).size()) excelCheckYn = false;
	            }
	            else if(getSelchk.equals("P7")) {
	            	System.out.println("excelRowP7.length -----> " + excelRowP7.length);
	            	if(excelRowP7.length != excelData.get(0).size()) excelCheckYn = false;
	            }
	            
	            if(!excelCheckYn) {
	            	result = "해당 서열의 첨부파일인지 확인해주세요.";
	            }else {
	            
		            // 집계를 위한 이전 TEMP 자료 삭제
		            if(getSelchk.equals("P6")) {
		            	int countSVH310PF_Temp = orderHostUpService.countSVH310PF_Temp(domain);
		            	
		            	if(countSVH310PF_Temp > 0) orderHostUpService.deleteSVH310PF_Temp(domain);
		            }
		            else if(getSelchk.equals("P7")) {
		            	int countSVH320PF_Temp = orderHostUpService.countSVH320PF_Temp(domain);
		            	
		            	if(countSVH320PF_Temp > 0) orderHostUpService.deleteSVH320PF_Temp(domain);
		            }
		            
		            
		            int excelCnt = 0;
		            
		            try {
			            for(Map<String, String> tempMap : excelData){
			            	if(getSelchk.equals("P6")) getDataP6(tempMap, domain);
			            	else if(getSelchk.equals("P7")) getDataP7(tempMap, domain);
			            	
			            	//if(domain.getSucList() != null) sList.add(domain.getSucList());
			            	//if(domain.getFailList() != null) fList.add(domain.getFailList());
			            	
			            	excelCnt++;
			            }        
			       
			            System.out.println("excelDataProcess > excelCnt : " + excelCnt + " sucCount : " + sList.size() + "  failCnt : " + fList.size());
		            
		            
			            // 정상건에 대해 거래처,품번별 집계
			            if(sList.size() > 0) {	            
				            if(getSelchk.equals("P6")) {	            	
				                //TEMP data
				            	List<? extends OrderHostUpDomain> tempList = orderHostUpService.selectSVH310PF_Temp(domain);
				            	
				            	//공장코드별 삭제
				            	int countSVH310PF1 = orderHostUpService.countSVH310PF1(domain);
				            	if(countSVH310PF1 > 0) orderHostUpService.deleteSVH310PF(domain);	
				            	
				            	//거래처,품번별 집계
				            	for (int i=0; i< tempList.size(); i++) {
				            		OrderHostUpDomain tempDomain = (OrderHostUpDomain) tempList.get(i);
				            		tempDomain.setLib1(domain.getLib1());
				            		tempDomain.setLib2(domain.getLib2());
				            					            		
				            		Boolean checkIns = true;
				            		if((tempList.size()-1) == i) checkIns = true;
				            		else {
					            		OrderHostUpDomain tempDomain1 = (OrderHostUpDomain) tempList.get(i+1);
					            		if(tempDomain.getComps() != tempDomain1.getComps() ||
					            		   tempDomain.getPyvnd() != tempDomain1.getPyvnd() ||
					            		   tempDomain.getPspno() != tempDomain1.getPspno()) {
					            			checkIns = true;
					            		}
					            		else checkIns = false;
				            		}
				            		
				            		if(checkIns) {
				            			OrderHostUpDomain selTempSumDomain = new OrderHostUpDomain();
				            			selTempSumDomain.setComps(tempDomain.getComps());
				            			selTempSumDomain.setPyvnd(tempDomain.getPyvnd());
				            			selTempSumDomain.setPspno(tempDomain.getPspno());
				            			selTempSumDomain.setLib1(domain.getLib1());
				            			selTempSumDomain.setLib2(domain.getLib2());							
				            	        OrderHostUpDomain getTempSum = orderHostUpService.selectSVH310PF_TempSum(selTempSumDomain);
				            	        
				            			tempDomain.setTrimd(getTempSum.getTrimd());			            			
										tempDomain.setPbsqy(getTempSum.getPbsqy());
										tempDomain.setPatqy(getTempSum.getPatqy());
										tempDomain.setWbsqy(getTempSum.getWbsqy());
										tempDomain.setD0t01(getTempSum.getD0t01());
										tempDomain.setD0t02(getTempSum.getD0t02());
										tempDomain.setD0t03(getTempSum.getD0t03());
										tempDomain.setD0t04(getTempSum.getD0t04());
										tempDomain.setD0t05(getTempSum.getD0t05());
										tempDomain.setD0t06(getTempSum.getD0t06());
										tempDomain.setD0t07(getTempSum.getD0t07());
										tempDomain.setD0t08(getTempSum.getD0t08());
										tempDomain.setD0t09(getTempSum.getD0t09());
										tempDomain.setD0t10(getTempSum.getD0t10());
										tempDomain.setD0tqy(getTempSum.getD0tqy());
										tempDomain.setD1t01(getTempSum.getD1t01());
										tempDomain.setD1t02(getTempSum.getD1t02());
										tempDomain.setD1t03(getTempSum.getD1t03());
										tempDomain.setD1t04(getTempSum.getD1t04());
										tempDomain.setD1t05(getTempSum.getD1t05());
										tempDomain.setD1t06(getTempSum.getD1t06());
										tempDomain.setD1t07(getTempSum.getD1t07());
										tempDomain.setD1t08(getTempSum.getD1t08());
										tempDomain.setD1t09(getTempSum.getD1t09());
										tempDomain.setD1t10(getTempSum.getD1t10());
										tempDomain.setD1tqy(getTempSum.getD1tqy());
										tempDomain.setD2t01(getTempSum.getD2t01());
										tempDomain.setD2t02(getTempSum.getD2t02());
										tempDomain.setD2t03(getTempSum.getD2t03());
										tempDomain.setD2t04(getTempSum.getD2t04());
										tempDomain.setD2t05(getTempSum.getD2t05());
										tempDomain.setD2t06(getTempSum.getD2t06());
										tempDomain.setD2t07(getTempSum.getD2t07());
										tempDomain.setD2t08(getTempSum.getD2t08());
										tempDomain.setD2t09(getTempSum.getD2t09());
										tempDomain.setD2t10(getTempSum.getD2t10());
										tempDomain.setD2tqy(getTempSum.getD2tqy());
										tempDomain.setD3t01(getTempSum.getD3t01());
										tempDomain.setD3t02(getTempSum.getD3t02());
										tempDomain.setD3t03(getTempSum.getD3t03());
										tempDomain.setD3t04(getTempSum.getD3t04());
										tempDomain.setD3t05(getTempSum.getD3t05());
										tempDomain.setD3t06(getTempSum.getD3t06());
										tempDomain.setD3t07(getTempSum.getD3t07());
										tempDomain.setD3t08(getTempSum.getD3t08());
										tempDomain.setD3t09(getTempSum.getD3t09());
										tempDomain.setD3t10(getTempSum.getD3t10());
										tempDomain.setD3tqy(getTempSum.getD3tqy());
										tempDomain.setD4t01(getTempSum.getD4t01());
										tempDomain.setD4t02(getTempSum.getD4t02());
										tempDomain.setD4t03(getTempSum.getD4t03());
										tempDomain.setD4t04(getTempSum.getD4t04());
										tempDomain.setD4t05(getTempSum.getD4t05());
										tempDomain.setD4t06(getTempSum.getD4t06());
										tempDomain.setD4t07(getTempSum.getD4t07());
										tempDomain.setD4t08(getTempSum.getD4t08());
										tempDomain.setD4t09(getTempSum.getD4t09());
										tempDomain.setD4t10(getTempSum.getD4t10());
										tempDomain.setD4tqy(getTempSum.getD4tqy());
										tempDomain.setRemqy(getTempSum.getRemqy());
										tempDomain.setGrtot(getTempSum.getGrtot());
						            	
						            	// data생성
						                int countSVH310PF2 = orderHostUpService.countSVH310PF2(tempDomain);
						                			                
						                if(countSVH310PF2 > 0) {
						                	JSONObject errList = new JSONObject();
						                	
						                	errList.put("ERROR", "중복DATA");
						                	errList.put("pyvnd", tempDomain.getPyvnd()); //거래처코드 
						                	errList.put("pspno", tempDomain.getPspno()); //풍성품번 
						                	errList.put("dmkcr", tempDomain.getDmkcr()); //차종코드
						                	errList.put("dsecd", tempDomain.getDsecd()); //서열코드
						                	errList.put("dseno", tempDomain.getDseno()); //대표서열번호 (CODE SERAIL)) 
						                	errList.put("dfacd", tempDomain.getDfacd()); //대표공장(공장구분) 
						    							                	
						                	//fList.add(errList);
						                }
						                else orderHostUpService.createSVH310PF(tempDomain);
				            		}
				            	}
				                
				                //업체부품구성마스터에의한 구성품번 추가
				                ////orderHostUpService.createSVH310PF_ADD(domain);
				            }
				            else if(getSelchk.equals("P7")) {
				            	//data생성
				            	List<? extends OrderHostUpDomain> tempList = orderHostUpService.selectSVH320PF_Temp(domain);
				            	
				            	//공장코드별 삭제
				            	int countSVH320PF1 = orderHostUpService.countSVH320PF1(domain);
				            	if(countSVH320PF1 > 0) orderHostUpService.deleteSVH320PF(domain);
				            	
				            	for (int i=0; i< tempList.size(); i++) {
				            		OrderHostUpDomain tempDomain = (OrderHostUpDomain) tempList.get(i);
				            		tempDomain.setLib1(domain.getLib1());
				            		tempDomain.setLib2(domain.getLib2());
				            		
				            		//거래처,품번별 집계
				            		Boolean checkIns = true;
				            		if((tempList.size()-1) == i) checkIns = true;
				            		else {
					            		OrderHostUpDomain tempDomain1 = (OrderHostUpDomain) tempList.get(i+1);
					            		if(tempDomain.getComps() != tempDomain1.getComps() ||
					            		   tempDomain.getPyvnd() != tempDomain1.getPyvnd() ||
					            		   tempDomain.getPspno() != tempDomain1.getPspno()) {
					            			checkIns = true;
					            		}
					            		else checkIns = false;
				            		}
				            		
				            		if(checkIns) {			            						            			
				            			OrderHostUpDomain selTempSumDomain = new OrderHostUpDomain();
				            			selTempSumDomain.setComps(tempDomain.getComps());
				            			selTempSumDomain.setPyvnd(tempDomain.getPyvnd());
				            			selTempSumDomain.setPspno(tempDomain.getPspno());
				            			selTempSumDomain.setLib1(domain.getLib1());
				            			selTempSumDomain.setLib2(domain.getLib2());							
				            	        OrderHostUpDomain getTempSum = orderHostUpService.selectSVH320PF_TempSum(selTempSumDomain);
				            	        
										tempDomain.setTrimd(getTempSum.getTrimd());
										tempDomain.setPbsqy(getTempSum.getPbsqy());
										tempDomain.setPatqy(getTempSum.getPatqy());					
										tempDomain.setWbsqy(getTempSum.getWbsqy());					
										tempDomain.setDat00(getTempSum.getDat00());
										tempDomain.setDat01(getTempSum.getDat01());
										tempDomain.setDat02(getTempSum.getDat02());
										tempDomain.setDat03(getTempSum.getDat03());
										tempDomain.setDat04(getTempSum.getDat04());
										tempDomain.setDat05(getTempSum.getDat05());
										tempDomain.setDat06(getTempSum.getDat06());
										tempDomain.setDat07(getTempSum.getDat07());
										tempDomain.setDat08(getTempSum.getDat08());
										tempDomain.setDat09(getTempSum.getDat09());
										tempDomain.setDat10(getTempSum.getDat10());
										tempDomain.setDat11(getTempSum.getDat11());
										tempDomain.setDat12(getTempSum.getDat12());
										tempDomain.setRemqy(getTempSum.getRemqy());
										tempDomain.setOkqty(getTempSum.getOkqty());
										tempDomain.setMitqy(getTempSum.getMitqy());
										tempDomain.setPrseq(getTempSum.getPrseq());
										tempDomain.setMiqqy(getTempSum.getMiqqy());
										tempDomain.setMioqy(getTempSum.getMioqy());
										tempDomain.setGrtot(getTempSum.getGrtot());
						            	
						            	// data생성
						                int countSVH320PF2 = orderHostUpService.countSVH320PF2(tempDomain);
						                
						                if(countSVH320PF2 > 0) {        	 
						                	JSONObject errList = new JSONObject();
						                	
						                	errList.put("ERROR", "중복DATA");
						                	errList.put("pyvnd", tempDomain.getPyvnd()); //거래처코드 
						                	errList.put("pspno", tempDomain.getPspno()); //풍성품번 
						                	errList.put("dmkcr", tempDomain.getDmkcr()); //차종코드
						                	errList.put("dsecd", tempDomain.getDsecd()); //서열코드
						                	errList.put("dseno", tempDomain.getDseno()); //대표서열번호 (CODE SERAIL)) 
						                	errList.put("dfacd", tempDomain.getDfacd()); //대표공장(공장구분) 
						    				
						                	//fList.add(errList);
						                }
						                else orderHostUpService.createSVH320PF(tempDomain);
				            		}
				            	}           	
				            	
				                //업체부품구성마스터에의한 구성품번 추가
				                ////orderHostUpService.createSVH320PF_ADD(domain);
				            }
			            }
			            
			            result = "업로드 성공하였습니다.(총:" + excelCnt + ", 정상:" + sList.size() + ", ERROR:" + fList.size();
			            
		            }catch(Exception e){
		            	e.printStackTrace();

		            	result = "업로드 파일 데이터를 확인해 주세요. : " + (excelCnt+1) + "행"+ "\\r\\n(※서버메시지:" + e.getMessage()+")";
		            	System.out.println("서열업로드 에러DATA : " +excelData.get(excelCnt+1));

		            	sList.clear();
		            	fList.clear();		                
		            }			            
	            }
            }

        }else{
            //return UxisCmmUtil.jsonMessage("첨부파일 읽어오기에 실패하였습니다.","N");
        } 

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        ModelAndView mv = new ModelAndView();
        UxisCmmUtil.getSessionComCode(request, mv);
        mv.setViewName(".tiles.page.WAN008");
        mv.addObject("tabId", tabId);
        mv.addObject("result", result);
        mv.addObject("comps", getComps);
        mv.addObject("selChk", getSelchk);
        mv.addObject("sucList", sList);
        mv.addObject("failList", fList);
        return mv;
    }
    
    @RequestMapping(value = "/procExcelImport", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAN008OrderHostUp/init.do")
    public ModelAndView procExcelImport(HttpServletRequest request, 
        HttpServletResponse response, 
        MultipartHttpServletRequest multiRequest) throws Exception{
        
        System.out.println("-------------------------------------------------");
        String result = "";
        String fileName = "";   //파일명을 담을 변수 선언
        UxisExcelFileUtil efUtil = new UxisExcelFileUtil();
        OrderHostUpDomain domain = new OrderHostUpDomain();
        
        // 화면 선택 값
        //사업부
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        domain.setComps(getComps);  
        //서열구분
        String getSelchk = ServletRequestUtils.getStringParameter(request, "getSelchk");
        //공장구분
        String getHmckmcchk = ServletRequestUtils.getStringParameter(request, "getHmckmcchk");

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
    	
        domain.setLib1(empInfo.getLib1());
        domain.setLib2(empInfo.getLib2());  
        
        System.out.println("* 사업부 : " + domain.getComps());
        System.out.println("* LIB1 : " + domain.getLib1());
        System.out.println("* LIB2 : " + domain.getLib2());
        System.out.println("* 서열구분 : " + getSelchk);
        System.out.println("* 공장구분 : " + getHmckmcchk);
        
        /** 파일 업로드 처리 **/
        //파일 업로드 처리를 하고 그 결과 내용을 받는다.
        //업로드 대상 파일 검색 
        //    파일명 : 오늘날짜, 사업부가 E1->P068 or 그외->RONZ, P6 or P7,  HMC or KMC
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String todayDate = format1.format(date);
        File path = new File(UxisCmmUtil.getProperty("vpn.file.path"));
        System.out.println(UxisCmmUtil.getProperty("vpn.file.path"));
        System.out.println(path.length());
        
        //디렉토리 없음
        if (!path.exists()) {
        	result = "파일 경로를 다시 확인 해주시십시오.";
        } else {
        	
        	String todayFileList[] = path.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if(getComps.equals("E1")) {
                    	return name.contains(todayDate + "_00") && name.contains(getSelchk) && name.contains("P068") && name.contains(getHmckmcchk);            // todayDate 포함되는 이름
        	        } else if (getComps != null && !getComps.equals("E1")) {
        	        	return name.contains(todayDate + "_00") && name.contains(getSelchk) && name.contains("RONZ") && name.contains(getHmckmcchk);            // todayDate 포함되는 이름
        	        }
                    return false;            // todayDate 포함되는 이름
                }
            });
        	System.out.println("파일 갯수 :" + todayFileList.length);
            
            if(todayFileList.length > 0) {
            	
            	File f = new File(todayDate + "_" + getSelchk + "_" + getComps + ".csv");
        		BufferedWriter bw = new BufferedWriter(new FileWriter(path + "/" + todayDate + "_" + getSelchk + "_" + getComps + "_" +  getHmckmcchk + ".csv"));
        		
        	    String c;
        		for(int j=0; j < todayFileList.length; j++) {
        			System.out.println("파일명 :" + todayFileList[j]);
        			BufferedReader br = new BufferedReader(new FileReader(path + "/" + todayFileList[j]));
        			while((c=br.readLine()) != null)
        		    {
        		    	bw.write(c);
        		    	bw.write("\n");
        		    }
        		}

        		bw.flush();
        		bw.close();
        		 
        		fileName = path + "/" + todayDate + "_" + getSelchk + "_" + getComps + "_" +  getHmckmcchk + ".csv";
                
                fileName = csvToXLSX(fileName);
            
            } else {

            	result = "오늘 날짜에 해당되는 파일이 존재하지 않습니다.";
            	System.out.println("오늘 날짜에 해당되는 파일이 존재하지 않습니다.");
            
            }
        	
        }

        //List sList = new ArrayList(); //정상 dataset return
		//List fList = new ArrayList(); //error dataset return
        sList.clear();
        fList.clear();	    
		
        /** 액셀 내용 읽기 및 데이터 등록 **/
        //파일명 값이 있을 경우 업로드 된 액셀내용을 읽어서 데이터 등록/수정 처리를 한다.
        if(!UxisStringUtil.isEmpty(fileName)){
            System.out.println("=================Excel Data===============");
            System.out.println(fileName);
            //fileName의 엑셀 파일을 읽어서 변수에 데이터를 담는다.
            List<Map<String, String>> excelData = efUtil.getExcelData(fileName, "order");
            //System.out.println("=================Excel Data===============");
            //System.out.println(excelData);
            //System.out.println("=================Excel Data===============");
                        
            //엑셀데이터가 없을 경우 오류 처리 
            if(excelData == null || excelData.size() <= 0){            	
            	 result = "첨부파일이 잘못되었습니다.";
            }else{
	            System.out.println("start excelDataProcess1 -----> " + getSelchk + " : " + excelData.get(0).size());
	            
	            boolean excelCheckYn = true;
	            if(getSelchk.equals("P6")) {
	            	System.out.println("excelRowP6.length1 -----> " + excelRowP6.length);
	            	if(excelRowP6.length != excelData.get(0).size()) excelCheckYn = false;
	            }
	            else if(getSelchk.equals("P7")) {
	            	System.out.println("excelRowP7.length -----> " + excelRowP7.length);
	            	if(excelRowP7.length != excelData.get(0).size()) excelCheckYn = false;
	            }
	            
	            System.out.println("excelCheckYn -----> " + excelCheckYn);
	            if(!excelCheckYn) {
	            	result = "해당 서열의 첨부파일인지 확인해주세요.";
	            }else {
	            	System.out.println("getSelchk -----> " + getSelchk);
	            	
		            // 집계를 위한 이전 TEMP 자료 삭제
		            if(getSelchk.equals("P6")) {
		            	int countSVH310PF_Temp = orderHostUpService.countSVH310PF_Temp(domain);
		            	
		            	if(countSVH310PF_Temp > 0) orderHostUpService.deleteSVH310PF_Temp(domain);
		            }
		            else if(getSelchk.equals("P7")) {
		            	int countSVH320PF_Temp = orderHostUpService.countSVH320PF_Temp(domain);
		            	
		            	if(countSVH320PF_Temp > 0) orderHostUpService.deleteSVH320PF_Temp(domain);
		            }
		            
		            System.out.println("excelData -----> " + excelData.size());
		            int excelCnt = 0;
		            
		            try {
			            for(Map<String, String> tempMap : excelData){
			            	if(getSelchk.equals("P6")) getDataP6(tempMap, domain);
			            	else if(getSelchk.equals("P7")) getDataP7(tempMap, domain);
			            	
			            	//if(domain.getSucList() != null) sList.add(domain.getSucList());
			            	//if(domain.getFailList() != null) fList.add(domain.getFailList());
			            	
			            	excelCnt++;
			            }        
			            
			            System.out.println("excelDataProcess > excelCnt : " + excelCnt + " sucCount : " + sList.size() + "  failCnt : " + fList.size());
			            
			            
			            // 정상건에 대해 거래처,품번별 집계
			            if(sList.size() > 0) {	            
				            if(getSelchk.equals("P6")) {	            	
				                //TEMP data
				            	List<? extends OrderHostUpDomain> tempList = orderHostUpService.selectSVH310PF_Temp(domain);
				            	
				            	//공장코드별 삭제
				            	int countSVH310PF1 = orderHostUpService.countSVH310PF1(domain);
				            	if(countSVH310PF1 > 0) orderHostUpService.deleteSVH310PF(domain);	
				            	
				            	//거래처,품번별 집계
				            	for (int i=0; i< tempList.size(); i++) {
				            		OrderHostUpDomain tempDomain = (OrderHostUpDomain) tempList.get(i);
				            		tempDomain.setLib1(domain.getLib1());
				            		tempDomain.setLib2(domain.getLib2());
				            					            		
				            		Boolean checkIns = true;
				            		if((tempList.size()-1) == i) checkIns = true;
				            		else {
					            		OrderHostUpDomain tempDomain1 = (OrderHostUpDomain) tempList.get(i+1);
					            		if(tempDomain.getComps() != tempDomain1.getComps() ||
					            		   tempDomain.getPyvnd() != tempDomain1.getPyvnd() ||
					            		   tempDomain.getPspno() != tempDomain1.getPspno()) {
					            			checkIns = true;
					            		}
					            		else checkIns = false;
				            		}
				            		
				            		if(checkIns) {
				            			OrderHostUpDomain selTempSumDomain = new OrderHostUpDomain();
				            			selTempSumDomain.setComps(tempDomain.getComps());
				            			selTempSumDomain.setPyvnd(tempDomain.getPyvnd());
				            			selTempSumDomain.setPspno(tempDomain.getPspno());
				            			selTempSumDomain.setLib1(domain.getLib1());
				            			selTempSumDomain.setLib2(domain.getLib2());							
				            	        OrderHostUpDomain getTempSum = orderHostUpService.selectSVH310PF_TempSum(selTempSumDomain);
				            	        
				            			tempDomain.setTrimd(getTempSum.getTrimd());			            			
										tempDomain.setPbsqy(getTempSum.getPbsqy());
										tempDomain.setPatqy(getTempSum.getPatqy());
										tempDomain.setWbsqy(getTempSum.getWbsqy());
										tempDomain.setD0t01(getTempSum.getD0t01());
										tempDomain.setD0t02(getTempSum.getD0t02());
										tempDomain.setD0t03(getTempSum.getD0t03());
										tempDomain.setD0t04(getTempSum.getD0t04());
										tempDomain.setD0t05(getTempSum.getD0t05());
										tempDomain.setD0t06(getTempSum.getD0t06());
										tempDomain.setD0t07(getTempSum.getD0t07());
										tempDomain.setD0t08(getTempSum.getD0t08());
										tempDomain.setD0t09(getTempSum.getD0t09());
										tempDomain.setD0t10(getTempSum.getD0t10());
										tempDomain.setD0tqy(getTempSum.getD0tqy());
										tempDomain.setD1t01(getTempSum.getD1t01());
										tempDomain.setD1t02(getTempSum.getD1t02());
										tempDomain.setD1t03(getTempSum.getD1t03());
										tempDomain.setD1t04(getTempSum.getD1t04());
										tempDomain.setD1t05(getTempSum.getD1t05());
										tempDomain.setD1t06(getTempSum.getD1t06());
										tempDomain.setD1t07(getTempSum.getD1t07());
										tempDomain.setD1t08(getTempSum.getD1t08());
										tempDomain.setD1t09(getTempSum.getD1t09());
										tempDomain.setD1t10(getTempSum.getD1t10());
										tempDomain.setD1tqy(getTempSum.getD1tqy());
										tempDomain.setD2t01(getTempSum.getD2t01());
										tempDomain.setD2t02(getTempSum.getD2t02());
										tempDomain.setD2t03(getTempSum.getD2t03());
										tempDomain.setD2t04(getTempSum.getD2t04());
										tempDomain.setD2t05(getTempSum.getD2t05());
										tempDomain.setD2t06(getTempSum.getD2t06());
										tempDomain.setD2t07(getTempSum.getD2t07());
										tempDomain.setD2t08(getTempSum.getD2t08());
										tempDomain.setD2t09(getTempSum.getD2t09());
										tempDomain.setD2t10(getTempSum.getD2t10());
										tempDomain.setD2tqy(getTempSum.getD2tqy());
										tempDomain.setD3t01(getTempSum.getD3t01());
										tempDomain.setD3t02(getTempSum.getD3t02());
										tempDomain.setD3t03(getTempSum.getD3t03());
										tempDomain.setD3t04(getTempSum.getD3t04());
										tempDomain.setD3t05(getTempSum.getD3t05());
										tempDomain.setD3t06(getTempSum.getD3t06());
										tempDomain.setD3t07(getTempSum.getD3t07());
										tempDomain.setD3t08(getTempSum.getD3t08());
										tempDomain.setD3t09(getTempSum.getD3t09());
										tempDomain.setD3t10(getTempSum.getD3t10());
										tempDomain.setD3tqy(getTempSum.getD3tqy());
										tempDomain.setD4t01(getTempSum.getD4t01());
										tempDomain.setD4t02(getTempSum.getD4t02());
										tempDomain.setD4t03(getTempSum.getD4t03());
										tempDomain.setD4t04(getTempSum.getD4t04());
										tempDomain.setD4t05(getTempSum.getD4t05());
										tempDomain.setD4t06(getTempSum.getD4t06());
										tempDomain.setD4t07(getTempSum.getD4t07());
										tempDomain.setD4t08(getTempSum.getD4t08());
										tempDomain.setD4t09(getTempSum.getD4t09());
										tempDomain.setD4t10(getTempSum.getD4t10());
										tempDomain.setD4tqy(getTempSum.getD4tqy());
										tempDomain.setRemqy(getTempSum.getRemqy());
										tempDomain.setGrtot(getTempSum.getGrtot());
						            	
						            	// data생성
						                int countSVH310PF2 = orderHostUpService.countSVH310PF2(tempDomain);
						                			                
						                if(countSVH310PF2 > 0) {
						                	JSONObject errList = new JSONObject();
						                	
						                	errList.put("ERROR", "중복DATA");
						                	errList.put("pyvnd", tempDomain.getPyvnd()); //거래처코드 
						                	errList.put("pspno", tempDomain.getPspno()); //풍성품번 
						                	errList.put("dmkcr", tempDomain.getDmkcr()); //차종코드
						                	errList.put("dsecd", tempDomain.getDsecd()); //서열코드
						                	errList.put("dseno", tempDomain.getDseno()); //대표서열번호 (CODE SERAIL)) 
						                	errList.put("dfacd", tempDomain.getDfacd()); //대표공장(공장구분) 
						    							                	
						                	//fList.add(errList);
						                }
						                else orderHostUpService.createSVH310PF(tempDomain);
				            		}
				            	}
				                
				                //업체부품구성마스터에의한 구성품번 추가
				               // orderHostUpService.createSVH310PF_ADD(domain);
				            }
				            else if(getSelchk.equals("P7")) {
				            	//data생성
				            	List<? extends OrderHostUpDomain> tempList = orderHostUpService.selectSVH320PF_Temp(domain);
				            	
				            	//공장코드별 삭제
				            	int countSVH320PF1 = orderHostUpService.countSVH320PF1(domain);
				            	if(countSVH320PF1 > 0) orderHostUpService.deleteSVH320PF(domain);
				            	
				            	for (int i=0; i< tempList.size(); i++) {
				            		OrderHostUpDomain tempDomain = (OrderHostUpDomain) tempList.get(i);
				            		tempDomain.setLib1(domain.getLib1());
				            		tempDomain.setLib2(domain.getLib2());
				            		
				            		//거래처,품번별 집계
				            		Boolean checkIns = true;
				            		if((tempList.size()-1) == i) checkIns = true;
				            		else {
					            		OrderHostUpDomain tempDomain1 = (OrderHostUpDomain) tempList.get(i+1);
					            		if(tempDomain.getComps() != tempDomain1.getComps() ||
					            		   tempDomain.getPyvnd() != tempDomain1.getPyvnd() ||
					            		   tempDomain.getPspno() != tempDomain1.getPspno()) {
					            			checkIns = true;
					            		}
					            		else checkIns = false;
				            		}
				            		
				            		if(checkIns) {			            						            			
				            			OrderHostUpDomain selTempSumDomain = new OrderHostUpDomain();
				            			selTempSumDomain.setComps(tempDomain.getComps());
				            			selTempSumDomain.setPyvnd(tempDomain.getPyvnd());
				            			selTempSumDomain.setPspno(tempDomain.getPspno());
				            			selTempSumDomain.setLib1(domain.getLib1());
				            			selTempSumDomain.setLib2(domain.getLib2());							
				            	        OrderHostUpDomain getTempSum = orderHostUpService.selectSVH320PF_TempSum(selTempSumDomain);
				            	        
										tempDomain.setTrimd(getTempSum.getTrimd());
										tempDomain.setPbsqy(getTempSum.getPbsqy());
										tempDomain.setPatqy(getTempSum.getPatqy());					
										tempDomain.setWbsqy(getTempSum.getWbsqy());					
										tempDomain.setDat00(getTempSum.getDat00());
										tempDomain.setDat01(getTempSum.getDat01());
										tempDomain.setDat02(getTempSum.getDat02());
										tempDomain.setDat03(getTempSum.getDat03());
										tempDomain.setDat04(getTempSum.getDat04());
										tempDomain.setDat05(getTempSum.getDat05());
										tempDomain.setDat06(getTempSum.getDat06());
										tempDomain.setDat07(getTempSum.getDat07());
										tempDomain.setDat08(getTempSum.getDat08());
										tempDomain.setDat09(getTempSum.getDat09());
										tempDomain.setDat10(getTempSum.getDat10());
										tempDomain.setDat11(getTempSum.getDat11());
										tempDomain.setDat12(getTempSum.getDat12());
										tempDomain.setRemqy(getTempSum.getRemqy());
										tempDomain.setOkqty(getTempSum.getOkqty());
										tempDomain.setMitqy(getTempSum.getMitqy());
										tempDomain.setPrseq(getTempSum.getPrseq());
										tempDomain.setMiqqy(getTempSum.getMiqqy());
										tempDomain.setMioqy(getTempSum.getMioqy());
										tempDomain.setGrtot(getTempSum.getGrtot());
						            	
						            	// data생성
						                int countSVH320PF2 = orderHostUpService.countSVH320PF2(tempDomain);
						                
						                if(countSVH320PF2 > 0) {        	 
						                	JSONObject errList = new JSONObject();
						                	
						                	errList.put("ERROR", "중복DATA");
						                	errList.put("pyvnd", tempDomain.getPyvnd()); //거래처코드 
						                	errList.put("pspno", tempDomain.getPspno()); //풍성품번 
						                	errList.put("dmkcr", tempDomain.getDmkcr()); //차종코드
						                	errList.put("dsecd", tempDomain.getDsecd()); //서열코드
						                	errList.put("dseno", tempDomain.getDseno()); //대표서열번호 (CODE SERAIL)) 
						                	errList.put("dfacd", tempDomain.getDfacd()); //대표공장(공장구분) 
						    				
						                	//fList.add(errList);
						                }
						                else orderHostUpService.createSVH320PF(tempDomain);
				            		}
				            	}           	
				            	
				                //업체부품구성마스터에의한 구성품번 추가
				                //orderHostUpService.createSVH320PF_ADD(domain);
				            }
			            }
			            	            
			            result = "업로드 성공하였습니다.(총:" + excelCnt + ", 정상:" + sList.size() + ", ERROR:" + fList.size();
			            
		            }catch(Exception e){
		            	e.printStackTrace();

		            	result = "업로드 파일 데이터를 확인해 주세요. : " + (excelCnt+1) + "행"+ "\\r\\n(※서버메시지:" + e.getMessage()+")";
		            	System.out.println("서열업로드 에러DATA : " +excelData.get(excelCnt+1));

		            	sList.clear();
		            	fList.clear();		                
		            }
	            }
            }

        }else{
            //return UxisCmmUtil.jsonMessage("첨부파일 읽어오기에 실패하였습니다.","N");
        }

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        ModelAndView mv = new ModelAndView();
        UxisCmmUtil.getSessionComCode(request, mv);
        mv.setViewName(".tiles.page.WAN008");
        mv.addObject("tabId", tabId);
        mv.addObject("result", result);
        mv.addObject("comps", getComps);
        mv.addObject("selChk", getSelchk);
        mv.addObject("hmckmcChk", getHmckmcchk);        
        mv.addObject("sucList", sList);
        mv.addObject("failList", fList);
	    
        return mv;
	    
    }
    
    private void getDataP6(Map<String, String> map, OrderHostUpDomain domain) throws ApplicationException{
    	domain.setSucList(null);
    	domain.setFailList(null);
    	
    	String vDocument = map.get(excelRowP6[0]);
    	
    	String vplngb = map.get(excelRowP6[2]);    	
    	
    	if (vplngb.equals("T")) {
			String vCol02 = map.get(excelRowP6[1]); //처리구분
			String vCol04 = map.get(excelRowP6[3]); //VAN ID 4자리
			String vCol05 = map.get(excelRowP6[4]); //FILE  ID
			String vCol06 = map.get(excelRowP6[5]); //관리구분
			String vCol07 = map.get(excelRowP6[6]); //DATA구분
			String vCol08 = map.get(excelRowP6[7]); //서열번호 3자리
			String vCol09 = map.get(excelRowP6[8]); //업체품명
			String vCol10 = map.get(excelRowP6[9]); //작업지시구분
			String vCol11t = map.get(excelRowP6[10]); //서열코드 15자리
			String vCol11="";

			// 쌍따옴표 처리						
			if (vCol09 != null) {
				vCol09 = vCol09.replaceAll("\"", "");
			}
			if (vCol11t != null) {
				vCol11t = vCol11t.replaceAll("\"", "");
			}
			
			if(vCol11t == ""){
				vCol11 = "    "; //서열코드 4자리변경
			}else{
				// 15까지공백으로 채우고 4자리 취득
				vCol11t = String.format(vCol11t, "%-15s");
				vCol11 = vCol11t.substring(0,4); //서열코드 4자리취득
				//vCol11 = vCol11.trim(); //서열코드 3자리인경우 공백제거
				
			}
			String vCol12 = map.get(excelRowP6[11]); //oem공장코드 4자리
			
			String vCol74t = map.get(excelRowP6[73]); //차종코드 4자리	
			String vCol74="";
			if(vCol74t == ""){
				vCol74 = "    "; 
			}else{
				vCol74 = vCol74t.substring(0,2); //차종코드 2자리변경
			}
			
			String comps = "";
			String pyvnd = "";
			String pspno = "";
			String efffr = "";
			String effto = "";
			String daypyo_DMKCR = "";
			String daypyo_DSECD = "";
			String errCHK ="";
			
			OrderHostUpDomain selSVM020PFDomain = new OrderHostUpDomain();
			selSVM020PFDomain.setComps(domain.getComps());
			selSVM020PFDomain.setVndcd(vCol04);	//VAN ID 4자리
			selSVM020PFDomain.setSeqno(vCol08);	//서열SEQ(화성용)
			selSVM020PFDomain.setFaccd(vCol12);	//공장코드
			selSVM020PFDomain.setLib1(domain.getLib1());
			selSVM020PFDomain.setLib2(domain.getLib2());							
			OrderHostUpDomain getSVM020PF = orderHostUpService.selectSVM020PF(selSVM020PFDomain);
	        	        
	        if(getSVM020PF != null && getSVM020PF.getPsvnd() != null && !getSVM020PF.getPsvnd().equals("")){
	        	comps = getSVM020PF.getPscom();
	        	pyvnd = getSVM020PF.getPsvnd();
				//대표서열산출(중복서열코드마스타)
	        	OrderHostUpDomain selSVZ080PFDomain = new OrderHostUpDomain();
	        	selSVZ080PFDomain.setComps(comps); //사업부코드
	        	selSVZ080PFDomain.setPyvnd(pyvnd); //업체코드
	        	selSVZ080PFDomain.setMcrc1(vCol74); //차종코드
	        	selSVZ080PFDomain.setMsec1(vCol11); //서열코드
	        	selSVZ080PFDomain.setLib1(domain.getLib1());
	        	selSVZ080PFDomain.setLib2(domain.getLib2());	    
	        	
	        	//System.out.println(comps + "," + pyvnd + "," + vCol74 + "," + vCol11);
	        	OrderHostUpDomain getSVZ080PF = orderHostUpService.selectSVZ080PF(selSVZ080PFDomain);

				if(getSVZ080PF != null && getSVZ080PF.getMcrcd() != null && !getSVZ080PF.getMcrcd().equals("")){
					daypyo_DMKCR = getSVZ080PF.getMcrcd(); //대표차종
					daypyo_DSECD = getSVZ080PF.getMsecd(); //대표서열
				}else{
					daypyo_DMKCR = vCol74;
					daypyo_DSECD = vCol11;
				}
			
				//업체서열차종마스타
	        	OrderHostUpDomain selSVM100PFDomain = new OrderHostUpDomain();
	        	selSVM100PFDomain.setComps(comps); //사업부코드
	        	selSVM100PFDomain.setPyvnd(pyvnd); //업체코드
	        	selSVM100PFDomain.setMcrcd(daypyo_DMKCR.substring(0,2)); //차종코드
	        	selSVM100PFDomain.setSeqcd(daypyo_DSECD); //서열코드 3,4자리
	        	selSVM100PFDomain.setSeqno(vCol08); //서열번호
	        	selSVM100PFDomain.setLib1(domain.getLib1());
	        	selSVM100PFDomain.setLib2(domain.getLib2());
	        		        	
	        	List<? extends OrderHostUpDomain> getListSVM100PF = orderHostUpService.selectSVM100PF(selSVM100PFDomain);
	
	        	//System.out.println(comps + "," + pyvnd + "," + daypyo_DMKCR.substring(0,2) + "," + daypyo_DSECD.substring(0,4) + "," + vCol08 + " => " + getListSVM100PF.size() + "건");
	        	
				if(!getListSVM100PF.isEmpty()){
		            for(OrderHostUpDomain domainSVM100PF : getListSVM100PF) {
						effto = domainSVM100PF.getEffto(); //적용일자TO

						errCHK = "T";
						if (effto.equals("99999999")){							
							pspno = domainSVM100PF.getPspno(); //풍성품번
							efffr = domainSVM100PF.getEfffr(); //적용일자FR
							effto = domainSVM100PF.getEffto(); //적용일자TO
							
							/*
							// 중복자료 확인
			            	OrderHostUpDomain cntTempDomain = new OrderHostUpDomain();
			            	//cntTempDomain.setComps(comps);	//사업부코드
			            	cntTempDomain.setPyvnd(pyvnd);	//업체코드
			            	cntTempDomain.setPspno(pspno);	//품번
			            	//cntTempDomain.setDmkcr(daypyo_DMKCR.substring(0,2));	//대표차종
			            	//cntTempDomain.setDsecd(daypyo_DSECD.substring(0,4));	//대표서열
			            	//cntTempDomain.setDseno(vCol08);	//대표번호
			            	//cntTempDomain.setDfacd(vCol12);	//대표공장
			            	cntTempDomain.setLib1(domain.getLib1());
			            	cntTempDomain.setLib2(domain.getLib2());
			                int countSVH310PF_Temp = orderHostUpService.countSVH310PF_Temp(cntTempDomain);
			                
			                // 기존 분석 (SVH314UC)
			                // 1. 대표(차종/서열/번호/공장)정보가 틀린 동일 품번이 존재할시 정상 리스트에 모두 표시.
			                // 2. 거래처, 품번별 자료를 집계 : Dataset 으로 sort, sum
			                // 3. 집계테이블(SVH310PF, SVH320PF)에 INSERT 할때 동일한 거래처와 품번이 존재하면 '중복DATA' 로 ERROR LIST 에 추가. 
			                // -> 기존 Dataset 집계 처리하는 부분 때문에 TEMP TABLE(SVH315PF, SVH325PF) 을 생성. 
			                //    대표(차종/서열/번호/공장)정보가 틀린 동일 품번 정보를 정상 LIST 에 넣고, ERROR LIST 에 '중복DATA' 로 넣음. 
			               
			                if(countSVH310PF_Temp > 0) {
			                	errCHK = "4"; //중복DATA
			                }else {
								errCHK = "T";
			                }
			                */							
			                
							JSONObject sucList = new JSONObject();
							sucList.put("pyvnd", pyvnd); //거래처코드 
							sucList.put("pspno", pspno); //풍성품번 
							sucList.put("dmkcr", daypyo_DMKCR.substring(0,2)); //차종코드 
							sucList.put("dsecd", daypyo_DSECD); //서열코드 3,4자리
							sucList.put("dseno", vCol08); //대표서열번호 (CODE SERAIL)) 
							sucList.put("dfacd", vCol12); //대표공장(공장구분) 
							sucList.put("dumcb", vDocument.substring(2,10)); //문서일자 
							sucList.put("jbgb1", ""); //지시구분 
							sucList.put("itmno", vCol08); //서열번호 (CODE SERAIL) 
							sucList.put("pnonm", vCol09); //업체품명 (CODE NAME) 
							sucList.put("itmcd", vCol11); //서열코드 
							sucList.put("trimd", map.get(excelRowP6[12])); //TRIM (D-1실적) 
							sucList.put("pbsqy", map.get(excelRowP6[13])); //대기댓수 
							sucList.put("patqy", map.get(excelRowP6[14])); //도장갯수 
							sucList.put("wbsqy", map.get(excelRowP6[15])); //비축댓수 
							sucList.put("d0t01", map.get(excelRowP6[16])); //D DAY 2HR수량 
							sucList.put("d0t02", map.get(excelRowP6[17])); //D DAY 2HR수량 
							sucList.put("d0t03", map.get(excelRowP6[18])); //D DAY 2HR수량 
							sucList.put("d0t04", map.get(excelRowP6[19])); //D DAY 2HR수량 
							sucList.put("d0t05", map.get(excelRowP6[20])); //D DAY 2HR수량 
							sucList.put("d0t06", map.get(excelRowP6[21])); //D DAY 2HR수량 
							sucList.put("d0t07", map.get(excelRowP6[22])); //D DAY 2HR수량 
							sucList.put("d0t08", map.get(excelRowP6[23])); //D DAY 2HR수량 
							sucList.put("d0t09", map.get(excelRowP6[24])); //D DAY 2HR수량 
							sucList.put("d0t10", map.get(excelRowP6[25])); //D DAY 2HR수량 
							sucList.put("d0tqy", map.get(excelRowP6[26])); //D DAY 수량 
							sucList.put("d1t01", map.get(excelRowP6[27])); //D+1 DAY 2HR수량 
							sucList.put("d1t02", map.get(excelRowP6[28])); //D+1 DAY 2HR수량 
							sucList.put("d1t03", map.get(excelRowP6[29])); //D+1 DAY 2HR수량 
							sucList.put("d1t04", map.get(excelRowP6[30])); //D+1 DAY 2HR수량 
							sucList.put("d1t05", map.get(excelRowP6[31])); //D+1 DAY 2HR수량 
							sucList.put("d1t06", map.get(excelRowP6[32])); //D+1 DAY 2HR수량 
							sucList.put("d1t07", map.get(excelRowP6[33])); //D+1 DAY 2HR수량 
							sucList.put("d1t08", map.get(excelRowP6[34])); //D+1 DAY 2HR수량 
							sucList.put("d1t09", map.get(excelRowP6[35])); //D+1 DAY 2HR수량 
							sucList.put("d1t10", map.get(excelRowP6[36])); //D+1 DAY 2HR수량 
							sucList.put("d1tqy", map.get(excelRowP6[37])); //D+1 DAY 수량 
							sucList.put("d2t01", map.get(excelRowP6[38])); //D+2 DAY 2HR수량 
							sucList.put("d2t02", map.get(excelRowP6[39])); //D+2 DAY 2HR수량 
							sucList.put("d2t03", map.get(excelRowP6[40])); //D+2 DAY 2HR수량 
							sucList.put("d2t04", map.get(excelRowP6[41])); //D+2 DAY 2HR수량 
							sucList.put("d2t05", map.get(excelRowP6[42])); //D+2 DAY 2HR수량 
							sucList.put("d2t06", map.get(excelRowP6[43])); //D+2 DAY 2HR수량 
							sucList.put("d2t07", map.get(excelRowP6[44])); //D+2 DAY 2HR수량 
							sucList.put("d2t08", map.get(excelRowP6[45])); //D+2 DAY 2HR수량 
							sucList.put("d2t09", map.get(excelRowP6[46])); //D+2 DAY 2HR수량 
							sucList.put("d2t10", map.get(excelRowP6[47])); //D+2 DAY 2HR수량 
							sucList.put("d2tqy", map.get(excelRowP6[48])); //D+2 DAY 수량 
							sucList.put("d3t01", map.get(excelRowP6[49])); //D+3 DAY 2HR수량 
							sucList.put("d3t02", map.get(excelRowP6[50])); //D+3 DAY 2HR수량 
							sucList.put("d3t03", map.get(excelRowP6[51])); //D+3 DAY 2HR수량 
							sucList.put("d3t04", map.get(excelRowP6[52])); //D+3 DAY 2HR수량 
							sucList.put("d3t05", map.get(excelRowP6[53])); //D+3 DAY 2HR수량 
							sucList.put("d3t06", map.get(excelRowP6[54])); //D+3 DAY 2HR수량 
							sucList.put("d3t07", map.get(excelRowP6[55])); //D+3 DAY 2HR수량 
							sucList.put("d3t08", map.get(excelRowP6[56])); //D+3 DAY 2HR수량 
							sucList.put("d3t09", map.get(excelRowP6[57])); //D+3 DAY 2HR수량 
							sucList.put("d3t10", map.get(excelRowP6[58])); //D+3 DAY 2HR수량 
							sucList.put("d3tqy", map.get(excelRowP6[59])); //D+3 DAY 수량 
							sucList.put("d4t01", map.get(excelRowP6[60])); //D+4 DAY 2HR수량 
							sucList.put("d4t02", map.get(excelRowP6[61])); //D+4 DAY 2HR수량 
							sucList.put("d4t03", map.get(excelRowP6[62])); //D+4 DAY 2HR수량 
							sucList.put("d4t04", map.get(excelRowP6[63])); //D+4 DAY 2HR수량 
							sucList.put("d4t05", map.get(excelRowP6[64])); //D+4 DAY 2HR수량 
							sucList.put("d4t06", map.get(excelRowP6[65])); //D+4 DAY 2HR수량 
							sucList.put("d4t07", map.get(excelRowP6[66])); //D+4 DAY 2HR수량 
							sucList.put("d4t08", map.get(excelRowP6[67])); //D+4 DAY 2HR수량 
							sucList.put("d4t09", map.get(excelRowP6[68])); //D+4 DAY 2HR수량 
							sucList.put("d4t10", map.get(excelRowP6[69])); //D+4 DAY 2HR수량 
							sucList.put("d4tqy", map.get(excelRowP6[70])); //D+4 DAY 수량 
							sucList.put("remqy", map.get(excelRowP6[71])); //이후투입수량 
							sucList.put("grtot", map.get(excelRowP6[72])); //합계수량 
							sucList.put("molcd", vCol74); //차종코드 
								
							// 집계							
							sucList.put("comps", comps); //사업부
							sucList.put("deffr", efffr);
							sucList.put("defto", effto);
															
							domain.setSucList(sucList);
							sList.add(domain.getSucList());
								
							//if(countSVH310PF_Temp == 0) {
								// 성공 자료 집계를 위해 TEMP 테이블에 저장.
								OrderHostUpDomain domainSum = new Gson().fromJson(sucList.toJSONString(), OrderHostUpDomain.class);
								orderHostUpService.createSVH310PF_Temp(domainSum);
							//}
						}
					}
				}else{
					//차종서열제외마스타
		        	OrderHostUpDomain selSVM300PFDomain = new OrderHostUpDomain();
		        	selSVM300PFDomain.setComps(comps);
		        	selSVM300PFDomain.setPyvnd(pyvnd);
		        	selSVM300PFDomain.setMcrcd(daypyo_DMKCR.substring(0,2));//차종코드
		        	selSVM300PFDomain.setSeqcd(daypyo_DSECD);//서열코드 3,4자리
		        	selSVM300PFDomain.setSeqno(vCol08);//서열번호
		        	selSVM300PFDomain.setLib1(domain.getLib1());
		        	selSVM300PFDomain.setLib2(domain.getLib2());
		        	OrderHostUpDomain getSVM300PF = orderHostUpService.selectSVM300PF(selSVM300PFDomain);
	
					if(getSVM300PF != null && getSVM300PF.getComps() != null && !getSVM300PF.getComps().equals("")){
						errCHK = "2"; //차종서열제외 list.
					}else{
						errCHK = "1"; //차종서열 존재하지 않음.
					}
				}
	        }else{
				errCHK = "3"; //HKMC공장코드error
			}
	        
	        if(errCHK != "T"){
	        	JSONObject failList = new JSONObject();
	        	
	        	//ERROR
	        	if(errCHK.equals("1")) failList.put("ERROR", "서열無"); 	        	
	        	else if(errCHK.equals("2")) failList.put("ERROR", "서열제외");
	        	else if(errCHK.equals("3")) failList.put("ERROR", "공장코드");
	        	//else if(errCHK.equals("4")) failList.put("ERROR", "중복DATA");
	        	
	        	failList.put("pyvnd", pyvnd); //거래처코드 
	        	failList.put("pspno", pspno); //풍성품번 
				//차종코드 
				if(daypyo_DMKCR == ""){
					failList.put("dmkcr", "");
				}else {
					failList.put("dmkcr", daypyo_DMKCR.substring(0,2)); 
				}
				//서열코드 
				if(daypyo_DSECD == ""){
					failList.put("dsecd", "");
				}else {
					failList.put("dsecd", daypyo_DSECD);
				}
				failList.put("dseno", vCol08); //대표서열번호 (CODE SERAIL)) 
				failList.put("dfacd", vCol12); //대표공장(공장구분) 
				failList.put("dumcb", vDocument.substring(2,10)); //문서일자 
				failList.put("jbgb1", ""); //지시구분 
				failList.put("itmno", vCol08); //서열번호 (CODE SERAIL) 
				failList.put("pnonm", vCol09); //업체품명 (CODE NAME) 
				failList.put("itmcd", vCol11); //서열코드 
				failList.put("trimd", map.get(excelRowP6[12])); //TRIM (D-1실적) 
				failList.put("pbsqy", map.get(excelRowP6[13])); //대기댓수 
				failList.put("patqy", map.get(excelRowP6[14])); //도장갯수 
				failList.put("wbsqy", map.get(excelRowP6[15])); //비축댓수 
				failList.put("d0t01", map.get(excelRowP6[16])); //D DAY 2HR수량 
				failList.put("d0t02", map.get(excelRowP6[17])); //D DAY 2HR수량 
				failList.put("d0t03", map.get(excelRowP6[18])); //D DAY 2HR수량 
				failList.put("d0t04", map.get(excelRowP6[19])); //D DAY 2HR수량 
				failList.put("d0t05", map.get(excelRowP6[20])); //D DAY 2HR수량 
				failList.put("d0t06", map.get(excelRowP6[21])); //D DAY 2HR수량 
				failList.put("d0t07", map.get(excelRowP6[22])); //D DAY 2HR수량 
				failList.put("d0t08", map.get(excelRowP6[23])); //D DAY 2HR수량 
				failList.put("d0t09", map.get(excelRowP6[24])); //D DAY 2HR수량 
				failList.put("d0t10", map.get(excelRowP6[25])); //D DAY 2HR수량 
				failList.put("d0tqy", map.get(excelRowP6[26])); //D DAY 수량 
				failList.put("d1t01", map.get(excelRowP6[27])); //D+1 DAY 2HR수량 
				failList.put("d1t02", map.get(excelRowP6[28])); //D+1 DAY 2HR수량 
				failList.put("d1t03", map.get(excelRowP6[29])); //D+1 DAY 2HR수량 
				failList.put("d1t04", map.get(excelRowP6[30])); //D+1 DAY 2HR수량 
				failList.put("d1t05", map.get(excelRowP6[31])); //D+1 DAY 2HR수량 
				failList.put("d1t06", map.get(excelRowP6[32])); //D+1 DAY 2HR수량 
				failList.put("d1t07", map.get(excelRowP6[33])); //D+1 DAY 2HR수량 
				failList.put("d1t08", map.get(excelRowP6[34])); //D+1 DAY 2HR수량 
				failList.put("d1t09", map.get(excelRowP6[35])); //D+1 DAY 2HR수량 
				failList.put("d1t10", map.get(excelRowP6[36])); //D+1 DAY 2HR수량 
				failList.put("d1tqy", map.get(excelRowP6[37])); //D+1 DAY 수량 
				failList.put("d2t01", map.get(excelRowP6[38])); //D+2 DAY 2HR수량 
				failList.put("d2t02", map.get(excelRowP6[39])); //D+2 DAY 2HR수량 
				failList.put("d2t03", map.get(excelRowP6[40])); //D+2 DAY 2HR수량 
				failList.put("d2t04", map.get(excelRowP6[41])); //D+2 DAY 2HR수량 
				failList.put("d2t05", map.get(excelRowP6[42])); //D+2 DAY 2HR수량 
				failList.put("d2t06", map.get(excelRowP6[43])); //D+2 DAY 2HR수량 
				failList.put("d2t07", map.get(excelRowP6[44])); //D+2 DAY 2HR수량 
				failList.put("d2t08", map.get(excelRowP6[45])); //D+2 DAY 2HR수량 
				failList.put("d2t09", map.get(excelRowP6[46])); //D+2 DAY 2HR수량 
				failList.put("d2t10", map.get(excelRowP6[47])); //D+2 DAY 2HR수량 
				failList.put("d2tqy", map.get(excelRowP6[48])); //D+2 DAY 수량 
				failList.put("d3t01", map.get(excelRowP6[49])); //D+3 DAY 2HR수량 
				failList.put("d3t02", map.get(excelRowP6[50])); //D+3 DAY 2HR수량 
				failList.put("d3t03", map.get(excelRowP6[51])); //D+3 DAY 2HR수량 
				failList.put("d3t04", map.get(excelRowP6[52])); //D+3 DAY 2HR수량 
				failList.put("d3t05", map.get(excelRowP6[53])); //D+3 DAY 2HR수량 
				failList.put("d3t06", map.get(excelRowP6[54])); //D+3 DAY 2HR수량 
				failList.put("d3t07", map.get(excelRowP6[55])); //D+3 DAY 2HR수량 
				failList.put("d3t08", map.get(excelRowP6[56])); //D+3 DAY 2HR수량 
				failList.put("d3t09", map.get(excelRowP6[57])); //D+3 DAY 2HR수량 
				failList.put("d3t10", map.get(excelRowP6[58])); //D+3 DAY 2HR수량 
				failList.put("d3tqy", map.get(excelRowP6[59])); //D+3 DAY 수량
				failList.put("d4t01", map.get(excelRowP6[60])); //D+4 DAY 2HR수량 
				failList.put("d4t02", map.get(excelRowP6[61])); //D+4 DAY 2HR수량 
				failList.put("d4t03", map.get(excelRowP6[62])); //D+4 DAY 2HR수량 
				failList.put("d4t04", map.get(excelRowP6[63])); //D+4 DAY 2HR수량 
				failList.put("d4t05", map.get(excelRowP6[64])); //D+4 DAY 2HR수량 
				failList.put("d4t06", map.get(excelRowP6[65])); //D+4 DAY 2HR수량 
				failList.put("d4t07", map.get(excelRowP6[66])); //D+4 DAY 2HR수량 
				failList.put("d4t08", map.get(excelRowP6[67])); //D+4 DAY 2HR수량 
				failList.put("d4t09", map.get(excelRowP6[68])); //D+4 DAY 2HR수량 
				failList.put("d4t10", map.get(excelRowP6[69])); //D+4 DAY 2HR수량 
				failList.put("d4tqy", map.get(excelRowP6[70])); //D+4 DAY 수량 
				failList.put("remqy", map.get(excelRowP6[71])); //이후투입수량 
				failList.put("grtot", map.get(excelRowP6[72])); //합계수량 
				failList.put("molcd", vCol74); //차종코드 
				
				domain.setFailList(failList);
				fList.add(domain.getFailList());
	        }
    	}
    	
        //return domain;
    }
    
    private void getDataP7(Map<String, String> map, OrderHostUpDomain domain) throws ApplicationException{
    	domain.setSucList(null);
    	domain.setFailList(null);
    	
    	String vDocument = map.get(excelRowP7[0]);
    	
    	String vplngb = map.get(excelRowP7[2]);    	
    	
    	if (vplngb.equals("T")) {
			String vCol02 = map.get(excelRowP7[1]); //처리구분
			String vCol04 = map.get(excelRowP7[3]); //VAN ID 4자리
			String vCol05 = map.get(excelRowP7[4]); //FILE  ID
			String vCol06 = map.get(excelRowP7[5]); //관리구분
			String vCol07 = map.get(excelRowP7[6]); //DATA구분
			String vCol08 = map.get(excelRowP7[7]); //서열번호 3자리
			String vCol09 = map.get(excelRowP7[8]); //업체품명
			String vCol10 = map.get(excelRowP7[9]); //작업지시구분
			String vCol11t = map.get(excelRowP7[10]); //서열코드 15자리
			String vCol11="";
			
			// 쌍따옴표 처리						
			if (vCol09 != null) {
				vCol09 = vCol09.replaceAll("\"", "");
			}
			if (vCol11t != null) {
				vCol11t = vCol11t.replaceAll("\"", "");
			}
			
			if(vCol11t == ""){
				vCol11 = "    "; //서열코드 4자리변경
			}else{
				// 15까지공백으로 채우고 4자리 취득
				vCol11t = String.format(vCol11t, "%-15s");
				vCol11 = vCol11t.substring(0,4); //서열코드 4자리취득
				//vCol11 = vCol11.trim(); //서열코드 3자리인경우 공백제거
			}
			String vCol12 = map.get(excelRowP7[11]); //oem공장코드 4자리
			
			String vCol37t = map.get(excelRowP7[36]); //차종코드 4자리	
			String vCol37="";
			if(vCol37t == ""){
				vCol37 = "    "; 
			}else{
				vCol37 = vCol37t.substring(0,2); //차종코드 2자리변경
			}

			
			String comps = "";
			String pyvnd = "";
			String pspno = "";
			String efffr = "";
			String effto = "";
			String daypyo_DMKCR = "";
			String daypyo_DSECD = "";
			String errCHK ="";
			
	
			OrderHostUpDomain selSVM020PFDomain = new OrderHostUpDomain();
			selSVM020PFDomain.setComps(domain.getComps());
			selSVM020PFDomain.setVndcd(vCol04);	//VAN ID 4자리
			selSVM020PFDomain.setSeqno(vCol08);	//서열SEQ(화성용)
			selSVM020PFDomain.setFaccd(vCol12);	//공장코드
			selSVM020PFDomain.setLib1(domain.getLib1());
			selSVM020PFDomain.setLib2(domain.getLib2());							
	        OrderHostUpDomain getSVM020PF = orderHostUpService.selectSVM020PF(selSVM020PFDomain);
	        	        
	        if(getSVM020PF != null && getSVM020PF.getPsvnd() != null && !getSVM020PF.getPsvnd().equals("")){
	        	comps = getSVM020PF.getPscom();
	        	pyvnd = getSVM020PF.getPsvnd();
				//대표서열산출(중복서열코드마스타)
	        	OrderHostUpDomain selSVZ080PFDomain = new OrderHostUpDomain();
	        	selSVZ080PFDomain.setComps(comps);
	        	selSVZ080PFDomain.setPyvnd(pyvnd);
	        	selSVZ080PFDomain.setMcrc1(vCol37);//차종코드
	        	selSVZ080PFDomain.setMsec1(vCol11);//서열코드
	        	selSVZ080PFDomain.setLib1(domain.getLib1());
	        	selSVZ080PFDomain.setLib2(domain.getLib2());	        	
	        	OrderHostUpDomain getSVZ080PF = orderHostUpService.selectSVZ080PF(selSVZ080PFDomain);

				if(getSVZ080PF != null && getSVZ080PF.getMcrcd() != null && !getSVZ080PF.getMcrcd().equals("")){
					daypyo_DMKCR = getSVZ080PF.getMcrcd();
					daypyo_DSECD = getSVZ080PF.getMsecd();
				}else{
					daypyo_DMKCR = vCol37;
					daypyo_DSECD = vCol11;
				}
			
				//업체서열차종마스타
	        	OrderHostUpDomain selSVM100PFDomain = new OrderHostUpDomain();
	        	selSVM100PFDomain.setComps(comps);
	        	selSVM100PFDomain.setPyvnd(pyvnd);
	        	selSVM100PFDomain.setMcrcd(daypyo_DMKCR.substring(0,2));//차종코드
	        	selSVM100PFDomain.setSeqcd(daypyo_DSECD);//서열코드 3,4자리
	        	selSVM100PFDomain.setSeqno(vCol08);//서열번호
	        	selSVM100PFDomain.setLib1(domain.getLib1());
	        	selSVM100PFDomain.setLib2(domain.getLib2());
	        	List<? extends OrderHostUpDomain> getListSVM100PF = orderHostUpService.selectSVM100PF(selSVM100PFDomain);
	
				if(!getListSVM100PF.isEmpty()){
		            for(OrderHostUpDomain domainSVM100PF : getListSVM100PF) {
						effto = domainSVM100PF.getEffto();

						errCHK = "T";
						if (effto.equals("99999999")){
							pspno = domainSVM100PF.getPspno();
							efffr = domainSVM100PF.getEfffr();
							effto = domainSVM100PF.getEffto();
							
							/*
							// 중복자료 확인
			            	OrderHostUpDomain cntTempDomain = new OrderHostUpDomain();
			            	//cntTempDomain.setComps(comps);	//사업부코드
			            	cntTempDomain.setPyvnd(pyvnd);	//업체코드
			            	cntTempDomain.setPspno(pspno);	//품번
			            	//cntTempDomain.setDmkcr(daypyo_DMKCR.substring(0,2));	//대표차종
			            	//cntTempDomain.setDsecd(daypyo_DSECD.substring(0,4));	//대표서열
			            	//cntTempDomain.setDseno(vCol08);	//대표번호
			            	//cntTempDomain.setDfacd(vCol12);	//대표공장
			            	cntTempDomain.setLib1(domain.getLib1());
			            	cntTempDomain.setLib2(domain.getLib2());
			                int countSVH320PF_Temp = orderHostUpService.countSVH320PF_Temp(cntTempDomain);
			                
			                if(countSVH320PF_Temp > 0) {
			                	errCHK = "4"; //중복DATA
			                }else {
			                	errCHK = "T";
			                }
			                */							
									        
							JSONObject sucList = new JSONObject();
							sucList.put("pyvnd", pyvnd); //거래처코드
							sucList.put("pspno", pspno); //풍성품번
							sucList.put("dmkcr", daypyo_DMKCR.substring(0,2)); //차종코드
							sucList.put("dsecd", daypyo_DSECD); //서열코드
							sucList.put("dseno", vCol08); //대표서열번호 (CODE SERAIL))
							sucList.put("dfacd", vCol12); //대표공장(공장구분)
							sucList.put("dumcb", vDocument.substring(2,10)); //문서일자
							sucList.put("jbgb1", ""); //지시구분
							sucList.put("itmno", vCol08); //서열번호 (CODE SERAIL)
							sucList.put("pnonm", vCol09); //업체품명 (CODE NAME)
							sucList.put("itmcd", vCol11); //서열코드
							sucList.put("trimd", map.get(excelRowP7[12])); //TRIM (D-1실적)
							sucList.put("pbsqy", map.get(excelRowP7[13])); //대기댓수
							sucList.put("patqy", map.get(excelRowP7[14])); //도장갯수							
							sucList.put("wbsqy", map.get(excelRowP7[15])); //비축댓수							
							sucList.put("dat00", map.get(excelRowP7[16])); //D DAY 수량 	
							sucList.put("dat01", map.get(excelRowP7[17])); //D+1 DAY 수량
							sucList.put("dat02", map.get(excelRowP7[18])); //D+2 DAY 수량
							sucList.put("dat03", map.get(excelRowP7[19])); //D+3 DAY 수량
							sucList.put("dat04", map.get(excelRowP7[20])); //D+4 DAY 수량
							sucList.put("dat05", map.get(excelRowP7[21])); //D+5 DAY 수량
							sucList.put("dat06", map.get(excelRowP7[22])); //D+6 DAY 수량	
							sucList.put("dat07", map.get(excelRowP7[23])); //D+7 DAY 수량
							sucList.put("dat08", map.get(excelRowP7[24])); //D+8 DAY 수량
							sucList.put("dat09", map.get(excelRowP7[25])); //D+9 DAY 수량
							sucList.put("dat10", map.get(excelRowP7[26])); //D+10 DAY 수량		
							sucList.put("dat11", map.get(excelRowP7[27])); //D+11 DAY 수량	
							sucList.put("dat12", map.get(excelRowP7[28])); //D+12 DAY 수량
							sucList.put("remqy", map.get(excelRowP7[29])); //이후투입수량
							sucList.put("okqty", map.get(excelRowP7[30])); //확정수량
							sucList.put("mitqy", map.get(excelRowP7[31])); //MITU
							sucList.put("prseq", map.get(excelRowP7[32])); //PR-SEQ
							sucList.put("miqqy", map.get(excelRowP7[33])); //당월미반영잔량
							sucList.put("mioqy", map.get(excelRowP7[34])); //차월생산 ORDER량
							sucList.put("grtot", map.get(excelRowP7[35])); //합계수량
							sucList.put("molcd", vCol37); //차종코드	
	                                             
							// 집계							
							sucList.put("comps", comps); //사업부
							sucList.put("deffr", efffr);
							sucList.put("defto", effto);
														
							domain.setSucList(sucList);
							sList.add(domain.getSucList());
								
							//if(countSVH320PF_Temp == 0) {
								// 성공 자료 집계를 위해 TEMP 테이블에 저장.
							    OrderHostUpDomain domainSum = new Gson().fromJson(sucList.toJSONString(), OrderHostUpDomain.class);
							    orderHostUpService.createSVH320PF_Temp(domainSum);
							//}
						}					
					}
				}else{
					//차종서열제외마스타
		        	OrderHostUpDomain selSVM300PFDomain = new OrderHostUpDomain();
		        	selSVM300PFDomain.setComps(comps);
		        	selSVM300PFDomain.setPyvnd(pyvnd);
		        	selSVM300PFDomain.setMcrcd(daypyo_DMKCR.substring(0,2));//차종코드
		        	selSVM300PFDomain.setSeqcd(daypyo_DSECD);//서열코드
		        	selSVM300PFDomain.setSeqno(vCol08);//서열번호
		        	selSVM300PFDomain.setLib1(domain.getLib1());
		        	selSVM300PFDomain.setLib2(domain.getLib2());
		        	OrderHostUpDomain getSVM300PF = orderHostUpService.selectSVM300PF(selSVM300PFDomain);
	
					if(getSVM300PF != null && getSVM300PF.getComps() != null && !getSVM300PF.getComps().equals("")){
						errCHK = "2"; //차종서열제외 list.
					}else{
						errCHK = "1"; //차종서열 존재하지 않음.
					}
				}
	        }else{
				errCHK = "3"; //HKMC공장코드error
			}
	        
	        if(errCHK != "T"){
	        	JSONObject failList = new JSONObject();
	        	
	        	//ERROR
	        	if(errCHK.equals("1")) failList.put("ERROR", "서열無"); 	        	
	        	else if(errCHK.equals("2")) failList.put("ERROR", "서열제외");
	        	else if(errCHK.equals("3")) failList.put("ERROR", "공장코드");
	        	//else if(errCHK.equals("4")) failList.put("ERROR", "중복DATA");
	        	
	        	failList.put("pyvnd", pyvnd); //거래처코드
	        	failList.put("pspno", pspno); //풍성품번
				//차종코드
				if(daypyo_DMKCR == ""){
					failList.put("dmkcr", "");
				}else {
					failList.put("dmkcr", daypyo_DMKCR.substring(0,2)); 
				}
				//서열코드
				if(daypyo_DSECD == ""){
					failList.put("dsecd", "");
				}else {
					failList.put("dsecd", daypyo_DSECD);
				}
				
				failList.put("dseno", vCol08); //대표서열번호 (CODE SERAIL))
				failList.put("dfacd", vCol12); //대표공장(공장구분)
				failList.put("dumcb", vDocument.substring(2,10)); //문서일자
				failList.put("jbgb1", ""); //지시구분
				failList.put("itmno", vCol08); //서열번호 (CODE SERAIL)
				failList.put("pnonm", vCol09); //업체품명 (CODE NAME)
				failList.put("itmcd", vCol11); //서열코드
				failList.put("trimd", map.get(excelRowP7[12])); //TRIM (D-1실적)
				failList.put("pbsqy", map.get(excelRowP7[13])); //대기댓수
				failList.put("patqy", map.get(excelRowP7[14])); //도장갯수							
				failList.put("wbsqy", map.get(excelRowP7[15])); //비축댓수							
				failList.put("dat00", map.get(excelRowP7[16])); //D DAY 수량 	
				failList.put("dat01", map.get(excelRowP7[17])); //D+1 DAY 수량
				failList.put("dat02", map.get(excelRowP7[18])); //D+2 DAY 수량
				failList.put("dat03", map.get(excelRowP7[19])); //D+3 DAY 수량
				failList.put("dat04", map.get(excelRowP7[20])); //D+4 DAY 수량
				failList.put("dat05", map.get(excelRowP7[21])); //D+5 DAY 수량
				failList.put("dat06", map.get(excelRowP7[22])); //D+6 DAY 수량	
				failList.put("dat07", map.get(excelRowP7[23])); //D+7 DAY 수량
				failList.put("dat08", map.get(excelRowP7[24])); //D+8 DAY 수량
				failList.put("dat09", map.get(excelRowP7[25])); //D+9 DAY 수량
				failList.put("dat10", map.get(excelRowP7[26])); //D+10 DAY 수량		
				failList.put("dat11", map.get(excelRowP7[27])); //D+11 DAY 수량	
				failList.put("dat12", map.get(excelRowP7[28])); //D+12 DAY 수량
				failList.put("remqy", map.get(excelRowP7[29])); //이후투입수량
				failList.put("okqty", map.get(excelRowP7[30])); //확정수량
				failList.put("mitqy", map.get(excelRowP7[31])); //MITU
				failList.put("prseq", map.get(excelRowP7[32])); //PR-SEQ
				failList.put("miqqy", map.get(excelRowP7[33])); //당월미반영잔량
				failList.put("mioqy", map.get(excelRowP7[34])); //차월생산 ORDER량
				failList.put("grtot", map.get(excelRowP7[35])); //합계수량
				failList.put("molcd", vCol37); //차종코드	
				
				domain.setFailList(failList);
				fList.add(domain.getFailList());
	        }
    	}
    	
        //return domain;
    }
    
    public String csvToXLSX(String fileName){
    	String xlsxFile = fileName.toUpperCase().replace("CSV", "xlsx");
    	
        try {        	
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("sheet1");
            String currentLine=null;
            int RowNum=0;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((currentLine = br.readLine()) != null) {
                //String str[] = currentLine.split(",");                
            	String str[] = csvSplit(currentLine);                
                XSSFRow currentRow=sheet.createRow(RowNum);
                for(int i=0;i<str.length;i++){
                    currentRow.createCell(i).setCellValue(str[i]);
                }
                RowNum++;
            }

            FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFile);
            workBook.write(fileOutputStream);
            fileOutputStream.close();

            System.out.println("CSV to XLSX Done");
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "Exception in try.");
        }
        
		return xlsxFile;
    }

    // 안에 내용중 콤마가 있는경우 " 쌍따옴표로 감싸기 때문에 처리.
    public static String[] csvSplit(String str){
		String[] resultStr = null;
		String result = "";

		String[] a = str.split(",");

		int cnt = 0;
		String temp = "";

		for(int i = 0; i < a.length; i++){
			if(a[i].indexOf("\"") == 0){
				if(a[i].lastIndexOf("\"") == a[i].length()-1){
					result += a[i].replaceAll("\"","");
				}else{
					cnt++;
					temp += a[i].replaceAll("\"","");
				}
			}else if(a[i].lastIndexOf("\"") == a[i].length()-1){
				if(cnt > 0){
					result += temp + "," + a[i].replaceAll("\"","");
					cnt = 0;
					temp = "";
				}
			}else{
				if(cnt > 0){
					cnt++;
					temp += "," + a[i].replaceAll("\"","");
				}else{
					result += a[i];
				}
			}

			if(i != a.length-1 && cnt == 0) result += "|,|";
		}
		
		resultStr = result.split("\\|,\\|");
		
		return resultStr;
	}
    
}
