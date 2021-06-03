/********************************************************************** 
 * @version              		 			: 1.0 
 * @author               		 			: 황규철
 * @see 
 * ● SYSTEM NAME          			: DIONE
 * ● PROGRAM NO.          			: UserController.java
 * ● PROGRAM DESCRIPTION  	: 시스템관리 처리 컨트롤러
 * ● DATE WRITTEN        				: 2010.11.26
 ********************************************************************** 
 * ● REVISION HISTORY
 * ● 2010.11.26							:  황규철
 */ 

package com.denso.system;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.denso.common.converter.DataConverter;
import com.denso.common.converter.MiPlatformView;
import com.denso.common.dao.CommonDAO;
import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;


public class UserController extends MultiActionController {
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사용자 리스트 
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void userList(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.userList", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_userList", list);
		new MiPlatformView().render(map, request, response);		
	}

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사용자  전체 데이터 조회
	 * 	- 중복체크용
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void userListAll(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.userList", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_userList_dummy", list);
		new MiPlatformView().render(map, request, response);		
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메뉴권한
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void menuAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.menuAuth", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuAuth", list);
		new MiPlatformView().render(map, request, response);		
	}	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메뉴그룹만 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void menuAuthGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.menuAuthGroup", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuAuthGroup", list);
		new MiPlatformView().render(map, request, response);		
	}		
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사용자 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void userSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_userList");
		List pList2 = DataConverter.getMiPlatformMultiData(pReq, "ds_menuMrpAuth");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		String modifyUser = (String)pMap.get("CREATE_USER");
		Iterator it = pList.iterator();
		Iterator it2 = pList2.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		dao.startTransaction(); //tr 시작		
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("CREATE_USER", modifyUser);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("user.insertUser", pData);
				//START 기본권한 추가로직 추가 - 2017.05.18
				String menuType="";
				String chkComp=(String) pData.get("COMPANY");
				String chkAut="";
				if(!chkComp.equals("KR")){
					while (it2.hasNext()) {
						Map pData2 = (Map) it2.next();
						pData2.put("USER_ID",(String)pMap.get("SUSER_ID"));
						chkAut=(String) pData2.get("MNGCD");
						if(chkAut.equals("00")){
							pData2.put("USER_YN","1");
						}
						//메뉴권한 등록
						dao.deleteData("user.deleteMenuAuth", pData2);				
						dao.insertData("user.insertMenuAuth", pData2);
						//버튼권한등록(모든버튼권한부여)						
						menuType=(String)pData2.get("TOP_MENU");
						if(menuType.substring(0,1).equals("m")){
							for(int i=1; i<=6; i++){	//help제외
								pData2.put("BUTTON_ID",i);
								pData2.put("BTN_AUTH", "1");
								dao.deleteData("user.deleteButtonAuth", pData2);	
								dao.insertData("user.insertButtonAuth", pData2);				
							}
						}			
					}
					//급여명세서 조회추가
					Map<String, String> fData = new HashMap<String, String>();
					fData.put("USER_ID",(String)pMap.get("SUSER_ID"));
					fData.put("USER_YN","1");
					fData.put("BTN_AUTH","1");
					if(chkComp.equals("PE")){
						fData.put("MENU_ID","10579");
						dao.deleteData("user.deleteMenuAuth", fData);				
						dao.insertData("user.insertMenuAuth", fData);
						
						fData.put("BUTTON_ID","1");
						dao.deleteData("user.deleteButtonAuth", fData);	
						dao.insertData("user.insertButtonAuth", fData);				

						fData.put("BUTTON_ID","5");
						dao.deleteData("user.deleteButtonAuth", fData);	
						dao.insertData("user.insertButtonAuth", fData);										
					}else if(chkComp.equals("PS")){
						fData.put("MENU_ID","10595");
						dao.deleteData("user.deleteMenuAuth", fData);				
						dao.insertData("user.insertMenuAuth", fData);
						
						fData.put("BUTTON_ID","1");
						dao.deleteData("user.deleteButtonAuth", fData);	
						dao.insertData("user.insertButtonAuth", fData);				

						fData.put("BUTTON_ID","5");
						dao.deleteData("user.deleteButtonAuth", fData);	
						dao.insertData("user.insertButtonAuth", fData);	
					}
				}
				//END
			} else if ("update".equals(rowType)) {
				dao.updateData("user.updateUser", pData);
			} else if ("delete".equals(rowType)) {
				dao.deleteData("user.deleteUser", pData);
			}
		}
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);		
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메뉴권한 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void saveMenuAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_menuAuth");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			dao.deleteData("user.deleteMenuAuth", pData);				
			dao.insertData("user.insertMenuAuth", pData);
		}

		new MiPlatformView().render(null, request, response);		
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 버튼권한 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void buttonAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.buttonAuth", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_buttonAuth", list);
		new MiPlatformView().render(map, request, response);		
	}		


	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 버튼권한 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void saveButtonAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_buttonAuth");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		
		while (it.hasNext()) {
			Map pData = (Map) it.next();

			for(int i=1; i<=7; i++){
				pData.put("BUTTON_ID",i);
				pData.put("BTN_AUTH", (String)pData.get("BTN" + i ));
				dao.deleteData("user.deleteButtonAuth", pData);	
				dao.insertData("user.insertButtonAuth", pData);				
			}
		}
		new MiPlatformView().render(null, request, response);		
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 공통코드 그룹 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void selectComCodeClass(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectComCodeClass", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_ComCodeClass", list);
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
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectComCode", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_ComCode", list);
		new MiPlatformView().render(map, request, response);		
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 공통코드 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void comCodeSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ComCode");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				System.out.println("===iiiiiiiiiiiiiiiiiiiiii===========");
				dao.insertData("user.insertComCode", pData);
			} else if ("update".equals(rowType)) {
				System.out.println("===uuuuuuuuuuuuuuu===========");
				dao.updateData("user.updateComCode", pData);
				dao.updateData("user.updateComCodeClassName", pData);				
			} else if ("delete".equals(rowType)) {
				System.out.println("===ddddddddddddd===========");
				dao.deleteData("user.deleteComCode", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}	
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 외부 시스템조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void selectOutSystem(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectOutSystem", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_outSystem", list);
		new MiPlatformView().render(map, request, response);		
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 외부 시스템 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void outSystemSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_outSystem");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				System.out.println("===iiiiiiiiiiiiiiiiiiiiii===========");
				dao.insertData("user.insertOutSystem", pData);
			} else if ("update".equals(rowType)) {
				System.out.println("===uuuuuuuuuuuuuuu===========");
				dao.updateData("user.updateOutSystem", pData);
			} else if ("delete".equals(rowType)) {
				System.out.println("===ddddddddddddd===========");
				dao.deleteData("user.deleteOutSystem", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}	
		

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 외부 시스템 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void outSystemSave2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_outSystem");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				System.out.println("===iiiiiiiiiiiiiiiiiiiiii===========");
				dao.insertData("user.insertOutSystem2", pData);
			} else if ("update".equals(rowType)) {
				System.out.println("===uuuuuuuuuuuuuuu===========");
				dao.updateData("user.updateOutSystem", pData);
			} else if ("delete".equals(rowType)) {
				System.out.println("===ddddddddddddd===========");
				//dao.deleteData("user.deleteComCode", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}		
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- SSO 계정 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void selectSsoAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectSsoAccount", pData);
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
	 * 	- SSO 계정 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void ssoAccountSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ssoaccount");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		String createUsr = (String)pMap.get("CREATE_USR");		

		
		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("CREATE_USR", createUsr);			
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				//dao.insertData("user.insertSsoAccount", pData);
			} else if ("update".equals(rowType)) {
				dao.deleteData("user.deleteSsoAccount", pData);
				dao.insertData("user.insertSsoAccount", pData);				
				
				dao.insertData("user.insertSsoAccountLog", pData);				
			} else if ("delete".equals(rowType)) {

				//dao.deleteData("user.deleteComCode", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}		
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- TQMS 계정 저장 (Stored Procedure 실행)
	 * @exception 
	 * @see
	 * 	- 2015-11-10	: sklee
	***********************************************************************/
	public void saveTQMSAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = null;
	    String url = "jdbc:sqlserver://10.73.254.137;databasename=DensoTQMS";
	    String user = "sa";
	    String password = "1111";
	    try { 
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        conn = DriverManager.getConnection(url, user, password);
			PlatformRequest pReq = new PlatformRequest(request);
			pReq.receiveData();
			//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_GATE01");
			Map pArg = DataConverter.getMiPlatformData(pReq);
			
			//Iterator it = pList.iterator();
		    //Statement stmt = null; 
		    //ResultSet rs = null;
	
			//ArrayList< String > al = new ArrayList< String >(); //arrayList객체생성(SQL저장)
			//dao.startTransaction(); //tr 시작
			CallableStatement cs = conn.prepareCall("{call USP_COM_MEMBERS_INS(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1,pArg.get("P_MODE").toString()); // type_mode (1 : insert)
			cs.setString(2,pArg.get("P_COMP").toString()); // 공장구분
			cs.setString(3,pArg.get("P_GUB").toString()); // 사용자구분
			cs.setString(4,pArg.get("P_ID").toString()); // 사용자ID
			cs.setString(5,pArg.get("P_NAME").toString()); // 사용자명
			cs.setString(6,pArg.get("P_EMAIL").toString()); // 이메일
			cs.setString(7,pArg.get("P_PASS").toString()); // 패스워드
			cs.setString(8,pArg.get("P_DEPTCD").toString()); // 부서코드
			cs.setString(9,pArg.get("P_JIKGUB").toString()); // 직급
			cs.setString(10,pArg.get("P_TEL").toString()); // 전화번호
			cs.setString(11,pArg.get("P_MOBILE").toString()); // 핸드폰
			cs.setString(12,pArg.get("P_PASSWD").toString()); // 비밀번호
			cs.execute();
			cs.close();
			conn.close();
			System.out.println("close");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	 try { if (conn != null) conn.close();  }
	    	 catch (SQLException ignored) {}
	    }

	}  
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사용자 사업부 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void selectUserCompany(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectUserCompany", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_userCompany", list);
		new MiPlatformView().render(map, request, response);		
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메세지 리스트 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectMsg(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectMsg", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_message", list);
		new MiPlatformView().render(map, request, response);		
	}	
	
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메세지 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 			
	public void msgSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_message");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("user.insertMsg", pData);
			} else if ("update".equals(rowType)) {
				dao.updateData("user.updateMsg", pData);
				} else if ("delete".equals(rowType)) {
				dao.deleteData("user.deleteMsg", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}			
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 세부메뉴 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void subMenuAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.subMenuAuth", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuAuth", list);
		new MiPlatformView().render(map, request, response);		
	}		
	
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 세부메뉴 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 	
	public void subMenuAuthSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_menuAuth");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
			} else if ("update".equals(rowType)) {
				dao.deleteData("user.deleteSubMenuAuth", pData);
				dao.updateData("user.insertSubMenuAuth", pData);
			} else if ("delete".equals(rowType)) {
			}
		}
		new MiPlatformView().render(null, request, response);		
	}			
		

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 시스템 로그 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		 		
	public void saveMenuLog(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_menuLog");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			rowType = (String) pData.get("ROW_TYPE");
			dao.insertData("user.insertMenuLog", pData);
		}
		new MiPlatformView().render(null, request, response);		
	}			
			
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 시스템 로그 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		 		
	public void selectMenuLog(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectMenuLog", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuLog", list);
		new MiPlatformView().render(map, request, response);		
	}			
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- SSO 로그 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectSsoAccountLog(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectSsoAccountLog", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_ssoAccountLog", list);
		new MiPlatformView().render(map, request, response);		
	}			
		
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-로그인 비밀번호 변경
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void savePassword1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_password");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			dao.updateData("user.updatePassword1", pData);
		}
		new MiPlatformView().render(null, request, response);		
	}	

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메뉴 비밀번호 변경
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void savePassword2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_password2");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			dao.updateData("user.updatePassword2", pData);
		}
		new MiPlatformView().render(null, request, response);		
	}	
	
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 디바이스 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectDevice(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectDevice", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_device", list);
		new MiPlatformView().render(map, request, response);		
	}			
			
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 디바이스 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		 	
	public void deviceSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_device");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			dao.deleteData("user.deleteDevice", pData);
			dao.updateData("user.insertDevice", pData);
		}
		new MiPlatformView().render(null, request, response);		
	}				
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 즐겨찾기 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectFavoriteAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.favoriteAuth", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_favorite", list);
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
	public void saveFavoriteAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_favorite");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();

			if ("1".equals(pData.get("USER_YN") )) {
				dao.deleteData("login.deletebookMark", pData);
				dao.insertData("login.insertbookMark", pData);
			}	else {
				dao.deleteData("login.deletebookMark", pData);
			}	
			

		}
		new MiPlatformView().render(null, request, response);		
	}				
		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메뉴리스트 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		 		
	public void selectMenuList(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectMenuList", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuList", list);
		new MiPlatformView().render(map, request, response);		
	}				
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 상위 메뉴리스트 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		 		
	public void selectUpMenuCode(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectUpMenuCode", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_upMenuCode", list);
		new MiPlatformView().render(map, request, response);		
	}		
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 최상위 메뉴리스트 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectTopMenuCode(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectTopMenuCode", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_topMenuCode", list);
		new MiPlatformView().render(map, request, response);		
	}			
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 메뉴저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/
	public void saveMenuList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_menuList");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			rowType = (String) pData.get("ROW_TYPE");
			
			System.out.println("MENU_ORDER=============================" + pData.get("MENU_ORDER"));
			
			if ("insert".equals(rowType)) {
/*				//dao.insertData("user.insertMenuList", pData);	
				//START 기본권한 추가로직 추가 - 2017.05.19
				String chkMngcd=(String) pData.get("MNGCD");
				String chkComp=(String) pData.get("COMPANY");
				String chkTopMenu=(String) pData.get("TOP_MENU");
				String chkAut="";
				Map iData = new HashMap();
				if(!chkComp.equals("KR")){	//KR사업부가 아닌경우
					System.out.println("KR아님"+chkComp+"=="+chkTopMenu);
					if(chkTopMenu.equals("m1") || chkTopMenu.equals("m2") || chkTopMenu.equals("m3")){	//영업,생산,자재만 해당
						System.out.println("영업/생산/자재"+chkTopMenu);
						if(chkMngcd.equals("00")){	//권한이 기본인경우
							System.out.println("기본권한"+chkMngcd);
							Map CheckMID = (Map)dao.getReadData("user.selectMenuID",pData); //메뉴ID 체크
							if(!("").equals(CheckMID.get("MENU_ID"))){
								if(chkComp.equals("00")){
									iData.put("COMPS", "'PE','PS'");
								}else{
									iData.put("COMPS", "'"+chkComp+"'");
								}
								//iData.put("COMPS", "'"+chkComp+"'");
								iData.put("MENU_ID", CheckMID.get("MENU_ID"));
								iData.put("USER_YN", "1");
								//메뉴권한 등록
								dao.deleteData("user.deleteMenuAuthAll", iData);				
								dao.insertData("user.insertMenuAuthAll", iData);
								if(chkTopMenu.substring(0,1).equals("m")){
									for(int i=1; i<=6; i++){	//help제외
										iData.put("BUTTON_ID",i);
										iData.put("BTN_AUTH", "1");
										dao.deleteData("user.deleteButtonAuthAll", iData);	
										dao.insertData("user.insertButtonAuthAll", iData);				
									}
								}
							}							
						}
					}
				} else if ("update".equals(rowType)) {
				//dao.updateData("user.updateMenuList", pData);
				//START 기본권한 추가로직 추가 - 2017.05.19
				String chkMngcd=(String) pData.get("MNGCD");
				String chkComp=(String) pData.get("COMPANY");
				String chkTopMenu=(String) pData.get("TOP_MENU");
				String chkMenuId=(String) pData.get("MENU_ID");
				String chkAut="";
				Map iData = new HashMap();
				if(!chkComp.equals("KR")){	//KR사업부가 아닌경우
					System.out.println("KR아님"+chkComp+"=="+chkTopMenu);
					if(chkTopMenu.equals("m1") || chkTopMenu.equals("m2") || chkTopMenu.equals("m3")){	//영업,생산,자재만 해당
						System.out.println("영업/생산/자재"+chkTopMenu);
						if(chkMngcd.equals("00")){	//권한이 기본인경우
							System.out.println("기본권한"+chkMngcd);
							if(!("").equals(chkMenuId)){
								if(chkComp.equals("00")){
									iData.put("COMPS", "'PE','PS'");
								}else{
									iData.put("COMPS", "'"+chkComp+"'");
								}
								//iData.put("COMPS", "'"+chkComp+"'");
								iData.put("MENU_ID", chkMenuId);
								iData.put("USER_YN", "1");
								//메뉴권한 등록
								dao.deleteData("user.deleteMenuAuthAll", iData);				
								dao.insertData("user.insertMenuAuthAll", iData);
								if(chkTopMenu.substring(0,1).equals("m")){
									for(int i=1; i<=6; i++){	//help제외
										iData.put("BUTTON_ID",i);
										iData.put("BTN_AUTH", "1");
										dao.deleteData("user.deleteButtonAuthAll", iData);	
										dao.insertData("user.insertButtonAuthAll", iData);				
									}
								}
							}							
						}else if(chkMngcd.equals("M1")){	//권한이 권한인경우
							if(!("").equals(chkMenuId)){
								if(chkComp.equals("00")){
									iData.put("COMPS", "'PE','PS'");
								}else{
									iData.put("COMPS", "'"+chkComp+"'");
								}
								//iData.put("COMPS", "'"+chkComp+"'");
								iData.put("MENU_ID", chkMenuId);
								iData.put("USER_YN", "1");
								//메뉴권한 등록
								
								dao.deleteData("user.deleteMenuAuthAll", iData);				
								if(chkTopMenu.substring(0,1).equals("m")){
									for(int i=1; i<=6; i++){	//help제외
										iData.put("BUTTON_ID",i);
										iData.put("BTN_AUTH", "1");
										dao.deleteData("user.deleteButtonAuthAll", iData);	
									}
								}
							}		
						}
					}
				}
				//END
*/
				dao.insertData("user.insertMenuList", pData);	
				//START 기본권한 추가로직 추가 - 2017.05.19
				String chkMngcd1=(String) pData.get("MNGCD1");	//KE
				String chkMngcd2=(String) pData.get("MNGCD2");	//KA
				String chkMngcd="";
				String chkComp=(String) pData.get("COMPANY");
				String chkTopMenu=(String) pData.get("TOP_MENU");
				String chkAut="";
				Map iData = new HashMap();
				if(!chkComp.equals("KR")&&!chkComp.equals("")){	//KR사업부가 아닌경우
					System.out.println("KR아님"+chkComp+"=="+chkTopMenu);
					if(chkTopMenu.equals("m1") || chkTopMenu.equals("m2") || chkTopMenu.equals("m3")){	//영업,생산,자재만 해당
						System.out.println("영업/생산/자재"+chkTopMenu);
						if(chkMngcd1.equals("00") || chkMngcd2.equals("00")){	//권한이 기본인경우
							System.out.println("기본권한 KE ="+chkMngcd1+" 기본권한 KA ="+chkMngcd2);
							Map CheckMID = (Map)dao.getReadData("user.selectMenuID",pData); //메뉴ID 체크						
							//KE사업부처리
							if(chkMngcd1.equals("00")&& (chkComp.equals("00") ||chkComp.equals("PE"))){	//권한이 기본인경우
								System.out.println("기본권한 KE = "+chkMngcd1);
								if(!("").equals(CheckMID.get("MENU_ID"))){
									iData.put("COMPS", "'PE'");
									iData.put("MENU_ID", CheckMID.get("MENU_ID"));
									//iData.put("MENU_ID","11248");
									iData.put("USER_YN", "1");
									//메뉴권한 등록
									dao.deleteData("user.deleteMenuAuthAll", iData);				
									dao.insertData("user.insertMenuAuthAll", iData);
									if(chkTopMenu.substring(0,1).equals("m")){
										for(int i=1; i<=6; i++){	//help제외
											iData.put("BUTTON_ID",i);
											iData.put("BTN_AUTH", "1");
											dao.deleteData("user.deleteButtonAuthAll", iData);	
											dao.insertData("user.insertButtonAuthAll", iData);				
										}
									}
								}							
							}
							//KA사업부처리
							if(chkMngcd2.equals("00") && (chkComp.equals("00") || chkComp.equals("PS"))){	//권한이 기본인경우
								System.out.println("기본권한 KA = "+chkMngcd2);
								if(!("").equals(CheckMID.get("MENU_ID"))){
									iData.put("COMPS", "'PS'");
									//iData.put("COMPS", "'"+chkComp+"'");
									iData.put("MENU_ID", CheckMID.get("MENU_ID"));
									//iData.put("MENU_ID","11248");
									iData.put("USER_YN", "1");
									//메뉴권한 등록
									dao.deleteData("user.deleteMenuAuthAll", iData);				
									dao.insertData("user.insertMenuAuthAll", iData);
									if(chkTopMenu.substring(0,1).equals("m")){
										for(int i=1; i<=6; i++){	//help제외
											iData.put("BUTTON_ID",i);
											iData.put("BTN_AUTH", "1");
											dao.deleteData("user.deleteButtonAuthAll", iData);	
											dao.insertData("user.insertButtonAuthAll", iData);				
										}
									}
								}							
							}
						}
					}	
				}
				//END
			} else if ("update".equals(rowType)) {
				dao.updateData("user.updateMenuList", pData);
				//START 기본권한 추가로직 추가 - 2017.05.19
				String chkMngcd1=(String) pData.get("MNGCD1");	//KE
				String chkMngcd2=(String) pData.get("MNGCD2");	//KA
				String chkMngcd="";
				String chkComp=(String) pData.get("COMPANY");
				String chkTopMenu=(String) pData.get("TOP_MENU");
				String chkMenuId=(String) pData.get("MENU_ID");
				String chkAut="";
				Map iData = new HashMap();
				if(!chkComp.equals("KR")&&!chkComp.equals("")){	//KR사업부가 아닌경우
					System.out.println("KR아님"+chkComp+"=="+chkTopMenu);
					if(chkTopMenu.equals("m1") || chkTopMenu.equals("m2") || chkTopMenu.equals("m3")){	//영업,생산,자재만 해당
						System.out.println("영업/생산/자재"+chkTopMenu);
						if(chkMngcd1.equals("00") || chkMngcd2.equals("00")){	//권한이 기본인경우
							System.out.println("기본권한 KE ="+chkMngcd1+" 기본권한 KA ="+chkMngcd2);
							if(!("").equals(chkMenuId)){
								if(chkMngcd1.equals("00")&& (chkComp.equals("00") ||chkComp.equals("PE"))){	//권한이 기본인경우
									System.out.println("기본권한 KE = "+chkMngcd1);
									iData.put("COMPS", "'PE'");
									iData.put("MENU_ID", chkMenuId);
									iData.put("USER_YN", "1");
									//메뉴권한 등록
									//dao.deleteData("user.deleteMenuAuthAll", iData);	//수정인경우 적용여부 확인필요
									//dao.insertData("user.insertMenuAuthAll", iData);	//수정인경우 적용여부 확인필요
									if(chkTopMenu.substring(0,1).equals("m")){
										for(int i=1; i<=6; i++){	//help제외
											iData.put("BUTTON_ID",i);
											iData.put("BTN_AUTH", "1");
											//dao.deleteData("user.deleteButtonAuthAll", iData);	//수정인경우 적용여부 확인필요
											//dao.insertData("user.insertButtonAuthAll", iData);	//수정인경우 적용여부 확인필요
										}
									}
								}
								if(chkMngcd2.equals("00") && (chkComp.equals("00") || chkComp.equals("PS"))){	//권한이 기본인경우
									System.out.println("기본권한 KA = "+chkMngcd2);
									iData.put("COMPS", "'PS'");
									iData.put("MENU_ID", chkMenuId);
									iData.put("USER_YN", "1");
									//메뉴권한 등록
									//dao.deleteData("user.deleteMenuAuthAll", iData);	//수정인경우 적용여부 확인필요
									//dao.insertData("user.insertMenuAuthAll", iData);	//수정인경우 적용여부 확인필요
									if(chkTopMenu.substring(0,1).equals("m")){
										for(int i=1; i<=6; i++){	//help제외
											iData.put("BUTTON_ID",i);
											iData.put("BTN_AUTH", "1");
											//dao.deleteData("user.deleteButtonAuthAll", iData);	//수정인경우 적용여부 확인필요
											//dao.insertData("user.insertButtonAuthAll", iData);	//수정인경우 적용여부 확인필요
										}
									}
								}
							}							
						}
						if(chkMngcd1.equals("M1") || chkMngcd2.equals("M1")){	//권한이 권한인경우
							System.out.println("권한부여 KE ="+chkMngcd1+" 권한부여 KA ="+chkMngcd2);
							if(!("").equals(chkMenuId)){
								if(chkMngcd1.equals("M1")&& (chkComp.equals("00") ||chkComp.equals("PE"))){	//권한이 기본인경우
									System.out.println("권한부여 KE = "+chkMngcd1);
									iData.put("COMPS", "'PE'");
									iData.put("MENU_ID", chkMenuId);
									//iData.put("USER_YN", "1");
									//메뉴권한 등록
									dao.deleteData("user.deleteMenuAuthAll", iData);				
									if(chkTopMenu.substring(0,1).equals("m")){
										for(int i=1; i<=6; i++){	//help제외
											iData.put("BUTTON_ID",i);
											iData.put("BTN_AUTH", "1");
											//dao.deleteData("user.deleteButtonAuthAll", iData);	//수정인경우 적용여부 확인필요
										}
									}
								}
								if(chkMngcd2.equals("M1") && (chkComp.equals("00") || chkComp.equals("PS"))){	//권한이 기본인경우
									System.out.println("권한부여 KA = "+chkMngcd2);
									iData.put("COMPS", "'PS'");
									iData.put("MENU_ID", chkMenuId);
									//iData.put("USER_YN", "1");
									//메뉴권한 등록
									dao.deleteData("user.deleteMenuAuthAll", iData);				
									if(chkTopMenu.substring(0,1).equals("m")){
										for(int i=1; i<=6; i++){	//help제외
											iData.put("BUTTON_ID",i);
											iData.put("BTN_AUTH", "1");
											//dao.deleteData("user.deleteButtonAuthAll", iData);	//수정인경우 적용여부 확인필요
										}
									}
								}
							}
							
						}
					}
				}
				//END
			} else if ("delete".equals(rowType)) {
				dao.deleteData("user.deleteMenuList", pData);				
			}
		}
		new MiPlatformView().render(null, request, response);		
	}			
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 외부 시스템 그룹 조회
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectGroupOutSystem(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectGroupOutSystem", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_outsystem", list);
		new MiPlatformView().render(map, request, response);		
	}				
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 디바이스 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		 		
	public void saveDevice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_device");
		Map pMap = DataConverter.getMiPlatformData(pReq);

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			dao.deleteData("user.deleteDevice", pData);
			dao.updateData("user.insertDevice", pData);
		}
		new MiPlatformView().render(null, request, response);		
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 내부 시스템 자동로그인 여부 확인
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		 		
	public void selectOutSystemLoginYn(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectOutSystemLoginYn", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_loginYn", list);
		new MiPlatformView().render(map, request, response);		
	}		
	


	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 공지사항 리스트
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 				
	public void selectNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectNotice", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_notice", list);
		new MiPlatformView().render(map, request, response);		
	}			
	

	

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사용자 저장
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	황규철
	***********************************************************************/ 		
	public void saveNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_notice");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		String modifyUser = (String)pMap.get("CREATE_USER");

		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("CREATE_USER", modifyUser);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
	
				dao.insertData("user.insertNotice", pData);	
				

				
				
			} else if ("update".equals(rowType)) {

				
				
				dao.updateData("user.updateNotice", pData);
				
			} else if ("delete".equals(rowType)) {
				
				System.out.println("========NTC_SEQ======"+pData.get("NTC_SEQ"));						
				System.out.println("=======COMPANYA======"+pData.get("COMPANY"));
				System.out.println("=======PLANT_CD=A======"+pData.get("PLANT_CD"));
				System.out.println("========NTC_SDATEA======"+pData.get("NTC_SDATE"));
				System.out.println("========NTC_EDATEA======"+pData.get("NTC_EDATE"));
				System.out.println("========NTC_TITLEA======"+pData.get("NTC_TITLE"));
				System.out.println("========NTC_CNTA======"+pData.get("NTC_CNT"));
				System.out.println("========CREATE_USERA======"+pData.get("CREATE_USER"));				
				dao.deleteData("user.deleteNotice", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사용자 조회_팝업
	 * @exception 
	 * @see
	 * 	- 2012-02-29	:	제환복
	***********************************************************************/ 
	public void selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectUser", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_selUser", list);
		new MiPlatformView().render(map, request, response);		
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- TopMemu Level조회 ===MRP메뉴추가 TEST
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	제환복
	***********************************************************************/ 
	public void selectTmenuLev(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectTmenuLev", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_tmenuLev", list);
		new MiPlatformView().render(map, request, response);		
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- left menu MrpChk ===MRP메뉴 사용체크 TEST
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	제환복
	***********************************************************************/ 
/*사용안함
	public void selectMrpChk(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectMrpChk", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_mrpChk", list);
		new MiPlatformView().render(map, request, response);		
	}
*/	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- DIONE사용자 조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectUser_DIONE(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectUser_DIONE", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_User_DIONE", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- SSO 사용자 조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectUser_SSO(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectUser_SSO", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_User_SSO", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- SSO외부 사용자 조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectUser_SSO_OUT(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectUser_SSO_OUT", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_User_SSO_OUT", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전관리,계측기,예비품,QRWEB 사용자 조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectUser_ETC(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("user.selectUser_ETC", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_User_ETC", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- MRP 사용자 조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectUser_MRP(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("user.selectUser_MRP", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_User_MRP", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- MRP pgm 사용자권한 조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectUser_PGMAuth_tree(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("user.selectUser_PGMAuth_tree", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_User_PGMAuth_tree", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- MRP pgm 사용자권한 조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectUser_PGMAuth_dept(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("user.selectUser_PGMAuth_dept", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_User_PGMAuth_dept", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- MRP password pgm 사용자권한 조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectUser_PGMPwd(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("user.selectUser_PGMPwd", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_User_PGMPwd", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- OZ 인사화상시스템 사용자권한 조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectUser_OZ_Em(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("user.selectUser_OZ_Em", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_User_OZ_Em", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- MRP SYSTEM관리
	 * @exception 
	 * @see
	 * 	- 2013-09-27	:	jhb
	***********************************************************************/ 
	public void selectMngFlag(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		Map pData2 = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("user.selectMngFlag", pData);
		List list2 = dao.getListData("user.selectSILCHK", pData2);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_mngflag", list);
		map.addAttribute("ds_SILTM", list2);
		new MiPlatformView().render(map, request, response);		
	}
	public void updateMngFlag(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_mngflag");
		List pList2 = DataConverter.getMiPlatformMultiData(pReq, "ds_SILTM");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it_iu = pList.iterator();
		Iterator it_iu2 = pList2.iterator();
		String rowType="";
		dao.startTransaction(); //tr 시작		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			rowType = (String) pData.get("ROW_TYPE");
			if ("update".equals(rowType)) {
				dao.updateData("user.updateMngFlag", pData);			
			}     
		} 
		while (it_iu2.hasNext()) {
			Map pData = (Map) it_iu2.next();
			rowType = (String) pData.get("ROW_TYPE");
			if ("update".equals(rowType)) {
				dao.updateData("user.updateSILCHK", pData);			
			}     
		}    
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 실사 시간관리
	 * @exception 
	 * @see
	 * 	- 2013-09-27	:	jhb
	***********************************************************************/ 
	public void selectSILCHK(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("user.selectSILCHK", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_SILTM", list);
		new MiPlatformView().render(map, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- DIONE 로그인 로그조회
	 * @exception 
	 * @see
	 * 	- 2012-04-29	:	lsk
	***********************************************************************/ 
	public void selectLoginLog(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("user.selectLoginLog", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_LoginLog", list);
		new MiPlatformView().render(map, request, response);		
	}
	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- MRP SYSTEM 메뉴 GROUP조회
	 * @exception 
	 * @see
	 * 	- 2017-03-28	:	jhb
	***********************************************************************/ 		
	public void menuMrpGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.menuMrpGroup", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuMrpGroup", list);
		new MiPlatformView().render(map, request, response);		
	}
	public void menuMrpAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.menuMrpAuth", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuMrpAuth", list);
		new MiPlatformView().render(map, request, response);		
	}
	public void menuMrpAuthDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.menuMrpAuth_Default", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuMrpAuth", list);
		new MiPlatformView().render(map, request, response);		
	}
	public void saveMenuMrpAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_menuMrpAuth");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it = pList.iterator();
		String rowType="";
		String menuType="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_menuMrpAuth");
		//////////////////////////////////////////////////////////////		

		dao.startTransaction(); //tr 시작		
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			//메뉴권한 등록
			dao.deleteData("user.deleteMenuAuth", pData);				
			dao.insertData("user.insertMenuAuth", pData);
			//버튼권한등록(모든버튼권한부여)
			
			menuType=(String)pData.get("TOP_MENU");
			if(menuType.substring(0,1).equals("m")){
				//System.out.println(menuType.substring(0,1));
				//System.out.println((String)pArg.get("BTNAUTH"));
				//for(int i=1; i<=7; i++){
				for(int i=1; i<=6; i++){	//help제외
					pData.put("BUTTON_ID",i);
					//pData.put("BTN_AUTH", (String)pData.get("BTN" + i ));
					//pData.put("BTN_AUTH", (String)pArg.get("BTNAUTH"));	//삭제 : 20180509
					pData.put("BTN_AUTH", (String)pData.get("USER_YN"));
					dao.deleteData("user.deleteButtonAuth", pData);	
					dao.insertData("user.insertButtonAuth", pData);				
				}
			}			
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		new MiPlatformView().render(null, request, response);
		}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 권한복사 - 미사용
	 * @exception 
	 * @see
	 * 	- 2014-11-28	:	jhb
	***********************************************************************/ 
	public void selectMenuAuthCP(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectMenuAuthCP", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_MenuAuthCP", list);
		new MiPlatformView().render(map, request, response);		
	}
	public void saveMenuAuthCP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_MenuAuthCP");
		Map pArg = DataConverter.getMiPlatformData(pReq);	
		
		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		
		String useTF="";

		while (it.hasNext()) {
			Map pData = (Map) it.next();
			useTF = (String) pData.get("USER_YN");
			pData.put("USER_ID", (String)pArg.get("USER_ID"));
			if(useTF.equals("1")){
				//System.out.println("권한부여");
				Map CheckCnt = (Map)dao.getReadData("user.selectMenuAuthCP_Check",pData);
				if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
					if(CheckCnt.get("CNT").equals(0)){
						System.out.println("권한부여등록");
						//dao.deleteData("user.deleteMenuAuthCP", pData);				
						dao.insertData("user.insertMenuAuth", pData);
					}else{
						System.out.println("권한부여수정");
						dao.updateData("user.updateMenuAuth", pData);
					}
				}
			}
		}
		new MiPlatformView().render(null, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 넷클라이언트 사용자 갱신
	 * @exception 
	 * @see
	 * 	- 2016-05-20	:	jhb
	***********************************************************************/ 
	public void selectNetClientUser(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.selectNetClientUser", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_N_USER_IF", list);
		new MiPlatformView().render(map, request, response);		
	}
	public void saveNetClientUser(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList1 = DataConverter.getMiPlatformMultiData(pReq, "ds_N_USER_IF");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_iu1 = pList1.iterator();//ds_HAY011PF
		String rowType="";
		String emptyPN="";
		
		dao.startTransaction(); //tr 시작
		dao.deleteData("user.deleteNetClientUser", pArg);//table삭제

		while (it_iu1.hasNext()) {
			Map pData = (Map) it_iu1.next();
			emptyPN = (String) pData.get("SABUN");
			if (emptyPN != "") {
				dao.insertData("user.insertNetClientUser", pData);
			}       
		} 
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_ERROR", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 권한일괄부여관리
	 * @exception 
	 * @see
	 * 	- 2018-03-16	:	제환복
	***********************************************************************/ 			
	public void menuAuthList(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("user.menuAuthList", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_menuAuth", list);
		new MiPlatformView().render(map, request, response);		
	}
	public void saveMenuAuthList(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		
		CommonDAO dao = CommonDAO.getInstance(1);
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();
		List pList1 = DataConverter.getMiPlatformMultiData(pReq, "ds_menuAuth");
		List pList2 = DataConverter.getMiPlatformMultiData(pReq, "ds_UserAdd");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it1 = pList1.iterator();
		//Iterator it2 = pList2.iterator();
		String rowType="";
		String emptyMid="";
		String emptyMidYN="";
		String emptyUid="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_menuAuth");
		Dataset ds1 = in_dl.getDataset("ds_UserAdd");
		//////////////////////////////////////////////////////////////		

		dao.startTransaction(); //tr 시작		
		while (it1.hasNext()) {
			Map pData = (Map) it1.next();
			//System.out.println(pData);
			//메뉴권한 등록
			emptyMid = (String) pData.get("MENU_ID");
			emptyMidYN = (String) pData.get("USER_YN");
			if (emptyMid != "" && emptyMidYN.equals("1")) {
				//System.out.println((String)pData.get("MENU_ID")+"=="+(String)pData.get("USER_ID")+"=="+(String)pData.get("USER_YN"));
				for(int i=0; i<pList2.size(); i++){
					Map pData2 = (Map) pList2.get(i);
					//System.out.println(pData2);
					//버튼권한등록(모든버튼권한부여)
					emptyUid = (String) pData2.get("USER_ID");
					if (emptyUid != "") {
						for(int j=1; j<=6; j++){	//help제외
							pData2.put("MENU_ID", (String)pData.get("MENU_ID"));//메뉴ID를 유저map에 등록
		
							pData2.put("BUTTON_ID",j);
							//pData.put("BTN_AUTH", (String)pData.get("BTN" + j ));
							pData2.put("BTN_AUTH", "1");
							dao.deleteData("user.deleteButtonAuth", pData2);	
							dao.insertData("user.insertButtonAuth", pData2);
		
							pData.put("USER_ID", (String)pData2.get("USER_ID"));//유저ID를 메뉴map에 등록
							//System.out.println((String)pData2.get("MENU_ID")+"=="+Integer.parseInt(pData2.get("BUTTON_ID").toString())+"=="+(String)pData2.get("USER_ID"));
							
							//System.out.println("chek1=="+(String)pData2.get("MENU_ID")+ "=="+Integer.parseInt(pData2.get("BUTTON_ID").toString())+"=="+(String)pData2.get("USER_ID"));
						}
						//System.out.println("chek2=="+(String)pData.get("MENU_ID")+"=="+(String)pData.get("USER_ID")+"=="+(String)pData.get("USER_YN"));
						dao.deleteData("user.deleteMenuAuth", pData);				
						dao.insertData("user.insertMenuAuth", pData);	
					}
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		new MiPlatformView().render(null, request, response);
	}	
}