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
public class ProductInventoryDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 품번<br>
     * [EN] <br>
     * [JP] <br>
     */    
   private String pspno;    
   
    /**
     * [KO] 창고코드<br>
     * [EN] <br>
     * [JP] <br>
     */    
   private String house;       
   
   /**
    * [KO] 품번<br>
    * [EN] <br>
    * [JP] <br>
    */    
	private String itnbr;
	
	 /**
	    * [KO] 품명<br>
	    * [EN] <br>
	    * [JP] <br>
	    */    
	private String itdsc;
	
	/**
	* [KO] 업체코드<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String cusno;

	/**
	* [KO] 득의선명<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String cusnm;

	/**
	* [KO] 현 재고수량<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String mohtq;

	/**
	* [KO] 최종출고일<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String enddt;
	
	
/////
	  /**
     * [KO] ITEM TYPE<br>
     * [EN] <br>
     * [JP] <br>
     */ 
    private String ittyp;
  
    /**
     * [KO] ITEM CLASS<br>
     * [EN] <br>
     * [JP] <br>
     */ 
    private String itcls;

    /**
     * [KO] 이월재고 <br>
     * [EN] BEGINNING INVENTORY<br>
     * [JP] <br>
     */ 
    private String begin;
    
    /**
     * [KO] 입고수량 <br>
     * [EN] QTY RECEIVED THIS PERIOD<br>
     * [JP] <br>
     */ 
    private String recmo;
    
    /**
     * [KO] 출고수량 <br>
     * [EN] QTY ISSUED THIS PERIOD <br>
     * [JP] <br>
     */ 
    private String issmo;
    /**
     * [KO] 조정수량 <br>
     * [EN] QTY ADJUSTED THIS PERIOD<br>
     * [JP] <br>
     */ 
    private String adjmo; 
    
    
    /**
     * [KO] PACKING CODE<br>
     * [EN] <br>
     * [JP] <br>
     */ 
    private String packc;
        
    /**
     * [KO] 전일입고수량<br>
     * [EN]  <br>
     * [JP] <br>
     */ 
    private String trqtyRc;
    
    /**
     * [KO] 전일추고수량<br>
     * [EN] <br>
     * [JP] <br>
     */ 
    private String trqtyIw;
    
    /**
     * [KO] 재고금액<br>
     * [EN] ON HAND TOTAL PRICE<br>
     * [JP] <br>
     */ 
    private String amt;
    
    /**
     * [KO] 차종코드<br>
     * [EN] <br>
     * [JP] <br>
     */ 
    private String carcd;
    
    /**
     * [KO] 차종명<br>
     * [EN] <br>
     * [JP] <br>
     */ 
    private String carnm;	
	 /**
     * [KO] 처리파일<br>
     * [EN] <br>
     * [JP] <br>
     */
     private String jobName;
     
     /**
      * [KO] 제품코드<br>
      * [EN] <br>
      * [JP] <br>
      */ 
     private String prdcd;
     
    /**
     * [KO] 구분<br>
     * [EN] <br>
     * [JP] <br>
     */ 
    private String gubun;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public ProductInventoryDomain() {
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
	 * @return the pspno
	 */
	public String getPspno() {
		return pspno;
	}

	/**
	 * @param pspno the pspno to set
	 */
	public void setPspno(String pspno) {
		this.pspno = pspno;
	}

	/**
	 * @return the house
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(String house) {
		this.house = house;
	}
	

	/**
	 * @return the itnbr
	 */
	public String getItnbr() {
		return itnbr;
	}

	/**
	 * @param itnbr the itnbr to set
	 */
	public void setItnbr(String itnbr) {
		this.itnbr = itnbr;
	}

	/**
	 * @return the itdsc
	 */
	public String getItdsc() {
		return itdsc;
	}

	/**
	 * @param itdsc the itdsc to set
	 */
	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}

	/**
	 * @return the cusno
	 */
	public String getCusno() {
		return cusno;
	}

	/**
	 * @param cusno the cusno to set
	 */
	public void setCusno(String cusno) {
		this.cusno = cusno;
	}

	/**
	 * @return the cusnm
	 */
	public String getCusnm() {
		return cusnm;
	}

	/**
	 * @param cusnm the cusnm to set
	 */
	public void setCusnm(String cusnm) {
		this.cusnm = cusnm;
	}

	/**
	 * @return the mohtq
	 */
	public String getMohtq() {
		return mohtq;
	}

	/**
	 * @param mohtq the mohtq to set
	 */
	public void setMohtq(String mohtq) {
		this.mohtq = mohtq;
	}

	/**
	 * @return the enddt
	 */
	public String getEnddt() {
		return enddt;
	}

	/**
	 * @param enddt the enddt to set
	 */
	public void setEnddt(String enddt) {
		this.enddt = enddt;
	}

	/**
	 * @return the ittyp
	 */
	public String getIttyp() {
		return ittyp;
	}

	/**
	 * @param ittyp the ittyp to set
	 */
	public void setIttyp(String ittyp) {
		this.ittyp = ittyp;
	}

	/**
	 * @return the itcls
	 */
	public String getItcls() {
		return itcls;
	}

	/**
	 * @param itcls the itcls to set
	 */
	public void setItcls(String itcls) {
		this.itcls = itcls;
	}

	/**
	 * @return the begin
	 */
	public String getBegin() {
		return begin;
	}

	/**
	 * @param begin the begin to set
	 */
	public void setBegin(String begin) {
		this.begin = begin;
	}

	/**
	 * @return the recmo
	 */
	public String getRecmo() {
		return recmo;
	}

	/**
	 * @param recmo the recmo to set
	 */
	public void setRecmo(String recmo) {
		this.recmo = recmo;
	}

	/**
	 * @return the issmo
	 */
	public String getIssmo() {
		return issmo;
	}

	/**
	 * @param issmo the issmo to set
	 */
	public void setIssmo(String issmo) {
		this.issmo = issmo;
	}

	/**
	 * @return the adjmo
	 */
	public String getAdjmo() {
		return adjmo;
	}

	/**
	 * @param adjmo the adjmo to set
	 */
	public void setAdjmo(String adjmo) {
		this.adjmo = adjmo;
	}

	/**
	 * @return the packc
	 */
	public String getPackc() {
		return packc;
	}

	/**
	 * @param packc the packc to set
	 */
	public void setPackc(String packc) {
		this.packc = packc;
	}

	/**
	 * @return the amt
	 */
	public String getAmt() {
		return amt;
	}

	/**
	 * @param amt the amt to set
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}

	/**
	 * @return the prdcd
	 */
	public String getPrdcd() {
		return prdcd;
	}

	/**
	 * @param prdcd the prdcd to set
	 */
	public void setPrdcd(String prdcd) {
		this.prdcd = prdcd;
	}

	
	
	/**
	 * @return the carcd
	 */
	public String getCarcd() {
		return carcd;
	}

	/**
	 * @param carcd the carcd to set
	 */
	public void setCarcd(String carcd) {
		this.carcd = carcd;
	}

	/**
	 * @return the carnm
	 */
	public String getCarnm() {
		return carnm;
	}

	/**
	 * @param carnm the carnm to set
	 */
	public void setCarnm(String carnm) {
		this.carnm = carnm;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the gubun
	 */
	public String getGubun() {
		return gubun;
	}

	/**
	 * @param gubun the gubun to set
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("house", this.house);
        jsonObj.put("itnbr", this.itnbr);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("cusno", this.cusno);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("mohtq", this.mohtq);
        jsonObj.put("enddt", this.enddt);
        
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("begin", this.begin);
        jsonObj.put("recmo", this.recmo);
        jsonObj.put("issmo", this.issmo);
        jsonObj.put("adjmo", this.adjmo);
        jsonObj.put("packc", this.packc);        
        jsonObj.put("amt", this.amt);
        jsonObj.put("trqtyRc", this.trqtyRc);
        jsonObj.put("trqtyIw", this.trqtyIw);
        
        
        jsonObj.put("carcd", this.carcd);
        jsonObj.put("carnm", this.carnm);

        
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}

