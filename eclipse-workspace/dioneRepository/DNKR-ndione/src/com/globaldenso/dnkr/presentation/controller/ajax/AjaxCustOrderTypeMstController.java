package com.globaldenso.dnkr.presentation.controller.ajax;

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
import com.globaldenso.dnkr.business.service.CustOrderTypeMstService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CustOrderTypeMstDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxCustOrderTypeMst")
public class AjaxCustOrderTypeMstController {

    /**
     * [KR] 업체서열차종마스타 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private CustOrderTypeMstService custOrderTypeMstService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxCustOrderTypeMstController() {
        // no process
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
    @RequestMapping(value = "/init", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void init(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        JSONObject jsonObj = new JSONObject();
        
        /*
        List<? extends CustOrderTypeMstDomain> domainlist = null;

        CustOrderTypeMstDomain criteria = new CustOrderTypeMstDomain();
       
        domainlist = custOrderTypeMstService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }
        */
        
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
    public void check(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String chkComps = ServletRequestUtils.getStringParameter(request, "comps");
        String chkPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String chkMcrcd = ServletRequestUtils.getStringParameter(request, "mcrcd");
        String chkSeqcd = ServletRequestUtils.getStringParameter(request, "seqcd");
        String chkEfffr = ServletRequestUtils.getStringParameter(request, "efffr");
        String chkEffto = ServletRequestUtils.getStringParameter(request, "effto");
        
        String chkPspno = ServletRequestUtils.getStringParameter(request, "pspno");

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(chkComps);
        
        //존재하는지 체크
        CustOrderTypeMstDomain cntDomain = new CustOrderTypeMstDomain();
        cntDomain.setComps(chkComps);
        cntDomain.setPyvnd(chkPyvnd);
        cntDomain.setMcrcd(chkMcrcd);
        cntDomain.setSeqcd(chkSeqcd);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        
        
        // BAR CODE 정보마스타 확인
        cntDomain.setPspno(chkPspno);
        int cnt3 = custOrderTypeMstService.searchCheck3(cntDomain);
        
        if(cnt3 == 0) {        	 
            //jsonObj.put("errMsg", "[확인] BARCODE 정보마스타의 ALC코드값과 불일치(품목정보마스타에서 확인가능합니다.)");
        	jsonObj.put("errMsg", "LN_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }
        
        // 중복차종서열코드마스타 확인
        int cnt = custOrderTypeMstService.searchCheck(cntDomain);
        
        if(cnt > 0) {        	 
            //jsonObj.put("errMsg", "등록불가(중복차종서열코드마스타에 등록된 대표차종,서열 자료입니다.)");
        	jsonObj.put("errMsg", "LN_CHK2");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }
        
        // 일자 확인
        if(!(chkEfffr.equals("") || chkEfffr.equals("99999999"))) {
	        cntDomain.setMakdt(chkEfffr);
	        int cnt2 = custOrderTypeMstService.searchCheck2(cntDomain);
	        
	        if(cnt2 == 0) {        	 
	            //jsonObj.put("errMsg", "[확인] 시작일자를 확인바랍니다.");
	        	jsonObj.put("errMsg", "LN_CHK3");
	            response.setContentType("text/html;charset=utf-8");
	            response.getWriter().print(jsonObj);
	            return;
	        }
	        else {            
	        	if(!(chkEffto.equals("") || chkEffto.equals("99999999"))) {
		            cntDomain.setMakdt(chkEffto);
		            cnt2 = custOrderTypeMstService.searchCheck2(cntDomain);
		            
		            if(cnt2 == 0) {        	 
		                //jsonObj.put("errMsg", "[확인] 종료일자를 확인바랍니다.");
		            	jsonObj.put("errMsg", "LN_CHK4");
		                response.setContentType("text/html;charset=utf-8");
		                response.getWriter().print(jsonObj);
		                return;
		            }
	        	}
	        }
        }
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
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
    	
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");
        String getPchk  = ServletRequestUtils.getStringParameter(request, "getPchk");
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");        
        String getPspno = ServletRequestUtils.getStringParameter(request, "getPspno");

        List<? extends CustOrderTypeMstDomain> domainlist = null;

        CustOrderTypeMstDomain criteria = new CustOrderTypeMstDomain();
        criteria.setComps(getComps);
        criteria.setPchk(getPchk);
        criteria.setPyvnd(getPyvnd);
        criteria.setPspno(getPspno);

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);

        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        domainlist = custOrderTypeMstService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
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
    @ErrorBack(viewName = "forward:/WAN001CustOrderTypeMst/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String delComps = ServletRequestUtils.getStringParameter(request, "comps");
        String delPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String delPspno = ServletRequestUtils.getStringParameter(request, "pspno");
        String delMcrcd = ServletRequestUtils.getStringParameter(request, "mcrcd");
        String delSeqcd = ServletRequestUtils.getStringParameter(request, "seqcd");
        String delSeqno = ServletRequestUtils.getStringParameter(request, "seqno");        
        String delEfffr = ServletRequestUtils.getStringParameter(request, "efffr");
        String delEffto = ServletRequestUtils.getStringParameter(request, "effto");

        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDomain empInfo2 = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(delComps);
        
        //존재하는지 체크
        CustOrderTypeMstDomain cntDomain = new CustOrderTypeMstDomain();
        cntDomain.setComps(delComps);
        cntDomain.setPyvnd(delPyvnd);
        cntDomain.setPspno(delPspno);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = custOrderTypeMstService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        
        CustOrderTypeMstDomain delDomain = new CustOrderTypeMstDomain();
        delDomain.setComps(delComps);
        delDomain.setPyvnd(delPyvnd);
        delDomain.setPspno(delPspno);
        delDomain.setGubcd("D");
        delDomain.setSeqno(delSeqno);
        delDomain.setSeqcd(delSeqcd);
        delDomain.setMcrcd(delMcrcd);        
        delDomain.setEfffr(delEfffr);
        delDomain.setEffto(delEffto);
        delDomain.setSeqno2("");
        delDomain.setSeqcd2("");
        delDomain.setMcrcd2("");
        delDomain.setEfffr2("0");
        delDomain.setEffto2("0");
        delDomain.setUsrid(empInfo2.getEmpNumber());                
        delDomain.setLib1(empInfo.getLib1());
        delDomain.setLib2(empInfo.getLib2());
        
        custOrderTypeMstService.delete(delDomain);
        
        // 이력 등록
        custOrderTypeMstService.createSVM200(delDomain);

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
    @ErrorBack(viewName = "forward:/WAN001CustOrderTypeMst/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

        String insComps = ServletRequestUtils.getStringParameter(request, "comps");
        String insPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String insPspno = ServletRequestUtils.getStringParameter(request, "pspno");
        String insMcrcd = ServletRequestUtils.getStringParameter(request, "mcrcd");
        String insSeqcd = ServletRequestUtils.getStringParameter(request, "seqcd");
        String insSeqno = ServletRequestUtils.getStringParameter(request, "seqno");        
        String insEfffr = ServletRequestUtils.getStringParameter(request, "efffr");
        String insEffto = ServletRequestUtils.getStringParameter(request, "effto");

        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDomain empInfo2 = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(insComps);
        
        
        //존재하는지 체크
        CustOrderTypeMstDomain cntDomain = new CustOrderTypeMstDomain();
        cntDomain.setComps(insComps);
        cntDomain.setPyvnd(insPyvnd);
        cntDomain.setPspno(insPspno);
        cntDomain.setMcrcd(insMcrcd);
        cntDomain.setSeqcd(insSeqcd);
        cntDomain.setSeqno(insSeqno);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = custOrderTypeMstService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "등록불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	int cnt2 = custOrderTypeMstService.searchCount2(cntDomain);
        	
        	if(cnt2 > 0) {
                //jsonObj.put("errMsg", "등록불가(차종/서열코드/번호가 동일한 항목이 존재합니다.)");
        		jsonObj.put("errMsg", "LN_INS_CHK2");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);
                return;
            }        	
        }        
        
        
        CustOrderTypeMstDomain insDomain = new CustOrderTypeMstDomain();
        insDomain.setComps(insComps);
        insDomain.setPyvnd(insPyvnd);
        insDomain.setPspno(insPspno);
        insDomain.setMcrcd(insMcrcd);
        insDomain.setSeqno(insSeqno);
        insDomain.setSeqcd(insSeqcd);
        insDomain.setEfffr(insEfffr);
        insDomain.setEffto(insEffto); 
        insDomain.setUsrid(empInfo2.getEmpNumber());
        insDomain.setLib1(empInfo.getLib1());
        insDomain.setLib2(empInfo.getLib2());  
        custOrderTypeMstService.create(insDomain);

        // 이력 등록
        insDomain.setGubcd("A");
        insDomain.setSeqno("");
        insDomain.setSeqcd("");
        insDomain.setMcrcd("");
        insDomain.setEfffr("0");
        insDomain.setEffto("0");         
        insDomain.setSeqno2(insSeqno);
        insDomain.setSeqcd2(insSeqcd);
        insDomain.setMcrcd2(insMcrcd);
        insDomain.setEfffr2(insEfffr);
        insDomain.setEffto2(insEffto);        
        custOrderTypeMstService.createSVM200(insDomain);
        
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
    @ErrorBack(viewName = ".tiles.page.WAN001")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        JSONObject jsonObj = new JSONObject();

        String updComps = ServletRequestUtils.getStringParameter(request, "comps");
        String updPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");
        String updPspno = ServletRequestUtils.getStringParameter(request, "pspno");
        String updMcrcd = ServletRequestUtils.getStringParameter(request, "mcrcd");
        String updSeqcd = ServletRequestUtils.getStringParameter(request, "seqcd");
        String updSeqno = ServletRequestUtils.getStringParameter(request, "seqno");
        String updEfffr = ServletRequestUtils.getStringParameter(request, "efffr");
        String updEffto = ServletRequestUtils.getStringParameter(request, "effto");

        String updOldSeqno = ServletRequestUtils.getStringParameter(request, "oldSeqno");
        String updOldSeqcd = ServletRequestUtils.getStringParameter(request, "oldSeqcd");
        String updOldMcrcd = ServletRequestUtils.getStringParameter(request, "oldMcrcd");
        String updOldEfffr = ServletRequestUtils.getStringParameter(request, "oldEfffr");
        String updOldEffto = ServletRequestUtils.getStringParameter(request, "oldEffto");        
        
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDomain empInfo2 = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(updComps);
        
        
        //존재하는지 체크
        CustOrderTypeMstDomain cntDomain = new CustOrderTypeMstDomain();
        cntDomain.setComps(updComps);
        cntDomain.setPyvnd(updPyvnd);
        cntDomain.setPspno(updPspno);
        cntDomain.setMcrcd(updMcrcd);
        cntDomain.setSeqcd(updSeqcd);
        cntDomain.setSeqno(updSeqno);
        cntDomain.setLib1(empInfo.getLib1());
        cntDomain.setLib2(empInfo.getLib2());
        int cnt = custOrderTypeMstService.searchCount(cntDomain);
        
        if(cnt == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.(품번)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	int cnt2 = custOrderTypeMstService.searchCount2(cntDomain);
        	
        	if(cnt2 == 0) {
                //jsonObj.put("errMsg", "수정불가(차종/서열코드/번호가 미 등록된 자료입니다.)");
        		jsonObj.put("errMsg", "LN_UPD_CHK2");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print(jsonObj);
                return;
        	}
        }       


        CustOrderTypeMstDomain updDomain = new CustOrderTypeMstDomain();
        updDomain.setComps(updComps);
        updDomain.setPyvnd(updPyvnd);
        updDomain.setPspno(updPspno);
        updDomain.setMcrcd(updMcrcd);
        updDomain.setSeqcd(updSeqcd);
        updDomain.setSeqno(updSeqno);        
        updDomain.setEfffr(updEfffr);
        updDomain.setEffto(updEffto); 
        updDomain.setUsrid(empInfo2.getEmpNumber());
        updDomain.setLib1(empInfo.getLib1());
        updDomain.setLib2(empInfo.getLib2());    
        custOrderTypeMstService.update(updDomain);
    
        // 이력 등록
        updDomain.setGubcd("C");
        updDomain.setSeqno(updOldSeqno);
        updDomain.setSeqcd(updOldSeqcd);
        updDomain.setMcrcd(updOldMcrcd);
        updDomain.setEfffr(updOldEfffr);
        updDomain.setEffto(updOldEffto);         
        updDomain.setSeqno2(updSeqno);
        updDomain.setSeqcd2(updSeqcd);
        updDomain.setMcrcd2(updMcrcd);
        updDomain.setEfffr2(updEfffr);
        updDomain.setEffto2(updEffto);
        custOrderTypeMstService.createSVM200(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}