package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 생산성지표 기준정보(제품관리) 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class LgstTimeDstrRtBaseDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String clsCode;
    private String lineCode;
    private String lineNm;    
    private String lgsDstRt;
    private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;

    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public LgstTimeDstrRtBaseDomain () {
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


	public String getLgsDstRt() {
		return lgsDstRt;
	}


	public void setLgsDstRt(String lgsDstRt) {
		this.lgsDstRt = lgsDstRt;
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

        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("lineCode", this.lineCode);
        jsonObj.put("lineNm", this.lineNm);
        jsonObj.put("lgsDstRt", this.lgsDstRt);
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate);      
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
