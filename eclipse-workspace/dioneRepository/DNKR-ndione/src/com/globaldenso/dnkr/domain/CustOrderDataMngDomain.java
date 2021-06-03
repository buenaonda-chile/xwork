package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;

/**
 * [KR] 수주이관DATA관리 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class CustOrderDataMngDomain extends CommonDb2Domain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143743L;
    
    /**
     * [KR] COMPANY CODE <br>
     */
    private String comps;
    /**
     * [KR] TYPE CODE <br>
     */
    private String typcd;
    
    /**
     * [KR] TYPE NAME <br>
     */
    private String typcnm;
    
    /**
     * [KR] CUSTOMER CODE <br>
     */
    private String pyvnd;
    
    /**
     * [KR] CUSTOMER NAME <br>
     */
    private String cusnm;
    
    /**
     * [KR] ITEM CODE <br>
     */
    private String pspno;

    /**
     * [KR] PLANT DATE <br>
     */
    private String plndt;
    
    /**
     * [KR] PLANT QTY <br>
     */
    private String basqy;
    
    /**
     * [KR] PLANT CODE <br>
     */
    private String plncd;
    
    /**
     * [KR] STANDARD DATE <br>
     */
    private String chgdt;
    
    /**
     * [KR] CHANGE USER <br>
     */
    private String chpid;
    
    
    
    /**
	 * @return the typcd
	 */
	public String getTypcd() {
		return typcd;
	}



	/**
	 * @param typcd the typcd to set
	 */
	public void setTypcd(String typcd) {
		this.typcd = typcd;
	}


	/**
	 * @return the typcnm
	 */
	public String getTypcnm() {
		return typcnm;
	}


	/**
	 * @param typcnm the typcnm to set
	 */
	public void setTypcnm(String typcnm) {
		this.typcnm = typcnm;
	}


	/**
	 * @return the pyvnd
	 */
	public String getPyvnd() {
		return pyvnd;
	}


	/**
	 * @param pyvnd the pyvnd to set
	 */
	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}


	/**
	 * @return the cusnm
	 */
	public String getCusnm() {
		return cusnm;
	}


	/**
	 * @param cusnm the cusnm to set
	 */
	public void setCusnm(String cusnm) {
		this.cusnm = cusnm;
	}


	/**
	 * @return the pspno
	 */
	public String getPspno() {
		return pspno;
	}


	/**
	 * @param pspno the pspno to set
	 */
	public void setPspno(String pspno) {
		this.pspno = pspno;
	}


	/**
	 * @return the plndt
	 */
	public String getPlndt() {
		return plndt;
	}


	/**
	 * @param plndt the plndt to set
	 */
	public void setPlndt(String plndt) {
		this.plndt = plndt;
	}


	/**
	 * @return the basqy
	 */
	public String getBasqy() {
		return basqy;
	}


	/**
	 * @param basqy the basqy to set
	 */
	public void setBasqy(String basqy) {
		this.basqy = basqy;
	}


	/**
	 * @return the plncd
	 */
	public String getPlncd() {
		return plncd;
	}


	/**
	 * @param plncd the plncd to set
	 */
	public void setPlncd(String plncd) {
		this.plncd = plncd;
	}


	/**
	 * @return the chgdt
	 */
	public String getChgdt() {
		return chgdt;
	}


	/**
	 * @param chgdt the chgdt to set
	 */
	public void setChgdt(String chgdt) {
		this.chgdt = chgdt;
	}


	/**
	 * @return the chpid
	 */
	public String getChpid() {
		return chpid;
	}


	/**
	 * @param chpid the chpid to set
	 */
	public void setChpid(String chpid) {
		this.chpid = chpid;
	}


	/**
	 * @return the comps
	 */
	public String getComps() {
		return comps;
	}

	/**
	 * @param comps the comps to set
	 */
	public void setComps(String comps) {
		this.comps = comps;
	}



	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("typcd", this.typcd);
        jsonObj.put("typcnm", this.typcnm);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("plndt", this.plndt);
        jsonObj.put("basqy", this.basqy);
        jsonObj.put("plncd", this.plncd);
        jsonObj.put("chgdt", this.chgdt);
        jsonObj.put("chpid", this.chpid);
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
