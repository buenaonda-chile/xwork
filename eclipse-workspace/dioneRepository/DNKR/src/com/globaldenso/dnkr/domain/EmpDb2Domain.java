package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 사원정보 도메인 <br>
 * [EN] Domain class of Employee information.<br>
 * [JP] 社員情報のDomainクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class EmpDb2Domain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -2416734915898910560L;

    
    /**
     * [EN] Employee ID.<br>
     * [JP] <br>
     */
    private String userId;
    
    /**
     * [EN] Employee name.<br>
     * [JP] <br>
     */
    private String userName;
    
    /**
     * [EN] Employee company.<br>
     * [JP] 従業員番号。<br>
     */
    private String company;
    
    /**
     * [EN] Employee plant code.<br>
     * [JP] <br>
     */
    private String plantCd;
    
    /**
     * [EN] Employee password.<br>
     * [JP] <br>
     */
    private String password;
    
    /**
     * [KO] 사원번호
     * [EN] Employee number.<br>
     * [JP] <br>
     */
    private String sabun;
    
    /**
     * [KO] 사원명
     * [EN] Employee name.<br>
     * [JP] <br>
     */
    private String kornm;
    
    /**
     * [KO] 부서코드
     * [EN] Employee department code.<br>
     * [JP] <br>
     */
    private String dptcd;
    
    /**
     * [KO] 실시부서코드
     * [EN] Employee department code.<br>
     * [JP] <br>
     */
    private String sdpcd;
    
    /**
     * [KO] 메뉴코드<br>
     */
    private String mcode;
    
    /**
     * [KO] 그리드용 컬럽<br>
     */
    private String code;
    
    /**
     * [KO] 그리드용 컬럽<br>
     */
    private String name1;
    
    /**
     * [KO] 그리드용 컬럽<br>
     */
    private String name2;
    
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
     * [EN] Employee menuj_pw.<br>
     * [JP] <br>
     */
    private String menu_pw;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public EmpDb2Domain() {
        // no process
    }
    
    
    
    /**
     * @return the userId
     */   
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId String
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */   
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName String
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return the company
     */   
    public String getCompany() {
        return company;
    }

    /**
     * @param company String
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the plantCd
     */   
    public String getPlantCd() {
        return plantCd;
    }

    /**
     * @param plantCd String
     */
    public void setPlantCd(String plantCd) {
        this.plantCd = plantCd;
    }
    
    /**
     * @return the menuj_pw
     */ 
    public String getPassword() {
        return password;
    }

    /**
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return String
     */
    public String getSabun() {
        return sabun;
    }

    /**
     * 
     * @param sabun String
     */
    public void setSabun(String sabun) {
        this.sabun = sabun;
    }

    /**
     * 
     * @return kornm
     */
    public String getKornm() {
        return kornm;
    }

    /**
     * 
     * @param kornm String
     */
    public void setKornm(String kornm) {
        this.kornm = kornm;
    }

    /**
     * 
     * @return dptcd
     */
    public String getDptcd() {
        return dptcd;
    }

    /**
     * 
     * @param dptcd String
     */
    public void setDptcd(String dptcd) {
        this.dptcd = dptcd;
    }

    /**
     * 
     * @return sdpcd
     */
    public String getSdpcd() {
        return sdpcd;
    }

    /**
     * 
     * @param sdpcd String
     */
    public void setSdpcd(String sdpcd) {
        this.sdpcd = sdpcd;
    }
    
    /**
     * [KO] mcode의 getter method 이다.<br>
     * [EN] It is a getter method of mcode.<br>
     * [JP] <br>
     * 
     * @return the mcode
     */
    public String getMcode() {
        return mcode;
    }

    /**
     * [KO] mcode의 setter method 이다.<br>
     * [EN] It is a setter method of mcode.<br>
     * [JP] <br>
     * 
     * @param mcode String
     */
    public void setMcode(String mcode) {
        this.mcode = mcode;
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
     * [KO] name1의 getter method 이다.<br>
     * [EN] It is a getter method of name1.<br>
     * [JP] <br>
     * 
     * @return the name1
     */
    public String getName1() {
        return name1;
    }

    /**
     * [KO] name1의 setter method 이다.<br>
     * [EN] It is a setter method of name1.<br>
     * [JP] <br>
     * 
     * @param name1 String
     */
    public void setName1(String name1) {
        this.name1 = name1;
    }
    
    /**
     * [KO] name2의 getter method 이다.<br>
     * [EN] It is a getter method of name2.<br>
     * [JP] <br>
     * 
     * @return the name2
     */
    public String getName2() {
        return name2;
    }

    /**
     * [KO] name2의 setter method 이다.<br>
     * [EN] It is a setter method of name2.<br>
     * [JP] <br>
     * 
     * @param name2 String
     */
    public void setName2(String name2) {
        this.name2 = name2;
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
     * @return the menuj_pw
     */ 
    public String getMenu_pw() {
        return menu_pw;
    }

    /**
     * @param menu_pw String
     */
    public void setMenu_pw(String menu_pw) {
        this.menu_pw = menu_pw;
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("userId", this.userId);
        jsonObj.put("userName", this.userName);
        jsonObj.put("company", this.company);
        jsonObj.put("plantCd", this.plantCd);
        jsonObj.put("password", this.password);
        jsonObj.put("sabun", this.sabun);
        jsonObj.put("kornm", this.kornm);
        jsonObj.put("code", this.code);
        jsonObj.put("name1", this.name1);
        jsonObj.put("name2", this.name2);
        jsonObj.put("lib1", this.lib1);
        jsonObj.put("lib2", this.lib2);
        jsonObj.put("lib3", this.lib3);
        jsonObj.put("lib4", this.lib4);
        jsonObj.put("menu_pw", this.menu_pw);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

	public String getLib4() {
		return lib4;
	}

	public void setLib4(String lib4) {
		this.lib4 = lib4;
	}

}
