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
public class PrdYrPlnCrtRgsDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private int year;
    private String locCode;
    private String clsCode;
    private String lineCode;
    private String lineNm;
	private String iem;
	private String code;
	private String codeNm;
	private float apr;
	private float may;
	private float jun;
	private float july;
	private float aug;
	private float sep;
	private float oct;
	private float nov;
	private float dec;
	private float jan;
	private float feb;
	private float mar;
	private float totSum;
    
    private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;

    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public PrdYrPlnCrtRgsDomain () {
        //no process
    }    

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
    
	public String getClsCode() {
		return clsCode;
	}

	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCodeNm() {
		return codeNm;
	}

	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}
	
	public String getIem() {
		return iem;
	}

	public void setIem(String iem) {
		this.iem = iem;
	}
	
	public float getApr() {
		return apr;
	}

	public void setApr(float apr) {
		this.apr = apr;
	}	
	
	public float getMay() {
		return may;
	}

	public void setMay(float may) {
		this.may = may;
	}
	
	public float getJun() {
		return jun;
	}

	public void setJun(float jun) {
		this.jun = jun;
	}
	
	public float getJuly() {
		return july;
	}

	public void setJuly(float july) {
		this.july = july;
	}
	
	public float getAug() {
		return aug;
	}

	public void setAug(float aug) {
		this.aug = aug;
	}
	
	public float getSep() {
		return sep;
	}

	public void setSep(float sep) {
		this.sep = sep;
	}
	
	public float getOct() {
		return oct;
	}

	public void setOct(float oct) {
		this.oct = oct;
	}
	
	public float getNov() {
		return nov;
	}

	public void setNov(float nov) {
		this.nov = nov;
	}
	
	public float getDec() {
		return dec;
	}

	public void setDec(float dec) {
		this.dec = dec;
	}
	
	public float getJan() {
		return jan;
	}

	public void setJan(float jan) {
		this.jan = jan;
	}
	
	public float getFeb() {
		return feb;
	}

	public void setFeb(float feb) {
		this.feb = feb;
	}
	
	public float getMar() {
		return jan;
	}

	public void setMar(float mar) {
		this.mar = mar;
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

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("year", this.year);
        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("locCode", this.locCode);
        jsonObj.put("lineCode", this.lineCode);
        jsonObj.put("lineNm", this.lineNm);
        jsonObj.put("iem", this.iem);
        jsonObj.put("code", this.code);
        jsonObj.put("codeNm", this.codeNm);
        jsonObj.put("totSum", this.totSum);
        
        jsonObj.put("apr", this.apr);
        jsonObj.put("may", this.may);
        jsonObj.put("jun", this.jun);
        jsonObj.put("july", this.july);
        jsonObj.put("aug", this.aug);
        jsonObj.put("sep", this.sep);
        jsonObj.put("oct", this.oct);
        jsonObj.put("nov", this.nov);
        jsonObj.put("dec", this.dec);
        jsonObj.put("jan", this.jan);
        jsonObj.put("feb", this.feb);
        jsonObj.put("mar", this.mar);
        
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate);   
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
