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
public class OceanListSalesRevenueDomain extends CommonDb2Domain implements Serializable {
  
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
     * [KO] 수량1 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsqy1;
    /**
     * [KO] 금액1 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsam1;
    /**
     * [KO] 수량2 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsqy2;
    /**
     * [KO] 금액2 <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String jpsam2;
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
   
    /**                 
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     *
     */
    public OceanListSalesRevenueDomain() {
        // no process
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
	
	/**
	 * @return the jobFileName
	 */
	public String getJobFileName() {
		return jobFileName;
	}

	/**
	 * @param jobFileName the jobFileName to set
	 */
	public void setJobFileName(String jobFileName) {
		this.jobFileName = jobFileName;
	}

	/**
	 * @return the comps
	 */
	public String getComps() {
		return comps;
	}

	/**
	 * @param comps the comps to set
	 */
	public void setComps(String comps) {
		this.comps = comps;
	}

	
	/**
	 * @return the house
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(String house) {
		this.house = house;
	}

	/**
	 * @return the prddv
	 */
	public String getPrddv() {
		return prddv;
	}

	/**
	 * @param prddv the prddv to set
	 */
	public void setPrddv(String prddv) {
		this.prddv = prddv;
	}

	/**
	 * @return the prddd
	 */
	public String getPrddd() {
		return prddd;
	}

	/**
	 * @param prddd the prddd to set
	 */
	public void setPrddd(String prddd) {
		this.prddd = prddd;
	}

	/**
	 * @return the pyvnd
	 */
	public String getPyvnd() {
		return pyvnd;
	}

	/**
	 * @param pyvnd the pyvnd to set
	 */
	public void setPyvnd(String pyvnd) {
		this.pyvnd = pyvnd;
	}

	/**
	 * @return the pspno
	 */
	public String getPspno() {
		return pspno;
	}

	/**
	 * @param pspno the pspno to set
	 */
	public void setPspno(String pspno) {
		this.pspno = pspno;
	}

	/**
	 * @return the jpsqy1
	 */
	public String getJpsqy1() {
		return jpsqy1;
	}

	/**
	 * @param jpsqy1 the jpsqy1 to set
	 */
	public void setJpsqy1(String jpsqy1) {
		this.jpsqy1 = jpsqy1;
	}

	/**
	 * @return the jpsam1
	 */
	public String getJpsam1() {
		return jpsam1;
	}

	/**
	 * @param jpsam1 the jpsam1 to set
	 */
	public void setJpsam1(String jpsam1) {
		this.jpsam1 = jpsam1;
	}

	/**
	 * @return the jpsqy2
	 */
	public String getJpsqy2() {
		return jpsqy2;
	}

	/**
	 * @param jpsqy2 the jpsqy2 to set
	 */
	public void setJpsqy2(String jpsqy2) {
		this.jpsqy2 = jpsqy2;
	}

	/**
	 * @return the jpsam2
	 */
	public String getJpsam2() {
		return jpsam2;
	}

	/**
	 * @param jpsam2 the jpsam2 to set
	 */
	public void setJpsam2(String jpsam2) {
		this.jpsam2 = jpsam2;
	}

	/**
	 * @return the addno
	 */
	public String getAddno() {
		return addno;
	}

	/**
	 * @param addno the addno to set
	 */
	public void setAddno(String addno) {
		this.addno = addno;
	}

	/**
	 * @return the prli1
	 */
	public String getPrli1() {
		return prli1;
	}

	/**
	 * @param prli1 the prli1 to set
	 */
	public void setPrli1(String prli1) {
		this.prli1 = prli1;
	}

	/**
	 * @return the prli2
	 */
	public String getPrli2() {
		return prli2;
	}

	/**
	 * @param prli2 the prli2 to set
	 */
	public void setPrli2(String prli2) {
		this.prli2 = prli2;
	}

	/**
	 * @return the prtno
	 */
	public String getPrtno() {
		return prtno;
	}

	/**
	 * @param prtno the prtno to set
	 */
	public void setPrtno(String prtno) {
		this.prtno = prtno;
	}

	/**
	 * @return the odate
	 */
	public String getOdate() {
		return odate;
	}

	/**
	 * @param odate the odate to set
	 */
	public void setOdate(String odate) {
		this.odate = odate;
	}

	/**
	 * @return the invct
	 */
	public String getInvct() {
		return invct;
	}

	/**
	 * @param invct the invct to set
	 */
	public void setInvct(String invct) {
		this.invct = invct;
	}

	/**
	 * @return the prlcd
	 */
	public String getPrlcd() {
		return prlcd;
	}

	/**
	 * @param prlcd the prlcd to set
	 */
	public void setPrlcd(String prlcd) {
		this.prlcd = prlcd;
	}

	/**
	 * @return the edate
	 */
	public String getEdate() {
		return edate;
	}

	/**
	 * @param edate the edate to set
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}

	/**
	 * @return the mnfcs
	 */
	public String getMnfcs() {
		return mnfcs;
	}

	/**
	 * @param mnfcs the mnfcs to set
	 */
	public void setMnfcs(String mnfcs) {
		this.mnfcs = mnfcs;
	}

	/**
	 * @return the dircs
	 */
	public String getDircs() {
		return dircs;
	}

	/**
	 * @param dircs the dircs to set
	 */
	public void setDircs(String dircs) {
		this.dircs = dircs;
	}

	/**
	 * @return the dirmc
	 */
	public String getDirmc() {
		return dirmc;
	}

	/**
	 * @param dirmc the dirmc to set
	 */
	public void setDirmc(String dirmc) {
		this.dirmc = dirmc;
	}

	/**
	 * @return the rmatl
	 */
	public String getRmatl() {
		return rmatl;
	}

	/**
	 * @param rmatl the rmatl to set
	 */
	public void setRmatl(String rmatl) {
		this.rmatl = rmatl;
	}

	/**
	 * @return the rmati
	 */
	public String getRmati() {
		return rmati;
	}

	/**
	 * @param rmati the rmati to set
	 */
	public void setRmati(String rmati) {
		this.rmati = rmati;
	}

	/**
	 * @return the rmimc
	 */
	public String getRmimc() {
		return rmimc;
	}

	/**
	 * @param rmimc the rmimc to set
	 */
	public void setRmimc(String rmimc) {
		this.rmimc = rmimc;
	}

	/**
	 * @return the purcl
	 */
	public String getPurcl() {
		return purcl;
	}

	/**
	 * @param purcl the purcl to set
	 */
	public void setPurcl(String purcl) {
		this.purcl = purcl;
	}

	/**
	 * @return the purci
	 */
	public String getPurci() {
		return purci;
	}

	/**
	 * @param purci the purci to set
	 */
	public void setPurci(String purci) {
		this.purci = purci;
	}

	/**
	 * @return the ppimc
	 */
	public String getPpimc() {
		return ppimc;
	}

	/**
	 * @param ppimc the ppimc to set
	 */
	public void setPpimc(String ppimc) {
		this.ppimc = ppimc;
	}

	/**
	 * @return the labcs
	 */
	public String getLabcs() {
		return labcs;
	}

	/**
	 * @param labcs the labcs to set
	 */
	public void setLabcs(String labcs) {
		this.labcs = labcs;
	}

	/**
	 * @return the depcs
	 */
	public String getDepcs() {
		return depcs;
	}

	/**
	 * @param depcs the depcs to set
	 */
	public void setDepcs(String depcs) {
		this.depcs = depcs;
	}

	/**
	 * @return the mfexp
	 */
	public String getMfexp() {
		return mfexp;
	}

	/**
	 * @param mfexp the mfexp to set
	 */
	public void setMfexp(String mfexp) {
		this.mfexp = mfexp;
	}

	/**
	 * @return the diecs
	 */
	public String getDiecs() {
		return diecs;
	}

	/**
	 * @param diecs the diecs to set
	 */
	public void setDiecs(String diecs) {
		this.diecs = diecs;
	}

	/**
	 * @return the mohcs
	 */
	public String getMohcs() {
		return mohcs;
	}

	/**
	 * @param mohcs the mohcs to set
	 */
	public void setMohcs(String mohcs) {
		this.mohcs = mohcs;
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
        jsonObj.put("jpsqy1", this.jpsqy1);        
        jsonObj.put("jpsam1", this.jpsam1);
        jsonObj.put("jpsqy2", this.jpsqy2);
        jsonObj.put("jpsam2", this.jpsam2);
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
        
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}
