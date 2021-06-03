package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 중복차종서열코드마스타 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class DuplTypeOrderCodeMstDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;
    
    /**
     * [KR] 사업부코드 <br>
     */
    private String comps;
    
    /**
     * [KR] 업체코드 <br>
     */
    private String pyvnd;
    
    /**
     * [KR] 대표차종<br>
     */
    private String mcrcd;
    
    /**
     * [KR] 대표서열<br>
     */
    private String msecd;
    
    /**
     * [KR] 상세차종<br>
     */
    private String mcrc1;
    
    /**
     * [KR] 상세서열<br>
     */
    private String msec1;
    
    /**
     * [KR] 품번<br>
     */
    private String pspno;
    
    /**
     * [KR] ITEM DESCRIPTION<br>
     */
    private String itdsc;
    
    /**
     * [KR] CUSTONER NAME<br>
     */
    private String cusnm;
    
    /**
     * [KR] 대표차종명<br>
     */
    private String carnm;
    
    /**
     * [KR] CUSTOMER PART NO<br>
     */
    private String cprtn;
    
    
    /**
     * [KR] 상세차종(수정전)<br>
     */
    private String oldMcrc1;
    
    /**
     * [KR] 상세서열(수정전)<br>
     */
    private String oldMsec1;

    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String lib1;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String lib2;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String lib3;
    
    private String selchk;
    
    /**
     * [KR] 사업부코드의 getter method
     * @return the comps
     */
    public String getComps() {
        return comps;
    }

    /**
     * [KR] 사업부코드의 setter method
     * @param comps String
     */
    public void setComps(String comps) {
        this.comps = comps;
    }

    /**
     * [KR] 업체코드의 getter method
     * @return the pyvnd
     */
    public String getPyvnd() {
        return pyvnd;
    }

    /**
     * [KR] 업체코드의 setter method
     * @param pyvnd String
     */
    public void setPyvnd(String pyvnd) {
        this.pyvnd = pyvnd;
    }
    
    /**
     * [KR] 대표차종의 getter method
     * @return the mcrcd
     */
    public String getMcrcd() {
        return mcrcd;
    }

    /**
     * [KR] 대표차종의 setter method
     * @param mcrcd String
     */
    public void setMcrcd(String mcrcd) {
        this.mcrcd = mcrcd;
    }    

    /**
     * [KR] 대표서열의 getter method
     * @return the msecd
     */
    public String getMsecd() {
        return msecd;
    }

    /**
     * [KR] 대표서열의 setter method
     * @param msecd String
     */
    public void setMsecd(String msecd) {
        this.msecd = msecd;
    } 
    
    /**
     * [KR] 상세차종의 getter method
     * @return the mcrc1
     */
    public String getMcrc1() {
        return mcrc1;
    }

    /**
     * [KR] 상세차종의 setter method
     * @param mcrc1 String
     */
    public void setMcrc1(String mcrc1) {
        this.mcrc1 = mcrc1;
    } 
    
    /**
     * [KR] 상세서열의 getter method
     * @return the msec1
     */
    public String getMsec1() {
        return msec1;
    }

    /**
     * [KR] 상세서열의 setter method
     * @param msec1 String
     */
    public void setMsec1(String msec1) {
        this.msec1 = msec1;
    }
    
    /**
     * [KR] 품번의 getter method
     * @return the pspno
     */
    public String getPspno() {
        return pspno;
    }

    /**
     * [KR] 품번의 setter method
     * @param pspno String
     */
    public void setPspno(String pspno) {
        this.pspno = pspno;
    }
    
    /**
     * [KR] ITEM DESCRIPTION의 getter method
     * @return the itdsc
     */
    public String getItdsc() {
        return itdsc;
    }

    /**
     * [KR] ITEM DESCRIPTION의 setter method
     * @param itdsc String
     */
    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }
    
    /**
     * [KR] CUSTONER NAME의 getter method
     * @return the cusnm
     */
    public String getCusnm() {
        return cusnm;
    }

    /**
     * [KR] CUSTONER NAME의 setter method
     * @param cusnm String
     */
    public void setCusnm(String cusnm) {
        this.cusnm = cusnm;
    }
    
    /**
     * [KR] 대표차종명의 getter method
     * @return the carnm
     */
    public String getCarnm() {
        return carnm;
    }

    /**
     * [KR] 대표차종명의 setter method
     * @param carnm String
     */
    public void setCarnm(String carnm) {
        this.carnm = carnm;
    }
    
    /**
     * [KR] CUSTOMER PART NO의 getter method
     * @return the cprtn
     */
    public String getCprtn() {
        return cprtn;
    }

    /**
     * [KR] CUSTOMER PART NO의 setter method
     * @param cprtn String
     */
    public void setCprtn(String cprtn) {
        this.cprtn = cprtn;
    }
    
    
    /**
     * [KR] 상세차종(수정전)의 getter method
     * @return the oldMcrc1
     */
    public String getOldMcrc1() {
        return oldMcrc1;
    }

    /**
     * [KR] 상세차종(수정전)의 setter method
     * @param oldMcrc1 String
     */
    public void setOldMcrc1(String oldMcrc1) {
        this.oldMcrc1 = oldMcrc1;
    } 
    
    /**
     * [KR] 상세서열(수정전)의 getter method
     * @return the oldMsec1
     */
    public String getOldMsec1() {
        return oldMsec1;
    }

    /**
     * [KR] 상세서열(수정전)의 setter method
     * @param oldMsec1 String
     */
    public void setOldMsec1(String oldMsec1) {
        this.oldMsec1 = oldMsec1;
    }

    
    /**
     * [KO] lib1의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the lib1
     */
    public String getLib1() {
        return lib1;
    }

    /**
     * [KO] lib1의 setter method 이다.<br>
     * [EN] It is a setter method of lib1.<br>
     * [JP] <br>
     * 
     * @param lib1 String
     */
    public void setLib1(String lib1) {
        this.lib1 = lib1;
    }

    /**
     * [KO] lib2의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the lib2
     */
    public String getLib2() {
        return lib2;
    }

    /**
     * [KO] lib2의 setter method 이다.<br>
     * [EN] It is a setter method of lib2.<br>
     * [JP] <br>
     * 
     * @param lib2 String
     */
    public void setLib2(String lib2) {
        this.lib2 = lib2;
    }

    /**
     * [KO] lib3의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the lib3
     */
    public String getLib3() {
        return lib3;
    }

    /**
     * [KO] lib3의 setter method 이다.<br>
     * [EN] It is a setter method of lib3.<br>
     * [JP] <br>
     * 
     * @param lib3 String
     */
    public void setLib3(String lib3) {
        this.lib3 = lib3;
    }

    /**
     * [KR] 작업구분의 getter method
     * @return the selchk
     */
    public String getSelchk() {
        return selchk;
    }

    /**
     * [KR] 작업구분의 setter method
     * @param selchk String
     */
    public void setSelchk(String selchk) {
        this.selchk = selchk;
    }
    
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("mcrcd", this.mcrcd);
        jsonObj.put("msecd", this.msecd);
        jsonObj.put("mcrc1", this.mcrc1);
        jsonObj.put("msec1", this.msec1);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("carnm", this.carnm);
        jsonObj.put("cprtn", this.cprtn);
        jsonObj.put("oldMcrc1", this.oldMcrc1);
        jsonObj.put("oldMsec1", this.oldMsec1);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
