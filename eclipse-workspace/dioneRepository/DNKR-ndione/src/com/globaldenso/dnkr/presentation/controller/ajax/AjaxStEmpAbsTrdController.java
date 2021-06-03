package com.globaldenso.dnkr.presentation.controller.ajax;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.PrdctIndComBaseService;
import com.globaldenso.dnkr.business.service.PrdctSvcPsnlInputService;
import com.globaldenso.dnkr.business.service.StEmpAbsTrdService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PrdctIndComBaseDomain;
import com.globaldenso.dnkr.domain.PrdctSvcPsnlInputDomain;
import com.globaldenso.dnkr.domain.ProdctCodeBaseDomain;
import com.globaldenso.dnkr.domain.StEmpAbsTrdDomain;
import com.globaldenso.dnkr.domain.WrkrInfoBaseDomain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxStEmpAbsTrd")
public class AjaxStEmpAbsTrdController {

    /**
     * [KR] 현장사원 일일근태등록 계획 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private StEmpAbsTrdService stEmpAbsTrdService;

    
    /**
     * [KR] 용역사원정보 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PrdctSvcPsnlInputService prdctSvcPsnlInputService;
    
    
    /**
     * [KR] 생산성지표 기준정보(공통마스타)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PrdctIndComBaseService prdctIndComBaseService;    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxStEmpAbsTrdController() {
        // no process
    }
    
    private int workPsbBaseMin = 3120;
    
    /**
     * [KO] 생산성지표 현장사원일일근태등록 조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void init(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        JSONObject jsonObj = new JSONObject();
        
        /*
        List<? extends DuplTypeOrderCodeMstDomain> domainlist = null;

        DuplTypeOrderCodeMstDomain criteria = new DuplTypeOrderCodeMstDomain();
        
        domainlist = duplTypeOrderCodeMstService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }
        */
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * [KO] 조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void search(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
    	JSONObject jsonObj = new JSONObject();
    	
        String clsCode = ServletRequestUtils.getStringParameter(request, "getComps");  
        String locCode = ServletRequestUtils.getStringParameter(request, "getLocId");          
        String getOpertDe = ServletRequestUtils.getStringParameter(request, "getOpertDe");  //작업일자
        
        List<? extends StEmpAbsTrdDomain> domainlist = null;
        List<? extends StEmpAbsTrdDomain> workPsbTimeList = null;    
        List<? extends StEmpAbsTrdDomain> minusSumList = null;    
        List<? extends StEmpAbsTrdDomain> workDaySumList = null;           

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateOpertDe = transFormat.parse(getOpertDe);
        

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateOpertDe);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        
        Calendar beforeCal = Calendar.getInstance();
        beforeCal.setTime(dateOpertDe);
        
        Calendar toCal = Calendar.getInstance();
        toCal.setTime(dateOpertDe);        
        
        //작업가능시간을 구하기 위해 한주동안 작업한 시간을 구하기 위함
        String beforeDate = null;
        String toDate = null;        
        switch(dayOfWeek) {
        	case 1://일
        		beforeCal.add(Calendar.DATE, -6);
        		beforeDate = transFormat.format(beforeCal.getTime());
        		toDate = transFormat.format(toCal.getTime());
        		break;
        	case 2://월
        		beforeDate = transFormat.format(beforeCal.getTime());
        		toCal.add(Calendar.DATE, 6);
        		toDate = transFormat.format(toCal.getTime());
        		break;
        	case 3://화
        		beforeCal.add(Calendar.DATE, -1);
        		beforeDate = transFormat.format(beforeCal.getTime());
        		toCal.add(Calendar.DATE, 5);
        		toDate = transFormat.format(toCal.getTime());
        		break;        	
        	case 4://수
        		beforeCal.add(Calendar.DATE, -2);
        		beforeDate = transFormat.format(beforeCal.getTime());
        		toCal.add(Calendar.DATE, 4);
        		toDate = transFormat.format(toCal.getTime());
        		break;        	
        	case 5://목
        		beforeCal.add(Calendar.DATE, -3);
        		beforeDate = transFormat.format(beforeCal.getTime());
        		toCal.add(Calendar.DATE, 3);
        		toDate = transFormat.format(toCal.getTime());        		
        		break;
        	case 6://금
        		beforeCal.add(Calendar.DATE, -4);
        		beforeDate = transFormat.format(beforeCal.getTime());
        		toCal.add(Calendar.DATE, 2);
        		toDate = transFormat.format(toCal.getTime());        		
        		break;
        	case 7://토
        		beforeCal.add(Calendar.DATE, -5);
        		beforeDate = transFormat.format(beforeCal.getTime());
        		toCal.add(Calendar.DATE, 1);
        		toDate = transFormat.format(toCal.getTime());        		
        		break;        	
        }
        
        
        //더존 인사정보 취득하기
        PrdctIndComBaseDomain prdctIndComBaseDomain = new PrdctIndComBaseDomain();
        //생산용역인원관리
        PrdctSvcPsnlInputDomain prdctSvcPsnlInputDomain = new PrdctSvcPsnlInputDomain();
        
