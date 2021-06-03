package com.globaldenso.dnkr.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
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
import com.globaldenso.dnkr.domain.PjtDomain;
import com.globaldenso.dnkr.domain.WorkSortDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAK001PjtSearchForm;

/**
 * [KO] 프로젝트 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls of project (WAK001).<br>
 * [JP] <br>
 * 
 * @author UXIS
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAK002PjtSearchAll")
@ViewId(value = "WAK002")
public class WAK002PjtSearchAllController {

    /**
     * [KR] 프로젝트관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private PjtService pjtService;
    
    /**
     * [KR] 코드관리 서비스 <br> 
     * [EN] Field of CommonCodeService.<br>
     * [JP] <br>    
     */
    @Autowired
    private WorkSortService workSortService;
    
    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
        
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
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAK002PjtSearchAllController() {
        // no process
    }
    
    /**
     * 
     * 
     * @param request       HttpServletRequest
     * @param pjtDomain     WAK001PjtSearchForm
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = ".tiles.page.WAK002")
    @Token(save = true)
    public ModelAndView init(HttpServletRequest request, @ModelAttribute("pjtDomain") WAK001PjtSearchForm pjtDomain) throws Exception {

        /**
         * <pre>
         * 1.[EN] Screen initialization processing.
         *   [EN]    I acquire Common code information and display it to a screen  
         *   [JP] 
         * </pre>
         */

        //System.out.println("WAK002PjtSearchAll/init.do");
        ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String searchDate = ServletRequestUtils.getStringParameter(request, "searchDate");
        
        String getWorkLCode = ServletRequestUtils.getStringParameter(request, "workLCode");
        String getWorkMCode = ServletRequestUtils.getStringParameter(request, "workMCode");
        String getWorkSCode = ServletRequestUtils.getStringParameter(request, "workSCode");

        String logEmpNum = (String)request.getSession().getAttribute("logEmpNum");
        
        WorkSortDomain workLDomain = new WorkSortDomain();  
        workLDomain.setUseYn("Y");
        workLDomain.setWorkLv(1);
        List<WorkSortDomain> workLList = workSortService.searchByCondition(workLDomain);

        WorkSortDomain workMDomain = new WorkSortDomain();
        workMDomain.setUppWorkCode(getWorkLCode);
        workMDomain.setWorkLv(2);
        List<WorkSortDomain> workMList = workSortService.searchByCondition(workMDomain);

        WorkSortDomain workSDomain = new WorkSortDomain();
        workSDomain.setUppWorkCode(getWorkMCode);
        workSDomain.setWorkLv(3);
        List<WorkSortDomain> workSList = workSortService.searchByCondition(workSDomain);

        if(pjtDomain.getStartDate() == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            pjtDomain.setStartDate(today);
            pjtDomain.setEndDate(today);
        }

        pjtDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        pjtDomain.setEmpNumber(logEmpNum);
