package com.globaldenso.dicas.business.service.impl;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dicas.business.dao.BoardAtchmnflDao;
import com.globaldenso.dicas.business.dao.BoardDao;
import com.globaldenso.dicas.business.domain.BoardDomain;
import com.globaldenso.dicas.business.dto.BoardAtchmnflDto;
import com.globaldenso.dicas.business.dto.BoardDto;
import com.globaldenso.dicas.business.service.AtchmnflService;
import com.globaldenso.dicas.business.service.BoardAtchmnflService;
import com.globaldenso.dicas.business.service.BoardService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.BoardSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import com.globaldenso.dicas.constant.DicasConstant.ParamAttribute;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

    @Autowired
    private BoardDao boardDao;

    @Autowired
    private AtchmnflService atchmnflService;

    @Autowired
    private BoardAtchmnflService boardAtchmnflService;

    public BoardServiceImpl() {
        //no process
    }

    public void setBoardDao(BoardDao boardDao) {this.boardDao = boardDao;}

    @Override
    public BoardDto searchByKey(BoardDto boardDto) throws ApplicationException {
        return boardDao.searchByKey(boardDto);
    }

    @Override
    public Page<BoardDto> searchByCondition(BoardSearchForm criteria, Pageable pageable) throws ApplicationException {
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if(pageable != null)
            totalCount = boardDao.searchCount(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();

        // List<BoardDto> boardDtos = boardDao.searchByCondition(searchMap);

        List<BoardDto> boardDtos = boardDao.searchByConditionNotice(searchMap);
        List<BoardDto> boardDtos2 = boardDao.searchByCondition(searchMap);
        boardDtos.addAll(boardDtos2);

        if(totalCount == 0) totalCount = boardDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(boardDtos, pageable, totalCount);
    }

    @Override
    public Page<BoardDto> searchByCondition2(BoardSearchForm criteria, Pageable pageable) throws ApplicationException {
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;
        if(pageable != null)
            totalCount = boardDao.searchCount(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();
        List<BoardDto> boardDtos = boardDao.searchByConditionNotice(searchMap);
        List<BoardDto> boardDtos2 = boardDao.searchByCondition(searchMap);
        boardDtos.addAll(boardDtos2);

        if(totalCount == 0) totalCount = boardDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(boardDtos, pageable, totalCount);
    }

    @Override
    public Page<BoardDto> searchByConditionMobile(BoardSearchForm criteria, Pageable pageable) throws ApplicationException {
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put(DicasConstant.ParamAttribute.CRITERIA, criteria);
        searchMap.put(DicasConstant.ParamAttribute.PAGEABLE, pageable);

        long start = System.currentTimeMillis();

        int totalCount = 0;

        if(pageable != null)
            totalCount = boardDao.searchCountMobile(searchMap);

        long end = System.currentTimeMillis();
        start = System.currentTimeMillis();
        List<BoardDto> boardMobileDtos = boardDao.searchByConditionMobile(searchMap);

        if(totalCount == 0) totalCount = boardMobileDtos.size();

        end = System.currentTimeMillis();

        return new PageImpl<>(boardMobileDtos, pageable, totalCount);
    }

    @Override
    public List<BoardDto> searchByMain(String type, String sdYn) throws ApplicationException {
        List<BoardDto> boardList = new ArrayList<>();
        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("type", type);
        searchMap.put("sdYn", sdYn);
        if (type == "POPUP_NOTICE"){
            boardList = boardDao.searchMainList(searchMap);
        }else{
            boardList = boardDao.searchMainList2(searchMap);
        }

        return boardList;
    }

    @Override
    public void create(BoardDto boardDto) throws ApplicationException {

        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        boardDto.setRgstrId(Long.parseLong(loginVO.getUniqId()));
        boardDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

        boardDto.setUserId(loginVO.getUsername());
        boardDto.setName(loginVO.getFulnm());

        boardDao.create(boardDto);

        if (!EgovStringUtil.isEmpty(boardDto.getFiles()))
            transactBoardAtchmnfl(boardDto);
    }

    @Override
    public void update(BoardDto boardDto) throws ApplicationException {

        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
        boardDto.setUpdtrId(Long.parseLong(loginVO.getUniqId()));

        boardDto.setUserId(loginVO.getUsername());
        boardDto.setName(loginVO.getFulnm());

        boardDto.setUpdtDt(null);
        boardDto.setModDate(null);
        boardDto.setModTime(null);

        boardDao.update(boardDto);

        if ("N".equals(boardDto.getDelYn())) {
            if (!EgovStringUtil.isEmpty(boardDto.getFiles()))
                transactBoardAtchmnfl(boardDto);
        } else {
            List<BoardAtchmnflDto> items = boardAtchmnflService.searchByCondition(boardDto.getSeq());
            for (BoardAtchmnflDto item : items) {
              atchmnflService.delete(item.getAtchmnflId());
            }
        }
    }

    @Override
    public void delete(BoardDto boardDto) throws ApplicationException {

        BoardDto oldBoardDto = searchByKey(boardDto);
        oldBoardDto.setDelYn("Y");

        update(oldBoardDto);
    }

    private void transactBoardAtchmnfl(BoardDto boardDto) throws ApplicationException {

        BoardAtchmnflDto searchDto = new BoardAtchmnflDto() {{
            setBoardSeq(boardDto.getSeq());
        }};

        List<String> files = Arrays.asList(boardDto.getFiles().split(","));
        for(String str: files) {
            searchDto.setAtchmnflId(Long.parseLong(str));
            if (boardAtchmnflService.searchCountByKey(searchDto) == 0) {
                boardAtchmnflService.create(searchDto);
            }
        }
    }

    @Override
    public void upCount(BoardDto boardDto) throws ApplicationException {
        boardDao.upCount(boardDto);
    }
}