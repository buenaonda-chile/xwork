package com.denso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.denso.common.util.DataConverter;
import com.denso.common.util.MiPlatformView;
import com.denso.param.LoginParam;
import com.denso.service.intf.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	/**
	 * 로그인 요청
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) {

		return "login/login";
	}

	/**
	 * 로그인 체크
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param command
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login/checkLogin", method = RequestMethod.POST)
	public String checkLogin(Model model, HttpServletRequest request,
			HttpServletResponse response, LoginParam command) throws Exception {

		String ldapUser = checkUserInfo(command.getUserId());
		String ldapPass = checkUserInfo(command.getPassword());

		HashMap<String, String> userLoginLog = new HashMap<String, String>();
		userLoginLog.put("USERID", ldapUser);
		userLoginLog.put("USERPASS", ldapPass);
		
		//Cookie[] cookies = request.getCookies();	
		//String resultPwfcReset = "";
		//String resultPassYn = "";
		//String resultMessage ="";
		// DIONE 등록 여부 확인
		try {
			Map<String, String> userInfo = loginService.checkLogin(command.getUserId().toUpperCase().toString());
			if (userInfo != null){
				// Session 정보 입력
				this.setSessinoInfo(request, userInfo);
				//setLoginHistory("STATUS", "A", userLoginLog);
				if(!command.getPassword().equals(userInfo.get("PASSWORD"))){
					setResultMessage(model, command.getUserId(), "비밀번호를 확인해 주세요.");
					return "login/login";	
				}
				/* 원본
				if(!command.getPassword().equals(userInfo.get("PASSWORD"))){
					if(userInfo.get("PWFC").equals("0")){
						resultMessage = "비밀번호를 확인해 주세요" ;
					} else {
						resultMessage = "비밀번호를 확인해 주세요   [ " +  userInfo.get("PWFC") + "회이상 오류시차단]" ;
					}

					for(int i=0;i<cookies.length;i++){
						if(cookies[i].getName().equals("pwfcCount")){
							if(cookies[i].getValue().equals(userInfo.get("PWFC"))){
							    dao.updateData("login.pwfcOver",command.getUserId());		
								resultMessage = "계정이 차단되었습니다.[입력횟수 초과]       전산관리자에게 문의하세요"  ;
								resultPwfcReset = "Y";
							}
						}
					}
				}
				*/
			}
		}catch (Exception e) {//nullponException 
			setResultMessage(model, command.getUserId(), "DIONE 등록되지 않은 사용자입니다.");
			return "login/login";
			/*
			String resultMessage = "DIONE 등록되지 않은 사용자입니다.";
			System.out.println("접속에 실패 했습니다.");
			setResultMessage(model, command.getUserId(), resultMessage);
			return "login/login";
			*/	
		}						
		return "init/miInstall";
		
		
