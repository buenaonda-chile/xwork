package com.denso.psogmlib;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.denso.common.converter.DataConverter;
import com.denso.common.converter.MiPlatformView;
import com.denso.common.dao.CommonDAO;
import com.denso.common.util.FileUpDown;
import com.ibatis.sqlmap.engine.mapping.sql.dynamic.elements.IsEmptyTagHandler;
import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;

public class PsogmlibController extends MultiActionController {
	
	CommonDAO dao = CommonDAO.getInstance(1);	
	protected Log log = LogFactory.getLog(this.getClass());
	
	public void selectOGMPrtno(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMPrtno", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOGMVndnr(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMVndnr", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOGMMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMMaker", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOGMUserID(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMUserID", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}

	public void selectOGMPrtcd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMPrtcd", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOGMMshno(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMMshno", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOGMMstcd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMMstcd", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOGMBuSabun(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMBuSabun", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Select", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-예비품 마감 확인    -  spare_common.js
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	이상건
	***********************************************************************/
	public void selectcloseYN(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectcloseYN", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_closeYN", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-예비품/설비보전/계측기 관리자 권한확인    -  spare_common.js
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	이상건
	***********************************************************************/ 
	public void selectmanagerYN(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectmanagerYN", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_managerYN", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOGM010(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM010", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM010", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOGM010_dchk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM010_dchk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM010_dchk", list);
		new MiPlatformView().render(map, request, response);
	}
	/*REV om003 추가시 입출고내역이 있을 경우 추가 不*/
	public void selectOGM010_dchkall(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM010_dchkall", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM010_dchk", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 품목관리 저장 _재고발주량 조회 ogm010.xml, ogm125.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-07	:	이상건
	***********************************************************************/ 
	public void selectOGM010_JG(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM010_JG", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM010_JG", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOGM020(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM020", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM020", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOGM040(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM040", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM040", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-예비품/설비보전  관리자 권한 등록
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	이상건
	***********************************************************************/ 
	public void selectOgm030(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm030", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm030", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-예비품/설비보전  관리자 권한 등록
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	이상건
	***********************************************************************/ 
	public void OGM030Save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CommonDAO dao = CommonDAO.getInstance(1);*/
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_Ogm030");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		String Scomps = (String)pMap.get("COMPS");
		String Sgroup = (String)pMap.get("GROUP");
		//String Sidnum = (String)pMap.get("ADUSR");
		String Slib2 = (String)pMap.get("LIB2");
		
		Iterator it = pList.iterator();
		String rowType = "";
		//List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("COMPS", Scomps);
			pData.put("GROUP", Sgroup);
			//pData.put("ADUSR", Sidnum);
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOgm030", pData);
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateOgm030", pData);
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOgm030", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}
	
	public void selectOGM040PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM040PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM040PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOGM040PF_dchk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM040PF_dchk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM040PF_dchk", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOBJ100PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBJ100PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBJ100PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOGM011(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM011", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM011", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOGM011d1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM011d1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM011d1", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOGM011d2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM011d2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM011d2", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOGM011d3(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM011d3", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM011d3", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Maker관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-08-16	:	이상건
	***********************************************************************/ 		
	public void OGM020Save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CommonDAO dao = CommonDAO.getInstance(1);*/
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm020");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		String Scomps = (String)pMap.get("COMPS");
		String Sgroup = (String)pMap.get("GROUP");
		String Sidnum = (String)pMap.get("ADUSR");
		String Slib2 = (String)pMap.get("LIB2");
		
		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("COMPS", Scomps);
			pData.put("GROUP", Sgroup);
			pData.put("ADUSR", Sidnum);
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOGM020", pData);
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateOGM020", pData);
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOGM020", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}
	public void OGM040Save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CommonDAO dao = CommonDAO.getInstance(1);*/
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm040");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		//String Scomps = (String)pMap.get("COMPS");
		//String Sgroup = (String)pMap.get("GROUP");
		//String Sidnum = (String)pMap.get("ADUSR");
		String Slib2 = (String)pMap.get("LIB2");
		
		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			//pData.put("COMPS", Scomps);
			//pData.put("GROUP", Sgroup);
			//pData.put("ADUSR", Sidnum);
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOGM040", pData);
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateOGM040", pData);
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOGM040", pData);
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
	 * 	- 품목관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-08-16	:	이상건
	***********************************************************************/ 		
	public void OGM010Save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CommonDAO dao = CommonDAO.getInstance(1);*/
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm010");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		String Scomps = (String)pMap.get("COMPS");
		String Sgroup = (String)pMap.get("GROUP");
		String Sidnum = (String)pMap.get("ADUSR");
		String Slib2 = (String)pMap.get("LIB2");
		
		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("COMPS", Scomps);
			pData.put("GROUP", Sgroup);
			pData.put("ADUSR", Sidnum);
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOGM010", pData);
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateOGM010", pData);
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOGM010", pData);
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
	 * 	- 코드관리 조회
	 * @exception 
	 * @see
	 * 	- 2011-08-18	:	이상건
	***********************************************************************/ 
	public void selectOGM050(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM050", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM050", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 코드관리 중복CHECK용
	 * @exception 
	 * @see
	 * 	- 2011-08-18	:	이상건
	***********************************************************************/ 
	public void selectOGM050_dchk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM050_dchk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM050_dchk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 품목관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-08-16	:	이상건
	***********************************************************************/ 		
	public void OGM050Save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CommonDAO dao = CommonDAO.getInstance(1);*/
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm050");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		String Scomps = (String)pMap.get("COMPS");
		String Sgrpcd = (String)pMap.get("GRPCD");
		String Sidnum = (String)pMap.get("ADUSR");
		String Slib2 = (String)pMap.get("LIB2");
		
		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("COMPS", Scomps);
			pData.put("GRPCD", Sgrpcd);
			pData.put("ADUSR", Sidnum);
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOGM050", pData);
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateOGM050", pData);
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOGM050", pData);
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
	 * 	- 발주후보등록 조회 (발주후보)
	 * @exception 
	 * @see
	 * 	- 2011-08-22	:	이상건
	***********************************************************************/ 
	public void selectOGM105_A(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM105_A", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM105", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주후보등록 조회 (발주보류)
	 * @exception 
	 * @see
	 * 	- 2011-08-22	:	이상건
	***********************************************************************/ 
	public void selectOGM105_B(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM105_B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM105", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주후보등록 발행조회 ogm105.xml
	 * @exception 
	 * @see
	 * 	- 2011-08-22	:	이상건
	***********************************************************************/ 
	public void selectOGM105_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM105_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm105rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주후보등록 (승인) 
	 * @exception 
	 * @see
	 * 	- 2011-08-22	:	이상건
	***********************************************************************/ 
	public void updateOGM105_OK(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOGM105_OK" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주후보등록 (승인) 
	 * @exception 
	 * @see
	 * 	- 2011-08-22	:	이상건
	***********************************************************************/ 
	public void deleteOGM105(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.deleteOGM105" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주후보등록  (발주후보저장)
	 * @exception 
	 * @see
	 * 	- 2011-08-23	:	이상건
	***********************************************************************/ 		
	public void updateOGM105_PR(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOGM105_PR" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주후보등록  (발주후보저장)
	 * @exception 
	 * @see
	 * 	- 2011-08-23	:	이상건
	***********************************************************************/ 		
	public void insertOGM105_PR(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm105");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.insertOGM105_PR" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주후보등록 조회 (발주보류)
	 * @exception 
	 * @see
	 * 	- 2011-08-22	:	이상건
	***********************************************************************/ 
	public void selectOGM105_maxNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM105_maxNumber", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM105_maxNumber", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주등록 조회 
	 * @exception 
	 * @see
	 * 	- 2011-08-24	:	이상건
	***********************************************************************/ 
	public void selectOGM106(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM106", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM106", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주등록 (LIST발행)
	 * @exception 
	 * @see
	 * 	- 2011-08-24	:	이상건
	***********************************************************************/ 		
	public void updateOGM106_HOLD_PR(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOGM106_HOLD_PR" , pData);
		new MiPlatformView().render(null, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주등록 (발주취소)
	 * @exception 
	 * @see
	 * 	- 2011-08-24	:	이상건
	***********************************************************************/ 		
	public void updateOGM106_HOLD_CANCEL(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOGM106_HOLD_CANCEL" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주등록 (인쇄승인) 
	 * @exception 
	 * @see
	 * 	- 2011-08-22	:	이상건
	***********************************************************************/ 
	public void updateOGM106_OK(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOGM106_OK" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주등록 발행 ogm106.xml
	 * @exception 
	 * @see
	 * 	- 2011-08-22	:	이상건
	***********************************************************************/ 
	public void selectOGM106_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM106_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm106rep", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 구매발주번호등록 조회 
	 * @exception 
	 * @see
	 * 	- 2011-08-24	:	이상건
	***********************************************************************/ 
	public void selectOGM107(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM107", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM107", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 구매발주번호등록 저장 
	 * @exception 
	 * @see
	 * 	- 2011-08-25	:	이상건
	***********************************************************************/ 
	public void updateOGM107(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOGM107" , pData);
		new MiPlatformView().render(null, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주현황 조회  ogm100.xml
	 * @exception 
	 * @see
	 * 	- 2011-08-25	:	이상건
	***********************************************************************/ 
	public void selectOGM100(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM100", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재입고  ogm115.xml
	 * @exception 
	 * @see
	 * 	- 2011-08-29	:	이상건
	***********************************************************************/ 
	public void selectOGM115(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM115", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM115", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재입고처리 - 자재입고번호 구하기  ogm115.xml ,ogm116.xml
	 * @exception 
	 * @see
	 * 	- 2011-08-22	:	이상건
	***********************************************************************/ 
	public void selectOGM115_maxNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM115_maxNumber", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM115_maxNumber", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재입고처리 - 자재발주 update  ogm115.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-01	:	이상건
	***********************************************************************/ 		
	public void updateOGM115(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOGM115" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재입고처리 - 자재입고 insert ogm115.xml , ogm116.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-01	:	이상건
	***********************************************************************/ 		
	public void insertOGM115(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm105");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.insertOGM115" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재입고처리 - 품목정보 update  ogm115.xml , ogm116.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-01	:	이상건
	***********************************************************************/ 		
	public void updateOGM115_1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_CVTSPY200C2");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOGM115_1" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재강제입고등록 - 조회  ogm116.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-01	:	이상건
	***********************************************************************/ 
	public void selectOGM116(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM116", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM116", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재강제입고등록 - 현재고조회  ogm116.xml, OGM125.XML
	 * @exception 
	 * @see
	 * 	- 2011-09-01	:	이상건
	***********************************************************************/ 
	public void selectOGM116_JG(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM116_JG", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM116_JG", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 입고취소 - 조회  ogm117.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	이상건
	***********************************************************************/ 
	public void selectOGM117(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM117", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM117", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 입고현황 - 조회  ogm110.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-05	:	이상건
	***********************************************************************/ 
	public void selectOGM110(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM110", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM110", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재출고처리 - 조회  ogm125.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-07	:	이상건
	***********************************************************************/ 
	public void selectOGM125(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM125", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM125", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재출고처리 - 자재출고번호 구하기  ogm125.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-07	:	이상건
	***********************************************************************/ 
	public void selectOGM125_maxNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM125_maxNumber", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM125_maxNumber", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재출고처리 - 자재출고 insert ogm125.xml 
	 * @exception 
	 * @see
	 * 	- 2011-09-07	:	이상건
	***********************************************************************/ 		
	public void insertOGM125(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm105");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.insertOGM125" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재출고취소 - 조회  ogm126.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-19	:	이상건
	***********************************************************************/ 
	public void selectOGM126(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM126", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM126", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재출고현황 - 조회  ogm120.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-19	:	이상건
	***********************************************************************/ 
	public void selectOGM120(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM120", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM120", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 월마감 - 조회  ogm135.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-27	:	이상건
	***********************************************************************/ 
	public void selectOGM135(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM135", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM135", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 월마감 - step1  ogm135.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-27	:	이상건
	***********************************************************************/ 
	public void selectOGM135_step1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM135_step1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM135_step1", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 월마감 - step1  ogm135.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-27	:	이상건
	***********************************************************************/ 
	public void selectOGM135_magam(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM135_magam", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM135_magam", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 월마감 - step1,setp2,step3 저장  ogm135.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-28	:	이상건
	***********************************************************************/ 
	public void saveOGM135(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OGM135_magam");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		dao.startTransaction(); //tr 시작
		dao.startBatch(); //배치작업 준비
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM135" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM135" , pData);
			}
		}
		dao.executeBatch(); //배치작업실행
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 월마감 - step1,setp2,step3 저장  ogm135.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-28	:	이상건
	***********************************************************************/ 
	public void saveOGM135_T(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OGM135_step1");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String m3C = (String)pArg.get("M3CHECK");
		dao.startTransaction(); //tr 시작
		//dao.startBatch(); //배치작업 준비
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("GROUP", (String)pArg.get("GROUP"));
			pData.put("JYEAR", (String)pArg.get("JYEAR"));
			pData.put("IQYMM", (String)pArg.get("IQYMM"));
			pData.put("IAMMM", (String)pArg.get("IAMMM"));
			pData.put("OQYMM", (String)pArg.get("OQYMM"));
			pData.put("OAMMM", (String)pArg.get("OAMMM"));
			Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOGM135_Check",pData);
			if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
				if(CheckCnt.get("CNT").equals(0)){
					dao.insertData("psogmlib.insertOGM135_T" , pData);
					dao.updateData("psogmlib.updateOGM135_T" , pData);
				}else{
					dao.updateData("psogmlib.updateOGM135_T" , pData);
				}
			}
		}
		dao.updateData("psogmlib.updateOGM135_JEGO" , pArg);  //재고수량 및 재고금액산출
		//3월마감시 다음회계년도 생성
		if(m3C.equals("Y")){
			dao.updateData("psogmlib.insertOGM135_YYYY" , pArg);
		}
		//dao.executeBatch(); //배치작업실행
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 월마감 - step4 저장  ogm135.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-28	:	이상건
	***********************************************************************/ 		
	public void insertOGM135_030(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm105");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.insertOGM135_030" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 재고대장조회   ogm136.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-29	:	이상건
	***********************************************************************/ 
	public void selectOGM136(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM136", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM136", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재현재고현항   ogm137.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-31	:	이상건
	***********************************************************************/ 
	public void selectOGM137(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM137", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM137", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 기간별매입현황   ogm138.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-02	:	이상건
	***********************************************************************/ 
	public void selectOGM138(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM138", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM138", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 기간별매출현황   ogm139.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-02	:	이상건
	***********************************************************************/ 
	public void selectOGM139(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM139", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM139", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 재고실사처리   ogm145.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-04	:	이상건
	***********************************************************************/ 
	public void selectOGM145(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM145", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM145", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재실사처리 - 자재실사번호 구하기  ogm145.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-05	:	이상건
	***********************************************************************/ 
	public void selectOGM145_maxNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM145_maxNumber", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM145_maxNumber", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재실사처리 - insert ogm145.xml 
	 * @exception 
	 * @see
	 * 	- 2011-10-07	:	이상건
	***********************************************************************/ 		
	public void insertOGM145(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm105");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.insertOGM145" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 자재실사처리 - 실사단가 insert ogm145.xml 
	 * @exception 
	 * @see
	 * 	- 2011-10-07	:	이상건
	***********************************************************************/ 		
	public void insertOGM145_1(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm105");
		//Map pArg = DataConverter.getMiPlatformData(pReq);
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.insertOGM145_1" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 재고실사현황 -  ogm146.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-07	:	이상건
	***********************************************************************/ 
	public void selectOGM146(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM146", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM146", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 년수불대장 -  ogm130.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-07	:	이상건
	***********************************************************************/ 
	public void selectOGM130(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM130", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm130", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전작업코드 -  ogm080A_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-30	:	한재희
	***********************************************************************/ 
	public void selectOGM080A_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080A_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080A_Chk", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전작업코드 -  ogm080A_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-04	:	한재희
	***********************************************************************/ 
	public void selectOGM080A_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080A_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080A_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전작업코드 -  ogm080A.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-09	:	한재희
	***********************************************************************/ 
	public void selectOGM080A(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
//System.out.println("pData--->"+pData);		
		String tableNm = (String)pData.get("TABLENM");
		String selSql="";
//System.out.println("tableNm--->"+tableNm);		
		if (tableNm.equals("obc140pf")){
			selSql="psogmlib.selectOGM080A1";
		}
		else {
			selSql="psogmlib.selectOGM080A";
		}
//System.out.println("selSql--->"+selSql);		
		List list = dao.getListData(selSql, pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080A", list);
		new MiPlatformView().render(map, request, response);
		
	}
/****	
	public void selectOGM080A1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080A1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080A1", list);
		new MiPlatformView().render(map, request, response);
	}
	****/
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전작업코드 -  ogm080A.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void saveOGM080A(HttpServletRequest request, HttpServletResponse response) throws Exception {
	PlatformRequest pReq 	= new PlatformRequest(request);
	pReq.receiveData();	
	//miplatform 에서 전송한 파라메타 값
	List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080A");
//System.out.println("pList--->"+pList);
	Map pArg = DataConverter.getMiPlatformData(pReq);	
	Iterator it = pList.iterator();
	String rowType="";
	while(it.hasNext()){
		Map pData = (Map)it.next();
		String comps = pArg.get("COMPS").toString();
		pData.put("LIB2", (String)pArg.get("LIB2"));
		pData.put("COMPS", comps);
		pData.put("ADUSR", (String)pArg.get("ADUSR"));
		pData.put("TABLENM", (String)pArg.get("TABLENM"));
		pData.put("FIELD1", (String)pArg.get("FIELD1"));
		pData.put("FIELD2", (String)pArg.get("FIELD2"));
		pData.put("FIELD3", (String)pArg.get("FIELD3"));
		rowType = (String)pData.get("ROW_TYPE");
		String tableNm = (String)pData.get("TABLENM");
		if ("obc140pf".equals(tableNm)){			
			if("E1".equals(comps)){
				pData.put("COMPS", comps);
				if("insert".equals(rowType)){
					dao.insertData("psogmlib.insertOGM080A1" , pData);
				} else if("update".equals(rowType)){
					dao.updateData("psogmlib.updateOGM080A1" , pData);
				} else if("delete".equals(rowType)){
					dao.deleteData("psogmlib.deleteOGM080A1" , pData);
				}
			} else {
				if("insert".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.insertData("psogmlib.insertOGM080A1" , pData);
					pData.put("COMPS", "S1");
					dao.insertData("psogmlib.insertOGM080A1" , pData);
					pData.put("COMPS", "H1");
					dao.insertData("psogmlib.insertOGM080A1" , pData);
				} else if("update".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.updateData("psogmlib.updateOGM080A1" , pData);
					pData.put("COMPS", "S1");
					dao.updateData("psogmlib.updateOGM080A1" , pData);
					pData.put("COMPS", "H1");
					dao.updateData("psogmlib.updateOGM080A1" , pData);
				} else if("delete".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.deleteData("psogmlib.deleteOGM080A1" , pData);
					pData.put("COMPS", "S1");
					dao.deleteData("psogmlib.deleteOGM080A1" , pData);
					pData.put("COMPS", "H1");
					dao.deleteData("psogmlib.deleteOGM080A1" , pData);
				}
			}
		} else if (!"obc140pf".equals(tableNm)){
			if("E1".equals(comps)){
				pData.put("COMPS", comps);
				if("insert".equals(rowType)){
					dao.insertData("psogmlib.insertOGM080A" , pData);
				} else if("update".equals(rowType)){
					dao.updateData("psogmlib.updateOGM080A" , pData);
				} else if("delete".equals(rowType)){
					dao.deleteData("psogmlib.deleteOGM080A" , pData);
				}
			} else {
				if("insert".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.insertData("psogmlib.insertOGM080A" , pData);
					pData.put("COMPS", "S1");
					dao.insertData("psogmlib.insertOGM080A" , pData);
					pData.put("COMPS", "H1");
					dao.insertData("psogmlib.insertOGM080A" , pData);
				} else if("update".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.updateData("psogmlib.updateOGM080A" , pData);
					pData.put("COMPS", "S1");
					dao.updateData("psogmlib.updateOGM080A" , pData);
					pData.put("COMPS", "H1");
					dao.updateData("psogmlib.updateOGM080A" , pData);
				} else if("delete".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.deleteData("psogmlib.deleteOGM080A" , pData);
					pData.put("COMPS", "S1");
					dao.deleteData("psogmlib.deleteOGM080A" , pData);
					pData.put("COMPS", "H1");
					dao.deleteData("psogmlib.deleteOGM080A" , pData);
				}	
			}
		}
	}
	new MiPlatformView().render(null, request, response);
}

	/*	public void saveOGM080A(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080A");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("TABLENM", (String)pArg.get("TABLENM"));
			pData.put("FIELD1", (String)pArg.get("FIELD1"));
			pData.put("FIELD2", (String)pArg.get("FIELD2"));
			pData.put("FIELD3", (String)pArg.get("FIELD3"));
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM080A" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM080A" , pData);
			}
			else if("delete".equals(rowType)){
				dao.updateData("psogmlib.deleteOGM080A" , pData);
			}
		}
		new MiPlatformView().render(null, request, response);
	}
	*/

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080B_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-12-01	:	한재희
	***********************************************************************/ 
	public void selectOGM080B_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080B_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080B_Chk", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080B_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-09	:	한재희
	***********************************************************************/ 
	public void selectOGM080B_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080B_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080B_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080B_B_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-12-07	:	한재희
	***********************************************************************/ 
	public void selectOGM080B_B_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080B_B_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080B_B_Chk", list);
		new MiPlatformView().render(map, request, response);
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080B_B_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-09	:	한재희
	***********************************************************************/ 
	public void selectOGM080B_B_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080B_B_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080B_B_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080B.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void selectOGM080B(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080B", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080B_B.xml
	 * @exception 
	 * @see
	 * 	- 2011-12-02	:	한재희
	***********************************************************************/ 
	public void selectOGM080B_B(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080B_B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080B_B", list);
		new MiPlatformView().render(map, request, response);
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-작업내역코드  ogm080B_B.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void saveOGM080B_B(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080B_B");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			String comps = pArg.get("COMPS").toString();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", comps);
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("TABLENM_B", (String)pArg.get("TABLENM_B"));
			pData.put("FIELD1_B", (String)pArg.get("FIELD1_B"));
			pData.put("FIELD2_B", (String)pArg.get("FIELD2_B"));
			pData.put("FIELD3_B", (String)pArg.get("FIELD3_B"));			
			pData.put("STCODE", (String)pArg.get("STCODE"));
//			pData.put("TABLENM", (String)pArg.get("TABLENM"));
//			pData.put("FIELD1", (String)pArg.get("FIELD1"));
//			pData.put("FIELD2", (String)pArg.get("FIELD2"));
			rowType = (String)pData.get("ROW_TYPE");
			
			if("E1".equals(comps)){
				pData.put("COMPS", comps);
				if("insert".equals(rowType)){
					dao.insertData("psogmlib.insertOGM080B_B" , pData);
				} else if("update".equals(rowType)){
					dao.updateData("psogmlib.updateOGM080B_B" , pData);
				} else if("delete".equals(rowType)){
					dao.deleteData("psogmlib.deleteOGM080B_B" , pData);
				}
			} else {
				if("insert".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.insertData("psogmlib.insertOGM080B_B" , pData);
					pData.put("COMPS", "S1");
					dao.insertData("psogmlib.insertOGM080B_B" , pData);
					pData.put("COMPS", "H1");
					dao.insertData("psogmlib.insertOGM080B_B" , pData);
				}
				else if("update".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.updateData("psogmlib.updateOGM080B_B" , pData);
					pData.put("COMPS", "S1");
					dao.updateData("psogmlib.updateOGM080B_B" , pData);
					pData.put("COMPS", "H1");
					dao.updateData("psogmlib.updateOGM080B_B" , pData);
				}
				else if("delete".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.deleteData("psogmlib.deleteOGM080B_B" , pData);
					pData.put("COMPS", "S1");
					dao.deleteData("psogmlib.deleteOGM080B_B" , pData);
					pData.put("COMPS", "H1");
					dao.deleteData("psogmlib.deleteOGM080B_B" , pData);
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
	 * 	-작업내역코드  ogm080B.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void saveOGM080B(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080B");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			String comps = pArg.get("COMPS").toString();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", comps);
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("TABLENM", (String)pArg.get("TABLENM"));
			pData.put("FIELD1", (String)pArg.get("FIELD1"));
			pData.put("FIELD2", (String)pArg.get("FIELD2"));
			rowType = (String)pData.get("ROW_TYPE");
			if("E1".equals(comps)){
				pData.put("COMPS", comps);
				if("insert".equals(rowType)){
					dao.insertData("psogmlib.insertOGM080B" , pData);
				} else if("update".equals(rowType)){
					dao.updateData("psogmlib.updateOGM080B" , pData);
				} else if("delete".equals(rowType)){
					dao.deleteData("psogmlib.deleteOGM080B" , pData);
				}
			} else {
				if("insert".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.insertData("psogmlib.insertOGM080B" , pData);
					pData.put("COMPS", "S1");
					dao.insertData("psogmlib.insertOGM080B" , pData);
					pData.put("COMPS", "H1");
					dao.insertData("psogmlib.insertOGM080B" , pData);
				}
				else if("update".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.updateData("psogmlib.updateOGM080B" , pData);
					pData.put("COMPS", "S1");
					dao.updateData("psogmlib.updateOGM080B" , pData);
					pData.put("COMPS", "H1");
					dao.updateData("psogmlib.updateOGM080B" , pData);
				}
				else if("delete".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.deleteData("psogmlib.deleteOGM080B" , pData);
					pData.put("COMPS", "S1");
					dao.deleteData("psogmlib.deleteOGM080B" , pData);
					pData.put("COMPS", "H1");
					dao.deleteData("psogmlib.deleteOGM080B" , pData);
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
	 * 	- 작업내역코드 -  ogm080C_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-12-01	:	한재희
	***********************************************************************/ 
	public void selectOGM080C_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080C_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080C_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080C_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-09	:	한재희
	***********************************************************************/ 
	public void selectOGM080C_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080C_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080C_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 부품분류코드 -  ogm080C.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void selectOGM080C(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080C", list);
		new MiPlatformView().render(map, request, response);
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-부품분류코드  ogm080C.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void saveOGM080C(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080C");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			String comps = pArg.get("COMPS").toString();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", comps);
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("TABLENM", (String)pArg.get("TABLENM"));
			pData.put("FIELD1", (String)pArg.get("FIELD1"));
			pData.put("FIELD2", (String)pArg.get("FIELD2"));
			rowType = (String)pData.get("ROW_TYPE");
			
			if("E1".equals(comps)){
				pData.put("COMPS", comps);
				if("insert".equals(rowType)){
					dao.insertData("psogmlib.insertOGM080C" , pData);
				} else if("update".equals(rowType)){
					dao.updateData("psogmlib.updateOGM080C" , pData);
				} else if("delete".equals(rowType)){
					dao.deleteData("psogmlib.deleteOGM080C" , pData);
				}
			} else {
				if("insert".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.insertData("psogmlib.insertOGM080C" , pData);
					pData.put("COMPS", "S1");
					dao.insertData("psogmlib.insertOGM080C" , pData);
					pData.put("COMPS", "H1");
					dao.insertData("psogmlib.insertOGM080C" , pData);
				}
				else if("update".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.updateData("psogmlib.updateOGM080C" , pData);
					pData.put("COMPS", "S1");
					dao.updateData("psogmlib.updateOGM080C" , pData);
					pData.put("COMPS", "H1");
					dao.updateData("psogmlib.updateOGM080C" , pData);
				}
				else if("delete".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.deleteData("psogmlib.deleteOGM080C" , pData);
					pData.put("COMPS", "S1");
					dao.deleteData("psogmlib.deleteOGM080C" , pData);
					pData.put("COMPS", "H1");
					dao.deleteData("psogmlib.deleteOGM080C" , pData);
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
	 * 	- 작업내역코드 -  ogm080C_C_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-12-07	:	한재희
	***********************************************************************/ 
	public void selectOGM080C_C_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080C_C_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080C_C_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080C_C_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-09	:	한재희
	***********************************************************************/ 
	public void selectOGM080C_C_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080C_C_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080C_C_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080C_C.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-09	:	한재희
	***********************************************************************/ 
	public void selectOGM080C_C(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080C_C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080C_C", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-부품분류코드  ogm080C_C.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-09	:	한재희
	***********************************************************************/ 
	public void saveOGM080C_C(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080C_C");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			String comps = pArg.get("COMPS").toString();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", comps);;
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("TABLENM_C", (String)pArg.get("TABLENM_C"));
			pData.put("FIELD1_C", (String)pArg.get("FIELD1_C"));
			pData.put("FIELD2_C", (String)pArg.get("FIELD2_C"));
			pData.put("FIELD3_C", (String)pArg.get("FIELD3_C"));
			pData.put("FIELD4_C", (String)pArg.get("FIELD4_C"));
			pData.put("FIELD5_C", (String)pArg.get("FIELD5_C"));
			pData.put("STCODE", (String)pArg.get("STCODE"));
			rowType = (String)pData.get("ROW_TYPE");
			if("E1".equals(comps)){
				pData.put("COMPS", comps);
				if("insert".equals(rowType)){
					dao.insertData("psogmlib.insertOGM080C_C" , pData);
				} else if("update".equals(rowType)){
					dao.updateData("psogmlib.updateOGM080C_C" , pData);
				} else if("delete".equals(rowType)){
					dao.deleteData("psogmlib.deleteOGM080C_C" , pData);
				}
			} else {
				if("insert".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.insertData("psogmlib.insertOGM080C_C" , pData);
					pData.put("COMPS", "S1");
					dao.insertData("psogmlib.insertOGM080C_C" , pData);
					pData.put("COMPS", "H1");
					dao.insertData("psogmlib.insertOGM080C_C" , pData);
				}
				else if("update".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.updateData("psogmlib.updateOGM080C_C" , pData);
					pData.put("COMPS", "S1");
					dao.updateData("psogmlib.updateOGM080C_C" , pData);
					pData.put("COMPS", "H1");
					dao.updateData("psogmlib.updateOGM080C_C" , pData);
				}
				else if("delete".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.deleteData("psogmlib.deleteOGM080C_C" , pData);
					pData.put("COMPS", "S1");
					dao.deleteData("psogmlib.deleteOGM080C_C" , pData);
					pData.put("COMPS", "H1");
					dao.deleteData("psogmlib.deleteOGM080C_C" , pData);
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
	 * 	- 작업내역코드 -  ogm080D_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	한재희
	***********************************************************************/ 
	public void selectOGM080D_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080D_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080D_Chk", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080D_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	한재희
	***********************************************************************/ 
	public void selectOGM080D_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080D_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080D_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080D_D_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	한재희
	***********************************************************************/ 
	public void selectOGM080D_D_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080D_D_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080D_D_Chk", list);
		new MiPlatformView().render(map, request, response);
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080D_D_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	한재희
	***********************************************************************/ 
	public void selectOGM080D_D_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080D_D_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080D_D_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 효과코드 -  ogm080D.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void selectOGM080D(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080D", list);
		new MiPlatformView().render(map, request, response);
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-효과코드  ogm080D.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void saveOGM080D(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080D");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			String comps = pArg.get("COMPS").toString();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", comps);
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("TABLENM", (String)pArg.get("TABLENM"));
			pData.put("FIELD1", (String)pArg.get("FIELD1"));
			pData.put("FIELD2", (String)pArg.get("FIELD2"));
			rowType = (String)pData.get("ROW_TYPE");
			if("E1".equals(comps)){
				pData.put("COMPS", comps);
				if("insert".equals(rowType)){
					dao.insertData("psogmlib.insertOGM080D" , pData);
				} else if("update".equals(rowType)){
					dao.updateData("psogmlib.updateOGM080D" , pData);
				} else if("delete".equals(rowType)){
					dao.deleteData("psogmlib.deleteOGM080D" , pData);
				}
			} else {
				if("insert".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.insertData("psogmlib.insertOGM080D" , pData);
					pData.put("COMPS", "S1");
					dao.insertData("psogmlib.insertOGM080D" , pData);
					pData.put("COMPS", "H1");
					dao.insertData("psogmlib.insertOGM080D" , pData);
				}
				else if("update".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.updateData("psogmlib.updateOGM080D" , pData);
					pData.put("COMPS", "S1");
					dao.updateData("psogmlib.updateOGM080D" , pData);
					pData.put("COMPS", "H1");
					dao.updateData("psogmlib.updateOGM080D" , pData);
				}
				else if("delete".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.deleteData("psogmlib.deleteOGM080D" , pData);
					pData.put("COMPS", "S1");
					dao.deleteData("psogmlib.deleteOGM080D" , pData);
					pData.put("COMPS", "H1");
					dao.deleteData("psogmlib.deleteOGM080D" , pData);
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
	 * 	- 작업내역코드 -  ogm080D_D.xml
	 * @exception 
	 * @see
	 * 	- 2011-12-02	:	한재희
	***********************************************************************/ 
	public void selectOGM080D_D(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080D_D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080D_D", list);
		new MiPlatformView().render(map, request, response);
	}
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-작업내역코드  ogm080D_D.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void saveOGM080D_D(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080D_D");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			String comps = pArg.get("COMPS").toString();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", comps);
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("TABLENM_D", (String)pArg.get("TABLENM_D"));
			pData.put("FIELD1_D", (String)pArg.get("FIELD1_D"));
			pData.put("FIELD2_D", (String)pArg.get("FIELD2_D"));
			pData.put("FIELD3_D", (String)pArg.get("FIELD3_D"));			
			pData.put("STCODE", (String)pArg.get("STCODE"));
//			pData.put("TABLENM", (String)pArg.get("TABLENM"));
//			pData.put("FIELD1", (String)pArg.get("FIELD1"));
//			pData.put("FIELD2", (String)pArg.get("FIELD2"));
			rowType = (String)pData.get("ROW_TYPE");
			if("E1".equals(comps)){
				pData.put("COMPS", comps);
				if("insert".equals(rowType)){
					dao.insertData("psogmlib.insertOGM080D_D" , pData);
				} else if("update".equals(rowType)){
					dao.updateData("psogmlib.updateOGM080D_D" , pData);
				} else if("delete".equals(rowType)){
					dao.deleteData("psogmlib.deleteOGM080D_D" , pData);
				}
			} else {
				if("insert".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.insertData("psogmlib.insertOGM080D_D" , pData);
					pData.put("COMPS", "S1");
					dao.insertData("psogmlib.insertOGM080D_D" , pData);
					pData.put("COMPS", "H1");
					dao.insertData("psogmlib.insertOGM080D_D" , pData);
				}
				else if("update".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.updateData("psogmlib.updateOGM080D_D" , pData);
					pData.put("COMPS", "S1");
					dao.updateData("psogmlib.updateOGM080D_D" , pData);
					pData.put("COMPS", "H1");
					dao.updateData("psogmlib.updateOGM080D_D" , pData);
				}
				else if("delete".equals(rowType)){
					pData.put("COMPS", "C1");
					dao.deleteData("psogmlib.deleteOGM080D_D" , pData);
					pData.put("COMPS", "S1");
					dao.deleteData("psogmlib.deleteOGM080D_D" , pData);
					pData.put("COMPS", "H1");
					dao.deleteData("psogmlib.deleteOGM080D_D" , pData);
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
	 * 	- 작업내역코드 -  ogm080E_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-12-01	:	한재희
	***********************************************************************/ 
	public void selectOGM080E_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080E_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080E_Chk", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080E_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-09	:	한재희
	***********************************************************************/ 
	public void selectOGM080E_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080E_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080E_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080E_E_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-12-07	:	한재희
	***********************************************************************/ 
	public void selectOGM080E_E_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080E_E_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080E_E_Chk", list);
		new MiPlatformView().render(map, request, response);
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080E_E_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-09	:	한재희
	***********************************************************************/ 
	public void selectOGM080E_E_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080E_E_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080E_E_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 실시부서코드 -  ogm080E.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void selectOGM080E(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080E", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080E", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 작업내역코드 -  ogm080E_E.xml
	 * @exception 
	 * @see
	 * 	- 2011-12-02	:	한재희
	***********************************************************************/ 
	public void selectOGM080E_E(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080E_E", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm080E_E", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-작업내역코드  ogm080E_E.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void saveOGM080E_E(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080E_E");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("TABLENM_E", (String)pArg.get("TABLENM_E"));
			pData.put("FIELD1_E", (String)pArg.get("FIELD1_E"));
			pData.put("FIELD2_E", (String)pArg.get("FIELD2_E"));
//			pData.put("FIELD3_E", (String)pArg.get("FIELD3_E"));			
			pData.put("STCODE", (String)pArg.get("STCODE"));
//			pData.put("TABLENM", (String)pArg.get("TABLENM"));
//			pData.put("FIELD1", (String)pArg.get("FIELD1"));
//			pData.put("FIELD2", (String)pArg.get("FIELD2"));
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM080E_E" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM080E_E" , pData);
			}
			else if("delete".equals(rowType)){
				dao.deleteData("psogmlib.deleteOGM080E_E" , pData);
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
	 * 	-실시부서코드  ogm080E.xml
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	한재희
	***********************************************************************/ 
	public void saveOGM080E(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm080E");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("TABLENM", (String)pArg.get("TABLENM"));
			pData.put("FIELD1", (String)pArg.get("FIELD1"));
			pData.put("FIELD2", (String)pArg.get("FIELD2"));
			pData.put("FIELD3", (String)pArg.get("FIELD3"));
			pData.put("FIELD4", (String)pArg.get("FIELD4"));
			//pData.put("FIELD5", (String)pArg.get("FIELD5"));
			//pData.put("FIELD6", (String)pArg.get("FIELD6"));
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM080E" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM080E" , pData);
			}
			else if("delete".equals(rowType)){
				dao.updateData("psogmlib.deleteOGM080E" , pData);
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
	 * 	- 작업내역코드 -  ogm080F.xml
	 * @exception 
	 * @see
	 * 	- 2016-07-01	:	제환복
	***********************************************************************/ 
/*	public void selectOGM080F(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM080F", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM080F", list);
		new MiPlatformView().render(map, request, response);
	}*/
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 설비대장마스타관리 -  ogm090A_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:   한재희
	***********************************************************************/ 
	public void selectOGM090A_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090A_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090A_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 설비대장마스타관리 -  ogm090A_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:   한재희
	***********************************************************************/ 
	public void selectOGM090A_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090A_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090A_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 설비대장마스타관리 -  ogm090A.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	이상건
	***********************************************************************/ 
	public void selectOGM090A(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090A", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090A", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-설비대장마스타    저장  ogm090A.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	이상건
	***********************************************************************/ 
	public void saveOGM090A(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm090A");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM090A" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM090A" , pData);
			}
			else if("delete".equals(rowType)){
				dao.deleteData("psogmlib.deleteOGM090A" , pData);
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
	 * 	- 라인코드마스타관리 -  ogm090B_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:   한재희
	***********************************************************************/ 
	public void selectOGM090B_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090B_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090B_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 라인코드마스타관리 -  ogm090B.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-14	:	이상건
	***********************************************************************/ 
	public void selectOGM090B(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090B", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-라인코드마스타    저장  ogm090B.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	이상건
	***********************************************************************/ 
	public void saveOGM090B(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm090B");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM090B" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM090B" , pData);
			}
			else if("delete".equals(rowType)){
				dao.updateData("psogmlib.deleteOGM090B" , pData);
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
	 * 	- 라인코드마스타관리 -  ogm090B.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-14	:	이상건
	***********************************************************************/ 
	public void selectOGM090B_B(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090B_B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090B_B", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 라인코드마스타관리 -  ogm090B_B_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:   한재희
	***********************************************************************/ 
	public void selectOGM090B_B_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090B_B_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090B_B_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 라인코드마스타관리 -  ogm090B_B_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-09	:	한재희
	***********************************************************************/ 
	public void selectOGM090B_B_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090B_B_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090B_B_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-라인코드설비리스트   저장  ogm090B_B.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	이상건
	***********************************************************************/ 
	public void saveOGM090B_B(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm090B_B");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			pData.put("LINCD", (String)pArg.get("LINCD"));
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM090B_B" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM090B_B" , pData);
			}
			else if("delete".equals(rowType)){
				dao.updateData("psogmlib.deleteOGM090B_B" , pData);
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
	 * 	- 팀코드마스타관리 -  ogm090C_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-20	:	한재희
	***********************************************************************/ 
	public void selectOGM090C_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090C_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090C_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 팀코드마스타관리 -  ogm090C_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-20	:	한재희
	***********************************************************************/ 
	public void selectOGM090C_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090C_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090C_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 팀코드마스타관리 -  ogm090C.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-17	:	이상건
	***********************************************************************/ 
	public void selectOGM090C(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090C", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-팀코드마스타   저장  ogm090C.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	이상건
	***********************************************************************/ 
	public void saveOGM090C(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm090C");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			/*pData.put("TIMCD", (String)pArg.get("TIMCD"));*/
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM090C" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM090C" , pData);
			}
			else if("delete".equals(rowType)){
				dao.updateData("psogmlib.deleteOGM090C" , pData);
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
	 * 	- 파트코드마스타관리 -  ogm090D_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-20	:	한재희
	***********************************************************************/ 
	public void selectOGM090D_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090D_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090D_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 파트코드마스타관리 -  ogm090D_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2012-01-20	:	한재희
	***********************************************************************/ 
	public void selectOGM090D_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090D_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090D_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 파트코드마스타관리 -  ogm090D.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-17	:	이상건
	***********************************************************************/ 
	public void selectOGM090D(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090D", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-파트코드마스타   저장  ogm090D.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-17	:	이상건
	***********************************************************************/ 
	public void saveOGM090D(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm090D");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			/*pData.put("TIMCD", (String)pArg.get("TIMCD"));*/
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM090D" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM090D" , pData);
			}
			else if("delete".equals(rowType)){
				dao.updateData("psogmlib.deleteOGM090D" , pData);
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
	 * 	- 반코드마스타관리 -  ogm090E_Chk.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-17	:	한재희
	***********************************************************************/ 
	public void selectOGM090E_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090E_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090E_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 반코드마스타관리 -  ogm090E_DelChk.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-17	:	한재희
	***********************************************************************/ 
	public void selectOGM090E_DelChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090E_DelChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090E_DelChk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 반코드마스타관리 -  ogm090E.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-17	:	이상건
	***********************************************************************/ 
	public void selectOGM090E(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090E", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090E", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-반코드마스타   저장  ogm090E.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-17	:	이상건
	***********************************************************************/ 
	public void saveOGM090E(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm090E");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		Iterator it = pList.iterator();
		String rowType="";
		while(it.hasNext()){
			Map pData = (Map)it.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			rowType = (String)pData.get("ROW_TYPE");
			if("insert".equals(rowType)){
				dao.insertData("psogmlib.insertOGM090E" , pData);
			}
			else if("update".equals(rowType)){
				dao.updateData("psogmlib.updateOGM090E" , pData);
			}
			else if("delete".equals(rowType)){
				dao.updateData("psogmlib.deleteOGM090E" , pData);
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
	 * 	- 제품코드(라인)마스터 -  ogm090F.xml
	 * @exception 
	 * @see
	 * 	- 2016-12-09	:	제환복
	***********************************************************************/ 
	public void selectOBC030PF(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBC030PF", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBC030PF", list);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOGM090F(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM090F", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm090F", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	-제품코드(라인)마스타   저장  ogm090E.xml
	 * @exception 
	 * @see
	 * 	- 2016-12-09	:	제환복
	***********************************************************************/ 
	public void saveOGM090F(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm090F");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_ogm090F");
		//////////////////////////////////////////////////////////////		
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
			
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_PRDCD", (String) pData.get("PRDCD"));
					pData.put("OLD_LINCD", (String) pData.get("LINCD"));
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOGM090F_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PRDCD", pData.get("OLD_PRDCD"));
							errMap.put("LINCD", pData.get("OLD_LINCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOGM090F", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("ADUSR", (String)pArg.get("ADUSR"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					if ("insert".equals(rowType)) {
						pData.put("OLD_PRDCD", (String) pData.get("PRDCD"));
						pData.put("OLD_LINCD", (String) pData.get("LINCD"));
						Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOGM090F_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("PRDCD", pData.get("OLD_PRDCD"));
								errMap.put("LINCD", pData.get("OLD_LINCD"));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("psogmlib.insertOGM090F", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						pData.put("OLD_PRDCD", ds.getOrgBuffColumn(bufCnt, "PRDCD").getString());
						pData.put("OLD_LINCD", ds.getOrgBuffColumn(bufCnt, "LINCD").getString());
						Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOGM090F_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(0)){
								//update 불가(대상이 없음)
								HashMap errMap = new HashMap();
								errMap.put("PRDCD", pData.get("OLD_PRDCD"));
								errMap.put("LINCD", pData.get("OLD_LINCD"));
								errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.updateData("psogmlib.updateOGM090F", pData);
							}
						}
					}
				}
				bufCnt++;
			}       
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_ogm090F_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 발주중 품목   ogm101.xml
	 * @exception 
	 * @see
	 * 	- 2011-08-24	:	한재희   
	***********************************************************************/
	public void selectOGM101(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM101", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM101", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 설비별 출고현황   ogm121.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-15	:	한재희   
	***********************************************************************/
	public void selectOGM121(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM121", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM121", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 거래처별 미납현황   ogm112.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-19	:	한재희   
	***********************************************************************/
	public void selectOGM112(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM112", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM112", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 부품별 납입실적조회   ogm111.xml
	 * @exception 
	 * @see
	 * 	- 2011-09-21	:	한재희   
	***********************************************************************/
	public void selectOGM111(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM111", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM111", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 장기재고현황   ogm147.xml
	 * @exception 
	 * @see
	 * 	- 2011-10-11	:	한재희   
	***********************************************************************/
	public void selectOGM147(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM147", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM147", list);
		new MiPlatformView().render(map, request, response);
	}

	//end line		
	//start 2011/08/23 JHB
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_작업개시등록
	 * @exception 
	 * @see
	 * 	- 2011-08-23	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm200_chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM200_chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm200_chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_작업개시등록 _설비선택1
	 * @exception 
	 * @see 
	 * 	- 2011-08-24	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm200_pop1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm200_pop1", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm200_pop1", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_작업개시등록 _설비선택2
	 * @exception 
	 * @see
	 * 	- 2011-08-24	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm200_pop2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm200_pop2", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm200_pop2", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_작업개시등록 _설비선택
	 * @exception 
	 * @see
	 * 	- 2011-08-24	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm200_pop(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm200_pop", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm200_pop", list);
		new MiPlatformView().render(map, request, response); 
	} 
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_작업개시등록 _설비선택
	 * @exception 
	 * @see
	 * 	- 2011-08-24	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm200_method(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm200_method", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm200_method", list);
		new MiPlatformView().render(map, request, response); 
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_작업개시등록 _책임자변경
	 * @exception 
	 * @see
	 * 	- 2011-08-30	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm200_hmd020pf(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm200_hmd020pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm200_hmd020pf", list);
		new MiPlatformView().render(map, request, response); 
	}	
	   
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_작업개시등록_등록
	 * @exception 
	 * @see
	 * 	- 2011-08-30	:	제환복
	***********************************************************************/ 	
	public void saveOGM200(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.insertOGM200" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _일반책임자등급
	 * @exception 
	 * @see
	 * 	- 2011-09-03 	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM202_obj200pf_02(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm202_obj200pf_02", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm202", list);
		new MiPlatformView().render(map, request, response); 
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _관리자등급
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM202_obj200pf_05(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm202_obj200pf_05", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm202", list);
		new MiPlatformView().render(map, request, response); 
	}
	
	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _내외구분
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbInoCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc020pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc020pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _우선도
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbEmgCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc010pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc010pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _품질확인
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbQorCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc170pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc170pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _설비부위분류
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbSubas(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc230pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc230pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _재발방지
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbRepCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc150pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc150pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _ASSY부품
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbComCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc220pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc220pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _ASSY부품_PopKndCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_PopKndCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc060pf_01", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc060pf_01", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _ASSY부품_PopKndCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_PopUmhen(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc060pf_02", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc060pf_02", list);
		new MiPlatformView().render(map, request, response); 
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _단위부품_cmbDecCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbDecCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc070pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc070pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _단위부품_PopDKndCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_PopDKndCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc050pf_01", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc050pf_01", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _단위부품_PopDUmhen
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_PopDUmhen(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc050pf_02", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc050pf_02", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _처치
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbChoCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc160pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc160pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _현상_cmbHyoCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbHyoCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc190pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc190pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업  _현상_PopHKndCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_PopHKndCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc180pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc180pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업  _원인_cmbCauCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbCauCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc120pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc120pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업  _원인_cmbCauCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_PopCKndCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc110pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc110pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업  _실원인_cmbTruCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbTruCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc100pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc100pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업  _실원인_PopTKndCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_PopTKndCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc090pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc090pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업  _효과구분_cmbEffCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_cmbEffCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc210pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc210pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업  _효과구분_PopEKndCd
	 * @exception 
	 * @see
	 * 	- 2011-09-03	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_PopEKndCd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obc200pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc200pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _Get Data
	 * @exception 
	 * @see
	 * 	- 2011-09-21	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM203_obj200pf_03(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_obj200pf_03", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj200pf_03", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_진행중작업 _예비조회
	 * @exception 
	 * @see
	 * 	- 2011-09-22	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm010pf(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm010pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm010pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_신규이력등록_교환부품등록
	 * @exception 
	 * @see
	 * 	- 2011-09-22	:	제환복
	***********************************************************************/ 	
	/*
	public void saveOGM205(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.insertData("psogmlib.insertOgm205_obj220pf" , pData);
		new MiPlatformView().render(null, request, response);
	}
	*/
	public void saveOGM205(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm205_obj220pf");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		String Sjisno = (String)pMap.get("JISNO");
		String Scomps = (String)pMap.get("COMPS");
		String Slib2 = (String)pMap.get("LIB2");
		
		Iterator it = pList.iterator();
		String rowType = "";
		dao.startTransaction();
		while (it.hasNext()) {
			
			Map pData = (Map) it.next();
			pData.put("JISNO", Sjisno);
			pData.put("COMPS", Scomps);
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOgm205_obj220pf", pData);
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateOgm205_obj220pf", pData);
			}
		}
		dao.endTransaction();
		new MiPlatformView().render(null, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_신규이력등록_교환부품등록 trigger용
	 * @exception 
	 * @see
	 * 	- 2011-09-22	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm205_obj220pf(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm205_obj220pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm205_obj220pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_신규이력등록_교환부품삭제
	 * @exception 
	 * @see
	 * 	- 2011-09-22	:	제환복
	***********************************************************************/ 	
	public void deleteOGM205(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.deleteData("psogmlib.deleteOgm205_obj220pf" , pData);
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_신규이력등록_개선상세_개선상세 등록여부확인
	 * @exception 
	 * @see
	 * 	- 2011-09-22	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm204_obj210pf(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm204_obj210pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj210pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_개선상세_등록
	 * @exception 
	 * @see
	 * 	- 2011-09-29	:	제환복
	***********************************************************************/ 	
	public void saveOGM204_obj210pf_insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
//System.out.println("pData====>"+pData);
		String flag = (String)pData.get("FLAG");
//System.out.println("flag====>"+flag);
		if(flag.equals("insert")){
		dao.insertData("psogmlib.insertOgm204_obj210pf" , pData);
		}
		else if(flag.equals("update")){
		dao.updateData("psogmlib.updateOgm204_obj210pf" , pData);
		}
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_신규이력등록_개선상세_도면 등록여부확인
	 * @exception 
	 * @see
	 * 	- 2011-09-22	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm204_obj210pf_01(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm204_obj210pf_01", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj210pf_01", list);
		new MiPlatformView().render(map, request, response); 
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_개선상세_도면등록
	 * @exception 
	 * @see
	 * 	- 2011-09-29	:	제환복
	***********************************************************************/ 	
	public void saveOGM204_obj210pf_addImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
//System.out.println("pData====>"+pData);
		dao.updateData("psogmlib.updateOgm204_obj210pf_addImg" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력검색_실시부서조회
	 * @exception 
	 * @see
	 * 	- 2011-10-05	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm313_cmbsdpcd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm313_obc250pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc250pf", list);
		new MiPlatformView().render(map, request, response); 
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력검색 _파트조회
	 * @exception 
	 * @see 
	 * 	- 2011-10-05	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm313_cmbprtcd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm313_cmbprtcd", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc270pf", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력검색 _라인조회
	 * @exception 
	 * @see 
	 * 	- 2011-10-05	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm313_cmblincd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm313_cmblincd", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc030pf_01", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력검색 _보전이력분석조회
	 * @exception 
	 * @see 
	 * 	- 2011-10-06	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm313_ogm219(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm313_gms219", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj200pf_03", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력검색 _교환품목록검색
	 * @exception 
	 * @see 
	 * 	- 2011-10-06	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm219_obj220pf_InqParts(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.select_obj220pf_InqParts", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj220pf", list);
		new MiPlatformView().render(map, request, response);
	} 
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력검색 _첨부파일 존재 검색
	 * @exception 
	 * @see 
	 * 	- 2011-10-06	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm219_obj230pf(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm219_obj230pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj230pf", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력검색 _개선상세 존재 검색
	 * @exception 
	 * @see 
	 * 	- 2011-10-06	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm219_obj210pf(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm219_obj210pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj210pf", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력등록_이력입력
	 * @exception 
	 * @see
	 * 	- 2011-10-06	:	제환복
	***********************************************************************/ 	
	public void saveOGM203(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
System.out.println("pData====>"+pData);
		String flag = (String)pData.get("FLAG");
System.out.println("flag====>"+flag);
		if(flag.equals("insert")){
		dao.insertData("psogmlib.insertOgm203", pData);
		}
		else if(flag.equals("update")){
		dao.updateData("psogmlib.updateOgm203", pData);
		}
		new MiPlatformView().render(null, request, response);
	} 
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력검색 _작업보고 검색결과 LIST
	 * @exception 
	 * @see 
	 * 	- 2011-10-06	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm314_onload(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);

//System.out.println("ANDOR===>"+(String)pData.get("ANDOR"));
		String andor=(String)pData.get("ANDOR");
		String hyosn1=(String)pData.get("HYOSN1");
		String hyosn2=(String)pData.get("HYOSN2");
		String hyosn3=(String)pData.get("HYOSN3");
		String wonin1=(String)pData.get("WONIN1");
		String wonin2=(String)pData.get("WONIN2");
		String wonin3=(String)pData.get("WONIN3");
		String daech1=(String)pData.get("DAECH1");
		String daech2=(String)pData.get("DAECH2");
		String daech3=(String)pData.get("DAECH3");
		
		String orHyosn="";
		String orWonin="";
		String orDaech="";
		if(andor.equals("or")){

			if(hyosn1.length() != 0 && hyosn2.length() != 0 && hyosn3.length() != 0) 
			{
				orHyosn = "and ( a.hyosn like '%" + hyosn1 + "%' or a.hyosn like '%" + hyosn2 + "%' or a.hyosn like '%" + hyosn3 + "%' )";			
			}
			else if(hyosn1.length() != 0 && hyosn2.length() != 0 && hyosn3.length() == 0)
			{
				orHyosn = "and ( a.hyosn like '%" + hyosn1 + "%' or a.hyosn like '%" + hyosn2 + "%')";			
						 
			}else if(hyosn1.length() != 0 && hyosn2.length() == 0 && hyosn3.length() == 0)
			{
				orHyosn = "and ( a.hyosn like '%" + hyosn1 + "%')";			
			}
			pData.put("ORHYOSN", orHyosn);

		
			if(wonin1.length() != 0 && wonin2.length() != 0 && wonin3.length() != 0) 
			{
				orWonin += "and ( a.wonin like '%" + wonin1 + "%' or a.wonin like '%" + wonin2 + "%' or a.wonin like '%" + wonin3 + "%' )";			
				
			}
			else if(wonin1.length() != 0 && wonin2.length() != 0 && wonin3.length() == 0)
			{
				orWonin += "and ( a.wonin like '%" + wonin1 + "%' or a.wonin like '%" + wonin2 + "%')";	
			}
			else if(wonin1.length() != 0 && wonin2.length() == 0 && wonin3.length() == 0)
			{
				orWonin += "and ( a.wonin like '%" + wonin1 + "%')";	
			}
			pData.put("ORWONIN", orWonin);
			
			if(daech1.length() != 0 && daech2.length() != 0 && daech3.length() != 0) 
			{
				orDaech += "and ( a.daech like '%" + daech1 + "%' or a.daech like '%" + daech2 + "%' or a.daech like '%" + daech3 + "%' )";			
				
			}
			else if(daech1.length() != 0 && daech2.length() != 0 && daech3.length() == 0)
			{
				orDaech += "and ( a.daech like '%" + daech1 + "%' or a.daech like '%" + daech2 + "%')";	
			}
			else if(daech1.length() != 0 && daech2.length() == 0 && daech3.length() == 0)
			{
				orDaech += "and ( a.daech like '%" + daech1 + "%')";	
			}
			pData.put("ORDAECH", orDaech);	
		}
//System.out.println("orHyosn===>"+orHyosn);
//System.out.println("orWonin===>"+orWonin);
//System.out.println("orDaech===>"+orDaech);
		
		List list = dao.getListData("psogmlib.selectOgm314_onload", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm314", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력분석검색 
	 * @exception 
	 * @see 
	 * 	- 2011-10-13	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm317_onload(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		//System.out.println("pData"+pData);
		List list = dao.getListData("psogmlib.selectOgm317_onload", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj200pf", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력분석검색 _보전실적분석 상세
	 * @exception 
	 * @see 
	 * 	- 2011-10-19	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm318_onload(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
//System.out.println("pData"+pData);
		List list = dao.getListData("psogmlib.selectOgm318_onload", pData);
	
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj200pf_16", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_보전이력분석검색 _보전실적분석 상세
	 * @exception 
	 * @see 
	 * 	- 2011-10-19	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm319_onload(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
System.out.println("pData"+pData);
		List list = dao.getListData("psogmlib.selectOgm319_onload", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obj200pf_1", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계 _팀조회
	 * @exception 
	 * @see 
	 * 	- 2011-10-24	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm211_timNm(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm211_290pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_obc290pf", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_장시간 정지/고장
	 * @exception 
	 * @see 
	 * 	- 2011-10-24	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm211(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm211", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm211", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_주요라인고장실적
	 * @exception 
	 * @see 
	 * 	- 2011-10-25	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm213(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm213", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm213", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_주요라인고장실적_상세
	 * @exception 
	 * @see 
	 * 	- 2011-10-25	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm215(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm215", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm215", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_주요설고장실적
	 * @exception 
	 * @see 
	 * 	- 2011-10-27	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm212(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm212", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm212", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_주요설비고장실적_상세
	 * @exception 
	 * @see 
	 * 	- 2011-10-27	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm216(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm216", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm216", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_워스트50설비
	 * @exception 
	 * @see 
	 * 	- 2011-10-27	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm214(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm214", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm214", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_부문별실적
	 * @exception 
	 * @see 
	 * 	- 2011-10-27	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm310(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm310", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm310", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_부문별실적_상세
	 * @exception 
	 * @see 
	 * 	- 2011-10-27	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm315(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm315", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm315", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_라인별실적
	 * @exception 
	 * @see 
	 * 	- 2011-10-27	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm311(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm311", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm311", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_라인별실적_상세
	 * @exception  
	 * @see 
	 * 	- 2011-10-27	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm316(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm316", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm316", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_설비No별실적_TextVal
	 * @exception  
	 * @see 
	 * 	- 2011-10-31	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm312_textVal(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm312_textVal", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm312_textVal", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_설비No별실적_GridVal
	 * @exception  
	 * @see 
	 * 	- 2011-10-31	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm312_gridVal(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm312_gridVal", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm312_gridVal", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_보전업무집계_부서별개선효과금액_소속조회
	 * @exception  
	 * @see 
	 * 	- 2011-10-31	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm320_likcd(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm320_likcd", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm320_likcd", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_보전업무집계_부서별개선효과금액_조회
	 * @exception  
	 * @see 
	 * 	- 2011-10-31	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm320_amount_dis(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm320_amount_dis", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm320_amount_dis", list);
		new MiPlatformView().render(map, request, response);
	}
/*
	public void selectOgm320_amount(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm320_amount", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm320_amount", list);
		new MiPlatformView().render(map, request, response);
	}
*/	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_보전업무집계_보전이력분석검색
	 * @exception  
	 * @see 
	 * 	- 2011-11-07	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm321(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm321", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm321", list);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_보전업무집계_실시부서 보전실적
	 * @exception  
	 * @see 
	 * 	- 2011-11-07	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm324(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm324", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm324", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_보전업무집계_실시부서 보전실적상세
	 * @exception  
	 * @see 
	 * 	- 2011-11-07	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm326(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm326", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm326", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_개선상세내역 View
	 * @exception  
	 * @see 
	 * 	- 2011-11-09	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm220(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm220", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm220", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- file upload sample
	 * @exception 
	 * @see 
	 * 	- 2011-10-25	:	이상건
	***********************************************************************/
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 파일업로드
	 * @exception 
	 * @see
	 * 	- 2011-09-29	:	제환복
	***********************************************************************/
	
	public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		DatasetList inDl = pReq.getDatasetList();
		Dataset inDs = inDl.getDataset("ds_uploadFile");
		if(inDs!=null){
			String uploadaaa = request.getContextPath();
			
System.out.print("uploadaaa==>"+uploadaaa);
			//String uploadDir = "C:/upload/";
			String uploadDir = "D:/04.develop/workspace/DENSO/WebContent/bojen/images/";
			//String uploadDir = "http://127.0.0.1/bojen/images/";
			File upDir = new File(uploadDir);
			if(!upDir.exists()) upDir.mkdir();
			inDs.setColumn(0, "FILE_PATH", uploadDir);
			FileUpDown.setFileUp(inDs);	
		}else{
			throw new Exception("Dataset not found..");
		}
		new MiPlatformView().render(null, request, response);		
	} 
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 파일삭제
	 * @exception 
	 * @see
	 * 	- 2011-09-29	:	제환복
	***********************************************************************/	
	@SuppressWarnings("unchecked")
	public void fileDel(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		String fName=(String)pData.get("FNAME");
		String fdir=(String)pData.get("FDIR");
		//String uploadDir = "D:/04.develop/workspace/DENSO/WebContent/bojen/images/";
		String tarFname= fdir + fName;
		
		File fileDel =new File(tarFname);
		
		if (fileDel.delete()){	
			System.out.print("삭제성공==>");
		}else{
			System.out.print("삭제실패==>");
		}
		
		new MiPlatformView().render(null, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 이력편집 완료조회
	 * @exception  
	 * @see 
	 * 	- 2011-11-09	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm203_cmplt(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_cmplt", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm203_cmplt", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력등록_이력삭제
	 * @exception 
	 * @see
	 * 	- 2011-11-23	:	제환복
	***********************************************************************/ 	
	public void delOGM203(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.deleteData("psogmlib.deleteOgm203", pData);	
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력편집_Max_seqNo조회
	 * @exception  
	 * @see 
	 * 	- 2011-11-24	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOGM206_maxSeq(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm206_maxSeq", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm206_maxSeq", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력편집_첨부파일등록
	 * @exception 
	 * @see
	 * 	- 2011-11-24	:	제환복
	***********************************************************************/ 	
	public void saveOGM206_sFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.insertData("psogmlib.insertOgm206_sFile" , pData);
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력편집_첨부파일삭제
	 * @exception 
	 * @see
	 * 	- 2011-11-24	:	제환복
	***********************************************************************/ 	
	public void delOGM206(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.deleteData("psogmlib.deleteOgm206", pData);	
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력조회_개선상세내역 리포트
	 * @exception  
	 * @see 
	 * 	- 2011-11-25	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm220_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm220_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm220_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_실적집계_부서별개선효과금액 년별조회
	 * @exception  
	 * @see 
	 * 	- 2011-11-25	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm323(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm323", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm323", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력편집_레포트
	 * @exception  
	 * @see 
	 * 	- 2011-11-26	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm203_rep(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_rep", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm203_rep", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력편집_jisno Seq
	 * @exception  
	 * @see 
	 * 	- 2011-12-01	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm_maxNum(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm_maxNum", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm_maxNum", list);
		new MiPlatformView().render(map, request, response);
	}
	@SuppressWarnings("unchecked")
	public void updateOgm_maxNum(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOgm_maxNum" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력편집_재발방지수리
	 * @exception  
	 * @see 
	 * 	- 2011-12-01	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm203_pepcdChk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm203_pepcdChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm203_pepcdChk", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_이력등록_재발방지등록
	 * @exception 
	 * @see
	 * 	- 2011-10-06	:	제환복
	***********************************************************************/ 	
	public void saveOGM203_pepcd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		String flag = (String)pData.get("FLAG");
		if(flag.equals("insert")){
		dao.insertData("psogmlib.insertOgm203_pepcd", pData);
		}
		else if(flag.equals("update")){
		dao.updateData("psogmlib.updateOgm203_pepcd", pData);
		}
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 보전이력_예비품조회
	 * @exception  
	 * @see 
	 * 	- 2012-01-05	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm205_pop(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm205_pop", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm205_pop", list);
		new MiPlatformView().render(map, request, response);
	}	
//end JHB
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB DEVID 조회
	 * @exception 
	 * @see
	 * 	- 2012-01-02	:	이상건
	***********************************************************************/ 	
	public void selectDevID(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectDevID", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DevID", list);
		new MiPlatformView().render(map, request, response);
	} 

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 공정코드 조회
	 * @exception 
	 * @see
	 * 	- 2012-01-02	:	이상건
	***********************************************************************/ 	
	public void selectProc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectProc", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Proc", list);
		new MiPlatformView().render(map, request, response);
	} 

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 공정코드 조회
	 * @exception 
	 * @see
	 * 	- 2012-01-02	:	이상건
	***********************************************************************/ 	
	public void selectHouse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectHouse", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_House", list);
		new MiPlatformView().render(map, request, response);
	} 
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 작업시간코드 조회
	 * @exception 
	 * @see
	 * 	- 2012-01-02	:	이상건
	***********************************************************************/ 	
	public void selectQRTime(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectQRTime", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_QRTime", list);
		new MiPlatformView().render(map, request, response);
	} 
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 일별제품실적조회
	 * @exception 
	 * @see
	 * 	- 2012-01-02	:	이상건
	***********************************************************************/ 	
	public void selectOgm520(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm520", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm520", list);
		new MiPlatformView().render(map, request, response);
	} 
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 일별제품실적조회 상세
	 * @exception 
	 * @see
	 * 	- 2012-01-02	:	이상건
	***********************************************************************/ 	
	public void selectOgm520D(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm520D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm520D", list);
		new MiPlatformView().render(map, request, response);
	} 
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 시간대별제품실적조회
	 * @exception 
	 * @see
	 * 	- 2012-01-03	:	이상건
	***********************************************************************/ 	
	public void selectOgm530(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm530", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm530", list);
		new MiPlatformView().render(map, request, response);
	} 
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 시간대별제품실적조회
	 * @exception 
	 * @see
	 * 	- 2012-01-03	:	이상건
	***********************************************************************/ 	
	public void selectOgm530D(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm530D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm530D", list);
		new MiPlatformView().render(map, request, response);
	}
	
//계측기 START

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 측정기 초기화면
	 * @exception 
	 * @see
	 * 	- 2012-01-16	:	제환복
	***********************************************************************/ 
	public void selectOGM400(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);

		Map pMap = new HashMap();
		List list = new ArrayList();
        //각기 다른 SQL의 결과 물을  하나의 커리로 구현한 것처럼 처리
		//1. dao.getListData를 이용하여 결과 값취득(List타입)
		//2. List의 값취득(값 : count0=468)
		//3. Map형변환 후, Key값으로 값 취득(값 : 468)
		//4. 같은 값으로 취득값 설정 
		//현재월에 해야 교정해야 할것 -- selectOGM400a
		//다음월에 해야 교정해야 할것 -- selectOGM400b
		//지금까지 해야 미교정된것       -- selectOGM400c
		pMap.put("COUNT0", ((Map)dao.getListData("psogmlib.selectOGM400a", pData).get(0)).get("COUNT0"));
		pMap.put("COUNT1", ((Map)dao.getListData("psogmlib.selectOGM400b", pData).get(0)).get("COUNT1"));
		pMap.put("COUNT2", ((Map)dao.getListData("psogmlib.selectOGM400c", pData).get(0)).get("COUNT2"));		

		//값을 설정한 Map을 List에 설정
		list.add(pMap);
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OGM400", list);
		new MiPlatformView().render(map, request, response);

	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 측정기_조회_검색조건 조회
	 * @exception 
	 * @see
	 * 	- 2012-01-26	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm411_cmbsel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm411_cmbsel", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_cmbsel", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 측정기_조회_장비조회
	 * @exception 
	 * @see 
	 * 	- 2012-01-17	:	제환복
	***********************************************************************/ 
/* 사용안함.
	@SuppressWarnings("unchecked")
	
	public void selectOgm411(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm411", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm411", list);
		new MiPlatformView().render(map, request, response);
	}
*/	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 측정기_조회_교정내역확인
	 * @exception 
	 * @see 
	 * 	- 2012-01-16	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm421(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm421", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm421", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 측정기_조회_교정누락현황조회
	 * @exception 
	 * @see 
	 * 	- 2012-01-16	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectOgm422(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm422", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm422", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 측정기_조회_월별계획 대 실적
	 * @exception 
	 * @see
	 * 	- 2012-01-17	:	제환복
	***********************************************************************/ 
	public void selectOgm401(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm401", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm401", list);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기 사용부서 공통
	 * @exception 
	 * @see
	 * 	- 2012-01-16	:	제환복
	***********************************************************************/ 
	public void selectOGMgauge_Mst650pf(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMgauge_Mst650pf", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_mst650pf", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기 장비구분 공통
	 * @exception 
	 * @see
	 * 	- 2012-01-19	:	제환복
	***********************************************************************/ 
	public void selectOGMgauge_Mst050pf(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMgauge_Mst050pf", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_mst050pf", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_ 교정분야선택
	 * @exception 
	 * @see
	 * 	- 2012-01-19	:	제환복
	***********************************************************************/ 
	public void selectOGMgauge_SelMst050pf(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMgauge_SelMst050pf", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_selmst050pf", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_장비등록_ 폐기사유
	 * @exception 
	 * @see
	 * 	- 2012-01-19	:	제환복
	***********************************************************************/ 
	public void selectOGMgauge_dresn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGMgauge_dresn", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_dresn", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_장비등록_ 조회
	 * @exception 
	 * @see
	 * 	- 2012-01-19	:	제환복
	***********************************************************************/ 
	public void selectOgm410(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm410", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm410", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_장비등록_ 추가
	 * @exception 
	 * @see
	 * 	- 2012-01-27	:	제환복
	***********************************************************************/ 
	public void selectOgm410_maxcnt(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
			
		String maxflag = (String)pData.get("MAXFLAG");
		List list; 		
		if(maxflag.equals("3")){
			list = dao.getListData("psogmlib.selectOgm410_maxcnt2", pData);
		}
		else{
			 list = dao.getListData("psogmlib.selectOgm410_maxcnt1", pData);
		}		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_maxCnt", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_장비등록_ 중복체크
	 * @exception 
	 * @see
	 * 	- 2012-01-27	:	제환복
	***********************************************************************/ 
	public void selectOgm410_mngChk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm410_mngChk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_mngChk", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_장비등록_ chkIsAttme101
	 * @exception 
	 * @see
	 * 	- 2012-01-27	:	제환복
	***********************************************************************/ 
	public void selectOgm410_tme101Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm410_tme101Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_tme101", list);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_장비등록_ IsAtTme100pf
	 * @exception 
	 * @see
	 * 	- 2012-01-30	:	제환복
	***********************************************************************/ 
	public void selectOgm410_tme100Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm410_tme100Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_tme100", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_장비등록_ getMaxRpDat
	 * @exception 
	 * @see
	 * 	- 2012-01-30	:	제환복
	***********************************************************************/
	public void selectOgm410_MaxRpDat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm410_MaxRpDat", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_maxRpDat", list);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_장비등록_ 삭제처리
	 * @exception 
	 * @see 
	 * 	- 2012-01-30	:	제환복
	***********************************************************************/
	public void delOgm410(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		//miplatform 에서 전송한 파라메타 값
		//List pList = DataConverter.getMiPlatformMultiData(pReq, "Dataset0");
		Map pData = DataConverter.getMiPlatformData(pReq);
		//Iterator it = pList.iterator();
		//String rowType="";
		String flag101 = (String)pData.get("FALG101");
		String flag100 = (String)pData.get("FALG100");
		dao.startTransaction(); //tr 시작		
		 		
		if(flag101.equals("Y")){
			dao.deleteData("psogmlib.deleteOGM410_tme101", pData);
		}
		else if(flag100.equals("Y")){
			dao.deleteData("psogmlib.deleteOGM410_tme100", pData);
		}
		dao.deleteData("psogmlib.deleteOGM410_tme010", pData);
		System.out.println("-----------------endTransaction");
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_장비등록_ 저장처리
	 * @exception 
	 * @see 
	 * 	- 2012-01-30	:	제환복
	***********************************************************************/
	public void saveOgm410(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		String insFlag = (String)pData.get("INSFLAG");
		String rsign = (String)pData.get("RSIGN");
		String delFalg = (String)pData.get("DELFLAG");

		dao.startTransaction(); //tr 시작		
		System.out.println("startTransaction=====>");
		 		
		if(insFlag.equals("insert")){
			dao.insertData("psogmlib.insertOGM410_010pf", pData);
			dao.insertData("psogmlib.insertOGM410_100pf", pData);
		}
		else if(insFlag.equals("update")){
			dao.updateData("psogmlib.updateOGM410_010pf", pData);
				if(rsign.equals("3")){
					dao.updateData("psogmlib.updateOGM410_100pf_rsignY", pData);
					if(delFalg.equals("Y")){
						dao.deleteData("psogmlib.deleteOGM410_tme101", pData);
					}
				}
				else if(rsign.equals("1")){
					dao.updateData("psogmlib.updateOGM410_100pf_rsignN", pData);
				}
		}
		System.out.println("endTransaction=====>");
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_교정등록_ 조회
	 * @exception 
	 * @see
	 * 	- 2012-02-01	:	제환복
	***********************************************************************/ 
	public void selectOgm420(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		String selFalg = (String)pData.get("SELFLAG");
		List list; 		
		if(selFalg.equals("sel1")){
			list = dao.getListData("psogmlib.selectOgm420_sel1", pData);
		}
		else{
			list = dao.getListData("psogmlib.selectOgm420_sel2", pData);			
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm420_sel", list);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_교정등록_ 저장
	 * @exception 
	 * @see
	 * 	- 2012-02-02	:	제환복
	***********************************************************************/ 		
	public void OGM420Save_accept(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm420_sel1");
		
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		String Strflag = (String)pMap.get("TRFLAG");
		String Sidnum = (String)pMap.get("CHUSR");
		String Scomps = (String)pMap.get("COMPS");
		String Slib2 = (String)pMap.get("LIB2");
		
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		dao.startTransaction(); //commit
		//ModelMap map = new ModelMap(); //데이터 보내기위함.
		//있으면
		while (it.hasNext()) {
			//취득
			Map pData = (Map) it.next();
            //공장코드는 DB에 들어가지만 DATASET에 없기에 변수로 받아서 ROW의 테이터들과 같은 곳에 해당키값으로 저장
			pData.put("COMPS", Scomps);
			pData.put("LIB2", Slib2);
			pData.put("CHUSR", Sidnum);
			
			//데이터셋의 컬럼중 처리에 체크된 것만 업데이트처리함. 변경하였어도 체크하지 않으면 업데이트 하지않음.
			String schkflag = (String) pData.get("CHKFLAG"); //데이터셋의 특정 컬럼데이터 가져오기
//System.out.println("pData===>"+pData);
//System.out.println("Schkflag===>"+schkflag);
            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");
			
			//update의경우
			
			if ("update".equals(rowType)) {
				//교정처리 및 저장의 구분을 두기위해 strflag를 둠.(둘다 ds변경으로 업데이트 인식함.
				if(Strflag.equals("update")){
					if(schkflag.equals("1")){
						//업데이트시 변경만하고 처리체크박스에 표시를 안하면 변경안되도록 하기위함.
						dao.updateData("psogmlib.updateOGM420_1", pData);
					}
					else{
						System.out.println("처리란에 체크해야 정상수행됩니다.");
					}
				}
				else if(Strflag.equals("insert")){
					dao.insertData("psogmlib.insertOGM420_accept010pf", pData);
					dao.updateData("psogmlib.updateOGM420_accept100pf", pData);					
				}
				//delete의경우
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOGM420_1", pData);
			}
			/*
			//insert의경우
			}else if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOGM420_1", pData);   // 첫번째 인자 : psogmlib의 SQL파일에 insertOGM430의 SQL사용
			}
			*/ 
			
		}
		dao.endTransaction(); //commit
		//new MiPlatformView().render(map, request, response);
		new MiPlatformView().render(null, request, response);		
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_교정등록_ 저장
	 * @exception 
	 * @see
	 * 	- 2012-02-02	:	제환복
	***********************************************************************/ 		
	public void OGM420Save_conduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm420_sel2");
		
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		String Strflag = (String)pMap.get("TRFLAG");
		String Sidnum = (String)pMap.get("CHUSR");
		String Scomps = (String)pMap.get("COMPS");
		String Slib2 = (String)pMap.get("LIB2");
		
		Iterator it = pList.iterator();
		String rowType = "";
		
		dao.startTransaction(); //commit

		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("COMPS", Scomps);
			pData.put("LIB2", Slib2);
			pData.put("CHUSR", Sidnum);
			 
			String schkflag = (String) pData.get("CHKFLAG"); //데이터셋의 특정 컬럼데이터 가져오기

			rowType = (String) pData.get("ROW_TYPE");
			if ("update".equals(rowType)) {
				if(Strflag.equals("update")){
					if(schkflag.equals("1")){
						dao.updateData("psogmlib.insertOGM420_save2", pData);
						dao.updateData("psogmlib.updateOGM420_save2", pData);
						dao.updateData("psogmlib.deleteOGM420_btndel2", pData);
					}
					else{
						System.out.println("처리란에 체크해야 정상수행됩니다.");
					}
				}
				else if(Strflag.equals("delete")){
					dao.updateData("psogmlib.updateOGM420_btndel2", pData);					
					dao.deleteData("psogmlib.deleteOGM420_btndel2", pData);
				}
				//delete의경우
			} else if ("delete".equals(rowType)) {
				//dao.deleteData("psogmlib.deleteOGM420_1", pData);
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
	 * 	- 계측기_등록_장비등록_ getSeqNo 
	 * @exception 
	 * @see
	 * 	- 2012-02-03	:	제환복
	***********************************************************************/
	//SQL_tme100pf_09
	public void selectOgm420_getSeqNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm420_getSeqNo", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_getSeqNo", list);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_등록_교정등록_ POP조회
	 * @exception 
	 * @see
	 * 	- 2012-02-01	:	제환복
	***********************************************************************/ 
	public void selectOgm420_pop(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm420_pop", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm420_pop", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 코드관리 조회
	 * @exception 
	 * @see
	 * 	- 2011-11-10	:	김종진
	***********************************************************************/ 
	public void selectOGM430(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM430", pData);
	
		//디버깅을 위한 소스 ( log4j 평소 레벨이 FATAL 이기에 표시 안됨, INFO 이혹은 DEBUG레벨일 때 보임)
		for(int k=0; k < list.size(); k++){
					
			log.info("값 :" + k + "번째" + list.get(k));
		}
		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm430", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 코드관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-11-10	:	김종진
	***********************************************************************/ 		
	public void OGM430Save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm430");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득
		String Sidnum = (String)pMap.get("ADUSR");
		String Scomps = (String)pMap.get("COMPS");
		String Slib2 = (String)pMap.get("LIB2");
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		//있으면
		while (it.hasNext()) {
			
			//취득
			Map pData = (Map) it.next();
            //공장코드는 DB에 들어가지만 DATASET에 없기에 변수로 받아서 ROW의 테이터들과 같은 곳에 해당키값으로 저장
			pData.put("ADUSR", Sidnum);
			pData.put("COMPS", Scomps);
			pData.put("LIB2", Slib2);
            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");
			//insert의경우
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOGM430", pData);   // 첫번째 인자 : psogmlib의 SQL파일에 insertOGM430의 SQL사용
			//update의경우
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateOGM430", pData);
			//delete의경우
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOGM430", pData);
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
	 * 	- 코드관리 중복CHECK용
	 * @exception 
	 * @see
	 * 	- 2011-11-11	:	김종진
	***********************************************************************/ 
	public void selectOGM430_dchk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		//처리가 일반 조회랑 같기에 동일 SQL사용
		List list = dao.getListData("psogmlib.selectOGM430", pData);
		ModelMap map = new ModelMap();
		//Dataset의 경우도 동일 데이터셋 사용해도 가능하다고 생각..?
		map.addAttribute("ds_OGM430_dchk", list);
		new MiPlatformView().render(map, request, response);
	}
				
//계측기 END	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 일별내제품실적조회
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	이상건
	***********************************************************************/ 	
	public void selectOgm540(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm540", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm540", list);
		new MiPlatformView().render(map, request, response);
	} 
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 일별내제품실적조회 상세
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	이상건
	***********************************************************************/ 	
	public void selectOgm540D(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm540D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm540D", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 시간대별 내제품 실적조회
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	이상건
	***********************************************************************/ 	
	public void selectOgm550(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm550", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm550", list);
		new MiPlatformView().render(map, request, response);
	} 
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 시간대별 내제품 실적 조회 상세
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	이상건
	***********************************************************************/ 	
	public void selectOgm550D(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm550D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm550D", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 일별 제품 출하실적조회
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	이상건
	***********************************************************************/ 	
	public void selectOgm560(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm560", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm560", list);
		new MiPlatformView().render(map, request, response);
	} 
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 일별 제품 출하실적 조회 상세
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	이상건
	***********************************************************************/ 	
	public void selectOgm560D(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm560D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm560D", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 주야간 시간관리 조회 
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	이상건
	***********************************************************************/ 	
	public void selectOgm501(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOgm501", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_Ogm501", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB 주야간 시간관리 저장
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	이상건
	***********************************************************************/ 	
	public void SaveOgm501(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOgm501" , pData);
		new MiPlatformView().render(null, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기 _ 장비 조회 
	 * @exception 
	 * @see
	 * 	- 2012-01-12	:	이상건
	***********************************************************************/ 	
	public void selectogm411(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectogm411", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm411", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB  장치명관리
	 * @exception 
	 * @see
	 * 	- 2012-02-27	:	이상건
	***********************************************************************/ 	
	public void selectogm502(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectogm502", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm502", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB  장치명관리 중복Check
	 * @exception 
	 * @see
	 * 	- 2012-02-27	:	이상건
	***********************************************************************/ 	
	public void selectogm502_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectogm502_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm502_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Maker관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-08-16	:	이상건
	***********************************************************************/ 		
	public void ogm502Save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CommonDAO dao = CommonDAO.getInstance(1);*/
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm502");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		String Scomps = (String)pMap.get("COMPS");
		String Slib2 = (String)pMap.get("LIB2");
		
		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("COMPS", Scomps);
			pData.put("LIB2", Slib2);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertogm502", pData);
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateogm502", pData);
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteogm502", pData);
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
	 * 	- QR WEB  표준시간관리
	 * @exception 
	 * @see
	 * 	- 2012-02-10	:	이상건
	***********************************************************************/ 	
	public void selectogm503(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectogm503", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm503", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- QR WEB  표준시간관리 중복Check
	 * @exception 
	 * @see
	 * 	- 2012-02-10	:	이상건
	***********************************************************************/ 	
	public void selectogm503_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectogm503_Chk", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ogm503_Chk", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- Maker관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-08-16	:	이상건
	***********************************************************************/ 		
	public void ogm503Save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*CommonDAO dao = CommonDAO.getInstance(1);*/
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_ogm503");
		Map pMap = DataConverter.getMiPlatformData(pReq);
		String Scomps = (String)pMap.get("COMPS");
		String Slib2 = (String)pMap.get("LIB2");
		String Sdaygu = (String)pMap.get("DAYGU");
		Iterator it = pList.iterator();
		String rowType = "";
		List deleteList = new ArrayList();
		while (it.hasNext()) {
			Map pData = (Map) it.next();
			pData.put("COMPS", Scomps);
			pData.put("LIB2", Slib2);
			pData.put("DAYGU", Sdaygu);
			rowType = (String) pData.get("ROW_TYPE");
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertogm503", pData);
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateogm503", pData);
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteogm503", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}

	/* kim jh */
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- MRP영업관리_마스터관리_제품단가확인서 발행
	 * @exception 
	 * @see 
	 * 	- 2012-03-28	:	제환복
	***********************************************************************/ 
	@SuppressWarnings("unchecked")
	public void selectSale154(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectSale154", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_sale154", list);
		new MiPlatformView().render(map, request, response);
	}	
/*******************************/
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_성적서_장비명_조회
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 
	public void selectORPE001Rjbcode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectORPE001Rjbcode", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_orpe001r_jbcode", list);
		new MiPlatformView().render(map, request, response);
		
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_성적서_갑지_조회
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 
	public void selectORPE001R(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectORPE001R", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_orpe001r_head", list);
		new MiPlatformView().render(map, request, response);
		
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_성적서_표준장비_조회
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 
	public void selectORPE001Rstd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectORPE001Rstd", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_orpe001r_standard", list);
		new MiPlatformView().render(map, request, response);
		
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_성적서_을지_조회
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 
	public void selectORPE001Reulji(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectORPE001Reulji", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_orpe001r_eulji", list);
		new MiPlatformView().render(map, request, response);				
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 성적서 갑지 저장
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 		
	public void saveORPE001R(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_orpe001r_head");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득
		String repno = (String)pMap.get("REPNO");
		//String jbno = (String)pMap.get("jbno");
		//String mngno = (String)pMap.get("mngno");
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		//있으면
		while (it.hasNext()) {
			
			//취득
			Map pData = (Map) it.next();
			pData.put("REPNO", repno);			

            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");								
			
			//insert의경우
			if ("insert".equals(rowType)) {
				log.info(pData.get("LOCATION"));
				dao.insertData("psogmlib.saveORPE001R", pData);   
			//update의경우
			} else if ("update".equals(rowType)) {
				log.info("test update");
				log.info(pData.get("repno"));
				log.info(pData.get("mngno"));
				dao.updateData("psogmlib.updateORPE001R", pData);
			//delete의경우
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteORPE001R", pData);
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
	 * 	- 표준장비 저장
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 		
	public void saveORPE001Rstd(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_orpe001r_standard");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득
		//String Sidnum = (String)pMap.get("ADUSR");
		//String Scomps = (String)pMap.get("COMPS");
		//String Slib2 = (String)pMap.get("LIB2");
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		//있으면
		while (it.hasNext()) {
			
			//취득
			Map pData = (Map) it.next();

            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");								
			
			//insert의경우
			if ("insert".equals(rowType)) {
				log.info("test insert");
				dao.insertData("psogmlib.saveORPE001Rstd", pData);   
			//update의경우
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateORPE001Rstd", pData);
			//delete의경우
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteORPE001Rstd", pData);
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
	 * 	- 을지 저장
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 		
	public void saveORPE001Reulji(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_orpe001r_eulji");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득
		//String Sidnum = (String)pMap.get("ADUSR");
		//String Scomps = (String)pMap.get("COMPS");
		//String Slib2 = (String)pMap.get("LIB2");
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		//있으면
		while (it.hasNext()) {
			
			//취득
			Map pData = (Map) it.next();

            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");								
			
			//insert의경우
			if ("insert".equals(rowType)) {
				log.info("test insert");
				dao.insertData("psogmlib.saveORPE001Reulji", pData);  
			//update의경우
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateORPE001Reulji", pData);
			//delete의경우
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteORPE001Reulji", pData);
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
	 * 	- 계측기_교정번호 확인
	 * @exception 
	 * @see
	 * 	- 2012-06-27	:	김정현
	***********************************************************************/ 
	public void selectORPE001R_maxrepno(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectORPE003_maxrepno", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_orpe001r_maxrepno", list);
		new MiPlatformView().render(map, request, response);		
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_엑셀파일 리스트
	 * @exception 
	 * @see
	 * 	- 2012-06-27	:	김정현
	***********************************************************************/ 
	public void selectORPE001R_xlslist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectORPE001R_xlslist", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_orpe001r_xls", list);
		new MiPlatformView().render(map, request, response);		
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- JXL 구현
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 	
	/* 계측기 을지 JXL부분 주석처리
	public void doJXL(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		String xlsRepno;
		String xlsFilename;
		//String xlsFilename2;
		//String xlsFilename3;
		
		///////////////////////////////
		//xlsFilename = "30-포인트마이크로미터";
		//xlsFilename = new String(xlsFilename.getBytes("KSC5601"), "8859_1");		
		///////////////////////////////
		
		// 파일명 한글처리부분
		xlsRepno = request.getParameter("repno");		
		xlsRepno = new String(xlsRepno.getBytes("8859_1"), "EUC-KR");

		xlsFilename = request.getParameter("xls");		
		//xlsFilename2 = new String(xlsFilename.getBytes("KSC5601"), "8859_1");	
		xlsFilename = new String(xlsFilename.getBytes("8859_1"), "EUC-KR");		
							
		response.setContentType("application/vnd.ms-excel");
	    //response.setHeader("Content-Disposition", "attachment; filename=" + xlsFilename2 + ".xls");
	    response.setHeader("Content-Disposition", "attachment; filename=result.xls");
	    
		Workbook workbook = Workbook.getWorkbook(new File("c:\\교정성적서\\" + xlsFilename + ".xls"));		
		WritableWorkbook copy = Workbook.createWorkbook(response.getOutputStream(), workbook); 		
		
		WritableSheet sheet3 = copy.getSheet("을지");	
		
		Number banbok11 = new Number(48, 19, 1.1); 
		sheet3.addCell(banbok11);			
		
		Number banbok12 = new Number(48, 20, 2.1); 
		sheet3.addCell(banbok12);	
		
		Number banbok13 = new Number(48, 21, 3.1); 
		sheet3.addCell(banbok13);		
		
		Number banbok14 = new Number(48, 22, 4.1); 
		sheet3.addCell(banbok14);			
		
		Number banbok15 = new Number(48, 23, 5.1); 
		sheet3.addCell(banbok15);	
		
		Number banbok16 = new Number(48, 24, 6.1); 
		sheet3.addCell(banbok16);	
		
		Number banbok17 = new Number(48, 25, 7.1); 
		sheet3.addCell(banbok17);			
		
		Number banbok18 = new Number(48, 26, 8.1); 
		sheet3.addCell(banbok18);		
		
		/////////////////////////////////////////
		
		Number banbok21 = new Number(49, 19, 1.1); 
		sheet3.addCell(banbok21);			
		
		Number banbok22 = new Number(49, 20, 2.1); 
		sheet3.addCell(banbok22);	
		
		Number banbok23 = new Number(49, 21, 3.1); 
		sheet3.addCell(banbok23);		
		
		Number banbok24 = new Number(49, 22, 4.1); 
		sheet3.addCell(banbok24);			
		
		Number banbok25 = new Number(49, 23, 5.1); 
		sheet3.addCell(banbok25);	
		
		Number banbok26 = new Number(49, 24, 6.1); 
		sheet3.addCell(banbok26);	
		
		Number banbok27 = new Number(49, 25, 7.1); 
		sheet3.addCell(banbok27);			
		
		Number banbok28 = new Number(49, 26, 8.1); 
		sheet3.addCell(banbok28);	
		
		////////////////////////////////////////
		
		Number banbok31 = new Number(50, 19, 1.1); 
		sheet3.addCell(banbok31);			
		
		Number banbok32 = new Number(50, 20, 2.1); 
		sheet3.addCell(banbok32);	
		
		Number banbok33 = new Number(50, 21, 3.1); 
		sheet3.addCell(banbok33);		
		
		Number banbok34 = new Number(50, 22, 4.1); 
		sheet3.addCell(banbok34);			
		
		Number banbok35 = new Number(50, 23, 5.1); 
		sheet3.addCell(banbok35);	
		
		Number banbok36 = new Number(50, 24, 6.1); 
		sheet3.addCell(banbok36);	
		
		Number banbok37 = new Number(50, 25, 7.1); 
		sheet3.addCell(banbok37);			
		
		Number banbok38 = new Number(50, 26, 8.1); 
		sheet3.addCell(banbok38);	
		
		copy.write(); 
		copy.close(); 		
	}	
	*/
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사외성적서 저장
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 		
	public void saveORPE001(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_orpe001_main");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득
		//String Sidnum = (String)pMap.get("ADUSR");
		//String Scomps = (String)pMap.get("COMPS");
		//String Slib2 = (String)pMap.get("LIB2");
		String repno = (String)pMap.get("REPNO");
		String gubun = (String)pMap.get("GUBUN");
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		//있으면
		while (it.hasNext()) {			
			//취득
			Map pData = (Map) it.next();
			pData.put("REPNO", repno);
			pData.put("GUBUN", gubun);	

            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");								
			
			//insert의경우
			if ("insert".equals(rowType)) {
				log.info("test insert");
				dao.insertData("psogmlib.saveORPE001", pData);  
			//update의경우
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateORPE001", pData);
			//delete의경우
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteORPE001", pData);
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
	 * 	- 사외성적서 저장
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 		
	public void saveORPE002(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_orpe002_main");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득
		//String Sidnum = (String)pMap.get("ADUSR");
		//String Scomps = (String)pMap.get("COMPS");
		//String Slib2 = (String)pMap.get("LIB2");
		String repno = (String)pMap.get("REPNO");
		String gubun = (String)pMap.get("GUBUN");
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		//있으면
		while (it.hasNext()) {			
			//취득
			Map pData = (Map) it.next();
			pData.put("REPNO", repno);
			pData.put("GUBUN", gubun);	

            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");								
			
			//insert의경우
			if ("insert".equals(rowType)) {
				log.info("test insert");
				dao.insertData("psogmlib.saveORPE002", pData);  
			//update의경우
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateORPE002", pData);
			//delete의경우
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteORPE002", pData);
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
	 * 	- 계측기_엑셀파일 리스트
	 * @exception 
	 * @see
	 * 	- 2012-06-27	:	김정현
	***********************************************************************/ 
	public void selectORPE001_select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);								
		List list_down = dao.getListData("psogmlib.selectORPE001_select", pData);			
		ModelMap map_down = new ModelMap();
		
		log.info("TEST");		
		for(int k=0; k < list_down.size(); k++){
			
			log.info("값 :" + k + "번째" + list_down.get(k));
		}
		
		map_down.addAttribute("ds_orpe001_select", list_down);
		new MiPlatformView().render(map_down, request, response);		
	}		
	
	public void selectORPE001_main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);		
		List list_top = dao.getListData("psogmlib.selectORPE001_main", pData);		
		ModelMap map_top = new ModelMap();
		
		log.info("TEST");		
		for(int k=0; k < list_top.size(); k++){
			
			log.info("값 :" + k + "번째" + list_top.get(k));
		}
		
		map_top.addAttribute("ds_orpe001_main", list_top);
		new MiPlatformView().render(map_top, request, response);		
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기_엑셀파일 리스트
	 * @exception 
	 * @see
	 * 	- 2012-06-27	:	김정현
	***********************************************************************/ 
	public void selectORPE002_select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
								
		List list_down = dao.getListData("psogmlib.selectORPE002_select", pData);
			
		ModelMap map_down = new ModelMap();
		map_down.addAttribute("ds_orpe002_select", list_down);
		new MiPlatformView().render(map_down, request, response);		
	}		
	
	public void selectORPE002_main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list_top = dao.getListData("psogmlib.selectORPE002_main", pData);
		
		ModelMap map_top = new ModelMap();
		map_top.addAttribute("ds_orpe002_main", list_top);
		new MiPlatformView().render(map_top, request, response);		
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 설비교정번호 자동생성
	 * @exception 
	 * @see
	 * 	- 2012-06-27	:	김정현
	***********************************************************************/ 
	public void selectORPE003_maxrepno(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectORPE003_maxrepno", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_orpe003_maxrepno", list);
		new MiPlatformView().render(map, request, response);		
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사외성적서 조회
	 * @exception 
	 * @see
	 * 	- 2012-06-27	:	김정현
	***********************************************************************/ 
	public void selectORPE004(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);								
		List list = dao.getListData("psogmlib.selectORPE004", pData);			
		ModelMap map = new ModelMap();
		
		System.out.println("TEST selectORPE004");
		log.info("TEST selectORPE004");
		
		for(int k=0; k < list.size(); k++){
			
			log.info("값 :" + k + "번째" + list.get(k));
		}
		
		map.addAttribute("ds_orpe004_select", list);
		new MiPlatformView().render(map, request, response);		
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사외성적서 조회
	 * @exception 
	 * @see
	 * 	- 2012-06-27	:	김정현
	***********************************************************************/ 
	public void selectORPE005(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
								
		List list_down = dao.getListData("psogmlib.selectORPE005", pData);
			
		ModelMap map_down = new ModelMap();
		
		//log.info("TEST");
		
		for(int k=0; k < list_down.size(); k++){
			
			log.info("값 :" + k + "번째" + list_down.get(k));
		}
		
		map_down.addAttribute("ds_orpe005_select", list_down);
		new MiPlatformView().render(map_down, request, response);		
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 계측기 사용부서 공통
	 * @exception 
	 * @see
	 * 	- 2012-01-16	:	제환복
	***********************************************************************/ 
	public void selectOGM_ORPE_Mst650pf(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM_ORPE_Mst650pf", pData);

		ModelMap map = new ModelMap();
		map.addAttribute("ds_mst650pf", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/* 전광판 */
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE01(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		
		// 세션 확인
		//System.out.println("전광판 조회 요청 처리 받음");
		//System.out.println("사용자 세션ID 값 확인 request.getSession() : " + request.getSession());
		
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE01", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi001m", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE01_Sum(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE01_Sum", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_ppmi001m_sum", list);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE02_1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE02_1", pData);
		ModelMap map = new ModelMap();
		
		log.info("Check");
		for(int k=0; k < list.size(); k++){
			
			log.info("값 :" + k + "번째" + list.get(k));
		}
		
		map.addAttribute("DS_OBSE02_1", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE02_2_Day(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE02_2_Day", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE02_2_Day", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE02_2_Night(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE02_2_Night", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE02_2_Night", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE02_3(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE02_3", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE02_3", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE02_4(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE02_4", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE02_4", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE02_5(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE02_5", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE02_5", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE03_D(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE03_D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE03_D", list);
		new MiPlatformView().render(map, request, response);
	}

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE03_N(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE03_N", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE03_N", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE04Group(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE04Group", pData);
		
		System.out.println("=======ROWGB==================" + pData.get("ROWGB"));
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE04Group", list);
		new MiPlatformView().render(map, request, response);
	}	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE04_Tab1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE04_Tab1", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE04_Tab1", list);
		
		new MiPlatformView().render(map, request, response);
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE04_Tab1Sub(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE04_Tab1Sub", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE04_Tab1Sub", list);
		
		new MiPlatformView().render(map, request, response);
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE04_Tab2(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE04_Tab2", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE04_Tab2", list);
		
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE04_Tab3(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE04_Tab3", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE04_Tab3", list);
		
		new MiPlatformView().render(map, request, response);
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE04_Tab3Sub(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE04_Tab3Sub", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE04_Tab3Sub", list);
		
		new MiPlatformView().render(map, request, response);
	}	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE04_Tab4_D(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE04_Tab4_D", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE04_Tab4_D", list);
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2012-09-26	:	김정현
	***********************************************************************/ 				
	public void selectOBSE04_Tab4_N(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBSE04_Tab4_N", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE04_Tab4_N", list);
		new MiPlatformView().render(map, request, response);
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE04_Tab4Sub(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE04_Tab4Sub", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE04_Tab4Sub", list);
		
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE05_Tab1_Top(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE05_Tab1_Top", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE05_TAB1_TOP", list);
		
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 코드관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-11-10	:	김정현
	***********************************************************************/ 		
	public void saveOBSE05_Tab1_Top(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "DS_OBSE05_TAB1_TOP");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득
		//String Sidnum = (String)pMap.get("ADUSR");
		String procs = (String)pMap.get("PROCS");
		String ordat = (String)pMap.get("ORDAT");
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		//있으면
		while (it.hasNext()) {			
			Map pData = (Map) it.next();
            //공장코드는 DB에 들어가지만 DATASET에 없기에 변수로 받아서 ROW의 테이터들과 같은 곳에 해당키값으로 저장
			//pData.put("ADUSR", Sidnum);
			pData.put("PROCS", procs);
			pData.put("ORDAT", ordat);
            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");
			//insert의경우
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOBSE05_Tab1_Top", pData);   // 첫번째 인자 : psogmlib의 SQL파일에 insertOGM430의 SQL사용
			//update의경우
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateOBSE05_Tab1_Top", pData);
			//delete의경우
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOBSE05_Tab1_Top", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}	

	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE05_Tab1_Mid(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE05_Tab1_Mid", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE05_TAB1_MID", list);
		
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 코드관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-11-10	:	김정현
	***********************************************************************/ 		
	public void saveOBSE05_Tab1_Mid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "DS_OBSE05_TAB1_MID");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득
		String stmin = (String)pMap.get("STMIN");
		String procs = (String)pMap.get("PROCS");
		String ordat = (String)pMap.get("ORDAT");
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		//있으면
		while (it.hasNext()) {			
			Map pData = (Map) it.next();
            //공장코드는 DB에 들어가지만 DATASET에 없기에 변수로 받아서 ROW의 테이터들과 같은 곳에 해당키값으로 저장
			
			pData.put("STMIN", stmin);
			pData.put("PROCS", procs);
			pData.put("ORDAT", ordat);			
			
            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");
			//insert의경우
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOBSE05_Tab1_Mid", pData);   // 첫번째 인자 : psogmlib의 SQL파일에 insertOGM430의 SQL사용
			//update의경우
			} else if ("update".equals(rowType)) {
				dao.updateData("psogmlib.updateOBSE05_Tab1_Mid", pData);
			//delete의경우
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOBSE05_Tab1_Mid", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE05_Find(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE05_Find", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_SELECT", list);
		
		new MiPlatformView().render(map, request, response);
	}	

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE05_Tab1_Bottom(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE05_Tab1_Bottom", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE05_TAB1_BOTTOM", list);
		
		new MiPlatformView().render(map, request, response);
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 코드관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-11-10	:	김정현
	***********************************************************************/ 		
	public void saveOBSE05_Tab1_Bottom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "DS_OBSE05_TAB1_BOTTOM");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득
		String bsmin = (String)pMap.get("BSMIN");
		String procs = (String)pMap.get("PROCS");
		String ordat = (String)pMap.get("ORDAT");
				
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("DS_OBSE05_TAB1_BOTTOM");
		//////////////////////////////////////////////////////////////
		
		while (it.hasNext()) {			
			Map pData = (Map) it.next();
            //공장코드는 DB에 들어가지만 DATASET에 없기에 변수로 받아서 ROW의 테이터들과 같은 곳에 해당키값으로 저장
			
			pData.put("BSMIN", bsmin);
			pData.put("PROCS", procs);
			pData.put("ORDAT", ordat);	
			
            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");
			
			if ("insert".equals(rowType)) {
				dao.insertData("psogmlib.insertOBSE05_Tab1_Bottom", pData);			
			} else if ("update".equals(rowType)) {
				pData.put("OLD_BSTFM", ds.getOrgBuffColumn(0, "BSTFM").getString());
				pData.put("OLD_BSTTO", ds.getOrgBuffColumn(0, "BSTTO").getString());
				pData.put("OLD_DAYGU", ds.getOrgBuffColumn(0, "DAYGU").getString());
				pData.put("OLD_DPTGU", ds.getOrgBuffColumn(0, "DPTGU").getString());
				
				dao.updateData("psogmlib.updateOBSE05_Tab1_Bottom", pData);			
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOBSE05_Tab1_Bottom", pData);
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
	 * 	- 코드관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-11-10	:	김정현
	***********************************************************************/ 		
	public void saveOBSE05_Tab2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "DS_OBSE04_Tab1");		
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득		
		String procs = (String)pMap.get("PROCS");
		String ordat = (String)pMap.get("ORDAT");
		
		////////////////////////////////////////////////////////////
		DatasetList dl = new DatasetList();
		dl = pReq.getDatasetList();
		Dataset ds = dl.getDataset("DS_OBSE04_Tab1");
		////////////////////////////////////////////////////////////
						
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		while (it.hasNext()) {			
			Map pData = (Map) it.next();
            
			pData.put("PROCS", procs);
			pData.put("ORDAT", ordat);									
			
            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");
			
			if ("insert".equals(rowType)) {							
			} else if ("update".equals(rowType)) {
				pData.put("OLD_DAYGU", ds.getOrgBuffColumn(0, "DAYGU").getString());
				
				dao.updateData("psogmlib.updateOBSE05_Tab2", pData);			
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOBSE05_Tab2", pData);
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
	 * 	- 코드관리 저장
	 * @exception 
	 * @see
	 * 	- 2011-11-10	:	김정현
	***********************************************************************/ 		
	public void saveOBSE05_Tab3(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		
		//추가, 삭제, 업데이트 중 하나가 발생한 데이터만 해당 Dataset에서 취득
		List pList = DataConverter.getMiPlatformMultiData(pReq, "DS_OBSE04_Tab2");
		
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		//변수취득		
		String procs = (String)pMap.get("PROCS");
		String ordat = (String)pMap.get("ORDAT");				
		//String badlg = (String)pMap.get("BADLG");
		//String badmd = (String)pMap.get("BADMD");
		//String badsm = (String)pMap.get("BADSM");		

		////////////////////////////////////////////////////////////
		DatasetList dl = new DatasetList();
		dl = pReq.getDatasetList();
		Dataset ds = dl.getDataset("DS_OBSE04_Tab2");
		////////////////////////////////////////////////////////////		
		
		//취득한 변경발생된 데이터를 루프
		Iterator it = pList.iterator();
		String rowType = "";
		
		while (it.hasNext()) {			
			Map pData = (Map) it.next();
            //공장코드는 DB에 들어가지만 DATASET에 없기에 변수로 받아서 ROW의 테이터들과 같은 곳에 해당키값으로 저장
						
			pData.put("PROCS", procs);
			pData.put("ORDAT", ordat);
			
            //DATASET의 숨겨진 칼럼인 ROW타입을 판단 
			rowType = (String) pData.get("ROW_TYPE");
			
			if ("insert".equals(rowType)) {		
				dao.insertData("psogmlib.insertOBSE05_Tab3", pData);
			} else if ("update".equals(rowType)) {
				pData.put("OLD_DAYGU", ds.getOrgBuffColumn(0, "DAYGU").getString());
				pData.put("OLD_PSPNO", ds.getOrgBuffColumn(0, "PSPNO").getString());
				pData.put("OLD_BADTM", ds.getOrgBuffColumn(0, "BADTM").getString());				
				
				dao.updateData("psogmlib.updateOBSE05_Tab3", pData);					
			} else if ("delete".equals(rowType)) {
				dao.deleteData("psogmlib.deleteOBSE05_Tab3", pData);
			}
		}
		new MiPlatformView().render(null, request, response);		
	}		
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE05_Tab2_Misengsan(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE05_Tab2_Misengsan", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE05_TAB2_MSS", list);
		
		new MiPlatformView().render(map, request, response);
	}	
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2010-11-26	:	김정현
	***********************************************************************/ 	
	public void selectOBSE05_Tab2_Misengsan_Count_Chk(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		
		List list = dao.getListData("psogmlib.selectOBSE05_Tab2_Misengsan_Count_Chk", pData);
		
		ModelMap map = new ModelMap();
		map.addAttribute("DS_OBSE05_TAB2_MSS_COUNT", list);
		
		new MiPlatformView().render(map, request, response);
	}	
	
	
	//////////////////
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사외성적서 저장
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 		
	public void insertOBSE05_Tab2_Misengsan(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
				
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		String procs = (String)pMap.get("PROCS");
		String ordat = (String)pMap.get("ORDAT");				
		String jobsq = (String)pMap.get("JOBSQ");
		String orqty = (String)pMap.get("ORQTY");		
		String split = (String)pMap.get("SPLIT");
		String seqno = (String)pMap.get("SEQNO");
		String serno = (String)pMap.get("SERNO");
		String prtno = (String)pMap.get("PRTNO");
		String prlot = (String)pMap.get("PRLOT");
		String qtunt = (String)pMap.get("QTUNT");		
		String cyctm = (String)pMap.get("CYCTM");		
						
		pMap.put("PROCS", procs);
		pMap.put("ORDAT", ordat);
		pMap.put("JOBSQ", jobsq);
		pMap.put("ORQTY", orqty);		
		pMap.put("SPLIT", split);
		pMap.put("SEQNO", seqno);
		pMap.put("SERNO", serno);
		pMap.put("PRTNO", prtno);
		pMap.put("PRLOT", prlot);
		pMap.put("QTUNT", qtunt);				
		pMap.put("CYCTM", cyctm);
					
		dao.insertData("psogmlib.insertOBSE05_Tab3_Misengsan", pMap);  			

		new MiPlatformView().render(null, request, response);		
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @hint
	 * 	- 사외성적서 저장
	 * @exception 
	 * @see
	 * 	- 2012-06-07	:	김정현
	***********************************************************************/ 		
	public void updateOBSE05_Tab2_Misengsan(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
				
		//변수 저장 MAP 취득
		Map pMap = DataConverter.getMiPlatformData(pReq);
		
		String procs = (String)pMap.get("PROCS");
		String ordat = (String)pMap.get("ORDAT");				
		String jobsq = (String)pMap.get("JOBSQ");
		String orqty = (String)pMap.get("ORQTY");		
		String split = (String)pMap.get("SPLIT");
		String seqno = (String)pMap.get("SEQNO");
		String serno = (String)pMap.get("SERNO");
		String prtno = (String)pMap.get("PRTNO");
		String prlot = (String)pMap.get("PRLOT");
		String qtunt = (String)pMap.get("QTUNT");		
		String cyctm = (String)pMap.get("CYCTM");		
						
		pMap.put("PROCS", procs);
		pMap.put("ORDAT", ordat);
		pMap.put("JOBSQ", jobsq);
		pMap.put("ORQTY", orqty);		
		pMap.put("SPLIT", split);
		pMap.put("SEQNO", seqno);
		pMap.put("SERNO", serno);
		pMap.put("PRTNO", prtno);
		pMap.put("PRLOT", prlot);
		pMap.put("QTUNT", qtunt);				
		pMap.put("CYCTM", cyctm);
					
		dao.insertData("psogmlib.updateOBSE05_Tab3_Misengsan", pMap);  			

		new MiPlatformView().render(null, request, response);		
	}	
	//////////////////
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * @see
	 * 	- 2014-07-08	:	민명규
	***********************************************************************/ 	
	public void selectOBSE01_1(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);		
		List list = dao.getListData("psogmlib.selectOBSE01_1", pData);		
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBSE01_1", list);		
		new MiPlatformView().render(map, request, response);
	}	
	
	// 전광판 추가 끝	

	/*
 * 보전이력관리-[알림/통계 START 2016.06.21
 */
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-마스터조회(라인,설비 등등)
	 * @see
	 * 	- 2016-05-24	:	제환복
	***********************************************************************/
	public void selectMSTCODE(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8");
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		String selectSQL = "psogmlib." + pData.get("SQLID").toString(); 
		List list = dao.getListData(selectSQL, pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSTCODE", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-종합알림창
	 * @see
	 * 	- 2016-05-24	:	제환복
	***********************************************************************/
	public void selectOBNZ100Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psogmlib.selectOBNZ100Q_A", pData);	//중점설비
		List list2 = dao.getListData("psogmlib.selectOBNZ100Q_B", pData);	//계획점검
		List list3 = dao.getListData("psogmlib.selectOBNZ100Q_C", pData);	//예방점검
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ100Q_A", list1);
		map.addAttribute("ds_OBNZ100Q_B", list2);
		map.addAttribute("ds_OBNZ100Q_C", list3);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-점검체크리스트 마스터
	 * @see
	 * 	- 2016-07-01	:	제환복
	***********************************************************************/
	public void selectOBNZ110(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ110", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ110", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBNZ110(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ110");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ110");
		//////////////////////////////////////////////////////////////		
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
			
		String chgCd = (String)pArg.get("CHGCD");
		String chkCnt = (String)pArg.get("P_CNT");
		String dDate = (String)pArg.get("DDATE");
		String rDate = (String)pArg.get("RDATE");
		System.out.println("chgCd 확인=="+chgCd);//syso

		
		dao.startTransaction(); //tr 시작
		if(chgCd.equals("0")){
			while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
					Map pData = (Map) it_d.next();
					pData.put("LIB1", (String)pArg.get("LIB1"));
					pData.put("LIB2", (String)pArg.get("LIB2"));
					pData.put("LIB3", (String)pArg.get("LIB3"));
					pData.put("USRID", (String)pArg.get("USER_ID"));
					emptyPN = (String) pData.get("LINCD");
					rowType = (String) pData.get("ROW_TYPE");
					if (emptyPN != "") {
						if ("delete".equals(rowType)) {
							pData.put("OLD_SPOCD", (String) pData.get("SPOCD"));
							pData.put("OLD_ITECD", (String) pData.get("ITECD"));
							Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ110_Check",pData);
							if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
								if(CheckCnt.get("CNT").equals(0)){
									//삭제불가(대상이 없음)
									HashMap errMap = new HashMap();
									errMap.put("SPOCD", pData.get("OLD_SPOCD"));
									errMap.put("ITECD", pData.get("OLD_ITECD"));
									errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
									errList.add(errMap);
								}else{
									dao.deleteData("psogmlib.deleteOBNZ110", pData);
								}
							}
						}
					}
				}
				bufCnt=0;
				while (it_iu.hasNext()) {
					Map pData = (Map) it_iu.next();
					pData.put("LIB1", (String)pArg.get("LIB1"));
					pData.put("LIB2", (String)pArg.get("LIB2"));
					pData.put("LIB3", (String)pArg.get("LIB3"));
					pData.put("USRID", (String)pArg.get("USER_ID"));
					emptyPN = (String) pData.get("LINCD");
					
					rowType = (String) pData.get("ROW_TYPE");
					if (emptyPN != "") {
						if(bufCnt < bufSize){
							if ("insert".equals(rowType)) {
								pData.put("OLD_SPOCD", (String) pData.get("SPOCD"));
								pData.put("OLD_ITECD", (String) pData.get("ITECD"));
								Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ110_Check",pData);
								if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
									if(CheckCnt.get("CNT").equals(1)){
										//insert 불가(대상이 있음)
										HashMap errMap = new HashMap();
										errMap.put("SPOCD", pData.get("OLD_SPOCD"));
										errMap.put("ITECD", pData.get("OLD_ITECD"));
										errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
										errList.add(errMap);
									}else{
										dao.insertData("psogmlib.insertOBNZ110", pData);
									}
								}
							} else if ("update".equals(rowType)) {
								pData.put("OLD_SPOCD", ds.getOrgBuffColumn(bufCnt, "SPOCD").getString());
								pData.put("OLD_ITECD", ds.getOrgBuffColumn(bufCnt, "ITECD").getString());
								Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ110_Check",pData);
								if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
									if(CheckCnt.get("CNT").equals(0)){
										//update 불가(대상이 없음)
										HashMap errMap = new HashMap();
										errMap.put("SPOCD", pData.get("OLD_SPOCD"));
										errMap.put("ITECD", pData.get("OLD_ITECD"));
										errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
										errList.add(errMap);
									}else{
										dao.updateData("psogmlib.updateOBNZ110", pData);
									}
								}
							}				
						}
						bufCnt++;
					}
				}
		}else{
			while (it_iu.hasNext()) {
				Map pData = (Map) it_iu.next();
				pData.put("LIB1", (String)pArg.get("LIB1"));
				pData.put("LIB2", (String)pArg.get("LIB2"));
				pData.put("LIB3", (String)pArg.get("LIB3"));
				pData.put("USRID", (String)pArg.get("USER_ID"));
				pData.put("DDATE", dDate);
				pData.put("RDATE", rDate);
				emptyPN = (String) pData.get("LINCD");
				rowType = (String) pData.get("ROW_TYPE");
				if (emptyPN != "") {
					if (!"delete".equals(rowType)) {
						Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ110_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("SPOCD", pData.get("OLD_SPOCD"));
								errMap.put("ITECD", pData.get("OLD_ITECD"));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("psogmlib.insertOBNZ110", pData);
							}
						}
					}
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ110_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-중점설비점검
	 * @see
	 * 	- 2016-05-24	:	제환복
	***********************************************************************/
	public void selectOBNZ120(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ120", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ120", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBNZ120(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ120");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ120");
		//////////////////////////////////////////////////////////////	
		System.out.println(ds);
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
			
		dao.startTransaction(); //tr 시작
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_MSHNO", (String) pData.get("MSHNO"));
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ120_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("LINCD"));
							errMap.put("MSHNO", pData.get("OLD_MSHNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errMap.put("PLNDT", pData.get(""));
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBNZ120", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					if ("insert".equals(rowType)) {
						pData.put("OLD_MSHNO", (String) pData.get("MSHNO"));
						Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ120_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("LINCD", pData.get("LINCD"));
								errMap.put("MSHNO", pData.get("OLD_MSHNO"));
								errMap.put("PLNDT", pData.get(""));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("psogmlib.insertOBNZ120", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						pData.put("OLD_MSHNO", ds.getOrgBuffColumn(bufCnt, "MSHNO").getString());
/*						pData.put("ORG_MOND1", ds.getOrgBuffColumn(bufCnt, "MOND1").getString());
						pData.put("ORG_MOND2", ds.getOrgBuffColumn(bufCnt, "MOND2").getString());
						pData.put("ORG_MOND3", ds.getOrgBuffColumn(bufCnt, "MOND3").getString());
						pData.put("ORG_MOND4", ds.getOrgBuffColumn(bufCnt, "MOND4").getString());
						pData.put("ORG_MOND5", ds.getOrgBuffColumn(bufCnt, "MOND5").getString());
						pData.put("ORG_MOND6", ds.getOrgBuffColumn(bufCnt, "MOND6").getString());
						pData.put("ORG_MOND7", ds.getOrgBuffColumn(bufCnt, "MOND7").getString());
						pData.put("ORG_MOND8", ds.getOrgBuffColumn(bufCnt, "MOND8").getString());
						pData.put("ORG_MOND9", ds.getOrgBuffColumn(bufCnt, "MOND9").getString());
						pData.put("ORG_MOND10", ds.getOrgBuffColumn(bufCnt, "MOND10").getString());
						pData.put("ORG_MOND11", ds.getOrgBuffColumn(bufCnt, "MOND11").getString());
						pData.put("ORG_MOND12", ds.getOrgBuffColumn(bufCnt, "MOND12").getString());*/
						
						String p_MOND_ORG="";
						String p_MOND_NEW="";
						
						int chkCnt=0;
						for(int i=1; i<=12; i++){
							p_MOND_ORG = ds.getOrgBuffColumn(bufCnt, "MOND"+i).asString();
							p_MOND_NEW = (String) pData.get("MOND"+i);
							//System.out.println("기존에 있음 MOND"+i +"="+ p_MOND);
							if(p_MOND_ORG !=""){
								System.out.println("기존에 있음 MOND"+i+"=="+p_MOND_ORG );
								pData.put("OLD_PLNDT", p_MOND_ORG);
								
								System.out.println("MOND=="+p_MOND_ORG+"=="+p_MOND_NEW );
								System.out.println(pData.get("OLD_PLNDT"));
								if(!p_MOND_ORG.equals(p_MOND_NEW)){
									System.out.println("다름");
									Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ120_Check2",pData);
									
									chkCnt = Integer.parseInt( CheckCnt.get("CNT").toString());
									System.out.println("chkCnt=="+chkCnt);
									
									if(chkCnt!=0){
										HashMap errMap = new HashMap();
										errMap.put("LINCD", pData.get("LINCD"));
										errMap.put("MSHNO", pData.get("OLD_MSHNO"));
										errMap.put("PLNDT", pData.get("OLD_PLNDT"));
										errMap.put("RTMSG", "수정불가(실적이 등록된 자료입니다.)");
										errList.add(errMap);	
									}

									
								}								
							}
							/*
							else{
								System.out.println("기존에 없음 MOND"+i);
							}
							*/
						}
						
						if(chkCnt == 0){
							Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ120_Check",pData);
							if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
								if(CheckCnt.get("CNT").equals(0)){
									//update 불가(대상이 없음)
									HashMap errMap = new HashMap();
									errMap.put("LINCD", pData.get("LINCD"));
									errMap.put("MSHNO", pData.get("OLD_MSHNO"));
									errMap.put("PLNDT", pData.get(""));
									errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
									errList.add(errMap);
								}else{
									dao.updateData("psogmlib.updateOBNZ120", pData);
								}
							}	
						}

					}				
				}
				bufCnt++;
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ120_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-중점점검결과등록
	 * @see
	 * 	- 2016-07-14	:	제환복
	***********************************************************************/
	public void selectOBNZ120_DataCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);

		List list = dao.getListData("psogmlib.selectOBNZ120_DataCheck", pData);
		List chkList = new ArrayList();
		Iterator chk = list.iterator();
		String chkDT ="";
		while (chk.hasNext()) {
			Map chkData = (Map) chk.next();
			for(int i=1; i<13; i++){
				System.out.println(i+"=="+chkData.get("MOND"+i));
				chkDT = chkData.get("MOND"+i).toString().trim();
				if(!chkDT.isEmpty()){
					HashMap chkMap = new HashMap();
					chkMap.put("MOND", chkDT);		
					chkList.add(chkMap);
				}
			}
		}
/*		
		List<Map> list = dao.getListData("psogmlib.selectOBNZ120_DataCheck", pData); 
		List chkList = new ArrayList();
		Integer cnt = 1;
		String chkDT ="";
		for (Map map : list) {
			chkDT = map.get("MOND"+cnt).toString().trim();
			if(!chkDT.isEmpty()){
				HashMap chkMap = new HashMap();
				chkMap.put("MOND", chkDT);		
				chkList.add(chkMap);
			}
			cnt++;
		}
*/
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DataCheck", chkList);
		new MiPlatformView().render(map, request, response);
	}	
	public void selectOBNZ130(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ130", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ130", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBNZ130(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ130");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ130");
		//////////////////////////////////////////////////////////////		
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//
			
		dao.startTransaction(); //tr 시작
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			System.out.println("삭제=="+(String) pData.get("LINCD"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("PLNDT", (String)pArg.get("PLNDT"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					System.out.println("삭제");
					//pData.put("OLD_MSHNO", (String) pData.get("MSHNO"));
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ130_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("LINCD"));
							errMap.put("MSHNM", pData.get("MSHNO"));
							//errMap.put("ITECD", pData.get("ITECD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBNZ130", pData);
							//중점설비계획의 완료여부 갱신
							List list2 = dao.getListData("psogmlib.selectOBNZ120_DataCheck", pData);
							List chkList = new ArrayList();
							Map chkData = (Map) list2.get(0);
							String chkDT ="";
							for(int i=1; i<13; i++){
								//System.out.println(i+"=="+chkData.get("MOND"+i)+"=="+chkPLNDT);
								chkDT = chkData.get("MOND"+i).toString().trim();
								//CLTCD : 1.완료, 2:진행중, 3:예정, 4:지연
								if(!chkDT.isEmpty()){
									if(Integer.parseInt(chkDT) > 0){	//계획일보다 큰게 있으면 진행중
										pData.put("CLTCD", "2");
									}else{	//계획일보다 큰게 없으면 완료
										pData.put("CLTCD", "3");
									}
									dao.updateData("psogmlib.updateOBNZ120_CLT", pData);
								}
							}
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("PLNDT", (String)pArg.get("PLNDT"));
			pData.put("SILDT", (String)pArg.get("SILDT"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			String chkPLNDT=(String)pArg.get("PLNDT");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if (!"delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ130_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							dao.insertData("psogmlib.insertOBNZ130", pData);
						}else{
							dao.updateData("psogmlib.updateOBNZ130", pData);
						}						
						//중점설비계획의 완료여부 갱신
						List list2 = dao.getListData("psogmlib.selectOBNZ120_DataCheck", pData);
						List chkList = new ArrayList();
						Map chkData = (Map) list2.get(0);
						String chkDT ="";
						System.out.println("list2=="+list2);
						for(int i=1; i<13; i++){
							//System.out.println(i+"=="+chkData.get("MOND"+i)+"=="+chkPLNDT);
							chkDT = chkData.get("MOND"+i).toString().trim();
							//CLTCD : 1.완료, 2:진행중, 3:예정, 4:지연
							if(!chkDT.isEmpty()){
								System.out.println(i+"=="+chkData.get("MOND"+i)+"=="+chkPLNDT);
								if(Integer.parseInt(chkDT) > Integer.parseInt(chkPLNDT)){	//계획일보다 큰게 있으면 진행중
									pData.put("CLTCD", "2");
								}else{	//계획일보다 큰게 없으면 완료
									pData.put("CLTCD", "1");
								}
								dao.updateData("psogmlib.updateOBNZ120_CLT", pData);
							}
						}
					}
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ130_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	public void selectOBNZ130R(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ130R", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ130R", list);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-계획보전점검
	 * @see
	 * 	- 2016-09-30	:	제환복
	***********************************************************************/
	public void selectOBNZ180(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ180", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ180", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBNZ180(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ180");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ180");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSHNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ180_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSHNM", pData.get("MSHNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBNZ180", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSHNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ180_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("MSHNM", pData.get("MSHNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBNZ180", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ180_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSHNM", pData.get("MSHNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBNZ180", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ180_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-예방점검관리
	 * @see
	 * 	- 2016-11-04	:	제환복
	***********************************************************************/
	public void selectOBNZ190(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ190", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ190", list);
		new MiPlatformView().render(map, request, response);
	}
	/* OBNZ190_A PGM 소스
	public void saveOBNZ190(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ190");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ190");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSHNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ190_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSHNM", pData.get("MSHNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBNZ190", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSHNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ190_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("MSHNM", pData.get("MSHNO"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBNZ190", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ190_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSHNM", pData.get("MSHNO"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBNZ190", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ190_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	*/
	public void saveOBNZ190(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ190");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ190");
		//////////////////////////////////////////////////////////////	
		System.out.println(ds);
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
			
		dao.startTransaction(); //tr 시작
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_MSHNO", (String) pData.get("MSHNO"));
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ190_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("LINCD"));
							errMap.put("MSHNO", pData.get("OLD_MSHNO"));
							errMap.put("PLNDT", pData.get(""));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBNZ190", pData);
						}
					}
				}
			}
		}
		bufCnt=0;
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if(bufCnt < bufSize){
					if ("insert".equals(rowType)) {
						pData.put("OLD_MSHNO", (String) pData.get("MSHNO"));
						Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ190_Check",pData);
						if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
							if(CheckCnt.get("CNT").equals(1)){
								//insert 불가(대상이 있음)
								HashMap errMap = new HashMap();
								errMap.put("LINCD", pData.get("LINCD"));
								errMap.put("MSHNO", pData.get("OLD_MSHNO"));
								errMap.put("PLNDT", pData.get(""));
								errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
								errList.add(errMap);
							}else{
								dao.insertData("psogmlib.insertOBNZ190", pData);
							}
						}
					} else if ("update".equals(rowType)) {
						pData.put("OLD_MSHNO", ds.getOrgBuffColumn(bufCnt, "MSHNO").getString());					
						String p_MOND_ORG="";
						String p_MOND_NEW="";
						
						int chkCnt=0;
						for(int i=1; i<=12; i++){
							p_MOND_ORG = ds.getOrgBuffColumn(bufCnt, "MOND"+i).asString();
							p_MOND_NEW = (String) pData.get("MOND"+i);
							if(p_MOND_ORG !=""){
								pData.put("OLD_PLNDT", p_MOND_ORG);								
								if(!p_MOND_ORG.equals(p_MOND_NEW)){
									Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ190_Check2",pData);
									chkCnt = Integer.parseInt( CheckCnt.get("CNT").toString());
									if(chkCnt!=0){
										HashMap errMap = new HashMap();
										errMap.put("LINCD", pData.get("LINCD"));
										errMap.put("MSHNO", pData.get("OLD_MSHNO"));
										errMap.put("PLNDT", pData.get("OLD_PLNDT"));
										errMap.put("RTMSG", "수정불가(실적이 등록된 자료입니다.)");
										errList.add(errMap);	
									}									
								}								
							}
						}
						if(chkCnt == 0){
							Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ190_Check",pData);
							if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
								if(CheckCnt.get("CNT").equals(0)){
									//update 불가(대상이 없음)
									HashMap errMap = new HashMap();
									errMap.put("LINCD", pData.get("LINCD"));
									errMap.put("MSHNO", pData.get("OLD_MSHNO"));
									errMap.put("PLNDT", pData.get(""));
									errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
									errList.add(errMap);
								}else{
									dao.updateData("psogmlib.updateOBNZ190", pData);
								}
							}	
						}

					}				
				}
				bufCnt++;
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ190_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-예방점검결과등록
	 * @see
	 * 	- 2016-11-16	:	제환복
	***********************************************************************/
	/* OBNZ190_A, OBNZ200_A PGM 소스
	public void selectOBNZ190_DataCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);

		List list = dao.getListData("psogmlib.selectOBNZ190_DataCheck", pData);
		List chkList = new ArrayList();
		Iterator chk = list.iterator();
		String chkDT ="";
		while (chk.hasNext()) {
			Map chkData = (Map) chk.next();
			chkDT = chkData.get("CHPLN").toString().trim();
			if(!chkDT.isEmpty()){
				HashMap chkMap = new HashMap();
				chkMap.put("MOND", chkDT);		
				chkList.add(chkMap);
			}
		}

		ModelMap map = new ModelMap();
		map.addAttribute("ds_DataCheck", chkList);
		new MiPlatformView().render(map, request, response);
	}	
	public void selectOBNZ200(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ200", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ200", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBNZ200(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ200");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ200");
		//////////////////////////////////////////////////////////////		
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//syso
			
		dao.startTransaction(); //tr 시작
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("PLNYM", (String)pArg.get("PLNYM"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					pData.put("OLD_MSHNO", (String) pData.get("MSHNO"));
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("LINCD"));
							errMap.put("MSHNM", pData.get("MSHNO"));
							errMap.put("ITECD", pData.get("ITECD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBNZ200", pData);
							//예방계획의 완료여부 갱신
							List list2 = dao.getListData("psogmlib.selectOBNZ190_DataCheck", pData);
							List chkList = new ArrayList();
							Map chkData = (Map) list2.get(0);
							String chkDT ="";
							chkDT = chkData.get("CHPLN").toString().trim();
							//CLTCD : T.완료, P:진행중, F:예정, 4:지연
							if(!chkDT.isEmpty()){
								if(Integer.parseInt(chkDT) > 0){	//계획일보다 큰게 있으면 진행중
									pData.put("SIGNE", "P");
								}else{	//계획일보다 큰게 없으면 완료
									pData.put("SIGNE", "F");
								}
								dao.updateData("psogmlib.updateOBNZ190_CLT", pData);
							}
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("LIB3", (String)pArg.get("LIB3"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("PLNYM", (String)pArg.get("PLNYM"));
			pData.put("SILDT", (String)pArg.get("SILDT"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			String chkPLNYM=(String)pArg.get("PLNYM");
			
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if (!"delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							dao.insertData("psogmlib.insertOBNZ200", pData);
						}else{
							dao.updateData("psogmlib.updateOBNZ200", pData);
						}
						//예방계획의 완료여부 갱신
						List list2 = dao.getListData("psogmlib.selectOBNZ190_DataCheck", pData);
						List chkList = new ArrayList();
						Map chkData = (Map) list2.get(0);
						String chkDT ="";
						System.out.println("list2=="+list2);
						chkDT = chkData.get("CHPLN").toString().trim();
						//CLTCD : T.완료, P:진행중, F:예정, 4:지연
						if(!chkDT.isEmpty()){
							System.out.println(chkData.get("CHPLN")+"=="+chkPLNYM);
							if(Integer.parseInt(chkDT) > Integer.parseInt(chkPLNYM)){	//계획일보다 큰게 있으면 진행중
								pData.put("SIGNE", "P");
							}else{	//계획일보다 큰게 없으면 완료
								pData.put("SIGNE", "T");
							}
							dao.updateData("psogmlib.updateOBNZ190_CLT", pData);
						}
					}
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ200_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
		
	}
*/
	public void selectOBNZ190_DataCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
	
		List list = dao.getListData("psogmlib.selectOBNZ190_DataCheck", pData);
		List chkList = new ArrayList();
		Iterator chk = list.iterator();
		String chkDT ="";
		while (chk.hasNext()) {
			Map chkData = (Map) chk.next();
			for(int i=1; i<13; i++){
				System.out.println(i+"=="+chkData.get("MOND"+i));
				chkDT = chkData.get("MOND"+i).toString().trim();
				if(!chkDT.isEmpty()){
					HashMap chkMap = new HashMap();
					chkMap.put("MOND", chkDT);		
					chkList.add(chkMap);
				}
			}
		}
		ModelMap map = new ModelMap();
		map.addAttribute("ds_DataCheck", chkList);
		new MiPlatformView().render(map, request, response);
	}	
	public void selectOBNZ200(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ200", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ200", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBNZ200(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ200");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ200");
		//////////////////////////////////////////////////////////////		
		int bufCnt=0;
		int bufSize=0;	//orginal dataset buffer size
			bufSize=ds.getRowCount();
			System.out.println("originalIndex 확인=="+bufSize);//
			
		dao.startTransaction(); //tr 시작
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			System.out.println("삭제=="+(String) pData.get("LINCD"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("PLNDT", (String)pArg.get("PLNDT"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					System.out.println("삭제");
					//pData.put("OLD_MSHNO", (String) pData.get("MSHNO"));
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("LINCD"));
							errMap.put("MSHNM", pData.get("MSHNO"));
							//errMap.put("ITECD", pData.get("ITECD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBNZ200", pData);
							//중점설비계획의 완료여부 갱신
							List list2 = dao.getListData("psogmlib.selectOBNZ190_DataCheck", pData);
							List chkList = new ArrayList();
							Map chkData = (Map) list2.get(0);
							String chkDT ="";
							for(int i=1; i<13; i++){
								//System.out.println(i+"=="+chkData.get("MOND"+i)+"=="+chkPLNDT);
								chkDT = chkData.get("MOND"+i).toString().trim();
								//CLTCD : 1.완료, 2:진행중, 3:예정, 4:지연
								if(!chkDT.isEmpty()){
									if(Integer.parseInt(chkDT) > 0){	//계획일보다 큰게 있으면 진행중
										pData.put("CLTCD", "2");
									}else{	//계획일보다 큰게 없으면 완료
										pData.put("CLTCD", "3");
									}
									dao.updateData("psogmlib.updateOBNZ190_CLT", pData);
								}
							}
						}
					}
				}
			}
		}
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("COMPS", (String)pArg.get("COMPS"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("PLNDT", (String)pArg.get("PLNDT"));
			pData.put("SILDT", (String)pArg.get("SILDT"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			String chkPLNDT=(String)pArg.get("PLNDT");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if (!"delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							dao.insertData("psogmlib.insertOBNZ200", pData);
						}else{
							dao.updateData("psogmlib.updateOBNZ200", pData);
						}						
						//중점설비계획의 완료여부 갱신
						List list2 = dao.getListData("psogmlib.selectOBNZ190_DataCheck", pData);
						List chkList = new ArrayList();
						Map chkData = (Map) list2.get(0);
						String chkDT ="";
						System.out.println("list2=="+list2);
						for(int i=1; i<13; i++){
							//System.out.println(i+"=="+chkData.get("MOND"+i)+"=="+chkPLNDT);
							chkDT = chkData.get("MOND"+i).toString().trim();
							//CLTCD : 1.완료, 2:진행중, 3:예정, 4:지연
							if(!chkDT.isEmpty()){
								System.out.println(i+"=="+chkData.get("MOND"+i)+"=="+chkPLNDT);
								if(Integer.parseInt(chkDT) > Integer.parseInt(chkPLNDT)){	//계획일보다 큰게 있으면 진행중
									pData.put("CLTCD", "2");
								}else{	//계획일보다 큰게 없으면 완료
									pData.put("CLTCD", "1");
								}
								dao.updateData("psogmlib.updateOBNZ190_CLT", pData);
							}
						}
					}
				}
			}
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ200_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	public void selectOBNZ200R(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ200R", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ200R", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-통계(작업자실적)-개인별실적조회
	 * @see
	 * 	- 2016-11-03	:	제환복
	***********************************************************************/
	public void selectOBNZ210Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psogmlib.selectOBNZ210Q_Prd", pData);	//라인기준
		List list2 = dao.getListData("psogmlib.selectOBNZ210Q_Line", pData);	//설비기준
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ210Q_A", list1);
		map.addAttribute("ds_OBNZ210Q_B", list2);
		new MiPlatformView().render(map, request, response);
		
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-통계(작업자실적)-작업자전체실적조회
	 * @see
	 * 	- 2016-11-04	:	제환복
	***********************************************************************/
	public void selectOBNZ220Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ220Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ220Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-통계(설비이력실적)-장시간고장실적
	 * @see
	 * 	- 2016-12-09	:	제환복
	***********************************************************************/
	public void selectOBNZ230Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psogmlib.selectOBNZ230Q_Prd", pData);	//라인기준
		List list2 = dao.getListData("psogmlib.selectOBNZ230Q_Line", pData);	//설비기준
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ230Q_A", list1);
		map.addAttribute("ds_OBNZ230Q_B", list2);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-통계(설비이력실적)-주요라인고장실적
	 * @see
	 * 	- 2016-12-09	:	제환복
	***********************************************************************/
	public void selectOBNZ240Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psogmlib.selectOBNZ240Q_Prd", pData);	//라인기준
		List list2 = dao.getListData("psogmlib.selectOBNZ240Q_Line", pData);	//설비기준
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ240Q_A", list1);
		map.addAttribute("ds_OBNZ240Q_B", list2);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-통계(설비이력실적)-주요설비고장실적
	 * @see
	 * 	- 2016-12-09	:	제환복
	***********************************************************************/
	public void selectOBNZ250Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psogmlib.selectOBNZ250Q_Line", pData);	//라인기준
		List list2 = dao.getListData("psogmlib.selectOBNZ250Q_Mshno", pData);	//설비기준
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ250Q_A", list1);
		map.addAttribute("ds_OBNZ250Q_B", list2);
		new MiPlatformView().render(map, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-통계(설비이력실적)-워스트50설비
	 * @see
	 * 	- 2016-12-09	:	제환복
	***********************************************************************/
	public void selectOBNZ260Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psogmlib.selectOBNZ260Q_Line", pData);	//라인기준
		List list2 = dao.getListData("psogmlib.selectOBNZ260Q_Mshno", pData);	//설비기준
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ260Q_A", list1);
		map.addAttribute("ds_OBNZ260Q_B", list2);
		new MiPlatformView().render(map, request, response);
	}

	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-실적집계-전년도 계획관리(가동시간, 고장시간, 고장건수)
	 * @see
	 * 	- 2019-05-24	:	제환복
	***********************************************************************/
	public void selectOBNZ280(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ280", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ280", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBNZ280(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ280");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		String pTable="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ280");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ280_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("LINCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBNZ280", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {	//미사용
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ280_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("LINCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBNZ280", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ280_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							dao.insertData("psogmlib.insertOBNZ280", pData);

						}else{
							dao.updateData("psogmlib.updateOBNZ280", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ280_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-실적집계-가동시간 실적관리
	 * @see
	 * 	- 2016-12-13	:	제환복
	***********************************************************************/
	public void selectOBNZ290(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ290", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ290", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBNZ290(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBNZ290");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBNZ290");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ290_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("LINCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBNZ290", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("PYEAR", (String)pArg.get("PYEAR"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {	//미사용
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ290_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("LINCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBNZ290", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBNZ290_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							dao.insertData("psogmlib.insertOBNZ290", pData);

						}else{
							dao.updateData("psogmlib.updateOBNZ290", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBNZ290_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-실적집계-실적(KPI)
	 * @see
	 * 	- 2016-12-08	:	제환복
	***********************************************************************/
	/* 생산실적(QR실적사용 및 등록) - 미사용test중 */
	public void selectOBNZ300(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ300", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ300", list);
		new MiPlatformView().render(map, request, response);
	}
	/* 조회만...생산실적(사용자등록)*/
	public void selectOBNZ300Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ300Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ300Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-실적집계-실적(MTBF)
	 * @see
	 * 	- 2016-12-08	:	제환복
	***********************************************************************/
	public void selectOBNZ310Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ310Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ310Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-실적집계-실적(MTTR)
	 * @see
	 * 	- 2016-12-08	:	제환복
	***********************************************************************/
	public void selectOBNZ320Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ320Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ320Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-실적집계-실적(고장률)
	 * @see
	 * 	- 2019-05-22	:	제환복
	***********************************************************************/
	public void selectOBNZ330Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ330Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ330Q", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-실적집계-실적(당월지수)
	 * @see
	 * 	- 2019-05-22	:	제환복
	***********************************************************************/
	public void selectOBNZ340Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psogmlib.selectOBNZ340Q_A", pData);	//라인기준
		List list2 = dao.getListData("psogmlib.selectOBNZ340Q_B", pData);	//설비기준
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ340Q_A", list1);
		map.addAttribute("ds_OBNZ340Q_B", list2);
		new MiPlatformView().render(map, request, response);

	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-알림/통계-실적집계-실적(월별MTBF/MTTR)
	 * @see
	 * 	- 2019-05-30	:	제환복
	***********************************************************************/
	public void selectOBNZ340Q_SUM(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBNZ340Q_A", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBNZ340Q_SUM", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-제품코드MASTER
	 * @see
	 * 	- 2016-12-15	:	제환복
	***********************************************************************/
	public void selectOBMZ100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ100", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ100", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ100(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ100");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ100");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ100_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ100", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSTCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ100_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ100", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ100_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSTCD", pData.get("MSTCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ100", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ100_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-라인별 설비MASTER
	 * @see
	 * 	- 2017-01-20	:	제환복
	***********************************************************************/
	public void selectOBMZ105(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ105", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ105", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ105(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ105");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ105");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSHNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ105_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSHNO", pData.get("MSHNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ105", pData);
						}
					}
				}
			}
		}	
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSHNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ105_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("ERRCD", pData.get("ERRCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ105", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ105_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							dao.insertData("psogmlib.insertOBMZ105", pData);
						}else{
							dao.updateData("psogmlib.updateOBMZ105", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ105_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-라인별 설비MASTER_설비매뉴얼 및 SOFT백업관리
	 * @see
	 * 	- 2017-01-20	:	제환복
	***********************************************************************/
	public void selectOBMZ105_ADD(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ105_ADD", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ105_ADD", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ105_ADD(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ105_ADD");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ105_ADD");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSHNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ105_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("MSHNO", pData.get("MSHNO"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ105_ADD", pData);
						}
					}
				}
			}
		}	
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("MSHNO");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ105_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("ERRCD", pData.get("ERRCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ105_ADD", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ105_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							dao.insertData("psogmlib.insertOBMZ105_ADD", pData);
						}else{
							dao.updateData("psogmlib.updateOBMZ105_ADD", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ105_ADD_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-설비별 에러MASTER
	 * @see
	 * 	- 2016-10-21	:	제환복
	***********************************************************************/
	public void selectOBMZ110(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ110", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ110", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ110(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ110");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ110");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("ERRCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ110_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ERRCD", pData.get("ERRCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ110", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("ERRCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ110_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("ERRCD", pData.get("ERRCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ110", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ110_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ERRCD", pData.get("ERRCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ110", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ110_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-안전보호구 MASTER
	 * @see
	 * 	- 2016-12-27	:	제환복
	***********************************************************************/
	public void selectOBMZ120(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ120", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ120", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ120(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ120");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ120");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("EQUCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ120_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("EQUCD", pData.get("EQUCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ120", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("EQUCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ120_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("EQUCD", pData.get("EQUCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ120", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ120_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("EQUCD", pData.get("EQUCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ120", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ120_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-설비별 필요보호구 MASTER
	 * @see
	 * 	- 2016-12-27	:	제환복
	***********************************************************************/
	public void selectOBMZ130(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ130", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ130", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ130(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ130");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ130");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			pData.put("LINCD", (String)pArg.get("LINCD"));
			pData.put("MSHNO", (String)pArg.get("MSHNO"));			
			emptyPN = (String) pData.get("EQUCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ130_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("EQUCD", pData.get("EQUCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ130", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			pData.put("LINCD", (String)pArg.get("LINCD"));
			pData.put("MSHNO", (String)pArg.get("MSHNO"));
			emptyPN = (String) pData.get("EQUCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ130_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("EQUCD", pData.get("EQUCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ130", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ130_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							dao.insertData("psogmlib.insertOBMZ130", pData);

						}else{
							dao.updateData("psogmlib.updateOBMZ130", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ130_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-재해 MASTER
	 * @see
	 * 	- 2016-12-27	:	제환복
	***********************************************************************/
	public void selectOBMZ140(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ140", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ140", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ140(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ140");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ140");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("ACCCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ140_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ACCCD", pData.get("ACCCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ140", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("ACCCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ140_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("ACCCD", pData.get("ACCCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ140", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ140_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("EQUCD", pData.get("EQUCD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ140", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ140_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-설비별 발생재해 MASTER
	 * @see
	 * 	- 2016-12-27	:	제환복
	***********************************************************************/
	public void selectOBMZ150(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ150", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ150", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ150(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ150");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ150");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			pData.put("LINCD", (String)pArg.get("LINCD"));
			pData.put("MSHNO", (String)pArg.get("MSHNO"));			
			emptyPN = (String) pData.get("ACCCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ150_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ACCCD", pData.get("ACCCD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ150", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			pData.put("LINCD", (String)pArg.get("LINCD"));
			pData.put("MSHNO", (String)pArg.get("MSHNO"));
			emptyPN = (String) pData.get("ACCCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ150_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("ACCCD", pData.get("ACCCD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ150", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ150_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							dao.insertData("psogmlib.insertOBMZ150", pData);

						}else{
							dao.updateData("psogmlib.updateOBMZ150", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ150_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-작업자MASTER
	 * @see
	 * 	- 2016-10-21	:	제환복
	***********************************************************************/
	public void selectOBMZ160(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ160", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ160", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ160(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ160");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ160");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ160_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ160", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ160_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ160", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ160_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ160", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ160_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-알림수신설정마스터
	 * @see
	 * 	- 2016-12-28	:	제환복
	***********************************************************************/
	public void selectOBMZ170(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ170", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ170", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ170(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ170");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ170");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ170_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ170", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("SABUN");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ170_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ170", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ170_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ170", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ170_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-공장레이아웃설정
	 * @see
	 * 	- 2016-12-29	:	제환복
	***********************************************************************/
	public void selectOBMZ180(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ180", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ180", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ180(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ180");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ180");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("FNAME");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ180_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("FNAME", pData.get("FNAME"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ180", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("FNAME");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ180_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("FNAME", pData.get("FNAME"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ180", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ180_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("FNAME", pData.get("FNAME"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ180", pData);
						}
						/*
						if(CheckCnt.get("CNT").equals(0)){
							dao.insertData("psogmlib.insertOBMZ180", pData);

						}else{
							dao.updateData("psogmlib.updateOBMZ180", pData);
						}
						*/		
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ180_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-라인현황입력
	 * @see
	 * 	- 2016-12-29	:	제환복
	***********************************************************************/
	public void selectOGM_MSHNO_POP(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOGM_MSHNO_POP", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_MSHNO_POP", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOBMZ190(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ190", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ190", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ190(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ190");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		String statusMH="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ190");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("P_JOB", (String)pArg.get("P_JOB"));	//ARG로 받을경우 전체ROW에 해당되어 문제가 발생할 수 있음.
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("P_JOB");
			statusMH = (String) pData.get("M_STATU");
			rowType = (String) pData.get("ROW_TYPE");
System.out.println(emptyPN);
			if (emptyPN != "") {
				if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ190_LCheck",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("LINCD", pData.get("P_JOB"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ190_LStatus", pData);
							//설비이상인경우만 처리됨.
							if ("E".equals(emptyPN)) {
								System.out.println("설비이상");
								Map CheckCnt2 = (Map)dao.getReadData("psogmlib.selectOBMZ190_MCheck",pData);
								if(CheckCnt2!=null && CheckCnt2.get("CNT")!=null && !CheckCnt2.get("CNT").equals("")){
									if(CheckCnt2.get("CNT").equals(0)){
										//update 불가(대상이 없음)
										HashMap errMap = new HashMap();
										errMap.put("MSHNO", pData.get("P_JOB"));
										errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
										errList.add(errMap);
									}else{
										dao.updateData("psogmlib.updateOBMZ190_MStatus", pData);
										if ("F".equals(statusMH) || "0".equals(statusMH)) {
											dao.updateData("psogmlib.updateOBMZ190_OBM200", pData);
										}
									}
								}
							}
							
						}
						
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ190_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	//추가 2018.03.19 설비플래그 변경여부 확인- OBMZ190, OBMZ210
	public void selectOBMZ190_MStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ190_MStatus", pData);
		System.out.println(list);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ190_MCheck", list);
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-보전의뢰 작업등록
	 * @see
	 * 	- 2017-02-21	:	제환복
	***********************************************************************/
	
	public void selectOBMZ200(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ200", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ200", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ200(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ200");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();// error List
		List seqList = new ArrayList();// Seq List
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ200");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("ERYMD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ERYMD", pData.get("ERYMD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ200", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("ERYMD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				String getSeq="";
				if ("insert".equals(rowType)) {
					Map CheckSeq = (Map)dao.getReadData("psogmlib.selectOBMZ200_SEQ",pData);
					getSeq = CheckSeq.get("ERSEQ").toString();
					
					if("0".equals(getSeq)){	
						System.out.println("신규");
						pData.put("ERSEQ", "1");
						System.out.println(CheckSeq.get("ERSEQ"));
					}else{
						System.out.println("추가");
						pData.put("ERSEQ", Integer.parseInt(CheckSeq.get("ERSEQ").toString())+1);
						System.out.println(CheckSeq.get("ERSEQ"));			
					}
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("ERYMD", pData.get("ERYMD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ200", pData);
							
							HashMap seqMap = new HashMap();
							seqMap.put("ERSEQ", pData.get("ERSEQ"));
							seqList.add(seqMap);
						}
					}
				} else if ("update".equals(rowType)) {
					/*
					Map CheckSeq = (Map)dao.getReadData("psogmlib.selectOBMZ200_SEQ",pData);
					getSeq = CheckSeq.get("ERSEQ").toString();
					
					if("0".equals(getSeq)){	
						System.out.println("신규");
						pData.put("ERSEQ", "1");
						System.out.println(CheckSeq.get("ERSEQ"));
					}else{
						System.out.println("추가");
						pData.put("ERSEQ", Integer.parseInt(CheckSeq.get("ERSEQ").toString())+1);
						System.out.println(CheckSeq.get("ERSEQ"));			
					}
					*/
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ERYMD", pData.get("ERYMD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ200", pData);
						}	
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ200_CHECK", errList);//추가
		map.addAttribute("ds_OBMZ200_ERSEQ", seqList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-보전의뢰관리
	 * @see
	 * 	- 2017-02-21	:	제환복
	***********************************************************************/	
	public void selectOBMZ210(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ210", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ210", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ210(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ210");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ210");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("ERYMD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ERYMD", pData.get("ERYMD"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ200", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("ERYMD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				String getSeq="";
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("ERYMD", pData.get("ERYMD"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ200", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					
					//dao.updateData("psogmlib.updateOgm_maxNum" , pArg);
					
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ200_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("ERYMD", pData.get("ERYMD"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ200", pData);
						}	
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ210_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	//보전작업의뢰 추가
	public void saveOBMZ200_OBJ200PF(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pData = DataConverter.getMiPlatformData(pReq);
		dao.insertData("psogmlib.insertOBMZ200_OBJ200PF" , pData);
		new MiPlatformView().render(null, request, response);
	}
	//작업자 배치
	public void saveOBMZ200_OBM220PF(HttpServletRequest request, HttpServletResponse response) throws Exception {

		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ220");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds1 = in_dl.getDataset("ds_OBMZ220");
		//////////////////////////////////////////////////////////////		

		dao.startTransaction(); //tr 시작
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			System.out.println(pData);
			pData.put("LIB2", (String)pArg.get("LIB2"));
			emptyPN = (String) pData.get("ERYMD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ200_OBM220PF_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							//errMap.put("ERYMD", pData.get("ERYMD"));
							//errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							//errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ200_OBM220PF", pData);
						}
					}
					Map CheckCnt2 = (Map)dao.getReadData("psogmlib.selectOBMZ200_OBM220PF_Check2",pData);
					if(CheckCnt2!=null && CheckCnt2.get("CNT")!=null && !CheckCnt2.get("CNT").equals("")){
						if(CheckCnt2.get("CNT").equals(0)){
							dao.updateData("psogmlib.updateOBMZ200_OBM200PF", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("ACOMPS", (String)pArg.get("COMPS"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("SABUN");
			
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ200_OBM220PF_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							dao.updateData("psogmlib.updateOBMZ200_OBM220PF", pData);

						}else{
							dao.insertData("psogmlib.insertOBMZ200_OBM220PF", pData);
						}
					}

				}
			}       
		}
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ220_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	//설비상태변경
	public void saveOBMZ200_MStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOBMZ190_MStatus", pArg);
		new MiPlatformView().render(null, request, response);
	}
	//라인상태변경
	public void saveOBMZ200_LStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformRequest pReq 	= new PlatformRequest(request);
		pReq.receiveData();	
		Map pArg = DataConverter.getMiPlatformData(pReq);
		dao.updateData("psogmlib.updateOBMZ190_LStatus", pArg);
		new MiPlatformView().render(null, request, response);
	}	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-작업자배치
	 * @see
	 * 	- 2016-12-29	:	제환복
	***********************************************************************/

	public void selectOBMZ220(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ220", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ220", list);
		new MiPlatformView().render(map, request, response);
	}

	public void saveOBMZ220(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ220");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ220");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("FNAME");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ220_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("FNAME", pData.get("FNAME"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ220", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("FNAME");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ220_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("FNAME", pData.get("FNAME"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ220", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ220_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("FNAME", pData.get("FNAME"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ220", pData);
						}
						
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ220_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-전라인가동현황
	 * @see
	 * 	- 2017-04-30	:	제환복
	***********************************************************************/
	// 미사용 20170809 -TEST 확인시 사용 ->완료 후 주석처리 필요
	public void selectOBMZ230Q_OLD(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ230Q", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ230Q", list);
		new MiPlatformView().render(map, request, response);
	}
	
	public void selectOBMZ230Q(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psogmlib.selectOBMZ230Q_A", pData);
		List list2 = dao.getListData("psogmlib.selectOBMZ230Q_B", pData);
		List list3 = dao.getListData("psogmlib.selectOBMZ230Q_C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ230Q_A", list1);
		map.addAttribute("ds_OBMZ230Q_B", list2);
		map.addAttribute("ds_OBMZ230Q_C", list3);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOBMZ230Q_A(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list1 = dao.getListData("psogmlib.selectOBMZ230Q_A", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ230Q_A", list1);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOBMZ230Q_B(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list2 = dao.getListData("psogmlib.selectOBMZ230Q_B", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ230Q_B", list2);
		new MiPlatformView().render(map, request, response);
	}
	public void selectOBMZ230Q_C(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list3 = dao.getListData("psogmlib.selectOBMZ230Q_C", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ230Q_C", list3);
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-설총율 기준정보관리
	 * @see
	 * 	- 2019-10-22	:	제환복
	***********************************************************************/
	public void selectOBMZ250(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ250", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ250", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ250(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ250");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ250");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
		while (it_d.hasNext()) {  //tr발생이 insert발생 후 delete가 발생되므로 삭제먼저 진행 (중복오류발생)
			Map pData = (Map) it_d.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("PTYPE");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("delete".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ250_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//삭제불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("SABUN", pData.get("SABUN"));
							errMap.put("RTMSG", "삭제불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.deleteData("psogmlib.deleteOBMZ250", pData);
						}
					}
				}
			}
		}
		
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB1", (String)pArg.get("LIB1"));
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("PTYPE");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("insert".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ250_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(1)){
							//insert 불가(대상이 있음)
							HashMap errMap = new HashMap();
							errMap.put("PTYPE", pData.get("PTYPE"));
							errMap.put("RTMSG", "추가불가(이미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.insertData("psogmlib.insertOBMZ250", pData);
						}
					}
				} else if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ250_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							//update 불가(대상이 없음)
							HashMap errMap = new HashMap();
							errMap.put("PTYPE", pData.get("PTYPE"));
							errMap.put("RTMSG", "수정불가(미 등록된 자료입니다.)");
							errList.add(errMap);
						}else{
							dao.updateData("psogmlib.updateOBMZ250", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ250_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-라인코드 맵핑 마스터
	 * @see
	 * 	- 2019-10-30	:	제환복
	***********************************************************************/
	public void selectOBMZ260(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		List list = dao.getListData("psogmlib.selectOBMZ260", pData);
		ModelMap map = new ModelMap();
		map.addAttribute("ds_OBMZ260", list);
		new MiPlatformView().render(map, request, response);
	}
	public void saveOBMZ260(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		List pList = DataConverter.getMiPlatformMultiData(pReq, "ds_OBMZ260");
		Map pArg = DataConverter.getMiPlatformData(pReq);
		
		List errList = new ArrayList();//추가
		Iterator it_d = pList.iterator();
		Iterator it_iu = pList.iterator();
		String rowType="";
		String emptyPN="";
		//////////////////////////////////////////////////////////////
		// OLD값 처리
		DatasetList in_dl = new DatasetList();
		in_dl = pReq.getDatasetList();
		Dataset ds = in_dl.getDataset("ds_OBMZ260");
		//////////////////////////////////////////////////////////////		
		
		dao.startTransaction(); //tr 시작		
				
		while (it_iu.hasNext()) {
			Map pData = (Map) it_iu.next();
			pData.put("LIB2", (String)pArg.get("LIB2"));
			pData.put("USRID", (String)pArg.get("USER_ID"));
			emptyPN = (String) pData.get("LINCD");
			rowType = (String) pData.get("ROW_TYPE");
			if (emptyPN != "") {
				if ("update".equals(rowType)) {
					Map CheckCnt = (Map)dao.getReadData("psogmlib.selectOBMZ260_Check",pData);
					if(CheckCnt!=null && CheckCnt.get("CNT")!=null && !CheckCnt.get("CNT").equals("")){
						if(CheckCnt.get("CNT").equals(0)){
							dao.insertData("psogmlib.insertOBMZ260", pData);
						}else{
							dao.updateData("psogmlib.updateOBMZ260", pData);
						}
					}
				}				
			}       
		}      
		dao.endTransaction(); //commit
		ModelMap map = new ModelMap();//추가
		map.addAttribute("ds_OBMZ260_CHECK", errList);//추가
		new MiPlatformView().render(map, request, response);
	}
	
	/********************************************************************** 
	 * @param 
	 * 	- HttpServletRequest request			:   데이터셋, 파라미터
	 * @return 
	 * 	- HttpServletResponse response		:	데이터셋
	 * @exception 
	 * 	-  [설비보전]-전라인가동현황-라인코드 맵핑 마스터
	 * @see
	 * 	- 2019-10-31	:	제환복
	***********************************************************************/
	public void selectOBMZ230Q_IF(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8"); 
		pReq.receiveData();
		Map pData = DataConverter.getMiPlatformData(pReq);
		CommonDAO daoOther = CommonDAO.getInstance(10);	
		String pCOMPS = (String) pData.get("COMPS");
		
		List list = daoOther.getListData("psogmlib.selectOBMZ230Q_IF", pData);
		//System.out.println(list);

		dao.startTransaction(); //tr 시작
		Iterator chk = list.iterator();
		String chkDT ="";
		while (chk.hasNext()) {
			Map chkData = (Map) chk.next();
			pData.put("PLINCD", chkData.get("LINE_CODE").toString().trim());	//보전진척 라인코드
			pData.put("CURRATE", chkData.get("CUR_ING_RATE").toString().trim());	//생산진척 설총률
			pData.put("MODTM", chkData.get("CUR_ING_DATETIME").toString().trim());	//생산진척 갱신시간
			dao.updateData("psogmlib.updateOBMZ260_IF", pData);
		}		
		dao.endTransaction(); //commit
		new MiPlatformView().render(null, request, response);
	}
}
