package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;

/***
 */
public class PsogmDomain implements Serializable{

    /**
    * [EN] Serial Version UID.<br>
    * [JP] シリアルバージョンID。<br>
    */
    private static final long serialVersionUID = -1682855166940403739L;
    /***
     */
    private String lincd;
    /***
     */
    private String linnm;
    /***
     */
    private String comps;
    /***
     */
    private String cdept;
    /***
     */
    private String prtcd;
    /***
     */
    private String mline;
    /***
     */
    private String dptfl;
    /***
     */
    private String addat;
    /***
     */
    private String adtim;
    /***
     */
    private String adusr;
    /***
     */
    private String chdat;
    /***
     */
    private String chtim;
    /***
     */
    private String chusr;
    /***
     */
    private String statu;
    /***
     */
    private String errtm;
    
    /**
     * [KO] 작업방법 코드
     */
    private String jobcd;
    
    /**
     * [KO] 고장 구분
     */
    private String kogub;
    
    /**
     * [KO] 실시부서코드
     */
    private String sdpcd;
    
    /**
     * [KO] 실시부서명
     */
    private String sdpnm;
    
    /**
     * [KO] SUBASSY코드
     */
    private String subas;
    
    /**
     * [KO] 분류코드명
     */
    private String assnm;
    
    /**
     * [KO] 부품분류코드
     */
    private String kndcd;
    
    /**
     * [KO] 부품분류명
     */
    private String kndnm;
    
    /**
     * [KO] 처치코드
     */
    private String chocd;
    
    /**
     * [KO] 처치명
     */
    private String chonm;
    
    /**
     * [KO] 검색 - 음행
     */
    private String umhen;
    
    /**
     * [KO] COMPLETE 부품코드
     */
    private String comcd;
    
    /**
     * [KO] COMPLETE 부품명
     */
    private String cpart;
    
    /**
     * [KO] 현상분류 코드
     */
    private String hkind;
    
    /**
     * [KO] 현상분류명
     */
    private String hkdnm;
    
    /**
     * [KO] 원인분류 코드
     */
    private String ckind;
    
    /**
     * [KO] 원인분류명
     */
    private String ckdnm;
    
    /**
     * [KO] 실원인분류 코드
     */
    private String tkind;
    
    /**
     * [KO] 실원인분류명
     */
    private String tkdnm;
    
    /**
     * [KO] 현상코드
     */
    private String hyocd;
    
    /**
     * [KO] 현상명
     */
    private String hyonm;
    
    /**
     * [KO] 원인코드
     */
    private String caucd;
    
    /**
     * [KO] 원인명
     */
    private String cause;
    
    /**
     * [KO] 실원인코드
     */
    private String trucd;
    
    /**
     * [KO] 실원인명
     */
    private String trunm;
    
    /**
     * [KO] 설비
     */
    private String msh;
    
    /**
     * [KO] 설비번호
     */
    private String mshno;
    
    /**
     * [KO] 설비
     */
    private String mshnm;
    
    /**
     * [KO] 책임자
     */
    private String wrkm;
    
    /**
     * [KO] 책임자 이름
     */
    private String kornm;
    
    /**
     * [KO] 
     */
    private String wndat;
    
    /**
     * [KO] 지시 No
     */
    private String jisno;
    
    /**
     * [KO] 현상
     */
    private String hyosn;
    
    /**
     * [KO] 현상(param)
     */
    private String hyosn2;
    
    /**
     * [KO] 현상(param)
     */
    private String hyosn3;

    /**
     * [KO] 원인
     */
    private String wonin;
    

    /**
     * [KO] 원인(param)
     */
    private String wonin2;
    

    /**
     * [KO] 원인(param)
     */
    private String wonin3;
    
    /**
     * [KO] 디책
     */
    private String daech;
    
    /**
     * [KO] 디책(param)
     */
    private String daech2;
    
    /**
     * [KO] 디책(param)
     */
    private String daech3;
    
    /**
     * [KO] 
     */
    private String job;
    
    /**
     * [KO] 
     */
    private String jobnm;
    
    /**
     * [KO] 
     */
    private String assy;
    
    /**
     * [KO] 
     */
    private String set;
    
    /**
     * [KO] 
     */
    private String hyo;
    
    
    /**
     * [KO] 
     */
    private String cho;
    
    /**
     * [KO] 
     */
    private String dec;
    
    /**
     * [KO] 
     */
    private String dpart;
    
    /**
     * [KO] 
     */
    private String stphr;
    
    /**
     * [KO] 
     */
    private String mnthr;
    
    /**
     * [KO] 
     */
    private String janhr;
    
    /**
     * [KO] 
     */
    private String padat;
    
    /**
     * [KO] 
     */
    private String urdat;
    
    /**
     * [KO] 
     */
    private String ksdat;
    
    /**
     * [KO] 
     */
    private String wndat2;
    
    /**
     * [KO] 
     */
    private String deccd;
    
    /**
     * [KO] 
     */
    private String andor;
    
    /**
     * [KO] 검색개시일
     */
    private String wndats;
    
    /**
     * [KO] 검색종료일
     */
    private String wndate;
    
    /**
     * [KO] 
     */
    private String timcd;
    
    /**
     * [KO] 
     */
    private String dptcd;
    
