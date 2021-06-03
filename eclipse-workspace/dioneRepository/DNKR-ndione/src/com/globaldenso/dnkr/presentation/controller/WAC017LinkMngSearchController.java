package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.LinkService;
import com.globaldenso.dnkr.domain.LinkDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAC017LinkManagementForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 링크관리  컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC017LinkManagement")
@ViewId(value = "WAC017")
public class WAC017LinkMngSearchController {

    /** */
    private final String MENU_CODE = "681";
    
    /**
     * [KR] 링크 서비스 <br>     
     */
    @Autowired
    private LinkService linkService;
    

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAC017LinkMngSearchController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAC017LinkManagementForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAC017LinkManagementForm") WAC017LinkManagementForm form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
             
        int count = 0;
        try {
            count = linkService.searchCountLink(form);
        } catch (Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            List<LinkDomain> linkList = linkService.searchByConditionForPagingLink(form);
            mv.addObject("linkList", linkList);
        }

        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("totCount", count);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAC017LinkManagement.jsp");
        mv.setViewName(".tiles.page.WAC017");
        return mv;
        
    }
  
   
    /**
     * [EN] Main processing.<br>
     * [EN] I register and handle it.<br>
     * 
     * [JP] メイン処理。<br>
     * [JP] 登録処理をします。<br>
     * 
     * @param form WAC017LinkManagementForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ErrorBack(viewName = ".tiles.page.WAC017")
    @Token(check = false, save = true)
    public ModelAndView create(
    		HttpServletRequest request,
    		 @ModelAttribute("WAC017LinkManagementForm") @Validated WAC017LinkManagementForm form) throws Exception {
         // Add main processin
        	
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
        
        //세션 저장된 데이터 불러오기
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
        String empNumber        = (String)empJsonObj.get("uid");        //사용자 사번
        String empId        = (String)empJsonObj.get("empId");        //사용자 ID
        
        form.setCreateUser(empId);
    	int count = 0;
    	/*
    		LinkDomain domain = new LinkDomain();
    		domain.setSeq(form.getSeq());
        try {
    		count = linkService.searchCount(form);
    	}catch (ApplicationException e) {
            count = 0;
            e.printStackTrace();
        } 
         */
    	if (count == 0){
    		linkService.createLink(form);
            MessageManager.setInformation("SMPL-I0-0001", new Object[] { "employee Infomation."});
            
        }else{
            MessageManager.setError("SMPL-E8-0004", new Object[] { ""});            
        }
    	
        ModelAndView mv = new ModelAndView();
        //mv.setViewName("redirect:init.do");

        if (count == 0){
    		int count2 = 0;
            try {
            	count2 = linkService.searchCountLink(form);
            } catch (Exception e) {
                System.out.println("조회할 데이터가 없습니다.");
            }
            if(count2 > 0) {
                // paging process
                PagingUtility.calcPaging(form, count2);
                List<LinkDomain> linkList = linkService.searchByConditionForPagingLink(form);
                mv.addObject("linkList", linkList);
            } 
        }  	
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("totCount", count);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAC017LinkManagement.jsp");
        mv.setViewName(".tiles.page.WAC017");
  
        return mv;
    }

}
