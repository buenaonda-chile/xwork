package com.denso.model;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CodeMaster implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(getClass());

	private String key;
	private List<CodeDetail> codeDetailList;
	private Hashtable<String, CodeDetail> codeToNameHashTable = new Hashtable<String, CodeDetail>();
	private Hashtable<String, CodeDetail> nameToCodeHashtable = new Hashtable<String, CodeDetail>();

	public CodeMaster(String key, List<CodeDetail> codeDetailList) {
		for (CodeDetail codeDetail : codeDetailList) {
			codeToNameHashTable.put(codeDetail.getCode(), codeDetail);
			nameToCodeHashtable.put(codeDetail.getCodeName() == null ? "" : codeDetail.getCodeName(), codeDetail);
		}

		this.key = key;
		this.codeDetailList = codeDetailList;
		logger.info(this.toString());
	}

	public String getKey() {
		return key;
	}
	
	public List<CodeDetail> getList() {
		return codeDetailList;
	}
}
