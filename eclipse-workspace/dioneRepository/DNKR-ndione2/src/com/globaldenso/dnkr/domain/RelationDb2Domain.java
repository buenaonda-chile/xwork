package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 조직도 정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class RelationDb2Domain implements Serializable{

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 2635316452479110137L;
    
    /**
     * [KR] 사업부<br>
     */
    private String dpcomp;
    
    /**
     * [KR] 짧은코드<br>
     */
    private String  dpcode;
    
    /**
     * [KR] 짧은명<br>
     */
    private String  dpconm;
    
    /**
     * [KR] 긴코드<br>
     */
    private String  dpdpcode;
    
    /**
     * [KR] 긴코드명<br>
     */
    private String  dpdpnm;
    
    /**
     * [KR] 코드 | 코드명<br>
     */
    private String  cdnm;
    
    /**
     * [KR] 파트코드<br>
     */
    private String  prtcd;
    
    /**
     * [KR] 파트코드명<br>
     */
    private String  prtnm;
    
    /**
     * [KR] 사업장<br>
     */
    private String  comps;
    
    /**
     * [KR] 라인코드<br>
     */
    private String  lincd;
    
    /**
     * [KR] 라인코드명<br>
     */
    private String  linnm;
    
    /**
     * [EN] Employee lib1.<br>
     * [JP] <br>
     */
    private String  lib1;
    
    /**
     * [EN] Employee lib2.<br>
     * [JP] <br>
     */
    private String  lib2;
    
    /**
     * [EN] Employee lib3.<br>
     * [JP] <br>
     */
    private String  lib3;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public RelationDb2Domain() {
        // no process   
    }


    /**
     * [KR] 사업부의 getter method
     * @return the dpcomp
     */
    public String getDpcomp() {
        return dpcomp;
    }

    /**
     * [KR] 사업부의 setter method
     * @param dpcomp String
     */
    public void setDpcomp(String dpcomp) {
        this.dpcomp = dpcomp;
    }

    /**
     * [KR] 짧은코드의 getter method
     * @return the dpcode
     */
    public String getDpcode() {
        return dpcode;
    }

    /**
     * [KR] 짧은코드의 setter method
     * @param dpcode String
     */
    public void setDpcode(String dpcode) {
        this.dpcode = dpcode;
    }

    /**
     * [KR] 짧은명의 getter method
     * @return the dpconm
     */
    public String getDpconm() {
        return dpconm;
    }

    /**
     * [KR] 짧은명의 setter method
     * @param dpconm String
     */
    public void setDpconm(String dpconm) {
        this.dpconm = dpconm;
    }

    /**
     * [KR] 긴코드의 getter method
     * @return the dpdpcode
     */
    public String getDpdpcode() {
        return dpdpcode;
    }

    /**
     * [KR] 긴코드의 setter method
     * @param dpdpcode String
     */
    public void setDpdpcode(String dpdpcode) {
        this.dpdpcode = dpdpcode;
    }

    /**
     * [KR] 긴코드명의 getter method
     * @return the dpdpnm
     */
    public String getDpdpnm() {
        return dpdpnm;
    }

    /**
     * [KR] 긴코드명의 setter method
     * @param dpdpnm String
     */
    public void setDpdpnm(String dpdpnm) {
        this.dpdpnm = dpdpnm;
    }
    
    /**
     * [KR] 코드 | 코드명의 getter method
     * @return the cdnm
     */
    public String getCdnm() {
        return cdnm;
    }

    /**
     * [KR] 코드 | 코드명의 setter method
     * @param cdnm String
     */
    public void setCdnm(String cdnm) {
        this.cdnm = cdnm;
    }

    /**
     * [KR] 파트코드의 getter method
     * @return the prtcd
     */
    public String getPrtcd() {
        return prtcd;
    }

    /**
     * [KR] 파트코드의 setter method
     * @param prtcd String
     */
    public void setPrtcd(String prtcd) {
        this.prtcd = prtcd;
    }

    /**
     * [KR] 파트코드명의 getter method
     * @return the prtnm
     */
    public String getPrtnm() {
        return prtnm;
    }

    /**
     * [KR] 파트코드명의 setter method
     * @param prtnm String
     */
    public void setPrtnm(String prtnm) {
        this.prtnm = prtnm;
    }

    /**
     * [KR] 사업부의 getter method
     * @return the comps
     */
    public String getComps() {
        return comps;
    }

    /**
     * [KR] 사업부의 setter method
     * @param comps String
     */
    public void setComps(String comps) {
        this.comps = comps;
    }

    /**
     * [KR] 라인코드의 getter method
     * @return the lincd
     */
    public String getLincd() {
        return lincd;
    }

    /**
     * [KR] 라인코드의 setter method
     * @param lincd String
     */
    public void setLincd(String lincd) {
        this.lincd = lincd;
    }

    /**
     * [KR] 라인코드명의 getter method
     * @return the linnm
     */
    public String getLinnm() {
        return linnm;
    }

    /**
     * [KR] 라인코드명의 setter method
     * @param linnm String
     */
    public void setLinnm(String linnm) {
        this.linnm = linnm;
    }
    
    /**
     * @return the lib1
     */   
    public String getLib1() {
        return lib1;
    }

    /**
     * @param lib1 String
     */
    public void setLib1(String lib1) {
        this.lib1 = lib1;
    }
    
    /**
     * @return the lib2
     */   
    public String getLib2() {
        return lib2;
    }

    /**
     * @param lib2 String
     */
    public void setLib2(String lib2) {
        this.lib2 = lib2;
    }

    /**
     * @return the lib3
     */   
    public String getLib3() {
        return lib3;
    }

    /**
     * @param lib3 String
     */
    public void setLib3(String lib3) {
        this.lib3 = lib3;
    }
    
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("dpcomp", this.dpcomp);
        jsonObj.put("dpcode", this.dpcode);
        jsonObj.put("dpconm", this.dpconm);
        jsonObj.put("dpdpcode", this.dpdpcode);
        jsonObj.put("dpdpnm", this.dpdpnm);
        jsonObj.put("cdnm", this.cdnm);
        jsonObj.put("prtcd", this.prtcd);
        jsonObj.put("prtnm", this.prtnm);
        jsonObj.put("lincd", this.lincd);
        jsonObj.put("linnm", this.linnm);
        jsonObj.put("comps", this.comps);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }
}
