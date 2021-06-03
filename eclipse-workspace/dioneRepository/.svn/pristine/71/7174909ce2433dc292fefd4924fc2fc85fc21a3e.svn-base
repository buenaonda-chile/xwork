package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.BoardAtchmnflDto;
import java.util.List;

public interface BoardAtchmnflService {

  List<BoardAtchmnflDto> searchByCondition(Long boardSeq) throws ApplicationException;
  int searchCountByKey(BoardAtchmnflDto boardAtchmnflDto) throws ApplicationException;

  void create(BoardAtchmnflDto boardAtchmnflDto) throws ApplicationException;

  void delete(BoardAtchmnflDto boardAtchmnflDto) throws ApplicationException;
  void deleteAll(Long boardSeq) throws ApplicationException;
}
