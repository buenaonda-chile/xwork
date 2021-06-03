package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class DailyDepartmentCostDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 처리년월<br>
     * [EN] <br>
     * [JP] <br>
     */
     private String jyymm;
     
     /**
      * [KO] 회계년도기준 - 조회년도<br>
      * [EN] <br>
      * [JP] <br>
      */
      private String pYear;
      
      /**
       * [KO] 회계년도기준 - 조회월<br>
       * [EN] <br>
       * [JP] <br>
       */
       private String pMonth;
     
     /**
      * [KO] Business Unit <br>
      * [EN] Business Unit <br>
      * [JP] <br>
      */
     private String glmcu;
     
     /**
      * [KO] Business Name <br>
      * [EN] Business Name <br>
      * [JP] <br>
      */
     private String mcdc;
     
     /**
      * [KO] Object Account <br>
      * [EN] Object Account <br>
      * [JP] <br>
      */
     private String globj;
     
     /**
      * [KO] Subsidiary <br>
      * [EN] Subsidiary <br>
      * [JP] <br>
      */
     private String glsub;
     
     /**
      * [KO] Subsidiary Name <br>
      * [EN] Subsidiary Name <br>
      * [JP] <br>
      */
     private String gmdl01;
     
     /**
      * [KO] Document Type <br>
      * [EN] Document Type <br>
      * [JP] <br>
      */
     private String gldct;
     
     /**
      * [KO] JULIAN G/L Date <br>
      * [EN] JULIAN G/L Date <br>
      * [JP] <br>
      */
     private String gldgj;
     
     /**
      * [KO] G/L Date <br>
      * [EN] G/L Date <br>
      * [JP] <br>
      */
     private String gldate;
     
     /**
      * [KO] Subledger <br>
      * [EN] Subledger <br>
      * [JP] <br>
      */
     private String glsbl;
     
     /**
      * [KO] Subledger Type <br>
      * [EN] Subledger Type <br>
      * [JP] <br>
      */
     private String glsblt;
     
     /**
      * [KO] Amount <br>
      * [EN] Amount <br>
      * [JP] <br>
      */
     private String glaa;
     
     /**
      * [KO] Explanation - Name <br>
      * [EN] Explanation - Name <br>
      * [JP] <br>
      */
     private String glexa;
     
     /**
      * [KO] Explanation - REMA <br>
      * [EN] Explanation - REMA <br>
      * [JP] <br>
      */
     private String glexr;
     
     /**
      * [KO] Batch Date <br>
      * [EN] Batch Date <br>
      * [JP] <br>
      */
     private String batchDate;
     
    /**                 
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public DailyDepartmentCostDomain() {
        // no process
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("glmcu", this.glmcu);
        jsonObj.put("mcdc", this.mcdc);
        jsonObj.put("globj", this.globj);
        jsonObj.put("glsub", this.glsub);
        jsonObj.put("gmdl01", this.gmdl01);
        jsonObj.put("gldct", this.gldct);
        jsonObj.put("gldgj", this.gldgj);        
        jsonObj.put("gldate", this.gldate);
        jsonObj.put("glsbl", this.glsbl);
        jsonObj.put("glsblt", this.glsblt);
        jsonObj.put("glaa", this.glaa);
        jsonObj.put("glexa", this.glexa);
        jsonObj.put("glexr", this.glexr);
        jsonObj.put("batchDate", this.batchDate);
       
        
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

	public int getRowNumFrom() {
		return rowNumFrom;
	}

	public void setRowNumFrom(int rowNumFrom) {
		this.rowNumFrom = rowNumFrom;
	}

	public int getRowNumTo() {
		return rowNumTo;
	}

	public void setRowNumTo(int rowNumTo) {
		this.rowNumTo = rowNumTo;
	}

	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the jyymm
	 */
	public String getJyymm() {
		return jyymm;
	}

	/**
	 * @param jyymm the jyymm to set
	 */
	public void setJyymm(String jyymm) {
		this.jyymm = jyymm;
	}

	/**
	 * @return the pYear
	 */
	public String getpYear() {
		return pYear;
	}

	/**
	 * @param pYear the pYear to set
	 */
	public void setpYear(String pYear) {
		this.pYear = pYear;
	}

	/**
	 * @return the pMonth
	 */
	public String getpMonth() {
		return pMonth;
	}

	/**
	 * @param pMonth the pMonth to set
	 */
	public void setpMonth(String pMonth) {
		this.pMonth = pMonth;
	}	
	
}
