package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class ProductShippingReceivingDomain extends CommonDb2Domain implements Serializable {
  
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
      * [KO] 사업부<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String comps;
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
      * [KO] 창고<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String house;
     /**
      * [KO] 구분 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String gubun;
     /**
      * [KO] ITEM CLASS<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String itcls1;
     /**
      * [KO] ITEM CLASS <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String itcls2;
     /**
      * [KO] ITEM TYPE <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String ittyp;
     /**
      * [KO] PLANNER <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String plann;
     /**
      * [KO] 입고  <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String imi12;
     /**
      * [KO] 출고 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String imo12;
     /**
      * [KO] 조정 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String imc12;
     /**
      * [KO] 재고 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String imq12;
     
     /**
      * [KO] 실사차이<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String dif12;
   
     /**
      * [KO] MANUFACTURING COST<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String mnfcs;
     /**
      * [KO] SALES PRICE<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String price;
    
    
     
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public ProductShippingReceivingDomain() {
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
	 * @return the gubun
	 */
	public String getGubun() {
		return gubun;
	}

	/**
	 * @param gubun the gubun to set
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	/**
	 * @return the itcls1
	 */
	public String getItcls1() {
		return itcls1;
	}

	/**
	 * @param itcls1 the itcls1 to set
	 */
	public void setItcls1(String itcls1) {
		this.itcls1 = itcls1;
	}

	/**
	 * @return the itcls2
	 */
	public String getItcls2() {
		return itcls2;
	}

	/**
	 * @param itcls2 the itcls2 to set
	 */
	public void setItcls2(String itcls2) {
		this.itcls2 = itcls2;
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
	 * @return the plann
	 */
	public String getPlann() {
		return plann;
	}

	/**
	 * @param plann the plann to set
	 */
	public void setPlann(String plann) {
		this.plann = plann;
	}

	/**
	 * @return the imi12
	 */
	public String getImi12() {
		return imi12;
	}

	/**
	 * @param imi12 the imi12 to set
	 */
	public void setImi12(String imi12) {
		this.imi12 = imi12;
	}

	/**
	 * @return the imo12
	 */
	public String getImo12() {
		return imo12;
	}

	/**
	 * @param imo12 the imo12 to set
	 */
	public void setImo12(String imo12) {
		this.imo12 = imo12;
	}

	/**
	 * @return the imc12
	 */
	public String getImc12() {
		return imc12;
	}

	/**
	 * @param imc12 the imc12 to set
	 */
	public void setImc12(String imc12) {
		this.imc12 = imc12;
	}

	/**
	 * @return the imq12
	 */
	public String getImq12() {
		return imq12;
	}

	/**
	 * @param imq12 the imq12 to set
	 */
	public void setImq12(String imq12) {
		this.imq12 = imq12;
	}

	/**
	 * @return the dif12
	 */
	public String getDif12() {
		return dif12;
	}

	/**
	 * @param dif12 the dif12 to set
	 */
	public void setDif12(String dif12) {
		this.dif12 = dif12;
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
		

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("house", this.house);
        jsonObj.put("gubun", this.gubun);
        jsonObj.put("itcls1", this.itcls1);
        jsonObj.put("itcls2", this.itcls2);
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("plann", this.plann);
        jsonObj.put("imi12", this.imi12);
        jsonObj.put("imo12", this.imo12);
        jsonObj.put("imc12", this.imc12);
        jsonObj.put("imq12", this.imq12);
        jsonObj.put("dif12", this.dif12);
        jsonObj.put("mnfcs", this.mnfcs);
        jsonObj.put("price", this.price);    

        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}

