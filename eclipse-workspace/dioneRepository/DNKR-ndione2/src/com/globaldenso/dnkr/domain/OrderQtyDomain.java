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
public class OrderQtyDomain extends OrderDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143742L;
    
    /**
     * [KR] 날짜 <br>   
     */
    private String orderDate;
    
    /**
     * [KR] 수량 <br>   
     */
    private String orderQty;
    
    /**
     * [KR] 수량 <br>   
     */
    private String stockQty;

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStockQty() {
		return stockQty;
	}

	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}
    
}
