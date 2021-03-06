package com.globaldenso.dnkr.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.library.presentation.paging.utility.PagingUtility;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.MenuService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.domain.RelationLocDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.domain.WorkSortDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAB001EmpSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisUtil;

/**
 * [KR] ???????????? ????????? ????????????<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAB001EmpSearch")
@ViewId(value = "WAB001")
public class WAB001EmpSearchController {

    /**
     * [KR] ???????????? ????????? <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] ???????????? ????????? <br>     
     */
    @Autowired
    private WorkSortService workSortService;
    
    /**
     * [KR] ??????????????? ????????? <br>     
     */
    @Autowired
    private RelationClsService relationClsService;
    
    /**
     * [KR] ??????????????? ????????? <br>          
     */
    @Autowired
    private RelationLocService relationLocService;
    
    /**
     * [KR] ????????????(???)?????? ????????? <br>     
     */
    @Autowired
    private RelationTeamService relationTeamService;

    /**
     * [KR] ???????????? ????????? <br>     
     */
    @Autowired
    private PrivateAuthService privateAuthService;
    
    /**
     * [KR] ??????????????? <br>     
     */
    @Autowired
    private MenuService menuService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] ???????????????????????????????????????<br>
     */
    public WAB001EmpSearchController() {
        // no process
    }
    
    
    
    /**
     * [KR] <br>     
     * 
     * @param request           HttpServletRequest
     * @param form              WAB001EmpSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("WAB001EmpSearchForm") WAB001EmpSearchForm form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String resultMsg = ServletRequestUtils.getStringParameter(request, "resultMsg");
        System.out.println("resultMsg:" + resultMsg);
        
        //WAB001EmpSearchForm empDomain = new WAB001EmpSearchForm();
        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        
        int count = 0;
        try {
            count = empService.searchCount(form);
        } catch (Exception e) {
            System.out.println("???????????? ????????????.");
        }
        
        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(form, count);
            List<EmpDomain> empList = empService.searchByConditionForPaging(form);
            mv.addObject("empList", empList);
        }
        
        
        /*// ?????????, ????????? ????????? ???????????? ?????? - 180626 ?????????????????? ??????
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        clsDomain.setUseYn("Y");
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        locDomain.setUseYn("Y");
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        */
        
        //UxisCmmUtil.getSessionCls(request, mv);//????????? ?????? ??????????????? ?????? 180831
        UxisCmmUtil.getSessionLoc(request, mv);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        teamDomain.setUseYn("Y");
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        
//        System.out.println("????????????:" + menu);
//        System.out.println("????????????" + UxisCmmUtil.getSessionAuthData(request, menu));
        
        //????????????????????? ?????? ???????????????
        mv.addObject("resultMsg", resultMsg);
        
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("menu", menu);
        mv.addObject("totCount", count);
        mv.addObject("teamList", teamList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAB001EmpSearch.jsp");
        if(UxisUtil.isMobile(request)) {
            Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
            
            mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAB001M");
        } else {
            mv.setViewName(".tiles.page.WAB001");
        }
        return mv;
        
    }
    
    /**
     * [KR] <br>     
     * 
     * @param form              WAB001EmpSearchForm
     * @param request           HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:init.do")
    public ModelAndView search(@ModelAttribute("WAB001EmpSearchForm") WAB001EmpSearchForm form, HttpServletRequest request)  throws Exception {
        
        //System.out.println("WAB0014EmpSearch/search.do");
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String srvCode = ServletRequestUtils.getStringParameter(request, "srvCode");
        
        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        int count = 0;
        try {
            count = empService.searchCount(form);
        } catch (Exception e) {
            System.out.println("???????????? ????????????.");
        }
//        domain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
//        List<EmpDomain> empList = empService.searchByCondition(domain);
        
        // paging process
        if(count > 0){
            PagingUtility.calcPaging(form, count);
            List<EmpDomain> empList = empService.searchByConditionForPaging(form);
            mv.addObject("totCount", count);
            mv.addObject("empList", empList);
        }
        
        /*// ????????? ????????? ???????????? ?????? - 180626 ?????????????????? ??????
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setUseYn("Y");
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        */
        
