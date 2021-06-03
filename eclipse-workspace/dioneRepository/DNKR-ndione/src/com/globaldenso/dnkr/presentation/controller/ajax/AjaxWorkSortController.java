package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.util.Strings;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.PjtService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
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
@RequestMapping(value = "/ajaxWorkSort")
public class AjaxWorkSortController {

    /**
     * [KR] 코드관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private WorkSortService workSortService;
    
    /**
     * [KO] 업무분류 관리 Dao <br>
     */
    @Autowired
    private PjtService pjtService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxWorkSortController () {
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
        String teamCode = ServletRequestUtils.getStringParameter(request, "teamCode");
        String sort = ServletRequestUtils.getStringParameter(request, "sort");
        String upperCode = ServletRequestUtils.getStringParameter(request, "upperCode");
        //System.out.println("type:" + type);

        WorkSortDomain criteria = new WorkSortDomain();

        //업무코드등록페이지 체크
        //sort == "WORK" 면 전체조회
        //sort != "WORK" 활성화 업무코드만 조회
        if(sort != null) {
            if(! sort.equals("WORK")) {
                criteria.setUseYn("Y");
            }
        } else {
            criteria.setUseYn("Y");
        }

        criteria.setLangCmc(DensoContext.get().getLocale().getLanguage());
        criteria.setTeamCode(teamCode);
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
        String teamCode = ServletRequestUtils.getStringParameter(request, "teamCode");
        String sort = ServletRequestUtils.getStringParameter(request, "sort");
        String workTypeNm = ServletRequestUtils.getStringParameter(request, "workTypeNm");

        String getWtcL = ServletRequestUtils.getStringParameter(request, "getWtcL");
        String getWtcM = ServletRequestUtils.getStringParameter(request, "getWtcM");
        
        WorkSortDomain criteria = new WorkSortDomain();

        //업무코드등록페이지 체크
        //sort == "WORK" 면 전체조회
        //sort != "WORK" 활성화 업무코드만 조회
        if(sort != null) {
            if(! sort.equals("WORK")) {
                criteria.setUseYn("Y");
            }
        } else {
            criteria.setUseYn("Y");
        }

        criteria.setLangCmc(DensoContext.get().getLocale().getLanguage());
        criteria.setTeamCode(teamCode);
        List<WorkSortDomain> workSortList = null;

        if (type == null) {
            type = "L";
        }
        
        System.out.println("getWtcL : " + getWtcL);
        
        if(type.equals("L")){
            criteria.setWorkLv(1);
            workSortList = workSortService.searchByCondition(criteria);
        } else if(type.equals("M") || type.equals("S") ){
            if(type.equals("M")) {
                criteria.setUppWorkCode(getWtcL);
                criteria.setWorkLv(2);
            }else if(type.equals("S")) {
                criteria.setUppWorkCode(getWtcM);
                criteria.setWorkLv(3);
            }
            workSortList = workSortService.searchByCondition(criteria);
        }

        //criteria.setWorkTypeNm(workTypeNm);
        //criteria.setLangCmc(DensoContext.get().getLocale().getLanguage());
        //System.out.println("criteria.getLangCmc():" + criteria.getLangCmc());
        //workSortList = workSortService.searchByCondition(criteria);

        if(workSortList != null) {
            jsonObj.put("list", workSortList);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
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
     * @param domain WorkSortDomain
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
//    @ErrorBack(viewName = "forward:init.do")
    public void create(WorkSortDomain domain, HttpServletRequest request, HttpServletResponse response) throws Exception {

        /**
         * <pre>
         * 1.[KO] 업무 분류 등록 처리.<br>
         *   [KO]   입력한 내용으로 업무를 등록한다.<br>
         * 1.[EN] <br>
         *   [JP] 
         * </pre>
         */

        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObj = new JSONObject();
        //System.out.println("ajaxWorkSort/create.do");

        String type = ServletRequestUtils.getStringParameter(request, "type");
        String workCode = ServletRequestUtils.getStringParameter(request, "workCode");
        String workTypeNm = ServletRequestUtils.getStringParameter(request, "workTypeNm");
        String useYn = ServletRequestUtils.getStringParameter(request, "useYn");
        //String aprvCode = ServletRequestUtils.getStringParameter(request, "aprvCode");

        //System.out.println("type:" + type);
        //System.out.println("workCode:" + workCode);
        //System.out.println("domain.getWorkCode:" + domain.getWorkCode());
        //System.out.println("domain.getWorkTypeNm:" + domain.getWorkTypeNm());

        String madeWorkSortNum = makeWorkSortNum();
        domain.setWorkCode(madeWorkSortNum);
        //System.out.println("madeWorkSortNum:" + madeWorkSortNum);
        //System.out.println("domain.getWorkCode:" + domain.getWorkCode());
        //최상위 레벨이면
        if (! type.equals("L")) {
            //System.out.println("if (! type.equals(L)) {");
            String upperCode = ServletRequestUtils.getStringParameter(request, "upperCode");
            if(upperCode == null || Strings.judgeBlank(upperCode)){
                jsonObj.put("errMsg", "상위코드를 선택해주세요");
                response.getWriter().print(jsonObj);
                return;
            }


            //상위코드가 존재하는지 체크
            WorkSortDomain setDomain = new WorkSortDomain();
            setDomain.setWorkCode(upperCode);
            WorkSortDomain checkDomain = workSortService.searchByKey(setDomain);
            if(checkDomain == null){
                jsonObj.put("errMsg", "존재하지 않는 상위코드입니다.");
                response.getWriter().print(jsonObj);
                return;
            }

            if (type.equals("M")) {
                domain.setWorkLv(2);
            } else if (type.equals("S")) {
                domain.setWorkLv(3);
            }

            domain.setUppWorkCode(upperCode);
        }
        workSortService.create(domain);
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
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
     * @param domain WorkSortDomain
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAK005")
    public void update(WorkSortDomain domain, HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        /**
         * <pre>
         * 1.[KO] 업무분류 데이터 수정 처리.<br>
         *   [KO]   입력한 내용으로 업무분류 데이터를 수정한다.<br>
         * 1.[EN] <br>
         *   [JP] <br>
         * </pre>
         */
        
        //System.out.println("ajaxWorkSort/update.do");
        JSONObject jsonObj = new JSONObject();        

        //생성하는 코드가 존재하는지 체크
        if (workSortService.searchByKey(domain) == null) {
            jsonObj.put("errMsg", "잘못된 접근입니다.");
            response.getWriter().print(jsonObj);
            return;
        }

        domain.setLangCmc(DensoContext.get().getLocale().getLanguage());
        workSortService.update(domain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);
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
    @ErrorBack(viewName = "forward:/WAK005WorkSortSearch/init.do")
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
        String delWorkCode = ServletRequestUtils.getStringParameter(request, "workCode");
        String delType = ServletRequestUtils.getStringParameter(request, "type");
        //System.out.println("delWorkCode:" + delWorkCode);

        response.setContentType("text/html;charset=utf-8");

        if(delType.equals("L") || delType.equals("M")){
            //하위코드가 존재하는지 체크
            WorkSortDomain subWorkDomain = new WorkSortDomain();
            subWorkDomain.setUppWorkCode(delWorkCode);
            int subWorkCount = 0;
            try {
                subWorkCount = workSortService.searchCount(subWorkDomain);
            } catch (Exception e) {
                //System.out.println("보여줄 데이터가 없습니다.");
            }

            if(subWorkCount > 0) {
                jsonObj.put("errMsg", "하위코드가 존재합니다.");
                response.getWriter().print(jsonObj);
                return;
            }
        }

        //업무분류 데이터 삭제처리
        WorkSortDomain delWorkDomain = new WorkSortDomain();
        PjtDomain pjt = new PjtDomain();
        if(delType.equals("L")){
            pjt.setWorkLCode(delWorkCode);
        } else if(delType.equals("M")){
            pjt.setWorkMCode(delWorkCode);
        } else if(delType.equals("S")){
            pjt.setWorkSCode(delWorkCode);
        }

        //프로젝트에 등록된 업무분류코드인지 확인
        int pjtCnt = 0;

        try{
            pjtCnt = pjtService.searchCount(pjt);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }

        if (pjtCnt > 0) {
            jsonObj.put("errMsg", "프로젝트에 등록된 업무분류코드입니다..");
        }else {
            delWorkDomain.setWorkCode(delWorkCode);
            workSortService.delete(delWorkDomain);
            jsonObj.put("result", DnkrConstans.RESULT_OK);
        }
        response.getWriter().print(jsonObj);
        return;
    }

    /**
     * 
     * 
     * @return String
     * @throws Exception 
     */
    private String makeWorkSortNum() throws Exception{
        WorkSortDomain criteria = new WorkSortDomain();
        StringBuffer madeWorkSortNum = new StringBuffer();

        //외부직원은 맨앞글자를 O로 고정
        madeWorkSortNum.append("WTC");

        String maxWorkCodeNum = workSortService.searchMaxWorkCodeNum(criteria);
        if (maxWorkCodeNum == null || "".equals(maxWorkCodeNum)){
            //가장큰 데이터가 없을경우 
            madeWorkSortNum.append("00001");
        } else {
            int strLength = maxWorkCodeNum.length();
            int maxNo = Integer.parseInt(maxWorkCodeNum.substring(3, strLength));
            String strMaxNo = String.format("%05d", maxNo + 1);
            madeWorkSortNum.append(strMaxNo);
        }
        return madeWorkSortNum.toString();
    }
    
    /**
   * [KO] 주 처리과정.<br>
   * [KO] 업무승인 관리자 추가.<br>
   * 
   * [EN] Main processing.<br>
   * [EN] .<br>
   * 
   * [JP] <br>
   * [JP] <br>
   * 
   * @param empDomain EmpDomain
   * @param request HttpServletRequest
   * @param response HttpServletResponse
   * @throws Exception Exception
   */
    @RequestMapping(value = "/aprvEmpSet", method = {RequestMethod.POST, RequestMethod.GET})
    //@ErrorBack(viewName = "forward:init.do")
    public void aprvEmpSet(@ModelAttribute("empDomain")EmpDomain empDomain, 
        HttpServletRequest request, HttpServletResponse response) throws Exception {

        /**
       * <pre>
       * 1.[KO] 업무 분류 등록 처리.<br>
       *   [KO]   입력한 내용으로 업무를 등록한다.<br>
       * 1.[EN] <br>
       *   [JP] 
       * </pre>
       */

        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObj = new JSONObject();
        //System.out.println("ajaxWorkSort/aprvEmpSet.do");

        //String empNumList = ServletRequestUtils.getStringParameter(request, "empNumList");
        String workCode = ServletRequestUtils.getStringParameter(request, "workCode");
        //System.out.println("workCode:" + workCode);
        //System.out.println("empNumList:" + empNumList);
        List<String> empList = empDomain.getEmpNumList();
        WorkSortDomain criteria = new WorkSortDomain();
        criteria.setWorkCode(workCode);

        try{
            workSortService.deleteAprvEmp(criteria);
        } catch (Exception e) {
            System.out.println("삭제할 데이터가 없습니다.");
        }
        if(empList != null){
            for(String aprvEmp: empList ) {
                if(aprvEmp != null){
                    criteria.setAprvEmpNum(aprvEmp);
                    workSortService.createSetAprvEmp(criteria);
                }
            }
        }

        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }
}
