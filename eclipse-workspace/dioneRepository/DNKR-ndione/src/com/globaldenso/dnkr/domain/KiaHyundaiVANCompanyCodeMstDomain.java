package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 기아현대 VAN 업체코드마스타 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class KiaHyundaiVANCompanyCodeMstDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143742L;
    
    private String comps;
    private String pyvnd;
    
    private String vndcd;
    private String faccd;
    private String facnm;
    private String pscom;
    private String psvnd1;
    
    private String oldVndcd;
    private String oldFaccd;
    private String oldFacnm;
    private String oldPscom;
	private String oldPsvnd1;
    
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






	public String getVndcd() {
		return vndcd;
	}






	public void setVndcd(String vndcd) {
		this.vndcd = vndcd;
	}






	public String getFaccd() {
		return faccd;
	}






	public void setFaccd(String faccd) {
		this.faccd = faccd;
	}






	public String getFacnm() {
		return facnm;
	}






	public void setFacnm(String facnm) {
		this.facnm = facnm;
	}






	public String getPscom() {
		return pscom;
	}






	public void setPscom(String pscom) {
		this.pscom = pscom;
	}






	public String getPsvnd1() {
		return psvnd1;
	}






	public void setPsvnd1(String psvnd1) {
		this.psvnd1 = psvnd1;
	}






	public String getOldVndcd() {
		return oldVndcd;
	}






	public void setOldVndcd(String oldVndcd) {
		this.oldVndcd = oldVndcd;
	}






	public String getOldFaccd() {
		return oldFaccd;
	}






	public void setOldFaccd(String oldFaccd) {
		this.oldFaccd = oldFaccd;
	}






	public String getOldFacnm() {
		return oldFacnm;
	}






	public void setOldFacnm(String oldFacnm) {
		this.oldFacnm = oldFacnm;
	}






	public String getOldPscom() {
		return oldPscom;
	}






	public void setOldPscom(String oldPscom) {
		this.oldPscom = oldPscom;
	}






	public String getOldPsvnd1() {
		return oldPsvnd1;
	}






	public void setOldPsvnd1(String oldPsvnd1) {
		this.oldPsvnd1 = oldPsvnd1;
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
        jsonObj.put("vndcd", this.vndcd);
        jsonObj.put("faccd", this.faccd);
        jsonObj.put("facnm", this.facnm);
        jsonObj.put("pscom", this.pscom);
        jsonObj.put("psvnd1", this.psvnd1);
        jsonObj.put("oldVndcd", this.oldVndcd);
        jsonObj.put("oldFaccd", this.oldFaccd);
        jsonObj.put("oldFacnm", this.oldFacnm);
        jsonObj.put("oldPscom", this.oldPscom);
        jsonObj.put("oldPsvnd1", this.oldPsvnd1);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
