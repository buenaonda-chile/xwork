package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 년업체차종별제품출고집계현황 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PssalPCarOutDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 7992434311253235586L;
   
    
    /**
     * [KO] 사업부<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String comps;
    
    /**
     * [KO] 업체1<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pyvnd;
    
    /**
     * [KO] 업체2<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pyvnd2;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cusnm;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String carcd;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String carnm;
    
    /**
     * [KO] 전표일자1<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpyym;
    
    /**
     * [KO] 전표일자2<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpyym2;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon4;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon5;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon6;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon7;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon8;    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon9;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon10;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon11;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon12;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon1;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon2;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mon3;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost4;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost5;
    
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost6;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost7;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost8;
    
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost9;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost10;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost11;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost12;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost1;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost2;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost3;
    
    
    /**
     * [KO]납입일자 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsdt;
    
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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PssalPCarOutDomain() {
        // no process
    }
   

    /**
     * [KO] comps의 getter method 이다.<br>
     * [EN] It is a getter method of comps.<br>
     * [JP] <br>
     * 
     * @return the comps
     */
    public String getComps() {
        if(comps == null){
            return "";
        }else{
            return comps;
        }
    }

    /**
     * [KO] comps의 setter method 이다.<br>
     * [EN] It is a setter method of comps.<br>
     * [JP] <br>
     * 
     * @param comps String
     */
    public void setComps(String comps) {
        this.comps = comps;
    }

    /**
     * [KO] pyvnd의 getter method 이다.<br>
     * [EN] It is a getter method of pyvnd.<br>
     * [JP] <br>
     * 
     * @return the pyvnd
     */
    public String getPyvnd() {
        return pyvnd;
    }

    /**
     * [KO] pyvnd의 setter method 이다.<br>
     * [EN] It is a setter method of pyvnd.<br>
     * [JP] <br>
     * 
     * @param pyvnd String
     */
    public void setPyvnd(String pyvnd) {
        this.pyvnd = pyvnd;
    }

    /**
     * [KO] pyvnd2의 getter method 이다.<br>
     * [EN] It is a getter method of pyvnd2.<br>
     * [JP] <br>
     * 
     * @return the pyvnd2
     */
    public String getPyvnd2() {
        if(pyvnd2 == null){
            return "";
        }else{
            return pyvnd2;
        }
    }

    /**
     * [KO] pyvnd2의 setter method 이다.<br>
     * [EN] It is a setter method of pyvnd2.<br>
     * [JP] <br>
     * 
     * @param pyvnd2 String
     */
    public void setPyvnd2(String pyvnd2) {
        this.pyvnd2 = pyvnd2;
    }
    
    /**
     * [KO] cusnm의 getter method 이다.<br>
     * [EN] It is a getter method of cusnm.<br>
     * [JP] <br>
     * 
     * @return the jpsdt
     */
    public String getCusnm() {
        return cusnm;
    }

    /**
     * [KO] cusnm의 setter method 이다.<br>
     * [EN] It is a setter method of cusnm.<br>
     * [JP] <br>
     * 
     * @param cusnm String
     */
    public void setCusnm(String cusnm) {
        this.cusnm = cusnm;
    }

    /**
     * [KO] carcd의 getter method 이다.<br>
     * [EN] It is a getter method of carcd.<br>
     * [JP] <br>
     * 
     * @return the carcd
     */
    public String getCarcd() {
        return carcd;
    }

    /**
     * [KO] carcd의 setter method 이다.<br>
     * [EN] It is a setter method of carcd.<br>
     * [JP] <br>
     * 
     * @param carcd String
     */
    public void setCarcd(String carcd) {
        this.carcd = carcd;
    }
    
    /**
     * [KO] carnm의 getter method 이다.<br>
     * [EN] It is a getter method of carnm.<br>
     * [JP] <br>
     * 
     * @return the carnm
     */
    public String getCarnm() {
        return carnm;
    }

    /**
     * [KO] carnm의 setter method 이다.<br>
     * [EN] It is a setter method of carnm.<br>
     * [JP] <br>
     * 
     * @param carnm String
     */
    public void setCarnm(String carnm) {
        this.carnm = carnm;
    }

    /**
     * [KO] jpyym의 getter method 이다.<br>
     * [EN] It is a getter method of jpyym.<br>
     * [JP] <br>
     * 
     * @return the jpyym
     */
    public String getJpyym() {
        return jpyym;
    }

    /**
     * [KO] jpyym의 setter method 이다.<br>
     * [EN] It is a setter method of jpyym.<br>
     * [JP] <br>
     * 
     * @param jpyym String
     */
    public void setJpyym(String jpyym) {
        this.jpyym = jpyym;
    }

    /**
     * [KO] jpyym2의 getter method 이다.<br>
     * [EN] It is a getter method of jpyym2.<br>
     * [JP] <br>
     * 
     * @return the jpyym2
     */
    public String getJpyym2() {
        return jpyym2;
    }

    /**
     * [KO] jpyym2의 setter method 이다.<br>
     * [EN] It is a setter method of jpyym2.<br>
     * [JP] <br>
     * 
     * @param jpyym2 String
     */
    public void setJpyym2(String jpyym2) {
        this.jpyym2 = jpyym2;
    }

    /**
     * [KO] mon4의 getter method 이다.<br>
     * [EN] It is a getter method of mon4.<br>
     * [JP] <br>
     * 
     * @return the mon4
     */
    public String getMon4() {
        return mon4;
    }

    /**
     * [KO] mon4의 setter method 이다.<br>
     * [EN] It is a setter method of mon4.<br>
     * [JP] <br>
     * 
     * @param mon4 String
     */
    public void setMon4(String mon4) {
        this.mon4 = mon4;
    }

    /**
     * [KO] mon5의 getter method 이다.<br>
     * [EN] It is a getter method of mon5.<br>
     * [JP] <br>
     * 
     * @return the mon5
     */
    public String getMon5() {
        return mon5;
    }

    /**
     * [KO] mon5의 setter method 이다.<br>
     * [EN] It is a setter method of mon5.<br>
     * [JP] <br>
     * 
     * @param mon5 String
     */
    public void setMon5(String mon5) {
        this.mon5 = mon5;
    }

    /**
     * [KO] mon6의 getter method 이다.<br>
     * [EN] It is a getter method of mon6.<br>
     * [JP] <br>
     * 
     * @return the mon6
     */
    public String getMon6() {
        return mon6;
    }

    /**
     * [KO] mon6의 setter method 이다.<br>
     * [EN] It is a setter method of mon6.<br>
     * [JP] <br>
     * 
     * @param mon6 String
     */
    public void setMon6(String mon6) {
        this.mon6 = mon6;
    }

    /**
     * [KO] mon7의 getter method 이다.<br>
     * [EN] It is a getter method of mon7.<br>
     * [JP] <br>
     * 
     * @return the mon7
     */
    public String getMon7() {
        return mon7;
    }

    /**
     * [KO] mon7의 setter method 이다.<br>
     * [EN] It is a setter method of mon7.<br>
     * [JP] <br>
     * 
     * @param mon7 String
     */
    public void setMon7(String mon7) {
        this.mon7 = mon7;
    }

    /**
     * [KO] mon8의 getter method 이다.<br>
     * [EN] It is a getter method of mon8.<br>
     * [JP] <br>
     * 
     * @return the jpsdt
     */
    public String getMon8() {
        return mon8;
    }

    /**
     * [KO] mon8의 setter method 이다.<br>
     * [EN] It is a setter method of mon8.<br>
     * [JP] <br>
     * 
     * @param mon8 String
     */
    public void setMon8(String mon8) {
        this.mon8 = mon8;
    }

    /**
     * [KO] mon9의 getter method 이다.<br>
     * [EN] It is a getter method of mon9.<br>
     * [JP] <br>
     * 
     * @return the mon9
     */
    public String getMon9() {
        return mon9;
    }

    /**
     * [KO] mon9의 setter method 이다.<br>
     * [EN] It is a setter method of mon9.<br>
     * [JP] <br>
     * 
     * @param mon9 String
     */
    public void setMon9(String mon9) {
        this.mon9 = mon9;
    }

    /**
     * [KO] mon10의 getter method 이다.<br>
     * [EN] It is a getter method of mon10.<br>
     * [JP] <br>
     * 
     * @return the mon10
     */
    public String getMon10() {
        return mon10;
    }

    /**
     * [KO] mon10의 setter method 이다.<br>
     * [EN] It is a setter method of mon10.<br>
     * [JP] <br>
     * 
     * @param mon10 String
     */
    public void setMon10(String mon10) {
        this.mon10 = mon10;
    }

    /**
     * [KO] mon11의 getter method 이다.<br>
     * [EN] It is a getter method of mon11.<br>
     * [JP] <br>
     * 
     * @return the mon11
     */
    public String getMon11() {
        return mon11;
    }

    /**
     * [KO] mon11의 setter method 이다.<br>
     * [EN] It is a setter method of mon11.<br>
     * [JP] <br>
     * 
     * @param mon11 String
     */
    public void setMon11(String mon11) {
        this.mon11 = mon11;
    }

    /**
     * [KO] mon12의 getter method 이다.<br>
     * [EN] It is a getter method of mon12.<br>
     * [JP] <br>
     * 
     * @return the mon12
     */
    public String getMon12() {
        return mon12;
    }

    /**
     * [KO] mon12의 setter method 이다.<br>
     * [EN] It is a setter method of mon12.<br>
     * [JP] <br>
     * 
     * @param mon12 String
     */
    public void setMon12(String mon12) {
        this.mon12 = mon12;
    }

    /**
     * [KO] mon1의 getter method 이다.<br>
     * [EN] It is a getter method of mon1.<br>
     * [JP] <br>
     * 
     * @return the mon1
     */
    public String getMon1() {
        return mon1;
    }

    /**
     * [KO] mon1의 setter method 이다.<br>
     * [EN] It is a setter method of mon1.<br>
     * [JP] <br>
     * 
     * @param mon1 String
     */
    public void setMon1(String mon1) {
        this.mon1 = mon1;
    }

    /**
     * [KO] mon2의 getter method 이다.<br>
     * [EN] It is a getter method of mon2.<br>
     * [JP] <br>
     * 
     * @return the mon2
     */
    public String getMon2() {
        return mon2;
    }

    /**
     * [KO] mon2의 setter method 이다.<br>
     * [EN] It is a setter method of mon2.<br>
     * [JP] <br>
     * 
     * @param mon2 String
     */
    public void setMon2(String mon2) {
        this.mon2 = mon2;
    }

    /**
     * [KO] mon3의 getter method 이다.<br>
     * [EN] It is a getter method of mon3.<br>
     * [JP] <br>
     * 
     * @return the mon3
     */
    public String getMon3() {
        return mon3;
    }

    /**
     * [KO] mon3의 setter method 이다.<br>
     * [EN] It is a setter method of mon3.<br>
     * [JP] <br>
     * 
     * @param mon3 String
     */
    public void setMon3(String mon3) {
        this.mon3 = mon3;
    }

    /**
     * [KO] pcost4의 getter method 이다.<br>
     * [EN] It is a getter method of pcost4.<br>
     * [JP] <br>
     * 
     * @return the pcost4
     */
    public String getPcost4() {
        return pcost4;
    }

    /**
     * [KO] pcost4의 setter method 이다.<br>
     * [EN] It is a setter method of pcost4.<br>
     * [JP] <br>
     * 
     * @param pcost4 String
     */
    public void setPcost4(String pcost4) {
        this.pcost4 = pcost4;
    }

    /**
     * [KO] pcost5의 getter method 이다.<br>
     * [EN] It is a getter method of pcost5.<br>
     * [JP] <br>
     * 
     * @return the pcost5
     */
    public String getPcost5() {
        return pcost5;
    }

    /**
     * [KO] pcost5의 setter method 이다.<br>
     * [EN] It is a setter method of pcost5.<br>
     * [JP] <br>
     * 
     * @param pcost5 String
     */
    public void setPcost5(String pcost5) {
        this.pcost5 = pcost5;
    }

    /**
     * [KO] pcost6의 getter method 이다.<br>
     * [EN] It is a getter method of pcost6.<br>
     * [JP] <br>
     * 
     * @return the pcost6
     */
    public String getPcost6() {
        return pcost6;
    }

    /**
     * [KO] pcost6의 setter method 이다.<br>
     * [EN] It is a setter method of pcost6.<br>
     * [JP] <br>
     * 
     * @param pcost6 String
     */
    public void setPcost6(String pcost6) {
        this.pcost6 = pcost6;
    }

    /**
     * [KO] pcost7의 getter method 이다.<br>
     * [EN] It is a getter method of pcost7.<br>
     * [JP] <br>
     * 
     * @return the pcost7
     */
    public String getPcost7() {
        return pcost7;
    }

    /**
     * [KO] pcost7의 setter method 이다.<br>
     * [EN] It is a setter method of pcost7.<br>
     * [JP] <br>
     * 
     * @param pcost7 String
     */
    public void setPcost7(String pcost7) {
        this.pcost7 = pcost7;
    }

    /**
     * [KO] pcost8의 getter method 이다.<br>
     * [EN] It is a getter method of pcost8.<br>
     * [JP] <br>
     * 
     * @return the pcost8
     */
    public String getPcost8() {
        return pcost8;
    }

    /**
     * [KO] pcost8의 setter method 이다.<br>
     * [EN] It is a setter method of pcost8.<br>
     * [JP] <br>
     * 
     * @param pcost8 String
     */
    public void setPcost8(String pcost8) {
        this.pcost8 = pcost8;
    }

    /**
     * [KO] pcost9의 getter method 이다.<br>
     * [EN] It is a getter method of pcost9.<br>
     * [JP] <br>
     * 
     * @return the pcost9
     */
    public String getPcost9() {
        return pcost9;
    }

    /**
     * [KO] pcost9의 setter method 이다.<br>
     * [EN] It is a setter method of pcost9.<br>
     * [JP] <br>
     * 
     * @param pcost9 String
     */
    public void setPcost9(String pcost9) {
        this.pcost9 = pcost9;
    }

    /**
     * [KO] pcost10의 getter method 이다.<br>
     * [EN] It is a getter method of pcost10.<br>
     * [JP] <br>
     * 
     * @return the pcost10
     */
    public String getPcost10() {
        return pcost10;
    }

    /**
     * [KO] pcost10의 setter method 이다.<br>
     * [EN] It is a setter method of pcost10.<br>
     * [JP] <br>
     * 
     * @param pcost10 String
     */
    public void setPcost10(String pcost10) {
        this.pcost10 = pcost10;
    }

    /**
     * [KO] pcost11의 getter method 이다.<br>
     * [EN] It is a getter method of pcost11.<br>
     * [JP] <br>
     * 
     * @return the pcost11
     */
    public String getPcost11() {
        return pcost11;
    }

    /**
     * [KO] pcost11의 setter method 이다.<br>
     * [EN] It is a setter method of pcost11.<br>
     * [JP] <br>
     * 
     * @param pcost11 String
     */
    public void setPcost11(String pcost11) {
        this.pcost11 = pcost11;
    }

    /**
     * [KO] pcost12의 getter method 이다.<br>
     * [EN] It is a getter method of pcost12.<br>
     * [JP] <br>
     * 
     * @return the pcost12
     */
    public String getPcost12() {
        return pcost12;
    }

    /**
     * [KO] pcost12의 setter method 이다.<br>
     * [EN] It is a setter method of pcost12.<br>
     * [JP] <br>
     * 
     * @param pcost12 String
     */
    public void setPcost12(String pcost12) {
        this.pcost12 = pcost12;
    }

    /**
     * [KO] pcost1의 getter method 이다.<br>
     * [EN] It is a getter method of pcost1.<br>
     * [JP] <br>
     * 
     * @return the pcost1
     */
    public String getPcost1() {
        return pcost1;
    }

    /**
     * [KO] pcost1의 setter method 이다.<br>
     * [EN] It is a setter method of pcost1.<br>
     * [JP] <br>
     * 
     * @param pcost1 String
     */
    public void setPcost1(String pcost1) {
        this.pcost1 = pcost1;
    }

    /**
     * [KO] jpsdt의 getter method 이다.<br>
     * [EN] It is a getter method of jpsdt.<br>
     * [JP] <br>
     * 
     * @return the jpsdt
     */
    public String getPcost2() {
        return pcost2;
    }

    /**
     * [KO] jpyym2의 setter method 이다.<br>
     * [EN] It is a setter method of jpyym2.<br>
     * [JP] <br>
     * 
     * @param pcost2 String
     */
    public void setPcost2(String pcost2) {
        this.pcost2 = pcost2;
    }

    /**
     * [KO] jpsdt의 getter method 이다.<br>
     * [EN] It is a getter method of jpsdt.<br>
     * [JP] <br>
     * 
     * @return the jpsdt
     */
    public String getPcost3() {
        return pcost3;
    }

    /**
     * [KO] jpyym2의 setter method 이다.<br>
     * [EN] It is a setter method of jpyym2.<br>
     * [JP] <br>
     * 
     * @param pcost3 String
     */
    public void setPcost3(String pcost3) {
        this.pcost3 = pcost3;
    }

    /**
     * [KO] jpsdt의 getter method 이다.<br>
     * [EN] It is a getter method of jpsdt.<br>
     * [JP] <br>
     * 
     * @return the jpsdt
     */
    public String getJpsdt() {
        if(jpsdt == null){
            return "";
        }else{
            return jpsdt;
        }
    }

    /**
     * [KO] jpsdt의 setter method 이다.<br>
     * [EN] It is a setter method of jpsdt.<br>
     * [JP] <br>
     * 
     * @param jpsdt String
     */
    public void setJpsdt(String jpsdt) {
        this.jpsdt = jpsdt;
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
        this.lib1 = lib1;
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
        this.lib2 = lib2;
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("cusnm", this.cusnm);
        jsonObj.put("carnm", this.carnm);
        jsonObj.put("carcd", this.carcd);
        jsonObj.put("mon4", this.mon4);
        jsonObj.put("mon5", this.mon5);
        jsonObj.put("mon6", this.mon6);
        jsonObj.put("mon7", this.mon7);
        jsonObj.put("mon8", this.mon8);
        jsonObj.put("mon9", this.mon9);
        jsonObj.put("mon10", this.mon10);
        jsonObj.put("mon11", this.mon11);
        jsonObj.put("mon12", this.mon12);
        jsonObj.put("mon1", this.mon1);
        jsonObj.put("mon2", this.mon2);
        jsonObj.put("mon3", this.mon3);
        jsonObj.put("pcost4", this.pcost4);
        jsonObj.put("pcost5", this.pcost5);
        jsonObj.put("pcost6", this.pcost6);
        jsonObj.put("pcost7", this.pcost7);
        jsonObj.put("pcost8", this.pcost8);
        jsonObj.put("pcost9", this.pcost9);
        jsonObj.put("pcost10", this.pcost10);
        jsonObj.put("pcost11", this.pcost11);
        jsonObj.put("pcost12", this.pcost12);
        jsonObj.put("pcost1", this.pcost1);
        jsonObj.put("pcost2", this.pcost2);
        jsonObj.put("pcost3", this.pcost3);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}
