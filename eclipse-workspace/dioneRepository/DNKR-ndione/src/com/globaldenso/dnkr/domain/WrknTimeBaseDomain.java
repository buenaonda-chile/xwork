package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 생산성지표 기준정보(근무조시간관리) 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class WrknTimeBaseDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String clsCode;
    private String workStle;
    private String workStleNm;    
    private String group;
    private String groupNm;    
    private String startTime;
    private String endTime;
    private String appstaDe;
    private String appendDe; 
    private String refrn;     
    private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;
    private String oldWorkStle;    
    private String oldGroup;     
    private String oldAppstaDe;
    private String oldAppendDe;     

    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public WrknTimeBaseDomain () {
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

	public String getWorkStle() {
		return workStle;
	}

	public void setWorkStle(String workStle) {
		this.workStle = workStle;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public String getAppstaDe() {
		return appstaDe;
	}

	public void setAppstaDe(String appstaDe) {
		this.appstaDe = appstaDe;
	}

	public String getAppendDe() {
		return appendDe;
	}

	public String getOldAppstaDe() {
		return oldAppstaDe;
	}

	public void setOldAppstaDe(String oldAppstaDe) {
		this.oldAppstaDe = oldAppstaDe;
	}

	public String getOldAppendDe() {
		return oldAppendDe;
	}

	public void setOldAppendDe(String oldAppendDe) {
		this.oldAppendDe = oldAppendDe;
	}

	public void setAppendDe(String appendDe) {
		this.appendDe = appendDe;
	}

	public String getRefrn() {
		return refrn;
	}

	public void setRefrn(String refrn) {
		this.refrn = refrn;
	}
	

	public String getWorkStleNm() {
		return workStleNm;
	}

	public void setWorkStleNm(String workStleNm) {
		this.workStleNm = workStleNm;
	}

	public String getGroupNm() {
		return groupNm;
	}

	public void setGroupNm(String groupNm) {
		this.groupNm = groupNm;
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

	public String getOldWorkStle() {
		return oldWorkStle;
	}

	public void setOldWorkStle(String oldWorkStle) {
		this.oldWorkStle = oldWorkStle;
	}

	public String getOldGroup() {
		return oldGroup;
	}

	public void setOldGroup(String oldGroup) {
		this.oldGroup = oldGroup;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("workStle", this.workStle);
        jsonObj.put("group", this.group);
        jsonObj.put("workStleNm", this.workStleNm);
        jsonObj.put("groupNm", this.groupNm);
        jsonObj.put("startTime", this.startTime);
        jsonObj.put("endTime", this.endTime);
        jsonObj.put("refrn", this.refrn);
        jsonObj.put("appstaDe", this.appstaDe);        
        jsonObj.put("appendDe", this.appendDe);
        jsonObj.put("regUser", this.regUser);        
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate);      
        jsonObj.put("oldWorkStle", this.oldWorkStle);
        jsonObj.put("oldGroup", this.oldGroup);        
        jsonObj.put("oldAppstaDe", this.oldAppstaDe);        
        jsonObj.put("oldAppendDe", this.oldAppendDe);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