    /**
     * [KO] 
     */
    private String kdown;
    
    /**
     * [KO] 
     */
    private String inocd;
    
    /**
     * [KO] 
     */
    private String inonm;
    
    /**
     * [KO] 
     */
    private String emgcd;
    
    /**
     * [KO] 
     */
    private String emgry;
    
    /**
     * [KO] 
     */
    private String qorcd;
    
    /**
     * [KO] 
     */
    private String qornm;
    
    /**
     * [KO] 
     */
    private String assno;
    
    /**
     * [KO] 
     */
    private String prtno;
    
    /**
     * [KO] 
     */
    private String patim;
    
    /**
     * [KO] 
     */
    private String urtim;
    
    /**
     * [KO] 
     */
    private String kstim;
    
    /**
     * [KO] 
     */
    private String wntim;
    
    /**
     * [KO] 
     */
    private String wrkm2;
    
    /**
     * [KO] 
     */
    private String kornm2;
        
    /**
     * [KO] 
     */
    private String sdpnm2;
    
    /**
     * [KO] 
     */
    private String subcn;
    
    /**
     * [KO] 
     */
    private String scost;
    
    /**
     * [KO] 
     */
    private String pcost;
    
    /**
     * [KO] 
     */
    private String repcd;
    
    /**
     * [KO] 
     */
    private String repnm;
    
    /**
     * [KO] 
     */
    private String effcd;
    
    /**
     * [KO] 
     */
    private String effnm;
    
    /**
     * [KO] 
     */
    private String ecost;
    
    /**
     * [KO] 
     */
    private String wathr;
    
    /**
     * [KO] 
     */
    private String wrkhr;
    
    /**
     * [KO] 
     */
    private String bfrhr;
    
    /**
     * [KO] 
     */
    private String tothr;
    
    /**
     * [KO] 
     */
    private String cmplt;
    
    /**
     * [KO] 
     */
    private String cnote;
    
    /**
     * [KO] 
     */
    private String teima;
    
    /**
     * [KO] 
     */
    private String daesn;
    
    /**
     * [KO] 
     */
    private String chkan;
    
    /**
     * [KO] 
     */
    private String imgbf;
    
    /**
     * [KO] 
     */
    private String imgaf;
    
    /**
     * [KO] 부품명
     */
    private String prtnm;
    
    /**
     * [KO] 규격
     */
    private String ptype;
    
    /**
     * [KO] 수량      
     */
    private String quaty;
    
    /**
     * [KO] 근액
     */
    private String amont;
    
    /**
     * [KO] MAKER
     */
    private String maker;
    
    /**
     * [KO] 단가
     */
    private String price;
    
    /**
     * [KO] 일련번호
     */
    private String seqno;
    
    //사업부별 DB2데이터베이스
    /***
     */
    private String lib1;

    //사업부별 DB2데이터베이스
    /***
     */
    private String lib2;

    //사업부별 DB2데이터베이스
    /***
     */
    private String lib3;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmDomain() {
        // no process
    }

    /**
        @return lincd
     */
    public String getLincd() {
        return lincd;
    }

    /**
        @param lincd String
     */
    public void setLincd(String lincd) {
        this.lincd = lincd;
    }


    /**
        @return linnm
     */
    public String getLinnm() {
        if(linnm == null){
            return "";
        }else{
            return linnm;
        }
    }


    /**
        @param linnm String
     */
    public void setLinnm(String linnm) {
        this.linnm = linnm;
    }


    /**
        @return comps
     */
    public String getComps() {
        return comps;
    }


    /**
        @param comps String
     */
    public void setComps(String comps) {
        this.comps = comps;
    }


    /**
        @return cdept
     */
    public String getCdept() {
        return cdept;
    }


    /**
        @param cdept String
     */
    public void setCdept(String cdept) {
        this.cdept = cdept;
    }


    /**
        @return prtcd
     */
    public String getPrtcd() {
        return prtcd;
    }


    /**
        @param prtcd String
     */
    public void setPrtcd(String prtcd) {
        this.prtcd = prtcd;
    }


    /**
        @return mline
     */
    public String getMline() {
        return mline;
    }


    /**
        @param mline String
     */
    public void setMline(String mline) {
        this.mline = mline;
    }


    /**
        @return dptfl
     */
    public String getDptfl() {
        return dptfl;
    }


    /**
        @param dptfl String
     */
    public void setDptfl(String dptfl) {
        this.dptfl = dptfl;
    }


    /**
        @return addat
     */
    public String getAddat() {
        return addat;
    }


    /**
        @param addat String
     */
    public void setAddat(String addat) {
        this.addat = addat;
    }


    /**
        @return adtim
     */
    public String getAdtim() {
        return adtim;
    }


    /**
        @param adtim String
     */
    public void setAdtim(String adtim) {
        this.adtim = adtim;
    }


    /**
        @return adusr
     */
    public String getAdusr() {
        return adusr;
    }


    /**
        @param adusr String
     */
    public void setAdusr(String adusr) {
        this.adusr = adusr;
    }


    /**
        @return chdat
     */
    public String getChdat() {
        return chdat;
    }


    /**
        @param chdat String
     */
    public void setChdat(String chdat) {
        this.chdat = chdat;
    }


