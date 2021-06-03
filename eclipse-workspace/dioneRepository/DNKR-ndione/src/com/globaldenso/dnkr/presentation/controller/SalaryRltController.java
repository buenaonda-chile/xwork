package com.globaldenso.dnkr.presentation.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
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
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.SalaryService;
import com.globaldenso.dnkr.business.service.SalaryUserService;
import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.constant.Constants;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.google.gson.Gson;

/**
 * 
 * @파일명 : SalaryRltController.java
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
@RequestMapping(value = "/salary")
@ViewId(value = "SALARY")
public class SalaryRltController {

	@Autowired
	private SalaryService salaryService;

	@Autowired
	private SalaryUserService salaryUserService;

	/**
	 * 
	 * @메소드명 : salaryPopup
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육 결과 동의 팝업호출
	 *     </pre>
	 * 
	 * @param request
	 * @param response
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/salaryRltPopup", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView salaryRltPopup(HttpServletRequest request, HttpServletResponse response,
			@CookieValue("locallocale") Optional<String> locale) throws Exception {

		ModelAndView mv = new ModelAndView();

		CommandMap commandMap = new CommandMap();

		if (request.getParameter("edu_pk") == null && request.getParameter("emp_id") == null) {
			commandMap.put("edu_pk", "");
			commandMap.put("emp_id", "");
			commandMap.put("emp_number", "");
		} else {
			commandMap.put("edu_pk", request.getParameter("edu_pk"));
			commandMap.put("emp_id", request.getParameter("emp_id"));
			commandMap.put("emp_number", request.getParameter("emp_number"));
		}

		// 세션 저장된 데이터 불러오기
		EmpDomain empInfo = (EmpDomain) request.getSession().getAttribute("EMP_DOMAIN");
		String userId = empInfo.getEmpId();
		String signId = empInfo.getEmpNumber();

		/*
		 * if (userId != null) { signId = userId.substring(1, userId.length()); }
		 */

		/*
		 * if(!request.getParameter("emp_id").equals(userId)) {
		 * 
		 * return mv; }
		 */

		Map<String, Object> eduAgree = salaryUserService.getSalaryAgree(commandMap);

		mv.addObject("edu_pk", commandMap.get("edu_pk"));
		mv.addObject("userId", userId);
		mv.addObject("signId", signId);
		mv.addObject("agree_title", eduAgree.get("AGREE_TITLE"));

		Map<String, Object> eduMap = salaryUserService.getSalaryUser(commandMap);

		mv.addObject("edu_subject", eduMap.get("EDU_SUBJECT"));
		mv.addObject("start_date", eduMap.get("START_DATE"));
		mv.addObject("emp_type_promotion", eduMap.get("EMP_TYPE_PROMOTION"));
		
		
		Map<String, Object> eduDtlMap = salaryUserService.getSalaryUserInfo(commandMap);

		mv.addObject("salary_amt", toNumFormat(eduDtlMap.get("SALARY_AMT").toString()));
		mv.addObject("salary_kr", eduDtlMap.get("SALARY_KR"));
		mv.addObject("capacity_rt", eduDtlMap.get("CAPACITY_RT"));
		mv.addObject("capacity_amt", toNumFormat(eduDtlMap.get("CAPACITY_AMT").toString()));
		mv.addObject("perfor_rt", eduDtlMap.get("PERFOR_RT"));
		
		if(eduDtlMap.get("PERFOR_AMT") != null) {
			mv.addObject("perfor_amt", toNumFormat(eduDtlMap.get("PERFOR_AMT").toString()));	
		}

		// 오늘 날짜 표시
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy년  MM월  dd일");
		String format_time2 = format2.format(System.currentTimeMillis());

		// 연봉 정보 변환
		String agree = eduAgree.get("AGREE").toString();
		agree = agree.replace("$성명$", eduDtlMap.get("REG_USER").toString());
		agree = agree.replace("$연봉한글$", eduDtlMap.get("SALARY_KR").toString());
		agree = agree.replace("$연봉$", toNumFormat(eduDtlMap.get("SALARY_AMT").toString()));
		agree = agree.replace("$날짜$", format_time2);
		agree = agree.replace("$서명$", "서명 : " + eduDtlMap.get("REG_USER").toString() + "<img src='/images/sign/"+signId+".gif' style='height:50px'/>");
		mv.addObject("agree", agree);
		
		// 사번만 넘김
		mv.addObject("emp_id",commandMap.get("emp_id").toString().subSequence(1, commandMap.get("emp_id").toString().length()));
		mv.setViewName("/dnkr/salary/salaryUserAgreePopup"); // 대상자 지정 팝업

		return mv;
	}
	/**
	 * 숫자에 천단위마다 콤마 넣기
	 * 
	 * @param int
	 * @return String
	 */
	public static String toNumFormat(String num) {

		// 연봉 콤마 처리
		String returnAmt = "0";
		DecimalFormat df = new DecimalFormat("#,###");
		
		try {
			if(num != null) {
				if(num.matches("[0-9]+")) {
					returnAmt = df.format(Integer.parseInt(num));
				}
			}
		} catch (NumberFormatException e) {
		}
		return returnAmt;
	}

	/**
	 * 
	 * @메소드명 : salary
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
	@RequestMapping(value = "/salaryRlt", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView salary(HttpServletRequest request, HttpServletResponse response,
			@CookieValue("locallocale") Optional<String> locale) throws Exception {

		ModelAndView mv = new ModelAndView();

		// 저장된 세션 데이터 불러오기
		EmpDomain empInfo = (EmpDomain) request.getSession().getAttribute("EMP_DOMAIN");
		String userId = empInfo.getEmpId();
		String empNumber = empInfo.getEmpNumber();
		String userName = empInfo.getEmpName();

		mv.addObject("user_id", userId);
		mv.addObject("emp_number", empNumber);
		mv.addObject("user_name", userName);

		mv.setViewName("/dnkr/salary/salaryRltList"); // 외부업체용

		return mv;
	}

	/**
	 * 
	 * @메소드명 : salary
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
	@RequestMapping(value = "/salaryInfoUpload", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView salaryInfoUpload(HttpServletRequest request, HttpServletResponse response,
			@CookieValue("locallocale") Optional<String> locale) throws Exception {

		ModelAndView mv = new ModelAndView();

		// 저장된 세션 데이터 불러오기
		EmpDomain empInfo = (EmpDomain) request.getSession().getAttribute("EMP_DOMAIN");
		String userId = empInfo.getEmpId();
		String userName = empInfo.getEmpName();
		String edu_pk = request.getParameter("edu_pk");

		mv.addObject("user_id", userId);
		mv.addObject("user_name", userName);
		mv.addObject("edu_pk", edu_pk);

		salaryService.saveAmountExcelInfo(edu_pk, userName);

		mv.setViewName("/dnkr/salary/salaryRltDtlList"); // 외부업체용

		return mv;
	}

	/**
	 * 
	 * @메소드명 : getSalaryList
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
	@RequestMapping(value = "/salaryRltList", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public JsonView salaryRltList(HttpServletRequest request, HttpServletResponse response)
			throws ApplicationException, UnsupportedEncodingException {

		String rtnJson; // return Json
		JsonView jv = new JsonView();

		try {

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

			rtnJson = new Gson().toJson(salaryService.getSalaryRltList(commandMap));

			jv.addStaticAttribute("jsonString", rtnJson);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return jv;
	}

	/**
	 * 
	 * @메소드명 : salary
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
	@RequestMapping(value = "/salaryRltDtl", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView salaryRltDtl(HttpServletRequest request, HttpServletResponse response,
			@CookieValue("locallocale") Optional<String> locale) throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.addObject("edu_pk", request.getParameter("edu_pk"));
		mv.setViewName("/dnkr/salary/salaryRltDtlList"); // 외부업체용

		return mv;
	}

	/**
	 * 
	 * @메소드명 : salaryDetail
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
	@RequestMapping(value = "/salaryRltDtlList", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json")
	public JsonView getSalaryRltDtlList(HttpServletRequest request, HttpServletResponse response)
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
		rtnJson = new Gson().toJson(salaryService.getSalaryDtlRltList(commandMap));

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
	@RequestMapping(value = "/salaryRltListExcel.do", method = { RequestMethod.GET })
	@ErrorBack(viewName = "forward:init.do")
	public void salaryRltListExcel(HttpServletResponse response, HttpServletRequest request) throws Exception {

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
		Map<String, Object> eduMap = (Map<String, Object>) salaryService.getSalaryDtlRltList(commandMap);

		List<Map<String, Object>> eduMapList = (List<Map<String, Object>>) eduMap.get("rows");

		Map<String, Object> eduInfo = (Map<String, Object>) salaryService.getSalary(commandMap);

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Annual Income");
		Row row = null;
		Cell cell = null;
		int rowNo = 1;

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

		String[] mainTitleArr = { "제목" };
		String[] mainValueArr = { eduInfo.get("SUBJECT").toString() };

		for (int i = 0; i < mainTitleArr.length; i++) {
			sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 2, 4));
			row = sheet.createRow(rowNo++);
			cell = row.createCell(1);
			cell.setCellStyle(titleStyle);
			cell.setCellValue(mainTitleArr[i]);
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(mainValueArr[i]);
			for (int j = 3; j < 5; j++) {
				cell = row.createCell(j);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue("");
			}
		}

		row = sheet.createRow(rowNo++);

		row = sheet.createRow(rowNo++);

		cell = row.createCell(1);
		cell.setCellStyle(titleStyle);
		cell.setCellValue("공장");

		cell = row.createCell(2);
		cell.setCellStyle(titleStyle);
		cell.setCellValue("지역명");

		cell = row.createCell(3);
		cell.setCellStyle(titleStyle);
		cell.setCellValue("팀명");

		cell = row.createCell(4);
		cell.setCellStyle(titleStyle);
		cell.setCellValue("사용자");

		cell = row.createCell(5);
		cell.setCellStyle(titleStyle);
		cell.setCellValue("사용자ID");

		cell = row.createCell(6);
		cell.setCellStyle(titleStyle);
		cell.setCellValue("사번");

		cell = row.createCell(7);
		cell.setCellStyle(titleStyle);
		cell.setCellValue("직급");

		cell = row.createCell(8);
		cell.setCellStyle(titleStyle);
		cell.setCellValue("체결여부");

		cell = row.createCell(9);
		cell.setCellStyle(headStyle);
		cell.setCellValue("연봉");

		cell = row.createCell(10);
		cell.setCellStyle(headStyle);
		cell.setCellValue("연봉(한글)");

		cell = row.createCell(11);
		cell.setCellStyle(headStyle);
		cell.setCellValue("역량평가");

		cell = row.createCell(12);
		cell.setCellStyle(headStyle);
		cell.setCellValue("승급액");

		cell = row.createCell(13);
		cell.setCellStyle(headStyle);
		cell.setCellValue("업적평가");

		cell = row.createCell(14);
		cell.setCellStyle(headStyle);
		cell.setCellValue("지급액");

		if (eduMapList != null && eduMapList.size() > 0) {

			for (int i = 0; i < eduMapList.size(); i++) {
				Map<String, Object> map = eduMapList.get(i);
				row = sheet.createRow(rowNo++);

				cell = row.createCell(1);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "cls_name"));

				cell = row.createCell(2);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "loc_name")); // 답항

				cell = row.createCell(3);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "team_name")); // 개별답항 카운트

				cell = row.createCell(4);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "emp_name")); // 답항별 투표율

				cell = row.createCell(5);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "emp_id")); // 답항별 투표율

				cell = row.createCell(6);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "emp_number")); // 사번

				cell = row.createCell(7);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "emp_step_nm")); // 직급

				cell = row.createCell(8);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "edu_complete")); // 답항별 투표율

				cell = row.createCell(9);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "salary_amt")); // 연봉금액(숫자)

				cell = row.createCell(10);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "salary_kr")); // 연봉금액(한글)

				cell = row.createCell(11);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "capacity_rt")); // 발휘능력 등급

				cell = row.createCell(12);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "capacity_amt")); // 발휘능력 금액

				cell = row.createCell(13);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "perfor_rt")); // 개인업적평가 등급

				cell = row.createCell(14);
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "perfor_amt")); // 개인업적평가 금액

			}
		}
		response.reset();
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=Annual Income.xlsx");
		wb.write(response.getOutputStream());
		wb.close();

	}

	/**
	 * 메일 전송 미완료자 전체에게 <리마인드 메일 발송>
	 * 
	 * @param response HttpServletResponse
	 * @param request  HttpServletRequest
	 * @throws InterruptedException
	 * @throws Exception
	 */
	@RequestMapping(value = "/mailSend.do", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonView mailSend(HttpServletRequest request, HttpServletResponse response, Map<String, String> proMap)
			throws ApplicationException, UnsupportedEncodingException, InterruptedException {

		String rtnJson;

		// 교육 PK
		String edu_pk = request.getParameter("edu_pk");

		// 교육대상자중 미완료자 메일 취득
		List<Map<String, Object>> getNoSalaryMailList = salaryService.getNoSalaryMailList(edu_pk);

		// System.out.println("교육대상자중 미완료자 메일 취득수 : " + getNoSalaryMailList.size());

		// 메일전송수
		int mailSendSuccess = 0;

		// 메일이 있는경우, 메일 전송
		if (getNoSalaryMailList != null && getNoSalaryMailList.size() > 0) {

			for (int i = 0; i < getNoSalaryMailList.size(); i++) {
				Map<String, Object> map = getNoSalaryMailList.get(i);

				// 설정값 셋팅
				setProp(proMap);

				// 메일 전송
				// System.out.println("Mail전송");

				// 네이버일 경우 smtp.naver.com 을 입력합니다.
				// Google일 경우 smtp.gmail.com 을 입력합니다.
				String host = proMap.get("mail.smtp.host");
				final String username = proMap.get("mail.smtp.username"); // 네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요.
				final String password = proMap.get("mail.smtp.password"); // 네이버 이메일 비밀번호를 입력해주세요.
				int port = Integer.parseInt(proMap.get("mail.smtp.port")); // 포트번호

				// 메일 내용
				String recipient = (String) map.get("emp_email"); // 받는 사람의 메일주소를 입력해주세요.
				// System.out.println("메일주소 : " + recipient);

				String subject = "회람교육 안내 메일"; // 메일 제목 입력해주세요.

				String body = readTemplate(proMap.get("mail.template")); // 메일 내용 입력해주세요.
				// System.out.println("body : " + body);

				Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성

				// SMTP 서버 정보 설정
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", port);
				props.put("mail.smtp.auth", proMap.get("mail.smtp.auth"));
				props.put("mail.smtp.ssl.enable", proMap.get("mail.smtp.ssl.enable"));
				props.put("mail.smtp.ssl.trust", host);

				// Session 생성
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					String un = username;
					String pw = password;

					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(un, pw);
					}
				});

				session.setDebug(true); // for debug
				Message mimeMessage = new MimeMessage(session); // MimeMessage 생성

				try {
					mimeMessage.setFrom(new InternetAddress(proMap.get("mail.smtp.sender")));
					// 발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); // 수신자셋팅 //.TO
																										// 외에 .CC(참조)
																										// .BCC(숨은참조) 도
																										// 있음

					// mimeMessage.setSubject(subject); //제목셋팅
					mimeMessage.setSubject(MimeUtility.encodeText(subject, "EUC-KR", "B"));
					mimeMessage.setContent(body, "text/html; charset=EUC-KR");

					Transport.send(mimeMessage); // javax.mail.Transport.send() 이용

					// Thread.sleep(2000);
					// 메일 전송 수
					mailSendSuccess = mailSendSuccess + 1;

					// System.out.println("완료 메일전송 수 : " + mailSendSuccess);

				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// 교육 미완료자 수
		map.put("getNoSalaryMailList", getNoSalaryMailList.size());
		// 메일 전송수
		map.put("mailSendSuccess", mailSendSuccess);
		rtnJson = new Gson().toJson(map);

		JsonView jv = new JsonView();
		jv.addStaticAttribute("jsonString", rtnJson);

		return jv;

	}

	/**
	 * 이 메소드는 프로퍼티 파일을 스트림으로 읽어 들여 멤버 변수의 프로퍼티에 적재합니다.
	 *
	 * @param path
	 * @throws IOException
	 */
	public Properties loadProp(String path) throws IOException {

		Properties properties = new Properties();

		InputStream inputStream = getClass().getResourceAsStream(path);

		properties.load(inputStream);
		inputStream.close();

		return properties;
	}

	/** 설정값 셋팅 */
	private void setProp(Map<String, String> proMap) {

		try {

			// System.out.println("Start");

			String propertiesPath = UxisCmmUtil.class.getResource("").getPath().substring(0,
					UxisCmmUtil.class.getResource("").getPath().lastIndexOf("com")) + "mailConfigDefault.properties";

			FileInputStream fis = null;
			Properties props = new Properties();

			String returnValue = propertiesPath;
			if (returnValue == null || returnValue.trim().equals("")) {
			} else {
				returnValue = returnValue.replaceAll("\\.\\./", ""); // ../
				returnValue = returnValue.replaceAll("\\.\\.\\\\", ""); // ..\
			}

			fis = new FileInputStream(returnValue);

			props.load(new BufferedInputStream(fis));

			proMap.put("mail.template", String.valueOf(props.get("mail.template")));

			proMap.put("mail.smtp.host", String.valueOf(props.get("mail.smtp.host")));
			proMap.put("mail.smtp.port", String.valueOf(props.get("mail.smtp.port")));
			proMap.put("mail.smtp.username", String.valueOf(props.get("mail.smtp.username")));
			proMap.put("mail.smtp.password", String.valueOf(props.get("mail.smtp.password")));
			proMap.put("mail.smtp.auth", String.valueOf(props.get("mail.smtp.auth")));
			proMap.put("mail.smtp.ssl.enable", String.valueOf(props.get("mail.smtp.ssl.enable")));
			proMap.put("mail.smtp.sender", String.valueOf(props.get("mail.smtp.sender")));

		} catch (IOException e) {
			// System.out.println("설정파일 로드 실패");
			e.printStackTrace();
		}

	}

	// 메일 템플렛 취득
	private static String readTemplate(String _FILE_NAME) {

		StringBuilder rtnVal = new StringBuilder();

		File file = new File(_FILE_NAME);
		if (file == null || !file.exists()) {
			// System.out.println ("File Not Exists: template_email_salary.txt");
			return rtnVal.toString();
		}

		try {
			BufferedReader buf_reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(_FILE_NAME), "UTF8"));

			do {
				String line = buf_reader.readLine();
				if (line != null)
					rtnVal.append(line + "\r\n");
				else
					break;
			} while (true);
			buf_reader.close();

		} catch (IOException e) {
			// System.out.println ("IO exception =" + e );
			return rtnVal.toString();
		}

		return rtnVal.toString();
	}

	private String printIsNull(Map<String, Object> map, String key) {
		String rlt = "";
		if (map.get(key) != null) {
			rlt = map.get(key).toString();
		}

		return rlt;
	}

}
