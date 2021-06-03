package com.globaldenso.dnkr.presentation.controller.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.JsonService;

/**
 * @author e110290
 *
 */
@Controller
@RequestMapping(value = "/JsonSearch")
public class JsonIfController {

	@Autowired
	private JsonService jsonService;
	
	public  JsonIfController(){

	}
	
	@RequestMapping(value = "/initQRSearch", method = {RequestMethod.GET, RequestMethod.POST}, headers="Accept=application/json")
	public JsonView initQRSearch(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
	
		String rtnJson;	//return Json
		
		List<Object> list = null;
		JSONObject jsonList = new JSONObject();
		
		HashMap<String, String> setParam = new HashMap<String, String>();
		setParam.put("CALL", "QR");
		setParam.put("COMPS", "S1");
		setParam.put("TRNDT", "20190723");
		setParam.put("DEVID", "21");
		setParam.put("PRSTMFR", "100000");
		setParam.put("PRSTMTO", "110000");
		
		list = jsonService.searchJson(setParam);			
		//System.out.println(list);
		jsonList.put(setParam.get("CALL")+"List", list);
		
		rtnJson = jsonList.toJSONString(); 
		System.out.println(rtnJson);
		
		//Jsonview - 화면따윈 필요없다!!
        JsonView jv = new JsonView();
        jv.addStaticAttribute("jsonString", rtnJson);

        return jv;		
	}
}
