package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * [KR] 메뉴관리 서비스 인터페이스.
 *
 * @author $Author$
 * @version $Revision$
 */
public interface CodeService {

  CodeDto searchByKey(CodeDto codeDto) throws ApplicationException;
  Page<CodeDto> searchByCondition(CodeSearchForm criteria, Pageable pageable) throws ApplicationException;
  List<CodeDto> searchGrpCdByCondition(CodeSearchForm criteria) throws ApplicationException;
  List<CodeDto> searchCodeByCondition(CodeSearchForm criteria) throws ApplicationException;

  void create(CodeDto codeDto) throws ApplicationException;
  void update(CodeDto codeDto) throws ApplicationException;
  void delete(CodeDto codeDto) throws ApplicationException;
}
