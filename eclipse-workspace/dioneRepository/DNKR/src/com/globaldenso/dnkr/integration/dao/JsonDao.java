/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;

/**
 * [KO] 권한관리 정보의 dao 인터페이스.<br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface JsonDao {


    public List<Object> searchJson(HashMap<String, String> setParam) throws ApplicationException; 
   
}
