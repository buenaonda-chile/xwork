package com.globaldenso.dnkr.domain;

import java.io.Serializable;
/***
 */
public class MaDeptDomain implements Serializable{

    
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
    private String cdDept;

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
    private String nmDept;
    
    /**
     * [EN] nmEng.<br>
     * [KR] 영문이름
     * [JP] <br>
     */
    private String cdBizarea;
    
    /**
     * [EN] nmChin.<br>
     * [KR] 한자이름
     * [JP] <br>
     */
    private String cdCc;
    /**
     * 
     */
    private String hDept;
    /**
     * 
     */
    public MaDeptDomain() {
        // no process
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
     * @return cdCompany
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
     * @return nmDept
     */
    public String getNmDept() {
        return nmDept;
    }

    /**
     * @param nmDept String
     */
    public void setNmDept(String nmDept) {
        this.nmDept = nmDept;
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
     * @return cdCc
     */
    public String getCdCc() {
        return cdCc;
    }

    /**
     * @param cdCc String
     */
    public void setCdCc(String cdCc) {
        this.cdCc = cdCc;
    }

    /**
     * @return serialVersionUID
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return hDept
     */
    public String gethDept() {
        return hDept;
    }

    /**
     * @param hDept String
     */
    public void sethDept(String hDept) {
        this.hDept = hDept;
    }

}
