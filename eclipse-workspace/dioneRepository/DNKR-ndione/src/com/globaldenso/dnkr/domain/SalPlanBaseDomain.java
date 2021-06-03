package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 생산성지표 기준정보(공통) 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class SalPlanBaseDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String comps;    
    private String code;
    private String name;
    private String sub;
    
    private String reprtse;  //보고서종류
    private String reprtNm; //보고서명
    private String cmnitm;  //코멘트항목     
    
    private String lib1;    
    private String lib2;        
    private String lib3;        
    
	
    
    
	public String getSub() {
		return sub;
	}



	public void setSub(String sub) {
		this.sub = sub;
	}



	public String getComps() {
		return comps;
	}



	public void setComps(String comps) {
		this.comps = comps;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getReprtse() {
		return reprtse;
	}



	public void setReprtse(String reprtse) {
		this.reprtse = reprtse;
	}



	public String getReprtNm() {
		return reprtNm;
	}



	public void setReprtNm(String reprtNm) {
		this.reprtNm = reprtNm;
	}



	public String getCmnitm() {
		return cmnitm;
	}



	public void setCmnitm(String cmnitm) {
		this.cmnitm = cmnitm;
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



	public String getLib3() {
		return lib3;
	}



	public void setLib3(String lib3) {
		this.lib3 = lib3;
	}



	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("code", this.code);
        jsonObj.put("name", this.name);
        jsonObj.put("sub", this.sub);
        
        jsonObj.put("reprtse", this.reprtse);
        jsonObj.put("reprtNm", this.reprtNm);
        jsonObj.put("cmnitm", this.cmnitm);      
        
        jsonObj.put("lib1", this.lib1); 
        jsonObj.put("lib2", this.lib2);         
        jsonObj.put("lib3", this.lib3);                 
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
