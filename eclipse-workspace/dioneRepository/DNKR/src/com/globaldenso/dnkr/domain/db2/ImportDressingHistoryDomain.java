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
public class ImportDressingHistoryDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 작업구분 <br>
     * [EN] <br>
     * [JP] <br>
     */
     private String jobName;
         
    /**
     * [KO] 업체코드 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String vndnr;
    /**
     * [KO] 업체명 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String vname;
    /**
     * [KO] 조달구분<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String supgu;
    /**
     * [KO] 품번<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pspno;
    /**
     * [KO] 품명 <br>
     * [EN] ITEM DESCRIPTION <br>
     * [JP] <br>
     */
    private String itdsc;
    /**
     * [KO] ITEM TYPE CODE <br>
     * [EN] ITEM TYPE CODE <br>
     * [JP] <br>
     */
    private String ittyp;
    /**
     * [KO] ITEM CLASS <br>
     * [EN] ITEM CLASS <br>
     * [JP] <br>
     */
    private String itcls;
    /**
     * [KO] 거래단위 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String unmsr;
    /**
     * [KO] 거래일자 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String trndt;
    /**
     * [KO] 거래단가 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String trcst;
    /**
     * [KO] 표준단가<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String stcst;
    /**
     * [KO] 거래통화 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String crcyw;
    /**
     * [KO] 거래수량 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String trqty;
    /**
     * [KO] 거래금액 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String tramt;
     
    private String performanceDivision;
    
    /**                 
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public ImportDressingHistoryDomain() {
        // no process
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("vndnr", this.vndnr);
        jsonObj.put("vname", this.vname);
        jsonObj.put("supgu", this.supgu);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("itcls", this.itcls);        
        jsonObj.put("unmsr", this.unmsr);
        jsonObj.put("trndt", this.trndt);
        jsonObj.put("trcst", this.trcst);
        jsonObj.put("stcst", this.stcst);
        jsonObj.put("crcyw", this.crcyw);
        jsonObj.put("trqty", this.trqty);
        jsonObj.put("tramt", this.tramt);        
        
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
	 * @return the vndnr
	 */
	public String getVndnr() {
		return vndnr;
	}

	/**
	 * @param vndnr the vndnr to set
	 */
	public void setVndnr(String vndnr) {
		this.vndnr = vndnr;
	}

	/**
	 * @return the vname
	 */
	public String getVname() {
		return vname;
	}

	/**
	 * @param vname the vname to set
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}
	
}
