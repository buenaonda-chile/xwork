package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.LinkService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.SsoAccountDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAC021SsoAccountForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;



/**
 * [KR] SSO조회  컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC023SsoAccountDevice")
@ViewId(value = "WAC023")
public class WAC023SsoAccountDeviceController {
    
    /**
     * [KR] 링크 서비스 <br>     
     */
    @Autowired
    private LinkService linkService;
    
    
	/**
	 * [KR] 공통코드관리 서비스 <br>
	 */
	@Autowired
	private CodeService codeService;
	
	
    /**
     * [KR] 사업부관리 서비스 <br>     
     */
    @Autowired
    private RelationClsService relationClsService;
    
    /**
     * [KR] 사업장관리 서비스 <br>          
     */
    @Autowired
    private RelationLocService relationLocService;


    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAC023SsoAccountDeviceController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAC021SsoAccountForm
     * @return ModelAndView
     * @throws Exception Exception
     */
	@RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView initSsoAccountInt(HttpServletRequest request,
			@ModelAttribute("WAC021SsoAccountForm") WAC021SsoAccountForm form)
			throws Exception {
		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */
		System.out.println("OK");
		// Tab, 메뉴 기본 처리
		String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
		String menu = ServletRequestUtils.getStringParameter(request, "menu");

		ModelAndView mv = new ModelAndView();

		/*
		// 세션 저장된 데이터 불러오기
		EmpDb2Domain empInfo = (EmpDb2Domain) request.getSession().getAttribute("ACCOUNT_DB2");
		//사업부 코드
		CodeDb2Domain codeDomain = new CodeDb2Domain();
		codeDomain.setDb2class("PLNT");
		//codeDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeList = null;	//사업부코드
		try {
			codeList = codeService.comCode(codeDomain);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}

		//사업장 코드
		CodeDb2Domain codeDomain2 = new CodeDb2Domain();
		codeDomain2.setDb2class("COMP");
		//codeDomain.setCoded1(empInfo.getCompany());

		List<CodeDb2Domain> codeList2 = null;	//사업부코드
		try {
			codeList2 = codeService.comCode(codeDomain2);			
		} catch (Exception e) {
			System.out.println("데이터가 없습니다.");
		}
*/
		
		RelationClsDomain clsDomain = new RelationClsDomain();
	    clsDomain.setUseYn("Y");
	    clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
	    List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
	        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        
		UxisCmmUtil.getSessionLoc(request, mv);
		
		mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
		mv.addObject("tabId", tabId);
		mv.addObject("menu", menu);
		//mv.addObject("codeList", codeList);
		//mv.addObject("codeList2", codeList2);
		mv.addObject("clsList", clsList);
		mv.addObject("locList", locList);
		mv.addObject("paraDomain", form);
		mv.addObject("url", "WAC023SsoAccountDevice.jsp");
		mv.setViewName(".tiles.page.WAC023SsoAccountDevice");
		return mv;
	}
	/**
	 * [종합관리] - [판매정보] - 출하매출현황 데이터 조회
	 * 
	 * @param request HttpServletRequest
	 * @param form    WAE022ShippingSalesForm
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ssoAccountDeviceSearch(HttpServletRequest request,
			@ModelAttribute("WAC021SsoAccountForm") WAC021SsoAccountForm form)
			throws Exception {

		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */

		ModelAndView model = new ModelAndView(new JsonView());
		JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
		
		form.setEmpUse("Y");//사용여부
		form.setInOutType("I");	//내부/외부 직원구분
		form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());	//언어
		List<SsoAccountDomain>  ssoAccountList = null;
        
		try {
			ssoAccountList = linkService.searchBySsoAccount(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ssoAccountList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", ssoAccountList);
		}
		
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	@RequestMapping(value = "/ajaxSearchDeviceCompany", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ssoAccountDeviceCompanySearch(HttpServletRequest request,
			@ModelAttribute("WAC021SsoAccountForm") WAC021SsoAccountForm form)
			throws Exception {

		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */
		form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());	//언어
		ModelAndView model = new ModelAndView(new JsonView());
		JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
		
		List<SsoAccountDomain>  searchBySsoDeviceCompanyList = null;
        
		try {
			searchBySsoDeviceCompanyList = linkService.searchBySsoDeviceCompany(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchBySsoDeviceCompanyList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", searchBySsoDeviceCompanyList);
		}
		//System.out.println(searchBySsoDeviceCompanyList);
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	@RequestMapping(value = "/ajaxSearchDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ssoAccountDeviceDetailSearch(HttpServletRequest request,
			@ModelAttribute("WAC021SsoAccountForm") WAC021SsoAccountForm form)
			throws Exception {

		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */
		form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());	//언어
		form.setCmcParentCode("CMCM00110");//디바이스 코드
		ModelAndView model = new ModelAndView(new JsonView());
		JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
		
		List<SsoAccountDomain>  searchBySsoDeviceList = null;
        
		try {
			searchBySsoDeviceList = linkService.searchBySsoDevice(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchBySsoDeviceList != null) {
			result = DnkrConstans.RESULT_Y;
			jsonObj.put("list", searchBySsoDeviceList);
		}
		
		jsonObj.put("result", result);

		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
    /**
     * [KO] 주 처리과정.<br>
     * [KO] 권한 정보 수정.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] <br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param form  WAC017LinkManagementForm
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/saveAction", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    //@ErrorBack(viewName = ".tiles.page.WAC023SsoAccountDevice")
    public void saveAction(@RequestBody List<SsoAccountDomain> ajaxParams,
    		HttpServletRequest request, HttpServletResponse response)  
        throws Exception {

   	 	//세션 저장된 데이터 불러오기
    	String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
    	JSONParser parser = new JSONParser();
    	Object empInfoObj       = parser.parse(empInfo);
    	JSONObject empJsonObj   = (JSONObject)empInfoObj;
    	String empId        = (String)empJsonObj.get("empId");        //사용자 ID
    	
    	
    	//System.out.println(ajaxParams);
		//List<SsoAccountDomain> searchBySsoDeviceCheck = null;
    	
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("result", DnkrConstans.RESULT_N);
    	for(SsoAccountDomain SsoAccountDomain : ajaxParams) {
        	SsoAccountDomain.setCreateUser(empId);
        	SsoAccountDomain.setUpdateUser(empId);
            
            int count=0;
            int rltCount=0;
            	count = linkService.searchBySsoDeviceCount(SsoAccountDomain);
            if(count==0) {
                //System.out.println("insert : "+ SsoAccountDomain.getEmpNumber()+"="+ SsoAccountDomain.getDeviceId()+"="+ SsoAccountDomain.getDeviceName()+"="+ SsoAccountDomain.getUseYn()+"="+ SsoAccountDomain.getCompany()+"="+SsoAccountDomain.getCreateUser());
            	if(SsoAccountDomain.getDeviceName() != null &&SsoAccountDomain.getDeviceName() != "") {
            		rltCount= linkService.insertSsoDeviceUser(SsoAccountDomain);
            	}
            }else {
                //System.out.println("update : "+ SsoAccountDomain.getEmpNumber()+"="+ SsoAccountDomain.getDeviceId()+"="+ SsoAccountDomain.getDeviceName()+"="+ SsoAccountDomain.getUseYn()+"="+ SsoAccountDomain.getCompany()+"="+SsoAccountDomain.getUpdateUser());
            	rltCount = linkService.updateSsoDeviceUser(SsoAccountDomain);
            }
            if(rltCount < 0) {
            	jsonObj.put("result", DnkrConstans.RESULT_OK);
            }
          //System.out.println("count : "+ count+" rltCount : "+ rltCount);
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