    /**
        @return chtim
     */
    public String getChtim() {
        return chtim;
    }


    /**
        @param chtim String
     */
    public void setChtim(String chtim) {
        this.chtim = chtim;
    }


    /**
        @return chusr
     */
    public String getChusr() {
        return chusr;
    }


    /**
        @param chusr String
     */
    public void setChusr(String chusr) {
        this.chusr = chusr;
    }


    /**
        @return statu
     */
    public String getStatu() {
        return statu;
    }


    /**
        @param statu String
     */
    public void setStatu(String statu) {
        this.statu = statu;
    }


    /**
        @return errtm
     */
    public String getErrtm() {
        return errtm;
    }


    /**
        @param errtm String
     */
    public void setErrtm(String errtm) {
        this.errtm = errtm;
    }
    
    /**
     * @return LIB1
     */
    public String getJobcd() {
        if(jobcd == null){
            return "";
        }else{
            return jobcd;
        }
    }

    /**
     * @param jobcd String
     */
    public void setJobcd(String jobcd) {
        this.jobcd = jobcd;
    }

    /**
     * @return LIB1
     */
    public String getKogub() {
        return kogub;
    }

    /**
     * @param kogub String
     */
    public void setKogub(String kogub) {
        this.kogub = kogub;
    }
    
    /**
     * @return sdpcd
     */
    public String getSdpcd() {
        if(sdpcd == null){
            return "";
        }else{
            return sdpcd;
        }
    }

    /**
     * @param sdpcd String
     */
    public void setSdpcd(String sdpcd) {
        this.sdpcd = sdpcd;
    }
    
    /**
     * @return sdpnm
     */
    public String getSdpnm() {
        if(sdpnm == null){
            return "";
        }else{
            return sdpnm;
        }
    }

    /**
     * @param sdpnm String
     */
    public void setSdpnm(String sdpnm) {
        this.sdpnm = sdpnm;
    }
    
    /**
     * 
     * @return subas
     */
    public String getSubas() {
        if(subas == null){
            return "";
        }else{
            return subas;
        }
    }

    /**
     * 
     * @param subas String
     */
    public void setSubas(String subas) {
        this.subas = subas;
    }

    /**
     * 
     * @return assnm
     */
    public String getAssnm() {
        if(assnm == null){
            return "";
        }else{
            return assnm;
        }
    }

    /**
     * 
     * @param assnm String
     */
    public void setAssnm(String assnm) {
        this.assnm = assnm;
    }

    /**
     * 
     * @return kndcd
     */
    public String getKndcd() {
        return kndcd;
    }

    /**
     * 
     * @param kndcd String
     */
    public void setKndcd(String kndcd) {
        this.kndcd = kndcd;
    }

    /**
     * 
     * @return kndnm
     */
    public String getKndnm() {
        return kndnm;
    }

    /**
     * 
     * @param kndnm String
     */
    public void setKndnm(String kndnm) {
        this.kndnm = kndnm;
    }
    
    /**
     * 
     * @return chocd
     */
    public String getChocd() {
        if(chocd == null){
            return "";
        }else{
            return chocd;
        }
    }

    /**
     * 
     * @param chocd String
     */
    public void setChocd(String chocd) {
        this.chocd = chocd;
    }

    /**
     * 
     * @return chonm
     */
    public String getChonm() {
        if(chonm == null){
            return "";
        }else{
            return chonm;
        }
    }

    /**
     * 
     * @param chonm String
     */
    public void setChonm(String chonm) {
        this.chonm = chonm;
    }
    
    /**
     * 
     * @return umhen
     */
    public String getUmhen() {
        return umhen;
    }

    /**
     * 
     * @param umhen String
     */
    public void setUmhen(String umhen) {
        this.umhen = umhen;
    }

    /**
     * 
     * @return comcd
     */
    public String getComcd() {
        if(comcd == null){
            return "";
        }else{
            return comcd;
        }
    }

    /**
     * 
     * @param comcd String
     */
    public void setComcd(String comcd) {
        this.comcd = comcd;
    }

    /**
     * 
     * @return cpart
     */
    public String getCpart() {
        if(cpart == null){
            return "";
        }else{
            return cpart;
        }
    }

    /**
     * 
     * @param cpart String
     */
    public void setCpart(String cpart) {
        this.cpart = cpart;
    }

    /**
     * 
     * @return hkind
     */
    public String getHkind() {
        return hkind;
    }

    /**
     * 
     * @param hkind String
     */
    public void setHkind(String hkind) {
        this.hkind = hkind;
    }

    /**
     * 
     * @return hkdnm
     */
    public String getHkdnm() {
        return hkdnm;
    }

    /**
     * 
     * @param hkdnm String
     */
    public void setHkdnm(String hkdnm) {
        this.hkdnm = hkdnm;
    }
    
    /**
     * 
     * @return ckind
     */
    public String getCkind() {
        return ckind;
    }

    /**
     * 
     * @param ckind String
     */
    public void setCkind(String ckind) {
        this.ckind = ckind;
    }

    /**
     * 
     * @return ckdnm
     */
    public String getCkdnm() {
        return ckdnm;
    }

    /**
     * 
     * @param ckdnm String
     */
    public void setCkdnm(String ckdnm) {
        this.ckdnm = ckdnm;
    }

