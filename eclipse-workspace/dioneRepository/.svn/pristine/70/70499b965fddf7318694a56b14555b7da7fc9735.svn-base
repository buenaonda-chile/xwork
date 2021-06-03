package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
/**
 * [KR] 설문조사 참여 대상자 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class TargetDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -5558034364544771438L;
    /**
     * 
     */
    private String qstCode;
    /**
     * 
     */
    private String aswCode;
    /**
     * 
     */
    private String srvCode;
    
    /**
     * [KO] 익명성 여부 
     */
    private String srvAnonymous;
    
    /**
     * 
     */
    private String drAnswer;
    /**
     * 
     */
    private Integer searchTotalCount;
    /**
     * 
     */
    private List<String> empNumList;
    /**
     * 
     */
    private String srvTitle;

    /**
       * [EN] Employee number.<br>
       * [JP] 従業員番号。<br>
       */
    private String empNumber;
      
      /**
       * [KO] 사업부 코드 <br>
       * [EN] <br>
       * [JP] <br>
       */
    private String clsCode;
      
      /**
       * [KO] 사업장 코드 <br>
       * [EN] <br>
       * [JP] <br>
       */
    private String locCode;
      
      /**
       * [KO] 부서(팀) 코드 <br>
       * [EN] <br>
       * [JP] <br>
       */
    private String teamCode;
          
      /**
       * [KO] 사업부 명칭 <br>
       * [EN] <br>
       * [JP] <br>
       */
    private String clsName;
      
      /**
       * [KO] 사업장 명칭 <br>
       * [EN] <br>
       * [JP] <br>
       */
    private String locName;
      
      /**
       * [KO] 부서(팀) 명칭 <br>
       * [EN] <br>
       * [JP] <br>
       */
    private String teamName;
      
      /**
       * [KO] 권한 코드 <br>
       * [EN] <br>
       * [JP] <br>
       */
    private String authCode;
      
      /**
       * [EN] Last name.<br>
       * [JP] 名前(名)。<br>
       */
    private String lastName;
      
      /**
       * [EN] First name.<br>
       * [JP] 名前(姓)。<br>
       */
    private String firstName;
      
      /**
       * [EN] Full name.<br>
       * [JP] 氏名。<br>
       */
    private String empName;
      
      /**
       * [EN] E-mail address.<br>
       * [JP] E-Mailアドレス。<br>
       */
    private String empEmail;
      
      /**
       * [EN] Employee ID.<br>
       * [JP] 従業員番号。<br>
       */
    private String empId;
      
      
      /**
    * [KO] 사용여부.<br>
       * [EN] <br>
       * [JP] <br>
       */
    private String empUse;
      
      /**
       * [EN] Last sync date.<br>
       * [JP] 最終更新日時。<br>
       */
    private Timestamp empSyncDate;
      
      /**
    * [KO] 사원 비밀번호.<br>
       * [EN] Employee password.<br><br>
       * [JP] <br>
       */
    private String empPwd;
      
      /**
    * [KO] 개인권한여부.<br>
       * [EN] <br>
       * [JP] <br>
       */
    private String empPrivateAuth;
      
     /**
    * [KO] 내부직원, 외부업체 구분.<br>
      * [EN] <br>
      * [JP] <br>
      */
    private String inOutType;
      
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
       * [EN] Paging(To).<br>
       * [JP] ページング(To)。<br>
       */
    private int rowNum;
    
    /**
     * countPerPage.
     */
    private Integer countPerPage = 10;
    
    /**
     * pageNo.
     */
    private Integer pageNo;
    
    /**
     * pages.
     */
    private String pages = "search";
    
    /**
     * 
     */
    private String relName;

    /**
     * 
     */
    private String tgtParticipation;
    
    /**
     * 
     */
    private String mode;
    
    /**
     * 
     */
    private String chkYn;
    
    /**
     * 
     */
    private String teamYn;
    
    /** Constructor. */
    public TargetDomain() {
        // TODO Auto-generated constructor stub
    }
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return  String
     */
    public String getTeamYn() {
        return teamYn;
    }

    /**
     * @param teamYn String
     */
    public void setTeamYn(String teamYn) {
        this.teamYn = teamYn;
    }
    /**
     * @return chkYn
     */
    public String getChkYn() {
        return chkYn;
    }
    /**
     * @param chkYn String
     */
    public void setChkYn(String chkYn) {
        this.chkYn = chkYn;
    }

    /**
    * 
    * Describe the outline of the function for this method.
    * 
    * <p>
    * Describe the detail of the function for this method.
    * </p>
    * 
    * @return         String
    */
    public String getMode() {
        if(mode == null || "".equals(mode)){
            return null;
        }else{
            return mode;
        }
    }
    /**
     * @param mode String
     */
    public void setMode(String mode) {
        this.mode = mode;
    }
    /**
     * @return tgtParticipation
     */
    public String getTgtParticipation() {
        return tgtParticipation;
    }
    /**
     * @param tgtParticipation String
     */
    public void setTgtParticipation(String tgtParticipation) {
        this.tgtParticipation = tgtParticipation;
    }
    /**
     * @return relName
     */
    public String getRelName() {
        return relName;
    }
    /**
     * @param relName String
     */
    public void setRelName(String relName) {
        this.relName = relName;
    }
    /**
     * @return empNumList
     */
    public List<String> getEmpNumList() {
        return empNumList;
    }
    /**
     * @param empNumList List<String>
     */
    public void setEmpNumList(List<String> empNumList) {
        this.empNumList = empNumList;
    }
    /**
     * @return empNumber
     */
    public String getEmpNumber() {
        return empNumber;
    }
    /**
     * @param empNumber String
     */
    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }
    /**
     * @return clsCode
     */
    public String getClsCode() {
        return clsCode;
    }
    /**
     * @param clsCode String
     */
    public void setClsCode(String clsCode) {
        this.clsCode = clsCode;
    }
    /**
     * @return locCode
     */
    public String getLocCode() {
        return locCode;
    }
    /**
     * @param locCode String
     */
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }
    /**
     * @return teamCode
     */
    public String getTeamCode() {
        return teamCode;
    }
    /**
     * @param teamCode String
     */
    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }
    /**
     * @return clsName
     */
    public String getClsName() {
        return clsName;
    }
    /**
     * @param clsName String
     */
    public void setClsName(String clsName) {
        this.clsName = clsName;
    }
    /**
     * @return locName
     */
    public String getLocName() {
        return locName;
    }
    /**
     * @param locName String
     */
    public void setLocName(String locName) {
        this.locName = locName;
    }
    /**
     * @return teamName
     */
    public String getTeamName() {
        return teamName;
    }
    /**
     * @param teamName String
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    /**
     * @return authCode
     */
    public String getAuthCode() {
        return authCode;
    }
    /**
     * @param authCode String
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    /**
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return empName
     */
    public String getEmpName() {
        return empName;
    }
    /**
     * @param empName String
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    /**
     * @return empEmail
     */
    public String getEmpEmail() {
        return empEmail;
    }
    /**
     * @param empEmail String
     */
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }
    /**
     * @return empId
     */
    public String getEmpId() {
        return empId;
    }
    /**
     * @param empId String
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    /**
     * @return empUse
     */
    public String getEmpUse() {
        return empUse;
    }
    /**
     * @param empUse String
     */
    public void setEmpUse(String empUse) {
        this.empUse = empUse;
    }
    /**
     * @return empSyncDate
     */
    public Timestamp getEmpSyncDate() {
        return empSyncDate;
    }
    /**
     * @param empSyncDate String
     */
    public void setEmpSyncDate(Timestamp empSyncDate) {
        this.empSyncDate = empSyncDate;
    }
    /**
     * @return empPwd
     */
    public String getEmpPwd() {
        return empPwd;
    }
    /**
     * @param empPwd String
     */
    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }
    /**
     * @return empPrivateAuth
     */
    public String getEmpPrivateAuth() {
        return empPrivateAuth;
    }
    /**
     * @param empPrivateAuth String
     */
    public void setEmpPrivateAuth(String empPrivateAuth) {
        this.empPrivateAuth = empPrivateAuth;
    }
    /**
     * @return inOutType
     */
    public String getInOutType() {
        return inOutType;
    }
    /**
     * @param inOutType String
     */
    public void setInOutType(String inOutType) {
        this.inOutType = inOutType;
    }
    /**
     * @return cmcLangCode
     */
    public String getCmcLangCode() {
        return cmcLangCode;
    }
    /**
     * @param cmcLangCode String
     */
    public void setCmcLangCode(String cmcLangCode) {
        this.cmcLangCode = cmcLangCode;
    }
    /**
     * @return rowNumFrom
     */
    public int getRowNumFrom() {
        return rowNumFrom;
    }
    /**
     * @param rowNumFrom int
     */
    public void setRowNumFrom(int rowNumFrom) {
        this.rowNumFrom = rowNumFrom;
    }
    /**
     * @return rowNumTo
     */
    public int getRowNumTo() {
        return rowNumTo;
    }
    /**
     * @param rowNumTo int
     */
    public void setRowNumTo(int rowNumTo) {
        this.rowNumTo = rowNumTo;
    }
    /**
     * @return rowNum
     */
    public int getRowNum() {
        return rowNum;
    }
    /**
     * @param rowNum int
     */
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
    /**
     * @return searchTotalCount
     */
    public Integer getSearchTotalCount() {
        return searchTotalCount;
    }
    /**
     * @param searchTotalCount Integer
     */
    public void setSearchTotalCount(Integer searchTotalCount) {
        this.searchTotalCount = searchTotalCount;
    }
    /**
     * @return countPerPage
     */
    public Integer getCountPerPage() {
        return countPerPage;
    }
    /**
     * @param countPerPage Integer
     */
    public void setCountPerPage(Integer countPerPage) {
        this.countPerPage = countPerPage;
    }
    /**
     * @return pageNo
     */
    public Integer getPageNo() {
        return pageNo;
    }
    /**
     * @param pageNo String
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    /**
     * @return pages
     */
    public String getPages() {
        return pages;
    }
    /**
     * @param pages String
     */
    public void setPages(String pages) {
        this.pages = pages;
    }
    /**
     * @return qstCode
     */
    public String getQstCode() {
        return qstCode;
    }
    /**
     * @param qstCode String
     */
    public void setQstCode(String qstCode) {
        this.qstCode = qstCode;
    }
    /**
     * @return aswCode
     */
    public String getAswCode() {
        return aswCode;
    }
    /**
     * @param aswCode String
     */
    public void setAswCode(String aswCode) {
        this.aswCode = aswCode;
    }
    /**
     * @return srvCode
     */
    public String getSrvCode() {
        return srvCode;
    }
    /**
     * @param srvCode String
     */
    public void setSrvCode(String srvCode) {
        this.srvCode = srvCode;
    }
    
    /**
     * @return srvAnonymous
     */
    public String getSrvAnonymous() {
        return srvAnonymous;
    }
    /**
     * @param srvCode String
     */
    public void setSrvAnonymous(String srvAnonymous) {
        this.srvAnonymous = srvAnonymous;
    }
    
    /**
     * @return drAnswer
     */
    public String getDrAnswer() {
        return drAnswer;
    }
    /**
     * @param drAnswer String
     */
    public void setDrAnswer(String drAnswer) {
        this.drAnswer = drAnswer;
    }
    /**
     * @return srvTitle
     */
    public String getSrvTitle() {
        return srvTitle;
    }
    /**
     * @param srvTitle String
     */
    public void setSrvTitle(String srvTitle) {
        this.srvTitle = srvTitle;
    }
    
}
