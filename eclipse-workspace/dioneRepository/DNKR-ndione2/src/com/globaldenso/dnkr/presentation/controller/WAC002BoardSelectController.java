package com.globaldenso.dnkr.presentation.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.BoardService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.domain.BoardFileDomain;
import com.globaldenso.dnkr.domain.BoardTextDomain;
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAC001BoardSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KR] 게시판 뷰페이지 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAC002BoardSelect")
@ViewId(value = "WAC002")
public class WAC002BoardSelectController {
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
    public WAC002BoardSelectController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @return ModelAndView
     * @throws Exception Exception
     */
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request       HttpServletRequest
     * @param form          WAC001BoardSearchForm
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(HttpServletRequest request, @ModelAttribute("WAC001BoardSearchForm") WAC001BoardSearchForm form)  throws Exception {
        ModelAndView mv = new ModelAndView();
    
       	String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String boardId = ServletRequestUtils.getStringParameter(request, "boardId");
        String idx = ServletRequestUtils.getStringParameter(request, "idx");
        
        //System.out.println("boardId : " + boardId + "  , idx : " + idx);
        String userId = UxisCmmUtil.getSessionData(request, "uid");
        BoardTextDomain domain = new BoardTextDomain();
        domain.setBoardId(boardId);
        domain.setIdx(idx);
        domain.setUser_Id(userId);
        
        boardService.hitsUpdate(domain);
        
        BoardTextDomain getBoardTextDomain = boardService.searchById(domain);
        BoardFileDomain fileDomain = new BoardFileDomain();
        fileDomain.setBoardId(getBoardTextDomain.getBoardId());
        fileDomain.setIdx(getBoardTextDomain.getIdx());
        List<BoardFileDomain> fileList = boardService.searchFileList(fileDomain);
        
        /*세션에 저장된 아이디 받아오기 */
        /*String empInfo = request.getSession().getAttribute("ACCOUNT").toString();

        JSONParser parser = new JSONParser();
        Object empInfoObj = parser.parse(empInfo);
        JSONObject empJsonObj = (JSONObject)empInfoObj;
        String userId = (String)empJsonObj.get("uid");*/
        
        
        String menuCode = "";
        if(ServletRequestUtils.getStringParameter(request, "pageNo") != null){
            int pageNo = Integer.parseInt(ServletRequestUtils.getStringParameter(request, "pageNo"));
            if(pageNo != 0){
                form.setPageNo(pageNo);
            }
        }
        if(form.getBoardId().equals("BID0001")){
            menuCode = "6";
        }else if(form.getBoardId().equals("BID0003")){
            menuCode = "441";
        }
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menuCode));
        
        mv.addObject("tabId", tabId);
        mv.addObject("userId", userId);
        mv.addObject("paging", form);
        mv.addObject("boardTextDomain", getBoardTextDomain);
        mv.addObject("fileList", fileList);
        mv.addObject("url", "WAC002BoardSelect.jsp");
        if(UxisUtil.isMobile(request)) {
        	Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
        	
        	mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAC002M");
        } else {
        	mv.setViewName(".tiles.page.WAC002");
        }
        return mv;
        
    }
}
