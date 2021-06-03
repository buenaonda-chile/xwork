package com.globaldenso.dnkr.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.json.simple.JSONObject;

/**
 * [KR] 사원정보 도메인 <br>
 * [EN] Domain class of Employee information.<br>
 * [JP] 社員情報のDomainクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class EmpDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -9081802919041897234L;

    /**
     * [EN] Employee number.<br>
     * [JP] 従業員番号。<br>
     */
    private List<String> empNumList;
    
    /**
     * [EN] Employee number.<br>
     * [JP] 従業員番号。<br>
     */
    private String empNumber;
    
    /**
     * [KO] 사업부 코드 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String clsCode;
    
    /**
     * [KO] 사업장 코드 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String locCode;
    
    /**
     * [KO] 부서(팀) 코드 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String teamCode;
        
    /**
     * [KO] 사업부 명칭 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String clsName;
    
    /**
     * [KO] 사업장 명칭 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String locName;
    
    /**
     * [KO] 부서(팀) 명칭 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String teamName;
    
    /**
     * [KO] 권한 코드 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String authCode;
    
    /**
     * [EN] Last name.<br>
     * [JP] 名前(名)。<br>
     */
    private String lastName;
    
    /**
     * [EN] First name.<br>
     * [JP] 名前(姓)。<br>
     */
    private String firstName;
    
    /**
     * [EN] Full name.<br>
     * [JP] 氏名。<br>
     */
    private String empName;
    
    /**
     * [EN] E-mail address.<br>
     * [JP] E-Mailアドレス。<br>
     */
    private String empEmail;
    
    /**
     * [EN] Employee ID.<br>
     * [JP] 従業員番号。<br>
     */
    private String empId;
    
    
    /**
     * [KO] 사용여부.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String empUse;
    
    /**
     * [EN] Last sync date.<br>
     * [JP] 最終更新日時。<br>
     */
    private Timestamp empSyncDate;
    
    /**
     * [KO] 사원 비밀번호.<br>
     * [EN] Employee password.<br><br>
     * [JP] <br>
     */
    private String empPwd;
    
    /**
     * [KO] 개인권한여부.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String empPrivateAuth;
    
   /**
    * [KO] 내부직원, 외부업체 구분.<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String inOutType;
    
    /**
     * [KO] 언어코드.<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cmcLangCode;
    
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
     * 
     */
    private String relName;
    
    /**
     * H_TEAM_CODE 가 teamCode 를 사용하고있어서 부가적으로 생성
     */
    private String teamCd;
    
    
    
    /**
     * 협럭업체의 업무 사업부
     */
    private String relationCopLoc;
    
    /**
     * 협럭업체의 업무 사업부명
     */
    private String relationCopLocName;
    
    /**
     * 협럭업체 사업자등록번호
     */
    private String relationCopNo;
    
    /**
     * 협럭업체 전용유무
     */
    private String externalAccount;
    
    
	/**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public EmpDomain() {
        // no process
    }
    
    
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @return String
     */
    public String getTeamCd() {
        return teamCd;
    }



    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param teamCd String
     */
    public void setTeamCd(String teamCd) {
        this.teamCd = teamCd;
    }




    /**
     * @return the relName
     */   
    public String getRelName() {
        return relName;
    }
    /**
     * @param relName String
     */
    public void setRelName(String relName) {
        this.relName = relName;
    }    
    
    /**
     * [EN] It is a getter method of EmpNumList.<br>
     * [JP] EmpNumList のゲッターメソッドです。<br>
     * 
     * @return empNumList
     */
    public List<String> getEmpNumList() {
        return empNumList;
    }

    /**
     * @param empNumList List<String>
     */
    public void setEmpNumList(List<String> empNumList) {
        this.empNumList = empNumList;
    }

    /**
     * [EN] It is a getter method of empNo.<br>
     * [JP] empNo のゲッターメソッドです。<br>
     * 
     * @return the empNo
     */
    public String getEmpNumber() {
        return empNumber;
    }

    /**
     * [EN] It is a setter method of empNo.<br>
     * [JP] empNo のセッターメソッドです。<br>
     * 
     * @param empNumber String
     */
    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    /**
     * [EN] It is a getter method of clsCode.<br>
     * [JP] clsCode のゲッターメソッドです。<br>
     * 
     * @return the deptNo
     */
    public String getClsCode() {
        return clsCode;
    }

    /**
     * [EN] It is a setter method of clsCode.<br>
     * [JP] clsCode のセッターメソッドです。<br>
     * 
     * @param clsCode clsCode に設定する
     */
    public void setClsCode(String clsCode) {
        this.clsCode = clsCode;
    }
    
    /**
     * [EN] It is a getter method of locCode.<br>
     * [JP] locCode のゲッターメソッドです。<br>
     * 
     * @return the locCode
     */
    public String getLocCode() {
        return locCode;
    }

    /**
     * [EN] It is a setter method of locCode.<br>
     * [JP] locCode のセッターメソッドです。<br>
     * 
     * @param locCode locCode に設定する
     */
    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }


    /**
     * [EN] It is a getter method of deptNo.<br>
     * [JP] deptNo のゲッターメソッドです。<br>
     * 
     * @return the deptNo
     */
    public String getTeamCode() {
        return teamCode;
    }

    /**
     * [EN] It is a setter method of deptNo.<br>
     * [JP] noticeNo のセッターメソッドです。<br>
     * 
     * @param teamCode String
     */
    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }
    
    /**
     * [EN] It is a getter method of clsCode.<br>
     * [JP] clsCode のゲッターメソッドです。<br>
     * 
     * @return the deptNo
     */
    public String getClsName() {
        return clsName;
    }

    /**
     * [EN] It is a setter method of clsCode.<br>
     * [JP] clsCode のセッターメソッドです。<br>
     * 
     * @param clsName String
     */
    public void setClsName(String clsName) {
        this.clsName = clsName;
    }
    
    /**
     * [EN] It is a getter method of locCode.<br>
     * [JP] locCode のゲッターメソッドです。<br>
     * 
     * @return the locCode
     */
    public String getLocName() {
        return locName;
    }

    /**
     * [EN] It is a setter method of locCode.<br>
     * [JP] locCode のセッターメソッドです。<br>
     * 
     * @param locName String
     */
    public void setLocName(String locName) {
        this.locName = locName;
    }


    /**
     * [EN] It is a getter method of deptNo.<br>
     * [JP] deptNo のゲッターメソッドです。<br>
     * 
     * @return the deptNo
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * [EN] It is a setter method of deptNo.<br>
     * [JP] noticeNo のセッターメソッドです。<br>
     * 
     * @param teamName String
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * [EN] It is a getter method of authCode.<br>
     * [JP] authCode のゲッターメソッドです。<br>
     * 
     * @return the authCode
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * [EN] It is a setter method of authCode.<br>
     * [JP] authCode のセッターメソッドです。<br>
     * 
     * @param authCode authCode に設定する
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     * [EN] It is a getter method of lastName.<br>
     * [JP] lastName のゲッターメソッドです。<br>
     * 
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * [EN] It is a setter method of lastName.<br>
     * [JP] lastName のセッターメソッドです。<br>
     * 
     * @param lastName lastName に設定する
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * [EN] It is a getter method of firstName.<br>
     * [JP] firstName のゲッターメソッドです。<br>
     * 
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * [EN] It is a setter method of firstName.<br>
     * [JP] firstName のセッターメソッドです。<br>
     * 
     * @param firstName firstName に設定する
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * [EN] It is a getter method of empName.<br>
     * [JP] empName のゲッターメソッドです。<br>
     * 
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * [EN] It is a setter method of empName.<br>
     * [JP] empName のセッターメソッドです。<br>
     * 
     * @param empName empName に設定する
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * [EN] It is a getter method of email.<br>
     * [JP] email のゲッターメソッドです。<br>
     * 
     * @return the email
     */
    public String getEmpEmail() {
        return empEmail;
    }

    /**
     * [EN] It is a setter method of email.<br>
     * [JP] email のセッターメソッドです。<br>
     * 
     * @param empEmail String
     */
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    /**
     * [EN] It is a getter method of empId.<br>
     * [JP] empId のゲッターメソッドです。<br>
     * 
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * [EN] It is a setter method of empId.<br>
     * [JP] empId のセッターメソッドです。<br>
     * 
     * @param empId empId に設定する
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * [KO] 사원의 정보 사용여부 getter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @return the cmcUseYN
     */
    public String getEmpUse() {
        return empUse;
    }

    /**
     * [KO] 사원의 정보 사용여부 setter method 이다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param empUse String
     */
    public void setEmpUse(String empUse) {
        this.empUse = empUse;
    }

    /**
     * [EN] It is a getter method of empSyncDate.<br>
     * [JP] EmpSyncDate のゲッターメソッドです。<br>
     * 
     * @return the empSyncDate
     */
    public Timestamp getEmpSyncDate() {
        return empSyncDate;
    }

    /**
     * [EN] It is a setter method of empSyncDate.<br>
     * [JP] empSyncDate のセッターメソッドです。<br>
     * 
     * @param empSyncDate empSyncDate に設定する
     */
    public void setEmpSyncDate(Timestamp empSyncDate) {
        this.empSyncDate = empSyncDate;
    }

    /**
     * [EN] It is a getter method of empPwd.<br>
     * [JP] empPwd のゲッターメソッドです。<br>
     * 
     * @return the empPwd
     */
    public String getEmpPwd() {
        return empPwd;
    }

    /**
     * [EN] It is a setter method of empPwd.<br>
     * [JP] empPwd のセッターメソッドです。<br>
     * 
     * @param empPwd empPwd に設定する
     */
    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    /**
     * [EN] It is a getter method of empPrivateAuth.<br>
     * [JP] empPrivateAuth のゲッターメソッドです。<br>
     * 
     * @return the empPrivateAuth
     */
    public String getEmpPrivateAuth() {
        return empPrivateAuth;
    }

    /**
     * [EN] It is a setter method of empPrivateAuth.<br>
     * [JP] empPrivateAuth のセッターメソッドです。<br>
     * 
     * @param empPrivateAuth empPrivateAuth に設定する
     */
    public void setEmpPrivateAuth(String empPrivateAuth) {
        this.empPrivateAuth = empPrivateAuth;
    }
    
    
    /**
     * [EN] It is a getter method of inOutType.<br>
     * [JP] inOutType のゲッターメソッドです。<br>
     * 
     * @return the inOutType
     */
    public String getInOutType() {
        return inOutType;
    }


    /**
     * [EN] It is a setter method of inOutType.<br>
     * [JP] inOutType のセッターメソッドです。<br>
     * 
     * @param inOutType inOutType に設定する
     */
    public void setInOutType(String inOutType) {
        this.inOutType = inOutType;
    }


    public String getRelationCopLoc() {
		return relationCopLoc;
	}


	public void setRelationCopLoc(String relationCopLoc) {
		this.relationCopLoc = relationCopLoc;
	}

	public String getRelationCopLocName() {
		return relationCopLocName;
	}

	public void setRelationCopLocName(String relationCopLocName) {
		this.relationCopLocName = relationCopLocName;
	}

	public String getRelationCopNo() {
		return relationCopNo;
	}


	public void setRelationCopNo(String relationCopNo) {
		this.relationCopNo = relationCopNo;
	}
	
	public String getExternalAccount() {
		return externalAccount;
	}

	public void setExternalAccount(String externalAccount) {
		this.externalAccount = externalAccount;
	}



	/**
     * [EN] It is a getter method of empPrivateAuth.<br>
     * [JP] empPrivateAuth のゲッターメソッドです。<br>
     * 
     * @return the cmcLangCode
     */
    public String getCmcLangCode() {
        return cmcLangCode;
    }

    /**
     * [EN] It is a setter method of empPrivateAuth.<br>
     * [JP] empPrivateAuth のセッターメソッドです。<br>
     * 
     * @param cmcLangCode String に設定する
     */
    public void setCmcLangCode(String cmcLangCode) {
        this.cmcLangCode = cmcLangCode;
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
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("empNumber", this.empNumber);
        jsonObj.put("empName", this.empName);
        jsonObj.put("empId", this.empId);	//2019.07.25추가 JHB
        jsonObj.put("locCode", this.locCode);	//2019.07.25추가 JHB
        jsonObj.put("clsCode", this.clsCode);	//2019.07.25추가 JHB
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
    
    
}
