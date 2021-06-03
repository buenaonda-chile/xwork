/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service.db2;

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
import com.globaldenso.dnkr.domain.db2.FileDb2Domain;
import com.globaldenso.dnkr.integration.dao.db2.PsogmAttachedFileDao;
import com.globaldenso.dnkr.uxis.UxisBoardFileUtil;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisFileMngUtil;

/**
 * [KR] 생산전광판 현황 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("psogmAttachedFileService")
public class PsogmAttachedFileServiceImpl implements PsogmAttachedFileService {

    /**
     * 첨부파일 저장소
     */
    private String rootPath = UxisCmmUtil.getProperty("system.uploadpath");
    
    /**
     * [KR] 첨부파일관리 Dao <br>
     */
    @Autowired
    private PsogmAttachedFileDao psogmAttachedFileDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmAttachedFileServiceImpl() {
        // no process
    }
    
    /**
     * [EN] Set DAO of attached File.<br>
     * [JP] <br>
     * 
     * @param psogmAttachedFileDao Dao of 'PsogmAttachedFileDao'
     */
    public void setPsfaclibDao(PsogmAttachedFileDao psogmAttachedFileDao) {
        this.psogmAttachedFileDao = psogmAttachedFileDao;
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmAttachedFileService#searchById(FileDb2Domain)
     */
    public FileDb2Domain searchById(FileDb2Domain domain) throws ApplicationException {
        return psogmAttachedFileDao.searchById(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmAttachedFileService#selectOgm219_obj230pf(FileDb2Domain)
     */
    public List<FileDb2Domain > selectOgm219_obj230pf(FileDb2Domain domain) throws ApplicationException {
        return psogmAttachedFileDao.selectOgm219_obj230pf(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmAttachedFileService#create(FileDb2Domain, MultipartHttpServletRequest)
     */
    public void create(FileDb2Domain domain, MultipartHttpServletRequest multiRequest) throws ApplicationException {
        try {
            String seqNo = "";
            
            //IDX 받아오기
            seqNo = psogmAttachedFileDao.selectOgm206_maxSeq(domain) + "";
        
            domain.setSeqno(seqNo);
        
            //첨부파일 저장
            //업로드가능한 확장자 검색
            String fileExt = "*.gif;*.jpg;*.jpeg;*.png;*.xls;*.xlsx;*.hwp;*.doc;*.docx;*.ppt;*.pptx;*.ods;*.zip;*.log;*.txt;*.pdf";
            int fileSize = 1;
            
            //첨부파일 디비 저장을 위해 데이터세팅
//            String result = insertFileData(multiRequest.getFileMap(), domain, fileExt, fileSize);
            String result = "";
            
            Map<String, MultipartFile> files = multiRequest.getFileMap();
            
            int fsize = 0;
            int upcnt = 0;
//            String saveDir = "data/" + UxisBoardFileUtil.getDir();
//            String saveDir = "/data/bojen/images/" + UxisBoardFileUtil.getDir();//기존
            String saveDir = "/bojen/images/" + UxisBoardFileUtil.getDir();
            String fullPath = rootPath + saveDir;

            UxisFileMngUtil fileUtil = new UxisFileMngUtil();
            try{
                if(!files.isEmpty()){
                    if(UxisBoardFileUtil.checkFileExt(files, fileExt)){
                        boolean sizeFlag = true;
                        
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
                            //파일 업로드
                            List<FileDb2Domain> fresult = fileUtil.parseFileInfo(files, fullPath, domain);
                            fsize = fresult.size();
                            //System.out.println("fsize:" + fsize);
                            //파일 등록(DB)
                            upcnt = insertFileData(fresult, domain, saveDir);
                        }else{
                            result = "첨부파일 제한 용량은 " + fileSize + "MB 입니다.";
                        }
                        
                        
                        if( fsize != upcnt ){
                            result = "첨부파일 등록이 실패되었습니다.";
                        }

                    }else{
                        result = "허용하지 않은 파일입니다.";
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
                result = "첨부파일 등록이 실패되었습니다.";
            }
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
     * [KO] 첨부파일정보 DB에 데이터 등록 처리
     * 
     * @param result List<UxisFileVO>
     * @param domain FileDb2Domain
     * @param saveDir String
     * @return file_cnt
     */
    public int insertFileData(List<FileDb2Domain> result, FileDb2Domain domain, String saveDir){
        // 첨부파일등록
        int cnt = result.size();
        int file_cnt = 0;
        for(int i = cnt - 1; i >= 0; i--){
            FileDb2Domain arr = result.get(i);
            domain.setFilnm(saveDir + arr.getFilnm());
            domain.setSeqno(arr.getSeqno());

            try{
                file_cnt += psogmAttachedFileDao.insertOgm206_sFile(domain);;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return file_cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmAttachedFileService#delete(FileDb2Domain)
     */
    public int delete(FileDb2Domain domain) throws ApplicationException {
        FileDb2Domain searchDomain = domain;
        searchDomain = psogmAttachedFileDao.searchById(domain);
        
        String fileName = rootPath + searchDomain.getFilnm();
        UxisFileMngUtil fileUtil = new UxisFileMngUtil();
        fileUtil.deleteFile(fileName);
        
        return psogmAttachedFileDao.deleteOgm206(domain);
    }       
    
}
