package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class LogDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 1905246848714381325L;
    
    /**
     * [KO] 로그코드<br>
     * [EN] Log number.<br>
     * [JP] <br>
     */
    private int logIdx;
    
    /**
     * [KO] 대상자 ID<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String logId;
    
    /**
     * [KO] 접근 URI<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String logUri;
    
    /**
     * [KO] 접근 일자<br>
     * [EN] connected date.<br>
     * [JP] <br>
     */
    private Timestamp logDate;
    
    /**
     * [KO] 접근메뉴코드<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mcdCode;
    
    /**
     * [KO] 접근메뉴코드명<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mcdName;
    
    /**
     * [KO] 접근 IP<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String logIp;
    
    /**
     * [KO] 접근 사원번호<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String empNumber;
    
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
     * [EN] Paging(rowCnt).<br>
     * [JP] ページング(rowCnt)。<br>
     */
    private int rowCnt;
    /**
     */
    private String empId;
    /**
     */
    private String empName;
    /**
     */
    private String clsCode;
    /**
     */
    private String locCode;
    /**
     */
    private String clsName;
    /**
     */
    private String locName;
    /**
     */
    private String searchData;
    
    /**
     * [KO] 언어코드<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cmcCode;
    
    /**
     * [KO] 조회시작일<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String startDate;
    
    /**
     * [KO] 조회종료일<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String endDate;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public LogDomain() {
        // no process
    }
    
    /**
     * @return the logIdx
     */
    public String getSearchData() {
        return searchData;
    }
    /**
     * @param searchData String
     */
    public void setSearchData(String searchData) {
        this.searchData = searchData;
    }
    

    /**
     * [EN] It is a getter method of Log ID.<br>
     * [JP] <br>
     * 
     * @return the logIdx
     */
    public int getLogIdx() {
        return logIdx;
    }
    /**
     * @param logIdx int
     */
    public void setLogIdx(int logIdx) {
        this.logIdx = logIdx;
    }

    /**
     * [KO] 접근 대상자 ID 의 getter 메소드이다.
     * [EN] It is a getter method of Logged user ID.<br>
     * [JP] <br>
     * 
     * @return the logId
     */
    public String getLogId() {
        return logId;
    }

    /**
     * @param logId String
     */
    public void setLogId(String logId) {
        this.logId = logId;
    }

    /**
     * [KO] 접근  URI의 getter 메소드 이다.
     * [EN] It is a getter method of Log Uri.<br>
     * [JP] <br>
     * 
     * @return the logUri
     */
    public String getLogUri() {
        return logUri;
    }

    /**
     * @param logUri String
     */
    public void setLogUri(String logUri) {
        this.logUri = logUri;
    }

    /**
     * [KO] 접근일자의 getter 메소드이다.
     * [EN] It is a getter method of Log Date.<br>
     * [JP] <br>
     * 
     * @return the logDate
     */
    public Timestamp getLogDate() {
        return logDate;
    }
    /**
     * @param logDate String
     */
    public void setLogDate(Timestamp logDate) {
        this.logDate = logDate;
    }

    /**
     * [KO] 접근 메뉴코드 getter 메소드이다.
     * [EN] It is a getter method of Log mcdCode.<br>
     * [JP] <br>
     * 
     * @return the mcdCode
     */
    public String getMcdCode() {
        return mcdCode;
    }
    /**
     * @param mcdCode String
     */
    public void setMcdCode(String mcdCode) {
        this.mcdCode = mcdCode;
    }
    
    /**
     * [KO] 접근 메뉴코드 getter 메소드이다.
     * [EN] It is a getter method of Log mcdCode.<br>
     * [JP] <br>
     * 
     * @return the mcdCode
     */
    public String getMcdName() {
        return mcdName;
    }
    /**
     * @param mcdName String
     */
    public void setMcdName(String mcdName) {
        this.mcdName = mcdName;
    }

    /**
     * [KO] 접근 IP 의  getter 메소드이다.<br>
     * [EN] It is a getter method of Log Ip.<br>
     * [JP] <br>
     * 
     * @return the logIp
     */
    public String getLogIp() {
        return logIp;
    }
    /**
     * @param logIp String
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    /**
     * [KO] 접근 사원번호의 getter 메소드이다.<br>
     * [EN] It is a getter method of Log empNumber.<br>
     * [JP] <br>
     * 
     * @return the empNumber
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

    /**
     * [EN] It is a getter method of rowCnt.<br>
     * [JP] rowCnt のゲッターメソッドです。<br>
     * 
     * @return the rowCnt
     */
    public int getRowCnt() {
        return rowCnt;
    }

    /**
     * [EN] It is a setter method of rowCnt.<br>
     * [JP] rowCnt のセッターメソッドです。<br>
     * 
     * @param rowCnt rowCnt に設定する
     */
    public void setRowCnt(int rowCnt) {
        this.rowCnt = rowCnt;
    }

    /**
     * @return the logIdx
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
     * @return the logIdx
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
     * @return the logIdx
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
     * @return the logIdx
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
     * @return the logIdx
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
     * @return the logIdx
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
     * @return the logIdx
     */
    public String getCmcCode() {
        return cmcCode;
    }

    /**
     * @param cmcCode String
     */
    public void setCmcCode(String cmcCode) {
        this.cmcCode = cmcCode;
    }

    /**
     * @return the logIdx
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate String
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the logIdx
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate String
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}
