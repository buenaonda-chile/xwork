package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 *  [KR] 매출분석코멘트 도메인 클레스 <br>
 * 
 * @author K-DATALAB
 * @version 1.0
 */
public class SalAnlysComentDomain implements Serializable {
	
	/**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
	private static final long serialVersionUID = 973185958667352960L;
	
	private String comps;
	private String repym;
	private String reprtse;
	private String cmnitm;
	private String cmncn;
	private String regu;
	private String regd;
	private String modu;
	private String modd;

	private String oldComps;
	private String oldRepym;
	private String oldReprtse;
	private String oldCmnitm;
	private String oldCmncn;
	
	private String lib1;
	private String lib2;
	
	public String getComps() {
		return comps;
	}



	public void setComps(String comps) {
		this.comps = comps;
	}



	public String getRepym() {
		return repym;
	}



	public void setRepym(String repym) {
		this.repym = repym;
	}



	public String getReprtse() {
		return reprtse;
	}



	public void setReprtse(String reprtse) {
		this.reprtse = reprtse;
	}



	public String getCmnitm() {
		return cmnitm;
	}



	public void setCmnitm(String cmnitm) {
		this.cmnitm = cmnitm;
	}



	public String getCmncn() {
		return cmncn;
	}



	public void setCmncn(String cmncn) {
		this.cmncn = cmncn;
	}



	public String getRegu() {
		return regu;
	}



	public void setRegu(String regu) {
		this.regu = regu;
	}



	public String getRegd() {
		return regd;
	}



	public void setRegd(String regd) {
		this.regd = regd;
	}



	public String getModu() {
		return modu;
	}



	public void setModu(String modu) {
		this.modu = modu;
	}



	public String getModd() {
		return modd;
	}



	public void setModd(String modd) {
		this.modd = modd;
	}



	public String getOldComps() {
		return oldComps;
	}



	public void setOldComps(String oldComps) {
		this.oldComps = oldComps;
	}



	public String getOldRepym() {
		return oldRepym;
	}



	public void setOldRepym(String oldRepym) {
		this.oldRepym = oldRepym;
	}



	public String getOldReprtse() {
		return oldReprtse;
	}



	public void setOldReprtse(String oldReprtse) {
		this.oldReprtse = oldReprtse;
	}



	public String getOldCmnitm() {
		return oldCmnitm;
	}



	public void setOldCmnitm(String oldCmnitm) {
		this.oldCmnitm = oldCmnitm;
	}



	public String getOldCmncn() {
		return oldCmncn;
	}



	public void setOldCmncn(String oldCmncn) {
		this.oldCmncn = oldCmncn;
	}



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



	@Override
	public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("comps", this.comps);
		jsonObj.put("repym", this.repym);
		jsonObj.put("reprtse", this.reprtse);
		jsonObj.put("cmnitm", this.cmnitm);
		jsonObj.put("cmncn", this.cmncn);
		jsonObj.put("regu", this.regu);
		jsonObj.put("regd", this.regd);
		jsonObj.put("modu", this.modu);
		jsonObj.put("modd", this.modd);
		
		jsonObj.put("oldComps", this.oldComps);
		jsonObj.put("oldRepym", this.oldRepym);
		jsonObj.put("oldReprtse", this.oldReprtse);
		jsonObj.put("oldCmnitm", this.oldCmnitm);
		jsonObj.put("oldCmncn", this.oldCmncn);
		
		String rtnStr = jsonObj.toJSONString();
		
		return rtnStr;
	}
		
}
