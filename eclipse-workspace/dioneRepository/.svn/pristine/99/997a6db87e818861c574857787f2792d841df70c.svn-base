package com.globaldenso.dnkr.presentation.controller.sal;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.NonOrderHostUpService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisExcelFileUtil;
import com.globaldenso.dnkr.uxis.UxisFileMngUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;
import com.google.gson.Gson;

/**
 * [KR] 비서열형 HOST UP 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN015NonOrderHostUp")
@ViewId(value = "WAN015")
public class WAN015NonOrderHostUpController {
    /**
     * [KR] 비서열형 HOST UP 서비스 <br>     
     */
    @Autowired
    private NonOrderHostUpService nonOrderHostUpService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN015NonOrderHostUpController() {
        // no process
    }
        
    /**
     * 확정오더 PERIOD MAX 일자 
     */
    private Long maxPeriod = Long.parseLong(UxisCmmUtil.getProperty("nonOrderHostUp.maxPeriod"));
    
    // 비서열 - 표준양식, 확정오더 - 표준양식
    private String[] excelRow = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
    		                     "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
    		                     "U", "V"};
  
    // 확정오더 - HMC CKD(창원)
    private String[] excelRow2A = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                                   "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
                                   "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", 
                                   "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", 
                                   "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", 
                                   "AY", "AZ", "BA", "BB", "BC", "BD"};
    
    // 확정오더 - HMC CKD(화성)
    private String[] excelRow2B = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                                   "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
                                   "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", 
                                   "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", 
                                   "AO", "AP",
                                   "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX"};  // 숨김열  
    
    // 확정오더 - KMC CKD
    private String[] excelRow3 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                                  "K", "L", "M", "N", "O", "P", "Q"};  
    // 확정오더 - MOBIS CKD
    private String[] excelRow4 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                                  "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
                                  "U", "V", "W"};
    // 확정오더 - MOBIS AS (신양식 SRS)
    private String[] excelRow5A = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                                   "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
                                   "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", 
                                   "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", 
                                   "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", 
                                   "AY", "AZ", "BA", "BB", "BC", "BD", "BE", "BF", "BG", "BH", 
                                   "BI", "BJ", "BK", "BL", "BM", "BN", "BO", "BP", "BQ", "BR",
                                   "BS", "BT", "BU", "BV", "BW", "BX", "BY"};
    
    // 확정오더 - MOBIS AS (구양식 SPIN)
    private String[] excelRow5B = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                                   "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
                                   "U", "V", "W", "X", "Y", "Z", "AA", "AB", "AC", "AD", 
                                   "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", 
                                   "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", 
                                   "AY", "AZ", "BA", "BB", "BC", "BD", "BE", "BF", "BG", "BH", 
                                   "BI", "BJ", "BK", "BL", "BM", "BN", "BO", "BP"};
    
    // 확정오더 - GLOVIS
    private String[] excelRow6 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
                                  "K"};  

    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAM015")
    public ModelAndView init(HttpServletRequest request)  throws Exception {
        ModelAndView mv = new ModelAndView();

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        UxisCmmUtil.getSessionComCode(request, mv);
        
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        mv.addObject("comps", getComps); 
        
        String getTypcd = ServletRequestUtils.getStringParameter(request, "getTypcd");
        if(getTypcd == null) getTypcd = "BB";
        mv.addObject("typcd", getTypcd);
        
        String getCCTypcd = ServletRequestUtils.getStringParameter(request, "getCCTypcd");
        mv.addObject("ccTypcd", getCCTypcd);  
        
        String getCCTypGbcd = ServletRequestUtils.getStringParameter(request, "getCCTypGbcd");
        mv.addObject("ccTypGbcd", getCCTypGbcd);  
        
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");
        mv.addObject("pyvnd", getPyvnd); 
        
        String getCusnm = ServletRequestUtils.getStringParameter(request, "getCusnm");
        mv.addObject("cusnm", getCusnm); 

    	String getPlndt = ServletRequestUtils.getStringParameter(request, "getPlndt");    	
    	if(getPlndt == null) {
	        SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
	        Calendar calendar = Calendar.getInstance();
	        String today = datafmt.format(calendar.getTime());        
	        mv.addObject("plndt", today);
    	}
    	else mv.addObject("plndt", getPlndt);
    	
        if(getTypcd.equals("CC") && !getCCTypcd.equals("1")) {
        	mv.addObject("period", "");
        }
        else {	        
	        String getPeriod = ServletRequestUtils.getStringParameter(request, "getPeriod");
	        if(getPeriod == null) getPeriod = "";
	        mv.addObject("period", getPeriod);
        }
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "NonOrderHostUp.jsp");
        mv.setViewName(".tiles.page.WAN015");
        return mv;
    }
    
    @RequestMapping(value = "/fileDownload", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:/WAN015NonOrderHostUp/init.do")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response)  throws Exception {
    	
    	String fileDir = ServletRequestUtils.getStringParameter(request, "fileDir");
        
    	System.out.println("공통양식 다운로드 : " + fileDir);
    	
    	String rootPath = request.getSession().getServletContext().getRealPath("/") ;
    	String path = rootPath + fileDir;
    	
    	File file = new File(path);

    	String userAgent = request.getHeader("User-Agent");
    	boolean ie = userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("rv:11") > -1;
    	String fileName = null;
    	  
    	if (ie) {
    		fileName = URLEncoder.encode(file.getName(), "utf-8");
    	} else {
    		fileName = new String(file.getName().getBytes("utf-8"),"iso-8859-1");
    	}
    	  
    	response.setContentType("application/octet-stream");
    	response.setHeader("Content-Disposition","attachment;filename=\"" +fileName+"\";");
    	  
    	FileInputStream fis=new FileInputStream(file);
    	BufferedInputStream bis=new BufferedInputStream(fis);
    	ServletOutputStream so=response.getOutputStream();
    	BufferedOutputStream bos=new BufferedOutputStream(so);
    	  
    	byte[] data=new byte[2048];
    	int input=0;
    	while((input=bis.read(data))!=-1){
    		bos.write(data,0,input);
    		bos.flush();
    	}
    	  
    	if(bos!=null) bos.close();
    	if(bis!=null) bis.close();
    	if(so!=null) so.close();
    	if(fis!=null) fis.close();
    	
    	System.out.println("공통양식 다운로드 end.");
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
    @ErrorBack(viewName = "forward:/WAN015NonOrderHostUp/init.do")
    public ModelAndView procExcelUpload(HttpServletRequest request, 
        HttpServletResponse response, 
        MultipartHttpServletRequest multiRequest) throws Exception{
        
        System.out.println("-------------------------------------------------");
        String result = "";
        String fileName = "";   //파일명을 담을 변수 선언
        UxisExcelFileUtil efUtil = new UxisExcelFileUtil();
        NonOrderHostUpDomain domain = new NonOrderHostUpDomain();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat listFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");

        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        domain.setInpid(empInfo.getEmpNumber());
        
        CommonDb2Domain empInfo2 = UxisUtil.getDB2Lib(getComps);
        
        domain.setLib1(empInfo2.getLib1());
        domain.setLib2(empInfo2.getLib2());

        String getTypcd = ServletRequestUtils.getStringParameter(request, "getTypcd");
        String getCCTypcd = ServletRequestUtils.getStringParameter(request, "getCCTypcd");
        String getCCTypGbcd = "";	//ServletRequestUtils.getStringParameter(request, "getCCTypGbcd");
        
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");
        String getCusnm = ServletRequestUtils.getStringParameter(request, "getCusnm");
        String getPlndt = ServletRequestUtils.getStringParameter(request, "getPlndt");        
        String getPeriod = ServletRequestUtils.getStringParameter(request, "getPeriod");

        domain.setComps(getComps);
        domain.setTypcd(getTypcd);
        domain.setPyvnd(getPyvnd);
        
        if(getPlndt != null) {
    		try {
    			domain.setPlndt(sdf.format(listFormat.parse(getPlndt)));
    		} catch (java.text.ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}  
        }
        domain.setPeriod(getPeriod);

        
        System.out.println("* 사업부 : " + domain.getComps());
        System.out.println("* LIB1 : " + domain.getLib1());
        System.out.println("* LIB2 : " + domain.getLib2());
        System.out.println("* 사원번호 : " + domain.getInpid());  
        
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
        
        
		List sList = new ArrayList(); //정상 dataset return
		List fList = new ArrayList(); //error dataset return
		
        /** 액셀 내용 읽기 및 데이터 등록 **/
        //파일명 값이 있을 경우 업로드 된 액셀내용을 읽어서 데이터 등록/수정 처리를 한다.
        if(!UxisStringUtil.isEmpty(fileName)){
            System.out.println("=================Excel Data===============");
            System.out.println(fileName);
            //fileName의 엑셀 파일을 읽어서 변수에 데이터를 담는다.
            List<Map<String, String>> excelData = null;
            
            String rowIndex = "";
            
            //엑셀 0행부터 읽어야 하는 경우 
            //1.표준양식 : 필수항목만 입력
            //2.타이틀행 없음 : 확정오더 - HMC CKD (창원양식)
            if(domain.getTypcd().equals("BB")) rowIndex = "order";
            if(domain.getTypcd().equals("CC")) {
            	if(getCCTypcd.equals("1") || getCCTypcd.equals("2")) rowIndex = "order";
            }
            
            excelData = efUtil.getExcelData(fileName, rowIndex);

            //엑셀데이터가 없을 경우 오류 처리 (읽을 수 없는 HTML 형태의 엑셀 파일일때 등.)
            if(excelData == null || excelData.size() <= 0){
            	 result = "첨부파일이 잘못되었습니다.";
            }else{
            	
                //MOBIS AS 구양식 : 5행부터 Title이 시작 (HTML 형태의 엑셀 파일을 변환하여 읽으면 열 사이즈 6이 나옴.)  
                if(domain.getTypcd().equals("CC") && getCCTypcd.equals("5") && excelData.get(0).size() == 6) {
                	excelData = efUtil.getExcelData(fileName, "order5");	// 데이터 5행부터 읽기
                }
                
                //System.out.println("=================Excel Data===============");
                //System.out.println(excelData);
                //System.out.println("=================Excel Data===============");
            	
	            System.out.println("start excelDataProcess -----> RowCnt : " + excelData.size() + " CelCnt : " + excelData.get(0).size());
	            
	            int excelLength = 0;
	            //비서열 - 표준양식
	            if(domain.getTypcd().equals("BB")) excelLength = excelRow.length;
	            else {
	            	//확정오더 - 표준양식 
	            	if(getCCTypcd.equals("1")) excelLength = excelRow.length;
	            	//확정오더 - HMC CKD
	            	if(getCCTypcd.equals("2")) {
	            		//창원
	            		if(excelData.get(0).size() == excelRow2A.length) {
	            			excelLength = excelRow2A.length;
	            			getCCTypGbcd = "2A";
	            		}
	            		//화성
	            		if(excelData.get(0).size() == excelRow2B.length) {
	            			excelLength = excelRow2B.length;
	            			getCCTypGbcd = "2B";
	            		}
	            	}
	            	//확정오더 - KMC CKD
	            	if(getCCTypcd.equals("3")) excelLength = excelRow3.length;
	            	//확정오더 - MOBIS CKD
	            	if(getCCTypcd.equals("4")) excelLength = excelRow4.length;
	            	//확정오더 - MOBIS AS
	            	if(getCCTypcd.equals("5")) {
	            		//신양식
	            		if(excelData.get(0).size() == excelRow5A.length) {
	            			excelLength = excelRow5A.length;
	            			getCCTypGbcd = "5A";
	            		}
	            		//구양식
	            		if(excelData.get(0).size() == excelRow5B.length) {
	            			excelLength = excelRow5B.length;
	            			getCCTypGbcd = "5B";
	            		}
	            	}
	            	//확정오더 - GLOVIS
	            	if(getCCTypcd.equals("6")) excelLength = excelRow6.length;
	            }
	            System.out.println("양식 -----> " + excelLength);
	            
	            boolean excelCheckYn = true;
	            if(excelLength != excelData.get(0).size()) excelCheckYn = false;

	            if(!excelCheckYn) {
	            	result = "해당 양식의 첨부파일인지 확인해주세요.";
	            }else {	        
	            	
	            	// 표준양식 : 필수항목만 입력한 경우의 타이틀 포함하여 읽었기 때문에 타이틀 삭제처리.
	            	// 확정오더 - HMC CKD (화성) : 창원 양식의 타이틀이 없는 기준으로 읽었기 때문에 화성 양식의 타이틀 삭제처리.
	                if(domain.getTypcd().equals("BB")) excelData.remove(0);
	                if(domain.getTypcd().equals("CC")) {
	                	if(getCCTypcd.equals("1")) excelData.remove(0);
	                	if(getCCTypcd.equals("2") && getCCTypGbcd.equals("2B")) excelData.remove(0);
	                }
	                
		            int excelCnt = 0;
		            
		            try {
			            boolean delVanData = true;
			            for(Map<String, String> tempMap : excelData){
			            
		            		//VAN DATA  WORK FILE 삭제	            	
		    	            if(delVanData) {
		    	    	    	NonOrderHostUpDomain delSVZ60PFDomain = new NonOrderHostUpDomain();
		    	    	    	delSVZ60PFDomain.setComps(domain.getComps());
		    	    	    	delSVZ60PFDomain.setTypcd(domain.getTypcd());
		    	    	    	delSVZ60PFDomain.setPyvnd(domain.getPyvnd());
		    	    	    	delSVZ60PFDomain.setLib1(domain.getLib1());
		    	    	    	delSVZ60PFDomain.setLib2(domain.getLib2());	        	
		    	            	
		    	            	int cntSVZ60PF = nonOrderHostUpService.countSVZ60PF(delSVZ60PFDomain);   
		    	            	if(cntSVZ60PF > 0) nonOrderHostUpService.deleteSVZ60PF(delSVZ60PFDomain);
		    	            		    	            	
		    	            	delVanData = false;
		    	            }
			    	        
		    	            //System.out.println("excelRow5[0] -----> " + tempMap.get(excelRow5[0]));
		    	            
		    	            //비서열 - 표준양식
		    	            if(domain.getTypcd().equals("BB")) getData(tempMap, domain);
		    	            else {
		    	            	//확정오더 - 표준양식 (1)
		    	            	//확정오더 - HMC CKD (2)
		    	            	//확정오더 - KMC CKD (3)
		    	            	//확정오더 - MOBIS CKD (4)
		    	            	//확정오더 - MOBIS AS (5)
		    	            	//확정오더 - GLOVIS (6)
		    	            	if(getCCTypcd.equals("1")) getData(tempMap, domain);
		    	            	else {
		    	            		// 확정오더 - KMC CKD -> 업체코드가 'RONZ' 인 자료만 처리 (속도저하 개선)
		    	            		if(getCCTypcd.equals("3") && !tempMap.get(excelRow3[10]).equals("RONZ")) {
		    	            	    	domain.setSucList(null);
		    	            	    	domain.setFailList(null);
		    	            	    	
		    	            	    	JSONObject failList = new JSONObject();
		    	            	    			    	                    	
		    	            	    	failList.put("ERROR", "업체코드(RONZ)불일치");
		    	            	    	
		    	            	    	String dtPlndt = replaceColDt(tempMap.get(excelRow3[3]));
		    	            			try {
		    	            				dtPlndt = listFormat.format(sdf.parse(dtPlndt));
		    	            			} catch (java.text.ParseException e) {
		    	            				// TODO Auto-generated catch block
		    	            				e.printStackTrace();
		    	            			}  
		    	            			
		    	        				for (int f=0; f<=16; f++) {
		    	        					if(f==0) {
		    	        						failList.put("cprtn", tempMap.get(excelRow3[0])); //고객품번
		    	        						failList.put("pspno", ""); //덴소품번
		    	        					}
		    	        					else if(f==3) failList.put("plndt", dtPlndt); //일자 (구분자있는 형식)
		    	        					else if(f==4) failList.put("basqy", StringUtils.isEmpty(tempMap.get(excelRow3[4]))?"0":tempMap.get(excelRow3[4])); //수량
		    	        					else if(f==12) failList.put("ponum", tempMap.get(excelRow3[12])); //PO 번호 
		    	        					else failList.put("col" + f, replaceCol(tempMap.get(excelRow3[f])));		
		    	        				}
		    	        				
		    	        				domain.setFailList(failList);
		    	            		}
		    	            		else getData1(tempMap, domain, getCCTypcd, getCCTypGbcd);        	
		    	            	}
			   	            }
		    	            
				           	if(domain.getSucList() != null) sList.add(domain.getSucList());
				           	if(domain.getFailList() != null) fList.add(domain.getFailList());
			    
			            	excelCnt++;
			            }        
			            
			            System.out.println("excelDataProcess > excelCnt : " + excelCnt + " sucCount : " + sList.size() + "  failCnt : " + fList.size());
			            
			            
			            // 정상건에 대해
			            
			            if(sList.size() > 0) {
				           	//일일판매계획 삭제
			            	int cntSVZ600PF = nonOrderHostUpService.countSVZ600PF(domain);	            	
			            	if(cntSVZ600PF > 0) nonOrderHostUpService.deleteSVZ600PF(domain);
	
			            	//일일판매계획 재생성
		            		// 미납분처리(확정오더 고객사 양식)
		            		// : 납기계획일자가 기준일자이전의 항목은 기준일자로 합계하여 수주계획을 수립
		            		if(domain.getTypcd().equals("CC") && !getCCTypcd.equals("1")) domain.setTgubn("2");
		            		else domain.setTgubn("1");			            	
			            	nonOrderHostUpService.createSVZ600PF(domain);
			            	
			            	
			            	// SVZ603PF (PERIOD MASTER) 에 수주갱신기간 INSERT  
		
							//PERIOD MASTER 삭제
			            	int cntSVZ603PF = nonOrderHostUpService.countSVZ603PF(domain);	            	
			            	if(cntSVZ603PF > 0) nonOrderHostUpService.deleteSVZ603PF(domain);
			            	
			            	//PERIOD MASTER 재생성 
			            	if(domain.getTypcd().equals("CC") && !getCCTypcd.equals("1")) {
			            		// 등록된 일자 확인
	    	        			NonOrderHostUpDomain getPERIOD = nonOrderHostUpService.selectPERIOD(domain);
	    	        			
	    	        			if(getPERIOD != null && getPERIOD.getEnplndt() != null && !getPERIOD.getEnplndt().equals("")){    							
	    							Date stDate = null;
	    							Date enDate = null;
	    							
	    							try {
	    								// 고객사 기준일자 자동계산 : 기준일자를 기준으로 계산하도록 처리.
	    								//stDate = sdf.parse(getPERIOD.getStplndt());
	    								stDate = sdf.parse(domain.getPlndt());	    								
	    								enDate = sdf.parse(getPERIOD.getEnplndt());
	    							} catch (java.text.ParseException e) {
	    								// TODO Auto-generated catch block
	    								e.printStackTrace();
	    							} 
	    									
	    							Calendar cal = Calendar.getInstance();
	    							cal.setTime(stDate);
	    							
	    							// 일수 계산
	    							long diff = enDate.getTime() - stDate.getTime();
	    					    	long period = diff / (24 * 60 * 60 * 1000);
	    					    	
	    					    	// MAX 일수 처리
	    					    	if(period < 0) period = 0;
	    					    	else if(period > maxPeriod) period = maxPeriod;
	    					    	
	    					    	//getPlndt = getPERIOD.getStplndt();
	    					    	getPeriod = Long.toString(period);
	    					    	domain.setPeriod(getPeriod);
	    					    	
	    					    	/*
		    				        if(getPlndt != null) {
		    							try {
		    								getPlndt = listFormat.format(sdf.parse(getPlndt));
		    							} catch (java.text.ParseException e) {
		    								// TODO Auto-generated catch block
		    								e.printStackTrace();
		    							}
		    				        } 
		    				        */   					    	
	    	        			}
			            	}
			            	nonOrderHostUpService.createSVZ603PF(domain);
			            }
			            
			            
			            //System.out.println(sList.toString());
			            
			            result = "업로드 성공하였습니다.(총:" + excelCnt + ", 정상:" + sList.size() + ", ERROR:" + fList.size();
		            }catch(Exception e){
		            	e.printStackTrace();
		            	
		                // 타이틀행 없음 : 확정오더 - HMC CKD
		            	int excelErrorRow = 0;	//오류 data행 재계산 : IT
		                if(domain.getTypcd().equals("CC") && getCCTypcd.equals("2")) {
		                	excelCnt = excelCnt + 1;
		                	excelErrorRow = excelCnt - 1;
		                }
		                else {
		                	excelCnt = excelCnt + 2;
		                	excelErrorRow = excelCnt - 2;
		                }
		            	result = "업로드 파일 데이터를 확인해 주세요. : " + excelCnt + "행"+ " \\r\\n(※서버메시지:" + e.getMessage()+")";
		            	System.out.println("비서열업로드 에러DATA : " + excelData.get(excelErrorRow));
		            	
		            	// WORK FILE 등록 자료 삭제.
    	    	    	NonOrderHostUpDomain delSVZ60PFDomain2 = new NonOrderHostUpDomain();
    	    	    	delSVZ60PFDomain2.setComps(domain.getComps());
    	    	    	delSVZ60PFDomain2.setTypcd(domain.getTypcd());
    	    	    	delSVZ60PFDomain2.setPyvnd(domain.getPyvnd());
    	    	    	delSVZ60PFDomain2.setLib1(domain.getLib1());
    	    	    	delSVZ60PFDomain2.setLib2(domain.getLib2());
    	            	
    	            	int cntSVZ60PF2 = nonOrderHostUpService.countSVZ60PF(delSVZ60PFDomain2);   
    	            	if(cntSVZ60PF2 > 0) nonOrderHostUpService.deleteSVZ60PF(delSVZ60PFDomain2);
    	            	
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
        mv.setViewName(".tiles.page.WAN015");
        mv.addObject("tabId", tabId);
        mv.addObject("result", result);
        mv.addObject("comps", getComps); 
        mv.addObject("typcd", getTypcd);
        mv.addObject("ccTypcd", getCCTypcd);
        mv.addObject("ccTypGbcd", getCCTypGbcd);
        mv.addObject("pyvnd", getPyvnd);
        mv.addObject("cusnm", getCusnm);
        mv.addObject("plndt", getPlndt);
        mv.addObject("period", getPeriod);
        mv.addObject("sucList", sList);
        mv.addObject("failList", fList);
        return mv;
    }

    private NonOrderHostUpDomain getData(Map<String, String> map, NonOrderHostUpDomain domain) throws ApplicationException{
    	JSONObject sucList = new JSONObject();
    	JSONObject failList = new JSONObject();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date plndt = null;
		try {
			plndt = sdf.parse(domain.getPlndt());
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
		Calendar cal = Calendar.getInstance();
		cal.setTime(plndt);
    	
    	domain.setSucList(null);
    	domain.setFailList(null);
    	
    	String errCHK = "";
    	
    	// *** 공통양식의 필수 항목 validation 변경 → (업체코드[0],  덴소품번[5])
    	
    	//String cusno = map.get(excelRow[0]); // 고객코드
    	//domain.setPsvnd(cusno);
    	String cusno = domain.getPyvnd(); 
    	//String cprtn = map.get(excelRow[4]); // 고객품번
    	String cprtn = map.get(excelRow[5]); // 덴소품번
    	
    	String outqy = StringUtils.isEmpty(map.get(excelRow[7]))?"0":map.get(excelRow[7]); //적입량
    	
	    if(cusno.equals(map.get(excelRow[0]))) { // 화면조건의 업체와 엑셀자료의 업체코드 매칭 확인

	    	NonOrderHostUpDomain selEM000PRDomain = new NonOrderHostUpDomain();
	    	selEM000PRDomain.setCusno(cusno);  // CUSTOMER NO.
	    	selEM000PRDomain.setCprtn(cprtn);  // CUSTOMER PART NO.
	    	selEM000PRDomain.setPrtgb("D");    // 덴소품번으로 업체품번 확인
	    	selEM000PRDomain.setLib1(domain.getLib1());
	    	selEM000PRDomain.setLib2(domain.getLib2());	        	
		    NonOrderHostUpDomain getEM000PR = nonOrderHostUpService.selectEM000PR(selEM000PRDomain);
		        
		    // Part No. Cross Reference MA
			if(getEM000PR != null && getEM000PR.getPrtno() != null && !getEM000PR.getPrtno().equals("")){
	
				NonOrderHostUpDomain cntMST100PFDomain = new NonOrderHostUpDomain();
				cntMST100PFDomain.setComps(domain.getComps());      // 사업부
				cntMST100PFDomain.setPrtno(getEM000PR.getPrtno());  // PART NO. (품번)
				cntMST100PFDomain.setLib1(domain.getLib1());
				cntMST100PFDomain.setLib2(domain.getLib2());
		       	int cntMST100PF = nonOrderHostUpService.countMST100PF(cntMST100PFDomain);
		
		       	// 품목정보마스타
				if(cntMST100PF > 0){
					
					// 중복자료 확인
					// 덴소품번별로 기준일자에서 처리기간까지 데이터 생성 (null 도 0으로 등록)
					// -> 동일품번이 등록되어 있으면 중복자료로 확인함.
	    	    	NonOrderHostUpDomain chkSVZ60PFDomain = new NonOrderHostUpDomain();
	    	    	chkSVZ60PFDomain.setComps(domain.getComps());
	    	    	chkSVZ60PFDomain.setTypcd(domain.getTypcd());
	    	    	chkSVZ60PFDomain.setPyvnd(cusno);
	    	    	chkSVZ60PFDomain.setShpto(0);
	    	    	chkSVZ60PFDomain.setPspno(getEM000PR.getPrtno());
	    	    	chkSVZ60PFDomain.setLib1(domain.getLib1());
	    	    	chkSVZ60PFDomain.setLib2(domain.getLib2());	        	
	            	 
					int cntSVZ60PF = nonOrderHostUpService.countSVZ60PF(chkSVZ60PFDomain); 
					if(cntSVZ60PF > 0) {
						errCHK = "3";
					}
					else {
			           	errCHK = "T";
				            	
						sucList.put("cusno", cusno); //고객코드
						sucList.put("col1",  map.get(excelRow[1])); //고객명
						sucList.put("faccd", map.get(excelRow[2])); //생산공장
						sucList.put("yard",  map.get(excelRow[3])); //하치장
						sucList.put("cprtn", getEM000PR.getCprtn()); //고객품번
						sucList.put("pspno", getEM000PR.getPrtno()); //덴소품번
						sucList.put("cpdsc", replaceCol(getEM000PR.getCpdsc())); //품명
						sucList.put("outqy", outqy); //적입량
					    	
						int cntdt = Integer.parseInt(domain.getPeriod());
						for (int i=0; i<cntdt; i++) {
							if(i <= 13) {
								sucList.put("do" + i + "qy", StringUtils.isEmpty(map.get(excelRow[i+8]))?"0":map.get(excelRow[i+8])); //D ~ D+13						
		
								// 비서열 테이블에 저장.
								JSONObject insList = new JSONObject();
									
								insList.put("comps", domain.getComps()); //사업부
								insList.put("typcd", domain.getTypcd()); //구분
								insList.put("pyvnd", cusno); //업체코드
								insList.put("shpto", 0); //SHIP TO
								insList.put("pspno", getEM000PR.getPrtno()); //덴소품번
									
								if(i > 0) cal.add(cal.DATE, 1);
								insList.put("plndt", sdf.format(cal.getTime())); //계획일자
									
								insList.put("basqy", StringUtils.isEmpty(map.get(excelRow[i+8]))?"0":map.get(excelRow[i+8])); //계획수량
								insList.put("ponum", cusno); //PO번호	
								
								insList.put("faccd", map.get(excelRow[2])); //생산공장
								insList.put("yard",  map.get(excelRow[3])); //하치장
								insList.put("outqy", outqy); //적입량
								
								insList.put("inpid", domain.getInpid()); //등록자ID 
			
								
								//VAN DATA  WORK FILE 등록							
								NonOrderHostUpDomain domainSVZ60PF = new Gson().fromJson(insList.toJSONString(), NonOrderHostUpDomain.class);								
								nonOrderHostUpService.createSVZ60PF(domainSVZ60PF);
							}
						}
							
						domain.setSucList(sucList);
					}
				}else{
					errCHK = "1"; //품번 비매칭
				}
	        }else{
				errCHK = "2"; //고객품번 비매칭
			}			
    	}else {
    		errCHK = "5"; //업체코드 비매칭
    	}
	        
        if(errCHK != "T"){
        	//ERROR
        	if(errCHK.equals("1")) failList.put("ERROR", "품번 비매칭"); 	        	
        	else if(errCHK.equals("2")) failList.put("ERROR", "고객품번 비매칭");
        	else if(errCHK.equals("3")) failList.put("ERROR", "중복DATA");
        	else if(errCHK.equals("5")) failList.put("ERROR", "업체코드 비매칭");
	        
        	//고객코드
        	if(errCHK.equals("5")) failList.put("cusno", map.get(excelRow[0]));
        	else failList.put("cusno", cusno);
        	
        	failList.put("col1",  map.get(excelRow[1])); //고객명
        	failList.put("faccd", map.get(excelRow[2])); //생산공장
        	failList.put("yard",  map.get(excelRow[3])); //하치장
        	failList.put("cprtn", map.get(excelRow[4])); //고객품번
        	failList.put("pspno", map.get(excelRow[5])); //덴소품번
        	failList.put("cpdsc", replaceCol(map.get(excelRow[6]))); //품명
        	failList.put("outqy", outqy); //적입량
	        	
        	int cntdt = Integer.parseInt(domain.getPeriod());
			for (int i=0; i<cntdt; i++) {
				if(i <= 13) failList.put("do" + i + "qy", StringUtils.isEmpty(map.get(excelRow[i+8]))?"0":map.get(excelRow[i+8])); //D ~ D+13
			}
				
			domain.setFailList(failList);
        }
    	
        return domain;
    }

    private NonOrderHostUpDomain getData1(Map<String, String> map, NonOrderHostUpDomain domain, String ccTypcd, String getCCTypGbcd) throws ApplicationException{
    	JSONObject sucList = new JSONObject();
    	JSONObject failList = new JSONObject();
    	    	    
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  	
    	
    	domain.setSucList(null);
    	domain.setFailList(null);
    	
    	String errCHK = "";
    	//String cusno = ""; // 고객코드
    	String cusno = domain.getPyvnd(); 
    	//String faccd = ""; // 공장구분    	
    	String ponum = ""; // PO번호    	
    	String cprtn = ""; // 고객품번    	
    	String plndt = ""; // 일자
    	String basqy = ""; // 수량
    	
    	String mobisAsLine = ""; // MOBIS AS 에서 품번 확인을 위한 구분값 -> 계열(신양식-SRS) / 발주번호(구양식-SPIN)
    	
    	//확정오더 - HMC CKD (2)
    	//확정오더 - KMC CKD (3)
    	//확정오더 - MOBIS CKD (4)
    	//확정오더 - MOBIS AS (5)
    	//확정오더 - GLOVIS (6)        
    	if(ccTypcd.equals("2")) {
    		//창원
    		if(getCCTypGbcd.equals("2A")) {
	    		//faccd = "HK11";	//map.get(excelRow2[3]); // 공장구분(HK11)
	        	
	        	ponum = map.get(excelRow2A[15]); // PO번호    	
	        	cprtn = map.get(excelRow2A[5]); // 고객품번    	
	        	plndt = replaceColDt(map.get(excelRow2A[12])); // 일자
	        	 
	        	basqy = StringUtils.isEmpty(map.get(excelRow2A[10]))?"0":map.get(excelRow2A[10]); //수량
    		}
    		//화성
    		if(getCCTypGbcd.equals("2B")) {
	    		//faccd = "";	// 공장구분

	        	ponum = map.get(excelRow2B[11]); // PO번호
	        	cprtn = map.get(excelRow2B[2]); // 고객품번
	        	plndt = replaceColDt(map.get(excelRow2B[8])); // 일자
	        	
	        	basqy = StringUtils.isEmpty(map.get(excelRow2B[6]))?"0":map.get(excelRow2B[6]); //수량
    		}
    	}
    	else if(ccTypcd.equals("3")) {
    		//faccd = "HV21";	// 공장구분
        	
        	ponum = map.get(excelRow3[12]); // PO번호    	
        	cprtn = map.get(excelRow3[0]); // 고객품번    	
        	plndt = replaceColDt(map.get(excelRow3[3])); // 일자
        	
        	basqy = StringUtils.isEmpty(map.get(excelRow3[4]))?"0":map.get(excelRow3[4]); //수량
    	}
    	else if(ccTypcd.equals("4")) {
    		//faccd = "HV12";	// 공장구분
        	   	
        	ponum = map.get(excelRow4[2]); // PO번호    	
        	cprtn = map.get(excelRow4[6]); // 고객품번    	
        	plndt = replaceColDt(map.get(excelRow4[8])); // 일자
        	
        	basqy = StringUtils.isEmpty(map.get(excelRow4[12]))?"0":map.get(excelRow4[12]); //수량
    	}
    	else if(ccTypcd.equals("5")) {
    		//faccd = "HM21";	// 공장구분
    		
    		//신양식
    		if(getCCTypGbcd.equals("5A")) {
	        	ponum = map.get(excelRow5A[11]); // PO번호
	        	cprtn = map.get(excelRow5A[1]); // 고객품번
	        	plndt = replaceColDt(map.get(excelRow5A[30])); // 일자
	
	        	basqy = StringUtils.isEmpty(map.get(excelRow5A[33]))?"0":map.get(excelRow5A[33]); //수량
	        	
	        	mobisAsLine = map.get(excelRow5A[4]).substring(0, 1); // 계열
    		}
    		//구양식
    		if(getCCTypGbcd.equals("5B")) {
	        	ponum = map.get(excelRow5B[10]); // PO번호    	
	        	cprtn = map.get(excelRow5B[1]); // 고객품번 	
	        	plndt = replaceColDt(map.get(excelRow5B[20])); // 일자
	        	
	        	basqy = StringUtils.isEmpty(map.get(excelRow5B[24]))?"0":map.get(excelRow5B[24]); //수량
	        	
	        	mobisAsLine = map.get(excelRow5B[10]).substring(0, 1); // 발주번호
    		}
    	}
    	else if(ccTypcd.equals("6")) {
    		//faccd = "KV22";	// 공장구분
        	    	
        	ponum = map.get(excelRow6[0]); // PO번호    	
        	cprtn = map.get(excelRow6[2]); // 고객품번    	
        	plndt = replaceColDt(map.get(excelRow6[4])); // 일자
        	
        	basqy = StringUtils.isEmpty(map.get(excelRow6[6]))?"0":map.get(excelRow6[6]); //수량  		
    	}
    	
    	
    	SimpleDateFormat listFormat = new SimpleDateFormat("yyyy-MM-dd");
    	String dtPlndt = "";
		try {
			dtPlndt = listFormat.format(sdf.parse(plndt));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

	    NonOrderHostUpDomain selEM000PRDomain = new NonOrderHostUpDomain();
	    selEM000PRDomain.setCusno(cusno);  // CUSTOMER NO.
	    selEM000PRDomain.setCprtn(cprtn);  // CUSTOMER PART NO.
	    selEM000PRDomain.setPrtgb("C");    // 업체품번으로 덴소품번 확인
	    
    	//확정오더 - HMC CKD (2)
    	//확정오더 - KMC CKD (3)
    	//확정오더 - MOBIS CKD (4)
    	//확정오더 - MOBIS AS (5)
    	//확정오더 - GLOVIS (6)        
    	if(ccTypcd.equals("2")) selEM000PRDomain.setLingb("1");
    	else if(ccTypcd.equals("3")) selEM000PRDomain.setLingb("1");
    	else if(ccTypcd.equals("4")) selEM000PRDomain.setLingb("1");    	
	    // MOBIS AS 에서 품번 확인을 위한 구분값 ('D'이면 덴소품번 끝에서 2번째자리 '3', 'E'이면 덴소품번 끝에서 2번째자리 '4' 매칭)
    	else if(ccTypcd.equals("5")) {
    		if(mobisAsLine.equals("D")) selEM000PRDomain.setLingb("3");
    		else if(mobisAsLine.equals("E")) selEM000PRDomain.setLingb("4");
    	}
    	else if(ccTypcd.equals("6")) {
    		// 마산 : 1, 그외 : 0
    		if(domain.getComps().equals("E1")) selEM000PRDomain.setLingb("1");
    		else selEM000PRDomain.setLingb("0");
    	}
	    
	    selEM000PRDomain.setLib1(domain.getLib1());
	    selEM000PRDomain.setLib2(domain.getLib2());	        	
	    NonOrderHostUpDomain getEM000PR = nonOrderHostUpService.selectEM000PR(selEM000PRDomain);
	    
	    // Part No. Cross Reference MA
	    if(getEM000PR != null && getEM000PR.getPrtno() != null && !getEM000PR.getPrtno().equals("")){

			NonOrderHostUpDomain cntMST100PFDomain = new NonOrderHostUpDomain();
			cntMST100PFDomain.setComps(domain.getComps());      // 사업부
			cntMST100PFDomain.setPrtno(getEM000PR.getPrtno());  // PART NO. (품번)
			cntMST100PFDomain.setLib1(domain.getLib1());
			cntMST100PFDomain.setLib2(domain.getLib2());
	    	int cntMST100PF = nonOrderHostUpService.countMST100PF(cntMST100PFDomain);
	    	
	    	// 품목정보마스타
	    	if(cntMST100PF > 0){
	    		
				// 확정오더 테이블에 저장.
				JSONObject insList = new JSONObject();
						
				insList.put("comps", domain.getComps()); //사업부
				insList.put("typcd", domain.getTypcd()); //구분
				insList.put("pyvnd", cusno); //업체코드 => 확정오더 : 공장구분에 대한 PS업체코드(1100)로 들어가면 해당 정보만 delete, insert 처리 안됨.
				//insList.put("pyvnd", faccd); //공장구분 => 문자열 오류 발생.  
				insList.put("shpto", 0); //SHIP TO
				insList.put("pspno", getEM000PR.getPrtno()); //덴소품번							
				insList.put("plndt", plndt); //계획일자							
				insList.put("basqy", basqy); //계획수량
				insList.put("ponum", ponum); //PO번호			
				
				insList.put("faccd", ""); //생산공장
				insList.put("yard", ""); //하치장
				insList.put("outqy", "0"); //적입량
				
				insList.put("inpid", domain.getInpid()); //등록자ID 

				//VAN DATA  WORK FILE 등록
				NonOrderHostUpDomain domainSVZ60PF = new Gson().fromJson(insList.toJSONString(), NonOrderHostUpDomain.class);							
                int cntSVZ60PF = nonOrderHostUpService.countSVZ60PF(domainSVZ60PF);
                if(cntSVZ60PF > 0) {
                	errCHK = "3"; //계획일자에 대한 중복DATA
                }
                else {
					errCHK = "T";
                }
                
			    //확정오더 - HMC CKD (2)
			    //확정오더 - KMC CKD (3)
			    //확정오더 - MOBIS CKD (4)
			    //확정오더 - MOBIS AS (5)
			    //확정오더 - GLOVIS (6)        
			    if(ccTypcd.equals("2")) {
			    	//창원
			    	if(getCCTypGbcd.equals("2A")) {
						for (int j=0; j<=55; j++) {
							if(j==5) {
								sucList.put("cprtn", getEM000PR.getCprtn()); //고객품번
								sucList.put("pspno", getEM000PR.getPrtno()); //덴소품번
							}
							else if(j==10) sucList.put("basqy", basqy); //수량
							else if(j==12) sucList.put("plndt", dtPlndt); //일자 (구분자있는 형식)
							else if(j==15) sucList.put("ponum", ponum); //PO번호
							else sucList.put("col" + j, replaceCol(map.get(excelRow2A[j])));		
						}
			    	}
			    	//화성
			    	if(getCCTypGbcd.equals("2B")) {
						//for (int j=0; j<=49; j++) {
				   		for (int j=0; j<=41; j++) {	// 숨김열 제외
							if(j==2) {
								sucList.put("cprtn", getEM000PR.getCprtn()); //고객품번
								sucList.put("pspno", getEM000PR.getPrtno()); //덴소품번
							}
							else if(j==6) sucList.put("basqy", basqy); //수량
							else if(j==8) sucList.put("plndt", dtPlndt); //일자 (구분자있는 형식)							
							else if(j==11) sucList.put("ponum", ponum); //PO 번호 
							else sucList.put("col" + j, replaceCol(map.get(excelRow2B[j])));		
						}
			    	}
			    }
			    else if(ccTypcd.equals("3")) {
					for (int j=0; j<=16; j++) {
						if(j==0) {
							sucList.put("cprtn", getEM000PR.getCprtn()); //고객품번
							sucList.put("pspno", getEM000PR.getPrtno()); //덴소품번
						}
						else if(j==3) sucList.put("plndt", dtPlndt); //일자 (구분자있는 형식)
						else if(j==4) sucList.put("basqy", basqy); //수량
						else if(j==12) sucList.put("ponum", ponum); //PO 번호 
						else sucList.put("col" + j, replaceCol(map.get(excelRow3[j])));		
					}
			    }
			    else if(ccTypcd.equals("4")) {
					for (int j=0; j<=22; j++) {
						if(j==2) sucList.put("ponum", ponum); //PO 번호 										
						else if(j==6) {
							sucList.put("cprtn", getEM000PR.getCprtn()); //고객품번
							sucList.put("pspno", getEM000PR.getPrtno()); //덴소품번
						}
						else if(j==8) sucList.put("plndt", dtPlndt); //일자 (구분자있는 형식)
						else if(j==12) sucList.put("basqy", basqy); //수량
						else sucList.put("col" + j, replaceCol(map.get(excelRow4[j])));		
					}	
			    }
			    else if(ccTypcd.equals("5")) {
			    	//신양식
			    	if(getCCTypGbcd.equals("5A")) {
				   		for (int j=0; j<=76; j++) {
							if(j==1) {
								sucList.put("cprtn", getEM000PR.getCprtn()); //고객품번
								sucList.put("pspno", getEM000PR.getPrtno()); //덴소품번
							}										
							else if(j==11) sucList.put("ponum", ponum); //PO 번호										
							else if(j==30) sucList.put("plndt", dtPlndt); //일자 (구분자있는 형식)										
							else if(j==33) sucList.put("basqy", basqy); //수량										
							else sucList.put("col" + j, replaceCol(map.get(excelRow5A[j])));		
						}
			    	}
			    	//구양식
			    	if(getCCTypGbcd.equals("5B")) {
				   		for (int j=0; j<=67; j++) {
							if(j==1) {
								sucList.put("cprtn", getEM000PR.getCprtn()); //고객품번
								sucList.put("pspno", getEM000PR.getPrtno()); //덴소품번
							}										
							else if(j==10) sucList.put("ponum", ponum); //PO 번호									
							else if(j==20) sucList.put("plndt", dtPlndt); //일자 (구분자있는 형식)									
							else if(j==24) sucList.put("basqy", basqy); //수량										
							else sucList.put("col" + j, replaceCol(map.get(excelRow5B[j])));		
						}
			    	}
			    }
			    else if(ccTypcd.equals("6")) {
					for (int j=0; j<=10; j++) {
						if(j==0) sucList.put("ponum", ponum); //PO 번호									
						else if(j==2) {
							sucList.put("cprtn", getEM000PR.getCprtn()); //고객품번
							sucList.put("pspno", getEM000PR.getPrtno()); //덴소품번
						}
						else if(j==4) sucList.put("plndt", dtPlndt); //일자 (구분자있는 형식)
						else if(j==6) sucList.put("basqy", basqy); //수량										
						else sucList.put("col" + j, replaceCol(map.get(excelRow6[j])));		
					}
			    }
				
			    domain.setSucList(sucList);
			    
				if(errCHK == "T") {
					nonOrderHostUpService.createSVZ60PF(domainSVZ60PF);
				}
				// 중복 자료에 대한 처리 -> 동일 업체, 품번, 납기일자 자료 SUM
				else if(errCHK == "3") {
					errCHK = "T";
					
					nonOrderHostUpService.updateSVZ602PF(domainSVZ60PF);
				}
			
			}else{
				errCHK = "1"; //품번 비매칭
			}
		}else{
			errCHK = "2"; //고객품번 비매칭
		}
		    

		if(errCHK != "T"){
		   	//ERROR
		   	if(errCHK.equals("1")) failList.put("ERROR", "품번 비매칭"); 	        	
		   	else if(errCHK.equals("2")) failList.put("ERROR", "고객품번 비매칭");
		   	else if(errCHK.equals("3")) failList.put("ERROR", "중복DATA");
		    
			//확정오더 - HMC CKD (2)
			//확정오더 - KMC CKD (3)
			//확정오더 - MOBIS CKD (4)
			//확정오더 - MOBIS A/S (5)
			//확정오더 - GLOVIS (6)        
			if(ccTypcd.equals("2")) {
				//창원
				if(getCCTypGbcd.equals("2A")) {
					for (int f=0; f<=55; f++) {
						if(f==5) {
							failList.put("cprtn", cprtn); //고객품번
							failList.put("pspno", ""); //덴소품번
						}
						else if(f==10) failList.put("basqy", basqy); //수량
						else if(f==12) failList.put("plndt", dtPlndt); //일자 (구분자있는 형식)
						else if(f==15) failList.put("ponum", ponum); //PO번호
						else failList.put("col" + f, replaceCol(map.get(excelRow2A[f])));		
					}
				}
				//화성
				if(getCCTypGbcd.equals("2B")) {
					//for (int j=0; j<=49; j++) {
		    		for (int f=0; f<=41; f++) {	// 숨김열 제외
						if(f==2) {
							failList.put("cprtn", cprtn); //고객품번
							failList.put("pspno", ""); //덴소품번
						}
						else if(f==6) failList.put("basqy", basqy); //수량
						else if(f==8) failList.put("plndt", dtPlndt); //일자 (구분자있는 형식)							
						else if(f==11) failList.put("ponum", ponum); //PO 번호 
						else failList.put("col" + f, replaceCol(map.get(excelRow2B[f])));		
					}
				}
			}
			else if(ccTypcd.equals("3")) {
				for (int f=0; f<=16; f++) {
					if(f==0) {
						failList.put("cprtn", cprtn); //고객품번
						failList.put("pspno", ""); //덴소품번
					}
					else if(f==3) failList.put("plndt", dtPlndt); //일자 (구분자있는 형식)
					else if(f==4) failList.put("basqy", basqy); //수량
					else if(f==12) failList.put("ponum", ponum); //PO 번호 
					else failList.put("col" + f, replaceCol(map.get(excelRow3[f])));		
				}
			}
			else if(ccTypcd.equals("4")) {
				for (int f=0; f<=22; f++) {
					if(f==2) failList.put("ponum", ponum); //PO 번호 										
					else if(f==6) {
						failList.put("cprtn", cprtn); //고객품번
						failList.put("pspno", ""); //덴소품번
					}
					else if(f==8) failList.put("plndt", dtPlndt); //일자 (구분자있는 형식)
					else if(f==12) failList.put("basqy", basqy); //수량
					else failList.put("col" + f, replaceCol(map.get(excelRow4[f])));		
				}
			}
			else if(ccTypcd.equals("5")) {
				//신양식
				if(getCCTypGbcd.equals("5A")) {
					for (int f=0; f<=76; f++) {
						if(f==1) {
							failList.put("cprtn", cprtn); //고객품번
							failList.put("pspno", ""); //덴소품번
						}										
						else if(f==11) failList.put("ponum", ponum); //PO 번호										
						else if(f==30) failList.put("plndt", dtPlndt); //일자 (구분자있는 형식)										
						else if(f==33) failList.put("basqy", basqy); //수량										
						else failList.put("col" + f, replaceCol(map.get(excelRow5A[f])));
					}
				}
				//구양식
				if(getCCTypGbcd.equals("5B")) {
				    for (int f=0; f<=67; f++) {
						if(f==1) {
							failList.put("cprtn", cprtn); //고객품번
							failList.put("pspno", ""); //덴소품번
						}										
						else if(f==10) failList.put("ponum", ponum); //PO 번호									
						else if(f==20) failList.put("plndt", dtPlndt); //일자 (구분자있는 형식)									
						else if(f==24) failList.put("basqy", basqy); //수량										
						else failList.put("col" + f, replaceCol(map.get(excelRow5B[f])));
					} 
				}
			}
			else if(ccTypcd.equals("6")) {
				for (int f=0; f<=10; f++) {
					if(f==0) failList.put("ponum", ponum); //PO 번호									
					else if(f==2) {
						failList.put("cprtn", cprtn); //고객품번
						failList.put("pspno", ""); //덴소품번
					}
					else if(f==4) failList.put("plndt", dtPlndt); //일자 (구분자있는 형식)
					else if(f==6) failList.put("basqy", basqy); //수량										
					else failList.put("col" + f, replaceCol(map.get(excelRow6[f])));		
				}
			}
	
			domain.setFailList(failList);
	    }
    	    	
        return domain;
    }
    
    public String replaceColDt(String col){
    	// 구분자 없는 일자
		return col.replaceAll("-", "").substring(0, 8);
    }
    
    public String replaceCol(String col){
    	// 데이터상(테스트 시 MOBIS A/S 자료)에서 "종결되지 않은 문자열 상수입니다." 오류 발생. &#39; &quot;
    	return col.replaceAll("\\'", " ").replaceAll("\\\"", " ");
    }
}
