package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 생산성지표 기준정보(생산용역인원관리) 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PrdctSvcPsnlInputDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;
    
    private String clsCode; //사업부코드
    private String locCode; //부서코드
    private String servcNo; //용역번호
    private String startDe; //시작일
    private String endDe; //종료일
    private String nm; //성명
    private String refrn; //참조
    private String regUser; //등록자
    private String regDate; //등록일
    private String modUser; //수정자
    private String modDate; //수정일
    private String oldServcNo; //수정일    
//    private String locNm; //부서명


    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public PrdctSvcPsnlInputDomain () {
        //no process
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


	public String getServcNo() {
		return servcNo;
	}

	
	public void setServcNo(String servcNo) {
		this.servcNo = servcNo;
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


	public String getNm() {
		return nm;
	}


	public void setNm(String nm) {
		this.nm = nm;
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

	public String getOldServcNo() {
		return oldServcNo;
	}


	public void setOldServcNo(String oldServcNo) {
		this.oldServcNo = oldServcNo;
	}


	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("locCode", this.locCode);
        jsonObj.put("servcNo", this.servcNo);
        jsonObj.put("startDe", this.startDe);
        jsonObj.put("endDe", this.endDe);
        jsonObj.put("nm", this.nm);
        jsonObj.put("refrn", this.refrn);
        jsonObj.put("regUser", this.regUser);
        jsonObj.put("regDate", this.regDate);
        jsonObj.put("modUser", this.modUser);
        jsonObj.put("modDate", this.modDate);
        jsonObj.put("oldServcNo", this.oldServcNo);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
