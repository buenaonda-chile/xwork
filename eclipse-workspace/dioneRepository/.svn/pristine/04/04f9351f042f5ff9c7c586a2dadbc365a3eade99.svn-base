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
public class SalPlnPerfmncMtReprtExlDomain extends CommonDb2Domain implements Serializable {
	
	private static final long serialVersionUID = 95862799759233280L;
	
	private String itemCd;
	private Double pQtyM;
	private Double pQtyS;
	private Double rate;
	private String dumcb;
	
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
		
		jsonObj.put("itemCd", this.itemCd);
		jsonObj.put("pQtyM", this.pQtyM);
		jsonObj.put("pQtyS", this.pQtyS);
		jsonObj.put("rate", this.rate);
		jsonObj.put("dumcb", this.dumcb);
		
		String rtnStr = jsonObj.toJSONString();
		 return rtnStr;
	}

	public String getItemCd() {
		return itemCd;
	}

	public void setItemCd(String itemCd) {
		this.itemCd = itemCd;
	}

	
	public Double getpQtyS() {
		return pQtyS;
	}

	public void setpQtyS(Double pQtyS) {
		this.pQtyS = pQtyS;
	}

	public String getDumcb() {
		return dumcb;
	}

	public void setDumcb(String dumcb) {
		this.dumcb = dumcb;
	}

	public Double getpQtyM() {
		return pQtyM;
	}

	public void setpQtyM(Double pQtyM) {
		this.pQtyM = pQtyM;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
		
}
