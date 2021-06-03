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
public class DomesticPurchasePriceListDomain extends CommonDb2Domain implements Serializable {
  
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
    * [KO] 제품<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String itcls;
        
    /**
    * [KO] 입고업체 <br>
    * [EN] <br>
    * [JP] <br>
    */
    private String vndnr;
    
    /**
    * [KO] 품번 <br>
    * [EN] <br>
    * [JP] <br>
    */
    private String pspno;
    
    /**
    * [KO] 품명 <br>
    * [EN] <br>
    * [JP] <br>
    */
    private String itdsc;
    
    /**
    * [KO] 입고일자 <br>
    * [EN] <br>
    * [JP] <br>
    */
    private String trndt;
    
    /**
    * [KO] 거래수량 <br>
    * [EN] <br>
    * [JP] <br>
    */
    private String trqty;
    
    /**
    * [KO] 단가구분 <br>
    * [EN] <br>
    * [JP] <br>
    */
    private String trfot;
    
    /**
    * [KO] 거래단가 <br>
    * [EN] <br>
    * [JP] <br>
    */
    private String trcst;
    
  
    
    private String performanceDivision;
    
    /**                 
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public DomesticPurchasePriceListDomain() {
        // no process
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
	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("vndnr", this.vndnr);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("trndt", this.trndt);
        jsonObj.put("trqty", this.trqty);
        jsonObj.put("trfot", this.trfot);
        jsonObj.put("trcst", this.trcst);

        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }	

}
