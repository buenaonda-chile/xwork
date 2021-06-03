package com.globaldenso.dnkr.presentation.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.EduService;
import com.globaldenso.dnkr.business.service.EduUserService;
import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.constant.Constants;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
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
	
			
			rtnJson = new Gson().toJson(eduService.getEduRltList(commandMap));
		
			jv.addStaticAttribute("jsonString", rtnJson);
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

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
        cell.setCellValue("사번");
        
        cell = row.createCell(7);
        cell.setCellStyle(headStyle);
        cell.setCellValue("직급");
        
        cell = row.createCell(8);
        cell.setCellStyle(headStyle);
        cell.setCellValue("교육여부");

        cell = row.createCell(9);
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
				cell.setCellValue( printIsNull(map, "emp_number")); //사번
				
				cell = row.createCell(7); 
				cell.setCellStyle(bodyStyle);
				cell.setCellValue( printIsNull(map, "emp_step_nm")); //직급
			
				cell = row.createCell(8); 
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "edu_complete")); //답항별 투표율
				
				cell = row.createCell(9); 
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
	
	/**
	 * 메일 전송
	 * 미완료자 전체에게 <리마인드 메일 발송> 
	 * 
	 * @param response HttpServletResponse
	 * @param request  HttpServletRequest
	 * @throws InterruptedException 
	 * @throws Exception
	 */
	@RequestMapping(value = "/mailSend.do", method = {RequestMethod.GET, RequestMethod.POST})
	public JsonView mailSend(HttpServletRequest request, HttpServletResponse response, Map<String,String> proMap)
			throws ApplicationException, UnsupportedEncodingException, InterruptedException {	
		
		String rtnJson;
		
		// 교육 PK
		String edu_pk = request.getParameter("edu_pk");
		
		// 교육대상자중 미완료자 메일 취득
		List<Map<String, Object>> getNoEduMailList = eduService.getNoEduMailList(edu_pk);
		
		//System.out.println("교육대상자중 미완료자 메일 취득수 : " + getNoEduMailList.size());
		
		// 메일전송수
		int mailSendSuccess = 0;
		
		// 메일이 있는경우, 메일 전송
		if(getNoEduMailList != null && getNoEduMailList.size() > 0){
            
            for(int i = 0; i < getNoEduMailList.size(); i++){
            	Map<String, Object> map = getNoEduMailList.get(i);
            	
            	// 설정값 셋팅
        		setProp(proMap);
        		
        		
        		// 메일 전송
        		//System.out.println("Mail전송");

        		// 네이버일 경우 smtp.naver.com 을 입력합니다.
        		// Google일 경우 smtp.gmail.com 을 입력합니다.
        		 String host = proMap.get("mail.smtp.host");
        		 final String username = proMap.get("mail.smtp.username"); //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요.
        		 final String password = proMap.get("mail.smtp.password"); //네이버 이메일 비밀번호를 입력해주세요.
        		 int port=Integer.parseInt(proMap.get("mail.smtp.port")); //포트번호

        		 //메일 내용
        		 String recipient = (String) map.get("emp_email"); //받는 사람의 메일주소를 입력해주세요.
        		 //System.out.println("메일주소 : " + recipient);
        		 
        		 String subject = "회람교육 안내 메일"; //메일 제목 입력해주세요.
        		 		 
        		 String body = readTemplate(proMap.get("mail.template")); //메일 내용 입력해주세요.
        		 //System.out.println("body : " + body);
        		 
        		 Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성

        		 //SMTP 서버 정보 설정
        		 props.put("mail.smtp.host", host);
        		 props.put("mail.smtp.port", port);
        		 props.put("mail.smtp.auth", proMap.get("mail.smtp.auth"));
        		 props.put("mail.smtp.ssl.enable", proMap.get("mail.smtp.ssl.enable"));
        		 props.put("mail.smtp.ssl.trust", host);	
        		 
        		 //Session 생성
        		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
        			 String un=username;
        			 String pw=password;
        			 protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
        			 	return new javax.mail.PasswordAuthentication(un, pw);
        			 }
        		 });

        		 session.setDebug(true); //for debug
        		 Message mimeMessage = new MimeMessage(session); //MimeMessage 생성
        		 
				 try {
					 mimeMessage.setFrom(new InternetAddress(proMap.get("mail.smtp.sender")));
					 //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요.
					 mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
	
					 //mimeMessage.setSubject(subject); //제목셋팅
					 mimeMessage.setSubject(MimeUtility.encodeText(subject, "EUC-KR", "B"));
					 mimeMessage.setContent(body, "text/html; charset=EUC-KR");
					 
					 Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
					 
					 //Thread.sleep(2000);
					 // 메일 전송 수
					 mailSendSuccess = mailSendSuccess + 1;
					 
					 //System.out.println("완료 메일전송 수 : " + mailSendSuccess);
					 
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
		map.put("getNoEduMailList",getNoEduMailList.size());
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
	private void setProp(Map<String,String> proMap) {

		try {

			//System.out.println("Start");
			
			String propertiesPath = UxisCmmUtil.class.getResource("").getPath().substring(0, UxisCmmUtil.class.getResource("").getPath().lastIndexOf("com")) 
			            + "mailConfigDefault.properties";

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
			//System.out.println("설정파일 로드 실패");
			e.printStackTrace();
		}

	}
	
	// 메일 템플렛 취득
	private static String readTemplate(String _FILE_NAME) {
	       
        StringBuilder rtnVal = new StringBuilder();

        File file = new File ( _FILE_NAME );
        if (file == null || !file.exists ()) {
          //System.out.println ("File Not Exists: template_email_salary.txt");
          return rtnVal.toString();
        }

        try {
          BufferedReader buf_reader = new BufferedReader(new InputStreamReader(new FileInputStream(_FILE_NAME),"UTF8"));

          do {
             String line = buf_reader.readLine();
             if (line != null)
                 rtnVal.append(line+"\r\n");
             else
                 break;
          } while (true);
          buf_reader.close ();

        }
        catch (IOException e) {
            //System.out.println ("IO exception =" + e );
              return rtnVal.toString();
        }

        return rtnVal.toString();
    }

	
	
	private String printIsNull(Map<String, Object> map, String key) {
		String rlt = "";
		if(map.get(key) != null) {
			rlt = map.get(key).toString();
		}
		
		return rlt;
	}
	
}
