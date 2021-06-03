package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.PjtService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;
import com.globaldenso.dnkr.business.service.WorkSortService;
import com.globaldenso.dnkr.business.service.WorkStatsService;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PjtDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAK001PjtSearchForm;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * [KO] 업무별 통계 컨트롤러를 정의하는 클래스.<br>
 * [EN] <br>
 * [JP] <br>
 * 
 * @author UXIS
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAK007WorkStatsSearch")
@ViewId(value = "WAK007")
public class WAK007WorkStatsSearchController {

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] 업무분류 서비스 <br>     
     */
    @Autowired
    private WorkSortService workSortService;
    
    /**
     * [KR] 사업부관리 서비스 <br>     
     */
    @Autowired
    private RelationClsService relationClsService;
    
    /**
     * [KR] 사업장관리 서비스 <br>          
     */
    @Autowired
    private RelationLocService relationLocService;
    
    /**
     * [KR] 사업부서(팀)관리 서비스 <br>     
     */
    @Autowired
    private RelationTeamService relationTeamService;
    
    /**
     * [KR] 사업장관리 서비스 <br>          
     */
    @Autowired
    private PjtService pjtService;
    
    /**
     * [KR] 사업장관리 서비스 <br>          
     */
    @Autowired
    private WorkStatsService workStatsService;
    
    /** */
    private final String MENU_CODE = "263";
    

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAK007WorkStatsSearchController() {
        // no process
    }
    
    /**
     * 
     * 
     * @param request       HttpServletRequest
     * @param pjtSearchForm WAK001PjtSearchForm
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK007")
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, 
        @ModelAttribute("pjtSearchForm") WAK001PjtSearchForm pjtSearchForm) throws Exception {

        /**
         * <pre>
         * [KO] 업무별 통계 정보를 화면에 보여준다<br>
         * [EN] <br>  
         * [JP] <br>
         * </pre>
         */

        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        //System.out.println("tabId:" + tabId);
        
        //첫 로딩시 오늘날짜로 조회 
        SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String today = datafmt.format(calendar.getTime());
        pjtSearchForm.setStartDate(today);
        pjtSearchForm.setEndDate(today);

        //팀조회용 도메인
        EmpDomain empDomain = new EmpDomain();

        //첫 로딩시 본인의 팀 데이터 출력 
        String teamCode = (String)request.getSession().getAttribute("teamCode");
        if(teamCode != null) {
            empDomain.setTeamCode(teamCode);
        }
        List<EmpDomain> empList = empService.searchByCondition(empDomain);
        List<String> empNumList = new ArrayList<String>();
        if(empList != null) {
            for(EmpDomain emp :empList) {
                empNumList.add(emp.getEmpNumber());
            }
        }
        pjtSearchForm.setEmpNumList(empNumList);
        pjtSearchForm.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        int count = 0;
        try {
            count = workStatsService.searchCountTeamL(pjtSearchForm);
        } catch(Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }
         
        
     // paging process
        /*PagingUtility.calcPaging(pjtSearchForm, count);
        
        List<PjtDomain> pjtList = workStatsService.searchByConditionForPagingTeamL(pjtSearchForm);*/
        mv.addObject("pjtCount", count);
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK007WorkStatsSearch.jsp");
        mv.setViewName(".tiles.page.WAK007");
        return mv;
    }
    
    /**
     * 
     * 
     * @param request           HttpServletRequest
     * @param pjtSearchForm     WAK001PjtSearchForm
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/search", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK007")
    @Token(save = true)
    public ModelAndView search(HttpServletRequest request, 
        @ModelAttribute("pjtSearchForm") WAK001PjtSearchForm pjtSearchForm) throws Exception {

        /**
         * <pre>
         * [KO] 업무별 통계 정보를 화면에 보여준다<br>
         * [EN] <br>  
         * [JP] <br>
         * </pre>
         */

        //System.out.println("WAK007WorkStatsSearch/search.do");
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String workType = ServletRequestUtils.getStringParameter(request, "workType");
        
        String loginTeamCode = (String)request.getSession().getAttribute("teamCode");
        
        EmpDomain empDomain = new EmpDomain();
        empDomain.setTeamCode(loginTeamCode);
        List<EmpDomain> empList = empService.searchByCondition(empDomain);
        List<String> empNumList = new ArrayList<String>();

        //팀내 사원이 존재하는지 체크
        Boolean empCheck = false;
        if(!empList.isEmpty()) {
//          if(!empList.isEmpty() && empList.size() > 0) {
            empCheck = true;
            for(EmpDomain emp :empList) {
                empNumList.add(emp.getEmpNumber());
            }
        }

        if(empCheck){
            //System.out.println("empNumList.size:" + empNumList.size());
            pjtSearchForm.setEmpNumList(empNumList);
            pjtSearchForm.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            int count = 0;
            try{
                if(workType != null) {
                    if(workType.equals("L")) {
                        count = workStatsService.searchCountTeamL(pjtSearchForm);
                    } else if(workType.equals("M")) {
                        count = workStatsService.searchCountTeamM(pjtSearchForm);
                    } else if(workType.equals("S")) {
                        count = workStatsService.searchCountTeamS(pjtSearchForm);
                    } else if(workType.equals("REL_SYS")) {
                        count = workStatsService.searchCountRelSys(pjtSearchForm);
                    }
                } else {
                    count = workStatsService.searchCountTeamL(pjtSearchForm);
                }
            } catch (Exception e) {
//              e.printStackTrace();
                System.out.println("데이터가 없습니다.");
            }    
            System.out.println("relsyscount" + count);
         // paging process
            if(count > 0) {
                PagingUtility.calcPaging(pjtSearchForm, count);
                List<PjtDomain> pjtExcel = null;
                List<PjtDomain> pjtList = null;
                List<PjtDomain> pjtChartDatas = null;
                if(workType != null) {
                    if(workType.equals("L")) {
                        pjtList = workStatsService.searchByConditionForPagingTeamL(pjtSearchForm);
                        pjtChartDatas = workStatsService.searchByConditionForTeamL(pjtSearchForm);
                    } else if(workType.equals("M")) {
                        pjtList = workStatsService.searchByConditionForPagingTeamM(pjtSearchForm);
                        pjtChartDatas = workStatsService.searchByConditionForTeamM(pjtSearchForm);
                    } else if(workType.equals("S")) {
                        pjtList = workStatsService.searchByConditionForPagingTeamS(pjtSearchForm);
                        pjtChartDatas = workStatsService.searchByConditionForTeamS(pjtSearchForm);
                    } else if(workType.equals("REL_SYS")) {
                        pjtList = workStatsService.searchByConditionForPagingRelSys(pjtSearchForm);
                        pjtChartDatas = workStatsService.searchByConditionForRelSys(pjtSearchForm);
                    }
                } else {
                    pjtList = workStatsService.searchByConditionForPagingTeamL(pjtSearchForm);
                    pjtChartDatas = workStatsService.searchByConditionForTeamL(pjtSearchForm);
                }
                //mv.addObject("pjtCount", count);
                mv.addObject("pjtChartDatas", pjtChartDatas);
                mv.addObject("pjtList", pjtList);
            }
        }
        mv.addObject("authBinaryNum", UxisCmmUtil.getSessionAuthData(request, MENU_CODE));
        mv.addObject("workType", workType);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAK007WorkStatsSearch.jsp");
        mv.setViewName(".tiles.page.WAK007");
        return mv;
        
    }
    
    
    /**
     * 
     * 
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @param pjtSearchForm WAK001PjtSearchForm
     * @throws Exception 
     */
    @RequestMapping(value = "/workStatExcel.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK007")
    @Token(save = true)
    public void workStatExcel(HttpServletRequest request, 
        HttpServletResponse response, 
        @ModelAttribute("pjtSearchForm") WAK001PjtSearchForm pjtSearchForm) throws Exception {
       
        String filename = ServletRequestUtils.getStringParameter(request, "filename");
        String workType = ServletRequestUtils.getStringParameter(request, "workType");

        String startDate = ServletRequestUtils.getStringParameter(request, "startDate");
        String endDate = ServletRequestUtils.getStringParameter(request, "endDate");
        
        String loginTeamCode = (String)request.getSession().getAttribute("teamCode");
        
        EmpDomain empDomain = new EmpDomain();
        empDomain.setTeamCode(loginTeamCode);
        List<EmpDomain> empList = empService.searchByCondition(empDomain);
        List<String> empNumList = new ArrayList<String>();
        List<PjtDomain> pjtList = null;

        //팀내 사원이 존재하는지 체크
        Boolean empCheck = false;
        if(!empList.isEmpty()) {
            //if(!empList.isEmpty() && empList.size() > 0) {
            empCheck = true;
            for(EmpDomain emp :empList) {
                empNumList.add(emp.getEmpNumber());
            }
        }
        
        if(empCheck){
            //System.out.println("empNumList.size:" + empNumList.size());
            
            System.out.println(endDate);

            pjtSearchForm.setStartDate(startDate);
            pjtSearchForm.setEndDate(endDate);
            pjtSearchForm.setEmpNumList(empNumList);
            pjtSearchForm.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
            int count = 0;
            try{
                if(workType != null) {
                    if(workType.equals("L")) {
                        count = workStatsService.searchCountTeamL(pjtSearchForm);
                    } else if(workType.equals("M")) {
                        count = workStatsService.searchCountTeamM(pjtSearchForm);
                    } else if(workType.equals("S")) {
                        count = workStatsService.searchCountTeamS(pjtSearchForm);
                    } else if(workType.equals("REL_SYS")) {
                        count = workStatsService.searchCountRelSys(pjtSearchForm);
                    }
                } else {
                    count = workStatsService.searchCountTeamL(pjtSearchForm);
                }
            } catch (Exception e) {
                e.printStackTrace();;
                System.out.println("데이터가 없습니다.");
            }    
            
         // paging process
            if(count > 0) {
                PagingUtility.calcPaging(pjtSearchForm, count);
                List<PjtDomain> getPjtList = null;
                List<PjtDomain> pjtChartDatas = null;
                if(workType != null) {
                    if(workType.equals("L")) {
                        getPjtList = workStatsService.searchByConditionForPagingTeamL(pjtSearchForm);
                        pjtChartDatas = workStatsService.searchByConditionForTeamL(pjtSearchForm);
                        pjtList = getPjtList;
                    } else if(workType.equals("M")) {
                        getPjtList = workStatsService.searchByConditionForPagingTeamM(pjtSearchForm);
                        pjtChartDatas = workStatsService.searchByConditionForTeamM(pjtSearchForm);
                        pjtList = getPjtList;
                    } else if(workType.equals("S")) {
                        getPjtList = workStatsService.searchByConditionForPagingTeamS(pjtSearchForm);
                        pjtChartDatas = workStatsService.searchByConditionForTeamS(pjtSearchForm);
                        pjtList = getPjtList;
                    } else if(workType.equals("REL_SYS")) {
                        pjtList = workStatsService.searchByConditionForPagingRelSys(pjtSearchForm);
                        pjtChartDatas = workStatsService.searchByConditionForRelSys(pjtSearchForm);
                    }
                } else {
                    getPjtList = workStatsService.searchByConditionForPagingTeamL(pjtSearchForm);
                    pjtChartDatas = workStatsService.searchByConditionForTeamL(pjtSearchForm);
                    pjtList = getPjtList;
                }
            }
        }
        
        
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("업무별통계");
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
        cell.setCellValue("업무별통계");
        
        row = sheet.createRow(rowNo++);
        cell = row.createCell(1);
        cell.setCellStyle(headStyle);
        cell.setCellValue("번호");
        cell = row.createCell(2);
        cell.setCellStyle(headStyle);
        cell.setCellValue("업무분류(대)");
        cell = row.createCell(3);
        cell.setCellStyle(headStyle);
        cell.setCellValue("업무분류(중)");
        cell = row.createCell(4);
        cell.setCellStyle(headStyle);
        cell.setCellValue("업무분류(소)");
        cell = row.createCell(5);
        cell.setCellStyle(headStyle);
        cell.setCellValue("관련시스템");
        cell = row.createCell(6);
        cell.setCellStyle(headStyle);
        cell.setCellValue("업무시간");
        
        if(pjtList != null){
            for(int i = 0; i < pjtList.size(); i++) {
                row = sheet.createRow(rowNo++);
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtList.get(i).getRowNum());
                
                cell = row.createCell(2);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtList.get(i).getWorkLTypeNm());
               
                cell = row.createCell(3);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtList.get(i).getWorkMTypeNm());
                
                cell = row.createCell(4);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtList.get(i).getWorkTypeNm());
                
                cell = row.createCell(5);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtList.get(i).getRelSys());
                
                cell = row.createCell(6);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtList.get(i).getWorkHour());
            }
        }
        
        response.reset();
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename + "_excel.xls");
        
        wb.write(response.getOutputStream());
        wb.close();
    }
}
