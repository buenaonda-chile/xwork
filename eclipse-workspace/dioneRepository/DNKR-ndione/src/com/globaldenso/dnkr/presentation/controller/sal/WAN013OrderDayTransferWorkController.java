package com.globaldenso.dnkr.presentation.controller.sal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.OrderDayTransferWorkService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.domain.OrderDayTransferWorkDomain;
import com.globaldenso.dnkr.domain.OrderTransferMngDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Message;
import com.ibm.as400.access.AS400Text;
import com.ibm.as400.access.ProgramCall;
import com.ibm.as400.access.ProgramParameter;


/**
 * [KR] 서열형 일일 수주이관 작업  컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN013OrderDayTransferWork")
@ViewId(value = "WAN013")
public class WAN013OrderDayTransferWorkController {

    /**
     * [KR] 서열형 일일 수주이관 작업 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private OrderDayTransferWorkService orderDayTransferWorkService;    
    
    
    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN013OrderDayTransferWorkController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request)  throws Exception {

        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        UxisCmmUtil.getSessionComCode(request, mv);

        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기       
        EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        mv.addObject("userId", empInfo.getEmpNumber());
        
        // 날짜 취득을 위해 초기 고정값
        String getComps = "E1";
        
        CommonDb2Domain empInfo2 = new CommonDb2Domain();

    	// LIB 셋팅
    	if(getComps.equals(DnkrConstans.COMPS_MASAN)) {
    		empInfo2.setLib1(DnkrConstans.DNKE_LIB1);
    		empInfo2.setLib2(DnkrConstans.DNKE_LIB2);
    	} else {
    		empInfo2.setLib1(DnkrConstans.DNKA_LIB1);
    		empInfo2.setLib2(DnkrConstans.DNKA_LIB2);
    	}
        
        SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String today = datafmt.format(calendar.getTime());
        mv.addObject("today", today);
        

        List<? extends OrderDayTransferWorkDomain> domainlist = null;
	        
        OrderDayTransferWorkDomain criteria = new OrderDayTransferWorkDomain();
        criteria.setLib1(empInfo2.getLib1());
        criteria.setLib2(empInfo2.getLib2());

        domainlist = orderDayTransferWorkService.searchCigmaDate(criteria);
	
        if(domainlist != null) {
        	String cigmaDate = domainlist.get(0).getAdsdt();
        	mv.addObject("cigmaDate", cigmaDate.substring(0, 4) + "-" + cigmaDate.substring(4, 6) + "-" + cigmaDate.substring(6));
        }        
   
        
//      mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "OrderDayTransferWork.jsp");
        mv.setViewName(".tiles.page.WAN013");
        return mv;
        
    }
    
    /**
     * [KO] 자료확인.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/cigmaDate", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void cigmaDate(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();

        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        List<? extends OrderDayTransferWorkDomain> domainlist = null;
        
        OrderDayTransferWorkDomain criteria = new OrderDayTransferWorkDomain();
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());

        domainlist = orderDayTransferWorkService.searchCigmaDate(criteria);
	
        if(domainlist != null) {
        	String cigmaDate = domainlist.get(0).getAdsdt();
        	jsonObj.put("cigmaDate", cigmaDate.substring(0, 4) + "-" + cigmaDate.substring(4, 6) + "-" + cigmaDate.substring(6));
        } 
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
    /**
     * [KO] 자료확인.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/check", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void check(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();

        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");
        String getPlndt = ServletRequestUtils.getStringParameter(request, "getPlndt");

        OrderDayTransferWorkDomain criteria = new OrderDayTransferWorkDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        criteria.setPlndt(getPlndt);
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        int countMST040PF = orderDayTransferWorkService.countMST040PF(criteria);

        if(countMST040PF > 0) jsonObj.put("countMST040PF", "Y");
        else jsonObj.put("countMST040PF", "N");
        
        List<NonOrderHostUpDomain> list = orderDayTransferWorkService.selectSVZ600PF_2(criteria);
        
        String msg = "";
        boolean flag_aa = false;
        boolean flag_bb = false;
        boolean flag_cc = false;
        
        for (NonOrderHostUpDomain domain : list) {
        	if (domain.getTypcd().equals("AA")) {
        		flag_aa = true;
        	} else if (domain.getTypcd().equals("BB")) {
        		flag_bb = true;
        	} else if (domain.getTypcd().equals("CC")) {
        		flag_cc = true;
        	}        	
        }
        
        if (flag_aa) {
        	msg = msg + "서열:등록 ";
        } else {
        	msg = msg + "서열:미등록 ";
        }
        
        if (flag_bb) {
        	msg = msg + "비서열:등록 ";
        } else {
        	msg = msg + "비서열:미등록 ";
        }
        
        if (flag_cc) {
        	msg = msg + "확정오더:등록 ";
        } else {
        	msg = msg + "확정오더:미등록 ";
        }
        
        jsonObj.put("msg", msg);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
    /**
     * [KO] 이관.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    //private static final String HOST = "notes.densokorea.kr";//AS400 IP
    
    @RequestMapping(value = "/trans", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void trans(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();
    	
        String getParam = ServletRequestUtils.getStringParameter(request, "getParam");        
        
        // HISTORY 조건
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        String getPlndt = ServletRequestUtils.getStringParameter(request, "getPlndt");
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");
        String getAdsdt = ServletRequestUtils.getStringParameter(request, "getAdsdt");
        

    	HashMap map = new HashMap();
    	map.put("mi_parm", getParam);
    	
    	String url = UxisCmmUtil.getProperty("jdbc.url4");
    	String id = UxisCmmUtil.getProperty("jdbc.username4");
    	String pwd = UxisCmmUtil.getProperty("jdbc.password4");
    	   	
    	String rtnMsg = "";
    	String idMsg = "";
    	String numMsg = "";
    	       
    	//1. MODE1 자바 바로 호출 
    	//2. MODE2 프로시저 호출 
    	//3. MODE3 AS400
    	int i = 3;
    	
    	// 중복체크 
    	// 처리 스킵
    	OrderDayTransferWorkDomain historyFDomain2 = new OrderDayTransferWorkDomain();
        historyFDomain2.setPlndt(getPlndt);
        historyFDomain2.setComps(getComps);
        historyFDomain2.setPyvnd(getPyvnd);
        
        StringBuffer sb = new StringBuffer();
        List<NonOrderHostUpDomain> list = orderDayTransferWorkService.selectSVZ600PF(historyFDomain2);
        if (list.size() > 0) {
        	i = 4;
        	
        	for (NonOrderHostUpDomain data : list) {
        		
        		sb.append("[");
        		sb.append(data.getComps());
        		sb.append(",");
        		sb.append(data.getPyvnd());
        		sb.append(",");
        		sb.append(data.getPspno());
        		sb.append(",");
        		sb.append(data.getPlndt());
        		sb.append("]");
        	}
        }    	
    	
    	if(i == 1) {
    		
        	// MODE1 
    		
        	Connection con =null;
        	CallableStatement cs = null;
        	boolean rtn = false;
        	String sql = "";	      	
        	
      	  	try {
      	  		//String driver = "com.ibm.as400.access.AS400JDBCDriver";
      	  		//Class.forName(driver);
      	  		con = DriverManager.getConnection(url, id, pwd);
      	  		sql = "{CALL PSEOBJLIB.SPDZ159RC('"+getParam+"')}";
    				System.out.println("sql : " + sql);
      	  		cs = con.prepareCall(sql);  	  			
      	  		rtn = cs.execute();	  	
      	  		//ResultSet rs = cs.executeQuery();		     	  		 	
      	  		}
      	  	catch(Exception e) {
      	  			
      	  		rtn = false;
      	  		System.out.println("=== error : " + e.toString() + " ===");
      	  			
      	  		}
      	  	finally {
      	  			
      	  		cs.close();
      	  		con.close(); 
      	  			
      	  		}
    		if(rtn) {
    		
    			jsonObj.put("rtnMsg", "수주이관 작업 success");
    		
    		}
    		else {
    		
    			jsonObj.put("rtnMsg", "수주이관 작업 error");
    			
    		}
    		
    		
    	}
    	else if(i == 2) {
    		
        	// MODE2
        	boolean rtn = orderDayTransferWorkService.procTrans(map);
    		if(rtn) {
        		
    			jsonObj.put("rtnMsg", "수주이관 작업 success");
    		
    		}
    		else {
    		
    			jsonObj.put("rtnMsg", "수주이관 작업 error");
    			
    		}
    		
    		
    	}
    	else if(i == 3) {
    		
        	// MODE3
    		
			String fullProgramName = "/QSYS.LIB/PSEOBJLIB.LIB/SPDZ159RC.PGM";
    		
        	AS400 as400 = null;
        	ProgramParameter[] parmList;//parameter list witch is accepting AS400 RPG program
        	ProgramCall programCall;
        	try {
        	    // Create an AS400 object
        		// URL 처리
        		url = url.split(";")[0];
        		url = url.split("//")[1];
        		
        		String cigma_id = "";
        		String cigma_pwd = "";
        		// ID,PW 처리 
        		// 1.마산 : CDNPE_REMC
        		// 2.마산외 : CDNPS_REMC
        		if (getComps.equals(DnkrConstans.COMPS_MASAN)) {
        			
        			cigma_id = UxisCmmUtil.getProperty("cigma.username_e");
        			cigma_pwd = UxisCmmUtil.getProperty("cigma.password_e");
        		} else {
        			cigma_id = UxisCmmUtil.getProperty("cigma.username_s");
        			cigma_pwd = UxisCmmUtil.getProperty("cigma.password_s");
        		}
        		
        		as400 = new AS400(url, cigma_id, cigma_pwd);
        		//as400 = new AS400(url, id, pwd);

        	    // Create a parameter list
        	    // The list must have both input and output parameters
        	    parmList = new ProgramParameter[1];

        	    // Convert the Strings to IBM format
        	    AS400Text nametext1 = new AS400Text(72);

        	    //getParam = getParam.replace("E1", "Z1");
        	    
        	    Date today = new Date();
        	    System.out.println(today);
       	    
        	    System.out.println("cigma_id : " +cigma_id);
        	    System.out.println("호출 전 : " +getParam);

        	    // Create the input parameter // get the exact patameter type and length, if not this not be working  
        	    parmList[0] = new ProgramParameter(nametext1.toBytes(getParam),72);
        	    
        	    // Create the output parameter

        	    programCall = new ProgramCall(as400);
        	    programCall.setProgram(fullProgramName, parmList);

        	    if (!programCall.run()) {
        	    	
        	        /**
        	         * If the AS/400 is not run then look at the message list to
        	         * find out why it didn't run.
        	         */
        	        AS400Message[] messageList = programCall.getMessageList();
        	        for (AS400Message message : messageList) {
        	            System.out.println(message.getID() + " - " + message.getText());
        	            
        	        }
        	    } else {
        	        System.out.println("success");
        	        
        	        /**
        	         * Else the program is successfull. Process the output, which
        	         * contains the returned data.
        	         */
        	        //use same parameter type which will be return from AS400 program
        	        AS400Text text1 = new AS400Text(72);
        	        //System.out.println("호출 후 : " + text1.toObject(parmList[0].getOutputData()));
        	        
        	        rtnMsg = String.valueOf(text1.toObject(parmList[0].getOutputData()));
        	        idMsg = rtnMsg.substring(60,70);
        	        numMsg = rtnMsg.substring(70,72);
        	        rtnMsg = rtnMsg.substring(50, 53);

        	    }

        	    as400.disconnectService(AS400.COMMAND);

        	    //-----------------------
        	} catch (Exception e) {
        	    e.printStackTrace();
        	    System.err.println(":: Exception ::" + e.toString());
        	} finally {
        	    try {
        	        // Make sure to disconnect 

        	        if (as400 != null) {
        	            as400.disconnectAllServices();
        	        }
        	    } catch (Exception e) {
        	        System.err.println(":: Exception ::" + e.toString());
        	    }
        	    
        	}
    	    
        	//System.out.println("리턴값 : " + rtnMsg);
        	//System.out.println("사용자 id : "+ idMsg +" = "+ idMsg.replaceAll("[^0-9]", ""));
        	//System.out.println("유저숫자 : " + numMsg);
        	
        	Date today = new Date();
    	    System.out.println(today);
        	
    	    //jsonObj.put("rtnMsg", "수주이관 작업 success");
        	if(rtnMsg.equals("777")) jsonObj.put("rtnMsg", "[" + rtnMsg + "] 초기리턴값이 000 또는 사업부코드가 정상이 아닙니다.");
        	else if(rtnMsg.equals("888")) {        		
        		EmpDomain searchEmpInfo = new EmpDomain();
        		searchEmpInfo.setEmpNumber( idMsg.replaceAll("[^0-9]", ""));
        		EmpDomain getEmpInfo=  empService.searchByKey(searchEmpInfo);
        		jsonObj.put("rtnMsg", "[" + rtnMsg + "] 다른사용자가 사용중입니다. \n 사용자(ID : "+ idMsg + ", 이름 : "+getEmpInfo.getEmpName() +")외 ("+ numMsg +")명 사용중 ");
        	}
        	else if(rtnMsg.equals("999")) {
        		jsonObj.put("rtnMsg", "[" + rtnMsg + "] 정상처리 되었습니다.");
        		
            	//HISTORY 저장
                CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

                OrderDayTransferWorkDomain historyFDomain = new OrderDayTransferWorkDomain();
                historyFDomain.setComps(getComps);            
                historyFDomain.setPyvnd(getPyvnd);
                historyFDomain.setPlndt(getPlndt);
                historyFDomain.setAdsdt(getAdsdt);
                historyFDomain.setLib1(empInfo.getLib1());
                historyFDomain.setLib2(empInfo.getLib2());	        	
            	
            	// 비서열
                historyFDomain.setTypcd("BB");
            	int countHISTORY_BB = orderDayTransferWorkService.countHISTORY(historyFDomain);   
            	if(countHISTORY_BB > 0) orderDayTransferWorkService.deleteHISTORY(historyFDomain);
            	
            	orderDayTransferWorkService.createHISTORY(historyFDomain);
            	
            	// 확정오더
            	historyFDomain.setTypcd("CC");        	
            	int countHISTORY_CC = orderDayTransferWorkService.countHISTORY(historyFDomain);   
            	if(countHISTORY_CC > 0) orderDayTransferWorkService.deleteHISTORY(historyFDomain);
            	
            	orderDayTransferWorkService.createHISTORY(historyFDomain);
            	
            	// CIGMA 수주이관처리후 정상처리(999)인 경우 HISTORY(SVZ613PF) 저장 - 수주이관 현황 모니터링
            	
            	//존재하는지 체크
            	OrderTransferMngDomain orderTransferMngDomain = new OrderTransferMngDomain();
            	orderTransferMngDomain.setComps(getComps); //사업부          
            	orderTransferMngDomain.setPyvnd(getPyvnd); //업체
            	orderTransferMngDomain.setPlndt(getPlndt); //계획일자
            	
                int cnt = orderDayTransferWorkService.searchSVZ613PF(orderTransferMngDomain);
                
                // 존재 체크
                OrderDayTransferWorkDomain criteria = new OrderDayTransferWorkDomain();
                criteria.setComps(getComps);
                criteria.setPyvnd(getPyvnd);
                criteria.setPlndt(getPlndt);
                criteria.setLib1(empInfo.getLib1());
                criteria.setLib2(empInfo.getLib2());
                               
                List<NonOrderHostUpDomain> list2 = orderDayTransferWorkService.selectSVZ600PF_2(criteria);
                
                boolean flag_aa = false;
                boolean flag_bb = false;
                boolean flag_cc = false;
                
                for (NonOrderHostUpDomain domain : list2) {
                	if (domain.getTypcd().equals("AA")) {
                		flag_aa = true;
                	} else if (domain.getTypcd().equals("BB")) {
                		flag_bb = true;
                	} else if (domain.getTypcd().equals("CC")) {
                		flag_cc = true;
                	}        	
                }
                
                
                if(cnt > 0) {
                	// 존재하면 업데이트
                	
                	// 있으면 1, 없으면 0
                	if (flag_aa) {
                		orderTransferMngDomain.setStcd1("1");  //서열
                	} else {
                		orderTransferMngDomain.setStcd1("0");  //서열
                	}
                	
                	if (flag_bb) {
                		orderTransferMngDomain.setStcd2("1");  //비서열
                	} else {
                		orderTransferMngDomain.setStcd2("0");  //비서열
                	}
                	
                	if (flag_cc) {
                		orderTransferMngDomain.setStcd3("1");  //확정오더
                	} else {
                		orderTransferMngDomain.setStcd3("0");  //확정오더
                	}                	
                	
                	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
                	SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
                	Date time = new Date();
                	String time1 = format1.format(time);
                	String time2 = format2.format(time);               	
                	
                	// 현재시간
                	orderTransferMngDomain.setMagdt(time1);  //GIGMA수주갱신일자
                	orderTransferMngDomain.setMagtm(time2);  //GIGMA수주갱신시간
                	
                	orderDayTransferWorkService.updateSVZ613PF(orderTransferMngDomain);
                	
                } else {
                	// 존재하지 않으면 insert
                	
                	// 있으면 1, 없으면 0
                	if (flag_aa) {
                		orderTransferMngDomain.setStcd1("1");  //서열
                	} else {
                		orderTransferMngDomain.setStcd1("0");  //서열
                	}
                	
                	if (flag_bb) {
                		orderTransferMngDomain.setStcd2("1");  //비서열
                	} else {
                		orderTransferMngDomain.setStcd2("0");  //비서열
                	}
                	
                	if (flag_cc) {
                		orderTransferMngDomain.setStcd3("1");  //확정오더
                	} else {
                		orderTransferMngDomain.setStcd3("0");  //확정오더
                	}   
                	
                	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyyMMdd");
                	SimpleDateFormat format2 = new SimpleDateFormat ( "HHmmss");
                	Date time = new Date();
                	String time1 = format1.format(time);
                	String time2 = format2.format(time);               	
                	
                	// 현재시간
                	orderTransferMngDomain.setMagdt(time1);  //GIGMA수주갱신일자
                	orderTransferMngDomain.setMagtm(time2);  //GIGMA수주갱신시간
                	
                	orderDayTransferWorkService.createSVZ613PF(orderTransferMngDomain);
                }
            	
                
        	}
        	else jsonObj.put("rtnMsg", "[" + rtnMsg + "] 수주이관 작업 error");
    	} else if (i == 4) {
    		
    		jsonObj.put("rtnMsg", "중복데이터가 있습니다." + sb.toString());
    		
    	}
	    
	    
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }    

    /**
     * [KO] CIGMA 수주 DATA 다운로드.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    
       
    @RequestMapping(value = "/cigmaDataSearch", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void cigmaDataSearch(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();
    	
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");        
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");        
        String getPlnym = ServletRequestUtils.getStringParameter(request, "getPlnym");
        
        List<? extends OrderDayTransferWorkDomain> domainlist = null;

        OrderDayTransferWorkDomain criteria = new OrderDayTransferWorkDomain();
        criteria.setComps(getComps);
        criteria.setPyvnd(getPyvnd);
        criteria.setChgdt(getPlnym);
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());

        domainlist = orderDayTransferWorkService.cigmaDataSearch(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }    
}
