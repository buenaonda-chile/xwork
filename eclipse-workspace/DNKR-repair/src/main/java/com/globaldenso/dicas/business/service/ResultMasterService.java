/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.presentation.form.ResultMasterSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR]
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface ResultMasterService {

  ResultMasterDto searchByKey(ResultMasterDto resultmasterDto) throws ApplicationException;
  Page<ResultMasterDto> searchByCondition(ResultMasterSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<ResultMasterDto> searchGrpCdByCondition(ResultMasterSearchForm criteria) throws ApplicationException;
  List<ResultMasterDto> searchResultMasterByCondition(ResultMasterSearchForm criteria) throws ApplicationException;

  Page<ResultMasterDto> searchByCondition2(ResultMasterSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<ResultMasterDto> searchListByCondition(ResultMasterSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<ResultMasterDto> searchListByCondition2(ResultMasterSearchForm criteria, Pageable pageable) throws ApplicationException;
  Page<ResultMasterDto> searchListByConditionDownload(ResultMasterSearchForm criteria, Pageable pageable) throws ApplicationException;

  List<ResultMasterDto> searchMainListByCondition() throws ApplicationException; // main
  List<ResultMasterDto> searchMainListByUser() throws ApplicationException; // main

  void create(ResultMasterDto resultmasterDto) throws ApplicationException;
  void update(ResultMasterDto resultmasterDto) throws ApplicationException;
  void updateManageNo(ResultMasterDto resultmasterDto) throws ApplicationException;
  void gridUpdate(ResultMasterDto resultmasterDto) throws ApplicationException;
  void delete(ResultMasterDto resultmasterDto) throws ApplicationException;
  void deleteManageNo(ResultMasterDto resultmasterDto) throws ApplicationException;
  void update2(ResultMasterDto resultmasterDto) throws ApplicationException;
  void update3(ResultMasterDto resultmasterDto) throws ApplicationException;
  void update4(ResultMasterDto resultmasterDto) throws ApplicationException;
  void update5(ResultMasterDto resultmasterDto) throws ApplicationException;
  void mobileUpdate(ResultMasterDto resultmasterDto) throws ApplicationException;

  Page<ResultMasterDto> selectMstInfo(ResultMasterSearchForm criteria, Pageable pageable) throws ApplicationException;

}