//      List<PjtDomain> pjtList = pjtService.searchByCondition(pjtDomain);
        int count = 0;

        try {
            count = pjtService.searchCount(pjtDomain);
        } catch (Exception e) {
            System.out.println("조회할 데이터가 없습니다.");
        }

        if(count > 0) {
            // paging process
            PagingUtility.calcPaging(pjtDomain, count);
            List<PjtDomain> pjtList = pjtService.searchByConditionForPaging(pjtDomain);
            mv.addObject("pjtList", pjtList);
            
            pjtDomain.setRowNumFrom(0);
            pjtDomain.setRowNumTo(count);
            List<PjtDomain> pjtExcel = pjtService.searchByConditionForPaging(pjtDomain);
            mv.addObject("pjtExcel", pjtExcel);
        }

        System.out.println(pjtDomain.getRelSys());

        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("workLList", workLList);
        mv.addObject("workMList", workMList);
        mv.addObject("workSList", workSList);
        mv.addObject("getWorkLCode", getWorkLCode);
        mv.addObject("getWorkMCode", getWorkMCode);
        mv.addObject("getWorkSCode", getWorkSCode);
        mv.addObject("url", "WAK002PjtSearchAll.jsp");
        mv.setViewName(".tiles.page.WAK002");
        return mv;  
    }
    
    /**
     *
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @param pjtDomain WAK001PjtSearchForm
     * @throws Exception 
     */
    @RequestMapping(value = "/pjtExcel.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ErrorBack(viewName = "forward:init.do")
    public void pjtExcel(HttpServletRequest request, 
        HttpServletResponse response, 
        @ModelAttribute("pjtDomain") WAK001PjtSearchForm pjtDomain) throws Exception {
        
        String filename = ServletRequestUtils.getStringParameter(request, "filename");
        String logEmpNum = (String)request.getSession().getAttribute("logEmpNum");

        pjtDomain.setCmcLangCode(DensoContext.get().getLocale().getLanguage());
        pjtDomain.setEmpNumber(logEmpNum);

        if(pjtDomain.getStartDate() == null) {
            SimpleDateFormat datafmt = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            String today = datafmt.format(calendar.getTime());
            pjtDomain.setStartDate(today);
            pjtDomain.setEndDate(today);
        }

        int count = 0;
        try {
            count = pjtService.searchCount(pjtDomain);
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        List<PjtDomain> pjtExcel = null;
        if(count > 0) {
            PagingUtility.calcPaging(pjtDomain, count);
            System.out.println(pjtDomain);
            pjtExcel = pjtService.searchByConditionForPaging(pjtDomain);
        }
        
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("프로젝트등록 > 전체검색");
        sheet.setColumnWidth((short)1, (short)3000);
        
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
        
        HSSFCellStyle dateStyle = (HSSFCellStyle) wb.createCellStyle();
        dateStyle.setDataFormat((short) 0xe);
        dateStyle.setBorderTop(BorderStyle.THIN);
        dateStyle.setBorderBottom(BorderStyle.THIN);
        dateStyle.setBorderLeft(BorderStyle.THIN);
        dateStyle.setBorderRight(BorderStyle.THIN);
        
        row = sheet.createRow(1);
        cell = row.createCell(1);
        cell.setCellValue("프로젝트등록 > 전체검색");
        
        row = sheet.createRow(rowNo++);
        cell = row.createCell(1);
        cell.setCellStyle(headStyle);
        cell.setCellValue("일자");
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
        cell.setCellValue("업무영역(공통/지역)");
        cell = row.createCell(7);
        cell.setCellStyle(headStyle);
        cell.setCellValue("업무시간(h)");
        cell = row.createCell(8);
        cell.setCellStyle(headStyle);
        cell.setCellValue("업무상세");
        
        if(pjtExcel != null){
            for(int i = 0; i < pjtExcel.size(); i++) {
                row = sheet.createRow(rowNo++);
                cell = row.createCell(1);
                cell.setCellStyle(dateStyle);
                cell.setCellValue(pjtExcel.get(i).getRegDate());
                
                cell = row.createCell(2);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtExcel.get(i).getWorkLTypeNm());
               
                cell = row.createCell(3);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtExcel.get(i).getWorkMTypeNm());
                
                cell = row.createCell(4);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtExcel.get(i).getWorkTypeNm());
                
                cell = row.createCell(5);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtExcel.get(i).getRelSys());
                
                cell = row.createCell(6);
                cell.setCellStyle(bodyStyle);
                if(pjtExcel.get(i).getWorkTrtr().equals("CMCM00003")){
                    cell.setCellValue("공통");
                }else{
                    cell.setCellValue("지역");
                }
                
                cell = row.createCell(7);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtExcel.get(i).getWorkHour());
                
                cell = row.createCell(8);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(pjtExcel.get(i).getWorkDtlCnts());
            }
        }
        
        response.reset();
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename + "_excel.xls");
        
        wb.write(response.getOutputStream());
        wb.close();
    }
}
