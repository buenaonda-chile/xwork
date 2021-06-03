package com.globaldenso.dicas.presentation.controller.popup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.constant.DicasConstant.CodeGroupAttribute;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("popup.codeController")
@RequestMapping(value="/popup/code")
public class CodePopupController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CodePopupController.class);

  @Autowired
  private CodeService codeService;

  /**
   * [EN] Default constructor.<br>
   * [JP] デフォルトコンストラクタ。<br>
   */
  public CodePopupController() {
    // no process
  }

  @RequestMapping(method = RequestMethod.GET, value = "/init")
  @ViewId("WCMP001")
  public ModelAndView init(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    CodeSearchForm searchForm = new CodeSearchForm();
    searchForm.setGrpCds(Arrays.asList(new String[]{
        CodeGroupAttribute.USE_YN
    }));
    List<CodeDto> codeList = codeService.searchCodeByCondition(searchForm);

    List<CodeDto> useYnList = codeList
        .stream()
        .filter(item -> item.getGrpCd().equals(CodeGroupAttribute.USE_YN))
        .collect(Collectors.toList());

    ObjectMapper mapper = new ObjectMapper();
    String jsonUseYnItems = "";
    try {
      jsonUseYnItems = mapper.writeValueAsString(useYnList);
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    ModelAndView mv = new ModelAndView();
    mv.setViewName(".tiles.popup.cmmn.WCMP001");
    mv.addObject("useYnItems", jsonUseYnItems);

    return mv;
  }
}
