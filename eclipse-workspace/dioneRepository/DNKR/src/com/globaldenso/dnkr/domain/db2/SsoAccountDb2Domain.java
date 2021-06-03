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
public class SsoAccountDb2Domain implements Serializable{

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 1499049531088869616L;
    
    /**
     * [EN] System ID.<br>
     * [JP] <br>
     */
    private String systemId;
    
    /**
     * [EN] System Password.<br>
     * [JP] <br>
     */
    private String systemPw;
    
    /**
     * [EN] System Group.<br>
     * [JP] <br>
     */
    private String systemGru;
    
    /**
     * [EN] System URL.<br>
     * [JP] <br>
     */
    private String systemUrl;
    
    /**
     * [EN] System Url2.<br>
     * [JP] <br>
     */
    private String systemUrl2;
    
    /**
     * [EN] System Login Y, N.<br>
     * [JP] <br>
     */
    private String loginYn;
    
    /**
     * [EN] System ID.<br>
     * [JP] <br>
     */
    private String userId;
    
    /**
     * [EN] Employee company.<br>
     * [JP] 従業員番号。<br>
     */
    private String company;
    
    /**
     * [EN] System ID.<br>
     * [JP] <br>
     */
    private String systemSeq;
    
    
    /* 2018.06.08 IT 제화복 추가
     * Printer Session 추가 
    */
    /**
     * [EN] Device ID1.<br>
     * [JP] <br>
     */
    private String device1;
    
    /**
     * [EN] Device ID2.<br>
     * [JP] <br>
     */
    private String device2;

    /**
     * [EN] Device Count.<br>
     * [JP] <br>
     */
    private String deviceCnt;
    
    
    //2019.01.28추가
    /**
     * [EN] Dione plant Code.<br>
     * [JP] <br>
     */
    private String plantCd;
    
    /**
     * [EN] Dione Account Count.<br>
     * [JP] <br>
     */
    private String dioneCnt;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SsoAccountDb2Domain() {
        // no process
    }

    
    /**
     * [KO] code의 getter method 이다.<br>
     * [EN] It is a getter method of code.<br>
     * [JP] <br>
     * 
     * @return the code
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * [KO] systemId의 setter method 이다.<br>
     * [EN] It is a setter method of systemId.<br>
     * [JP] <br>
     * 
     * @param systemId String
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    /**
     * [KO] systemPw의 getter method 이다.<br>
     * [EN] It is a getter method of systemPw.<br>
     * [JP] <br>
     * 
     * @return the systemPw
     */
    public String getSystemPw() {
        return systemPw;
    }

    /**
     * [KO] systemPw의 setter method 이다.<br>
     * [EN] It is a setter method of systemPw.<br>
     * [JP] <br>
     * 
     * @param systemPw String
     */
    public void setSystemPw(String systemPw) {
        this.systemPw = systemPw;
    }

    /**
     * [KO] systemGru의 getter method 이다.<br>
     * [EN] It is a getter method of systemGru.<br>
     * [JP] <br>
     * 
     * @return the systemGru
     */
    public String getSystemGru() {
        return systemGru;
    }

    /**
     * [KO] systemGru의 setter method 이다.<br>
     * [EN] It is a setter method of systemGru.<br>
     * [JP] <br>
     * 
     * @param systemGru String
     */
    public void setSystemGru(String systemGru) {
        this.systemGru = systemGru;
    }

    /**
     * [KO] systemUrl의 getter method 이다.<br>
     * [EN] It is a getter method of systemUrl.<br>
     * [JP] <br>
     * 
     * @return the systemUrl
     */
    public String getSystemUrl() {
        return systemUrl;
    }

    /**
     * [KO] systemUrl의 setter method 이다.<br>
     * [EN] It is a setter method of systemUrl.<br>
     * [JP] <br>
     * 
     * @param systemUrl String
     */
    public void setSystemUrl(String systemUrl) {
        this.systemUrl = systemUrl;
    }

    /**
     * [KO] systemUrl2의 getter method 이다.<br>
     * [EN] It is a getter method of systemUrl2.<br>
     * [JP] <br>
     * 
     * @return the systemUrl2
     */
    public String getSystemUrl2() {
        return systemUrl2;
    }

    /**
     * [KO] systemUrl2의 setter method 이다.<br>
     * [EN] It is a setter method of systemUrl2.<br>
     * [JP] <br>
     * 
     * @param systemUrl2 String
     */
    public void setSystemUrl2(String systemUrl2) {
        this.systemUrl2 = systemUrl2;
    }

    /**
     * [KO] loginYn의 getter method 이다.<br>
     * [EN] It is a getter method of loginYn.<br>
     * [JP] <br>
     * 
     * @return the loginYn
     */
    public String getLoginYn() {
        return loginYn;
    }

    /**
     * [KO] loginYn의 setter method 이다.<br>
     * [EN] It is a setter method of loginYn.<br>
     * [JP] <br>
     * 
     * @param loginYn String
     */
    public void setLoginYn(String loginYn) {
        this.loginYn = loginYn;
    }

    /**
     * [KO] userId의 getter method 이다.<br>
     * [EN] It is a getter method of userId.<br>
     * [JP] <br>
     * 
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * [KO] userId의 setter method 이다.<br>
     * [EN] It is a setter method of userId.<br>
     * [JP] <br>
     * 
     * @param userId String
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * [KO] systemSeq의 getter method 이다.<br>
     * [EN] It is a getter method of systemSeq.<br>
     * [JP] <br>
     * 
     * @return the systemSeq
     */
    public String getSystemSeq() {
        return systemSeq;
    }

    /**
     * [KO] systemSeq의 setter method 이다.<br>
     * [EN] It is a setter method of systemSeq.<br>
     * [JP] <br>
     * 
     * @param systemSeq String
     */
    public void setSystemSeq(String systemSeq) {
        this.systemSeq = systemSeq;
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("systemId", this.systemId);
        jsonObj.put("systemPw", this.systemPw);
        jsonObj.put("systemGru", this.systemGru);
        jsonObj.put("systemUrl", this.systemUrl);
        jsonObj.put("systemUrl2", this.systemUrl2);
        jsonObj.put("loginYn", this.loginYn);
        jsonObj.put("userId", this.userId);
        jsonObj.put("systemSeq", this.systemSeq);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }


	public String getDevice1() {
		return device1;
	}


	public void setDevice1(String device1) {
		this.device1 = device1;
	}


	public String getDevice2() {
		return device2;
	}


	public void setDevice2(String device2) {
		this.device2 = device2;
	}


	public String getDeviceCnt() {
		return deviceCnt;
	}


	public void setDeviceCnt(String deviceCnt) {
		this.deviceCnt = deviceCnt;
	}


	/**
	 * @return the plantCd
	 */
	public String getPlantCd() {
		return plantCd;
	}


	/**
	 * @param plantCd the plantCd to set
	 */
	public void setPlantCd(String plantCd) {
		this.plantCd = plantCd;
	}


	/**
	 * @return the dioneCnt
	 */
	public String getDioneCnt() {
		return dioneCnt;
	}


	/**
	 * @param dioneCnt the dioneCnt to set
	 */
	public void setDioneCnt(String dioneCnt) {
		this.dioneCnt = dioneCnt;
	}
        
}
