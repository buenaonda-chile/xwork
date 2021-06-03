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
public class MonthlyDivisionRatioDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 처리파일<br>
     * [EN] <br>
     * [JP] <br>
     */
     private String jobFileName;
     
    /**
     * [KO] 처리년월<br>
     * [EN] <br>
     * [JP] <br>
     */
     private String jyymm;
     
     
     /**
      * [KO] Business Unit <br>
      * [EN] Business Unit <br>
      * [JP] <br>
      */
     private String glmcu;
     
     /**
      * [KO] DESCRIPTION <br>
      * [EN] DESCRIPTION <br>
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
      * [KO] DESCRIPTION <br>
      * [EN] DESCRIPTION <br>
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
      * [KO] G/L Date <br>
      * [EN] G/L Date <br>
      * [JP] <br>
      */
     private String gldgj;
     
     /**
      * [KO] Batch Number <br>
      * [EN] Batch Number <br>
      * [JP] <br>
      */
     private String glicu;
     
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
      * [KO] AmounT <br>
      * [EN] AmounT <br>
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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public MonthlyDivisionRatioDomain() {
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
        jsonObj.put("glicu", this.glicu);
        jsonObj.put("glsbl", this.glsbl);
        jsonObj.put("glsblt", this.glsblt);
        jsonObj.put("glaa", this.glaa);
        jsonObj.put("glexa", this.glexa);
        jsonObj.put("glexr", this.glexr);
       
        
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
	
	
}
