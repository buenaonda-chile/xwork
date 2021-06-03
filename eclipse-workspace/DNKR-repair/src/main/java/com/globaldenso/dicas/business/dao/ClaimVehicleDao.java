package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ClaimVehicleDomain;
import com.globaldenso.dicas.business.dto.ClaimVehicleDto;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository("claimVehicleDao")
public interface ClaimVehicleDao {
    ClaimVehicleDto searchByKey(ClaimVehicleDomain domain) throws SystemException;

    List<ClaimVehicleDto> searchByCondition(Map<String, Object> params) throws SystemException;

    List<ClaimVehicleDto> searchByPopupCondition(Map<String, Object> params) throws SystemException;

    List<ClaimVehicleDto> searchByConditionDownload(Map<String, Object> params) throws SystemException;

    List<ClaimVehicleDto> searchByByMainIngListDownload(Map<String, Object> searchMap) throws SystemException;

    List<ClaimVehicleDto> searchByMainRsListDownLoad(Map<String, Object> searchMap) throws SystemException;

    List<ClaimVehicleDto> searchByTypeDownload(Map<String, Object> searchMap) throws SystemException;

    int searchCount1(Map<String, Object> params) throws SystemException;

    int searchCount2(Map<String, Object> params) throws SystemException;

    int searchCount3(Map<String, Object> params) throws SystemException;
    /**
     *
     * @param params
     * @return
     * @throws SystemException
     */
    List<ClaimVehicleDto> searchByType(Map<String, Object> params) throws SystemException;

    /**
     *
     * @param params
     * @return
     * @throws SystemException
     */
    int searchByTypeCount (Map<String, Object> params) throws SystemException;

    List<ClaimVehicleDto> searchByMainIngList(Map<String, Object> params) throws SystemException;

    int searchByMainIngListCount (Map<String, Object> params) throws SystemException;

    List<ClaimVehicleDto> searchByMainRsList(Map<String, Object> params) throws SystemException;

    int searchByMainRsListCount (Map<String, Object> params) throws SystemException;

    List<ClaimVehicleDto> searchByMain() throws SystemException;

    List<ClaimVehicleDto> searchByMainUser(String uname) throws SystemException;

    int searchByMainClaimProcessCnt(String keyValue) throws SystemException;

    int searchByMainClaimPerCnt() throws SystemException;

    int searchByMainIngCnt(String uname) throws SystemException;

    int searchByMaingRsCnt(String uname) throws SystemException;

    int searchByMaingPerCnt(String uname) throws SystemException;

    List<ClaimVehicleDto> searchByConditionRecpDt(Map<String, Object> params) throws SystemException;
    List<ClaimVehicleDto> searchByConditionDownloadRecpDt(Map<String, Object> params) throws SystemException;

}