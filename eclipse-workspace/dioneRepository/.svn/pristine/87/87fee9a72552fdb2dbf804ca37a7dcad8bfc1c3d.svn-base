package com.denso.dwhlib;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.denso.common.converter.DataConverter;
import com.denso.common.converter.MiPlatformView;
import com.denso.common.dao.CommonDAO;
import com.tobesoft.platform.PlatformRequest;

public class DWHlibController extends MultiActionController {
	
	CommonDAO dao = CommonDAO.getInstance(1);	
	
	/**************************
	 * DWH 경영 부분 정보 조회
	 * 1. 부품 입고 현황 조회                                             DWHZ001Q / SQL ID : dwhlib.selectdwhz001q
	 * 2. 인원코드리스트                                                   DWHZ006Q / SQL ID : dwhlib.selectdwhz006q 
	 * 3. 성과급 지급내역 리스트                                       DWHZ007Q / SQL ID : dwhlib.selectdwhz007q
	 * 4. 소급분 지급 리스트                                              DWHZ008Q / SQL ID : dwhlib.selectdwhz008q
	 * 5. 성과급 지급내역 리스트(월별)               DWHZ008Q / SQL ID : dwhlib.selectdwhz009q
	 * 6. 성과급 지급내역 리스트(합산분)             DWHZ009Q / SQL ID : dwhlib.selectdwhz008q
	 * 7. 종업원명부(DNKA 퇴사자, 입사자 명부)      DWHZ027Q / SQL ID : dwhlib.selectdwhz008q
	 * 8. 월급자료(DNKA)                        DWHZ028Q / SQL ID : dwhlib.selectdwhz008q
	 * 9.  
	 **************************/
	public void selectManagement(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8");
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String selectSQL = "dwhlib." + pData.get("SQLID").toString(); 
		List list = dao.getListData(selectSQL, pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DWH", list);
		new MiPlatformView().render(map, request, response);
	}
	/* LSK START */
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  DWH FILE 생성 이력조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-10	:	lsk
	***********************************************************************/ 
	public void selectDWHZ000Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("dwhlib.selectDWHZ000Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DWHZ000Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  DWH FILE 조회
	 * @exception 
	 * @see 
	 * 	- 2013-05-10	:	lsk
	***********************************************************************/ 
	public void selectDWHXXXXQ(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("dwhlib.selectDWHXXXXQ", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DWHXXXXQ", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-  DWH FILE 조회 (data 건수가 10000건 이상일때)
	 * @exception 
	 * @see 
	 * 	- 2013-05-10	:	lsk
	***********************************************************************/ 
	public void selectDWHXXXYQ(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		String querySTEP = (String) pData.get("STEP");
		List list = dao.getListData("dwhlib.selectDWHXXXYQ", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DWHXXXYQ_"+querySTEP, list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - 
	 * @see 
	 * 	- 2019-10-14	:	JDE F0902테이블에 등록된 BU코드만 보여줌
	***********************************************************************/ 
	public void selectJdeF0902_BU(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("dwhlib.selectJdeF0902_BU", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_BUCD", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - 
	 * @see 
	 * 	- 2019-10-14	:	JDE F0902테이블에 등록된 부서코드만 보여줌
	***********************************************************************/ 
	public void selectJdeF0902_DP(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("dwhlib.selectJdeF0902_DP", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DPCODE", list);
		new MiPlatformView().render(map, request, response);
	}/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Product Structure
	 * @exception .
	 * - 
	 * @see 
	 * 	- 2019-10-15	:	JDE F0902테이블에 등록된 계정코드만 보여줌
	***********************************************************************/ 
	public void selectJdeF0902_GBOBJ(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("dwhlib.selectJdeF0902_GBOBJ", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_GBOBJ", list);
		new MiPlatformView().render(map, request, response);
	}
}