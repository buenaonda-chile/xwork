package com.globaldenso.dnkr.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.AuthService;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.AuthDomain;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAB001EmpSearchForm;
import com.globaldenso.dnkr.presentation.form.basic.WAD001AuthCreateForm;
import com.globaldenso.dnkr.presentation.form.basic.WAD001AuthSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 권한관리 리스트 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD001AuthSearch")
@ViewId(value = "WAD001")
public class WAD001AuthSearchController {

    /** */
    private final String MENU_CODE = "3";
    
    /**
     * [KR] 권한 서비스 <br>     
     */
    @Autowired
    private AuthService authService;
    
    /**
     * [KR] 공통코드 서비스 <br>     
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD001AuthSearchController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAD001AuthSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
//    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAD001AuthSearchForm") WAD001AuthSearchForm form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String authName = ServletRequestUtils.getStringParameter(request, "authName");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        if(authName != null) {
            form.setAuthName(authName);
        }
        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        int count = 0;
        try {
            count = authService.searchCount(form);
        } catch (Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            List<AuthDomain> authList = authService.searchByConditionForPaging(form);
            mv.addObject("authList", authList);
        }
        
//        System.out.println("메뉴코드:" + menu);
//        System.out.println("권한체크" + UxisCmmUtil.getSessionAuthData(request, menu));
        
//        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("totCount", count);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAD001AuthSearch.jsp");
        mv.setViewName(".tiles.page.WAD001");
        return mv;
        
    }
    
   //before paging 
    /*@RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
//  @Token(save = true)
  public ModelAndView init(HttpServletRequest request,
      @ModelAttribute("WAD001AuthSearchForm") WAD001AuthSearchForm form)  throws Exception {
      
      ModelAndView mv = new ModelAndView();
      
      String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
      String authName = ServletRequestUtils.getStringParameter(request, "authName");
      
      AuthDomain authDomain = new AuthDomain();
      
      if(authName != null) {
        authDomain.setAuthName(authName);
      }
      authDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
      List<AuthDomain> authList = authService.searchByCondition(authDomain);
      
      mv.addObject("authList", authList);
      mv.addObject("tabId", tabId);
      mv.addObject("url", "WAD001AuthSearch.jsp");
      mv.setViewName(".tiles.page.WAD001");
      return mv;
      
  }*/
    
    /**
     * [EN] Main processing.<br>
     * [EN] I register and handle it.<br>
     * 
     * [JP] メイン処理。<br>
     * [JP] 登録処理をします。<br>
     * 
     * @param form WA0002EmpCreateForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ErrorBack(viewName = ".tiles.page.WA0002")
//    @Token(check = true, save = true)
    public ModelAndView create(@Validated WAD001AuthCreateForm form) throws Exception {
        
        /**
         * <pre>
         * 1.[EN] Employee registration processing.
         *   [EN]   I register an employee with DB by input contents.
         *   [JP] 社員登録処理
         *   [JP]  ・取得したフォームの部署番号から部署名を取得する
         *   [JP]       ・部署名が取得できなかったとき
         *   [JP]           ・存在しない部署として例外を返す。
         *   [JP]  ・取得したフォームの上司社員番号から社員情報を取得する
         *   [JP]       ・社員情報が取得できなかったとき
         *   [JP]           ・存在しない上司社員番号として例外を返す。
         *   [JP]  ・ページアクションを"create"に設定する。
         *   [JP]  ・取得したフォームに登録者と最終更新者をセットする
         *   [JP]  ・取得したフォームの内容で社員情報を登録する。
         *   [JP]  ・登録完了メッセージをMessageManagerにセットする
         *   [JP]  ・社員登録画面を表示する。
         * </pre>
         */
        
        ModelAndView mv = new ModelAndView();
        
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
        
        form.setAuthCode("new");
        authService.create(form, langList);
        
        MessageManager.setInformation("SMPL-I0-0001", new Object[] {
            MessageSources.getInstance().value("info.employee")});
        mv.setViewName("redirect:init.do");
        return mv;
        
    }
}
