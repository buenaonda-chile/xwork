package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.BoardAtchmnflDomain;
import com.globaldenso.dicas.business.dto.BoardAtchmnflDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("boardAtchmnflDao")
public interface BoardAtchmnflDao {

  List<BoardAtchmnflDto> searchByCondition(BoardAtchmnflDto boardAtchmnflDto) throws SystemException;
  int searchCountByKey(BoardAtchmnflDto boardAtchmnflDto) throws SystemException;

  void create(BoardAtchmnflDomain boardAtchmnflDomain) throws SystemException;
  void delete(BoardAtchmnflDomain boardAtchmnflDomain) throws SystemException;
}
