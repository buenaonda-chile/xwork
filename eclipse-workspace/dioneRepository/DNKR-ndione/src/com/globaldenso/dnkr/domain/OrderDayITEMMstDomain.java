package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 일일수주갱신 ITEM 제어마스타 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class OrderDayITEMMstDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143742L;
    
    
    private String comps;
    private String pyvnd;
    
    private String pspno;
    private String itdsc;
    private String carcd;
    private String carnm;
    private String bdycd;
    private String bdynm;
    
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

	public String getPspno() {
		return pspno;
	}

	public void setPspno(String pspno) {
		this.pspno = pspno;
	}

	public String getItdsc() {
		return itdsc;
	}

	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}

	public String getCarcd() {
		return carcd;
	}

	public void setCarcd(String carcd) {
		this.carcd = carcd;
	}

	public String getCarnm() {
		return carnm;
	}

	public void setCarnm(String carnm) {
		this.carnm = carnm;
	}

	public String getBdycd() {
		return bdycd;
	}

	public void setBdycd(String bdycd) {
		this.bdycd = bdycd;
	}

	public String getBdynm() {
		return bdynm;
	}

	public void setBdynm(String bdynm) {
		this.bdynm = bdynm;
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
        jsonObj.put("comps", this.comps);
        jsonObj.put("pyvnd", this.pyvnd);
        
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("carcd", this.carcd);
        jsonObj.put("carnm", this.carnm);
        jsonObj.put("bdycd", this.bdycd);
        jsonObj.put("bdynm", this.bdynm);     
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
