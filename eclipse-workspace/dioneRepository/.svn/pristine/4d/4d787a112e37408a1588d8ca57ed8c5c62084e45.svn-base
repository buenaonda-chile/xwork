package com.denso.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.denso.common.util.DataConverter;
import com.denso.common.util.MiPlatformView;
import com.denso.service.intf.SystemService;
import com.tobesoft.platform.PlatformRequest;

@Controller
@RequestMapping(value="/system")
public class SystemController {
	
	@Autowired
	SystemService systemService;

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  LEFT Menu/사용자 권한조회(Loading시)
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 
	@RequestMapping(value="/getMenuAuthList", method=RequestMethod.POST)
	public void getMenuAuthList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> menuAuthList = systemService.getMenuAuthList(pData);

		map.addAttribute("ds_menuAuth", menuAuthList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setMenuAuth", method=RequestMethod.POST)
	public void setMenuAuth(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(request, "ds_menuAuth");
		systemService.setMenuAuth(pList);
		new MiPlatformView().render(null, request, response);
	}
	@RequestMapping(value="/setMenuLog", method=RequestMethod.POST)
	public void setMenuLog(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(request, "ds_menuLog");
		systemService.setMenuLog(pList);
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  TOP Menu/즐겨찾기추가
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 	
	@RequestMapping(value="/setBookMark", method=RequestMethod.POST)
	/*
	public void setBookMark(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_bookMark");
		systemService.setBookMark(pList);
		new MiPlatformView().render(null, request, response);
	}
	 */
	public void setBookMark(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(request, "ds_bookMark");
		systemService.setBookMark(pList);
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- [공통]시스템관리/사용자관리
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 
	@RequestMapping(value="/getUserList", method=RequestMethod.POST)
	public void getUserList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> userList = systemService.getUserList(pData);

		map.addAttribute("ds_userList", userList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getUserListAll", method=RequestMethod.POST)
	public void getUserListAll(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> userListAll = systemService.getUserList(pData);

		map.addAttribute("ds_userList_dummy", userListAll);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setUserList", method=RequestMethod.POST)
	public void setUserList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{

 		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_userList");
/*
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(request, "ds_userList");
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(request);
		pArg=null;
*/		
		systemService.setUserList(pArg, pList);

		/*
		String modifyUser = (String)pArg.get("CREATE_USER");
		Iterator it = pList.iterator();
		while (it.hasNext()) {
			HashMap<String, String> pData = (HashMap<String, String>) it.next();
			pData.put("CREATE_USER", modifyUser);
			systemService.setUserList(pData);
		}
		*/
		new MiPlatformView().render(null, request, response);

	}
	//버튼권한
	@RequestMapping(value="/getButtonAuthList", method=RequestMethod.POST)
	public void getButtonAuthList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> buttonAuthList = systemService.getButtonAuthList(pData);

		map.addAttribute("ds_buttonAuth", buttonAuthList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setButtonAuth", method=RequestMethod.POST)	
	public void setButtonAuth(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(request, "ds_buttonAuth");
		systemService.setButtonAuth(pList);
		new MiPlatformView().render(null, request, response);
	}
	//즐겨찾기
	@RequestMapping(value="/getFavoriteAuthList", method=RequestMethod.POST)
	public void getFavoriteAuthList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> favoriteAuthList = systemService.getFavoriteAuthList(pData);

		map.addAttribute("ds_favorite", favoriteAuthList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setFavoriteAuth", method=RequestMethod.POST)	
	public void setFavoriteAuth(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(request, "ds_favorite");
		systemService.setFavoriteAuth(pList);
		new MiPlatformView().render(null, request, response);
	}
	//사용자조회
	@RequestMapping(value="/getEmployList", method=RequestMethod.POST)
	public void getEmployList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> employList = systemService.getEmployList(pData);

		map.addAttribute("ds_selUser", employList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- [공통]시스템관리/시스템메뉴관리
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 	
	@RequestMapping(value="/getMenuAuthGroupList", method=RequestMethod.POST)
	public void getMenuAuthGroupList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{		
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> menuAuthGroupList = systemService.getMenuAuthGroupList(pData);

		map.addAttribute("ds_menuAuthGroup", menuAuthGroupList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getUpMenuCodeList", method=RequestMethod.POST)
	public void getUpMenuCodeList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> upMenuCodeList = systemService.getUpMenuCodeList(pData);

		map.addAttribute("ds_upMenuCode", upMenuCodeList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getTopMenuCodeList", method=RequestMethod.POST)
	public void getTopMenuCodeList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{

		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> topMenuCodeList = systemService.getTopMenuCodeList(pData);

		map.addAttribute("ds_topMenuCode", topMenuCodeList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getMenuList", method=RequestMethod.POST)
	public void getMenuList(HttpServletRequest request,HttpServletResponse response, ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> menuList = systemService.getMenuList(pData);

		map.addAttribute("ds_menuList", menuList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setMenuList", method=RequestMethod.POST)
/*
	public void setMenuList(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{

		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_menuList");
		//HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);
		//System.out.println(pList);		
		systemService.setMenuList(pList);
		new MiPlatformView().render(null, request, response);
	}		
*/	
	public void setMenuList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(request, "ds_menuList");
		//HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);
		//System.out.println(pList);		
		systemService.setMenuList(pList);
		new MiPlatformView().render(null, request, response);
	}
	
	// [공통 코드 관리] 조회
	@RequestMapping(value = "/getComCode/{type}")
	public void getComCode(@PathVariable String type, HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception {

		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> list = null;

		if ("code".equals(type)) {
			list = systemService.getComCode(pData);
			map.addAttribute("ds_ComCode", list);
		} else if ("class".equals(type)) {
			list = systemService.getComCodeClass(pData);
			map.addAttribute("ds_ComCodeClass", list);
		}

		new MiPlatformView().render(map, request, response);
	}

	// [공통 코드 관리] 등록 및 업데이트
	@RequestMapping(value = "/comCodeSave", method = RequestMethod.POST)	
	public void comCodeSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(request, "ds_ComCode");
		systemService.saveComCode(pList);
		new MiPlatformView().render(null, request, response);
	}
	
	// [메세지 관리] 조회
	@RequestMapping(value = "/getMessage", method = RequestMethod.POST)	
	public void getMessage(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception {		
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> list = systemService.getMessage(pData);

		map.addAttribute("ds_message", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	// [공통 코드 관리] 등록 및 업데이트
	@RequestMapping(value = "/saveMessage", method = RequestMethod.POST)	
	public void saveMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(request, "ds_message");
		systemService.saveMessage(pList);
		new MiPlatformView().render(null, request, response);
	}
	
	// [메세지 관리] 조회
	@RequestMapping(value = "/getMenuLog", method = RequestMethod.POST)	
	public void getMenuLog(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception {		
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> list = systemService.getMenuLog(pData);

		map.addAttribute("ds_menuLog", list);
		new MiPlatformView().render(map, request, response);
	}
	//공지사항
	@RequestMapping(value="/getNoticeList", method=RequestMethod.POST)
	public void getNoticeList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> noticeList = systemService.getNoticeList(pData);

		map.addAttribute("ds_notice", noticeList);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/setNoticeList", method=RequestMethod.POST)	
	public void setNoticeList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{

 		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		HashMap<String, String> pArg = DataConverter.getMiPlatformData(pReq);
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_notice");
		systemService.setNoticeList(pArg, pList);
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 공통사용/공통팝업
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 
	@RequestMapping(value="/getFSA120PF", method=RequestMethod.POST)
	public void getFSA120PF(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> fSA120PF = systemService.getFSA120PF(pData);

		map.addAttribute("ds_Select", fSA120PF);
		new MiPlatformView().render(map, request, response);
	}
	/* 경비예산*/
	@RequestMapping(value="/getMIZ221PF", method=RequestMethod.POST)
	public void getMIZ221PF(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZ221PF = systemService.getMIZ221PF(pData);

		map.addAttribute("ds_Select", mIZ221PF);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/getMIZ220PF", method=RequestMethod.POST)
	public void getMIZ220PF(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> mIZ220PF = systemService.getMIZ220PF(pData);

		map.addAttribute("ds_Select", mIZ220PF);
		new MiPlatformView().render(map, request, response);
	}
}
