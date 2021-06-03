package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.util.List;
/**
 * [KR] 설문조사 질문 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PartDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 6055914909017268780L;

    /**
    * 질문코드
    */
    private String qstCode;

    /**
    * 설문지코드
    */
    private String srvCode;

    /**
    * 질문타입
    */
    private String qstType;

    /**
    * 언어코드
    */
    private String cmcCode;
    
    /**
    * 질문
    */
    private String qstTitle;

    /**
    * 도움말
    */
    private String qstHelp;

    /**
    * 답변코드
    */
    private String aswCode;
    
    /**
    * 답변명칭
    */
    private String aswTitle;

    /**
    * 
    */
    private String maxSrv;

    /**
    * 
    */
    private String aswTotalCount;
    /**
    * 
    */
    private String aswTotalPercent;
    /**
    * 
    */
    private String drAnswer;
    /**
    * 
    */
    private List<String> drAnswerList;
    /**
    * 
    */
    private String mulCheck;
    
    /**
     * 
     */
     private String empNumber;

    /**
     * 
     */
    public PartDomain () {
        //no process
    }
    /**
    * @return mulCheck
    */
    public String getMulCheck() {
        return mulCheck;
    }
    /**
    * @param mulCheck String
    */
    public void setMulCheck(String mulCheck) {
        this.mulCheck = mulCheck;
    }
    /**
    * @return aswTotalPercent
    */
    public String getAswTotalPercent() {
        return aswTotalPercent;
    }
    /**
    * @param aswTotalPercent String
    */
    public void setAswTotalPercent(String aswTotalPercent) {
        this.aswTotalPercent = aswTotalPercent;
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
    * @return drAnswerList
    */
    public List<String> getDrAnswerList() {
        return drAnswerList;
    }
    /**
    * @param drAnswerList List<String>
    */
    public void setDrAnswerList(List<String> drAnswerList) {
        this.drAnswerList = drAnswerList;
    }
    /**
    * @return aswTotalCount
    */
    public String getAswTotalCount() {
        return aswTotalCount;
    }
    /**
    * @param aswTotalCount String
    */
    public void setAswTotalCount(String aswTotalCount) {
        this.aswTotalCount = aswTotalCount;
    }
    /**
    * @return maxSrv
    */
    public String getMaxSrv() {
        return maxSrv;
    }
    /**
    * @param maxSrv String
    */
    public void setMaxSrv(String maxSrv) {
        this.maxSrv = maxSrv;
    }
    /**
    * @return aswTitle
    */
    public String getAswTitle() {
        return aswTitle;
    }
    /**
    * @param aswTitle String
    */
    public void setAswTitle(String aswTitle) {
        this.aswTitle = aswTitle;
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
    * @return qstType
    */
    public String getQstType() {
        return qstType;
    }
    /**
    * @param qstType String
    */
    public void setQstType(String qstType) {
        this.qstType = qstType;
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
    * @return qstTitle
    */
    public String getQstTitle() {
        if(qstTitle == null){
            return "";
        } else{
            return qstTitle;
        }
    }
    /**
    * @param qstTitle String
    */
    public void setQstTitle(String qstTitle) {
        this.qstTitle = qstTitle;
    }
    /**
    * @return qstHelp
    */
    public String getQstHelp() {
        if(qstHelp == null){
            return "";
        } else {
            return qstHelp;
        }
    }
    /**
    * @param qstHelp String
    */
    public void setQstHelp(String qstHelp) {
        this.qstHelp = qstHelp;
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
     * 
     * @return
     */
	public String getEmpNumber() {
		return empNumber;
	}
	
    /**
     * 
     * @return
     */
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

    
}
