package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.BoardService;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.BoardFileDomain;
import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.BoardTextDomain;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAB001EmpSearchForm;
import com.globaldenso.dnkr.presentation.form.basic.WAC004BoardCreateForm;
import com.globaldenso.dnkr.presentation.form.basic.WAC004BoardInfoCreateForm;
import com.globaldenso.dnkr.uxis.BoardConfig;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 게시판 수정 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC003BoardUpdate")
@ViewId(value = "WAC003")
public class WAC003BoardUpdateController {
    
    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private WorkSortService workSortService;
    
    /**
     * [KR] 게시판 서비스 <br>     
     */
    @Autowired
    private BoardService boardService;

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
    public WAC003BoardUpdateController() {
        // no process
    }
    
    /**
     * [KR] <br>     
     * 
     * @param form                      WAC004BoardCreateForm
     * @param request                   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(@ModelAttribute("WAC004BoardCreateForm") WAC004BoardCreateForm form, HttpServletRequest request)  throws Exception {
        
        ModelAndView mv = new ModelAndView();   
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String boardId = ServletRequestUtils.getStringParameter(request, "boardId");
        String idx = ServletRequestUtils.getStringParameter(request, "idx");
        
        BoardTextDomain domain = new BoardTextDomain();
        domain.setBoardId(boardId);
        domain.setIdx(idx);
        
        BoardTextDomain getDomain = boardService.searchById(domain);
        
        WAB001EmpSearchForm form_empDomain = new WAB001EmpSearchForm();
        
        form_empDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());      
        List<EmpDomain> empList = empService.searchByCondition(form_empDomain);
        
        String[] circulation;
        if(getDomain.getCirculation_Id() != null){
            circulation = getDomain.getCirculation_Id().split(","); //한사람 한사람 자름.
        }else{
            circulation = null;
        }
        mv.addObject("circulation", circulation);
        
        String[] circulation_Team;
        if(getDomain.getCirculation_Id_Team() != null){
            circulation_Team = getDomain.getCirculation_Id_Team().split(","); //한사람 한사람 자름.
        }else{
            circulation_Team = null;
        }
        mv.addObject("circulation_Team", circulation_Team);
        
        //circulation[0] => 1 circulation[1] => 2
        //circulation[0][0] => 1의 name
//        String[] circulation_info = null;
//        for(int i = 0; i < circulation.length; i++){
//        circulation_info = circulation[i].split("/");
//          System.out.println("testtest : "+circulation_info[0]);
//        }
//        System.out.println("testtest : "+circulation_info.length);
        
        //카테고리 조회
        CodeDomain langDomain = new CodeDomain();
        langDomain.setCnmLangCode(DensoContext.get().getLocale().getLanguage());
        langDomain.setCmcParentCode(DnkrConstans.CMC_BOARD_CATEGORY);
        List<CodeDomain> categoryList = codeService.searchByCondition(langDomain);
        mv.addObject("categoryList", categoryList);
        
        BoardInfoDomain infoDomain = new BoardInfoDomain();
        infoDomain.setBoardId(boardId);
        infoDomain = boardService.searchInfoById(infoDomain);
        
        BoardFileDomain fileDomain = new BoardFileDomain();
        fileDomain.setBoardId(getDomain.getBoardId());
        fileDomain.setIdx(getDomain.getIdx());
        List<BoardFileDomain> fileList = boardService.searchFileList(fileDomain);
        
        /*세션에 저장된 아이디 받아오기 */
        String userId = UxisCmmUtil.getSessionData(request, "uid");
        
