package com.globaldenso.dnkr.domain;

import java.io.Serializable;

/**
 * [KR] 설문 관리 정도 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class SurveyDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -5992818818997673072L;

    
    /**
     * 설문지코드
     */
    private String srvCode;
    
    /**
     * 설문시작일자
     */
    private String srvStart;
    
    /**
     * 설문종료일자
     */
    private String srvEnd;
    
    /**
     * 설문활성여부
     */
    private String srvUse;
    
    /**
     * 익명여부
     */
    private String srvAnonymous = "Y";
    
    /**
     * 설문지명
     */
    private String srvTitle;
    
    /**
     * 언어코드
     */
    private String cmcCode;
    
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
    * 시작일 종료일
    */
    private String startY;
   /**
    * 
    */
    private String startM;
    /**
     * 
     */
    private String startD;
    /**
     * 
     */
    private String startH;
    /**
     * 
     */
    private String startI;
    /**
     * 
     */
    private String endY;
    /**
     * 
     */
    private String endM;
    /**
     * 
     */
    private String endD;
    /**
     * 
     */
    private String endH;
    /**
     * 
     */
    private String endI;
    /**
     * 
     */
    private int cnt;
   //시작종료일 끝
    /**
     * 작성자 팀 코드
     */
    private String teamCode;


   /**
    * 
    */
    public SurveyDomain () {
       //no process
    }
    /**
     * @return rowNumFrom
     */
    public int getRowNumFrom() {
        return rowNumFrom;
    }
    /**
     * @return cnt
     */
    public int getCnt() {
        return cnt;
    }
    /**
     * @param cnt int
     */
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    /**
     * @return startY
     */
    public String getStartY() {
        return startY;
    }
    /**
     * @param startY String
     */
    public void setStartY(String startY) {
        this.startY = startY;
    }
    /**
     * @return startM
     */
    public String getStartM() {
        return startM;
    }
    /**
     * @param startM String
     */
    public void setStartM(String startM) {
        this.startM = startM;
    }
    /**
     * @return startD
     */
    public String getStartD() {
        return startD;
    }
    /**
     * @param startD String
     */
    public void setStartD(String startD) {
        this.startD = startD;
    }
    /**
     * @return startH
     */
    public String getStartH() {
        return startH;
    }
    /**
     * @param startH String
     */
    public void setStartH(String startH) {
        this.startH = startH;
    }
    /**
     * @return startI
     */
    public String getStartI() {
        return startI;
    }
    /**
     * @param startI String
     */
    public void setStartI(String startI) {
        this.startI = startI;
    }
    /**
     * @return endY
     */
    public String getEndY() {
        return endY;
    }
    /**
     * @param endY String
     */
    public void setEndY(String endY) {
        this.endY = endY;
    }
    /**
     * @return endM
     */
    public String getEndM() {
        return endM;
    }
    /**
     * @param endM String
     */
    public void setEndM(String endM) {
        this.endM = endM;
    }
    /**
     * @return endD
     */
    public String getEndD() {
        return endD;
    }
    /**
     * @param endD String
     */
    public void setEndD(String endD) {
        this.endD = endD;
    }
    /**
     * @return endH
     */
    public String getEndH() {
        return endH;
    }
    /**
     * @param endH String
     */
    public void setEndH(String endH) {
        this.endH = endH;
    }
    /**
     * @return endI
     */
    public String getEndI() {
        return endI;
    }
    /**
     * @param endI String
     */
    public void setEndI(String endI) {
        this.endI = endI;
    }
    /**
     * @param rowNumFrom String
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
     * @param rowNumTo String
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
     * @param rowNum String
     */
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
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
     * @return srvStart
     */
    public String getSrvStart() {
        return srvStart;
    }
    /**
     * @param srvStart String
     */
    public void setSrvStart(String srvStart) {
        this.srvStart = srvStart;
    }
    /**
     * @return srvEnd
     */
    public String getSrvEnd() {
        return srvEnd;
    }
    /**
     * @param srvEnd String
     */
    public void setSrvEnd(String srvEnd) {
        this.srvEnd = srvEnd;
    }
    /**
     * @return srvUse
     */
    public String getSrvUse() {
        return srvUse;
    }
    /**
     * @param srvUse String
     */
    public void setSrvUse(String srvUse) {
        this.srvUse = srvUse;
    }
    /**
     * @return srvAnonymous
     */
    public String getSrvAnonymous() {
        return srvAnonymous;
    }
    /**
     * @param srvAnonymous String
     */
    public void setSrvAnonymous(String srvAnonymous) {
        this.srvAnonymous = srvAnonymous;
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
    /**
     * @return cmcCode
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
    
    
    
    
}
