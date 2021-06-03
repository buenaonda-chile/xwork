package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class DWHManagemetDomain implements Serializable {
  
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
     * 
     */
    private String clsCode;
    /**
     * 
     */
    private String locCode;
    /**
     * 
     */
    private String clsName;
    /**
     * 
     */
    private String locName;
    
    
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
    

    
    //=====================Material Cost
    /**
     * [KO] 조회기간FR<br>
     * [EN] <br>
     * [JP] <br>
     */
     private String yearFr;
     /**
      * [KO] 조회기간TO<br>
      * [EN] <br>
      * [JP] <br>
      */
      private String yearTo;
      
    /**
    * [KO] 번호<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String seqNo;
    
    /**
     * [KO] 업체코드<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pyvnd;
    
    /**
     * [KO] 품번<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pspno;
    
    /**
     * [KO] 품명<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String itdsc;
    
    /**
     * [KO] 차종<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String carnm;
    
    /**
     * [KO] 년계획단가<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String yearPcost;
    
    /**
     * [KO] 현단가<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String price;
    
    /**
     * [KO] 원재료<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String krsur;
    
    /**
     * [KO] 원재료(KR)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String surkr;
    
    /**
     * [KO] 원재료(US)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String surus;
    
    /**
     * [KO] 원재료(JP)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String surjp;
    
    /**
     * [KO] 원재료(UR)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String surur;
    
    /**
     * [KO] 구매품(UR)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String krpur;
    
    /**
     * [KO] 구매품(KD)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String krckd;
    
    /**
     * [KO] CKD(US)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String ckdus;
    
    /**
     * [KO] CKD(JR)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String ckdjp;
    
    /**
     * [KO] CKD(UR)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String ckdur;
    
    /**
     * [KO] CKD(KR)<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String ckdkr;
    
    /**
     * [KO] 4월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty04;
    
    /**
     * [KO] 5월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty05;
    
    /**
     * [KO] 6월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty06;
    
    /**
     * [KO] 7월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty07;
    
    /**
     * [KO] 8월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty08;
    
    /**
     * [KO] 9월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty09;
    
    /**
     * [KO] 10월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty10;
    
    /**
     * [KO] 11월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty11;
    
    /**
     * [KO] 12월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty12;
    
    /**
     * [KO] 1월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty01;
    
    /**
     * [KO] 2월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty02;
    
    /**
     * [KO] 3월수량<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String qty03;
    
    
    //SalesPerformance 항목 추가
    /**
     * [KO] 제품<br>
     * [EN] <br>
     * [JP] <br>
     */
    
    /**
    * MaterialReceiving        
    */     
   private String comps;       
   /**     
    *      
    */     
   private String house;       
   /**     
    *      
    */     
   private String vndnr;       
   /**     
    *      
    */     
   private String vname;       
   /**     
    *      
    */     
   /*      
   private String pspno;       
   */      
   /**     
    *      
    */     
   /*      
   private String itdsc;       
   */      
   /**     
    *      
    */
   /*
   private String ittyp;
   */       
   /**     
    *      
    */     
   private String itcls;       
   /**     
    *      
    */     
   private String prdgu;       
   /**     
    *      
    */     
   private String prdcd;       
   /**     
    *      
    */     
   private String supgu;       
   /**     
    *      
    */     
   private String trcst;       
   /**     
    *      
    */     
   private String crcyw;       
   /**     
    *      
    */     
   private String trfot;       
   /**     
    *      
    */     
   private String month1;      
   /**     
    *      
    */     
   private String month2;      
   /**     
    *      
    */     
   private String month3;      
   /**     
    *      
    */     
   private String month4;      
   /**     
    *      
    */     
   private String month5;      
   /**     
    *      
    */     
   private String month6;      
   /**     
    *      
    */     
   private String month7;      
   /**     
    *      
    */     
   private String month8;      
   /**     
    *      
    */     
   private String month9;      
   /**     
    *      
    */     
   private String month10;     
   /**     
    *      
    */     
   private String month11;     
   /**     
    *      
    */     
   private String month12;     
   /**     
    * PurchasePrice        
    */     
   private String packc;       
   /**     
    *      
    */     
   private String recid;       
   /**     
    *      
    */     
   private String prtno;       
   /**     
    *      
    */     
   /*      
   private String itdsc;       
   */      
   /**     
    *      
    */     
   private String spcod;       
   /**     
    *      
    */     
   /*      
   private String vname;       
   */      
   /**     
    *      
   */
   /*
   private String unmsr;
   */       
   /**     
    *      
    */     
   /*      
   private String itcls;       
   */      
   /**     
    *      
    */     
   /*      
   private String ittyp;       
   */      
   /**     
    *      
    */     
   private String crcye;       
   /**     
    *      
    */     
   private String tempe;       
   /**     
    *      
    */     
   private String resne;       
   /**     
    *      
    */     
   private String prcee;       
   /**     
    *      
    */     
   private String edate;       
   /**     
    * StandardCost     
    */     
   /*      
   private String prtno;       
   */      
   /**     
    *      
    */     
   private String procd;       
   /**     
    *      
    */     
   private String mnfcs;       
   /**     
    *      
    */     
   private String dircs;       
   /**     
    *      
    */     
   private String mcost;       
   /**     
    *      
    */     
   private String rmatc;       
   /**     
    *      
    */     
   private String rmatl;       
   /**     
    *      
    */     
   private String rmati;       
   /**     
    *      
    */     
   private String rmimc;       
   /**     
    *      
    */     
   private String purcs;       
   /**     
    *      
    */     
   private String purcl;       
   /**     
    *      
    */     
   private String purci;       
   /**     
    *      
    */     
   private String ppimc;       
   /**     
    *      
    */     
   private String prcst;       
   /**     
    *      
    */     
   private String labcs;       
   /**     
    *      
    */     
   private String depcs;       
   /**     
    *      
    */     
   private String mfexp;       
   /**     
    *      
    */     
   private String diecs;       
   /**     
    *      
    */     
   private String mohcs;       
   /**     
    *      
    */     
   private String fixdt;       
   /**     
    *      
    */     
   private String rcomp;       
   /**     
    *      
    */     
   private String brmtl;       
   /**     
    *      
    */     
   private String brmti;       
   /**     
    *      
    */     
   private String brmic;       
   /**     
    *      
    */     
   private String bpurl;       
   /**     
    *      
    */     
   private String bpuri;       
   /**     
    *      
    */     
   private String bppic;       
   /**     
    *      
    */     
   private String blabc;       
   /**     
    *      
    */     
   private String bdepc;       
   /**     
    *      
    */     
   private String bmexp;       
   /**     
    *      
    */     
   private String bdiec;       
   /**     
    *      
    */     
   private String ocean;       
   /**     
    *      
    */     
   private String insdt;       
   /**     
    *      
    */     
   /*      
   private String itdsc;       
   */      
   /**     
    
    private String itcls;
    
    /**
     * [KO] 업체명<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cusnm;
    
    /**
     * [KO] 단가<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost;
    
    /**
     * [KO] 급액01<br>
     * [EN] <br>
     * [JP] <br>
     */    
    private String amount01;
    
    /**
     * [KO] 급액02<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount02;
    
    /**
     * [KO] 급액03<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount03;
    
    /**
     * [KO] 급액04<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount04;
    
    /**
     * [KO] 급액05<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount05;
    
    /**
     * [KO] 급액06<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount06;
    
    /**
     * [KO] 급액07<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount07;
    
    /**
     * [KO] 급액08<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount08;
    
    /**
     * [KO] 급액09<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount09;
    
    /**
     * [KO] 급액10<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount10;
    
    /**
     * [KO] 급액11<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount11;
    
    /**
     * [KO] 급액12<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String amount12;

    
    /**
     * [KO] 12개월<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private HashMap<String, String> searchDate;
    

    //기간별 실적대 재료비현황 
    
    //private String pyvnd;
    private String procs;
    //private String pspno;
    private String edatm;
    //private String price;
    private String unmsr;
    private String ittyp;
    //private String itdsc;
    //private String krsur;
    //private String surkr;
    //private String surus;
    //private String surjp;
    //private String surur;
    //private String krpur;
    //private String krckd;
    //private String ckdus;
    //private String ckdjp;
    //private String ckdur;
    //private String ckdkr;
    private String krpat;
	private String krcot;
	private String mchmu;
	private String mager;
	private String hndtm;
	private String drman;
	private String sbman;
	private String drmch;
	private String sbmch;
	private String epckd;
	private String dangu;
	private String danst;
	private String dandt;
	private String crtdt;
	private String chgdt;
	private String prtqy;
	
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public DWHManagemetDomain() {
        // no process
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
     * @return rowCnt
     */
    public int getRowCnt() {
        return rowCnt;
    }
    /**
     * @param rowCnt int
     */
    public void setRowCnt(int rowCnt) {
        this.rowCnt = rowCnt;
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
     * @return startDate
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
     * @return endDate
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
    
  
    public String getYearFr() {
		return yearFr;
	}
	public void setYearFr(String yearFr) {
		this.yearFr = yearFr;
	}
	public String getYearTo() {
		return yearTo;
	}
	public void setYearTo(String yearTo) {
		this.yearTo = yearTo;
	}
	/**
     * @return seqNo
     */
    public String getSeqNo() {
        return seqNo;
    }
    /**
     * @param seqNo String
     */
    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }
    /**
     * @return pyvnd
     */
    public String getPyvnd() {
        return pyvnd;
    }
    /**
     * @param pyvnd String
     */
    public void setPyvnd(String pyvnd) {
        this.pyvnd = pyvnd;
    }
    /**
     * @return pspno
     */
    public String getPspno() {
        return pspno;
    }
    /**
     * @param pspno String
     */
    public void setPspno(String pspno) {
        this.pspno = pspno;
    }
    /**
     * @return itdsc
     */
    public String getItdsc() {
        return itdsc;
    }
    /**
     * @param itdsc String
     */
    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    /**
     * @return carnm
     */
    public String getCarnm() {
        return carnm;
    }
    /**
     * @param carnm String
     */
    public void setCarnm(String carnm) {
        this.carnm = carnm;
    }
    /**
     * @return yearPcost
     */
    public String getYearPcost() {
        return yearPcost;
    }
    /**
     * @param yearPcost String
     */
    public void setYearPcost(String yearPcost) {
        this.yearPcost = yearPcost;
    }
    /**
     * @return price
     */
    public String getPrice() {
        return price;
    }
    /**
     * @param price String
     */
    public void setPrice(String price) {
        this.price = price;
    }
    /**
     * @return krsur
     */
    public String getKrsur() {
        return krsur;
    }
    /**
     * @param krsur String
     */
    public void setKrsur(String krsur) {
        this.krsur = krsur;
    }
    /**
     * @return surkr
     */
    public String getSurkr() {
        return surkr;
    }
    /**
     * @param surkr String
     */
    public void setSurkr(String surkr) {
        this.surkr = surkr;
    }
    /**
     * @return surus
     */
    public String getSurus() {
        return surus;
    }
    /**
     * @param surus String
     */
    public void setSurus(String surus) {
        this.surus = surus;
    }
    /**
     * @return surjp
     */
    public String getSurjp() {
        return surjp;
    }
    /**
     * @param surjp String
     */
    public void setSurjp(String surjp) {
        this.surjp = surjp;
    }
    /**
     * @return surur
     */
    public String getSurur() {
        return surur;
    }
    /**
     * @param surur String
     */
    public void setSurur(String surur) {
        this.surur = surur;
    }
    /**
     * @return krpur
     */
    public String getKrpur() {
        return krpur;
    }
    /**
     * @param krpur String
     */
    public void setKrpur(String krpur) {
        this.krpur = krpur;
    }
    /**
     * @return krckd
     */
    public String getKrckd() {
        return krckd;
    }
    /**
     * @param krckd String
     */
    public void setKrckd(String krckd) {
        this.krckd = krckd;
    }
    /**
     * @return ckdus
     */
    public String getCkdus() {
        return ckdus;
    }
    /**
     * @param ckdus String
     */
    public void setCkdus(String ckdus) {
        this.ckdus = ckdus;
    }
    /**
     * @return ckdjp
     */
    public String getCkdjp() {
        return ckdjp;
    }
    /**
     * @param ckdjp String
     */
    public void setCkdjp(String ckdjp) {
        this.ckdjp = ckdjp;
    }
    /**
     * @return ckdur
     */
    public String getCkdur() {
        return ckdur;
    }
    /**
     * @param ckdur String
     */
    public void setCkdur(String ckdur) {
        this.ckdur = ckdur;
    }
    /**
     * @return ckdkr
     */
    public String getCkdkr() {
        return ckdkr;
    }
    /**
     * @param ckdkr String
     */
    public void setCkdkr(String ckdkr) {
        this.ckdkr = ckdkr;
    }
    /**
     * @return qty04
     */
    public String getQty04() {
        return qty04;
    }
    /**
     * @param qty04 String
     */
    public void setQty04(String qty04) {
        this.qty04 = qty04;
    }
    /**
     * @return qty05
     */
    public String getQty05() {
        return qty05;
    }
    /**
     * @param qty05 String
     */
    public void setQty05(String qty05) {
        this.qty05 = qty05;
    }
    /**
     * @return qty06
     */
    public String getQty06() {
        return qty06;
    }
    /**
     * @param qty06 String
     */
    public void setQty06(String qty06) {
        this.qty06 = qty06;
    }
    /**
     * @return qty07
     */
    public String getQty07() {
        return qty07;
    }
    /**
     * @param qty07 String
     */
    public void setQty07(String qty07) {
        this.qty07 = qty07;
    }
    /**
     * @return qty08
     */
    public String getQty08() {
        return qty08;
    }
    /**
     * @param qty08 String
     */
    public void setQty08(String qty08) {
        this.qty08 = qty08;
    }
    /**
     * @return qty09
     */
    public String getQty09() {
        return qty09;
    }
    /**
     * @param qty09 String
     */
    public void setQty09(String qty09) {
        this.qty09 = qty09;
    }
    /**
     * @return qty10
     */
    public String getQty10() {
        return qty10;
    }
    /**
     * @param qty10 String
     */
    public void setQty10(String qty10) {
        this.qty10 = qty10;
    }
    /**
     * @return qty11
     */
    public String getQty11() {
        return qty11;
    }
    /**
     * @param qty11 String
     */
    public void setQty11(String qty11) {
        this.qty11 = qty11;
    }
    /**
     * @return qty12
     */
    public String getQty12() {
        return qty12;
    }
    /**
     * @param qty12 String
     */
    public void setQty12(String qty12) {
        this.qty12 = qty12;
    }
    /**
     * @return qty01
     */
    public String getQty01() {
        return qty01;
    }
    /**
     * @param qty01 String
     */
    public void setQty01(String qty01) {
        this.qty01 = qty01;
    }
    /**
     * @return qty02
     */
    public String getQty02() {
        return qty02;
    }
    /**
     * @param qty02 String
     */
    public void setQty02(String qty02) {
        this.qty02 = qty02;
    }
    /**
     * @return qty03
     */
    public String getQty03() {
        return qty03;
    }
    /**
     * @param qty03 String
     */
    public void setQty03(String qty03) {
        this.qty03 = qty03;
    }
    /**     
     * comps のゲッターメソッドです。       
     *      
     * @return the comps        
     */     
    public String getComps() {      
        return comps;       
    }       
    /**     
     * comps のセッターメソッドです。       
     *      
     * @param comps comps に設定する     
     */     
    public void setComps(String comps) {        
        this.comps = comps;     
    }       
    /**     
     * house のゲッターメソッドです。       
     *      
     * @return the house        
     */     
    public String getHouse() {      
        return house;       
    }       
    /**     
     * house のセッターメソッドです。       
     *      
     * @param house house に設定する     
     */     
    public void setHouse(String house) {        
        this.house = house;     
    }       
    /**     
     * vndnr のゲッターメソッドです。       
     *      
     * @return the vndnr        
     */     
    public String getVndnr() {      
        return vndnr;       
    }       
    /**     
     * vndnr のセッターメソッドです。       
     *      
     * @param vndnr vndnr に設定する     
     */     
    public void setVndnr(String vndnr) {        
        this.vndnr = vndnr;     
    }       
    /**     
     * vname のゲッターメソッドです。       
     *      
     * @return the vname        
     */     
    public String getVname() {      
        return vname;       
    }       
    /**     
     * vname のセッターメソッドです。       
     *      
     * @param vname vname に設定する     
     */     
    public void setVname(String vname) {        
        this.vname = vname;     
    }       
    /**     
     * ittyp のゲッターメソッドです。       
     *      
     * @return the ittyp        
     */  
    /*
    public String getIttyp() {      
        return ittyp;       
    } 
    */      
    /**     
     * ittyp のセッターメソッドです。       
     *      
     * @param ittyp ittyp に設定する     
     */
    /*
    public void setIttyp(String ittyp) {        
        this.ittyp = ittyp;     
    } 
    */      
    /**     
     * itcls のゲッターメソッドです。       
     *      
     * @return the itcls        
     */    
    /*
    public String getItcls() {      
        return itcls;       
    } 
    */      
    /**     
     * itcls のセッターメソッドです。       
     *      
     * @param itcls itcls に設定する     
     */     
    /*
    public void setItcls(String itcls) {        
        this.itcls = itcls;     
    } 
    */      
    /**     
     * prdgu のゲッターメソッドです。       
     *      
     * @return the prdgu        
     */     
    public String getPrdgu() {      
        return prdgu;       
    }       
    /**     
     * prdgu のセッターメソッドです。       
     *      
     * @param prdgu prdgu に設定する     
     */     
    public void setPrdgu(String prdgu) {        
        this.prdgu = prdgu;     
    }       
    /**     
     * prdcd のゲッターメソッドです。       
     *      
     * @return the prdcd        
     */     
    public String getPrdcd() {      
        return prdcd;       
    }       
    /**     
     * prdcd のセッターメソッドです。       
     *      
     * @param prdcd prdcd に設定する     
     */     
    public void setPrdcd(String prdcd) {        
        this.prdcd = prdcd;     
    }       
    /**     
     * supgu のゲッターメソッドです。       
     *      
     * @return the supgu        
     */     
    public String getSupgu() {      
        return supgu;       
    }       
    /**     
     * supgu のセッターメソッドです。       
     *      
     * @param supgu supgu に設定する     
     */     
    public void setSupgu(String supgu) {        
        this.supgu = supgu;     
    }       
    /**     
     * trcst のゲッターメソッドです。       
     *      
     * @return the trcst        
     */     
    public String getTrcst() {      
        return trcst;       
    }       
    /**     
     * trcst のセッターメソッドです。       
     *      
     * @param trcst trcst に設定する     
     */     
    public void setTrcst(String trcst) {        
        this.trcst = trcst;     
    }       
    /**     
     * crcyw のゲッターメソッドです。       
     *      
     * @return the crcyw        
     */     
    public String getCrcyw() {      
        return crcyw;       
    }       
    /**     
     * crcyw のセッターメソッドです。       
     *      
     * @param crcyw crcyw に設定する     
     */     
    public void setCrcyw(String crcyw) {        
        this.crcyw = crcyw;     
    }       
    /**     
     * trfot のゲッターメソッドです。       
     *      
     * @return the trfot        
     */     
    public String getTrfot() {      
        return trfot;       
    }       
    /**     
     * trfot のセッターメソッドです。       
     *      
     * @param trfot trfot に設定する     
     */     
    public void setTrfot(String trfot) {        
        this.trfot = trfot;     
    }       
    /**     
     * month1 のゲッターメソッドです。      
     *      
     * @return the month1       
     */     
    public String getMonth1() {     
        return month1;      
    }       
    /**     
     * month1 のセッターメソッドです。      
     *      
     * @param month1 month1 に設定する       
     */     
    public void setMonth1(String month1) {      
        this.month1 = month1;       
    }       
    /**     
     * month2 のゲッターメソッドです。      
     *      
     * @return the month2       
     */     
    public String getMonth2() {     
        return month2;      
    }       
    /**     
     * month2 のセッターメソッドです。      
     *      
     * @param month2 month2 に設定する       
     */     
    public void setMonth2(String month2) {      
        this.month2 = month2;       
    }       
    /**     
     * month3 のゲッターメソッドです。      
     *      
     * @return the month3       
     */     
    public String getMonth3() {     
        return month3;      
    }       
    /**     
     * month3 のセッターメソッドです。      
     *      
     * @param month3 month3 に設定する       
     */     
    public void setMonth3(String month3) {      
        this.month3 = month3;       
    }       
    /**     
     * month4 のゲッターメソッドです。      
     *      
     * @return the month4       
     */     
    public String getMonth4() {     
        return month4;      
    }       
    /**     
     * month4 のセッターメソッドです。      
     *      
     * @param month4 month4 に設定する       
     */     
    public void setMonth4(String month4) {      
        this.month4 = month4;       
    }       
    /**     
     * month5 のゲッターメソッドです。      
     *      
     * @return the month5       
     */     
    public String getMonth5() {     
        return month5;      
    }       
    /**     
     * month5 のセッターメソッドです。      
     *      
     * @param month5 month5 に設定する       
     */     
    public void setMonth5(String month5) {      
        this.month5 = month5;       
    }       
    /**     
     * month6 のゲッターメソッドです。      
     *      
     * @return the month6       
     */     
    public String getMonth6() {     
        return month6;      
    }       
    /**     
     * month6 のセッターメソッドです。      
     *      
     * @param month6 month6 に設定する       
     */     
    public void setMonth6(String month6) {      
        this.month6 = month6;       
    }       
    /**     
     * month7 のゲッターメソッドです。      
     *      
     * @return the month7       
     */     
    public String getMonth7() {     
        return month7;      
    }       
    /**     
     * month7 のセッターメソッドです。      
     *      
     * @param month7 month7 に設定する       
     */     
    public void setMonth7(String month7) {      
        this.month7 = month7;       
    }       
    /**     
     * month8 のゲッターメソッドです。      
     *      
     * @return the month8       
     */     
    public String getMonth8() {     
        return month8;      
    }       
    /**     
     * month8 のセッターメソッドです。      
     *      
     * @param month8 month8 に設定する       
     */     
    public void setMonth8(String month8) {      
        this.month8 = month8;       
    }       
    /**     
     * month9 のゲッターメソッドです。      
     *      
     * @return the month9       
     */     
    public String getMonth9() {     
        return month9;      
    }       
    /**     
     * month9 のセッターメソッドです。      
     *      
     * @param month9 month9 に設定する       
     */     
    public void setMonth9(String month9) {      
        this.month9 = month9;       
    }       
    /**     
     * month10 のゲッターメソッドです。     
     *      
     * @return the month10      
     */     
    public String getMonth10() {        
        return month10;     
    }       
    /**     
     * month10 のセッターメソッドです。     
     *      
     * @param month10 month10 に設定する     
     */     
    public void setMonth10(String month10) {        
        this.month10 = month10;     
    }       
    /**     
     * month11 のゲッターメソッドです。     
     *      
     * @return the month11      
     */     
    public String getMonth11() {        
        return month11;     
    }       
    /**     
     * month11 のセッターメソッドです。     
     *      
     * @param month11 month11 に設定する     
     */     
    public void setMonth11(String month11) {        
        this.month11 = month11;     
    }       
    /**     
     * month12 のゲッターメソッドです。     
     *      
     * @return the month12      
     */     
    public String getMonth12() {        
        return month12;     
    }       
    /**     
     * month12 のセッターメソッドです。     
     *      
     * @param month12 month12 に設定する     
     */     
    public void setMonth12(String month12) {        
        this.month12 = month12;     
    }       
    /**     
     * packc のゲッターメソッドです。       
     *      
     * @return the packc        
     */     
    public String getPackc() {      
        return packc;       
    }       
    /**     
     * packc のセッターメソッドです。       
     *      
     * @param packc packc に設定する     
     */     
    public void setPackc(String packc) {        
        this.packc = packc;     
    }       
    /**     
     * recid のゲッターメソッドです。       
     *      
     * @return the recid        
     */     
    public String getRecid() {      
        return recid;       
    }       
    /**     
     * recid のセッターメソッドです。       
     *      
     * @param recid recid に設定する     
     */     
    public void setRecid(String recid) {        
        this.recid = recid;     
    }       
    /**     
     * prtno のゲッターメソッドです。       
     *      
     * @return the prtno        
     */     
    public String getPrtno() {      
        return prtno;       
    }       
    /**     
     * prtno のセッターメソッドです。       
     *      
     * @param prtno prtno に設定する     
     */     
    public void setPrtno(String prtno) {        
        this.prtno = prtno;     
    }       
    /**     
     * spcod のゲッターメソッドです。       
     *      
     * @return the spcod        
     */     
    public String getSpcod() {      
        return spcod;       
    }       
    /**     
     * spcod のセッターメソッドです。       
     *      
     * @param spcod spcod に設定する     
     */     
    public void setSpcod(String spcod) {        
        this.spcod = spcod;     
    }       
    /**     
     * unmsr のゲッターメソッドです。       
     *      
     * @return the unmsr        
     */     
    /*
    public String getUnmsr() {      
        return unmsr;       
    }       
    */
    /**     
     * unmsr のセッターメソッドです。       
     *      
     * @param unmsr unmsr に設定する     
     */     
    /*
    public void setUnmsr(String unmsr) {        
        this.unmsr = unmsr;     
    }       
    */
    /**     
     * crcye のゲッターメソッドです。       
     *      
     * @return the crcye        
     */     
    public String getCrcye() {      
        return crcye;       
    }       
    /**     
     * crcye のセッターメソッドです。       
     *      
     * @param crcye crcye に設定する     
     */     
    public void setCrcye(String crcye) {        
        this.crcye = crcye;     
    }       
    /**     
     * tempe のゲッターメソッドです。       
     *      
     * @return the tempe        
     */     
    public String getTempe() {      
        return tempe;       
    }       
    /**     
     * tempe のセッターメソッドです。       
     *      
     * @param tempe tempe に設定する     
     */     
    public void setTempe(String tempe) {        
        this.tempe = tempe;     
    }       
    /**     
     * resne のゲッターメソッドです。       
     *      
     * @return the resne        
     */     
    public String getResne() {      
        return resne;       
    }       
    /**     
     * resne のセッターメソッドです。       
     *      
     * @param resne resne に設定する     
     */     
    public void setResne(String resne) {        
        this.resne = resne;     
    }       
    /**     
     * prcee のゲッターメソッドです。       
     *      
     * @return the prcee        
     */     
    public String getPrcee() {      
        return prcee;       
    }       
    /**     
     * prcee のセッターメソッドです。       
     *      
     * @param prcee prcee に設定する     
     */     
    public void setPrcee(String prcee) {        
        this.prcee = prcee;     
    }       
    /**     
     * edate のゲッターメソッドです。       
     *      
     * @return the edate        
     */     
    public String getEdate() {      
        return edate;       
    }       
    /**     
     * edate のセッターメソッドです。       
     *      
     * @param edate edate に設定する     
     */     
    public void setEdate(String edate) {        
        this.edate = edate;     
    }       
    /**     
     * procd のゲッターメソッドです。       
     *      
     * @return the procd        
     */     
    public String getProcd() {      
        return procd;       
    }       
    /**     
     * procd のセッターメソッドです。       
     *      
     * @param procd procd に設定する     
     */     
    public void setProcd(String procd) {        
        this.procd = procd;     
    }       
    /**     
     * mnfcs のゲッターメソッドです。       
     *      
     * @return the mnfcs        
     */     
    public String getMnfcs() {      
        return mnfcs;       
    }       
    /**     
     * mnfcs のセッターメソッドです。       
     *      
     * @param mnfcs mnfcs に設定する     
     */     
    public void setMnfcs(String mnfcs) {        
        this.mnfcs = mnfcs;     
    }       
    /**     
     * dircs のゲッターメソッドです。       
     *      
     * @return the dircs        
     */     
    public String getDircs() {      
        return dircs;       
    }       
    /**     
     * dircs のセッターメソッドです。       
     *      
     * @param dircs dircs に設定する     
     */     
    public void setDircs(String dircs) {        
        this.dircs = dircs;     
    }       
    /**     
     * mcost のゲッターメソッドです。       
     *      
     * @return the mcost        
     */     
    public String getMcost() {      
        return mcost;       
    }       
    /**     
     * mcost のセッターメソッドです。       
     *      
     * @param mcost mcost に設定する     
     */     
    public void setMcost(String mcost) {        
        this.mcost = mcost;     
    }       
    /**     
     * rmatc のゲッターメソッドです。       
     *      
     * @return the rmatc        
     */     
    public String getRmatc() {      
        return rmatc;       
    }       
    /**     
     * rmatc のセッターメソッドです。       
     *      
     * @param rmatc rmatc に設定する     
     */     
    public void setRmatc(String rmatc) {        
        this.rmatc = rmatc;     
    }       
    /**     
     * rmatl のゲッターメソッドです。       
     *      
     * @return the rmatl        
     */     
    public String getRmatl() {      
        return rmatl;       
    }       
    /**     
     * rmatl のセッターメソッドです。       
     *      
     * @param rmatl rmatl に設定する     
     */     
    public void setRmatl(String rmatl) {        
        this.rmatl = rmatl;     
    }       
    /**     
     * rmati のゲッターメソッドです。       
     *      
     * @return the rmati        
     */     
    public String getRmati() {      
        return rmati;       
    }       
    /**     
     * rmati のセッターメソッドです。       
     *      
     * @param rmati rmati に設定する     
     */     
    public void setRmati(String rmati) {        
        this.rmati = rmati;     
    }       
    /**     
     * rmimc のゲッターメソッドです。       
     *      
     * @return the rmimc        
     */     
    public String getRmimc() {      
        return rmimc;       
    }       
    /**     
     * rmimc のセッターメソッドです。       
     *      
     * @param rmimc rmimc に設定する     
     */     
    public void setRmimc(String rmimc) {        
        this.rmimc = rmimc;     
    }       
    /**     
     * purcs のゲッターメソッドです。       
     *      
     * @return the purcs        
     */     
    public String getPurcs() {      
        return purcs;       
    }       
    /**     
     * purcs のセッターメソッドです。       
     *      
     * @param purcs purcs に設定する     
     */     
    public void setPurcs(String purcs) {        
        this.purcs = purcs;     
    }       
    /**     
     * purcl のゲッターメソッドです。       
     *      
     * @return the purcl        
     */     
    public String getPurcl() {      
        return purcl;       
    }       
    /**     
     * purcl のセッターメソッドです。       
     *      
     * @param purcl purcl に設定する     
     */     
    public void setPurcl(String purcl) {        
        this.purcl = purcl;     
    }       
    /**     
     * purci のゲッターメソッドです。       
     *      
     * @return the purci        
     */     
    public String getPurci() {      
        return purci;       
    }       
    /**     
     * purci のセッターメソッドです。       
     *      
     * @param purci purci に設定する     
     */     
    public void setPurci(String purci) {        
        this.purci = purci;     
    }       
    /**     
     * ppimc のゲッターメソッドです。       
     *      
     * @return the ppimc        
     */     
    public String getPpimc() {      
        return ppimc;       
    }       
    /**     
     * ppimc のセッターメソッドです。       
     *      
     * @param ppimc ppimc に設定する     
     */     
    public void setPpimc(String ppimc) {        
        this.ppimc = ppimc;     
    }       
    /**     
     * prcst のゲッターメソッドです。       
     *      
     * @return the prcst        
     */     
    public String getPrcst() {      
        return prcst;       
    }       
    /**     
     * prcst のセッターメソッドです。       
     *      
     * @param prcst prcst に設定する     
     */     
    public void setPrcst(String prcst) {        
        this.prcst = prcst;     
    }       
    /**     
     * labcs のゲッターメソッドです。       
     *      
     * @return the labcs        
     */     
    public String getLabcs() {      
        return labcs;       
    }       
    /**     
     * labcs のセッターメソッドです。       
     *      
     * @param labcs labcs に設定する     
     */     
    public void setLabcs(String labcs) {        
        this.labcs = labcs;     
    }       
    /**     
     * depcs のゲッターメソッドです。       
     *      
     * @return the depcs        
     */     
    public String getDepcs() {      
        return depcs;       
    }       
    /**     
     * depcs のセッターメソッドです。       
     *      
     * @param depcs depcs に設定する     
     */     
    public void setDepcs(String depcs) {        
        this.depcs = depcs;     
    }       
    /**     
     * mfexp のゲッターメソッドです。       
     *      
     * @return the mfexp        
     */     
    public String getMfexp() {      
        return mfexp;       
    }       
    /**     
     * mfexp のセッターメソッドです。       
     *      
     * @param mfexp mfexp に設定する     
     */     
    public void setMfexp(String mfexp) {        
        this.mfexp = mfexp;     
    }       
    /**     
     * diecs のゲッターメソッドです。       
     *      
     * @return the diecs        
     */     
    public String getDiecs() {      
        return diecs;       
    }       
    /**     
     * diecs のセッターメソッドです。       
     *      
     * @param diecs diecs に設定する     
     */     
    public void setDiecs(String diecs) {        
        this.diecs = diecs;     
    }       
    /**     
     * mohcs のゲッターメソッドです。       
     *      
     * @return the mohcs        
     */     
    public String getMohcs() {      
        return mohcs;       
    }       
    /**     
     * mohcs のセッターメソッドです。       
     *      
     * @param mohcs mohcs に設定する     
     */     
    public void setMohcs(String mohcs) {        
        this.mohcs = mohcs;     
    }       
    /**     
     * fixdt のゲッターメソッドです。       
     *      
     * @return the fixdt        
     */     
    public String getFixdt() {      
        return fixdt;       
    }       
    /**     
     * fixdt のセッターメソッドです。       
     *      
     * @param fixdt fixdt に設定する     
     */     
    public void setFixdt(String fixdt) {        
        this.fixdt = fixdt;     
    }       
    /**     
     * rcomp のゲッターメソッドです。       
     *      
     * @return the rcomp        
     */     
    public String getRcomp() {      
        return rcomp;       
    }       
    /**     
     * rcomp のセッターメソッドです。       
     *      
     * @param rcomp rcomp に設定する     
     */     
    public void setRcomp(String rcomp) {        
        this.rcomp = rcomp;     
    }       
    /**     
     * brmtl のゲッターメソッドです。       
     *      
     * @return the brmtl        
     */     
    public String getBrmtl() {      
        return brmtl;       
    }       
    /**     
     * brmtl のセッターメソッドです。       
     *      
     * @param brmtl brmtl に設定する     
     */     
    public void setBrmtl(String brmtl) {        
        this.brmtl = brmtl;     
    }       
    /**     
     * brmti のゲッターメソッドです。       
     *      
     * @return the brmti        
     */     
    public String getBrmti() {      
        return brmti;       
    }       
    /**     
     * brmti のセッターメソッドです。       
     *      
     * @param brmti brmti に設定する     
     */     
    public void setBrmti(String brmti) {        
        this.brmti = brmti;     
    }       
    /**     
     * brmic のゲッターメソッドです。       
     *      
     * @return the brmic        
     */     
    public String getBrmic() {      
        return brmic;       
    }       
    /**     
     * brmic のセッターメソッドです。       
     *      
     * @param brmic brmic に設定する     
     */     
    public void setBrmic(String brmic) {        
        this.brmic = brmic;     
    }       
    /**     
     * bpurl のゲッターメソッドです。       
     *      
     * @return the bpurl        
     */     
    public String getBpurl() {      
        return bpurl;       
    }       
    /**     
     * bpurl のセッターメソッドです。       
     *      
     * @param bpurl bpurl に設定する     
     */     
    public void setBpurl(String bpurl) {        
        this.bpurl = bpurl;     
    }       
    /**     
     * bpuri のゲッターメソッドです。       
     *      
     * @return the bpuri        
     */     
    public String getBpuri() {      
        return bpuri;       
    }       
    /**     
     * bpuri のセッターメソッドです。       
     *      
     * @param bpuri bpuri に設定する     
     */     
    public void setBpuri(String bpuri) {        
        this.bpuri = bpuri;     
    }       
    /**     
     * bppic のゲッターメソッドです。       
     *      
     * @return the bppic        
     */     
    public String getBppic() {      
        return bppic;       
    }       
    /**     
     * bppic のセッターメソッドです。       
     *      
     * @param bppic bppic に設定する     
     */     
    public void setBppic(String bppic) {        
        this.bppic = bppic;     
    }       
    /**     
     * blabc のゲッターメソッドです。       
     *      
     * @return the blabc        
     */     
    public String getBlabc() {      
        return blabc;       
    }       
    /**     
     * blabc のセッターメソッドです。       
     *      
     * @param blabc blabc に設定する     
     */     
    public void setBlabc(String blabc) {        
        this.blabc = blabc;     
    }       
    /**     
     * bdepc のゲッターメソッドです。       
     *      
     * @return the bdepc        
     */     
    public String getBdepc() {      
        return bdepc;       
    }       
    /**     
     * bdepc のセッターメソッドです。       
     *      
     * @param bdepc bdepc に設定する     
     */     
    public void setBdepc(String bdepc) {        
        this.bdepc = bdepc;     
    }       
    /**     
     * bmexp のゲッターメソッドです。       
     *      
     * @return the bmexp        
     */     
    public String getBmexp() {      
        return bmexp;       
    }       
    /**     
     * bmexp のセッターメソッドです。       
     *      
     * @param bmexp bmexp に設定する     
     */     
    public void setBmexp(String bmexp) {        
        this.bmexp = bmexp;     
    }       
    /**     
     * bdiec のゲッターメソッドです。       
     *      
     * @return the bdiec        
     */     
    public String getBdiec() {      
        return bdiec;       
    }       
    /**     
     * bdiec のセッターメソッドです。       
     *      
     * @param bdiec bdiec に設定する     
     */     
    public void setBdiec(String bdiec) {        
        this.bdiec = bdiec;     
    }       
    /**     
     * ocean のゲッターメソッドです。       
     *      
     * @return the ocean        
     */     
    public String getOcean() {      
        return ocean;       
    }       
    /**     
     * ocean のセッターメソッドです。       
     *      
     * @param ocean ocean に設定する     
     */     
    public void setOcean(String ocean) {        
        this.ocean = ocean;     
    }       
    /**     
     * insdt のゲッターメソッドです。       
     *      
     * @return the insdt        
     */     
    public String getInsdt() {      
        return insdt;       
    }       
    /**     
     * insdt のセッターメソッドです。       
     *      
     * @param insdt insdt に設定する     
     */     
    public void setInsdt(String insdt) {        
        this.insdt = insdt;     
    }       

    
    public String getItcls() {
        return itcls;
    }
    public void setItcls(String itcls) {
        this.itcls = itcls;
    }
    public String getCusnm() {
        return cusnm;
    }
    public void setCusnm(String cusnm) {
        this.cusnm = cusnm;
    }
    public String getPcost() {
        return pcost;
    }
    public void setPcost(String pcost) {
        this.pcost = pcost;
    }
    public String getAmount01() {
        return amount01;
    }
    public void setAmount01(String amount01) {
        this.amount01 = amount01;
    }
    public String getAmount02() {
        return amount02;
    }
    public void setAmount02(String amount02) {
        this.amount02 = amount02;
    }
    public String getAmount03() {
        return amount03;
    }
    public void setAmount03(String amount03) {
        this.amount03 = amount03;
    }
    public String getAmount04() {
        return amount04;
    }
    public void setAmount04(String amount04) {
        this.amount04 = amount04;
    }
    public String getAmount05() {
        return amount05;
    }
    public void setAmount05(String amount05) {
        this.amount05 = amount05;
    }
    public String getAmount06() {
        return amount06;
    }
    public void setAmount06(String amount06) {
        this.amount06 = amount06;
    }
    public String getAmount07() {
        return amount07;
    }
    public void setAmount07(String amount07) {
        this.amount07 = amount07;
    }
    public String getAmount08() {
        return amount08;
    }
    public void setAmount08(String amount08) {
        this.amount08 = amount08;
    }
    public String getAmount09() {
        return amount09;
    }
    public void setAmount09(String amount09) {
        this.amount09 = amount09;
    }
    public String getAmount10() {
        return amount10;
    }
    public void setAmount10(String amount10) {
        this.amount10 = amount10;
    }
    public String getAmount11() {
        return amount11;
    }
    public void setAmount11(String amount11) {
        this.amount11 = amount11;
    }
    public String getAmount12() {
        return amount12;
    }
    public void setAmount12(String amount12) {
        this.amount12 = amount12;
    }
    public HashMap<String, String> getSearchDate() {
        return searchDate;
    }
    public void setSearchDate(HashMap<String, String> searchDate) {
        this.searchDate = searchDate;
    }
    public String getProcs() {
        return procs;
    }
    public void setProcs(String procs) {
        this.procs = procs;
    }
    public String getEdatm() {
        return edatm;
    }
    public void setEdatm(String edatm) {
        this.edatm = edatm;
    }
    public String getUnmsr() {
        return unmsr;
    }
    public void setUnmsr(String unmsr) {
        this.unmsr = unmsr;
    }
    public String getIttyp() {
        return ittyp;
    }
    public void setIttyp(String ittyp) {
        this.ittyp = ittyp;
    }
    public String getKrpat() {
        return krpat;
    }
    public void setKrpat(String krpat) {
        this.krpat = krpat;
    }
    public String getKrcot() {
        return krcot;
    }
    public void setKrcot(String krcot) {
        this.krcot = krcot;
    }
    public String getMchmu() {
        return mchmu;
    }
    public void setMchmu(String mchmu) {
        this.mchmu = mchmu;
    }
    public String getMager() {
        return mager;
    }
    public void setMager(String mager) {
        this.mager = mager;
    }
    public String getHndtm() {
        return hndtm;
    }
    public void setHndtm(String hndtm) {
        this.hndtm = hndtm;
    }
    public String getDrman() {
        return drman;
    }
    public void setDrman(String drman) {
        this.drman = drman;
    }
    public String getSbman() {
        return sbman;
    }
    public void setSbman(String sbman) {
        this.sbman = sbman;
    }
    public String getDrmch() {
        return drmch;
    }
    public void setDrmch(String drmch) {
        this.drmch = drmch;
    }
    public String getSbmch() {
        return sbmch;
    }
    public void setSbmch(String sbmch) {
        this.sbmch = sbmch;
    }
    public String getEpckd() {
        return epckd;
    }
    public void setEpckd(String epckd) {
        this.epckd = epckd;
    }
    public String getDangu() {
        return dangu;
    }
    public void setDangu(String dangu) {
        this.dangu = dangu;
    }
    public String getDanst() {
        return danst;
    }
    public void setDanst(String danst) {
        this.danst = danst;
    }
    public String getDandt() {
        return dandt;
    }
    public void setDandt(String dandt) {
        this.dandt = dandt;
    }
    public String getCrtdt() {
        return crtdt;
    }
    public void setCrtdt(String crtdt) {
        this.crtdt = crtdt;
    }
    public String getChgdt() {
        return chgdt;
    }
    public void setChgdt(String chgdt) {
        this.chgdt = chgdt;
    }
    public String getPrtqy() {
        return prtqy;
    }
    public void setPrtqy(String prtqy) {
        this.prtqy = prtqy;
    }
    
}
