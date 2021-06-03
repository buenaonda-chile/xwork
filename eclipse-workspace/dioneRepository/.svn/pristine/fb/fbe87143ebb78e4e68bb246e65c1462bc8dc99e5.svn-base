package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 메뉴관리 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class OrderCalendarDomain implements Serializable {
	
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143747L;
    
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

	public String getMakdt() {
		return makdt;
	}

	public void setMakdt(String makdt) {
		this.makdt = makdt;
	}

	public String getMakmk() {
		return makmk;
	}

	public void setMakmk(String makmk) {
		this.makmk = makmk;
	}

	public String getMltcd() {
		return mltcd;
	}

	public void setMltcd(String mltcd) {
		this.mltcd = mltcd;
	}

	public String getClhcd() {
		return clhcd;
	}

	public void setClhcd(String clhcd) {
		this.clhcd = clhcd;
	}

	private String comps;
    private String pyvnd;
    private String makdt;
    private String makmk;
    private String mltcd;
    private String clhcd;
    
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
    
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("makdt", this.makdt);
        jsonObj.put("makmk", this.makmk);
        jsonObj.put("mltcd", this.mltcd);
        jsonObj.put("clhcd", this.clhcd);              
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }    
    
}
