package com.globaldenso.dnkr.uxis;

import java.io.Serializable; 

/**
 * 첨부파일 VO 
 * @author $Author$
 * @version $Revision$
 */
public class UxisFileVO implements Serializable{
    /** serialVersionUID */
    private static final long serialVersionUID = -7430610947548073621L;
    
    /** 게시판 idx */
    public String boardIdx = "";

    /** 게시판 id  */
    public String boardId = "";

    /** 사이트 ID  */
    public String site_id = "";
    
    /** 테이블 이름  */
    public String table_nm = "";
    
    /** 첨부파일 아이디    */
    public String atchFileId = "";
    /** 생성일자    */
    public String creatDt = "";
    /** 파일내용    */
    public String fileCn = "";
    /** 파일확장자   */
    public String fileExtsn = "";
    /** 파일크기    */
    public String fileMg = "";
    /** 파일연번    */
    public String fileSn = "";
    /** 파일저장경로  */
    public String fileStreCours = "";
    /** 원파일명    */
    public String orignlFileNm = "";
    /** 저장파일명   */
    public String streFileNm = "";
    /** ID  */
    public String htmlID = "";

    /** 첨부파일 고유키 idx*/
    private int fidx;
    /** 등록일 */
    private long regDate;

    /** Constructor*/
    public UxisFileVO() {
    }
    
    /**
     * 첨부파일 HtmlId 값을 리턴한다.
     * @return  String
     */
    public String getHtmlID() {
        return htmlID;
    }
    /**
     * 첨부파일 HtmlId 값을 설정한다. 
     * @param htmlID    String
     */
    public void setHtmlID(String htmlID) {
        this.htmlID = htmlID;
    }

    /**
     * atchFileId attribute를 리턴한다.
     * 
     * @return the atchFileId
     */
    public String getAtchFileId() {
        return atchFileId;
    }

  /**
   * atchFileId attribute 값을 설정한다.
   * 
   * @param atchFileId
   *            the atchFileId to set
   */
    public void setAtchFileId(String atchFileId) {
        this.atchFileId = atchFileId;
    }

  /**
   * creatDt attribute를 리턴한다.
   * 
   * @return the creatDt
   */
    public String getCreatDt() {
        return creatDt;
    }

  /**
   * creatDt attribute 값을 설정한다.
   * 
   * @param creatDt
   *            the creatDt to set
   */
    public void setCreatDt(String creatDt) {
        this.creatDt = creatDt;
    }

  /**
   * fileCn attribute를 리턴한다.
   * 
   * @return the fileCn
   */
    public String getFileCn() {
        return fileCn;
    }

  /**
   * fileCn attribute 값을 설정한다.
   * 
   * @param fileCn
   *            the fileCn to set
   */
    public void setFileCn(String fileCn) {
        this.fileCn = fileCn;
    }

  /**
   * fileExtsn attribute를 리턴한다.
   * 
   * @return the fileExtsn
   */
    public String getFileExtsn() {
        return fileExtsn;
    }

  /**
   * fileExtsn attribute 값을 설정한다.
   * 
   * @param fileExtsn
   *            the fileExtsn to set
   */
    public void setFileExtsn(String fileExtsn) {
        this.fileExtsn = fileExtsn;
    }

  /**
   * fileMg attribute를 리턴한다.
   * 
   * @return the fileMg
   */
    public String getFileMg() {
        return fileMg;
    }

  /**
   * fileMg attribute 값을 설정한다.
   * 
   * @param fileMg
   *            the fileMg to set
   */
    public void setFileMg(String fileMg) {
        this.fileMg = fileMg;
    }

  /**
   * fileSn attribute를 리턴한다.
   * 
   * @return the fileSn
   */
    public String getFileSn() {
        return fileSn;
    }

  /**
   * fileSn attribute 값을 설정한다.
   * 
   * @param fileSn
   *            the fileSn to set
   */
    public void setFileSn(String fileSn) {
        this.fileSn = fileSn;
    }

  /**
   * fileStreCours attribute를 리턴한다.
   * 
   * @return the fileStreCours
   */
    public String getFileStreCours() {
        return fileStreCours;
    }

  /**
   * fileStreCours attribute 값을 설정한다.
   * 
   * @param fileStreCours
   *            the fileStreCours to set
   */
    public void setFileStreCours(String fileStreCours) {
        this.fileStreCours = fileStreCours;
    }

  /**
   * orignlFileNm attribute를 리턴한다.
   * 
   * @return the orignlFileNm
   */
    public String getOrignlFileNm() {
        return orignlFileNm;
    }

  /**
   * orignlFileNm attribute 값을 설정한다.
   * 
   * @param orignlFileNm
   *            the orignlFileNm to set
   */
    public void setOrignlFileNm(String orignlFileNm) {
        this.orignlFileNm = orignlFileNm;
    }

  /**
   * streFileNm attribute를 리턴한다.
   * 
   * @return the streFileNm
   */
    public String getStreFileNm() {
        return streFileNm;
    }

  /**
   * streFileNm attribute 값을 설정한다.
   * 
   * @param streFileNm
   *            the streFileNm to set
   */
    public void setStreFileNm(String streFileNm) {
        this.streFileNm = streFileNm;
    }
 
    /**
     * site_id attribute를 리턴한다.
     * @return  the site_id
     */
    public String getSite_id() {
        return site_id;
    }

    /**
     * site_id attribute 값을 설정한다.
     * @param site_id
     *             the site_id to set
     */
    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    /**
     * table_nm attribute를 리턴한다.
     * @return  the table_nm
     */
    public String getTable_nm() {
        return table_nm;
    }

    /**
     * table_nm attribute 값을 설정한다.
     * @param table_nm
     *              the table_nm to set
     */
    public void setTable_nm(String table_nm) {
        this.table_nm = table_nm;
    }

    /**
     * boardIdx attribute를 리턴한다.
     * @return  the boardIdx
     */
    public String getBoardIdx() {
        return boardIdx;
    }

    /**
     * boardIdx attribute 값을 설정한다.
     * @param boardIdx
     *              the boardIdx to set
     */
    public void setBoardIdx(String boardIdx) {
        this.boardIdx = boardIdx;
    }

    /**
     * boardId attribute를 리턴한다.
     * @return  the boardId
     */
    public String getBoardId() {
        return boardId;
    }

    /**
     * boardId attribute 값을 설정한다.
     * @param boardId
     *              the boardId to set
     */
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    /**
     * fidx attribute를 리턴한다.
     * @return  the fidx
     */
    public int getFidx() {
        return fidx;
    }

    /**
     * fidx attribute 값을 설정한다.
     * @param fidx
     *              the fidx to set
     */
    public void setFidx(int fidx) {
        this.fidx = fidx;
    }

    /**
     * regDate attribute를 리턴한다.
     * @return  the regDate
     */
    public long getRegDate() {
        return regDate;
    }

    /**
     * regDate attribute 값을 설정한다.
     * @param regDate
     *              the regDate to set
     */
    public void setRegDate(long regDate) {
        this.regDate = regDate;
    }
}
