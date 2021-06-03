package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 업체부품구성마스타 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class CustPartConstMstDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143748L;

    /**
     * [KR] 사업부코드 <br>
     */
    private String comps;
    
    /**
     * [KR] 업체코드 <br>
     */
    private String pyvnd;
    
    /**
     * [KR] CUSTONER NAME<br>
     */
    private String cusnm;
    
    /**
     * [KR] 풍성품번<br>
     */
    private String pspno;
    
    /**
     * [KR] ITEM DESCRIPTION<br>
     */
    private String itdsc;
    
    /**
     * [KR] CUSTOMER PART NO.<br>
     */
    private String mkpno;
    
    /**
     * [KR] CUST. PART DESCRIPTION<br>
     */
    private String mkpnm;
    
    /**
     * [KR] 차종코드<br>
     */
    private String carcd;
    
    /**
     * [KR] 차종명<br>
     */
    private String carnm;
        
    /**
     * [KR] 규격코드<br>
     */
    private String bdycd;
    
    /**
     * [KR] 규격명<br>
     */
    private String bdynm;

    /**
     * [KR] 구성품번<br>
     */
    private String cinbr;

    /**
     * [KR] 구성수량<br>
     */
    private String qtypr;
    
    private String oldCinbr;
    
    
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
     * [KR] 풍성품번의 getter method
     * @return the pspno
     */
    public String getPspno() {
        return pspno;
    }

    /**
     * [KR] 풍성품번의 setter method
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
     * [KR] CUSTOMER PART NO.의 getter method
     * @return the mkpno
     */
    public String getMkpno() {
        return mkpno;
    }

    /**
     * [KR] CUSTOMER PART NO.의 setter method
     * @param mkpno String
     */
    public void setMkpno(String mkpno) {
        this.mkpno = mkpno;
    }
    
    /**
     * [KR] CUST. PART DESCRIPTION의 getter method
     * @return the mkpnm
     */
    public String getMkpnm() {
        return mkpnm;
    }

    /**
     * [KR] CUST. PART DESCRIPTION의 setter method
     * @param mkpnm String
     */
    public void setMkpnm(String mkpnm) {
        this.mkpnm = mkpnm;
    }
    
    /**
     * [KR] 차종코드의 getter method
     * @return the carcd
     */
    public String getCarcd() {
        return carcd;
    }

    /**
     * [KR] 차종코드의 setter method
     * @param carcd String
     */
    public void setCarcd(String carcd) {
        this.carcd = carcd;
    }
    
    /**
     * [KR] 차종명의 getter method
     * @return the carnm
     */
    public String getCarnm() {
        return carnm;
    }

    /**
     * [KR] 차종명의 setter method
     * @param carnm String
     */
    public void setCarnm(String carnm) {
        this.carnm = carnm;
    }
    
    /**
     * [KR] 규격코드의 getter method
     * @return the bdycd
     */
    public String getBdycd() {
        return bdycd;
    }

    /**
     * [KR] 규격코드의 setter method
     * @param bdycd String
     */
    public void setBdycd(String bdycd) {
        this.bdycd = bdycd;
    }
    
    /**
     * [KR] 규격명의 getter method
     * @return the bdynm
     */
    public String getBdynm() {
        return bdynm;
    }

    /**
     * [KR] 규격명의 setter method
     * @param bdynm String
     */
    public void setBdynm(String bdynm) {
        this.bdynm = bdynm;
    }
    
    /**
     * [KR] 구성품번의 getter method
     * @return the cinbr
     */
    public String getCinbr() {
        return cinbr;
    }

    /**
     * [KR] 구성품번의 setter method
     * @param cinbr String
     */
    public void setCinbr(String cinbr) {
        this.cinbr = cinbr;
    }    

    /**
     * [KR] 구성수량의 getter method
     * @return the qtypr
     */
    public String getQtypr() {
        return qtypr;
    }

    /**
     * [KR] 구성수량의 setter method
     * @param qtypr String
     */
    public void setQtypr(String qtypr) {
        this.qtypr = qtypr;
    } 

    
    /**
     * [KR] 구성품번의 getter method
     * @return the oldCinbr
     */
    public String getOldCinbr() {
        return oldCinbr;
    }

    /**
     * [KR] 구성품번의 setter method
     * @param oldCinbr String
     */
    public void setOldCinbr(String oldCinbr) {
        this.oldCinbr = oldCinbr;
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
        jsonObj.put("cusnm", this.cusnm);                
        jsonObj.put("pspno", this.pspno);        
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("mkpno", this.mkpno);
        jsonObj.put("mkpnm", this.mkpnm);
        jsonObj.put("carcd", this.carcd);
        jsonObj.put("carnm", this.carnm);
        jsonObj.put("bdycd", this.bdycd);        
        jsonObj.put("bdynm", this.bdynm);        
        jsonObj.put("cinbr", this.cinbr);
        jsonObj.put("qtypr", this.qtypr);        
        jsonObj.put("oldCinbr", this.oldCinbr);
        jsonObj.put("selchk", this.selchk);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }    
}