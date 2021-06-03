package com.globaldenso.dicas.presentation.controller.mobile;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.BoardAtchmnflDto;
import com.globaldenso.dicas.business.dto.BoardDto;
import com.globaldenso.dicas.business.service.BoardAtchmnflService;
import com.globaldenso.dicas.business.service.BoardService;
import com.globaldenso.dicas.presentation.form.BoardSearchForm;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mobile.BoardController")
@RequestMapping(value = "/mobile/board")
public class BoardController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private BoardService boardService;

  @Autowired
  private BoardAtchmnflService boardAtchmnflService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public BoardController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{boardType}/init")
  @ViewId("WCB0001")
  public ModelAndView init(@PathVariable("boardType") String boardType,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.mobile.comm.WCB0001");
    mv.addObject("boardType", boardType);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "{boardType}/search")
  public ModelAndView search(@PathVariable("boardType") String boardType,
                                BoardSearchForm criteria, Pageable pageable) throws Exception {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

    if (!EgovStringUtil.isEmpty(boardType)) {
      criteria.setBoardType("POPUP_" + boardType.toUpperCase());
      criteria.setDelYn("N");

      if(!EgovStringUtil.isNull(loginVO.getOfficeNm())){
        criteria.setIsSd(true);
      }
    }

    Page<BoardDto> boardItems = boardService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", boardItems.getTotalElements());

    retMap.put("contents", boardItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

//    mv.addObject("total", boardItems.getTotalElements());
//    mv.addObject("data", boardItems.getContent());
//    mv.addObject("records", boardItems.getTotalElements());

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "{boardType}/search2")
  public ModelAndView search2(@PathVariable("boardType") String boardType,
                             BoardSearchForm criteria, Pageable pageable) throws Exception {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();

    if (!EgovStringUtil.isEmpty(boardType)) {
      criteria.setBoardType("POPUP_" + boardType.toUpperCase());
      criteria.setDelYn("N");

      if(!EgovStringUtil.isNull(loginVO.getOfficeNm())){
        criteria.setIsSd(true);
      }
    }

    Page<BoardDto> boardItems = boardService.searchByConditionMobile(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", boardItems.getTotalElements());

    retMap.put("contents", boardItems.getContent());
    retMap.put("pagination", pageMap);

    int totalCnt = Integer.parseInt(pageMap.get("totalCount").toString());
    int totalPage = totalCnt/pageable.getPageSize();
    if (totalPage % pageable.getPageSize() > 0) {
          totalPage++;
    }
    retMap.put("totalPageCnt", totalPage);
    mv.addObject("result", true);
    mv.addObject("data", retMap);
    mv.addObject("totalpagecnt", totalPage);
    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "{boardType}/view/{boardSeq}")
  @ViewId("WCB0002")
  public ModelAndView view(@PathVariable("boardType") String boardType,
      @PathVariable("boardSeq") String boardSeq, HttpServletRequest request,
      HttpServletResponse response) throws Exception {

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

    mv.setViewName(".tiles.mobile.comm.WCB0002");

    mv.addObject("_editor_", "tui.viewer");
    mv.addObject("boardType", boardType);
    mv.addObject("boardSeq", boardSeq);
    mv.addObject("boardForm", boardDto);
    mv.addObject("fileItems", fileItems);

    return mv;
  }
}
