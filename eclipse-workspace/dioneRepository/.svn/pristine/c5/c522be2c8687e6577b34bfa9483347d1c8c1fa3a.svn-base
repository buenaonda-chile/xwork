package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ClaimVehicleDto;
import com.globaldenso.dicas.presentation.form.ClaimVehicleSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * [KR] 클레임현황
 *
 * @author TWOGOMS
 * @ver
 */
public interface ClaimVehicleService {
    ClaimVehicleDto searchByKey(ClaimVehicleDto claimVehicleDto) throws ApplicationException;
    Page<ClaimVehicleDto> searchByCondition(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;
    Page<ClaimVehicleDto> searchByPopupCondition(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;
    Page<ClaimVehicleDto> searchByConditionDownload(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;
    Page<ClaimVehicleDto> searchByByMainIngListDownload(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;
    Page<ClaimVehicleDto> searchByMainRsListDownLoad(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;
    Page<ClaimVehicleDto> searchByTypeDownload(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;

    /**
     * 조건에 의한 클레임 현황
     * 관리자 + 타입
     * @param criteria
     * @param pageable
     * @return
     * @throws ApplicationException
     */
    Page<ClaimVehicleDto> searchByType(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;

    Page<ClaimVehicleDto> searchByMainIngList(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;

    Page<ClaimVehicleDto> searchByMainRsList(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;

    List<ClaimVehicleDto> searchGrpCdByCondition(ClaimVehicleSearchForm criteria) throws ApplicationException;
    List<ClaimVehicleDto> searchByMain() throws ApplicationException;
    int searchByMainClaimProcessCnt(String keyValue) throws ApplicationException;
    int searchByMainClaimPerCnt() throws ApplicationException;

    int searchByMainIngCnt() throws ApplicationException;
    int searchByMaingRsCnt() throws ApplicationException;
    int searchByMaingPerCnt() throws ApplicationException;

    Page<ClaimVehicleDto> searchByConditionRecpDt(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;
    Page<ClaimVehicleDto> searchByConditionDownloadRecpDt(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException;
}
