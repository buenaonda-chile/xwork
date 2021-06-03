package com.globaldenso.dnkr.domain;

import java.io.Serializable;
/**
 * [KR] 게시글 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class BoardFileDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 4797973067494912780L;

    /**
     * [KO] 첨부파일 코드.<br>
     * [EN] Board id.<br>
     * [JP] <br>
     */
    private int fidx;
    
    /**
     * [KO] 게시물 코드.<br>
     * [EN] idx.<br>
     * [JP] <br>
     */
    private String idx;
    
    /**
     * [KO] 저장된파일명.<br>
     * [EN] save file name.<br>
     * [JP] <br>
     */
    private String saveName;
    
    /**
     * [KO] 실제파일명.<br>
     * [EN] real file name.<br>
     * [JP] <br>
     */
    private String realName;

    /**
     * [KO] 파일사이즈.<br>
     * [EN] file size.<br>
     * [JP] <br>
     */
    private int fileSize;
    
    /**
     * [KO] 파일타입.<br>
     * [EN] file type.<br>
     * [JP] <br>
     */
    private String fileType;
    
    /**
     * [KO] 다운로드횟수.<br>
     * [EN] down count.<br>
     * [JP] <br>
     */
    private int downCnt;
    
    /**
     * [KO] 게시판아이디.<br>
     * [EN] Board id.<br>
     * [JP] <br>
     */
    private String boardId;
    
    /**
     * [KO] 파일경로.<br>
     * [EN] save dir.<br>
     * [JP] <br>
     */
    private String saveDir;
    
    /**
     * [KO] 비밀번호.<br>
     * [EN] password.<br>
     * [JP] <br>
     */
    private String pass;
    
    /**
     * [KO] 저장일자.<br>
     * [EN] regi date.<br>
     * [JP] <br>
     */
    private String regDate;
    

    /**
     * 
     */
    public BoardFileDomain () {
        //no process
    }
    

    /**
     * @return fidx;
     */
    public int getFidx() {
        return fidx;
    }

    /**
     * @param fidx int
     */
    public void setFidx(int fidx) {
        this.fidx = fidx;
    }
    /**
     * @return idx;
     */
    public String getIdx() {
        return idx;
    }

    /**
     * @param idx String
     */
    public void setIdx(String idx) {
        this.idx = idx;
    }
    /**
     * @return saveName;
     */
    public String getSaveName() {
        return saveName;
    }

    /**
     * @param saveName String
     */
    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }
    /**
     * @return realName;
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName String
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }
    /**
     * @return fileSize;
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize int
     */
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }
    /**
     * @return fileType;
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType String
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    /**
     * @return downCnt;
     */
    public int getDownCnt() {
        return downCnt;
    }

    /**
     * @param downCnt int
     */
    public void setDownCnt(int downCnt) {
        this.downCnt = downCnt;
    }
    /**
     * @return boardId;
     */
    public String getBoardId() {
        return boardId;
    }

    /**
     * @param boardId String
     */
    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
    /**
     * @return saveDir;
     */
    public String getSaveDir() {
        return saveDir;
    }

    /**
     * @param saveDir String
     */
    public void setSaveDir(String saveDir) {
        this.saveDir = saveDir;
    }
    /**
     * @return pass;
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass String
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    /**
     * @return regDate;
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * @param regDate String
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
    /**
     * @return serialVersionUID;
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
