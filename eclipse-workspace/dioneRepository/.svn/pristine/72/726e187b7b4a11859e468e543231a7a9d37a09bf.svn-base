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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.integration.dao.JsonDao;

/**
 * [KR] 권한관리 서비스 구현.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("jsonService")
public class JsonServiceImpl implements JsonService {

   
    @Autowired
    private JsonDao jsonDao;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public JsonServiceImpl() {
        // no process
    }

    
    /**
     * [EN] Set DAO of Employee information.<br>
     * [JP] 社員情報のDAOを設定します。<br>
     * 
     * @param authDao Dao of 'EMP_INFO'
     */
    public void setJsonDao(JsonDao jsonDao) {
		this.jsonDao = jsonDao;
	}

	/**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.JsonService#searchQR()
     */
    public List<Object> searchJson(HashMap<String, String> setParam) throws ApplicationException {
        return jsonDao.searchJson(setParam);
    }
    
}
