package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class SalesPlanMaterialCostDomain extends CommonDb2Domain implements Serializable {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 3333018149644115190L;
	private List<String> yearList;
	private String division;
	private String year;
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
    
    private String pyvnd;
    private String pspno;
    private String itdsc;
    private String mstsm;
    private String yescs;
    private String edatm;
    private String price;
    private String krsur;
    private String surkr;
    private String surus;
    private String surjp;
    private String surur;
    private String krpur;
    private String krckd;
    private String ckdus;
    private String ckdjp;
    private String ckdur;
    private String ckdkr; 
    private String ym1;
    private String ym2;
    private String ym3;
    private String ym4;
    private String ym5;
    private String ym6;
    private String ym7;
    private String ym8;
    private String ym9;
    private String ym10;
    private String ym11;
    private String ym12;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public SalesPlanMaterialCostDomain() {
        // no process
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("pyvnd",   this.pyvnd);
        jsonObj.put("pspno",   this.pspno);
        jsonObj.put("itdsc",   this.itdsc);
        jsonObj.put("mstsm",   this.mstsm);
        jsonObj.put("yescs",   this.yescs);
        jsonObj.put("edatm",   this.edatm);
        jsonObj.put("price",   this.price);
        jsonObj.put("krsur",   this.krsur);
        jsonObj.put("surkr",   this.surkr);
        jsonObj.put("surus",   this.surus);
        jsonObj.put("surjp",   this.surjp);
        jsonObj.put("surur",   this.surur);
        jsonObj.put("krpur",   this.krpur);
        jsonObj.put("krckd",  this.krckd);
        jsonObj.put("ckdus",  this.ckdus);
        jsonObj.put("ckdjp",  this.ckdjp);
        jsonObj.put("ckdur",  this.ckdur);
        jsonObj.put("ckdkr",  this.ckdkr);
        
        jsonObj.put("ym1",   this.ym1);
        jsonObj.put("ym2",   this.ym2);
        jsonObj.put("ym3",   this.ym3);
        jsonObj.put("ym4",   this.ym4);
        jsonObj.put("ym5",   this.ym5);
        jsonObj.put("ym6",   this.ym6);
        jsonObj.put("ym7",   this.ym7);
        jsonObj.put("ym8",   this.ym8);
        jsonObj.put("ym9",   this.ym9);
        jsonObj.put("ym10",   this.ym10);
        jsonObj.put("ym11",   this.ym11);
        jsonObj.put("ym12",   this.ym12);
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }



	public List<String> getYearList() {
		return yearList;
	}



	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}



	public String getDivision() {
		return division;
	}



	public void setDivision(String division) {
		this.division = division;
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



	public String getPyvnd() {
		return pyvnd;
	}



	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}



	public String getPspno() {
		return pspno;
	}



	public void setPspno(String pspno) {
		this.pspno = pspno;
	}



	public String getItdsc() {
		return itdsc;
	}



	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}



	public String getMstsm() {
		return mstsm;
	}



	public void setMstsm(String mstsm) {
		this.mstsm = mstsm;
	}



	public String getYescs() {
		return yescs;
	}



	public void setYescs(String yescs) {
		this.yescs = yescs;
	}



	public String getEdatm() {
		return edatm;
	}



	public void setEdatm(String edatm) {
		this.edatm = edatm;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getKrsur() {
		return krsur;
	}



	public void setKrsur(String krsur) {
		this.krsur = krsur;
	}



	public String getSurkr() {
		return surkr;
	}



	public void setSurkr(String surkr) {
		this.surkr = surkr;
	}



	public String getSurus() {
		return surus;
	}



	public void setSurus(String surus) {
		this.surus = surus;
	}



	public String getSurjp() {
		return surjp;
	}



	public void setSurjp(String surjp) {
		this.surjp = surjp;
	}



	public String getSurur() {
		return surur;
	}



	public void setSurur(String surur) {
		this.surur = surur;
	}



	public String getKrpur() {
		return krpur;
	}



	public void setKrpur(String krpur) {
		this.krpur = krpur;
	}



	public String getKrckd() {
		return krckd;
	}



	public void setKrckd(String krckd) {
		this.krckd = krckd;
	}



	public String getCkdus() {
		return ckdus;
	}



	public void setCkdus(String ckdus) {
		this.ckdus = ckdus;
	}



	public String getCkdjp() {
		return ckdjp;
	}



	public void setCkdjp(String ckdjp) {
		this.ckdjp = ckdjp;
	}



	public String getCkdur() {
		return ckdur;
	}



	public void setCkdur(String ckdur) {
		this.ckdur = ckdur;
	}



	public String getCkdkr() {
		return ckdkr;
	}



	public void setCkdkr(String ckdkr) {
		this.ckdkr = ckdkr;
	}



	public String getYm1() {
		return ym1;
	}



	public void setYm1(String ym1) {
		this.ym1 = ym1;
	}



	public String getYm2() {
		return ym2;
	}



	public void setYm2(String ym2) {
		this.ym2 = ym2;
	}



	public String getYm3() {
		return ym3;
	}



	public void setYm3(String ym3) {
		this.ym3 = ym3;
	}



	public String getYm4() {
		return ym4;
	}



	public void setYm4(String ym4) {
		this.ym4 = ym4;
	}



	public String getYm5() {
		return ym5;
	}



	public void setYm5(String ym5) {
		this.ym5 = ym5;
	}



	public String getYm6() {
		return ym6;
	}



	public void setYm6(String ym6) {
		this.ym6 = ym6;
	}



	public String getYm7() {
		return ym7;
	}



	public void setYm7(String ym7) {
		this.ym7 = ym7;
	}



	public String getYm8() {
		return ym8;
	}



	public void setYm8(String ym8) {
		this.ym8 = ym8;
	}



	public String getYm9() {
		return ym9;
	}



	public void setYm9(String ym9) {
		this.ym9 = ym9;
	}



	public String getYm10() {
		return ym10;
	}



	public void setYm10(String ym10) {
		this.ym10 = ym10;
	}



	public String getYm11() {
		return ym11;
	}



	public void setYm11(String ym11) {
		this.ym11 = ym11;
	}



	public String getYm12() {
		return ym12;
	}



	public void setYm12(String ym12) {
		this.ym12 = ym12;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
