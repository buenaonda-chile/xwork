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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.BoardService;
import com.globaldenso.dnkr.business.service.CodeService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAC004BoardCreateForm;
import com.globaldenso.dnkr.presentation.form.basic.WAC004BoardInfoCreateForm;
import com.globaldenso.dnkr.uxis.BoardConfig;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KR] 게시판 추가 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC004BoardCreate")
@ViewId(value = "WAC004")
public class WAC004BoardCreateController {
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
    public WAC004BoardCreateController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param form   WAC004BoardCreateForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAC004BoardCreateForm") WAC004BoardCreateForm form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();  
        if(UxisUtil.isMobile(request)) {
            mv.setViewName(".tiles.page.WAC004M");
        } else {
            String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
            String boardId = ServletRequestUtils.getStringParameter(request, "boardId");
            
            System.out.println("tabId : " + tabId);
            System.out.println("boardId : " + boardId);
            
            BoardInfoDomain infoDomain = new BoardInfoDomain();
            infoDomain.setBoardId(boardId);
            infoDomain = boardService.searchInfoById(infoDomain);
            
            /*세션에 저장된 아이디 받아오기 */
            String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
    
            JSONParser parser = new JSONParser();
            Object empInfoObj = parser.parse(empInfo);
            JSONObject empJsonObj = (JSONObject)empInfoObj;
            String userId = (String)empJsonObj.get("uid");
            
            //카테고리 조회
            CodeDomain langDomain = new CodeDomain();
            langDomain.setCnmLangCode(DensoContext.get().getLocale().getLanguage());
            langDomain.setCmcParentCode(DnkrConstans.CMC_BOARD_CATEGORY);
            List<CodeDomain> categoryList = codeService.searchByCondition(langDomain);
            mv.addObject("categoryList", categoryList);
    
            //사용자 권한 받아오기
            String menuCode = "";
            if(form.getBoardId().equals("BID0001")){
                menuCode = "6";
            }else if(form.getBoardId().equals("BID0003")){
                menuCode = "441";
            }
            mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menuCode));
            
            mv.addObject("tabId", tabId);
            mv.addObject("writer", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("today", UxisStringUtil.getTodayYMDString());
            mv.addObject("userId", userId);
            mv.addObject("infoDomain", infoDomain);
            mv.addObject("url", "WAC004BoardCreate.jsp");
            
            mv.setViewName(".tiles.page.WAC004");
        }
        return mv;
        
    }
    
    /**
     * [KR] 사용자정보 입력 처리<br>     
     * 
     * @param request   HttpServletRequest
     * @param form   WAC004BoardCreateForm
     * @param multiRequest   MultipartHttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
    @ErrorBack(viewName = ".tiles.page.WAC004")
    @Token(check = false, save = true)
    public ModelAndView create(HttpServletRequest request, 
        @ModelAttribute("WAC004BoardCreateForm") @Validated WAC004BoardCreateForm form, 
        MultipartHttpServletRequest multiRequest)  throws Exception {
        
        //System.out.println("WAC004BoardCreate  create ");
        ModelAndView mv = new ModelAndView(); 
        
        /*세션에 저장된 아이디 받아오기 */
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj = parser.parse(empInfo);
        JSONObject empJsonObj = (JSONObject)empInfoObj;
        String empNumber = (String)empJsonObj.get("uid");

        String userIp = request.getRemoteAddr();

        form.setRegiId(empNumber);
        form.setUserIp(userIp);

        boardService.create(form, multiRequest);
        
        //System.out.println("create  boardId : " + form.getBoardId());
        mv.addObject("boardId", form.getBoardId());
        mv.setViewName("redirect:/WAC001BoardSearch/init.do");
        return mv;
        
    }
    
    /**
     * [KR] 게시판 입력화면<br>     
     * 
     * @param request       HttpServletRequest
     * @param form          WAC004BoardInfoCreateForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/infoInit", method = { RequestMethod.GET, RequestMethod.POST })
    @Token(save = true)
    public ModelAndView infoInit(HttpServletRequest request, 
        @ModelAttribute("WAC004BoardInfoCreateForm") WAC004BoardInfoCreateForm form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();      
        
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
       
        BoardConfig boardConfig = new BoardConfig();
        
        mv.addObject("tabId", tabId);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, "401"));
        mv.addObject("boardAuth", boardConfig.get_boardAuth());
        mv.addObject("boardType", boardConfig.get_boardType());
        mv.addObject("fileNum", boardConfig.get_fileNum());
        mv.addObject("fileSize", boardConfig.get_fileSize());
        mv.addObject("fileExt", boardConfig.get_fileExt());
        mv.addObject("pageSize", boardConfig.get_pageSize());
        mv.addObject("pageUnit", boardConfig.get_pageUnit());
        mv.setViewName(".tiles.page.WAC014");
        return mv;
        
    }
    
    /**
     * [KR] 사용자정보 입력 처리<br>     
     * 
     * @param request   HttpServletRequest
     * @param form      WAC004BoardInfoCreateForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/infoCreate", method = RequestMethod.POST)
    @ErrorBack(viewName = ".tiles.page.WAC014")
    @Token(check = false, save = true)
    public ModelAndView infoCreate(HttpServletRequest request, 
        @ModelAttribute("WAC004BoardInfoCreateForm") @Validated WAC004BoardInfoCreateForm form)  throws Exception {
        
        //System.out.println("WAC004BoardCreate  infoCreate ");
        ModelAndView mv = new ModelAndView(); 
        
        /*세션에 저장된 아이디 받아오기 */
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj = parser.parse(empInfo);
        JSONObject empJsonObj = (JSONObject)empInfoObj;
        String empNumber = (String)empJsonObj.get("uid");

        form.setRegiId(empNumber);
        
        boardService.infoCreate(form);
        
        mv.setViewName("redirect:/WAC001BoardSearch/infoInit.do");
        return mv;
        
    }
}
