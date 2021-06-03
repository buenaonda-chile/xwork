package com.globaldenso.dnkr.presentation.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 조직도 리스트 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD008RelationSearch")
@ViewId(value = "WAD008")
public class WAD008RelationSearchController {

    /**
     * [KR] 조직도 서비스 <br>     
     
    @Autowired
    private RelationClsService relationService;
     */

    /**
     * [KR] 부서(팀) 서비스 <br>     
     */
    @Autowired
    private RelationTeamService relationTeamService;
    
    /** */
    private final String MENU_CODE = "4";
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD008RelationSearchController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public ModelAndView init(HttpServletRequest request)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
//        System.out.println("메뉴코드:" + menu);
//        System.out.println("권한체크" + UxisCmmUtil.getSessionAuthData(request, menu));
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
//        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAD008RelationSearch.jsp");
        mv.setViewName(".tiles.page.WAD008");
        return mv;
        
    }
    
    
    /**
     * [KR] 부서정보 연계 처리<br>     
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/deptRntn", method = RequestMethod.GET)
    @ErrorBack(viewName = ".tiles.page.WAD008")
    @Token(check = false, save = true)
    public ModelAndView deptRntn(HttpServletRequest request)  throws Exception {
        
        //System.out.println("deptRntn");
        ModelAndView mv = new ModelAndView(); 
        HashMap rtnMap = relationTeamService.procMergeDept();
        
        /**
         * 2019.04.17 JHB TEST
         * ①최신부서코드가 아닌 항목에 대해서는 사용여부를 False로 변경
         * 프로시저(PROC_MERGE_TEAM) 수정 - UPDATE DNKR_RELATION_TEAM의-TEAM_USE = 'Y' -- 사용여부 강제 업데이트(2019.04.17 제환복추가)
         **/
        /*
        //버튼 및 스케줄  서비스단에서 처리하도록 로직변경 : 2020.09.11
        String procRlt = rtnMap.get("rtnCd").toString(); 
        if(procRlt.equals("1")){	//정상적으로 처리된 경우
        	relationTeamService.searchByClsLocCode(); //PROC_MERGE_TEAM) 수정 -TEAM_USE = 'Y'(2019.04.17 제환복추가)
        }
        */
        //System.out.println(rtnMap.get("rtnCd"));
        //System.out.println(rtnMap.get("rtnMsg"));
        mv.setViewName("redirect:/WAD008RelationSearch/init.do");
        return mv;
        
    }
}
