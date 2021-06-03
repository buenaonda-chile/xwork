package com.denso.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.denso.mapper.BarcodeMapper;

@Repository
public class BarcodeDao {

	@Autowired
	private BarcodeMapper barcodeMapper;

	public List<HashMap<String, String>> selectFPQZ100Qlist_type1(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQZ100Qlist_type1(reqMap);
	}
		public List<HashMap<String, String>> selectFPQZ100Qlist_type4(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQZ100Qlist_type4(reqMap);
	}
	public List<HashMap<String, String>> selectFPQZ100Qlist_detail(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQZ100Qlist_detail(reqMap);
	}
	public List<HashMap<String, String>> selectFPQC100Qlist_report(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQC100Qlist_report(reqMap);
	}
	public List<HashMap<String, String>> selectFPQE110Qlist_report(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQE110Qlist_report(reqMap);
	}
	
	public List<HashMap<String, String>> selectFPQE140Qlist_type4(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQE140Qlist_type4(reqMap);
	}
	public HashMap<String, String> selectFPQE140Qlist_seq(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQE140QSeq_737PF_CHK(reqMap);
	}
	public void setFPQE140Q_seqInsert(HashMap<String, String> reqMap) {
		barcodeMapper.insertFPQE140QSeq_737PF(reqMap);
	}
	public void setFPQE140Q_seqUpdate(HashMap<String, String> reqMap) {
		barcodeMapper.updateFPQE140QSeq_737PF(reqMap);
	}
	
	
	public List<HashMap<String, String>> selectFPQE150Qlist_type1(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQE150Qlist_type1(reqMap);
	}
	public List<HashMap<String, String>> selectFPQE150Qlist_type4(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQE150Qlist_type4(reqMap);
	}
	public HashMap<String, String> selectFPQE150Qlist_seq(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQE150QSeq_767PF_CHK(reqMap);
	}	
	public void setFPQE150Q_seqInsert(HashMap<String, String> reqMap) {
		barcodeMapper.insertFPQE150QSeq_767PF(reqMap);
	}
	public void setFPQE150Q_seqUpdate(HashMap<String, String> reqMap) {
		barcodeMapper.updateFPQE150QSeq_767PF(reqMap);
	}	
	
	public List<HashMap<String, String>> selectFPQC140Qlist_type4(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQC140Qlist_type4(reqMap);
	}
	public HashMap<String, String> selectFPQC140Qlist_seq(HashMap<String, String> reqMap) {
		return barcodeMapper.selectFPQC140QSeq_737PF_CHK(reqMap);
	}
	public void setFPQC140Q_seqInsert(HashMap<String, String> reqMap) {
		barcodeMapper.insertFPQC140QSeq_737PF(reqMap);
	}
	public void setFPQC140Q_seqUpdate(HashMap<String, String> reqMap) {
		barcodeMapper.updateFPQC140QSeq_737PF(reqMap);
	}	
}
