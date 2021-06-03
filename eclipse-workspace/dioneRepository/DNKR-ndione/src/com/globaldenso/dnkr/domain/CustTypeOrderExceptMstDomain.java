package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 업체차종서열제외마스타 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class CustTypeOrderExceptMstDomain implements Serializable {
    
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
     * [KR] 차종<br>
     */
    private String mkcar;
    
    /**
     * [KR] 서열<br>
     */
    private String seyno;
    
    /**
     * [KR] 번호<br>
     */
    private String seycd; 
    
    /**
     * [KR] 업체명<br>
     */
    private String cusnm; 
    

    private String oldMkcar;
    private String oldSeyno;
    private String oldSeycd;
    
    
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
     * [KR] 차종의 getter method
     * @return the mkcar
     */
    public String getMkcar() {
        return mkcar;
    }

    /**
     * [KR] 차종의 setter method
     * @param mkcar String
     */
    public void setMkcar(String mkcar) {
        this.mkcar = mkcar;
    }    

    /**
     * [KR] 서열의 getter method
     * @return the seyno
     */
    public String getSeyno() {
        return seyno;
    }

    /**
     * [KR] 서열의 setter method
     * @param seyno String
     */
    public void setSeyno(String seyno) {
        this.seyno = seyno;
    } 

    /**
     * [KR] 번호의 getter method
     * @return the seycd
     */
    public String getSeycd() {
        return seycd;
    }

    /**
     * [KR] 번호의 setter method
     * @param seycd String
     */
    public void setSeycd(String seycd) {
        this.seycd = seycd;
    } 
    
    /**
     * [KR] 업체명의 getter method
     * @return the cusnm
     */
    public String getCusnm() {
        return cusnm;
    }

    /**
     * [KR] 업체명의 setter method
     * @param cusnm String
     */
    public void setCusnm(String cusnm) {
        this.cusnm = cusnm;
    } 
    
    
    
    public String getOldMkcar() {
        return oldMkcar;
    }

    public void setOldMkcar(String oldMkcar) {
        this.oldMkcar = oldMkcar;
    }

    public String getOldSeyno() {
        return oldSeyno;
    }

    public void setOldSeyno(String oldSeyno) {
        this.oldSeyno = oldSeyno;
    }

    public String getOldSeycd() {
        return oldSeycd;
    }

    public void setOldSeycd(String oldSeycd) {
        this.oldSeycd = oldSeycd;
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
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("mkcar", this.mkcar);
        jsonObj.put("seyno", this.seyno);
        jsonObj.put("seycd", this.seycd);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("oldMkcar", this.oldMkcar);
        jsonObj.put("oldSeyno", this.oldSeyno);
        jsonObj.put("oldSeycd", this.oldSeycd);    
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
