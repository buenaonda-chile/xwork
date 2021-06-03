/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.domain.SsoAuthDomain;
import com.globaldenso.dnkr.integration.dao.PrivateAuthDao;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KR] 권한관리 서비스 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("privateAuthService")
public class PrivateAuthServiceImpl implements PrivateAuthService {

    /**
     * [KR] 권한관리 Dao <br>
     */
    @Autowired
    private PrivateAuthDao privateAuthDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PrivateAuthServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set DAO of Employee information.<br>
     * [JP] 社員情報のDAOを設定します。<br>
     * 
     * @param privateAuthDao PrivateAuthDao
     */
    public void setAuthDao(PrivateAuthDao privateAuthDao) {
        this.privateAuthDao = privateAuthDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchByKey(PrivateAuthDomain)
     */
    public PrivateAuthDomain searchByKey(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchByCondition(PrivateAuthDomain)
     */
    public List<PrivateAuthDomain> searchByCondition(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchAuthDetail(PrivateAuthDomain)
     */
    public List<PrivateAuthDomain> searchAuthDetail(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.searchAuthDetail(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchMenuList(PrivateAuthDomain)
     */
    public List<PrivateAuthDomain> searchMenuList(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.searchMenuList(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchByConditionForPaging(PrivateAuthDomain)
     */
    public List<PrivateAuthDomain> searchByConditionForPaging(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchCount(PrivateAuthDomain)
     */
    public int searchCount(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchByKey(PrivateAuthDomain)
     */
    public PrivateAuthDomain searchPrivateAuthDetail(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.searchPrivateAuthDetail(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#create(PrivateAuthDomain)
     */
    public int create(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.create(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#update(PrivateAuthDomain)
     */
    public int update(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.update(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#delete(PrivateAuthDomain)
     */
    public int delete(PrivateAuthDomain domain) throws ApplicationException {
        return privateAuthDao.delete(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#delete(List)
     */
    public int delete(List<PrivateAuthDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (PrivateAuthDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchByConditionSsoAuth(SsoAuthDomain)
     */
    public List<SsoAuthDomain> searchByConditionSsoAuth(SsoAuthDomain domain) throws ApplicationException {
        return privateAuthDao.searchByConditionSsoAuth(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#searchCountSsoAuth(SsoAuthDomain)
     */
    public int searchCountSsoAuth(SsoAuthDomain domain) throws ApplicationException {
        return privateAuthDao.searchCountSsoAuth(domain);
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#createSsoAuth(SsoAuthDomain)
     */
    public int createSsoAuth(SsoAuthDomain domain) throws ApplicationException {
        return privateAuthDao.createSsoAuth(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.AuthService#updateSsoAuth(SsoAuthDomain)
     */
    public int updateSsoAuth(SsoAuthDomain domain) throws ApplicationException {
        return privateAuthDao.updateSsoAuth(domain);
    }
    
}
