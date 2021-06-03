package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 품목 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class ItemMasterDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143741L;
    
    /**
     * [KR] 품번 <br>
     */
    private String itnbr;
    
    /**
     * [KR] 품명 <br>
     */
    private String itdsc;
    
    /**
     * [KR] Item Type<br>
     */
    private String ittyp;

    
    /**
     * [KR] 조회구분<br>
     */
    private String gbn;
    
    
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
     * [KR] 품번의 getter method
     * @return the itnbr
     */
    public String getItnbr() {
        return itnbr;
    }

    /**
     * [KR] 품번의 setter method
     * @param itnbr String
     */
    public void setItnbr(String itnbr) {
        this.itnbr = itnbr;
    }

    /**
     * [KR] 품명의 getter method
     * @return the itdsc
     */
    public String getItdsc() {
        return itdsc;
    }

    /**
     * [KR] 품명의 setter method
     * @param itdsc String
     */
    public void setItdsc(String itdsc) {
        this.itdsc = itdsc;
    }

    /**
     * [KR] Item Type의 getter method
     * @return the ittyp
     */
    public String getIttyp() {
        return ittyp;
    }

    /**
     * [KR] Item Type의 setter method
     * @param ittyp String
     */
    public void setIttyp(String ittyp) {
        this.ittyp = ittyp;
    } 
    
    /**
     * [KR] 조회구분의 getter method
     * @return the gbn
     */
    public String getGbn() {
        return gbn;
    }

    /**
     * [KR] 조회구분의 setter method
     * @param gbn String
     */
    public void setGbn(String gbn) {
        this.gbn = gbn;
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
        jsonObj.put("itnbr", this.itnbr);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("gbn", this.gbn);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
