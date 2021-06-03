package com.globaldenso.dnkr.presentation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

@Controller
public class FileController {

	/**
	 * 
	 * @메소드명	: getFileDownload
	 * @날짜		: 2019. 5. 31.
	 * @작성자		: Cho HeumJun
	 * @설명
	 * <pre>
	 *		Form 양식 다운로드 Controller
	 * </pre>
	 * @param commandMap
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/fileDownload", produces="text/plain;charset=UTF-8")
	public void getFileDownload(HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		CommandMap commandMap = new CommandMap();
		request.setCharacterEncoding("utf-8");
		Enumeration<?> enumeration = request.getParameterNames();
		
		// 모든 파라미터를 commandMap에 담는다.
		String key = null;
		String[] values = null;
		while (enumeration.hasMoreElements())
		{
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if (values != null)
			{
				commandMap.put(key, (values.length > 1) ? values : values[0]);
			}
		}
		
		String fileName = (String) commandMap.get("fileName");
		String orgFileName = (String) commandMap.get("org_file_name");
		//String path = request.getSession().getServletContext().getRealPath("/formDownload");
		//String uploadDir = "D:\\TEST\\";
		String path = UxisCmmUtil.getProperty("edu.uploadpath");
		
		// 한글파일명 깨지지 않도록
		String docName = URLEncoder.encode(orgFileName, "UTF-8").replaceAll("\\+", "%20");

		response.setHeader("Content-Disposition", "attachment;filename=" + docName + ";");
		response.setContentType("text/plain");
		
		File down_file = new File(path + fileName); // 파일 생성
		FileInputStream fileIn = new FileInputStream(down_file); // 파일 읽어오기
		// ByteStreams.copy(fileIn, response.getOutputStream());
//			response.flushBuffer();
			
		ServletOutputStream out = response.getOutputStream();
		
		byte[] outputByte = new byte[4096];		
		//copy binary contect to output stream
		while(fileIn.read(outputByte, 0, 4096) != -1){
			out.write(outputByte, 0, 4096);
		}
		
		fileIn.close();
		out.flush();
		out.close();

	}
	
}