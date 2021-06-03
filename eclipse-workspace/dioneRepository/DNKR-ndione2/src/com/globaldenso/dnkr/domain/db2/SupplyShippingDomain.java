package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class SupplyShippingDomain extends CommonDb2Domain implements Serializable {
  
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
     
     //DWH201PF
    /**
      * [KO] 사업부<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String comps;
     /**
      * [KO] 출고전표번호 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String isijp;
     /**
      * [KO] 출고부서업체 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String isdpt;
     
     /**
      * [KO] 출고부서 짧은명 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String dpconm;
     /**
      * [KO] 츨고일자 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String isidt;
     /**
      * [KO] 출고계정분류 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String isicl;
     /**
      * [KO] 출고품번 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String isipn;
     /**
      * [KO] 품명<br>
      * [EN] <br>
      * [JP] <br>
      */
     private String smonm;
     /**
      * [KO] 규격 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String smobd;
     /**
      * [KO] 등록일자 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String isadt;
     /**
      * [KO] 등록시간 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String istim;
     /**
      * [KO] 출고수량 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String chlqy;
     /**
      * [KO] 출고단가 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String rpist;
     /**
      * [KO] 출고음액 <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String chlam;
     /**
      * [KO] Business Unit <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String opmcu;
     /**
      * [KO] Obj Account <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String opobj;
     /**
      * [KO] Subsidiary <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String opsub;
     /**
      * [KO] JDE  DESCRIPTION <br>
      * [EN] <br>
      * [JP] <br>
      */
     private String gmdl0;
 
     
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public SupplyShippingDomain() {
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
	 * @return the isijp
	 */
	public String getIsijp() {
		return isijp;
	}

	/**
	 * @param isijp the isijp to set
	 */
	public void setIsijp(String isijp) {
		this.isijp = isijp;
	}

	/**
	 * @return the isdpt
	 */
	public String getIsdpt() {
		return isdpt;
	}

	/**
	 * @param isdpt the isdpt to set
	 */
	public void setIsdpt(String isdpt) {
		this.isdpt = isdpt;
	}

	/**
	 * @return the dpconm
	 */
	public String getDpconm() {
		return dpconm;
	}

	/**
	 * @param dpconm the dpconm to set
	 */
	public void setDpconm(String dpconm) {
		this.dpconm = dpconm;
	}

	/**
	 * @return the isidt
	 */
	public String getIsidt() {
		return isidt;
	}

	/**
	 * @param isidt the isidt to set
	 */
	public void setIsidt(String isidt) {
		this.isidt = isidt;
	}

	/**
	 * @return the isicl
	 */
	public String getIsicl() {
		return isicl;
	}

	/**
	 * @param isicl the isicl to set
	 */
	public void setIsicl(String isicl) {
		this.isicl = isicl;
	}

	/**
	 * @return the isipn
	 */
	public String getIsipn() {
		return isipn;
	}

	/**
	 * @param isipn the isipn to set
	 */
	public void setIsipn(String isipn) {
		this.isipn = isipn;
	}

	/**
	 * @return the smonm
	 */
	public String getSmonm() {
		return smonm;
	}

	/**
	 * @param smonm the smonm to set
	 */
	public void setSmonm(String smonm) {
		this.smonm = smonm;
	}

	/**
	 * @return the smobd
	 */
	public String getSmobd() {
		return smobd;
	}

	/**
	 * @param smobd the smobd to set
	 */
	public void setSmobd(String smobd) {
		this.smobd = smobd;
	}

	/**
	 * @return the isadt
	 */
	public String getIsadt() {
		return isadt;
	}

	/**
	 * @param isadt the isadt to set
	 */
	public void setIsadt(String isadt) {
		this.isadt = isadt;
	}

	/**
	 * @return the istim
	 */
	public String getIstim() {
		return istim;
	}

	/**
	 * @param istim the istim to set
	 */
	public void setIstim(String istim) {
		this.istim = istim;
	}

	/**
	 * @return the chlqy
	 */
	public String getChlqy() {
		return chlqy;
	}

	/**
	 * @param chlqy the chlqy to set
	 */
	public void setChlqy(String chlqy) {
		this.chlqy = chlqy;
	}

	/**
	 * @return the rpist
	 */
	public String getRpist() {
		return rpist;
	}

	/**
	 * @param rpist the rpist to set
	 */
	public void setRpist(String rpist) {
		this.rpist = rpist;
	}

	/**
	 * @return the chlam
	 */
	public String getChlam() {
		return chlam;
	}

	/**
	 * @param chlam the chlam to set
	 */
	public void setChlam(String chlam) {
		this.chlam = chlam;
	}

	/**
	 * @return the opmcu
	 */
	public String getOpmcu() {
		return opmcu;
	}

	/**
	 * @param opmcu the opmcu to set
	 */
	public void setOpmcu(String opmcu) {
		this.opmcu = opmcu;
	}

	/**
	 * @return the opobj
	 */
	public String getOpobj() {
		return opobj;
	}

	/**
	 * @param opobj the opobj to set
	 */
	public void setOpobj(String opobj) {
		this.opobj = opobj;
	}

	/**
	 * @return the opsub
	 */
	public String getOpsub() {
		return opsub;
	}

	/**
	 * @param opsub the opsub to set
	 */
	public void setOpsub(String opsub) {
		this.opsub = opsub;
	}

	/**
	 * @return the gmdl0
	 */
	public String getGmdl0() {
		return gmdl0;
	}

	/**
	 * @param gmdl0 the gmdl0 to set
	 */
	public void setGmdl0(String gmdl0) {
		this.gmdl0 = gmdl0;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("isijp", this.isijp);
        jsonObj.put("isdpt", this.isdpt);
        jsonObj.put("dpconm", this.dpconm);
        jsonObj.put("isidt", this.isidt);
        jsonObj.put("isicl", this.isicl);
        jsonObj.put("isipn", this.isipn);
        jsonObj.put("smonm", this.smonm);
        jsonObj.put("smobd", this.smobd);
        jsonObj.put("isadt", this.isadt);
        jsonObj.put("istim", this.istim);
        jsonObj.put("chlqy", this.chlqy);
        jsonObj.put("rpist", this.rpist);
        jsonObj.put("chlam", this.chlam);
        jsonObj.put("opmcu", this.opmcu);
        jsonObj.put("opobj", this.opobj);
        jsonObj.put("opsub", this.opsub);
        jsonObj.put("gmdl0", this.gmdl0);

        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}

