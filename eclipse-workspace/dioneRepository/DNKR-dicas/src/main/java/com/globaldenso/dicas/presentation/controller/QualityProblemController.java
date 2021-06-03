package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.QualityProblemDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.QualityProblemService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.QualityProblemForm;
import com.globaldenso.dicas.presentation.form.QualityProblemSearchForm;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/qualityProblem")
public class QualityProblemController {

  private static final Logger LOGGER = LoggerFactory.getLogger(QualityProblemController.class);

  @Autowired
  private QualityProblemService qualityproblemService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public QualityProblemController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0013")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

	CodeSearchForm searchForm1 = new CodeSearchForm();
	searchForm1.setGrpCds(Arrays.asList(new String[] {
		    DicasConstant.CodeGroupAttribute.USE_YN,
            DicasConstant.CodeGroupAttribute.PART_DIV
	}));
    searchForm1.setUseYn("Y");
	List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
	List<CodeDto> useYnList = codeList1
		.stream()
		.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN)).collect(Collectors.toList());

    List<CodeDto> partDivList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.PART_DIV)).collect(Collectors.toList());

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0013");

	mv.addObject("useYnItems", useYnList);
    mv.addObject("partDivItems", partDivList);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(QualityProblemSearchForm criteria, Pageable pageable) throws Exception {

    Page<QualityProblemDto> qualityproblemItems = qualityproblemService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", qualityproblemItems.getTotalElements());

    retMap.put("contents", qualityproblemItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody QualityProblemForm qualityproblemForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    qualityproblemService.create(qualityproblemForm);
    mv.addObject("data", qualityproblemForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody QualityProblemForm qualityproblemForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    qualityproblemService.update(qualityproblemForm);
    mv.addObject("data", qualityproblemForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody QualityProblemForm qualityproblemForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    qualityproblemService.delete(qualityproblemForm);

    return mv;
  }

  @RequestMapping(value="/group/list.json")
  public ModelAndView getGroupQualityProblemList() throws Exception {

    QualityProblemSearchForm criteria = new QualityProblemSearchForm();
    List<QualityProblemDto> qualityproblemItems = qualityproblemService.searchGrpCdByCondition(criteria);

    ModelAndView mv = new ModelAndView("jsonView");
    mv.addObject("data", qualityproblemItems);
    mv.addObject("total", qualityproblemItems.size());

    return mv;
  }

  @RequestMapping(value = "/list.json")
  @ResponseBody
  public Map<String, Object> getQualityProblemList(@RequestBody QualityProblemSearchForm criteria) throws Exception {

    List<QualityProblemDto> qualityproblemItems = qualityproblemService.searchQualityProblemByCondition(criteria);

    Map<String, Object> retMap = new HashMap<>();
    retMap.put("data", qualityproblemItems);
    retMap.put("total", qualityproblemItems.size());

    return retMap;
  }
}
