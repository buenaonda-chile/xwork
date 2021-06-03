package com.globaldenso.dicas.presentation.controller.popup;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.DtcDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.DtcService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.DtcForm;
import com.globaldenso.dicas.presentation.form.DtcSearchForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller("popup.dtcController")
@RequestMapping(value = "/popup/dtc")
public class DtcPopupController {

  private static final Logger LOGGER = LoggerFactory.getLogger(DtcPopupController.class);

  @Autowired
  private DtcService dtcService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public DtcPopupController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCMP012")
  public ModelAndView init(DtcSearchForm criteria, HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    CodeSearchForm searchForm1 = new CodeSearchForm();
    // 배기규제 코드값
    searchForm1.setGrpCds(Arrays.asList(new String[] {
            DicasConstant.CodeGroupAttribute.EXHAUS_REG,
            DicasConstant.CodeGroupAttribute.ENGINE_TYPE
    }));
    searchForm1.setUseYn("Y");
    List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
    List<CodeDto> exhausList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EXHAUS_REG)).collect(Collectors.toList());

    // 엔진형식 코드값
    List<CodeDto> engineList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.ENGINE_TYPE)).collect(Collectors.toList());

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.popup.cmmn.WCMP012");

    mv.addObject("exhausRegItems", exhausList);
    mv.addObject("engineTypeItems", engineList);

    mv.addObject("dtcForm", criteria);
    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(DtcSearchForm criteria, Pageable pageable) throws Exception {

    Page<DtcDto> modelsItems = dtcService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", modelsItems.getTotalElements());

    retMap.put("contents", modelsItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

}
