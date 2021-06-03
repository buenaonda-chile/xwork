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
public class FinlCustTypeBaseDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;
    
    private String comps;	//사업부
    private String endccd; 	//최종고객코드
    private String endcnm; 	//최종고객명
    private String pyvnd;	//업체코드
    private String pyvndnm;	//업체코드명
    private String brnnm;	//지점명
    private String desc;	//설명
    private String regu;	//생성자
    private String regd;	//생성일
    private String modu;	//수정자
    private String modd;	//수정일
    
    private String oldComps;
    private String oldEndccd;
    private String oldPyvnd;
    
	public String getComps() {
		return comps;
	}
	public void setComps(String comps) {
		this.comps = comps;
	}
	public String getEndccd() {
		return endccd;
	}
	public void setEndccd(String endccd) {
		this.endccd = endccd;
	}
	public String getPyvnd() {
		return pyvnd;
	}
	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}
	public String getBrnnm() {
		return brnnm;
	}
	public void setBrnnm(String brnnm) {
		this.brnnm = brnnm;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public String getEndcnm() {
		return endcnm;
	}
	public void setEndcnm(String endcnm) {
		this.endcnm = endcnm;
	}
	public String getOldComps() {
		return oldComps;
	}
	public void setOldComps(String oldComps) {
		this.oldComps = oldComps;
	}
	public String getOldEndccd() {
		return oldEndccd;
	}
	public void setOldEndccd(String oldEndccd) {
		this.oldEndccd = oldEndccd;
	}
	public String getOldPyvnd() {
		return oldPyvnd;
	}
	public void setOldPyvnd(String oldPyvnd) {
		this.oldPyvnd = oldPyvnd;
	}
	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("endccd", this.endccd);
        jsonObj.put("endcnm", this.endcnm);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("pyvndnm", this.pyvndnm);
        jsonObj.put("brnnm", this.brnnm);
        jsonObj.put("desc", this.desc);
        jsonObj.put("regu", this.regu);
        jsonObj.put("regd", this.regd);
        jsonObj.put("modu", this.modu);
        jsonObj.put("modd", this.modd);
        
        jsonObj.put("oldComps", this.oldComps);
        jsonObj.put("oldEndccd", this.oldEndccd);
        jsonObj.put("oldPyvnd", this.oldPyvnd);
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }
	public String getPyvndnm() {
		return pyvndnm;
	}
	public void setPyvndnm(String pyvndnm) {
		this.pyvndnm = pyvndnm;
	}
	
	

}
