package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 업체서열차종마스타차종별조회 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class CustOrderTypeMstViewDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143749L;
    
    /**
     * [KR] 사업부코드 <br>
     */
    private String comps;
    
    /**
     * [KR] CUSTONER NAME<br>
     */
    private String cusnm;
    
    /**
     * [KR] 업체코드 <br>
     */
    private String pyvnd;
    
    /**
     * [KR] 품번<br>
     */
    private String pspno;
    
    /**
     * [KR] ITEM DESCRIPTION<br>
     */
    private String itdsc;
        
    /**
     * [KR] 서열번호<br>
     */
    private String seqno;
    
    /**
     * [KR] 서열코드<br>
     */
    private String seqcd;

    /**
     * [KR] 대표차종<br>
     */
    private String mcrcd;

    /**
     * [KR] 적용일자FR<br>
     */
    private String efffr;
    
    /**
     * [KR] 적용일자TO<br>
     */
    private String effto;
    
    /**
     * [KR] 업체품번<br>
     */
    private String cprtn;

    /**
     * [KR] 차종명<br>
     */
    private String mstsm;
    
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
     * [KR] 서열번호의 getter method
     * @return the seqno
     */
    public String getSeqno() {
        return seqno;
    }

    /**
     * [KR] 서열번호의 setter method
     * @param seqno String
     */
    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }
    
    /**
     * [KR] 서열코드의 getter method
     * @return the seqcd
     */
    public String getSeqcd() {
        return seqcd;
    }

    /**
     * [KR] 서열코드의 setter method
     * @param seqcd String
     */
    public void setSeqcd(String seqcd) {
        this.seqcd = seqcd;
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
     * [KR] 적용일자FR의 getter method
     * @return the efffr
     */
    public String getEfffr() {
        return efffr;
    }

    /**
     * [KR] 적용일자FR의 setter method
     * @param efffr String
     */
    public void setEfffr1(String efffr) {
        this.efffr = efffr;
    } 
    
    /**
     * [KR] 적용일자TO의 getter method
     * @return the effto
     */
    public String getEffto() {
        return effto;
    }

    /**
     * [KR] 적용일자TO의 setter method
     * @param effto String
     */
    public void setEffto(String effto) {
        this.effto = effto;
    } 

    /**
     * [KR] 업체품번의 getter method
     * @return the cprtn
     */
    public String getCprtn() {
        return cprtn;
    }

    /**
     * [KR] 업체품번의 setter method
     * @param cprtn String
     */
    public void setCprtn(String cprtn) {
        this.cprtn = cprtn;
    } 
 
    /**
     * [KR] 차종명의 getter method
     * @return the mstsm
     */
    public String getMstsm() {
        return mstsm;
    }

    /**
     * [KR] 차종명의 setter method
     * @param mstsm String
     */
    public void setMstsm(String mstsm) {
        this.mstsm = mstsm;
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
        jsonObj.put("cusnm", this.cusnm);        
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("pspno", this.pspno);       
        jsonObj.put("itdsc", this.itdsc);        
        jsonObj.put("seqno", this.seqno);        
        jsonObj.put("seqcd", this.seqcd);
        jsonObj.put("mcrcd", this.mcrcd);        
        jsonObj.put("efffr", this.efffr);
        jsonObj.put("effto", this.effto);   
        jsonObj.put("cprtn", this.cprtn);        
        jsonObj.put("mstsm", this.mstsm);        
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }    
}