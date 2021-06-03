package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.util.List;
/**
 * [KR] 권한 정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
/**
 * @author UXIS
 *
 */
public class AuthDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 7287103375784704870L;

    /**
     * 
     */
    private List<AuthDomain> authList;
    
    /**
     * [EN] Auth code.<br>
     * [JP] <br>
     */
    private String authCode;
    
    /**
     * [EN] Auth use.<br>
     * [JP] <br>
     */
    private String useYn;
    
    /**
     * [EN] Auth name.<br>
     * [JP] <br>
     */
    private String authName;
    
    /**
     * [EN] Auth name.<br>
     * [JP] <br>
     */
    private String authDescription;
    
    /**
     * [EN] Common language code.<br>
     * [JP] <br>
     */
    private String cmcLangCode;
    
    /**
     * [EN] Menu code.<br>
     * [JP] <br>
     */
    private String menuCode;
    
    /**
     * [EN] Menu code.<br>
     * [JP] <br>
     */
    private String menuName;
    
    /**
     * [EN] Menu code.<br>
     * [JP] <br>
     */
    private String menuDepth;
    
    /**
     * [EN] Menu code.<br>
     * [JP] <br>
     */
    private String menuDepthFullName;

    /**
     * [KO] 권한구분 번호 : 읽기권한(1), 쓰기권한(2), 수정권한(4), 삭제권한(8).<br>
     * [KO] ex: 읽기권한(1) + 쓰기권한 (2) + 수정권한(4) = 7<br>
     * [EN] Auth number.<br>
     * [JP] <br>
     */
    private int authNum;
    
    /**
     * [KO] 권한구분 번호 : 읽기권한(1), 쓰기권한(2), 수정권한(4), 삭제권한(8).<br>
     * [KO] ex: 읽기권한(1) + 쓰기권한 (2) + 수정권한(4) = 7<br>
     * [EN] Auth number.<br>
     * [JP] <br>
     */
    private String authBinaryNum;
    
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
     * [EN] Paging(To).<br>
     * [JP] ページング(To)。<br>
     */
    private int rowNum;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AuthDomain () {
        //no process
    }
    
    
    /**
     * [EN] It is a getter method of authCode.<br>
     * [JP] <br>
     * 
     * @return the authCode
     */
    public List<AuthDomain> getAuthList() {
        return authList;
    }

    /**
     * [EN] It is a setter method of authCode.<br>
     * [JP] <br>
     * 
     * @param authList List<AuthDomain>
     */
    public void setAuthList(List<AuthDomain> authList) {
        this.authList = authList;
    }
    
    /**
     * [EN] It is a getter method of authCode.<br>
     * [JP] <br>
     * 
     * @return the authCode
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * [EN] It is a setter method of authCode.<br>
     * [JP] <br>
     * 
     * @param authCode String
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     * [EN] It is a getter method of useYn.<br>
     * [JP] <br>
     * 
     * @return the useYn
     */
    public String getUseYn() {
        return useYn;
    }

    /**
     * [EN] It is a setter method of useYn.<br>
     * [JP] <br>
     * 
     * @param useYn String
     */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    /**
     * [EN] It is a getter method of authName.<br>
     * [JP] <br>
     * 
     * @return the authName
     */
    public String getAuthName() {
        return authName;
    }

    /**
     * [EN] It is a setter method of authName.<br>
     * [JP] <br>
     * 
     * @param authName String
     */
    public void setAuthName(String authName) {
        this.authName = authName;
    }

    /**
     * [EN] It is a getter method of authDescription.<br>
     * [JP] <br>
     * 
     * @return the authDescription
     */
    public String getAuthDescription() {
        return authDescription;
    }

    /**
     * [EN] It is a setter method of authDescription.<br>
     * [JP] <br>
     * 
     * @param authDescription String
     */
    public void setAuthDescription(String authDescription) {
        this.authDescription = authDescription;
    }

    /**
     * [EN] It is a getter method of cmcLangCode.<br>
     * [JP] <br>
     * 
     * @return the cmcLangCode
     */
    public String getCmcLangCode() {
        return cmcLangCode;
    }

    /**
     * [EN] It is a setter method of cmcLangCode.<br>
     * [JP] <br>
     * 
     * @param cmcLangCode String
     */
    public void setCmcLangCode(String cmcLangCode) {
        this.cmcLangCode = cmcLangCode;
    }

    /**
     * [EN] It is a getter method of menuCode.<br>
     * [JP] <br>
     * 
     * @return the menuCode
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * [EN] It is a setter method of menuCode.<br>
     * [JP] <br>
     * 
     * @param menuCode String
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
    

    /**
     * [EN] It is a getter method of menuName.<br>
     * [JP] <br>
     * 
     * @return the menuName
     */
    public String getMenuName() {
        return menuName;
    }


    /**
     * [EN] It is a setter method of menuName.<br>
     * [JP] <br>
     * 
     * @param menuName String
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * [EN] It is a getter method of menuDepth.<br>
     * [JP] <br>
     * 
     * @return the menuDepth
     */
    public String getMenuDepth() {
        return menuDepth;
    }

    /**
     * [EN] It is a setter method of menuDepth.<br>
     * [JP] <br>
     * 
     * @param menuDepth String
     */
    public void setMenuDepth(String menuDepth) {
        this.menuDepth = menuDepth;
    }

    /**
     * [EN] It is a getter method of menuDepthFullName.<br>
     * [JP] <br>
     * 
     * @return the menuDepthFullName
     */
    public String getMenuDepthFullName() {
        return menuDepthFullName;
    }

    /**
     * [EN] It is a setter method of menuDepthFullName.<br>
     * [JP] <br>
     * 
     * @param menuDepthFullName String
     */
    public void setMenuDepthFullName(String menuDepthFullName) {
        this.menuDepthFullName = menuDepthFullName;
    }

    /**
     * [EN] It is a getter method of authNum.<br>
     * [JP] <br>
     * 
     * @return the authNum
     */
    public int getAuthNum() {
        return authNum;
    }

    /**
     * [EN] It is a setter method of authNum.<br>
     * [JP] <br>
     * 
     * @param authNum String
     */
    public void setAuthNum(int authNum) {
        this.authNum = authNum;
    }
    
    /**
     * [EN] It is a getter method of authNum.<br>
     * [JP] <br>
     * 
     * @return the authNum
     */
    public String getAuthBinaryNum() {
        return authBinaryNum;
    }

    /**
     * [EN] It is a setter method of authNum.<br>
     * [JP] <br>
     * 
     * @param authNum int
     */
    public void setAuthBinaryNum(int authNum) {
        StringBuffer sBuffer = new StringBuffer(); 
        
        if(authNum > 0){
            for(int i = 0; i < Integer.numberOfLeadingZeros(authNum) - 28; i++) {
                sBuffer.append(0);
            }
            sBuffer.append(Integer.toBinaryString(authNum));
        }else {
            sBuffer.append("0000");
        }
        
        this.authBinaryNum = sBuffer.toString();
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
     * @param rowNum int に設定する
     */
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
}
