package com.globaldenso.dicas.business.service.impl;


import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.ClaimVehicleDao;
import com.globaldenso.dicas.business.dto.ClaimVehicleDto;
import com.globaldenso.dicas.business.service.ClaimVehicleService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.ClaimVehicleSearchForm;

import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.string.EgovStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("claimVehicleService")
public class ClaimVehicleServiceImpl implements ClaimVehicleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClaimVehicleServiceImpl.class);

    @Autowired
    private ClaimVehicleDao claimVehicleDao;

    public ClaimVehicleServiceImpl() {
    }

    public void setClaimVehicleDao(ClaimVehicleDao claimVehicleDao) {this.claimVehicleDao = claimVehicleDao;}

    @Override
    public ClaimVehicleDto searchByKey(ClaimVehicleDto claimVehicleDto) throws ApplicationException {
        return claimVehicleDao.searchByKey(claimVehicleDto);
    }

    @Override
    public Page<ClaimVehicleDto> searchByCondition(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchCount1(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByCondition(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    /**
     * 2019-04-27
     * User별 검색
     * @param criteria
     * @param pageable
     * @return
     * @throws ApplicationException
     */
    @Override
    public Page<ClaimVehicleDto> searchByPopupCondition(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {

        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        String statusUsr = null;
        if (loginVO.getOfficeCd()!= null){
            statusUsr = loginVO.getUsername();
            criteria.setStatusUsr(statusUsr);
        }

        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;

        if (pageable != null){
            if (loginVO.getOfficeCd() != null) {
                totalCount =  claimVehicleDao.searchCount2(searchMap);
            }else{
                totalCount =  claimVehicleDao.searchCount1(searchMap);
            }
        }

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = null ;
        if (loginVO.getOfficeCd() != null) {
            claimVehicleDtos = claimVehicleDao.searchByPopupCondition(searchMap);
        }else{
            claimVehicleDtos = claimVehicleDao.searchByCondition(searchMap);
        }

        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    @Override
    public Page<ClaimVehicleDto> searchByConditionDownload(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchCount1(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByConditionDownload(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    @Override
    public Page<ClaimVehicleDto> searchByByMainIngListDownload(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        if (!loginVO.getUsername().equals("system")){
            criteria.setStatusUsr(loginVO.getUsername());
        }
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchCount1(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByByMainIngListDownload(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    @Override
    public Page<ClaimVehicleDto> searchByMainRsListDownLoad(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        if (!loginVO.getUsername().equals("system")){
            criteria.setStatusUsr(loginVO.getUsername());
        }
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchCount1(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByMainRsListDownLoad(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    @Override
    public Page<ClaimVehicleDto> searchByTypeDownload(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        if (!loginVO.getUsername().equals("system")){
            criteria.setStatusUsr(loginVO.getUsername());
        }
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchCount1(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByTypeDownload(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    /**
     * 2019.02.18 추가
     * @param criteria
     * @param pageable
     * @return
     * @throws ApplicationException
     */
    @Override
    public Page<ClaimVehicleDto> searchByType(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        if (!loginVO.getUsername().equals("system")){
            criteria.setStatusUsr(loginVO.getUsername().toString());
        }
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchByTypeCount(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByType(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    @Override
    public Page<ClaimVehicleDto> searchByMainIngList(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        if (!loginVO.getUsername().equals("system")){
            criteria.setStatusUsr(loginVO.getUsername());
        }
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchByMainIngListCount(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByMainIngList(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    @Override
    public Page<ClaimVehicleDto> searchByMainRsList(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        if (!loginVO.getUsername().equals("system")){
            criteria.setStatusUsr(loginVO.getUsername());
        }
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchByMainRsListCount(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByMainRsList(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    @Override
    public List<ClaimVehicleDto> searchGrpCdByCondition(ClaimVehicleSearchForm criteria) throws ApplicationException {
        return searchByCondition(criteria, null).getContent();
    }

    @Override
    public List<ClaimVehicleDto> searchByMain() throws ApplicationException {
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        String id = null;
        //if (!loginVO.getUsername().equals("system")){
        if (EgovStringUtil.isNull(loginVO.getOfficeCd())){
            id = null;
        }else{
            id = loginVO.getUsername();
        }
        return claimVehicleDao.searchByMainUser(id);
    }

    @Override
    public int searchByMainClaimProcessCnt(String keyValue) throws ApplicationException {
        int rsCnt = 0 ;
        rsCnt = claimVehicleDao.searchByMainClaimProcessCnt(keyValue);
        return rsCnt;
    }

    @Override
    public int searchByMainClaimPerCnt() throws ApplicationException {
        int rsCnt = 0;
        rsCnt = claimVehicleDao.searchByMainClaimPerCnt();
        return rsCnt;
    }

    @Override
    public int searchByMainIngCnt() throws ApplicationException {
        int cnt = 0;
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        String id = null;
        if (!loginVO.getUsername().equals("system")){
            id = loginVO.getUsername();
        }
        cnt = claimVehicleDao.searchByMainIngCnt(id);

        return cnt;
    }

    @Override
    public int searchByMaingRsCnt() throws ApplicationException {
        int cnt = 0;
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        String id = null;
        if (!loginVO.getUsername().equals("system")){
            id = loginVO.getUsername();
        }
        cnt = claimVehicleDao.searchByMaingRsCnt(id);
        return cnt;
    }

    @Override
    public int searchByMaingPerCnt() throws ApplicationException {
        int cnt = 0;
        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        String id = null;
        if (!loginVO.getUsername().equals("system")){
            id = loginVO.getUsername();
        }
        cnt = claimVehicleDao.searchByMaingPerCnt(id);
        return cnt;
    }

    @Override
    public Page<ClaimVehicleDto> searchByConditionRecpDt(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchCount3(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByConditionRecpDt(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }

    @Override
    public Page<ClaimVehicleDto> searchByConditionDownloadRecpDt(ClaimVehicleSearchForm criteria, Pageable pageable) throws ApplicationException {
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if (pageable != null)
            totalCount =  claimVehicleDao.searchCount3(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        List<ClaimVehicleDto> claimVehicleDtos = claimVehicleDao.searchByConditionDownloadRecpDt(searchMap);
        if(totalCount == 0) totalCount = claimVehicleDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(claimVehicleDtos, pageable, totalCount);
    }
}
