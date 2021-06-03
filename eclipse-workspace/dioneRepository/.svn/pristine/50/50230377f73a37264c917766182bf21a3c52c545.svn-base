package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.AtchmnflDto;
import com.globaldenso.dicas.business.dto.FileSaveResultDto;
import com.globaldenso.dicas.presentation.form.AtchmnflSearchForm;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface AtchmnflService {

  AtchmnflDto searchByKey(AtchmnflDto atchmnflDto) throws ApplicationException;
  List<AtchmnflDto> searchByCondition(AtchmnflSearchForm criteria) throws ApplicationException;

  FileSaveResultDto save(MultipartFile file, String metadata) throws ApplicationException;
  void delete(long atchmnflId) throws ApplicationException;
}
