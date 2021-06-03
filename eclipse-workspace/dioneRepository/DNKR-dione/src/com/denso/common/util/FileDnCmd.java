package com.denso.common.util;

import javax.servlet.http.HttpServlet;
import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.denso.common.TextUtil;

public class FileDnCmd extends HttpServlet { 
	/**
	 * 
	 */
	
   public void init(ServletConfig config) throws ServletException     {
	        super.init(config);
	    }


	public void doGet(HttpServletRequest req, HttpServletResponse res )  throws ServletException, IOException  {		
		String file_path = req.getParameter("file_path");
		String file_name = req.getParameter("file_name");
		String file_id = req.getParameter("file_id");
		if(file_path.equals("AD")){
			//file_path = req.getRealPath("/")+ "/upload/AD/";
			file_path = "E:/mis_attach_files/ad_files/";
		}else if(file_path.equals("OP")){
			file_path = req.getRealPath("/")+ "/upload/OP/";		
		}else if(file_path.equals("RT")){
			file_path = req.getRealPath("/")+ "/upload/RT/";		
		}else if(file_path.equals("MP")){
			file_path = req.getRealPath("/")+ "/upload/MP/";		
		}
		System.out.println("filepath"+ file_path);
		try{
			downFile(req, res, file_path, file_id, file_name);
		}catch(Exception e){
			
		}
	}

	/**
	* 
	* Method Name : <br>
	* Method Description :
	* @param req
	* @param res
	* @param filePath
	* @param file_id
	* @param file_name
	* @throws Exception
	*/
	private void downFile(HttpServletRequest req, HttpServletResponse res, String file_path ,String file_id,  String file_name) throws Exception{
		System.out.println(file_path);
		System.out.println(file_id);
		System.out.println(file_name);
		File file = null;
		BufferedInputStream fin = null;
		BufferedOutputStream outs = null;
	try {

		file = new File(file_path + "\\" + file_id);
	    // ���� ����
	    int filelength = (int) file.length();
	    byte[] bytestream = new byte[2048];
	    int read = 0;
	    
	    if(!file.exists()){
	    	throw new Exception("mis.file.noexist");
	    }
		
	    fin = new BufferedInputStream(new FileInputStream(file));
	    outs = new BufferedOutputStream(res.getOutputStream());
	    
	
		String clientHead = req.getHeader("User-Agent");
		
		res.setContentLength(filelength);
		if (clientHead.indexOf("MSIE 5.5") > -1)
		{			
			res.setContentType("application/x-filler; charset=EUC-KR");
			res.setHeader("Content-Type", "doesn/matter;");
			res.setHeader("Content-Disposition", "filename=\"" + file_name + "\";");
		}
		else
		{
			res.setHeader("Content-Type", "application/octet-stream;");
			res.setHeader("Content-Disposition", "attachment;filename=\"" + file_name + "\";");
		}
		res.setHeader ("Content-Length", "" + filelength);
	
	    //try {
		if(filelength>0) {
			while ((read = fin.read(bytestream)) != -1) {
				outs.write(bytestream, 0, read);
			}
		}
	    
	    //close
	    outs.close();
	    fin.close();
	} catch (Exception e) {
		
	} finally {
		if(outs != null) { try { outs.close(); } catch(Exception e) {} }
		if(fin != null) { try { fin.close(); } catch(Exception e) {} }
	}
}
	
}