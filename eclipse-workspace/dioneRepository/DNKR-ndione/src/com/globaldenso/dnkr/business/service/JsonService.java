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

import com.globaldenso.ai.core.exception.ApplicationException;

/**
 * [KR] 권한관리 서비스 인터페이스. <br>
 * [EN] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface JsonService {

    public List<Object> searchJson(HashMap<String, String> setParam) throws ApplicationException;
    
}
