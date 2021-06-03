package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.AuthService;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.domain.AuthDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;

/**
 * [KR] 권한수정 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAD006AuthPopSelect")
@ViewId(value = "WAD007")
public class WAD007AuthPopSelectController {

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;

    /**
     * [KR] 권한 서비스 <br>     
     */
    @Autowired
    private RelationTeamService teamService;

    /**
     * [KR] 권한 서비스 <br>     
     */
    @Autowired
    private AuthService authService;
    
    /**
     * [KR] 메뉴서비스 <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD007AuthPopSelectController() {
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
        
        //System.out.println("AuthPopSelect/init.do");
        ModelAndView mv = new ModelAndView(); 
        
        String teamCode = ServletRequestUtils.getStringParameter(request, "teamCode");
        String researchCode = ServletRequestUtils.getStringParameter(request, "researchCode");
        
        //선택한 팀정보
        RelationTeamDomain setTeamDomain = new RelationTeamDomain();
        RelationTeamDomain getTeamDomain = new RelationTeamDomain();
        setTeamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        setTeamDomain.setRelationCode(teamCode);
        getTeamDomain = teamService.searchByKey(setTeamDomain);
        
        
        AuthDomain authDomain = new AuthDomain();

        authDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        
        //권한그룹리스트
        List<AuthDomain> authList = authService.searchByCondition(authDomain);
        
        List<AuthDomain> researchList = null;
        
        if(researchCode != null || "".equals(researchCode)){
            authDomain.setAuthCode(researchCode);
            researchList = authService.searchByCondition(authDomain);
            mv.addObject("researchList", researchList);
        }
        
        mv.addObject("authList", authList);
        mv.addObject("teamName", getTeamDomain.getRelationName());
        mv.addObject("authCode", getTeamDomain.getAuthCode());
        mv.addObject("teamCode", teamCode);
        mv.addObject("url", "WAD007AuthPopSelect.jsp");
        mv.setViewName(".tiles.page.WAD007");
        return mv;
        
    }
    
    /**
     * 
     * @param request   HttpServletRequest
     * @return  ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/selectConfig", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView selectConfig(HttpServletRequest request)  throws Exception {

        //System.out.println("authPopSelect/selectConfig.do");

        String authCode = ServletRequestUtils.getStringParameter(request, "authCode");
        String teamCode = ServletRequestUtils.getStringParameter(request, "teamCode");

        ModelAndView mv = new ModelAndView();

        //팀도메인에 권한코드 등록하기
        RelationTeamDomain teamDomain2 = new RelationTeamDomain();
        teamDomain2.setRelationCode(teamCode);
        teamDomain2.setAuthCode(authCode);
        teamService.updateAuth(teamDomain2);

        //사원테이블에 팀에 맞게 권한코드 등록하기
        EmpDomain empDomain = new EmpDomain();
        empDomain.setTeamCode(teamCode);
        empDomain.setAuthCode(authCode);
        try {
            empService.update(empDomain);
        }catch(Exception e) {
            System.out.println("업데이트할 사원이 없습니다.");
        }

        mv.addObject("authCode", authCode);
        mv.addObject("teamCode", teamCode);
        mv.addObject("url", "WAD005AuthPopConfig.jsp");
        mv.setViewName("redirect:init.do");
        return mv;
    }
}
