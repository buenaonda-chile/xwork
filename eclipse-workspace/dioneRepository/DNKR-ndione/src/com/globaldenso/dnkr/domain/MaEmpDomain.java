package com.globaldenso.dnkr.domain;

import java.io.Serializable;
/***
 */
public class MaEmpDomain implements Serializable{


    
    /**
     * 더존 ERP 사원정보 Domain
     *  /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    private static final long serialVersionUID = -3230700030219779150L;
 
    /**
     * [EN] Employee number.<br>
     * [KR] 사번
     * [JP] <br>
     */
    private String noEmp;

    /**
     * [EN] cdCompany code.<br>
     * [KR] 회사코드
     * [JP] <br>
     */
    private String cdCompany;
    
    /**
     * [EN] nmKor.<br>
     * [KR] 한글이름
     * [JP] <br>
     */
    private String nmKor;
    
    /**
     * [EN] nmEng.<br>
     * [KR] 영문이름
     * [JP] <br>
     */
    private String nmEng;
    
    /**
     * [EN] nmChin.<br>
     * [KR] 한자이름
     * [JP] <br>
     */
    private String nmChin;
    
    /**
     * [EN] cdBizarea code.<br>
     * [KR] 사업장 코드
     * [JP] <br>
     */
    private String cdBizarea;
    
    /**
     * [EN] cdDept code.<br>
     * [KR] 부서 코드
     * [JP] <br>
     */
    private String cdDept;
    
    /**
     * [EN] email address.<br>
     * [KR] 이메일주소
     * [JP] <br>
     */
    private String noEmail;
    
    /**
     * [EN] income code.<br>
     * [KR] 재직구분
     * [JP] <br>
     */
    private String cdIncom;   
    
    /**
     * [EN] income code name.<br>
     * [KR] 재직구분명
     * [JP] <br>
     */
    private String cdIncomNm;
    
    /**
     * [EN] tpemp code.<br>
     * [KR] 사원구분
     * [JP] <br>
     */
    private String tpEmp;
    
    /**
     * [EN]  tpemp code name.<br>
     * [KR] 사원구분명
     * [JP] <br>
     */
    private String tpEmpNm;
    
    /**
     * [EN]  cdDutyStep code.<br>
     * [KR] 직급코드
     * [JP] <br>
     */
    private String cdDutyStep;
    
    /**
     * [EN]  cdDutyStep code name.<br>
     * [KR] 직급명
     * [JP] <br>
     */
    private String cdDutyStepNm;
    
    /**
     * [EN]  cdNation code.<br>
     * [KR] 네외구분코드
     * [JP] <br>
     */
    private String cdNation;
    
    /**
     * [EN]  cdNation code name.<br>
     * [KR] 내외구분명
     * [JP] <br>
     */
    private String cdNationNm;
    
    /***
     */
    public MaEmpDomain() {
        // no process
    }

    /**
     * @return cdDept
     */
    public String getNoEmp() {
        return noEmp;
    }

    /**
     * @param noEmp String
     */
    public void setNoEmp(String noEmp) {
        this.noEmp = noEmp;
    }

    /**
     * @return cdDept
     */
    public String getCdCompany() {
        return cdCompany;
    }

    /**
     * @param cdCompany String
     */
    public void setCdCompany(String cdCompany) {
        this.cdCompany = cdCompany;
    }

    /**
     * @return cdDept
     */
    public String getNmKor() {
        return nmKor;
    }

    /**
     * @param nmKor String
     */
    public void setNmKor(String nmKor) {
        this.nmKor = nmKor;
    }

    /**
     * @return nmEng
     */
    public String getNmEng() {
        return nmEng;
    }

    /**
     * @param nmEng String
     */
    public void setNmEng(String nmEng) {
        this.nmEng = nmEng;
    }

    /**
     * @return nmChin
     */
    public String getNmChin() {
        return nmChin;
    }

    /**
     * @param nmChin String
     */
    public void setNmChin(String nmChin) {
        this.nmChin = nmChin;
    }

    /**
     * @return cdBizarea
     */
    public String getCdBizarea() {
        return cdBizarea;
    }

    /**
     * @param cdBizarea String
     */
    public void setCdBizarea(String cdBizarea) {
        this.cdBizarea = cdBizarea;
    }

    /**
     * @return cdDept
     */
    public String getCdDept() {
        return cdDept;
    }

    /**
     * @param cdDept String
     */
    public void setCdDept(String cdDept) {
        this.cdDept = cdDept;
    }

    /**
     * @return noEmail
     */
    public String getNoEmail() {
        return noEmail;
    }

    /**
     * @param noEmail String
     */
    public void setNoEmail(String noEmail) {
        this.noEmail = noEmail;
    }

	public String getCdIncom() {
		return cdIncom;
	}

	public void setCdIncom(String cdIncom) {
		this.cdIncom = cdIncom;
	}

	public String getCdIncomNm() {
		return cdIncomNm;
	}

	public void setCdIncomNm(String cdIncomNm) {
		this.cdIncomNm = cdIncomNm;
	}

	public String getTpEmp() {
		return tpEmp;
	}

	public void setTpEmp(String tpEmp) {
		this.tpEmp = tpEmp;
	}

	public String getTpEmpNm() {
		return tpEmpNm;
	}

	public void setTpEmpNm(String tpEmpNm) {
		this.tpEmpNm = tpEmpNm;
	}

	public String getCdDutyStep() {
		return cdDutyStep;
	}

	public void setCdDutyStep(String cdDutyStep) {
		this.cdDutyStep = cdDutyStep;
	}

	public String getCdDutyStepNm() {
		return cdDutyStepNm;
	}

	public void setCdDutyStepNm(String cdDutyStepNm) {
		this.cdDutyStepNm = cdDutyStepNm;
	}

	public String getCdNation() {
		return cdNation;
	}

	public void setCdNation(String cdNation) {
		this.cdNation = cdNation;
	}

	public String getCdNationNm() {
		return cdNationNm;
	}

	public void setCdNationNm(String cdNationNm) {
		this.cdNationNm = cdNationNm;
	}
    
	
}
