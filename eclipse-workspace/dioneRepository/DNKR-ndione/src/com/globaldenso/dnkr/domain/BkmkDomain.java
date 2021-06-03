package com.globaldenso.dnkr.domain;

import java.io.Serializable;
/**
 * [KR] 메뉴관리 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class BkmkDomain implements Serializable {

	
	
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143742L;
    
    /**
     * [KR] 회원코드 <br>   
     */
    private String empNumber;   
    
    /**
     * [KR] 메뉴코드 <br>   
     */
    private String menuCode;
    
    /**
     * [KR] 메뉴코드명 <br>  
     */
    private String menuCodeNm;
    
    /**
     * [KR] 메뉴정렬 순서<br>
     */
    private String menuSort;
    
    /**
     * [KR] 언어코드<br>
     */
    private String langCmc;
    
    /**
     * [KR] 메뉴아이콘<br>
     */
    private String mcdIcon;
    
    /**
     * [KR] 메뉴 경로<br>
     */
    private String mcdUrl;
    /**
     * 
     */
    public BkmkDomain () {
        //no process
    }
    
    /**
     * @return ㄹㄹㄹ
     */
    public String getEmpNumber() {
        return empNumber;
    }
    /**
     * @param empNumber String
     */
    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    /**
     * @return ㄹㄹㄹ
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * @param menuCode String
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * @return ㄹㄹㄹ
     */
    public String getMenuSort() {
        return menuSort;
    }

    /**
     * @param menuSort String
     */
    public void setMenuSort(String menuSort) {
        this.menuSort = menuSort;
    }

    /**
     * @return ㄹㄹㄹ
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return ㄹㄹㄹ
     */
    public String getMenuCodeNm() {
        return menuCodeNm;
    }

    /**
     * @param menuCodeNm String
     */
    public void setMenuCodeNm(String menuCodeNm) {
        this.menuCodeNm = menuCodeNm;
    }

    /**
     * @return ㄹㄹㄹ
     */
    public String getLangCmc() {
        return langCmc;
    }

    /**
     * @param langCmc String
     */
    public void setLangCmc(String langCmc) {
        this.langCmc = langCmc;
    }

    /**
     * @return ㄹㄹㄹ
     */
    public String getMcdIcon() {
        return mcdIcon;
    }

    /**
     * @param mcdIcon String
     */
    public void setMcdIcon(String mcdIcon) {
        this.mcdIcon = mcdIcon;
    }

    /**
     * @return ㄹㄹㄹ
     */
    public String getMcdUrl() {
        return mcdUrl;
    }

    /**
     * @param mcdUrl String
     */
    public void setMcdUrl(String mcdUrl) {
        this.mcdUrl = mcdUrl;
    }
    
    
}
