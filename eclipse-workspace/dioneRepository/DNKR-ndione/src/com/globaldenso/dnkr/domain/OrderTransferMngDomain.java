package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * 
 * 
 * @author K-DATALAB
 * @version 1.0
 */
public class OrderTransferMngDomain implements Serializable {
	
	private static final long serialVersionUID = 313133003492332992L;
	
    private String comps;
    private String pyvnd;
    private String plndt;
    private String stcd1;
    private String stcd2;
    private String stcd3;
    private String magdt;
    private String magtm;
    private String chgdt;
    private String chgtm;
	


	public String getChgdt() {
		return chgdt;
	}

	public void setChgdt(String chgdt) {
		this.chgdt = chgdt;
	}

	public String getChgtm() {
		return chgtm;
	}

	public void setChgtm(String chgtm) {
		this.chgtm = chgtm;
	}
	
	public String getPlndt() {
		return plndt;
	}
	
	public void setPlndt(String plndt) {
		this.plndt = plndt;
	}

	public String getStcd1() {
		return stcd1;
	}

	public void setStcd1(String stcd1) {
		this.stcd1 = stcd1;
	}

	public String getStcd2() {
		return stcd2;
	}

	public void setStcd2(String stcd2) {
		this.stcd2 = stcd2;
	}

	public String getStcd3() {
		return stcd3;
	}

	public void setStcd3(String stcd3) {
		this.stcd3 = stcd3;
	}

	public String getMagdt() {
		return magdt;
	}

	public void setMagdt(String magdt) {
		this.magdt = magdt;
	}

	public String getMagtm() {
		return magtm;
	}

	public void setMagtm(String magtm) {
		this.magtm = magtm;
	}

	private String lib1;

	private String lib2;

	private String lib3;

	
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

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("plndt", this.plndt);
        jsonObj.put("stcd1", this.stcd1);
        jsonObj.put("stcd2", this.stcd2);
        jsonObj.put("stcd3", this.stcd3);
        jsonObj.put("magdt", this.magdt);
        jsonObj.put("magtm", this.magtm);  
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }
		
}
