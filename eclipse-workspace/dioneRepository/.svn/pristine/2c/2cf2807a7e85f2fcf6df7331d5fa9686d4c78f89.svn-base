package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.util.Strings;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;

/**
 * [KO] 공통코드의  ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing of common code (WAC015).<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxRelation")
public class AjaxRelationController {

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] 코드관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * [KR] 조직도(사업부)관리 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private RelationClsService relationClsService;
    
    /**
     * [KR] 조직도(사업장)관리 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private RelationLocService relationLocService;
    
    /**
     * [KR] 조직도(사업부서)관리 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private RelationTeamService relationTeamService;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxRelationController() {
        // no process
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
        String sort = ServletRequestUtils.getStringParameter(request, "sort");
        String parentCode = ServletRequestUtils.getStringParameter(request, "parentCode");
        String allView = ServletRequestUtils.getStringParameter(request, "allView");	//2020.09.25 JHB 추가 : WAD013사용
        //System.out.println("type:" + type);
        //System.out.println("allView:" + allView);

        //사업부, 사업장, 사업부서 등록페이지 체크
        Boolean checkPage = true;
        if(sort != null) {
            if(sort.equals("RELATION")) {
                checkPage = false;
            }
        }
        List<? extends RelationDomain> relationDomainlist = null;
        List<EmpDomain> empList = null;

        if (type == null) {
            type = "CLS";
        }

        if (type.equals("CLS")) {
            RelationClsDomain criteria = new RelationClsDomain();
            if(checkPage) {
                criteria.setUseYn("Y");
            }
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            relationDomainlist = relationClsService.searchByCondition(criteria);
        } else if (type.equals("LOC")) {
            RelationLocDomain criteria = new RelationLocDomain();
            if(checkPage) {
                criteria.setUseYn("Y");
            }
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            criteria.setClsCode(parentCode);
            relationDomainlist = relationLocService.searchByCondition(criteria);
        } else if (type.equals("TEAM")) {
            RelationTeamDomain criteria = new RelationTeamDomain();
            if(checkPage) {
                criteria.setUseYn("Y");
                if("Y".equals(allView)){	//2020.09.25 JHB 추가 : WAD013사용
                	 criteria.setUseYn("");
                }
            }
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            criteria.setLocCode(parentCode);
            relationDomainlist = relationTeamService.searchByCondition(criteria);
        } else if (type.equals("EMP")) {
            EmpDomain criteria = new EmpDomain();
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

    /**
     * [KO] 조직도 조회.<br>
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

        /**
         * [KO] 조직도 검색.<br>
         * [EN] <br>
         * [JP] <br>
         * 
         * @return ModelAndView
         * @throws Exception Exception
         */

        JSONObject jsonObj = new JSONObject();

        String type = ServletRequestUtils.getStringParameter(request, "type");
        String relationName = ServletRequestUtils.getStringParameter(request, "relationName");

        String getCls = ServletRequestUtils.getStringParameter(request, "getCls");
        String getLoc = ServletRequestUtils.getStringParameter(request, "getLoc");
        //System.out.println("type:" + type);
        //System.out.println("relationName:" + relationName);

        List<? extends RelationDomain> relationList = null;

        if (type == null) {
            type = "CLS";
        }

        if (type.equals("CLS")) {
            RelationClsDomain criteria = new RelationClsDomain();
            criteria.setRelationName(relationName);
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            relationList = relationClsService.searchByCondition(criteria);
        } else if (type.equals("LOC")) {
            RelationLocDomain criteria = new RelationLocDomain();
            criteria.setClsCode(getCls);
            criteria.setRelationName(relationName);
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            relationList = relationLocService.searchByCondition(criteria);
        } else if (type.equals("TEAM")) {
            RelationTeamDomain criteria = new RelationTeamDomain();
            criteria.setLocCode(getLoc);
            criteria.setRelationName(relationName);
            criteria.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            relationList = relationTeamService.searchByCondition(criteria);
        }

        if(relationList != null) {
            jsonObj.put("list", relationList);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * [KO] 조직도 삭제.<br>
     * [EN] Main processing<br>
     * [EN] Delete from the DB the information displayed on the screen.<br>
     * [JP] 社員削除処理<br>
     * [JP] 画面上で選択された社員情報をDBから削除します。<br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAD008RelationSearch/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /**
         * <pre>
         * 1.[KO] 조직도 삭제 처리<br>
         *   [KO]   화면에서 선택된 조직도를 DB에서 삭제합니다.<br>
         * 1.[EN] <br>
         *   [JP] <br>
         * </pre>
         */

        //System.out.println("delete start");
        JSONObject jsonObj = new JSONObject();
        String delRelationCode = ServletRequestUtils.getStringParameter(request, "relationCode");
        String delType = ServletRequestUtils.getStringParameter(request, "type");
        //System.out.println("delRelationCode:" + delRelationCode);

        response.setContentType("text/html;charset=utf-8");

        if(delType.equals(DnkrConstans.CLS_TYPE)){
            //하위코드가 존재하는지 체크
            RelationLocDomain subLocDomain = new RelationLocDomain();
            subLocDomain.setClsCode(delRelationCode);
            int subLocCount = relationLocService.searchLocCount(subLocDomain);
            
            if(subLocCount > 0) {
                jsonObj.put("errMsg", "하위코드가 존재합니다.");
                response.getWriter().print(jsonObj);
                return;
            }

            RelationClsDomain delClsDomain = new RelationClsDomain();
            delClsDomain.setRelationCode(delRelationCode);
            relationClsService.delete(delClsDomain);
        } else if(delType.equals(DnkrConstans.LOC_TYPE)){
            //하위코드가 존재하는지 체크
            RelationTeamDomain subTeamDomain = new RelationTeamDomain();
            subTeamDomain.setLocCode(delRelationCode);
            //System.out.println("subTeamDomain:" + subTeamDomain.toString());
            int subTeamCount = relationTeamService.searchTeamCount(subTeamDomain);

            if(subTeamCount > 0) {
                jsonObj.put("errMsg", "하위코드가 존재합니다.");
                response.getWriter().print(jsonObj);
                return;
            }

            RelationLocDomain delLocDomain = new RelationLocDomain();
            delLocDomain.setRelationCode(delRelationCode);
            relationLocService.delete(delLocDomain);
        } else if(delType.equals(DnkrConstans.TEAM_TYPE)){

            RelationTeamDomain delTeamDomain = new RelationTeamDomain();
            delTeamDomain.setRelationCode(delRelationCode);
            relationTeamService.delete(delTeamDomain);
        }

        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }

    /**
     * [KO] 주 처리과정.<br>
     * [KO] 조직도 추가.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] .<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAD008RelationSearch/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        /**
         * <pre>
         * 1.[KO] 조직도 등록 처리.<br>
         *   [KO]   입력한 내용으로 조직도를 등록한다.<br>
         * 1.[EN] Relation code registration processing.<br>
         *   [EN]   I register an Relation code with DB by input contents.<br>
         *   [JP] 
         *   [JP] 
         * </pre>
         */

        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObj = new JSONObject();
        //System.out.println("ajaxRelation/create.do");

        String type = ServletRequestUtils.getStringParameter(request, "type");
        String relationCode = ServletRequestUtils.getStringParameter(request, "relationCode");
        String relationName = ServletRequestUtils.getStringParameter(request, "relationName");
        //String useYn = ServletRequestUtils.getStringParameter(request, "useYn");
        String authCode = ServletRequestUtils.getStringParameter(request, "authCode");
        
      //언어조회
        //System.out.println("언어조회");
        CodeDomain langDomain = new CodeDomain();
        langDomain.setCmcParentCode(DnkrConstans.CMC_SUPER_LANG_CODE);
        List<CodeDomain> domainList = codeService.searchByCondition(langDomain);
        List<String> langList = new ArrayList<String>();
        
        if(! domainList.isEmpty()) {
            for(CodeDomain domain: domainList) {
                langList.add(domain.getCmcCode());
            }
        }
        
        if (type.equals(DnkrConstans.CLS_TYPE)) {
            RelationClsDomain createCls = new RelationClsDomain();
            createCls.setRelationCode("new");
            createCls.setRelationName(relationName);
            //createCls.setUseYn(useYn);
            relationClsService.create(createCls, langList);
        } else {
            String parentCode = ServletRequestUtils.getStringParameter(request, "parentCode");
            if (type.equals(DnkrConstans.LOC_TYPE)) {
                //System.out.println("if (type.equals(DnkrConstans.LOC_TYPE)) {");
                //상위코드가 존재하는지 체크
                RelationClsDomain parentDomain = new RelationClsDomain();
                parentDomain.setRelationCode(parentCode);
                RelationClsDomain checkDomain = relationClsService.searchByKey(parentDomain);
                if(checkDomain == null){
                    jsonObj.put("errMsg", "존재하지 않는 상위코드입니다.");
                    response.getWriter().print(jsonObj);
                    return;
                }

                RelationLocDomain createLoc = new RelationLocDomain();
                createLoc.setRelationCode("new");
                createLoc.setRelationName(relationName);
                createLoc.setClsCode(parentCode);
                //createLoc.setUseYn(useYn);

                relationLocService.create(createLoc, langList);

                if(parentCode == null || Strings.judgeBlank(parentCode)){
                    jsonObj.put("errMsg", "상위코드를 선택해주세요");
                    response.getWriter().print(jsonObj);
                    return;
                }
            } else if (type.equals(DnkrConstans.TEAM_TYPE)) {
                //System.out.println("} else if (type.equals(DnkrConstans.TEAM_TYPE))");
                //상위코드가 존재하는지 체크
                RelationLocDomain parentDomain = new RelationLocDomain();
                parentDomain.setRelationCode(parentCode);
                RelationLocDomain checkDomain = relationLocService.searchByKey(parentDomain);
                if(checkDomain == null){
                    jsonObj.put("errMsg", "존재하지 않는 상위코드입니다.");
                    response.getWriter().print(jsonObj);
                    return;
                }

                RelationTeamDomain createTeam = new RelationTeamDomain();
                createTeam.setRelationCode("new");
                createTeam.setRelationName(relationName);
                createTeam.setLocCode(parentCode);
                //createTeam.setUseYn(useYn);
                createTeam.setAuthCode(authCode);
                relationTeamService.create(createTeam, langList);
            }
        }
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
        
    }
    
    /**
     * [KO] 주 처리과정.<br>
     * [KO] 공통코드 수정.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] Register to DB information you have modified the screen.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAC015")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        /**
         * <pre>
         * 1.[KO] 공통코드 수정 처리.
         *   [KO]   입력한 내용으로 공통코드를 수정한다.
         * 1.[EN] Common code update process.
         *   [EN]   I update an Common code with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */

        JSONObject jsonObj = new JSONObject();

        String type = ServletRequestUtils.getStringParameter(request, "type");
        String relationCode = ServletRequestUtils.getStringParameter(request, "relationCode");
        String relationName = ServletRequestUtils.getStringParameter(request, "relationName");
        String useYn = ServletRequestUtils.getStringParameter(request, "useYn");
        String authCode = ServletRequestUtils.getStringParameter(request, "authCode");

        if (type.equals(DnkrConstans.CLS_TYPE)) {
            RelationClsDomain updateClsTarget = new RelationClsDomain();
            updateClsTarget.setRelationCode(relationCode);

            //생성하는 코드가 존재하는지 체크
            if (relationClsService.searchByKey(updateClsTarget) == null) {
                jsonObj.put("errMsg", "잘못된 접근입니다.");
                response.getWriter().print(jsonObj);
                return;
            }

            updateClsTarget.setRelationName(relationName);
            updateClsTarget.setUseYn(useYn);
            updateClsTarget.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            
            relationClsService.update(updateClsTarget);
            
        } else if (type.equals(DnkrConstans.LOC_TYPE)) {
            RelationLocDomain updateLocTarget = new RelationLocDomain();
            updateLocTarget.setRelationCode(relationCode);

            //생성하는 코드가 존재하는지 체크
            if (relationLocService.searchByKey(updateLocTarget) == null) {
                jsonObj.put("errMsg", "잘못된 접근입니다.");
                response.getWriter().print(jsonObj);
                return;
            }

            updateLocTarget.setRelationName(relationName);
            updateLocTarget.setUseYn(useYn);
            updateLocTarget.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            
            relationLocService.update(updateLocTarget);
            
        } else if (type.equals(DnkrConstans.TEAM_TYPE)) {
            RelationTeamDomain updateTeamTarget = new RelationTeamDomain();
            updateTeamTarget.setRelationCode(relationCode);

            //생성하는 코드가 존재하는지 체크
            if (relationTeamService.searchByKey(updateTeamTarget) == null) {
                jsonObj.put("errMsg", "잘못된 접근입니다.");
                response.getWriter().print(jsonObj);
                return;
            }

            updateTeamTarget.setRelationName(relationName);
            updateTeamTarget.setUseYn(useYn);
            updateTeamTarget.setAuthCode(authCode);
            updateTeamTarget.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            
            relationTeamService.update(updateTeamTarget);

        }
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }
}
