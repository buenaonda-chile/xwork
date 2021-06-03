package com.globaldenso.dicas.presentation.controller.popup;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.OfficeService;
import com.globaldenso.dicas.constant.DicasConstant;
import com.globaldenso.dicas.presentation.form.CodeSearchForm;
import com.globaldenso.dicas.presentation.form.OfficeSearchForm;
import com.globaldenso.dicas.presentation.form.PartNumberSearchForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller("popup.officeController2")
@RequestMapping(value = "/popup/office2")
public class OfficePopupController2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfficePopupController.class);

    @Autowired
    private OfficeService officeService;

    @Autowired
    private CodeService codeService;

    /**
     * [EN] Default constructor.<br>
     * [JP] ?????????????<br>
     */
    public OfficePopupController2() {
        // no process
    }

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    @ViewId("WCMP007")
    public ModelAndView init(OfficeSearchForm criteria,
            HttpServletRequest request,
             HttpServletResponse response) throws Exception {

        CodeSearchForm searchForm1 = new CodeSearchForm();
        searchForm1.setGrpCds(Arrays.asList(new String[]{
                DicasConstant.CodeGroupAttribute.USE_YN,
                DicasConstant.CodeGroupAttribute.MAKER,
                DicasConstant.CodeGroupAttribute.OFFICE_DIV,
                DicasConstant.CodeGroupAttribute.OFFICE_CITY,
                DicasConstant.CodeGroupAttribute.MATERIAL_DIV,
        }));
        List<CodeDto> codeList1 = codeService.searchCodeByCondition(searchForm1);
        List<CodeDto> useYnList = codeList1
                .stream()
                .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN)).collect(Collectors.toList());

        List<CodeDto> makerList = codeList1
                .stream()
                .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MAKER)).collect(Collectors.toList());

        List<CodeDto> officeDivList = codeList1
                .stream()
                .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.OFFICE_DIV)).collect(Collectors.toList());

        List<CodeDto> officeCityList = codeList1
                .stream()
                .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.OFFICE_CITY)).collect(Collectors.toList());

        List<CodeDto> materialDivList = codeList1
                .stream()
                .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.MATERIAL_DIV)).collect(Collectors.toList());

        List<CodeDto> reprYnList = codeList1
                .stream()
                .filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute.USE_YN)).collect(Collectors.toList());

        ModelAndView mv = new ModelAndView();
        mv.setViewName(".tiles.popup.cmmn.WCMP007");

        mv.addObject("useYnItems", useYnList);
        mv.addObject("makerItems", makerList);
        mv.addObject("officeDivItems", officeDivList);
        mv.addObject("officeCityItems", officeCityList);
        mv.addObject("materialDivItems", materialDivList);
        mv.addObject("reprYnItems", reprYnList);

        mv.addObject("officeForm", criteria);

        return mv;
    }
}


