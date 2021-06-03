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
public class OrderDaySaleCreateDomain implements Serializable {
    
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
 
    public String getPyvnd() {
		return pyvnd;
	}

	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}

	public String getPspno() {
		return pspno;
	}

	public void setPspno(String pspno) {
		this.pspno = pspno;
	}

	public String getMkpno() {
		return mkpno;
	}

	public void setMkpno(String mkpno) {
		this.mkpno = mkpno;
	}

	public String getChldt() {
		return chldt;
	}

	public void setChldt(String chldt) {
		this.chldt = chldt;
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

	public String getSeyno() {
		return seyno;
	}

	public void setSeyno(String seyno) {
		this.seyno = seyno;
	}

	public String getMkcar() {
		return mkcar;
	}

	public void setMkcar(String mkcar) {
		this.mkcar = mkcar;
	}

	public String getCarcd() {
		return carcd;
	}

	public void setCarcd(String carcd) {
		this.carcd = carcd;
	}

	public String getTrimdd() {
		return trimdd;
	}

	public void setTrimdd(String trimdd) {
		this.trimdd = trimdd;
	}

	public String getPbsqyd() {
		return pbsqyd;
	}

	public void setPbsqyd(String pbsqyd) {
		this.pbsqyd = pbsqyd;
	}

	public String getDatq0d() {
		return datq0d;
	}

	public void setDatq0d(String datq0d) {
		this.datq0d = datq0d;
	}

	public String getDat11d() {
		return dat11d;
	}

	public void setDat11d(String dat11d) {
		this.dat11d = dat11d;
	}

	public String getDat12d() {
		return dat12d;
	}

	public void setDat12d(String dat12d) {
		this.dat12d = dat12d;
	}

	public String getDatq1d() {
		return datq1d;
	}

	public void setDatq1d(String datq1d) {
		this.datq1d = datq1d;
	}

	public String getDat21d() {
		return dat21d;
	}

	public void setDat21d(String dat21d) {
		this.dat21d = dat21d;
	}

	public String getDat22d() {
		return dat22d;
	}

	public void setDat22d(String dat22d) {
		this.dat22d = dat22d;
	}

	public String getDatq2d() {
		return datq2d;
	}

	public void setDatq2d(String datq2d) {
		this.datq2d = datq2d;
	}

	public String getDat31d() {
		return dat31d;
	}

	public void setDat31d(String dat31d) {
		this.dat31d = dat31d;
	}

	public String getDat32d() {
		return dat32d;
	}

	public void setDat32d(String dat32d) {
		this.dat32d = dat32d;
	}

	public String getDatq3d() {
		return datq3d;
	}

	public void setDatq3d(String datq3d) {
		this.datq3d = datq3d;
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

	public String getDat11t() {
		return dat11t;
	}

	public void setDat11t(String dat11t) {
		this.dat11t = dat11t;
	}

	public String getDat12t() {
		return dat12t;
	}

	public void setDat12t(String dat12t) {
		this.dat12t = dat12t;
	}

	public String getDatq1t() {
		return datq1t;
	}

	public void setDatq1t(String datq1t) {
		this.datq1t = datq1t;
	}

	public String getDat21t() {
		return dat21t;
	}

	public void setDat21t(String dat21t) {
		this.dat21t = dat21t;
	}

	public String getDat22t() {
		return dat22t;
	}

	public void setDat22t(String dat22t) {
		this.dat22t = dat22t;
	}

	public String getDatq2t() {
		return datq2t;
	}

	public void setDatq2t(String datq2t) {
		this.datq2t = datq2t;
	}

	public String getDat31t() {
		return dat31t;
	}

	public void setDat31t(String dat31t) {
		this.dat31t = dat31t;
	}

	public String getDat32t() {
		return dat32t;
	}

	public void setDat32t(String dat32t) {
		this.dat32t = dat32t;
	}

	public String getDatq3t() {
		return datq3t;
	}

	public void setDatq3t(String datq3t) {
		this.datq3t = datq3t;
	}

	public String getDat41t() {
		return dat41t;
	}

	public void setDat41t(String dat41t) {
		this.dat41t = dat41t;
	}

	public String getDat42t() {
		return dat42t;
	}

	public void setDat42t(String dat42t) {
		this.dat42t = dat42t;
	}

	public String getDatq4t() {
		return datq4t;
	}

	public void setDatq4t(String datq4t) {
		this.datq4t = datq4t;
	}

	public String getDat51t() {
		return dat51t;
	}

	public void setDat51t(String dat51t) {
		this.dat51t = dat51t;
	}

	public String getDat52t() {
		return dat52t;
	}

	public void setDat52t(String dat52t) {
		this.dat52t = dat52t;
	}

	public String getDatq5t() {
		return datq5t;
	}

	public void setDatq5t(String datq5t) {
		this.datq5t = datq5t;
	}

	public String getDat61t() {
		return dat61t;
	}

	public void setDat61t(String dat61t) {
		this.dat61t = dat61t;
	}

	public String getDat62t() {
		return dat62t;
	}

	public void setDat62t(String dat62t) {
		this.dat62t = dat62t;
	}

	public String getDatq6t() {
		return datq6t;
	}

	public void setDatq6t(String datq6t) {
		this.datq6t = datq6t;
	}

	public String getDat71t() {
		return dat71t;
	}

	public void setDat71t(String dat71t) {
		this.dat71t = dat71t;
	}

	public String getDat72t() {
		return dat72t;
	}

	public void setDat72t(String dat72t) {
		this.dat72t = dat72t;
	}

	public String getDatq7t() {
		return datq7t;
	}

	public void setDatq7t(String datq7t) {
		this.datq7t = datq7t;
	}

	public String getDat81t() {
		return dat81t;
	}

	public void setDat81t(String dat81t) {
		this.dat81t = dat81t;
	}

	public String getDat82t() {
		return dat82t;
	}

	public void setDat82t(String dat82t) {
		this.dat82t = dat82t;
	}

	public String getDatq8t() {
		return datq8t;
	}

	public void setDatq8t(String datq8t) {
		this.datq8t = datq8t;
	}

	public String getDat91t() {
		return dat91t;
	}

	public void setDat91t(String dat91t) {
		this.dat91t = dat91t;
	}

	public String getDat92t() {
		return dat92t;
	}

	public void setDat92t(String dat92t) {
		this.dat92t = dat92t;
	}

	public String getDatq9t() {
		return datq9t;
	}

	public void setDatq9t(String datq9t) {
		this.datq9t = datq9t;
	}

	public String getData1t() {
		return data1t;
	}

	public void setData1t(String data1t) {
		this.data1t = data1t;
	}

	public String getData2t() {
		return data2t;
	}

	public void setData2t(String data2t) {
		this.data2t = data2t;
	}

	public String getDatqat() {
		return datqat;
	}

	public void setDatqat(String datqat) {
		this.datqat = datqat;
	}

	public String getDatb1t() {
		return datb1t;
	}

	public void setDatb1t(String datb1t) {
		this.datb1t = datb1t;
	}

	public String getDatb2t() {
		return datb2t;
	}

	public void setDatb2t(String datb2t) {
		this.datb2t = datb2t;
	}

	public String getDatqbt() {
		return datqbt;
	}

	public void setDatqbt(String datqbt) {
		this.datqbt = datqbt;
	}

	public String getDatc1t() {
		return datc1t;
	}

	public void setDatc1t(String datc1t) {
		this.datc1t = datc1t;
	}

	public String getDatc2t() {
		return datc2t;
	}

	public void setDatc2t(String datc2t) {
		this.datc2t = datc2t;
	}

	public String getDatqct() {
		return datqct;
	}

	public void setDatqct(String datqct) {
		this.datqct = datqct;
	}

	private String pyvnd;
    private String pspno;
    private String mkpno;	
    private String chldt;	
    private String faccd;	
    private String seycd;	
    private String seyno;	
    private String mkcar;	
    private String carcd;	
    private String trimdd;	
    private String pbsqyd;	
    private String datq0d;	
    private String dat11d;	
    private String dat12d;	
    private String datq1d;	
    private String dat21d;	
    private String dat22d;	
    private String datq2d;	
    private String dat31d;	
    private String dat32d;	
    private String datq3d;	
    private String trimdt;	
    private String pbsqyt;	
    private String datq0t;	
    private String dat11t;	
    private String dat12t;	
    private String datq1t;	
    private String dat21t;	
    private String dat22t;	
    private String datq2t;	
    private String dat31t;	
    private String dat32t;	
    private String datq3t;	
    private String dat41t;	
    private String dat42t;	
    private String datq4t;	
    private String dat51t;	
    private String dat52t;	
    private String datq5t;	
    private String dat61t;	
    private String dat62t;	
    private String datq6t;	
    private String dat71t;	
    private String dat72t;	
    private String datq7t;	
    private String dat81t;	
    private String dat82t;	
    private String datq8t;	
    private String dat91t;	
    private String dat92t;	
    private String datq9t;	
    private String data1t;	
    private String data2t;	
    private String datqat;	
    private String datb1t;	
    private String datb2t;	
    private String datqbt;	
    private String datc1t;	
    private String datc2t;	
    private String datqct;		
    
    private String comps;
    private String errcd;
    
    private String dmkcr;
    private String dsecd;
    private String dseno;
    private String dfacd;
    private String deffr;
    private String defto;
    
    private int dumcb;    
    private int trimd;    
    private int pbsqy;
    private int patqy;
    private int wbsqy;
    
    private int dat00;
    private int dat01;
    private int dat02;
    private int dat03;
    private int dat04;
    private int dat05;
    private int dat06;
    private int dat07;
    private int dat08;
    private int dat09;
    private int dat10;
    private int dat11;
    private int dat12;
    
    private String remqy;
    private String okqty;
    private String mitqy;
    private String prseq;
    private String miqqy;
    private String mioqy;
    private String grtot;

    //월 판매계획 취득, 잔여근무일수 취득
    private String baseym;
    private String baseymd;
    private String pqtym; 
  
    public String getDaseym() {
		return baseym;
	}

	public void setDaseym(String baseym) {
		this.baseym = baseym;
	}

	public String getDaseymd() {
		return baseymd;
	}

	public void setDaseymd(String baseymd) {
		this.baseymd = baseymd;
	}
	
	public String getpqtym() {
		return pqtym;
	}

	public void setPqtym(String pqtym) {
		this.pqtym = pqtym;
	}
    
    
    
	public int getDumcb() {
		return dumcb;
	}

	public void setDumcb(int dumcb) {
		this.dumcb = dumcb;
	}

	public int getTrimd() {
		return trimd;
	}

	public void setTrimd(int trimd) {
		this.trimd = trimd;
	}

	public int getPbsqy() {
		return pbsqy;
	}

	public void setPbsqy(int pbsqy) {
		this.pbsqy = pbsqy;
	}

	public int getPatqy() {
		return patqy;
	}

	public void setPatqy(int patqy) {
		this.patqy = patqy;
	}

	public int getWbsqy() {
		return wbsqy;
	}

	public void setWbsqy(int wbsqy) {
		this.wbsqy = wbsqy;
	}

	public int getDat00() {
		return dat00;
	}

	public void setDat00(int dat00) {
		this.dat00 = dat00;
	}

	public int getDat01() {
		return dat01;
	}

	public void setDat01(int dat01) {
		this.dat01 = dat01;
	}

	public int getDat02() {
		return dat02;
	}

	public void setDat02(int dat02) {
		this.dat02 = dat02;
	}

	public int getDat03() {
		return dat03;
	}

	public void setDat03(int dat03) {
		this.dat03 = dat03;
	}

	public int getDat04() {
		return dat04;
	}

	public void setDat04(int dat04) {
		this.dat04 = dat04;
	}

	public int getDat05() {
		return dat05;
	}

	public void setDat05(int dat05) {
		this.dat05 = dat05;
	}

	public int getDat06() {
		return dat06;
	}

	public void setDat06(int dat06) {
		this.dat06 = dat06;
	}

	public int getDat07() {
		return dat07;
	}

	public void setDat07(int dat07) {
		this.dat07 = dat07;
	}

	public int getDat08() {
		return dat08;
	}

	public void setDat08(int dat08) {
		this.dat08 = dat08;
	}

	public int getDat09() {
		return dat09;
	}

	public void setDat09(int dat09) {
		this.dat09 = dat09;
	}

	public int getDat10() {
		return dat10;
	}

	public void setDat10(int dat10) {
		this.dat10 = dat10;
	}

	public int getDat11() {
		return dat11;
	}

	public void setDat11(int dat11) {
		this.dat11 = dat11;
	}

	public int getDat12() {
		return dat12;
	}

	public void setDat12(int dat12) {
		this.dat12 = dat12;
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

	public String getDfacd() {
		return dfacd;
	}

	public void setDfacd(String dfacd) {
		this.dfacd = dfacd;
	}

	public String getDeffr() {
		return deffr;
	}

	public void setDeffr(String deffr) {
		this.deffr = deffr;
	}

	public String getDefto() {
		return defto;
	}

	public void setDefto(String defto) {
		this.defto = defto;
	}

	public String getRemqy() {
		return remqy;
	}

	public void setRemqy(String remqy) {
		this.remqy = remqy;
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

	public String getGrtot() {
		return grtot;
	}

	public void setGrtot(String grtot) {
		this.grtot = grtot;
	}

	public String getErrcd() {
		return errcd;
	}

	public void setErrcd(String errcd) {
		this.errcd = errcd;
	}

	public String getComps() {
		return comps;
	}

	public void setComps(String comps) {
		this.comps = comps;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();

    	jsonObj.put("chldt", this.chldt);
    	jsonObj.put("faccd", this.faccd);
    	jsonObj.put("seycd", this.seycd);
    	jsonObj.put("mkcar", this.mkcar);
    	jsonObj.put("mkpno", this.mkpno);
    	jsonObj.put("pspno", this.pspno);    	
    	
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }  
}