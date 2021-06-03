package com.globaldenso.dnkr.business.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.BoardFileDomain;
import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.BoardTextDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.integration.dao.BoardDao;
import com.globaldenso.dnkr.uxis.ShaEncryptUtils;
import com.globaldenso.dnkr.uxis.UxisBoardFileUtil;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisFileMngUtil;
import com.globaldenso.dnkr.uxis.UxisFileVO;

/**
 * [KR] 게시판관리 서비스 구현<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {
    /**
     * 
     */
    String rootPath = UxisCmmUtil.getProperty("system.uploadpath");
    /**
     * [KR] 게시판  Dao <br>
     */
    @Autowired
    private BoardDao boardDao;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public BoardServiceImpl() {
        // no process
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchCount(BoardInfoDomain)
     */
    public BoardTextDomain searchById(BoardTextDomain domain) throws ApplicationException {
        return boardDao.searchById(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchByConditionForPaging(BoardInfoDomain)
     */
    public List<BoardTextDomain> searchByConditionForMain(BoardTextDomain domain) throws ApplicationException {
        return boardDao.searchByConditionForMain(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchByConditionForPaging(BoardInfoDomain)
     */
    public List<BoardTextDomain> searchByCondition(BoardTextDomain domain) throws ApplicationException {
        return boardDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchCount(BoardInfoDomain)
     */
    public int noticeCount(BoardTextDomain domain) throws ApplicationException {
        return boardDao.noticeCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchByConditionForPaging(BoardInfoDomain)
     */
    public List<BoardTextDomain> searchByConditionForPaging(BoardTextDomain domain) throws ApplicationException {
        return boardDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchCount(BoardInfoDomain)
     */
    public int searchCount(BoardTextDomain domain) throws ApplicationException {
        return boardDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#boardCount(BoardInfoDomain)
     */
    public int boardCount(BoardTextDomain domain) throws ApplicationException {
        return boardDao.boardCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#create(BoardInfoDomain)
     */
    public void create(BoardTextDomain domain, MultipartHttpServletRequest multiRequest) throws ApplicationException {
        try {
            //IDX 받아오기
            String idx = boardDao.boardNextIdx(domain);
        
            domain.setIdx(idx);
            domain.setPwd(ShaEncryptUtils.encrypt(domain.getPwd()));
            
            //게시글 작성
            boardDao.create(domain);
      
        
            //첨부파일 저장
            //업로드가능한 확장자 검색
            BoardInfoDomain infoDomain = new BoardInfoDomain();
            infoDomain.setBoardId(domain.getBoardId());
            infoDomain = boardDao.searchInfoById(infoDomain);
            String fileExt = infoDomain.getFileExt();
            int fileSize = infoDomain.getFileSize();
            
            //첨부파일 디비 저장을 위해 데이터세팅
            BoardFileDomain fileDomain = new BoardFileDomain();
            fileDomain.setBoardId(domain.getBoardId());
            fileDomain.setIdx(idx);
            String result = insertFileData(multiRequest.getFileMap(), fileDomain, fileExt, fileSize);

            System.out.println("insertFileData result  : " + result);
   
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.board"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.EmpService#update(EmpDomain)
     */
    public int update(BoardTextDomain domain,
        MultipartHttpServletRequest multiRequest) throws ApplicationException {
        try {

            int result = boardDao.update(domain);
            
            //첨부파일 저장
            //업로드가능한 확장자 검색
            BoardInfoDomain infoDomain = new BoardInfoDomain();
            infoDomain.setBoardId(domain.getBoardId());
            infoDomain = boardDao.searchInfoById(infoDomain);
            String fileExt = infoDomain.getFileExt();
            int fileSize = infoDomain.getFileSize();

            //첨부파일 디비 저장을 위해 데이터세팅
            BoardFileDomain fileDomain = new BoardFileDomain();
            fileDomain.setBoardId(domain.getBoardId());
            fileDomain.setIdx(domain.getIdx());
            String rtnMsg = insertFileData(multiRequest.getFileMap(), fileDomain, fileExt, fileSize);

            System.out.println(rtnMsg);
            return result;

        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                     "SMPL-E8-0004", 
                     MessageSources.getInstance().value("info.board"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.EmpService#hitsUpdate(EmpDomain)
     */
    public int hitsUpdate(BoardTextDomain domain) throws ApplicationException {
        return boardDao.hitsUpdate(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.EmpService#chkDelete(EmpDomain)
     */
    public int chkDelete(BoardTextDomain domain) throws ApplicationException {
        return boardDao.chkDelete(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.EmpService#delete(EmpDomain)
     */
    public int delete(BoardTextDomain domain) throws ApplicationException {
        return boardDao.delete(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchInfoById(BoardInfoDomain)
     */
    public BoardInfoDomain searchInfoById(BoardInfoDomain domain) throws ApplicationException {
        return boardDao.searchInfoById(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchByInfoConditionForPaging(BoardInfoDomain)
     */
    public List<BoardInfoDomain> searchByInfoConditionForPaging(BoardInfoDomain domain) throws ApplicationException {
        return boardDao.searchByInfoConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchInfoCount(BoardInfoDomain)
     */
    public int searchInfoCount(BoardInfoDomain domain) throws ApplicationException {
        return boardDao.searchInfoCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#infoCreate(BoardInfoDomain)
     */
    public void infoCreate(BoardInfoDomain domain) throws ApplicationException {
        try {
            boardDao.infoCreate(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.board"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.EmpService#delete(EmpDomain)
     */
    public int infoUpdate(BoardInfoDomain domain) throws ApplicationException {
        return boardDao.infoUpdate(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.EmpService#delete(EmpDomain)
     */
    public int infoDelete(BoardInfoDomain domain) throws ApplicationException {
        return boardDao.infoDelete(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchByConditionForPaging(BoardInfoDomain)
     */
    public BoardFileDomain searchFileById(BoardFileDomain domain) throws ApplicationException {
        return boardDao.searchFileById(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#searchByConditionForPaging(BoardInfoDomain)
     */
    public List<BoardFileDomain> searchFileList(BoardFileDomain domain) throws ApplicationException {
        return boardDao.searchFileList(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.BoardService#infoCreate(BoardInfoDomain)
     */
    public void fileCreate(BoardFileDomain domain) throws ApplicationException {
        try {
            boardDao.fileCreate(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.board"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.EmpService#delete(EmpDomain)
     */
    public int fileUpdate(BoardFileDomain domain) throws ApplicationException {
        return boardDao.fileUpdate(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.EmpService#delete(EmpDomain)
     */
    public int downCntUpdate(BoardFileDomain domain) throws ApplicationException {
        return boardDao.downCntUpdate(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.business.service.EmpService#fileDelete(EmpDomain)
     */
    public int fileDelete(BoardFileDomain domain) throws ApplicationException {
        domain = boardDao.searchFileById(domain);

        String fileName = rootPath + domain.getSaveDir() + domain.getSaveName();
        
        UxisFileMngUtil fileUtil = new UxisFileMngUtil();
        fileUtil.deleteFile(fileName);
        
        return boardDao.fileDelete(domain);
    }
    
    /**
    * 첨부파일 업로드 및 등록 처리
    * @param files Map<String, MultipartFile>
    * @param boardVO BoardFileDomain
    * @param fileExt String
    * @param fileSize int
    * @return string
    */
    public String insertFileData(Map<String, MultipartFile> files, BoardFileDomain boardVO, String fileExt, int fileSize){
        int fsize = 0;
        int upcnt = 0;
        String saveDir = "data/" + UxisBoardFileUtil.getDir();
        String fullPath = rootPath + saveDir;

        UxisFileMngUtil fileUtil = new UxisFileMngUtil();
        try{
            if(!files.isEmpty()){
                if(UxisBoardFileUtil.checkFileExt(files, fileExt)){
                    boolean sizeFlag = true;
                    //파일 업로드
                    Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
                    MultipartFile file;
                    while (itr.hasNext()) {
                        Entry<String, MultipartFile> entry = itr.next();
                        
                        file = entry.getValue();
                        System.out.println("fileSize : " + (fileSize * 1048576) + "   , file.getSize : " + file.getSize());
                        if((fileSize * 1048576) < file.getSize()){
                            sizeFlag = false;
                        }
                    }

                    if(sizeFlag){
                        List<UxisFileVO> fresult = fileUtil.parseFileInf(files, fullPath);
                        fsize = fresult.size();

                        //파일 등록
                        upcnt = insertFileData(fresult, boardVO, saveDir);
                    }else{
                        return "첨부파일 제한 용량은 " + fileSize + "MB 입니다.";
                    }
                    
                    
                    if( fsize != upcnt ){
                        return "첨부파일 등록이 실패되었습니다.";
                    }

                }else{
                    return "허용하지 않은 파일입니다.";
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            return "첨부파일 등록이 실패되었습니다.";
        }

        return "";
    }
    /**
     * 
     * 
     * @param result List<UxisFileVO>
     * @param boardDomain BoardFileDomain
     * @param saveDir String
     * @return file_cnt
     */
    public int insertFileData(List<UxisFileVO> result, BoardFileDomain boardDomain, String saveDir){
        // 첨부파일등록
        int cnt = result.size();
        int file_cnt = 0;
        for(int i = cnt - 1; i >= 0; i--){
            UxisFileVO arr = result.get(i);
            boardDomain.setSaveName(arr.getStreFileNm());
            boardDomain.setRealName(arr.getOrignlFileNm());
            boardDomain.setFileSize(Integer.parseInt(arr.getFileMg()));
            boardDomain.setFileType(arr.getFileExtsn());
            boardDomain.setSaveDir(saveDir);

            try{
                file_cnt += boardDao.fileCreate(boardDomain);;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return file_cnt;
    }

}
