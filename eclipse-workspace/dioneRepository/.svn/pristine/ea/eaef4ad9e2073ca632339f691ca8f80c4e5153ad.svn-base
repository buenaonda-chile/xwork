package com.globaldenso.dicas.business.service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dto.BoardDto;
import com.globaldenso.dicas.presentation.form.BoardSearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    BoardDto searchByKey(BoardDto boardDto) throws ApplicationException;
    Page<BoardDto> searchByCondition(BoardSearchForm criteria, Pageable pageable) throws ApplicationException;
    Page<BoardDto> searchByCondition2(BoardSearchForm criteria, Pageable pageable) throws ApplicationException;
    Page<BoardDto> searchByConditionMobile(BoardSearchForm criteria, Pageable pageable) throws ApplicationException;
    List<BoardDto> searchByMain(String type, String sdYn) throws ApplicationException;

    void upCount(BoardDto boardDto) throws ApplicationException;
    void create(BoardDto boardDto) throws ApplicationException;
    void update(BoardDto boardDto) throws ApplicationException;
    void delete(BoardDto boardDto) throws ApplicationException;
}