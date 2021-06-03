package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.List;
import java.util.Map;

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
import com.globaldenso.dnkr.business.service.PjtService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.PjtDomain;
import com.globaldenso.dnkr.domain.WorkSortDomain;

/**
 * [KO] 업무 분류 관리 의  ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxPjt")
public class AjaxPjtController {

    /**
     * [KR] 프로젝트 등록 관리 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private PjtService pjtService;
    
    /**
     * [KR] 프로젝트 등록 관리 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private WorkSortService workSortService;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxPjtController () {
        //no process
    }
    
    /**
     * [KO] 업무 분류 조회.<br>
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
         * [KO] 업무분류 조회.<br>
         * [EN] <br>
         * [JP] <br>
         * 
         * @throws Exception Exception
         */

        //System.out.println("ajaxWorkSort/init.do");

        JSONObject jsonObj = new JSONObject();

        String type = ServletRequestUtils.getStringParameter(request, "type");
        String upperCode = ServletRequestUtils.getStringParameter(request, "upperCode");
        //System.out.println("type:" + type);

        WorkSortDomain criteria = new WorkSortDomain();
        criteria.setLangCmc(DensoContext.get().getLocale().getLanguage());
        List<WorkSortDomain> workSortDomainList = null;

        if (type == null) {
            type = "L";
        }

        if(type.equals("L")){
            criteria.setWorkLv(1);
            workSortDomainList = workSortService.searchByCondition(criteria);
        } else if(type.equals("M") || type.equals("S") ){
            if(type.equals("M")) {
                criteria.setWorkLv(2);
            }else if(type.equals("S")) {
                criteria.setWorkLv(3);
            }
            criteria.setUppWorkCode(upperCode);
            workSortDomainList = workSortService.searchByCondition(criteria);
        }

        if(workSortDomainList != null) {
            jsonObj.put("list", workSortDomainList);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * [KO] 업무 분류 조회.<br>
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
        String workTypeNm = ServletRequestUtils.getStringParameter(request, "workTypeNm");

        //System.out.println("type:" + type);
        //System.out.println("workTypeNm:" + workTypeNm);
        String logEmpNum = (String)request.getSession().getAttribute("logEmpNum");
        List<WorkSortDomain> workSortList = null;

        WorkSortDomain criteria = new WorkSortDomain();

        criteria.setWorkTypeNm(workTypeNm);
        criteria.setLangCmc(DensoContext.get().getLocale().getLanguage());
        //System.out.println("criteria.getLangCmc():" + criteria.getLangCmc());
        workSortList = workSortService.searchByCondition(criteria);

        if(workSortList != null) {
            jsonObj.put("list", workSortList);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * [KO] 주 처리과정.<br>
     * [KO] 업무분류 수정.<br>
     * 
     * [EN] Main processing.<br>
     * [EN] Register to DB information you have modified the screen.<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param domain PjtDomain
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAK001PjtSearch/init.do")
    public void update(PjtDomain domain, HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        /**
         * <pre>
         * 1.[KO] 프로젝트 데이터 수정 처리.<br>
         *   [KO]   입력한 내용으로 업무분류 데이터를 수정한다.<br>
         * 1.[EN] <br>
         *   [JP] <br>
         * </pre>
         */

        response.setContentType("text/html;charset=utf-8");
        //System.out.println("ajaxWorkSort/update.do");
        JSONObject jsonObj = new JSONObject();     

        String logEmpNum = (String)request.getSession().getAttribute("logEmpNum");

        //System.out.println("logEmpNum:" + logEmpNum);
        PjtDomain criteria = pjtService.searchByKey(domain);

        //로그인한 사원이 프로젝트 수정시 승인구분을 대기로 수정
        domain.setAprvType("S");

        if(logEmpNum.equals(criteria.getEmpNumber())) {
            int count = pjtService.update(domain);
            //System.out.println("count:" + count);
            //if(count >0){
            //jsonObj.put("result", DnkrConstans.RESULT_OK);
        //} else {
            //jsonObj.put("errMsg", "잠시 후 시도해 주세요.");
        //}
            jsonObj.put("result", DnkrConstans.RESULT_OK);
        } else {
            jsonObj.put("errMsg", "잘못된 접근입니다.");
        }
        response.getWriter().print(jsonObj);
        return;
    }
    
    /**
     * [KO] 업무 분류 정보 삭제.<br>
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
    @ErrorBack(viewName = "forward:/WAK001PjtSearch/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /**
         * <pre>
         * 1.[KO] 조직도 삭제 처리<br>
         *   [KO]   화면에서 선택된 조직도를 DB에서 삭제합니다.<br>
         * 1.[EN] <br>
         *   [JP] <br>
         * </pre>
         */

        //System.out.println("ajaxWorkSort/delete start");
        JSONObject jsonObj = new JSONObject();
        int pjtNum = ServletRequestUtils.getIntParameter(request, "pjtNum");
        //System.out.println("pjtNum:" + pjtNum);

        response.setContentType("text/html;charset=utf-8");

        //업무분류 데이터 삭제처리
        PjtDomain delPjtDomain = new PjtDomain();
        delPjtDomain.setPjtNum(pjtNum);
        pjtService.delete(delPjtDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }

}
