package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.PjtService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDomain;
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
@RequestMapping(value = "/WAK000PjtSearch")
@ViewId(value = "WAK000")
public class WAK000PjtSearchController {

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;

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
    private final String MENU_CODE = "503";


    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAK000PjtSearchController() {
        // no process
    }

    /**
     *
     * 
     * @param form      WAK001PjtCreateForm
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK000")
    @Token(save = true)
    public ModelAndView init(WAK001PjtCreateForm form, HttpServletRequest request) throws Exception {

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
        
      //로그인한 사용자 정보조회
        String logEmpNum = (String)request.getSession().getAttribute("logEmpNum");
        String teamCode = (String)request.getSession().getAttribute("teamCode");

        //프로젝트 등록일자에 오늘날짜 셋팅
        if(form.getWorkDate() == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            form.setWorkDate(today);
        }
        
        WorkSortDomain workLDomain = new WorkSortDomain(); 
        workLDomain.setUseYn("Y");
        workLDomain.setWorkLv(1);
        workLDomain.setTeamCode(teamCode);
        List<WorkSortDomain> workLList = workSortService.searchByCondition(workLDomain);

        WorkSortDomain workMDomain = new WorkSortDomain();
        workMDomain.setWorkLv(2);
        workMDomain.setTeamCode(teamCode);
        List<WorkSortDomain> workMList = workSortService.searchByCondition(workMDomain);

        WorkSortDomain workSDomain = new WorkSortDomain();
        workSDomain.setWorkLv(3);
        workSDomain.setTeamCode(teamCode);
        List<WorkSortDomain> workSList = workSortService.searchByCondition(workSDomain);

        //같은팀의 프로젝트 관련시스템 리스트 가져오기
        PjtDomain relDomain = new PjtDomain();
        EmpDomain empDomain = new EmpDomain();
        List<String> relSysList = null;
        if(teamCode != null) {
            empDomain.setTeamCode(teamCode);
            List<EmpDomain> empList = empService.searchByCondition(empDomain);
            List<String> empNumList = new ArrayList<String>();
            if(empList != null) {
                for(EmpDomain emp :empList) {
                    empNumList.add(emp.getEmpNumber());
                }
            }
            relDomain.setEmpNumList(empNumList);
            relSysList = pjtService.relSysList(relDomain);
        } else if(teamCode == null && logEmpNum.equals(DnkrConstans.SYSTEM_MANAGER)) {
            relSysList = pjtService.relSysList(relDomain);
        }

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
        
        mv.addObject("insertDomain", form);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("workLList", workLList);
        mv.addObject("workMList", workMList);
        mv.addObject("workSList", workSList);
        mv.addObject("relSysList", relSysList);
        mv.addObject("pjtList", pjtList);
        mv.addObject("url", "WAK001Pjt.jsp");
        mv.setViewName(".tiles.page.WAK000");
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
    @Token(check = false, save = true)
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
        String empNumber = (String)request.getSession().getAttribute("logEmpNum");

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
        mv.addObject("insertDomain", form);
        mv.setViewName("forward:init.do");
        return mv;
        
    }
}
