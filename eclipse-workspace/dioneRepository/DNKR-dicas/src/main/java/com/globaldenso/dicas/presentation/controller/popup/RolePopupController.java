package com.globaldenso.dicas.presentation.controller.popup;

import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.RoleDto;
import com.globaldenso.dicas.business.service.RoleService;
import com.globaldenso.dicas.presentation.form.RoleSearchForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.HashMap;
import java.util.Map;

@Controller("popup.roleController")
@RequestMapping(value = "/popup/role")
public class RolePopupController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RolePopupController.class);

    @Autowired
    private RoleService roleService;

    /**
     * [EN] Default constructor.<br>
     * [JP] ?????????????<br>
     */
    public RolePopupController() {
        // no process
    }

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    @ViewId("WCMP003")
    public ModelAndView init(HttpServletRequest request,
                HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.setViewName(".tiles.popup.cmmn.WCMP003");

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ModelAndView search(RoleSearchForm criteria, Pageable pageable) throws Exception {

        Page<RoleDto> roleItems = roleService.searchByCondition(criteria, pageable);

        ModelAndView mv = new ModelAndView("jsonView");

        Map<String, Object> retMap = new HashMap<>();

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", pageable.getPageNumber());
        pageMap.put("totalCount", roleItems.getTotalElements());

        retMap.put("contents", roleItems.getContent());
        retMap.put("pagination", pageMap);

        mv.addObject("result", true);
        mv.addObject("data", retMap);

        return mv;
    }
}
