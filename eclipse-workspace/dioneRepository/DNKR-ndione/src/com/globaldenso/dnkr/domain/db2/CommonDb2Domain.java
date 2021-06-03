package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * 
 * Describe the outline of this class.
 * 
 * <p>
 * Describe the detail of this class.
 * </p>
 *
 * @author $Author$
 * @version $Revision$
 */
public class CommonDb2Domain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -5559833330478453871L;

    /**
     * [KO] code<br>
     */
    private String code;
    
    /**
     * [KO] DB2 coded1<br>
     */
    private String codeNm;
    
    /**
     * [KO] DB2 comps<br>
     */
    private String comps;
    
    /**
     * [KO] DB2 company<br>
     */
    private String company;
    
    /**
     * [KO] DB2 grpcd<br>
     */
    private String grpcd;
    
    /**
     * [KO] DB2 coded1<br>
     */
    private String cdNm;
    
    /**
     * [KO] DB2 vndnr<br>
     */
    private String vndnr;
    
    /**
     * [KO] DB2 vname<br>
     */
    private String vname;
    
    /**
     * [EN] Employee lib1.<br>
     * [JP] 従業員番号。<br>
     */
    private String lib1;
    
    /**
     * [EN] Employee lib2.<br>
     * [JP] <br>
     */
    private String lib2;
    
    /**
     * [EN] Employee lib3.<br>
     * [JP] <br>
     */
    private String lib3;
    
    /**
     * [EN] Employee lib4.<br>
     * [JP] <br>
     */
    private String lib4;

    /**
     * [EN] locCode.<br>
     * [JP] <br>
     */
    private String locCode;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CommonDb2Domain() {
        // no process
    }

    /**
     * [KO] code의 getter method 이다.<br>
     * [EN] It is a getter method of code.<br>
     * [JP] <br>
     * 
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * [KO] code의 setter method 이다.<br>
     * [EN] It is a setter method of code.<br>
     * [JP] <br>
     * 
     * @param code String
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * [KO] codeNm의 getter method 이다.<br>
     * [EN] It is a getter method of codeNm.<br>
     * [JP] <br>
     * 
     * @return the codeNm
     */
    public String getCodeNm() {
        return codeNm;
    }

    /**
     * [KO] codeNm의 setter method 이다.<br>
     * [EN] It is a setter method of codeNm.<br>
     * [JP] <br>
     * 
     * @param codeNm String
     */
    public void setCodeNm(String codeNm) {
        this.codeNm = codeNm;
    }

    /**
     * [KO] cdNm의 getter method 이다.<br>
     * [EN] It is a getter method of cdNm.<br>
     * [JP] <br>
     * 
     * @return the cdNm
     */
    public String getCdNm() {
        return cdNm;
    }

    /**
     * [KO] cdNm의 setter method 이다.<br>
     * [EN] It is a setter method of cdNm.<br>
     * [JP] <br>
     * 
     * @param cdNm String
     */
    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }
    
    /**
     * [KO] comps의 getter method 이다.<br>
     * [EN] It is a getter method of comps.<br>
     * [JP] <br>
     * 
     * @return the comps
     */
    public String getComps() {
        return comps;
    }

    /**
     * [KO] comps의 setter method 이다.<br>
     * [EN] It is a setter method of comps.<br>
     * [JP] <br>
     * 
     * @param comps String
     */
    public void setComps(String comps) {
        this.comps = comps;
    }
    
    /**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
     * [KO] grpcd의 getter method 이다.<br>
     * [EN] It is a getter method of grpcd.<br>
     * [JP] <br>
     * 
     * @return the grpcd
     */
    public String getGrpcd() {
        return grpcd;
    }

    /**
     * [KO] grpcd의 setter method 이다.<br>
     * [EN] It is a setter method of grpcd.<br>
     * [JP] <br>
     * 
     * @param grpcd String
     */
    public void setGrpcd(String grpcd) {
        this.grpcd = grpcd;
    }
    
    /**
     * @return the lib1
     */   
    public String getLib1() {
        return lib1;
    }

    /**
     * @param lib1 String
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
     * @param lib2 String
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
     * @param lib3 String
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
        jsonObj.put("code", this.code);
        jsonObj.put("codeNm", this.codeNm);
        jsonObj.put("cdNm", this.cdNm);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

	public String getVndnr() {
		return vndnr;
	}

	public void setVndnr(String vndnr) {
		this.vndnr = vndnr;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}
}
