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
public class LosExcIndTmDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private int year;
    private int hrMnt;
    private int opertDe;
    private String locCode;
    private String clsCode;
    private String code;
	private String codeNm;
	private String se;
	private String seNm;
	private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;

    private String lineCode;
    private String lineNm;
   
    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public LosExcIndTmDomain () {
        //no process
    }    

	public int getOpertDe() {
		return opertDe;
	}

	public void setOpertDe(int opertDe) {
		this.opertDe = opertDe;
	}
    
	public int getHrMnt() {
		return hrMnt;
	}

	public void setHrMnt(int hrMnt) {
		this.hrMnt = hrMnt;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getSe() {
		return se;
	}

	public void setSe(String se) {
		this.se = se;
	}
	
	public String getSeNm() {
		return seNm;
	}

	public void setSeNm(String seNm) {
		this.seNm = seNm;
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

	//라인1
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
	
	
	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        
        jsonObj.put("year", this.year);
        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("locCode", this.locCode);
        jsonObj.put("code", this.code);
        jsonObj.put("codeNm", this.codeNm);
        jsonObj.put("opertDe", this.opertDe);
        jsonObj.put("se", this.se);
        jsonObj.put("seNm", this.seNm);
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate);   
        jsonObj.put("lineCode", this.lineCode);
        jsonObj.put("lineNm", this.lineNm);
        jsonObj.put("hrMnt", this.hrMnt);
        
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