        //사용자 권한 받아오기
        String menuCode = "";
        if(form.getBoardId().equals("BID0001")){
            menuCode = "6";
        }else if(form.getBoardId().equals("BID0003")){
            menuCode = "441";
        }
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menuCode));
        
        mv.addObject("tabId", tabId);
        mv.addObject("userId", userId);
        mv.addObject("boardTextDomain", getDomain);
        mv.addObject("infoDomain", infoDomain);
        mv.addObject("fileList", fileList);
        mv.addObject("url", "WAC003BoardUpdate.jsp");
       // mv.addObject("circulation_info",circulation_info);
        mv.setViewName(".tiles.page.WAC003");
        return mv;
        
    }
    
    /**
     * [EN] Main processing<br>
     * [EN] Register to DB information you have modified the screen.<br>
     * [JP] メイン処理<br>
     * [JP] 画面で変更した情報をDBに登録します。<br>
     * 
     * @param form WAC004BoardInfoCreateForm
     * @param request HttpServletRequest
     * @param multiRequest MultipartHttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ErrorBack(viewName = ".tiles.page.WAC013")
    @Token(check = false, save = true)
    public ModelAndView update(@ModelAttribute("WAC004BoardCreateForm") WAC004BoardCreateForm form, HttpServletRequest request, 
        MultipartHttpServletRequest multiRequest) throws Exception {
        
        //System.out.println("WAC003BoardUpdate/infoUpdate.do");
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String boardId = ServletRequestUtils.getStringParameter(request, "boardId");
        String idx = ServletRequestUtils.getStringParameter(request, "idx");
        
        form.setIdx(idx);
        form.setBoardId(boardId);
        
        boardService.update(form, multiRequest);
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAC001BoardSearch.jsp");
        mv.addObject("boardId", form.getBoardId());
        mv.setViewName("redirect:/WAC001BoardSearch/init.do");
        return mv;
        
    }
    
    /**
     * [KR] <br>     
     * 
     * @param form WAC004BoardInfoCreateForm
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @Token(save = true)
    @RequestMapping(value = "/infoInit", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView infoInit(@ModelAttribute("WAC004BoardInfoCreateForm") WAC004BoardInfoCreateForm form, HttpServletRequest request)  throws Exception {
        
        //System.out.println("WAC003BoardUpdate/infoInit.do");
        ModelAndView mv = new ModelAndView();   
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String boardId = ServletRequestUtils.getStringParameter(request, "boardId");
        
        
        BoardInfoDomain domain = new BoardInfoDomain();
        domain.setBoardId(boardId);
        
        BoardInfoDomain getBoardDomain = boardService.searchInfoById(domain);
        
        BoardConfig boardConfig = new BoardConfig();
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, "401"));
        mv.addObject("tabId", tabId);
        mv.addObject("boardInfoDomain", getBoardDomain);
        mv.addObject("boardAuth", boardConfig.get_boardAuth());
        mv.addObject("boardType", boardConfig.get_boardType());
        mv.addObject("fileNum", boardConfig.get_fileNum());
        mv.addObject("fileSize", boardConfig.get_fileSize());
        mv.addObject("fileExt", boardConfig.get_fileExt());
        mv.addObject("pageSize", boardConfig.get_pageSize());
        mv.addObject("pageUnit", boardConfig.get_pageUnit());
        mv.addObject("url", "WAC003BoardUpdate.jsp");
        mv.setViewName(".tiles.page.WAC013");
        return mv;
        
    }
    
    /**
     * [EN] Main processing<br>
     * [EN] Register to DB information you have modified the screen.<br>
     * [JP] メイン処理<br>
     * [JP] 画面で変更した情報をDBに登録します。<br>
     * 
     * @param form WAC004BoardInfoCreateForm
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/infoUpdate", method = RequestMethod.POST)
    @ErrorBack(viewName = ".tiles.page.WAC013")
    @Token(check = false, save = true)
    public ModelAndView infoUpdate(@ModelAttribute("WAC004BoardInfoCreateForm") WAC004BoardInfoCreateForm form, 
        HttpServletRequest request) throws Exception {
        
        /**
         * <pre>
         * 1.[EN] Employee update process.
         *   [EN]   I update an employee with DB by input contents. 
         *   [JP] 社員更新処理
         *   [JP]  ・取得したフォームの部署番号から部署名を取得する
         *   [JP]       ・部署名が取得できなかったとき
         *   [JP]           ・存在しない部署として例外を返す。
         *   [JP]  ・取得したフォームの上司社員番号から社員情報を取得する
         *   [JP]       ・社員情報が取得できなかったとき
         *   [JP]           ・存在しない上司社員番号として例外を返す。
         *   [JP]  ・給料がNULLでない場合
         *   [JP]       ・給料が最低賃金より小さい場合
         *   [JP]           ・警告例を返す。
         *   [JP]  ・取得したフォームに最終更新者をセットする
         *   [JP]  ・取得したフォームの内容で社員情報を更新する。
         *   [JP]  ・更新完了メッセージをMessageManagerにセットする
         *   [JP]  ・更新画面を表示する。
         * </pre>
         */
        //System.out.println("WAC003BoardUpdate/infoUpdate.do");
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        //System.out.println("boardId :" + form.getBoardId());
        boardService.infoUpdate(form);
        
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAC001BoardSearch.jsp");
        mv.setViewName("redirect:/WAC001BoardSearch/infoInit.do");
        return mv;
        
    }
}
