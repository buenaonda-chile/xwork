package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * [KR] 프로젝트 관리 정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PjtDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 7023570191274263900L;
    
    /**
     * [KO] 프로젝트 번호.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private List<PjtDomain> pjtList;
    
    /**
     * [KO] 사원번호.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private List<String> empNumList;
    
    /**
     * [KO] 프로젝트 번호.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private int pjtNum;
    
    /**
     * [KO] 사원 번호.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String empNumber;
    
    /**
     * [KO] 사원 이름.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String empName;
    
    /**
     * [KO] 업무일자.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String workDate;
    
    /**
     * [KO] 업무시간.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private Float workHour;
    
    /**
     * [KO] 업무 분류 코드(소).<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String workCode;
    
    /**
     * [KO] 업무 분류 코드(대).<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String workLCode;
    
    /**
     * [KO] 업무 분류 코드(중).<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String workMCode;
    
    /**
     * [KO] 업무 분류 코드(소).<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String workSCode;
    
    /**
     * [KO] 업무 분류 코드(소).<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String workTypeNm;
    
    /**
     * [KO] 업무 분류 코드(대).<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String workLTypeNm;
    
    /**
     * [KO] 업무 분류 코드(중).<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String workMTypeNm;
    
    /**
     * [KR] 관련시스템<br>
     */
    private String relSys;
    
    /**
     * [KR] 업무영역<br>
     */
    private String workTrtr;
    
    /**
     * [KR] 승인구분<br>
     */
    private String aprvType;
    
    /**
     * [KR] 승인사원번호<br>
     */
    private String aprvEmpNum;
    
    /**
     * [KR] 반려사유<br>
     */
    private String note;

    /**
     * [KR] 업무상세<br>
     */
    private String workDtlCnts;

    /**
     * [KR] 등록일시<br>
     */
    private Date regDate;
    
    /**
     * [KR] 조회시작날짜<br>
     */
    private String startDate;
    
    /**
     * [KR] 조회마지막날짜<br>
     */
    private String endDate;
    
    /**
     * [KR] 승인일시<br>
     */
    private Date aprvDate;
    
    /**
     * [KR] 언어분류 코드<br>
     */
    private String cmcLangCode;
    
    /**
     * pageNo.
     */
    private Integer rowNum;
    
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
    public PjtDomain(){
        // no process
    }
    
    
    /**
     * [KR] 프로젝트 번호의 getter method
     * @return the pjtNum
     */
    public List<PjtDomain> getPjtList() {
        return pjtList;
    }

    /**
     * [KR] 프로젝트 번호의 setter method
     * @param pjtList List<PjtDomain>
     */
    public void setPjtList(List<PjtDomain> pjtList) {
        this.pjtList = pjtList;
    }
    
    /**
     * [KR] 사원번호 List의 getter method
     * @return the pjtNum
     */
    public List<String> getEmpNumList() {
        return empNumList;
    }

    /**
     * [KR] 사원번호 List의 setter method
     * @param empNumList List<String>
     */
    public void setEmpNumList(List<String> empNumList) {
        this.empNumList = empNumList;
    }


    /**
     * [KR] 프로젝트 번호의 getter method
     * @return the pjtNum
     */
    public int getPjtNum() {
        return pjtNum;
    }

    /**
     * [KR] 프로젝트 번호의 setter method
     * @param pjtNum to set
     */
    public void setPjtNum(int pjtNum) {
        this.pjtNum = pjtNum;
    }

    /**
     * [KR] 사원 번호의 getter method
     * @return the empNumber
     */
    public String getEmpNumber() {
        return empNumber;
    }

    /**
     * [KR] 사원 번호의 setter method
     * @param empNumber to set
     */
    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    /**
     * [KR] 사원이름의 getter method
     * @return the workDate
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * [KR] 사원이름의 setter method
     * @param empName String
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }


    /**
     * [KR] 업무일자의 getter method
     * @return the workDate
     */
    public String getWorkDate() {
        return workDate;
    }

    /**
     * [KR] 업무일자의 setter method
     * @param workDate to set
     */
    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    /**
     * [KR] 업무시간의 getter method
     * @return the workHour
     */
    public Float getWorkHour() {
        return workHour;
    }

    /**
     * [KR] 업무시간의 setter method
     * @param workHour to set
     */
    public void setWorkHour(Float workHour) {
        this.workHour = workHour;
    }

    /**
     * [KR] 업무 분류 코드(소)의 getter method
     * @return the workCode
     */
    public String getWorkCode() {
        return workCode;
    }

    /**
     * [KR] 업무 분류 코드(소)의 setter method
     * @param workCode to set
     */
    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    /**
     * [KR] 업무 분류 코드(대)의 getter method
     * @return the workLCode
     */
    public String getWorkLCode() {
        return workLCode;
    }

    /**
     * [KR] 업무 분류 코드(대)의 setter method
     * @param workLCode to set
     */
    public void setWorkLCode(String workLCode) {
        this.workLCode = workLCode;
    }

    /**
     * [KR] 업무 분류 코드(중)의 getter method
     * @return the workMCode
     */
    public String getWorkMCode() {
        return workMCode;
    }

    /**
     * [KR] 업무 분류 코드(중)의 setter method
     * @param workMCode to set
     */
    public void setWorkMCode(String workMCode) {
        this.workMCode = workMCode;
    }

    /**
     * [KR] 업무 분류 코드(소)의 getter method
     * @return the workSCode
     */
    public String getWorkSCode() {
        return workSCode;
    }

    /**
     * [KR] 업무 분류 코드(소)의 setter method
     * @param workSCode to set
     */
    public void setWorkSCode(String workSCode) {
        this.workSCode = workSCode;
    }

    /**
     * [KR] 업무 분류(소) 명칭의 getter method
     * @return the workSCode
     */
    public String getWorkTypeNm() {
        return workTypeNm;
    }


    /**
     * [KR] 업무 분류 (소) 명칭의 setter method
     * @param workTypeNm String
     */
    public void setWorkTypeNm(String workTypeNm) {
        this.workTypeNm = workTypeNm;
    }

    /**
     * [KR] 업무 분류 (대) 명칭의 getter method
     * @return the workSCode
     */
    public String getWorkLTypeNm() {
        return workLTypeNm;
    }

    /**
     * [KR] 업무 분류(대) 명칭의 setter method
     * @param workLTypeNm String
     */
    public void setWorkLTypeNm(String workLTypeNm) {
        this.workLTypeNm = workLTypeNm;
    }

    /**
     * [KR] 업무 분류 (중) 명칭의 getter method
     * @return the workSCode
     */
    public String getWorkMTypeNm() {
        return workMTypeNm;
    }

    /**
     * [KR] 업무 분류(중) 명칭의 setter method
     * @param workMTypeNm String
     */
    public void setWorkMTypeNm(String workMTypeNm) {
        this.workMTypeNm = workMTypeNm;
    }


    /**
     * [KR] 관련시스템의 getter method
     * @return the relSys
     */
    public String getRelSys() {
        return relSys;
    }

    /**
    * [KR] 관련시스템의 setter method
    * @param relSys to set
    */
    public void setRelSys(String relSys) {
        this.relSys = relSys;
    }

    /**
    * [KR] 업무영역의 getter method
    * @return the workTrtr
    */
    public String getWorkTrtr() {
        return workTrtr;
    }

    /**
    * [KR] 업무영역의 setter method
    * @param workTrtr to set
    */
    public void setWorkTrtr(String workTrtr) {
        this.workTrtr = workTrtr;
    }

    /**
    * [KR] 승인구분의 getter method
    * @return the aprvType
    */
    public String getAprvType() {
        return aprvType;
    }

    /**
    * [KR] 승인구분의 setter method
    * @param aprvType to set
    */
    public void setAprvType(String aprvType) {
        this.aprvType = aprvType;
    }

    /**
    * [KR] 승인사원번호의 getter method
    * @return the aprvEmpNum
    */
    public String getAprvEmpNum() {
        return aprvEmpNum;
    }

    /**
    * [KR] 승인사원번호의 setter method
    * @param aprvEmpNum to set
    */
    public void setAprvEmpNum(String aprvEmpNum) {
        this.aprvEmpNum = aprvEmpNum;
    }

    /**
    * [KR] 비고의 getter method
    * @return the note
    */
    public String getNote() {
        return note;
    }

    /**
    * [KR] 비고의 setter method
    * @param note to set
    */
    public void setNote(String note) {
        this.note = note;
    }

    /**
    * [KR] 등록일시의 getter method
    * @return the regDate
    */
    public Date getRegDate() {
        return regDate;
    }

    /**
    * [KR] 등록일시의 setter method
    * @param regDate to set
    */
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }


    /**
    * [KR] 조회시작날짜 getter method
    * @return the regDate
    */
    public String getStartDate() {
        return startDate;
    }

    /**
    * [KR] 조회시작날짜 setter method
    * @param startDate String
    */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
    * [KR] 조회마지막날짜의 getter method
    * @return the regDate
    */
    public String getEndDate() {
        return endDate;
    }

    /**
    * [KR] 조회마지막날짜의 setter method
    * @param endDate String
    */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    /**
    * [KR] 승인일시의 getter method
    * @return the aprvDate
    */
    public Date getAprvDate() {
        return aprvDate;
    }

    /**
    * [KR] 승인일시의 setter method
    * @param aprvDate to set
    */
    public void setAprvDate(Date aprvDate) {
        this.aprvDate = aprvDate;
    }


    /**
    * [KR] 업무상세의 getter method
    * @return the aprvDate
    */
    public String getWorkDtlCnts() {
        return workDtlCnts;
    }

    /**
    * [KR] 업무상세의 setter method
    * @param workDtlCnts String
    */
    public void setWorkDtlCnts(String workDtlCnts) {
        this.workDtlCnts = workDtlCnts;
    }

    /**
    * [KR] 언어분류코드의 getter method
    * @return the aprvDate
    */
    public String getCmcLangCode() {
        return cmcLangCode;
    }

    /**
    * [KR] 언어분류코드의 setter method
    * @param cmcLangCode String
    */
    public void setCmcLangCode(String cmcLangCode) {
        this.cmcLangCode = cmcLangCode;
    }


    /**
    * Getter method of pageNo.
    *
    * @return the pageNo
    */
    public Integer getRowNum() {
        return rowNum;
    }
   
   /**
    * Setter method of pageNo.
    *
    * @param rowNum Integer
    */
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    /**
    * [EN] It is a getter method of rowNumFrom.<br>
    * [JP] rowNumFrom のゲッターメソッドです。<br>
    * 
    * @return the rowNumFrom
    */
    public int getRowNumFrom() {
        return rowNumFrom;
    }

    /**
    * [EN] It is a setter method of rowNumFrom.<br>
    * [JP] rowNumFrom のセッターメソッドです。<br>
    * 
    * @param rowNumFrom rowNumFrom に設定する
    */
    public void setRowNumFrom(int rowNumFrom) {
        this.rowNumFrom = rowNumFrom;
    }

    /**
    * [EN] It is a getter method of rowNumTo.<br>
    * [JP] rowNumTo のゲッターメソッドです。<br>
    * 
    * @return the rowNumTo
    */
    public int getRowNumTo() {
        return rowNumTo;
    }

    /**
    * [EN] It is a setter method of rowNumTo.<br>
    * [JP] rowNumTo のセッターメソッドです。<br>
    * 
    * @param rowNumTo rowNumTo に設定する
    */
    public void setRowNumTo(int rowNumTo) {
        this.rowNumTo = rowNumTo;
    }

}
