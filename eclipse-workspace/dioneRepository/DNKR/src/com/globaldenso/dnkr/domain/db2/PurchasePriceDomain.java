package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;

import org.json.simple.JSONObject;

/**
 * [KR] 구매현황 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PurchasePriceDomain extends CommonDb2Domain implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2394932110424230471L;

	/**
	 * 
	 */
	private String year;

	/**
	 * 
	 */
	private String clsCode;
	
	/**
	 * 
	 */
	private String locCode;
	
	/**
	 * 
	 */
	private String clsName;
	
	/**
	 * 
	 */
	private String locName;

	/**
	 * [KO] 언어코드<br>
	 * [EN] <br>
	 * [JP] <br>
	 */
	private String cmcCode;

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
	 * PurchasePrice
	 */
	private String packc;
	
	/**     
	*      
	*/
	private String recid;
	
	/**     
	*      
	*/
	private String prtno;
	
	/**     
	*      
	*/
	private String itdsc;
	
	/**     
	*      
	*/
	private String spcod;
	
	/**     
	*      
	*/
	private String vname;
	
	/**     
	*      
	*/
	private String unmsr;

	/**     
	*      
	*/
	private String itcls;

	/**     
	*      
	*/
	private String ittyp;

	/**     
	*      
	*/
	private String crcye;
	
	/**     
	*      
	*/
	private String tempe;
	
	/**     
	*      
	*/
	private String resne;
	
	/**     
	*      
	*/
	private String prcee;
	
	/**     
	*      
	*/
	private String edate;

	public String getClsCode() {
		return clsCode;
	}

	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getCmcCode() {
		return cmcCode;
	}

	public void setCmcCode(String cmcCode) {
		this.cmcCode = cmcCode;
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

	public String getPackc() {
		return packc;
	}

	public void setPackc(String packc) {
		this.packc = packc;
	}

	public String getRecid() {
		return recid;
	}

	public void setRecid(String recid) {
		this.recid = recid;
	}

	public String getPrtno() {
		return prtno;
	}

	public void setPrtno(String prtno) {
		this.prtno = prtno;
	}

	public String getItdsc() {
		return itdsc;
	}

	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}

	public String getSpcod() {
		return spcod;
	}

	public void setSpcod(String spcod) {
		this.spcod = spcod;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getUnmsr() {
		return unmsr;
	}

	public void setUnmsr(String unmsr) {
		this.unmsr = unmsr;
	}

	public String getItcls() {
		return itcls;
	}

	public void setItcls(String itcls) {
		this.itcls = itcls;
	}

	public String getIttyp() {
		return ittyp;
	}

	public void setIttyp(String ittyp) {
		this.ittyp = ittyp;
	}

	public String getCrcye() {
		return crcye;
	}

	public void setCrcye(String crcye) {
		this.crcye = crcye;
	}

	public String getTempe() {
		return tempe;
	}

	public void setTempe(String tempe) {
		this.tempe = tempe;
	}

	public String getResne() {
		return resne;
	}

	public void setResne(String resne) {
		this.resne = resne;
	}

	public String getPrcee() {
		return prcee;
	}

	public void setPrcee(String prcee) {
		this.prcee = prcee;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("packc", this.packc);
        jsonObj.put("recid", this.recid);
        jsonObj.put("prtno", this.prtno);
        jsonObj.put("itdsc", this.itdsc);
        jsonObj.put("spcod", this.spcod);
        jsonObj.put("vname", this.vname);
        jsonObj.put("unmsr", this.unmsr);
        jsonObj.put("itcls", this.itcls);
        jsonObj.put("ittyp", this.ittyp);
        jsonObj.put("crcye", this.crcye);
        jsonObj.put("tempe", this.tempe);
        jsonObj.put("resne", this.resne);
        jsonObj.put("prcee", this.prcee);
        jsonObj.put("edate", this.edate);
        
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}
