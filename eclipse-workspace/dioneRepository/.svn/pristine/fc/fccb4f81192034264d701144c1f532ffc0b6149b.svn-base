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
public class ProdctCodeBaseDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String clsCode;
    private String prdtCode;
    private String prdtNm;
    private String startDe;
    private String endDe;
    private String refrn;
    private String regUser;
    private String regDate;
    private String modUser;
    private String modDate;
    private String oldPrdtCode;   
    private String oldStartDe;
    private String oldEndDe;       

    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public ProdctCodeBaseDomain () {
        //no process
    }    



	public String getClsCode() {
		return clsCode;
	}



	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}



	public String getPrdtCode() {
		return prdtCode;
	}



	public void setPrdtCode(String prdtCode) {
		this.prdtCode = prdtCode;
	}



	public String getPrdtNm() {
		return prdtNm;
	}



	public void setPrdtNm(String prdtNm) {
		this.prdtNm = prdtNm;
	}



	public String getStartDe() {
		return startDe;
	}



	public void setStartDe(String startDe) {
		this.startDe = startDe;
	}



	public String getEndDe() {
		return endDe;
	}



	public void setEndDe(String endDe) {
		this.endDe = endDe;
	}



	public String getRefrn() {
		return refrn;
	}



	public void setRefrn(String refrn) {
		this.refrn = refrn;
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



	public String getOldPrdtCode() {
		return oldPrdtCode;
	}



	public void setOldPrdtCode(String oldPrdtCode) {
		this.oldPrdtCode = oldPrdtCode;
	}



	public String getOldStartDe() {
		return oldStartDe;
	}



	public void setOldStartDe(String oldStartDe) {
		this.oldStartDe = oldStartDe;
	}



	public String getOldEndDe() {
		return oldEndDe;
	}



	public void setOldEndDe(String oldEndDe) {
		this.oldEndDe = oldEndDe;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("prdtCode", this.prdtCode);
        jsonObj.put("prdtNm", this.prdtNm);
        jsonObj.put("startDe", this.startDe);
        jsonObj.put("endDe", this.endDe);
        jsonObj.put("refrn", this.refrn);
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate);      
        jsonObj.put("oldPrdtCode", this.oldPrdtCode); 
        jsonObj.put("oldStartDe", this.oldStartDe);  
        jsonObj.put("oldEndDe", this.oldEndDe);         
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
