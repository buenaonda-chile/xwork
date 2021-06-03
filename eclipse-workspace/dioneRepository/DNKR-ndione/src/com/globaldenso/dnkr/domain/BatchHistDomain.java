package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 배치실행이력 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class BatchHistDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143742L;
    
    
    private String seq;
    private String batchcd;
    private String batchnm;
    private String rst;
    private String rstdata;
    private String regdt;
    private String updt;
    
    
    
    public String getSeq() {
		return seq;
	}



	public void setSeq(String seq) {
		this.seq = seq;
	}



	public String getBatchcd() {
		return batchcd;
	}



	public void setBatchcd(String batchcd) {
		this.batchcd = batchcd;
	}



	public String getBatchnm() {
		return batchnm;
	}



	public void setBatchnm(String batchnm) {
		this.batchnm = batchnm;
	}



	public String getRst() {
		return rst;
	}



	public void setRst(String rst) {
		this.rst = rst;
	}



	public String getRstdata() {
		return rstdata;
	}



	public void setRstdata(String rstdata) {
		this.rstdata = rstdata;
	}



	public String getRegdt() {
		return regdt;
	}



	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}



	public String getUpdt() {
		return updt;
	}



	public void setUpdt(String updt) {
		this.updt = updt;
	}



	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("seq", this.seq);
        jsonObj.put("batchcd", this.batchcd);
        jsonObj.put("batchnm", this.batchnm);
        jsonObj.put("rst", this.rst);
        jsonObj.put("rstdata", this.rstdata);
        jsonObj.put("regdt", this.regdt);
        jsonObj.put("updt", this.updt);  
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
