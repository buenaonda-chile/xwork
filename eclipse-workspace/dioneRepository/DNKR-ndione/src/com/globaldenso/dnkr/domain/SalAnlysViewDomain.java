package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * 
 * 
 * @author K-DATALAB
 * @version 1.0
 */
public class SalAnlysViewDomain implements Serializable {
	
	private static final long serialVersionUID = 127184309427386016L;
	
	private String lib1;

	private String lib2;

	private String lib3;

	public String getLib1() {
		return lib1;
	}

	public void setLib1(String lib1) {
		this.lib1 = lib1;
	}

	public String getLib2() {
		return lib2;
	}

	public void setLib2(String lib2) {
		this.lib2 = lib2;
	}

	public String getLib3() {
		return lib3;
	}

	public void setLib3(String lib3) {
		this.lib3 = lib3;
	}

	public String toString() {
		JSONObject jsonObj = new JSONObject();
		String rtnStr = jsonObj.toJSONString();
		 return rtnStr;
	}
		
}