    /**
     * 
     * @return tkind
     */
    public String getTkind() {
        return tkind;
    }

    /**
     * 
     * @param tkind String
     */
    public void setTkind(String tkind) {
        this.tkind = tkind;
    }

    /**
     * 
     * @return tkdnm
     */
    public String getTkdnm() {
        return tkdnm;
    }

    /**
     * 
     * @param tkdnm String
     */
    public void setTkdnm(String tkdnm) {
        this.tkdnm = tkdnm;
    }
    
    /**
     * 
     * @return hyocd
     */
    public String getHyocd() {
        if(hyocd == null){
            return "";
        }else{
            return hyocd;
        }
    }

    /**
     * 
     * @param hyocd String
     */
    public void setHyocd(String hyocd) {
        this.hyocd = hyocd;
    }

    /**
     * 
     * @return hyonm
     */
    public String getHyonm() {
        if(hyonm == null){
            return "";
        }else{
            return hyonm;
        }
    }

    /**
     * 
     * @param hyonm String
     */
    public void setHyonm(String hyonm) {
        this.hyonm = hyonm;
    }

    /**
     * 
     * @return caucd
     */
    public String getCaucd() {
        if(caucd == null){
            return "";
        }else{
            return caucd;
        }
    }

    /**
     * 
     * @param caucd String
     */
    public void setCaucd(String caucd) {
        this.caucd = caucd;
    }

    /**
     * 
     * @return cause
     */
    public String getCause() {
        if(cause == null){
            return "";
        }else{
            return cause;
        }
    }

    /**
     * 
     * @param cause String
     */
    public void setCause(String cause) {
        this.cause = cause;
    }

    /**
     * 
     * @return trucd
     */
    public String getTrucd() {
        if(trucd == null){
            return "";
        }else{
            return trucd;
        }
    }

    /**
     * 
     * @param trucd String
     */
    public void setTrucd(String trucd) {
        this.trucd = trucd;
    }

    /**
     * 
     * @return trunm
     */
    public String getTrunm() {
        if(trunm == null){
            return "";
        }else{
            return trunm;
        }
    }

    /**
     * 
     * @param trunm String
     */
    public void setTrunm(String trunm) {
        this.trunm = trunm;
    }
    
    /**
     * 
     * @return msh
     */
    public String getMsh() {
        return msh;
    }

    /**
     * 
     * @param msh String
     */
    public void setMsh(String msh) {
        this.msh = msh;
    }

    /**
     * 
     * @return mshno
     */
    public String getMshno() {
        if(mshno == null){
            return "";
        }else{
            return mshno;
        }
    }

    /**
     * 
     * @param mshno String
     */
    public void setMshno(String mshno) {
        this.mshno = mshno;
    }

    /**
     * 
     * @return mshnm
     */
    public String getMshnm() {
        if(mshnm == null){
            return "";
        }else{
            return mshnm;
        }
    }

    /**
     * @param mshnm String
     */
    public void setMshnm(String mshnm) {
        this.mshnm = mshnm;
    }

    /**
     *  
     * @return wrkm
     */
    public String getWrkm() {
        if(wrkm == null){
            return "";
        }else{
            return wrkm;
        }
    }

    /**
     * 
     * @param wrkm String
     */
    public void setWrkm(String wrkm) {
        this.wrkm = wrkm;
    }

    /**
     * 
     * @return kornm
     */
    public String getKornm() {
        if(kornm == null){
            return "";
        }else{
            return kornm;
        }
    }

    /**
     * 
     * @param kornm String
     */
    public void setKornm(String kornm) {
        this.kornm = kornm;
    }

    /**
     * 
     * @return wndat
     */
    public String getWndat() {
        if(wndat == null){
            return "";
        }else{
            return wndat;
        }
    }

    /**
     * 
     * @param wndat String
     */
    public void setWndat(String wndat) {
        this.wndat = wndat;
    }
    
    /**
     * 
     * @return jisno
     */
    public String getJisno() {
        if(jisno == null){
            return "";
        }else{
            return jisno;
        }
    }

    /**
     * 
     * @param jisno String
     */
    public void setJisno(String jisno) {
        this.jisno = jisno;
    }

    /**
     * 
     * @return hyosn
     */
    public String getHyosn() {
        if(hyosn == null){
            return "";
        }else{
            return hyosn;
        }
    }

    /**
     * 
     * @param hyosn String
     */
    public void setHyosn(String hyosn) {
        this.hyosn = hyosn;
    }
    
    /**
     * 
     * @return hyosn2
     */
    public String getHyosn2() {
        return hyosn2;
    }

    /**
     * 
     * @param hyosn2 String
     */
    public void setHyosn2(String hyosn2) {
        this.hyosn2 = hyosn2;
    }
    
    /**
     * 
     * @return hyosn3
     */
    public String getHyosn3() {
        return hyosn3;
    }

    /**
     *  
     * @param hyosn3 String
     */
    public void setHyosn3(String hyosn3) {
        this.hyosn3 = hyosn3;
    }
    
    /**
     * 
     * @return wonin
     */
    public String getWonin() {
        if(wonin == null){
            return "";
        }else{
            return wonin;
        }
    }

    /**
     * 
     * @param wonin String
     */
    public void setWonin(String wonin) {
        this.wonin = wonin;
    }
    
