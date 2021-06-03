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
public class OceanListDomain extends CommonDb2Domain implements Serializable {
  
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
    
    /**
     * [KO] 처리파일<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jobFileName;
    
    
    /**
     * [KO] 사업부<br>
     * [EN] <br>
     * [JP] <br>
     */
    private String comps;
    /**
     * [KO] 창고 <br>
     * [EN] WAREHOUSE<br>
     * [JP] <br>
     */
    private String house;
    /**
     * [KO] PRODUCT DIVISION <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String prddv;
    /**
     * [KO] DIVISION DESCRIPTION <br>
     * [EN] DIVISION DESCRIPTION <br>
     * [JP] <br>
     */
    private String prddd;
    /**
     * [KO] 득의선코드  <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pyvnd;
    /**
     * [KO] 덴소품번  <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String pspno;
    /**
     * [KO] 수량 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsqy;
    /**
     * [KO] 금액 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsam;

    /**
     * [KO] JDE ADDRESS  <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String addno;
    /**
     * [KO] ITEM 1ST <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String prli1;
    /**
     * [KO] ITEM 2ST <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String prli2;
    /**
     * [KO] PART NO <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String prtno;
    /**
     * [KO] DATE OCCURED <br>
     * [EN] DATE OCCURED <br>
     * [JP] <br>
     */
    private String odate;
    /**
     * [KO] INVENTORY CATEGORY <br>
     * [EN] INVENTORY CATEGORY <br>
     * [JP] <br>
     */
    private String invct;
    /**
     * [KO] PRODUCT LINE <br>
     * [EN] PRODUCT LINE <br>
     * [JP] <br>
     */
    private String prlcd;
    /**
     * [KO] ENTRY DATE <br>
     * [EN] ENTRY DATE <br>
     * [JP] <br>
     */
    private String edate;
    /**
     * [KO] MFG.COST <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mnfcs;
    /**
     * [KO] DIRECT COST <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String dircs;
    /**
     * [KO] DIR.MAT.COST <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String dirmc;
    /**
     * [KO] RAW MAT.LOCAL <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String rmatl;
    /**
     * [KO] RAW MAT.IMPORT <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String rmati;
    /**
     * [KO] RAW MAT.CHARGE <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String rmimc;
    /**
     * [KO] PUR.LOCAL <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String purcl;
    /**
     * [KO] PUR.IMPORT <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String purci;
    /**
     * [KO] PUR.CHARGE <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String ppimc;
    /**
     * [KO] LABOR COST <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String labcs;
    /**
     * [KO] DEP.COST <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String depcs;
    /**
     * [KO] MFG.EXPENSES <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mfexp;
    /**
     * [KO] DIE COST <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String diecs;
    /**
     * [KO] MFG.OVERHEAD <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String mohcs;
    
    private String performanceDivision;
    
    /**                 
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public OceanListDomain() {
        // no process
    }
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("house", this.house);
        jsonObj.put("prddv", this.prddv);
        jsonObj.put("prddd", this.prddd);
        jsonObj.put("pyvnd", this.pyvnd);
        jsonObj.put("pspno", this.pspno);
        jsonObj.put("jpsqy", this.jpsqy);
        jsonObj.put("jpsam", this.jpsam);        
        jsonObj.put("addno", this.addno);
        jsonObj.put("prli1", this.prli1);
        jsonObj.put("prli2", this.prli2);
        jsonObj.put("prtno", this.prtno);
        jsonObj.put("odate", this.odate);
        jsonObj.put("invct", this.invct);
        jsonObj.put("prlcd", this.prlcd);
        jsonObj.put("edate", this.edate);
        jsonObj.put("mnfcs", this.mnfcs);
        jsonObj.put("dircs", this.dircs);
        jsonObj.put("dirmc", this.dirmc);
        jsonObj.put("rmatl", this.rmatl);
        jsonObj.put("rmati", this.rmati);
        jsonObj.put("rmimc", this.rmimc);
        jsonObj.put("purcl", this.purcl);
        jsonObj.put("purci", this.purci);
        jsonObj.put("ppimc", this.ppimc);
        jsonObj.put("labcs", this.labcs);
        jsonObj.put("depcs", this.depcs);
        jsonObj.put("mfexp", this.mfexp);
        jsonObj.put("diecs", this.diecs);
        jsonObj.put("mohcs", this.mohcs);
 
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

	public String getComps() {
		return comps;
	}

	public void setComps(String comps) {
		this.comps = comps;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getPrddv() {
		return prddv;
	}

	public void setPrddv(String prddv) {
		this.prddv = prddv;
	}

	public String getPrddd() {
		return prddd;
	}

	public void setPrddd(String prddd) {
		this.prddd = prddd;
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

	public String getJpsqy() {
		return jpsqy;
	}

	public void setJpsqy(String jpsqy) {
		this.jpsqy = jpsqy;
	}

	public String getJpsam() {
		return jpsam;
	}

	public void setJpsam(String jpsam) {
		this.jpsam = jpsam;
	}

	public String getAddno() {
		return addno;
	}

	public void setAddno(String addno) {
		this.addno = addno;
	}

	public String getPrli1() {
		return prli1;
	}

	public void setPrli1(String prli1) {
		this.prli1 = prli1;
	}

	public String getPrli2() {
		return prli2;
	}

	public void setPrli2(String prli2) {
		this.prli2 = prli2;
	}

	public String getPrtno() {
		return prtno;
	}

	public void setPrtno(String prtno) {
		this.prtno = prtno;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public String getInvct() {
		return invct;
	}

	public void setInvct(String invct) {
		this.invct = invct;
	}

	public String getPrlcd() {
		return prlcd;
	}

	public void setPrlcd(String prlcd) {
		this.prlcd = prlcd;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
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

	public String getDirmc() {
		return dirmc;
	}

	public void setDirmc(String dirmc) {
		this.dirmc = dirmc;
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

	public String getJobFileName() {
		return jobFileName;
	}

	public void setJobFileName(String jobFileName) {
		this.jobFileName = jobFileName;
	}
}
