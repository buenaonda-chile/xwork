package com.denso.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tobesoft.platform.PlatformRequest;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.VariableList;

/**
 * @author
 *
 */
public class DataConverter {

	public static Map<String, String> getData(HttpServletRequest request) {
		Map<String, String> data = new HashMap<String, String>();
		String s;
		for (Enumeration<?> enumeration = request.getParameterNames(); enumeration
				.hasMoreElements(); data.put(s, request.getParameter(s)))
			s = (String) enumeration.nextElement();

		return data;
	}

	public static Map<String, String> getMiPlatformData(PlatformRequest pReq, String dsName)throws Exception {
		DatasetList inDl = pReq.getDatasetList();
		Dataset inDs = inDl.getDataset(dsName);
		if (inDs == null)
			return null;
		Map<String, String> result = new HashMap<String, String>();
		int colCnt = inDs.getColumnCount();
		int deleteRowCnt = inDs.getDeleteRowCount();
		if (deleteRowCnt < 1) {
			result.put("ROW_TYPE", inDs.getRowStatus(0));
			for (int j = 0; j < colCnt; j++) {
				result.put(inDs.getColumnID(j), nullTrans(inDs
						.getColumnAsString(0, inDs.getColumnID(j))));
			}
		} else {
			result.put("ROW_TYPE", "delete");
			for (int j = 0; j < colCnt; j++) {
				result.put(inDs.getColumnID(j),
						nullTrans(inDs.getDeleteColumn(0, inDs.getColumnID(j))
								.getString()));
			}
		}
		return result;
	}

	public static List<HashMap<String, String>> getMiPlatformMultiData(HttpServletRequest request, String dsName) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request);
		pReq.receiveData();
		return getMiPlatformMultiData(pReq, dsName);
	}

	public static List<HashMap<String, String>> getMiPlatformMultiData(PlatformRequest pReq, String dsName) throws Exception {
		DatasetList inDl = pReq.getDatasetList();
		Dataset inDs = inDl.getDataset(dsName);
		if (inDs == null)
			return null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		int rowCnt = inDs.getRowCount();
		int colCnt = inDs.getColumnCount();
		for (int i = 0; i < rowCnt; i++) {
			HashMap<String, String> inputData = new HashMap<String, String>();
			inputData.put("ROW_TYPE", inDs.getRowStatus(i));
			for (int j = 0; j < colCnt; j++) {
				inputData.put(inDs.getColumnID(j), nullTrans(inDs
						.getColumnAsString(i, inDs.getColumnID(j))));
			}
			list.add(inputData);
		}

		int deleteRowCnt = inDs.getDeleteRowCount();
		for (int i = 0; i < deleteRowCnt; i++) {
			HashMap<String, String> inputData = new HashMap<String, String>();
			inputData.put("ROW_TYPE", "delete");
			for (int j = 0; j < colCnt; j++) {
				inputData.put(inDs.getColumnID(j), nullTrans(inDs
						.getDeleteColumn(i, inDs.getColumnID(j)).getString()));
			}
			list.add(inputData);
		}
		return list;
	}

	public static HashMap<String, String> getMiPlatformData(HttpServletRequest request) throws Exception {
		PlatformRequest pReq = new PlatformRequest(request, "UTF-8");
		pReq.receiveData();
		return getMiPlatformData(pReq);
	}

	public static HashMap<String, String> getMiPlatformData(PlatformRequest pReq)throws Exception {
		VariableList inVl = pReq.getVariableList();
		HashMap<String, String> result = new HashMap<String, String>();
		int rowCnt = inVl.size();
		for (int i = 0; i < rowCnt; i++) {
			result.put(inVl.getVariable(i).getID(),
					(String) inVl.getValueAsString(inVl.getVariable(i).getID()));
		}

		return result;
	}

	// max5250 head
	public static Map<String, String> setMiPlatformDataSet(PlatformRequest pReq, String dsName) throws Exception {
		DatasetList inDl = pReq.getDatasetList();
		Dataset inDs = inDl.getDataset(dsName);
		if (inDs == null)
			return null;
		Map<String, String> result = new HashMap<String, String>();
		int colCnt = inDs.getColumnCount();
		for (int i = 0; i < colCnt; i++) {
			result.put(inDs.getColumnID(i),
					nullTrans(inDs.getColumnAsString(0, inDs.getColumnID(i))));
		}
		return result;
	}

	static String nullTrans(String srcStr) {
		if (srcStr == null || srcStr.trim().equals("")) {
			return "";
		} else {
			return srcStr;
		}

	}
}
