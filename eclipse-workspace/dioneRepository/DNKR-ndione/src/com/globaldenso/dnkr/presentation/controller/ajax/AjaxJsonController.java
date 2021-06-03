package com.globaldenso.dnkr.presentation.controller.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.dnkr.JsonView;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/reqJson")
public class AjaxJsonController {

    /** Constructor.  */
    public AjaxJsonController(){

    }

    /**
     * 
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @return JsonView
     * @throws Exception 
     */
    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
    public JsonView testJson(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        JsonView jv = new JsonView();

        jv.addStaticAttribute("jsonString", "{'json':'aa'}");

        return jv;
    }
}
