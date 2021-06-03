package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * [KR] 메뉴관리 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class SheetDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143742L;
    
    /**
     * [KR] AS수량 <br>   
     */
    private String asQty;

    /**
     * [KR] 전일재고 <br>   
     */
    private String beforeStockQty;

    /**
     * [KR] 불량수량 <br>   
     */
    private String badQty;

    /**
     * [KR] BL번호 <br>   
     */
    private String blNo;

    /**
     * [KR] 화주코드 <br>   
     */
    private String custCd;

    /**
     * [KR] LOT번호 <br>   
     */
    private String custLotNo;

    /**
     * [KR] 화주명 <br>   
     */
    private String custNm;

    /**
     * [KR] 입고수량 <br>   
     */
    private String inQty;

    /**
     * [KR] 유통기한만료일 <br>   
     */
    private String itemBestDateEnd;

    /**
     * [KR] 상품군 <br>   
     */
    private String itemGrpNm;

    /**
     * [KR] 로케이션코드 <br>   
     */
    private String locCd;

    /**
     * [KR] 제조일 <br>   
     */
    private String makeDt;

    /**
     * [KR] 출고수량 <br>   
     */
    private String outQty;

    /**
     * [KR] 안전재고체크 <br>   
     */
    private String propChk;
    
    /**
     * [KR] 안전재고수량 <br>   
     */
    private String propQty;
    
    /**
     * [KR] 물류용기수량 <br>   
     */
    private String realPltQty;
    
    /**
     * [KR] 센터화주상품ID <br>   
     */
    private String ritemId;
    
    /**
     * [KR] 센터화주상품코드 <br>   
     */
    private String ritemCd;
    
    /**
     * [KR] 센터화주상품명 <br>   
     */
    private String ritemNm;
    
    /**
     * [KR] 재고수량 <br>   
     */
    private String stockQty;
    
    /**
     * [KR] 재고중량 <br>   
     */
    private String stockWeight;
    
    /**
     * [KR] UOM <br>   
     */
    private String uomNm;
    
    /**
     * [KR] 창고명 <br>   
     */
    private String whNm;
    
    /**
     * [KR] 입고일 <br>   
     */
    private String InDt;

    
	public String getAsQty() {
		return asQty;
	}

	public void setAsQty(String asQty) {
		this.asQty = asQty;
	}

	public String getBeforeStockQty() {
		return beforeStockQty;
	}

	public void setBeforeStockQty(String beforeStockQty) {
		this.beforeStockQty = beforeStockQty;
	}

	public String getBadQty() {
		return badQty;
	}

	public void setBadQty(String badQty) {
		this.badQty = badQty;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	public String getCustLotNo() {
		return custLotNo;
	}

	public void setCustLotNo(String custLotNo) {
		this.custLotNo = custLotNo;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getInQty() {
		return inQty;
	}

	public void setInQty(String inQty) {
		this.inQty = inQty;
	}

	public String getItemBestDateEnd() {
		return itemBestDateEnd;
	}

	public void setItemBestDateEnd(String itemBestDateEnd) {
		this.itemBestDateEnd = itemBestDateEnd;
	}

	public String getItemGrpNm() {
		return itemGrpNm;
	}

	public void setItemGrpNm(String itemGrpNm) {
		this.itemGrpNm = itemGrpNm;
	}

	public String getLocCd() {
		return locCd;
	}

	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}

	public String getMakeDt() {
		return makeDt;
	}

	public void setMakeDt(String makeDt) {
		this.makeDt = makeDt;
	}

	public String getOutQty() {
		return outQty;
	}

	public void setOutQty(String outQty) {
		this.outQty = outQty;
	}

	public String getPropChk() {
		return propChk;
	}

	public void setPropChk(String propChk) {
		this.propChk = propChk;
	}

	public String getPropQty() {
		return propQty;
	}

	public void setPropQty(String propQty) {
		this.propQty = propQty;
	}

	public String getRealPltQty() {
		return realPltQty;
	}

	public void setRealPltQty(String realPltQty) {
		this.realPltQty = realPltQty;
	}

	public String getRitemId() {
		return ritemId;
	}

	public void setRitemId(String ritemId) {
		this.ritemId = ritemId;
	}

	public String getRitemCd() {
		return ritemCd;
	}

	public void setRitemCd(String ritemCd) {
		this.ritemCd = ritemCd;
	}

	public String getRitemNm() {
		return ritemNm;
	}

	public void setRitemNm(String ritemNm) {
		this.ritemNm = ritemNm;
	}

	public String getStockQty() {
		return stockQty;
	}

	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}

	public String getStockWeight() {
		return stockWeight;
	}

	public void setStockWeight(String stockWeight) {
		this.stockWeight = stockWeight;
	}

	public String getUomNm() {
		return uomNm;
	}

	public void setUomNm(String uomNm) {
		this.uomNm = uomNm;
	}

	public String getWhNm() {
		return whNm;
	}

	public void setWhNm(String whNm) {
		this.whNm = whNm;
	}

	public String getInDt() {
		return InDt;
	}

	public void setInDt(String inDt) {
		InDt = inDt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
