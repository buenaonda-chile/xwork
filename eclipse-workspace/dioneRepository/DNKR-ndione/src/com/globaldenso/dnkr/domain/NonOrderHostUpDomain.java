package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 비열형 HOST UP 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class NonOrderHostUpDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143748L;
    
    /**
     * [KR]  업로드 성공 리스트<br>   
     */
    private JSONObject sucList;
    
    /**
     * [KR]  업로드 실패 리스트<br>   
     */
    private JSONObject failList;

	public JSONObject getSucList() {
		return sucList;
	}

	public void setSucList(JSONObject sucList) {
		this.sucList = sucList;
	}

	public JSONObject getFailList() {
		return failList;
	}

	public void setFailList(JSONObject failList) {
		this.failList = failList;
	}


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

    
    private String stplndt;
    private String enplndt;
    
	private String psvnd;
	private String pscom;
	private String vndcd;
	
	private String prtno;
	private String cpdsc;
	private String cusno;
	private String cprtn;
	
	private String prtgb;
	private String lingb;
	
    private String comps;
    private String typcd;
    private String pyvnd;
    private int shpto;
    private String pspno;    
    private String plndt;
    private String basqy;
    private String ponum;
    private String faccd;
    private String yard;
    private String outqy;    
    private String inpid;
    
    private String period;
    
    private String tgubn;
    
    private String chgdt;
    private String inpdt;
    private String inptm;
    private String chpid;
    private String chpdt;
    private String chgtm;
    private String plncd;
    
    public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}


	private int rows;
    
	public String getPlncd() {
		return plncd;
	}

	public void setPlncd(String plncd) {
		this.plncd = plncd;
	}

	public String getChgdt() {
		return chgdt;
	}

	public void setChgdt(String chgdt) {
		this.chgdt = chgdt;
	}

	public String getInpdt() {
		return inpdt;
	}

	public void setInpdt(String inpdt) {
		this.inpdt = inpdt;
	}

	public String getInptm() {
		return inptm;
	}

	public void setInptm(String inptm) {
		this.inptm = inptm;
	}

	public String getChpid() {
		return chpid;
	}

	public void setChpid(String chpid) {
		this.chpid = chpid;
	}

	public String getChpdt() {
		return chpdt;
	}

	public void setChpdt(String chpdt) {
		this.chpdt = chpdt;
	}

	public String getChgtm() {
		return chgtm;
	}

	public void setChgtm(String chgtm) {
		this.chgtm = chgtm;
	}

	public String getStplndt() {
		return stplndt;
	}

	public void setStplndt(String stplndt) {
		this.stplndt = stplndt;
	}

	public String getEnplndt() {
		return enplndt;
	}

	public void setEnplndt(String enplndt) {
		this.enplndt = enplndt;
	}

	public String getPsvnd() {
		return psvnd;
	}

	public void setPsvnd(String psvnd) {
		this.psvnd = psvnd;
	}

	public String getPscom() {
		return pscom;
	}

	public void setPscom(String pscom) {
		this.pscom = pscom;
	}

	public String getVndcd() {
		return vndcd;
	}

	public void setVndcd(String vndcd) {
		this.vndcd = vndcd;
	}

	public String getPrtno() {
		return prtno;
	}

	public void setPrtno(String prtno) {
		this.prtno = prtno;
	}

	public String getCpdsc() {
		return cpdsc;
	}

	public void setCpdsc(String cpdsc) {
		this.cpdsc = cpdsc;
	}

	public String getCusno() {
		return cusno;
	}

	public void setCusno(String cusno) {
		this.cusno = cusno;
	}

	public String getCprtn() {
		return cprtn;
	}

	public void setCprtn(String cprtn) {
		this.cprtn = cprtn;
	}
	
	public String getPrtgb() {
		return prtgb;
	}

	public void setPrtgb(String prtgb) {
		this.prtgb = prtgb;
	}

	public String getLingb() {
		return lingb;
	}

	public void setLingb(String lingb) {
		this.lingb = lingb;
	}

	public String getComps() {
		return comps;
	}

	public void setComps(String comps) {
		this.comps = comps;
	}

	public String getTypcd() {
		return typcd;
	}

	public void setTypcd(String typcd) {
		this.typcd = typcd;
	}

	public String getPyvnd() {
		return pyvnd;
	}

	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}

	public int getShpto() {
		return shpto;
	}

	public void setShpto(int shpto) {
		this.shpto = shpto;
	}

	public String getPspno() {
		return pspno;
	}

	public void setPspno(String pspno) {
		this.pspno = pspno;
	}

	public String getPlndt() {
		return plndt;
	}

	public void setPlndt(String plndt) {
		this.plndt = plndt;
	}

	public String getBasqy() {
		return basqy;
	}

	public void setBasqy(String basqy) {
		this.basqy = basqy;
	}

	public String getPonum() {
		return ponum;
	}

	public void setPonum(String ponum) {
		this.ponum = ponum;
	}

	public String getFaccd() {
		return faccd;
	}

	public void setFaccd(String faccd) {
		this.faccd = faccd;
	}

	public String getYard() {
		return yard;
	}

	public void setYard(String yard) {
		this.yard = yard;
	}

	public String getOutqy() {
		return outqy;
	}

	public void setOutqy(String outqy) {
		this.outqy = outqy;
	}

	public String getInpid() {
		return inpid;
	}

	public void setInpid(String inpid) {
		this.inpid = inpid;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTgubn() {
		return tgubn;
	}

	public void setTgubn(String tgubn) {
		this.tgubn = tgubn;
	}

}
