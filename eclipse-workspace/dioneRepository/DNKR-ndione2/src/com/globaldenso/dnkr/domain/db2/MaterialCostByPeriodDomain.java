package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;

import org.json.simple.JSONObject;
/**
 * [KR] 로그정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class MaterialCostByPeriodDomain extends CommonDb2Domain implements Serializable {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 3333018149644115190L;

	/**
     * [EN] Paging(From).<br>
     * [JP] ページング(From)。<br>
     */
    private int rowNumFrom;
    
    /**
     * [EN] Paging(To).<br>
     * [JP] ページング(To)。<br>
     */
    private int rowNumTo;
    
    /**
     * [EN] Paging(rowCnt).<br>
     * [JP] ページング(rowCnt)。<br>
     */
    private int rowCnt;
    
    /**
    * [KO] 조회시작일<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String startDate;
    
    /**
    * [KO] 조회종료일<br>
    * [EN] <br>
    * [JP] <br>
    */
    private String endDate;
    
    private String pyvnd;
    private String procs;
    private String pspno;
    private String edatm;
    private String price;
    private String unmsr;
    private String ittyp;
    private String itdsc;
    
    private String krsur;
    private String surkr;
    private String surus;
    private String surjp;
    private String surur;
    private String krpur;
    private String krckd;
    private String ckdus;
    private String ckdjp;
    private String ckdur;
    private String ckdkr;
    private String krpat;
    private String krcot;
    private String mchmu;
    private String mager;
    private String hndtm;
    private String drman;
    private String sbman;
    private String drmch;
    private String sbmch;
    private String epckd;
    private String dangu;
    private String danst;
    private String dandt;
    private String crtdt;
    private String chgdt;
    private String prtqy;
    
    private String mnfcs;
    private String dircs;
    private String mcost;
    private String rmatc;
    private String rmatl;
    private String rmati;
    private String rmimc;
    private String purcs;
    private String purcl;
    private String purci;
    private String ppimc;
    private String prcst;
    private String labcs;
    private String depcs;
    private String mfexp;
    private String diecs;
    private String mohcs;
    private String fixdt;
    
    private String performanceDivision;
    
    /**                 
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public MaterialCostByPeriodDomain() {
        // no process
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("procs", this.procs);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("edatm", this.edatm);
        jsonObj.put("price", this.price);
        jsonObj.put("unmsr", this.unmsr);
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("itdsc", this.itdsc);        
        jsonObj.put("krsur", this.krsur);
        jsonObj.put("surkr", this.surkr);
        jsonObj.put("surus", this.surus);
        jsonObj.put("surjp", this.surjp);
        jsonObj.put("surur", this.surur);
        jsonObj.put("krpur", this.krpur);
        jsonObj.put("krckd", this.krckd);
        jsonObj.put("ckdus", this.ckdus);
        jsonObj.put("ckdjp", this.ckdjp);
        jsonObj.put("ckdur", this.ckdur);
        jsonObj.put("ckdkr", this.ckdkr);
        jsonObj.put("krpat", this.krpat);
        jsonObj.put("krcot", this.krcot);
        jsonObj.put("mchmu", this.mchmu);
        jsonObj.put("mager", this.mager);
        jsonObj.put("hndtm", this.hndtm);
        jsonObj.put("drman", this.drman);
        jsonObj.put("sbman", this.sbman);
        jsonObj.put("drmch", this.drmch);
        jsonObj.put("sbmch", this.sbmch);
        jsonObj.put("epckd", this.epckd);
        jsonObj.put("dangu", this.dangu);
        jsonObj.put("danst", this.danst);
        jsonObj.put("dandt", this.dandt);
        jsonObj.put("crtdt", this.crtdt);
        jsonObj.put("chgdt", this.chgdt);
        jsonObj.put("prtqy", this.prtqy);
        
        
        jsonObj.put("mnfcs", this.mnfcs);
        jsonObj.put("dircs", this.dircs);
        jsonObj.put("mcost", this.mcost);
        jsonObj.put("rmatc", this.rmatc);
        jsonObj.put("rmatl", this.rmatl);
        jsonObj.put("rmati", this.rmati);
        jsonObj.put("rmimc", this.rmimc);
        jsonObj.put("purcs", this.purcs);
        jsonObj.put("purcl", this.purcl);
        jsonObj.put("purci", this.purci);
        jsonObj.put("ppimc", this.ppimc);
        jsonObj.put("prcst", this.prcst);
        jsonObj.put("labcs", this.labcs);
        jsonObj.put("depcs", this.depcs);
        jsonObj.put("mfexp", this.mfexp);
        jsonObj.put("diecs", this.diecs);
        jsonObj.put("mohcs", this.mohcs);
        jsonObj.put("fixdt", this.fixdt);        
        
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }

	public int getRowNumFrom() {
		return rowNumFrom;
	}

	public void setRowNumFrom(int rowNumFrom) {
		this.rowNumFrom = rowNumFrom;
	}

	public int getRowNumTo() {
		return rowNumTo;
	}

	public void setRowNumTo(int rowNumTo) {
		this.rowNumTo = rowNumTo;
	}

	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPyvnd() {
		return pyvnd;
	}

	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}

	public String getProcs() {
		return procs;
	}

	public void setProcs(String procs) {
		this.procs = procs;
	}

	public String getPspno() {
		return pspno;
	}

	public void setPspno(String pspno) {
		this.pspno = pspno;
	}

	public String getEdatm() {
		return edatm;
	}

	public void setEdatm(String edatm) {
		this.edatm = edatm;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUnmsr() {
		return unmsr;
	}

	public void setUnmsr(String unmsr) {
		this.unmsr = unmsr;
	}

	public String getIttyp() {
		return ittyp;
	}

	public void setIttyp(String ittyp) {
		this.ittyp = ittyp;
	}

	public String getItdsc() {
		return itdsc;
	}

	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}

	public String getKrsur() {
		return krsur;
	}

	public void setKrsur(String krsur) {
		this.krsur = krsur;
	}

	public String getSurkr() {
		return surkr;
	}

	public void setSurkr(String surkr) {
		this.surkr = surkr;
	}

	public String getSurus() {
		return surus;
	}

	public void setSurus(String surus) {
		this.surus = surus;
	}

	public String getSurjp() {
		return surjp;
	}

	public void setSurjp(String surjp) {
		this.surjp = surjp;
	}

	public String getSurur() {
		return surur;
	}

	public void setSurur(String surur) {
		this.surur = surur;
	}

	public String getKrpur() {
		return krpur;
	}

	public void setKrpur(String krpur) {
		this.krpur = krpur;
	}

	public String getKrckd() {
		return krckd;
	}

	public void setKrckd(String krckd) {
		this.krckd = krckd;
	}

	public String getCkdus() {
		return ckdus;
	}

	public void setCkdus(String ckdus) {
		this.ckdus = ckdus;
	}

	public String getCkdjp() {
		return ckdjp;
	}

	public void setCkdjp(String ckdjp) {
		this.ckdjp = ckdjp;
	}

	public String getCkdur() {
		return ckdur;
	}

	public void setCkdur(String ckdur) {
		this.ckdur = ckdur;
	}

	public String getCkdkr() {
		return ckdkr;
	}

	public void setCkdkr(String ckdkr) {
		this.ckdkr = ckdkr;
	}

	public String getKrpat() {
		return krpat;
	}

	public void setKrpat(String krpat) {
		this.krpat = krpat;
	}

	public String getKrcot() {
		return krcot;
	}

	public void setKrcot(String krcot) {
		this.krcot = krcot;
	}

	public String getMchmu() {
		return mchmu;
	}

	public void setMchmu(String mchmu) {
		this.mchmu = mchmu;
	}

	public String getMager() {
		return mager;
	}

	public void setMager(String mager) {
		this.mager = mager;
	}

	public String getHndtm() {
		return hndtm;
	}

	public void setHndtm(String hndtm) {
		this.hndtm = hndtm;
	}

	public String getDrman() {
		return drman;
	}

	public void setDrman(String drman) {
		this.drman = drman;
	}

	public String getSbman() {
		return sbman;
	}

	public void setSbman(String sbman) {
		this.sbman = sbman;
	}

	public String getDrmch() {
		return drmch;
	}

	public void setDrmch(String drmch) {
		this.drmch = drmch;
	}

	public String getSbmch() {
		return sbmch;
	}

	public void setSbmch(String sbmch) {
		this.sbmch = sbmch;
	}

	public String getEpckd() {
		return epckd;
	}

	public void setEpckd(String epckd) {
		this.epckd = epckd;
	}

	public String getDangu() {
		return dangu;
	}

	public void setDangu(String dangu) {
		this.dangu = dangu;
	}

	public String getDanst() {
		return danst;
	}

	public void setDanst(String danst) {
		this.danst = danst;
	}

	public String getDandt() {
		return dandt;
	}

	public void setDandt(String dandt) {
		this.dandt = dandt;
	}

	public String getCrtdt() {
		return crtdt;
	}

	public void setCrtdt(String crtdt) {
		this.crtdt = crtdt;
	}

	public String getChgdt() {
		return chgdt;
	}

	public void setChgdt(String chgdt) {
		this.chgdt = chgdt;
	}

	public String getPrtqy() {
		return prtqy;
	}

	public void setPrtqy(String prtqy) {
		this.prtqy = prtqy;
	}

	public String getMnfcs() {
		return mnfcs;
	}

	public void setMnfcs(String mnfcs) {
		this.mnfcs = mnfcs;
	}

	public String getDircs() {
		return dircs;
	}

	public void setDircs(String dircs) {
		this.dircs = dircs;
	}

	public String getMcost() {
		return mcost;
	}

	public void setMcost(String mcost) {
		this.mcost = mcost;
	}

	public String getRmatc() {
		return rmatc;
	}

	public void setRmatc(String rmatc) {
		this.rmatc = rmatc;
	}

	public String getRmatl() {
		return rmatl;
	}

	public void setRmatl(String rmatl) {
		this.rmatl = rmatl;
	}

	public String getRmati() {
		return rmati;
	}

	public void setRmati(String rmati) {
		this.rmati = rmati;
	}

	public String getRmimc() {
		return rmimc;
	}

	public void setRmimc(String rmimc) {
		this.rmimc = rmimc;
	}

	public String getPurcs() {
		return purcs;
	}

	public void setPurcs(String purcs) {
		this.purcs = purcs;
	}

	public String getPurcl() {
		return purcl;
	}

	public void setPurcl(String purcl) {
		this.purcl = purcl;
	}

	public String getPurci() {
		return purci;
	}

	public void setPurci(String purci) {
		this.purci = purci;
	}

	public String getPpimc() {
		return ppimc;
	}

	public void setPpimc(String ppimc) {
		this.ppimc = ppimc;
	}

	public String getPrcst() {
		return prcst;
	}

	public void setPrcst(String prcst) {
		this.prcst = prcst;
	}

	public String getLabcs() {
		return labcs;
	}

	public void setLabcs(String labcs) {
		this.labcs = labcs;
	}

	public String getDepcs() {
		return depcs;
	}

	public void setDepcs(String depcs) {
		this.depcs = depcs;
	}

	public String getMfexp() {
		return mfexp;
	}

	public void setMfexp(String mfexp) {
		this.mfexp = mfexp;
	}

	public String getDiecs() {
		return diecs;
	}

	public void setDiecs(String diecs) {
		this.diecs = diecs;
	}

	public String getMohcs() {
		return mohcs;
	}

	public void setMohcs(String mohcs) {
		this.mohcs = mohcs;
	}

	public String getFixdt() {
		return fixdt;
	}

	public void setFixdt(String fixdt) {
		this.fixdt = fixdt;
	}

	public String getPerformanceDivision() {
		return performanceDivision;
	}

	public void setPerformanceDivision(String performanceDivision) {
		this.performanceDivision = performanceDivision;
	}
}
