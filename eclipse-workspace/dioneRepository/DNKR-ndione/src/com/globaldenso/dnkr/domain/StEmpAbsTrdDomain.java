package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 생산성지표 근태정보 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class StEmpAbsTrdDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String opertDe;    
    private String clsCode;
    private String locCode;
    private String empno;    
    private String empnm;        

    private String posType;    
    private Boolean logiType;
    private String strLogiType;    
    private String shiftwork;
    private String shiftworkNm;    
    private String workCode;
    private String workNm;    
    private String lrlyTime;    
    private String latenTime;   
    private String gnotTime;       
    private String closSe;   
    private String arqstTime;      
    private String workPsbTime;    
    
    private String beforeDate;
    private String toDate;
    private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;

    private String overtimeM;
    private String rcvsupTm;
    private String minusSum;  
    private String sumWorkTime;  
    
    private String lgstTm; //물류시간
    
	/**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public StEmpAbsTrdDomain () {
        //no process
    }    

    public String getOpertDe() {
		return opertDe;
	}

	public void setOpertDe(String opertDe) {
		this.opertDe = opertDe;
	}

	public String getClsCode() {
		return clsCode;
	}

	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}

	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEmpnm() {
		return empnm;
	}

	public void setEmpnm(String empnm) {
		this.empnm = empnm;
	}

	public String getPosType() {
		return posType;
	}

	public void setPosType(String posType) {
		this.posType = posType;
	}

	public Boolean getLogiType() {
		return logiType;
	}

	public void setLogiType(Boolean logiType) {
		this.logiType = logiType;
	}

	public String getStrLogiType() {
		return strLogiType;
	}

	public void setStrLogiType(String strLogiType) {
		this.strLogiType = strLogiType;
	}

	public String getShiftwork() {
		return shiftwork;
	}

	public void setShiftwork(String shiftwork) {
		this.shiftwork = shiftwork;
	}

	public String getShiftworkNm() {
		return shiftworkNm;
	}

	public void setShiftworkNm(String shiftworkNm) {
		this.shiftworkNm = shiftworkNm;
	}

	public String getWorkCode() {
		return workCode;
	}

	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}

	public String getWorkNm() {
		return workNm;
	}

	public void setWorkNm(String workNm) {
		this.workNm = workNm;
	}

	public String getLrlyTime() {
		return lrlyTime;
	}

	public void setLrlyTime(String lrlyTime) {
		this.lrlyTime = lrlyTime;
	}

	public String getLatenTime() {
		return latenTime;
	}

	public void setLatenTime(String latenTime) {
		this.latenTime = latenTime;
	}

	public String getGnotTime() {
		return gnotTime;
	}

	public void setGnotTime(String gnotTime) {
		this.gnotTime = gnotTime;
	}

	public String getClosSe() {
		return closSe;
	}

	public void setClosSe(String closSe) {
		this.closSe = closSe;
	}

	public String getArqstTime() {
		return arqstTime;
	}

	public void setArqstTime(String arqstTime) {
		this.arqstTime = arqstTime;
	}

	public String getWorkPsbTime() {
		return workPsbTime;
	}

	public void setWorkPsbTime(String workPsbTime) {
		this.workPsbTime = workPsbTime;
	}

	public String getBeforeDate() {
		return beforeDate;
	}

	public void setBeforeDate(String beforeDate) {
		this.beforeDate = beforeDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
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
	
	public String getOvertimeM() {
		return overtimeM;
	}

	public void setOvertimeM(String overtimeM) {
		this.overtimeM = overtimeM;
	}
	
    public String getRcvsupTm() {
		return rcvsupTm;
	}

	public void setRcvsupTm(String rcvsupTm) {
		this.rcvsupTm = rcvsupTm;
	}
	
	public String getMinusSum() {
		return minusSum;
	}

	public void setMinusSum(String minusSum) {
		this.minusSum = minusSum;
	}

	public String getSumWorkTime() {
		return sumWorkTime;
	}

	public void setSumWorkTime(String sumWorkTime) {
		this.sumWorkTime = sumWorkTime;
	}

	public String getLgstTm() {
		return lgstTm;
	}

	public void setLgstTm(String lgstTm) {
		this.lgstTm = lgstTm;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("opertDe", this.opertDe);        
        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("locCode", this.locCode);
        jsonObj.put("empno", this.empno);
        jsonObj.put("empnm", this.empnm);
        jsonObj.put("posType", this.posType);
        jsonObj.put("strLogiType", this.strLogiType);        
        jsonObj.put("logiType", this.logiType);
        jsonObj.put("shiftwork", this.shiftwork);
        jsonObj.put("shiftworkNm", this.shiftworkNm);   
        jsonObj.put("workCode", this.workCode);
        jsonObj.put("workNm", this.workNm);              
        jsonObj.put("lrlyTime", this.lrlyTime);
        jsonObj.put("latenTime", this.latenTime);
        jsonObj.put("gnotTime", this.gnotTime);
        jsonObj.put("arqstTime", this.arqstTime);
        jsonObj.put("workPsbTime", this.workPsbTime);        
        jsonObj.put("closSe", this.closSe);
        jsonObj.put("beforeDate", this.beforeDate);
        jsonObj.put("toDate", this.toDate);        
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate);
        jsonObj.put("overtimeM", this.overtimeM);  
        jsonObj.put("rcvsupTm", this.rcvsupTm);         
        jsonObj.put("minusSum", this.minusSum);
        jsonObj.put("sumWorkTime", this.sumWorkTime);          
        jsonObj.put("lgstTm", this.lgstTm);  
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