        String cdBizarea = null;
        if(clsCode.equals("E1")) {
        	cdBizarea = "1000";  //마산
        }else if(clsCode.equals("C1")) {
        	cdBizarea = "2000"; //창원       	
        }else if(clsCode.equals("S1")) {
        	cdBizarea = "3000"; //화성       	
        }        
        prdctIndComBaseDomain.setCdBizarea(cdBizarea);  //사업부
        prdctIndComBaseDomain.setDeptCdMap(locCode);  //부서       
        
        List<PrdctIndComBaseDomain> empMasterList = prdctIndComBaseService.searchEmpMaster(prdctIndComBaseDomain);
        
        prdctSvcPsnlInputDomain.setClsCode(clsCode);
        prdctSvcPsnlInputDomain.setLocCode(locCode);
        List<PrdctSvcPsnlInputDomain> prdctSvcPsnlInputList = prdctSvcPsnlInputService.searchByCondition(prdctSvcPsnlInputDomain);
        
		// 저장된 세션 데이터 불러오기
//		EmpDomain salarayInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        StEmpAbsTrdDomain criteria = new StEmpAbsTrdDomain();
        
        beforeDate = beforeDate.replaceAll("-", "");
        toDate = toDate.replaceAll("-", "");        
        criteria.setClsCode(clsCode);
        criteria.setLocCode(locCode);
        criteria.setOpertDe(getOpertDe);   
        criteria.setBeforeDate(beforeDate);
        criteria.setToDate(toDate);
        
        if(beforeDate !=null && toDate != null) {
        	domainlist = stEmpAbsTrdService.searchByCondition(criteria);
        }else {
        	domainlist = stEmpAbsTrdService.searchByCondition1(criteria);        	
        }       
        
        //이미 저장된 값을 추출하기 위해 key값을 매핑한다.
        HashMap stEmpAbsTrdMap = new HashMap();
        for(int i = 0; i < domainlist.size(); i ++) {
        	StEmpAbsTrdDomain wrkrInfoBaseDomain = domainlist.get(i);
        	String empNumber = wrkrInfoBaseDomain.getEmpno();
        	stEmpAbsTrdMap.put(empNumber, wrkrInfoBaseDomain);
        }

        List<StEmpAbsTrdDomain> reusltList = new ArrayList<StEmpAbsTrdDomain>();
        
    	//근무코드
		int intWorkPsbTimeSum = 0;
		//조퇴,지각,외출
		int intMinusSum = 0;     
		
		
    	//값이 없는경우는 해당주에 전날값을 가져온다.(근무코드 sum)
    	workPsbTimeList = stEmpAbsTrdService.searchByOverTimeSum(criteria);
    	//조퇴,지각,외출 sum정보를 가져온다
    	minusSumList = stEmpAbsTrdService.searchByMinusSum(criteria);        		
		