/*			
		try {

			// 로그인 정보 체크
			Map<String, String> userInfo = loginService.checkLogin(command.getUserId().toUpperCase().toString());

			// DIONE 등록 여부 확인
			if (userInfo == null & userInfo.get("USER_ID") == null & userInfo.get("USER_ID").equals("")) {
				//setLoginHistory("STATUS", "D", userLoginLog);
				setResultMessage(model, command.getUserId(), "DIONE 등록되지 않은 사용자입니다.");
				return "login/login";
			}

			HashMap<String, String> keyData = new HashMap<String, String>();
			keyData.put("LIB3", loginService.getLibraryCode(command.getUserId().toUpperCase()));
			keyData.put("SABUN", command.getUserId().toUpperCase().substring(1));

			// Session 정보 입력
			this.setSessinoInfo(request, userInfo);
			//setLoginHistory("STATUS", "A", userLoginLog);

		} catch (Exception e) {

			String resultMessage = "Window AD 등록되지 않은 사용자입니다. ID/Password확인바랍니다.";

			System.out.println("LDAP 접속에 실패 했습니다.");

			if (ldapUser == "xxxxxxx") {
				resultMessage = "DIONE 신규설치로 재접속이 필요합니다.";
			} else {
				setLoginHistory("STATUS", "X", userLoginLog);
			}

			setResultMessage(model, command.getUserId(), resultMessage);
			return "login/login";
		}

		return "init/miInstall";
*/
	} // end of checkLogin

	/**
	 * 결과 메세지 정보 셋팅
	 * 
	 * @param model
	 * @param userId
	 * @param message
	 */
	private void setLoginHistory(String key, String value,
			HashMap<String, String> userLoginLog) {
		userLoginLog.put("STATUS", "H");
		loginService.insertLoginHistory(userLoginLog);
	}

	/**
	 * 결과 메세지 정보 셋팅
	 * 
	 * @param model
	 * @param userId
	 * @param message
	 */
	private void setResultMessage(Model model, String userId, String message) {
		model.addAttribute("userId", userId);
		model.addAttribute("resultMessage", message);
		model.addAttribute("resultPwfcReset", "");
		model.addAttribute("resultPassYn", "");
	}

	/**
	 * 유저 아이디/패스워드 정보 확인
	 * 
	 * @param temp
	 * @return
	 */
	private String checkUserInfo(String temp) {
		if (temp == null) {
			temp = "xxxxxxx";
		}
		return temp;
	}

	/**
	 * 세션 정보 입력
	 * 
	 * @param request
	 * @param userInfo
	 */
	private void setSessinoInfo(HttpServletRequest request,
			Map<String, String> userInfo) {
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(60 * 20);
		session.setAttribute("userInfo", userInfo);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Global/1)전체메뉴조회
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 	
	//@RequestMapping(value="/login/getMenuList", method=RequestMethod.POST)
	/*
	public void getMenuList(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{

		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);
		List<HashMap<String, String>> menuList = loginService.getMenuList(pData);

		ModelMap map = new ModelMap();
		map.addAttribute("G_ds_menu", menuList);
		new MiPlatformView().render(map, request, response);
	}
	*/
	@RequestMapping(value="/login/getMenuList", method=RequestMethod.POST)
	public void getMenuList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> menuList = loginService.getMenuList(pData);

		map.addAttribute("G_ds_menu", menuList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Global/ 2)등록된 메세지 조회
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 	
	@RequestMapping(value="/login/getComMsgList", method=RequestMethod.POST)
	public void getComMsgList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> comMsgList = loginService.getComMsgList(pData);

		map.addAttribute("G_ds_message", comMsgList);
		new MiPlatformView().render(map, request, response);
	}
	//3)사용자 등록 LEFT메뉴 조회(관리자용)	
	/*
	@RequestMapping(value="/login/getMenuAuthList", method=RequestMethod.POST)
	public void getMenuAuthList(HttpServletRequest request,HttpServletResponse response,Model model) throws Exception{
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);
		List<HashMap<String, String>> menuAuthList = loginService.getMenuAuthList(pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuAuth", menuAuthList);
		new MiPlatformView().render(map, request, response);
	}
	*/
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Global/ 4)LEFT TOP메뉴 조회
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 
	@RequestMapping(value="/login/getLeftTopMenuList", method=RequestMethod.POST)
	public void getLeftTopMenuList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> leftTopMenuList = loginService.getLeftTopMenuList(pData);

		map.addAttribute("ds_leftTopMenu", leftTopMenuList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Global/ 5)LEFT 즐겨찾기조회
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 	
	@RequestMapping(value="/login/getBookMarkList", method=RequestMethod.POST)
	public void getBookMarkList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> bookMarkList = loginService.getBookMarkList(pData);

		map.addAttribute("G_ds_menu", bookMarkList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Global/ 6)사업부코드조회
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 	
	@RequestMapping(value="/login/getComCodeList", method=RequestMethod.POST)
	public void getComCodeList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> comCodeList = loginService.getComCodeList(pData);

		map.addAttribute("ds_ComCode_" + pData.get("CLASS") , comCodeList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Global/ 7)권한조회
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 	
	@RequestMapping(value="/login/getBtnAuthList", method=RequestMethod.POST)
	public void getBtnAuthList(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> btnAuthList = loginService.getBtnAuthList(pData);

		map.addAttribute("ds_btnAuth", btnAuthList);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Global/ 8)패스워드변경
	 * @exception 
	 * @see 
	 * 	- 2015-04-16	:	제환복
	***********************************************************************/ 	
	@RequestMapping(value="/login/getPassWordChange", method=RequestMethod.POST)
	public void getPassWordChange(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> passWordChangeDay = loginService.getPassWordChange(pData);

		map.addAttribute("ds_pwChangeDay", passWordChangeDay);
		new MiPlatformView().render(map, request, response);
	}
	@RequestMapping(value="/login/setPassWordChang/{type}", method=RequestMethod.POST)
	public void setPassWordChang(@PathVariable String type, HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		/*
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List<HashMap<String, String>> pList = DataConverter.getMiPlatformMultiData(pReq, "ds_pwChangeDay");
		*/
		List<HashMap<String, String>> pList = null;
		if ("change1".equals(type)) {
			pList = DataConverter.getMiPlatformMultiData(request, "ds_password");
			loginService.setPassWordChang1(pList);
		} else if ("change2".equals(type)) {
			pList = DataConverter.getMiPlatformMultiData(request, "ds_password2");
			loginService.setPassWordChang2(pList);
		}
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Global/ 공지사항
	 * @exception 
	 * @see 
	 * 	- 2015-06-17	:	제환복
	***********************************************************************/ 	
	@RequestMapping(value="/login/getUserNotice", method=RequestMethod.POST)
	public void getUserNotice(HttpServletRequest request,HttpServletResponse response,ModelMap map) throws Exception{
		HashMap<String, String> pData = DataConverter.getMiPlatformData(request);
		List<HashMap<String, String>> userNotice = loginService.getUserNotice(pData);

		map.addAttribute("ds_userNotice", userNotice);
		new MiPlatformView().render(map, request, response);
	}
}
