package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.MainRePartDao;
import com.globaldenso.dicas.business.dto.MainRePartDto;
import com.globaldenso.dicas.business.service.MainRePartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mainRePartService")
public class MainRePartServiceImpl implements MainRePartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainRePartServiceImpl.class);

    @Autowired
    private MainRePartDao mainRePartDao;

    /**
     * [EN] Default constructor.<br>
     * [KR] 기본 생성자
     */
    public MainRePartServiceImpl() {
        // no process
    }

    @Override
    public MainRePartDto searchByKey(MainRePartDto mainRePartDto) throws ApplicationException {
        return mainRePartDao.searchByKey(mainRePartDto);
    }

    @Override
    public MainRePartDto searchByString(String keyValue) throws ApplicationException {
        return mainRePartDao.searchByString(keyValue);
    }

    @Override
    public MainRePartDto searchByString1(String keyValue) throws ApplicationException {
        return mainRePartDao.searchByString1(keyValue);
    }

    @Override
    public MainRePartDto searchByString2(String keyValue) throws ApplicationException {
        return mainRePartDao.searchByString2(keyValue);
    }

    @Override
    public MainRePartDto searchByString3(String keyValue) throws ApplicationException {
        return mainRePartDao.searchByString3(keyValue);
    }
}