    	//값이 없는경우는 해당주에 전날값을 가져온다.(근무코드 sum)   	
    	HashMap overtimeMap = new HashMap(); 
    	if(workPsbTimeList != null && workPsbTimeList.size() > 0) {
    		for(int i = 0; i < workPsbTimeList.size(); i ++) {
	    		StEmpAbsTrdDomain stEmpAbsTrdDomain = workPsbTimeList.get(i);
	    		if(stEmpAbsTrdDomain != null) {
	        		String overtimeM = stEmpAbsTrdDomain.getOvertimeM();
	        		String empNo = stEmpAbsTrdDomain.getEmpno();
	        		overtimeM = changeZero(overtimeM);
	        		overtimeMap.put(empNo, overtimeM);
	    		}
    		}
    	}
    	
    	//조퇴,지각,외출 sum정보를 가져온다
    	HashMap minusSumMap = new HashMap(); 
    	if(minusSumList != null && minusSumList.size() > 0) {
    		for(int i = 0; i < minusSumList.size(); i ++) {
	    		StEmpAbsTrdDomain stEmpAbsTrdDomain = minusSumList.get(i);
	    		if(stEmpAbsTrdDomain != null) {
	        		String minusVal = stEmpAbsTrdDomain.getMinusSum();
	        		String empNo = stEmpAbsTrdDomain.getEmpno();
	        		minusVal = changeZero(minusVal);
	        		minusSumMap.put(empNo, minusVal);
	        		
	    		}
    		}
    	} 
    	
        //더존사원정보
        for(int i = 0; i < empMasterList.size(); i ++) {
        	StEmpAbsTrdDomain resultDomain = new StEmpAbsTrdDomain();
        	
        	PrdctIndComBaseDomain domain = empMasterList.get(i);
        	String empClsCode = (String)domain.getCdBizarea(); //사업부
        	String noEmp = (String)domain.getNoEmp(); //사원번호
        	int intNoEmp = Integer.parseInt(noEmp);  //DB에 Number 타입이어서 앞에 '0' 삭제
        	noEmp = String.valueOf(intNoEmp);
        	
        	String deptCdMap = (String)domain.getDeptCdMap(); //부서코드
        	String nmKor = (String)domain.getNmKor(); //이름

        	resultDomain.setOpertDe(getOpertDe); 	//작업일자
        	resultDomain.setClsCode(empClsCode);
        	resultDomain.setLocCode(deptCdMap);
        	resultDomain.setEmpno(noEmp);        	
        	resultDomain.setEmpnm(nmKor);  
        	resultDomain.setLogiType(false);            	
        	
        	if(empClsCode.equals("1000")) {
            	empClsCode = "E1";  //마산
            }else if(empClsCode.equals("2000")) {
            	empClsCode = "C1"; //창원       	
            }else if(empClsCode.equals("3000")) {
            	empClsCode = "S1"; //화성       	
            }         	
        	
            if(stEmpAbsTrdMap.get(noEmp) != null ) {
            	resultDomain = (StEmpAbsTrdDomain)stEmpAbsTrdMap.get(noEmp);
            	String strWorkPsbTime = resultDomain.getWorkPsbTime();
            	String strMinusSum = resultDomain.getMinusSum();
            	int intWorkPsbTime = 0;
            	int intMinus = 0;            	
            	int workPsbTime = 0;
            	//조회일자기준 한주 근무가능시간 취득
            	
            	//근무코드 sum
            	strWorkPsbTime = changeZero(strWorkPsbTime);
            	//조퇴,지각,외출 sum
            	strMinusSum = changeZero(strMinusSum);         
            	intWorkPsbTime = Integer.parseInt(strWorkPsbTime);  
            	intMinus = Integer.parseInt(strMinusSum); 
            	workPsbTime = workPsbBaseMin - (intWorkPsbTime + intMinus);
            	
            	resultDomain.setWorkPsbTime(String.valueOf(workPsbTime));
            	resultDomain.setEmpnm(nmKor); 
            	//총근무코드시간
//            	intWorkPsbTimeSum = intWorkPsbTimeSum +intWorkPsbTime;
            	//총조퇴,지각,외출
//            	intMinusSum = intMinusSum + intMinus;

            }else {
            	//근무코드
        		int intWorkPsbTime = 0;
        		//조퇴,지각,외출
        		int intMinus = 0;        		
        		int workPsbTime = 0; 
            	
        		String overtimeM = (String)overtimeMap.get(noEmp);
        		overtimeM = changeZero(overtimeM);  		
        		intWorkPsbTime = Integer.parseInt(overtimeM);
        		
        		String minusVal = (String)minusSumMap.get(noEmp);
        		minusVal = changeZero(minusVal);  		
        		intMinus = Integer.parseInt(minusVal);        		
        		
            	workPsbTime = workPsbBaseMin - (intWorkPsbTime + intMinus);
            	
            	resultDomain.setWorkPsbTime(String.valueOf(workPsbTime)); //52시간(작업가능시간)
            	//총근무코드시간
//            	intWorkPsbTimeSum = intWorkPsbTimeSum +intWorkPsbTime;
            	//총조퇴,지각,외출
 //           	intMinusSum = intMinusSum + intMinus;

            }
            reusltList.add(resultDomain);
        }
        
