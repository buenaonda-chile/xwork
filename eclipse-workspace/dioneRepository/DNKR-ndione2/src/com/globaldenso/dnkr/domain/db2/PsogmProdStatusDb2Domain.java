package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * 
 * Describe the outline of this class.
 * 
 * <p>
 * Describe the detail of this class.
 * </p>
 *
 * @author $Author$
 * @version $Revision$
 */
public class PsogmProdStatusDb2Domain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -8668844825133225990L;

    
    /**
     * [KO] 사업부<br>
     */
    private String comps;
    
    /**
     * [KO] 공정상태코드<br>
     */
    private String runcd;
    
    /**
     * [KO] 공정코드<br>
     */
    private String procs;
    
    /**
     * [KO] 공정 약명<br>
     */
    private String prosm;
    
    /**
     * [KO] 생산중 차종명<br>
     */
    private String mstsm;
    
    /**
     * [KO] 주야구분<br>
     */
    private String daygu;
    
    /**
     * [KO] 최종생산품번 <br>
     */
    private String prtno;
    
    /**
     * [KO] 지시 일자<br>
     */
    private String ordat;
    
    /**
     * [KO] 택트 타임<br>
     */
    private String cyctm;

    /**
     * [KO] 금일생산수<br>
     */
    private String fstqy;
    
    /**
     * [KO] 생산능력수<br>
     */
    private String atoqy;
    
    /**
     * [KO] 생산실적수<br>
     */
    private String prdqy;
    
    /**
     * [KO] fstqyRate<br>
     */
    private String fstqyRate;
    
    /**
     * [KO] atoqyRate<br>
     */
    private String atoqyRate;
    
    /**
     * [KO] ROW 구분<br>
     */
    private String rowgb;
    
    /**
     * [KO] 생산계획 합계<br>
     */
    private String sum1;
    
    /**
     * [KO] 생산능력 합계<br>
     */
    private String sum2;
    
    /**
     * [KO] 생산실적 합계<br>
     */
    private String sum3;
    
    /**
     * [KO] 실적/계획 %<br>
     */
    private String per1;
    
    /**
     * [KO] 실적/능력 %<br>
     */
    private String per2;
    
    /**
     * [EN] Employee lib1.<br>
     * [JP] 従業員番号。<br>
     */
    private String lib1;
    
    /**
     * [EN] Employee lib2.<br>
     * [JP] <br>
     */
    private String lib2;
    
    /**
     * [EN] Employee lib3.<br>
     * [JP] <br>
     */
    private String lib3;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmProdStatusDb2Domain() {
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
        return comps;
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
     * [KO] runcd의 getter method 이다.<br>
     * [EN] It is a getter method of runcd.<br>
     * [JP] <br>
     * 
     * @return the runcd
     */
    public String getRuncd() {
        return runcd;
    }

    /**
     * [KO] runcd의 setter method 이다.<br>
     * [EN] It is a setter method of runcd.<br>
     * [JP] <br>
     * 
     * @param runcd String
     */
    public void setRuncd(String runcd) {
        this.runcd = runcd;
    }
    
    /**
     * [KO] procs의 getter method 이다.<br>
     * [EN] It is a getter method of procs.<br>
     * [JP] <br>
     * 
     * @return the procs
     */
    public String getProcs() {
        return procs;
    }

    /**
     * [KO] procs의 setter method 이다.<br>
     * [EN] It is a setter method of procs.<br>
     * [JP] <br>
     * 
     * @param procs String
     */
    public void setProcs(String procs) {
        this.procs = procs;
    }
    
    /**
     * [KO] prosm의 getter method 이다.<br>
     * [EN] It is a getter method of prosm.<br>
     * [JP] <br>
     * 
     * @return the prosm
     */
    public String getProsm() {
        return prosm;
    }

    /**
     * [KO] prosm의 setter method 이다.<br>
     * [EN] It is a setter method of prosm.<br>
     * [JP] <br>
     * 
     * @param prosm String
     */
    public void setProsm(String prosm) {
        this.prosm = prosm;
    }
    
    /**
     * [KO] mstsm의 getter method 이다.<br>
     * [EN] It is a getter method of mstsm.<br>
     * [JP] <br>
     * 
     * @return the mstsm
     */
    public String getMstsm() {
        return mstsm;
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
     * [KO] daygu의 getter method 이다.<br>
     * [EN] It is a getter method of daygu.<br>
     * [JP] <br>
     * 
     * @return the daygu
     */
    public String getDaygu() {
        return daygu;
    }

    /**
     * [KO] daygu의 setter method 이다.<br>
     * [EN] It is a setter method of daygu.<br>
     * [JP] <br>
     * 
     * @param daygu String
     */
    public void setDaygu(String daygu) {
        this.daygu = daygu;
    }
    
    /**
     * [KO] prtno의 getter method 이다.<br>
     * [EN] It is a getter method of prtno.<br>
     * [JP] <br>
     * 
     * @return the prtno
     */
    public String getPrtno() {
        return prtno;
    }

    /**
     * [KO] prtno의 setter method 이다.<br>
     * [EN] It is a setter method of prtno.<br>
     * [JP] <br>
     * 
     * @param prtno String
     */
    public void setPrtno(String prtno) {
        this.prtno = prtno;
    }
    
    /**
     * [KO] ordat의 getter method 이다.<br>
     * [EN] It is a getter method of ordat.<br>
     * [JP] <br>
     * 
     * @return the ordat
     */
    public String getOrdat() {
        return ordat;
    }

    /**
     * [KO] ordat의 setter method 이다.<br>
     * [EN] It is a setter method of ordat.<br>
     * [JP] <br>
     * 
     * @param ordat String
     */
    public void setOrdat(String ordat) {
        this.ordat = ordat;
    }
    
    /**
     * [KO] cyctm의 getter method 이다.<br>
     * [EN] It is a getter method of cyctm.<br>
     * [JP] <br>
     * 
     * @return the cyctm
     */
    public String getCyctm() {
        return cyctm;
    }

    /**
     * [KO] cyctm의 setter method 이다.<br>
     * [EN] It is a setter method of cyctm.<br>
     * [JP] <br>
     * 
     * @param cyctm String
     */
    public void setCyctm(String cyctm) {
        this.cyctm = cyctm;
    }
    
    /**
     * [KO] fstqy의 getter method 이다.<br>
     * [EN] It is a getter method of fstqy.<br>
     * [JP] <br>
     * 
     * @return the fstqy
     */
    public String getFstqy() {
        return fstqy;
    }

    /**
     * [KO] fstqy의 setter method 이다.<br>
     * [EN] It is a setter method of fstqy.<br>
     * [JP] <br>
     * 
     * @param fstqy String
     */
    public void setFstqy(String fstqy) {
        this.fstqy = fstqy;
    }
    
    /**
     * [KO] atoqy의 getter method 이다.<br>
     * [EN] It is a getter method of atoqy.<br>
     * [JP] <br>
     * 
     * @return the atoqy
     */
    public String getAtoqy() {
        return atoqy;
    }

    /**
     * [KO] atoqy의 setter method 이다.<br>
     * [EN] It is a setter method of atoqy.<br>
     * [JP] <br>
     * 
     * @param atoqy String
     */
    public void setAtoqy(String atoqy) {
        this.atoqy = atoqy;
    }
    
    /**
     * [KO] prdqy의 getter method 이다.<br>
     * [EN] It is a getter method of prdqy.<br>
     * [JP] <br>
     * 
     * @return the prdqy
     */
    public String getPrdqy() {
        return prdqy;
    }

    /**
     * [KO] prdqy의 setter method 이다.<br>
     * [EN] It is a setter method of prdqy.<br>
     * [JP] <br>
     * 
     * @param prdqy String
     */
    public void setPrdqy(String prdqy) {
        this.prdqy = prdqy;
    }
    
    /**
     * [KO] fstqyRate의 getter method 이다.<br>
     * [EN] It is a getter method of fstqyRate.<br>
     * [JP] <br>
     * 
     * @return the fstqyRate
     */
    public String getFstqyRate() {
        return fstqyRate;
    }

    /**
     * [KO] fstqyRate의 setter method 이다.<br>
     * [EN] It is a setter method of fstqyRate.<br>
     * [JP] <br>
     * 
     * @param fstqyRate String
     */
    public void setFstqyRate(String fstqyRate) {
        this.fstqyRate = fstqyRate;
    }
    
    /**
     * [KO] atoqyRate의 getter method 이다.<br>
     * [EN] It is a getter method of atoqyRate.<br>
     * [JP] <br>
     * 
     * @return the atoqyRate
     */
    public String getAtoqyRate() {
        return atoqyRate;
    }

    /**
     * [KO] atoqyRate의 setter method 이다.<br>
     * [EN] It is a setter method of atoqyRate.<br>
     * [JP] <br>
     * 
     * @param atoqyRate String
     */
    public void setAtoqyRate(String atoqyRate) {
        this.atoqyRate = atoqyRate;
    }
    
    /**
     * [KO] rowgb의 getter method 이다.<br>
     * [EN] It is a getter method of rowgb.<br>
     * [JP] <br>
     * 
     * @return the rowgb
     */
    public String getRowgb() {
        return rowgb;
    }

    /**
     * [KO] rowgb의 setter method 이다.<br>
     * [EN] It is a setter method of rowgb.<br>
     * [JP] <br>
     * 
     * @param rowgb String
     */
    public void setRowgb(String rowgb) {
        this.rowgb = rowgb;
    }
    
    /**
     * @return the sum1
     */   
    public String getSum1() {
        return sum1;
    }

    /**
     * @param sum1 String
     */
    public void setSum1(String sum1) {
        this.sum1 = sum1;
    }
    
    /**
     * @return the sum2
     */   
    public String getSum2() {
        return sum2;
    }

    /**
     * @param sum2 String
     */
    public void setSum2(String sum2) {
        this.sum2 = sum2;
    }
    
    /**
     * @return the sum3
     */   
    public String getSum3() {
        return sum3;
    }

    /**
     * @param sum3 String
     */
    public void setSum3(String sum3) {
        this.sum3 = sum3;
    }
    
    /**
     * @return the per1
     */   
    public String getPer1() {
        return per1;
    }

    /**
     * @param per1 String
     */
    public void setPer1(String per1) {
        this.per1 = per1;
    }
    
    /**
     * @return the per2
     */   
    public String getPer2() {
        return per2;
    }

    /**
     * @param per2 String
     */
    public void setPer2(String per2) {
        this.per2 = per2;
    }
    
    /**
     * @return the lib1
     */   
    public String getLib1() {
        return lib1;
    }

    /**
     * @param lib1 String
     */
    public void setLib1(String lib1) {
        this.lib1 = lib1;
    }
    
    /**
     * @return the lib2
     */   
    public String getLib2() {
        return lib2;
    }

    /**
     * @param lib2 String
     */
    public void setLib2(String lib2) {
        this.lib2 = lib2;
    }

    /**
     * @return the lib3
     */   
    public String getLib3() {
        return lib3;
    }

    /**
     * @param lib3 String
     */
    public void setLib3(String lib3) {
        this.lib3 = lib3;
    }


    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("comps", this.comps);
        jsonObj.put("runcd", this.runcd);
        jsonObj.put("procs", this.procs);
        jsonObj.put("prosm", this.prosm);
        jsonObj.put("mstsm", this.mstsm);
        jsonObj.put("daygu", this.daygu);
        jsonObj.put("prtno", this.prtno);
        jsonObj.put("ordat", this.ordat);
        jsonObj.put("cyctm", this.cyctm);
        jsonObj.put("fstqy", this.fstqy);
        jsonObj.put("atoqy", this.atoqy);
        jsonObj.put("prdqy", this.prdqy);
        jsonObj.put("fstqyRate", this.fstqyRate);
        jsonObj.put("atoqyRate", this.atoqyRate);
        jsonObj.put("rowgb", this.rowgb);
        jsonObj.put("sum1", this.sum1);
        jsonObj.put("sum2", this.sum2);
        jsonObj.put("sum3", this.sum3);
        jsonObj.put("per1", this.per1);
        jsonObj.put("per2", this.per2);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}
