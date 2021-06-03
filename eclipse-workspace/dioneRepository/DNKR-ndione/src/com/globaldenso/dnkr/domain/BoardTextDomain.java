package com.globaldenso.dnkr.domain;

import java.io.Serializable;
/**
 * [KR] 게시글 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class BoardTextDomain implements Serializable {

    /**
     * [EN] Serial Version UID.<br>
     * [JP] シリアルバージョンID。<br>
     */
    private static final long serialVersionUID = 4797973067494912780L;

    /**
     * [KO] 게시판 아이디.<br>
     * [EN] Board id.<br>
     * [JP] <br>
     */
    private String boardId;
    
    /**
     * [KO] 게시글 인덱스.<br>
     * [EN] idx.<br>
     * [JP] <br>
     */
    private String idx;
    
    /**
     * [KO] 게시글 부모인덱스.<br>
     * [EN] prntIdx.<br>
     * [JP] <br>
     */
    private String prntIdx;
    
    /**
     * [KO] 게시글 제목.<br>
     * [EN] title.<br>
     * [JP] <br>
     */
    private String title;

    /**
     * [KO] 게시글 제목(자른것).<br>
     * [EN] cnts.<br>
     * [JP] <br>
     */
    private String titleCut;
    
    /**
     * [KO] 게시글 내용.<br>
     * [EN] cnts.<br>
     * [JP] <br>
     */
    private String cnts;
    
    /**
     * [KO] 게시글 내용(자른것).<br>
     * [EN] cnts.<br>
     * [JP] <br>
     */
    private String cntsCut;
    
    /**
     * [KO] 게시글 비밀번호.<br>
     * [EN] pwd.<br>
     * [JP] <br>
     */
    private String pwd;
    
    /**
     * [KO] 사용자 IP.<br>
     * [EN] userIp.<br>
     * [JP] <br>
     */
    private String userIp;
    
    /**
     * [KO] 공지여부.<br>
     * [EN] noticeYn.<br>
     * [JP] <br>
     */
    private String noticeYn;
    
    /**
     * [KO] 비밀여부.<br>
     * [EN] secretYn.<br>
     * [JP] <br>
     */
    private String secretYn;
    
    /**
     * [KO] 에디터여부.<br>
     * [EN] editorYn.<br>
     * [JP] <br>
     */
    private String editorYn;
    
    /**
     * [KO] 아이템.<br>
     * [EN] item.<br>
     * [JP] <br>
     */
    private String item;
    
    /**
     * [KO] 조회수.<br>
     * [EN] hits.<br>
     * [JP] <br>
     */
    private int hits;
    
    /**
     * [KO] 작성자.<br>
     * [EN] writer.<br>
     * [JP] <br>
     */
    private String writer;
    
    /**
     * [KO] 파일 아이디.<br>
     * [EN] fileId.<br>
     * [JP] <br>
     */
    private int fileId;
    
    /**
     * [KO] 게시글 등록자.<br>
     * [EN] Board regiId.<br>
     * [JP] <br>
     */
    private String regiId;
    
    /**
     * [KO] 게시글 등록일.<br>
     * [EN] Board regiDtm.<br>
     * [JP] <br>
     */
    private String regiDtm;
    
    /**
     * [KO] 게시글 수정일.<br>
     * [EN] Board modiDtm.<br>
     * [JP] <br>
     */
    private String modiDtm;
    
    
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
     * [EN] Paging(To).<br>
     * [JP] ページング(To)。<br>
     */
    private int rowNum;

    /**
     * [KO] 이전 게시글 아이디.<br>
     * [EN] Board modiDtm.<br>
     * [JP] <br>
     */
    private String prevIdx;
    
    /**
     * [KO] 이전 게시글 텍스트.<br>
     * [EN] Board modiDtm.<br>
     * [JP] <br>
     */
    private String prevTitle;
    
    /**
     * [KO] 다음 게시글 아이디.<br>
     * [EN] Board modiDtm.<br>
     * [JP] <br>
     */
    private String nextIdx;
    
    /**
     * [KO] 다음 게시글 텍스트.<br>
     * [EN] Board modiDtm.<br>
     * [JP] <br>
     */
    private String nextTitle;
    
    /**
     * [KO] 첨부파일 갯수.<br>
     * [EN] Board fileCnt.<br>
     * [JP] <br>
     */
    private String fileCnt;
    
    /**
     * [KO] 삭제할 idx 리스트<br>
     * [EN] Board modiDtm.<br>
     * [JP] <br>
     */
    private String[] idxArr;
    
    /**
     * [KO] 카테고리.<br>
     * [EN] category.<br>
     * [JP] <br>
     */
    private String category;
    /**
     * [KO] 회람자 개인.<br>
     * [EN] circulation_Id.<br>
     * [JP] <br>
     */
    private String circulation_Id;
    /**
     * [KO] 회람자 팀.<br>
     * [EN] circulation_Id.<br>
     * [JP] <br>
     */
    private String circulation_Id_Team;

    /**
     * [KO] 유저아이디.<br>
     * [EN] user_Id.<br>
     * [JP] <br>
     */
    private String user_Id;
    
    /**
     * 
     */
    public BoardTextDomain () {
        //no process
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
     * @return prntIdx;
     */
    public String getPrntIdx() {
        return prntIdx;
    }

    /**
     * @param prntIdx String
     */
    public void setPrntIdx(String prntIdx) {
        this.prntIdx = prntIdx;
    }
    /**
     * @return title;
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title String
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return cnts;
     */
    public String getCnts() {
        return cnts;
    }

    /**
     * @param cnts String
     */
    public void setCnts(String cnts) {
        this.cnts = cnts;
    }
    /**
     * @return pwd;
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd String
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    /**
     * @return userIp;
     */
    public String getUserIp() {
        return userIp;
    }

    /**
     * @param userIp String
     */
    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
    /**
     * @return noticeYn;
     */
    public String getNoticeYn() {
        return noticeYn;
    }

    /**
     * @param noticeYn String
     */
    public void setNoticeYn(String noticeYn) {
        this.noticeYn = noticeYn;
    }
    /**
     * @return secretYn;
     */
    public String getSecretYn() {
        return secretYn;
    }

    /**
     * @param secretYn String
     */
    public void setSecretYn(String secretYn) {
        this.secretYn = secretYn;
    }
    /**
     * @return editorYn;
     */
    public String getEditorYn() {
        return editorYn;
    }

    /**
     * @param editorYn String
     */
    public void setEditorYn(String editorYn) {
        this.editorYn = editorYn;
    }
    /**
     * @return item;
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item String
     */
    public void setItem(String item) {
        this.item = item;
    }
    /**
     * @return hits;
     */
    public int getHits() {
        return hits;
    }

    /**
     * @param hits int
     */
    public void setHits(int hits) {
        this.hits = hits;
    }
    /**
     * @return writer;
     */
    public String getWriter() {
        return writer;
    }

    /**
     * @param writer String
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }
    /**
     * @return fileId;
     */
    public int getFileId() {
        return fileId;
    }

    /**
     * @param fileId String
     */
    public void setFileId(int fileId) {
        this.fileId = fileId;
    }
    /**
     * @return regiId;
     */
    public String getRegiId() {
        return regiId;
    }

    /**
     * @param regiId String
     */
    public void setRegiId(String regiId) {
        this.regiId = regiId;
    }
    /**
     * @return regiDtm;
     */
    public String getRegiDtm() {
        return regiDtm;
    }

    /**
     * @param regiDtm String
     */
    public void setRegiDtm(String regiDtm) {
        this.regiDtm = regiDtm;
    }
    /**
     * @return rowNumFrom;
     */
    public int getRowNumFrom() {
        return rowNumFrom;
    }

    /**
     * @param rowNumFrom int
     */
    public void setRowNumFrom(int rowNumFrom) {
        this.rowNumFrom = rowNumFrom;
    }
    /**
     * @return rowNumTo;
     */
    public int getRowNumTo() {
        return rowNumTo;
    }

    /**
     * @param rowNumTo int
     */
    public void setRowNumTo(int rowNumTo) {
        this.rowNumTo = rowNumTo;
    }
    /**
     * @return rowNum;
     */
    public int getRowNum() {
        return rowNum;
    }

    /**
     * @param rowNum int
     */
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
    /**
     * @return serialVersionUID;
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    /**
     * @return modiDtm;
     */
    public String getModiDtm() {
        return modiDtm;
    }

    /**
     * @param modiDtm String
     */
    public void setModiDtm(String modiDtm) {
        this.modiDtm = modiDtm;
    }
    /**
     * @return prevIdx;
     */
    public String getPrevIdx() {
        return prevIdx;
    }

    /**
     * @param prevIdx String
     */
    public void setPrevIdx(String prevIdx) {
        this.prevIdx = prevIdx;
    }
    /**
     * @return nextIdx;
     */
    public String getNextIdx() {
        return nextIdx;
    }

    /**
     * @param nextIdx String
     */
    public void setNextIdx(String nextIdx) {
        this.nextIdx = nextIdx;
    }
    /**
     * @return prevTitle;
     */
    public String getPrevTitle() {
        return prevTitle;
    }

    /**
     * @param prevTitle String
     */
    public void setPrevTitle(String prevTitle) {
        this.prevTitle = prevTitle;
    }
    /**
     * @return nextTitle;
     */
    public String getNextTitle() {
        return nextTitle;
    }

    /**
     * @param nextTitle String
     */
    public void setNextTitle(String nextTitle) {
        this.nextTitle = nextTitle;
    }
    /**
     * @return cntsCut;
     */
    public String getCntsCut() {
        return cntsCut;
    }

    /**
     * @param cntsCut String
     */
    public void setCntsCut(String cntsCut) {
        this.cntsCut = cntsCut;
    }
    /**
     * @return idxArr;
     */
    public String[] getIdxArr() {
        return idxArr;
    }

    /**
     * @param idxArr String
     */
    public void setIdxArr(String[] idxArr) {
        this.idxArr = idxArr;
    }
    /**
     * @return fileCnt;
     */
    public String getFileCnt() {
        return fileCnt;
    }

    /**
     * @param fileCnt String
     */
    public void setFileCnt(String fileCnt) {
        this.fileCnt = fileCnt;
    }
    /**
     * @return titleCut;
     */
    public String getTitleCut() {
        return titleCut;
    }

    /**
     * @param titleCut String
     */
    public void setTitleCut(String titleCut) {
        this.titleCut = titleCut;
    }
    /**
     * @return category;
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category String
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * @return circulation_Id;
     */
    public String getCirculation_Id() {
        return circulation_Id;
    }

    /**
     * @param circulation_Id String
     */
    public void setCirculation_Id(String circulation_Id) {
        this.circulation_Id = circulation_Id;
    }
    /**
     * @return circulation_Team;
     */
    public String getCirculation_Id_Team() {
        return circulation_Id_Team;
    }

    /**
     * @param circulation_Id_Team String
     */
    public void setCirculation_Id_Team(String circulation_Id_Team) {
        this.circulation_Id_Team = circulation_Id_Team;
    }
    /**
     * @return user_Id;
     */
    public String getUser_Id() {
        return user_Id;
    }

    /**
     * @param User_Id String
     */
    public void setUser_Id(String User_Id) {
        this.user_Id = User_Id;
    }
    
}
