package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.BoardAtchmnflDao;
import com.globaldenso.dicas.business.dto.BoardAtchmnflDto;
import com.globaldenso.dicas.business.service.BoardAtchmnflService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardAtchmnflService")
public class BoardAtchmnflServiceImpl implements BoardAtchmnflService {

  private static final Logger LOGGER = LoggerFactory.getLogger(BoardAtchmnflServiceImpl.class);

  @Autowired
  private BoardAtchmnflDao boardAtchmnflDao;

  @Override
  public List<BoardAtchmnflDto> searchByCondition(Long boardSeq) throws ApplicationException {

    BoardAtchmnflDto searchDto = new BoardAtchmnflDto() {{
      setBoardSeq(boardSeq);
    }};

    return boardAtchmnflDao.searchByCondition(searchDto);
  }

  @Override
  public int searchCountByKey(BoardAtchmnflDto boardAtchmnflDto) throws ApplicationException {
    return boardAtchmnflDao.searchCountByKey(boardAtchmnflDto);
  }

  @Override
  public void create(BoardAtchmnflDto boardAtchmnflDto) throws ApplicationException {
    boardAtchmnflDao.create(boardAtchmnflDto);
  }

  @Override
  public void delete(BoardAtchmnflDto boardAtchmnflDto) throws ApplicationException {
    boardAtchmnflDao.delete(boardAtchmnflDto);
  }

  @Override
  public void deleteAll(Long boardSeq) throws ApplicationException {
    BoardAtchmnflDto boardAtchmnflDto = new BoardAtchmnflDto() {{
      setBoardSeq(boardSeq);
    }};
    boardAtchmnflDao.delete(boardAtchmnflDto);
  }
}
