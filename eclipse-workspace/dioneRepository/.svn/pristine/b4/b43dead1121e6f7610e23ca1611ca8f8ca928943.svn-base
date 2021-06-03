/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.DeptTreeDto;
import com.globaldenso.dicas.business.dto.GroupDto;
import com.globaldenso.dicas.presentation.form.GroupSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] 그룹관리 서비스 인터페이스.
 *
 * @author TWOGOMS
 * @version 1.0
 */
public interface GroupService {

  GroupDto searchByKey(GroupDto groupDto) throws ApplicationException;
  List<GroupDto> searchByCondition(GroupSearchForm criteria) throws ApplicationException;
  List<DeptTreeDto> searchGroupTreeByCondition(GroupSearchForm criteria) throws ApplicationException;

  void create(GroupDto groupDto) throws ApplicationException;
  void update(GroupDto groupDto) throws ApplicationException;
  void delete(GroupDto groupDto) throws ApplicationException;
}
