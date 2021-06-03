package com.globaldenso.dicas.presentation.controller.popup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.TrainingAppViewDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.TrainingAppViewService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.TrainingAppViewForm;
import com.globaldenso.dicas.presentation.form.TrainingAppViewSearchForm;
import com.globaldenso.dicas.presentation.form.TrainingInfoBaseForm;

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

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller("popup.trainingAppViewController")
@RequestMapping(value = "/popup/trainingAppView")
public class TrainingAppViewPopupController {

  private static final Logger LOGGER = LoggerFactory.getLogger(TrainingAppViewPopupController.class);

  @Autowired
  private TrainingAppViewService trainingAppViewService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public TrainingAppViewPopupController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("EDUP001")
  public ModelAndView init(TrainingAppViewSearchForm criteria, HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    CodeSearchForm searchForm1 = new CodeSearchForm();

    searchForm1.setGrpCds(Arrays.asList(new String[] {
            DicasConstant.CodeGroupAttribute.RANCD
    }));
    
    searchForm1.setUseYn("Y");
    
    List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
    
    List<CodeDto> rnkCdList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.RANCD))
            .collect(Collectors.toList());

    ObjectMapper mapper = new ObjectMapper();
	  String jsonRnkCdItems = "";
	  try {
		  jsonRnkCdItems = mapper.writeValueAsString(rnkCdList);
	  } catch (IOException ex) {
	    ex.printStackTrace();
	  }

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.popup.edu.EDUP001");

    mv.addObject("rnkCdItems", rnkCdList);
    mv.addObject("rnkCdItems2", jsonRnkCdItems);

	mv.addObject("trainingAppViewForm", criteria);
    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(TrainingAppViewSearchForm criteria, Pageable pageable) throws Exception {

    Page<TrainingAppViewDto> modelsItems = trainingAppViewService.searchBySdCondition(criteria, pageable);

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
  
  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody TrainingAppViewForm trainingAppViewForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    trainingAppViewService.update(trainingAppViewForm);
    mv.addObject("data", trainingAppViewForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody TrainingAppViewForm trainingAppViewForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    trainingAppViewService.delete(trainingAppViewForm);

    return mv;
  }

}
