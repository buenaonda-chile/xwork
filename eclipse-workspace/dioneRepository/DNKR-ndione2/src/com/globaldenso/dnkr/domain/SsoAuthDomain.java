package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.util.List;
/**
 * [KR] Sso권한 정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
/**
 * @author UXIS
 *
 */
public class SsoAuthDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 374291010941934282L;
    /***
     */
    private List<SsoAuthDomain> ssoAuthList;
    
    /**
     * [EN] emp number.<br>
     * [JP] <br>
     */
    private String empNumber;  
    
   
    /**
     * [EN] emp ID.<br>
     * [JP] <br>
     */
    private String empId; 
    
    /**
     * [EN] system sequence.<br>
     * [JP] <br>
     */
    private String sysSeq; 
    
    /**
     * [EN] system name.<br>
     * [JP] <br>
     */
    private String sysName; 
        
    /**
     * [EN] system company.<br>
     * [JP] <br>
     */
    private String company; 
        
    /**
     * [EN] system Type.<br>
     * [JP] <br>
     */
    private String sysType;
    
    /**
     * [EN] system inout type.<br>
     * [JP] <br>
     */
    private String inoutType;
        
    /**
     * [EN] use.<br>
     * [JP] <br>
     */
    private String useTf; 
    
    /**
     * [EN] temp use.<br>
     * [JP] <br>
     */
    private String tempUseTf; 
    
    /**
     * [EN] system using company.<br>
     * [JP] <br>
     */
    private String useCompany; 
    
    /**
     * [EN] system using company.<br>
     * [JP] <br>
     */
    private String changeCompany; 
    
        
    /**
     * [KO] 생성자.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String createUser;
    
    /**
     * [KO] 언어코드.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cmcLangCode;
    
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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SsoAuthDomain () {
    //no process
    }


	public List<SsoAuthDomain> getSsoAuthList() {
		return ssoAuthList;
	}


	public void setSsoAuthList(List<SsoAuthDomain> ssoAuthList) {
		this.ssoAuthList = ssoAuthList;
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


	public String getSysSeq() {
		return sysSeq;
	}


	public void setSysSeq(String sysSeq) {
		this.sysSeq = sysSeq;
	}


	public String getSysName() {
		return sysName;
	}


	public void setSysName(String sysName) {
		this.sysName = sysName;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getSysType() {
		return sysType;
	}


	public void setSysType(String sysType) {
		this.sysType = sysType;
	}


	public String getInoutType() {
		return inoutType;
	}


	public void setInoutType(String inoutType) {
		this.inoutType = inoutType;
	}


	public String getUseTf() {
		return useTf;
	}


	public void setUseTf(String useTf) {
		this.useTf = useTf;
	}


	public String getTempUseTf() {
		return tempUseTf;
	}


	public void setTempUseTf(String tempUseTf) {
		this.tempUseTf = tempUseTf;
	}


	public String getUseCompany() {
		return useCompany;
	}


	public void setUseCompany(String useCompany) {
		this.useCompany = useCompany;
	}


	/**
	 * @return the changeCompany
	 */
	public String getChangeCompany() {
		return changeCompany;
	}


	/**
	 * @param changeCompany the changeCompany to set
	 */
	public void setChangeCompany(String changeCompany) {
		this.changeCompany = changeCompany;
	}


	public String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}


	public String getCmcLangCode() {
		return cmcLangCode;
	}


	public void setCmcLangCode(String cmcLangCode) {
		this.cmcLangCode = cmcLangCode;
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

}
