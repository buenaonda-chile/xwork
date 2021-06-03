package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;

/**
 *  [KR] 납입구분관리 도메인 클레스 <br>
 * 
 * @author K-DATALAB
 * @version 1.0
 */
public class PaymentTypeBaseDomain extends CommonDb2Domain implements Serializable {
	
	/**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
	private static final long serialVersionUID = 973185958667352960L;
	
	private String comps;
	private String pyvnd;
	private String regu;
	private String regd;
	private String modu;
	private String modd;
	private String oldPyvnd;
	
	private String lib1;
	private String lib2;


	public String getComps() {
		return comps;
	}




	public void setComps(String comps) {
		this.comps = comps;
	}




	public String getPyvnd() {
		return pyvnd;
	}




	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}


	public String getOldPyvnd() {
		return oldPyvnd;
	}



	public void setOldPyvnd(String oldPyvnd) {
		this.oldPyvnd = oldPyvnd;
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
		jsonObj.put("pyvnd", this.pyvnd);
		jsonObj.put("oldPyvnd", this.oldPyvnd);
		jsonObj.put("regu", this.regu);
		jsonObj.put("regd", this.regd);
		jsonObj.put("modu", this.modu);
		jsonObj.put("modd", this.modd);
		
		String rtnStr = jsonObj.toJSONString();
		
		return rtnStr;
	}
		
}
