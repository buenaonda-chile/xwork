package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] DB2 코드정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PsogmMonPerformDb2Domain implements Serializable{

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
    */
    private static final long serialVersionUID = -1526181805033446453L;


    /**
     * [KO] <br>
     */
    private String timnm;
    
    /**
     * [KO] <br>
     */
    private String prtnm;
    
    /**
     * [KO] <br>
     */
    private String startYearMon;
    
    /**
     * [KO] <br>
     */
    private String endYearMon;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_08;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_04;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_05;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_02;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_03;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_15;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_11;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_09;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_06;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_01;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_16;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_17;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_14;
    
    /**
     * [KO] <br>
     */
    private String cnt_jnbno_total;
    
    /**
     * [KO] <br>
     */
    private String m4;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_04;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_04;
    
    /**
     * [KO] <br>
     */
    private String m5;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_05;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_05;
    
    /**
     * [KO] <br>
     */
    private String m6;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_06;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_06;
    
    /**
     * [KO] <br>
     */
    private String m7;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_07;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_07;
    
    /**
     * [KO] <br>
     */
    private String m8;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_08;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_08;
    
    /**
     * [KO] <br>
     */
    private String m9;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_09;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_09;
    
    /**
     * [KO] <br>
     */
    private String m10;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_10;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_10;
    
    /**
     * [KO] <br>
     */
    private String m11;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_11;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_11;
    
    /**
     * [KO] <br>
     */
    private String m12;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_12;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_12;
    
    /**
     * [KO] <br>
     */
    private String m1;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_01;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_01;
    
    /**
     * [KO] <br>
     */
    private String m2;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_02;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_02;
    
    /**
     * [KO] <br>
     */
    private String m3;
    
    /**
     * [KO] <br>
     */
    private String cnt_yedat_03;
    
    /**
     * [KO] <br>
     */
    private String cnt_rpdat_03;
    
    /**
     * [KO] <br>
     */
    private String cnt_total;
    
    /**
     * [KO] 사업부<br>
     */
    private String comps;
    
    /**
     * [KO] 교정구분(전체, 사내, 사외, 표준기(사외))<br>
     */
    private String g_gub;
    
    /**
     * [KO] 쿼리문<br>
     */
    private String strval;
    
    /**
     * [KR] 사업부별 DB2데이터베이스 
     */
    private String lib1;
    
    /**
     * [KR] 사업부별 DB2데이터베이스 
     */
    private String lib2;
    
    /**
     * [KR] 사업부별 DB2데이터베이스 
     */
    private String lib3;


    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmMonPerformDb2Domain(){
        // no process
    }

    
    
    /**
     * [KO] timnm의 getter method 이다.<br>
     * [EN] It is a getter method of timnm.<br>
     * [JP] <br>
     * 
     * @return the timnm
     */
    public String getTimnm() {
        return timnm;
    }

    /**
     * [KO] timnm의 setter method 이다.<br>
     * [EN] It is a setter method of timnm.<br>
     * [JP] <br>
     * 
     * @param timnm String
     */
    public void setTimnm(String timnm) {
        this.timnm = timnm;
    }

    /**
     * [KO] prtnm의 getter method 이다.<br>
     * [EN] It is a getter method of prtnm.<br>
     * [JP] <br>
     * 
     * @return the prtnm
     */
    public String getPrtnm() {
        return prtnm;
    }

    /**
     * [KO] prtnm의 setter method 이다.<br>
     * [EN] It is a setter method of prtnm.<br>
     * [JP] <br>
     * 
     * @param prtnm String
     */
    public void setPrtnm(String prtnm) {
        this.prtnm = prtnm;
    }

    /**
     * [EN] It is a getter method of startYearMon.<br>
     * [JP] <br>
     * 
     * @return the startYearMon
     */
    public String getStartYearMon() {
        return startYearMon;
    }

    /**
     * [EN] It is a setter method of startYearMon.<br>
     * [JP] <br>
     * 
     * @param startYearMon String
     */     
    public void setStartYearMon(String startYearMon) {
        this.startYearMon = startYearMon;
    }
    
    /**
     * [EN] It is a getter method of endYearMon.<br>
     * [JP] <br>
     * 
     * @return the endYearMon
     */
    public String getEndYearMon() {
        return endYearMon;
    }

    /**
     * [EN] It is a setter method of endYearMon.<br>
     * [JP] <br>
     * 
     * @param endYearMon String
     */     
    public void setEndYearMon(String endYearMon) {
        this.endYearMon = endYearMon;
    }

    /**
     * [KO] cnt_jnbno_08의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_08.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_08
     */
    public String getCnt_jnbno_08() {
        return cnt_jnbno_08;
    }

    /**
     * [KO] cnt_jnbno_08의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_08.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_08 String
     */
    public void setCnt_jnbno_08(String cnt_jnbno_08) {
        this.cnt_jnbno_08 = cnt_jnbno_08;
    }

    /**
     * [KO] cnt_jnbno_04의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_04.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_04
     */
    public String getCnt_jnbno_04() {
        return cnt_jnbno_04;
    }

    /**
     * [KO] cnt_jnbno_04의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_04.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_04 String
     */
    public void setCnt_jnbno_04(String cnt_jnbno_04) {
        this.cnt_jnbno_04 = cnt_jnbno_04;
    }

    /**
     * [KO] cnt_jnbno_05의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_05.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_05
     */
    public String getCnt_jnbno_05() {
        return cnt_jnbno_05;
    }

    /**
     * [KO] cnt_jnbno_05의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_05.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_05 String
     */
    public void setCnt_jnbno_05(String cnt_jnbno_05) {
        this.cnt_jnbno_05 = cnt_jnbno_05;
    }

    /**
     * [KO] cnt_jnbno_02의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_02.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_02
     */
    public String getCnt_jnbno_02() {
        return cnt_jnbno_02;
    }

    /**
     * [KO] cnt_jnbno_02의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_02.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_02 String
     */
    public void setCnt_jnbno_02(String cnt_jnbno_02) {
        this.cnt_jnbno_02 = cnt_jnbno_02;
    }

    /**
     * [KO] cnt_jnbno_03의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_03.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_03
     */
    public String getCnt_jnbno_03() {
        return cnt_jnbno_03;
    }

    /**
     * [KO] cnt_jnbno_03의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_03.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_03 String
     */
    public void setCnt_jnbno_03(String cnt_jnbno_03) {
        this.cnt_jnbno_03 = cnt_jnbno_03;
    }

    /**
     * [KO] cnt_jnbno_15의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_15.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_15
     */
    public String getCnt_jnbno_15() {
        return cnt_jnbno_15;
    }

    /**
     * [KO] cnt_jnbno_15의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_15.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_15 String
     */
    public void setCnt_jnbno_15(String cnt_jnbno_15) {
        this.cnt_jnbno_15 = cnt_jnbno_15;
    }

    /**
     * [KO] cnt_jnbno_11의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_11.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_11
     */
    public String getCnt_jnbno_11() {
        return cnt_jnbno_11;
    }

    /**
     * [KO] cnt_jnbno_11의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_11.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_11 String
     */
    public void setCnt_jnbno_11(String cnt_jnbno_11) {
        this.cnt_jnbno_11 = cnt_jnbno_11;
    }

    /**
     * [KO] cnt_jnbno_09의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_09.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_09
     */
    public String getCnt_jnbno_09() {
        return cnt_jnbno_09;
    }

    /**
     * [KO] cnt_jnbno_09의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_09.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_09 String
     */
    public void setCnt_jnbno_09(String cnt_jnbno_09) {
        this.cnt_jnbno_09 = cnt_jnbno_09;
    }

    /**
     * [KO] cnt_jnbno_06의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_06.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_06
     */
    public String getCnt_jnbno_06() {
        return cnt_jnbno_06;
    }

    /**
     * [KO] cnt_jnbno_06의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_06.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_06 String
     */
    public void setCnt_jnbno_06(String cnt_jnbno_06) {
        this.cnt_jnbno_06 = cnt_jnbno_06;
    }

    /**
     * [KO] cnt_jnbno_01의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_01.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_01
     */
    public String getCnt_jnbno_01() {
        return cnt_jnbno_01;
    }

    /**
     * [KO] cnt_jnbno_01의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_01.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_01 String
     */
    public void setCnt_jnbno_01(String cnt_jnbno_01) {
        this.cnt_jnbno_01 = cnt_jnbno_01;
    }

    /**
     * [KO] cnt_jnbno_16의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_16.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_16
     */
    public String getCnt_jnbno_16() {
        return cnt_jnbno_16;
    }

    /**
     * [KO] cnt_jnbno_16의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_16.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_16 String
     */
    public void setCnt_jnbno_16(String cnt_jnbno_16) {
        this.cnt_jnbno_16 = cnt_jnbno_16;
    }

    /**
     * [KO] cnt_jnbno_17의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_17.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_17
     */
    public String getCnt_jnbno_17() {
        return cnt_jnbno_17;
    }

    /**
     * [KO] cnt_jnbno_17의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_17.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_17 String
     */
    public void setCnt_jnbno_17(String cnt_jnbno_17) {
        this.cnt_jnbno_17 = cnt_jnbno_17;
    }

    /**
     * [KO] cnt_jnbno_14의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_14.<br>
     * [JP] <br>
     * 
     * @return the cnt_jnbno_14
     */
    public String getCnt_jnbno_14() {
        return cnt_jnbno_14;
    }

    /**
     * [KO] cnt_jnbno_14의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_14.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_14 String
     */
    public void setCnt_jnbno_14(String cnt_jnbno_14) {
        this.cnt_jnbno_14 = cnt_jnbno_14;
    }

    /**
     * [KO] cnt_jnbno_total의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_jnbno_total.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getCnt_jnbno_total() {
        return cnt_jnbno_total;
    }

    /**
     * [KO] cnt_jnbno_total의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_jnbno_total.<br>
     * [JP] <br>
     * 
     * @param cnt_jnbno_total String
     */
    public void setCnt_jnbno_total(String cnt_jnbno_total) {
        this.cnt_jnbno_total = cnt_jnbno_total;
    }

    /**
     * [KO] m4의 getter method 이다.<br>
     * [EN] It is a getter method of m4.<br>
     * [JP] <br>
     * 
     * @return the m4
     */
    public String getM4() {
        return m4;
    }

    /**
     * [KO] m4의 setter method 이다.<br>
     * [EN] It is a setter method of m4.<br>
     * [JP] <br>
     * 
     * @param m4 String
     */
    public void setM4(String m4) {
        this.m4 = m4;
    }

    /**
     * [KO] cnt_yedat_04의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_04.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_04
     */
    public String getCnt_yedat_04() {
        return cnt_yedat_04;
    }

    /**
     * [KO] cnt_yedat_04의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_04.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_04 String
     */
    public void setCnt_yedat_04(String cnt_yedat_04) {
        this.cnt_yedat_04 = cnt_yedat_04;
    }

    /**
     * [KO] cnt_rpdat_04의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_04.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_04
     */
    public String getCnt_rpdat_04() {
        return cnt_rpdat_04;
    }

    /**
     * [KO] cnt_rpdat_04의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_04.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_04 String
     */
    public void setCnt_rpdat_04(String cnt_rpdat_04) {
        this.cnt_rpdat_04 = cnt_rpdat_04;
    }

    /**
     * [KO] m5의 getter method 이다.<br>
     * [EN] It is a getter method of m5.<br>
     * [JP] <br>
     * 
     * @return the m5
     */
    public String getM5() {
        return m5;
    }

    /**
     * [KO] m5의 setter method 이다.<br>
     * [EN] It is a setter method of m5.<br>
     * [JP] <br>
     * 
     * @param m5 String
     */
    public void setM5(String m5) {
        this.m5 = m5;
    }

    /**
     * [KO] cnt_yedat_05의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_05.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_05
     */
    public String getCnt_yedat_05() {
        return cnt_yedat_05;
    }

    /**
     * [KO] cnt_yedat_05의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_05.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_05 String
     */
    public void setCnt_yedat_05(String cnt_yedat_05) {
        this.cnt_yedat_05 = cnt_yedat_05;
    }

    /**
     * [KO] cnt_rpdat_05의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_05.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_05
     */
    public String getCnt_rpdat_05() {
        return cnt_rpdat_05;
    }

    /**
     * [KO] cnt_rpdat_05의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_05.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_05 String
     */
    public void setCnt_rpdat_05(String cnt_rpdat_05) {
        this.cnt_rpdat_05 = cnt_rpdat_05;
    }

    /**
     * [KO] m6의 getter method 이다.<br>
     * [EN] It is a getter method of m6.<br>
     * [JP] <br>
     * 
     * @return the m6
     */
    public String getM6() {
        return m6;
    }

    /**
     * [KO] m6의 setter method 이다.<br>
     * [EN] It is a setter method of m6.<br>
     * [JP] <br>
     * 
     * @param m6 String
     */
    public void setM6(String m6) {
        this.m6 = m6;
    }

    /**
     * [KO] cnt_yedat_06의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_06.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_06
     */
    public String getCnt_yedat_06() {
        return cnt_yedat_06;
    }

    /**
     * [KO] cnt_yedat_06의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_06.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_06 String
     */
    public void setCnt_yedat_06(String cnt_yedat_06) {
        this.cnt_yedat_06 = cnt_yedat_06;
    }

    /**
     * [KO] cnt_rpdat_06의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_06.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_06
     */
    public String getCnt_rpdat_06() {
        return cnt_rpdat_06;
    }

    /**
     * [KO] cnt_rpdat_06의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_06.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_06 String
     */
    public void setCnt_rpdat_06(String cnt_rpdat_06) {
        this.cnt_rpdat_06 = cnt_rpdat_06;
    }

    /**
     * [KO] m7의 getter method 이다.<br>
     * [EN] It is a getter method of m7.<br>
     * [JP] <br>
     * 
     * @return the m7
     */
    public String getM7() {
        return m7;
    }

    /**
     * [KO] m7의 setter method 이다.<br>
     * [EN] It is a setter method of m7.<br>
     * [JP] <br>
     * 
     * @param m7 String
     */
    public void setM7(String m7) {
        this.m7 = m7;
    }

    /**
     * [KO] cnt_yedat_07의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_07.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_07
     */
    public String getCnt_yedat_07() {
        return cnt_yedat_07;
    }

    /**
     * [KO] cnt_yedat_07의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_07.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_07 String
     */
    public void setCnt_yedat_07(String cnt_yedat_07) {
        this.cnt_yedat_07 = cnt_yedat_07;
    }

    /**
     * [KO] cnt_rpdat_07의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_07.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getCnt_rpdat_07() {
        return cnt_rpdat_07;
    }

    /**
     * [KO] cnt_rpdat_07의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_07.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_07 String
     */
    public void setCnt_rpdat_07(String cnt_rpdat_07) {
        this.cnt_rpdat_07 = cnt_rpdat_07;
    }

    /**
     * [KO] m8의 getter method 이다.<br>
     * [EN] It is a getter method of m8.<br>
     * [JP] <br>
     * 
     * @return the m8
     */
    public String getM8() {
        return m8;
    }

    /**
     * [KO] m8의 setter method 이다.<br>
     * [EN] It is a setter method of m8.<br>
     * [JP] <br>
     * 
     * @param m8 String
     */
    public void setM8(String m8) {
        this.m8 = m8;
    }

    /**
     * [KO] cnt_yedat_08의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_08.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_08
     */
    public String getCnt_yedat_08() {
        return cnt_yedat_08;
    }

    /**
     * [KO] cnt_yedat_08의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_08.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_08 String
     */
    public void setCnt_yedat_08(String cnt_yedat_08) {
        this.cnt_yedat_08 = cnt_yedat_08;
    }

    /**
     * [KO] cnt_rpdat_08의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_08.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_08
     */
    public String getCnt_rpdat_08() {
        return cnt_rpdat_08;
    }

    /**
     * [KO] cnt_rpdat_08의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_08.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_08 String
     */
    public void setCnt_rpdat_08(String cnt_rpdat_08) {
        this.cnt_rpdat_08 = cnt_rpdat_08;
    }

    /**
     * [KO] m9의 getter method 이다.<br>
     * [EN] It is a getter method of m9.<br>
     * [JP] <br>
     * 
     * @return the m9
     */
    public String getM9() {
        return m9;
    }

    /**
     * [KO] m9의 setter method 이다.<br>
     * [EN] It is a setter method of m9.<br>
     * [JP] <br>
     * 
     * @param m9 String
     */
    public void setM9(String m9) {
        this.m9 = m9;
    }

    /**
     * [KO] cnt_yedat_09의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_09.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_09
     */
    public String getCnt_yedat_09() {
        return cnt_yedat_09;
    }

    /**
     * [KO] cnt_yedat_09의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_09.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_09 String
     */
    public void setCnt_yedat_09(String cnt_yedat_09) {
        this.cnt_yedat_09 = cnt_yedat_09;
    }

    /**
     * [KO] cnt_rpdat_09의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_09.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_09
     */
    public String getCnt_rpdat_09() {
        return cnt_rpdat_09;
    }

    /**
     * [KO] cnt_rpdat_09의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_09.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_09 String
     */
    public void setCnt_rpdat_09(String cnt_rpdat_09) {
        this.cnt_rpdat_09 = cnt_rpdat_09;
    }

    /**
     * [KO] m10의 getter method 이다.<br>
     * [EN] It is a getter method of m10.<br>
     * [JP] <br>
     * 
     * @return the m10
     */
    public String getM10() {
        return m10;
    }

    /**
     * [KO] m10의 setter method 이다.<br>
     * [EN] It is a setter method of m10.<br>
     * [JP] <br>
     * 
     * @param m10 String
     */
    public void setM10(String m10) {
        this.m10 = m10;
    }

    /**
     * [KO] cnt_yedat_10의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_10.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_10
     */
    public String getCnt_yedat_10() {
        return cnt_yedat_10;
    }

    /**
     * [KO] cnt_rpdat_10의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_10.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_10 String
     */
    public void setCnt_yedat_10(String cnt_yedat_10) {
        this.cnt_yedat_10 = cnt_yedat_10;
    }

    /**
     * [KO] cnt_rpdat_10의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_10.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_10
     */
    public String getCnt_rpdat_10() {
        return cnt_rpdat_10;
    }

    /**
     * [KO] cnt_rpdat_10의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_10.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_10 String
     */
    public void setCnt_rpdat_10(String cnt_rpdat_10) {
        this.cnt_rpdat_10 = cnt_rpdat_10;
    }

    /**
     * [KO] m11의 getter method 이다.<br>
     * [EN] It is a getter method of m11.<br>
     * [JP] <br>
     * 
     * @return the m11
     */
    public String getM11() {
        return m11;
    }

    /**
     * [KO] m11의 setter method 이다.<br>
     * [EN] It is a setter method of m11.<br>
     * [JP] <br>
     * 
     * @param m11 String
     */
    public void setM11(String m11) {
        this.m11 = m11;
    }

    /**
     * [KO] cnt_yedat_11의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_11.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_11
     */
    public String getCnt_yedat_11() {
        return cnt_yedat_11;
    }

    /**
     * [KO] cnt_yedat_11의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_11.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_11 String
     */
    public void setCnt_yedat_11(String cnt_yedat_11) {
        this.cnt_yedat_11 = cnt_yedat_11;
    }

    /**
     * [KO] cnt_rpdat_11의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_11.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_11
     */
    public String getCnt_rpdat_11() {
        return cnt_rpdat_11;
    }

    /**
     * [KO] cnt_rpdat_11의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_11.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_11 String
     */
    public void setCnt_rpdat_11(String cnt_rpdat_11) {
        this.cnt_rpdat_11 = cnt_rpdat_11;
    }
    
    /**
     * [KO] m12의 getter method 이다.<br>
     * [EN] It is a getter method of m12.<br>
     * [JP] <br>
     * 
     * @return the m12
     */
    public String getM12() {
        return m12;
    }

    /**
     * [KO] m12의 setter method 이다.<br>
     * [EN] It is a setter method of m12.<br>
     * [JP] <br>
     * 
     * @param m12 String
     */
    public void setM12(String m12) {
        this.m12 = m12;
    }

    /**
     * [KO] cnt_yedat_12의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_12.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_12
     */
    public String getCnt_yedat_12() {
        return cnt_yedat_12;
    }

    /**
     * [KO] cnt_yedat_12의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_12.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_12 String
     */
    public void setCnt_yedat_12(String cnt_yedat_12) {
        this.cnt_yedat_12 = cnt_yedat_12;
    }

    /**
     * [KO] cnt_rpdat_12의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_12.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_12
     */
    public String getCnt_rpdat_12() {
        return cnt_rpdat_12;
    }
    
    /**
     * [KO] cnt_rpdat_12의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_12.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_12 String
     */
    public void setCnt_rpdat_12(String cnt_rpdat_12) {
        this.cnt_rpdat_12 = cnt_rpdat_12;
    }

    /**
     * [KO] m1의 getter method 이다.<br>
     * [EN] It is a getter method of m1.<br>
     * [JP] <br>
     * 
     * @return the m1
     */
    public String getM1() {
        return m1;
    }

    /**
     * [KO] m1의 setter method 이다.<br>
     * [EN] It is a setter method of m1.<br>
     * [JP] <br>
     * 
     * @param m1 String
     */
    public void setM1(String m1) {
        this.m1 = m1;
    }

    /**
     * [KO] cnt_yedat_01의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_01.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_01
     */
    public String getCnt_yedat_01() {
        return cnt_yedat_01;
    }

    /**
     * [KO] cnt_yedat_01의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_01.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_01 String
     */
    public void setCnt_yedat_01(String cnt_yedat_01) {
        this.cnt_yedat_01 = cnt_yedat_01;
    }

    /**
     * [KO] cnt_rpdat_01의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_01.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_01
     */
    public String getCnt_rpdat_01() {
        return cnt_rpdat_01;
    }

    /**
     * [KO] cnt_rpdat_01의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_01.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_01 String
     */
    public void setCnt_rpdat_01(String cnt_rpdat_01) {
        this.cnt_rpdat_01 = cnt_rpdat_01;
    }

    /**
     * [KO] m2의 getter method 이다.<br>
     * [EN] It is a getter method of m2.<br>
     * [JP] <br>
     * 
     * @return the m2
     */
    public String getM2() {
        return m2;
    }

    /**
     * [KO] m2의 setter method 이다.<br>
     * [EN] It is a setter method of m2.<br>
     * [JP] <br>
     * 
     * @param m2 String
     */
    public void setM2(String m2) {
        this.m2 = m2;
    }

    /**
     * [KO] cnt_yedat_02의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_02.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_02
     */
    public String getCnt_yedat_02() {
        return cnt_yedat_02;
    }

    /**
     * [KO] cnt_yedat_02의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_02.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_02 String
     */
    public void setCnt_yedat_02(String cnt_yedat_02) {
        this.cnt_yedat_02 = cnt_yedat_02;
    }

    /**
     * [KO] cnt_rpdat_02의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_02.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_02
     */
    public String getCnt_rpdat_02() {
        return cnt_rpdat_02;
    }

    /**
     * [KO] cnt_rpdat_02의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_02.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_02 String
     */
    public void setCnt_rpdat_02(String cnt_rpdat_02) {
        this.cnt_rpdat_02 = cnt_rpdat_02;
    }

    /**
     * [KO] m3의 getter method 이다.<br>
     * [EN] It is a getter method of m3.<br>
     * [JP] <br>
     * 
     * @return the m3
     */
    public String getM3() {
        return m3;
    }

    /**
     * [KO] m3의 setter method 이다.<br>
     * [EN] It is a setter method of m3.<br>
     * [JP] <br>
     * 
     * @param m3 String
     */
    public void setM3(String m3) {
        this.m3 = m3;
    }

    /**
     * [KO] cnt_yedat_03의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_yedat_03.<br>
     * [JP] <br>
     * 
     * @return the cnt_yedat_03
     */
    public String getCnt_yedat_03() {
        return cnt_yedat_03;
    }

    /**
     * [KO] cnt_yedat_03의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_yedat_03.<br>
     * [JP] <br>
     * 
     * @param cnt_yedat_03 String
     */
    public void setCnt_yedat_03(String cnt_yedat_03) {
        this.cnt_yedat_03 = cnt_yedat_03;
    }

    /**
     * [KO] cnt_rpdat_03의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_rpdat_03.<br>
     * [JP] <br>
     * 
     * @return the cnt_rpdat_03
     */
    public String getCnt_rpdat_03() {
        return cnt_rpdat_03;
    }

    /**
     * [KO] cnt_rpdat_03의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_rpdat_03.<br>
     * [JP] <br>
     * 
     * @param cnt_rpdat_03 String
     */
    public void setCnt_rpdat_03(String cnt_rpdat_03) {
        this.cnt_rpdat_03 = cnt_rpdat_03;
    }

    /**
     * [KO] cnt_total의 getter method 이다.<br>
     * [EN] It is a getter method of cnt_total.<br>
     * [JP] <br>
     * 
     * @return the cnt_total
     */
    public String getCnt_total() {
        return cnt_total;
    }

    /**
     * [KO] cnt_total의 setter method 이다.<br>
     * [EN] It is a setter method of cnt_total.<br>
     * [JP] <br>
     * 
     * @param cnt_total String
     */
    public void setCnt_total(String cnt_total) {
        this.cnt_total = cnt_total;
    }

    /**
     * [KO] 사업부 코드 getter 메소드이다 
     * [EN] It is a getter method of comps.<br>
     * [JP] <br>
     * 
     * @return the comps
     */
    public String getComps() {
        return comps;
    }

    /**
     * [KO] 사업부 코드 setter 메소드이다 
     * [EN] It is a setter method of comps.<br>
     * [JP] <br>
     * 
     * @param comps String
     */ 
    public void setComps(String comps) {
        this.comps = comps;
    }
    
    /**
     * [KO] 교정구분 getter 메소드이다 
     * [EN] It is a getter method of g_gub.<br>
     * [JP] <br>
     * 
     * @return the g_gub
     */
    public String getG_gub() {
        return g_gub;
    }

    /**
     * [KO] 교정구분 setter 메소드이다 
     * [EN] It is a setter method of g_gub.<br>
     * [JP] <br>
     * 
     * @param g_gub String
     */ 
    public void setG_gub(String g_gub) {
        this.g_gub = g_gub;
    }
    
    /**
     * [KO] 추가 쿼리문 getter 메소드이다 
     * [EN] It is a getter method of strval.<br>
     * [JP] <br>
     * 
     * @return the strval
     */
    public String getStrval() {
        return strval;
    }

    /**
     * [KO] 추가 쿼리문 setter 메소드이다 
     * [EN] It is a setter method of strval.<br>
     * [JP] <br>
     * 
     * @param strval String
     */ 
    public void setStrval(String strval) {
        this.strval = strval;
    }
    
    /**
     * [EN] It is a getter method of lib1.<br>
     * [JP] <br>
     * 
     * @return the lib1
     */
    public String getLib1() {
        return lib1;
    }

    /**
     * [EN] It is a setter method of lib1.<br>
     * [JP] <br>
     * 
     * @param lib1 String
     */ 
    public void setLib1(String lib1) {
        this.lib1 = lib1;
    }

    /**
     * [EN] It is a getter method of lib2.<br>
     * [JP] <br>
     * 
     * @return the lib2
     */
    public String getLib2() {
        return lib2;
    }

    /**
     * [EN] It is a setter method of lib2.<br>
     * [JP] <br>
     * 
     * @param lib2 String
     */ 
    public void setLib2(String lib2) {
        this.lib2 = lib2;
    }

    /**
     * [EN] It is a getter method of lib3.<br>
     * [JP] <br>
     * 
     * @return the lib3
     */
    public String getLib3() {
        return lib3;
    }

    /**
     * [EN] It is a setter method of lib3.<br>
     * [JP] <br>
     * 
     * @param lib3 String
     */     
    public void setLib3(String lib3) {
        this.lib3 = lib3;
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("timnm", this.timnm);
        jsonObj.put("prtnm", this.prtnm);
        jsonObj.put("cnt_jnbno_08", this.cnt_jnbno_08);
        jsonObj.put("cnt_jnbno_04", this.cnt_jnbno_04);
        jsonObj.put("cnt_jnbno_05", this.cnt_jnbno_05);
        jsonObj.put("cnt_jnbno_02", this.cnt_jnbno_02);
        jsonObj.put("cnt_jnbno_03", this.cnt_jnbno_03);
        jsonObj.put("cnt_jnbno_15", this.cnt_jnbno_15);
        jsonObj.put("cnt_jnbno_11", this.cnt_jnbno_11);
        jsonObj.put("cnt_jnbno_09", this.cnt_jnbno_09);
        jsonObj.put("cnt_jnbno_06", this.cnt_jnbno_06);
        jsonObj.put("cnt_jnbno_01", this.cnt_jnbno_01);
        jsonObj.put("cnt_jnbno_16", this.cnt_jnbno_16);
        jsonObj.put("cnt_jnbno_17", this.cnt_jnbno_17);
        jsonObj.put("cnt_jnbno_14", this.cnt_jnbno_14);
        jsonObj.put("cnt_jnbno_total", this.cnt_jnbno_total);
        jsonObj.put("m4", this.m4);
        jsonObj.put("cnt_yedat_04", this.cnt_yedat_04);
        jsonObj.put("cnt_rpdat_04", this.cnt_rpdat_04);
        jsonObj.put("m5", this.m5);
        jsonObj.put("cnt_yedat_05", this.cnt_yedat_05);
        jsonObj.put("cnt_rpdat_05", this.cnt_rpdat_05);
        jsonObj.put("m6", this.m6);
        jsonObj.put("cnt_yedat_06", this.cnt_yedat_06);
        jsonObj.put("cnt_rpdat_06", this.cnt_rpdat_06);
        jsonObj.put("m7", this.m7);
        jsonObj.put("cnt_yedat_07", this.cnt_yedat_07);
        jsonObj.put("cnt_rpdat_07", this.cnt_rpdat_07);
        jsonObj.put("m8", this.m8);
        jsonObj.put("cnt_yedat_08", this.cnt_yedat_08);
        jsonObj.put("cnt_rpdat_08", this.cnt_rpdat_08);
        jsonObj.put("m9", this.m9);
        jsonObj.put("cnt_yedat_09", this.cnt_yedat_09);
        jsonObj.put("cnt_rpdat_09", this.cnt_rpdat_09);
        jsonObj.put("m10", this.m10);
        jsonObj.put("cnt_yedat_10", this.cnt_yedat_10);
        jsonObj.put("cnt_rpdat_10", this.cnt_rpdat_10);
        jsonObj.put("m11", this.m11);
        jsonObj.put("cnt_yedat_11", this.cnt_yedat_11);
        jsonObj.put("cnt_rpdat_11", this.cnt_rpdat_11);
        jsonObj.put("m12", this.m12);
        jsonObj.put("cnt_yedat_12", this.cnt_yedat_12);
        jsonObj.put("cnt_rpdat_12", this.cnt_rpdat_12);
        jsonObj.put("m1", this.m1);
        jsonObj.put("cnt_yedat_01", this.cnt_yedat_01);
        jsonObj.put("cnt_rpdat_01", this.cnt_rpdat_01);
        jsonObj.put("m2", this.m2);
        jsonObj.put("cnt_yedat_02", this.cnt_yedat_02);
        jsonObj.put("cnt_rpdat_02", this.cnt_rpdat_02);
        jsonObj.put("m3", this.m3);
        jsonObj.put("cnt_yedat_03", this.cnt_yedat_03);
        jsonObj.put("cnt_rpdat_03", this.cnt_rpdat_03);
        jsonObj.put("cnt_total", this.cnt_total);
        jsonObj.put("comps", this.comps);
        jsonObj.put("g_gub", this.g_gub);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