    /**
     * 
     * @return wonin2
     */
    public String getWonin2() {
        return wonin2;
    }

    /**
     * 
     * @param wonin2 String
     */
    public void setWonin2(String wonin2) {
        this.wonin2 = wonin2;
    }
    
    /**
     * 
     * @return wonin3
     */ 
    public String getWonin3() {
        return wonin3;
    }

    /**
     * 
     * @param wonin3 String
     */
    public void setWonin3(String wonin3) {
        this.wonin = wonin3;
    }

    /**
     * 
     * @return daech
     */
    public String getDaech() {
        if(daech == null){
            return "";
        }else{
            return daech;
        }
    }

    /**
     * 
     * @param daech String
     */
    public void setDaech(String daech) {
        this.daech = daech;
    }
    
    /**
     * 
     * @return daech2
     */
    public String getDaech2() {
        return daech2;
    }

    /**
     * 
     * @param daech2 String
     */
    public void setDaech2(String daech2) {
        this.daech2 = daech2;
    }
    
    /**
     *  
     * @return daech3
     */
    public String getDaech3() {
        return daech3;
    }

    /**
     * 
     * @param daech3 String
     */
    public void setDaech3(String daech3) {
        this.daech3 = daech3;
    }

    /**
     * 
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * 
     * @param job String
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 
     * @return jobnm
     */
    public String getJobnm() {
        if(jobnm == null){
            return "";
        }else{
            return jobnm;
        }
    }

    /**
     * 
     * @param jobnm String
     */
    public void setJobnm(String jobnm) {
        this.jobnm = jobnm;
    }

    /**
     * 
     * @return assy
     */
    public String getAssy() {
        return assy;
    }

    /**
     * 
     * @param assy String
     */
    public void setAssy(String assy) {
        this.assy = assy;
    }

    /**
     * 
     * @return set
     */
    public String getSet() {
        return set;
    }

    /**
     * 
     * @param set String
     */
    public void setSet(String set) {
        this.set = set;
    }

    /**
     * 
     * @return hyo
     */
    public String getHyo() {
        return hyo;
    }

    /**
     * 
     * @param hyo String
     */
    public void setHyo(String hyo) {
        this.hyo = hyo;
    }

    /**
     * 
     * @return cho
     */
    public String getCho() {
        return cho;
    }

    /**
     * 
     * @param cho String
     */
    public void setCho(String cho) {
        this.cho = cho;
    }

    /**
     * 
     * @return dec
     */
    public String getDec() {
        return dec;
    }

    /**
     * 
     * @param dec String
     */
    public void setDec(String dec) {
        this.dec = dec;
    }

    /**
     * 
     * @return dpart
     */
    public String getDpart() {
        if(dpart == null){
            return "";
        }else{
            return dpart;
        }
    }

    /**
     * 
     * @param dpart String 
     */
    public void setDpart(String dpart) {
        this.dpart = dpart;
    }

    /**
     * 
     * @return stphr
     */
    public String getStphr() {
        if(stphr == null){
            return "";
        }else{
            return stphr;
        }
    }

    /**
     * 
     * @param stphr String
     */
    public void setStphr(String stphr) {
        this.stphr = stphr;
    }
    
    /**
     * 
     * @return mnthr
     */
    public String getMnthr() {
        if(mnthr == null){
            return "";
        }else{
            return mnthr;
        }
    }

    /**
     * 
     * @param mnthr String
     */
    public void setMnthr(String mnthr) {
        this.mnthr = mnthr;
    }

    /**
     * 
     * @return janhr
     */
    public String getJanhr() {
        if(janhr == null){
            return "";
        }else{
            return janhr;
        }
    }

    /**
     * 
     * @param janhr String 
     */
    public void setJanhr(String janhr) {
        this.janhr = janhr;
    }

    /**
     * 
     * @return padat
     */
    public String getPadat() {
        if(padat == null){
            return "";
        }else{
            return padat;
        }
    }

    /**
     * 
     * @param padat String
     */
    public void setPadat(String padat) {
        this.padat = padat;
    }

    /**
     * 
     * @return urdat
     */
    public String getUrdat() {
        if(urdat == null){
            return "";
        }else{
            return urdat;
        }
    }

    /**
     * 
     * @param urdat String
     */
    public void setUrdat(String urdat) {
        this.urdat = urdat;
    }

    /**
     * 
     * @return ksdat
     */
    public String getKsdat() {
        if(ksdat == null){
            return "";
        }else{
            return ksdat;
        }
    }

    /**
     * 
     * @param ksdat String
     */
    public void setKsdat(String ksdat) {
        this.ksdat = ksdat;
    }

    /**
     * 
     * @return wndat2
     */
    public String getWndat2() {
        return wndat2;
    }

    /**
     * 
     * @param wndat2 String
     */
    public void setWndat2(String wndat2) {
        this.wndat2 = wndat2;
    }

    /**
     * 
     * @return deccd
     */
    public String getDeccd() {
        if(deccd == null){
            return "";
        }else{
            return deccd;
        }
    }

    /**
     * 
     * @param deccd String
     */
    public void setDeccd(String deccd) {
        this.deccd = deccd;
    }

    /**
     * 
     * @return andor
     */
    public String getAndor() {
        return andor;
    }

