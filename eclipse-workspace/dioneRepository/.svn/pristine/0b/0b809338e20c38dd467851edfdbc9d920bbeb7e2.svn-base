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

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.LinkDomain;
import com.globaldenso.dnkr.domain.SessionDomain;
import com.globaldenso.dnkr.domain.SsoAccountDomain;
import com.globaldenso.dnkr.integration.dao.LinkDao;

/**
 * [KR] 링크관리 서비스 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    /**
     * [KR] 링크관리 Dao <br>
     */
    @Autowired
    private LinkDao linkDao;
    
        
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public LinkServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set DAO of Employee information.<br>
     * [JP] 社員情報のDAOを設定します。<br>
     * 
     * @param linkDao Dao of 'Link_INFO'
     */
    public void setAuthDao(LinkDao linkDao) {
        this.linkDao = linkDao;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchCount(LinkDomain)
     */
    public int searchCountLink(LinkDomain domain) throws ApplicationException {
        return linkDao.searchCountLink(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchByConditionForPaging(LinkDomain)
     */
    public List<LinkDomain> searchByConditionForPagingLink(LinkDomain domain) throws ApplicationException {
        return linkDao.searchByConditionForPagingLink(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#createLink(LinkDomain)
     */
    public int createLink(LinkDomain domain) throws ApplicationException{

        //domain.setCreateUser(DensoContext.get().getDscId());
       // domain.setLastUpdateUser(DensoContext.get().getDscId());
        return linkDao.createLink(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#updatLink(LinkDomain)
     */
    public int updateLink(LinkDomain domain) throws ApplicationException{
       // domain.setCreateUser(DensoContext.get().getDscId());
       // domain.setLastUpdateUser(DensoContext.get().getDscId());
        int cnt = linkDao.updateLink(domain);
        return cnt;
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#deleteLink(LinkDomain)
     */
    public int deleteLink(LinkDomain domain) throws ApplicationException{
       // domain.setCreateUser(DensoContext.get().getDscId());
       // domain.setLastUpdateUser(DensoContext.get().getDscId());
        int cnt = linkDao.deleteLink(domain);  
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchCount(LinkDomain)
     */
    public int searchCountSso(LinkDomain domain) throws ApplicationException {
        return linkDao.searchCountSso(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchByConditionForPaging(LinkDomain)
     */
    public List<LinkDomain> searchByConditionForPagingSso(LinkDomain domain) throws ApplicationException {
        return linkDao.searchByConditionForPagingSso(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#createLink(LinkDomain)
     */
    public int createSso(LinkDomain domain) throws ApplicationException{

        //domain.setCreateUser(DensoContext.get().getDscId());
       // domain.setLastUpdateUser(DensoContext.get().getDscId());
        return linkDao.createSso(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#updatLink(LinkDomain)
     */
    public int updateSso(LinkDomain domain) throws ApplicationException{
       // domain.setCreateUser(DensoContext.get().getDscId());
       // domain.setLastUpdateUser(DensoContext.get().getDscId());
        int cnt = linkDao.updateSso(domain);
        return cnt;
    }

    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#deleteLink(LinkDomain)
     */
    public int deleteSso(LinkDomain domain) throws ApplicationException{
       // domain.setCreateUser(DensoContext.get().getDscId());
       // domain.setLastUpdateUser(DensoContext.get().getDscId());
        int cnt = linkDao.deleteSso(domain);  
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchByConditionForPaging(LinkDomain)
     */
    public LinkDomain searchSsoUrl(LinkDomain domain) throws ApplicationException {
        return linkDao.searchSsoUrl(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchByConditionForPaging(SsoAccountDomain)
     */
    public List<SsoAccountDomain> searchBySsoAccount(SsoAccountDomain domain) throws ApplicationException {
        return linkDao.searchBySsoAccount(domain);
    }
  
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchByConditionForPaging(SsoAccountDomain)
     */
    public List<SsoAccountDomain> searchBySsoDeviceId(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.searchBySsoDeviceId(domain);
	}
	public List<SsoAccountDomain> searchBySsoSystem(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.searchBySsoSystem(domain);
	}
    public int searchBySsoSystemCount(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.searchBySsoSystemCount(domain);
	}
    
    public int insertSsoSystemUser(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.insertSsoSystemUser(domain);
	}
    
    public int updateSsoSystemUser(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.updateSsoSystemUser(domain);
	}
    
    public int deleteSsoSystemUser(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.deleteSsoSystemUser(domain);
	}

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchBySsoDeviceCompany(SsoAccountDomain)
     */
    public List<SsoAccountDomain> searchBySsoSystemCompany(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.searchBySsoSystemCompany(domain);
	}
	
	 /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchBySsoDeviceCompany(SsoAccountDomain)
     */
    public List<SsoAccountDomain> searchBySsoDeviceCompany(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.searchBySsoDeviceCompany(domain);
	}
	
	public List<SsoAccountDomain> searchBySsoDevice(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.searchBySsoDevice(domain);
	}
	
	public int searchBySsoDeviceCount(SsoAccountDomain domain) throws ApplicationException {
	    return linkDao.searchBySsoDeviceCount(domain);
	}
	
    public int insertSsoDeviceUser(SsoAccountDomain domain) throws ApplicationException{
	    return linkDao.insertSsoDeviceUser(domain);
	}
    
    public int updateSsoDeviceUser(SsoAccountDomain domain) throws ApplicationException{
	    return linkDao.updateSsoDeviceUser(domain);
	}
  
	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#ssoUrlAccounts(SsoAccountDomain)
     */
  	//sso url 조회
    public LinkDomain ssoUrlAccounts(LinkDomain domain) throws ApplicationException {
	    return linkDao.ssoUrlAccounts(domain);
	}
    
    //sso url + 사용자 조회
    public LinkDomain ssoUrlAccountsAuth(LinkDomain domain) throws ApplicationException {
	    return linkDao.ssoUrlAccountsAuth(domain);
	}
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.LinkService#searchDioneAccountCnt(SessionDomain)
     */
	//Display session count
    public List<SessionDomain> searchDioneAccountCnt(SessionDomain domain) throws ApplicationException{
	    return linkDao.searchDioneAccountCnt(domain);
	}

    //Display session 사용자 죠회
    public List<SessionDomain> searchSsoDspSessionAccount(SessionDomain domain) throws ApplicationException{
	    return linkDao.searchSsoDspSessionAccount(domain);
	}
    
    //Print session 사용자 죠회
    public SessionDomain searchSsoPrtSessionAccount(SessionDomain domain) throws ApplicationException{
	    return linkDao.searchSsoPrtSessionAccount(domain);
	}
}
