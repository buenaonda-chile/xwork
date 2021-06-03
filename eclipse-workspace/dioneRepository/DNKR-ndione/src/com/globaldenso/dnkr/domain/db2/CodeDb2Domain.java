package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] DB2 코드정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class CodeDb2Domain implements Serializable{

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 4648614880859983486L;

    
    /**
     * [KO] DB2 class<br>
     */
    private String db2class;
    
    /**
     * [KO] DB2 coded1<br>
     */
    private String code1;
    
    /**
     * [KO] DB2 coded2<br>
     */
    private String code2;
    
    /**
     * [KO] DB2 code_name<br>
     */
    private String code_name;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    
    //MST050PF CODE LIST
    /**
     * [KO] DB2 MST050PF 사업부코드<br>
     */
    private String comps;
    /**
     * [KO] DB2 MST050PF 코드종류<br>
     */
    private String grpcd;
    /**
     * [KO] DB2 MST050PF 코드<br>
     */
    private String mstcd;
    /**
     * [KO] DB2 MST050PF 코드명<br>
     */
    private String mstsm;
    /**
     * [KO] DB2 MST050PF 제외코드<br>
     */
    private String mstgu;
       
    /**
     * [KO] DB2 MST050PF 코드 긴명<br>
     */
    private String mstrm;
    
    
    /**
     * [KO] DB2 JDE-F0901 과목코드 <br>
     */
    private String gmobj;
    
    /**
     * [KO] DB2 JDE-F0901 과목코드 명<br>
     */
    private String gmdl01;
        
    /**
     * [KO] DB2 JDE-F0901 과목코드 명<br>
     */
    private String gmobjName;
    
    /**
     * [KO] DB2 JDE-F0006LB BU코드<br>
     */
    private String mcmcu;
    /**
     * [KO] DB2 JDE-F0006LB BU코드명<br>
     */
    private String mcdc;
    
    /**
     * [KO] DB2 JDE-F0006LB BU코드명2<br>
     */
    private String mcName;
    
    /**
     * [KO] DB2 JDE-F0006LB BU코드명2<br>
     */
    private String mcstyl;
    
    /**
     * [KO] DB2 JDE-F0006LB BU코드명2<br>
     */
    private String mcrp11;
    
    /**
     * [KO] DB2 JDE-F0006LB BU코드명2<br>
     */
    private String mcrp12;
    
    
    /**
     * [KO] DB2 MST650PF 부서코드 <br>
     */
    private String dpCode;
    
    /**
     * [KO] DB2 MST650PF 부서코드 명<br>
     */
    private String dpDpnm;
    
    /**
     * [KO] DB2 MST650PF 부서코드+부서명 <br>
     */
    private String dpCoDpnm;
    
    /**
     * [EN] Employee lib1.<br>
     */
    private String lib1;
    
    /**
     * [EN] Employee lib2.<br>
     */
    private String lib2;
  
    /**
     * [EN] Employee lib3.<br>
     */
    private String lib3;
    
    /**
     * [EN] Employee lib4.<br>
     */
    private String lib4;
    
    public CodeDb2Domain(){
        // no process
    }


    /**
     * [KO] 의 getter method 이다.<br>
     * [EN] It is a getter method of db2class.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getDb2class() {
        return db2class;
    }


    /**
     * [KO] db2class의 setter method 이다.<br>
     * [EN] It is a setter method of db2class.<br>
     * [JP] <br>
     * 
     * @param db2class String
     */
    public void setDb2class(String db2class) {
        this.db2class = db2class;
    }

    /**
     * [KO] code1의 getter method 이다.<br>
     * [EN] It is a getter method of code1.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getCode1() {
        return code1;
    }

    /**
     * [KO] code1의 setter method 이다.<br>
     * [EN] It is a setter method of code1.<br>
     * [JP] <br>
     * 
     * @param code1 String
     */
    public void setCoded1(String code1) {
        this.code1 = code1;
    }

    /**
     * [KO] coded2의 getter method 이다.<br>
     * [EN] It is a getter method of coded2.<br>
     * [JP] <br>
     * 
     * @return the coded2
     */
    public String getCode2() {
        return code2;
    }

    /**
     * [KO] code2의 setter method 이다.<br>
     * [EN] It is a setter method of code2.<br>
     * [JP] <br>
     * 
     * @param code2 String
     */
    public void setCode2(String code2) {
        this.code2 = code2;
    }

    /**
     * [KO] code_name의 getter method 이다.<br>
     * [EN] It is a getter method of code_name.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getCode_name() {
        return code_name;
    }

    /**
     * [KO] 의 setter method 이다.<br>
     * [EN] It is a setter method of code_name.<br>
     * [JP] <br>
     * 
     * @param code_name String
     */
    public void setCode_name(String code_name) {
        this.code_name = code_name;
    }


	/**
	 * @return the grpcd
	 */
	public String getGrpcd() {
		return grpcd;
	}


	/**
	 * @param grpcd the grpcd to set
	 */
	public void setGrpcd(String grpcd) {
		this.grpcd = grpcd;
	}


	/**
	 * @return the mstcd
	 */
	public String getMstcd() {
		return mstcd;
	}


	/**
	 * @param mstcd the mstcd to set
	 */
	public void setMstcd(String mstcd) {
		this.mstcd = mstcd;
	}


	/**
	 * @return the mstsm
	 */
	public String getMstsm() {
		return mstsm;
	}


	/**
	 * @return the comps
	 */
	public String getComps() {
		return comps;
	}


	/**
	 * @param comps the comps to set
	 */
	public void setComps(String comps) {
		this.comps = comps;
	}


	/**
	 * @return the mstgu
	 */
	public String getMstgu() {
		return mstgu;
	}


	/**
	 * @param mstgu the mstgu to set
	 */
	public void setMstgu(String mstgu) {
		this.mstgu = mstgu;
	}


	/**
	 * @param mstsm the mstsm to set
	 */
	public void setMstsm(String mstsm) {
		this.mstsm = mstsm;
	}


	/**
	 * @return the mstrm
	 */
	public String getMstrm() {
		return mstrm;
	}


	/**
	 * @param mstrm the mstrm to set
	 */
	public void setMstrm(String mstrm) {
		this.mstrm = mstrm;
	}


	/**
	 * @return the gmobj
	 */
	public String getGmobj() {
		return gmobj;
	}


	/**
	 * @param gmobj the gmobj to set
	 */
	public void setGmobj(String gmobj) {
		this.gmobj = gmobj;
	}


	/**
	 * @return the gmdl01
	 */
	public String getGmdl01() {
		return gmdl01;
	}


	/**
	 * @param gmdl01 the gmdl01 to set
	 */
	public void setGmdl01(String gmdl01) {
		this.gmdl01 = gmdl01;
	}


	/**
	 * @return the gmobjName
	 */
	public String getGmobjName() {
		return gmobjName;
	}


	/**
	 * @param gmobjName the gmobjName to set
	 */
	public void setGmobjName(String gmobjName) {
		this.gmobjName = gmobjName;
	}


	public String getMcmcu() {
		return mcmcu;
	}


	public void setMcmcu(String mcmcu) {
		this.mcmcu = mcmcu;
	}


	public String getMcdc() {
		return mcdc;
	}


	public void setMcdc(String mcdc) {
		this.mcdc = mcdc;
	}

	public String getMcName() {
		return mcName;
	}


	public void setMcName(String mcName) {
		this.mcName = mcName;
	}


	public String getMcstyl() {
		return mcstyl;
	}


	public void setMcstyl(String mcstyl) {
		this.mcstyl = mcstyl;
	}


	public String getMcrp11() {
		return mcrp11;
	}


	public void setMcrp11(String mcrp11) {
		this.mcrp11 = mcrp11;
	}


	public String getMcrp12() {
		return mcrp12;
	}


	public void setMcrp12(String mcrp12) {
		this.mcrp12 = mcrp12;
	}
	
	public String getDpCode() {
		return dpCode;
	}

	public void setDpCode(String dpCode) {
		this.dpCode = dpCode;
	}

	public String getDpDpnm() {
		return dpDpnm;
	}

	public void setDpDpnm(String dpDpnm) {
		this.dpDpnm = dpDpnm;
	}

	public String getDpCoDpnm() {
		return dpCoDpnm;
	}

	public void setDpCoDpnm(String dpCoDpnm) {
		this.dpCoDpnm = dpCoDpnm;
	}
	/**
	 * @return the lib1
	 */
	public String getLib1() {
		return lib1;
	}


	/**
	 * @param lib1 the lib1 to set
	 */
	public void setLib1(String lib1) {
		this.lib1 = lib1;
	}


	/**
	 * @return the lib2
	 */
	public String getLib2() {
		return lib2;
	}


	/**
	 * @param lib2 the lib2 to set
	 */
	public void setLib2(String lib2) {
		this.lib2 = lib2;
	}


	/**
	 * @return the lib3
	 */
	public String getLib3() {
		return lib3;
	}


	/**
	 * @param lib3 the lib3 to set
	 */
	public void setLib3(String lib3) {
		this.lib3 = lib3;
	}


	/**
	 * @return the lib4
	 */
	public String getLib4() {
		return lib4;
	}


	/**
	 * @param lib4 the lib4 to set
	 */
	public void setLib4(String lib4) {
		this.lib4 = lib4;
	}
	
	@Override
	public String toString() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("gmobj", this.gmobj);
		jsonObj.put("gmobjName", this.gmobjName);
		
		jsonObj.put("mcmcu", this.mcmcu);
		jsonObj.put("mcName", this.mcName);
		
		jsonObj.put("dpcode", this.dpCode);
		jsonObj.put("dpCoDpnm", this.dpCoDpnm);
				
		jsonObj.put("mstcd", this.mstcd);
		jsonObj.put("mstrm", this.mstrm);
		jsonObj.put("className", super.toString());
		String rtnStr = jsonObj.toJSONString();
		return rtnStr;
	}
}
