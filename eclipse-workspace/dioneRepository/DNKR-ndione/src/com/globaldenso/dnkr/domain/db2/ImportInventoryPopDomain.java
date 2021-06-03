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
public class ImportInventoryPopDomain extends CommonDb2Domain implements Serializable {
  
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
    
	//POP1	
    /**
     * [KO] 수입품번<br>
     * [EN] <br>
     * [JP] <br>
     */    
   private String expno;    
   	
	/**
	* [KO] 품명<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String exdsc;
	/**
	* [KO] HSNO<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String exphs;
	/**
	* [KO] 안전재고<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String exrtt;
	/**
	* [KO] 차종코드<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String carcd;
	/**
	* [KO] 차종명<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String carnm;
	
	/**
	* [KO] 구입업체코드<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String vndnr;
	/**
	* [KO] 구입업체명<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String vname;
	/**
	* [KO] 덴소품번<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String pspno;
	/**
	* [KO] 단위환산<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String exrat;
	
	/**
	* [KO] ??<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String buycd;
	/**
	* [KO] ??<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String buyrm;
	
	/**
	* [KO] 무상사급<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String d1;
	
	/**
	* [KO] 발주재고<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String d2;
	/**
	* [KO] 보세재고<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String d3;
	/**
	* [KO] 자재재고<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String d4;
	/**
	* [KO] 재고합계<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String d5;
	/**
	* [KO] 미통관수<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String d6;
	/**
	* [KO] 기준변경소요량 M월<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String m00qy;
	/**
	* [KO] 기준변경소요량 M+1월<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String m10qy;
	/**
	* [KO] 기준변경소요량 M+2월<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String m20qy;
	/**
	* [KO]기준변경소요량 M+3월<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String m30qy;
	/**
	* [KO] 일소요량<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String smdqy1;
	/**
	* [KO] 현재고일<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String smddt1;
	/**
	* [KO] 안전재고<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String smaqy1;
	/**
	* [KO] 안전일수<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String smadt1;
	/**
	* [KO] 과소재고<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String smcqy1;	
	
	/**
	* [KO] 과소일수<br>
	* [EN] <br>
	* [JP] <br>
	*/
	private String smcdt1;

