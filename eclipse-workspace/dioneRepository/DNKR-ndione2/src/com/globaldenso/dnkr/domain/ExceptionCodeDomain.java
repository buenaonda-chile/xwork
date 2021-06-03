package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
/**
 * 
 */
public class ExceptionCodeDomain extends CommonDb2Domain implements Serializable{

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -5919437299779275732L;

    
    /**
     * [KO] 코드 종류.<br>
     * [EN] <br>
     * [JP] <br>
     */
	private String pCodeType;
	
    /**
     * [KO] 코드 종류.<br>
     * [EN] <br>
     * [JP] <br>
     */
	private String codeType;
     
     /**
      * [KO] 예외 코드.<br>
      * [EN] <br>
      * [JP] <br>
      */
    private String code;
    
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
     * [KO] 타시스템 사용여부.<br>
     * [EN] <br>
     * [JP] <br>
     */
	private String useTf;

    /**
     * [EN] 비고.<br>
     * [JP] <br>
     */
	private String etc;
	
     /**
      * [EN] Param Link createUser.<br>
      * [JP] <br>
      */
	private String createUser;
     
     /**
      * [EN] Param Link updateUser.<br>
      * [JP] <br>
      */
	private String updateUser;
         
  
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
     * [KO] 예외코드명 <br>
     * [EN] <br>
     * [JP] <br>
     */
    protected String codeName;
    
    
    /**
     * [KO] 트랜잭션플래그 <br>
     * [EN] <br>
     * [JP] <br>
     */
    protected String trProcCode;
    
    

     /**
      * [EN] Paging(From).<br>
      * [JP] ページング(From)。<br>
      */
	protected int rowNumFrom;
     
     /**
      * [EN] Paging(To).<br>
      * [JP] ページング(To)。<br>
      */
	protected int rowNumTo;
     
     /**
      * [EN] Paging(To).<br>
      * [JP] ページング(To)。<br>
      */
	private int rowNum;
	
    /**
    * [KO] 언어 <br>
    * [EN] <br>
    * [JP] <br>
    */
    protected String cmcLangCode;
     
     
     /**
      * [EN] Default constructor.<br>
      * [JP] デフォルトコンストラクタ。<br>
      */
	protected ExceptionCodeDomain() {
         // no process   
	}


     /**
	 * @return the pCodeType
	 */
	public String getpCodeType() {
		return pCodeType;
	}


	/**
	 * @param pCodeType the pCodeType to set
	 */
	public void setpCodeType(String pCodeType) {
		this.pCodeType = pCodeType;
	}


	/**
	 * @return the codeType
	 */
	public String getCodeType() {
		return codeType;
	}


	/**
	 * @param codeType the codeType to set
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * @return the locCode
	 */
	public String getLocCode() {
		return locCode;
	}


	/**
	 * @param locCode the locCode to set
	 */
	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}


	/**
	 * @return the clsCode
	 */
	public String getClsCode() {
		return clsCode;
	}


	/**
	 * @param clsCode the clsCode to set
	 */
	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}


	/**
	 * @return the locName
	 */
	public String getLocName() {
		return locName;
	}


	/**
	 * @param locName the locName to set
	 */
	public void setLocName(String locName) {
		this.locName = locName;
	}


	/**
	 * @return the clsName
	 */
	public String getClsName() {
		return clsName;
	}


	/**
	 * @param clsName the clsName to set
	 */
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}


	/**
	 * @return the codeName
	 */
	public String getCodeName() {
		return codeName;
	}


	/**
	 * @param codeName the codeName to set
	 */
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}


	/**
	 * @return the useTf
	 */
	public String getUseTf() {
		return useTf;
	}


	/**
	 * @param useTf the useTf to set
	 */
	public void setUseTf(String useTf) {
		this.useTf = useTf;
	}


	/**
	 * @return the etc
	 */
	public String getEtc() {
		return etc;
	}


	/**
	 * @param etc the etc to set
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}


	/**
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}


	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}


	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}


	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}




	/**
	 * @return the trProcCode
	 */
	public String getTrProcCode() {
		return trProcCode;
	}


	/**
	 * @param trProcCode the trProcCode to set
	 */
	public void setTrProcCode(String trProcCode) {
		this.trProcCode = trProcCode;
	}


	/**
	 * @return the rowNumFrom
	 */
	public int getRowNumFrom() {
		return rowNumFrom;
	}


	/**
	 * @param rowNumFrom the rowNumFrom to set
	 */
	public void setRowNumFrom(int rowNumFrom) {
		this.rowNumFrom = rowNumFrom;
	}


	/**
	 * @return the rowNumTo
	 */
	public int getRowNumTo() {
		return rowNumTo;
	}


	/**
	 * @param rowNumTo the rowNumTo to set
	 */
	public void setRowNumTo(int rowNumTo) {
		this.rowNumTo = rowNumTo;
	}


	/**
     * [KO] rowNum의 getter 메소드이다.<br>
     * [EN] It is a getter method of rowNum.<br>
     * [JP] <br>
	 * @return the rowNum
	 */
	public int getRowNum() {
		return rowNum;
	}


	/**
	 * 
     * [KO] rowNum의 getter 메소드이다.<br>
     * [EN] It is a getter method of rowNum.<br>
     * [JP] <br>
	 * @param rowNum the rowNum to set
	 */
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}


	/**
	 * @return the cmcLangCode
	 */
	public String getCmcLangCode() {
		return cmcLangCode;
	}


	/**
	 * @param cmcLangCode the cmcLangCode to set
	 */
	public void setCmcLangCode(String cmcLangCode) {
		this.cmcLangCode = cmcLangCode;
	}


	/**
      * [KO] 조직코드의 getter 메소드이다.<br>
      * [EN] It is a getter method of relationCode.<br>
      * [JP] <br>
      * 
      * @return the relationCode
      */
	

     @Override
     public String toString() {
         JSONObject jsonObj = new JSONObject();
         jsonObj.put("codeType", this.codeType);
         jsonObj.put("code", this.code);
         jsonObj.put("clsCode", this.clsCode);
         jsonObj.put("locCode", this.locCode);
         jsonObj.put("useTf", this.useTf);
         jsonObj.put("etc", this.etc);
         jsonObj.put("createUser", this.createUser);
         jsonObj.put("updateUser", this.updateUser);
         jsonObj.put("locName", this.locName);
         jsonObj.put("clsName", this.clsName);
         jsonObj.put("codeName", this.codeName);

         jsonObj.put("trProcCode", this.trProcCode);
         jsonObj.put("rowNumFrom", this.rowNumFrom);
         jsonObj.put("rowNumTo", this.rowNumTo);
         jsonObj.put("className", super.toString());
         String rtnStr = jsonObj.toJSONString();
         
         return rtnStr;
     }
}