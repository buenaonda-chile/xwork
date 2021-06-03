package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;

/**
 * [KO] 업무 승인 관리 의  ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxWorkConfirm")
public class AjaxWorkConfirmController{

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private WorkSortService workSortService;
    
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
     * [KR] 사업부서(팀)관리 서비스 <br>     
     */
    @Autowired
    private RelationTeamService relationTeamService;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxWorkConfirmController () {
        //no process
    }
    
    
    /**
     * [KO] 조직도 조회.<br>
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

        /**
         * [KO] 공통코드 조회.<br>
         * [EN] Common code select.<br>
         * [JP] <br>
         * 
         * @return ModelAndView
         * @throws Exception Exception
         */

        //System.out.println("ajaxRelation/init.do");

        JSONObject jsonObj = new JSONObject();

        String type = ServletRequestUtils.getStringParameter(request, "type");
        String parentCode = ServletRequestUtils.getStringParameter(request, "parentCode");
        //System.out.println("type:" + type);

        List<? extends RelationDomain> relationDomainlist = null;
        List<EmpDomain> empList = null;

        if (type == null) {
            type = "CLS";
        }

        if (type.equals("CLS")) {
            RelationClsDomain criteria = new RelationClsDomain();
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            relationDomainlist = relationClsService.searchByCondition(criteria);
        } else if (type.equals("LOC")) {
            RelationLocDomain criteria = new RelationLocDomain();
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            criteria.setClsCode(parentCode);
            relationDomainlist = relationLocService.searchByCondition(criteria);
        } else if (type.equals("TEAM")) {
            RelationTeamDomain criteria = new RelationTeamDomain();
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            criteria.setLocCode(parentCode);
            relationDomainlist = relationTeamService.searchByCondition(criteria);
        } else if (type.equals("EMP")) {
            EmpDomain criteria = new EmpDomain();
            //System.out.println("parentCode:" + parentCode);
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            criteria.setTeamCode(parentCode);
            empList = empService.searchByCondition(criteria);
            if(empList != null) {
                jsonObj.put("list", empList);
            }
        }

        if(relationDomainlist != null) {
            jsonObj.put("list", relationDomainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

}
