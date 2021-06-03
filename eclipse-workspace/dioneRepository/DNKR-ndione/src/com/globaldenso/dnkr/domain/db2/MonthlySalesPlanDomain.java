package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class MonthlySalesPlanDomain extends CommonDb2Domain implements Serializable {
  
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
      * [KO] 업체코드<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String pyvnd;
     
     /**
      * [KO] 업체명<br>
      * [EN] CUSTOMER NAME<br>
      * [JP] <br>
      */
     private String cusnm;
          
     /**
      * [KO] 품번<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String pspno;

     /**
      * [KO] 품명<br>
      * [EN] ITEM DESCRIPTION<br>
      * [JP] <br>
      */
     private String itdsc;
     /**
      * [KO] 기본M0계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm0qy;
     /**
      * [KO] 기본M1계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm1qy;
    
     /**
      * [KO] 기본M2계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm2qy;
     /**
      * [KO] 기본M3계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm3qy;
     /**
      * [KO] 기본M4계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm4qy;
     /**
      * [KO] 기본M5계획  <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm5qy;
     
     /**
      * [KO] 기본M0계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm0am;
     /**
      * [KO] 기본M1계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm1am;
     /**
      * [KO] 기본M2계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm2am;
     
     /**
      * [KO] 기본M3계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm3am;
     /**
      * [KO] 기본M4계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm4am;
     /**
      * [KO] 기본M5계획 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String sm5am;
        
         
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public MonthlySalesPlanDomain() {
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
	 * @return the pyvnd
	 */
	public String getPyvnd() {
		return pyvnd;
	}

	/**
	 * @param pyvnd the pyvnd to set
	 */
	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
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
	 * @return the sm0qy
	 */
	public String getSm0qy() {
		return sm0qy;
	}

	/**
	 * @param sm0qy the sm0qy to set
	 */
	public void setSm0qy(String sm0qy) {
		this.sm0qy = sm0qy;
	}

	/**
	 * @return the sm1qy
	 */
	public String getSm1qy() {
		return sm1qy;
	}

	/**
	 * @param sm1qy the sm1qy to set
	 */
	public void setSm1qy(String sm1qy) {
		this.sm1qy = sm1qy;
	}

	/**
	 * @return the sm2qy
	 */
	public String getSm2qy() {
		return sm2qy;
	}

	/**
	 * @param sm2qy the sm2qy to set
	 */
	public void setSm2qy(String sm2qy) {
		this.sm2qy = sm2qy;
	}

	/**
	 * @return the sm3qy
	 */
	public String getSm3qy() {
		return sm3qy;
	}

	/**
	 * @param sm3qy the sm3qy to set
	 */
	public void setSm3qy(String sm3qy) {
		this.sm3qy = sm3qy;
	}

	/**
	 * @return the sm4qy
	 */
	public String getSm4qy() {
		return sm4qy;
	}

	/**
	 * @param sm4qy the sm4qy to set
	 */
	public void setSm4qy(String sm4qy) {
		this.sm4qy = sm4qy;
	}

	/**
	 * @return the sm5qy
	 */
	public String getSm5qy() {
		return sm5qy;
	}

	/**
	 * @param sm5qy the sm5qy to set
	 */
	public void setSm5qy(String sm5qy) {
		this.sm5qy = sm5qy;
	}

	/**
	 * @return the sm0am
	 */
	public String getSm0am() {
		return sm0am;
	}

	/**
	 * @param sm0am the sm0am to set
	 */
	public void setSm0am(String sm0am) {
		this.sm0am = sm0am;
	}

	/**
	 * @return the sm1am
	 */
	public String getSm1am() {
		return sm1am;
	}

	/**
	 * @param sm1am the sm1am to set
	 */
	public void setSm1am(String sm1am) {
		this.sm1am = sm1am;
	}

	/**
	 * @return the sm2am
	 */
	public String getSm2am() {
		return sm2am;
	}

	/**
	 * @param sm2am the sm2am to set
	 */
	public void setSm2am(String sm2am) {
		this.sm2am = sm2am;
	}

	/**
	 * @return the sm3am
	 */
	public String getSm3am() {
		return sm3am;
	}

	/**
	 * @param sm3am the sm3am to set
	 */
	public void setSm3am(String sm3am) {
		this.sm3am = sm3am;
	}

	/**
	 * @return the sm4am
	 */
	public String getSm4am() {
		return sm4am;
	}

	/**
	 * @param sm4am the sm4am to set
	 */
	public void setSm4am(String sm4am) {
		this.sm4am = sm4am;
	}

	/**
	 * @return the sm5am
	 */
	public String getSm5am() {
		return sm5am;
	}

	/**
	 * @param sm5am the sm5am to set
	 */
	public void setSm5am(String sm5am) {
		this.sm5am = sm5am;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("sm0qy", this.sm0qy);
        jsonObj.put("sm1qy", this.sm1qy);
        jsonObj.put("sm2qy", this.sm2qy);
        jsonObj.put("sm3qy", this.sm3qy);
        jsonObj.put("sm4qy", this.sm4qy);
        jsonObj.put("sm5qy", this.sm5qy);
        jsonObj.put("sm0am", this.sm0am);
        jsonObj.put("sm1am", this.sm1am);
        jsonObj.put("sm2am", this.sm2am);
        jsonObj.put("sm3am", this.sm3am);
        jsonObj.put("sm4am", this.sm4am);
        jsonObj.put("sm5am", this.sm5am);

        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

}