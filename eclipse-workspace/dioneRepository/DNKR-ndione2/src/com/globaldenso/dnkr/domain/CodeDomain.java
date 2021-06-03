package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 코드정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class CodeDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -5344967488446084845L;
    
    
    /**
     * [KO] 공통 코드.<br>
     * [EN] Common code.<br>
     * [JP] <br>
     */
    private String cmcCode;
    
    /**
     * [KO] 상위 코드.<br>
     * [EN] Parent code.<br>
     * [JP] <br>
     */
    private String cmcParentCode;
    
    /**
     * [KO] 구분.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cmcType;
    
    /**
     * [KO] 사용여부.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cmcUseYN;
    
    /**
     * [KO] 등록일.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cmcRegdate;
    
    /**
     * [KO] 공통코드명.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cnmName;
    
    /**
     * [KO] 공통코드 설명.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cnmDescription;
    
    /**
     * [KO] 공통코드 사용언어.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cnmLangCode;
    
    /**
     * [EN] Paging(From).<br>
     * [JP] ページング(From)。<br>
     */
    private int rowNumFrom;
    
    /**
     * [EN] Paging(To).<br>
     * [JP] ページング(To)。<br>
     */
    private int rowNumTo;
    
    /**
     * [EN] Paging(rowCnt).<br>
     * [JP] ページング(rowCnt)。<br>
     */
    private int rowCnt;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CodeDomain(){
        // no process
    }
    
    
    /**
     * [KO] 공통 코드의 getter method 이다.<br>
     * [EN] It is a getter method of Common code.<br>
     * [JP] <br>
     * 
     * @return the cmcCode
     */
    public String getCmcCode() {
        return cmcCode;
    }

    /**
     * [KO] 공통 코드의 setter method 이다.<br>
     * [EN] It is a setter method of Common code.<br>
     * [JP] <br>
     * 
     * @param cmcCode String
     */
    public void setCmcCode(String cmcCode) {
        this.cmcCode = cmcCode;
    }

    /**
     * [KO] 공통 코드의 상위코드 getter method 이다.<br>
     * [EN] .<br>
     * [JP] <br>
     * 
     * @return the cmcCode
     */
    public String getCmcParentCode() {
        return cmcParentCode;
    }

    /**
     * [KO] 공통 코드의 상위코드 setter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param cmcParentCode String
     */
    public void setCmcParentCode(String cmcParentCode) {
        this.cmcParentCode = cmcParentCode;
    }

    /**
     * [KO] 공통 코드의 구분자 getter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return the cmcCode
     */
    public String getCmcType() {
        return cmcType;
    }

    /**
     * [KO] 공통 코드의 구분자 setter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param cmcType String
     */
    public void setCmcType(String cmcType) {
        this.cmcType = cmcType;
    }

    /**
     * [KO] 공통 코드의 사용여부 getter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return the cmcUseYN
     */
    public String getCmcUseYN() {
        return cmcUseYN;
    }

    /**
     * [KO] 공통 코드의 사용여부 setter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param cmcUseYN String
     */
    public void setCmcUseYN(String cmcUseYN) {
        this.cmcUseYN = cmcUseYN;
    }

    /**
     * [KO] 공통 코드의 등록일 getter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return the cmcCode
     */
    public String getCmcRegdate() {
        return cmcRegdate;
    }

    /**
     * [KO] 공통 코드의 등록일 setter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param cmcRegdate String
     */
    public void setCmcRegdate(String cmcRegdate) {
        this.cmcRegdate = cmcRegdate;
    }
    
    /**
     * [KO] 공통 코드의 사용여부 getter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return the cmcUseYN
     */
    public String getCnmName() {
        return cnmName;
    }
    
    /**
     * [KO] 공통 코드의 코드명 setter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param cnmName String
     */
    public void setCnmName(String cnmName) {
        this.cnmName = cnmName;
    }
    
    /**
     * [KO] 공통 코드의 사용여부 getter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return the cmcUseYN
     */
    public String getCnmDescription() {
        return cnmDescription;
    }
    
    /**
     * [KO] 공통 코드의 코드설명 etter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param cnmDescription String
     */
    public void setCnmDescription(String cnmDescription) {
        this.cnmDescription = cnmDescription;
    }
    
    /**
     * [KO] 공통 코드의 사용언어 getter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return the cmcUseYN
     */
    public String getCnmLangCode() {
        return cnmLangCode;
    }
    
    /**
     * [KO] 공통 코드의 사용언어 setter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param cnmLangCode String
     */
    public void setCnmLangCode(String cnmLangCode) {
        this.cnmLangCode = cnmLangCode;
    }

    /**
     * [EN] It is a getter method of rowNumFrom.<br>
     * [JP] rowNumFrom のゲッターメソッドです。<br>
     * 
     * @return the rowNumFrom
     */
    public int getRowNumFrom() {
        return rowNumFrom;
    }

    /**
     * [EN] It is a setter method of rowNumFrom.<br>
     * [JP] rowNumFrom のセッターメソッドです。<br>
     * 
     * @param rowNumFrom rowNumFrom に設定する
     */
    public void setRowNumFrom(int rowNumFrom) {
        this.rowNumFrom = rowNumFrom;
    }

    /**
     * [EN] It is a getter method of rowNumTo.<br>
     * [JP] rowNumTo のゲッターメソッドです。<br>
     * 
     * @return the rowNumTo
     */
    public int getRowNumTo() {
        return rowNumTo;
    }

    /**
     * [EN] It is a setter method of rowNumTo.<br>
     * [JP] rowNumTo のセッターメソッドです。<br>
     * 
     * @param rowNumTo rowNumTo に設定する
     */
    public void setRowNumTo(int rowNumTo) {
        this.rowNumTo = rowNumTo;
    }

    /**
     * [EN] It is a getter method of rowCnt.<br>
     * [JP] rowCnt のゲッターメソッドです。<br>
     * 
     * @return the rowCnt
     */
    public int getRowCnt() {
        return rowCnt;
    }

    /**
     * [EN] It is a setter method of rowCnt.<br>
     * [JP] rowCnt のセッターメソッドです。<br>
     * 
     * @param rowCnt rowCnt に設定する
     */
    public void setRowCnt(int rowCnt) {
        this.rowCnt = rowCnt;
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("cmcCode", this.cmcCode);
        jsonObj.put("cmcParentCode", this.cmcParentCode);
        jsonObj.put("cmcType", this.cmcType);
        jsonObj.put("cmcUseYN", this.cmcUseYN);
        jsonObj.put("cmcRegdate", this.cmcRegdate);
        jsonObj.put("cnmName", this.cnmName);
        jsonObj.put("cnmDescription", this.cnmDescription);
        jsonObj.put("cnmLangCode", this.cnmLangCode);
        jsonObj.put("rowNumFrom", this.rowNumFrom);
        jsonObj.put("rowNumTo", this.rowNumTo);
        jsonObj.put("rowCnt", this.rowCnt);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

}
