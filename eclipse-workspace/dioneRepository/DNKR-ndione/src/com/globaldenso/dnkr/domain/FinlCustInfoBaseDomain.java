package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 판매계획 기준정보 최종고객정보관리 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class FinlCustInfoBaseDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String endccd; //최종고객코드
    private String endcnm; //최종고객명
    private String regu; //생성자
    private String regd; //생성일
    private String modu; //수정자
    private String modd; //수정일
    

	public String getEndccd() {
		return endccd;
	}



	public void setEndccd(String endccd) {
		this.endccd = endccd;
	}



	public String getEndcnm() {
		return endcnm;
	}



	public void setEndcnm(String endcnm) {
		this.endcnm = endcnm;
	}



	public String getRegu() {
		return regu;
	}



	public void setRegu(String regu) {
		this.regu = regu;
	}



	public String getRegd() {
		return regd;
	}



	public void setRegd(String regd) {
		this.regd = regd;
	}



	public String getModu() {
		return modu;
	}



	public void setModu(String modu) {
		this.modu = modu;
	}



	public String getModd() {
		return modd;
	}



	public void setModd(String modd) {
		this.modd = modd;
	}
	

    
    
	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("endccd", this.endccd);
        jsonObj.put("endcnm", this.endcnm);
        jsonObj.put("regu", this.regu);
        jsonObj.put("regd", this.regd);
        jsonObj.put("modu", this.modu);
        jsonObj.put("modd", this.modd);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }


}
