package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class ProductionRecordDomain extends CommonDb2Domain implements Serializable {
  
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
      * [KO] 제품코드 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String prdcd;
     /**
      * [KO] 품번  <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String pspno;
     /**
      * [KO] ITEM DESCRIPTION <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String itdsc;
     
     /**
      * [KO] 실적수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String prtqy;
     /**
      * [KO] 실적금액 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String prtam;
     /**
      * [KO] 단가 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String prtcs;
     
 
     
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public ProductionRecordDomain() {
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
	 * @return the prtqy
	 */
	public String getPrtqy() {
		return prtqy;
	}

	/**
	 * @param prtqy the prtqy to set
	 */
	public void setPrtqy(String prtqy) {
		this.prtqy = prtqy;
	}

	/**
	 * @return the prtam
	 */
	public String getPrtam() {
		return prtam;
	}

	/**
	 * @param prtam the prtam to set
	 */
	public void setPrtam(String prtam) {
		this.prtam = prtam;
	}

	/**
	 * @return the prtcs
	 */
	public String getPrtcs() {
		return prtcs;
	}

	/**
	 * @param prtcs the prtcs to set
	 */
	public void setPrtcs(String prtcs) {
		this.prtcs = prtcs;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("prdcd", this.prdcd);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("prtqy", this.prtqy);
        jsonObj.put("prtam", this.prtam);
        jsonObj.put("prtcs", this.prtcs);

        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}

