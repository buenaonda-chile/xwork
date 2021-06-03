package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 거래처 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class CustomerDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143743L;
    
    /**
     * [KR] CODE <br>
     */
    private String cusno;
    
    /**
     * [KR] NAME1 <br>
     */
    private String cusnm;
    
    /**
     * [KR] NAME2<br>
     */
    private String cusa1;

    
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
     * [KR] CODE의 getter method
     * @return the cusno
     */
    public String getCusno() {
        return cusno;
    }

    /**
     * [KR] CODE의 setter method
     * @param cusno String
     */
    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    /**
     * [KR] NAME1의 getter method
     * @return the cusnm
     */
    public String getCusnm() {
        return cusnm;
    }

    /**
     * [KR] NAME1의 setter method
     * @param pyvnd String
     */
    public void setCusnm(String cusnm) {
        this.cusnm = cusnm;
    }
    
    /**
     * [KR] NAME2의 getter method
     * @return the cusa1
     */
    public String getCusa1() {
        return cusa1;
    }

    /**
     * [KR] NAME2의 setter method
     * @param cusa1 String
     */
    public void setCusa1(String cusa1) {
        this.cusa1 = cusa1;
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
        jsonObj.put("cusno", this.cusno);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("cusa1", this.cusa1);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
