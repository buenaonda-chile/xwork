package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] DB2 개선상세 정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class PsogmImprvDDomain implements Serializable{
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -1051410553915942418L;
    
    /**
     * [KO] 사업장<br>
     */
    private String comps;
    
    /**
     * [KO] 지시번호<br>
     */
    private String jisno;
    
    /**
     * [KO] 테마<br>
     */
    private String teima;
    
    /**
     * [KO] 대상<br>
     */
    private String daesn;
    
    /**
     * [KO] 착안점<br>
     */
    private String chkan;
    
    /**
     * [KO] 협력부서<br>
     */
    private String kyoru;
    
    /**
     * [KO] 개선전이미지<br>
     */
    private String imgbf;
    
    /**
     * [KO] 개선후이미지<br>
     */
    private String imgaf;
    
    /**
     * [KO] 개선비용<br>
     */
    private String kcost;
    
    /**
     * [KO] A효과 합계<br>
     */
    private String aSum;
    
    /**
     * [KO] B효과 합계<br>
     */
    private String bSum;
    
    /**
     * [KO] C효과 합계<br>
     */
    private String cSum;
    
    /**
     * [KO] D효과 합계<br>
     */
    private String dSum;
    
    /**
     * [KO] 효과 합계<br>
     */
    private String tSum;
    
    /**
     * [KO] A1현상<br>
     */
    private String a1hyn;
    
    /**
     * [KO] A1개선비용<br>
     */
    private String a1cst;
    
    /**
     * [KO] A1효과<br>
     */
    private String a1hyo;
    
    /**
     * [KO] A2효과<br>
     */
    private String a2hyo;
    
    /**
     * [KO] A3현상<br>
     */
    private String a3hyn;
    
    /**
     * [KO] A3개선비용<br>
     */
    private String a3cst;

    /**
     * [KO] A3효과<br>
     */
    private String a3hyo;
    
    /**
     * [KO] A4현상<br>
     */
    private String a4hyn;
    
    /**
     * [KO] A4개선비용<br>
     */
    private String a4cst;
    
    /**
     * [KO] A4개선후비용<br>
     */
    private String a4aft;

    /**
     * [KO] A4효과<br>
     */
    private String a4hyo;
    
    /**
     * [KO] A5현상<br>
     */
    private String a5hyn;
    
    /**
     * [KO] A5개선후비용<br>
     */
    private String a5aft;

    /**
     * [KO] A5효과<br>
     */
    private String a5hyo;
    
    /**
     * [KO] A6현상<br>
     */
    private String a6hyn;
    
    /**
     * [KO] A6개선비용<br>
     */
    private String a6cst;
    
    /**
     * [KO] A6개선후비용<br>
     */
    private String a6aft;

    /**
     * [KO] A6효과<br>
     */
    private String a6hyo;
    
    /**
     * [KO] B1현상<br>
     */
    private String b1hyn;
    
    /**
     * [KO] B1개선비용<br>
     */
    private String b1cst;
    
    /**
     * [KO] B1개선후비용<br>
     */
    private String b1aft;

    /**
     * [KO] B1효과<br>
     */
    private String b1hyo;
    
    /**
     * [KO] B2현상<br>
     */
    private String b2hyn;
    
    /**
     * [KO] B2개선비용<br>
     */
    private String b2cst;
    
    /**
     * [KO] B2개선후비용<br>
     */
    private String b2aft;

    /**
     * [KO] B2효과<br>
     */
    private String b2hyo;
    
    /**
     * [KO] B3현상<br>
     */
    private String b3hyn;
    
    /**
     * [KO] B3개선비용<br>
     */
    private String b3cst;
    
    /**
     * [KO] B3개선후비용<br>
     */
    private String b3aft;

    /**
     * [KO] B3효과<br>
     */
    private String b3hyo;
    
    /**
     * [KO] B4현상<br>
     */
    private String b4hyn;
    
    /**
     * [KO] B4개선비용<br>
     */
    private String b4cst;
    
    /**
     * [KO] B4개선후비용<br>
     */
    private String b4aft;

    /**
     * [KO] B4효과<br>
     */
    private String b4hyo;
    
    /**
     * [KO] C1현상<br>
     */
    private String c1hyn;
    
    /**
     * [KO] C1개선비용<br>
     */
    private String c1cst;
    
    /**
     * [KO] C1개선후비용<br>
     */
    private String c1aft;

    /**
     * [KO] C1효과<br>
     */
    private String c1hyo;
    
    /**
     * [KO] C2현상<br>
     */
    private String c2hyn;
    
    /**
     * [KO] C2개선비용<br>
     */
    private String c2cst;
    
    /**
     * [KO] C2개선후비용<br>
     */
    private String c2aft;

    /**
     * [KO] C2효과<br>
     */
    private String c2hyo;
    
    /**
     * [KO] C3현상<br>
     */
    private String c3hyn;
    
    /**
     * [KO] C3개선비용<br>
     */
    private String c3cst;
    
    /**
     * [KO] C3개선후비용<br>
     */
    private String c3aft;

    /**
     * [KO] C3효과<br>
     */
    private String c3hyo;
    
    /**
     * [KO] C4현상<br>
     */
    private String c4hyn;
    
    /**
     * [KO] C4개선비용<br>
     */
    private String c4cst;
    
    /**
     * [KO] C4개선후비용<br>
     */
    private String c4aft;

    /**
     * [KO] C4효과<br>
     */
    private String c4hyo;
    
    /**
     * [KO] D11현상<br>
     */
    private String d1hyn;
    
    /**
     * [KO] D11개선비용<br>
     */
    private String d1cst;
    
    /**
     * [KO] D11개선후비용<br>
     */
    private String d1aft;

    /**
     * [KO] D11효과<br>
     */
    private String d1hyo;
    
    /**
     * [KO] D12현상<br>
     */
    private String d2hyn;
    
    /**
     * [KO] D12개선비용<br>
     */
    private String d2cst;
    
    /**
     * [KO] D12개선후비용<br>
     */
    private String d2aft;

    /**
     * [KO] D12효과<br>
     */
    private String d2hyo;
    
    /**
     * [KO] D13현상<br>
     */
    private String d3hyn;
    
    /**
     * [KO] D13개선비용<br>
     */
    private String d3cst;
    
    /**
     * [KO] D13개선후비용<br>
     */
    private String d3aft;

    /**
     * [KO] D13효과<br>
     */
    private String d3hyo;
    
    /**
     * [KO] D15현상<br>
     */
    private String d5hyn;
    
    /**
     * [KO] D15개선후비용<br>
     */
    private String d5aft;

    /**
     * [KO] D15효과<br>
     */
    private String d5hyo;
    
    /**
     * [KO] D17현상<br>
     */
    private String d7hyn;
    
    /**
     * [KO] D17개선비용<br>
     */
    private String d7cst;
    
    /**
     * [KO] D17개선후비용<br>
     */
    private String d7aft;

    /**
     * [KO] D17효과<br>
     */
    private String d7hyo;
    
    /**
     * [KO] D18현상<br>
     */
    private String d8hyn;
    
    /**
     * [KO] D18개선후비용<br>
     */
    private String d8aft;

    /**
     * [KO] D18효과<br>
     */
    private String d8hyo;
    
    /**
     * [KO] D20현상<br>
     */
    private String dbhyn;
    
    /**
     * [KO] D20개선비용<br>
     */
    private String dbcst;
    
    /**
     * [KO] D20개선후비용<br>
     */
    private String dbaft;

    /**
     * [KO] D20효과<br>
     */
    private String dbhyo;
    
    /**
     * [KO] D21현상<br>
     */
    private String dchyn;
    
    /**
     * [KO] D21개선후비용<br>
     */
    private String dcaft;

    /**
     * [KO] D21효과<br>
     */
    private String dchyo;
    
    /**
     * [KO] D22현상<br>
     */
    private String ddhyn;
    
    /**
     * [KO] D22개선비용<br>
     */
    private String ddcst;
    
    /**
     * [KO] D22개선후비용<br>
     */
    private String ddaft;

    /**
     * [KO] D22효과<br>
     */
    private String ddhyo;
    
    /**
     * [KO] D24현상<br>
     */
    private String dehyn;
    
    /**
     * [KO] D24개선후비용<br>
     */
    private String deaft;

    /**
     * [KO] D24효과<br>
     */
    private String dehyo;
    
    /**
     * [KO] D31현상<br>
     */
    private String dfhyn;
    
    /**
     * [KO] D31개선비용<br>
     */
    private String dfcst;
    
    /**
     * [KO] D31개선후비용<br>
     */
    private String dfaft;

    /**
     * [KO] D31효과<br>
     */
    private String dfhyo;
    
    /**
     * [KO] D32현상<br>
     */
    private String dghyn;
    
    /**
     * [KO] D32개선비용<br>
     */
    private String dgcst;
    
    /**
     * [KO] D32개선후비용<br>
     */
    private String dgaft;

    /**
     * [KO] D32효과<br>
     */
    private String dghyo;
    
    /**
     * [KO] D48현상<br>
     */
    private String dhhyn;
    
    /**
     * [KO] D48개선후비용<br>
     */
    private String dhaft;

    /**
     * [KO] D48효과<br>
     */
    private String dhhyo;
    
    /**
     * [KO] D51현상<br>
     */
    private String dihyn;
    
    /**
     * [KO] D51개선비용<br>
     */
    private String dicst;
    
    /**
     * [KO] D51개선후비용<br>
     */
    private String diaft;

    /**
     * [KO] D51효과<br>
     */
    private String dihyo;
    
    /**
     * [KO] D531현상<br>
     */
    private String djhyn;
    
    /**
     * [KO] D53개선비용<br>
     */
    private String djcst;

    /**
     * [KO] D53효과<br>
     */
    private String djhyo;
    
    /**
     * [KO] 등록일자<br>
     */
    private String addat;
    
    /**
     * [KO] 등록시간<br>
     */
    private String adtim;
    
    /**
     * [KO] 등록사원<br>
     */
    private String adusr;
    
    /**
     * [KO] kornm<br>
     */
    private String kornm;
    
    /**
     * [KO] dpdpnm<br>
     */
    private String dpdpnm;

    /**
     * [KO] mshno<br>
     */
    private String mshno;
    
    /**
     * [KO] mshnm<br>
     */
    private String mshnm;
    
    /**
     * [KO] prtnm<br>
     */
    private String prtnm;
    
    /**
     * [KO] linnm<br>
     */
    private String linnm;
    
    /**
     * [KO] daech<br>
     */
    private String daech;
    
    /**
     * [KO] wonin<br>
     */
    private String wonin;
    
    /**
     * [KO] imgpath<br>
     */
    private String imgpath;
    
    /**
     * [KO] wndat<br>
     */
    private String wndat;
    
    /**
     * [KO] LIB2<br>
     */
    private String lib2;
    
    /**
     * [KO] LIB3<br>
     */
    private String lib3;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmImprvDDomain() {
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
     * [KO] jisno의 getter method 이다.<br>
     * [EN] It is a getter method of jisno.<br>
     * [JP] <br>
     * 
     * @return the jisno
     */
    public String getJisno() {
        return jisno;
    }

    /**
     * [KO] jisno의 setter method 이다.<br>
     * [EN] It is a setter method of jisno.<br>
     * [JP] <br>
     * 
     * @param jisno String
     */
    public void setJisno(String jisno) {
        this.jisno = jisno;
    }

    /**
     * [KO] teima의 getter method 이다.<br>
     * [EN] It is a getter method of teima.<br>
     * [JP] <br>
     * 
     * @return the teima
     */
    public String getTeima() {
        return teima;
    }

    /**
     * [KO] teima의 setter method 이다.<br>
     * [EN] It is a setter method of teima.<br>
     * [JP] <br>
     * 
     * @param teima String
     */
    public void setTeima(String teima) {
        this.teima = teima;
    }

    /**
     * [KO] daesn의 getter method 이다.<br>
     * [EN] It is a getter method of daesn.<br>
     * [JP] <br>
     * 
     * @return the daesn
     */
    public String getDaesn() {
        return daesn;
    }

    /**
     * [KO] daesn의 setter method 이다.<br>
     * [EN] It is a setter method of daesn.<br>
     * [JP] <br>
     * 
     * @param daesn String
     */
    public void setDaesn(String daesn) {
        this.daesn = daesn;
    }

    /**
     * [KO] chkan의 getter method 이다.<br>
     * [EN] It is a getter method of chkan.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getChkan() {
        return chkan;
    }

    /**
     * [KO] chkan의 setter method 이다.<br>
     * [EN] It is a setter method of chkan.<br>
     * [JP] <br>
     * 
     * @param chkan String
     */
    public void setChkan(String chkan) {
        this.chkan = chkan;
    }

    /**
     * [KO] kyoru의 getter method 이다.<br>
     * [EN] It is a getter method of kyoru.<br>
     * [JP] <br>
     * 
     * @return the kyoru
     */
    public String getKyoru() {
        return kyoru;
    }

    /**
     * [KO] kyoru의 setter method 이다.<br>
     * [EN] It is a setter method of kyoru.<br>
     * [JP] <br>
     * 
     * @param kyoru String
     */
    public void setKyoru(String kyoru) {
        this.kyoru = kyoru;
    }

    /**
     * [KO] imgbf의 getter method 이다.<br>
     * [EN] It is a getter method of imgbf.<br>
     * [JP] <br>
     * 
     * @return the imgbf
     */
    public String getImgbf() {
        return imgbf;
    }

    /**
     * [KO] imgbf의 setter method 이다.<br>
     * [EN] It is a setter method of imgbf.<br>
     * [JP] <br>
     * 
     * @param imgbf String
     */
    public void setImgbf(String imgbf) {
        this.imgbf = imgbf;
    }

    /**
     * [KO] imgaf의 getter method 이다.<br>
     * [EN] It is a getter method of imgaf.<br>
     * [JP] <br>
     * 
     * @return the imgaf
     */
    public String getImgaf() {
        return imgaf;
    }

    /**
     * [KO] imgaf의 setter method 이다.<br>
     * [EN] It is a setter method of imgaf.<br>
     * [JP] <br>
     * 
     * @param imgaf String
     */
    public void setImgaf(String imgaf) {
        this.imgaf = imgaf;
    }

    /**
     * [KO] kcost의 getter method 이다.<br>
     * [EN] It is a getter method of kcost.<br>
     * [JP] <br>
     * 
     * @return the kcost
     */
    public String getKcost() {
        return kcost;
    }

    /**
     * [KO] kcost의 setter method 이다.<br>
     * [EN] It is a setter method of kcost.<br>
     * [JP] <br>
     * 
     * @param kcost String
     */
    public void setKcost(String kcost) {
        this.kcost = kcost;
    }

    /**
     * [KO] aSum의 getter method 이다.<br>
     * [EN] It is a getter method of aSum.<br>
     * [JP] <br>
     * 
     * @return the aSum
     */
    public String getaSum() {
        return aSum;
    }

    /**
     * [KO] aSum의 setter method 이다.<br>
     * [EN] It is a setter method of aSum.<br>
     * [JP] <br>
     * 
     * @param aSum String
     */
    public void setaSum(String aSum) {
        this.aSum = aSum;
    }

    /**
     * [KO] bSum의 getter method 이다.<br>
     * [EN] It is a getter method of bSum.<br>
     * [JP] <br>
     * 
     * @return the bSum
     */
    public String getbSum() {
        return bSum;
    }

    /**
     * [KO] bSum의 setter method 이다.<br>
     * [EN] It is a setter method of bSum.<br>
     * [JP] <br>
     * 
     * @param bSum String
     */
    public void setbSum(String bSum) {
        this.bSum = bSum;
    }

    /**
     * [KO] 의 getter method 이다.<br>
     * [EN] It is a getter method of db2class.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getcSum() {
        return cSum;
    }

    /**
     * [KO] cSum의 setter method 이다.<br>
     * [EN] It is a setter method of cSum.<br>
     * [JP] <br>
     * 
     * @param cSum String
     */
    public void setcSum(String cSum) {
        this.cSum = cSum;
    }

    /**
     * [KO] dSum의 getter method 이다.<br>
     * [EN] It is a getter method of dSum.<br>
     * [JP] <br>
     * 
     * @return the dSum
     */
    public String getdSum() {
        return dSum;
    }

    /**
     * [KO] dSum의 setter method 이다.<br>
     * [EN] It is a setter method of dSum.<br>
     * [JP] <br>
     * 
     * @param dSum String
     */
    public void setdSum(String dSum) {
        this.dSum = dSum;
    }

    /**
     * [KO] tSum의 getter method 이다.<br>
     * [EN] It is a getter method of tSum.<br>
     * [JP] <br>
     * 
     * @return the tSum
     */
    public String gettSum() {
        return tSum;
    }

    /**
     * [KO] tSum의 setter method 이다.<br>
     * [EN] It is a setter method of tSum.<br>
     * [JP] <br>
     * 
     * @param tSum String
     */
    public void settSum(String tSum) {
        this.tSum = tSum;
    }

    /**
     * [KO] a1hyn의 getter method 이다.<br>
     * [EN] It is a getter method of a1hyn.<br>
     * [JP] <br>
     * 
     * @return the a1hyn
     */
    public String getA1hyn() {
        return a1hyn;
    }

    /**
     * [KO] a1hyn의 setter method 이다.<br>
     * [EN] It is a setter method of a1hyn.<br>
     * [JP] <br>
     * 
     * @param a1hyn String
     */
    public void setA1hyn(String a1hyn) {
        this.a1hyn = a1hyn;
    }

    /**
     * [KO] a1cst의 getter method 이다.<br>
     * [EN] It is a getter method of a1cst.<br>
     * [JP] <br>
     * 
     * @return the a1cst
     */
    public String getA1cst() {
        return a1cst;
    }

    /**
     * [KO] a1cst의 setter method 이다.<br>
     * [EN] It is a setter method of a1cst.<br>
     * [JP] <br>
     * 
     * @param a1cst String
     */
    public void setA1cst(String a1cst) {
        this.a1cst = a1cst;
    }

    /**
     * [KO] a1hyo의 getter method 이다.<br>
     * [EN] It is a getter method of a1hyo.<br>
     * [JP] <br>
     * 
     * @return the a1hyo
     */
    public String getA1hyo() {
        return a1hyo;
    }

    /**
     * [KO] a1hyo의 setter method 이다.<br>
     * [EN] It is a setter method of a1hyo.<br>
     * [JP] <br>
     * 
     * @param a1hyo String
     */
    public void setA1hyo(String a1hyo) {
        this.a1hyo = a1hyo;
    }

    /**
     * [KO] a2hyo의 getter method 이다.<br>
     * [EN] It is a getter method of a2hyo.<br>
     * [JP] <br>
     * 
     * @return the a2hyo
     */
    public String getA2hyo() {
        return a2hyo;
    }

    /**
     * [KO] a2hyo의 setter method 이다.<br>
     * [EN] It is a setter method of a2hyo.<br>
     * [JP] <br>
     * 
     * @param a2hyo String
     */
    public void setA2hyo(String a2hyo) {
        this.a2hyo = a2hyo;
    }

    /**
     * [KO] a3hyn의 getter method 이다.<br>
     * [EN] It is a getter method of a3hyn.<br>
     * [JP] <br>
     * 
     * @return the a3hyn
     */
    public String getA3hyn() {
        return a3hyn;
    }

    /**
     * [KO] a3hyn의 setter method 이다.<br>
     * [EN] It is a setter method of a3hyn.<br>
     * [JP] <br>
     * 
     * @param a3hyn String
     */
    public void setA3hyn(String a3hyn) {
        this.a3hyn = a3hyn;
    }

    /**
     * [KO] a3cst의 getter method 이다.<br>
     * [EN] It is a getter method of a3cst.<br>
     * [JP] <br>
     * 
     * @return the a3cst
     */
    public String getA3cst() {
        return a3cst;
    }

    /**
     * [KO] a3cst의 setter method 이다.<br>
     * [EN] It is a setter method of a3cst.<br>
     * [JP] <br>
     * 
     * @param a3cst String
     */
    public void setA3cst(String a3cst) {
        this.a3cst = a3cst;
    }

    /**
     * [KO] a3hyo의 getter method 이다.<br>
     * [EN] It is a getter method of a3hyo.<br>
     * [JP] <br>
     * 
     * @return the a3hyo
     */
    public String getA3hyo() {
        return a3hyo;
    }

    /**
     * [KO] a3hyo의 setter method 이다.<br>
     * [EN] It is a setter method of db2class.<br>
     * [JP] <br>
     * 
     * @param a3hyo String
     */
    public void setA3hyo(String a3hyo) {
        this.a3hyo = a3hyo;
    }

    /**
     * [KO] a4hyn의 getter method 이다.<br>
     * [EN] It is a getter method of a4hyn.<br>
     * [JP] <br>
     * 
     * @return the a4hyn
     */
    public String getA4hyn() {
        return a4hyn;
    }

    /**
     * [KO] a4hyn의 setter method 이다.<br>
     * [EN] It is a setter method of a4hyn.<br>
     * [JP] <br>
     * 
     * @param a4hyn String
     */
    public void setA4hyn(String a4hyn) {
        this.a4hyn = a4hyn;
    }

    /**
     * [KO] a4cst의 getter method 이다.<br>
     * [EN] It is a getter method of a4cst.<br>
     * [JP] <br>
     * 
     * @return the a4cst
     */
    public String getA4cst() {
        return a4cst;
    }

    /**
     * [KO] a4cst의 setter method 이다.<br>
     * [EN] It is a setter method of a4cst.<br>
     * [JP] <br>
     * 
     * @param a4cst String
     */
    public void setA4cst(String a4cst) {
        this.a4cst = a4cst;
    }

    /**
     * [KO] a4aft의 getter method 이다.<br>
     * [EN] It is a getter method of a4aft.<br>
     * [JP] <br>
     * 
     * @return the a4aft
     */
    public String getA4aft() {
        return a4aft;
    }

    /**
     * [KO] a4aft의 setter method 이다.<br>
     * [EN] It is a setter method of a4aft.<br>
     * [JP] <br>
     * 
     * @param a4aft String
     */
    public void setA4aft(String a4aft) {
        this.a4aft = a4aft;
    }

    /**
     * [KO] a4hyo의 getter method 이다.<br>
     * [EN] It is a getter method of a4hyo.<br>
     * [JP] <br>
     * 
     * @return the a4hyo
     */
    public String getA4hyo() {
        return a4hyo;
    }

    /**
     * [KO] a4hyo의 setter method 이다.<br>
     * [EN] It is a setter method of a4hyo.<br>
     * [JP] <br>
     * 
     * @param a4hyo String
     */
    public void setA4hyo(String a4hyo) {
        this.a4hyo = a4hyo;
    }

    /**
     * [KO] a5hyn의 getter method 이다.<br>
     * [EN] It is a getter method of a5hyn.<br>
     * [JP] <br>
     * 
     * @return the db2a5hynclass
     */
    public String getA5hyn() {
        return a5hyn;
    }

    /**
     * [KO] a5hyn의 setter method 이다.<br>
     * [EN] It is a setter method of a5hyn.<br>
     * [JP] <br>
     * 
     * @param a5hyn String
     */
    public void setA5hyn(String a5hyn) {
        this.a5hyn = a5hyn;
    }

    /**
     * [KO] a5aft의 getter method 이다.<br>
     * [EN] It is a getter method of a5aft.<br>
     * [JP] <br>
     * 
     * @return the a5aft
     */
    public String getA5aft() {
        return a5aft;
    }

    /**
     * [KO] a5aft의 setter method 이다.<br>
     * [EN] It is a setter method of a5aft.<br>
     * [JP] <br>
     * 
     * @param a5aft String
     */
    public void setA5aft(String a5aft) {
        this.a5aft = a5aft;
    }

    /**
     * [KO] a5hyo의 getter method 이다.<br>
     * [EN] It is a getter method of a5hyo.<br>
     * [JP] <br>
     * 
     * @return the a5hyo
     */
    public String getA5hyo() {
        return a5hyo;
    }

    /**
     * [KO] a5hyo의 setter method 이다.<br>
     * [EN] It is a setter method of a5hyo.<br>
     * [JP] <br>
     * 
     * @param a5hyo String
     */
    public void setA5hyo(String a5hyo) {
        this.a5hyo = a5hyo;
    }

    /**
     * [KO] a6hyn의 getter method 이다.<br>
     * [EN] It is a getter method of a6hyn.<br>
     * [JP] <br>
     * 
     * @return the a6hyn
     */
    public String getA6hyn() {
        return a6hyn;
    }

    /**
     * [KO] a6hyn의 setter method 이다.<br>
     * [EN] It is a setter method of a6hyn.<br>
     * [JP] <br>
     * 
     * @param a6hyn String
     */
    public void setA6hyn(String a6hyn) {
        this.a6hyn = a6hyn;
    }

    /**
     * [KO] a6cst의 getter method 이다.<br>
     * [EN] It is a getter method of a6cst.<br>
     * [JP] <br>
     * 
     * @return the a6cst
     */
    public String getA6cst() {
        return a6cst;
    }

    /**
     * [KO] a6cst의 setter method 이다.<br>
     * [EN] It is a setter method of a6cst.<br>
     * [JP] <br>
     * 
     * @param a6cst String
     */
    public void setA6cst(String a6cst) {
        this.a6cst = a6cst;
    }

    /**
     * [KO] a6aft의 getter method 이다.<br>
     * [EN] It is a getter method of a6aft.<br>
     * [JP] <br>
     * 
     * @return the a6aft
     */
    public String getA6aft() {
        return a6aft;
    }

    /**
     * [KO] a6aft의 setter method 이다.<br>
     * [EN] It is a setter method of a6aft.<br>
     * [JP] <br>
     * 
     * @param a6aft String
     */
    public void setA6aft(String a6aft) {
        this.a6aft = a6aft;
    }

    /**
     * [KO] a6hyo의 getter method 이다.<br>
     * [EN] It is a getter method of a6hyo.<br>
     * [JP] <br>
     * 
     * @return the a6hyo
     */
    public String getA6hyo() {
        return a6hyo;
    }

    /**
     * [KO] a6hyo의 setter method 이다.<br>
     * [EN] It is a setter method of a6hyo.<br>
     * [JP] <br>
     * 
     * @param a6hyo String
     */
    public void setA6hyo(String a6hyo) {
        this.a6hyo = a6hyo;
    }

    /**
     * [KO] b1hyn의 getter method 이다.<br>
     * [EN] It is a getter method of b1hyn.<br>
     * [JP] <br>
     * 
     * @return the b1hyn
     */
    public String getB1hyn() {
        return b1hyn;
    }

    /**
     * [KO] b1hyn의 setter method 이다.<br>
     * [EN] It is a setter method of b1hyn.<br>
     * [JP] <br>
     * 
     * @param b1hyn String
     */
    public void setB1hyn(String b1hyn) {
        this.b1hyn = b1hyn;
    }

    /**
     * [KO] b1cst의 getter method 이다.<br>
     * [EN] It is a getter method of b1cst.<br>
     * [JP] <br>
     * 
     * @return the b1cst
     */
    public String getB1cst() {
        return b1cst;
    }

    /**
     * [KO] b1cst의 setter method 이다.<br>
     * [EN] It is a setter method of b1cst.<br>
     * [JP] <br>
     * 
     * @param b1cst String
     */
    public void setB1cst(String b1cst) {
        this.b1cst = b1cst;
    }

    /**
     * [KO] b1aft의 getter method 이다.<br>
     * [EN] It is a getter method of b1aft.<br>
     * [JP] <br>
     * 
     * @return the b1aft
     */
    public String getB1aft() {
        return b1aft;
    }

    /**
     * [KO] b1aft의 setter method 이다.<br>
     * [EN] It is a setter method of b1aft.<br>
     * [JP] <br>
     * 
     * @param b1aft String
     */
    public void setB1aft(String b1aft) {
        this.b1aft = b1aft;
    }

    /**
     * [KO] b1hyo의 getter method 이다.<br>
     * [EN] It is a getter method of b1hyo.<br>
     * [JP] <br>
     * 
     * @return the b1hyo
     */
    public String getB1hyo() {
        return b1hyo;
    }

    /**
     * [KO] b1hyo의 setter method 이다.<br>
     * [EN] It is a setter method of b1hyo.<br>
     * [JP] <br>
     * 
     * @param b1hyo String
     */
    public void setB1hyo(String b1hyo) {
        this.b1hyo = b1hyo;
    }

    /**
     * [KO] b2hyn의 getter method 이다.<br>
     * [EN] It is a getter method of b2hyn.<br>
     * [JP] <br>
     * 
     * @return the b2hyn
     */
    public String getB2hyn() {
        return b2hyn;
    }

    /**
     * [KO] b2hyn의 setter method 이다.<br>
     * [EN] It is a setter method of b2hyn.<br>
     * [JP] <br>
     * 
     * @param b2hyn String
     */
    public void setB2hyn(String b2hyn) {
        this.b2hyn = b2hyn;
    }

    /**
     * [KO] b2cst의 getter method 이다.<br>
     * [EN] It is a getter method of b2cst.<br>
     * [JP] <br>
     * 
     * @return the b2cst
     */
    public String getB2cst() {
        return b2cst;
    }

    /**
     * [KO] b2cst의 setter method 이다.<br>
     * [EN] It is a setter method of b2cst.<br>
     * [JP] <br>
     * 
     * @param b2cst String
     */
    public void setB2cst(String b2cst) {
        this.b2cst = b2cst;
    }

    /**
     * [KO] b2aft의 getter method 이다.<br>
     * [EN] It is a getter method of b2aft.<br>
     * [JP] <br>
     * 
     * @return the b2aft
     */
    public String getB2aft() {
        return b2aft;
    }

    /**
     * [KO] b2aft의 setter method 이다.<br>
     * [EN] It is a setter method of b2aft.<br>
     * [JP] <br>
     * 
     * @param b2aft String
     */
    public void setB2aft(String b2aft) {
        this.b2aft = b2aft;
    }

    /**
     * [KO] b2hyo의 getter method 이다.<br>
     * [EN] It is a getter method of b2hyo.<br>
     * [JP] <br>
     * 
     * @return the b2hyo
     */
    public String getB2hyo() {
        return b2hyo;
    }

    /**
     * [KO] b2hyo의 setter method 이다.<br>
     * [EN] It is a setter method of b2hyo.<br>
     * [JP] <br>
     * 
     * @param b2hyo String
     */
    public void setB2hyo(String b2hyo) {
        this.b2hyo = b2hyo;
    }

    /**
     * [KO] b3hyn의 getter method 이다.<br>
     * [EN] It is a getter method of b3hyn.<br>
     * [JP] <br>
     * 
     * @return the b3hyn
     */
    public String getB3hyn() {
        return b3hyn;
    }

    /**
     * [KO] b3hyn의 setter method 이다.<br>
     * [EN] It is a setter method of b3hyn.<br>
     * [JP] <br>
     * 
     * @param b3hyn String
     */
    public void setB3hyn(String b3hyn) {
        this.b3hyn = b3hyn;
    }

    /**
     * [KO] b3cst의 getter method 이다.<br>
     * [EN] It is a getter method of b3cst.<br>
     * [JP] <br>
     * 
     * @return the b3cst
     */
    public String getB3cst() {
        return b3cst;
    }

    /**
     * [KO] b3cst의 setter method 이다.<br>
     * [EN] It is a setter method of b3cst.<br>
     * [JP] <br>
     * 
     * @param b3cst String
     */
    public void setB3cst(String b3cst) {
        this.b3cst = b3cst;
    }

    /**
     * [KO] b3aft의 getter method 이다.<br>
     * [EN] It is a getter method of b3aft.<br>
     * [JP] <br>
     * 
     * @return the b3aft
     */
    public String getB3aft() {
        return b3aft;
    }

    /**
     * [KO] b3aft의 setter method 이다.<br>
     * [EN] It is a setter method of b3aft.<br>
     * [JP] <br>
     * 
     * @param b3aft String
     */
    public void setB3aft(String b3aft) {
        this.b3aft = b3aft;
    }

    /**
     * [KO] b3hyo의 getter method 이다.<br>
     * [EN] It is a getter method of b3hyo.<br>
     * [JP] <br>
     * 
     * @return the b3hyo
     */
    public String getB3hyo() {
        return b3hyo;
    }

    /**
     * [KO] b3hyo의 setter method 이다.<br>
     * [EN] It is a setter method of b3hyo.<br>
     * [JP] <br>
     * 
     * @param b3hyo String
     */
    public void setB3hyo(String b3hyo) {
        this.b3hyo = b3hyo;
    }

    /**
     * [KO] b4hyn의 getter method 이다.<br>
     * [EN] It is a getter method of b4hyn.<br>
     * [JP] <br>
     * 
     * @return the b4hyn
     */
    public String getB4hyn() {
        return b4hyn;
    }

    /**
     * [KO] b4hyn의 setter method 이다.<br>
     * [EN] It is a setter method of b4hyn.<br>
     * [JP] <br>
     * 
     * @param b4hyn String
     */
    public void setB4hyn(String b4hyn) {
        this.b4hyn = b4hyn;
    }

    /**
     * [KO] b4cst의 getter method 이다.<br>
     * [EN] It is a getter method of b4cst.<br>
     * [JP] <br>
     * 
     * @return the b4cst
     */
    public String getB4cst() {
        return b4cst;
    }

    /**
     * [KO] b4cst의 setter method 이다.<br>
     * [EN] It is a setter method of b4cst.<br>
     * [JP] <br>
     * 
     * @param b4cst String
     */
    public void setB4cst(String b4cst) {
        this.b4cst = b4cst;
    }

    /**
     * [KO] b4aft의 getter method 이다.<br>
     * [EN] It is a getter method of b4aft.<br>
     * [JP] <br>
     * 
     * @return the b4aft
     */
    public String getB4aft() {
        return b4aft;
    }

    /**
     * [KO] b4aft의 setter method 이다.<br>
     * [EN] It is a setter method of b4aft.<br>
     * [JP] <br>
     * 
     * @param b4aft String
     */
    public void setB4aft(String b4aft) {
        this.b4aft = b4aft;
    }

    /**
     * [KO] b4hyo의 getter method 이다.<br>
     * [EN] It is a getter method of b4hyo.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getB4hyo() {
        return b4hyo;
    }

    /**
     * [KO] b4hyo의 setter method 이다.<br>
     * [EN] It is a setter method of b4hyo.<br>
     * [JP] <br>
     * 
     * @param b4hyo String
     */
    public void setB4hyo(String b4hyo) {
        this.b4hyo = b4hyo;
    }

    /**
     * [KO] c1hyn의 getter method 이다.<br>
     * [EN] It is a getter method of c1hyn.<br>
     * [JP] <br>
     * 
     * @return the c1hyn
     */
    public String getC1hyn() {
        return c1hyn;
    }

    /**
     * [KO] c1hyn의 setter method 이다.<br>
     * [EN] It is a setter method of c1hyn.<br>
     * [JP] <br>
     * 
     * @param c1hyn String
     */
    public void setC1hyn(String c1hyn) {
        this.c1hyn = c1hyn;
    }

    /**
     * [KO] c1cst의 getter method 이다.<br>
     * [EN] It is a getter method of c1cst.<br>
     * [JP] <br>
     * 
     * @return the c1cst
     */
    public String getC1cst() {
        return c1cst;
    }

    /**
     * [KO] c1cst의 setter method 이다.<br>
     * [EN] It is a setter method of c1cst.<br>
     * [JP] <br>
     * 
     * @param c1cst String
     */
    public void setC1cst(String c1cst) {
        this.c1cst = c1cst;
    }

    /**
     * [KO] c1aft의 getter method 이다.<br>
     * [EN] It is a getter method of c1aft.<br>
     * [JP] <br>
     * 
     * @return the c1aft
     */
    public String getC1aft() {
        return c1aft;
    }

    /**
     * [KO] c1aft의 setter method 이다.<br>
     * [EN] It is a setter method of c1aft.<br>
     * [JP] <br>
     * 
     * @param c1aft String
     */
    public void setC1aft(String c1aft) {
        this.c1aft = c1aft;
    }

    /**
     * [KO] c1hyo의 getter method 이다.<br>
     * [EN] It is a getter method of c1hyo.<br>
     * [JP] <br>
     * 
     * @return the c1hyo
     */
    public String getC1hyo() {
        return c1hyo;
    }

    /**
     * [KO] c1hyo의 setter method 이다.<br>
     * [EN] It is a setter method of c1hyo.<br>
     * [JP] <br>
     * 
     * @param c1hyo String
     */
    public void setC1hyo(String c1hyo) {
        this.c1hyo = c1hyo;
    }

    /**
     * [KO] c2hyn의 getter method 이다.<br>
     * [EN] It is a getter method of c2hyn.<br>
     * [JP] <br>
     * 
     * @return the c2hyn
     */
    public String getC2hyn() {
        return c2hyn;
    }

    /**
     * [KO] c2hyn의 setter method 이다.<br>
     * [EN] It is a setter method of c2hyn.<br>
     * [JP] <br>
     * 
     * @param c2hyn String
     */
    public void setC2hyn(String c2hyn) {
        this.c2hyn = c2hyn;
    }

    /**
     * [KO] c2cst의 getter method 이다.<br>
     * [EN] It is a getter method of c2cst.<br>
     * [JP] <br>
     * 
     * @return the c2cst
     */
    public String getC2cst() {
        return c2cst;
    }

    /**
     * [KO] c2cst의 setter method 이다.<br>
     * [EN] It is a setter method of c2cst.<br>
     * [JP] <br>
     * 
     * @param c2cst String
     */
    public void setC2cst(String c2cst) {
        this.c2cst = c2cst;
    }

    /**
     * [KO] c2aft의 getter method 이다.<br>
     * [EN] It is a getter method of c2aft.<br>
     * [JP] <br>
     * 
     * @return the c2aft
     */
    public String getC2aft() {
        return c2aft;
    }

    /**
     * [KO] c2aft의 setter method 이다.<br>
     * [EN] It is a setter method of c2aft.<br>
     * [JP] <br>
     * 
     * @param c2aft String
     */
    public void setC2aft(String c2aft) {
        this.c2aft = c2aft;
    }

    /**
     * [KO] c2hyo의 getter method 이다.<br>
     * [EN] It is a getter method of c2hyo.<br>
     * [JP] <br>
     * 
     * @return the c2hyo
     */
    public String getC2hyo() {
        return c2hyo;
    }

    /**
     * [KO] c2hyo의 setter method 이다.<br>
     * [EN] It is a setter method of c2hyo.<br>
     * [JP] <br>
     * 
     * @param c2hyo String
     */
    public void setC2hyo(String c2hyo) {
        this.c2hyo = c2hyo;
    }

    /**
     * [KO] c3hyn의 getter method 이다.<br>
     * [EN] It is a getter method of c3hyn.<br>
     * [JP] <br>
     * 
     * @return the c3hyn
     */
    public String getC3hyn() {
        return c3hyn;
    }

    /**
     * [KO] c3hyn의 setter method 이다.<br>
     * [EN] It is a setter method of c3hyn.<br>
     * [JP] <br>
     * 
     * @param c3hyn String
     */
    public void setC3hyn(String c3hyn) {
        this.c3hyn = c3hyn;
    }

    /**
     * [KO] c3cst의 getter method 이다.<br>
     * [EN] It is a getter method of c3cst.<br>
     * [JP] <br>
     * 
     * @return the c3cst
     */
    public String getC3cst() {
        return c3cst;
    }

    /**
     * [KO] c3cst의 setter method 이다.<br>
     * [EN] It is a setter method of c3cst.<br>
     * [JP] <br>
     * 
     * @param c3cst String
     */
    public void setC3cst(String c3cst) {
        this.c3cst = c3cst;
    }

    /**
     * [KO] c3aft의 getter method 이다.<br>
     * [EN] It is a getter method of c3aft.<br>
     * [JP] <br>
     * 
     * @return the c3aft
     */
    public String getC3aft() {
        return c3aft;
    }

    /**
     * [KO] c3aft의 setter method 이다.<br>
     * [EN] It is a setter method of c3aft.<br>
     * [JP] <br>
     * 
     * @param c3aft String
     */
    public void setC3aft(String c3aft) {
        this.c3aft = c3aft;
    }

    /**
     * [KO] c3hyo의 getter method 이다.<br>
     * [EN] It is a getter method of c3hyo.<br>
     * [JP] <br>
     * 
     * @return the c3hyo
     */
    public String getC3hyo() {
        return c3hyo;
    }

    /**
     * [KO] c3hyo의 setter method 이다.<br>
     * [EN] It is a setter method of c3hyo.<br>
     * [JP] <br>
     * 
     * @param c3hyo String
     */
    public void setC3hyo(String c3hyo) {
        this.c3hyo = c3hyo;
    }

    /**
     * [KO] c4hyn의 getter method 이다.<br>
     * [EN] It is a getter method of c4hyn.<br>
     * [JP] <br>
     * 
     * @return the c4hyn
     */
    public String getC4hyn() {
        return c4hyn;
    }

    /**
     * [KO] c4hyn의 setter method 이다.<br>
     * [EN] It is a setter method of c4hyn.<br>
     * [JP] <br>
     * 
     * @param c4hyn String
     */
    public void setC4hyn(String c4hyn) {
        this.c4hyn = c4hyn;
    }

    /**
     * [KO] c4cst의 getter method 이다.<br>
     * [EN] It is a getter method of c4cst.<br>
     * [JP] <br>
     * 
     * @return the c4cst
     */
    public String getC4cst() {
        return c4cst;
    }

    /**
     * [KO] c4cst의 setter method 이다.<br>
     * [EN] It is a setter method of c4cst.<br>
     * [JP] <br>
     * 
     * @param c4cst String
     */
    public void setC4cst(String c4cst) {
        this.c4cst = c4cst;
    }

    /**
     * [KO] c4aft의 getter method 이다.<br>
     * [EN] It is a getter method of c4aft.<br>
     * [JP] <br>
     * 
     * @return the c4aft
     */
    public String getC4aft() {
        return c4aft;
    }

    /**
     * [KO] c4aft의 setter method 이다.<br>
     * [EN] It is a setter method of c4aft.<br>
     * [JP] <br>
     * 
     * @param c4aft String
     */
    public void setC4aft(String c4aft) {
        this.c4aft = c4aft;
    }

    /**
     * [KO] c4hyo의 getter method 이다.<br>
     * [EN] It is a getter method of c4hyo.<br>
     * [JP] <br>
     * 
     * @return the c4hyo
     */
    public String getC4hyo() {
        return c4hyo;
    }

    /**
     * [KO] c4hyo의 setter method 이다.<br>
     * [EN] It is a setter method of c4hyo.<br>
     * [JP] <br>
     * 
     * @param c4hyo String
     */
    public void setC4hyo(String c4hyo) {
        this.c4hyo = c4hyo;
    }

    /**
     * [KO] d1hyn의 getter method 이다.<br>
     * [EN] It is a getter method of d1hyn.<br>
     * [JP] <br>
     * 
     * @return the d1hyn
     */
    public String getD1hyn() {
        return d1hyn;
    }

    /**
     * [KO] d1hyn의 setter method 이다.<br>
     * [EN] It is a setter method of d1hyn.<br>
     * [JP] <br>
     * 
     * @param d1hyn String
     */
    public void setD1hyn(String d1hyn) {
        this.d1hyn = d1hyn;
    }

    /**
     * [KO] d1cst의 getter method 이다.<br>
     * [EN] It is a getter method of d1cst.<br>
     * [JP] <br>
     * 
     * @return the d1cst
     */
    public String getD1cst() {
        return d1cst;
    }

    /**
     * [KO] d1cst의 setter method 이다.<br>
     * [EN] It is a setter method of d1cst.<br>
     * [JP] <br>
     * 
     * @param d1cst String
     */
    public void setD1cst(String d1cst) {
        this.d1cst = d1cst;
    }

    /**
     * [KO] d1aft의 getter method 이다.<br>
     * [EN] It is a getter method of d1aft.<br>
     * [JP] <br>
     * 
     * @return the d1aft
     */
    public String getD1aft() {
        return d1aft;
    }

    /**
     * [KO] d1aft의 setter method 이다.<br>
     * [EN] It is a setter method of d1aft.<br>
     * [JP] <br>
     * 
     * @param d1aft String
     */
    public void setD1aft(String d1aft) {
        this.d1aft = d1aft;
    }

    /**
     * [KO] d1hyo의 getter method 이다.<br>
     * [EN] It is a getter method of d1hyo.<br>
     * [JP] <br>
     * 
     * @return the d1hyo
     */
    public String getD1hyo() {
        return d1hyo;
    }

    /**
     * [KO] d1hyo의 setter method 이다.<br>
     * [EN] It is a setter method of d1hyo.<br>
     * [JP] <br>
     * 
     * @param d1hyo String
     */
    public void setD1hyo(String d1hyo) {
        this.d1hyo = d1hyo;
    }

    /**
     * [KO] d2hyn의 getter method 이다.<br>
     * [EN] It is a getter method of d2hyn.<br>
     * [JP] <br>
     * 
     * @return the d2hyn
     */
    public String getD2hyn() {
        return d2hyn;
    }

    /**
     * [KO] d2hyn의 setter method 이다.<br>
     * [EN] It is a setter method of d2hyn.<br>
     * [JP] <br>
     * 
     * @param d2hyn String
     */
    public void setD2hyn(String d2hyn) {
        this.d2hyn = d2hyn;
    }

    /**
     * [KO] d2cst의 getter method 이다.<br>
     * [EN] It is a getter method of d2cst.<br>
     * [JP] <br>
     * 
     * @return the d2cst
     */
    public String getD2cst() {
        return d2cst;
    }

    /**
     * [KO] d2cst의 setter method 이다.<br>
     * [EN] It is a setter method of d2cst.<br>
     * [JP] <br>
     * 
     * @param d2cst String
     */
    public void setD2cst(String d2cst) {
        this.d2cst = d2cst;
    }

    /**
     * [KO] d2aft의 getter method 이다.<br>
     * [EN] It is a getter method of d2aft.<br>
     * [JP] <br>
     * 
     * @return the d2aft
     */
    public String getD2aft() {
        return d2aft;
    }

    /**
     * [KO] d2aft의 setter method 이다.<br>
     * [EN] It is a setter method of d2aft.<br>
     * [JP] <br>
     * 
     * @param d2aft String
     */
    public void setD2aft(String d2aft) {
        this.d2aft = d2aft;
    }

    /**
     * [KO] d2hyo의 getter method 이다.<br>
     * [EN] It is a getter method of d2hyo.<br>
     * [JP] <br>
     * 
     * @return the d2hyo
     */
    public String getD2hyo() {
        return d2hyo;
    }

    /**
     * [KO] d2hyo의 setter method 이다.<br>
     * [EN] It is a setter method of d2hyo.<br>
     * [JP] <br>
     * 
     * @param d2hyo String
     */
    public void setD2hyo(String d2hyo) {
        this.d2hyo = d2hyo;
    }

    /**
     * [KO] d3hyn의 getter method 이다.<br>
     * [EN] It is a getter method of d3hyn.<br>
     * [JP] <br>
     * 
     * @return the d3hyn
     */
    public String getD3hyn() {
        return d3hyn;
    }

    /**
     * [KO] d3hyn의 setter method 이다.<br>
     * [EN] It is a setter method of d3hyn.<br>
     * [JP] <br>
     * 
     * @param d3hyn String
     */
    public void setD3hyn(String d3hyn) {
        this.d3hyn = d3hyn;
    }

    /**
     * [KO] d3cst의 getter method 이다.<br>
     * [EN] It is a getter method of d3cst.<br>
     * [JP] <br>
     * 
     * @return the d3cst
     */
    public String getD3cst() {
        return d3cst;
    }

    /**
     * [KO] d3cst의 setter method 이다.<br>
     * [EN] It is a setter method of d3cst.<br>
     * [JP] <br>
     * 
     * @param d3cst String
     */
    public void setD3cst(String d3cst) {
        this.d3cst = d3cst;
    }

    /**
     * [KO] d3aft의 getter method 이다.<br>
     * [EN] It is a getter method of d3aft.<br>
     * [JP] <br>
     * 
     * @return the d3aft
     */
    public String getD3aft() {
        return d3aft;
    }

    /**
     * [KO] d3aft의 setter method 이다.<br>
     * [EN] It is a setter method of d3aft.<br>
     * [JP] <br>
     * 
     * @param d3aft String
     */
    public void setD3aft(String d3aft) {
        this.d3aft = d3aft;
    }

    /**
     * [KO] d3hyo의 getter method 이다.<br>
     * [EN] It is a getter method of d3hyo.<br>
     * [JP] <br>
     * 
     * @return the d3hyo
     */
    public String getD3hyo() {
        return d3hyo;
    }

    /**
     * [KO] d3hyo의 setter method 이다.<br>
     * [EN] It is a setter method of d3hyo.<br>
     * [JP] <br>
     * 
     * @param d3hyo String
     */
    public void setD3hyo(String d3hyo) {
        this.d3hyo = d3hyo;
    }

    /**
     * [KO] d5hyn의 getter method 이다.<br>
     * [EN] It is a getter method of d5hyn.<br>
     * [JP] <br>
     * 
     * @return the d5hyn
     */
    public String getD5hyn() {
        return d5hyn;
    }

    /**
     * [KO] d5hyn의 setter method 이다.<br>
     * [EN] It is a setter method of d5hyn.<br>
     * [JP] <br>
     * 
     * @param d5hyn String
     */
    public void setD5hyn(String d5hyn) {
        this.d5hyn = d5hyn;
    }

    /**
     * [KO] d5aft의 getter method 이다.<br>
     * [EN] It is a getter method of d5aft.<br>
     * [JP] <br>
     * 
     * @return the d5aft
     */
    public String getD5aft() {
        return d5aft;
    }

    /**
     * [KO] d5aft의 setter method 이다.<br>
     * [EN] It is a setter method of d5aft.<br>
     * [JP] <br>
     * 
     * @param d5aft String
     */
    public void setD5aft(String d5aft) {
        this.d5aft = d5aft;
    }

    /**
     * [KO] d5hyo의 getter method 이다.<br>
     * [EN] It is a getter method of d5hyo.<br>
     * [JP] <br>
     * 
     * @return the d5hyo
     */
    public String getD5hyo() {
        return d5hyo;
    }

    /**
     * [KO] d5hyo의 setter method 이다.<br>
     * [EN] It is a setter method of d5hyo.<br>
     * [JP] <br>
     * 
     * @param d5hyo String
     */
    public void setD5hyo(String d5hyo) {
        this.d5hyo = d5hyo;
    }

    /**
     * [KO] d7hyn의 getter method 이다.<br>
     * [EN] It is a getter method of d7hyn.<br>
     * [JP] <br>
     * 
     * @return the d7hyn
     */
    public String getD7hyn() {
        return d7hyn;
    }

    /**
     * [KO] d7hyn의 setter method 이다.<br>
     * [EN] It is a setter method of d7hyn.<br>
     * [JP] <br>
     * 
     * @param d7hyn String
     */
    public void setD7hyn(String d7hyn) {
        this.d7hyn = d7hyn;
    }

    /**
     * [KO] d7cst의 getter method 이다.<br>
     * [EN] It is a getter method of d7cst.<br>
     * [JP] <br>
     * 
     * @return the d7cst
     */
    public String getD7cst() {
        return d7cst;
    }

    /**
     * [KO] d7cst의 setter method 이다.<br>
     * [EN] It is a setter method of d7cst.<br>
     * [JP] <br>
     * 
     * @param d7cst String
     */
    public void setD7cst(String d7cst) {
        this.d7cst = d7cst;
    }

    /**
     * [KO] d7aft의 getter method 이다.<br>
     * [EN] It is a getter method of d7aft.<br>
     * [JP] <br>
     * 
     * @return the d7aft
     */
    public String getD7aft() {
        return d7aft;
    }

    /**
     * [KO] d7aft의 setter method 이다.<br>
     * [EN] It is a setter method of d7aft.<br>
     * [JP] <br>
     * 
     * @param d7aft String
     */
    public void setD7aft(String d7aft) {
        this.d7aft = d7aft;
    }

    /**
     * [KO] d7hyo의 getter method 이다.<br>
     * [EN] It is a getter method of d7hyo.<br>
     * [JP] <br>
     * 
     * @return the d7hyo
     */
    public String getD7hyo() {
        return d7hyo;
    }

    /**
     * [KO] d7hyo의 setter method 이다.<br>
     * [EN] It is a setter method of d7hyo.<br>
     * [JP] <br>
     * 
     * @param d7hyo String
     */
    public void setD7hyo(String d7hyo) {
        this.d7hyo = d7hyo;
    }

    /**
     * [KO] d8hyn의 getter method 이다.<br>
     * [EN] It is a getter method of d8hyn.<br>
     * [JP] <br>
     * 
     * @return the d8hyn
     */
    public String getD8hyn() {
        return d8hyn;
    }

    /**
     * [KO] d8hyn의 setter method 이다.<br>
     * [EN] It is a setter method of d8hyn.<br>
     * [JP] <br>
     * 
     * @param d8hyn String
     */
    public void setD8hyn(String d8hyn) {
        this.d8hyn = d8hyn;
    }

    /**
     * [KO] d8aft의 getter method 이다.<br>
     * [EN] It is a getter method of d8aft.<br>
     * [JP] <br>
     * 
     * @return the d8aft
     */
    public String getD8aft() {
        return d8aft;
    }

    /**
     * [KO] d8aft의 setter method 이다.<br>
     * [EN] It is a setter method of d8aft.<br>
     * [JP] <br>
     * 
     * @param d8aft String
     */
    public void setD8aft(String d8aft) {
        this.d8aft = d8aft;
    }

    /**
     * [KO] d8hyo의 getter method 이다.<br>
     * [EN] It is a getter method of d8hyo.<br>
     * [JP] <br>
     * 
     * @return the d8hyo
     */
    public String getD8hyo() {
        return d8hyo;
    }

    /**
     * [KO] d8hyo의 setter method 이다.<br>
     * [EN] It is a setter method of d8hyo.<br>
     * [JP] <br>
     * 
     * @param d8hyo String
     */
    public void setD8hyo(String d8hyo) {
        this.d8hyo = d8hyo;
    }

    /**
     * [KO] dbhyn의 getter method 이다.<br>
     * [EN] It is a getter method of dbhyn.<br>
     * [JP] <br>
     * 
     * @return the dbhyn
     */
    public String getDbhyn() {
        return dbhyn;
    }

    /**
     * [KO] dbhyn의 setter method 이다.<br>
     * [EN] It is a setter method of dbhyn.<br>
     * [JP] <br>
     * 
     * @param dbhyn String
     */
    public void setDbhyn(String dbhyn) {
        this.dbhyn = dbhyn;
    }

    /**
     * [KO] dbcst의 getter method 이다.<br>
     * [EN] It is a getter method of dbcst.<br>
     * [JP] <br>
     * 
     * @return the dbcst
     */
    public String getDbcst() {
        return dbcst;
    }

    /**
     * [KO] dbcst의 setter method 이다.<br>
     * [EN] It is a setter method of dbcst.<br>
     * [JP] <br>
     * 
     * @param dbcst String
     */
    public void setDbcst(String dbcst) {
        this.dbcst = dbcst;
    }

    /**
     * [KO] dbaft의 getter method 이다.<br>
     * [EN] It is a getter method of dbaft.<br>
     * [JP] <br>
     * 
     * @return the dbaft
     */
    public String getDbaft() {
        return dbaft;
    }

    /**
     * [KO] dbaft의 setter method 이다.<br>
     * [EN] It is a setter method of dbaft.<br>
     * [JP] <br>
     * 
     * @param dbaft String
     */
    public void setDbaft(String dbaft) {
        this.dbaft = dbaft;
    }

    /**
     * [KO] dbhyo의 getter method 이다.<br>
     * [EN] It is a getter method of dbhyo.<br>
     * [JP] <br>
     * 
     * @return the dbhyo
     */
    public String getDbhyo() {
        return dbhyo;
    }

    /**
     * [KO] dbhyo의 setter method 이다.<br>
     * [EN] It is a setter method of dbhyo.<br>
     * [JP] <br>
     * 
     * @param dbhyo String
     */
    public void setDbhyo(String dbhyo) {
        this.dbhyo = dbhyo;
    }

    /**
     * [KO] dchyn의 getter method 이다.<br>
     * [EN] It is a getter method of dchyn.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getDchyn() {
        return dchyn;
    }

    /**
     * [KO] dchyn의 setter method 이다.<br>
     * [EN] It is a setter method of dchyn.<br>
     * [JP] <br>
     * 
     * @param dchyn String
     */
    public void setDchyn(String dchyn) {
        this.dchyn = dchyn;
    }

    /**
     * [KO] dcaft의 getter method 이다.<br>
     * [EN] It is a getter method of dcaft.<br>
     * [JP] <br>
     * 
     * @return the dcaft
     */
    public String getDcaft() {
        return dcaft;
    }

    /**
     * [KO] dcaft의 setter method 이다.<br>
     * [EN] It is a setter method of dcaft.<br>
     * [JP] <br>
     * 
     * @param dcaft String
     */
    public void setDcaft(String dcaft) {
        this.dcaft = dcaft;
    }

    /**
     * [KO] dchyo의 getter method 이다.<br>
     * [EN] It is a getter method of dchyo.<br>
     * [JP] <br>
     * 
     * @return the dchyo
     */
    public String getDchyo() {
        return dchyo;
    }

    /**
     * [KO] dchyo의 setter method 이다.<br>
     * [EN] It is a setter method of dchyo.<br>
     * [JP] <br>
     * 
     * @param dchyo String
     */
    public void setDchyo(String dchyo) {
        this.dchyo = dchyo;
    }

    /**
     * [KO] ddhyn의 getter method 이다.<br>
     * [EN] It is a getter method of ddhyn.<br>
     * [JP] <br>
     * 
     * @return the ddhyn
     */
    public String getDdhyn() {
        return ddhyn;
    }

    /**
     * [KO] ddhyn의 setter method 이다.<br>
     * [EN] It is a setter method of ddhyn.<br>
     * [JP] <br>
     * 
     * @param ddhyn String
     */
    public void setDdhyn(String ddhyn) {
        this.ddhyn = ddhyn;
    }

    /**
     * [KO] ddcst의 getter method 이다.<br>
     * [EN] It is a getter method of ddcst.<br>
     * [JP] <br>
     * 
     * @return the ddcst
     */
    public String getDdcst() {
        return ddcst;
    }

    /**
     * [KO] ddcst의 setter method 이다.<br>
     * [EN] It is a setter method of ddcst.<br>
     * [JP] <br>
     * 
     * @param ddcst String
     */
    public void setDdcst(String ddcst) {
        this.ddcst = ddcst;
    }

    /**
     * [KO] ddaft의 getter method 이다.<br>
     * [EN] It is a getter method of ddaft.<br>
     * [JP] <br>
     * 
     * @return the ddaft
     */
    public String getDdaft() {
        return ddaft;
    }

    /**
     * [KO] ddaft의 setter method 이다.<br>
     * [EN] It is a setter method of ddaft.<br>
     * [JP] <br>
     * 
     * @param ddaft String
     */
    public void setDdaft(String ddaft) {
        this.ddaft = ddaft;
    }

    /**
     * [KO] ddhyo의 getter method 이다.<br>
     * [EN] It is a getter method of ddhyo.<br>
     * [JP] <br>
     * 
     * @return the ddhyo
     */
    public String getDdhyo() {
        return ddhyo;
    }

    /**
     * [KO] ddhyo의 setter method 이다.<br>
     * [EN] It is a setter method of ddhyo.<br>
     * [JP] <br>
     * 
     * @param ddhyo String
     */
    public void setDdhyo(String ddhyo) {
        this.ddhyo = ddhyo;
    }

    /**
     * [KO] dehyn의 getter method 이다.<br>
     * [EN] It is a getter method of dehyn.<br>
     * [JP] <br>
     * 
     * @return the dehyn
     */
    public String getDehyn() {
        return dehyn;
    }

    /**
     * [KO] dehyn의 setter method 이다.<br>
     * [EN] It is a setter method of dehyn.<br>
     * [JP] <br>
     * 
     * @param dehyn String
     */
    public void setDehyn(String dehyn) {
        this.dehyn = dehyn;
    }

    /**
     * [KO] deaft의 getter method 이다.<br>
     * [EN] It is a getter method of deaft.<br>
     * [JP] <br>
     * 
     * @return the deaft
     */
    public String getDeaft() {
        return deaft;
    }

    /**
     * [KO] deaft의 setter method 이다.<br>
     * [EN] It is a setter method of deaft.<br>
     * [JP] <br>
     * 
     * @param deaft String
     */
    public void setDeaft(String deaft) {
        this.deaft = deaft;
    }

    /**
     * [KO] dehyo의 getter method 이다.<br>
     * [EN] It is a getter method of dehyo.<br>
     * [JP] <br>
     * 
     * @return the dehyo
     */
    public String getDehyo() {
        return dehyo;
    }

    /**
     * [KO] dehyo의 setter method 이다.<br>
     * [EN] It is a setter method of dehyo.<br>
     * [JP] <br>
     * 
     * @param dehyo String
     */
    public void setDehyo(String dehyo) {
        this.dehyo = dehyo;
    }

    /**
     * [KO] dfhyn의 getter method 이다.<br>
     * [EN] It is a getter method of dfhyn.<br>
     * [JP] <br>
     * 
     * @return the dfhyn
     */
    public String getDfhyn() {
        return dfhyn;
    }

    /**
     * [KO] dfhyn의 setter method 이다.<br>
     * [EN] It is a setter method of dfhyn.<br>
     * [JP] <br>
     * 
     * @param dfhyn String
     */
    public void setDfhyn(String dfhyn) {
        this.dfhyn = dfhyn;
    }

    /**
     * [KO] dfcst의 getter method 이다.<br>
     * [EN] It is a getter method of dfcst.<br>
     * [JP] <br>
     * 
     * @return the dfcst
     */
    public String getDfcst() {
        return dfcst;
    }

    /**
     * [KO] dfcst의 setter method 이다.<br>
     * [EN] It is a setter method of dfcst.<br>
     * [JP] <br>
     * 
     * @param dfcst String
     */
    public void setDfcst(String dfcst) {
        this.dfcst = dfcst;
    }

    /**
     * [KO] dfaft의 getter method 이다.<br>
     * [EN] It is a getter method of dfaft.<br>
     * [JP] <br>
     * 
     * @return the dfaft
     */
    public String getDfaft() {
        return dfaft;
    }

    /**
     * [KO] dfaft의 setter method 이다.<br>
     * [EN] It is a setter method of dfaft.<br>
     * [JP] <br>
     * 
     * @param dfaft String
     */
    public void setDfaft(String dfaft) {
        this.dfaft = dfaft;
    }

    /**
     * [KO] dfhyo의 getter method 이다.<br>
     * [EN] It is a getter method of dfhyo.<br>
     * [JP] <br>
     * 
     * @return the dfhyo
     */
    public String getDfhyo() {
        return dfhyo;
    }

    /**
     * [KO] dfhyo의 setter method 이다.<br>
     * [EN] It is a setter method of dfhyo.<br>
     * [JP] <br>
     * 
     * @param dfhyo String
     */
    public void setDfhyo(String dfhyo) {
        this.dfhyo = dfhyo;
    }

    /**
     * [KO] dghyn의 getter method 이다.<br>
     * [EN] It is a getter method of dghyn.<br>
     * [JP] <br>
     * 
     * @return the dghyn
     */
    public String getDghyn() {
        return dghyn;
    }

    /**
     * [KO] dghyn의 setter method 이다.<br>
     * [EN] It is a setter method of dghyn.<br>
     * [JP] <br>
     * 
     * @param dghyn String
     */
    public void setDghyn(String dghyn) {
        this.dghyn = dghyn;
    }

    /**
     * [KO] dgcst의 getter method 이다.<br>
     * [EN] It is a getter method of dgcst.<br>
     * [JP] <br>
     * 
     * @return the dgcst
     */
    public String getDgcst() {
        return dgcst;
    }

    /**
     * [KO] dgcst의 setter method 이다.<br>
     * [EN] It is a setter method of dgcst.<br>
     * [JP] <br>
     * 
     * @param dgcst String
     */
    public void setDgcst(String dgcst) {
        this.dgcst = dgcst;
    }

    /**
     * [KO] dgaft의 getter method 이다.<br>
     * [EN] It is a getter method of dgaft.<br>
     * [JP] <br>
     * 
     * @return the dgaft
     */
    public String getDgaft() {
        return dgaft;
    }

    /**
     * [KO] dgaft의 setter method 이다.<br>
     * [EN] It is a setter method of dgaft.<br>
     * [JP] <br>
     * 
     * @param dgaft String
     */
    public void setDgaft(String dgaft) {
        this.dgaft = dgaft;
    }

    /**
     * [KO] dghyo의 getter method 이다.<br>
     * [EN] It is a getter method of dghyo.<br>
     * [JP] <br>
     * 
     * @return the dghyo
     */
    public String getDghyo() {
        return dghyo;
    }

    /**
     * [KO] dghyo의 setter method 이다.<br>
     * [EN] It is a setter method of dghyo.<br>
     * [JP] <br>
     * 
     * @param dghyo String
     */
    public void setDghyo(String dghyo) {
        this.dghyo = dghyo;
    }

    /**
     * [KO] dhhyn의 getter method 이다.<br>
     * [EN] It is a getter method of dhhyn.<br>
     * [JP] <br>
     * 
     * @return the dhhyn
     */
    public String getDhhyn() {
        return dhhyn;
    }

    /**
     * [KO] dhhyn의 setter method 이다.<br>
     * [EN] It is a setter method of dhhyn.<br>
     * [JP] <br>
     * 
     * @param dhhyn String
     */
    public void setDhhyn(String dhhyn) {
        this.dhhyn = dhhyn;
    }

    /**
     * [KO] dhaft의 getter method 이다.<br>
     * [EN] It is a getter method of dhaft.<br>
     * [JP] <br>
     * 
     * @return the dhaft
     */
    public String getDhaft() {
        return dhaft;
    }

    /**
     * [KO] dhaft의 setter method 이다.<br>
     * [EN] It is a setter method of dhaft.<br>
     * [JP] <br>
     * 
     * @param dhaft String
     */
    public void setDhaft(String dhaft) {
        this.dhaft = dhaft;
    }

    /**
     * [KO] dhhyo의 getter method 이다.<br>
     * [EN] It is a getter method of dhhyo.<br>
     * [JP] <br>
     * 
     * @return the dhhyo
     */
    public String getDhhyo() {
        return dhhyo;
    }

    /**
     * [KO] dhhyo의 setter method 이다.<br>
     * [EN] It is a setter method of dhhyo.<br>
     * [JP] <br>
     * 
     * @param dhhyo String
     */
    public void setDhhyo(String dhhyo) {
        this.dhhyo = dhhyo;
    }

    /**
     * [KO] dihyn의 getter method 이다.<br>
     * [EN] It is a getter method of dihyn.<br>
     * [JP] <br>
     * 
     * @return the dihyn
     */
    public String getDihyn() {
        return dihyn;
    }

    /**
     * [KO] dihyn의 setter method 이다.<br>
     * [EN] It is a setter method of dihyn.<br>
     * [JP] <br>
     * 
     * @param dihyn String
     */
    public void setDihyn(String dihyn) {
        this.dihyn = dihyn;
    }

    /**
     * [KO] dicst의 getter method 이다.<br>
     * [EN] It is a getter method of dicst.<br>
     * [JP] <br>
     * 
     * @return the dicst
     */
    public String getDicst() {
        return dicst;
    }

    /**
     * [KO] dicst의 setter method 이다.<br>
     * [EN] It is a setter method of dicst.<br>
     * [JP] <br>
     * 
     * @param dicst String
     */
    public void setDicst(String dicst) {
        this.dicst = dicst;
    }

    /**
     * [KO] diaft의 getter method 이다.<br>
     * [EN] It is a getter method of diaft.<br>
     * [JP] <br>
     * 
     * @return the diaft
     */
    public String getDiaft() {
        return diaft;
    }

    /**
     * [KO] diaft의 setter method 이다.<br>
     * [EN] It is a setter method of diaft.<br>
     * [JP] <br>
     * 
     * @param diaft String
     */
    public void setDiaft(String diaft) {
        this.diaft = diaft;
    }

    /**
     * [KO] dihyo의 getter method 이다.<br>
     * [EN] It is a getter method of dihyo.<br>
     * [JP] <br>
     * 
     * @return the dihyo
     */
    public String getDihyo() {
        return dihyo;
    }

    /**
     * [KO] dihyo의 setter method 이다.<br>
     * [EN] It is a setter method of dihyo.<br>
     * [JP] <br>
     * 
     * @param dihyo String
     */
    public void setDihyo(String dihyo) {
        this.dihyo = dihyo;
    }

    /**
     * [KO] djhyn의 getter method 이다.<br>
     * [EN] It is a getter method of djhyn.<br>
     * [JP] <br>
     * 
     * @return the djhyn
     */
    public String getDjhyn() {
        return djhyn;
    }

    /**
     * [KO] djhyn의 setter method 이다.<br>
     * [EN] It is a setter method of djhyn.<br>
     * [JP] <br>
     * 
     * @param djhyn String
     */
    public void setDjhyn(String djhyn) {
        this.djhyn = djhyn;
    }

    /**
     * [KO] djcst의 getter method 이다.<br>
     * [EN] It is a getter method of djcst.<br>
     * [JP] <br>
     * 
     * @return the djcst
     */
    public String getDjcst() {
        return djcst;
    }

    /**
     * [KO] djcst의 setter method 이다.<br>
     * [EN] It is a setter method of djcst.<br>
     * [JP] <br>
     * 
     * @param djcst String
     */
    public void setDjcst(String djcst) {
        this.djcst = djcst;
    }

    /**
     * [KO] djhyo의 getter method 이다.<br>
     * [EN] It is a getter method of djhyo.<br>
     * [JP] <br>
     * 
     * @return the djhyo
     */
    public String getDjhyo() {
        return djhyo;
    }

    /**
     * [KO] djhyo의 setter method 이다.<br>
     * [EN] It is a setter method of djhyo.<br>
     * [JP] <br>
     * 
     * @param djhyo String
     */
    public void setDjhyo(String djhyo) {
        this.djhyo = djhyo;
    }

    /**
     * [KO] addat의 getter method 이다.<br>
     * [EN] It is a getter method of addat.<br>
     * [JP] <br>
     * 
     * @return the addat
     */
    public String getAddat() {
        return addat;
    }

    /**
     * [KO] addat의 setter method 이다.<br>
     * [EN] It is a setter method of addat.<br>
     * [JP] <br>
     * 
     * @param addat String
     */
    public void setAddat(String addat) {
        this.addat = addat;
    }
    
    /**
     * [KO] adtim의 getter method 이다.<br>
     * [EN] It is a getter method of adtim.<br>
     * [JP] <br>
     * 
     * @return the adtim
     */
    public String getAdtim() {
        return adtim;
    }

    /**
     * [KO] adtim의 setter method 이다.<br>
     * [EN] It is a setter method of adtim.<br>
     * [JP] <br>
     * 
     * @param adtim String
     */
    public void setAdtim(String adtim) {
        this.adtim = adtim;
    }
    
    /**
     * [KO] adusr의 getter method 이다.<br>
     * [EN] It is a getter method of adusr.<br>
     * [JP] <br>
     * 
     * @return the adusr
     */
    public String getAdusr() {
        return adusr;
    }

    /**
     * [KO] adusr의 setter method 이다.<br>
     * [EN] It is a setter method of adusr.<br>
     * [JP] <br>
     * 
     * @param adusr String
     */
    public void setAdusr(String adusr) {
        this.adusr = adusr;
    }

    /**
     * [KO] kornm의 getter method 이다.<br>
     * [EN] It is a getter method of kornm.<br>
     * [JP] <br>
     * 
     * @return the kornm
     */
    public String getKornm() {
        return kornm;
    }

    /**
     * [KO] kornm의 setter method 이다.<br>
     * [EN] It is a setter method of kornm.<br>
     * [JP] <br>
     * 
     * @param kornm String
     */
    public void setKornm(String kornm) {
        this.kornm = kornm;
    }

    /**
     * [KO] dpdpnm의 getter method 이다.<br>
     * [EN] It is a getter method of dpdpnm.<br>
     * [JP] <br>
     * 
     * @return the dpdpnm
     */
    public String getDpdpnm() {
        return dpdpnm;
    }

    /**
     * [KO] dpdpnm의 setter method 이다.<br>
     * [EN] It is a setter method of dpdpnm.<br>
     * [JP] <br>
     * 
     * @param dpdpnm String
     */
    public void setDpdpnm(String dpdpnm) {
        this.dpdpnm = dpdpnm;
    }

    /**
     * [KO] mshno의 getter method 이다.<br>
     * [EN] It is a getter method of mshno.<br>
     * [JP] <br>
     * 
     * @return the mshno
     */
    public String getMshno() {
        return mshno;
    }

    /**
     * [KO] mshno의 setter method 이다.<br>
     * [EN] It is a setter method of mshno.<br>
     * [JP] <br>
     * 
     * @param mshno String
     */
    public void setMshno(String mshno) {
        this.mshno = mshno;
    }

    /**
     * [KO] mshnm의 getter method 이다.<br>
     * [EN] It is a getter method of mshnm.<br>
     * [JP] <br>
     * 
     * @return the mshnm
     */
    public String getMshnm() {
        return mshnm;
    }

    /**
     * [KO] mshnm의 setter method 이다.<br>
     * [EN] It is a setter method of mshnm.<br>
     * [JP] <br>
     * 
     * @param mshnm String
     */
    public void setMshnm(String mshnm) {
        this.mshnm = mshnm;
    }

    /**
     * [KO] prtnm의 getter method 이다.<br>
     * [EN] It is a getter method of prtnm.<br>
     * [JP] <br>
     * 
     * @return the prtnm
     */
    public String getPrtnm() {
        return prtnm;
    }

    /**
     * [KO] prtnm의 setter method 이다.<br>
     * [EN] It is a setter method of prtnm.<br>
     * [JP] <br>
     * 
     * @param prtnm String
     */
    public void setPrtnm(String prtnm) {
        this.prtnm = prtnm;
    }

    /**
     * [KO] linnm의 getter method 이다.<br>
     * [EN] It is a getter method of linnm.<br>
     * [JP] <br>
     * 
     * @return the linnm
     */
    public String getLinnm() {
        return linnm;
    }

    /**
     * [KO] linnm의 setter method 이다.<br>
     * [EN] It is a setter method of linnm.<br>
     * [JP] <br>
     * 
     * @param linnm String
     */
    public void setLinnm(String linnm) {
        this.linnm = linnm;
    }

    /**
     * [KO] daech의 getter method 이다.<br>
     * [EN] It is a getter method of daech.<br>
     * [JP] <br>
     * 
     * @return the daech
     */
    public String getDaech() {
        return daech;
    }

    /**
     * [KO] daech의 setter method 이다.<br>
     * [EN] It is a setter method of daech.<br>
     * [JP] <br>
     * 
     * @param daech String
     */
    public void setDaech(String daech) {
        this.daech = daech;
    }
    
    /**
     * [KO] wonin의 getter method 이다.<br>
     * [EN] It is a getter method of wonin.<br>
     * [JP] <br>
     * 
     * @return the wonin
     */
    public String getWonin() {
        return wonin;
    }

    /**
     * [KO] wonin의 setter method 이다.<br>
     * [EN] It is a setter method of wonin.<br>
     * [JP] <br>
     * 
     * @param wonin String
     */
    public void setWonin(String wonin) {
        this.wonin = wonin;
    }
    
    /**
     * [KO] imgpath의 getter method 이다.<br>
     * [EN] It is a getter method of imgpath.<br>
     * [JP] <br>
     * 
     * @return the imgpath
     */
    public String getPath() {
        return imgpath;
    }

    /**
     * [KO] imgpath의 setter method 이다.<br>
     * [EN] It is a setter method of imgpath.<br>
     * [JP] <br>
     * 
     * @param imgpath String
     */
    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    /**
     * [KO] wndat의 getter method 이다.<br>
     * [EN] It is a getter method of wndat.<br>
     * [JP] <br>
     * 
     * @return the wndat
     */
    public String getWndat() {
        return wndat;
    }

    /**
     * [KO] wndat의 setter method 이다.<br>
     * [EN] It is a setter method of wndat.<br>
     * [JP] <br>
     * 
     * @param wndat String
     */
    public void setWndat(String wndat) {
        this.wndat = wndat;
    }
    
    /**
     * [KO] lib2의 getter method 이다.<br>
     * [EN] It is a getter method of lib2.<br>
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
     * [EN] It is a getter method of lib3.<br>
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
    
    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("jisno", this.jisno);
        jsonObj.put("imgbf", this.imgbf);
        jsonObj.put("imgaf", this.imgaf);
        jsonObj.put("className", super.toString());
        String rtnStr = jsonObj.toJSONString();
        return rtnStr;
    }
}
