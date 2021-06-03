package com.globaldenso.dicas.presentation.controller;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.dto.GroupDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.GroupService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.GroupForm;
import com.globaldenso.dicas.presentation.form.GroupSearchForm;
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

//@TODO: 마감관련 처리 모듈 작성 예정

@Controller
@RequestMapping(value = "/group")
public class GroupController {

  private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

  @Autowired
  private GroupService groupService;

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public GroupController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCM0005")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

	CodeSearchForm searchForm1 = new CodeSearchForm();
	searchForm1.setGrpCds(Arrays.asList(new String[] {
		    DicasConstant.CodeGroupAttribute.USE_YN,
            DicasConstant.CodeGroupAttribute.GROUP_ID,
            DicasConstant.CodeGroupAttribute.PART_DIV,
    }));
    searchForm1.setUseYn("Y");
    List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
	List<CodeDto> useYnList = codeList1
		.stream()
		.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN)).collect(Collectors.toList());

    List<CodeDto> groupIdList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.GROUP_ID)).collect(Collectors.toList());

    List<CodeDto> partDivList = codeList1
            .stream()
            .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.PART_DIV)).collect(Collectors.toList());


    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.page.cmmn.WCM0005");

	mv.addObject("useYnItems", useYnList);
    mv.addObject("groupIdItems", groupIdList);
    mv.addObject("partDivItems", partDivList);

    return mv;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public ModelAndView search(GroupSearchForm criteria, Pageable pageable) throws Exception {

    List<GroupDto> groupItems = groupService.searchByCondition(criteria);

    ModelAndView mv = new ModelAndView("jsonView");
    mv.addObject("data", groupItems);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/create")
  public ModelAndView create(@RequestBody GroupForm groupForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    groupService.create(groupForm);
    mv.addObject("data", groupForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/update")
  public ModelAndView update(@RequestBody GroupForm groupForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");

    groupService.update(groupForm);
    mv.addObject("data", groupForm);

    return mv;
  }

  @RequestMapping(method = RequestMethod.POST, value="/delete")
  public ModelAndView delete(@RequestBody GroupForm groupForm) throws Exception {

    ModelAndView mv = new ModelAndView("jsonView");
    groupService.delete(groupForm);

    return mv;
  }
}
