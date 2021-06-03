package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 생산성지표 라인인원투입시간등록 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PrdPrfrmRgsDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String opertDe;    
    private String clsCode;
    private String locCode;
    private String lineCode;
    private String lineNm;
    private String productNo;
    private String productNm;    
    private String intType;
    private String qy;
    private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;
    
    private String oldLineCode;
    private String oldProductNo;
    
    private String ifCode;
    
    private String day;
    private String opertDeMon;
    
    private String lib1;
    private String lib2;    

    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public PrdPrfrmRgsDomain () {
        //no process
    }    

	public String getOpertDe() {
		return opertDe;
	}

	public void setOpertDe(String opertDe) {
		this.opertDe = opertDe;
	}

	public String getClsCode() {
		return clsCode;
	}

	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}

	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

	public String getLineNm() {
		return lineNm;
	}

	public void setLineNm(String lineNm) {
		this.lineNm = lineNm;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductNm() {
		return productNm;
	}

	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}

	public String getIntType() {
		return intType;
	}

	public void setIntType(String intType) {
		this.intType = intType;
	}

	public String getQy() {
		return qy;
	}

	public void setQy(String qy) {
		this.qy = qy;
	}

	public String getOldLineCode() {
		return oldLineCode;
	}

	public void setOldLineCode(String oldLineCode) {
		this.oldLineCode = oldLineCode;
	}

	public String getOldProductNo() {
		return oldProductNo;
	}

	public void setOldProductNo(String oldProductNo) {
		this.oldProductNo = oldProductNo;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getModUser() {
		return modUser;
	}

	public void setModUser(String modUser) {
		this.modUser = modUser;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public String getIfCode() {
		return ifCode;
	}

	public void setIfCode(String ifCode) {
		this.ifCode = ifCode;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getOpertDeMon() {
		return opertDeMon;
	}

	public void setOpertDeMon(String opertDeMon) {
		this.opertDeMon = opertDeMon;
	}

	public String getLib1() {
		return lib1;
	}

	public void setLib1(String lib1) {
		this.lib1 = lib1;
	}

	public String getLib2() {
		return lib2;
	}

	public void setLib2(String lib2) {
		this.lib2 = lib2;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("opertDe", this.opertDe);
        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("locCode", this.locCode);
        jsonObj.put("lineCode", this.lineCode);
        jsonObj.put("lineNm", this.lineNm);
        jsonObj.put("productNo", this.productNo);
        jsonObj.put("productNm", this.productNm);  
        jsonObj.put("intType", this.intType);         
        jsonObj.put("qy", this.qy);             
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate);   
        jsonObj.put("ifCode", this.ifCode);    
        jsonObj.put("day", this.day);  
        jsonObj.put("opertDeMon", this.opertDeMon);
        jsonObj.put("oldLineCode", this.oldLineCode);
        jsonObj.put("oldProductNo", this.oldProductNo);        
        jsonObj.put("lib1", this.lib1);  
        jsonObj.put("lib2", this.lib2);          
       
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
