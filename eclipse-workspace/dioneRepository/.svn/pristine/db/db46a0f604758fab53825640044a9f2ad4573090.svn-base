package com.denso.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.denso.common.util.DataConverter;
import com.denso.common.util.MiPlatformView;
import com.denso.common.vo.AjaxResult;
import com.denso.param.BarcodeParam;
import com.denso.param.CodeInqueryParam;
import com.denso.service.intf.BarcodeService;
import com.tobesoft.platform.PlatformRequest;

@Controller
@RequestMapping(value="/barcode")//대소문자 구분함
public class BarcodeController {

	public Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	BarcodeService barcodeService;

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  QR발행: ETC
	 * @see
	 * 	- 2013-11-07	:	LSK
	***********************************************************************/
	@RequestMapping(value="/setSleepTime", method = {RequestMethod.GET, RequestMethod.POST})
	public void setSleepTime(HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		Integer sleepTime = 0;

		if(pData.get("SLEEPTIME") != null){
			sleepTime = Integer.parseInt((String)pData.get("SLEEPTIME"));
		}
		Thread.sleep(sleepTime);
		
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  QR발행: DNKE/KA사내용 TAG발행(공통)_FPQC100Q&FPQE110Q
	 * @see
	 * 	- 2013-11-07	:	LSK
	***********************************************************************/
	@RequestMapping(value="/selectFPQZ100Q/{type}", method = {RequestMethod.GET, RequestMethod.POST})
	public void selectFPQZ100Q(@PathVariable String type, HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList =null;
		if ("detail".equals(type) || "report".equals(type)) {
			pList = DataConverter.getMiPlatformMultiData(pReq, "ds_LOAD");//data set
		}
/*
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);//Argument
		List<HashMap<String, String>> pList =null;
*/		
		
		String getComps="";
		List<HashMap<String, String>> list = null;
		if ("list1".equals(type)) {	//공통(KE/KA) 공정코드조회
			list = barcodeService.getFPQZ100Qlist_type1(pData);
			map.addAttribute("ds_FPQC100Q_1", list);
		} else if ("list4".equals(type)) {	//공통(KE/KA) 바코드발행list조회
			list = barcodeService.getFPQZ100Qlist_type4(pData);
			map.addAttribute("ds_FPQC100Q_4", list);
		} else if ("detail".equals(type)) {	//공통(KE/KA) 바코드발행list 상세조회
			//pList = DataConverter.getMiPlatformMultiData(request, "ds_LOAD");//data set
			list = barcodeService.getFPQZ100Qlist_detail(pData, pList);
			map.addAttribute("ds_FPQC100QD", list);
		}else if ("report".equals(type)) {	//바코드발행
			getComps=(String)pData.get("COMPS");
			if(getComps.equals("E1")){
				//pList = DataConverter.getMiPlatformMultiData(request, "ds_LOAD");//data set
				list = barcodeService.getFPQE110Qlist_report(pData, pList);	//KE
				map.addAttribute("ds_FPQE110QR", list);
			}else{
				//pList = DataConverter.getMiPlatformMultiData(request, "ds_LOAD");//data set
				list = barcodeService.getFPQC100Qlist_report(pData, pList);	//KA		
				map.addAttribute("ds_FPQC100QR", list);
			}
			//pList = DataConverter.getMiPlatformMultiData(request, "ds_LOAD");//data set
			//list = barcodeService.getFPQC100Qlist_report(pData, pList);
		}
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  QR발행: DNKE사내용 PART라벨 TAG발행
	 * @see
	 * 	- 2013-11-07	:	LSK
	***********************************************************************/
	@RequestMapping(value="/selectFPQE140Q/{type}", method = {RequestMethod.GET, RequestMethod.POST})
	public void selectFPQE140Q(@PathVariable String type, HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList =null;
		if ("detail".equals(type) || "report".equals(type)) {
			pList = DataConverter.getMiPlatformMultiData(pReq, "ds_LOAD");//data set
		}

		
		List<HashMap<String, String>> list = null;
		if ("list1".equals(type)) {	//공통(KE/KA) 공정코드조회
			list = barcodeService.getFPQZ100Qlist_type1(pData);
			map.addAttribute("ds_FPQC100Q_1", list);
		} else if ("list4".equals(type)) {	//DNKE 사내용 PART LABEL 발행 (우측조회)
			list = barcodeService.getFPQE140Qlist_type4(pData);
			map.addAttribute("ds_FPQE140Q_4", list);
		} else if ("737PF".equals(type)) {	//DNKE 사내용 PART LABEL 발행 (품번별 label번호 저장)
			list = barcodeService.getFPQE140Qlist_seq(pData);
			map.addAttribute("ds_FPQE140Q_737PF", list);
		
			this.setBarcodeStatus(request, pData, list, map); //바코드 상태 업데이트하기
			
		}
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  QR발행: DNKE사내용 ID라벨 TAG발행
	 * @see
	 * 	- 2013-11-07	:	LSK
	***********************************************************************/
	@RequestMapping(value="/selectFPQE150Q/{type}", method = {RequestMethod.GET, RequestMethod.POST})
	public void selectFPQE150Q(@PathVariable String type, HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList =null;
		if ("detail".equals(type) || "report".equals(type)) {
			pList = DataConverter.getMiPlatformMultiData(pReq, "ds_LOAD");//data set
		}

		List<HashMap<String, String>> list = null;
		if ("list1".equals(type)) {	//ID LABEL 공정코드조회
			list = barcodeService.getFPQE150Qlist_type1(pData);
			map.addAttribute("ds_FPQE150Q_1", list);
		} else if ("list4".equals(type)) {	//DNKE 사내용 ID LABEL 발행 (우측조회)
			list = barcodeService.getFPQE150Qlist_type4(pData);
			map.addAttribute("ds_FPQE150Q_4", list);
		} else if ("767PF".equals(type)) {	//DNKE 사내용 PART LABEL 발행 (품번별 label번호 저장)
			list = barcodeService.getFPQE150Qlist_seq(pData);
			map.addAttribute("ds_FPQE150Q_767PF", list);
			
			this.setBarcodeStatus(request, pData, list, map); //바코드 상태 업데이트하기
		}
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  QR발행: DNKA사내용 PART라벨 TAG발행
	 * @see
	 * 	- 2015-05-28	:	JHB
	***********************************************************************/
	@RequestMapping(value="/selectFPQC140Q/{type}", method = {RequestMethod.GET, RequestMethod.POST})
	public void selectFPQC140Q(@PathVariable String type, HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList =null;
		if ("detail".equals(type) || "report".equals(type)) {
			pList = DataConverter.getMiPlatformMultiData(pReq, "ds_LOAD");//data set
		}

		//System.out.println(pData);
		//System.out.println(pList);
		
		List<HashMap<String, String>> list = null;
		if ("list1".equals(type)) {	//공통(KE/KA) 공정코드조회
			list = barcodeService.getFPQZ100Qlist_type1(pData);
			map.addAttribute("ds_FPQC100Q_1", list);
		} else if ("list4".equals(type)) {	//DNKE 사내용 PART LABEL 발행 (우측조회)
			list = barcodeService.getFPQC140Qlist_type4(pData);
			map.addAttribute("ds_FPQC140Q_4", list);
		} else if ("737PF".equals(type)) {	//DNKE 사내용 PART LABEL 발행 (품번별 label번호 저장)
			list = barcodeService.getFPQC140Qlist_seq(pData);
			map.addAttribute("ds_FPQC140Q_737PF", list);
		}
		new MiPlatformView().render(map, request, response);
	}
	
	/*
	// 바코드 상태 값 셋팅
	@RequestMapping(value="/setPrintStatus", method = {RequestMethod.GET, RequestMethod.POST})
	public void setPrintStatus(HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
		barcodeStatus = "ING";
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);//Argument
		
		Integer sleepTime = 0;
		if(sleepTime != null){
			sleepTime = Integer.parseInt((String)pData.get("sleepTime"));
		}
		Thread.sleep(sleepTime);
		System.out.println("j =" + j);
		System.out.println("sqn =" + sqn);
		String j = pData.get("j");
		String sqn =pData.get("sqn");
		this.j = j;
		this.sqn =sqn;

		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("flag", barcodeStatus);
		list.add(hm);
		System.out.println("barcodeStatusbarcodeStatusbarcodeStatusbarcodeStatus=="+barcodeStatus);
		map.addAttribute("statusFlag", list);
		
		new MiPlatformView().render(map, request, response);
	}
	*/
	/*	미사용~~
	@RequestMapping(value="/selectFPQC100Q_report", method = {RequestMethod.GET, RequestMethod.POST})
	public void selectFPQC100Q_report(HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);//Argument
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_LOAD");//data set
		List<HashMap<String, String>> list = barcodeService.getFPQC100Qlist_report(pData, pList);
		System.out.println(list);
		map.addAttribute("ds_FPQC100QR", list);
		new MiPlatformView().render(map, request, response);
	}

	@RequestMapping(value="/selectFPQC100Q_detail", method = RequestMethod.POST)
	public void selectFPQC100Q_detail(HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{

 
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();	
		HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);//Argument

		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_LOAD");//data set
		
		System.out.println(pList);
		List<HashMap<String, String>> list = barcodeService.getFPQC100Qlist_detail(pData, pList);
		map.addAttribute("ds_FPQC100QD", list);
		new MiPlatformView().render(map, request, response);

	}
    */
	
	/** 바코드 상태값 (static) */
	private static HashMap<String,HashMap<String,String>> staticMap = new HashMap<String, HashMap<String,String>>();

	/** 바코드 정지 상태 (static) */
	private static String printStop ="ING";
	
	// 바코드 상태 화면 표시 (JSP 호출)
	@RequestMapping(value="/status/{sessionId}", method = {RequestMethod.GET, RequestMethod.POST})
	public String barcodeStatus(HttpServletRequest request,Model model, @PathVariable String sessionId){
		
		model.addAttribute("sessionId",sessionId);

		return "/barcode/display";
	}
	
	// 바코드 상태 조회 (바코드 JSP → 상태값 호출)
	@RequestMapping(value="/ajaxStatus", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult ajaxStatus(CodeInqueryParam regParam,Model model, HttpServletRequest request, BarcodeParam param){
		AjaxResult ajaxResult = new AjaxResult();
		
		try {
			String sessionId = param.getSessionId();
			
			if(staticMap.get(sessionId) != null){
				HashMap<String, String> resMap = staticMap.get(sessionId);
				ajaxResult.setResult(resMap);
			}
			
			ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
			ajaxResult.setMsg("정상처리되었습니다.");
			
		} catch (Exception e) {
			ajaxResult.setCode(AjaxResult.FAIL_CODE);
			ajaxResult.setMsg("실패하였습니다.");
		}
		
		return ajaxResult;
	}
		
	// 바코드 프로그램 정지 (miplatform 바코드 정지)
	@RequestMapping(value="/printStop", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult printStop(BarcodeParam param,Model model){
		this.setPrintStop("STOP");
		return new AjaxResult();
	}

	// 바코드 상태값 조회
	private void setBarcodeStatus(HttpServletRequest request, HashMap<String, String> pData, List<HashMap<String, String>> list, ModelMap map){
		String bcsid = pData.get("BCSID");
		String sqn = "";
		for (HashMap<String, String> hashMap : list) {
			sqn = hashMap.get("LSEQN").toString();
		}			
		pData.put("SQN", sqn);//SQN
		// 세션별 상태값 저장
		staticMap.put(bcsid, pData);
		
		map.addAttribute("barcodeStatus", this.setPrintStatus());
		
		setPrintStop("ING"); //바코드 정지상태 초기화

		logger.debug("바코드 조회 화면 세션 ID : " + bcsid);
	}
	
	// 바코드 중지
	private List<HashMap<String, String>> setPrintStatus(){
		// 프린터 중지 status
		List<HashMap<String, String>> reslist = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> resMap = new HashMap<String,String>();
		resMap.put("flag", printStop);
		
		reslist.add(resMap);
		return reslist;
	}

	private void setPrintStop(String status){
		printStop = status;
	}
}
