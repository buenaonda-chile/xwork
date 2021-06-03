package com.globaldenso.dnkr.presentation.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.BoardService;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.BoardFileDomain;
import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.BoardTextDomain;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAC001BoardInfoSearchForm;
import com.globaldenso.dnkr.presentation.form.basic.WAC001BoardSearchForm;
import com.globaldenso.dnkr.uxis.BoardConfig;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisFileMngUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KR] 게시판 리스트 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC001BoardSearch")
@ViewId(value = "WAC001")
public class WAC001BoardSearchController {    
    /**
     * [KR] 코드관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private CodeService codeService;
    
    /**
     * [KR] 게시판 서비스 <br>     
     */
    @Autowired
    private BoardService boardService;
    
    /**
     * [KR] 개인권한 서비스 <br>     
     */
    @Autowired
    private PrivateAuthService privateAuthService;
    
    
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAC001BoardSearchController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @param request           HttpServletRequest
     * @param form              WAC001BoardSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAC001BoardSearchForm") WAC001BoardSearchForm form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String boardId = ServletRequestUtils.getStringParameter(request, "boardId");
        form.setBoardId(boardId);
        
        //회람자 아이디 셋팅
        String userId = UxisCmmUtil.getSessionData(request, "uid");
        mv.addObject("userId", userId);
        form.setCirculation_Id(userId);
        
        //회람자 팀 셋팅
        String userteamCode = UxisCmmUtil.getSessionData(request, "teamCode");
        form.setCirculation_Id_Team(userteamCode);
        
        int count = 0;
        try {
            count = boardService.boardCount(form);
        }catch (Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }
        
        //form.setCountPerPage(5);        
        //카테고리 조회
        CodeDomain langDomain = new CodeDomain();
        langDomain.setCnmLangCode(DensoContext.get().getLocale().getLanguage());
        langDomain.setCmcParentCode(DnkrConstans.CMC_BOARD_CATEGORY);
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            List<CodeDomain> categoryList = codeService.searchByCondition(langDomain);
            mv.addObject("categoryList", categoryList);
        }
        
        List<BoardTextDomain> getBoardList = boardService.searchByConditionForPaging(form);
//        List<BoardTextDomain> getNoticeList = boardService.searchByCondition(form);
        BoardInfoDomain infoDomain = new BoardInfoDomain();
        infoDomain.setBoardId(boardId);
        infoDomain = boardService.searchInfoById(infoDomain);
        
        String menuCode = "";
        if(form.getBoardId() != null && form.getBoardId().equals("BID0001")){
            menuCode = "6";
        }else if(form.getBoardId() != null && form.getBoardId().equals("BID0003")){
            menuCode = "441";
        }
        
        /*
        PrivateAuthDomain authDomain = new PrivateAuthDomain();
        authDomain.setEmpNumber(UxisCmmUtil.getSessionData(request, "uid"));
        if(form.getBoardId().equals("BID0001")){
            authDomain.setMenuCode("6");
        }else if(form.getBoardId().equals("BID0003")){
            authDomain.setMenuCode("441");
        }
        
        authDomain = privateAuthService.searchPrivateAuthDetail(authDomain);*/
        
        mv.addObject("today", UxisStringUtil.getTodayYMDString());
        mv.addObject("tabId", tabId);
        mv.addObject("paging", form);
        mv.addObject("boardId", boardId);
        mv.addObject("totCount", count);
        mv.addObject("boardList", getBoardList);
