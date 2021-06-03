package com.globaldenso.dnkr.domain;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * [KR] 파일업로드파라메터관리 도메인 클레스 <br>
 * 
 * 
 * @author $Author$
 * @version $Revision$
 */
public class FileUploadParameterMstDomain implements Serializable {
    
    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = -516551799495143745L;
    
    /**
     * [KR] 템플릿ID <br>
     */
    private String tplid;
    
    /**
     * [KR] 설명 <br>
     */
    private String colno;
    
    /**
     * [KR] 열번호 <br>
     */
    private String colmn;
    
    /**
     * [KR] 컬럼 <br>
     */
    private String comnt;
    
    /**
     * [KR] 필스체크 <br>
     */
    private String reqyn;
    
    /**
     * [KR] 타입 <br>
     */
    private String stype;
    
    /**
     * [KR] 길이 <br>
     */
    private String lengh;
    
    private String oldTplid;
    private String oldColno;
    private String oldColmn;
    
    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String lib1;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String lib2;

    /**
     * [KO] <br>
     * [EN] <br>
     * [JP] <br>
     */
    private String lib3;
    
    
    public String getTplid() {
		return tplid;
	}

	public void setTplid(String tplid) {
		this.tplid = tplid;
	}

	public String getColno() {
		return colno;
	}

	public void setColno(String colno) {
		this.colno = colno;
	}

	public String getColmn() {
		return colmn;
	}

	public void setColmn(String colmn) {
		this.colmn = colmn;
	}

	public String getComnt() {
		return comnt;
	}

	public void setComnt(String comnt) {
		this.comnt = comnt;
	}

	public String getReqyn() {
		return reqyn;
	}

	public void setReqyn(String reqyn) {
		this.reqyn = reqyn;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getLengh() {
		return lengh;
	}

	public void setLengh(String lengh) {
		this.lengh = lengh;
	}

	public String getOldTplid() {
		return oldTplid;
	}

	public void setOldTplid(String oldTplid) {
		this.oldTplid = oldTplid;
	}

	public String getOldColno() {
		return oldColno;
	}

	public void setOldColno(String oldColno) {
		this.oldColno = oldColno;
	}

	public String getOldColmn() {
		return oldColmn;
	}

	public void setOldColmn(String oldColmn) {
		this.oldColmn = oldColmn;
	}

	/**
     * [KO] lib1의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
     * [JP] <br>
     * 
     * @return the lib1
     */
    public String getLib1() {
        return lib1;
    }

    /**
     * [KO] lib1의 setter method 이다.<br>
     * [EN] It is a setter method of lib1.<br>
     * [JP] <br>
     * 
     * @param lib1 String
     */
    public void setLib1(String lib1) {
        this.lib1 = lib1;
    }

    /**
     * [KO] lib2의 getter method 이다.<br>
     * [EN] It is a getter method of .<br>
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
     * [EN] It is a getter method of .<br>
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
        jsonObj.put("tplid", this.tplid);
        jsonObj.put("colno", this.colno);
        jsonObj.put("colmn", this.colmn);
        jsonObj.put("comnt", this.comnt);
        jsonObj.put("reqyn", this.reqyn);
        jsonObj.put("stype", this.stype);
        jsonObj.put("lengh", this.lengh);
        jsonObj.put("oldTplid", this.oldTplid);
        jsonObj.put("oldColno", this.oldColno);
        jsonObj.put("oldColmn", this.oldColmn);
        
        String rtnStr = jsonObj.toJSONString();

        return rtnStr;
    }

}
