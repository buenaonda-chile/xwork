package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 영업출하현황 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class QrPartListDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 조회년도<br>
     * [EN] <br>
     * [JP] <br>
     */  
    private String partNum; 
    private String partName;    
    private String costumerNum;
	private String quantity;
	private String seq;
	private String lineCode;
	
	private String cinbr;
	private String ittyp;
	private String itdsc;
	private Integer qtypr;
	private String itcls;
	private String whslc = "";
	private String lotsz;
	private String mulqy;
	private String whslcdesc;
	
	private String prsnm ="";
	private Integer calculateQtypr;
	
	public int getRowNumFrom() {
		return rowNumFrom;
	}


	public int getRowNumTo() {
		return rowNumTo;
	}


	public int getRowCnt() {
		return rowCnt;
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


	public String getPartNum() {
		return partNum;
	}


	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}


	public String getCostumerNum() {
		return costumerNum;
	}


	public String getQuantity() {
		return quantity;
	}


	public String getSeq() {
		return seq;
	}


	public void setCostumerNum(String costumerNum) {
		this.costumerNum = costumerNum;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getPartName() {
		return partName;
	}


	public void setPartName(String partName) {
		this.partName = partName;
	}


	public String getCinbr() {
		return cinbr;
	}


	public String getIttyp() {
		return ittyp;
	}


	public String getItdsc() {
		return itdsc;
	}


	public Integer getQtypr() {
		return qtypr;
	}


	public String getItcls() {
		return itcls;
	}


	public void setCinbr(String cinbr) {
		this.cinbr = cinbr;
	}


	public void setIttyp(String ittyp) {
		this.ittyp = ittyp;
	}


	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}


	public void setQtypr(Integer qtypr) {
		this.qtypr = qtypr;
	}


	public void setItcls(String itcls) {
		this.itcls = itcls;
	}

	public String getWhslc() {
		return whslc;
	}


	public String getLotsz() {
		return lotsz;
	}


	public String getMulqy() {
		return mulqy;
	}


	public void setWhslc(String whslc) {
		this.whslc = whslc;
	}


	public void setLotsz(String lotsz) {
		this.lotsz = lotsz;
	}


	public void setMulqy(String mulqy) {
		this.mulqy = mulqy;
	}


	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("partNum", this.partNum);
        jsonObj.put("partName", this.partName);
        jsonObj.put("costumerNum", this.costumerNum);
        jsonObj.put("quantity", this.quantity);
        jsonObj.put("seq", this.seq);
        jsonObj.put("lineCode", this.lineCode);
        jsonObj.put("cinbr", this.cinbr);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("qtypr", this.qtypr);
        jsonObj.put("whslc", this.whslc);
        jsonObj.put("lotsz", this.lotsz);
        jsonObj.put("mulqy", this.mulqy);
        jsonObj.put("whslcdesc", this.whslcdesc);
        jsonObj.put("calculateQtypr", this.calculateQtypr);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }


	public String getLineCode() {
		return lineCode;
	}


	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}


	public String getPrsnm() {
		return prsnm;
	}


	public void setPrsnm(String prsnm) {
		this.prsnm = prsnm;
	}


	public Integer getCalculateQtypr() {
		return calculateQtypr;
	}


	public void setCalculateQtypr(Integer calculateQtypr) {
		this.calculateQtypr = calculateQtypr;
	}


	public String getWhslcdesc() {
		return whslcdesc;
	}


	public void setWhslcdesc(String whslcdesc) {
		this.whslcdesc = whslcdesc;
	}

}