    /**
     * 
     * @param andor String
     */
    public void setAndor(String andor) {
        this.andor = andor;
    }

    /**
     * 
     * @return wndats
     */
    public String getWndats() {
        return wndats;
    }

    /**
     * 
     * @param wndats String
     */
    public void setWndats(String wndats) {
        this.wndats = wndats;
    }

    /**
     * 
     * @return wndate
     */
    public String getWndate() {
        return wndate;
    }

    /**
     * 
     * @param wndate String
     */
    public void setWndate(String wndate) {
        this.wndate = wndate;
    }

    /**
     * 
     * @return timcd 
     */
    public String getTimcd() {
        return timcd;
    }

    /**
     * 
     * @param timcd String
     */
    public void setTimcd(String timcd) {
        this.timcd = timcd;
    }
    
    /**
     * 
     * @return dptcd 
     */
    public String getDptcd() {
        return dptcd;
    }

    /**
     * 
     * @param dptcd String
     */
    public void setDptcd(String dptcd) {
        this.dptcd = dptcd;
    }

    /**
     * 
     * @return kdown
     */
    public String getKdown() {
        if(kdown == null){
            return "";
        }else{
            return kdown;
        }
    }

    /**
     * 
     * @param kdown String
     */
    public void setKdown(String kdown) {
        this.kdown = kdown;
    }

    /**
     * 
     * @return inocd
     */
    public String getInocd() {
        if(inocd == null){
            return "";
        }else{
            return inocd;
        }
    }

    /**
     * 
     * @param inocd String 
     */
    public void setInocd(String inocd) {
        this.inocd = inocd;
    }

    /**
     * 
     * @return inonm
     */
    public String getInonm() {
        if(inonm == null){
            return "";
        }else{
            return inonm;
        }
    }

    /**
     * 
     * @param inonm String
     */
    public void setInonm(String inonm) {
        this.inonm = inonm;
    }

    /**
     * 
     * @return emgcd
     */
    public String getEmgcd() {
        if(emgcd == null){
            return "";
        }else{
            return emgcd;
        }
    }

    /**
     * 
     * @param emgcd String
     */
    public void setEmgcd(String emgcd) {
        this.emgcd = emgcd;
    }

    /**
     * 
     * @return emgry
     */
    public String getEmgry() {
        if(emgry == null){
            return "";
        }else{
            return emgry;
        }
    }

    /**
     * 
     * @param emgry String
     */
    public void setEmgry(String emgry) {
        this.emgry = emgry;
    }

    /**
     * 
     * @return qorcd
     */
    public String getQorcd() {
        if(qorcd == null){
            return "";
        }else{
            return qorcd;
        }
    }

    /**
     * 
     * @param qorcd String
     */
    public void setQorcd(String qorcd) {
        this.qorcd = qorcd;
    }

    /**
     * 
     * @return qornm
     */
    public String getQornm() {
        if(qornm == null){
            return "";
        }else{
            return qornm;
        }
    }

    /**
     * 
     * @param qornm String
     */
    public void setQornm(String qornm) {
        this.qornm = qornm;
    }

    /**
     * 
     * @return assno
     */
    public String getAssno() {
        if(assno == null){
            return "";
        }else{
            return assno;
        }
    }

    /**
     * 
     * @param assno String
     */
    public void setAssno(String assno) {
        this.assno = assno;
    }

    /**
     * 
     * @return prtno
     */
    public String getPrtno() {
        if(prtno == null){
            return "";
        }else{
            return prtno;
        }
    }

    /**
     * 
     * @param prtno String
     */
    public void setPrtno(String prtno) {
        this.prtno = prtno;
    }

    /**
     * 
     * @return patim
     */
    public String getPatim() {
        if(patim == null){
            return "";
        }else{
            return patim;
        }
    }

    /**
     * 
     * @param patim String
     */
    public void setPatim(String patim) {
        this.patim = patim;
    }

    /**
     * 
     * @return urtim
     */
    public String getUrtim() {
        if(urtim == null){
            return "";
        }else{
            return urtim;
        }
    }

    /**
     * 
     * @param urtim String
     */
    public void setUrtim(String urtim) {
        this.urtim = urtim;
    }

    /**
     * 
     * @return kstim
     */
    public String getKstim() {
        if(kstim == null){
            return "";
        }else{
            return kstim;
        }
    }

    /**
     * 
     * @param kstim String
     */
    public void setKstim(String kstim) {
        this.kstim = kstim;
    }

    /**
     * 
     * @return wntim
     */
    public String getWntim() {
        if(wntim == null){
            return "";
        }else{
            return wntim;
        }
    }

    /**
     * 
     * @param wntim String
     */
    public void setWntim(String wntim) {
        this.wntim = wntim;
    }

    /**
     * 
     * @return wrkm2
     */
    public String getWrkm2() {
        if(wrkm2 == null){
            return "";
        }else{
            return wrkm2;
        }
    }

    /**
     * 
     * @param wrkm2 String
     */
    public void setWrkm2(String wrkm2) {
        this.wrkm2 = wrkm2;
    }

    /**
     * 
     * @return kornm2
     */
    public String getKornm2() {
        if(kornm2 == null){
            return "";
        }else{
            return kornm2;
        }
    }

