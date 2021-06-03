package com.globaldenso.dnkr.presentation.controller.mrp;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.db2.ManagementInfomationService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.domain.db2.QrPartListDomain;
import com.globaldenso.dnkr.presentation.form.dwh.WAO001QrPartListForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 설문 진행 페이지 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAO001PartListView")
@ViewId(value = "WAG005")
public class WAO001PartListViewController {
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAO001PartListViewController() {
        // no process
    }
	/**
	 * [KR] 종합관리 서비스 <br>
	 */
	@Autowired
	private ManagementInfomationService mifService;
    /**
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @param locale Optional
     * @param form QuestionDomain
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/qrRead", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView qrRead(HttpServletRequest request, HttpServletResponse response, 
    		@CookieValue("locallocale") Optional<String> locale,  @ModelAttribute("WAG002SurveyQuestionCreate") QuestionDomain form)  throws Exception {
     	localeSet(locale, request, response); //익명으로 설문참여시 언어셋팅
        ModelAndView mv = new ModelAndView();  

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        form.setCmcCode(DensoContext.get().getLocale().getLanguage());
      
        mv.addObject("menu", menu);
        mv.addObject("srvCode", form.getSrvCode());
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG001SurveyPaperView.jsp");
        mv.setViewName(".tiles.page.WAO001");
        return mv;
    }
  
	@RequestMapping(value = "/ajaxPartNameSearch", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getPartName(HttpServletRequest request,
			@ModelAttribute("WAO001QrPartListForm") WAO001QrPartListForm form)
			throws Exception {
		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */
		ModelAndView model = new ModelAndView(new JsonView());
		JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
		String qrRead = form.getQrRead();
		
		if(qrRead.length() > 150) {
			jsonObj.put("result", result);
			result = DnkrConstans.RESULT_Y;
			model.addObject("jsonString", jsonObj.toString());
			return model;
		}
		
		String costumerNum = qrRead.substring(66, (66+25));
		String partNum = qrRead.substring(91, (91+15)).trim();
		String quantity = qrRead.substring(106,(106+7));
		String lineCode = qrRead.substring(113, (113+4));
		String seq = qrRead.substring(143,(143+7));
		   
		form.setPartNum(partNum);
		form.setLineCode(lineCode);
		// DISC5060020000010091000210125104151120712305153081540815509152072194001-F3011              TN157590-9070DA0000004C-07 20180514051418000100100010008345
		// DISC5060020000010091000210125104151120712305153081540815509152072194053-F2690              11004-128200H  0000004C-10 20190213021319000100200010000478
		
		// DISC5060020000010091000210125104151120712305153081540815509152072194053-F2690              11004-33772PO  0000004C-10 20190213021319000100200010000478
		// DISC5060020000010091000210125104151120712305153081540815509152072194053-A5530              11002-156803H  0000001C-24 20191101110119000100100010000007
		   
		
		// 라이브러리 comps 셋팅
		//UxisCmmUtil.getCompsLib(form);

		List<QrPartListDomain> upPartList = new ArrayList<QrPartListDomain>();
		
			try {
				QrPartListDomain partInfo = mifService.searchByPartName(form);
				
				QrPartListDomain domain = new QrPartListDomain();
				domain.setCostumerNum(costumerNum);
				domain.setPartNum(partInfo.getCinbr());
				domain.setQuantity(quantity);
				domain.setSeq(seq);
				domain.setPartName(partInfo.getItdsc());
				domain.setLineCode(partInfo.getPrsnm());
				
				upPartList.add(domain);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (upPartList != null) {
				result = DnkrConstans.RESULT_Y;
				jsonObj.put("list", upPartList);
			}
		
		jsonObj.put("result", result);
		
		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
	
	@RequestMapping(value = "/ajaxQrPartPrint", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView qrPrint(HttpServletRequest request,
			@ModelAttribute("WAO001QrPartListForm") WAO001QrPartListForm form)
			throws Exception {
		/**
		 * <pre>
		 *             
		 * 1.[JP]           
		 *   [EN] Screen initialization processing.         
		 *   [EN]   I acquire Log information and display it to a screen
		 * </pre>
		 */
		ModelAndView model = new ModelAndView(new JsonView());
		JSONObject jsonObj = new JSONObject();
		String result = DnkrConstans.RESULT_N;
		
		List<QrPartListDomain> partPrintList = null; 
		
			try {
				partPrintList = mifService.searchByQrPartList(form);
				
			
				//partPrintList.add(domain);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (partPrintList != null) {
				result = DnkrConstans.RESULT_Y;
				jsonObj.put("list", partPrintList);
			}
		
		jsonObj.put("result", result);
		
		model.addObject("jsonString", jsonObj.toString());
		return model;
	}
	
	 /**
     * [KO] 로그인 과정 없이 다이렉트로 설문참여시 언어 셋팅
     * 
     * @param locale Optional
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    private void localeSet(Optional<String> locale , HttpServletRequest request, HttpServletResponse response) {
    	Locale newLocale;
        String paraLocale = request.getParameter("locale");
    	try{
            if (paraLocale == null) {
                if((locale.orElse(DensoContext.get().getLocale().getLanguage())) != null 
                    && (locale.orElse(DensoContext.get().getLocale().getLanguage())).equals("ko")){
                    newLocale = new Locale("kr");
                    paraLocale = "kr";
                }else {
                    newLocale = new Locale(locale.orElse(DensoContext.get().getLocale().getLanguage()));
                    paraLocale = locale.orElse(DensoContext.get().getLocale().getLanguage());
                }
            } else {
                newLocale = new Locale(paraLocale);
            }
            DensoContext.get().setLocale(newLocale);
        }catch(Exception e){
            newLocale = new Locale("kr");
        }

        DensoContext.get().setLocale(newLocale);
        
        //세션이 있으면 쿠키굽기
        HttpSession session = request.getSession(false);
        if (session != null) {
//        System.out.println("cookie 굽기 : " + paraLocale);
            response.addCookie(UxisCmmUtil.makeCookie(request, "locallocale", paraLocale));
        }
    }
}
