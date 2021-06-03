package com.globaldenso.dnkr.presentation.controller.sal;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.CustomerOrderService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CustOrderDataMngDomain;
import com.globaldenso.dnkr.domain.CustOrderTypeMstDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.TopCustTypeMstDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KR] 수주DATA관리 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAN025CustOrderDataMng")
@ViewId(value = "WAN025")
public class WAN025CustOrderDataMngController {
    /**
     * [KR] 중복차종서열코드마스타 서비스 <br>     
     */
    @Autowired
    private CustomerOrderService customerOrderService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN025CustOrderDataMngController() {
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

        //UxisCmmUtil.getSessionComCode(request, mv);
        UxisCmmUtil.getSessionLoc(request, mv);// 사업부

        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String empCls        = (String)empJsonObj.get("clsCode");        //사용자 사업부
        String empLoc        = (String)empJsonObj.get("locCode");        //사용자 공장   
        
        // wijmo LicenseKey
        String wijmoLicenseKey = UxisCmmUtil.getProperty("wijmo.setLicenseKey");
        mv.addObject("wijmoLicenseKey", wijmoLicenseKey);
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("empLoc", empLoc);
        mv.addObject("url", "WAN025CustOrderDataMng.jsp");
        mv.setViewName(".tiles.page.WAN025");
        return mv;
        
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

        String getLocCode = ServletRequestUtils.getStringParameter(request, "getLocCode");
        String getChgdt = ServletRequestUtils.getStringParameter(request, "getChgdt");
        String getTypcd = ServletRequestUtils.getStringParameter(request, "getTypcd");
        String getPyvnd = ServletRequestUtils.getStringParameter(request, "getPyvnd");
        String getPspno = ServletRequestUtils.getStringParameter(request, "getPspno");
        String getPlndt = ServletRequestUtils.getStringParameter(request, "getPlndt");

        //System.out.println("getLocCode : "+getLocCode+" getChgdt : "+getChgdt+" getTypcd : "+getTypcd+" getPyvnd : "+getPyvnd+" getPspno : "+getPspno+" getPlndt : "+getPlndt);
        
        CustOrderDataMngDomain criteria = new CustOrderDataMngDomain();
        
        criteria.setLocCode(getLocCode);
        UxisCmmUtil.getCompsLib(criteria);
        //System.out.println("criteriaDomain1 : "+criteria.getCompany()+":"+criteria.getComps()+":"+criteria.getLib1()+":"+criteria.getLib2());

        criteria.setChgdt(getChgdt);
        criteria.setTypcd(getTypcd);
        criteria.setPyvnd(getPyvnd);
        criteria.setPspno(getPspno);
        criteria.setPlndt(getPlndt);
        //System.out.println("criteriaDomain2 : "+criteria.getComps()+":"+criteria.getChgdt()+":"+criteria.getTypcd()+":"+criteria.getPyvnd()+":"+criteria.getPspno()+":"+criteria.getPlndt());
               
        List<CustOrderDataMngDomain> domainlist = null;
        domainlist = customerOrderService.searchByCustOrderDataMng(criteria);

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
    @ErrorBack(viewName = "forward:/WAN025CustOrderDataMng/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String gridComps = ServletRequestUtils.getStringParameter(request, "comps");	//사업부
        String gridTypcd = ServletRequestUtils.getStringParameter(request, "typcd");	//구븐코드
        String gridPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");	//업체코드
        String gridPspno = ServletRequestUtils.getStringParameter(request, "pspno");	//품번
        String gridPlndt = ServletRequestUtils.getStringParameter(request, "plndt");	//계획일자
        String gridBasqy = ServletRequestUtils.getStringParameter(request, "basqy");	//계획수량
        String gridPlncd = ServletRequestUtils.getStringParameter(request, "plncd");	//계획구분
        String gridChgdt = ServletRequestUtils.getStringParameter(request, "chgdt");	//최종갱신일자

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(gridComps);	//미사용

        CustOrderDataMngDomain criteria = new CustOrderDataMngDomain();
        //criteria.setComps(gridComps);	
        //UxisCmmUtil.getCompsLib(criteria);//로케이션코드로 사업부코드,라이브러리 SETTING
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDomain empInfo2 = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        
        criteria.setComps(gridComps);;
        criteria.setTypcd(gridTypcd);
        criteria.setPyvnd(gridPyvnd);
        criteria.setPspno(gridPspno);
        criteria.setPlndt(gridPlndt);
        criteria.setPlncd(gridPlncd);//계획구분
        criteria.setBasqy(gridBasqy);
        criteria.setChgdt(gridChgdt);
        criteria.setChpid(empInfo2.getEmpNumber()); //사번
        
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        //존재하는지 체크
        int cnt = customerOrderService.searchCountCustOrderDataMng(criteria);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        customerOrderService.deleteCustOrderDataMng(criteria);

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
    @ErrorBack(viewName = ".tiles.page.WAN025")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        JSONObject jsonObj = new JSONObject();
        
        String gridComps = ServletRequestUtils.getStringParameter(request, "comps");	//사업부
        String gridTypcd = ServletRequestUtils.getStringParameter(request, "typcd");	//구븐코드
        String gridPyvnd = ServletRequestUtils.getStringParameter(request, "pyvnd");	//업체코드
        String gridPspno = ServletRequestUtils.getStringParameter(request, "pspno");	//품번
        String gridPlndt = ServletRequestUtils.getStringParameter(request, "plndt");	//계획일자
        String gridBasqy = ServletRequestUtils.getStringParameter(request, "basqy");	//계획수량
        String gridPlncd = ServletRequestUtils.getStringParameter(request, "plncd");	//계획구분
        String gridChgdt = ServletRequestUtils.getStringParameter(request, "chgdt");	//최종갱신일자
       /* 
        System.out.println("gridComps : "+gridComps+" gridTypcd : "+gridTypcd+" gridPyvnd : "+gridPyvnd+" gridPspno : "+gridPspno+
        		" gridPlndt : "+gridPlndt+" gridBasqy : "+gridBasqy+" gridPlncd : "+gridPlncd+" gridChgdt : "+gridChgdt);
         */     
        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(gridComps);	//미사용

        CustOrderDataMngDomain criteria = new CustOrderDataMngDomain();
        //criteria.setComps(gridComps);	
        //UxisCmmUtil.getCompsLib(criteria);//로케이션코드로 사업부코드,라이브러리 SETTING
        //로그인 사용자 사업부에 따른 데이터베이스
        //세션 저장된 데이터 불러오기
        EmpDomain empInfo2 = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        
        criteria.setComps(gridComps);;
        criteria.setTypcd(gridTypcd);
        criteria.setPyvnd(gridPyvnd);
        criteria.setPspno(gridPspno);
        criteria.setPlndt(gridPlndt);
        criteria.setPlncd(gridPlncd);//계획구분
        criteria.setBasqy(gridBasqy);
        criteria.setChgdt(gridChgdt);
        criteria.setChpid(empInfo2.getEmpNumber()); //사번
        
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());
        
        //존재하는지 체크
        int cnt = customerOrderService.searchCountCustOrderDataMng(criteria);
        //System.out.println(cnt);
        if(cnt == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.(품번)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }    
   
        customerOrderService.updateCustOrderDataMng(criteria);
  
        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
