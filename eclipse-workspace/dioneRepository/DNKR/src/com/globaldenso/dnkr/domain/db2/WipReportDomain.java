package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class WipReportDomain extends CommonDb2Domain implements Serializable {
  
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
      * [KO] 품번 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String itnbr;
     /**
      * [KO] 품번  <br>
      * [EN] ITEM DESCRIPTION<br>
      * [JP] <br>
      */
     private String itdsc;
     /**
      * [KO] ITEM TYPE <br>
      * [EN] ITEM TYPE <br>
      * [JP] <br>
      */
     private String ittyp;
     /**
      * [KO] ITEM CLASS <br>
      * [EN] ITEM CLASS<br>
      * [JP] <br>
      */
     private String itcls;
     /**
      * [KO] PACKING CODE <br>
      * [EN] PACKING CODE <br>
      * [JP] <br>
      */
     private String packc;
     /**
      * [KO] PLANNER <br>
      * [EN] PLANNER <br>
      * [JP] <br>
      */
     private String plann;
     /**
      * [KO] MANUFACTURING COST <br>
      * [EN] MANUFACTURING COST <br>
      * [JP] <br>
      */
     private String mnfcs;
     /**
      * [KO] 전월재고 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d0bfj;
     /**
      * [KO] 투입수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d0inp;
     /**
      * [KO] 실적수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d0out;
     /**
      * [KO] 불량수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d0bad;
     /**
      * [KO] 전월재고 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d1bfj;
     /**
      * [KO] 투입수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d1inp;
     /**
      * [KO] 실적수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d1out;
     /**
      * [KO] 불량수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d1bad;
     /**
      * [KO] 전월재고 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d2bfj;
     /**
      * [KO] 투입수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d2inp;
     /**
      * [KO] 실적수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d2out;
     /**
      * [KO] 불량수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d2bad;
     /**
      * [KO] 전월재고 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d3bfj;
     /**
      * [KO] 투입수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d3inp;
     /**
      * [KO] 실적수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d3out;
     /**
      * [KO] 불량수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d3bad;
     /**
      * [KO] 전월재고 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d4bfj;
     /**
      * [KO] 투입수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d4inp;
     /**
      * [KO] 실적수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d4out;
     /**
      * [KO] 불량수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d4bad;
     /**
      * [KO] 전월재고 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d5bfj;
     /**
      * [KO] 투입수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d5inp;
     /**
      * [KO] 실적수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d5out;
     /**
      * [KO] 불량수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String d5bad;
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public WipReportDomain() {
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
	 * @return the itnbr
	 */
	public String getItnbr() {
		return itnbr;
	}

	/**
	 * @param itnbr the itnbr to set
	 */
	public void setItnbr(String itnbr) {
		this.itnbr = itnbr;
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
	 * @return the d0bfj
	 */
	public String getD0bfj() {
		return d0bfj;
	}

	/**
	 * @param d0bfj the d0bfj to set
	 */
	public void setD0bfj(String d0bfj) {
		this.d0bfj = d0bfj;
	}

	/**
	 * @return the d0inp
	 */
	public String getD0inp() {
		return d0inp;
	}

	/**
	 * @param d0inp the d0inp to set
	 */
	public void setD0inp(String d0inp) {
		this.d0inp = d0inp;
	}

	/**
	 * @return the d0out
	 */
	public String getD0out() {
		return d0out;
	}

	/**
	 * @param d0out the d0out to set
	 */
	public void setD0out(String d0out) {
		this.d0out = d0out;
	}

	/**
	 * @return the d0bad
	 */
	public String getD0bad() {
		return d0bad;
	}

	/**
	 * @param d0bad the d0bad to set
	 */
	public void setD0bad(String d0bad) {
		this.d0bad = d0bad;
	}

	/**
	 * @return the d1bfj
	 */
	public String getD1bfj() {
		return d1bfj;
	}

	/**
	 * @param d1bfj the d1bfj to set
	 */
	public void setD1bfj(String d1bfj) {
		this.d1bfj = d1bfj;
	}

	/**
	 * @return the d1inp
	 */
	public String getD1inp() {
		return d1inp;
	}

	/**
	 * @param d1inp the d1inp to set
	 */
	public void setD1inp(String d1inp) {
		this.d1inp = d1inp;
	}

	/**
	 * @return the d1out
	 */
	public String getD1out() {
		return d1out;
	}

	/**
	 * @param d1out the d1out to set
	 */
	public void setD1out(String d1out) {
		this.d1out = d1out;
	}

	/**
	 * @return the d1bad
	 */
	public String getD1bad() {
		return d1bad;
	}

	/**
	 * @param d1bad the d1bad to set
	 */
	public void setD1bad(String d1bad) {
		this.d1bad = d1bad;
	}

	/**
	 * @return the d2bfj
	 */
	public String getD2bfj() {
		return d2bfj;
	}

	/**
	 * @param d2bfj the d2bfj to set
	 */
	public void setD2bfj(String d2bfj) {
		this.d2bfj = d2bfj;
	}

	/**
	 * @return the d2inp
	 */
	public String getD2inp() {
		return d2inp;
	}

	/**
	 * @param d2inp the d2inp to set
	 */
	public void setD2inp(String d2inp) {
		this.d2inp = d2inp;
	}

	/**
	 * @return the d2out
	 */
	public String getD2out() {
		return d2out;
	}

	/**
	 * @param d2out the d2out to set
	 */
	public void setD2out(String d2out) {
		this.d2out = d2out;
	}

	/**
	 * @return the d2bad
	 */
	public String getD2bad() {
		return d2bad;
	}

	/**
	 * @param d2bad the d2bad to set
	 */
	public void setD2bad(String d2bad) {
		this.d2bad = d2bad;
	}

	/**
	 * @return the d3bfj
	 */
	public String getD3bfj() {
		return d3bfj;
	}

	/**
	 * @param d3bfj the d3bfj to set
	 */
	public void setD3bfj(String d3bfj) {
		this.d3bfj = d3bfj;
	}

	/**
	 * @return the d3inp
	 */
	public String getD3inp() {
		return d3inp;
	}

	/**
	 * @param d3inp the d3inp to set
	 */
	public void setD3inp(String d3inp) {
		this.d3inp = d3inp;
	}

	/**
	 * @return the d3out
	 */
	public String getD3out() {
		return d3out;
	}

	/**
	 * @param d3out the d3out to set
	 */
	public void setD3out(String d3out) {
		this.d3out = d3out;
	}

	/**
	 * @return the d3bad
	 */
	public String getD3bad() {
		return d3bad;
	}

	/**
	 * @param d3bad the d3bad to set
	 */
	public void setD3bad(String d3bad) {
		this.d3bad = d3bad;
	}

	/**
	 * @return the d4bfj
	 */
	public String getD4bfj() {
		return d4bfj;
	}

	/**
	 * @param d4bfj the d4bfj to set
	 */
	public void setD4bfj(String d4bfj) {
		this.d4bfj = d4bfj;
	}

	/**
	 * @return the d4inp
	 */
	public String getD4inp() {
		return d4inp;
	}

	/**
	 * @param d4inp the d4inp to set
	 */
	public void setD4inp(String d4inp) {
		this.d4inp = d4inp;
	}

	/**
	 * @return the d4out
	 */
	public String getD4out() {
		return d4out;
	}

	/**
	 * @param d4out the d4out to set
	 */
	public void setD4out(String d4out) {
		this.d4out = d4out;
	}

	/**
	 * @return the d4bad
	 */
	public String getD4bad() {
		return d4bad;
	}

	/**
	 * @param d4bad the d4bad to set
	 */
	public void setD4bad(String d4bad) {
		this.d4bad = d4bad;
	}

	/**
	 * @return the d5bfj
	 */
	public String getD5bfj() {
		return d5bfj;
	}

	/**
	 * @param d5bfj the d5bfj to set
	 */
	public void setD5bfj(String d5bfj) {
		this.d5bfj = d5bfj;
	}

	/**
	 * @return the d5inp
	 */
	public String getD5inp() {
		return d5inp;
	}

	/**
	 * @param d5inp the d5inp to set
	 */
	public void setD5inp(String d5inp) {
		this.d5inp = d5inp;
	}

	/**
	 * @return the d5out
	 */
	public String getD5out() {
		return d5out;
	}

	/**
	 * @param d5out the d5out to set
	 */
	public void setD5out(String d5out) {
		this.d5out = d5out;
	}

	/**
	 * @return the d5bad
	 */
	public String getD5bad() {
		return d5bad;
	}

	/**
	 * @param d5bad the d5bad to set
	 */
	public void setD5bad(String d5bad) {
		this.d5bad = d5bad;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("itnbr", this.itnbr);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("packc", this.packc);
        jsonObj.put("plann", this.plann);
        jsonObj.put("mnfcs", this.mnfcs);
        jsonObj.put("d0bfj", this.d0bfj);
        jsonObj.put("d0inp", this.d0inp);
        jsonObj.put("d0out", this.d0out);
        jsonObj.put("d0bad", this.d0bad);
        jsonObj.put("d1bfj", this.d1bfj);
        jsonObj.put("d1inp", this.d1inp);
        jsonObj.put("d1out", this.d1out);
        jsonObj.put("d1bad", this.d1bad);
        jsonObj.put("d2bfj", this.d2bfj);
        jsonObj.put("d2inp", this.d2inp);
        jsonObj.put("d2out", this.d2out);
        jsonObj.put("d2bad", this.d2bad);
        jsonObj.put("d3bfj", this.d3bfj);
        jsonObj.put("d3inp", this.d3inp);
        jsonObj.put("d3out", this.d3out);
        jsonObj.put("d3bad", this.d3bad);
        jsonObj.put("d4bfj", this.d4bfj);
        jsonObj.put("d4inp", this.d4inp);
        jsonObj.put("d4out", this.d4out);
        jsonObj.put("d4bad", this.d4bad);
        jsonObj.put("d5bfj", this.d5bfj);
        jsonObj.put("d5inp", this.d5inp);
        jsonObj.put("d5out", this.d5out);
        jsonObj.put("d5bad", this.d5bad);
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}

