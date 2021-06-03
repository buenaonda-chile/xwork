package com.globaldenso.dicas.presentation.controller.popup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.VehicleViewDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.VehicleViewService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.VehicleViewForm;
import com.globaldenso.dicas.presentation.form.VehicleViewSearchForm;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("popup.vehicleViewController")
@RequestMapping(value = "/popup/vehicleView")
public class VehicleViewPopupController {

  private static final Logger LOGGER = LoggerFactory.getLogger(VehicleViewPopupController.class);

  @Autowired
  private VehicleViewService vehicleviewService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public VehicleViewPopupController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCMP0005")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    CodeSearchForm searchForm = new CodeSearchForm();
    searchForm.setGrpCds(Arrays.asList(new String[]{
            DicasConstant.CodeGroupAttribute.USE_YN,
            DicasConstant.CodeGroupAttribute.MAKER,
            DicasConstant.CodeGroupAttribute.EXHAUS_REG,
            DicasConstant.CodeGroupAttribute.ENGINE_TYPE,
            DicasConstant.CodeGroupAttribute.MODEL
    }));
    List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);

    List<CodeDto> useYnList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN))
            .collect(Collectors.toList());

    ObjectMapper mapper = new ObjectMapper();
    String jsonUseYnItems = "";
    try {
      jsonUseYnItems = mapper.writeValueAsString(useYnList);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    List<CodeDto> makerList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MAKER))
            .collect(Collectors.toList());

    mapper = new ObjectMapper();
    String jsonMakerItems = "";
    try {
      jsonMakerItems = mapper.writeValueAsString(makerList);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    List<CodeDto> exhausRegList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.EXHAUS_REG))
            .collect(Collectors.toList());

    mapper = new ObjectMapper();
    String jsonExhausRegItems = "";
    try {
      jsonExhausRegItems = mapper.writeValueAsString(exhausRegList);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    List<CodeDto> engineTypeList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.ENGINE_TYPE))
            .collect(Collectors.toList());

    mapper = new ObjectMapper();
    String jsonEngineTypeItems = "";
    try {
      jsonEngineTypeItems = mapper.writeValueAsString(engineTypeList);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    List<CodeDto> modelList = codeList
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MODEL))
            .collect(Collectors.toList());

    mapper = new ObjectMapper();
    String jsonModelItems = "";
    try {
      jsonModelItems = mapper.writeValueAsString(modelList);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.popup.cmmn.WCMP0005");
    mv.addObject("useYnItems", jsonUseYnItems);
    mv.addObject("makerItems", jsonMakerItems);
    mv.addObject("exhausRegItems", jsonExhausRegItems);
    mv.addObject("engineTypeItems", jsonEngineTypeItems);
    mv.addObject("modelItems", jsonModelItems);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(VehicleViewSearchForm criteria, Pageable pageable) throws Exception {

    Page<VehicleViewDto> vehicleviewItems = vehicleviewService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", vehicleviewItems.getTotalElements());

    retMap.put("contents", vehicleviewItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

}
