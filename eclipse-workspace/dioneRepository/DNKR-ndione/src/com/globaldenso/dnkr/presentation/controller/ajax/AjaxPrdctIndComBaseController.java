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
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.ItemMasterService;
import com.globaldenso.dnkr.business.service.LgstTimeDstrRtBaseService;
import com.globaldenso.dnkr.business.service.MnhrCntrBaseBaseService;
import com.globaldenso.dnkr.business.service.PrdctIndComBaseService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.ItemMasterDomain;
import com.globaldenso.dnkr.domain.LgstTimeDstrRtBaseDomain;
import com.globaldenso.dnkr.domain.MnhrCntrBaseBaseDomain;
import com.globaldenso.dnkr.domain.PrdctIndComBaseDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
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
@RequestMapping(value = "/ajaxPrdctIndComBase")
public class AjaxPrdctIndComBaseController {

    /**
     * [KR] 생산성지표 기준정보(공정관리)서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PrdctIndComBaseService prdctIndComBaseService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxPrdctIndComBaseController() {
        // no process
    }
    
    
    /**
     * [KO] 생산성지표 기준정보(라인기준정보) 조회.<br>
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
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
    /**
     * [KO] 제품코드조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
   
    @RequestMapping(value = "/searchItemMaster", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void searchPrdtCode(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
    	JSONObject jsonObj = new JSONObject();
    	
        String comps = ServletRequestUtils.getStringParameter(request, "getComps");  
        String itemCode = ServletRequestUtils.getStringParameter(request, "itemCode");          

        PrdctIndComBaseDomain prdctIndComBaseDomain = new PrdctIndComBaseDomain();

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(comps);
        prdctIndComBaseDomain.setLib1(empInfo.getLib1());
        prdctIndComBaseDomain.setLib2(empInfo.getLib2());
        prdctIndComBaseDomain.setCode(itemCode);
        
        List<PrdctIndComBaseDomain> itemMasterDomainList = prdctIndComBaseService.searchItemMaster(prdctIndComBaseDomain);
        
        if(itemMasterDomainList != null) {
            jsonObj.put("list", itemMasterDomainList);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
    /**
     * [KO] 더존부서정보조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
   
    @RequestMapping(value = "/searchDeptMaster", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void searchDeptMaster(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
    	JSONObject jsonObj = new JSONObject();

    	String comps = ServletRequestUtils.getStringParameter(request, "getComps");
    	String code = ServletRequestUtils.getStringParameter(request, "getCode");  
/*     
        if(comps.equals("E1")) {
        	comps = "1000";
        }else if(comps.equals("E2")) {
        	comps = "2000";
        }else if(comps.equals("S1")) {
        	comps = "3000";
        }
*/
        PrdctIndComBaseDomain prdctIndComBaseDomain = new PrdctIndComBaseDomain();
        prdctIndComBaseDomain.setComps(comps);
        prdctIndComBaseDomain.setDeptCdMap(code);        

        List<PrdctIndComBaseDomain> itemMasterDomainList = prdctIndComBaseService.searchDeptMaster(prdctIndComBaseDomain);
        
        if(itemMasterDomainList != null) {
            jsonObj.put("list", itemMasterDomainList);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }    
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/initDeptPop", method = RequestMethod.GET)
    public ModelAndView initDeptPop(HttpServletRequest request)  throws Exception {

    	ModelAndView mv = new ModelAndView();

        UxisCmmUtil.getSessionComCode(request, mv);
        
        mv.addObject("url", "DeptPopSelect.jsp");
        mv.setViewName(".tiles.page.WATDEPT");
        return mv;
    }    
    
}