    /**
     * 
     * @param kornm2 String
     */
    public void setKornm2(String kornm2) {
        this.kornm2 = kornm2;
    }

    /**
     * 
     * @return sdpnm2
     */
    public String getSdpnm2() {
        if(sdpnm2 == null){
            return "";
        }else{
            return sdpnm2;
        }
    }

    /**
     * 
     * @param sdpnm2 String
     */
    public void setSdpnm2(String sdpnm2) {
        this.sdpnm2 = sdpnm2;
    }

    /**
     * 
     * @return subcn
     */
    public String getSubcn() {
        if(subcn == null){
            return "";
        }else{
            return subcn;
        }
    }

    /**
     * 
     * @param subcn String
     */
    public void setSubcn(String subcn) {
        this.subcn = subcn;
    }

    /**
     * 
     * @return scost
     */
    public String getScost() {
        if(scost == null){
            return "";
        }else{
            return scost;
        }
    }

    /**
     * 
     * @param scost String
     */
    public void setScost(String scost) {
        this.scost = scost;
    }

    /**
     * 
     * @return pcost
     */
    public String getPcost() {
        if(pcost == null){
            return "";
        }else{
            return pcost;
        }
    }

    /**
     * 
     * @param pcost String
     */
    public void setPcost(String pcost) {
        this.pcost = pcost;
    }

    /**
     * 
     * @return repcd
     */
    public String getRepcd() {
        if(repcd == null){
            return "";
        }else{
            return repcd;
        }
    }

    /**
     * 
     * @param repcd String
     */
    public void setRepcd(String repcd) {
        this.repcd = repcd;
    }

    /**
     * 
     * @return repnm
     */
    public String getRepnm() {
        if(repnm == null){
            return "";
        }else{
            return repnm;
        }
    }

    /**
     * 
     * @param repnm String
     */
    public void setRepnm(String repnm) {
        this.repnm = repnm;
    }
    
    /**
     * 
     * @return effcd
     */
    public String getEffcd() {
        if(effcd == null){
            return "";
        }else{
            return effcd;
        }
    }

    /**
     * 
     * @param effcd String
     */
    public void setEffcd(String effcd) {
        this.effcd = effcd;
    }

    /**
     * 
     * @return effnm
     */
    public String getEffnm() {
        if(effnm == null){
            return "";
        }else{
            return effnm;
        }
    }

    /**
     * 
     * @param effnm String
     */
    public void setEffnm(String effnm) {
        this.effnm = effnm;
    }

    /**
     * 
     * @return ecost
     */
    public String getEcost() {
        if(ecost == null){
            return "";
        }else{
            return ecost;
        }
    }

    /**
     * 
     * @param ecost String
     */
    public void setEcost(String ecost) {
        this.ecost = ecost;
    }

    /**
     * 
     * @return wathr
     */
    public String getWathr() {
        if(wathr == null){
            return "";
        }else{
            return wathr;
        }
    }

    /**
     * 
     * @param wathr String
     */
    public void setWathr(String wathr) {
        this.wathr = wathr;
    }

    /**
     * 
     * @return wrkhr
     */
    public String getWrkhr() {
        return wrkhr;
    }

    /**
     * 
     * @param wrkhr String
     */
    public void setWrkhr(String wrkhr) {
        this.wrkhr = wrkhr;
    }

    /**
     * 
     * @return bfrhr
     */
    public String getBfrhr() {
        if(bfrhr == null){
            return "";
        }else{
            return bfrhr;
        }
    }

    /**
     * 
     * @param bfrhr String
     */
    public void setBfrhr(String bfrhr) {
        this.bfrhr = bfrhr;
    }

    /**
     * 
     * @return tothr
     */
    public String getTothr() {
        if(tothr == null){
            return "";
        }else{
            return tothr;
        }
    }

    /**
     * 
     * @param tothr String
     */
    public void setTothr(String tothr) {
        this.tothr = tothr;
    }

    /**
     * 
     * @return cmplt
     */
    public String getCmplt() {
        if(cmplt == null){
            return "";
        }else{
            return cmplt;
        }
    }

    /**
     * 
     * @param cmplt String
     */
    public void setCmplt(String cmplt) {
        this.cmplt = cmplt;
    }

    /**
     * 
     * @return cnote
     */
    public String getCnote() {
        if(cnote == null){
            return "";
        }else{
            return cnote;
        }
    }

    /**
     * 
     * @param cnote String
     */
    public void setCnote(String cnote) {
        this.cnote = cnote;
    }
    
    /**
     * 
     * @return teima
     */
    public String getTeima() {
        if(teima == null){
            return "";
        }else{
            return teima;
        }
    }

    /**
     *  
     * @param teima String
     */
    public void setTeima(String teima) {
        this.teima = teima;
    }
    
    /**
     * 
     * @return daesn
     */
    public String getDaesn() {
        if(daesn == null){
            return "";
        }else{
            return daesn;
        }
    }

    /**
     * 
     * @param daesn String
     */
    public void setDaesn(String daesn) {
        this.daesn = daesn;
    }
    
    /**
     * 
     * @return chkan
     */
    public String getChkan() {
        if(chkan == null){
            return "";
        }else{
            return chkan;
        }
    }

