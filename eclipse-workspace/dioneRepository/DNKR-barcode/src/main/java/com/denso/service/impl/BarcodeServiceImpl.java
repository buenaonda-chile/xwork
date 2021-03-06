package com.denso.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.denso.dao.BarcodeDao;
import com.denso.service.intf.BarcodeService;

@Service
public class BarcodeServiceImpl implements BarcodeService{

	@Autowired
	private BarcodeDao barcodeDao;

	@Override
	public List<HashMap<String, String>> getFPQZ100Qlist_type1(HashMap<String, String> reqMap) {
		return barcodeDao.selectFPQZ100Qlist_type1(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFPQZ100Qlist_type4(HashMap<String, String> reqMap) {
		return barcodeDao.selectFPQZ100Qlist_type4(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFPQZ100Qlist_detail(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) {
/*
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		HashMap<String, String> pData =null;
		while (it.hasNext()) {
			pData = (HashMap<String, String>) it.next();
			pData.put("LIB1", (String)reqMap.get("LIB1"));
			pData.put("LIB2", (String)reqMap.get("LIB2"));
			pData.put("TABLE", (String)reqMap.get("TABLE"));
			pData.put("COMPS", (String)reqMap.get("COMPS"));
			pData.put("PNYMD", (String)reqMap.get("PNYMD"));
		}
		return barcodeDao.selectFPQZ100Qlist_detail(pData);
*/
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		HashMap<String, String> pData =null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		while (it.hasNext()) {
			pData = (HashMap<String, String>) it.next();
			pData.put("LIB1", (String)reqMap.get("LIB1"));
			pData.put("LIB2", (String)reqMap.get("LIB2"));
			pData.put("TABLE", (String)reqMap.get("TABLE"));
			pData.put("COMPS", (String)reqMap.get("COMPS"));
			pData.put("PNYMD", (String)reqMap.get("PNYMD"));
			List<HashMap<String, String>> listT = new ArrayList<HashMap<String, String>>();
			listT =  barcodeDao.selectFPQZ100Qlist_detail(pData);
			list.addAll(listT);
		}
		return list;
	}
	@Override
	public List<HashMap<String, String>> getFPQC100Qlist_report(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) {
/*
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		HashMap<String, String> pData =null;
		while (it.hasNext()) {
			pData = (HashMap<String, String>) it.next();
			pData.put("LIB1", (String)reqMap.get("LIB1"));
			pData.put("LIB2", (String)reqMap.get("LIB2"));
			pData.put("TABLE", (String)reqMap.get("TABLE"));
			pData.put("COMPS", (String)reqMap.get("COMPS"));
			pData.put("PNYMD", (String)reqMap.get("PNYMD"));
			pData.put("PR_GU", (String)reqMap.get("PR_GU")); //????????????????????? ?????? or ????????????????????? ?????? ??????
		}
		return barcodeDao.selectFPQC100Qlist_report(pData);
*/
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		HashMap<String, String> pData =null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		while (it.hasNext()) {
			pData = (HashMap<String, String>) it.next();
			pData.put("LIB1", (String)reqMap.get("LIB1"));
			pData.put("LIB2", (String)reqMap.get("LIB2"));
			pData.put("TABLE", (String)reqMap.get("TABLE"));
			pData.put("COMPS", (String)reqMap.get("COMPS"));
			pData.put("PNYMD", (String)reqMap.get("PNYMD"));
			pData.put("PR_GU", (String)reqMap.get("PR_GU")); //????????????????????? ?????? or ????????????????????? ?????? ??????
			List<HashMap<String, String>> listT = new ArrayList<HashMap<String, String>>();
			listT = barcodeDao.selectFPQC100Qlist_report(pData);	
			list.addAll(listT);		
		}
		return list;		
	}
	@Override
	public List<HashMap<String, String>> getFPQE110Qlist_report(HashMap<String, String> reqMap, List<HashMap<String, String>> reqParam) {
/*
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		HashMap<String, String> pData =null;
		while (it.hasNext()) {
			pData = (HashMap<String, String>) it.next();
			pData.put("LIB1", (String)reqMap.get("LIB1"));
			pData.put("LIB2", (String)reqMap.get("LIB2"));
			pData.put("TABLE", (String)reqMap.get("TABLE"));
			pData.put("COMPS", (String)reqMap.get("COMPS"));
			pData.put("PNYMD", (String)reqMap.get("PNYMD"));
			pData.put("PR_GU", (String)reqMap.get("PR_GU")); //????????????????????? ?????? or ????????????????????? ?????? ??????
		}
		return barcodeDao.selectFPQE110Qlist_report(pData);
*/
		Iterator<HashMap<String, String>> it = reqParam.iterator();
		HashMap<String, String> pData =null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		while (it.hasNext()) {
			pData = (HashMap<String, String>) it.next();
			pData.put("LIB1", (String)reqMap.get("LIB1"));
			pData.put("LIB2", (String)reqMap.get("LIB2"));
			pData.put("TABLE", (String)reqMap.get("TABLE"));
			pData.put("COMPS", (String)reqMap.get("COMPS"));
			pData.put("PNYMD", (String)reqMap.get("PNYMD"));
			pData.put("PR_GU", (String)reqMap.get("PR_GU")); //????????????????????? ?????? or ????????????????????? ?????? ??????
			List<HashMap<String, String>> listT = new ArrayList<HashMap<String, String>>();
			listT = barcodeDao.selectFPQE110Qlist_report(pData);	
			list.addAll(listT);	
		}
		return list;
	}	
	
	@Override
	public List<HashMap<String, String>> getFPQE140Qlist_type4(HashMap<String, String> reqMap) {
		return barcodeDao.selectFPQE140Qlist_type4(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFPQE140Qlist_seq(HashMap<String, String> reqMap) {
		List<HashMap<String, String>> labelSeqNumber = new ArrayList<HashMap<String, String>>();
		
		reqMap.put("PRTNO_CVT", prtNoConvert(reqMap.get("PRTNO")));
		
		HashMap<String, String> CheckCnt = barcodeDao.selectFPQE140Qlist_seq(reqMap);
		
		String cnt="0";
		if(CheckCnt != null){
			cnt =String.valueOf(CheckCnt.get("CNT"));
			
			if(cnt.equals(0)){
				
				reqMap.put("LSEQN", (String)"1");
				barcodeDao.setFPQE140Q_seqInsert(reqMap);
				
			//////////////////////////////////////	
			// 20150810 999??? ????????? ?????? ?????? Start	
			// ????????? 999 ????????? 1????????? ????????????
		    // 20150810 999??? ????????? ?????? ?????? End
		    //////////////////////////////////////
			} else if(cnt.equals("999")){
			
				//double labelNo = Double.parseDouble(""+CheckCnt.get("CNT"));
				reqMap.put("LSEQN", (String)"1");
				barcodeDao.setFPQE140Q_seqUpdate(reqMap);
				
			} else{
			
				//double labelNo = Double.parseDouble(""+CheckCnt.get("CNT"));
				int labelNo = Integer.parseInt(""+cnt);
				labelNo = labelNo+1;
			
				reqMap.put("LSEQN", Integer.toString(labelNo));
				barcodeDao.setFPQE140Q_seqUpdate(reqMap);
			}
		}else{
			
			reqMap.put("LSEQN", (String)"1");
			barcodeDao.setFPQE140Q_seqInsert(reqMap);

		}
		labelSeqNumber.add(reqMap);
		List<HashMap<String, String>> list = labelSeqNumber;
		return list;
	}
	
	
	@Override
	public List<HashMap<String, String>> getFPQE150Qlist_type1(HashMap<String, String> reqMap) {
		return barcodeDao.selectFPQE150Qlist_type1(reqMap);
	}
	@Override
	public List<HashMap<String, String>> getFPQE150Qlist_type4(HashMap<String, String> reqMap) {
		return barcodeDao.selectFPQE150Qlist_type4(reqMap);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public List<HashMap<String, String>> getFPQE150Qlist_seq(HashMap<String, String> reqMap) {
		List<HashMap<String, String>> labelSeqNumber = new ArrayList<HashMap<String, String>>();
		
		reqMap.put("PRTNO_CVT", reqMap.get("PRTNO"));
		
		HashMap<String, String> CheckCnt = null;
		    // 1??? ?????? : ????????? ?????? ????????? ??????
			CheckCnt = barcodeDao.selectFPQE150Qlist_seq(reqMap);
		
		if(CheckCnt == null){
			// 2??? ?????? : ?????? ????????? ???????????? ????????? ??????
			reqMap.put("PRTNO_CVT", prtNoConvert(reqMap.get("PRTNO")));
			CheckCnt = barcodeDao.selectFPQE150Qlist_seq(reqMap);
			reqMap.put("PRTNO_CVT", reqMap.get("PRTNO"));
		}
		
		String cnt="0";
		if(CheckCnt != null){
			cnt =String.valueOf(CheckCnt.get("CNT"));
			
			if(cnt.equals(0)){
			
				reqMap.put("LSEQN", (String)"1");
				barcodeDao.setFPQE150Q_seqInsert(reqMap);
			}//////////////////////////////////////	
			// 20150810 999??? ????????? ?????? ?????? Start	
			// ????????? 999 ????????? 1????????? ????????????
		    // 20150810 999??? ????????? ?????? ?????? End
		    //////////////////////////////////////
			else if(cnt.equals("999")){
			
				//double labelNo = Double.parseDouble(""+CheckCnt.get("CNT"));
				reqMap.put("LSEQN", (String)"1");
				barcodeDao.setFPQE140Q_seqUpdate(reqMap);
				
			} 
			else{
			
				int labelNo = Integer.parseInt(""+cnt);
				labelNo = labelNo+1;
			
				reqMap.put("LSEQN", Integer.toString(labelNo));
				barcodeDao.setFPQE150Q_seqUpdate(reqMap);
			}
		}else{
			
			reqMap.put("LSEQN", (String)"1");
			barcodeDao.setFPQE150Q_seqInsert(reqMap);
		}
		labelSeqNumber.add(reqMap);
		List<HashMap<String, String>> list = labelSeqNumber;
		return list;
	}
	@Override
	public List<HashMap<String, String>> getFPQC140Qlist_type4(HashMap<String, String> reqMap) {
		return barcodeDao.selectFPQC140Qlist_type4(reqMap);
	}
	
	private String prtNoConvert(String prtNo){
		String rlt = "";
		if(prtNo != null){
			rlt = prtNo.trim();
			rlt = prtNo.replaceAll("[a-zA-Z-]", "");
			if(rlt.length() > 10){
				rlt = rlt.substring(0,10);	
			}
		}
		return rlt; 
	}
	
	@Override
	public List<HashMap<String, String>> getFPQC140Qlist_seq(HashMap<String, String> reqMap) {
		List<HashMap<String, String>> labelSeqNumber = new ArrayList<HashMap<String, String>>();
		
		
		HashMap<String, String> CheckCnt = barcodeDao.selectFPQC140Qlist_seq(reqMap);
		
		String cnt="0";
		if(CheckCnt != null){
			cnt =String.valueOf(CheckCnt.get("CNT"));
			
			if(cnt.equals(0)){
				
				reqMap.put("LSEQN", (String)"1");
				barcodeDao.setFPQC140Q_seqInsert(reqMap);
			}else{
				
				//double labelNo = Double.parseDouble(""+CheckCnt.get("CNT"));
				int labelNo = Integer.parseInt(""+cnt);
				labelNo = labelNo+1;
			
				reqMap.put("LSEQN", Integer.toString(labelNo));
				barcodeDao.setFPQC140Q_seqUpdate(reqMap);
			}
		}else{
			
			reqMap.put("LSEQN", (String)"1");
			barcodeDao.setFPQC140Q_seqInsert(reqMap);

		}
		labelSeqNumber.add(reqMap);
		List<HashMap<String, String>> list = labelSeqNumber;
		return list;
	}
}
