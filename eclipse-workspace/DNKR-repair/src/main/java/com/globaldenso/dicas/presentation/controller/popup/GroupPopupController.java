package com.globaldenso.dicas.presentation.controller.popup;


import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dicas.business.dto.GroupDto;
import com.globaldenso.dicas.business.service.CodeService;
import com.globaldenso.dicas.business.service.GroupService;
import com.globaldenso.dicas.presentation.form.GroupSearchForm;
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
import java.util.Map;


@Controller("popup.groupController")
@RequestMapping(value="/popup/group")
public class GroupPopupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupPopupController.class);

    @Autowired
    private GroupService groupService;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public GroupPopupController() {
        // no process
    }

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    @ViewId("WCMP002")
    public ModelAndView init(HttpServletRequest request,
         HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.setViewName(".tiles.popup.cmmn.WCMP002");

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ModelAndView search1(GroupSearchForm criteria, Pageable pageable) throws Exception {

        Page<GroupDto> groupItems = null; //groupService.searchByCondition2(criteria, pageable);

        ModelAndView mv = new ModelAndView("jsonView");

        Map<String, Object> retMap = new HashMap<>();

        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("page", pageable.getPageNumber());
        pageMap.put("totalCount", groupItems.getTotalElements());

        retMap.put("contents", groupItems.getContent());
        retMap.put("pagination", pageMap);

        mv.addObject("result", true);
        mv.addObject("data", retMap);

        return mv;
    }
}
