package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 생산성지표 기준정보(작업코드관리) 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class WorkCodeBaseDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String clsCode;
    private String se;
    private String code;
    private String codeNm;
    private String startTime;
    private String endTime;
    private String overtimeM;
    private String overtimeH;    
    private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;
    private String oldSe;
    private String oldCode;    

    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public WorkCodeBaseDomain () {
        //no process
    }    

    public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getClsCode() {
		return clsCode;
	}

	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}

	public String getSe() {
		return se;
	}

	public void setSe(String se) {
		this.se = se;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeNm() {
		return codeNm;
	}

	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOvertimeM() {
		return overtimeM;
	}

	public void setOvertimeM(String overtimeM) {
		this.overtimeM = overtimeM;
	}

	public String getOvertimeH() {
		return overtimeH;
	}

	public void setOvertimeH(String overtimeH) {
		this.overtimeH = overtimeH;
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

	public String getOldSe() {
		return oldSe;
	}

	public void setOldSe(String oldSe) {
		this.oldSe = oldSe;
	}

	public String getOldCode() {
		return oldCode;
	}

	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("se", this.se);
        jsonObj.put("code", this.code);
        jsonObj.put("codeNm", this.codeNm);
        jsonObj.put("startTime", this.startTime);
        jsonObj.put("endTime", this.endTime);
        jsonObj.put("overtimeM", this.overtimeM);
        jsonObj.put("overtimeH", this.overtimeH);        
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate); 
        jsonObj.put("oldSe", this.oldSe);
        jsonObj.put("oldCode", this.oldCode);        
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
