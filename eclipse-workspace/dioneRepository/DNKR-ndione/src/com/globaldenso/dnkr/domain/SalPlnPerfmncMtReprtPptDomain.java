package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;

/**
 * 
 * 
 * @author K-DATALAB
 * @version 1.0
 */
public class SalPlnPerfmncMtReprtPptDomain extends CommonDb2Domain implements Serializable {
	
	private static final long serialVersionUID = 705849963838902400L;
	
	
	private String maker;
	private Double pcosty;
	private Double pcostm;
	private Double pcosts; 
	private String dumcb;
	private String sdumcb;
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
		jsonObj.put("maker", this.maker);
		jsonObj.put("pcosty", this.pcosty);
		jsonObj.put("pcostm", this.pcostm);
		jsonObj.put("pcosts", this.pcosts);
		jsonObj.put("dumcb", this.dumcb);
		jsonObj.put("sdumcb", this.sdumcb);
		
		String rtnStr = jsonObj.toJSONString();
		 return rtnStr;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Double getPcosty() {
		return pcosty;
	}

	public void setPcosty(Double pcosty) {
		this.pcosty = pcosty;
	}

	public Double getPcostm() {
		return pcostm;
	}

	public void setPcostm(Double pcostm) {
		this.pcostm = pcostm;
	}

	public Double getPcosts() {
		return pcosts;
	}

	public void setPcosts(Double pcosts) {
		this.pcosts = pcosts;
	}

	public String getDumcb() {
		return dumcb;
	}

	public void setDumcb(String dumcb) {
		this.dumcb = dumcb;
	}

	public String getSdumcb() {
		return sdumcb;
	}

	public void setSdumcb(String sdumcb) {
		this.sdumcb = sdumcb;
	}
		
}
