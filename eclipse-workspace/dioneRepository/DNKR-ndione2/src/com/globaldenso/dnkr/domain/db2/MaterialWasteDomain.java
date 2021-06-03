package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class MaterialWasteDomain extends CommonDb2Domain implements Serializable {
  
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
      * [KO] PACKING CODE<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String packc;
     /**
      * [KO] 품번<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String prtno;
     /**
      * [KO] 품명<br>
      * [EN] ITEM DESCRIPTION<br>
      * [JP] <br>
      */
     private String itdsc;
     /**
      * [KO] 창고<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String house;
     /**
      * [KO] 실적일자<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String trndt;
     /**
      * [KO] 전표번호<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String slpno;
     /**
      * [KO] 이유코드<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String reasn;
     /**
      * [KO] 수량구분<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String qtycd;
     /**
      * [KO] 처리수량<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String trqty;
     /**
      * [KO] 공급/득의<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String succd;
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
      * [KO] MANUFACTURING COST<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String mnfcs;
     
     /**
      * [KO] 불량수량<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String badqy;
   
     
     /**
      * [KO] 사업부<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String comps;
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public MaterialWasteDomain() {
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
	 * @return the packc
	 */
	public String getPackc() {
		return packc;
	}

	/**
	 * @param packc the packc to set
	 */
	public void setPackc(String packc) {
		this.packc = packc;
	}

	/**
	 * @return the prtno
	 */
	public String getPrtno() {
		return prtno;
	}

	/**
	 * @param prtno the prtno to set
	 */
	public void setPrtno(String prtno) {
		this.prtno = prtno;
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
	 * @return the house
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(String house) {
		this.house = house;
	}

	/**
	 * @return the trndt
	 */
	public String getTrndt() {
		return trndt;
	}

	/**
	 * @param trndt the trndt to set
	 */
	public void setTrndt(String trndt) {
		this.trndt = trndt;
	}

	/**
	 * @return the slpno
	 */
	public String getSlpno() {
		return slpno;
	}

	/**
	 * @param slpno the slpno to set
	 */
	public void setSlpno(String slpno) {
		this.slpno = slpno;
	}

	/**
	 * @return the reasn
	 */
	public String getReasn() {
		return reasn;
	}

	/**
	 * @param reasn the reasn to set
	 */
	public void setReasn(String reasn) {
		this.reasn = reasn;
	}

	/**
	 * @return the qtycd
	 */
	public String getQtycd() {
		return qtycd;
	}

	/**
	 * @param qtycd the qtycd to set
	 */
	public void setQtycd(String qtycd) {
		this.qtycd = qtycd;
	}

	/**
	 * @return the trqty
	 */
	public String getTrqty() {
		return trqty;
	}

	/**
	 * @param trqty the trqty to set
	 */
	public void setTrqty(String trqty) {
		this.trqty = trqty;
	}

	/**
	 * @return the succd
	 */
	public String getSuccd() {
		return succd;
	}

	/**
	 * @param succd the succd to set
	 */
	public void setSuccd(String succd) {
		this.succd = succd;
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
	 * @return the badqy
	 */
	public String getBadqy() {
		return badqy;
	}

	/**
	 * @param badqy the badqy to set
	 */
	public void setBadqy(String badqy) {
		this.badqy = badqy;
	}

	
	/**
	 * @return the comps
	 */
	public String getComps() {
		return comps;
	}

	/**
	 * @param comps the comps to set
	 */
	public void setComps(String comps) {
		this.comps = comps;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("packc", this.packc);
        jsonObj.put("prtno", this.prtno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("house", this.house);
        jsonObj.put("trndt", this.trndt);
        jsonObj.put("slpno", this.slpno);
        jsonObj.put("reasn", this.reasn);
        jsonObj.put("qtycd", this.qtycd);
        jsonObj.put("trqty", this.trqty);
        jsonObj.put("succd", this.succd);
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("mnfcs", this.mnfcs);
        
        jsonObj.put("badqy", this.badqy);
        jsonObj.put("comps", this.comps);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}

