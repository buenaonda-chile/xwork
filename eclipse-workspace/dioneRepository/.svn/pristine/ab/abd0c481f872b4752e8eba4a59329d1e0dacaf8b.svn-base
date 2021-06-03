package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.BoardAtchmnflDto;
import com.globaldenso.dicas.business.dto.BoardDto;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.service.BoardAtchmnflService;
import com.globaldenso.dicas.business.service.BoardService;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.BoardForm;
import com.globaldenso.dicas.presentation.form.BoardSearchForm;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import com.globaldenso.dicas.util.DicasFileMngUtil;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.string.EgovStringUtil;

import java.net.URLEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardAtchmnflService boardAtchmnflService;

    @Autowired
    private CodeService codeService;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public BoardController() {
        // no process
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{type}/init")
    @ViewId("WCB0001")
    public ModelAndView init(@PathVariable("type") String type,
        HttpServletRequest request, HttpServletResponse response) throws Exception {

        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        BoardSearchForm criteria = new BoardSearchForm();

        if (!EgovStringUtil.isEmpty(type)) {
            criteria.setBoardType("POPUP_" + type.toUpperCase());
            criteria.setDelYn("N");
            if(!EgovStringUtil.isNull(loginVO.getOfficeNm())){
                criteria.setIsSd(true);
            }
        }

        Page<BoardDto> boardItems = boardService.searchByCondition(criteria, null);

        ModelAndView mv = new ModelAndView("jsonView");
        mv.setViewName(".tiles.page.comm.WCB0001");

        Map<String, Object> retMap = new HashMap<>();
        // mv.setViewName(".tiles.page.comm.WCB0001");

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", 1);
        pageMap.put("totalCount", boardItems.getTotalElements());

        retMap.put("contents", boardItems.getContent());
        retMap.put("pagination", pageMap);

        mv.addObject("result", true);
        mv.addObject("data", retMap);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{type}/search")
    public ModelAndView search(@PathVariable("type") String type,
            BoardSearchForm criteria, Pageable pageable) throws Exception {

        LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

        if (!EgovStringUtil.isEmpty(type)) {
            criteria.setBoardType("POPUP_" + type.toUpperCase());
            criteria.setDelYn("N");

            if(!EgovStringUtil.isNull(loginVO.getOfficeNm())){
                criteria.setIsSd(true);
            }
        }

        Page<BoardDto> boardItems = boardService.searchByCondition(criteria,pageable);
        ModelAndView mv = new ModelAndView("jsonView");

        Map<String, Object> retMap = new HashMap<>();
        // mv.setViewName(".tiles.page.comm.WCB0001");

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", pageable.getPageNumber());
        pageMap.put("totalCount", boardItems.getTotalElements());

        retMap.put("contents", boardItems.getContent());
        retMap.put("pagination", pageMap);

        mv.addObject("result", true);
        mv.addObject("data", retMap);

        return mv;
    }


    @RequestMapping(method = RequestMethod.GET, value = {"/{type}/form", "/{type}/form/{boardSeq}"})
    @ViewId("WCB0002")
    public ModelAndView form(@PathVariable("type") String type,
        @PathVariable("boardSeq") Optional<String> boardSeq, HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        BoardSearchForm searchForm = new BoardSearchForm();
        if (!EgovStringUtil.isEmpty(type)) {
            searchForm.setBoardType("POPUP_" + type.toUpperCase());
        }

        String pageTitle = EgovStringUtil.null2string(request.getParameter("pageTitle"),"");

        if (boardSeq.isPresent()) {
            pageTitle += " 수정";
        } else {
            pageTitle += " 등록";
        }

        CodeSearchForm searchForm1 = new CodeSearchForm();

        searchForm1.setGrpCds(Arrays.asList(new String[] {
                DicasConstant.CodeGroupAttribute.CATEGORY
        }));
        searchForm1.setUseYn("Y");
        List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
        List<CodeDto> categoryList = codeList1
                .stream()
                .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.CATEGORY))
                .collect(Collectors.toList());

        ModelAndView mv = new ModelAndView();

        mv.setViewName(".tiles.page.comm.WCB0002");
        mv.addObject("_editor_", "tui.editor");
        mv.addObject("pageTitle", pageTitle);
        mv.addObject("type", type);
        mv.addObject("categoryItems", categoryList);


        if (boardSeq.isPresent()) {
            BoardDto searchBoardDto = new BoardDto();
            searchBoardDto.setSeq(Long.parseLong(boardSeq.get()));
            searchBoardDto.setBoardType(searchForm.getBoardType());

            BoardDto boardDto = boardService.searchByKey(searchBoardDto);
            if (!EgovStringUtil.isEmpty(boardDto.getContent())) {
                boardDto.setContent(
                    boardDto.getContent()
                        .replaceAll("(\r\n|\n)", "\\\\r\\\\n")
                        .replaceAll("(\")","\\\\\"")

                );
            }

            List<BoardAtchmnflDto> fileItems
                = boardAtchmnflService.searchByCondition(boardDto.getSeq());

            mv.addObject("boardSeq", boardDto.getBoardSeq());
            mv.addObject("boardForm", boardDto);
            mv.addObject("fileItems", fileItems);
        } else {
            mv.addObject("boardSeq", null);
            mv.addObject("boardForm", searchForm);
        }

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{type}/view/{boardSeq}")
    @ViewId("WCB0003")
    public ModelAndView view(@PathVariable("type") String type,
        @PathVariable("boardSeq") String boardSeq, HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        String pageTitle = EgovStringUtil.null2string(request.getParameter("pageTitle"),"");

        BoardDto searchBoardDto = new BoardDto();
        searchBoardDto.setSeq(Long.parseLong(boardSeq));

        BoardDto boardDto = boardService.searchByKey(searchBoardDto);
        if (!EgovStringUtil.isEmpty(boardDto.getContent())) {
            boardDto.setContent(
                boardDto.getContent()
                    .replaceAll("(\r\n|\n)", "\\\\r\\\\n")
                    .replaceAll("(\")","\\\\\"")

            );
        }

        List<BoardAtchmnflDto> fileItems
            = boardAtchmnflService.searchByCondition(boardDto.getSeq());

        boardService.upCount(searchBoardDto);

        ModelAndView mv = new ModelAndView();

        mv.setViewName(".tiles.page.comm.WCB0003");
        mv.addObject("_editor_", "tui.viewer");
        mv.addObject("pageTitle", pageTitle);
        mv.addObject("type", type);
        mv.addObject("boardSeq", boardSeq);
        mv.addObject("boardForm", boardDto);
        mv.addObject("fileItems", fileItems);

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{type}/create")
    public ModelAndView create(@RequestBody BoardForm boardForm) throws Exception {

        ModelAndView mv = new ModelAndView("jsonView");

        boardService.create(boardForm);
        mv.addObject("data", boardForm);

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{type}/update/{boardSeq}")
    public ModelAndView update(@PathVariable("boardSeq") String boardSeq,
        @RequestBody BoardForm boardForm) throws Exception {

        ModelAndView mv = new ModelAndView("jsonView");

        boardService.update(boardForm);
        mv.addObject("data", boardForm);

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{type}/delete/{boardSeq}")
    public ModelAndView delete(@PathVariable("boardSeq") String boardSeq,
        @RequestBody BoardForm boardForm) throws Exception {

        ModelAndView mv = new ModelAndView("jsonView");

        boardService.delete(boardForm);
        mv.addObject("data", boardForm);

        return mv;

    }
}
