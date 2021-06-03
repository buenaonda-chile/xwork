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
public class ImportInventoryDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 수입품번<br>
     * [EN] <br>
     * [JP] <br>
     */    
   private String expno;    
   
    /**
     * [KO] 무상사급<br>
     * [EN] <br>
     * [JP] <br>
     */    
   private String mohtq;       
   
   /**
    * [KO] 보세+자재<br>
    * [EN] <br>
    * [JP] <br>
    */    
	private String doqtySaqtyMohtq;
	
	 /**
	    * [KO] 제조원가<br>
	    * [EN] <br>
	    * [JP] <br>
	    */    
	private String mnfcs;
	
	/**
	* [KO] 보세+자재금액<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String dsmPrice;

	/**
	* [KO] 보세재고금액<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String dsmMnfcsPrice;

	/**
	* [KO] 현 재고수량<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String mohtqTf;

	
	 /**
     * [KO] 수입품번 파라미터<br>
     * [EN] <br>
     * [JP] <br>
     */    
   private String pExpno; 
   
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public ImportInventoryDomain() {
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
	 * @return the expno
	 */
	public String getExpno() {
		return expno;
	}

	/**
	 * @param expno the expno to set
	 */
	public void setExpno(String expno) {
		this.expno = expno;
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
	 * @return the doqtySaqtyMohtq
	 */
	public String getDoqtySaqtyMohtq() {
		return doqtySaqtyMohtq;
	}

	/**
	 * @param doqtySaqtyMohtq the doqtySaqtyMohtq to set
	 */
	public void setDoqtySaqtyMohtq(String doqtySaqtyMohtq) {
		this.doqtySaqtyMohtq = doqtySaqtyMohtq;
	}

	/**
	 * @return the mnfcs
	 */
	public String getMnfcs() {
		return mnfcs;
	}

	/**
	 * @param mnfcs the mnfcs to set
	 */
	public void setMnfcs(String mnfcs) {
		this.mnfcs = mnfcs;
	}

	/**
	 * @return the dsmPrice
	 */
	public String getDsmPrice() {
		return dsmPrice;
	}

	/**
	 * @param dsmPrice the dsmPrice to set
	 */
	public void setDsmPrice(String dsmPrice) {
		this.dsmPrice = dsmPrice;
	}

	/**
	 * @return the dsmMnfcsPrice
	 */
	public String getDsmMnfcsPrice() {
		return dsmMnfcsPrice;
	}

	/**
	 * @param dsmMnfcsPrice the dsmMnfcsPrice to set
	 */
	public void setDsmMnfcsPrice(String dsmMnfcsPrice) {
		this.dsmMnfcsPrice = dsmMnfcsPrice;
	}

	/**
	 * @return the mohtqTf
	 */
	public String getMohtqTf() {
		return mohtqTf;
	}

	/**
	 * @param mohtqTf the mohtqTf to set
	 */
	public void setMohtqTf(String mohtqTf) {
		this.mohtqTf = mohtqTf;
	}

	/**
	 * @return the pExpno
	 */
	public String getpExpno() {
		return pExpno;
	}

	/**
	 * @param pExpno the pExpno to set
	 */
	public void setpExpno(String pExpno) {
		this.pExpno = pExpno;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("expno", this.expno);
        jsonObj.put("mohtq", this.mohtq);
        jsonObj.put("doqtySaqtyMohtq", this.doqtySaqtyMohtq);
        jsonObj.put("mnfcs", this.mnfcs);
        jsonObj.put("dsmPrice", this.dsmPrice);
        jsonObj.put("dsmMnfcsPrice", this.dsmMnfcsPrice);        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}

