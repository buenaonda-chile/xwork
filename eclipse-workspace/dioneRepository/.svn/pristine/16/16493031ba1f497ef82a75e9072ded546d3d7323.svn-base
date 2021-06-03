package com.globaldenso.dnkr.presentation.controller;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.EduService;
import com.globaldenso.dnkr.business.service.EduUserService;
import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.constant.Constants;
import com.google.gson.Gson;

/**
 * 
 * @파일명 : EduRltController.java
 * @프로젝트 : DNKR
 * @날짜 : 2019. 9. 25.
 * @작성자 : Cho HeumJun
 * @설명
 * 
 *     <pre>
 * 		관리자 교육 Controller
 *     </pre>
 */
@Controller
public class EduRltController {

	@Autowired
	private EduService eduService;

	@Autowired
	private EduUserService eduUserService;
	
	/**
	 * 
	 * @메소드명	: eduPopup
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		교육 결과 동의 팝업호출
	 * </pre>
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/eduRltPopup", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView eduRltPopup(HttpServletRequest request, HttpServletResponse response, 
        @CookieValue("locallocale") Optional<String> locale)  throws Exception {
		
		ModelAndView mv = new ModelAndView();
	
        CommandMap commandMap = new CommandMap();

        
		if (request.getParameter("edu_pk") == null && request.getParameter("emp_id") == null) {
			commandMap.put("edu_pk", "");
			commandMap.put("emp_id", "");
		} else {
			commandMap.put("edu_pk", request.getParameter("edu_pk"));
			commandMap.put("emp_id", request.getParameter("emp_id"));
			
		}
		
		
		Map<String, Object> eduInfo = (Map<String, Object>)eduService.getEdu(commandMap);
		
		Map<String, Object> eduUserInfo = (Map<String, Object>)eduUserService.getEduUserInfo(commandMap);
		
		mv.addObject("agree", eduInfo.get("AGREE"));
		mv.addObject("agree_title", eduInfo.get("AGREE_TITLE"));
		mv.addObject("reg_date", eduUserInfo.get("REG_DATE"));
		mv.addObject("reg_user", eduUserInfo.get("REG_USER"));
		// 사번만 넘김
		mv.addObject("emp_id", commandMap.get("emp_id").toString().subSequence(1, commandMap.get("emp_id").toString().length()));
        mv.setViewName("/dnkr/edu/eduRltPopup");   // 대상자 지정 팝업
        
        return mv;
	}
	
	/**
	 * 
	 * @메소드명 : edu
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		문제목록 화면으로 이동
	 *     </pre>
	 * 
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/eduRlt", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView edu(HttpServletRequest request, HttpServletResponse response,
			@CookieValue("locallocale") Optional<String> locale) throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.setViewName("/dnkr/edu/eduRltList"); // 외부업체용

		return mv;
	}

	/**
	 * 
	 * @메소드명 : getEduList
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		문제목록 리스트
	 *     </pre>
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ApplicationException
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/eduRltList", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public JsonView eduRltList(HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException, UnsupportedEncodingException {
		String rtnJson; // return Json

		CommandMap commandMap = new CommandMap();
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enumeration = request.getParameterNames();

		// 모든 파라미터를 commandMap에 담는다.
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements()) {
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null) {
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}

		rtnJson = new Gson().toJson(eduService.getEduRltList(commandMap));

		JsonView jv = new JsonView();
		jv.addStaticAttribute("jsonString", rtnJson);

		return jv;

	}

	/**
	 * 
	 * @메소드명 : edu
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		문제목록 화면으로 이동
	 *     </pre>
	 * 
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/eduRltDtl", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView eduRltDtl(HttpServletRequest request, HttpServletResponse response,
			@CookieValue("locallocale") Optional<String> locale) throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.addObject("edu_pk", request.getParameter("edu_pk"));
		mv.setViewName("/dnkr/edu/eduRltDtlList"); // 외부업체용

		return mv;
	}

	/**
	 * 
	 * @메소드명 : eduDetail
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육 상세 화면 이동
	 *     </pre>
	 * 
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/eduRltDtlList", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public JsonView getEduRltDtlList(HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException, UnsupportedEncodingException {

		String rtnJson; // return Json

		ModelAndView mv = new ModelAndView();

		CommandMap commandMap = new CommandMap();

		if (request.getParameter("edu_pk") == null) {
			commandMap.put("edu_pk", "");
		} else {
			commandMap.put("edu_pk", request.getParameter("edu_pk"));
		}

		if (!commandMap.get("edu_pk").equals("")) {

			// 교육에 대한 상세 정보 호출
			Enumeration<?> enumeration = request.getParameterNames();

			// 모든 파라미터를 commandMap에 담는다.
			String key = null;
			String[] values = null;
			while (enumeration.hasMoreElements()) {
				key = (String) enumeration.nextElement();
				values = request.getParameterValues(key);
				if (values != null) {
					commandMap.put(key, (values.length > 1) ? values : values[0]);
				}
			}

		}
		rtnJson = new Gson().toJson(eduService.getEduDtlRltList(commandMap));

		JsonView jv = new JsonView();
		jv.addStaticAttribute("jsonString", rtnJson);

		return jv;
	}

	/**
	 * [KO] 결과보기 화면 - 엑셀 다운로드
	 * 
	 * @param response HttpServletResponse
	 * @param request  HttpServletRequest
	 * @throws Exception
	 */
	@RequestMapping(value = "/eduRltListExcel.do", method = { RequestMethod.GET })
	@ErrorBack(viewName = "forward:init.do")
	public void eduRltListExcel(HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		String edu_pk = ServletRequestUtils.getStringParameter(request, "edu_pk");
        
        CommandMap commandMap = new CommandMap();

		if (request.getParameter("edu_pk") == null) {
			commandMap.put("edu_pk", "");
			commandMap.put("p_complete", "");
		} else {
			commandMap.put("edu_pk", request.getParameter("edu_pk"));
			commandMap.put("p_complete", "");
		}

		commandMap.put(Constants.FROM_GRID_PAGE_SIZE, "10000");
		commandMap.put(Constants.FROM_GRID_CUR_PAGE_NO, "1");
		
        // 
		Map<String, Object> eduMap = (Map<String, Object>)eduService.getEduDtlRltList(commandMap);
		
		
		List<Map<String, Object>> eduMapList = (List<Map<String, Object>>)eduMap.get("rows");

		Map<String, Object> eduInfo = (Map<String, Object>)eduService.getEdu(commandMap);
		
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("List of training ");
        Row row = null;
        Cell cell = null;
        int rowNo = 3;
        
        CellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFillForegroundColor(HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        
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
        cell.setCellValue("");
        
        String[] mainTitleArr = {"제목"};
        String[] mainValueArr = {
        		eduInfo.get("SUBJECT").toString()
        };
       
        for(int i = 0; i < mainTitleArr.length; i++) {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 2, 4));
            row = sheet.createRow(rowNo++);
            cell = row.createCell(1);
            cell.setCellStyle(titleStyle);
            cell.setCellValue(mainTitleArr[i]);
            cell = row.createCell(2);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(mainValueArr[i]);
            for(int j = 3; j < 5; j++) {
                cell = row.createCell(j);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue("");
            }
        }
        
