package com.globaldenso.dnkr.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
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
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAB002EmpCreateForm;

/**
 * [KR] 사원 추가 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAB002EmpCreate")
@ViewId(value = "WAB002")
public class WAB002EmpCreateController {

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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAB002EmpCreateController() {
        // no process
    }
    
    
    /**
     * [KR] 사용자정보 입력화면<br>     
     * 
     * @param request               HttpServletRequest
     * @param form                  WAB002EmpCreateForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAB002EmpCreateForm") WAB002EmpCreateForm form)  throws Exception {
        
        //System.out.println("WAB002EmpCreate/init.do");
        ModelAndView mv = new ModelAndView();      
        
        //사업부                   DNKR_RELATION_CLASS
        //사업장                   DNKR_RELATION_LOCATION
        //사업부서(팀)   DNKR_RELATION_TEAM
        
        List<? extends RelationDomain> relationList = null;
        
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        relationList = clsService.searchByCondition(clsDomain);
        //System.out.println("relationList:" + relationList);
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
       
        //공장코드 추가 - JHB 2018.11.14
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationLocDomain> locList = locService.searchByCondition(locDomain);
        
        //String typeExternal = ServletRequestUtils.getStringParameter(request, "type");	//등록메뉴 호출구분(사용자관리(협력업체)메뉴에서 호출한 경우 exteranlAccount)
       //System.out.println("type===="+typeExternal+"=="+menu);
        /*
        if("exteranlAccount".equals(typeExternal)){	//등록메뉴 호출구분
        	form.setInOutType("O");
        }
        */
        if("2".equals(menu)){	//등록메뉴 호출구분
        	System.out.println("XXXX");
        	form.setInOutType("I");
        	System.out.println(form.getInOutType());
        }else{
        	System.out.println("OXXXX");
        	form.setInOutType("O");
        	System.out.println(form.getInOutType());        	
        }
        
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("relationList", relationList);
        mv.addObject("locList", locList);	//공장코드
        mv.addObject("url", "WAB002EmpCreate.jsp");
        mv.setViewName(".tiles.page.WAB002");
        return mv;
        
    }
    
    /**
    * [KR] 사용자정보 입력 처리<br>     
    * 
    * @param request            HttpServletRequest
    * @param form               WAB002EmpCreateForm
    * @return ModelAndView
    * @throws Exception Exception
    */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ErrorBack(viewName = "forward:/WAB002EmpCreate/init.do")
    @Token(check = false, save = true)
    public ModelAndView create(HttpServletRequest request, 
        @ModelAttribute("WAB002EmpCreateForm") @Validated WAB002EmpCreateForm form)  throws Exception {
       
        ModelAndView mv = new ModelAndView(); 
     
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
       
        String empNumber = form.getEmpNumber();
       
       //System.out.println("empNumber:" + empNumber);
        
        if(empNumber == null){
            MessageManager.setMessagelessFieldError("WAB002EmpCreateForm", "empNumber", form.getEmpNumber());
//          throw new ApplicationException("AI-90-0006");
        }
       
        if(form.getInOutType().equals("O")){
            //외부업체 empNumber 임의생성
            String madeEmpNumber = makeEmpNumber();
            //System.out.println("madeEmpNumber:" + madeEmpNumber);
            form.setEmpNumber(madeEmpNumber);
            form.setEmpPrivateAuth("Y");
            //2018.11.15추가 JHB
            if(!"2".equals(menu)){	//menu가 협력업체사용자 관리인 경우
            	 form.setEmpPrivateAuth("N");
            }
        } 
       
        
        if(! Strings.judgeBlank(form.getClsCode()) && form.getInOutType().equals("I")){
            String clsRltnCode = "";
            String locRltnCode = "";

            //입력한 사업부가 존재하는지 확인
            RelationClsDomain setClsDomain = new RelationClsDomain();
            setClsDomain.setRelationCode(form.getClsCode());
            setClsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            RelationClsDomain getClsDomain = clsService.searchByKey(setClsDomain);
            if (getClsDomain == null || Strings.judgeBlank(getClsDomain.getRelationName())) {
                MessageManager.setMessagelessFieldError("WAB002EmpCreateForm", "clsCode", form.getClsCode());
                throw new ApplicationException("DNKR-E1-0000");
            }
            clsRltnCode = getClsDomain.getRltnCode();
           
            if(! Strings.judgeBlank(form.getLocCode())){
                EmpDomain setEmpDomain = new EmpDomain();
                setEmpDomain.setEmpNumber(empNumber);
                if(empService.searchByKey(setEmpDomain) != null) {
                    MessageManager.setMessagelessFieldError(
                           "WAB002EmpCreateForm", "empNumber", empNumber);
                    throw new ApplicationException("SMPL-E8-0004");
                }
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
                form.setEmpId(makeEmpId(empNumber, clsRltnCode, locRltnCode));
            }
        }
        empService.create(form);
       
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        //mv.addObject("url", "WAB001EmpSearch.jsp");
        //mv.setViewName("redirect:/WAB001EmpSearch/init.do");
        
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
    * [KO] 외부업체 사번 임의생성 메소드
    * 
    * @return   String
    * @throws Exception 
    */
    private String makeEmpNumber() throws Exception{
        EmpDomain empDomain = new EmpDomain();
        StringBuffer madeEmpNumber = new StringBuffer();
        //외부직원은 맨앞글자를 O로 고정
        madeEmpNumber.append("O");

        String maxEmpNumber = empService.searchMaxEmpNumber(empDomain);
        if (maxEmpNumber == null || "".equals(maxEmpNumber)){
            //가장큰 데이터가 없을경우 
            madeEmpNumber.append("000000001");
        } else {
            int strLength = maxEmpNumber.length();
            int maxNo = Integer.parseInt(maxEmpNumber.substring(1, strLength));
            String strMaxNo = String.format("%09d", maxNo + 1);
            madeEmpNumber.append(strMaxNo);
        }
        return madeEmpNumber.toString();
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
        }  else if (clsRltnCode.equals("DENSO") && locRltnCode.equals("4000")) {
            madeEmpId = 'R' + empNum;
        }  else {
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
