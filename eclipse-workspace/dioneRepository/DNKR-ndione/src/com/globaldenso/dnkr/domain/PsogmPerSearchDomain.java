package com.globaldenso.dnkr.domain;

import java.io.Serializable;

/**
 * 
 * Describe the outline of this class.
 * 
 * <p>
 * Describe the detail of this class.
 * </p>
 *
 * @author $Author$
 * @version $Revision$
 */
public class PsogmPerSearchDomain implements Serializable{

    /**
     * Describe the role of this field.
     */
    private static final long serialVersionUID = 8850156461415126516L;
    
    
    /**
     * 지시No
     */
    private String jisno;
    
    /**
     * jobnm 방법
     */
    private String jobnm;
    
    /**
     * tothr 총공수
     */
    private String tothr;
    
    /**
     * stphr 정지시간
     */
    private String stphr;
    
    /**
     * chonm 처치
     */
    private String chonm;
    
    /**
     * wndat 완료일
     */
    private String wndat;
    
    /**
     * hyonm 현상
     */
    private String hyonm;
        
    /**
     * cause 원인
     */
    private String cause;
    
    /**
     * trnum 실원인
     */
    private String trunm;
    
    /**
     * assnm 대분류
     */
    private String assnm;
    
    /**
     * cpart 셋트부품
     */
    private String cpart;
    
    /**
     * dpart 분해불가
     */
    private String dpart;
    
    /**
     * 스키마
     */
    private String LIB2;
    
    /**
     * company
     */
    private String COMPS;
    
    /**
     * 설비NO
     */
    private String MSHNO;
    
    /**
     * 검색시작일
     */
    private int WNDATS;
    
    /**
     * 검색종료일
     */
    private int WNDATE;

    /**
     * cnt_pm
     */
    private String cnt_pm;
    
    /**
     * cnt_bm
     */
    private String cnt_bm;
    
    /**
     * cnt_cm
     */
    private String cnt_cm;
    
    /**
     * sum_pm
     */
    private String sum_pm;
    
    /**
     * sum_bm
     */
    private String sum_bm;
    
    /**
     * sum_cm
     */
    private String sum_cm;
    
    /**
     * sum_pcost
     */
    private String sum_pcost;
    
    /**
     * sum_scost
     */
    private String sum_scost;
    
    /**
     * sum_stphr
     */
    private String sum_stphr;
    
    /**
     * sum_janhr
     */
    private String sum_janhr;
        
    /**
     * 
     * Constructor.
     *
     */
    public PsogmPerSearchDomain(){
        
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return String
     */
    public String getJisno() {
        return jisno;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param jisno String
     */
    public void setJisno(String jisno) {
        this.jisno = jisno;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return jobnm
     */
    public String getJobnm() {
        return jobnm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param jobnm String
     */
    public void setJobnm(String jobnm) {
        this.jobnm = jobnm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return tothr
     */
    public String getTothr() {
        return tothr;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param tothr 
     */
    public void setTothr(String tothr) {
        this.tothr = tothr;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return stphr
     */
    public String getStphr() {
        return stphr;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param stphr 
     */
    public void setStphr(String stphr) {
        this.stphr = stphr;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     *
     * @return chonm
     */
    public String getChonm() {
        return chonm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param chonm String
     */
    public void setChonm(String chonm) {
        this.chonm = chonm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return wndat
     */
    public String getWndat() {
        return wndat;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param wndat String
     */
    public void setWndat(String wndat) {
        this.wndat = wndat;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return hyonm
     */
    public String getHyonm() {
        return hyonm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param hyonm String
     */
    public void setHyonm(String hyonm) {
        this.hyonm = hyonm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return cause
     */
    public String getCause() {
        return cause;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param cause String
     */
    public void setCause(String cause) {
        this.cause = cause;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return trunm
     */
    public String getTrunm() {
        return trunm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param trunm String
     */
    public void setTrunm(String trunm) {
        this.trunm = trunm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return assnm
     */
    public String getAssnm() {
        return assnm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param assnm String
     */
    public void setAssnm(String assnm) {
        this.assnm = assnm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return cpart
     */
    public String getCpart() {
        return cpart;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param cpart String
     */
    public void setCpart(String cpart) {
        this.cpart = cpart;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return dpart
     */
    public String getDpart() {
        return dpart;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     *  
     * @param dpart String
     */
    public void setDpart(String dpart) {
        this.dpart = dpart;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return LIB2
     */
    public String getLIB2() {
        return LIB2;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param lIB2 String
     */
    public void setLIB2(String lIB2) {
        LIB2 = lIB2;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return COMPS
     */
    public String getCOMPS() {
        return COMPS;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param cOMPS String
     */
    public void setCOMPS(String cOMPS) {
        COMPS = cOMPS;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return MSHNO
     */
    public String getMSHNO() {
        return MSHNO;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param mSHNO String
     */
    public void setMSHNO(String mSHNO) {
        MSHNO = mSHNO;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return WNDATS
     */
    public int getWNDATS() {
        return WNDATS;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param wNDATS String
     */
    public void setWNDATS(int wNDATS) {
        WNDATS = wNDATS;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return WNDATE
     */
    public int getWNDATE() {
        return WNDATE;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param wNDATE String
     */
    public void setWNDATE(int wNDATE) {
        WNDATE = wNDATE;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return cnt_pm
     */
    public String getCnt_pm() {
        return cnt_pm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param cnt_pm String
     */
    public void setCnt_pm(String cnt_pm) {
        this.cnt_pm = cnt_pm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return cnt_bm
     */
    public String getCnt_bm() {
        return cnt_bm;
    }

    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param cnt_bm String
     */
    public void setCnt_bm(String cnt_bm) {
        this.cnt_bm = cnt_bm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return cnt_cm
     */
    public String getCnt_cm() {
        return cnt_cm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param cnt_cm String
     */
    public void setCnt_cm(String cnt_cm) {
        this.cnt_cm = cnt_cm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return sum_pm
     */
    public String getSum_pm() {
        return sum_pm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param sum_pm String
     */
    public void setSum_pm(String sum_pm) {
        this.sum_pm = sum_pm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return sum_bm
     */
    public String getSum_bm() {
        return sum_bm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param sum_bm String
     */
    public void setSum_bm(String sum_bm) {
        this.sum_bm = sum_bm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return sum_cm
     */
    public String getSum_cm() {
        return sum_cm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param sum_cm String
     */
    public void setSum_cm(String sum_cm) {
        this.sum_cm = sum_cm;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return sum_pcost
     */
    public String getSum_pcost() {
        return sum_pcost;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param sum_pcost String
     */
    public void setSum_pcost(String sum_pcost) {
        this.sum_pcost = sum_pcost;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return sum_scost
     */
    public String getSum_scost() {
        return sum_scost;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param sum_scost String
     */
    public void setSum_scost(String sum_scost) {
        this.sum_scost = sum_scost;
    }

    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return sum_stphr
     */
    public String getSum_stphr() {
        return sum_stphr;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param sum_stphr String
     */
    public void setSum_stphr(String sum_stphr) {
        this.sum_stphr = sum_stphr;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return sum_janhr
     */
    public String getSum_janhr() {
        return sum_janhr;
    }

    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param sum_janhr String
     */
    public void setSum_janhr(String sum_janhr) {
        this.sum_janhr = sum_janhr;
    }

    
 
    
}
