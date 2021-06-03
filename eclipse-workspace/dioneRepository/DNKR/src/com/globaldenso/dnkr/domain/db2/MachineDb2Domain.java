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
public class MachineDb2Domain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -4989482440907071198L;

    /**
     * [KO] code<br>
     */
    private String mshno;
    
    /**
     * [KO] DB2 coded1<br>
     */
    private String mshnm;
    
    /**
     * [KO] DB2 comps<br>
     */
    private String comps;
    
    /**
     * [KR] 팀코드<br>
     */
    private String  timcd;
    
    /**
     * [KR] 팀명<br>
     */
    private String  timnm;
    
    /**
     * [KR] 파트코드<br>
     */
    private String  prtcd;
    
    /**
     * [KR] 파트명<br>
     */
    private String  prtnm;
    
    /**
     * [KR] 라인코드<br>
     */
    private String  lincd;
    
    /**
     * [KR] 설비취득일자<br>
     */
    private String  indat;
    
    /**
     * [EN] Employee lib1.<br>
     * [JP] <br>
     */
    private String  lib1;
    
    /**
     * [EN] Employee lib2.<br>
     * [JP] <br>
     */
    private String  lib2;
    
    /**
     * [EN] Employee lib3.<br>
     * [JP] <br>
     */
    private String  lib3;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public MachineDb2Domain() {
        // no process
    }

    /**
     * [KO] 설비번호의 getter method 이다.<br>
     * [EN] It is a getter method of mshno.<br>
     * [JP] <br>
     * 
     * @return the mshno
     */
    public String getMshno() {
        return mshno;
    }

    /**
     * [KO] 설비번호의 setter method 이다.<br>
     * [EN] It is a setter method of mshno.<br>
     * [JP] <br>
     * 
     * @param mshno String
     */
    public void setMshno(String mshno) {
        this.mshno = mshno;
    }

    /**
     * [KO] 설비명의 getter method 이다.<br>
     * [EN] It is a getter method of mshnm.<br>
     * [JP] <br>
     * 
     * @return the mshnm
     */
    public String getMshnm() {
        return mshnm;
    }

    /**
     * [KO] 설비명의 setter method 이다.<br>
     * [EN] It is a setter method of mshnm.<br>
     * [JP] <br>
     * 
     * @param mshnm String
     */
    public void setMshnm(String mshnm) {
        this.mshnm = mshnm;
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
     * [KO] 팀코드의 getter method 이다.<br>
     * [EN] It is a getter method of timcd.<br>
     * [JP] <br>
     * 
     * @return the timcd
     */
    public String getTimcd() {
        return timcd;
    }

    /**
     * [KO] 팀코드의 setter method 이다.<br>
     * [EN] It is a setter method of timcd.<br>
     * [JP] <br>
     * 
     * @param timcd String
     */
    public void setTimcd(String timcd) {
        this.timcd = timcd;
    }

    /**
     * [KO] 팀명의 getter method 이다.<br>
     * [EN] It is a getter method of timnm.<br>
     * [JP] <br>
     * 
     * @return the timnm
     */
    public String getTimnm() {
        return timnm;
    }

    /**
     * [KO] 팀명의 setter method 이다.<br>
     * [EN] It is a setter method of timnm.<br>
     * [JP] <br>
     * 
     * @param timnm String
     */
    public void setTimnm(String timnm) {
        this.timnm = timnm;
    }

    /**
     * [KO] 파트코드의 getter method 이다.<br>
     * [EN] It is a getter method of prtcd.<br>
     * [JP] <br>
     * 
     * @return the prtcd
     */
    public String getPrtcd() {
        return prtcd;
    }

    /**
     * [KO] 파트코드의 setter method 이다.<br>
     * [EN] It is a setter method of prtcd.<br>
     * [JP] <br>
     * 
     * @param prtcd String
     */
    public void setPrtcd(String prtcd) {
        this.prtcd = prtcd;
    }

    /**
     * [KO] 파트명의 getter method 이다.<br>
     * [EN] It is a getter method of prtnm.<br>
     * [JP] <br>
     * 
     * @return the prtnm
     */
    public String getPrtnm() {
        return prtnm;
    }

    /**
     * [KO] 파트명의 setter method 이다.<br>
     * [EN] It is a setter method of prtnm.<br>
     * [JP] <br>
     * 
     * @param prtnm String
     */
    public void setPrtnm(String prtnm) {
        this.prtnm = prtnm;
    }

    /**
     * [KO] 라인코드의 getter method 이다.<br>
     * [EN] It is a getter method of lincd.<br>
     * [JP] <br>
     * 
     * @return the lincd
     */
    public String getLincd() {
        return lincd;
    }

    /**
     * [KO] 라인코드의 setter method 이다.<br>
     * [EN] It is a setter method of lincd.<br>
     * [JP] <br>
     * 
     * @param lincd String
     */
    public void setLincd(String lincd) {
        this.lincd = lincd;
    }
    
    
    /**
     * [KO] 설비취득일자의 getter method 이다.<br>
     * [EN] It is a getter method of indat.<br>
     * [JP] <br>
     * 
     * @return the indat
     */
    public String getIndat() {
        return indat;
    }

    /**
     * [KO] 설비취득일자의 setter method 이다.<br>
     * [EN] It is a setter method of indat.<br>
     * [JP] <br>
     * 
     * @param indat String
     */
    public void setIndat(String indat) {
        this.indat = indat;
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
        jsonObj.put("mshno", this.mshno);
        jsonObj.put("mshnm", this.mshnm);
        jsonObj.put("comps", this.comps);
        jsonObj.put("timcd", this.timcd);
        jsonObj.put("timnm", this.timnm);
        jsonObj.put("prtcd", this.prtcd);
        jsonObj.put("prtnm", this.prtnm);
        jsonObj.put("lincd", this.lincd);
        jsonObj.put("indat", this.indat);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}
