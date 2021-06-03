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

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.core.util.Strings;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CodeDomain;

/**
 * [KO] 공통코드의  ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing of common code (WAC015).<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxCode")
public class AjaxCodeController {

    /**
     * [KR] 코드관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private CodeService codeService;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxCodeController() {
        // no process
    }
    
    
    /**
     * [KO] 공통코드 조회.<br>
     * [EN] Common code select.<br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void init(HttpServletRequest request, HttpServletResponse response) throws Exception{

        /**
         * [KO] 공통코드 조회.<br>
         * [EN] Common code select.<br>
         * [JP] <br>
         * 
         * @return ModelAndView
         * @throws Exception Exception
         */

        JSONObject jsonObj = new JSONObject();

        String cmcType = ServletRequestUtils.getStringParameter(request, "cmcType");
        String cmcCode = ServletRequestUtils.getStringParameter(request, "cmcCode");
        
        CodeDomain criteria = new CodeDomain();

        if (cmcType == null) {
            cmcType = "MAIN";
        }

        if (cmcType.equals("MAIN")) {
            criteria.setCmcType(cmcType);
        } else if (cmcType.equals("SUB")) {
            criteria.setCmcParentCode(cmcCode);
        }
        criteria.setCnmLangCode(DensoContext.get().getLocale().getLanguage());

        List<CodeDomain> commonCodelist = codeService.searchByCondition(criteria);

        if(criteria != null) {
            jsonObj.put("list", commonCodelist);    
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

   /**
     * [KO] 공통코드 조회.<br>
     * [EN] Common code select.<br>
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
         * [KO] 공통코드 검색.<br>
         * [EN] Common code select.<br>
         * [JP] <br>
         * 
         * @return ModelAndView
         * @throws Exception Exception
         */

        JSONObject jsonObj = new JSONObject();

        String cmcType = ServletRequestUtils.getStringParameter(request, "cmcType");
        //String cmcCode = ServletRequestUtils.getStringParameter(request, "cmcCode");
        String cnmName = ServletRequestUtils.getStringParameter(request, "cnmName");

        //System.out.println(cmcType);
        //System.out.println(cnmName);

        CodeDomain criteria = new CodeDomain();

        if (cmcType == null) {
            cmcType = "MAIN";
        }

//      if (cmcType.equals("MAIN")) {
        criteria.setCmcType(cmcType);
//      } else if (cmcType.equals("SUB")) {
//          criteria.setCmcParentCode(cmcCode);
//      }
        criteria.setCnmName(cnmName);
        criteria.setCnmLangCode(DensoContext.get().getLocale().getLanguage());

        List<CodeDomain> commonCodelist = codeService.searchByCondition(criteria);

        if(criteria != null) {
            jsonObj.put("list", commonCodelist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * [KO] 공통코드 삭제.<br>
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
    @ErrorBack(viewName = "forward:/WAC015Code/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /**
         * <pre>
         * 1.[KO] 공통코드 삭제 처리
         *   [KO]   화면에서 선택된 공통코드를 DB에서 삭제합니다.
         * 1.[EN] Common code deleate processing.
         *   [EN]   I delete the Common code information chosen on a screen from DB.
         *   [JP]
         * </pre>
         */

        //System.out.println("delete start");
        JSONObject jsonObj = new JSONObject();
        String delCmcCode = ServletRequestUtils.getStringParameter(request, "cmcCode");
        String delCmcType = ServletRequestUtils.getStringParameter(request, "cmcType");
        CodeDomain criteria = new CodeDomain();
        response.setContentType("text/html;charset=utf-8");
        if (delCmcCode.equals(DnkrConstans.CMC_SUPER_LANG_CODE)) {
            jsonObj.put("errMsg", "언어 대분류는 삭제하실 수 없습니다.");
            response.getWriter().print(jsonObj);
            return;
        }

        if(delCmcType.equals("MAIN")){
            //공통코드 타입이 메인이면 하위코드가 존재하는지 체크
            criteria.setCmcParentCode(delCmcCode);
            int subCodeCount = codeService.searchCmcCount(criteria);
            if(subCodeCount > 0) {
                jsonObj.put("errMsg", "하위코드가 존재합니다.");
                response.getWriter().print(jsonObj);
                return;
            }
        }

        CodeDomain delCmcDomain = new CodeDomain();
        delCmcDomain.setCmcCode(delCmcCode);
        int count = codeService.delete(delCmcDomain);
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        MessageManager.setInformation("SMPL-I0-0002", new Object[] {
                MessageSources.getInstance().value("info.code"), 
                String.valueOf(count)});
    
        response.getWriter().print(jsonObj);
        return;
    }

    /**
     * [KO] 주 처리과정.<br>
     * [KO] 공통코드 추가.<br>
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
//    @ErrorBack(viewName = "forward: init.do")
//    @ErrorBack(viewName = ".tiles.page.WAC015")
    public void create(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        /**
         * <pre>
         * 1.[KO] 공통코드 등록 처리.
         *   [KO]   입력한 내용으로 공통코드를 등록한다.
         * 1.[EN] Common code registration processing.
         *   [EN]   I register an common code with DB by input contents.
         *   [JP] 
         *   [JP] 
         * </pre>
         */
        JSONObject jsonObj = new JSONObject();
        //System.out.println("ajax/create.do");

        String reqCode = ServletRequestUtils.getStringParameter(request, "cmcCode");
        String cmcType = ServletRequestUtils.getStringParameter(request, "cmcType");
        String cnmName = ServletRequestUtils.getStringParameter(request, "cnmName");
        
        //System.out.println("reqCode:" + reqCode);
        //System.out.println("cmcType:" + cmcType);
        //System.out.println("cnmName:" + cnmName);
        
        CodeDomain criteria = new CodeDomain();
        response.setContentType("text/html;charset=utf-8");
        String madeCode = "";
        if (reqCode == null || Strings.judgeBlank(reqCode)) {
            //max code 만들기
            String maxCmcCode = codeService.searchMaxCommonCode(criteria);
            //System.out.println("maxCmcCode:" + maxCmcCode);
            madeCode = makeCmcCode(maxCmcCode);
            jsonObj.put("cmcCode", madeCode);
        } else {
            //생성하는 코드가 존재하는지 체크
            //System.out.println("생성하는 코드가 존재하는지 체크");
            criteria.setCmcCode(reqCode);
            if (codeService.searchByKey(criteria) != null) {
                jsonObj.put("errMsg", "생성코드가 존재합니다.");
                response.getWriter().print(jsonObj);
                return;
            }
            madeCode = reqCode;
        }
        
        //언어조회
        //System.out.println("언어조회");
        //System.out.println("setCmcParentCode:");
        CodeDomain langDomain = new CodeDomain();
        langDomain.setCmcParentCode(DnkrConstans.CMC_SUPER_LANG_CODE);
        //System.out.println("setCmcParentCode:");
        List<CodeDomain> domainList = codeService.searchByCondition(langDomain);
        List<String> langList = new ArrayList<String>();
        //System.out.println("beforeisEmpty:");
        if(! domainList.isEmpty()) {
            for(CodeDomain domain: domainList) {
                langList.add(domain.getCmcCode());
            }
        }
        
        //System.out.println("madeCode:" + madeCode);
        CodeDomain createTarget = new CodeDomain();
        createTarget.setCmcCode(madeCode);
        createTarget.setCnmName(cnmName);
        if (cmcType.equals("MAIN")) {
            codeService.create(createTarget, langList);
        } else if (cmcType.equals("SUB")) {
            String cmcParentCode = ServletRequestUtils.getStringParameter(request, "cmcParentCode");
            String cnmDescription = ServletRequestUtils.getStringParameter(request, "cnmDescription");
            if(cmcParentCode == null || Strings.judgeBlank(cmcParentCode)){
                jsonObj.put("errMsg", "상위코드를 선택해주세요");
                response.getWriter().print(jsonObj);
                return;
            }

            //상위코드가 존재하는지 체크
            CodeDomain parentDomain = new CodeDomain();
            parentDomain.setCmcCode(cmcParentCode);
            CodeDomain checkDomain = codeService.searchByKey(parentDomain);
            if(checkDomain == null){
                jsonObj.put("errMsg", "존재하지 않는 상위코드입니다.");
                response.getWriter().print(jsonObj);
                return;
            }

            createTarget.setCmcType(cmcType);
            createTarget.setCmcParentCode(cmcParentCode);
            createTarget.setCnmDescription(cnmDescription);
            codeService.create(createTarget, langList);
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
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

        String cmcCode = ServletRequestUtils.getStringParameter(request, "cmcCode");
        String cnmName = ServletRequestUtils.getStringParameter(request, "cnmName");
        String cmcUseYn = ServletRequestUtils.getStringParameter(request, "cmcUseYn");
        String cnmDescription = ServletRequestUtils.getStringParameter(request, "cnmDescription");
        String cnmLangCode = ServletRequestUtils.getStringParameter(request, "cnmLangCode");
        
        CodeDomain updateTarget = new CodeDomain();
        updateTarget.setCmcCode(cmcCode);
        
        //생성하는 코드가 존재하는지 체크
        if (codeService.searchByKey(updateTarget) == null) {
            jsonObj.put("errMsg", "잘못된 접근입니다.");
            response.getWriter().print(jsonObj);
            return;
        }
        
        updateTarget.setCmcCode(cmcCode);
        updateTarget.setCnmName(cnmName);
        updateTarget.setCmcUseYN(cmcUseYn);
        updateTarget.setCnmDescription(cnmDescription);
        updateTarget.setCnmLangCode(DensoContext.get().getLocale().getLanguage());
        
        codeService.update(updateTarget);
        
        jsonObj.put("result", DnkrConstans.RESULT_OK);
        response.getWriter().print(jsonObj);
        return;
    }

    /**
     * [KO] 공통코드 생성.<br>
     * 
     * [EN] .<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param maxCmcCode String 
     * @return String Common code
     */
    private String makeCmcCode (String maxCmcCode) {
        int strLength = maxCmcCode.length();
        int maxNo = Integer.parseInt(maxCmcCode.substring(4, strLength));
        String strMaxNo = String.format("%05d", maxNo + 1);

        StringBuffer madeCmcCode = new StringBuffer();
        madeCmcCode.append("CMCM");
        madeCmcCode.append(strMaxNo);
        
        return madeCmcCode.toString();
    }
}
