package com.globaldenso.dnkr.domain;

/**
 * [KR] 조직도 정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class RelationDomain {

    /**
    * [KO] 조직관리 <br>
    * [EN] <br>
    * [JP] <br>
    */
    protected RelationDomain relationDomain;

    /**
    * [KO] 조직코드 <br>
    * [EN] <br>
    * [JP] <br>
    */
    protected String relationCode;

    /**
     * [KO] 연계코드 <br>
     * [EN] <br>
     * [JP] <br>
     */
    protected String rltnCode;
    
    /**
    * [KO] 조직이름 <br>
    * [EN] <br>
    * [JP] <br>
    */
    protected String relationName;

    /**
    * [KO] 조직이름 <br>
    * [EN] <br>
    * [JP] <br>
    */
    protected String cmcLangCode;

    /**
    * [KO] 조직 사용여부 <br>
    * [EN] <br>
    * [JP] <br>
    */
    protected String useYn;

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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    protected RelationDomain() {
        // no process   
    }

    
    /**
     * [KO] 조직관리도메인의 getter 메소드이다.<br>
     * [EN] It is a getter method of RelationDomain.<br>
     * [JP] <br>
     * 
     * @return the relationDomain
     */
    public RelationDomain getRelationDomain() {
        return relationDomain;
    }

    /**
     * [KO] 조직관리도메인의 setter 메소드이다.<br>
     * [EN] It is a setter method of RelationDomain.<br>
     * [JP] <br>
     * @param relationDomain RelationDomain
     */
    public void setRelationDomain(RelationDomain relationDomain) {
        this.relationDomain = relationDomain;
    }

    /**
     * [KO] 조직코드의 getter 메소드이다.<br>
     * [EN] It is a getter method of relationCode.<br>
     * [JP] <br>
     * 
     * @return the relationCode
     */
    public String getRelationCode() {
        return relationCode;
    }
    

    /**
    * [KO] 조직코드의 setter 메소드이다.<br>
    * [EN] It is a setter method of relationCode.<br>
    * [JP] <br>
    * @param relationCode String
    */
    public void setRelationCode(String relationCode) {
        this.relationCode = relationCode;
    }

    /**
     * [KO] 조직도 연계코드의 getter 메소드이다.<br>
     * [EN] It is a getter method of relationCode.<br>
     * [JP] <br>
     * 
     * @return the relationCode
     */
    public String getRltnCode() {
        return rltnCode;
    }
    

    /**
    * [KO] 조직도 연계코드의 setter 메소드이다.<br>
    * [EN] It is a setter method of relationCode.<br>
    * [JP] <br>
    * @param rltnCode String
    */
    public void setRltnCode(String rltnCode) {
        this.rltnCode = rltnCode;
    }

    /**
     * [KO] 조직명의 getter 메소드이다.<br>
     * [EN] It is a getter method of relation name.<br>
     * [JP] <br>
     * 
     * @return the relationName
     */
    public String getRelationName() {
        return relationName;
    }

    /**
     * [KO] 조직명의 setter 메소드이다.<br>
     * [EN] It is a setter method of relation name.<br>
     * [JP] <br>
     * @param relationName String
     */
    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }
    
    /**
     * [KO] 조직명의 getter 메소드이다.<br>
     * [EN] It is a getter method of relation name.<br>
     * [JP] <br>
     * 
     * @return the relationName
     */
    public String getCmcLangCode() {
        return cmcLangCode;
    }

    /**
     * [KO] 조직명의 setter 메소드이다.<br>
     * [EN] It is a setter method of relation name.<br>
     * [JP] <br>
     * @param cmcLangCode String
     */
    public void setCmcLangCode(String cmcLangCode) {
        this.cmcLangCode = cmcLangCode;
    }
    
    /**
     * [KO] 조직 사용여부의 getter 메소드이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return the useYn
     */
    public String getUseYn() {
        return useYn;
    }

    /**
     * [KO] 조직 사용여부의 setter 메소드이다.<br>
     * [EN] <br>
     * [JP] <br>
     * @param useYn String
     */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
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
     * [EN] It is a getter method of rowNumTo.<br>
     * [JP] rowNumTo のゲッターメソッドです。<br>
     * 
     * @return the rowNumTo
     */
    public int getRowNum() {
        return rowNum;
    }

    /**
     * [EN] It is a setter method of rowNumTo.<br>
     * [JP] rowNumTo のセッターメソッドです。<br>
     * 
     * @param rowNum int
     */
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

}
