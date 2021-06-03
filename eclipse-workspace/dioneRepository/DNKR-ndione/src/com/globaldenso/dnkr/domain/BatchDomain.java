package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 배치정보 도메인 <br>
 * [EN] Domain class of Employee information.<br>
 * [JP] 社員情報のDomainクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class BatchDomain implements Serializable {

	/**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 5436706032200856163L;
	
    private String comps;
    private String bchst;
    private String job02s;
    private String job15e;
    private String job01c;
    private String job02c;
    private String job03c;
    private String job04c;
    private String job05c;
    private String job06c;
    private String job07c;
    private String job08c;
    private String job09c;
    private String job10c;
    private String job11c;
    private String job12c;
    private String job13c;
    private String job14c;
    private String job15c;
    
    // SMS사용자리스트
    private String name;
    private String phone;
    private String sendDate;
    private String sendCnt;
    
    private String lib;
    
    public String getCheckError() {
    	String result = "";
    	
    	if(getJob01c().equals("E") 
    		||	getJob02c().equals("E")
    		||	getJob03c().equals("E")
    		||	getJob04c().equals("E")
    		||	getJob05c().equals("E")
    		||	getJob06c().equals("E")
    		||	getJob07c().equals("E")
    		||	getJob08c().equals("E")
    		||	getJob09c().equals("E")
    		||	getJob10c().equals("E")
    		||	getJob11c().equals("E")
    		||	getJob12c().equals("E")
    		||	getJob13c().equals("E")
    		||	getJob14c().equals("E")
    		||	getJob15c().equals("E")
    		) {
    		result = "ERROR";
    	}
    	return result;
    }
    
    
    
    public String getComps() {
		return comps;
	}


	public String getBchst() {
		return bchst;
	}


	public String getJob02s() {
		return job02s;
	}


	public String getJob15e() {
		return job15e;
	}


	public String getJob01c() {
		return job01c;
	}


	public String getJob02c() {
		return job02c;
	}


	public String getJob03c() {
		return job03c;
	}


	public String getJob04c() {
		return job04c;
	}


	public String getJob05c() {
		return job05c;
	}


	public String getJob06c() {
		return job06c;
	}


	public String getJob07c() {
		return job07c;
	}


	public String getJob08c() {
		return job08c;
	}


	public String getJob09c() {
		return job09c;
	}


	public String getJob10c() {
		return job10c;
	}


	public String getJob11c() {
		return job11c;
	}


	public String getJob12c() {
		return job12c;
	}


	public String getJob13c() {
		return job13c;
	}


	public String getJob14c() {
		return job14c;
	}


	public String getJob15c() {
		return job15c;
	}


	public void setComps(String comps) {
		this.comps = comps;
	}


	public void setBchst(String bchst) {
		this.bchst = bchst;
	}


	public void setJob02s(String job02s) {
		this.job02s = job02s;
	}


	public void setJob15e(String job15e) {
		this.job15e = job15e;
	}


	public void setJob01c(String job01c) {
		this.job01c = job01c;
	}


	public void setJob02c(String job02c) {
		this.job02c = job02c;
	}


	public void setJob03c(String job03c) {
		this.job03c = job03c;
	}


	public void setJob04c(String job04c) {
		this.job04c = job04c;
	}


	public void setJob05c(String job05c) {
		this.job05c = job05c;
	}


	public void setJob06c(String job06c) {
		this.job06c = job06c;
	}


	public void setJob07c(String job07c) {
		this.job07c = job07c;
	}


	public void setJob08c(String job08c) {
		this.job08c = job08c;
	}


	public void setJob09c(String job09c) {
		this.job09c = job09c;
	}


	public void setJob10c(String job10c) {
		this.job10c = job10c;
	}


	public void setJob11c(String job11c) {
		this.job11c = job11c;
	}


	public void setJob12c(String job12c) {
		this.job12c = job12c;
	}


	public void setJob13c(String job13c) {
		this.job13c = job13c;
	}


	public void setJob14c(String job14c) {
		this.job14c = job14c;
	}


	public void setJob15c(String job15c) {
		this.job15c = job15c;
	}


	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
		/*
		 * jsonObj.put("empNumber", this.empNumber); jsonObj.put("empName",
		 * this.empName); jsonObj.put("empId", this.empId); //2019.07.25추가 JHB
		 * jsonObj.put("locCode", this.locCode); //2019.07.25추가 JHB
		 * jsonObj.put("clsCode", this.clsCode); //2019.07.25추가 JHB
		 */        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getSendDate() {
		return sendDate;
	}



	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}



	public String getSendCnt() {
		return sendCnt;
	}



	public void setSendCnt(String sendCnt) {
		this.sendCnt = sendCnt;
	}



	public String getLib() {
		return lib;
	}



	public void setLib(String lib) {
		this.lib = lib;
	}
    
    
}
