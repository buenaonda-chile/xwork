package com.globaldenso.dnkr.presentation.controller.sal;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.presentation.form.basic.WAC016LogSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 
 * 
 * @author K-DATALAB
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/WAS005SalAnlysView")
@ViewId(value = "WAS005")
public class WAS005SalAnlysViewController {
    

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAS005SalAnlysViewController() {
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
    public ModelAndView init(HttpServletRequest request, @ModelAttribute("WAC016LogSearchForm") WAC016LogSearchForm form)  throws Exception {
    	
    	
    	String nameId = ServletRequestUtils.getStringParameter(request, "nameId");
        if(nameId == null){
            nameId = "empName";
        }
    	
    	if(nameId.equals("empId")){
            form.setEmpId(form.getSearchData());
            form.setEmpName("");
        }else{
            form.setEmpId("");
            form.setEmpName(form.getSearchData());
        }
    	
    	String startDate = ServletRequestUtils.getStringParameter(request, "startDate");
        String endDate = ServletRequestUtils.getStringParameter(request, "endDate");
        String getPlnym = ServletRequestUtils.getStringParameter(request, "getPlnym");
    	
        if(form.getStartDate() == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            startDate = today;
            endDate = today;
            form.setStartDate(startDate);
            form.setEndDate(endDate);
        }
        
        ModelAndView mv = new ModelAndView();
        
        if(getPlnym == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            getPlnym = today;
        }
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");

        UxisCmmUtil.getSessionLocToCls(request, mv);// 사업부
        
        String empInfo = request.getSession().getAttribute("ACCOUNT").toString();
        JSONParser parser = new JSONParser();
        Object empInfoObj       = parser.parse(empInfo);
        JSONObject empJsonObj   = (JSONObject)empInfoObj;
//        String empCls        = UxisCmmUtil.getChangeCls((String)empJsonObj.get("clsCode"));        //사용자 사업부
        String empLoc        = UxisCmmUtil.getChangeCls((String)empJsonObj.get("locCode"));        //사용자 공장   
       
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("tabId", tabId);
        mv.addObject("plnym", getPlnym);//캘린더설정
        mv.addObject("startDate", startDate);
        mv.addObject("endDate", endDate);
 //       mv.addObject("empCls", empCls);  //사용자 사업부
        mv.addObject("empLoc", empLoc);  //사용자 공장  
        mv.addObject("url", "WAS005SalAnlysView.jsp");
        mv.setViewName(".tiles.page.WAS005");
        return mv;       
    }

}
