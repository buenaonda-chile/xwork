/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.ResultMasterDomain;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * [EN] ResultMaster class of Menu information.<br>
 * [JP] ResultMaster class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("resultMasterDao")
public interface ResultMasterDao {

  ResultMasterDto searchByKey(ResultMasterDomain domain) throws SystemException;

  List<ResultMasterDto> searchByCondition(Map<String, Object> params) throws SystemException;

  List<ResultMasterDto> searchByCondition2(Map<String, Object> params) throws SystemException;

  List<ResultMasterDto> searchListByCondition(Map<String, Object> params) throws SystemException;

  List<ResultMasterDto> searchListByCondition2(Map<String, Object> params) throws SystemException;

  List<ResultMasterDto> searchListByConditionDownload(Map<String, Object> params) throws SystemException;

  List<ResultMasterDto> searchMainListByCondition() throws SystemException;

  List<ResultMasterDto> searchMainListByUser(String uname) throws SystemException;

  int searchCount(Map<String, Object> params) throws SystemException;

  int searchCount2(Map<String, Object> params) throws SystemException;

  int searchListByCount(Map<String, Object> params) throws SystemException;

  int searchListByCount2(Map<String, Object> params) throws SystemException;

  void create(ResultMasterDomain domain) throws SystemException;

  void update(ResultMasterDomain domain) throws SystemException;

  void updateManageNo(ResultMasterDomain domain) throws SystemException;

  void gridUpdate(ResultMasterDomain domain) throws SystemException;

  void delete(ResultMasterDomain domain) throws SystemException;

  void deleteManageNo(ResultMasterDomain domain) throws SystemException;


  void update2(ResultMasterDomain domain) throws SystemException;

  void update3(ResultMasterDomain domain) throws SystemException;

  void update4(ResultMasterDomain domain) throws SystemException;

  int searchCountByKey(ResultMasterDomain domain) throws SystemException;
  void fileCreate(ResultMasterDomain domain) throws SystemException;

  void update5(ResultMasterDomain domain) throws SystemException;

  void mobileUpdate(ResultMasterDomain domain) throws SystemException;

  List<ResultMasterDto> selectMstInfo(Map<String, Object> params) throws SystemException;
}
