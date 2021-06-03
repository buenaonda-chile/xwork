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
public class MonthlySalesPerformanceDomain extends CommonDb2Domain implements Serializable {
  
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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public MonthlySalesPerformanceDomain() {
        // no process
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
       /* jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("procs", this.procs);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("edatm", this.edatm);
        jsonObj.put("price", this.price);
        jsonObj.put("unmsr", this.unmsr);
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("itdsc", this.itdsc);        
        jsonObj.put("krsur", this.krsur);
        jsonObj.put("surkr", this.surkr);
        jsonObj.put("surus", this.surus);
        jsonObj.put("surjp", this.surjp);
        jsonObj.put("surur", this.surur);
        jsonObj.put("krpur", this.krpur);
        jsonObj.put("krckd", this.krckd);
        jsonObj.put("ckdus", this.ckdus);
        jsonObj.put("ckdjp", this.ckdjp);
        jsonObj.put("ckdur", this.ckdur);
        jsonObj.put("ckdkr", this.ckdkr);
        jsonObj.put("krpat", this.krpat);
        jsonObj.put("krcot", this.krcot);
        jsonObj.put("mchmu", this.mchmu);
        jsonObj.put("mager", this.mager);
        jsonObj.put("hndtm", this.hndtm);
        jsonObj.put("drman", this.drman);
        jsonObj.put("sbman", this.sbman);
        jsonObj.put("drmch", this.drmch);
        jsonObj.put("sbmch", this.sbmch);
        jsonObj.put("epckd", this.epckd);
        jsonObj.put("dangu", this.dangu);
        jsonObj.put("danst", this.danst);
        jsonObj.put("dandt", this.dandt);
        jsonObj.put("crtdt", this.crtdt);
        jsonObj.put("chgdt", this.chgdt);
        jsonObj.put("prtqy", this.prtqy);
        */
        
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
}
