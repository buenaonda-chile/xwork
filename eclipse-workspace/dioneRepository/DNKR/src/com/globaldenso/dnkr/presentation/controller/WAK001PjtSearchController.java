package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.PjtService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.domain.PjtDomain;
import com.globaldenso.dnkr.domain.WorkSortDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAK001PjtCreateForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 프로젝트 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls of project (WAK001).<br>
 * [JP] <br>
 * 
 * @author UXIS
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAK001PjtSearch")
@ViewId(value = "WAK001")
public class WAK001PjtSearchController {

    /**
     * [KR] 프로젝트관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private PjtService pjtService;
    
    /**
     * [KR] 코드관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private WorkSortService workSortService;
    
    /** */
    private final String MENU_CODE = "261";


    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAK001PjtSearchController() {
        // no process
    }
    
    /**
     * 
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK001")
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request) throws Exception {

        /**
         * <pre>
         * 1.[EN] Screen initialization processing.
         *   [EN]    I acquire Common code information and display it to a screen  
         *   [JP] 
         * </pre>
         */

        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String searchDate = ServletRequestUtils.getStringParameter(request, "searchDate");
        
        String logEmpNum = (String)request.getSession().getAttribute("logEmpNum");

        WorkSortDomain workLDomain = new WorkSortDomain(); 
        workLDomain.setUseYn("Y");
        workLDomain.setWorkLv(1);
        List<WorkSortDomain> workLList = workSortService.searchByCondition(workLDomain);

        WorkSortDomain workMDomain = new WorkSortDomain();
        workMDomain.setWorkLv(2);
        List<WorkSortDomain> workMList = workSortService.searchByCondition(workMDomain);

        WorkSortDomain workSDomain = new WorkSortDomain();
        workSDomain.setWorkLv(3);
        List<WorkSortDomain> workSList = workSortService.searchByCondition(workSDomain);

        PjtDomain pjtDomain = new PjtDomain();
        SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String today = datafmt.format(calendar.getTime());
        if(searchDate != null){
            pjtDomain.setWorkDate(searchDate);
            mv.addObject("searchDate", searchDate);
        } else {
            pjtDomain.setWorkDate(today);
            mv.addObject("searchDate", today);
        }

        pjtDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        pjtDomain.setEmpNumber(logEmpNum);
        List<PjtDomain> pjtList = pjtService.searchByCondition(pjtDomain);

//      System.out.println("메뉴코드:" + menu);
//      System.out.println("권한체크" + UxisCmmUtil.getSessionAuthData(request, menu));
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("workLList", workLList);
        mv.addObject("workMList", workMList);
        mv.addObject("workSList", workSList);
        mv.addObject("pjtList", pjtList);
        mv.addObject("url", "WAK001Pjt.jsp");
        mv.setViewName(".tiles.page.WAK001");
        return mv;
        
    }
    
    /**
     * [EN] Main processing.<br>
     * [EN] I register and handle it.<br>
     * 
     * [JP] メイン処理。<br>
     * [JP] 登録処理をします。<br>
     * 
     * @param form WA0002EmpCreateForm
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ErrorBack(viewName = "forward:init.do")
//    @Token(check = true, save = true)
    public ModelAndView create(@Validated WAK001PjtCreateForm form, HttpServletRequest request) throws Exception {
        
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
        //System.out.println("WAK001PjtSearch/create.do");
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj = parser.parse(empInfo);
        JSONObject empJsonObj = (JSONObject)empInfoObj;
        String empNumber = (String)empJsonObj.get("uid");

        //System.out.println("WAK001PjtSearch/create.do");
        PjtDomain criteria = new PjtDomain();
        int maxPjtNum = 0;
        try {
            maxPjtNum = pjtService.searchMaxPjtNum(criteria);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        form.setEmpNumber(empNumber);
        form.setPjtNum(maxPjtNum + 1);
        pjtService.create(form);
        
        MessageManager.setInformation("SMPL-I0-0001", new Object[] {
            MessageSources.getInstance().value("info.employee")});
        mv.setViewName("redirect:init.do");
        return mv;
        
    }
}
