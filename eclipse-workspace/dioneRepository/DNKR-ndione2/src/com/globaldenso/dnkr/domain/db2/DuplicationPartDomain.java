package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 영업출하현황 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class DuplicationPartDomain extends CommonDb2Domain implements Serializable {
  
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

    
    
    private String duplication_count; 
    private String tcode; 
    private String trnno; 
    private String tagcd; 
    private String insno; 
    private String prtno; 
    private String house; 
    private String trndt; 
    private String qtycd; 
    private String trqty; 
    private String succd; 
    private String slpno; 
	private String ngdcd; 
	private String reasn; 
	private String price; 
	private String curcy; 
	private String purum; 
	private String umcnv; 
	private String itcls;
	private String clsno; 
	private String cprno;
	private String duedt;
	private String orqty;
	private String pdtz6;
	private String devid;
	private String terno;
	private String sradr;
	private String linid;
    
   
	public int getRowNumFrom() {
		return rowNumFrom;
	}



	public int getRowNumTo() {
		return rowNumTo;
	}



	public int getRowCnt() {
		return rowCnt;
	}



	public String getStartDate() {
		return startDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public String getYear() {
		return year;
	}



	public String getDuplication_count() {
		return duplication_count;
	}



	public String getTcode() {
		return tcode;
	}



	public String getTrnno() {
		return trnno;
	}



	public String getTagcd() {
		return tagcd;
	}



	public String getInsno() {
		return insno;
	}



	public String getPrtno() {
		return prtno;
	}



	public String getHouse() {
		return house;
	}



	public String getTrndt() {
		return trndt;
	}



	public String getQtycd() {
		return qtycd;
	}



	public String getTrqty() {
		return trqty;
	}



	public String getSuccd() {
		return succd;
	}



	public String getSlpno() {
		return slpno;
	}



	public String getNgdcd() {
		return ngdcd;
	}



	public String getReasn() {
		return reasn;
	}



	public String getPrice() {
		return price;
	}



	public String getCurcy() {
		return curcy;
	}



	public String getPurum() {
		return purum;
	}



	public String getUmcnv() {
		return umcnv;
	}



	public String getItcls() {
		return itcls;
	}



	public String getClsno() {
		return clsno;
	}



	public String getCprno() {
		return cprno;
	}



	public String getDuedt() {
		return duedt;
	}



	public String getOrqty() {
		return orqty;
	}



	public String getPdtz6() {
		return pdtz6;
	}



	public String getDevid() {
		return devid;
	}



	public String getTerno() {
		return terno;
	}



	public String getSradr() {
		return sradr;
	}



	public String getLinid() {
		return linid;
	}



	public void setRowNumFrom(int rowNumFrom) {
		this.rowNumFrom = rowNumFrom;
	}



	public void setRowNumTo(int rowNumTo) {
		this.rowNumTo = rowNumTo;
	}



	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public void setDuplication_count(String duplication_count) {
		this.duplication_count = duplication_count;
	}



	public void setTcode(String tcode) {
		this.tcode = tcode;
	}



	public void setTrnno(String trnno) {
		this.trnno = trnno;
	}



	public void setTagcd(String tagcd) {
		this.tagcd = tagcd;
	}



	public void setInsno(String insno) {
		this.insno = insno;
	}



	public void setPrtno(String prtno) {
		this.prtno = prtno;
	}



	public void setHouse(String house) {
		this.house = house;
	}



	public void setTrndt(String trndt) {
		this.trndt = trndt;
	}



	public void setQtycd(String qtycd) {
		this.qtycd = qtycd;
	}



	public void setTrqty(String trqty) {
		this.trqty = trqty;
	}



	public void setSuccd(String succd) {
		this.succd = succd;
	}



	public void setSlpno(String slpno) {
		this.slpno = slpno;
	}



	public void setNgdcd(String ngdcd) {
		this.ngdcd = ngdcd;
	}



	public void setReasn(String reasn) {
		this.reasn = reasn;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public void setCurcy(String curcy) {
		this.curcy = curcy;
	}



	public void setPurum(String purum) {
		this.purum = purum;
	}



	public void setUmcnv(String umcnv) {
		this.umcnv = umcnv;
	}



	public void setItcls(String itcls) {
		this.itcls = itcls;
	}



	public void setClsno(String clsno) {
		this.clsno = clsno;
	}



	public void setCprno(String cprno) {
		this.cprno = cprno;
	}



	public void setDuedt(String duedt) {
		this.duedt = duedt;
	}



	public void setOrqty(String orqty) {
		this.orqty = orqty;
	}



	public void setPdtz6(String pdtz6) {
		this.pdtz6 = pdtz6;
	}



	public void setDevid(String devid) {
		this.devid = devid;
	}



	public void setTerno(String terno) {
		this.terno = terno;
	}



	public void setSradr(String sradr) {
		this.sradr = sradr;
	}



	public void setLinid(String linid) {
		this.linid = linid;
	}
	

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("duplication_count", this.duplication_count);
        jsonObj.put("tcode", this.tcode);
        jsonObj.put("trnno", this.trnno);
        jsonObj.put("tagcd", this.tagcd);
        jsonObj.put("insno", this.insno);
        jsonObj.put("prtno", this.prtno);
        jsonObj.put("house", this.house);
        jsonObj.put("trndt", this.trndt);
        jsonObj.put("qtycd", this.qtycd);
        jsonObj.put("trqty", this.trqty);
        jsonObj.put("succd", this.succd);
        jsonObj.put("slpno", this.slpno);
        jsonObj.put("ngdcd", this.ngdcd);
        jsonObj.put("reasn", this.reasn);
        jsonObj.put("price", this.price);
        jsonObj.put("curcy", this.curcy);
        jsonObj.put("purum", this.purum);
        jsonObj.put("umcnv", this.umcnv);
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("clsno", this.clsno);
        jsonObj.put("cprno", this.cprno);
        jsonObj.put("duedt", this.duedt);
        jsonObj.put("orqty", this.orqty);
        jsonObj.put("pdtz6", this.pdtz6);
        jsonObj.put("devid", this.devid);
        jsonObj.put("terno", this.terno);
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

}