        //용역사원정보
        for(int i = 0; i < prdctSvcPsnlInputList.size(); i++) {
        	StEmpAbsTrdDomain resultDomain = new StEmpAbsTrdDomain();
        	
        	PrdctSvcPsnlInputDomain domain = prdctSvcPsnlInputList.get(i);
        	String empClsCode = (String)domain.getClsCode(); //사업부
        	String noEmp = (String)domain.getServcNo(); //용역번호
        	int intNoEmp = Integer.parseInt(noEmp); //DB에 Number 타입이어서 앞에 '0' 삭제
        	noEmp = String.valueOf(intNoEmp);
        	
        	String deptCdMap = (String)domain.getLocCode(); //부서코드
        	String nmKor = (String)domain.getNm(); //이름
        	
        	resultDomain.setClsCode(empClsCode);
        	resultDomain.setLocCode(deptCdMap);
        	resultDomain.setEmpno(noEmp);        	
        	resultDomain.setEmpnm(nmKor);      
        	resultDomain.setLogiType(false);          	
            
            if(stEmpAbsTrdMap.get(noEmp) != null ) {
            	resultDomain = (StEmpAbsTrdDomain)stEmpAbsTrdMap.get(noEmp);
            	String strWorkPsbTime = resultDomain.getWorkPsbTime();
            	String strMinusSum = resultDomain.getMinusSum();
            	int intWorkPsbTime = 0;
            	int intMinus = 0;            	
            	int workPsbTime = 0;
            	//조회일자기준 한주 근무가능시간 취득
            	
            	//근무코드 sum
            	strWorkPsbTime = changeZero(strWorkPsbTime);
            	//조퇴,지각,외출 sum
            	strMinusSum = changeZero(strMinusSum);         
            	intWorkPsbTime = Integer.parseInt(strWorkPsbTime);  
            	intMinus = Integer.parseInt(strMinusSum); 
            	workPsbTime = workPsbBaseMin - (intWorkPsbTime + intMinus);
            	
            	resultDomain.setWorkPsbTime(String.valueOf(workPsbTime));
            	resultDomain.setEmpnm(nmKor);  
            	//총근무코드시간
//            	intWorkPsbTimeSum = intWorkPsbTimeSum +intWorkPsbTime;
            	//총조퇴,지각,외출
//            	intMinusSum = intMinusSum + intMinus;
            	
            }else {
            	//근무코드
        		int intWorkPsbTime = 0;
        		//조퇴,지각,외출
        		int intMinus = 0;        		
        		int workPsbTime = 0; 
            	
        		String overtimeM = (String)overtimeMap.get(noEmp);
        		overtimeM = changeZero(overtimeM);  		
        		intWorkPsbTime = Integer.parseInt(overtimeM);
        		
        		String minusVal = (String)minusSumMap.get(noEmp);
        		minusVal = changeZero(minusVal);  		
        		intMinus = Integer.parseInt(minusVal);  
        		
            	workPsbTime = workPsbBaseMin - (intWorkPsbTime + intMinus);
            	
            	resultDomain.setWorkPsbTime(String.valueOf(workPsbTime)); //52시간(작업가능시간)
            	//총근무코드시간
//            	intWorkPsbTimeSum = intWorkPsbTimeSum +intWorkPsbTime;
            	//총조퇴,지각,외출
//            	intMinusSum = intMinusSum + intMinus;
            	
            }
            reusltList.add(resultDomain);  
        }
        
        
        