    /**
     * 
     * @param chkan String
     */
    public void setChkan(String chkan) {
        this.chkan = chkan;
    }
    
    /**
     * 
     * @return imgbf
     */
    public String getImgbf() {
        if(imgbf == null){
            return "";
        }else{
            return imgbf;
        }
    }

    /**
     * 
     * @param imgbf String
     */
    public void setImgbf(String imgbf) {
        this.imgbf = imgbf;
    }
    
    /**
     * 
     * @return imgaf
     */
    public String getImgaf() {
        if(imgaf == null){
            return "";
        }else{
            return imgaf;
        }
    }

    /**
     *  
     * @param imgaf String
     */
    public void setImgaf(String imgaf) {
        this.imgaf = imgaf;
    }

    /**
     * 
     * @return prtnm
     */
    public String getPrtnm() {
        return prtnm;
    }

    /**
     * 
     * @param prtnm String
     */
    public void setPrtnm(String prtnm) {
        this.prtnm = prtnm;
    }

    /**
     * 
     * @return ptype
     */
    public String getPtype() {
        return ptype;
    }

    /**
     * 
     * @param ptype String
     */
    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    /**
     * 
     * @return quaty
     */
    public String getQuaty() {
        return quaty;
    }

    /**
     * 
     * @param quaty String
     */
    public void setQuaty(String quaty) {
        this.quaty = quaty;
    }

    /**
     * 
     * @return amont
     */
    public String getAmont() {
        return amont;
    }

    /**
     * 
     * @param amont String
     */
    public void setAmont(String amont) {
        this.amont = amont;
    }
    
    /**
     * 
     * @return maker
     */
    public String getMaker() {
        return maker;
    }

    /**
     * 
     * @param maker String
     */
    public void setMaker(String maker) {
        this.maker = maker;
    }

    /**
     * 
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price String
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 
     * @return seqno
     */
    public String getSeqno() {
        return seqno;
    }

    /**
     * 
     * @param seqno String
     */
    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }

    /**
    @return lib1
     */
    public String getLib1() {
        return lib1;
    }
    
    
    /**
        @param lib1 String
     */
    public void setLib1(String lib1) {
        this.lib1 = lib1;
    }


    /**
        @return lib2
     */
    public String getLib2() {
        return lib2;
    }


    /**
        @param lib2 String
     */
    public void setLib2(String lib2) {
        this.lib2 = lib2;
    }


    /**
        @return lib3
     */
    public String getLib3() {
        return lib3;
    }


    /**
        @param lib3 String
     */
    public void setLib3(String lib3) {
        this.lib3 = lib3;
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("seqno", this.seqno);
        jsonObj.put("jobcd", this.jobcd);
        jsonObj.put("kogub", this.kogub);
        jsonObj.put("subas", this.subas);
        jsonObj.put("assnm", this.assnm);
        jsonObj.put("kndcd", this.kndcd);
        jsonObj.put("kndnm", this.kndnm);
        jsonObj.put("umhen", this.umhen);
        jsonObj.put("comcd", this.comcd);
        jsonObj.put("cpart", this.cpart);
        jsonObj.put("hyocd", this.hyocd);
        jsonObj.put("hyonm", this.hyonm);
        jsonObj.put("hkdnm", this.hkdnm);
        jsonObj.put("caucd", this.caucd);
        jsonObj.put("cause", this.cause);
        jsonObj.put("ckdnm", this.ckdnm);
        jsonObj.put("trucd", this.trucd);
        jsonObj.put("trunm", this.trunm);
        jsonObj.put("tkdnm", this.tkdnm);
        jsonObj.put("msh", this.msh);
        jsonObj.put("mshno", this.mshno);
        jsonObj.put("mshnm", this.mshnm);
        jsonObj.put("wrkm", this.wrkm);
        jsonObj.put("kornm", this.kornm);
        jsonObj.put("wndat", this.wndat);
        jsonObj.put("jisno", this.jisno);
        jsonObj.put("prtno", this.prtno);
        jsonObj.put("prtnm", this.prtnm);
        jsonObj.put("ptype", this.ptype);
        jsonObj.put("maker", this.maker);
        jsonObj.put("quaty", this.quaty);
        jsonObj.put("price", this.price);
        jsonObj.put("amont", this.amont);
        jsonObj.put("hyosn", this.hyosn);
        jsonObj.put("wonin", this.wonin);
        jsonObj.put("daech", this.daech);
        jsonObj.put("effcd", this.effcd);
        jsonObj.put("effnm", this.effnm);
        jsonObj.put("repcd", this.repcd);
        jsonObj.put("repnm", this.repnm);
        jsonObj.put("job", this.job);
        jsonObj.put("jobnm", this.jobnm);
        jsonObj.put("assy", this.assy);
        jsonObj.put("set", this.set);
        jsonObj.put("hyo", this.hyo);
        jsonObj.put("cho", this.cho);
        jsonObj.put("dec", this.dec);
        jsonObj.put("dpart", this.dpart);
        jsonObj.put("stphr", this.stphr);
        jsonObj.put("janhr", this.janhr);
        jsonObj.put("urdat", this.urdat);
        jsonObj.put("ksdat", this.ksdat);
        jsonObj.put("deccd", this.deccd);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        return rtnStr;
    }

}

