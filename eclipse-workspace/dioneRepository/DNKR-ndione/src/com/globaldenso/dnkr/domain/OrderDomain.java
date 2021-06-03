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
public class OrderDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143742L;
    
    /**
     * [KR] 수주업로드 키 <br>   
     */
    private String orderKey;
    
    /**
     * [KR] No <br>   
     */
    private String no;
    
    /**
     * [KR] 상품코드 <br>   
     */
    private String meterialNumber;
    
    /**
     * [KR] 상품명 <br>   
     */
    private String shortText;
    
    /**
     * [KR]  수주날짜<br>   
     */
    private String releaseDate;
    
    /**
     * [KR]  조회일자텍스트<br>   
     */
    private String orderDateStr;
    
    /**
     * [KR]  비고<br>   
     */
    private String baseUnitOfMeasure;
    
    /**
     * [KR]  등록일<br>   
     */
    private String regiDt;
    
    /**
     * [KR]  등록자<br>   
     */
    private String regiId;
    
    /**
     * [KR]  덴소 번호<br>   
     */
    private String densoNumber;
    
    /**
     * [KR]  ALC 정보<br>   
     */
    private String alc;
    
    /**
     * [KR]  덴소 창고('1'번) 정보<br>   
     */
    private String densoStockQty;
    
    /**
     * [KR]  고객(납입선) 번호<br>   
     */
    private String customerNumber;
    
    /**
     * [KR]  상품의 설명<br>   
     */
    private String materialDesc;
    
    /**
     * [KR]  총재고수<br>   
     */
    private String totalStockQty = "0";
    
    /**
     * [KR]  하위 qty 리스트<br>   
     */
    private List<OrderQtyDomain> qtyList;
    
    /**
     * [KR]  엑셀 타이틀 리스트<br>   
     */
    private List<String> titleList;
    
    /**
     * [KR]  업로드 성공 리스트<br>   
     */
    private List<OrderDomain> sucList;
    
    /**
     * [KR]  업로드 실패 리스트<br>   
     */
    private List<OrderDomain> failList;
    
    /**
     * [KR]  조회조건<br>   
     */
    private String stockFlag;
    
    /**
     * [KR]  조회일<br>   
     */
    private String searchDate;
    

	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public String getMeterialNumber() {
		return meterialNumber;
	}

	public void setMeterialNumber(String meterialNumber) {
		this.meterialNumber = meterialNumber;
	}

	public String getShortText() {
		return shortText;
	}

	public void setShortText(String shortText) {
		this.shortText = shortText;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getOrderDateStr() {
		return orderDateStr;
	}

	public void setOrderDateStr(String orderDateStr) {
		this.orderDateStr = orderDateStr;
	}

	public String getBaseUnitOfMeasure() {
		return baseUnitOfMeasure;
	}

	public void setBaseUnitOfMeasure(String baseUnitOfMeasure) {
		this.baseUnitOfMeasure = baseUnitOfMeasure;
	}

	public String getRegiDt() {
		return regiDt;
	}

	public void setRegiDt(String regiDt) {
		this.regiDt = regiDt;
	}

	public String getRegiId() {
		return regiId;
	}

	public void setRegiId(String regiId) {
		this.regiId = regiId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDensoNumber() {
		return densoNumber;
	}

	public void setDensoNumber(String densoNumber) {
		this.densoNumber = densoNumber;
	}

	public String getTotalStockQty() {
		return totalStockQty;
	}

	public void setTotalStockQty(String totalStockQty) {
		this.totalStockQty = totalStockQty;
	}


	public List<OrderDomain> getSucList() {
		return sucList;
	}

	public void setSucList(List<OrderDomain> sucList) {
		this.sucList = sucList;
	}

	public List<OrderDomain> getFailList() {
		return failList;
	}

	public void setFailList(List<OrderDomain> failList) {
		this.failList = failList;
	}

	public List<String> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<String> titleList) {
		this.titleList = titleList;
	}

	public List<OrderQtyDomain> getQtyList() {
		return qtyList;
	}

	public void setQtyList(List<OrderQtyDomain> qtyList) {
		this.qtyList = qtyList;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getStockFlag() {
		return stockFlag;
	}

	public void setStockFlag(String stockFlag) {
		this.stockFlag = stockFlag;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public String getAlc() {
		return alc;
	}

	public void setAlc(String alc) {
		this.alc = alc;
	}

	public String getDensoStockQty() {
		return densoStockQty;
	}

	public void setDensoStockQty(String densoStockQty) {
		this.densoStockQty = densoStockQty;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}
    
}