//        mv.addObject("noticeList", getNoticeList);
        mv.addObject("boardInfo", infoDomain);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menuCode));
        //mv.addObject("authDomain", privateAuthService.getPrivateAuthDetil(request, menuCode));
        mv.addObject("url", "WAC001BoardSearch.jsp");
        if(UxisUtil.isMobile(request)) {
        	Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
        	
        	mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAC001M");
        } else {
            mv.setViewName(".tiles.page.WAC001");   
        }
        return mv;
    }
    
    /**
     * [KR] <br>     
     * 
     * @param form          WAC001BoardSearchForm
     * @param request       HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:init.do")
    public ModelAndView search(@ModelAttribute("WAC001BoardSearchForm") WAC001BoardSearchForm form, HttpServletRequest request)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String boardId = ServletRequestUtils.getStringParameter(request, "boardId");
        String sv = ServletRequestUtils.getStringParameter(request, "sv");
        String sw = ServletRequestUtils.getStringParameter(request, "sw");
        String pageNo = ServletRequestUtils.getStringParameter(request, "pageNo");
        
        form.setBoardId(boardId);
        if(!"".equals(form.getSv())){
            System.out.println("search_out_test : " + form.getSv());
        }
        
        if(pageNo != null){
            form.setPageNo(Integer.parseInt(pageNo));
            form.setPages("click");
        }
        
        form.setSv(sv);
        form.setSw(sw);
        
        //회람자 아이디 셋팅
        String userId = UxisCmmUtil.getSessionData(request, "uid");
        mv.addObject("userId", userId);
        form.setCirculation_Id(userId);
        
        //회람자 팀 셋팅
        String userteamCode = UxisCmmUtil.getSessionData(request, "teamCode");
        form.setCirculation_Id_Team(userteamCode);
        
        int count = 0;
        try {
            mv.addObject("userId", userId);     
            form.setCirculation_Id(userId);
            count = boardService.boardCount(form);
        } catch (Exception e) {
            System.out.println("보여줄 데이터가 없습니다.");
        }
        
        BoardInfoDomain infoDomain = new BoardInfoDomain();
        infoDomain.setBoardId(boardId);
        infoDomain = boardService.searchInfoById(infoDomain);  

        
        //카테고리 조회
        CodeDomain langDomain = new CodeDomain();
        langDomain.setCmcParentCode(DnkrConstans.CMC_BOARD_CATEGORY);
        List<CodeDomain> categoryList = codeService.searchByCondition(langDomain);
        mv.addObject("categoryList", categoryList);
        
        if(count > 0){
            PagingUtility.calcPaging(form, count);

            List<BoardTextDomain> getBoardList = boardService.searchByConditionForPaging(form);
            mv.addObject("totCount", count);
            mv.addObject("boardList", getBoardList);
//            List<BoardTextDomain> getNoticeList = boardService.searchByCondition(form);
//            int noticeCount = boardService.noticeCount(form);
//            mv.addObject("noticeCount", noticeCount);
//            mv.addObject("noticeList", getNoticeList);
        }
        
        String menuCode = "";
        if(form.getBoardId().equals("BID0001")){
            menuCode = "6";
        }else if(form.getBoardId().equals("BID0003")){
            menuCode = "441";
        }
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menuCode));
        mv.addObject("today", UxisStringUtil.getTodayYMDString());
        mv.addObject("tabId", tabId);
        mv.addObject("boardId", boardId);
        mv.addObject("boardInfo", infoDomain);
        mv.addObject("paging", form);
        mv.addObject("url", "WAC001BoardSearch.jsp");
        if(UxisUtil.isMobile(request)) {
        	Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
        	
        	mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAC001M");
        } else {
            mv.setViewName(".tiles.page.WAC001");   
        }
        return mv;
        
    }
    
    /**
     * [EN] Main processing<br>
     * [EN] Delete from the DB the information displayed on the screen.<br>
     * [JP] 社員削除処理<br>
     * [JP] 画面上で選択された社員情報をDBから削除します。<br>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/chkDelete", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:init.do")
    public ModelAndView chkDelete(HttpServletRequest request) throws 
            Exception {
        
        /**
         * <pre>
         * 1.[EN] Employee deleate processing.
         *   [EN]   I delete the employee information chosen on a screen from DB.
         *   [JP] 社員削除処理
         *   [JP]  ・フォームから削除対象の社員番号を取得する。
         *   [JP]  ・取得した社員番号がNULLの時はエラーとして抜ける。
         *   [JP]  ・社員番号を","で分割する。
         *   [JP]  ・分割した社員番号の数だけEmpDomainを作成し、リストにセットします。
         *   [JP]  ・社員削除処理するサービスを実行する。
         *   [JP]  ・削除完了メッセージと削除件数をMessageManagerにセットする。
         *   [JP]  ・社員検索画面を表示する。
         * </pre>
         */
        
        //System.out.println("WAC001BoardSearch/chkDelete.do");
        ModelAndView mv = new ModelAndView();

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String boardId = ServletRequestUtils.getStringParameter(request, "boardId");
        String chkIdx = ServletRequestUtils.getStringParameter(request, "chkIdx");

        String[] idxArr = chkIdx.split(",");

        BoardTextDomain domain = new BoardTextDomain();
        domain.setBoardId(boardId);
        domain.setIdxArr(idxArr);

        try{
            int result = boardService.chkDelete(domain);
            if(result > 0){
                for(int i = 0 ; i < idxArr.length ; i++){
                    BoardFileDomain fileDomain = new BoardFileDomain();
                    fileDomain.setBoardId(boardId);
                    fileDomain.setIdx(idxArr[i]);
                    boardService.fileDelete(fileDomain);
                }
            }
        }catch (Exception e){
            System.out.println("게시판 삭제시 문제가 생겼습니다. " + e.getMessage());
        }
        mv.addObject("tabId", tabId);
        mv.addObject("boardId", boardId);
        mv.setViewName("redirect:init.do");
        return mv;
    }
    
    /**
     * [KR] <br>     
     * 
     * @param request           HttpServletRequest
     * @param form              WAC001BoardInfoSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/infoInit", method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView infoInit(HttpServletRequest request, 
        @ModelAttribute("WAC001BoardInfoSearchForm") WAC001BoardInfoSearchForm form)  throws Exception {
        
        //System.out.println("/WAC001BoardSearch/infoInit.do");
        ModelAndView mv = new ModelAndView(); 
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        //form.setB(DensoContext.get().getLocale().getLanguage());
        int count = boardService.searchInfoCount(form); 
        
        // paging process
        PagingUtility.calcPaging(form, count);
        
        List<BoardInfoDomain> infoList = boardService.searchByInfoConditionForPaging(form);

        BoardConfig boardConfig = new BoardConfig();
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, "401"));
        mv.addObject("totCount", count);
        mv.addObject("infoList", infoList);
        mv.addObject("boardAuth", boardConfig.get_boardAuth());
        mv.addObject("boardType", boardConfig.get_boardType());
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAC001BoardInfoSearch.jsp");
        mv.setViewName(".tiles.page.WAC011");
        return mv;
        
    }
    
    /**
     * [KR] <br>     
     * 
     * @param form              WAC001BoardInfoSearchForm
     * @param request           HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/infoSearch", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:infoInit.do")
    public ModelAndView infoSearch(@ModelAttribute("WAC001BoardInfoSearchForm") WAC001BoardInfoSearchForm form, 
        HttpServletRequest request)  throws Exception {
        
        //System.out.println("WAC001BoardSearch/infoSearch.do");
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        int count = 0;
        try {
            count = boardService.searchInfoCount(form); 
        } catch (Exception e) {
            System.out.println("보여줄 데이터가 없습니다.");
        }
        
        if(count > 0){
            PagingUtility.calcPaging(form, count);
            List<BoardInfoDomain> infoList = boardService.searchByInfoConditionForPaging(form);
            mv.addObject("totCount", count);
            mv.addObject("infoList", infoList);
        }
        BoardConfig boardConfig = new BoardConfig();
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, "401"));
        mv.addObject("boardType", boardConfig.get_boardType());
        mv.addObject("tabId", tabId);
        mv.addObject("boardAuth", boardConfig.get_boardAuth());
        mv.addObject("url", "WAC001BoardInfoSearch.jsp");
        mv.setViewName(".tiles.page.WAC011");
        return mv;
        
    }
    
    /**
     * [EN] Main processing<br>
     * [EN] Delete from the DB the information displayed on the screen.<br>
     * [JP] 社員削除処理<br>
     * [JP] 画面上で選択された社員情報をDBから削除します。<br>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/infoDelete", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:infoInit.do")
    public ModelAndView infoDelete(HttpServletRequest request) throws 
            Exception {
        
        /**
         * <pre>
         * 1.[EN] Employee deleate processing.
         *   [EN]   I delete the employee information chosen on a screen from DB.
         *   [JP] 社員削除処理
         *   [JP]  ・フォームから削除対象の社員番号を取得する。
         *   [JP]  ・取得した社員番号がNULLの時はエラーとして抜ける。
         *   [JP]  ・社員番号を","で分割する。
         *   [JP]  ・分割した社員番号の数だけEmpDomainを作成し、リストにセットします。
         *   [JP]  ・社員削除処理するサービスを実行する。
         *   [JP]  ・削除完了メッセージと削除件数をMessageManagerにセットする。
         *   [JP]  ・社員検索画面を表示する。
         * </pre>
         */
        
        //System.out.println("WAC001BoardSearch/infoDelete.do");
        ModelAndView mv = new ModelAndView();

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String boardId = ServletRequestUtils.getStringParameter(request, "boardId");

        WAC001BoardSearchForm domain = new WAC001BoardSearchForm();
        domain.setBoardId(boardId);
        int count = 0;
        try{
            
            count = boardService.boardCount(domain);
            //게시글이 존재할경우
            if(count > 0){
                MessageManager.setMessagelessFieldError("WAC001BoardInfoSearchForm", "boardId", boardId);
                throw new ApplicationException("DNKR-E1-0003");
            }else if(count == 0) {
                BoardInfoDomain infoDomain = new BoardInfoDomain();
                infoDomain.setBoardId(boardId);
                boardService.infoDelete(infoDomain);
                //System.out.println("del result : " + result);
            }
        }catch (Exception e){
            System.out.println("게시판 삭제시 문제가 생겼습니다. " + e.getMessage());
        }

        mv.addObject("tabId", tabId);
        mv.setViewName("redirect:infoInit.do");
        return mv;
    }
    
    /**
     * 
     * @param fileDomain        BoardFileDomain
     * @param response          HttpServletResponse
     * @param request           HttpServletRequest
     * @throws Exception 
     */
    @RequestMapping(value = "/downFile", method = {RequestMethod.GET, RequestMethod.POST})
    public void downFileBoard(BoardFileDomain fileDomain, HttpServletResponse response, 
        HttpServletRequest request) throws Exception {

        String rootPath = UxisCmmUtil.getProperty("system.uploadpath");
        fileDomain = boardService.searchFileById(fileDomain);
        boardService.downCntUpdate(fileDomain);
        /** 파일 다운로드 처리 */
        try{
            UxisFileMngUtil mngUtil = new UxisFileMngUtil(); 

            mngUtil.downLoadProcess(response, request, rootPath + fileDomain.getSaveDir().toString(), fileDomain.getSaveName().toString(), 
                fileDomain.getRealName().toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