//        UxisCmmUtil.getSessionCls(request, mv);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
//        if(form.getClsCode() != null) {
//            locDomain.setClsCode(form.getClsCode());
//        }
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setUseYn("Y");
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        if(form.getLocCode() != null) {
            teamDomain.setLocCode(form.getLocCode());
        }
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        mv.addObject("menu", menu);
        mv.addObject("srvCode", srvCode);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, menu));
        mv.addObject("paraEmp", form);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAB001EmpSearch.jsp");
        if(UxisUtil.isMobile(request)) {
            Map<String, Integer> menuMap = (Map)request.getSession().getAttribute("menuMap");
            
            mv.addObject("empName", UxisCmmUtil.getSessionData(request, "empName"));
            mv.addObject("menuList", menuService.getMenuList(menuMap));
            mv.setViewName(".tiles.page.WAB001M");
        } else {
            mv.setViewName(".tiles.page.WAB001");
        }
        
        //?????? ??????????????? ?????????????????? ??????
        String maEmpYn = request.getParameter("maEmpYn");
        if("Y".equals(maEmpYn)){
            empService.procDnkrEmpTmpToMaEmp();
        }
        
        
        return mv;
        
    }
    
    /**
     * [EN] Main processing<br>
     * [EN] Delete from the DB the information displayed on the screen.<br>
     * [JP] ??????????????????<br>
     * [JP] ??????????????????????????????????????????DB????????????????????????<br>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:/WA0001EmpSearch/research.do")
    public ModelAndView delete(HttpServletRequest request) throws Exception {
        
        /**
         * <pre>
         * 1.[EN] Employee deleate processing.
         *   [EN]   I delete the employee information chosen on a screen from DB.
         *   [JP] ??????????????????
         *   [JP]  ??????????????????????????????????????????????????????????????????
         *   [JP]  ??????????????????????????????NULL???????????????????????????????????????
         *   [JP]  ??????????????????","??????????????????
         *   [JP]  ???????????????????????????????????????EmpDomain????????????????????????????????????????????????
         *   [JP]  ?????????????????????????????????????????????????????????
         *   [JP]  ????????????????????????????????????????????????MessageManager?????????????????????
         *   [JP]  ???????????????????????????????????????
         * </pre>
         */
        
        //System.out.println("WAB001EmpSearch/delete.do");
        ModelAndView mv = new ModelAndView();
        String resultMsg = "";
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");

        PrivateAuthDomain privateAuthDomain = new PrivateAuthDomain();
        privateAuthDomain.setEmpNumber(empNumber);
        try {
            int count = privateAuthService.delete(privateAuthDomain);
        } catch(Exception e) {
            System.out.println("???????????? ?????? ???????????? ????????????.");
        }

        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpNumber(empNumber);
        try {
            empService.delete(empDomain);
            resultMsg = "?????????????????????.";
        } catch (Exception e) {
            empDomain.setEmpUse("N");
            empDomain.setEmpPrivateAuth("N");
            empService.update(empDomain);
            resultMsg = "????????? ????????? ????????? ???????????? ????????? ????????? ???????????? ???????????? ??????????????? ???????????? ???????????????.";
        }
        
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("resultMsg", resultMsg);
        mv.setViewName("redirect:init.do");
        return mv;
        
    }
    
    /**
     * [KR] <br>     
     *
     * @param request           HttpServletRequest
     * @param form              WAB001EmpSearchForm
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/empSelectPop", method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView empSelectPop(HttpServletRequest request, 
        @ModelAttribute("WAB001EmpSearchForm") WAB001EmpSearchForm form)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String workCode = ServletRequestUtils.getStringParameter(request, "workCode");
        
        WorkSortDomain workDomain = new WorkSortDomain();
        workDomain.setWorkCode(workCode);
        
        List<WorkSortDomain> aprvEmpList = workSortService.searchWorkConfirmList(workDomain);
        
        Map<String, String> aprvEmpMap = new HashMap<String, String>();
        if(!aprvEmpList.isEmpty()) {
            for (WorkSortDomain domain :aprvEmpList) {
                aprvEmpMap.put(domain.getAprvEmpNum(), domain.getWorkCode());
            }
        }
        
        //WAB001EmpSearchForm empDomain = new WAB001EmpSearchForm();
        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
//        int count = empService.searchCount(form); 
        
        // paging process
//        PagingUtility.calcPaging(form, count);
        
        List<EmpDomain> empList = empService.searchByCondition(form);
        
        /*// ????????? ????????? ???????????? ?????? - 180626 ?????????????????? ??????
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setUseYn("Y");
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        */
//        UxisCmmUtil.getSessionCls(request, mv);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
//        if(form.getClsCode() != null) {
//            locDomain.setClsCode(form.getClsCode());
//        }
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setUseYn("Y");
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        if(form.getLocCode() != null) {
            teamDomain.setLocCode(form.getLocCode());
        }
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        mv.addObject("workCode", workCode);
        mv.addObject("aprvEmpMap", aprvEmpMap);
