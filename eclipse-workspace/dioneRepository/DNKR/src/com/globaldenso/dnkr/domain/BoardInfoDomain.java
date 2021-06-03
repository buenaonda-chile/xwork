package com.globaldenso.dnkr.domain;

import java.io.Serializable;
/**
 * [KR] 게시판 도메인 <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class BoardInfoDomain implements Serializable {

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
     * [KO] 게시판 이름.<br>
     * [EN] Board name.<br>
     * [JP] <br>
     */
    private String boardNm;
    
    /**
     * [KO] 게시판 그룹.<br>
     * [EN] Board grp.<br>
     * [JP] <br>
     */
    private String boardGrp;
    
    /**
     * [KO] 게시판 타입.<br>
     * [EN] Board Type.<br>
     * [JP] <br>
     */
    private String boardType;
    
    /**
     * [KO] 게시판 배경.<br>
     * [EN] Board Skin.<br>
     * [JP] <br>
     */
    private String boardSkin;
    
    /**
     * [KO] 쓰기권한.<br>
     * [EN] Board writeAuth.<br>
     * [JP] <br>
     */
    private String writeAuth;
    
    /**
     * [KO] 읽기권한.<br>
     * [EN] Board readAuth.<br>
     * [JP] <br>
     */
    private String readAuth;
    
    /**
     * [KO] 공지권한.<br>
     * [EN] Board notiAuth.<br>
     * [JP] <br>
     */
    private String notiAuth;
    
    /**
     * [KO] .<br>
     * [EN] Board nsrAuth.<br>
     * [JP] <br>
     */
    private String nsrAuth;
    
    /**
     * [KO] 메모 권한.<br>
     * [EN] Board memoAuth.<br>
     * [JP] <br>
     */
    private String memoAuth;
    
    /**
     * [KO] 비밀글사용여부.<br>
     * [EN] Board secretUse.<br>
     * [JP] <br>
     */
    private String secretUse;
    
    /**
     * [KO] 에디터 사용여부.<br>
     * [EN] Board editorUse.<br>
     * [JP] <br>
     */
    private String editorUse;
    
    /**
     * [KO] 게시판 아이템 사용여부.<br>
     * [EN] Board itemUse.<br>
     * [JP] <br>
     */
    private String itemUse;
    
    /**
     * [KO] 게시판 첨부파일 업로드 가능수.<br>
     * [EN] Board fileNum.<br>
     * [JP] <br>
     */
    private int fileNum;
    
    /**
     * [KO] 게시판 첨부파일 사이즈.<br>
     * [EN] Board fileSize.<br>
     * [JP] <br>
     */
    private int fileSize;
    
    /**
     * [KO] 게시판 첨부파일 확장자.<br>
     * [EN] Board fileExt.<br>
     * [JP] <br>
     */
    private String fileExt;
    
    /**
     * [KO] 게시판 뉴아이콘 노출날짜.<br>
     * [EN] Board fileNum.<br>
     * [JP] <br>
     */
    private int newiconDay;
    
    /**
     * [KO] .<br>
     * [EN] Board items.<br>
     * [JP] <br>
     */
    private String items;
    
    /**
     * [KO] 게시판 페이징목록.<br>
     * [EN] Board rowCnt.<br>
     * [JP] <br>
     */
    private int rowCnt;
    
    /**
     * [KO] 게시판 화면당 게시물 노출수.<br>
     * [EN] Board pageCnt.<br>
     * [JP] <br>
     */
    private int pageCnt;
    
    /**
     * [KO] 게시판 등록자.<br>
     * [EN] Board regiId.<br>
     * [JP] <br>
     */
    private String regiId;
    
    /**
     * [KO] 게시판 등록일.<br>
     * [EN] Board regiDtm.<br>
     * [JP] <br>
     */
    private String regiDtm;
    
    
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
     * 
     */
    public BoardInfoDomain () {
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
     * @return boardNm;
     */
    public String getBoardNm() {
        return boardNm;
    }
    /**
     * @param boardNm String
     */
    public void setBoardNm(String boardNm) {
        this.boardNm = boardNm;
    }

    /**
     * @return boardGrp;
     */
    public String getBoardGrp() {
        return boardGrp;
    }
    /**
     * @param boardGrp String
     */
    public void setBoardGrp(String boardGrp) {
        this.boardGrp = boardGrp;
    }

    /**
     * @return boardType;
     */
    public String getBoardType() {
        return boardType;
    }
    /**
     * @param boardType String
     */
    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    /**
     * @return boardSkin;
     */
    public String getBoardSkin() {
        return boardSkin;
    }
    /**
     * @param boardSkin String
     */
    public void setBoardSkin(String boardSkin) {
        this.boardSkin = boardSkin;
    }

    /**
     * @return writeAuth;
     */
    public String getWriteAuth() {
        return writeAuth;
    }
    /**
     * @param writeAuth String
     */
    public void setWriteAuth(String writeAuth) {
        this.writeAuth = writeAuth;
    }

    /**
     * @return readAuth;
     */
    public String getReadAuth() {
        return readAuth;
    }
    /**
     * @param readAuth String
     */
    public void setReadAuth(String readAuth) {
        this.readAuth = readAuth;
    }

    /**
     * @return notiAuth;
     */
    public String getNotiAuth() {
        return notiAuth;
    }
    /**
     * @param notiAuth String
     */
    public void setNotiAuth(String notiAuth) {
        this.notiAuth = notiAuth;
    }

    /**
     * @return nsrAuth;
     */
    public String getNsrAuth() {
        return nsrAuth;
    }
    /**
     * @param nsrAuth String
     */

    public void setNsrAuth(String nsrAuth) {
        this.nsrAuth = nsrAuth;
    }

    /**
     * @return memoAuth;
     */
    public String getMemoAuth() {
        return memoAuth;
    }

    /**
     * @param memoAuth String
     */
    public void setMemoAuth(String memoAuth) {
        this.memoAuth = memoAuth;
    }

    /**
     * @return secretUse;
     */
    public String getSecretUse() {
        return secretUse;
    }
    /**
     * @param secretUse String
     */
    public void setSecretUse(String secretUse) {
        this.secretUse = secretUse;
    }

    /**
     * @return editorUse;
     */
    public String getEditorUse() {
        return editorUse;
    }
    /**
     * @param editorUse String
     */
    public void setEditorUse(String editorUse) {
        this.editorUse = editorUse;
    }

    /**
     * @return itemUse;
     */
    public String getItemUse() {
        return itemUse;
    }
    /**
     * @param itemUse String
     */
    public void setItemUse(String itemUse) {
        this.itemUse = itemUse;
    }

    /**
     * @return fileNum;
     */
    public int getFileNum() {
        return fileNum;
    }
    /**
     * @param fileNum int
     */
    public void setFileNum(int fileNum) {
        this.fileNum = fileNum;
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
     * @return fileExt;
     */
    public String getFileExt() {
        return fileExt;
    }
    /**
     * @param fileExt String
     */
    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    /**
     * @return newiconDay;
     */
    public int getNewiconDay() {
        return newiconDay;
    }
    /**
     * @param newiconDay int
     */
    public void setNewiconDay(int newiconDay) {
        this.newiconDay = newiconDay;
    }

    /**
     * @return items;
     */
    public String getItems() {
        return items;
    }
    /**
     * @param items String
     */
    public void setItems(String items) {
        this.items = items;
    }

    /**
     * @return rowCnt;
     */
    public int getRowCnt() {
        return rowCnt;
    }
    /**
     * @param rowCnt int
     */
    public void setRowCnt(int rowCnt) {
        this.rowCnt = rowCnt;
    }

    /**
     * @return pageCnt;
     */
    public int getPageCnt() {
        return pageCnt;
    }

    /**
     * @param pageCnt int
     */
    public void setPageCnt(int pageCnt) {
        this.pageCnt = pageCnt;
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
     * @return serialVersionUID;
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
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
    
    
    
}
