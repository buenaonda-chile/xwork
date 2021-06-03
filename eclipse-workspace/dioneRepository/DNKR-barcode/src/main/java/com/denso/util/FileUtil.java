package com.denso.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	private FileOutputStream fos;
	
	/**
	 * 첨부파일등록
	 * @param file
	 * @param path
	 */
	public String writeFile(MultipartFile file, String path){
		return writeFile(file, path, 0, null);
	}
	
	/**
	 * 첨부파일등록
	 * @param file
	 * @param path
	 * @param limitFileSize
	 */
	public String writeFile(MultipartFile file, String path, long limitFileSize){
		return writeFile(file, path, limitFileSize, null);
	}
	
	/**
	 * 첨부파일등록
	 * @param file
	 * @param path
	 * @param limitFileSize
	 * @param availableFileExt
	 */
    public String writeFile(MultipartFile file, String path, long limitFileSize, ArrayList<String> availableFileExt){
    	String fileName = file.getName();
    	String originFileName = file.getOriginalFilename();
    	String contentType = file.getContentType();
    	long fileSize = file.getSize();
    	
    	//사용될 이름세팅
    	UUID usingFileName = UUID.randomUUID();
    	
    	//파일용량체크
    	if(limitFileSize > 0){
    		if(fileSize > limitFileSize){
    			try {
					throw new Exception("## 파일용량초과 :: "+fileSize);
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    	}
    	
    	String fileExt = originFileName.substring(originFileName.lastIndexOf(".") + 1).toLowerCase(); //대문자 들어올시 소문자로 치환
    	//파일 확장자체크
    	if(availableFileExt != null && availableFileExt.size() > 0){
    		if(!availableFileExt.contains(fileExt)){
    			try {
					throw new Exception("## 사용불가확장자 :: " + fileExt);
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    	}
    	
    	String changedFileName= usingFileName+"."+fileExt;
    	
    	InputStream inputStream = null;
    	OutputStream outputStream = null;
    	
    	try{
    		if(fileSize > 0){
    			inputStream = file.getInputStream();
    			File realUploadDir = new File(path);
    			System.out.println(realUploadDir.exists());
    			if(!realUploadDir.exists()){
    				realUploadDir.mkdirs();
    			}
    			
    			String organizedFilePath = path + "/" + changedFileName;
    			outputStream = new FileOutputStream(organizedFilePath);
    			
    			int readBytes = 0;
    			byte[] buffer = new byte[8192];
    			
    			while((readBytes = inputStream.read(buffer, 0, 8192)) != -1){
    				outputStream.write(buffer, 0, readBytes);
    			}
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		if(outputStream != null){
    			try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    		
    		if(inputStream != null){
    			try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	}
    	
    	return changedFileName;
    }
    
    public void fileMove(String inFileName, String outFileName) {
    	try {
    		FileInputStream fis = new FileInputStream(inFileName);
    		FileOutputStream fos = new FileOutputStream(outFileName);
   
    		int data = 0;
    		while((data=fis.read())!=-1) {
    			fos.write(data);
    		}
    		
    		fis.close();
    		fos.close();
   
    		//복사한뒤 원본파일을 삭제함
    		fileDelete(inFileName);
   
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }
    
    //파일을 삭제하는 메소드
    public void fileDelete(String deleteFileName) {
    	File I = new File(deleteFileName);
    	I.delete();
    }
}
