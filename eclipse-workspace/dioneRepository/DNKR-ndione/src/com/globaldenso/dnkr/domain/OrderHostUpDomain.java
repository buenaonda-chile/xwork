package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;
/**
 * [KR] 서열형 HOST UP 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class OrderHostUpDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143743L;
    
    /**
     * [KR]  업로드 성공 리스트<br>   
     */
    private JSONObject sucList;
    
    /**
     * [KR]  업로드 실패 리스트<br>   
     */
    private JSONObject failList;

	public JSONObject getSucList() {
		return sucList;
	}

	public void setSucList(JSONObject sucList) {
		this.sucList = sucList;
	}

	public JSONObject getFailList() {
		return failList;
	}

	public void setFailList(JSONObject failList) {
		this.failList = failList;
	}


    private String lib1;
    private String lib2;
    private String lib3;
    
    public String getLib1() {
        return lib1;
    }

    public void setLib1(String lib1) {
        this.lib1 = lib1;
    }

    public String getLib2() {
        return lib2;
    }

    public void setLib2(String lib2) {
        this.lib2 = lib2;
    }

    public String getLib3() {
        return lib3;
    }

    public void setLib3(String lib3) {
        this.lib3 = lib3;
    }

        
	private String psvnd;
	private String pscom;
	private String pyvnd;
	private String vndcd;
	private String faccd;
	
    private String comps;
    private String mcrcd;
    private String msecd;
    private String mcrc1;
    private String msec1;
    
    private String pspno;
    private String seqcd;
    private String seqno;
    private String efffr;
    private String effto;
    
    
    public String getPsvnd() {
        return psvnd;
    }

    public void setPsvnd(String psvnd) {
        this.psvnd = psvnd;
    }
    
    public String getPscom() {
        return pscom;
    }

    public void setPscom(String pscom) {
        this.pscom = pscom;
    }
    
    public String getPyvnd() {
        return pyvnd;
    }

    public void setPyvnd(String pyvnd) {
        this.pyvnd = pyvnd;
    }
    
    public String getVndcd() {
        return vndcd;
    }

    public void setVndcd(String vndcd) {
        this.vndcd = vndcd;
    }
    
    public String getFaccd() {
        return faccd;
    }

    public void setFaccd(String faccd) {
        this.faccd = faccd;
    }
    
    
    public String getComps() {
        return comps;
    }

    public void setComps(String comps) {
        this.comps = comps;
    }
    
    public String getMcrcd() {
        return mcrcd;
    }

    public void setMcrcd(String mcrcd) {
        this.mcrcd = mcrcd;
    }
    
    public String getMsecd() {
        return msecd;
    }

    public void setMsecd(String msecd) {
        this.msecd = msecd;
    }
    
    public String getMcrc1() {
        return mcrc1;
    }

    public void setMcrc1(String mcrc1) {
        this.mcrc1 = mcrc1;
    }
    
    public String getMsec1() {
        return msec1;
    }

    public void setMsec1(String msec1) {
        this.msec1 = msec1;
    }
    
    
    public String getPspno() {
        return pspno;
    }

    public void setPspno(String pspno) {
        this.pspno = pspno;
    }
    
    public String getSeqcd() {
        return seqcd;
    }

    public void setSeqcd(String seqcd) {
        this.seqcd = seqcd;
    }
    
    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }
    
    public String getEfffr() {
        return efffr;
    }

    public void setEfffr(String efffr) {
        this.efffr = efffr;
    }
    
    public String getEffto() {
        return effto;
    }

    public void setEffto(String effto) {
        this.effto = effto;
    }
    
    
    // 집계
	private String dmkcr;
	private String dsecd;
	private String dseno;
	private String dfacd;
	private String deffr;
	private String defto;
	private String dumcb;
	private String trimd;
	private String pbsqy;
	private String patqy;
	private String wbsqy;

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

	private String remqy;
	private String grtot;
	private String okqty;
	private String mitqy;
	private String prseq;
	private String miqqy;
	private String mioqy;
	private String molcd;
	
	private String typcd;
	
	public String getTypcd() {
		return typcd;
	}

	public void setTypcd(String typcd) {
		this.typcd = typcd;
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

	public String getDumcb() {
		return dumcb;
	}

	public void setDumcb(String dumcb) {
		this.dumcb = dumcb;
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

	public String getMolcd() {
		return molcd;
	}

	public void setMolcd(String molcd) {
		this.molcd = molcd;
	}
	
}
