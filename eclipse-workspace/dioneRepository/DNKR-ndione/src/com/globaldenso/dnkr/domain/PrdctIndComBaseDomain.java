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
public class PrdctIndComBaseDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;

    private String comps;    
    private String code;
    private String name;

    private String cdBizarea;    //사업부 
    private String nmKor;  //이름
    private String noEmp; //사원번호
    private String cdIncom;  //001:재직,002:휴직
    private String deptCdMap;    //부서코드     
    
    private String lib1;    
    private String lib2;        
    private String lib3;        
    
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

	
	
	public String getCdBizarea() {
		return cdBizarea;
	}

	public void setCdBizarea(String cdBizarea) {
		this.cdBizarea = cdBizarea;
	}

	public String getNmKor() {
		return nmKor;
	}

	public void setNmKor(String nmKor) {
		this.nmKor = nmKor;
	}

	public String getNoEmp() {
		return noEmp;
	}

	public void setNoEmp(String noEmp) {
		this.noEmp = noEmp;
	}


	public String getCdIncom() {
		return cdIncom;
	}

	public void setCdIncom(String cdIncom) {
		this.cdIncom = cdIncom;
	}

	public String getDeptCdMap() {
		return deptCdMap;
	}

	public void setDeptCdMap(String deptCdMap) {
		this.deptCdMap = deptCdMap;
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
        
        jsonObj.put("cdBizarea", this.cdBizarea);
        jsonObj.put("nmKor", this.nmKor);
        jsonObj.put("noEmp", this.noEmp);
        jsonObj.put("cdIncom", this.cdIncom); 
        jsonObj.put("deptCdMap", this.deptCdMap);         
        
        jsonObj.put("lib1", this.lib1); 
        jsonObj.put("lib2", this.lib2);         
        jsonObj.put("lib3", this.lib3);                 
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
