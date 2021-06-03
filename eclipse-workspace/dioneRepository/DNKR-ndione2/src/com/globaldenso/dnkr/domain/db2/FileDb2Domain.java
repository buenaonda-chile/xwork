package com.globaldenso.dnkr.domain.db2;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * 
 * [KO] 첨부파일 도메인
 *
 * @author $Author$
 * @version $Revision$
 */
public class FileDb2Domain implements Serializable{

    /**
    * [EN] Serial Version UID.<br>
    * [JP] シリアルバージョンID。<br>
    */
    private static final long serialVersionUID = 3810606681552934364L;
    
    /**
     * [KO] 일련번호
     */
    private String seqno;

    /**
     * [KO] 사업장
     */
    private String comps;
    
    /**
     * [KO] 지시번호
     */
    private String jisno;
    
    /**
     * [KO] 파일 타입(확장자)
     */
    private String ftype;
    
    /**
     * [KO] 자료 종류
     */
    private String siryo;
    
    /**
     * [KO] 파일 경로
     */
    private String filnm;
    
    /**
     * [KO] DB2 데이터베이스
     */
    private String lib2;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public FileDb2Domain() {
        // no process
    }


    /**
     * [KO] 공통 코드의 getter method 이다.<br>
     * [EN] It is a getter method of seqno.<br>
     * [JP] <br>
     * 
     * @return the seqno
     */
    public String getSeqno() {
        return seqno;
    }

    /**
     * [KO] seqno의 setter method 이다.<br>
     * [EN] It is a setter method of seqno.<br>
     * [JP] <br>
     * 
     * @param seqno String
     */
    public void setSeqno(String seqno) {
        this.seqno = seqno;
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
     * [KO] ftype의 getter method 이다.<br>
     * [EN] It is a getter method of ftype.<br>
     * [JP] <br>
     * 
     * @return the ftype
     */
    public String getFtype() {
        return ftype;
    }

    /**
     * [KO] ftype의 setter method 이다.<br>
     * [EN] It is a setter method of ftype.<br>
     * [JP] <br>
     * 
     * @param ftype String
     */
    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    /**
     * [KO] siryo의 getter method 이다.<br>
     * [EN] It is a getter method of siryo.<br>
     * [JP] <br>
     * 
     * @return the siryo
     */
    public String getSiryo() {
        return siryo;
    }

    /**
     * [KO] siryo의 setter method 이다.<br>
     * [EN] It is a setter method of siryo.<br>
     * [JP] <br>
     * 
     * @param siryo String
     */
    public void setSiryo(String siryo) {
        this.siryo = siryo;
    }

    /**
     * [KO] filnm의 getter method 이다.<br>
     * [EN] It is a getter method of filnm.<br>
     * [JP] <br>
     * 
     * @return the filnm
     */
    public String getFilnm() {
        return filnm;
    }

    /**
     * [KO] filnm의 setter method 이다.<br>
     * [EN] It is a setter method of filnm.<br>
     * [JP] <br>
     * 
     * @param filnm String
     */
    public void setFilnm(String filnm) {
        this.filnm = filnm;
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

    @Override
    public String toString() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("siryo", this.siryo);
        jsonObj.put("ftype", this.ftype);
        jsonObj.put("seqno", this.seqno);
        String rtnStr = jsonObj.toJSONString();
        
        return rtnStr;
    }
}
