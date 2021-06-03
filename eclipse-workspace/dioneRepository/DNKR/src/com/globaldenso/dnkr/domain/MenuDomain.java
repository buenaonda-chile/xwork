package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
/**
 * [KR] 메뉴관리 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class MenuDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143742L;
    
    /**
     * [KR] 메뉴코드 <br>
     */
    private String mcdCode;
    
    /**
     * [KR] 메뉴아이콘 <br>
     */
    private String mcdIcon;
    
    /**
     * [KR] 메뉴사용여부<br>
     */
    private String mcdUse;
    
    /**
     * [KR] 메뉴정렬순서<br>
     */
    private int mcdSort;
    
    /**
     * [KR] 보모메뉴코드<br>
     */
    private String mcdRef;
    
    /**
     * [KR] 보모메뉴코드명<br>
     */
    private String mcdRefName;
    
    /**
     * [KR] 링크 URL<br>
     */
    private String mcdUrl;
    
    /**
     * [KR] 링크 URL<br>
     */
    private int mcdDepth;
    
    /**
     * [KR] 언어코드<br>
     */
    private String langCmc;
    
    /**
     * [KR] 메뉴명칭( langCmc에 지정된 언어에 해당하는 명칭 )<br>
     */
    private String mcdName;
    
    /**
     * [KR] 새창여부<br>
     */
    private String mcdNewWindow;
    
    /**
     * [KR] 새창여부<br>
     */
    private String mcdAddCert;
    
    /**
     * [KR] 모바일 여부<br>
     */
    private String mcdMobile;
    
    /**
     * [KO] depth에 따른 전체메뉴명<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String depthFullName;
    
    /**
     * [KO] 즐겨찾기 사용여부<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String useYn;
    
    /**
     * [KR] 메뉴명칭(하위리스트)<br>
     */
    private List<MenuDomain> subList = new ArrayList<MenuDomain>();
    
    /**
     * [KR] 메뉴명칭 맵(언어별)<br>
     */
    
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
     * [EN] empNumber(To).<br>
     * [JP] ページング(To)。<br>
     */
    private String empNumber;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public MenuDomain(){
        // no process
    }
    
    
    /**
     * [KR] 하위메뉴 리스트 의 getter method
     * @return the subList
     */
    public List<MenuDomain> getSubList() {
        
        return subList;
    }

    /**
     * [KR] 하위메뉴 리스트 의 setter method
     * @param subDomain to set
     */
    public void setSubList(MenuDomain subDomain) {
        
        this.subList.add(subDomain);
    }
    
    /**
     * [KR] 메뉴코드의 getter method
     * @return the code
     */
    public String getMcdCode() {
        return mcdCode;
    }

    /**
     * [KR] 메뉴코드의 setter method
     * @param mcdCode String
     */
    public void setMcdCode(String mcdCode) {
        this.mcdCode = mcdCode;
    }
    
    /**
     * [KR] 메뉴아이콘의 getter method
     * @return mcdIcon
     */
    public String getMcdIcon() {
        return mcdIcon;
    }

    /**
     * [KR] 메뉴아이콘의 setter method
     * @param mcdIcon String
     */
    public void setMcdIcon(String mcdIcon) {
        this.mcdIcon = mcdIcon;
    }

    /**
     * [KR] 메뉴사용여부 getter method
     * @return the use
     */
    public String getMcdUse() {
        return mcdUse;
    }

    /**
     * [KR] 메뉴사용여부 setter method
     * @param mcdUse String
     */
    public void setMcdUse(String mcdUse) {
        this.mcdUse = mcdUse;
    }

    /**
     * [KR] 메뉴정렬순서 getter method
     * @return the sort
     */
    public int getMcdSort() {
        return mcdSort;
    }

    /**
     * [KR] 메뉴정렬순서 setter method
     * @param mcdSort int
     */
    public void setMcdSort(int mcdSort) {
        this.mcdSort = mcdSort;
    }

    /**
     * [KR] 부모메뉴코드 getter method
     * @return the parentCode
     */
    public String getMcdRef() {
        return mcdRef;
    }

    /**
     * [KR] 부모메뉴코드 setter method
     * @param mcdRef String
     */
    public void setMcdRef(String mcdRef) {
        this.mcdRef = mcdRef;
    }

    /**
     * [KR] 링크 URL getter method
     * @return the url
     */
    public String getMcdUrl() {
        return mcdUrl;
    }

    /**
     * [KR] 링크 URL setter method
     * @param mcdUrl String
     */
    public void setMcdUrl(String mcdUrl) {
        this.mcdUrl = mcdUrl;
    }
    
    /**
     * [KR] Depth getter method
     * @return the mcdDepth
     */
    public int getMcdDepth() {
        return mcdDepth;
    }

    /**
     * [KR] Depth setter method
     * @param mcdDepth the mcdDepth to set
     */
    public void setMcdDepth(int mcdDepth) {
        this.mcdDepth = mcdDepth;
    }

    /**
     * [KR] 언어코드 getter method
     * @return the langCmc
     */
    public String getLangCmc() {
        return langCmc;
    }

    /**
     * [KR] 언어코드 setter method ( 언어별 명칭 맵이 존재한다면 지정된 언어에 해당하는 명칭을 해당 맵에서 찾아 name을 함께 set )
     * @param langCmc the langCmc to set
     */
    public void setLangCmc(String langCmc) {
        this.langCmc = langCmc;
        
    }

    /**
     * [KR] 메뉴명칭 getter method
     * @return the name
     */
    public String getMcdName() {
        return mcdName;
    }

    /**
     * [KR] 메뉴명칭 setter method
     * @param mcdName String
     */
    public void setMcdName(String mcdName) {
        this.mcdName = mcdName;
    }
    
    /**
     * [KR] 새창여부 getter method
     * @return the mcdNewWindow
     */
    public String getMcdNewWindow() {
        return mcdNewWindow;
    }

    /**
     * [KR] 새창여부 setter method
     * @param mcdNewWindow String
     */
    public void setMcdNewWindow(String mcdNewWindow) {
        this.mcdNewWindow = mcdNewWindow;
    }
    
    /**
     * [KR] 메뉴링크 이동시 추가인증 여부 getter method
     * @return the mcdAddCert
     */
    public String getMcdAddCert() {
        return mcdAddCert;
    }

    /**
     * [KR] 메뉴링크 이동시 추가인증 여부 setter method
     * @param mcdAddCert String
     */
    public void setMcdAddCert(String mcdAddCert) {
        this.mcdAddCert = mcdAddCert;
    }
    
    /**
     * [EN] It is a getter method of setDepthFullName.<br>
     * [JP] <br>
     * 
     * @return the setDepthFullName
     */
    public String getDepthFullName() {
        return depthFullName;
    }

    /**
     * [EN] It is a setter method of setDepthFullName.<br>
     * [JP] <br>
     * 
     * @param depthFullName String
     */
    public void setDepthFullName(String depthFullName) {
        this.depthFullName = depthFullName;
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
     * @return mcdRefName
     */
    public String getMcdRefName() {
        return mcdRefName;
    }


    /**
     * @param mcdRefName String
     */
    public void setMcdRefName(String mcdRefName) {
        this.mcdRefName = mcdRefName;
    }

    /**
     * @return useYn
     */
    public String getUseYn() {
        return useYn;
    }


    /**
     * @param useYn String
     */
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    /**
     * @return mcdMobile
     */
    public String getMcdMobile() {
        return mcdMobile;
    }

    /**
     * @param mcdMobile String
     */
    public void setMcdMobile(String mcdMobile) {
        this.mcdMobile = mcdMobile;
    }
    
    /**
     * @return empNumber
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


	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("mcdCode", this.mcdCode);
        jsonObj.put("mcdIcon", this.mcdIcon);
        jsonObj.put("mcdUse", this.mcdUse);
        jsonObj.put("mcdSort", this.mcdSort);
        jsonObj.put("mcdRef", this.mcdRef);
        jsonObj.put("mcdRefName", this.mcdRefName);
        jsonObj.put("mcdUrl", this.mcdUrl);
        jsonObj.put("mcdDepth", this.mcdDepth);
        jsonObj.put("langCmc", this.langCmc);
        jsonObj.put("mcdName", this.mcdName);
        jsonObj.put("mcdNewWindow", this.mcdNewWindow);
        jsonObj.put("mcdAddCert", this.mcdAddCert);
        jsonObj.put("mcdMobile", this.mcdMobile);
        jsonObj.put("depthFullName", this.depthFullName);
        jsonObj.put("rowNumFrom", this.rowNumFrom);
        jsonObj.put("rowNumTo", this.rowNumTo);
        jsonObj.put("className", super.toString());
        jsonObj.put("useYn", this.useYn);
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }
}