//        mv.addObject("totCount", count);
        mv.addObject("empList", empList);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("paraEmp", form);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAB005EmpSelectPop.jsp");
        mv.setViewName(".tiles.page.WAB005");
        return mv;
        
    }
    
    /**
     * [KR] <br>     
     * 
     * @param form          WAB001EmpSearchForm
     * @param request       HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/empListPop", method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView empListPop(@ModelAttribute("WAB001EmpSearchForm") WAB001EmpSearchForm form, 
        HttpServletRequest request)  throws Exception {
        
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String workCode = ServletRequestUtils.getStringParameter(request, "workCode");
        String srvCode = ServletRequestUtils.getStringParameter(request, "srvCode");
        
        WorkSortDomain workDomain = new WorkSortDomain();
        workDomain.setWorkCode(workCode);
        
        List<WorkSortDomain> aprvEmpList = workSortService.searchWorkConfirmList(workDomain);
        
        Map<String, String> aprvEmpMap = new HashMap<String, String>();
        if(!aprvEmpList.isEmpty()) {
            for (WorkSortDomain domain :aprvEmpList) {
                aprvEmpMap.put(domain.getAprvEmpNum(), domain.getWorkCode());
            }
        }
        
        //WAB001EmpSearchForm empDomain = new WAB001EmpSearchForm();
        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        int count = empService.searchCount(form);
        // paging process
        PagingUtility.calcPaging(form, count);
        
        List<EmpDomain> empList = empService.searchByCondition(form);
        
        /*// ????????? ????????? ???????????? ?????? - 180626 ?????????????????? ??????
        RelationClsDomain clsDomain = new RelationClsDomain();
        clsDomain.setUseYn("Y");
        clsDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        List<RelationClsDomain> clsList = relationClsService.searchByCondition(clsDomain);
        */
        
//        UxisCmmUtil.getSessionCls(request, mv);
        
        RelationLocDomain locDomain = new RelationLocDomain();
        locDomain.setUseYn("Y");
        locDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
//        if(form.getClsCode() != null) {
//            locDomain.setClsCode(form.getClsCode());
//        }
        List<RelationLocDomain> locList = relationLocService.searchByCondition(locDomain);
        
        RelationTeamDomain teamDomain = new RelationTeamDomain();
        teamDomain.setUseYn("Y");
        teamDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        if(form.getLocCode() != null) {
            teamDomain.setLocCode(form.getLocCode());
        }
        List<RelationTeamDomain> teamList = relationTeamService.searchByCondition(teamDomain);
        
        mv.addObject("workCode", workCode);
        mv.addObject("aprvEmpMap", aprvEmpMap);
