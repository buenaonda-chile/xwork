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
public class LinkDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 7287103375784704870L;

    /**
     * 
     */
    private List<LinkDomain> LinkList;
    
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
     * Link variable 
    */
    
    /**
     * [EN] Link type.<br>
     * [JP] <br>
     */
    private String type;
    
    /**
     * [EN] Link seq.<br>
     * [JP] <br>
     */
    private String seq;
    
    /**
     * [EN] Link sorting number.<br>
     * [JP] <br>
     */
    private String sort;
    
    /**
     * [EN] Link site name.<br>
     * [JP] <br>
     */
    private String siteName;
    
    /**
     * [EN] Link site url.<br>
     * [JP] <br>
     */
    private String siteUrl;
    
    /**
     * [EN] Link introduction.<br>
     * [JP] <br>
     */
    private String intro;
    
    /**
     * [EN] Link use TF.<br>
     * [JP] <br>
     */
    private String useTf;    
    
    /**
     * [EN] Link etc.<br>
     * [JP] <br>
     */
    private String etc;
    
    /**
     * [EN] Param Link Type.<br>
     * [JP] <br>
     */
    private String pType;
    /**
     * [EN] Param Link use TF.<br>
     * [JP] <br>
     */
    private String pUseTf;
    
    /**
     * [EN] insert Link Type.<br>
     * [JP] <br>
     */
    private String iType;
    
    /**
     * [EN] Param Link createUser.<br>
     * [JP] <br>
     */
    private String createUser;
    
    /**
     * [EN] Param Link updateUser.<br>
     * [JP] <br>
     */
    private String updateUser;
        
  
    /**
     * SSO variable 
     */
    
    /**
     * [EN] Sso systemSeq.<br>
     * [JP] <br>
     */
    private String sysSeq;
    
    /**
     * [EN] Sso company.<br>
     * [JP] <br>
     */
    private String company;
   
    /**
     * [EN] Sso sysName.<br>
     * [JP] <br>
     */
    
    private String sysName;
    /**
     * [EN] Sso sysUrl.<br>
     * [JP] <br>
     */
    private String sysUrl;
    /**
     * [EN] Sso sysUrl2.<br>
     * [JP] <br>
     */
    private String sysUrl2;
    
    /**
     * [EN] Sso sysType.<br>
     * [JP] <br>
     */
    private String sysType;
    
    /**
     * [EN] Sso popupYn.<br>
     * [JP] <br>
     */
    private String popupYn;
    
    /**
     * [EN] Sso inOutType.<br>
     * [JP] <br>
     */
    private String inOutType;
    
    /**
     * [EN] Sso loginYn.<br>
     * [JP] <br>
     */
    private String loginYn;
    
    
    /**
     * [EN] Sso popupW.<br>
     * [JP] <br>
     */
    private String popupW;
    
    /**
     * [EN] Sso popupH.<br>
     * [JP] <br>
     */
    private String popupH;
    
    /**
     * [EN] Sso subYn.<br>
     * [JP] <br>
     */
    private String subYn;
    
    /**
     * [EN] Sso ssoTf.<br>
     * [JP] <br>
     */
    private String ssoTf;
        
    
    /**
     * [EN] Param Sso Company.<br>
     * [JP] <br>
     */
    private String pCompany;
    /**
     * [EN] Param Sso InOutType.<br>
     * [JP] <br>
     */
    private String pInOutType;
    /**
     * [EN] Param Sso Company.<br>
     * [JP] <br>
     */
    private String iCompany;

    /**
     * [EN] Sso sysType.<br>
     * [JP] <br>
     */
    private String iSysType;
       
    /**
     * [EN] Sso inOutType.<br>
     * [JP] <br>
     */
    private String iInOutType;
    
    
    //2019.11.19 추가 WAA011Main
    /**
     * [EN] Employee number.<br>
     * [JP] 従業員番号。<br>
     */
    private String empNumber;
    
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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public LinkDomain () {
        //no process
    }


	public List<LinkDomain> getLinkList() {
		return LinkList;
	}


	public void setLinkList(List<LinkDomain> linkList) {
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

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}


	public String getSiteName() {
		return siteName;
	}


	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	public String getSiteUrl() {
		return siteUrl;
	}


	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}


	public String getIntro() {
		return intro;
	}


	public void setIntro(String intro) {
		this.intro = intro;
	}


	public String getUseTf() {
		return useTf;
	}


	public void setUseTf(String useTf) {
		this.useTf = useTf;
	}


	public String getEtc() {
		return etc;
	}


	public void setEtc(String etc) {
		this.etc = etc;
	}


	public String getpType() {
		return pType;
	}


	public void setpType(String pType) {
		this.pType = pType;
	}


	public String getpUseTf() {
		return pUseTf;
	}


	public void setpUseTf(String pUseTf) {
		this.pUseTf = pUseTf;
	}



	public String getiType() {
		return iType;
	}


	public void setiType(String iType) {
		this.iType = iType;
	}


	public String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}


	public String getUpdateUser() {
		return updateUser;
	}


	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	

	public String getSysSeq() {
		return sysSeq;
	}


	public void setSysSeq(String sysSeq) {
		this.sysSeq = sysSeq;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getSysName() {
		return sysName;
	}


	public void setSysName(String sysName) {
		this.sysName = sysName;
	}


	public String getSysUrl() {
		return sysUrl;
	}


	public void setSysUrl(String sysUrl) {
		this.sysUrl = sysUrl;
	}


	public String getSysUrl2() {
		return sysUrl2;
	}


	public void setSysUrl2(String sysUrl2) {
		this.sysUrl2 = sysUrl2;
	}


	public String getSysType() {
		return sysType;
	}


	public void setSysType(String sysType) {
		this.sysType = sysType;
	}


	public String getPopupYn() {
		return popupYn;
	}


	public void setPopupYn(String popupYn) {
		this.popupYn = popupYn;
	}


	public String getInOutType() {
		return inOutType;
	}


	public void setInOutType(String inOutType) {
		this.inOutType = inOutType;
	}


	public String getLoginYn() {
		return loginYn;
	}


	public void setLoginYn(String loginYn) {
		this.loginYn = loginYn;
	}


	public String getPopupW() {
		return popupW;
	}


	public void setPopupW(String popupW) {
		this.popupW = popupW;
	}


	public String getPopupH() {
		return popupH;
	}


	public void setPopupH(String popupH) {
		this.popupH = popupH;
	}


	public String getSubYn() {
		return subYn;
	}


	public void setSubYn(String subYn) {
		this.subYn = subYn;
	}


	public String getSsoTf() {
		return ssoTf;
	}


	public void setSsoTf(String ssoTf) {
		this.ssoTf = ssoTf;
	}


	public String getpCompany() {
		return pCompany;
	}


	public void setpCompany(String pCompany) {
		this.pCompany = pCompany;
	}


	public String getpInOutType() {
		return pInOutType;
	}


	public void setpInOutType(String pInOutType) {
		this.pInOutType = pInOutType;
	}


	public String getiCompany() {
		return iCompany;
	}


	public void setiCompany(String iCompany) {
		this.iCompany = iCompany;
	}


	public String getiSysType() {
		return iSysType;
	}


	public void setiSysType(String iSysType) {
		this.iSysType = iSysType;
	}


	public String getiInOutType() {
		return iInOutType;
	}


	public void setiInOutType(String iInOutType) {
		this.iInOutType = iInOutType;
	}


	public String getEmpNumber() {
		return empNumber;
	}


	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
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

}
