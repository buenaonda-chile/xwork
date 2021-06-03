/*
 * Project : dicas
 *
 * $Id$
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.*;
import com.globaldenso.dicas.business.service.*;
import com.globaldenso.dicas.security.common.LoginVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import egovframework.rte.fdl.string.EgovStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * [EN] The class defines the controls of main (WCM0002).<br>
 * [JP] WCM0002 基本機能メニュー画面の制御を定義するクラス。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
public class MainController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

  @Autowired
  private MenuService menuService;

  @Autowired
  private MainRePartService partService;

  @Autowired
  private ClaimVehicleService claimVehicleService;

  @Autowired
  private ResultMasterService resultMasterService;

  @Autowired
  private BoardService boardService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public MainController() {
    // no process
  }

  /**
   * [EN] Display Dicas main page. <br>
   * [JP] Display Dicas main page. <br>
   *
   * @return ModelAndView
   * @throws Exception Exception
   */
  @RequestMapping(method = RequestMethod.GET, value = "/main")
  @ViewId(value = "WCM0002")
  public ModelAndView init(HttpServletRequest request) throws Exception {

    LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    List<MenuDto> menuDtos = menuService.searchByLoginUser(Long.parseLong(loginVO.getUniqId()));

    String sdYn = "";
    if(!EgovStringUtil.isNull(loginVO.getOfficeNm())){
      sdYn = "Y";
    }else{
      sdYn = "N";
    }
    MainRePartDto main01 = partService.searchByString("01"); // COMMOM RAIL
    MainRePartDto main02 = partService.searchByString("02"); // AC
    MainRePartDto main03 = partService.searchByString("03"); // SINGLE UNIT

    if (!loginVO.getUsername().equals("system")){
        main01 = partService.searchByString1(loginVO.getUsername()); // COMMOM RAIL
        main02 = partService.searchByString2(loginVO.getUsername()); // AC
        main03 = partService.searchByString3(loginVO.getUsername()); // SINGLE UNIT
    }

    List<ClaimVehicleDto> claimList = claimVehicleService.searchByMain();
    // List<ResultMasterDto> rsMstList = resultMasterService.searchMainListByCondition();
      List<ResultMasterDto> rsMstList = resultMasterService.searchMainListByUser();
    List<BoardDto> rsNoticeBoardList = boardService.searchByMain("POPUP_NOTICE", sdYn);
    List<BoardDto> rsFileBoardList = boardService.searchByMain("POPUP_FILE", sdYn);

    int callIng = 0;
    int callRecCnt = claimVehicleService.searchByMainClaimProcessCnt("01");
    int callConsltCnt = claimVehicleService.searchByMainClaimProcessCnt("02");
    int callSrchCnt = claimVehicleService.searchByMainClaimProcessCnt("03");
    int callRsCnt = claimVehicleService.searchByMainClaimProcessCnt("04");
    callIng = callConsltCnt + callSrchCnt ;

    int prcCnt = claimVehicleService.searchByMainClaimPerCnt();

    // 신규추가
    int cntIng = 0;
    int cntRs  = 0;
    int cntPer = 0;

    cntIng = claimVehicleService.searchByMainIngCnt();
    cntRs = claimVehicleService.searchByMaingRsCnt();
    cntPer = claimVehicleService.searchByMaingPerCnt();

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.main");
    mv.addObject("menuItems", menuDtos);
    mv.addObject("mainPart01", main01);
    mv.addObject("mainPart02", main02);
    mv.addObject("mainPart03", main03);
    mv.addObject("claimList", claimList);
    mv.addObject("rsMstList", rsMstList);
    mv.addObject("rsNoticeBoardList", rsNoticeBoardList);
    mv.addObject("rsFileBoardList", rsFileBoardList);
    mv.addObject("callRecCnt",callRecCnt);
    mv.addObject("callConsltCnt",callConsltCnt);
    mv.addObject("callSrchCnt",callSrchCnt);
    mv.addObject("callRsCnt",callRsCnt);
    mv.addObject("callIng",callIng);
    mv.addObject("prcCnt",prcCnt);
    mv.addObject("cntIng",cntIng);
    mv.addObject("cntRs",cntRs);
    mv.addObject("cntPer",cntPer);

    return mv;

  }
}

