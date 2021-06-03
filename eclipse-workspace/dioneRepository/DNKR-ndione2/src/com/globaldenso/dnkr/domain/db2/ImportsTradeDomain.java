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
public class ImportsTradeDomain extends CommonDb2Domain implements Serializable {
  
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
    
  
    
    private String performanceDivision;
    
    
    /**
     * [KO] 처리파일<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jobFileName;
    
    /**
     * [KO] PRMRK <br>
     * [EN] PRMRK <br>
     * [JP] <br>
     */
    private String prmrke;
    /**
     * [KO] 창고 <br>
     * [EN] WAREHOUSE <br>
     * [JP] <br>
     */
    private String housee;
    
    /**
     * [KO] ㅁ <br>
     * [EN] INVENTORY CATEGORY <br>
     * [JP] <br>
     */
    private String invcte;
    
    /**
     * [KO] PRODUCT DIVISION <br>
     * [EN] PRODUCT DIVISION <br>
     * [JP] <br>
     */
    private String prddve;
    
    /**
     * [KO] CREDIT AUX.CODE <br>
     * [EN] CREDIT AUX.CODE <br>
     * [JP] <br>
     */
    private String creaxe;
    
    /**
     * [KO] REFFERENCE <br>
     * [EN] REFFERENCE <br>
     * [JP] <br>
     */
    private String reffre;
    
    /**
     * [KO] PART NO. <br>
     * [EN] PART NO. <br>
     * [JP] <br>
     */
    private String prtnoe;
    
    /**
     * [KO] DATE OCCURED <br>
     * [EN] DATE OCCURED <br>
     * [JP] <br>
     */
    private String odatee;
    
    /**
     * [KO] QUANTITY <br>
     * [EN] QUANTITY <br>
     * [JP] <br>
     */
    private String quante;
    
    /**
     * [KO] CURRENCY CODE <br>
     * [EN] CURRENCY CODE <br>
     * [JP] <br>
     */
    private String curcde;
    
    /**
     * [KO] ACTUAL PRICE<br>
     * [EN] ACTUAL PRICE<br>
     * [JP] <br>
     */
    private String pricee;
    
    /**
     * [KO] STANDARD COST<br>
     * [EN] STANDARD COST<br>
     * [JP] <br>
     */
    private String scoste;
    
   
    /**                 
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public ImportsTradeDomain() {
        // no process
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("prmrke", this.prmrke);
        jsonObj.put("housee", this.housee);
        jsonObj.put("invcte", this.invcte);
        jsonObj.put("prddve", this.prddve);
        jsonObj.put("creaxe", this.creaxe);
        jsonObj.put("reffre", this.reffre);
        jsonObj.put("prtnoe", this.prtnoe);        
        jsonObj.put("odatee", this.odatee);
        jsonObj.put("quante", this.quante);
        jsonObj.put("curcde", this.curcde);
        jsonObj.put("pricee", this.pricee);
        jsonObj.put("scoste", this.scoste);
       
        
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
	 * @return the jobFileName
	 */
	public String getJobFileName() {
		return jobFileName;
	}

	/**
	 * @param jobFileName the jobFileName to set
	 */
	public void setJobFileName(String jobFileName) {
		this.jobFileName = jobFileName;
	}
	
}
