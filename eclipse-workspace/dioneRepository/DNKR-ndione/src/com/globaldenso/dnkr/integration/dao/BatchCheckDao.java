package com.globaldenso.dnkr.integration.dao;

import java.util.List;
import java.util.Map;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BatchDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface BatchCheckDao {

    /**
     * [KO] 배치 정보를 DB 테이블에서 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'NonOrderDayTransferWorkDomain' class
     * @return List of 'NonOrderDayTransferWorkDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<BatchDomain> selectBatchInfo(String string) throws ApplicationException;
    public int searchBatchCheckError(BatchDomain batchDomain) throws ApplicationException;
    public int searchBatchCheckMassage() throws ApplicationException;
    public void insertSmsSendData(Map<String, String> map) throws ApplicationException;
    public List<BatchDomain> searchSMSuserList() throws ApplicationException;
    public void updateSMSsendCount(Map<String, String> map) throws ApplicationException;
}