        String rcvsupTm = "0";
        domainlist = stEmpAbsTrdService.searchByConditionSt(criteria);
        if(domainlist != null && domainlist.size() > 0) {
    		StEmpAbsTrdDomain stEmpAbsTrdDomain = domainlist.get(0);
    		if(stEmpAbsTrdDomain != null) {
    			rcvsupTm = stEmpAbsTrdDomain.getRcvsupTm();
    		}
    	}
        
        //지원받는시간
		jsonObj.put("rcvsupTm", changeZero(rcvsupTm));
    	
		String sumWorkTime = "0";
		//룰류제외 총작업시간(분)
		criteria.setLogiType(true);
		workDaySumList = stEmpAbsTrdService.searchByDayWorkTimeSum(criteria);
	
		if(workDaySumList != null && workDaySumList.size() > 0) {
			StEmpAbsTrdDomain stEmpAbsTrdDomain = workDaySumList.get(0);
    		if(stEmpAbsTrdDomain != null) {
    			sumWorkTime = stEmpAbsTrdDomain.getSumWorkTime();
    		}
		}
		//(근무코드-(조퇴+지각+외출+지원보낸시간)) + 지원받은시간
		int intSumWorkTime = Integer.parseInt(changeZero(sumWorkTime));
		jsonObj.put("sumWorkTime", String.valueOf(intSumWorkTime));  //물류제외 총작업시간
		

        if(reusltList != null) {
            jsonObj.put("list", reusltList);
        }
        
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * [KO] 삭제.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAN000DuplTypeOrderCodeMst/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObj = new JSONObject();
        
        String getOpertDe = ServletRequestUtils.getStringParameter(request, "getOpertDe");  //작업일자        
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");        
        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");           
        
        //존재하는지 체크
        StEmpAbsTrdDomain cntDomain = new StEmpAbsTrdDomain();
        cntDomain.setOpertDe(getOpertDe);
        cntDomain.setClsCode(clsCode);
        cntDomain.setLocCode(locCode);
        cntDomain.setEmpno(empNumber);          

        int cnt = stEmpAbsTrdService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        StEmpAbsTrdDomain delDomain = new StEmpAbsTrdDomain();
        delDomain.setOpertDe(getOpertDe);
        delDomain.setClsCode(clsCode);
        delDomain.setLocCode(locCode);
        delDomain.setEmpno(empNumber);
        stEmpAbsTrdService.delete(delDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }

    /**
     * [KO] 추가.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAN000DuplTypeOrderCodeMst/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();
        
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");
    	if(clsCode.equals("1000")) {
    		clsCode = "E1";  //마산
        }else if(clsCode.equals("2000")) {
        	clsCode = "C1"; //창원       	
        }else if(clsCode.equals("3000")) {
        	clsCode = "S1"; //화성       	
        }   
        String opertDe = ServletRequestUtils.getStringParameter(request, "opertDe");      	
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");        
        String empno = ServletRequestUtils.getStringParameter(request, "empno");
        String workCode = ServletRequestUtils.getStringParameter(request, "workCode");   
        String logiType = ServletRequestUtils.getStringParameter(request, "logiType"); //물류인원 Check      
        String lrlyTime = ServletRequestUtils.getStringParameter(request, "lrlyTime"); //조퇴시간  
        String latenTime = ServletRequestUtils.getStringParameter(request, "latenTime"); //지각시간        
        String gnotTime = ServletRequestUtils.getStringParameter(request, "gnotTime"); //외출시간 
        String adtnRqstTime = ServletRequestUtils.getStringParameter(request, "adtnRqstTime"); //보낸시간           
        String closSe = ServletRequestUtils.getStringParameter(request, "closSe"); //마감구분        
        
        //근무코드값이 있는경우만 저장환다.
        if(workCode == null) {
        	return;
        }

        //존재하는지 체크
        StEmpAbsTrdDomain cntDomain = new StEmpAbsTrdDomain();
        cntDomain.setOpertDe(opertDe); //작업일자     
        cntDomain.setClsCode(clsCode); 
        cntDomain.setLocCode(locCode); 
        cntDomain.setEmpno(empno);          
         

        int cnt = stEmpAbsTrdService.searchCount(cntDomain);
        
        if(cnt > 0) {
            jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
//        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }      
        
        StEmpAbsTrdDomain insDomain = new StEmpAbsTrdDomain();
        insDomain.setOpertDe(opertDe); //작업일자     
        insDomain.setClsCode(clsCode); 
        insDomain.setLocCode(locCode); 
        insDomain.setEmpno(empno);  
        
        insDomain.setStrLogiType(logiType);  
        insDomain.setLrlyTime(lrlyTime);  
        insDomain.setLatenTime(latenTime);  
        insDomain.setGnotTime(gnotTime);  
        insDomain.setArqstTime(adtnRqstTime);  
        insDomain.setClosSe(closSe);          
        
        
        insDomain.setRegUser(userName);
        
        stEmpAbsTrdService.create(insDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
        
    }
    
    /**
     * [KO] 수정.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAN000")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {
        JSONObject jsonObj = new JSONObject();
        String clsCode = ServletRequestUtils.getStringParameter(request, "clsCode");

    	if(clsCode.equals("1000")) {
    		clsCode = "E1";  //마산
        }else if(clsCode.equals("2000")) {
        	clsCode = "C1"; //창원       	
        }else if(clsCode.equals("3000")) {
        	clsCode = "S1"; //화성       	
        }   
    	
        String opertDe = ServletRequestUtils.getStringParameter(request, "opertDe");      	
        String locCode = ServletRequestUtils.getStringParameter(request, "locCode");        
        String empno = ServletRequestUtils.getStringParameter(request, "empno");
        String shiftwork = ServletRequestUtils.getStringParameter(request, "shiftwork");           
        String workCode = ServletRequestUtils.getStringParameter(request, "workCode");    
        
        String logiType = ServletRequestUtils.getStringParameter(request, "logiType");  //물류인원 Check   
        if(logiType != null) {
        	logiType = logiType.trim();
        	if(logiType.equals("true")) {
        		logiType = "Y";
        	}else {
        		logiType = "";        		
        	}
        }else {
    		logiType = "";        	
        }
        String lrlyTime = ServletRequestUtils.getStringParameter(request, "lrlyTime");  //조퇴시간  
        String latenTime = ServletRequestUtils.getStringParameter(request, "latenTime");  //지각시간        
        String gnotTime = ServletRequestUtils.getStringParameter(request, "gnotTime");  //외출시간 
        String arqstTime = ServletRequestUtils.getStringParameter(request, "arqstTime");  //보낸시간           
        String closSe = ServletRequestUtils.getStringParameter(request, "closSe");  //마감구분 
        
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String empNumber = empInfo.getEmpNumber();
        String userName = empInfo.getEmpName();

        //존재하는지 체크
        StEmpAbsTrdDomain cntDomain = new StEmpAbsTrdDomain();        
        //값이 없으면 저장조건이 안됨
        if(opertDe == null || locCode == null || empno == null || shiftwork == null || workCode == null){
        	return;
        }
        if(opertDe != null){
        	opertDe = opertDe.replaceAll("-", "");
        }
        
        cntDomain.setOpertDe(opertDe); //작업일자     
        cntDomain.setClsCode(clsCode); 
        cntDomain.setLocCode(locCode); 
        cntDomain.setEmpno(empno);   
        
        int cntOld = stEmpAbsTrdService.searchCount(cntDomain);

        if(cntOld == 0) {
        	StEmpAbsTrdDomain insDomain = new StEmpAbsTrdDomain();
            if(!isEmpty(workCode) && !isEmpty(shiftwork)) {
            	
                insDomain.setOpertDe(opertDe); //작업일자     
                insDomain.setClsCode(clsCode); 
                insDomain.setLocCode(locCode); 
                insDomain.setEmpno(empno);  
                insDomain.setShiftwork(shiftwork);
                insDomain.setWorkCode(workCode);                

                insDomain.setStrLogiType(logiType);  
                insDomain.setLrlyTime(lrlyTime);  
                insDomain.setLatenTime(latenTime);  
                insDomain.setGnotTime(gnotTime);  
                insDomain.setArqstTime(arqstTime);  
                insDomain.setClosSe(closSe);  
                insDomain.setRegUser(empNumber);                
            	stEmpAbsTrdService.create(insDomain);
                
                jsonObj.put("result", DnkrConstans.RESULT_OK);        
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);             	
            }
           
        }else {
            if(!isEmpty(workCode) && !isEmpty(shiftwork)) {
       		StEmpAbsTrdDomain updDomain = new StEmpAbsTrdDomain();             	
       		updDomain.setOpertDe(opertDe); //작업일자     
       		updDomain.setClsCode(clsCode); 
       		updDomain.setLocCode(locCode); 
       		updDomain.setEmpno(empno);  
       		updDomain.setStrLogiType(logiType); 
       		
       		updDomain.setShiftwork(shiftwork);
       		updDomain.setWorkCode(workCode);         		
       		
       		updDomain.setLrlyTime(changeZero(lrlyTime));  
       		updDomain.setLatenTime(changeZero(latenTime));  
            updDomain.setGnotTime(changeZero(gnotTime));  
            updDomain.setArqstTime(changeZero(arqstTime));  
            updDomain.setClosSe(changeSpace(closSe));  
	        updDomain.setModUser(empNumber); 
	        stEmpAbsTrdService.update(updDomain);
	
	        jsonObj.put("result", DnkrConstans.RESULT_OK);        
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(jsonObj);
       	  }else { //code 값이 없으면 삭제처리한다.
       		StEmpAbsTrdDomain delDomain = new StEmpAbsTrdDomain();
       		delDomain.setOpertDe(opertDe); //작업일자     
       		delDomain.setClsCode(clsCode); 
       		delDomain.setLocCode(locCode); 
   			delDomain.setEmpno(empno);  
            stEmpAbsTrdService.delete(delDomain); 
              
            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;        		  
       	  }
        }
        return;
    }
    
    /**
     * [KO] 지원보내는시간<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/SaveRcvsupTm", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAN000")
    public void saveRcvsupTm(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {
        JSONObject jsonObj = new JSONObject();
        String clsCode = ServletRequestUtils.getStringParameter(request, "getComps");

    	if(clsCode.equals("1000")) {
    		clsCode = "E1";  //마산
        }else if(clsCode.equals("2000")) {
        	clsCode = "C1"; //창원       	
        }else if(clsCode.equals("3000")) {
        	clsCode = "S1"; //화성       	
        }   
    	
        String opertDe = ServletRequestUtils.getStringParameter(request, "getOpertDe");      	
        String locCode = ServletRequestUtils.getStringParameter(request, "getLocId");        
        String rcvsupTm = ServletRequestUtils.getStringParameter(request, "getRcvsupTm");  //물류지원시간          
        rcvsupTm = changeZero(rcvsupTm);
    	
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String empNumber = empInfo.getEmpNumber();

        //존재하는지 체크
        StEmpAbsTrdDomain cntDomain = new StEmpAbsTrdDomain();        
        
        cntDomain.setOpertDe(opertDe); //작업일자     
        cntDomain.setClsCode(clsCode); 
        cntDomain.setLocCode(locCode); 
        cntDomain.setRcvsupTm(rcvsupTm);   
        
        int cntOld = stEmpAbsTrdService.searchCountSt(cntDomain);

        if(cntOld == 0) {
        	StEmpAbsTrdDomain insDomain = new StEmpAbsTrdDomain();
            insDomain.setOpertDe(opertDe); //작업일자     
            insDomain.setClsCode(clsCode); 
            insDomain.setLocCode(locCode); 
            insDomain.setRcvsupTm(rcvsupTm);              
            insDomain.setRegUser(empNumber);                
        	stEmpAbsTrdService.createSt(insDomain);
            
            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);             	
           
        }else {
       		StEmpAbsTrdDomain updDomain = new StEmpAbsTrdDomain();             	
       		updDomain.setOpertDe(opertDe); //작업일자     
       		updDomain.setClsCode(clsCode); 
       		updDomain.setLocCode(locCode); 
       		updDomain.setRcvsupTm(rcvsupTm);    		
	        updDomain.setModUser(empNumber); 
	        stEmpAbsTrdService.updateSt(updDomain);
	
	        jsonObj.put("result", DnkrConstans.RESULT_OK);        
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(jsonObj);
       	 }
        
        return;    	
    }
    
    /**
     * [KO] 지원보내는시간<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/SaveLgstTm", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAN000")
    public void saveLgstTm(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {
        JSONObject jsonObj = new JSONObject();
        String clsCode = ServletRequestUtils.getStringParameter(request, "getComps");

    	if(clsCode.equals("1000")) {
    		clsCode = "E1";  //마산
        }else if(clsCode.equals("2000")) {
        	clsCode = "C1"; //창원       	
        }else if(clsCode.equals("3000")) {
        	clsCode = "S1"; //화성       	
        }   
    	
        String opertDe = ServletRequestUtils.getStringParameter(request, "getOpertDe");      	
        String locCode = ServletRequestUtils.getStringParameter(request, "getLocId");        
        String lgstTm = ServletRequestUtils.getStringParameter(request, "getLgstTm");  //물류시간
        lgstTm = changeZero(lgstTm);
    	
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String empNumber = empInfo.getEmpNumber();

        //존재하는지 체크
        StEmpAbsTrdDomain cntDomain = new StEmpAbsTrdDomain();        
        
        cntDomain.setOpertDe(opertDe); //작업일자     
        cntDomain.setClsCode(clsCode); 
        cntDomain.setLocCode(locCode); 
        int cntOld = stEmpAbsTrdService.searchCountSt(cntDomain);

        if(cntOld == 0) {
        	StEmpAbsTrdDomain insDomain = new StEmpAbsTrdDomain();
            insDomain.setOpertDe(opertDe); //작업일자     
            insDomain.setClsCode(clsCode); 
            insDomain.setLocCode(locCode); 
            insDomain.setLgstTm(lgstTm);              
            insDomain.setRegUser(empNumber);                
        	stEmpAbsTrdService.createLgstTm(insDomain);
            
            jsonObj.put("result", DnkrConstans.RESULT_OK);        
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);             	
           
        }else {
       		StEmpAbsTrdDomain updDomain = new StEmpAbsTrdDomain();             	
       		updDomain.setOpertDe(opertDe); //작업일자     
       		updDomain.setClsCode(clsCode); 
       		updDomain.setLocCode(locCode); 
       		updDomain.setLgstTm(lgstTm);       		
	        updDomain.setModUser(empNumber); 
	        stEmpAbsTrdService.updateLgstTm(updDomain);
	
	        jsonObj.put("result", DnkrConstans.RESULT_OK);        
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(jsonObj);
       	 }
        
        return;    	
    }    
    
    private boolean isEmpty(String val) {
    	if(val == null) {
    		return true;
    	}else {
    		val = val.trim();
    		if(val.length() == 0) {
    			return true;
    		}
    	}
    	return false;
    }
    
    private String changeZero(String val) {
    	if(val == null) {
    		return "0";
    	}else {
    		val = val.trim();
    		if(val.length() == 0) {
    			return "0";
    		}else {
    			return val;
    		}
    	}
    }    
    private String changeSpace(String val) {
    	if(val == null) {
    		return "";
    	}else {
    		val = val.trim();
    		if(val.length() == 0) {
    			return "";
    		}else {
    			return val;
    		}
    	}
    }        
}
