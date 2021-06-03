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
public class ProductStockShippingReceivingDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 품번<br>
     * [EN] <br>
     * [JP] <br>
     */    
   private String pspno;    
   
    /**
     * [KO] 창고코드<br>
     * [EN] <br>
     * [JP] <br>
     */    
   private String house;       
   
   ///===
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi04;
   /**
    * [KO] 05월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi05;
   /**
    * [KO] 06월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi06;
   /**
    * [KO] 07실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi07;
   /**
    * [KO] 08월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi08;
   /**
    * [KO] 09월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi09;
   /**
    * [KO] 10월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi10;
   /**
    * [KO] 11월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi11;
   /**
    * [KO] 12월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi12;
   /**
    * [KO] 01월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi01;
   /**
    * [KO] 02월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi02;
   /**
    * [KO] 03월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imi03;
   /**
    * [KO] 04월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo04;
   /**
    * [KO] 05월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo05;
   /**
    * [KO] 06월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo06;
   /**
    * [KO] 07월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo07;
   /**
    * [KO] 08월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo08;
   /**
    * [KO] 09월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo09;
   /**
    * [KO] 10월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo10;
   /**
    * [KO] 11월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo11;
   /**
    * [KO] 12월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo12;
   /**
    * [KO] 01월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo01;
   /**
    * [KO] 02월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo02;
   /**
    * [KO] 03월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imo03;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc04;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc05;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc06;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc07;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc08;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc09;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc10;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc11;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc12;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc01;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc02;
   /**
    * [KO] 04월조정<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imc03;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq00;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq04;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq05;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq06;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq07;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq08;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq09;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq10;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq11;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq12;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq01;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq02;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String imq03;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif04;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif05;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif06;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif07;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif08;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif09;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif10;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif11;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif12;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif01;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif02;
   /**
    * [KO] 04월실사차이<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String dif03;
   
   /**
    * [KO] 전원재고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String preStock;
   
   /**
    * [KO] 당월입고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String inStock;
   
   /**
    * [KO] 당월출고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String outStock;
   
   /**
    * [KO] 당월재고<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String stock;
   /**
    * [KO] 재고금액<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String stockPrice;
   /**
    * [KO] 증감율<br>
    * [EN] <br>
    * [JP] <br>
    */
   private String increase;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public ProductStockShippingReceivingDomain() {
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
	 * @return the house
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(String house) {
		this.house = house;
	}

	/**
	 * @return the imi04
	 */
	public String getImi04() {
		return imi04;
	}

	/**
	 * @param imi04 the imi04 to set
	 */
	public void setImi04(String imi04) {
		this.imi04 = imi04;
	}

	/**
	 * @return the imi05
	 */
	public String getImi05() {
		return imi05;
	}

	/**
	 * @param imi05 the imi05 to set
	 */
	public void setImi05(String imi05) {
		this.imi05 = imi05;
	}

	/**
	 * @return the imi06
	 */
	public String getImi06() {
		return imi06;
	}

	/**
	 * @param imi06 the imi06 to set
	 */
	public void setImi06(String imi06) {
		this.imi06 = imi06;
	}

	/**
	 * @return the imi07
	 */
	public String getImi07() {
		return imi07;
	}

	/**
	 * @param imi07 the imi07 to set
	 */
	public void setImi07(String imi07) {
		this.imi07 = imi07;
	}

	/**
	 * @return the imi08
	 */
	public String getImi08() {
		return imi08;
	}

	/**
	 * @param imi08 the imi08 to set
	 */
	public void setImi08(String imi08) {
		this.imi08 = imi08;
	}

	/**
	 * @return the imi09
	 */
	public String getImi09() {
		return imi09;
	}

	/**
	 * @param imi09 the imi09 to set
	 */
	public void setImi09(String imi09) {
		this.imi09 = imi09;
	}

	/**
	 * @return the imi10
	 */
	public String getImi10() {
		return imi10;
	}

	/**
	 * @param imi10 the imi10 to set
	 */
	public void setImi10(String imi10) {
		this.imi10 = imi10;
	}

	/**
	 * @return the imi11
	 */
	public String getImi11() {
		return imi11;
	}

	/**
	 * @param imi11 the imi11 to set
	 */
	public void setImi11(String imi11) {
		this.imi11 = imi11;
	}

	/**
	 * @return the imi12
	 */
	public String getImi12() {
		return imi12;
	}

	/**
	 * @param imi12 the imi12 to set
	 */
	public void setImi12(String imi12) {
		this.imi12 = imi12;
	}

	/**
	 * @return the imi01
	 */
	public String getImi01() {
		return imi01;
	}

	/**
	 * @param imi01 the imi01 to set
	 */
	public void setImi01(String imi01) {
		this.imi01 = imi01;
	}

	/**
	 * @return the imi02
	 */
	public String getImi02() {
		return imi02;
	}

	/**
	 * @param imi02 the imi02 to set
	 */
	public void setImi02(String imi02) {
		this.imi02 = imi02;
	}

	/**
	 * @return the imi03
	 */
	public String getImi03() {
		return imi03;
	}

	/**
	 * @param imi03 the imi03 to set
	 */
	public void setImi03(String imi03) {
		this.imi03 = imi03;
	}

	/**
	 * @return the imo04
	 */
	public String getImo04() {
		return imo04;
	}

	/**
	 * @param imo04 the imo04 to set
	 */
	public void setImo04(String imo04) {
		this.imo04 = imo04;
	}

	/**
	 * @return the imo05
	 */
	public String getImo05() {
		return imo05;
	}

	/**
	 * @param imo05 the imo05 to set
	 */
	public void setImo05(String imo05) {
		this.imo05 = imo05;
	}

	/**
	 * @return the imo06
	 */
	public String getImo06() {
		return imo06;
	}

	/**
	 * @param imo06 the imo06 to set
	 */
	public void setImo06(String imo06) {
		this.imo06 = imo06;
	}

	/**
	 * @return the imo07
	 */
	public String getImo07() {
		return imo07;
	}

	/**
	 * @param imo07 the imo07 to set
	 */
	public void setImo07(String imo07) {
		this.imo07 = imo07;
	}

	/**
	 * @return the imo08
	 */
	public String getImo08() {
		return imo08;
	}

	/**
	 * @param imo08 the imo08 to set
	 */
	public void setImo08(String imo08) {
		this.imo08 = imo08;
	}

	/**
	 * @return the imo09
	 */
	public String getImo09() {
		return imo09;
	}

	/**
	 * @param imo09 the imo09 to set
	 */
	public void setImo09(String imo09) {
		this.imo09 = imo09;
	}

	/**
	 * @return the imo10
	 */
	public String getImo10() {
		return imo10;
	}

	/**
	 * @param imo10 the imo10 to set
	 */
	public void setImo10(String imo10) {
		this.imo10 = imo10;
	}

	/**
	 * @return the imo11
	 */
	public String getImo11() {
		return imo11;
	}

	/**
	 * @param imo11 the imo11 to set
	 */
	public void setImo11(String imo11) {
		this.imo11 = imo11;
	}

	/**
	 * @return the imo12
	 */
	public String getImo12() {
		return imo12;
	}

	/**
	 * @param imo12 the imo12 to set
	 */
	public void setImo12(String imo12) {
		this.imo12 = imo12;
	}

	/**
	 * @return the imo01
	 */
	public String getImo01() {
		return imo01;
	}

	/**
	 * @param imo01 the imo01 to set
	 */
	public void setImo01(String imo01) {
		this.imo01 = imo01;
	}

	/**
	 * @return the imo02
	 */
	public String getImo02() {
		return imo02;
	}

	/**
	 * @param imo02 the imo02 to set
	 */
	public void setImo02(String imo02) {
		this.imo02 = imo02;
	}

	/**
	 * @return the imo03
	 */
	public String getImo03() {
		return imo03;
	}

	/**
	 * @param imo03 the imo03 to set
	 */
	public void setImo03(String imo03) {
		this.imo03 = imo03;
	}

	/**
	 * @return the imq00
	 */
	public String getImq00() {
		return imq00;
	}

	/**
	 * @param imq00 the imq00 to set
	 */
	public void setImq00(String imq00) {
		this.imq00 = imq00;
	}

	/**
	 * @return the imq04
	 */
	public String getImq04() {
		return imq04;
	}

	/**
	 * @param imq04 the imq04 to set
	 */
	public void setImq04(String imq04) {
		this.imq04 = imq04;
	}

	/**
	 * @return the imq05
	 */
	public String getImq05() {
		return imq05;
	}

	/**
	 * @param imq05 the imq05 to set
	 */
	public void setImq05(String imq05) {
		this.imq05 = imq05;
	}

	/**
	 * @return the imq06
	 */
	public String getImq06() {
		return imq06;
	}

	/**
	 * @param imq06 the imq06 to set
	 */
	public void setImq06(String imq06) {
		this.imq06 = imq06;
	}

	/**
	 * @return the imq07
	 */
	public String getImq07() {
		return imq07;
	}

	/**
	 * @param imq07 the imq07 to set
	 */
	public void setImq07(String imq07) {
		this.imq07 = imq07;
	}

	/**
	 * @return the imq08
	 */
	public String getImq08() {
		return imq08;
	}

	/**
	 * @param imq08 the imq08 to set
	 */
	public void setImq08(String imq08) {
		this.imq08 = imq08;
	}

	/**
	 * @return the imq09
	 */
	public String getImq09() {
		return imq09;
	}

	/**
	 * @param imq09 the imq09 to set
	 */
	public void setImq09(String imq09) {
		this.imq09 = imq09;
	}

	/**
	 * @return the imq10
	 */
	public String getImq10() {
		return imq10;
	}

	/**
	 * @param imq10 the imq10 to set
	 */
	public void setImq10(String imq10) {
		this.imq10 = imq10;
	}

	/**
	 * @return the imq11
	 */
	public String getImq11() {
		return imq11;
	}

	/**
	 * @param imq11 the imq11 to set
	 */
	public void setImq11(String imq11) {
		this.imq11 = imq11;
	}

	/**
	 * @return the imq12
	 */
	public String getImq12() {
		return imq12;
	}

	/**
	 * @param imq12 the imq12 to set
	 */
	public void setImq12(String imq12) {
		this.imq12 = imq12;
	}

	/**
	 * @return the imq01
	 */
	public String getImq01() {
		return imq01;
	}

	/**
	 * @param imq01 the imq01 to set
	 */
	public void setImq01(String imq01) {
		this.imq01 = imq01;
	}

	/**
	 * @return the imq02
	 */
	public String getImq02() {
		return imq02;
	}

	/**
	 * @param imq02 the imq02 to set
	 */
	public void setImq02(String imq02) {
		this.imq02 = imq02;
	}

	/**
	 * @return the imq03
	 */
	public String getImq03() {
		return imq03;
	}

	/**
	 * @param imq03 the imq03 to set
	 */
	public void setImq03(String imq03) {
		this.imq03 = imq03;
	}

	/**
	 * @return the preStock
	 */
	public String getPreStock() {
		return preStock;
	}

	/**
	 * @param preStock the preStock to set
	 */
	public void setPreStock(String preStock) {
		this.preStock = preStock;
	}

	/**
	 * @return the inStock
	 */
	public String getInStock() {
		return inStock;
	}

	/**
	 * @param inStock the inStock to set
	 */
	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

	/**
	 * @return the outStock
	 */
	public String getOutStock() {
		return outStock;
	}

	/**
	 * @param outStock the outStock to set
	 */
	public void setOutStock(String outStock) {
		this.outStock = outStock;
	}

	/**
	 * @return the stock
	 */
	public String getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(String stock) {
		this.stock = stock;
	}

	/**
	 * @return the stockPrice
	 */
	public String getStockPrice() {
		return stockPrice;
	}

	/**
	 * @param stockPrice the stockPrice to set
	 */
	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	/**
	 * @return the increase
	 */
	public String getIncrease() {
		return increase;
	}

	/**
	 * @param increase the increase to set
	 */
	public void setIncrease(String increase) {
		this.increase = increase;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("house", this.house);
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}
