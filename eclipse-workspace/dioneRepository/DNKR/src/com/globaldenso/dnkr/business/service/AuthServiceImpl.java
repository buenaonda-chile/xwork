/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.AuthDomain;
import com.globaldenso.dnkr.integration.dao.AuthDao;

/**
 * [KR] 권한관리 서비스 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("authService")
public class AuthServiceImpl implements AuthService {

    /**
     * [KR] 권한관리 Dao <br>
     */
    @Autowired
    private AuthDao authDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AuthServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set DAO of Employee information.<br>
     * [JP] 社員情報のDAOを設定します。<br>
     * 
     * @param authDao Dao of 'EMP_INFO'
     */
    public void setAuthDao(AuthDao authDao) {
        this.authDao = authDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchByKey(AuthDomain)
     */
    public AuthDomain searchByKey(AuthDomain domain) throws ApplicationException {
        return authDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchByCondition(AuthDomain)
     */
    public List<AuthDomain> searchByCondition(AuthDomain domain) throws ApplicationException {
        return authDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchTeamMenuList(AuthDomain)
     */
    public List<AuthDomain> searchTeamMenuList(AuthDomain domain) throws ApplicationException {
        return authDao.searchTeamMenuList(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchByConditionForPaging(AuthDomain)
     */
    public List<AuthDomain> searchByConditionForPaging(AuthDomain domain) throws ApplicationException {
        return authDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchAuthDetail(AuthDomain)
     */
    public List<AuthDomain> searchAuthDetail(AuthDomain domain) throws ApplicationException {
        return authDao.searchAuthDetail(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchCount(AuthDomain)
     */
    public int searchCount(AuthDomain domain) throws ApplicationException {
        return authDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchAuthDetailCount(AuthDomain)
     */
    public int searchAuthDetailCount(AuthDomain domain) throws ApplicationException {
        return authDao.searchAuthDetailCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#create(AuthDomain)
     */
    public void create(AuthDomain domain, List<String> langList) throws ApplicationException {
        try {
            authDao.create(domain, langList);
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
     * @see com.globaldenso.dnkr.business.service.AuthService#createDetail(AuthDomain)
     */
    public void createDetail(AuthDomain domain) throws ApplicationException {
        try {
            authDao.createDetail(domain);
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
     * @see com.globaldenso.dnkr.business.service.AuthService#update(AuthDomain)
     */
    public int update(AuthDomain domain) throws ApplicationException {
        int upResult = 0;
        upResult += updateCode(domain);
        upResult += updateName(domain);
        return upResult;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#updateCode(AuthDomain)
     */
    public int updateCode(AuthDomain domain) throws ApplicationException {
        return authDao.updateCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#updateName(AuthDomain)
     */
    public int updateName(AuthDomain domain) throws ApplicationException {
        return authDao.updateName(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#updateDetail(AuthDomain)
     */
    public int updateDetail(AuthDomain domain) throws ApplicationException {
        return authDao.updateDetail(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#delete(AuthDomain)
     */
    public int delete(AuthDomain domain) throws ApplicationException {
        int delResult = 0;
        //권한 상세 삭제
        try{
            delResult += deleteDetail(domain);
        } catch(Exception e) {
            System.out.println("삭제할 데이터가 없습니다.");
        }
        
        //권한 명칭 삭제
        delResult += deleteName(domain);
                
        //권한 삭제
        delResult += deleteCode(domain);
        
        return delResult;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#deleteCode(AuthDomain)
     */
    public int deleteCode(AuthDomain domain) throws ApplicationException {
        return authDao.deleteCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#deleteName(AuthDomain)
     */
    public int deleteName(AuthDomain domain) throws ApplicationException {
        return authDao.deleteName(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#deleteDetail(AuthDomain)
     */
    public int deleteDetail(AuthDomain domain) throws ApplicationException {
        return authDao.deleteDetail(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#delete(List)
     */
    public int delete(List<AuthDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (AuthDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
}