        row = sheet.createRow(rowNo++);
        
        row = sheet.createRow(rowNo++);
        
        cell = row.createCell(1);
        cell.setCellStyle(headStyle);
        cell.setCellValue("공장");
        
        cell = row.createCell(2);
        cell.setCellStyle(headStyle);
        cell.setCellValue("지역명");
        
        cell = row.createCell(3);
        cell.setCellStyle(headStyle);
        cell.setCellValue("팀명");
        
        cell = row.createCell(4);
        cell.setCellStyle(headStyle);
        cell.setCellValue("사용자");

        cell = row.createCell(5);
        cell.setCellStyle(headStyle);
        cell.setCellValue("사용자ID");

        cell = row.createCell(6);
        cell.setCellStyle(headStyle);
        cell.setCellValue("교육여부");

        cell = row.createCell(7);
        cell.setCellStyle(headStyle);
        cell.setCellValue("사용자의견");
                
        if(eduMapList != null && eduMapList.size() > 0){
            
            for(int i = 0; i < eduMapList.size(); i++){
            	Map<String, Object> map = eduMapList.get(i);
                row = sheet.createRow(rowNo++);
                
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(printIsNull(map, "cls_name"));
                
	            cell = row.createCell(2);
	            cell.setCellStyle(bodyStyle); 
	            cell.setCellValue(printIsNull(map, "loc_name")); //답항
	            
	            cell = row.createCell(3);
	            cell.setCellStyle(bodyStyle);
	            cell.setCellValue(printIsNull(map, "team_name")); //개별답항 카운트
	            
	            cell = row.createCell(4);
	            cell.setCellStyle(bodyStyle);
	            cell.setCellValue(printIsNull(map, "emp_name")); //답항별 투표율

	            cell = row.createCell(5);
	            cell.setCellStyle(bodyStyle);
	            cell.setCellValue(printIsNull(map, "emp_id")); //답항별 투표율
				
				cell = row.createCell(6); 
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "edu_complete")); //답항별 투표율
				
				cell = row.createCell(7); 
				cell.setCellStyle(bodyStyle);
				cell.setCellValue( printIsNull(map, "user_descript")); //답항별 투표율
				
				
			}
        }
        
        
        response.reset();
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=TrainingResultsList.xls");
        
        wb.write(response.getOutputStream());
        wb.close();
        
	}
	
	private String printIsNull(Map<String, Object> map, String key) {
		String rlt = "";
		if(map.get(key) != null) {
			rlt = map.get(key).toString();
		}
		
		return rlt;
	}
	
}
