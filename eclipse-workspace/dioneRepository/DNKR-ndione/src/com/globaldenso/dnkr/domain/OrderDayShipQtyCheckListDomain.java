package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 서열형 일일출하및수주량 CHECK LIST 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class OrderDayShipQtyCheckListDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143747L;
    
 
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
    private String gcomps;
    private String comps;    
    private String majcd;        
    private String majcd_h;        
    private String mjchr;
    private String majmk;
	private String house;
	private String pyvnd1;
	private String pyvnd2;
	private String chldt;
	private String cusnm;
	private String faccd;
	private String seycd;
	private String mkcar;
	private String mkpno;
	private String pspno;
	private String itmnm;
	private String makqy;
	private String pspqy;
	private String suyqy;
	private String cllq1;
	private String cllbox1;
	private String clpq1;	
	private String cllq2;
	private String cllbox2;
	private String clpq2;	
	private String junqy;
	private String notqy;
	private String trimd;
	private String pbsqy;
	private String datq0;
	private String dat11;
	private String dat12;
	private String dat21;
	private String dat22;
	private String dat31;
	private String dat32;
	private String dat41;
	private String dat42;
	private String dat51;
	private String dat52;
	private String dat61;
	private String dat62;
	private String datqy;
	private String plqty;
	private String boxq1;
	private String boxq2;
	private String dapq0;
	private String dap11;
	private String dap12;
	private String dap21;
	private String dap22;
	private String dap31;
	private String dap32;
	private String dap41;
	private String dap42;
	private String dap51;
	private String dap52;
	private String dap61;
	private String dap62;
	private String slqty;
	private String sujq0;
	private String sujq1;
	private String sujq2;
	private String sujq3;
	private String sujq4;
	private String sujq5;
	private String sujq6;
	private String sujq7;
	private String sujq8;
	private String sujq9;
	private String sujq10;
	private String sujq11;
	private String sujq12;
	private String sujqy;
	private String dalpr;
	private String trimds;
	private String pbsqys;
	private String datq0s;
	private String dat11s;
	private String dat12s;
	private String dat21s;
	private String dat22s;
	private String dat31s;
	private String dat32s;
	private String dat41s;
	private String dat42s;
	private String dat51s;
	private String dat52s;
	private String dat61s;
	private String dat62s;
	private String datqys;
	private String dapq0s;
	private String dap11s;
	private String dap12s;
	private String dap21s;
	private String dap22s;
	private String dap31s;
	private String dap32s;
	private String dap41s;
	private String dap42s;
	private String dap51s;
	private String dap52s;
	private String dap61s;
	private String dap62s;
	private String sujq0s;
	private String sujq1s;
	private String sujq2s;
	private String sujq3s;
	private String sujq4s;
	private String sujq5s;
	private String sujq6s;
	private String sujq7s;
	private String sujq8s;
	private String sujq9s;
	private String sujq10s;
	private String sujq11s;
	private String sujq12s;
	private String sujqys;
	private String trimdt;
	private String pbsqyt;
	private String datq0t;
	private String datq1t;
	private String datq2t;
	private String datq3t;
	private String datq4t;
	private String datq5t;
	private String datq6t;
	private String datq7t;
	private String datq8t;
	private String datq9t;
	private String datqat;
	private String datqbt;
	private String datqct;
	private String errcd;
	private String errnm;
	private String pyvnd;
	private String makdt;
	private String makmk;
	private String clhcd;
	private String prcdt;
	private String chkdt;
	private int chkcnt;
	private String stddt;		
	
	public String getSelchk() {
		return selchk;
	}

	public void setSelchk(String selchk) {
		this.selchk = selchk;
	}
	
	public String getGcomps() {
		return gcomps;
	}

	public void setGcomps(String gcomps) {
		this.gcomps = gcomps;
	}

	public String getComps() {
		return comps;
	}

	public void setComps(String comps) {
		this.comps = comps;
	}

	public String getMajcd() {
		return majcd;
	}

	public void setMajcd(String majcd) {
		this.majcd = majcd;
	}

	public String getMajcd_h() {
		return majcd_h;
	}

	public void setMajcd_h(String majcd_h) {
		this.majcd_h = majcd_h;
	}

	public String getMjchr() {
		return mjchr;
	}

	public void setMjchr(String mjchr) {
		this.mjchr = mjchr;
	}

	public String getMajmk() {
		return majmk;
	}

	public void setMajmk(String majmk) {
		this.majmk = majmk;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getPyvnd1() {
		return pyvnd1;
	}

	public void setPyvnd1(String pyvnd1) {
		this.pyvnd1 = pyvnd1;
	}

	public String getPyvnd2() {
		return pyvnd2;
	}

	public void setPyvnd2(String pyvnd2) {
		this.pyvnd2 = pyvnd2;
	}

	public String getChldt() {
		return chldt;
	}

	public void setChldt(String chldt) {
		this.chldt = chldt;
	}

	public String getCusnm() {
		return cusnm;
	}

	public void setCusnm(String cusnm) {
		this.cusnm = cusnm;
	}

	public String getFaccd() {
		return faccd;
	}

	public void setFaccd(String faccd) {
		this.faccd = faccd;
	}

	public String getSeycd() {
		return seycd;
	}

	public void setSeycd(String seycd) {
		this.seycd = seycd;
	}

	public String getMkcar() {
		return mkcar;
	}

	public void setMkcar(String mkcar) {
		this.mkcar = mkcar;
	}

	public String getMkpno() {
		return mkpno;
	}

	public void setMkpno(String mkpno) {
		this.mkpno = mkpno;
	}

	public String getPspno() {
		return pspno;
	}

	public void setPspno(String pspno) {
		this.pspno = pspno;
	}

	public String getItmnm() {
		return itmnm;
	}

	public void setItmnm(String itmnm) {
		this.itmnm = itmnm;
	}

	public String getMakqy() {
		return makqy;
	}

	public void setMakqy(String makqy) {
		this.makqy = makqy;
	}

	public String getPspqy() {
		return pspqy;
	}

	public void setPspqy(String pspqy) {
		this.pspqy = pspqy;
	}

	public String getSuyqy() {
		return suyqy;
	}

	public void setSuyqy(String suyqy) {
		this.suyqy = suyqy;
	}

	public String getCllq1() {
		return cllq1;
	}

	public void setCllq1(String cllq1) {
		this.cllq1 = cllq1;
	}

	public String getCllbox1() {
		return cllbox1;
	}

	public void setCllbox1(String cllbox1) {
		this.cllbox1 = cllbox1;
	}
	
	public String getClpq1() {
		return clpq1;
	}

	public void setClpq1(String clpq1) {
		this.clpq1 = clpq1;
	}

	public String getCllq2() {
		return cllq2;
	}

	public String getCllbox2() {
		return cllbox2;
	}

	public void setCllbox2(String cllbox2) {
		this.cllbox2 = cllbox2;
	}
	
	public void setCllq2(String cllq2) {
		this.cllq2 = cllq2;
	}
	
	public String getClpq2() {
		return clpq2;
	}

	public void setClpq2(String clpq2) {
		this.clpq2 = clpq2;
	}

	public String getJunqy() {
		return junqy;
	}

	public void setJunqy(String junqy) {
		this.junqy = junqy;
	}

	public String getNotqy() {
		return notqy;
	}

	public void setNotqy(String notqy) {
		this.notqy = notqy;
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

	public String getDatq0() {
		return datq0;
	}

	public void setDatq0(String datq0) {
		this.datq0 = datq0;
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

	public String getDat21() {
		return dat21;
	}

	public void setDat21(String dat21) {
		this.dat21 = dat21;
	}

	public String getDat22() {
		return dat22;
	}

	public void setDat22(String dat22) {
		this.dat22 = dat22;
	}

	public String getDat31() {
		return dat31;
	}

	public void setDat31(String dat31) {
		this.dat31 = dat31;
	}

	public String getDat32() {
		return dat32;
	}

	public void setDat32(String dat32) {
		this.dat32 = dat32;
	}

	public String getDat41() {
		return dat41;
	}

	public void setDat41(String dat41) {
		this.dat41 = dat41;
	}

	public String getDat42() {
		return dat42;
	}

	public void setDat42(String dat42) {
		this.dat42 = dat42;
	}

	public String getDat51() {
		return dat51;
	}

	public void setDat51(String dat51) {
		this.dat51 = dat51;
	}

	public String getDat52() {
		return dat52;
	}

	public void setDat52(String dat52) {
		this.dat52 = dat52;
	}

	public String getDat61() {
		return dat61;
	}

	public void setDat61(String dat61) {
		this.dat61 = dat61;
	}

	public String getDat62() {
		return dat62;
	}

	public void setDat62(String dat62) {
		this.dat62 = dat62;
	}

	public String getDatqy() {
		return datqy;
	}

	public void setDatqy(String datqy) {
		this.datqy = datqy;
	}

	public String getPlqty() {
		return plqty;
	}

	public void setPlqty(String plqty) {
		this.plqty = plqty;
	}

	public String getBoxq1() {
		return boxq1;
	}

	public void setBoxq1(String boxq1) {
		this.boxq1 = boxq1;
	}

	public String getBoxq2() {
		return boxq2;
	}

	public void setBoxq2(String boxq2) {
		this.boxq2 = boxq2;
	}

	public String getDapq0() {
		return dapq0;
	}

	public void setDapq0(String dapq0) {
		this.dapq0 = dapq0;
	}

	public String getDap11() {
		return dap11;
	}

	public void setDap11(String dap11) {
		this.dap11 = dap11;
	}

	public String getDap12() {
		return dap12;
	}

	public void setDap12(String dap12) {
		this.dap12 = dap12;
	}

	public String getDap21() {
		return dap21;
	}

	public void setDap21(String dap21) {
		this.dap21 = dap21;
	}

	public String getDap22() {
		return dap22;
	}

	public void setDap22(String dap22) {
		this.dap22 = dap22;
	}

	public String getDap31() {
		return dap31;
	}

	public void setDap31(String dap31) {
		this.dap31 = dap31;
	}

	public String getDap32() {
		return dap32;
	}

	public void setDap32(String dap32) {
		this.dap32 = dap32;
	}

	public String getDap41() {
		return dap41;
	}

	public void setDap41(String dap41) {
		this.dap41 = dap41;
	}

	public String getDap42() {
		return dap42;
	}

	public void setDap42(String dap42) {
		this.dap42 = dap42;
	}

	public String getDap51() {
		return dap51;
	}

	public void setDap51(String dap51) {
		this.dap51 = dap51;
	}

	public String getDap52() {
		return dap52;
	}

	public void setDap52(String dap52) {
		this.dap52 = dap52;
	}

	public String getDap61() {
		return dap61;
	}

	public void setDap61(String dap61) {
		this.dap61 = dap61;
	}

	public String getDap62() {
		return dap62;
	}

	public void setDap62(String dap62) {
		this.dap62 = dap62;
	}

	public String getSlqty() {
		return slqty;
	}

	public void setSlqty(String slqty) {
		this.slqty = slqty;
	}

	public String getSujq0() {
		return sujq0;
	}

	public void setSujq0(String sujq0) {
		this.sujq0 = sujq0;
	}

	public String getSujq1() {
		return sujq1;
	}

	public void setSujq1(String sujq1) {
		this.sujq1 = sujq1;
	}

	public String getSujq2() {
		return sujq2;
	}

	public void setSujq2(String sujq2) {
		this.sujq2 = sujq2;
	}

	public String getSujq3() {
		return sujq3;
	}

	public void setSujq3(String sujq3) {
		this.sujq3 = sujq3;
	}

	public String getSujq4() {
		return sujq4;
	}

	public void setSujq4(String sujq4) {
		this.sujq4 = sujq4;
	}

	public String getSujq5() {
		return sujq5;
	}

	public void setSujq5(String sujq5) {
		this.sujq5 = sujq5;
	}

	public String getSujq6() {
		return sujq6;
	}

	public void setSujq6(String sujq6) {
		this.sujq6 = sujq6;
	}

	public String getSujq7() {
		return sujq7;
	}

	public void setSujq7(String sujq7) {
		this.sujq7 = sujq7;
	}

	public String getSujq8() {
		return sujq8;
	}

	public void setSujq8(String sujq8) {
		this.sujq8 = sujq8;
	}

	public String getSujq9() {
		return sujq9;
	}

	public void setSujq9(String sujq9) {
		this.sujq9 = sujq9;
	}

	public String getSujq10() {
		return sujq10;
	}

	public void setSujq10(String sujq10) {
		this.sujq10 = sujq10;
	}

	public String getSujq11() {
		return sujq11;
	}

	public void setSujq11(String sujq11) {
		this.sujq11 = sujq11;
	}

	public String getSujq12() {
		return sujq12;
	}

	public void setSujq12(String sujq12) {
		this.sujq12 = sujq12;
	}

	public String getSujqy() {
		return sujqy;
	}

	public void setSujqy(String sujqy) {
		this.sujqy = sujqy;
	}

	public String getDalpr() {
		return dalpr;
	}

	public void setDalpr(String dalpr) {
		this.dalpr = dalpr;
	}

	public String getTrimds() {
		return trimds;
	}

	public void setTrimds(String trimds) {
		this.trimds = trimds;
	}

	public String getPbsqys() {
		return pbsqys;
	}

	public void setPbsqys(String pbsqys) {
		this.pbsqys = pbsqys;
	}

	public String getDatq0s() {
		return datq0s;
	}

	public void setDatq0s(String datq0s) {
		this.datq0s = datq0s;
	}

	public String getDat11s() {
		return dat11s;
	}

	public void setDat11s(String dat11s) {
		this.dat11s = dat11s;
	}

	public String getDat12s() {
		return dat12s;
	}

	public void setDat12s(String dat12s) {
		this.dat12s = dat12s;
	}

	public String getDat21s() {
		return dat21s;
	}

	public void setDat21s(String dat21s) {
		this.dat21s = dat21s;
	}

	public String getDat22s() {
		return dat22s;
	}

	public void setDat22s(String dat22s) {
		this.dat22s = dat22s;
	}

	public String getDat31s() {
		return dat31s;
	}

	public void setDat31s(String dat31s) {
		this.dat31s = dat31s;
	}

	public String getDat32s() {
		return dat32s;
	}

	public void setDat32s(String dat32s) {
		this.dat32s = dat32s;
	}

	public String getDat41s() {
		return dat41s;
	}

	public void setDat41s(String dat41s) {
		this.dat41s = dat41s;
	}

	public String getDat42s() {
		return dat42s;
	}

	public void setDat42s(String dat42s) {
		this.dat42s = dat42s;
	}

	public String getDat51s() {
		return dat51s;
	}

	public void setDat51s(String dat51s) {
		this.dat51s = dat51s;
	}

	public String getDat52s() {
		return dat52s;
	}

	public void setDat52s(String dat52s) {
		this.dat52s = dat52s;
	}

	public String getDat61s() {
		return dat61s;
	}

	public void setDat61s(String dat61s) {
		this.dat61s = dat61s;
	}

	public String getDat62s() {
		return dat62s;
	}

	public void setDat62s(String dat62s) {
		this.dat62s = dat62s;
	}

	public String getDatqys() {
		return datqys;
	}

	public void setDatqys(String datqys) {
		this.datqys = datqys;
	}

	public String getDapq0s() {
		return dapq0s;
	}

	public void setDapq0s(String dapq0s) {
		this.dapq0s = dapq0s;
	}

	public String getDap11s() {
		return dap11s;
	}

	public void setDap11s(String dap11s) {
		this.dap11s = dap11s;
	}

	public String getDap12s() {
		return dap12s;
	}

	public void setDap12s(String dap12s) {
		this.dap12s = dap12s;
	}

	public String getDap21s() {
		return dap21s;
	}

	public void setDap21s(String dap21s) {
		this.dap21s = dap21s;
	}

	public String getDap22s() {
		return dap22s;
	}

	public void setDap22s(String dap22s) {
		this.dap22s = dap22s;
	}

	public String getDap31s() {
		return dap31s;
	}

	public void setDap31s(String dap31s) {
		this.dap31s = dap31s;
	}

	public String getDap32s() {
		return dap32s;
	}

	public void setDap32s(String dap32s) {
		this.dap32s = dap32s;
	}

	public String getDap41s() {
		return dap41s;
	}

	public void setDap41s(String dap41s) {
		this.dap41s = dap41s;
	}

	public String getDap42s() {
		return dap42s;
	}

	public void setDap42s(String dap42s) {
		this.dap42s = dap42s;
	}

	public String getDap51s() {
		return dap51s;
	}

	public void setDap51s(String dap51s) {
		this.dap51s = dap51s;
	}

	public String getDap52s() {
		return dap52s;
	}

	public void setDap52s(String dap52s) {
		this.dap52s = dap52s;
	}

	public String getDap61s() {
		return dap61s;
	}

	public void setDap61s(String dap61s) {
		this.dap61s = dap61s;
	}

	public String getDap62s() {
		return dap62s;
	}

	public void setDap62s(String dap62s) {
		this.dap62s = dap62s;
	}

	public String getSujq0s() {
		return sujq0s;
	}

	public void setSujq0s(String sujq0s) {
		this.sujq0s = sujq0s;
	}

	public String getSujq1s() {
		return sujq1s;
	}

	public void setSujq1s(String sujq1s) {
		this.sujq1s = sujq1s;
	}

	public String getSujq2s() {
		return sujq2s;
	}

	public void setSujq2s(String sujq2s) {
		this.sujq2s = sujq2s;
	}

	public String getSujq3s() {
		return sujq3s;
	}

	public void setSujq3s(String sujq3s) {
		this.sujq3s = sujq3s;
	}

	public String getSujq4s() {
		return sujq4s;
	}

	public void setSujq4s(String sujq4s) {
		this.sujq4s = sujq4s;
	}

	public String getSujq5s() {
		return sujq5s;
	}

	public void setSujq5s(String sujq5s) {
		this.sujq5s = sujq5s;
	}

	public String getSujq6s() {
		return sujq6s;
	}

	public void setSujq6s(String sujq6s) {
		this.sujq6s = sujq6s;
	}

	public String getSujq7s() {
		return sujq7s;
	}

	public void setSujq7s(String sujq7s) {
		this.sujq7s = sujq7s;
	}

	public String getSujq8s() {
		return sujq8s;
	}

	public void setSujq8s(String sujq8s) {
		this.sujq8s = sujq8s;
	}

	public String getSujq9s() {
		return sujq9s;
	}

	public void setSujq9s(String sujq9s) {
		this.sujq9s = sujq9s;
	}

	public String getSujq10s() {
		return sujq10s;
	}

	public void setSujq10s(String sujq10s) {
		this.sujq10s = sujq10s;
	}

	public String getSujq11s() {
		return sujq11s;
	}

	public void setSujq11s(String sujq11s) {
		this.sujq11s = sujq11s;
	}

	public String getSujq12s() {
		return sujq12s;
	}

	public void setSujq12s(String sujq12s) {
		this.sujq12s = sujq12s;
	}

	public String getSujqys() {
		return sujqys;
	}

	public void setSujqys(String sujqys) {
		this.sujqys = sujqys;
	}

	public String getTrimdt() {
		return trimdt;
	}

	public void setTrimdt(String trimdt) {
		this.trimdt = trimdt;
	}

	public String getPbsqyt() {
		return pbsqyt;
	}

	public void setPbsqyt(String pbsqyt) {
		this.pbsqyt = pbsqyt;
	}

	public String getDatq0t() {
		return datq0t;
	}

	public void setDatq0t(String datq0t) {
		this.datq0t = datq0t;
	}

	public String getDatq1t() {
		return datq1t;
	}

	public void setDatq1t(String datq1t) {
		this.datq1t = datq1t;
	}

	public String getDatq2t() {
		return datq2t;
	}

	public void setDatq2t(String datq2t) {
		this.datq2t = datq2t;
	}

	public String getDatq3t() {
		return datq3t;
	}

	public void setDatq3t(String datq3t) {
		this.datq3t = datq3t;
	}

	public String getDatq4t() {
		return datq4t;
	}

	public void setDatq4t(String datq4t) {
		this.datq4t = datq4t;
	}

	public String getDatq5t() {
		return datq5t;
	}

	public void setDatq5t(String datq5t) {
		this.datq5t = datq5t;
	}

	public String getDatq6t() {
		return datq6t;
	}

	public void setDatq6t(String datq6t) {
		this.datq6t = datq6t;
	}

	public String getDatq7t() {
		return datq7t;
	}

	public void setDatq7t(String datq7t) {
		this.datq7t = datq7t;
	}

	public String getDatq8t() {
		return datq8t;
	}

	public void setDatq8t(String datq8t) {
		this.datq8t = datq8t;
	}

	public String getDatq9t() {
		return datq9t;
	}

	public void setDatq9t(String datq9t) {
		this.datq9t = datq9t;
	}

	public String getDatqat() {
		return datqat;
	}

	public void setDatqat(String datqat) {
		this.datqat = datqat;
	}

	public String getDatqbt() {
		return datqbt;
	}

	public void setDatqbt(String datqbt) {
		this.datqbt = datqbt;
	}

	public String getDatqct() {
		return datqct;
	}

	public void setDatqct(String datqct) {
		this.datqct = datqct;
	}

	public String getErrcd() {
		return errcd;
	}

	public void setErrcd(String errcd) {
		this.errcd = errcd;
	}

	public String getErrnm() {
		return errnm;
	}

	public void setErrnm(String errnm) {
		this.errnm = errnm;
	}
	
	public String getPyvnd() {
		return pyvnd;
	}

	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}

	public String getMakdt() {
		return makdt;
	}

	public void setMakdt(String makdt) {
		this.makdt = makdt;
	}

	public String getMakmk() {
		return makmk;
	}

	public void setMakmk(String makmk) {
		this.makmk = makmk;
	}

	public String getClhcd() {
		return clhcd;
	}

	public void setClhcd(String clhcd) {
		this.clhcd = clhcd;
	}

	public String getPrcdt() {
		return prcdt;
	}

	public void setPrcdt(String prcdt) {
		this.prcdt = prcdt;
	}

	public String getChkdt() {
		return chkdt;
	}

	public void setChkdt(String chkdt) {
		this.chkdt = chkdt;
	}

	public int getChkcnt() {
		return chkcnt;
	}

	public void setChkcnt(int chkcnt) {
		this.chkcnt = chkcnt;
	}

	public String getStddt() {
		return stddt;
	}

	public void setStddt(String stddt) {
		this.stddt = stddt;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("gcomps", this.gcomps);
        jsonObj.put("comps", this.comps);    
        jsonObj.put("majcd", this.majcd);        
        jsonObj.put("majcd_h", this.majcd_h);        
        jsonObj.put("mjchr", this.mjchr);
        jsonObj.put("majmk", this.majmk);
    	jsonObj.put("house", this.house);
    	jsonObj.put("pyvnd1", this.pyvnd1);
    	jsonObj.put("pyvnd2", this.pyvnd2);
    	jsonObj.put("chldt", this.chldt);
    	jsonObj.put("cusnm", this.cusnm);
    	jsonObj.put("faccd", this.faccd);
    	jsonObj.put("seycd", this.seycd);
    	jsonObj.put("mkcar", this.mkcar);
    	jsonObj.put("mkpno", this.mkpno);
    	jsonObj.put("pspno", this.pspno);
    	jsonObj.put("itmnm", this.itmnm);
    	jsonObj.put("makqy", this.makqy);
    	jsonObj.put("pspqy", this.pspqy);
    	jsonObj.put("suyqy", this.suyqy);
    	jsonObj.put("cllq1", this.cllq1);
    	jsonObj.put("cllbox1", this.cllbox1);
    	jsonObj.put("clpq1", this.clpq1);    	
    	jsonObj.put("cllq2", this.cllq2);
    	jsonObj.put("cllbox2", this.cllbox2);
    	jsonObj.put("clpq2", this.clpq2);    	
    	jsonObj.put("junqy", this.junqy);
    	jsonObj.put("notqy", this.notqy);
    	jsonObj.put("trimd", this.trimd);
    	jsonObj.put("pbsqy", this.pbsqy);
    	jsonObj.put("datq0", this.datq0);
    	jsonObj.put("dat11", this.dat11);
    	jsonObj.put("dat12", this.dat12);
    	jsonObj.put("dat21", this.dat21);
    	jsonObj.put("dat22", this.dat22);
    	jsonObj.put("dat31", this.dat31);
    	jsonObj.put("dat32", this.dat32);
    	jsonObj.put("dat41", this.dat41);
    	jsonObj.put("dat42", this.dat42);
    	jsonObj.put("dat51", this.dat51);
    	jsonObj.put("dat52", this.dat52);
    	jsonObj.put("dat61", this.dat61);
    	jsonObj.put("dat62", this.dat62);
    	jsonObj.put("datqy", this.datqy);
    	jsonObj.put("plqty", this.plqty);
    	jsonObj.put("boxq1", this.boxq1);
    	jsonObj.put("boxq2", this.boxq2);
    	jsonObj.put("dapq0", this.dapq0);
    	jsonObj.put("dap11", this.dap11);
    	jsonObj.put("dap12", this.dap12);
    	jsonObj.put("dap21", this.dap21);
    	jsonObj.put("dap22", this.dap22);
    	jsonObj.put("dap31", this.dap31);
    	jsonObj.put("dap32", this.dap32);
    	jsonObj.put("dap41", this.dap41);
    	jsonObj.put("dap42", this.dap42);
    	jsonObj.put("dap51", this.dap51);
    	jsonObj.put("dap52", this.dap52);
    	jsonObj.put("dap61", this.dap61);
    	jsonObj.put("dap62", this.dap62);
    	jsonObj.put("slqty", this.slqty);
    	jsonObj.put("sujq0", this.sujq0);
    	jsonObj.put("sujq1", this.sujq1);
    	jsonObj.put("sujq2", this.sujq2);
    	jsonObj.put("sujq3", this.sujq3);
    	jsonObj.put("sujq4", this.sujq4);
    	jsonObj.put("sujq5", this.sujq5);
    	jsonObj.put("sujq6", this.sujq6);
    	jsonObj.put("sujq7", this.sujq7);
    	jsonObj.put("sujq8", this.sujq8);
    	jsonObj.put("sujq9", this.sujq9);
    	jsonObj.put("sujq10", this.sujq10);
    	jsonObj.put("sujq11", this.sujq11);
    	jsonObj.put("sujq12", this.sujq12);
    	jsonObj.put("sujqy", this.sujqy);
    	jsonObj.put("dalpr", this.dalpr);
    	jsonObj.put("trimds", this.trimds);
    	jsonObj.put("pbsqys", this.pbsqys);
    	jsonObj.put("datq0s", this.datq0s);
    	jsonObj.put("dat11s", this.dat11s);
    	jsonObj.put("dat12s", this.dat12s);
    	jsonObj.put("dat21s", this.dat21s);
    	jsonObj.put("dat22s", this.dat22s);
    	jsonObj.put("dat31s", this.dat31s);
    	jsonObj.put("dat32s", this.dat32s);
    	jsonObj.put("dat41s", this.dat41s);
    	jsonObj.put("dat42s", this.dat42s);
    	jsonObj.put("dat51s", this.dat51s);
    	jsonObj.put("dat52s", this.dat52s);
    	jsonObj.put("dat61s", this.dat61s);
    	jsonObj.put("dat62s", this.dat62s);
    	jsonObj.put("datqys", this.datqys);
    	jsonObj.put("dapq0s", this.dapq0s);
    	jsonObj.put("dap11s", this.dap11s);
    	jsonObj.put("dap12s", this.dap12s);
    	jsonObj.put("dap21s", this.dap21s);
    	jsonObj.put("dap22s", this.dap22s);
    	jsonObj.put("dap31s", this.dap31s);    	
    	jsonObj.put("dap32s", this.dap32s);
    	jsonObj.put("dap41s", this.dap41s);
    	jsonObj.put("dap42s", this.dap42s);
    	jsonObj.put("dap51s", this.dap51s);
    	jsonObj.put("dap52s", this.dap52s);
    	jsonObj.put("dap61s", this.dap61s);
    	jsonObj.put("dap62s", this.dap62s);
    	jsonObj.put("sujq0s", this.sujq0s);
    	jsonObj.put("sujq1s", this.sujq1s);
    	jsonObj.put("sujq2s", this.sujq2s);
    	jsonObj.put("sujq3s", this.sujq3s);
    	jsonObj.put("sujq4s", this.sujq4s);
    	jsonObj.put("sujq5s", this.sujq5s);
    	jsonObj.put("sujq6s", this.sujq6s);
    	jsonObj.put("sujq7s", this.sujq7s);
    	jsonObj.put("sujq8s", this.sujq8s);
    	jsonObj.put("sujq9s", this.sujq9s);
    	jsonObj.put("sujq10s", this.sujq10s);
    	jsonObj.put("sujq11s", this.sujq11s);
    	jsonObj.put("sujq12s", this.sujq12s);
    	jsonObj.put("sujqys", this.sujqys);
    	jsonObj.put("trimdt", this.trimdt);
    	jsonObj.put("pbsqyt", this.pbsqyt);
    	jsonObj.put("datq0t", this.datq0t);
    	jsonObj.put("datq1t", this.datq1t);
    	jsonObj.put("datq2t", this.datq2t);
    	jsonObj.put("datq3t", this.datq3t);
    	jsonObj.put("datq4t", this.datq4t);
    	jsonObj.put("datq5t", this.datq5t);
    	jsonObj.put("datq6t", this.datq6t);
    	jsonObj.put("datq7t", this.datq7t);
    	jsonObj.put("datq8t", this.datq8t);
    	jsonObj.put("datq9t", this.datq9t);
    	jsonObj.put("datqat", this.datqat);
    	jsonObj.put("datqbt", this.datqbt);
    	jsonObj.put("datqct", this.datqct);
    	jsonObj.put("errcd", this.errcd);
    	jsonObj.put("errnm", this.errnm);
    	jsonObj.put("pyvnd", this.pyvnd);
    	jsonObj.put("makdt", this.makdt);
    	jsonObj.put("makmk", this.makmk);
    	jsonObj.put("clhcd", this.clhcd);
    	jsonObj.put("prcdt", this.prcdt);
    	jsonObj.put("chkdt", this.chkdt);
    	jsonObj.put("chkcnt", this.chkcnt);
    	jsonObj.put("stddt", this.stddt);	
    	
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }  
}