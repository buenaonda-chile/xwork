package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 영업출하현황(재료비) 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class BusinessShippingMaterialDomain extends CommonDb2Domain implements Serializable {
  
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
      * [KO] ITEM CLASS <br>
      * [EN] ITEM CLASS <br>
      * [JP] <br>
      */
     private String itcls;
 
     /**
      * [KO] 품번 <br>
      * [EN] ITEM No <br>
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
      * [KO] 차종코드 <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String carcd;
     /**
      * [KO] 코드 원명 <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String mstrm;
     /**
      * [KO] 득의선코드 <br>
      * [EN] CUSTOMER No <br>
      * [JP] <br>
      */
     private String pyvnd;
     /**
      * [KO] 득의선명 <br>
      * [EN] CUSTOMER NAME <br>
      * [JP] <br>
      */
     private String cusnm;
     /**
      * [KO] 적용일자 <br>
      * [EN] EFFECTIVE DATE FROM <br>
      * [JP] <br>
      */
     private String edatm;
     /**
      * [KO] 구매단가 <br>
      * [EN] SALES PRICE <br>
      * [JP] <br>
      */
     private String price;
     /**
      * [KO] 전표 수량 <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String jpsqy;
     /**
      * [KO] 금액 <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String jpsam;
     /**
      * [KO] 원재료 <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String krsur;
     /**
      * [KO] 원재료 ￦ <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String surkr;
     /**
      * [KO] 원재료 $ <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String surus;
     /**
      * [KO] 원재료 Y <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String surjp;
     /**
      * [KO] 원재료 U <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String surur;
     /**
      * [KO] 구매품 <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String krpur;
     /**
      * [KO] CKD ￦<br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String krckd;
     /**
      * [KO] CKD $ <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String ckdus;
     /**
      * [KO] CKD Y <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String ckdjp;
     /**
      * [KO] CKD U <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String ckdur;
     /**
      * [KO] CKD ￦  <br>
      * [EN]  <br>
      * [JP] <br>
      */
     private String ckdkr;
         
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public BusinessShippingMaterialDomain() {
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
	 * @return the mstrm
	 */
	public String getMstrm() {
		return mstrm;
	}

	/**
	 * @param mstrm the mstrm to set
	 */
	public void setMstrm(String mstrm) {
		this.mstrm = mstrm;
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
	 * @return the edatm
	 */
	public String getEdatm() {
		return edatm;
	}

	/**
	 * @param edatm the edatm to set
	 */
	public void setEdatm(String edatm) {
		this.edatm = edatm;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the jpsqy
	 */
	public String getJpsqy() {
		return jpsqy;
	}

	/**
	 * @param jpsqy the jpsqy to set
	 */
	public void setJpsqy(String jpsqy) {
		this.jpsqy = jpsqy;
	}

	/**
	 * @return the jpsam
	 */
	public String getJpsam() {
		return jpsam;
	}

	/**
	 * @param jpsam the jpsam to set
	 */
	public void setJpsam(String jpsam) {
		this.jpsam = jpsam;
	}

	/**
	 * @return the krsur
	 */
	public String getKrsur() {
		return krsur;
	}

	/**
	 * @param krsur the krsur to set
	 */
	public void setKrsur(String krsur) {
		this.krsur = krsur;
	}

	/**
	 * @return the surkr
	 */
	public String getSurkr() {
		return surkr;
	}

	/**
	 * @param surkr the surkr to set
	 */
	public void setSurkr(String surkr) {
		this.surkr = surkr;
	}

	/**
	 * @return the surus
	 */
	public String getSurus() {
		return surus;
	}

	/**
	 * @param surus the surus to set
	 */
	public void setSurus(String surus) {
		this.surus = surus;
	}

	/**
	 * @return the surjp
	 */
	public String getSurjp() {
		return surjp;
	}

	/**
	 * @param surjp the surjp to set
	 */
	public void setSurjp(String surjp) {
		this.surjp = surjp;
	}

	/**
	 * @return the surur
	 */
	public String getSurur() {
		return surur;
	}

	/**
	 * @param surur the surur to set
	 */
	public void setSurur(String surur) {
		this.surur = surur;
	}

	/**
	 * @return the krpur
	 */
	public String getKrpur() {
		return krpur;
	}

	/**
	 * @param krpur the krpur to set
	 */
	public void setKrpur(String krpur) {
		this.krpur = krpur;
	}

	/**
	 * @return the krckd
	 */
	public String getKrckd() {
		return krckd;
	}

	/**
	 * @param krckd the krckd to set
	 */
	public void setKrckd(String krckd) {
		this.krckd = krckd;
	}

	/**
	 * @return the ckdus
	 */
	public String getCkdus() {
		return ckdus;
	}

	/**
	 * @param ckdus the ckdus to set
	 */
	public void setCkdus(String ckdus) {
		this.ckdus = ckdus;
	}

	/**
	 * @return the ckdjp
	 */
	public String getCkdjp() {
		return ckdjp;
	}

	/**
	 * @param ckdjp the ckdjp to set
	 */
	public void setCkdjp(String ckdjp) {
		this.ckdjp = ckdjp;
	}

	/**
	 * @return the ckdur
	 */
	public String getCkdur() {
		return ckdur;
	}

	/**
	 * @param ckdur the ckdur to set
	 */
	public void setCkdur(String ckdur) {
		this.ckdur = ckdur;
	}

	/**
	 * @return the ckdkr
	 */
	public String getCkdkr() {
		return ckdkr;
	}

	/**
	 * @param ckdkr the ckdkr to set
	 */
	public void setCkdkr(String ckdkr) {
		this.ckdkr = ckdkr;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("carcd", this.carcd);
        jsonObj.put("mstrm", this.mstrm);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("edatm", this.edatm);
        jsonObj.put("price", this.price);
        jsonObj.put("jpsqy", this.jpsqy);
        jsonObj.put("jpsam", this.jpsam);
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
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();   
        return rtnStr;
    }
}