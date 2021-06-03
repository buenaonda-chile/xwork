package com.denso.model;

import java.io.Serializable;
import java.util.List;

public class CodeCategory implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7518357971306674282L;

	private String groupCode;
	private List<CodeDetail> codeDetailList;
	
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}
	
}
