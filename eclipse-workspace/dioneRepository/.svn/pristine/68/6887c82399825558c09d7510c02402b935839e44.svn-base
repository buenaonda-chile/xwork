package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 서열형 일일 수주이관전 ERROR LIST(HKMC) 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class OrderDayBeforeTransferErrorListDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143745L;

    /**
     * [KR] 사업부 <br>
     */
    private String comps;
    
    /**
     * [KR] 기준일자 <br>
     */
    private String chldt;
    
    /**
     * [KR] 업체코드 <br>
     */
    private String pyvnd;
    
    /**
     * [KR] 품번<br>
     */
    private String pspno;
    
    /**
     * [KR] CUSTONER NAME<br>
     */
    private String cusnm;
    
    /**
     * [KR] ITEM DESCRIPTION<br>
     */
    private String itdsc;
        
    /**
     * [KR] ERROR내역<br>
     */
    private String errnm;

    
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
    
    
    /**
     * [KR] 사업부의 getter method
     * @return the chldt
     */
    public String getComps() {
        return comps;
    }

    /**
     * [KR] 사업부의 setter method
     * @param chldt String
     */
    public void setComps(String comps) {
        this.comps = comps;
    }
    
    /**
     * [KR] 기준일자의 getter method
     * @return the chldt
     */
    public String getChldt() {
        return chldt;
    }

    /**
     * [KR] 기준일자의 setter method
     * @param chldt String
     */
    public void setChldt(String chldt) {
        this.chldt = chldt;
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
     * [KR] ERROR내역의 getter method
     * @return the errnm
     */
    public String getErrnm() {
        return errnm;
    }

    /**
     * [KR] ERROR내역의 setter method
     * @param seqno1 errnm
     */
    public void setErrnm(String errnm) {
        this.errnm = errnm;
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

    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("chldt", this.chldt);               
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("itdsc", this.itdsc);        
        jsonObj.put("errnm", this.errnm);        
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }    
}