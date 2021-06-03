package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.VehicleDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.VehicleService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.VehicleForm;
import com.globaldenso.dicas.presentation.form.VehicleSearchForm;
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
@RequestMapping(value = "/vehicle")
public class VehicleController {

  private static final Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

  @Autowired
  private VehicleService vehicleService;

  @Autowired
  private CodeService codeService;


  /**
   * [EN] Default constructor.<br>
   * [JP] ?????????????<br>
   */
  public VehicleController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("TEMP0004")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

	CodeSearchForm searchForm1 = new CodeSearchForm();
	searchForm1.setGrpCds(Arrays.asList(new String[] {
		DicasConstant.CodeGroupAttribute.USE_YN
	}));
    searchForm1.setUseYn("Y");
	List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
	List<CodeDto> useYnList = codeList1
		.stream()
		.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN))		.collect(Collectors.toList());

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.TEMP0004");

	mv.addObject("useYnItems", useYnList);


	return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(VehicleSearchForm criteria, Pageable pageable) throws Exception {

    Page<VehicleDto> vehicleItems = vehicleService.searchByCondition(criteria, pageable);

    ModelAndView mv = new ModelAndView("jsonView");

    Map<String, Object> retMap = new HashMap<>();

    Map<String, Object> pageMap = new HashMap<>();
    pageMap.put("page", pageable.getPageNumber());
    pageMap.put("totalCount", vehicleItems.getTotalElements());

    retMap.put("contents", vehicleItems.getContent());
    retMap.put("pagination", pageMap);

    mv.addObject("result", true);
    mv.addObject("data", retMap);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody VehicleForm vehicleForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    VehicleSearchForm criteria = new VehicleSearchForm();
    criteria.setChkVinno(vehicleForm.getVinno());
    Page<VehicleDto> vehicleItems = vehicleService.searchByCondition(criteria, null);
    if (vehicleItems.getTotalElements() > 0) {

      Map map = new HashMap();
      map.put("errCd", "E001");
      map.put("msg", "중복된 VIN NO 입니다. 조회하시겠습니까?");

      mv.addObject("data", map);
      return mv;
    }

    vehicleService.create(vehicleForm);

    criteria = new VehicleSearchForm();
    // criteria.setVinno(vehicleForm.getVinno());
    criteria.setChkVinno(vehicleForm.getVinno());
    vehicleItems = vehicleService.searchByCondition(criteria, null);
    mv.addObject("data", vehicleItems.getContent().get(0));

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody VehicleForm vehicleForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    VehicleSearchForm criteria = new VehicleSearchForm();
    /*
    criteria.setVinno(vehicleForm.getVinno());
    criteria.setMasterId(vehicleForm.getMasterId());
    Page<VehicleDto> vehicleItems = vehicleService.searchByCondition(criteria, null);

    if (vehicleItems.getTotalElements() > 0) {

      Map map = new HashMap();
      map.put("errCd", "E001");
      map.put("msg", "중복된 VIN NO 입니다.");

      mv.addObject("data", map);
      return mv;
    }
    */
    vehicleService.update(vehicleForm);
    mv.addObject("data", vehicleForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody VehicleForm vehicleForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    vehicleService.delete(vehicleForm);

    return mv;
  }
}
