package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.globaldenso.ai.core.util.Strings;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.AuthService;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.domain.AuthDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAB002EmpCreateForm;

/**
 * [KR] 사원 정보 수정 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAB004EmpUpdate")
@ViewId(value = "WAB004")
public class WAB004EmpUpdateController {

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] 사원부 관리 서비스 <br>     
     */
    @Autowired
    private RelationClsService clsService;
    
    /**
     * [KR] 사원장 관리 서비스 <br>     
     */
    @Autowired
    private RelationLocService locService;
    
    /**
     * [KR] 사원부서(팀) 관리 서비스 <br>     
     */
    @Autowired
    private RelationTeamService teamService;

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private PrivateAuthService privateAuthService;

    /**
     * [KR] 권한 서비스 <br>     
     */
    @Autowired
    private AuthService authService;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAB004EmpUpdateController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @param form              WAB002EmpCreateForm
     * @param request           HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @Token(save = true)
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(@ModelAttribute("WAB002EmpCreateForm") WAB002EmpCreateForm form, HttpServletRequest request)  throws Exception {
        
        //System.out.println("WAB004EmpUpdate/init.do");
        ModelAndView mv = new ModelAndView();   
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        //공장코드 추가 - JHB 2018.11.14
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationLocDomain> locList = locService.searchByCondition(locDomain);        
        
        EmpDomain setEmpDomain = new EmpDomain();
        setEmpDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        setEmpDomain.setEmpNumber(empNumber);
        EmpDomain getEmpDomain = empService.searchByKey(setEmpDomain);
        
        //개인권한이 없을 시 팀 권한을 불러오도록 수정
        String teamCode = getEmpDomain.getTeamCode();
        
        if(teamCode != null){	//2019.02.19 JHB 수정 : 협력업체는 팀코드가 없어서 오류발생함.
        	RelationTeamDomain setTeamDomain = new RelationTeamDomain();
            RelationTeamDomain getTeamDomain = new RelationTeamDomain();
            setTeamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            setTeamDomain.setRelationCode(teamCode);
            getTeamDomain = teamService.searchByKey(setTeamDomain);
            
            AuthDomain authDomain = new AuthDomain();
            authDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            List<AuthDomain> authList = authService.searchByCondition(authDomain);
            mv.addObject("authCode", getTeamDomain.getAuthCode());
        }else{
        	 mv.addObject("authCode", "");
        }
        
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("locList", locList);	//공장코드
        mv.addObject("empDomain", getEmpDomain);
        mv.addObject("url", "WAB004EmpUpdate.jsp");
        mv.setViewName(".tiles.page.WAB004");
        return mv;
        
    }
    
    /**
     * [EN] Main processing<br>
     * [EN] Register to DB information you have modified the screen.<br>
     * [JP] メイン処理<br>
     * [JP] 画面で変更した情報をDBに登録します。<br>
     * 
     * @param form WA0003EmpUpdateForm
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ErrorBack(viewName = ".tiles.page.WAB004")
    @Token(check = false, save = true)
    public ModelAndView update(@ModelAttribute("WAB002EmpCreateForm") WAB002EmpCreateForm form, HttpServletRequest request) throws 
            Exception {
        
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
        //System.out.println("WAB004EmpUpdate/update.do");
        ModelAndView mv = new ModelAndView();
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        
        //System.out.println("empNumber:" + form.getEmpNumber());
        
        //개인권한삭제
        if(form.getEmpPrivateAuth() != null && form.getEmpPrivateAuth().equals("N")){
            try {
                PrivateAuthDomain delDomain = new PrivateAuthDomain();
                delDomain.setEmpNumber(form.getEmpNumber());
                privateAuthService.delete(delDomain);
            } catch (Exception e) {
                System.out.println("삭제할 데이터가 없습니다.");
            }
        }
        
        //부서가 변경되었을걸 대비한 아이디 변경로직
        if(! Strings.judgeBlank(form.getClsCode())){
//          if(! Strings.judgeBlank(form.getClsCode()) && form.getInOutType().equals("I")){
            String clsRltnCode = "";
            String locRltnCode = "";

            //입력한 사업부가 존재하는지 확인
            RelationClsDomain setClsDomain = new RelationClsDomain();
            setClsDomain.setRelationCode(form.getClsCode());
            setClsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            RelationClsDomain getClsDomain = clsService.searchByKey(setClsDomain);
            if (getClsDomain == null || Strings.judgeBlank(getClsDomain.getRelationName())) {
                MessageManager.setMessagelessFieldError(
                    "WAB002EmpCreateForm", "clsCode", form.getClsCode());
                throw new ApplicationException("DNKR-E1-0000");
            }
            clsRltnCode = getClsDomain.getRltnCode();
            
            if(! Strings.judgeBlank(form.getLocCode())){
                //System.out.println("judgeBlank");
                //입력한 사업장이 존재하는지 확인
                RelationLocDomain setLocDomain = new RelationLocDomain();
                setLocDomain.setRelationCode(form.getLocCode());
                setLocDomain.setClsCode(form.getClsCode());
                setLocDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
                RelationLocDomain getLocDomain = locService.searchByKey(setLocDomain);
                if (getLocDomain == null || Strings.judgeBlank(getLocDomain.getRelationName())) {
                    MessageManager.setMessagelessFieldError("WAB002EmpCreateForm", "locCode", form.getLocCode());
                    throw new ApplicationException("DNKR-E1-0001");
                }
                if(! Strings.judgeBlank(form.getLocCode())){
                    //입력한 사업부서(팀)이 존재하는지 확인
                    RelationTeamDomain setTeamDomain = new RelationTeamDomain();
                    setTeamDomain.setRelationCode(form.getTeamCode());
                    setTeamDomain.setLocCode(form.getLocCode());
                    setTeamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
                    RelationTeamDomain getTeamDomain = teamService.searchByKey(setTeamDomain);
                    if (getTeamDomain == null || Strings.judgeBlank(getTeamDomain.getRelationName())) {
                        MessageManager.setMessagelessFieldError("WAB002EmpCreateForm", "teamCode", form.getTeamCode());
                        throw new ApplicationException("DNKR-E1-0002");
                    }
                }
                locRltnCode = getLocDomain.getRltnCode();
                form.setEmpId(makeEmpId(form.getEmpNumber(), clsRltnCode, locRltnCode));
            }
            
        }
        empService.update(form);
        
        mv.addObject("tabId", tabId);
        /*mv.addObject("empNumber", form.getEmpNumber());
        mv.setViewName("forward:init.do");*/
        //mv.addObject("url", "WAB001EmpSearch.jsp");
        //mv.setViewName("redirect:/WAB001EmpSearch/init.do?menu=" + menu);
        
        //System.out.println("menu====="+menu);
        if("2".equals(menu)){
			mv.addObject("url", "WAB001EmpSearch.jsp");
			mv.setViewName("redirect:/WAB001EmpSearch/init.do?menu=" + menu);
        }else{
			mv.addObject("url", "WAB007RelationCompanySearch.jsp");
        	mv.setViewName("redirect:/WAB007RelationCompanySearch/init.do?menu=" + menu);
        }
        return mv;
    }
    
    /**
     * [KO] 사업부, 사업장에 따른 사원 아이디 생성 메소드
     * 
     * @param empNum String
     * @param clsRltnCode String
     * @param locRltnCode String
     * @return String
     */
    private String makeEmpId(String empNum, String clsRltnCode, String locRltnCode) {
    	//더존 회사코드변경시 수정필요
        String madeEmpId = "";
        /*
        if (clsRltnCode.equals("1000") && locRltnCode.equals("1001")) {
            madeEmpId = 'C' + empNum;
        } else if (clsRltnCode.equals("1000") && locRltnCode.equals("2001")) {
            madeEmpId = 'H' + empNum;
        } else if (clsRltnCode.equals("1000") && locRltnCode.equals("3001")) {
            madeEmpId = 'S' + empNum;
        } else if (clsRltnCode.equals("2000") && locRltnCode.equals("1000")) {
            madeEmpId = 'E' + empNum;
        } else {
            madeEmpId = empNum;
        }
     
        if ((clsRltnCode.equals("1000") && locRltnCode.equals("1001")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("2000"))) {
            madeEmpId = 'C' + empNum;
        } else if ((clsRltnCode.equals("1000") && locRltnCode.equals("2001")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("5000"))) {
            madeEmpId = 'H' + empNum;
        } else if ((clsRltnCode.equals("1000") && locRltnCode.equals("3001")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("3000"))) {
            madeEmpId = 'S' + empNum;
        } else if ((clsRltnCode.equals("2000") && locRltnCode.equals("1000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("1000"))) {
            madeEmpId = 'E' + empNum;
        } else if (clsRltnCode.equals("DENSO") && locRltnCode.equals("4000")) {
            madeEmpId = 'R' + empNum;
        } else {
            madeEmpId = empNum;
        }
        
        if (clsRltnCode.equals("1000") && locRltnCode.equals("2000")) {
            madeEmpId = 'C' + empNum;
        } else if (clsRltnCode.equals("1000") && locRltnCode.equals("5000")) {
            madeEmpId = 'H' + empNum;
        } else if (clsRltnCode.equals("1000") && locRltnCode.equals("3000")) {
            madeEmpId = 'S' + empNum;
        } else if (clsRltnCode.equals("2000") && locRltnCode.equals("1000")) {
            madeEmpId = 'E' + empNum;
        } else if (clsRltnCode.equals("3000") && locRltnCode.equals("4000")) {
            madeEmpId = 'R' + empNum;
        } else {
            madeEmpId = empNum;
        }
        
        if ((clsRltnCode.equals("1000") && locRltnCode.equals("2000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("2000"))) {
            madeEmpId = 'C' + empNum;
        } else if ((clsRltnCode.equals("1000") && locRltnCode.equals("5000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("5000"))) {
            madeEmpId = 'H' + empNum;
        } else if ((clsRltnCode.equals("1000") && locRltnCode.equals("3000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("3000"))) {
            madeEmpId = 'S' + empNum;
        } else if ((clsRltnCode.equals("2000") && locRltnCode.equals("1000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("1000"))) {
            madeEmpId = 'E' + empNum;
        }  else if ((clsRltnCode.equals("3000") && locRltnCode.equals("4000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("4000"))) {
            madeEmpId = 'R' + empNum;
        }  else {
            madeEmpId = empNum;
        }
        */
        /*
        // 2020.06.18 삭제
        if ((clsRltnCode.equals("1000") && locRltnCode.equals("2000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("2000"))) {
            madeEmpId = 'C' + empNum;
        } else if ((clsRltnCode.equals("1000") && locRltnCode.equals("5000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("5000"))) {
            madeEmpId = 'H' + empNum;
        } else if ((clsRltnCode.equals("1000") && locRltnCode.equals("3000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("3000"))) {
            madeEmpId = 'S' + empNum;
        } else if ((clsRltnCode.equals("2000") && locRltnCode.equals("1000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("1000"))) {
            madeEmpId = 'E' + empNum;
        }  else if ((clsRltnCode.equals("3000") && locRltnCode.equals("4000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("4000"))) {
            madeEmpId = 'R' + empNum;
        }  else {
            madeEmpId = empNum;
        }
        */
        //2020.06.18 GCI-AD 변경 : 사업부코드(E/C/S/H/R) → 국가코드(40004)
       if ((clsRltnCode.equals("1000") && locRltnCode.equals("2000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("2000"))) {
            madeEmpId = "40004" + empNum;
        } else if ((clsRltnCode.equals("1000") && locRltnCode.equals("5000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("5000"))) {
            madeEmpId = "40004" + empNum;
        } else if ((clsRltnCode.equals("1000") && locRltnCode.equals("3000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("3000"))) {
            madeEmpId = "40004" + empNum;
        } else if ((clsRltnCode.equals("2000") && locRltnCode.equals("1000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("1000"))) {
            madeEmpId = "40004" + empNum;
        }  else if ((clsRltnCode.equals("3000") && locRltnCode.equals("4000")) || (clsRltnCode.equals("DENSO") && locRltnCode.equals("4000"))) {
            madeEmpId = "40004" + empNum;
        }  else {
            madeEmpId = empNum;
        }
        return madeEmpId;
    }
}
