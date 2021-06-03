package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class MaterialReceivingDomain extends CommonDb2Domain implements Serializable {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 3333018149644115190L;

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
    * [KO] 조회년도<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String year;
    
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
   private String pspno;       
         
   /**     
    *      
    */      
   private String itdsc;     
   
   /**     
    *      
    */
   private String ittyp;
         
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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public MaterialReceivingDomain() {
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
    
    /**
     * @return year
     */
    public String getYear() {
        return year;
    }
    
    /**
     * @param year String
     */
    public void setYear(String year) {
        this.year = year;
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
     * ittyp のゲッターメソッドです。       
     *      
     * @return the ittyp        
     */  
    public String getIttyp() {
        return ittyp;
    }
    
    /**     
     * ittyp のセッターメソッドです。       
     *      
     * @param ittyp ittyp に設定する     
     */
    public void setIttyp(String ittyp) {
        this.ittyp = ittyp;
    }
    
    /**     
     * itcls のゲッターメソッドです。       
     *      
     * @return the itcls        
     */  
    public String getItcls() {
        return itcls;
    }
    
    /**     
     * itcls のセッターメソッドです。       
     *      
     * @param itcls ittyp に設定する     
     */
    public void setItcls(String itcls) {
        this.itcls = itcls;
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("house", this.house);
        jsonObj.put("vndnr", this.vndnr);
        jsonObj.put("vname", this.vname);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("prdgu", this.prdgu);
        jsonObj.put("prdcd", this.prdcd);
        jsonObj.put("supgu", this.supgu);
        jsonObj.put("trcst", this.trcst);
        jsonObj.put("crcyw", this.crcyw);
        jsonObj.put("trfot", this.trfot);
        jsonObj.put("month1", this.month1);
        jsonObj.put("month2", this.month2);
        jsonObj.put("month3", this.month3);
        jsonObj.put("month4", this.month4);
        jsonObj.put("month5", this.month5);
        jsonObj.put("month6", this.month6);
        jsonObj.put("month7", this.month7);
        jsonObj.put("month8", this.month8);
        jsonObj.put("month9", this.month9);
        jsonObj.put("month10", this.month10);
        jsonObj.put("month11", this.month11);
        jsonObj.put("month12", this.month12);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}
