package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class MonthlyShipmentCheckDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 모품번 <br>
     * [EN] PARENT ITEM NUMBER<br>
     * [JP] <br>
     */
     private String pinbr;
     
     /**
      * [KO] 순번1 <br>
      * [EN] USER SEQUENCE <br>
      * [JP] <br>
      */
     private String usrs1;
     /**
      * [KO] 자품번 <br>
      * [EN] COMPONENT ITEM NUMBER <br>
      * [JP] <br>
      */
     private String cinbr;

     /**
      * [KO] 순번2 <br>
      * [EN] USER SEQUENCE <br>
      * [JP] <br>
      */
     private String usrs2;
     /**
      * [KO] 사용기간 시작일 <br>
      * [EN] EFFECTIVE DATE FROM <br>
      * [JP] <br>
      */
     private String edatm;
     /**
      * [KO] 사용기간 종료일 <br>
      * [EN] EFFECTIVE DATE TO <br>
      * [JP] <br>
      */
     private String edato;
     /**
      * [KO] 수정일 <br>
      * [EN] DATE THIS RECORD LAST MAINTAINED<br>
      * [JP] <br>
      */
     private String mdate;
     /**
      * [KO] 양  <br>
      * [EN] QUANTITY PER UNIT <br>
      * [JP] <br>
      */
     private String qtypr;
     
     /**
      * [KO] 단위  <br>
      * [EN] UNIT OF MEASURE <br>
      * [JP] <br>
      */
     private String unmsr;
    
     
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public MonthlyShipmentCheckDomain() {
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
 
	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public String getPinbr() {
		return pinbr;
	}

	public void setPinbr(String pinbr) {
		this.pinbr = pinbr;
	}

	public String getUsrs1() {
		return usrs1;
	}

	public void setUsrs1(String usrs1) {
		this.usrs1 = usrs1;
	}

	public String getCinbr() {
		return cinbr;
	}

	public void setCinbr(String cinbr) {
		this.cinbr = cinbr;
	}

	public String getUsrs2() {
		return usrs2;
	}

	public void setUsrs2(String usrs2) {
		this.usrs2 = usrs2;
	}

	public String getEdatm() {
		return edatm;
	}

	public void setEdatm(String edatm) {
		this.edatm = edatm;
	}

	public String getEdato() {
		return edato;
	}

	public void setEdato(String edato) {
		this.edato = edato;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public String getQtypr() {
		return qtypr;
	}

	public void setQtypr(String qtypr) {
		this.qtypr = qtypr;
	}

	public String getUnmsr() {
		return unmsr;
	}

	public void setUnmsr(String unmsr) {
		this.unmsr = unmsr;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("pinbr", this.pinbr);
        jsonObj.put("usrs1", this.usrs1);
        jsonObj.put("cinbr", this.cinbr);
        jsonObj.put("usrs2", this.usrs2);
        jsonObj.put("edatm", this.edatm);
        jsonObj.put("edato", this.edato);
        jsonObj.put("mdate", this.mdate);
        jsonObj.put("qtypr", this.qtypr);
        jsonObj.put("unmsr", this.unmsr);

        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}
