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

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.PsogmImprvDDomain;
import com.globaldenso.dnkr.integration.dao.db2.PsogmImprvDDao;
import com.globaldenso.dnkr.uxis.UxisBoardFileUtil;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisFileMngUtil;

/**
 * [KR] 생산전광판 현황 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("psogmImprvDService")
public class PsogmImprvDServiceImpl implements PsogmImprvDService {
    
    /**
     * 첨부파일 저장소
     */
    private String rootPath = UxisCmmUtil.getProperty("system.uploadpath2");
    
    /**
     * [KR] 개선상세관리 Dao <br>
     */
    @Autowired
    private PsogmImprvDDao psogmImprvDDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PsogmImprvDServiceImpl() {
        // no process
    }
    
    /**
     * [KO] 개선상세 DAO의 setter 메소드이다<br>
     * [JP] <br>
     * 
     * @param psogmImprvDDao Dao of 'PsogmImprvDDao'
     */
    public void setPsogmImprvDao(PsogmImprvDDao psogmImprvDDao) {
        this.psogmImprvDDao = psogmImprvDDao;
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmImprvDService#selectOgm204_obj210pf_01(PsogmImprvDDomain)
     */
    public PsogmImprvDDomain selectOgm204_obj210pf_01(PsogmImprvDDomain domain) throws ApplicationException {
        return psogmImprvDDao.selectOgm204_obj210pf_01(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmImprvDService#selectOgm220_rep(PsogmImprvDDomain)
     */
    public PsogmImprvDDomain selectOgm220_rep(PsogmImprvDDomain domain) throws ApplicationException {
        return psogmImprvDDao.selectOgm220_rep(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmImprvDService#insertOgm204_obj210pf(PsogmImprvDDomain)
     */
    public int insertOgm204_obj210pf(PsogmImprvDDomain domain) throws ApplicationException {
        return psogmImprvDDao.insertOgm204_obj210pf(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmImprvDService#updateOgm204_obj210pf(PsogmImprvDDomain)
     */
    public int updateOgm204_obj210pf(PsogmImprvDDomain domain) throws ApplicationException {
        return psogmImprvDDao.updateOgm204_obj210pf(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmImprvDServicee#create(PsogmImprvDDomain, MultipartHttpServletRequest)
     */
    public void updateImg(PsogmImprvDDomain domain, MultipartHttpServletRequest multiRequest) throws ApplicationException {
        
        //첨부파일 저장
        //업로드가능한 확장자 검색
        String fileExt = "*.gif;*.jpg;*.jpeg;*.png;";
        int fileSize = 1;
        
        //첨부파일 디비 저장을 위해 데이터세팅
//            String result = insertFileData(multiRequest.getFileMap(), domain, fileExt, fileSize);
        String result = "";
        
        Map<String, MultipartFile> files = multiRequest.getFileMap();
        
        int fsize = 0;
        int upcnt = 0;
//            String saveDir = "data/" + UxisBoardFileUtil.getDir();
//            String saveDir = "/data/bojen/images/" + UxisBoardFileUtil.getDir();  //기존
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
                        List<PsogmImprvDDomain> fresult = fileUtil.parseFileInfo(files, fullPath, domain);
                        fsize = fresult.size();
                        System.out.println("fsize:" + fsize);
                        //파일정보 업데이트(DB)
                        upcnt = updateFileData(fresult, domain, saveDir);
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
   
    }
    
    /**
     * [KO] 첨부파일정보 DB에 데이터 업데이트 처리
     * 
     * @param result List<UxisFileVO>
     * @param domain FileDb2Domain
     * @param saveDir String
     * @return file_cnt
     */
    public int updateFileData(List<PsogmImprvDDomain> result, PsogmImprvDDomain domain, String saveDir){
        // 첨부파일등록
        int cnt = result.size();
        int file_cnt = 0;
        for(int i = cnt - 1; i >= 0; i--){
            PsogmImprvDDomain imprvDomain = result.get(i);
            if(imprvDomain.getImgbf() != null && !"".equals(imprvDomain.getImgbf())) {
                domain.setImgbf(saveDir + imprvDomain.getImgbf());
            } else if(imprvDomain.getImgaf() != null && ! "".equals(imprvDomain.getImgaf())) {
                domain.setImgaf(saveDir + imprvDomain.getImgaf());
            }

            try{
                file_cnt += psogmImprvDDao.updateOgm204_obj210pf_addImg(domain);;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return file_cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.db2.PsogmAttachedFileService#deleteImg(PsogmImprvDDomain)
     */
    public int deleteImg(PsogmImprvDDomain domain) throws ApplicationException {
        String fileName = "";
        PsogmImprvDDomain searchDomain = domain;
        searchDomain = psogmImprvDDao.selectOgm204_obj210pf_01(domain);
        if(domain.getImgaf() != null && !"".equals(domain.getImgaf())) {
            fileName = rootPath + searchDomain.getImgaf();
            domain.setImgaf("");
        } else if(domain.getImgbf() != null && !"".equals(domain.getImgbf())) {
            fileName = rootPath + searchDomain.getImgbf();
            domain.setImgbf("");
        } 
        
        UxisFileMngUtil fileUtil = new UxisFileMngUtil();
        fileUtil.deleteFile(fileName);
        
        return psogmImprvDDao.updateOgm204_obj210pf_addImg(domain);
    }
}
