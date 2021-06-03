package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.util.List;
/**
 * [KR] 권한 정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
/**
 * @author UXIS
 *
 */
public class SessionDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 7287103375784704870L;

    /**
     * 
     */
    private List<SessionDomain> LinkList;
    
    /**
     * [KO] 권한구분 번호 : 읽기권한(1), 쓰기권한(2), 수정권한(4), 삭제권한(8).<br>
     * [KO] ex: 읽기권한(1) + 쓰기권한 (2) + 수정권한(4) = 7<br>
     * [EN] Auth number.<br>
     * [JP] <br>
     */
    private int authNum;
    
    /**
     * [KO] 권한구분 번호 : 읽기권한(1), 쓰기권한(2), 수정권한(4), 삭제권한(8).<br>
     * [KO] ex: 읽기권한(1) + 쓰기권한 (2) + 수정권한(4) = 7<br>
     * [EN] Auth number.<br>
     * [JP] <br>
     */
    private String authBinaryNum;
    
    /**
     * [EN] Paging(From).<br>
     * [JP] ページング(From)。<br>
     */
    private int rowNumFrom;
    
    /**
     * [EN] Paging(To).<br>
     * [JP] ページング(To)。<br>
     */
    private int rowNumTo;
    
    /**
     * [EN] Paging(To).<br>
     * [JP] ページング(To)。<br>
     */
    private int rowNum;
   
    /**
     * SSO variable 
     */
    
    /**
     * [EN] Employee number.<br>
     * [JP] 従業員番号。<br>
     */
    private String empNumber;
    
    /**
     * [EN] Employee ID.<br>
     * [JP] 従業員番号。<br>
     */
    private String empId;  
    
    /**
     * [EN] Employee Name.<br>
     * [JP] 従業員番号。<br>
     */
    private String empName;  
    
    /**
     * [EN] Sso company.<br>
     * [JP] <br>
     */
    private String company;
    
    /**
     * [EN] Sso workPlace.<br>
     * [JP] <br>
     */
    private String workPlace;
    
    /**
     * [EN] Sso workPlace.<br>
     * [JP] <br>
     */
    private String oldCompany;
    
    /**
     * [EN] Sso workPlace.<br>
     * [JP] <br>
     */
    private String oldWorkPlace;
    
    /**
     * [EN] Sso workPlace.<br>
     * [JP] <br>
     */
    private String deviceCnt;
    
    /**
     * [EN] Sso systemSeq.<br>
     * [JP] <br>
     */
    private String sysSeq;
    
    /**
     * [KO] system ID. <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String systemId;
    
    /**
     * [KO] system PW.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String systemPW;
    
    /**
     * [KO] system PW.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String systemGroup;
    
    /**
     * [KO] system PW.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String remarks;
    
    /**
     * [EN] Sso printer device1.<br>
     * [JP] <br>
     */
    private String device1;
    
    /**
     * [EN] Sso printer device2.<br>
     * [JP] <br>
     */
    private String device2;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SessionDomain () {
        //no process
    }

	public List<SessionDomain> getLinkList() {
		return LinkList;
	}

	public void setLinkList(List<SessionDomain> linkList) {
		LinkList = linkList;
	}

	public int getAuthNum() {
		return authNum;
	}

	public void setAuthNum(int authNum) {
		this.authNum = authNum;
	}

	public String getAuthBinaryNum() {
		return authBinaryNum;
	}

	public void setAuthBinaryNum(String authBinaryNum) {
		this.authBinaryNum = authBinaryNum;
	}

	public int getRowNumFrom() {
		return rowNumFrom;
	}

	public void setRowNumFrom(int rowNumFrom) {
		this.rowNumFrom = rowNumFrom;
	}

	public int getRowNumTo() {
		return rowNumTo;
	}

	public void setRowNumTo(int rowNumTo) {
		this.rowNumTo = rowNumTo;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getOldCompany() {
		return oldCompany;
	}

	public void setOldCompany(String oldCompany) {
		this.oldCompany = oldCompany;
	}

	public String getOldWorkPlace() {
		return oldWorkPlace;
	}

	public void setOldWorkPlace(String oldWorkPlace) {
		this.oldWorkPlace = oldWorkPlace;
	}

	public String getDeviceCnt() {
		return deviceCnt;
	}

	public void setDeviceCnt(String deviceCnt) {
		this.deviceCnt = deviceCnt;
	}

	public String getSysSeq() {
		return sysSeq;
	}

	public void setSysSeq(String sysSeq) {
		this.sysSeq = sysSeq;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getSystemPW() {
		return systemPW;
	}

	public void setSystemPW(String systemPW) {
		this.systemPW = systemPW;
	}

	public String getSystemGroup() {
		return systemGroup;
	}

	public void setSystemGroup(String systemGroup) {
		this.systemGroup = systemGroup;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getDevice1() {
		return device1;
	}

	public void setDevice1(String device1) {
		this.device1 = device1;
	}

	public String getDevice2() {
		return device2;
	}

	public void setDevice2(String device2) {
		this.device2 = device2;
	}

}
