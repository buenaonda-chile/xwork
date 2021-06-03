package com.globaldenso.dnkr.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.dnkr.integration.dao.WorkConfirmDao;

/**
 * [KO] 업무승인 관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("workConfirmService")
public class WorkConfirmServiceImpl implements WorkConfirmService {

    /**
     * [KO] 업무승인 관리 Dao <br>
     */
    @Autowired
    private WorkConfirmDao workConfirmDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WorkConfirmServiceImpl() {
        // no process
    }
}
