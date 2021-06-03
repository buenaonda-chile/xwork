package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 생산성지표 기준정보(작업자정보관리) 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class WrkrInfoBaseDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String clsCode;
    private String empNumber;    
    private String fullNm;        
    private String locCode;
    private String cpnCode;    
    private String cpnNm;
    private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;
    private String oldCpnCode;     

    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public WrkrInfoBaseDomain () {
        //no process
    }    

    
	public String getClsCode() {
		return clsCode;
	}


	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}


	public String getEmpNumber() {
		return empNumber;
	}


	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	
	public String getFullNm() {
		return fullNm;
	}


	public void setFullNm(String fullNm) {
		this.fullNm = fullNm;
	}


	public String getLocCode() {
		return locCode;
	}


	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	public String getCpnCode() {
		return cpnCode;
	}


	public void setCpnCode(String cpnCode) {
		this.cpnCode = cpnCode;
	}


	public String getCpnNm() {
		return cpnNm;
	}


	public void setCpnNm(String cpnNm) {
		this.cpnNm = cpnNm;
	}


	public String getRegUser() {
		return regUser;
	}


	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getModUser() {
		return modUser;
	}


	public void setModUser(String modUser) {
		this.modUser = modUser;
	}


	public String getModDate() {
		return modDate;
	}


	public void setModDate(String modDate) {
		this.modDate = modDate;
	}


	public String getOldCpnCode() {
		return oldCpnCode;
	}


	public void setOldCpnCode(String oldCpnCode) {
		this.oldCpnCode = oldCpnCode;
	}


	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("empNumber", this.empNumber);
        jsonObj.put("fullNm", this.fullNm);       
        jsonObj.put("locCode", this.locCode);
        jsonObj.put("cpnCode", this.cpnCode);
        jsonObj.put("cpnNm", this.cpnNm);        
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate); 
        jsonObj.put("oldCpnCode", this.oldCpnCode);          
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
