package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] DB2 코드정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PsfacDb2Domain implements Serializable{

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -8578836475022549843L;

    /**
     * [KO] 사업부<br>
     */
    private String comps;
    
    /**
     * [KO] 품번<br>
     */
    private String itmno;
    
    /**
     * [KO] 품명<br>
     */
    private String itmnm;
    
    /**
     * [KO] 작업번호<br>
     */
    private String wrknm;
    
    /**
     * [KO] 이력구분<br>
     */
    private String gubcd;
    
    /**
     * [KO] 실적<br>
     */
    private String wrktms;
    
    /**
     * [KO] 계획<br>
     */
    private String wrktmp;
    
    /**
     * [KO] 완료일자<br>
     */
    private String pwkdth;
    
    /**
     * [KO] 현황<br>
     */
    private String inttx;
    
    /**
     * [KO] wrktm<br>
     */
    private String wrktm;
    
    /**
     * [KO] 작업시간<br>
     */
    private String pwktmh;
    
    /**
     * [KO] 마감일자<br>
     */
    private String smgdth;
    
    /**
     * [KO] DB2 lib1<br>
     */
    private String lib1;
    
    /**
     * [KO] DB2 lib2<br>
     */
    private String lib2;
    
    /**
     * [KO] DB2 lib3<br>
     */
    private String lib3;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsfacDb2Domain(){
        // no process
    }


    /**
     * [KO] 사업부의 getter method 이다.<br>
     * [EN] It is a getter method of comps.<br>
     * [JP] <br>
     * 
     * @return the comps
     */
    public String getComps() {
        return comps;
    }


    /**
     * [KO] 사업부의 setter method 이다.<br>
     * [EN] It is a setter method of comps.<br>
     * [JP] <br>
     * 
     * @param comps String
     */
    public void setComps(String comps) {
        this.comps = comps;
    }

    /**
     * [KO] itmno의 getter method 이다.<br>
     * [EN] It is a getter method of itmno.<br>
     * [JP] <br>
     * 
     * @return the itmno
     */
    public String getItmno() {
        return itmno;
    }

    /**
     * [KO] itmno의 setter method 이다.<br>
     * [EN] It is a setter method of itmno.<br>
     * [JP] <br>
     * 
     * @param itmno String
     */
    public void setItmno(String itmno) {
        this.itmno = itmno;
    }

    /**
     * [KO] itmnm의 getter method 이다.<br>
     * [EN] It is a getter method of itmnm.<br>
     * [JP] <br>
     * 
     * @return the itmnm
     */
    public String getItmnm() {
        return itmnm;
    }

    /**
     * [KO] itmnm의 setter method 이다.<br>
     * [EN] It is a setter method of itmnm.<br>
     * [JP] <br>
     * 
     * @param itmnm String
     */
    public void setItmnm(String itmnm) {
        this.itmnm = itmnm;
    }

    /**
     * [KO] wrknm의 getter method 이다.<br>
     * [EN] It is a getter method of wrknm.<br>
     * [JP] <br>
     * 
     * @return the wrknm
     */
    public String getWrknm() {
        return wrknm;
    }

    /**
     * [KO] wrknm의 setter method 이다.<br>
     * [EN] It is a setter method of wrknm.<br>
     * [JP] <br>
     * 
     * @param wrknm String
     */
    public void setWrknm(String wrknm) {
        this.wrknm = wrknm;
    }
    
    /**
     * [KO] gubcd의 getter method 이다.<br>
     * [EN] It is a getter method of gubcd.<br>
     * [JP] <br>
     * 
     * @return the gubcd
     */
    public String getGubcd() {
        return wrknm;
    }

    /**
     * [KO] gubcd의 setter method 이다.<br>
     * [EN] It is a setter method of gubcd.<br>
     * [JP] <br>
     * 
     * @param gubcd String
     */
    public void setGubcd(String gubcd) {
        this.gubcd = gubcd;
    }
    
    /**
     * [KO] wrktms의 getter method 이다.<br>
     * [EN] It is a getter method of wrktms.<br>
     * [JP] <br>
     * 
     * @return the wrktms
     */
    public String getWrktms() {
        return wrktms;
    }

    /**
     * [KO] wrktms의 setter method 이다.<br>
     * [EN] It is a setter method of wrktms.<br>
     * [JP] <br>
     * 
     * @param wrktms String
     */
    public void setWrktms(String wrktms) {
        this.wrktms = wrktms;
    }
    
    /**
     * [KO] wrktmp의 getter method 이다.<br>
     * [EN] It is a getter method of wrktmp.<br>
     * [JP] <br>
     * 
     * @return the wrktmp
     */
    public String getWrktmp() {
        return wrktmp;
    }

    /**
     * [KO] wrktmp의 setter method 이다.<br>
     * [EN] It is a setter method of wrktmp.<br>
     * [JP] <br>
     * 
     * @param wrktmp String
     */
    public void setWrktmp(String wrktmp) {
        this.wrktmp = wrktmp;
    }
    
    /**
     * [KO] pwkdth의 getter method 이다.<br>
     * [EN] It is a getter method of pwkdth.<br>
     * [JP] <br>
     * 
     * @return the pwkdth
     */
    public String getpwkdthh() {
        return pwkdth;
    }

    /**
     * [KO] pwkdth의 setter method 이다.<br>
     * [EN] It is a setter method of pwkdth.<br>
     * [JP] <br>
     * 
     * @param pwkdth String
     */
    public void setPwkdth(String pwkdth) {
        this.pwkdth = pwkdth;
    }
    
    /**
     * [KO] inttx의 getter method 이다.<br>
     * [EN] It is a getter method of inttx.<br>
     * [JP] <br>
     * 
     * @return the inttx
     */
    public String getInttx() {
        return inttx;
    }

    /**
     * [KO] inttx의 setter method 이다.<br>
     * [EN] It is a setter method of inttx.<br>
     * [JP] <br>
     * 
     * @param inttx String
     */
    public void setInttx(String inttx) {
        this.inttx = inttx;
    }
    /**
     * [KO] wrktm의 getter method 이다.<br>
     * [EN] It is a getter method of wrktm.<br>
     * [JP] <br>
     * 
     * @return the wrktm
     */
    public String getWrktm() {
        return wrktm;
    }

    /**
     * [KO] wrktm의 setter method 이다.<br>
     * [EN] It is a setter method of wrktm.<br>
     * [JP] <br>
     * 
     * @param wrktm String
     */
    public void setWrktm(String wrktm) {
        this.wrknm = wrktm;
    }
    
    /**
     * [KO] pwktmh의 getter method 이다.<br>
     * [EN] It is a getter method of pwktmh.<br>
     * [JP] <br>
     * 
     * @return the pwktmh
     */
    public String getPwktmh() {
        return pwktmh;
    }

    /**
     * [KO] pwktmh의 setter method 이다.<br>
     * [EN] It is a setter method of pwktmh.<br>
     * [JP] <br>
     * 
     * @param pwktmh String
     */
    public void setPwktmh(String pwktmh) {
        this.pwktmh = pwktmh;
    }
    /**
     * [KO] smgdth의 getter method 이다.<br>
     * [EN] It is a getter method of smgdth.<br>
     * [JP] <br>
     * 
     * @return the smgdth
     */
    public String getSmgdth() {
        return smgdth;
    }

    /**
     * [KO] smgdth의 setter method 이다.<br>
     * [EN] It is a setter method of smgdth.<br>
     * [JP] <br>
     * 
     * @param smgdth String
     */
    public void setSmgdth(String smgdth) {
        this.smgdth = smgdth;
    }
    
    /**
     * [KO] lib1의 getter method 이다.<br>
     * [EN] It is a getter method of lib1.<br>
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
        this.wrknm = lib1;
    }
    
    /**
     * [KO] lib2의 getter method 이다.<br>
     * [EN] It is a getter method of lib2.<br>
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
        this.wrknm = lib2;
    }
    
    /**
     * [KO] lib1의 getter method 이다.<br>
     * [EN] It is a getter method of lib1.<br>
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
        this.wrknm = lib3;
    }   
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("itmno", this.itmno);
        jsonObj.put("itmnm", this.itmnm);
        jsonObj.put("wrknm", this.wrknm);
        jsonObj.put("gubcd", this.gubcd);
        jsonObj.put("wrktms", this.wrktms);
        jsonObj.put("wrktmp", this.wrktmp);
        jsonObj.put("pwkdth", this.pwkdth);
        jsonObj.put("inttx", this.inttx);
        jsonObj.put("wrktm", this.wrktm);
        jsonObj.put("pwktmh", this.pwktmh);
        jsonObj.put("smgdth", this.smgdth);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

}
