package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

/**
 * [KR] DB2 코드정보 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class OrderDb2Domain implements Serializable{

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 4648614880859983486L;

    
    /**
     * [KO] DB2 class<br>
     */
    private String db2class;
    
    /**
     * [KO] DB2 cprtn<br>
     */
    private String cprtn;
    
    /**
     * [KO] DB2 cusno<br>
     */
    private String cusno;
    
    /**
     * [KO] DB2 prtno<br>
     */
    private String prtno;
    
    private String mohtq;
    private String itdsc;
    private String mkalc;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderDb2Domain() {
        // no process
    }
    
    /**
     * [KO] db2class의 getter method 이다.<br>
     * [EN] It is a getter method of db2class.<br>
     * [JP] <br>
     * 
     * @return the db2class
     */
    public String getDb2class() {
        return db2class;
    }

    /**
     * [KO] db2class의 setter method 이다.<br>
     * [EN] It is a setter method of db2class.<br>
     * [JP] <br>
     * 
     * @param db2class String
     */
    public void setDb2class(String db2class) {
        this.db2class = db2class;
    }

    /**
     * [KO] cprtn의 getter method 이다.<br>
     * [EN] It is a getter method of cprtn.<br>
     * [JP] <br>
     * 
     * @return the cprtn
     */
    public String getCprtn() {
        return cprtn;
    }

    /**
     * [KO] cprtn의 setter method 이다.<br>
     * [EN] It is a setter method of cprtn.<br>
     * [JP] <br>
     * 
     * @param cprtn String
     */
    public void setCprtn(String cprtn) {
        this.cprtn = cprtn;
    }

    /**
     * [KO] cusno의 getter method 이다.<br>
     * [EN] It is a getter method of cusno.<br>
     * [JP] <br>
     * 
     * @return the cusno
     */
    public String getCusno() {
        return cusno;
    }

    /**
     * [KO] cusno의 setter method 이다.<br>
     * [EN] It is a setter method of cusno.<br>
     * [JP] <br>
     * 
     * @param cusno String
     */
    public void setCusno(String cusno) {
        this.cusno = cusno;
    }

    /**
     * [KO] serialVersionUID의 getter method 이다.<br>
     * [EN] It is a getter method of serialVersionUID.<br>
     * [JP] <br>
     * 
     * @return the serialVersionUID
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
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

	public String getMohtq() {
		return mohtq;
	}

	public void setMohtq(String mohtq) {
		this.mohtq = mohtq;
	}

	public String getItdsc() {
		return itdsc;
	}

	public void setItdsc(String itdsc) {
		this.itdsc = itdsc;
	}

	public String getMkalc() {
		return mkalc;
	}

	public void setMkalc(String mkalc) {
		this.mkalc = mkalc;
	}
    
}
