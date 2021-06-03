/********************************************************************** 
 * @version              		 			: 1.0 
 * @author               		 			: 황규철
 * @see 
 * ● SYSTEM NAME          			: DIONE
 * ● PROGRAM NO.          			: LoginController.java
 * ● PROGRAM DESCRIPTION  	: 로그인 처리 컨트롤러
 * ● DATE WRITTEN        				: 2010.11.26
 ********************************************************************** 
 * ● REVISION HISTORY
 * ● 2010.11.26							:  황규철
 */ 

package com.denso.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Enumeration;
import java.util.Set;
import java.io.*;
import java.net.*;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.denso.common.converter.DataConverter;
import com.denso.common.converter.MiPlatformView;
import com.denso.common.dao.CommonDAO;
import com.tobesoft.platform.PlatformRequest;


public class LoginController extends MultiActionController {
	CommonDAO dao = CommonDAO.getInstance(1);

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return new ModelAndView("login/login");
	}
	
	public ModelAndView login2(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return new ModelAndView("login/miInstall");
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			: 
	 * 	- LoginCommand command				: html 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:  resultMessage
	 * @hint
	 * 	- 로그인 체크
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		


	
	public ModelAndView checkLogin(HttpServletRequest request, HttpServletResponse response, LoginCommand command) throws Exception {	
		
		Cookie[] cookies = request.getCookies();		
		String resultPwfcReset = "";
		String resultPassYn = "";
		
		Map userInfo = (Map)dao.getReadData("login.checkLogin",command.getUserId());		
		String resultMessage = "등록되지 않은 사용자입니다.";
		if(userInfo!=null && userInfo.get("USER_ID")!=null && !userInfo.get("USER_ID").equals("")){
			if(command.getPassword().equals(userInfo.get("PASSWORD"))){
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(60*20);
				session.setAttribute("userInfo", userInfo);
				
				System.out.println("=======NOTICE_YN==========" + userInfo.get("NOTICE_YN"));
				System.out.println("=======CUT_YN==========" + userInfo.get("CUT_YN"));
				System.out.println("=======CHANGE_DAT==========" + userInfo.get("CHANGE_DAT"));
				
				if(userInfo.get("NOTICE_YN").equals("Y")){
					resultMessage = "[" +  userInfo.get("CHANGE_DAT") + "]일 까지 비밀번호를 변경하지 않으면 계정이 차단됨일 알려드립니다."  ;
					resultPassYn = "Y";
				}				
				
				if(userInfo.get("CUT_YN").equals("Y")){
					dao.updateData("login.pwfcOver",command.getUserId());
					resultMessage = "계정이 차단되었습니다.[변경기간 초과]        전산관리자에게 문의하세요"  ;
					resultPassYn = "";					
				}	

				if(userInfo.get("CUT_YN").equals("N") ){
					if(userInfo.get("NOTICE_YN").equals("N")){
						return new ModelAndView("login/miInstall");
					} 
				} 

			}else{
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
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		mav.addObject("userId", command.getUserId());
		mav.addObject("resultMessage", resultMessage);
		mav.addObject("resultPwfcReset", resultPwfcReset);
		mav.addObject("resultPassYn", resultPassYn);
		return mav;
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메뉴리스트  tree view용
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void menu(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.menu", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("G_ds_menu", list);
		new MiPlatformView().render(map, request, response);
	}
	


	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 즐겨찾기 리스트  tree view용
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void bookMark(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.bookMark", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("G_ds_menu", list);
		new MiPlatformView().render(map, request, response);
	}
		
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 즐겨찾기 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void saveBookMark(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_bookMark");
		Iterator it = pList.iterator();
		String rowType="";
		List<Object> deleteList = new ArrayList<Object>();
		while(it.hasNext()){
			Map pData = (Map)it.next();
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.deleteData("login.deletebookMark", pData);
				dao.insertData("login.insertbookMark", pData);
			}else if("update".equals(rowType)){

			}else if("delete".equals(rowType)){
				dao.deleteData("login.deletebookMark", pData);
			}
		}
		if(deleteList.size() > 0){
			System.out.println("deleteList.size()" + deleteList.size());
			Map pData = new HashMap();
			pData.put("deleteList", deleteList);
		}
		new MiPlatformView().render(null, request, response);
	}		

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 내외부 시스템 메뉴권한 조회 (권한 적용)
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void ssoAccounts(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.ssoAccounts", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ssoaccount", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 내외부 시스템 메뉴권한 조회 (권한 적용)_ORDERPROD추가
	 * @exception 
	 * @see
	 * 	- 2012-05-08	:	제환복
	***********************************************************************/ 			
	public void ssoAccounts_order(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.ssoAccounts_OrderProd", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ssoaccount", list);
		new MiPlatformView().render(map, request, response);
	}
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 버튼 권한 조회 (권한 적용)
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void btnAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.btnAuth", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_btnAuth", list);
		new MiPlatformView().render(map, request, response);
	}	
		
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 공통코드 조회 
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectComCode(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.comCode", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ComCode_" + pData.get("CLASS") , list);
		new MiPlatformView().render(map, request, response);
	}		
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메세지조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectComMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.comMessage", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("G_ds_message"  , list);
		new MiPlatformView().render(map, request, response);
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 내외부 시스템 설정 조회(좌측상단)
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/	
	public void selectLeftTopMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.leftTopMenu", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_leftTopMenu"  , list);
		new MiPlatformView().render(map, request, response);
	}	
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사용자 공지사항 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/	
	public void selectUserNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.selectUserNotice", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_userNotice"  , list);
		new MiPlatformView().render(map, request, response);
	}		
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사용자 공지사항 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/	
	public void selectViewNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("login.selectViewNotice", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_viewNotice"  , list);
		new MiPlatformView().render(map, request, response);
	}			
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			: 
	 * 	- LoginCommand command				: html 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:  resultMessage
	 * @hint
	 * 	- AD 로그인 체크
	 * @exception 
	 * @see
	 * 	- 2013-12-26	:	Lee SK
	***********************************************************************/ 		
	@SuppressWarnings("unchecked")
	public ModelAndView checkLoginLdap(HttpServletRequest request, HttpServletResponse response, LoginCommand command) throws Exception {	
		/*dione server system정보가져오기*/
		/*
		Properties pro = System.getProperties ( ); //시스템 정보를 몽땅 갖고 온다.
		Enumeration e1 = pro.propertyNames();
		while(e1.hasMoreElements()) {
			String obj = ( String )e1.nextElement();
			System.out.println(obj + ":"+ System.getProperty(obj ));
		}
		*/
		
		/*사용자ip가져오기*/
		/*
		InetAddress[] local = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
		for(int i=0; i<local.length; i++) {
	         System.out.println("[" + i + "]:" + local[i].getHostAddress());
	         System.out.println("[" + i + "]:" + local[i].getHostName());
	    }
		*/
		
		/* command명령실행하기 */
		/*
		String str;
		Process process = new ProcessBuilder("cmd","/c", "whoami").start();
		BufferedReader stdOut = new BufferedReader( new InputStreamReader(process.getInputStream()) );
		System.out.println(stdOut.readLine());
		// 표준출력 상태를 출력
		while( (str = stdOut.readLine()) != null ) {
		    System.out.println(str);
		}
		*/
		
		Cookie[] cookies = request.getCookies();		
		String resultPwfcReset = "";
		String resultPassYn = "";
		String resultMessage = "Window AD 등록되지 않은 사용자입니다. ID/Password확인바랍니다.";
		
		Hashtable<String, String> ldapEnv = new Hashtable<String, String>();
		String ldapHost = "korea.asia.denso";
		String domain = "korea.asia.denso";
		String port = "389"; // default Port
		String urlDC = "ldap://" + ldapHost+":"+port+"/"; // ldap://korea.asia.denso:389/
		String dcList = "";
		dcList = "DC=" + domain.replaceAll("\\.", ",DC="); // DC=korea,DC=asia,DC=denso
		System.out.println(dcList);
		String ldapUser = command.getUserId();   //"xxxxxxx"
		if(ldapUser==null){
			System.out.println("ldapUser null="+ ldapUser);
			ldapUser="xxxxxxx";
		}	
		String ldapPass = command.getPassword(); //"xxxxxxx"
		if(ldapPass==null){
			System.out.println("ldapPass null="+ ldapPass);
			ldapPass="xxxxxxx";
		}			
		String userName = ldapUser + "@" + domain; // e030191@korea.asia.denso
		
		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		ldapEnv.put(Context.SECURITY_PRINCIPAL, userName);        // e030191@korea.asia.denso
		ldapEnv.put(Context.SECURITY_CREDENTIALS, ldapPass);      // blogspot
		ldapEnv.put(Context.PROVIDER_URL, urlDC);                 // ldap://korea.asia.denso:389/
		ldapEnv.put("com.sun.jndi.ldap.read.timeout", "2000");    // Read Timeout 설정
		ldapEnv.put("com.sun.jndi.ldap.connect.timeout", "2000");// Connect Timeout 설정

		LdapContext ctx = null;
		//InitialDirContext ctx = null;
		
		HashMap userLoginLog = new HashMap();
		userLoginLog.put("USERID", ldapUser);
		userLoginLog.put("USERPASS", ldapPass);
		
		//신규추가 2017.12.20 jhb 
	    
		try {
			ctx = new InitialLdapContext(ldapEnv, null);
			System.out.println("LDAP 접속에 성공 했습니다.");
						
			//ctx = new InitialDirContext(ldapEnv);

			System.out.println("CTX=="+ctx);
			
			String sAttribs[] = {"cn","company", "department", "displayName", "name", "title", "mail", "lockoutTime"};
			
			SearchControls sc = new SearchControls();
			sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
			
			sc.setReturningAttributes(sAttribs);
			 
			String searchFilter = "sAMAccountName="+ldapUser;	//조회대상
			
			NamingEnumeration lrlts = ctx.search(dcList, searchFilter, sc);
			while(lrlts.hasMoreElements()){
			   	SearchResult srd = (SearchResult) lrlts.next();
			   	Attributes attrs =  srd.getAttributes();
			   	System.out.println("attrobute:"+attrs);
			   	System.out.println("attrobute1:"+attrs.get("cn"));	    	
		   }
		   System.out.println("LDAP 조회에 성공 했습니다.");	
			
			Map userInfo1 = (Map)dao.getReadData("login.checkLoginLdap",command.getUserId().toUpperCase());
			//if(userInfo!=null && userInfo.get("USER_ID")!=null && !userInfo.get("USER_ID").equals("")){   -->NullPointerException발생으로 분리
			if(userInfo1!=null){
				if(userInfo1.get("USER_ID")!=null && !userInfo1.get("USER_ID").equals("")){
					String lib ="PSEDBLIB";
					if(command.getUserId().toUpperCase().substring(0,1).equals("C")){
						lib = "PSCDBLIB";
					}else if(command.getUserId().toUpperCase().substring(0,1).equals("H")) {
						lib = "PSHDBLIB";
					}else if(command.getUserId().toUpperCase().substring(0,1).equals("S")) {
						lib = "PSSDBLIB";
					}else if(command.getUserId().toUpperCase().substring(0,1).equals("R")) {
						lib = "PSRDBLIB";
					}
					/* 2015.11.18 수정전
					System.out.println(lib);
					System.out.println(command.getUserId().toUpperCase().substring(1));
					HashMap keyData = new HashMap();
					keyData.put("LIB3", lib);
					keyData.put("SABUN", command.getUserId().toUpperCase().substring(1));
					Map userInfo2 = (Map)dao.getReadData("login.checkLoginHUM",keyData);
					if(userInfo2 != null){
						userLoginLog.put("STATUS", "H");
						dao.insertData("login.loginHistory", userLoginLog);
						resultMessage = "인사발령으로 로그인 권한이 없습니다.";
						//resultMessage = userInfo2.get("BALCD").toString()
						//				+" : "+ userInfo2.get("BSDAT").toString()
						//				+"~"+ userInfo2.get("BEDAT").toString()
						//				+" ("+ userInfo2.get("NAYON").toString()+")";
					}else{
						userInfo1.put("LDAPPASS", ldapPass);  //pgm password를 AD password로 변경 2014.03.18
						//Set set = userInfo1.entrySet();
						//System.out.println(set);
						HttpSession session = request.getSession(true);
						session.setMaxInactiveInterval(60*20);
						session.setAttribute("userInfo", userInfo1);
						//System.out.println("close1");			
						userLoginLog.put("STATUS", "A");
						dao.insertData("login.loginHistory", userLoginLog);
						ctx.close();
						return new ModelAndView("login/miInstall");
					}
					*/
					System.out.println(lib);
					System.out.println(command.getUserId().toUpperCase().substring(1));
					HashMap keyData = new HashMap();
					keyData.put("LIB3", lib);
					keyData.put("SABUN", command.getUserId().toUpperCase().substring(1));
					
					/*용역인 경우 휴직자마스타 check예외처리 2015.11.03*/
					//System.out.println(command.getUserId().toUpperCase().substring(1));
					boolean chksabun =true;
							chksabun = StringUtils.isNumeric(command.getUserId().toUpperCase().substring(1)); 
					//System.out.println(chksabun);
					/*==============================================================================*/
					//1.용역이 아닌경우
					if(chksabun==true){
						Map userInfo2 = (Map)dao.getReadData("login.checkLoginHUM",keyData);
						if(userInfo2 != null){
							userLoginLog.put("STATUS", "H");
							dao.insertData("login.loginHistory", userLoginLog);
							resultMessage = "인사발령으로 로그인 권한이 없습니다.";
							//resultMessage = userInfo2.get("BALCD").toString()
							//				+" : "+ userInfo2.get("BSDAT").toString()
							//				+"~"+ userInfo2.get("BEDAT").toString()
							//				+" ("+ userInfo2.get("NAYON").toString()+")";
						}else{
							userInfo1.put("LDAPPASS", ldapPass);  //pgm password를 AD password로 변경 2014.03.18
							//Set set = userInfo1.entrySet();
							//System.out.println(set);
							HttpSession session = request.getSession(true);
							session.setMaxInactiveInterval(60*20);
							session.setAttribute("userInfo", userInfo1);
							//System.out.println("close1");			
							userLoginLog.put("STATUS", "A");
							dao.insertData("login.loginHistory", userLoginLog);
							ctx.close();
							return new ModelAndView("login/miInstall");
						}
					}else{//2.용역인경우 HMD250PF 인사발령내역 체크안함.
						userInfo1.put("LDAPPASS", ldapPass);  //pgm password를 AD password로 변경 2014.03.18
						//Set set = userInfo1.entrySet();
						//System.out.println(set);
						HttpSession session = request.getSession(true);
						session.setMaxInactiveInterval(60*20);
						session.setAttribute("userInfo", userInfo1);
						//System.out.println("close1");			
						userLoginLog.put("STATUS", "A");
						dao.insertData("login.loginHistory", userLoginLog);
						ctx.close();
						return new ModelAndView("login/miInstall");
					}
				}else{
					userLoginLog.put("STATUS", "D");
					dao.insertData("login.loginHistory", userLoginLog);
					resultMessage = "DIONE 등록되지 않은 사용자입니다.";
				}
			}else{
				userLoginLog.put("STATUS", "D");
				dao.insertData("login.loginHistory", userLoginLog);
				resultMessage = "DIONE 등록되지 않은 사용자입니다..";
			}
			
		} catch (Exception e) {
			System.out.println("LDAP 접속에 실패 했습니다.");

			//계정존재 및 잠김체크
			DirContext ctx2 = null;
			Properties props = new Properties();
	
			props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			props.setProperty(Context.SECURITY_AUTHENTICATION, "simple");
			props.setProperty(Context.SECURITY_PRINCIPAL, "administrator@korea.asia.denso");        // e030191@korea.asia.denso
			props.setProperty(Context.SECURITY_CREDENTIALS, "denso_1001");      // blogspot
			props.setProperty(Context.PROVIDER_URL, urlDC);                 // ldap://korea.asia.denso:389/
			props.setProperty("com.sun.jndi.ldap.read.timeout", "2000");    // Read Timeout 설정
			props.setProperty("com.sun.jndi.ldap.connect.timeout", "2000");// Connect Timeout 설정
			props.setProperty(Context.REFERRAL,"follow");	// referral에러 방지

			ctx2 = new InitialDirContext(props);
			
			SearchControls sc = new SearchControls();
			sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
			String searchFilter = "cn="+ldapUser;	//조회대상
			String searchCn="";
			String searchLock="0";
			try {
				NamingEnumeration lrlts = ctx2.search(dcList, searchFilter, sc);
				while (lrlts != null && lrlts.hasMore()) {
					SearchResult dirObject = (SearchResult) lrlts.next();
					Attributes attrs = dirObject.getAttributes();
					if(attrs != null){
						System.out.println(attrs.get("cn"));
						System.out.println(attrs.get("lockoutTime"));
						searchCn=attrs.get("cn").toString();
						searchLock=attrs.get("lockoutTime").toString();
						System.out.println(searchLock.length());
					}
				}
				System.out.println("==end====");
			} catch (Exception e2) {
				System.out.println("Exc2==="+e2);
				// TODO: handle exception
			}			
			if(searchCn.equals("")){	//계정이 없는 경우
				resultMessage = "Window AD에 등록되지 않은 사용자입니다.";
				//AD계정추가
				//start
				/*
			    Attributes attrs = new BasicAttributes(true);
			    Attribute objclass = new BasicAttribute("objectclass");
			    objclass.add("top");
			    objclass.add("extensible");
			    attrs.put(objclass);
			    
			    Hashtable<String, String> env = new Hashtable<String, String>();
			    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
			    env.put(Context.PROVIDER_URL, "yourURL");

			    DirContext ctx3 = new InitialDirContext(env);
			    Context entry = ctx3.createSubcontext("cn=Sample", attrs);
				*/
				//end
			}else{
				if(searchLock.length() >14 ){	//계정이 잠긴 경우
					resultMessage = "계정이 잠겼습니다. 3분후 다시 시도하세요.";				
				}else{
					resultMessage = "잘못된 Password입니다.";
				}
			}
			
			if(ldapUser=="xxxxxxx"){
				resultMessage = "DIONE 신규설치로 재접속이 필요합니다.";
			}else{
				userLoginLog.put("STATUS", "X");
				dao.insertData("login.loginHistory", userLoginLog);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		mav.addObject("userId", command.getUserId());
		mav.addObject("resultMessage", resultMessage);
		mav.addObject("resultPwfcReset", resultPwfcReset);
		mav.addObject("resultPassYn", resultPassYn);
		return mav;
		/*
		int pageSize = 1000;
		String objAttribs[] = {"cn","displayName","name"}; // 조회할 칼럼명을 배열에 입력
		ctx.setRequestControls(new Control[] {new PagedResultsControl(pageSize, true)});	
		SearchControls srchInfo = new SearchControls();	
     	
		srchInfo.setSearchScope(SearchControls.SUBTREE_SCOPE);	
		         	
		srchInfo.setReturningAttributes(objAttribs);	
		         	
		//dcList = "CN="+ldapUser+",OU=members,OU=nex1,DC=korea,DC=asia,DC=denso";
		dcList = "CN="+ldapUser+",OU=ps_s_No_Screen_SVR,DC=korea,DC=asia,DC=denso";
		//dcList = "CN="+ldapUser+",DC=korea,DC=asia,DC=denso";
		NamingEnumeration dirObjects = ctx.search(dcList,"(objectClass=user)", srchInfo);	
		while (dirObjects != null && dirObjects.hasMoreElements()) {	
			SearchResult dirObject = (SearchResult) dirObjects.next();	
			//System.out.println(dirObject.getName() +"\t" + dirObject.getAttributes().get("pwdLastSet"));	
			System.out.println("uid : " + dirObject.getAttributes().get("cn"));
			System.out.println("uid : " + dirObject.getAttributes().get("displayName"));
			System.out.println("uid : " + dirObject.getAttributes().get("name"));
			ctx.close();	
		}
		*/
	} //end of checkLoginLdap
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			: 
	 * 	- LoginCommand command				: html 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:  resultMessage
	 * @hint
	 * 	- 뉴디오네 SSO연동
	 * @exception 
	 * @see
	 * 	- 2018-06-15	:	JAE H.B
	***********************************************************************/ 		
	@SuppressWarnings("unchecked")
	public ModelAndView checkLoginSSO(HttpServletRequest request, HttpServletResponse response, LoginCommand command) throws Exception {	

		
		Cookie[] cookies = request.getCookies();		
		String resultPwfcReset = "";
		String resultPassYn = "";
		String resultMessage = "Window AD 등록되지 않은 사용자입니다. ID/Password확인바랍니다.";
		
		HashMap userLoginLog = new HashMap();
		userLoginLog.put("USERID", command.getUserId().toUpperCase());
		userLoginLog.put("USERPASS", "SSO");
		
		Map userInfo1 = (Map)dao.getReadData("login.checkLoginLdap",command.getUserId().toUpperCase());
		//if(userInfo!=null && userInfo.get("USER_ID")!=null && !userInfo.get("USER_ID").equals("")){   -->NullPointerException발생으로 분리
		if(userInfo1!=null){
			if(userInfo1.get("USER_ID")!=null && !userInfo1.get("USER_ID").equals("")){
				String lib ="PSEDBLIB";
				if(command.getUserId().toUpperCase().substring(0,1).equals("C")){
					lib = "PSCDBLIB";
				}else if(command.getUserId().toUpperCase().substring(0,1).equals("H")) {
					lib = "PSHDBLIB";
				}else if(command.getUserId().toUpperCase().substring(0,1).equals("S")) {
					lib = "PSSDBLIB";
				}else if(command.getUserId().toUpperCase().substring(0,1).equals("R")) {
					lib = "PSRDBLIB";
				}
			System.out.println(lib);
			System.out.println(command.getUserId().toUpperCase().substring(1));
			HashMap keyData = new HashMap();
			keyData.put("LIB3", lib);
			keyData.put("SABUN", command.getUserId().toUpperCase().substring(1));
			
			/*용역인 경우 휴직자마스타 check예외처리 2015.11.03*/
			//System.out.println(command.getUserId().toUpperCase().substring(1));
			boolean chksabun =true;
					chksabun = StringUtils.isNumeric(command.getUserId().toUpperCase().substring(1)); 
			//System.out.println(chksabun);
			/*==============================================================================*/
			//1.용역이 아닌경우
			if(chksabun==true){
				Map userInfo2 = (Map)dao.getReadData("login.checkLoginHUM",keyData);
				if(userInfo2 != null){
					userLoginLog.put("STATUS", "H");
					dao.insertData("login.loginHistory", userLoginLog);
					resultMessage = "인사발령으로 로그인 권한이 없습니다.";
					}else{
						HttpSession session = request.getSession(true);
						session.setMaxInactiveInterval(60*20);
						session.setAttribute("userInfo", userInfo1);
						userLoginLog.put("STATUS", "A");
						dao.insertData("login.loginHistory", userLoginLog);
						return new ModelAndView("login/miInstall");
					}
				}else{//2.용역인경우 HMD250PF 인사발령내역 체크안함.
					HttpSession session = request.getSession(true);
					session.setMaxInactiveInterval(60*20);
					session.setAttribute("userInfo", userInfo1);
					userLoginLog.put("STATUS", "A");
					dao.insertData("login.loginHistory", userLoginLog);
					return new ModelAndView("login/miInstall");
				}
			}else{
				userLoginLog.put("STATUS", "D");
				dao.insertData("login.loginHistory", userLoginLog);
				resultMessage = "DIONE 등록되지 않은 사용자입니다.";
				}
		}else{
			userLoginLog.put("STATUS", "D");
			dao.insertData("login.loginHistory", userLoginLog);
			resultMessage = "DIONE 등록되지 않은 사용자입니다.";
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		mav.addObject("userId", command.getUserId());
		mav.addObject("resultMessage", resultMessage);
		mav.addObject("resultPwfcReset", resultPwfcReset);
		mav.addObject("resultPassYn", resultPassYn);
		return mav;

	}
}
