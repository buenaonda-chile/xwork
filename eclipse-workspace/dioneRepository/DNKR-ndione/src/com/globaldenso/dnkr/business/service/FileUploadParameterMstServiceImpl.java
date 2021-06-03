package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.FileUploadParameterMstDomain;
import com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao;

/**
* [KR] 파일업로드파라메터관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("fileUploadParameterMstService")
public class FileUploadParameterMstServiceImpl implements FileUploadParameterMstService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of FileUploadParameterMstDao.<br>
     */
    @Autowired
    private FileUploadParameterMstDao fileUploadParameterMstDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public FileUploadParameterMstServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set FileUploadParameterMstDao.<br>
     * [JP] <br>
     * 
     * @param fileUploadParameterMstDao 'FileUploadParameterMstDao' class
     */
    public void setFileUploadParameterMstDao(FileUploadParameterMstDao topCustTypeMstDao) {
        this.fileUploadParameterMstDao = fileUploadParameterMstDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.FileUploadParameterMstService#searchByKey(FileUploadParameterMstDomain)
     */
    public FileUploadParameterMstDomain searchByKey(FileUploadParameterMstDomain domain) throws ApplicationException {
        return fileUploadParameterMstDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.FileUploadParameterMstService#searchByCondition(FileUploadParameterMstDomain)
     */
    public List<FileUploadParameterMstDomain> searchByCondition(FileUploadParameterMstDomain domain) throws ApplicationException {
        return fileUploadParameterMstDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.FileUploadParameterMstService#searchByConditionForPaging(FileUploadParameterMstDomain)
     */
    public List<FileUploadParameterMstDomain> searchByConditionForPaging(FileUploadParameterMstDomain domain) throws ApplicationException {
        return fileUploadParameterMstDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.FileUploadParameterMstService#searchCount(FileUploadParameterMstDomain)
     */
    public int searchCount(FileUploadParameterMstDomain domain) throws ApplicationException {
        return fileUploadParameterMstDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.FileUploadParameterMstService#searchCount2(FileUploadParameterMstDomain)
     */
    public int searchCount2(FileUploadParameterMstDomain domain) throws ApplicationException {
        return fileUploadParameterMstDao.searchCount2(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.FileUploadParameterMstService#create(FileUploadParameterMstDomain)
     */
    public void create(FileUploadParameterMstDomain domain) throws ApplicationException {
        try {
        	fileUploadParameterMstDao.create(domain);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.FileUploadParameterMstService#update(FileUploadParameterMstDomain)
     */
    public int update(FileUploadParameterMstDomain domain) throws ApplicationException {
    	return fileUploadParameterMstDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.FileUploadParameterMstService#delete(TopCustTypeMstDomain)
     */
    public int delete(FileUploadParameterMstDomain domain) throws ApplicationException {
    	return fileUploadParameterMstDao.delete(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.FileUploadParameterMstService#delete(List)
     */
    public int delete(List<FileUploadParameterMstDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (FileUploadParameterMstDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
