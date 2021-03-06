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
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.google.gson.Gson;


/**
 * 
 * @????????? : EduRltController.java
 * @???????????? : DNKR
 * @?????? : 2019. 9. 25.
 * @????????? : Cho HeumJun
 * @??????
 * 
 *     <pre>
 * 		????????? ?????? Controller
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
	 * @????????????	: eduPopup
	 * @??????		: 2019. 9. 20.
	 * @?????????		: Cho HeumJun
	 * @??????
	 * <pre>
	 *		?????? ?????? ?????? ????????????
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
		// ????????? ??????
		mv.addObject("emp_id", commandMap.get("emp_id").toString().subSequence(1, commandMap.get("emp_id").toString().length()));
        mv.setViewName("/dnkr/edu/eduRltPopup");   // ????????? ?????? ??????
        
        return mv;
	}
	
	/**
	 * 
	 * @???????????? : edu
	 * @?????? : 2019. 9. 20.
	 * @????????? : Cho HeumJun
	 * @??????
	 * 
	 *     <pre>
	 *		???????????? ???????????? ??????
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
		

		// ????????? ?????? ????????? ????????????
		EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");
        String userId = empInfo.getEmpId();
        String userName = empInfo.getEmpName();
        
        mv.addObject("user_id", userId);
        mv.addObject("user_name", userName);

		mv.setViewName("/dnkr/edu/eduRltList"); // ???????????????

		return mv;
	}

	/**
	 * 
	 * @???????????? : getEduList
	 * @?????? : 2019. 9. 20.
	 * @????????? : Cho HeumJun
	 * @??????
	 * 
	 *     <pre>
	 *		???????????? ?????????
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
	
			// ?????? ??????????????? commandMap??? ?????????.
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
	 * @???????????? : edu
	 * @?????? : 2019. 9. 20.
	 * @????????? : Cho HeumJun
	 * @??????
	 * 
	 *     <pre>
	 *		???????????? ???????????? ??????
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
		mv.setViewName("/dnkr/edu/eduRltDtlList"); // ???????????????

		return mv;
	}

	/**
	 * 
	 * @???????????? : eduDetail
	 * @?????? : 2019. 9. 20.
	 * @????????? : Cho HeumJun
	 * @??????
	 * 
	 *     <pre>
	 *		?????? ?????? ?????? ??????
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

			// ????????? ?????? ?????? ?????? ??????
			Enumeration<?> enumeration = request.getParameterNames();

			// ?????? ??????????????? commandMap??? ?????????.
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
	 * [KO] ???????????? ?????? - ?????? ????????????
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
        
        String[] mainTitleArr = {"??????"};
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
        cell.setCellValue("??????");
        
        cell = row.createCell(2);
        cell.setCellStyle(headStyle);
        cell.setCellValue("?????????");
        
        cell = row.createCell(3);
        cell.setCellStyle(headStyle);
        cell.setCellValue("??????");
        
        cell = row.createCell(4);
        cell.setCellStyle(headStyle);
        cell.setCellValue("?????????");

        cell = row.createCell(5);
        cell.setCellStyle(headStyle);
        cell.setCellValue("?????????ID");
        
        cell = row.createCell(6);
        cell.setCellStyle(headStyle);
        cell.setCellValue("??????");
        
        cell = row.createCell(7);
        cell.setCellStyle(headStyle);
        cell.setCellValue("??????");
        
        cell = row.createCell(8);
        cell.setCellStyle(headStyle);
        cell.setCellValue("????????????");

        cell = row.createCell(9);
        cell.setCellStyle(headStyle);
        cell.setCellValue("???????????????");
        

        if(eduMapList != null && eduMapList.size() > 0){
            
            for(int i = 0; i < eduMapList.size(); i++){
            	Map<String, Object> map = eduMapList.get(i);
                row = sheet.createRow(rowNo++);
                
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(printIsNull(map, "cls_name"));
                
	            cell = row.createCell(2);
	            cell.setCellStyle(bodyStyle); 
	            cell.setCellValue(printIsNull(map, "loc_name")); //??????
	            
	            cell = row.createCell(3);
	            cell.setCellStyle(bodyStyle);
	            cell.setCellValue(printIsNull(map, "team_name")); //???????????? ?????????
	            
	            cell = row.createCell(4);
	            cell.setCellStyle(bodyStyle);
	            cell.setCellValue(printIsNull(map, "emp_name")); //????????? ?????????

	            cell = row.createCell(5);
	            cell.setCellStyle(bodyStyle);
	            cell.setCellValue(printIsNull(map, "emp_id")); //????????? ?????????
				
	            cell = row.createCell(6); 
				cell.setCellStyle(bodyStyle);
				cell.setCellValue( printIsNull(map, "emp_number")); //??????
				
				cell = row.createCell(7); 
				cell.setCellStyle(bodyStyle);
				cell.setCellValue( printIsNull(map, "emp_step_nm")); //??????
			
				cell = row.createCell(8); 
				cell.setCellStyle(bodyStyle);
				cell.setCellValue(printIsNull(map, "edu_complete")); //????????? ?????????
				
				cell = row.createCell(9); 
				cell.setCellStyle(bodyStyle);
				cell.setCellValue( printIsNull(map, "user_descript")); //????????? ?????????
			}
        }
        
        
        response.reset();
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=TrainingResultsList.xls");
        
        wb.write(response.getOutputStream());
        wb.close();
        
	}
	
	/**
	 * ?????? ??????
	 * ???????????? ???????????? <???????????? ?????? ??????> 
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
		
		// ?????? PK
		String edu_pk = request.getParameter("edu_pk");
		
		// ?????????????????? ???????????? ?????? ??????
		List<Map<String, Object>> getNoEduMailList = eduService.getNoEduMailList(edu_pk);
		
		//System.out.println("?????????????????? ???????????? ?????? ????????? : " + getNoEduMailList.size());
		
		// ???????????????
		int mailSendSuccess = 0;
		
		// ????????? ????????????, ?????? ??????
		if(getNoEduMailList != null && getNoEduMailList.size() > 0){
            
            for(int i = 0; i < getNoEduMailList.size(); i++){
            	Map<String, Object> map = getNoEduMailList.get(i);
            	
            	// ????????? ??????
        		setProp(proMap);
        		
        		
        		// ?????? ??????
        		//System.out.println("Mail??????");

        		// ???????????? ?????? smtp.naver.com ??? ???????????????.
        		// Google??? ?????? smtp.gmail.com ??? ???????????????.
        		 String host = proMap.get("mail.smtp.host");
        		 final String username = proMap.get("mail.smtp.username"); //????????? ???????????? ??????????????????. @nave.com??? ???????????? ????????????.
        		 final String password = proMap.get("mail.smtp.password"); //????????? ????????? ??????????????? ??????????????????.
        		 int port=Integer.parseInt(proMap.get("mail.smtp.port")); //????????????

        		 //?????? ??????
        		 String recipient = (String) map.get("emp_email"); //?????? ????????? ??????????????? ??????????????????.
        		 //System.out.println("???????????? : " + recipient);
        		 
        		 String subject = "???????????? ?????? ??????"; //?????? ?????? ??????????????????.
        		 		 
        		 String body = readTemplate(proMap.get("mail.template")); //?????? ?????? ??????????????????.
        		 //System.out.println("body : " + body);
        		 
        		 Properties props = System.getProperties(); // ????????? ?????? ?????? ?????? ??????

        		 //SMTP ?????? ?????? ??????
        		 props.put("mail.smtp.host", host);
        		 props.put("mail.smtp.port", port);
        		 props.put("mail.smtp.auth", proMap.get("mail.smtp.auth"));
        		 props.put("mail.smtp.ssl.enable", proMap.get("mail.smtp.ssl.enable"));
        		 props.put("mail.smtp.ssl.trust", host);	
        		 
        		 //Session ??????
        		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
        			 String un=username;
        			 String pw=password;
        			 protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
        			 	return new javax.mail.PasswordAuthentication(un, pw);
        			 }
        		 });

        		 session.setDebug(true); //for debug
        		 Message mimeMessage = new MimeMessage(session); //MimeMessage ??????
        		 
				 try {
					 mimeMessage.setFrom(new InternetAddress(proMap.get("mail.smtp.sender")));
					 //????????? ?????? , ????????? ????????? ?????????????????? ?????? ??? ???????????????. ????????? ????????? ??? ????????? ??? ??????????????????.
					 mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //??????????????? //.TO ?????? .CC(??????) .BCC(????????????) ??? ??????
	
					 //mimeMessage.setSubject(subject); //????????????
					 mimeMessage.setSubject(MimeUtility.encodeText(subject, "EUC-KR", "B"));
					 mimeMessage.setContent(body, "text/html; charset=EUC-KR");
					 
					 Transport.send(mimeMessage); //javax.mail.Transport.send() ??????
					 
					 //Thread.sleep(2000);
					 // ?????? ?????? ???
					 mailSendSuccess = mailSendSuccess + 1;
					 
					 //System.out.println("?????? ???????????? ??? : " + mailSendSuccess);
					 
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
		
		// ?????? ???????????? ???
		map.put("getNoEduMailList",getNoEduMailList.size());
		// ?????? ?????????
		map.put("mailSendSuccess", mailSendSuccess);
		rtnJson = new Gson().toJson(map);
				
		JsonView jv = new JsonView();
		jv.addStaticAttribute("jsonString", rtnJson);
		
		return jv;

	}
	

	
	/**
	 * ??? ???????????? ???????????? ????????? ??????????????? ?????? ?????? ?????? ????????? ??????????????? ???????????????.
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
	
	/** ????????? ?????? */
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
			//System.out.println("???????????? ?????? ??????");
			e.printStackTrace();
		}

	}
	
	// ?????? ????????? ??????
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
