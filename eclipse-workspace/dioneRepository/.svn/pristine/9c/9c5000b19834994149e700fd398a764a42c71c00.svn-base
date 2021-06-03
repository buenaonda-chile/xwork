package com.globaldenso.dnkr.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.core.util.Strings;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 공통코드 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls of common code (WAC015).<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC015Code")
@ViewId(value = "WAC015")
public class WAC015CodeController {

    /**
     * [KR] 코드관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private CodeService codeService;
    
    /** */
    private final String MENU_CODE = "8";

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAC015CodeController() {
        // no process
    }
    
    
    /**
     * [KO] 공통코드 조회화면 초기화.<br>
     * [EN] Common code search initial display.<br>
     * [JP] <br>
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAC015")
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request)  throws Exception {
        
        /**
         * <pre>
         * 1.[EN] Screen initialization processing.
         *   [EN]    I acquire Common code information and display it to a screen  
         *   [JP] 
         * </pre>
         */

        ModelAndView mv = new ModelAndView(); 
        
        CodeDomain criteria = new CodeDomain();

        criteria.setCnmLangCode(DensoContext.get().getLocale().getLanguage());
        String cmcType = ServletRequestUtils.getStringParameter(request, "cmcType");
        String cmcCode = ServletRequestUtils.getStringParameter(request, "cmcCode");
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        if (cmcType == null) {
            cmcType = "MAIN";
        }
        if (cmcType.equals("MAIN")) {
            criteria.setCmcType(cmcType);
        }else if (cmcType.equals("SUB")) {
            criteria.setCmcParentCode(cmcCode);
        }

        List<CodeDomain> cmcList = codeService.searchByCondition(criteria);
        if (cmcList.isEmpty()){
            MessageManager.setError("SMPL-E8-0003", new Object[] {
                MessageSources.getInstance().value("info.code")});
        }
        mv.addObject("cmcList", cmcList);
        mv.addObject("tabId", tabId);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("url", "WAC015Code.jsp");
        mv.setViewName(".tiles.page.WAC015");
        return mv;
        
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
     * @param response  HttpServletResponse
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
//    @ErrorBack(viewName = "forward: init.do")
    @ErrorBack(viewName = ".tiles.page.WAC015")
    public ModelAndView create(HttpServletRequest request, HttpServletResponse response) 
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

        ModelAndView mv = new ModelAndView();

        String reqCode = ServletRequestUtils.getStringParameter(request, "cmcCode");
        String cmcType = ServletRequestUtils.getStringParameter(request, "cmcType");
        String cnmName = ServletRequestUtils.getStringParameter(request, "cnmName");
        
        CodeDomain criteria = new CodeDomain();
        String madeCode = "";
        
        if (reqCode == null || Strings.judgeBlank(reqCode)) {
            //max code 만들기
            String maxCmcCode = codeService.searchMaxCommonCode(criteria);
            madeCode = makeCmcCode(maxCmcCode);
        } else {
            //생성하는 코드가 존재하는지 체크
            criteria.setCmcCode(reqCode);
            if (codeService.searchByKey(criteria) != null) {
                MessageManager.setError("SMPL-E8-0004", new Object[] {
                        MessageSources.getInstance().value("info.code")});
                throw new ApplicationException("SMPL-E7-0005");
            }
            madeCode = reqCode;
        }
        
        //언어조회
        CodeDomain langDomain = new CodeDomain();
        langDomain.setCmcParentCode(DnkrConstans.CMC_SUPER_LANG_CODE);
        List<CodeDomain> domainList = codeService.searchByCondition(langDomain);
        List<String> langList = new ArrayList<String>();
        if(! domainList.isEmpty()) {
            for(CodeDomain domain: domainList) {
                langList.add(domain.getCmcCode());
            }
        }
        
        CodeDomain createTarget = new CodeDomain();
        createTarget.setCmcCode(madeCode);
        createTarget.setCnmName(cnmName);
        if (cmcType.equals("MAIN")) {
            codeService.create(createTarget, langList);
        } else if (cmcType.equals("SUB")) {
            String cmcParentCode = ServletRequestUtils.getStringParameter(request, "cmcParentCode");
            String cnmDescription = ServletRequestUtils.getStringParameter(request, "cnmDescription");
            createTarget.setCmcType(cmcType);
            createTarget.setCmcParentCode(cmcParentCode);
            createTarget.setCnmDescription(cnmDescription);
            codeService.create(createTarget, langList);
        }
        mv.setViewName("redirect:init.do");
        return mv;   
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
     * @param response  HttpServletResponse
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAC015")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) 
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

        ModelAndView mv = new ModelAndView();

        String cmcCode = ServletRequestUtils.getStringParameter(request, "cmcCode");
        String cnmName = ServletRequestUtils.getStringParameter(request, "cnmName");
        String cnmDescription = ServletRequestUtils.getStringParameter(request, "cnmDescription");
        String cnmLangCode = ServletRequestUtils.getStringParameter(request, "cnmLangCode");
        
        CodeDomain updateTarget = new CodeDomain();
        updateTarget.setCmcCode(cmcCode);
        updateTarget.setCnmName(cnmName);
        updateTarget.setCnmDescription(cnmDescription);
        updateTarget.setCnmLangCode(cnmLangCode);
        
        codeService.update(updateTarget);
        
        mv.setViewName("redirect:init.do");
        return mv; 
    }
    
    /**
     * [KO] 공통코드 생성.<br>
     * 
     * [EN] .<br>
     * 
     * [JP] <br>
     * [JP] <br>
     * 
     * @param maxCmcCode    String
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
