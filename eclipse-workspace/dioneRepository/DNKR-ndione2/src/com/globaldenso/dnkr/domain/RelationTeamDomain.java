package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * 
 */
public class RelationTeamDomain extends RelationDomain implements Serializable{

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -5919437299779275732L;

    /**
    * [KO] 사업부 코드.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String clsCode;
    
    /**
    * [KO] 사업장(상위) 코드.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String locCode;

    /**
    * [KO] 사업부명.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String clsName;

    /**
    * [KO] 사업장(상위)명.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String locName;

    /**
    * [KO] 상위 코드.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String hRltnCode;

    /**
    * [KO] 권한코드.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String authCode;
    
    /**
    * [KO] 사업부 코드 사용유무.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String clsUse;
    
    /**
    * [KO] 사업부 코드 사용유무.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String locUse;    

    /**
    * [EN] Default constructor.<br>
    * [JP] デフォルトコンストラクタ。<br>
    */
    public RelationTeamDomain () { 
        //no process
    }

    /**
    * [KR] 사업부 getter method
    * @return the locCode
    */
    public String getClsCode() {
        return clsCode;
    }
    /**
    * [KR] 사업부 setter method
    * @param clsCode String
    */
    public void setClsCode(String clsCode) {
        this.clsCode = clsCode;
    }

    /**
    * [KR] 사업장(상위) getter method
    * @return the locCode
    */
    public String getLocCode() {
        return locCode;
    }
    /**
    * [KR] 사업장(상위) setter method
    * @param locCode String
    */
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }
    /**
    * [KR] 사업부 getter method
    * @return the locCode
    */
    public String getClsName() {
        return clsName;
    }
    /**
    * [KR] 사업부 setter method
    * @param clsName String
    */
    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    /**
    * [KR] 사업장(상위) getter method
    * @return the locCode
    */
    public String getLocName() {
        return locName;
    }
    /**
    * [KR] 사업장(상위) setter method
    * @param locName String
    */
    public void setLocName(String locName) {
        this.locName = locName;
    }
    
    /**
    * [KR] 상위 getter method
    * @return the locCode
    */
    public String getHRltnCode() {
        return hRltnCode;
    }

    /**
    * [KR] 상위 setter method
    * @param hRltnCode String
    */
    public void setHRltnCode(String hRltnCode) {
        this.hRltnCode = hRltnCode;
    }
    
    /**
    * [KR] 권한코드 getter method
    * @return the authCode
    */
    public String getAuthCode() {
        return authCode;
    }

    /**
    * [KR] 권한코드 setter method
    * @param authCode String
    */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("relationCode", this.relationCode);
        jsonObj.put("rltnCode", this.rltnCode);
        jsonObj.put("relationName", this.relationName);
        jsonObj.put("cmcLangCode", this.cmcLangCode);
        jsonObj.put("locCode", this.locCode);
        jsonObj.put("clsCode", this.clsCode);
        jsonObj.put("authCode", this.authCode);
        jsonObj.put("useYn", this.useYn);
        jsonObj.put("rowNumFrom", this.rowNumFrom);
        jsonObj.put("rowNumTo", this.rowNumTo);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }
}
