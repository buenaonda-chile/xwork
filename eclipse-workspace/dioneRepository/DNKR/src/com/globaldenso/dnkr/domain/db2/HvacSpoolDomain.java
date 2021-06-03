package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 영업출하현황 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class HvacSpoolDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 조회년도<br>
     * [EN] <br>
     * [JP] <br>
     */
	private String searchDate;
	private String searchKubun = "";	
	private String searchPrdcd;
	private String searchHouse;

	
    
    private String kubun; 
    private String comps; 
    private String itcls; 
    private String pspno; 
    private String itdsc;
    private String prdcd;
    private String prdnm;
    private String mohtq; 
    private String msum; 
    private String qty01; 
    private String qty02; 
    private String qty03; 
    private String qty04; 
    private String qty05; 
    private String qty06; 
	private String qty07; 
	private String qty08; 
	private String qty09; 
	private String qty10; 
	private String qty11; 
	private String qty12;
	private String qty13; 
    private String qty14; 
    private String qty15; 
    private String qty16; 
    private String qty17; 
    private String qty18; 
	private String qty19; 
	private String qty20; 
	private String qty21; 
	private String qty22; 
	private String qty23; 
	private String qty24; 
    private String qty25; 
    private String qty26; 
    private String qty27; 
    private String qty28; 
    private String qty29; 
	private String qty30; 
	private String qty31;
   
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


	public String getKubun() {
		return kubun;
	}


	public String getComps() {
		return comps;
	}


	public String getItcls() {
		return itcls;
	}


	public String getPspno() {
		return pspno;
	}


	public String getItdsc() {
		return itdsc;
	}


	public String getMsum() {
		return msum;
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


	public void setKubun(String kubun) {
		this.kubun = kubun;
	}


	public void setComps(String comps) {
		this.comps = comps;
	}


	public void setItcls(String itcls) {
		this.itcls = itcls;
	}


	public void setPspno(String pspno) {
		this.pspno = pspno;
	}


	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}


	public void setMsum(String msum) {
		this.msum = msum;
	}



	public String getSearchDate() {
		return searchDate;
	}


	public String getSearchKubun() {
		return searchKubun;
	}


	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}


	public void setSearchKubun(String searchKubun) {
		this.searchKubun = searchKubun;
	}


	/**
	 * @return the searchPrdcd
	 */
	public String getSearchPrdcd() {
		return searchPrdcd;
	}

	/**
	 * @param searchPrdcd the searchPrdcd to set
	 */
	public void setSearchPrdcd(String searchPrdcd) {
		this.searchPrdcd = searchPrdcd;
	}

	/**
	 * @return the searchHouse
	 */
	public String getSearchHouse() {
		return searchHouse;
	}

	/**
	 * @param searchHouse the searchHouse to set
	 */
	public void setSearchHouse(String searchHouse) {
		this.searchHouse = searchHouse;
	}

	public String getMohtq() {
		return mohtq;
	}


	public void setMohtq(String mohtq) {
		this.mohtq = mohtq;
	}


	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("kubun", this.kubun);
        jsonObj.put("comps", this.comps);
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("prdcd", this.prdcd);
        jsonObj.put("prdnm", this.prdnm);
        jsonObj.put("mohtq", this.mohtq);        
        jsonObj.put("msum", this.msum);
        jsonObj.put("qty01", this.qty01);
        jsonObj.put("qty02", this.qty02);
        jsonObj.put("qty03", this.qty03);
        jsonObj.put("qty04", this.qty04);
        jsonObj.put("qty05", this.qty05);
        jsonObj.put("qty06", this.qty06);
        jsonObj.put("qty07", this.qty07);
        jsonObj.put("qty08", this.qty08);
        jsonObj.put("qty09", this.qty09);
        jsonObj.put("qty10", this.qty10);
        jsonObj.put("qty11", this.qty11);
        jsonObj.put("qty12", this.qty12);
        jsonObj.put("qty13", this.qty13);
        jsonObj.put("qty14", this.qty14);
        jsonObj.put("qty15", this.qty15);
        jsonObj.put("qty16", this.qty16);
        jsonObj.put("qty17", this.qty17);
        jsonObj.put("qty18", this.qty18);
        jsonObj.put("qty19", this.qty19);
        jsonObj.put("qty20", this.qty20);
        jsonObj.put("qty21", this.qty21);
        jsonObj.put("qty22", this.qty22);
        jsonObj.put("qty23", this.qty23);
        jsonObj.put("qty24", this.qty24);
        jsonObj.put("qty25", this.qty25);
        jsonObj.put("qty26", this.qty26);
        jsonObj.put("qty27", this.qty27);
        jsonObj.put("qty28", this.qty28);
        jsonObj.put("qty29", this.qty29);
        jsonObj.put("qty30", this.qty30);
        jsonObj.put("qty31", this.qty31);
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

}