	//POP2
	/**
	* [KO] 주문번호<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String order;
	/**
	* [KO] 납기일자<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String dudat;
	/**
	* [KO] 발주수량<br>
	* [EN] <br>
	* [JP] <br>
	*/    	
	private String orqty;
	
		

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public ImportInventoryPopDomain() {
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
	 * @return the expno
	 */
	public String getExpno() {
		return expno;
	}

	/**
	 * @param expno the expno to set
	 */
	public void setExpno(String expno) {
		this.expno = expno;
	}

	


	/**
	 * @return the exdsc
	 */
	public String getExdsc() {
		return exdsc;
	}

	/**
	 * @param exdsc the exdsc to set
	 */
	public void setExdsc(String exdsc) {
		this.exdsc = exdsc;
	}

	/**
	 * @return the exphs
	 */
	public String getExphs() {
		return exphs;
	}

	/**
	 * @param exphs the exphs to set
	 */
	public void setExphs(String exphs) {
		this.exphs = exphs;
	}

	/**
	 * @return the exrtt
	 */
	public String getExrtt() {
		return exrtt;
	}

	/**
	 * @param exrtt the exrtt to set
	 */
	public void setExrtt(String exrtt) {
		this.exrtt = exrtt;
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
	 * @return the carnm
	 */
	public String getCarnm() {
		return carnm;
	}

	/**
	 * @param carnm the carnm to set
	 */
	public void setCarnm(String carnm) {
		this.carnm = carnm;
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

	/**
	 * @return the vname
	 */
	public String getVname() {
		return vname;
	}

	/**
	 * @param vname the vname to set
	 */
	public void setVname(String vname) {
		this.vname = vname;
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
	 * @return the exrat
	 */
	public String getExrat() {
		return exrat;
	}

	/**
	 * @param exrat the exrat to set
	 */
	public void setExrat(String exrat) {
		this.exrat = exrat;
	}

	/**
	 * @return the d1
	 */
	public String getD1() {
		return d1;
	}

	/**
	 * @param d1 the d1 to set
	 */
	public void setD1(String d1) {
		this.d1 = d1;
	}

	/**
	 * @return the d2
	 */
	public String getD2() {
		return d2;
	}

	/**
	 * @param d2 the d2 to set
	 */
	public void setD2(String d2) {
		this.d2 = d2;
	}

	/**
	 * @return the d3
	 */
	public String getD3() {
		return d3;
	}

	/**
	 * @param d3 the d3 to set
	 */
	public void setD3(String d3) {
		this.d3 = d3;
	}

	/**
	 * @return the d4
	 */
	public String getD4() {
		return d4;
	}

	/**
	 * @param d4 the d4 to set
	 */
	public void setD4(String d4) {
		this.d4 = d4;
	}

	/**
	 * @return the d5
	 */
	public String getD5() {
		return d5;
	}

	/**
	 * @param d5 the d5 to set
	 */
	public void setD5(String d5) {
		this.d5 = d5;
	}

	/**
	 * @return the d6
	 */
	public String getD6() {
		return d6;
	}

	/**
	 * @param d6 the d6 to set
	 */
	public void setD6(String d6) {
		this.d6 = d6;
	}

	/**
	 * @return the m00qy
	 */
	public String getM00qy() {
		return m00qy;
	}

	/**
	 * @param m00qy the m00qy to set
	 */
	public void setM00qy(String m00qy) {
		this.m00qy = m00qy;
	}

	/**
	 * @return the m10qy
	 */
	public String getM10qy() {
		return m10qy;
	}

	/**
	 * @param m10qy the m10qy to set
	 */
	public void setM10qy(String m10qy) {
		this.m10qy = m10qy;
	}

	/**
	 * @return the m20qy
	 */
	public String getM20qy() {
		return m20qy;
	}

	/**
	 * @param m20qy the m20qy to set
	 */
	public void setM20qy(String m20qy) {
		this.m20qy = m20qy;
	}

	/**
	 * @return the m30qy
	 */
	public String getM30qy() {
		return m30qy;
	}

	/**
	 * @param m30qy the m30qy to set
	 */
	public void setM30qy(String m30qy) {
		this.m30qy = m30qy;
	}

	/**
	 * @return the smdqy1
	 */
	public String getSmdqy1() {
		return smdqy1;
	}

	/**
	 * @param smdqy1 the smdqy1 to set
	 */
	public void setSmdqy1(String smdqy1) {
		this.smdqy1 = smdqy1;
	}

	/**
	 * @return the smddt1
	 */
	public String getSmddt1() {
		return smddt1;
	}

	/**
	 * @param smddt1 the smddt1 to set
	 */
	public void setSmddt1(String smddt1) {
		this.smddt1 = smddt1;
	}

	/**
	 * @return the smaqy1
	 */
	public String getSmaqy1() {
		return smaqy1;
	}

	/**
	 * @param smaqy1 the smaqy1 to set
	 */
	public void setSmaqy1(String smaqy1) {
		this.smaqy1 = smaqy1;
	}

	/**
	 * @return the smadt1
	 */
	public String getSmadt1() {
		return smadt1;
	}

	/**
	 * @param smadt1 the smadt1 to set
	 */
	public void setSmadt1(String smadt1) {
		this.smadt1 = smadt1;
	}

	/**
	 * @return the smcqy1
	 */
	public String getSmcqy1() {
		return smcqy1;
	}

	/**
	 * @param smcqy1 the smcqy1 to set
	 */
	public void setSmcqy1(String smcqy1) {
		this.smcqy1 = smcqy1;
	}

	/**
	 * @return the smcdt1
	 */
	public String getSmcdt1() {
		return smcdt1;
	}

	/**
	 * @param smcdt1 the smcdt1 to set
	 */
	public void setSmcdt1(String smcdt1) {
		this.smcdt1 = smcdt1;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the dudat
	 */
	public String getDudat() {
		return dudat;
	}

	/**
	 * @param dudat the dudat to set
	 */
	public void setDudat(String dudat) {
		this.dudat = dudat;
	}

	/**
	 * @return the orqty
	 */
	public String getOrqty() {
		return orqty;
	}

	/**
	 * @param orqty the orqty to set
	 */
	public void setOrqty(String orqty) {
		this.orqty = orqty;
	}

	
	/* (non-Javadoc)
	 * @see com.globaldenso.dnkr.domain.db2.CommonDb2Domain#getComps()
	 */
	@Override
	public String getComps() {
		// TODO Auto-generated method stub
		return super.getComps();
	}

	/* (non-Javadoc)
	 * @see com.globaldenso.dnkr.domain.db2.CommonDb2Domain#setComps(java.lang.String)
	 */
	@Override
	public void setComps(String comps) {
		// TODO Auto-generated method stub
		super.setComps(comps);
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.getComps());
        jsonObj.put("expno", this.expno);
        jsonObj.put("exdsc", this.exdsc);
        jsonObj.put("exphs", this.exphs);
        jsonObj.put("exrtt", this.exrtt);
        jsonObj.put("carcd", this.carcd);
        jsonObj.put("carnm", this.carnm);
        jsonObj.put("vndnr", this.vndnr);
        jsonObj.put("vname", this.vname);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("exrat", this.exrat);
        jsonObj.put("d1", this.d1);
        jsonObj.put("d2", this.d2);
        jsonObj.put("d3", this.d3);
        jsonObj.put("d4", this.d4);
        jsonObj.put("d5", this.d5);
        jsonObj.put("d6", this.d6);
        jsonObj.put("m00qy", this.m00qy);
        jsonObj.put("m10qy", this.m10qy);
        jsonObj.put("m20qy", this.m20qy);
        jsonObj.put("m30qy", this.m30qy);
        jsonObj.put("smdqy1", this.smdqy1);
        jsonObj.put("smddt1", this.smddt1);
        jsonObj.put("smaqy1", this.smaqy1);
        jsonObj.put("smadt1", this.smadt1);
        jsonObj.put("smcdt1", this.smcdt1);
        jsonObj.put("smcqy1", this.smcqy1);
        
        jsonObj.put("order", this.order);
        jsonObj.put("dudat", this.dudat);
        jsonObj.put("orqty", this.orqty);
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}

