package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 서열형 일일 수주이관 작업 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class OrderDayTransferWorkDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143748L;

    
    private String adsdt;
    
    private String comps;
    private String typcd;
    private String pyvnd;
    private String pspno;
    private String plndt;
    private String basqy;
    private String chgdt;
    private String duedt;
    private String orqty;
    private String alqty;
    private String shdqy;
    private String shpdt;
    private String corno;
    private String plncd;

    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String lib1;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String lib2;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String lib3;
    

    public String getAdsdt() {
        return adsdt;
    }

    public void setAdsdt(String adsdt) {
        this.adsdt = adsdt;
    }
    
 

	/**
     * [KO] lib1의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the lib1
     */
    public String getLib1() {
        return lib1;
    }

    /**
     * [KO] lib1의 setter method 이다.<br>
     * [EN] It is a setter method of lib1.<br>
     * [JP] <br>
     * 
     * @param lib1 String
     */
    public void setLib1(String lib1) {
        this.lib1 = lib1;
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

	public String getChgdt() {
		return chgdt;
	}

	public void setChgdt(String chgdt) {
		this.chgdt = chgdt;
	}

	public String getDuedt() {
		return duedt;
	}

	public void setDuedt(String duedt) {
		this.duedt = duedt;
	}

	public String getOrqty() {
		return orqty;
	}

	public void setOrqty(String orqty) {
		this.orqty = orqty;
	}

	public String getAlqty() {
		return alqty;
	}

	public void setAlqty(String alqty) {
		this.alqty = alqty;
	}

	public String getShdqy() {
		return shdqy;
	}

	public void setShdqy(String shdqy) {
		this.shdqy = shdqy;
	}

	public String getShpdt() {
		return shpdt;
	}

	public void setShpdt(String shpdt) {
		this.shpdt = shpdt;
	}

	public String getCorno() {
		return corno;
	}

	public void setCorno(String corno) {
		this.corno = corno;
	}

	public String getPlncd() {
		return plncd;
	}

	public void setPlncd(String plncd) {
		this.plncd = plncd;
	}

	/**
     * [KO] lib2의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the lib2
     */
    public String getLib2() {
        return lib2;
    }

    /**
     * [KO] lib2의 setter method 이다.<br>
     * [EN] It is a setter method of lib2.<br>
     * [JP] <br>
     * 
     * @param lib2 String
     */
    public void setLib2(String lib2) {
        this.lib2 = lib2;
    }

    /**
     * [KO] lib3의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the lib3
     */
    public String getLib3() {
        return lib3;
    }

    /**
     * [KO] lib3의 setter method 이다.<br>
     * [EN] It is a setter method of lib3.<br>
     * [JP] <br>
     * 
     * @param lib3 String
     */
    public void setLib3(String lib3) {
        this.lib3 = lib3;
    }

    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("adsdt", this.adsdt);        
        
        jsonObj.put("comps", this.comps);
        jsonObj.put("typcd", this.typcd);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("plndt", this.plndt);
        jsonObj.put("basqy", this.basqy);
        jsonObj.put("chgdt", this.chgdt);
        jsonObj.put("duedt", this.duedt);
        jsonObj.put("orqty", this.orqty);
        jsonObj.put("alqty", this.alqty);
        jsonObj.put("shdqy", this.shdqy);
        jsonObj.put("shpdt", this.shpdt);        
        jsonObj.put("corno", this.corno);
        jsonObj.put("plncd", this.plncd);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }    
}