//        mv.addObject("totCount", count);
        mv.addObject("srvCode", srvCode);
        mv.addObject("paraEmp", form);
        mv.addObject("empList", empList);
        mv.addObject("locList", locList);
        mv.addObject("teamList", teamList);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAB005EmpListPop.jsp");
        mv.setViewName(".tiles.page.WAB005L");
        return mv;
        
    }
    
    /**
     * 
     * @param form              WAB001EmpSearchForm
     * @param response          HttpServletResponse
     * @param request           HttpServletRequest
     * @throws Exception 
     */
    @RequestMapping(value = "/empExcel.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:init.do")
    public void empExcel(@ModelAttribute("WAB001EmpSearchForm") WAB001EmpSearchForm form, 
        HttpServletResponse response, 
        HttpServletRequest request)  throws Exception {
        
        String filename = ServletRequestUtils.getStringParameter(request, "filename");

        form.setCmcLangCode(DensoContext.get().getLocale().getLanguage());

        int count = 0;
        try {
            count = empService.searchCount(form);
        } catch (Exception e) {
            System.out.println("???????????? ????????????.");
        }
        
        List<EmpDomain> empExcel = null;
        if(count > 0) {
            form.setRowNumFrom(0);
            form.setRowNumTo(count);
            empExcel = empService.searchByConditionForPaging(form);
        }
        
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("???????????????");
        Row row = null;
        Cell cell = null;
        int rowNo = 3;
        
        CellStyle headStyle = wb.createCellStyle();
        
        headStyle.setFillForegroundColor(HSSFColorPredefined.GOLD.getIndex());
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setAlignment(HorizontalAlignment.CENTER);
        
        CellStyle bodyStyle = wb.createCellStyle();
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);
        
        row = sheet.createRow(1);
        cell = row.createCell(1);
        cell.setCellValue("???????????????");
        
        row = sheet.createRow(rowNo++);
        cell = row.createCell(1);
        cell.setCellStyle(headStyle);
        cell.setCellValue("??????");
        cell = row.createCell(2);
        cell.setCellStyle(headStyle);
        cell.setCellValue("????????????");
        cell = row.createCell(3);
        cell.setCellStyle(headStyle);
        cell.setCellValue("?????????");
        cell = row.createCell(4);
        cell.setCellStyle(headStyle);
        cell.setCellValue("?????????");
        cell = row.createCell(5);
        cell.setCellStyle(headStyle);
        cell.setCellValue("??????(???)");
        cell = row.createCell(6);
        cell.setCellStyle(headStyle);
        cell.setCellValue("????????????");
        cell = row.createCell(7);
        cell.setCellStyle(headStyle);
        cell.setCellValue("?????????");
        cell = row.createCell(8);
        cell.setCellStyle(headStyle);
        cell.setCellValue("?????????");
        cell = row.createCell(9);
        cell.setCellStyle(headStyle);
        cell.setCellValue("?????????");
        cell = row.createCell(10);
        cell.setCellStyle(headStyle);
        cell.setCellValue("????????????");
        cell = row.createCell(11);
        cell.setCellStyle(headStyle);
        cell.setCellValue("???????????????");
        cell = row.createCell(12);
        cell.setCellStyle(headStyle);
        cell.setCellValue("????????????");
        
        if(empExcel != null){
            for(int i = 0; i < empExcel.size(); i++) {
                row = sheet.createRow(rowNo++);
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(count - empExcel.get(i).getRowNum() + 1);
                
                cell = row.createCell(2);
                cell.setCellStyle(bodyStyle);
                if(empExcel.get(i).getInOutType().equals("I")){
                    cell.setCellValue("????????????");
                }else{
                    cell.setCellValue("????????????");
                }
                
                cell = row.createCell(3);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(empExcel.get(i).getClsName());
                
                cell = row.createCell(4);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(empExcel.get(i).getLocName());
                
                cell = row.createCell(5);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(empExcel.get(i).getTeamName());
                
                cell = row.createCell(6);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(empExcel.get(i).getEmpNumber());
                
                cell = row.createCell(7);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(empExcel.get(i).getEmpName());
                
                cell = row.createCell(8);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(empExcel.get(i).getEmpId());
                
                cell = row.createCell(9);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(empExcel.get(i).getEmpEmail());
                
                cell = row.createCell(10);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(empExcel.get(i).getRelationCopLocName());
                
                cell = row.createCell(11);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(empExcel.get(i).getRelationCopNo());
                
                cell = row.createCell(12);
                cell.setCellStyle(bodyStyle);
                if(empExcel.get(i).getEmpUse().equals("Y")){
                    cell.setCellValue("??????");
                }else{
                    cell.setCellValue("?????????");
                }
            }
        }
        
        response.reset();
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename + "_excel.xls");
        
        wb.write(response.getOutputStream());
        wb.close();
    }
    
}
