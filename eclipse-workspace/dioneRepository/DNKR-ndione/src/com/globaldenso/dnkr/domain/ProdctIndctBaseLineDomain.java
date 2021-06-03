package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 생산성지표 기준정보(라인정보) 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class ProdctIndctBaseLineDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String clsCode;
    private String lineCode;
    private String lineNm;
    private String locCode;
    private String partCode;
    private String teamCode;
    private String lcodeGb;
    private String workStle;
    private String prdtCode1;
    private String prdtCode2;
    private String prdtCode3;
    private String prdtNm1;
    private String prdtNm2;
    private String prdtNm3;    
    private String ifCode;
    private String ifType;    
    private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;
    private String oldLineCode;    

    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public ProdctIndctBaseLineDomain () {
        //no process
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


	public String getLocCode() {
		return locCode;
	}


	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}


	public String getPartCode() {
		return partCode;
	}


	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}


	public String getTeamCode() {
		return teamCode;
	}


	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}


	public String getLcodeGb() {
		return lcodeGb;
	}


	public void setLcodeGb(String lcodeGb) {
		this.lcodeGb = lcodeGb;
	}


	public String getWorkStle() {
		return workStle;
	}


	public void setWorkStle(String workStle) {
		this.workStle = workStle;
	}


	public String getPrdtCode1() {
		return prdtCode1;
	}


	public void setPrdtCode1(String prdtCode1) {
		this.prdtCode1 = prdtCode1;
	}


	public String getPrdtCode2() {
		return prdtCode2;
	}


	public void setPrdtCode2(String prdtCode2) {
		this.prdtCode2 = prdtCode2;
	}


	public String getPrdtCode3() {
		return prdtCode3;
	}


	public void setPrdtCode3(String prdtCode3) {
		this.prdtCode3 = prdtCode3;
	}


	public String getPrdtNm1() {
		return prdtNm1;
	}

	public void setPrdtNm1(String prdtNm1) {
		this.prdtNm1 = prdtNm1;
	}

	public String getPrdtNm2() {
		return prdtNm2;
	}

	public void setPrdtNm2(String prdtNm2) {
		this.prdtNm2 = prdtNm2;
	}

	public String getPrdtNm3() {
		return prdtNm3;
	}

	public void setPrdtNm3(String prdtNm3) {
		this.prdtNm3 = prdtNm3;
	}

	public String getIfCode() {
		return ifCode;
	}


	public void setIfCode(String ifCode) {
		this.ifCode = ifCode;
	}


	public String getIfType() {
		return ifType;
	}

	public void setIfType(String ifType) {
		this.ifType = ifType;
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


	public String getOldLineCode() {
		return oldLineCode;
	}

	public void setOldLineCode(String oldLineCode) {
		this.oldLineCode = oldLineCode;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("lineCode", this.lineCode);
        jsonObj.put("lineNm", this.lineNm);
        jsonObj.put("locCode", this.locCode);
        jsonObj.put("partCode", this.partCode);
        jsonObj.put("teamCode", this.teamCode);
        jsonObj.put("lcodeGb", this.lcodeGb);
        jsonObj.put("workStle", this.workStle);
        jsonObj.put("prdtCode1", this.prdtCode1);
        jsonObj.put("prdtCode2", this.prdtCode2);
        jsonObj.put("prdtCode3", this.prdtCode3);
        jsonObj.put("prdtNm1", this.prdtNm1);
        jsonObj.put("prdtNm2", this.prdtNm2);
        jsonObj.put("prdtNm3", this.prdtNm3);        
        jsonObj.put("ifCode", this.ifCode);
        jsonObj.put("ifType", this.ifType);        
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate); 
        jsonObj.put("oldLineCode", this.oldLineCode);          
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
