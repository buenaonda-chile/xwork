package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 서열형 HOST UP CHECK LIST 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class OrderHostUpCheckListDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143746L;
    
 
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
 
    
    private String selchk;  
    private String comps;
    private String hmckmcchk; 
    private String dumym;   
    private String pyvnd;   
    private String dumcb;   
    private String gubcd;   
    private String cusnm;   
    private String dfacd;   
    private String dmkcr;   
    private String dsecd;   
    private String dseno;   
    private String cprtn;   
    private String pspno;   
    private String itdsc;   
    private String oemjg;   
    private String sane;    
    private String sawe;    
    private String mohtq;   
    private String culjis;  
    private String trimd;   
    private String pbsqy;   
    private String patqy;   
    private String wbsqy;   
    private String pbs;		
	private String d0t01;   
	private String d0t02;   
	private String d0t03;   
	private String d0t04;   
	private String d0t05;   
	private String d0t06;   
	private String d0t07;   
	private String d0t08;   
	private String d0t09;   
	private String d0t10;   
	private String d0tqy;   
	private String d1t01;   
	private String d1t02;   
	private String d1t03;   
	private String d1t04;   
	private String d1t05;   
	private String d1t06;   
	private String d1t07;   
	private String d1t08;   
	private String d1t09;   
	private String d1t10;   
	private String d1tqy;   
	private String d2t01;   
	private String d2t02;   
	private String d2t03;   
	private String d2t04;   
	private String d2t05;   
	private String d2t06;   
	private String d2t07;   
	private String d2t08;   
	private String d2t09;   
	private String d2t10;   
	private String d2tqy;   
	private String d3t01;   
	private String d3t02;   
	private String d3t03;   
	private String d3t04;   
	private String d3t05;   
	private String d3t06;   
	private String d3t07;   
	private String d3t08;   
	private String d3t09;   
	private String d3t10;   
	private String d3tqy;   
	private String d4t01;   
	private String d4t02;   
	private String d4t03;   
	private String d4t04;   
	private String d4t05;   
	private String d4t06;   
	private String d4t07;   
	private String d4t08;   
	private String d4t09;   
	private String d4t10;   
	private String d4tqy;	
	private String remqy;   
	private String grtot;	
	private String sm0qy;   
	private String jpsqy;   
	private String prtqy;   
	private String ilonjs;    
	private String dat00;   
	private String dat01;   
	private String dat02;   
	private String dat03;   
	private String dat04;   
	private String dat05;   
	private String dat06;   
	private String dat07;   
	private String dat08;   
	private String dat09;   
	private String dat10;   
	private String dat11;   
	private String dat12;	
	private String okqty;   
	private String mitqy;   
	private String prseq;   
	private String miqqy;   
	private String mioqy;	
	private String dtq01;   
	private String dtq02;   
	private String dtq03;   
	private String dtq04;   
	private String dtq05;   
	private String dtq06;   
	private String dtq07;   
	private String dtq08;   
	private String dtq09;   
	private String dtq10;   
	private String dtq11;   
	private String dtq12;   
	private String dtq13;   
	private String dtq14;   
	private String silqty;


	public String getSelchk() {
		return selchk;
	}

	public void setSelchk(String selchk) {
		this.selchk = selchk;
	}

	public String getComps() {
		return comps;
	}

	public void setComps(String comps) {
		this.comps = comps;
	}

	public String getHmckmcchk() {
		return hmckmcchk;
	}

	public void setHmckmcchk(String hmckmcchk) {
		this.hmckmcchk = hmckmcchk;
	}

	public String getDumym() {
		return dumym;
	}

	public void setDumym(String dumym) {
		this.dumym = dumym;
	}

	public String getPyvnd() {
		return pyvnd;
	}

	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}

	public String getDumcb() {
		return dumcb;
	}

	public void setDumcb(String dumcb) {
		this.dumcb = dumcb;
	}

	public String getGubcd() {
		return gubcd;
	}

	public void setGubcd(String gubcd) {
		this.gubcd = gubcd;
	}

	public String getCusnm() {
		return cusnm;
	}

	public void setCusnm(String cusnm) {
		this.cusnm = cusnm;
	}

	public String getDfacd() {
		return dfacd;
	}

	public void setDfacd(String dfacd) {
		this.dfacd = dfacd;
	}

	public String getDmkcr() {
		return dmkcr;
	}

	public void setDmkcr(String dmkcr) {
		this.dmkcr = dmkcr;
	}

	public String getDsecd() {
		return dsecd;
	}

	public void setDsecd(String dsecd) {
		this.dsecd = dsecd;
	}

	public String getDseno() {
		return dseno;
	}

	public void setDseno(String dseno) {
		this.dseno = dseno;
	}

	public String getCprtn() {
		return cprtn;
	}

	public void setCprtn(String cprtn) {
		this.cprtn = cprtn;
	}

	public String getPspno() {
		return pspno;
	}

	public void setPspno(String pspno) {
		this.pspno = pspno;
	}

	public String getItdsc() {
		return itdsc;
	}

	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}

	public String getOemjg() {
		return oemjg;
	}

	public void setOemjg(String oemjg) {
		this.oemjg = oemjg;
	}

	public String getSane() {
		return sane;
	}

	public void setSane(String sane) {
		this.sane = sane;
	}

	public String getSawe() {
		return sawe;
	}

	public void setSawe(String sawe) {
		this.sawe = sawe;
	}

	public String getMohtq() {
		return mohtq;
	}

	public void setMohtq(String mohtq) {
		this.mohtq = mohtq;
	}

	public String getCuljis() {
		return culjis;
	}

	public void setCuljis(String culjis) {
		this.culjis = culjis;
	}

	public String getTrimd() {
		return trimd;
	}

	public void setTrimd(String trimd) {
		this.trimd = trimd;
	}

	public String getPbsqy() {
		return pbsqy;
	}

	public void setPbsqy(String pbsqy) {
		this.pbsqy = pbsqy;
	}

	public String getPatqy() {
		return patqy;
	}

	public void setPatqy(String patqy) {
		this.patqy = patqy;
	}

	public String getWbsqy() {
		return wbsqy;
	}

	public void setWbsqy(String wbsqy) {
		this.wbsqy = wbsqy;
	}

	public String getPbs() {
		return pbs;
	}

	public void setPbs(String pbs) {
		this.pbs = pbs;
	}

	public String getD0t01() {
		return d0t01;
	}

	public void setD0t01(String d0t01) {
		this.d0t01 = d0t01;
	}

	public String getD0t02() {
		return d0t02;
	}

	public void setD0t02(String d0t02) {
		this.d0t02 = d0t02;
	}

	public String getD0t03() {
		return d0t03;
	}

	public void setD0t03(String d0t03) {
		this.d0t03 = d0t03;
	}

	public String getD0t04() {
		return d0t04;
	}

	public void setD0t04(String d0t04) {
		this.d0t04 = d0t04;
	}

	public String getD0t05() {
		return d0t05;
	}

	public void setD0t05(String d0t05) {
		this.d0t05 = d0t05;
	}

	public String getD0t06() {
		return d0t06;
	}

	public void setD0t06(String d0t06) {
		this.d0t06 = d0t06;
	}

	public String getD0t07() {
		return d0t07;
	}

	public void setD0t07(String d0t07) {
		this.d0t07 = d0t07;
	}

	public String getD0t08() {
		return d0t08;
	}

	public void setD0t08(String d0t08) {
		this.d0t08 = d0t08;
	}

	public String getD0t09() {
		return d0t09;
	}

	public void setD0t09(String d0t09) {
		this.d0t09 = d0t09;
	}

	public String getD0t10() {
		return d0t10;
	}

	public void setD0t10(String d0t10) {
		this.d0t10 = d0t10;
	}

	public String getD0tqy() {
		return d0tqy;
	}

	public void setD0tqy(String d0tqy) {
		this.d0tqy = d0tqy;
	}

	public String getD1t01() {
		return d1t01;
	}

	public void setD1t01(String d1t01) {
		this.d1t01 = d1t01;
	}

	public String getD1t02() {
		return d1t02;
	}

	public void setD1t02(String d1t02) {
		this.d1t02 = d1t02;
	}

	public String getD1t03() {
		return d1t03;
	}

	public void setD1t03(String d1t03) {
		this.d1t03 = d1t03;
	}

	public String getD1t04() {
		return d1t04;
	}

	public void setD1t04(String d1t04) {
		this.d1t04 = d1t04;
	}

	public String getD1t05() {
		return d1t05;
	}

	public void setD1t05(String d1t05) {
		this.d1t05 = d1t05;
	}

	public String getD1t06() {
		return d1t06;
	}

	public void setD1t06(String d1t06) {
		this.d1t06 = d1t06;
	}

	public String getD1t07() {
		return d1t07;
	}

	public void setD1t07(String d1t07) {
		this.d1t07 = d1t07;
	}

	public String getD1t08() {
		return d1t08;
	}

	public void setD1t08(String d1t08) {
		this.d1t08 = d1t08;
	}

	public String getD1t09() {
		return d1t09;
	}

	public void setD1t09(String d1t09) {
		this.d1t09 = d1t09;
	}

	public String getD1t10() {
		return d1t10;
	}

	public void setD1t10(String d1t10) {
		this.d1t10 = d1t10;
	}

	public String getD1tqy() {
		return d1tqy;
	}

	public void setD1tqy(String d1tqy) {
		this.d1tqy = d1tqy;
	}

	public String getD2t01() {
		return d2t01;
	}

	public void setD2t01(String d2t01) {
		this.d2t01 = d2t01;
	}

	public String getD2t02() {
		return d2t02;
	}

	public void setD2t02(String d2t02) {
		this.d2t02 = d2t02;
	}

	public String getD2t03() {
		return d2t03;
	}

	public void setD2t03(String d2t03) {
		this.d2t03 = d2t03;
	}

	public String getD2t04() {
		return d2t04;
	}

	public void setD2t04(String d2t04) {
		this.d2t04 = d2t04;
	}

	public String getD2t05() {
		return d2t05;
	}

	public void setD2t05(String d2t05) {
		this.d2t05 = d2t05;
	}

	public String getD2t06() {
		return d2t06;
	}

	public void setD2t06(String d2t06) {
		this.d2t06 = d2t06;
	}

	public String getD2t07() {
		return d2t07;
	}

	public void setD2t07(String d2t07) {
		this.d2t07 = d2t07;
	}

	public String getD2t08() {
		return d2t08;
	}

	public void setD2t08(String d2t08) {
		this.d2t08 = d2t08;
	}

	public String getD2t09() {
		return d2t09;
	}

	public void setD2t09(String d2t09) {
		this.d2t09 = d2t09;
	}

	public String getD2t10() {
		return d2t10;
	}

	public void setD2t10(String d2t10) {
		this.d2t10 = d2t10;
	}

	public String getD2tqy() {
		return d2tqy;
	}

	public void setD2tqy(String d2tqy) {
		this.d2tqy = d2tqy;
	}

	public String getD3t01() {
		return d3t01;
	}

	public void setD3t01(String d3t01) {
		this.d3t01 = d3t01;
	}

	public String getD3t02() {
		return d3t02;
	}

	public void setD3t02(String d3t02) {
		this.d3t02 = d3t02;
	}

	public String getD3t03() {
		return d3t03;
	}

	public void setD3t03(String d3t03) {
		this.d3t03 = d3t03;
	}

	public String getD3t04() {
		return d3t04;
	}

	public void setD3t04(String d3t04) {
		this.d3t04 = d3t04;
	}

	public String getD3t05() {
		return d3t05;
	}

	public void setD3t05(String d3t05) {
		this.d3t05 = d3t05;
	}

	public String getD3t06() {
		return d3t06;
	}

	public void setD3t06(String d3t06) {
		this.d3t06 = d3t06;
	}

	public String getD3t07() {
		return d3t07;
	}

	public void setD3t07(String d3t07) {
		this.d3t07 = d3t07;
	}

	public String getD3t08() {
		return d3t08;
	}

	public void setD3t08(String d3t08) {
		this.d3t08 = d3t08;
	}

	public String getD3t09() {
		return d3t09;
	}

	public void setD3t09(String d3t09) {
		this.d3t09 = d3t09;
	}

	public String getD3t10() {
		return d3t10;
	}

	public void setD3t10(String d3t10) {
		this.d3t10 = d3t10;
	}

	public String getD3tqy() {
		return d3tqy;
	}

	public void setD3tqy(String d3tqy) {
		this.d3tqy = d3tqy;
	}

	public String getD4t01() {
		return d4t01;
	}

	public void setD4t01(String d4t01) {
		this.d4t01 = d4t01;
	}

	public String getD4t02() {
		return d4t02;
	}

	public void setD4t02(String d4t02) {
		this.d4t02 = d4t02;
	}

	public String getD4t03() {
		return d4t03;
	}

	public void setD4t03(String d4t03) {
		this.d4t03 = d4t03;
	}

	public String getD4t04() {
		return d4t04;
	}

	public void setD4t04(String d4t04) {
		this.d4t04 = d4t04;
	}

	public String getD4t05() {
		return d4t05;
	}

	public void setD4t05(String d4t05) {
		this.d4t05 = d4t05;
	}

	public String getD4t06() {
		return d4t06;
	}

	public void setD4t06(String d4t06) {
		this.d4t06 = d4t06;
	}

	public String getD4t07() {
		return d4t07;
	}

	public void setD4t07(String d4t07) {
		this.d4t07 = d4t07;
	}

	public String getD4t08() {
		return d4t08;
	}

	public void setD4t08(String d4t08) {
		this.d4t08 = d4t08;
	}

	public String getD4t09() {
		return d4t09;
	}

	public void setD4t09(String d4t09) {
		this.d4t09 = d4t09;
	}

	public String getD4t10() {
		return d4t10;
	}

	public void setD4t10(String d4t10) {
		this.d4t10 = d4t10;
	}

	public String getD4tqy() {
		return d4tqy;
	}

	public void setD4tqy(String d4tqy) {
		this.d4tqy = d4tqy;
	}

	public String getRemqy() {
		return remqy;
	}

	public void setRemqy(String remqy) {
		this.remqy = remqy;
	}

	public String getGrtot() {
		return grtot;
	}

	public void setGrtot(String grtot) {
		this.grtot = grtot;
	}

	public String getSm0qy() {
		return sm0qy;
	}

	public void setSm0qy(String sm0qy) {
		this.sm0qy = sm0qy;
	}

	public String getJpsqy() {
		return jpsqy;
	}

	public void setJpsqy(String jpsqy) {
		this.jpsqy = jpsqy;
	}

	public String getPrtqy() {
		return prtqy;
	}

	public void setPrtqy(String prtqy) {
		this.prtqy = prtqy;
	}

	public String getIlonjs() {
		return ilonjs;
	}

	public void setIlonjs(String ilonjs) {
		this.ilonjs = ilonjs;
	}

	public String getDat00() {
		return dat00;
	}

	public void setDat00(String dat00) {
		this.dat00 = dat00;
	}

	public String getDat01() {
		return dat01;
	}

	public void setDat01(String dat01) {
		this.dat01 = dat01;
	}

	public String getDat02() {
		return dat02;
	}

	public void setDat02(String dat02) {
		this.dat02 = dat02;
	}

	public String getDat03() {
		return dat03;
	}

	public void setDat03(String dat03) {
		this.dat03 = dat03;
	}

	public String getDat04() {
		return dat04;
	}

	public void setDat04(String dat04) {
		this.dat04 = dat04;
	}

	public String getDat05() {
		return dat05;
	}

	public void setDat05(String dat05) {
		this.dat05 = dat05;
	}

	public String getDat06() {
		return dat06;
	}

	public void setDat06(String dat06) {
		this.dat06 = dat06;
	}

	public String getDat07() {
		return dat07;
	}

	public void setDat07(String dat07) {
		this.dat07 = dat07;
	}

	public String getDat08() {
		return dat08;
	}

	public void setDat08(String dat08) {
		this.dat08 = dat08;
	}

	public String getDat09() {
		return dat09;
	}

	public void setDat09(String dat09) {
		this.dat09 = dat09;
	}

	public String getDat10() {
		return dat10;
	}

	public void setDat10(String dat10) {
		this.dat10 = dat10;
	}

	public String getDat11() {
		return dat11;
	}

	public void setDat11(String dat11) {
		this.dat11 = dat11;
	}

	public String getDat12() {
		return dat12;
	}

	public void setDat12(String dat12) {
		this.dat12 = dat12;
	}

	public String getOkqty() {
		return okqty;
	}

	public void setOkqty(String okqty) {
		this.okqty = okqty;
	}

	public String getMitqy() {
		return mitqy;
	}

	public void setMitqy(String mitqy) {
		this.mitqy = mitqy;
	}

	public String getPrseq() {
		return prseq;
	}

	public void setPrseq(String prseq) {
		this.prseq = prseq;
	}

	public String getMiqqy() {
		return miqqy;
	}

	public void setMiqqy(String miqqy) {
		this.miqqy = miqqy;
	}

	public String getMioqy() {
		return mioqy;
	}

	public void setMioqy(String mioqy) {
		this.mioqy = mioqy;
	}

	public String getDtq01() {
		return dtq01;
	}

	public void setDtq01(String dtq01) {
		this.dtq01 = dtq01;
	}

	public String getDtq02() {
		return dtq02;
	}

	public void setDtq02(String dtq02) {
		this.dtq02 = dtq02;
	}

	public String getDtq03() {
		return dtq03;
	}

	public void setDtq03(String dtq03) {
		this.dtq03 = dtq03;
	}

	public String getDtq04() {
		return dtq04;
	}

	public void setDtq04(String dtq04) {
		this.dtq04 = dtq04;
	}

	public String getDtq05() {
		return dtq05;
	}

	public void setDtq05(String dtq05) {
		this.dtq05 = dtq05;
	}

	public String getDtq06() {
		return dtq06;
	}

	public void setDtq06(String dtq06) {
		this.dtq06 = dtq06;
	}

	public String getDtq07() {
		return dtq07;
	}

	public void setDtq07(String dtq07) {
		this.dtq07 = dtq07;
	}

	public String getDtq08() {
		return dtq08;
	}

	public void setDtq08(String dtq08) {
		this.dtq08 = dtq08;
	}

	public String getDtq09() {
		return dtq09;
	}

	public void setDtq09(String dtq09) {
		this.dtq09 = dtq09;
	}

	public String getDtq10() {
		return dtq10;
	}

	public void setDtq10(String dtq10) {
		this.dtq10 = dtq10;
	}

	public String getDtq11() {
		return dtq11;
	}

	public void setDtq11(String dtq11) {
		this.dtq11 = dtq11;
	}

	public String getDtq12() {
		return dtq12;
	}

	public void setDtq12(String dtq12) {
		this.dtq12 = dtq12;
	}

	public String getDtq13() {
		return dtq13;
	}

	public void setDtq13(String dtq13) {
		this.dtq13 = dtq13;
	}

	public String getDtq14() {
		return dtq14;
	}

	public void setDtq14(String dtq14) {
		this.dtq14 = dtq14;
	}

	public String getSilqty() {
		return silqty;
	}

	public void setSilqty(String silqty) {
		this.silqty = silqty;
	}
	
	

	private String dtt01;   
	private String dtt02;   
	private String dtt03;   
	private String dtt04;   
	private String dtt05;   
	private String dtt06;   
	private String dtt07;   
	private String dtt08;   
	private String dtt09;   
	private String dtt10;

    public String getDtt01() {
		return dtt01;
	}

	public void setDtt01(String dtt01) {
		this.dtt01 = dtt01;
	}

	public String getDtt02() {
		return dtt02;
	}

	public void setDtt02(String dtt02) {
		this.dtt02 = dtt02;
	}

	public String getDtt03() {
		return dtt03;
	}

	public void setDtt03(String dtt03) {
		this.dtt03 = dtt03;
	}

	public String getDtt04() {
		return dtt04;
	}

	public void setDtt04(String dtt04) {
		this.dtt04 = dtt04;
	}

	public String getDtt05() {
		return dtt05;
	}

	public void setDtt05(String dtt05) {
		this.dtt05 = dtt05;
	}

	public String getDtt06() {
		return dtt06;
	}

	public void setDtt06(String dtt06) {
		this.dtt06 = dtt06;
	}

	public String getDtt07() {
		return dtt07;
	}

	public void setDtt07(String dtt07) {
		this.dtt07 = dtt07;
	}

	public String getDtt08() {
		return dtt08;
	}

	public void setDtt08(String dtt08) {
		this.dtt08 = dtt08;
	}

	public String getDtt09() {
		return dtt09;
	}

	public void setDtt09(String dtt09) {
		this.dtt09 = dtt09;
	}

	public String getDtt10() {
		return dtt10;
	}

	public void setDtt10(String dtt10) {
		this.dtt10 = dtt10;
	}

	
	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        
        jsonObj.put("comps", this.comps);   
        jsonObj.put("dumym", this.dumym);   
        jsonObj.put("pyvnd", this.pyvnd);   
        jsonObj.put("dumcb", this.dumcb);   
        jsonObj.put("gubcd", this.gubcd);   
        jsonObj.put("cusnm", this.cusnm);   
        jsonObj.put("dfacd", this.dfacd);   
        jsonObj.put("dmkcr", this.dmkcr);   
        jsonObj.put("dsecd", this.dsecd);   
        jsonObj.put("dseno", this.dseno);   
        jsonObj.put("cprtn", this.cprtn);   
        jsonObj.put("pspno", this.pspno);   
        jsonObj.put("itdsc", this.itdsc);   
        jsonObj.put("oemjg", this.oemjg);   
        jsonObj.put("sane", this.sane);    
        jsonObj.put("sawe", this.sawe);    
        jsonObj.put("mohtq", this.mohtq);   
        jsonObj.put("culjis", this.culjis);  
        jsonObj.put("trimd", this.trimd);   
        jsonObj.put("pbsqy", this.pbsqy);   
        jsonObj.put("patqy", this.patqy);   
        jsonObj.put("wbsqy", this.wbsqy);   
        jsonObj.put("pbs", this.pbs);		
    	jsonObj.put("d0t01", this.d0t01);   
    	jsonObj.put("d0t02", this.d0t02);   
    	jsonObj.put("d0t03", this.d0t03);   
    	jsonObj.put("d0t04", this.d0t04);   
    	jsonObj.put("d0t05", this.d0t05);   
    	jsonObj.put("d0t06", this.d0t06);   
    	jsonObj.put("d0t07", this.d0t07);   
    	jsonObj.put("d0t08", this.d0t08);   
    	jsonObj.put("d0t09", this.d0t09);   
    	jsonObj.put("d0t10", this.d0t10);   
    	jsonObj.put("d0tqy", this.d0tqy);   
    	jsonObj.put("d1t01", this.d1t01);   
    	jsonObj.put("d1t02", this.d1t02);   
    	jsonObj.put("d1t03", this.d1t03);   
    	jsonObj.put("d1t04", this.d1t04);   
    	jsonObj.put("d1t05", this.d1t05);   
    	jsonObj.put("d1t06", this.d1t06);   
    	jsonObj.put("d1t07", this.d1t07);   
    	jsonObj.put("d1t08", this.d1t08);   
    	jsonObj.put("d1t09", this.d1t09);   
    	jsonObj.put("d1t10", this.d1t10);   
    	jsonObj.put("d1tqy", this.d1tqy);   
    	jsonObj.put("d2t01", this.d2t01);   
    	jsonObj.put("d2t02", this.d2t02);   
    	jsonObj.put("d2t03", this.d2t03);   
    	jsonObj.put("d2t04", this.d2t04);   
    	jsonObj.put("d2t05", this.d2t05);   
    	jsonObj.put("d2t06", this.d2t06);   
    	jsonObj.put("d2t07", this.d2t07);   
    	jsonObj.put("d2t08", this.d2t08);   
    	jsonObj.put("d2t09", this.d2t09);   
    	jsonObj.put("d2t10", this.d2t10);   
    	jsonObj.put("d2tqy", this.d2tqy);   
    	jsonObj.put("d3t01", this.d3t01);   
    	jsonObj.put("d3t02", this.d3t02);   
    	jsonObj.put("d3t03", this.d3t03);   
    	jsonObj.put("d3t04", this.d3t04);   
    	jsonObj.put("d3t05", this.d3t05);   
    	jsonObj.put("d3t06", this.d3t06);   
    	jsonObj.put("d3t07", this.d3t07);   
    	jsonObj.put("d3t08", this.d3t08);   
    	jsonObj.put("d3t09", this.d3t09);   
    	jsonObj.put("d3t10", this.d3t10);   
    	jsonObj.put("d3tqy", this.d3tqy);   
    	jsonObj.put("d4t01", this.d4t01);   
    	jsonObj.put("d4t02", this.d4t02);   
    	jsonObj.put("d4t03", this.d4t03);   
    	jsonObj.put("d4t04", this.d4t04);   
    	jsonObj.put("d4t05", this.d4t05);   
    	jsonObj.put("d4t06", this.d4t06);   
    	jsonObj.put("d4t07", this.d4t07);   
    	jsonObj.put("d4t08", this.d4t08);   
    	jsonObj.put("d4t09", this.d4t09);   
    	jsonObj.put("d4t10", this.d4t10);   
    	jsonObj.put("d4tqy", this.d4tqy);	
    	jsonObj.put("remqy", this.remqy);   
    	jsonObj.put("grtot", this.grtot);	
    	jsonObj.put("sm0qy", this.sm0qy);   
    	jsonObj.put("jpsqy", this.jpsqy);   
    	jsonObj.put("prtqy", this.prtqy);   
    	jsonObj.put("ilonjs", this.ilonjs);    
    	jsonObj.put("dat00", this.dat00);   
    	jsonObj.put("dat01", this.dat01);   
    	jsonObj.put("dat02", this.dat02);   
    	jsonObj.put("dat03", this.dat03);   
    	jsonObj.put("dat04", this.dat04);   
    	jsonObj.put("dat05", this.dat05);   
    	jsonObj.put("dat06", this.dat06);   
    	jsonObj.put("dat07", this.dat07);   
    	jsonObj.put("dat08", this.dat08);   
    	jsonObj.put("dat09", this.dat09);   
    	jsonObj.put("dat10", this.dat10);   
    	jsonObj.put("dat11", this.dat11);   
    	jsonObj.put("dat12", this.dat12);	
    	jsonObj.put("okqty", this.okqty);   
    	jsonObj.put("mitqy", this.mitqy);   
    	jsonObj.put("prseq", this.prseq);   
    	jsonObj.put("miqqy", this.miqqy);   
    	jsonObj.put("mioqy", this.mioqy);	
    	jsonObj.put("dtq01", this.dtq01);   
    	jsonObj.put("dtq02", this.dtq02);   
    	jsonObj.put("dtq03", this.dtq03);   
    	jsonObj.put("dtq04", this.dtq04);   
    	jsonObj.put("dtq05", this.dtq05);   
    	jsonObj.put("dtq06", this.dtq06);   
    	jsonObj.put("dtq07", this.dtq07);   
    	jsonObj.put("dtq08", this.dtq08);   
    	jsonObj.put("dtq09", this.dtq09);   
    	jsonObj.put("dtq10", this.dtq10);   
    	jsonObj.put("dtq11", this.dtq11);   
    	jsonObj.put("dtq12", this.dtq12);   
    	jsonObj.put("dtq13", this.dtq13);   
    	jsonObj.put("dtq14", this.dtq14);   
    	jsonObj.put("silqty", this.silqty);
    	
    	jsonObj.put("dtt01", this.dtt01);   
    	jsonObj.put("dtt02", this.dtt02);   
    	jsonObj.put("dtt03", this.dtt03);   
    	jsonObj.put("dtt04", this.dtt04);   
    	jsonObj.put("dtt05", this.dtt05);   
    	jsonObj.put("dtt06", this.dtt06);   
    	jsonObj.put("dtt07", this.dtt07);   
    	jsonObj.put("dtt08", this.dtt08);   
    	jsonObj.put("dtt09", this.dtt09);   
    	jsonObj.put("dtt10", this.dtt10);   
    	
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }  
}