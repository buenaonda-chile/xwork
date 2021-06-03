package com.globaldenso.dicas.business.dao;

import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.dicas.business.domain.BoardDomain;
import com.globaldenso.dicas.business.dto.BoardDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * [EN] BoardDao class of Menu information.<br>
 * [JP] BoardDao class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Repository("boardDao")
public interface BoardDao {

    BoardDto searchByKey(BoardDomain boardDomain) throws SystemException;
    List<BoardDto> searchByCondition(Map<String, Object> params) throws SystemException;
    List<BoardDto> searchByConditionNotice(Map<String, Object> params) throws SystemException;
    List<BoardDto> searchByConditionMobile(Map<String, Object> params) throws SystemException;
    List<BoardDto> searchMainList(Map<String, Object> params) throws SystemException;
    List<BoardDto> searchMainList2(Map<String, Object> params) throws SystemException;
    int searchCount(Map<String, Object> params) throws SystemException;
    int searchCountMobile(Map<String, Object> params) throws SystemException;

    void upCount(BoardDomain boardDomain) throws SystemException;
    void create(BoardDomain boardDomain) throws SystemException;
    void update(BoardDomain boardDomain) throws SystemException;
    void delete(BoardDomain boardDomain) throws SystemException;
}
