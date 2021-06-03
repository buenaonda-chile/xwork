package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class MonthlyShippingListDomain extends CommonDb2Domain implements Serializable {
  
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
      * [KO] TRUCK NO<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String trkno;
     
     /**
      * [KO] 업체코드<br>
      * [EN] CUSTOMER NO<br>
      * [JP] <br>
      */
     private String cusno;
     
     /**
      * [KO] SHIP TO NO<br>
      * [EN] SHIP TO NO<br>
      * [JP] <br>
      */
     private String shpno;
     /**
      * [KO] 업체명<br>
      * [EN] CUSTOMER NAME<br>
      * [JP] <br>
      */
     private String cusnm;
          
     /**
      * [KO] DATE SHIPPING INSTRUCTED <br>
      * [EN] DATE SHIPPING INSTRUCTED <br>
      * [JP] <br>
      */
     private String shpdt;

     /**
      * [KO] PROCESSING FLAG <br>
      * [EN] PROCESSING FLAG <br>
      * [JP] <br>
      */
     private String prflg;
    
         
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public MonthlyShippingListDomain() {
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
	 * @return the trkno
	 */
	public String getTrkno() {
		return trkno;
	}

	/**
	 * @param trkno the trkno to set
	 */
	public void setTrkno(String trkno) {
		this.trkno = trkno;
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
	 * @return the shpno
	 */
	public String getShpno() {
		return shpno;
	}

	/**
	 * @param shpno the shpno to set
	 */
	public void setShpno(String shpno) {
		this.shpno = shpno;
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
	 * @return the shpdt
	 */
	public String getShpdt() {
		return shpdt;
	}

	/**
	 * @param shpdt the shpdt to set
	 */
	public void setShpdt(String shpdt) {
		this.shpdt = shpdt;
	}

	/**
	 * @return the prflg
	 */
	public String getPrflg() {
		return prflg;
	}

	/**
	 * @param prflg the prflg to set
	 */
	public void setPrflg(String prflg) {
		this.prflg = prflg;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("trkno", this.trkno);
        jsonObj.put("cusno", this.cusno);
        jsonObj.put("shpno", this.shpno);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("shpdt", this.shpdt);
        jsonObj.put("prflg", this.prflg);
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

}