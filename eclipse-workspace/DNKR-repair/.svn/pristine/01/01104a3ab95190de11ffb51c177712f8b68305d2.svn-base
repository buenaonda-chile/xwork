package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.QualityProblemDto;
import com.globaldenso.dicas.business.dto.TotalAlnalysisDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.QualityProblemService;
import com.globaldenso.dicas.business.service.TotalAlnalysisService;
import com.globaldenso.dicas.presentation.form.QualityProblemSearchForm;
import com.globaldenso.dicas.presentation.form.TotalAlnalysisSearchForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/totalAlnalysis")
public class TotalAlnalysisController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TotalAlnalysisController.class);

  @Autowired
  private TotalAlnalysisService totalalnAlysisService;

  @Autowired
  private CodeService codeService;

  @Autowired
  private QualityProblemService qualityProblemService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TotalAlnalysisController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WWA0002")
  public ModelAndView init(HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
    //품질문제명
    Page<QualityProblemDto> qualityProblemNm = qualityProblemService.searchByCondition(new QualityProblemSearchForm(), null);

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.list.WWA0002");

    mv.addObject("qualityProblemNmItems", qualityProblemNm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(TotalAlnalysisSearchForm criteria, Pageable pageable) throws Exception {

    Page<TotalAlnalysisDto> totalalnalysisItems = totalalnAlysisService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", totalalnalysisItems.getTotalElements());

    retMap.put("contents", totalalnalysisItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  /* 종합분석 차트 데이터 처리 */
  @RequestMapping(method = RequestMethod.GET, value = "/search6")
  public ModelAndView search6(TotalAlnalysisSearchForm criteria, Pageable pageable) throws Exception {

      Page<TotalAlnalysisDto> totalalnalysisItems = totalalnAlysisService.searchChartData(criteria, null);

      ModelAndView mv = new ModelAndView("jsonView");
      mv.addObject("data", totalalnalysisItems.getContent());

      return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search2")
  public ModelAndView search2(TotalAlnalysisSearchForm criteria, Pageable pageable) throws Exception {

    List<TotalAlnalysisDto>  totalalnalysisItems = totalalnAlysisService.searchByCondition2(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("contents", totalalnalysisItems);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search3")
  public ModelAndView search3(TotalAlnalysisSearchForm criteria, Pageable pageable) throws Exception {

    List<TotalAlnalysisDto>  totalalnalysisItems = totalalnAlysisService.searchByCondition3(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("contents", totalalnalysisItems);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search4")
  public ModelAndView search4(TotalAlnalysisSearchForm criteria, Pageable pageable) throws Exception {

    List<TotalAlnalysisDto>  totalalnalysisItems = totalalnAlysisService.searchByCondition4(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("contents", totalalnalysisItems);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search5")
  public ModelAndView search5(TotalAlnalysisSearchForm criteria, Pageable pageable) throws Exception {

    List<TotalAlnalysisDto>  totalalnalysisItems = totalalnAlysisService.searchByCondition5(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("contents", totalalnalysisItems);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

}
