package com.globaldenso.dnkr.domain;

import java.io.Serializable;

/**
 * [KR] 코드정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PssallibDomain implements Serializable{

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143716L;

    /**
     * [KO] 사업부<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String comps;

    /**
     * [KO] 전표No<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpnno;

    /**
     * [KO] 전표No 2<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpnno2;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String slpno;

    /**
     * [KO] 전표일자<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsdt;
    
    /**
     * [KO] 전표일자2<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsdt2;
    
    /**
     * [KO] 마감일자1<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jptdt1;
    
    /**
     * [KO] 마감일자2<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jptdt2;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pyvnd;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pyvnd2;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String shpto;
    
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
    private String shpnm;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String prdcd;

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
    private String mstsm;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pspno;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String cprtn;
 
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String unmsr;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsqy;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcost;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pfote;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String curcd;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pcsum;

    /**
     * [KO] 전표NO from<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String trknos;

    /**
     * [KO] 전표NO to<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String trknoe;

    /**
     * [KO] 전표일자<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String prcdt;

    /**
     * [KO] 출력구분(전체, 단가누락분만(Y))<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String dyes;

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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PssallibDomain() {
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
     * [KO] jpnno의 getter method 이다.<br>
     * [EN] It is a getter method ofjpnno .<br>
     * [JP] <br>
     * 
     * @return the jpnno
     */
    public String getJpnno() {
        if(jpnno == null){
            return "";
        }else{
            return jpnno;
        }
    }

    /**
     * [KO] jpnno의 setter method 이다.<br>
     * [EN] It is a setter method of jpnno.<br>
     * [JP] <br>
     * 
     * @param jpnno String
     */
    public void setJpnno(String jpnno) {
        this.jpnno = jpnno;
    }
    
    /**
     * [KO] jpnno2의 getter method 이다.<br>
     * [EN] It is a getter method ofjpnno2.<br>
     * [JP] <br>
     * 
     * @return the jpnno2
     */
    public String getJpnno2() {
        if(jpnno2 == null){
            return "";
        }else{
            return jpnno2;
        }
    }
    
    /**
     * [KO] jpnno2의 setter method 이다.<br>
     * [EN] It is a setter method of jpnno2.<br>
     * [JP] <br>
     * 
     * @param jpnno2 String
     */
    public void setJpnno2(String jpnno2) {
        this.jpnno2 = jpnno2;
    }

    /**
     * [KO] slpno의 getter method 이다.<br>
     * [EN] It is a getter method of slpno.<br>
     * [JP] <br>
     * 
     * @return the slpno
     */
    public String getSlpno() {
        if(slpno == null){
            return "";
        }else{
            return slpno;
        }
        
    }

    /**
     * [KO] slpno의 setter method 이다.<br>
     * [EN] It is a setter method of slpno.<br>
     * [JP] <br>
     * 
     * @param slpno String
     */
    public void setSlpno(String slpno) {
        this.slpno = slpno;
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
     * [KO] jpsdt2의 getter method 이다.<br>
     * [EN] It is a getter method of jpsdt2.<br>
     * [JP] <br>
     * 
     * @return the jpsdt2
     */
    public String getJpsdt2() {
        if(jpsdt2 == null){
            return "";
        }else{
            return jpsdt2;
        }
    }

    /**
     * [KO] jpsdt2의 setter method 이다.<br>
     * [EN] It is a setter method of jpsdt2.<br>
     * [JP] <br>
     * 
     * @param jpsdt2 String
     */
    public void setJpsdt2(String jpsdt2) {
        this.jpsdt2 = jpsdt2;
    }
    
    /**
     * [KO] jpsdt의 getter method 이다.<br>
     * [EN] It is a getter method of jpsdt.<br>
     * [JP] <br>
     * 
     * @return the jpsdt
     */
    public String getJptdt1() {
        if(jptdt1 == null){
            return "";
        }else{
            return jptdt1;
        }
    }

    /**
     * [KO] jptdt1의 setter method 이다.<br>
     * [EN] It is a setter method of jptdt1.<br>
     * [JP] <br>
     * 
     * @param jptdt1 String
     */
    public void setJptdt1(String jptdt1) {
        this.jptdt1 = jptdt1;
    }
    
    /**
     * [KO] jptdt2의 getter method 이다.<br>
     * [EN] It is a getter method of jptdt2.<br>
     * [JP] <br>
     * 
     * @return the jptdt2
     */
    public String getJptdt2() {
        if(jptdt2 == null){
            return "";
        }else{
            return jptdt2;
        }
    }

    /**
     * [KO] jptdt2의 setter method 이다.<br>
     * [EN] It is a setter method of jptdt2.<br>
     * [JP] <br>
     * 
     * @param jptdt2 String
     */
    public void setJptdt2(String jptdt2) {
        this.jptdt2 = jptdt2;
    }

    /**
     * [KO] pyvnd의 getter method 이다.<br>
     * [EN] It is a getter method of pyvnd.<br>
     * [JP] <br>
     * 
     * @return the pyvnd
     */
    public String getPyvnd() {
        if(pyvnd == null){
            return "";
        }else{
            return pyvnd;
        }
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
     * [KO] shpto의 getter method 이다.<br>
     * [EN] It is a getter method of shpto.<br>
     * [JP] <br>
     * 
     * @return the shpto
     */
    public String getShpto() {
        if(shpto == null){
            return "";
        }else{
            return shpto;
        }
    }

    /**
     * [KO] shpto의 setter method 이다.<br>
     * [EN] It is a setter method of shpto.<br>
     * [JP] <br>
     * 
     * @param shpto String
     */
    public void setShpto(String shpto) {
        this.shpto = shpto;
    }

    /**
     * [KO] cusnm의 getter method 이다.<br>
     * [EN] It is a getter method of cusnm.<br>
     * [JP] <br>
     * 
     * @return the cusnm
     */
    public String getCusnm() {
        if(cusnm == null){
            return "";
        }else{
            return cusnm;
        }
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
     * [KO] shpnm의 getter method 이다.<br>
     * [EN] It is a getter method of shpnm.<br>
     * [JP] <br>
     * 
     * @return the shpnm
     */
    public String getShpnm() {
        if(shpnm == null){
            return "";
        }else{
            return shpnm;
        }
        
    }

    /**
     * [KO] shpnm의 setter method 이다.<br>
     * [EN] It is a setter method of shpnm.<br>
     * [JP] <br>
     * 
     * @param shpnm String
     */
    public void setShpnm(String shpnm) {
        this.shpnm = shpnm;
    }

    /**
     * [KO] prdcd의 getter method 이다.<br>
     * [EN] It is a getter method of prdcd.<br>
     * [JP] <br>
     * 
     * @return the prdcd
     */
    public String getPrdcd() {
        if(prdcd == null){
            return "";
        }else{
            return prdcd;
        }
    }

    /**
     * [KO] prdcd의 setter method 이다.<br>
     * [EN] It is a setter method of prdcd.<br>
     * [JP] <br>
     * 
     * @param prdcd String
     */
    public void setPrdcd(String prdcd) {
        this.prdcd = prdcd;
    }

    /**
     * [KO] carcd의 getter method 이다.<br>
     * [EN] It is a getter method of carcd.<br>
     * [JP] <br>
     * 
     * @return the carcd
     */
    public String getCarcd() {
        if(carcd == null){
            return "";
        }else{
            return carcd;
        }
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
     * [KO] mstsm의 getter method 이다.<br>
     * [EN] It is a getter method of mstsm.<br>
     * [JP] <br>
     * 
     * @return the mstsm
     */
    public String getMstsm() {
        if(mstsm == null){
            return "";
        }else{
            return mstsm;
        }
    }

    /**
     * [KO] mstsm의 setter method 이다.<br>
     * [EN] It is a setter method of mstsm.<br>
     * [JP] <br>
     * 
     * @param mstsm String
     */
    public void setMstsm(String mstsm) {
        this.mstsm = mstsm;
    }

    /**
     * [KO] pspno의 getter method 이다.<br>
     * [EN] It is a getter method of pspno.<br>
     * [JP] <br>
     * 
     * @return the pspno
     */
    public String getPspno() {
        if(pspno == null){
            return "";
        }else{
            return pspno;
        }
    }

    /**
     * [KO] pspno의 setter method 이다.<br>
     * [EN] It is a setter method of pspno.<br>
     * [JP] <br>
     * 
     * @param pspno String
     */
    public void setPspno(String pspno) {
        this.pspno = pspno;
    }

    /**
     * [KO] cprtn의 getter method 이다.<br>
     * [EN] It is a getter method of cprtn.<br>
     * [JP] <br>
     * 
     * @return the cprtn
     */
    public String getCprtn() {
        if(cprtn == null){
            return "";
        }else{
            return cprtn;
        }
    }

    /**
     * [KO] cprtn의 setter method 이다.<br>
     * [EN] It is a setter method of cprtn.<br>
     * [JP] <br>
     * 
     * @param cprtn String
     */
    public void setCprtn(String cprtn) {
        this.cprtn = cprtn;
    }

    /**
     * [KO] unmsr의 getter method 이다.<br>
     * [EN] It is a getter method of unmsr.<br>
     * [JP] <br>
     * 
     * @return the unmsr
     */
    public String getUnmsr() {
        if(unmsr == null){
            return "";
        }else{
            return unmsr;
        }
    }

    /**
     * [KO] unmsr의 setter method 이다.<br>
     * [EN] It is a setter method of unmsr.<br>
     * [JP] <br>
     * 
     * @param unmsr String
     */
    public void setUnmsr(String unmsr) {
        this.unmsr = unmsr;
    }

    /**
     * [KO] jpsqy의 getter method 이다.<br>
     * [EN] It is a getter method of jpsqy.<br>
     * [JP] <br>
     * 
     * @return the jpsqy
     */
    public String getJpsqy() {
        if(jpsqy == null){
            return "";
        }else{
            return jpsqy;
        }
    }

    /**
     * [KO] jpsqy의 setter method 이다.<br>
     * [EN] It is a setter method of jpsqy.<br>
     * [JP] <br>
     * 
     * @param jpsqy String
     */
    public void setJpsqy(String jpsqy) {
        this.jpsqy = jpsqy;
    }

    /**
     * [KO] pcost의 getter method 이다.<br>
     * [EN] It is a getter method of pcost.<br>
     * [JP] <br>
     * 
     * @return the pcost
     */
    public String getPcost() {
        if(pcost == null){
            return "";
        }else{
            return pcost;
        }
    }

    /**
     * [KO] pcost의 setter method 이다.<br>
     * [EN] It is a setter method of pcost.<br>
     * [JP] <br>
     * 
     * @param pcost String
     */
    public void setPcost(String pcost) {
        this.pcost = pcost;
    }

    /**
     * [KO] 의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the cmcCode
     */
    public String getPfote() {
        if(pfote == null){
            return "";
        }else{
            return pfote;
        }
        
    }

    /**
     * [KO] pfote의 setter method 이다.<br>
     * [EN] It is a setter method of pfote.<br>
     * [JP] <br>
     * 
     * @param pfote String
     */
    public void setPfote(String pfote) {
        this.pfote = pfote;
    }

    /**
     * [KO] curcd의 getter method 이다.<br>
     * [EN] It is a getter method of curcd.<br>
     * [JP] <br>
     * 
     * @return the curcd
     */
    public String getCurcd() {
        if(curcd == null){
            return "";
        }else{
            return curcd;
        }
    }

    /**
     * [KO] curcd의 setter method 이다.<br>
     * [EN] It is a setter method of curcd.<br>
     * [JP] <br>
     * 
     * @param curcd String
     */
    public void setCurcd(String curcd) {
        this.curcd = curcd;
    }

    /**
     * [KO] pcsum의 getter method 이다.<br>
     * [EN] It is a getter method of pcsum.<br>
     * [JP] <br>
     * 
     * @return the pcsum
     */
    public String getPcsum() {
        if(pcsum == null){
            return "";
        }else{
            return pcsum;
        }
    }

    /**
     * [KO] pcsum의 setter method 이다.<br>
     * [EN] It is a setter method of pcsum.<br>
     * [JP] <br>
     * 
     * @param pcsum String
     */
    public void setPcsum(String pcsum){
        this.pcsum = pcsum;
    }
    

    /**
     * [KO] 의 getter method 이다.<br>
     * [EN] It is a getter method of trknos.<br>
     * [JP] <br>
     * 
     * @return the trknos
     */
    public String getTrknos() {
        return trknos;
    }

    /**
     * [KO] 전표No from의 setter method 이다.<br>
     * [EN] It is a setter method of trknos.<br>
     * [JP] <br>
     * 
     * @param trknos String
     */
    public void setTrknos(String trknos) {
        this.trknos = trknos;
    }

    /**
     * [KO] 전표No to의 getter method 이다.<br>
     * [EN] It is a getter trknoe.<br>
     * [JP] <br>
     * 
     * @return the trknoe
     */
    public String getTrknoe() {
        return trknoe;
    }

    /**
     * [KO] 전표No to의 setter method 이다.<br>
     * [EN] It is a setter method of trknoe.<br>
     * [JP] <br>
     * 
     * @param trknoe String
     */
    public void setTrknoe(String trknoe) {
        this.trknoe = trknoe;
    }

    /**
     * [KO] 전표일자의 getter method 이다.<br>
     * [EN] It is a getter trknoe.<br>
     * [JP] <br>
     * 
     * @return the prcdt
     */
    public String getPrcdt() {
        return prcdt;
    }

    /**
     * [KO] 전표일자의 setter method 이다.<br>
     * [EN] It is a setter method of prcdt.<br>
     * [JP] <br>
     * 
     * @param prcdt String
     */
    public void setPrcdt(String prcdt) {
        this.prcdt = prcdt;
    }
    
    /**
     * [KO] dyes의 getter method 이다.<br>
     * [EN] It is a getter method of dyes.<br>
     * [JP] <br>
     * 
     * @return the dyes
     */
    public String getDyes() {
        if(dyes == null){
            return "";
        }else{
            return dyes;
        }
    }

    /**
     * [KO] dyes의 setter method 이다.<br>
     * [EN] It is a setter method of dyes.<br>
     * [JP] <br>
     * 
     * @param dyes String
     */
    public void setDyes(String dyes) {
        this.dyes = dyes;
    }

    /**
     * [KO] 의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the cmcCode
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
     * [KO] 의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the cmcCode
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
     * [KO] 의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the cmcCode
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
}
