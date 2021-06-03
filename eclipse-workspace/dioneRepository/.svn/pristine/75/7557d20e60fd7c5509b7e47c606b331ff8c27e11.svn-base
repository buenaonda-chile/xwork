package com.denso.common.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class HTTPResource implements IResource {

	public final static String GET_URL     = "GET_URL";
	public final static String SET_URL     = "SET_URL";
	
	public static final String CRLF = "\r\n";

	/**
     * 파일을 업로드 처리 할 URL
     */
    private String set_url = null;

	/**
     * 파일을 다운로드 할 URL
     */
    private String get_url = null;

	
	public boolean connect(HashMap connect_info) throws Exception {
		set_url = (String)connect_info.get(HTTPResource.SET_URL);
		get_url = (String)connect_info.get(HTTPResource.GET_URL);
		return true;
	}

	public boolean disconnect() throws Exception {
		return true;
	}

	public boolean changePath(String folder_path) throws Exception {
		return false;
	}

	public boolean createFolder(String folder_path) throws Exception {
		return false;
	}

	public boolean deleteFile(String file_name) throws Exception {
		return false;
	}

	public boolean deleteFolder(String folder_path) throws Exception {
		return false;
	}

	public InputStream getFile(String file_name) throws Exception {

		// 파일을 업로드할 HTTP URL 파싱  
        URL conn_url = null; 
		try {
			conn_url = get_url==null?null:new URL(get_url);
            System.out.println("file get throws http protocol. target url: "+get_url);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// URL에 연결    
		HttpURLConnection conn = (HttpURLConnection)conn_url.openConnection();

		BufferedInputStream http_in = new BufferedInputStream(conn.getInputStream());
		
		return http_in;
	}

	public String[] listFile(String folder) throws Exception {
		return null;
	}

	public boolean setFile(String file_name, InputStream is) throws Exception {

		// 파일을 업로드할 HTTP URL 파싱  
        URL conn_url = null; 
		try {
			conn_url = set_url==null?null:new URL(set_url);
            System.out.println("file transfer throws http protocol. target url: "+set_url);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

        // multipart/form-data 인코딩에 필요한 파라미터 작성
		String delimeter = "---------------------------7d115d2a20060c";
        byte[] newLineBytes = CRLF.getBytes();
        byte[] delimeterBytes = delimeter.getBytes();
        byte[] dispositionBytes = "Content-Disposition: form-data; name=".getBytes();
        byte[] quotationBytes = "\"".getBytes();
        byte[] contentTypeBytes = "Content-Type: application/octet-stream".getBytes();
        byte[] fileNameBytes = "; filename=".getBytes();
        byte[] twoDashBytes = "--".getBytes();
        
    	// URL에 연결  및 초기화  
		HttpURLConnection conn = (HttpURLConnection)conn_url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary="+delimeter);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        
        BufferedOutputStream out = null;
        try {
        	//연결된 URL에 아웃풋 스트림 꺼내기
        	out = new BufferedOutputStream(conn.getOutputStream());

            // Delimeter 전송
            out.write(twoDashBytes);
            out.write(delimeterBytes);
            out.write(newLineBytes);

            // 파라미터 이름 전송
            out.write(dispositionBytes);
            out.write(quotationBytes);
            out.write( ("file1").getBytes() );
            out.write(quotationBytes);
            
	        // 주어진 파일명 전송
	        out.write(fileNameBytes);
	        out.write(quotationBytes);
	        out.write(file_name.getBytes() );
	        out.write(quotationBytes);

            //컨텐츠 타입 전송
	        out.write(newLineBytes);
            out.write(contentTypeBytes);
            out.write(newLineBytes);
            out.write(newLineBytes);

            // InputStream으로부터 스트림 데이터 전송
            try {
                byte[] fileBuffer = new byte[1024 * 8]; // 8k
                int len = -1;
                while ( (len = is.read(fileBuffer)) != -1) {
                    out.write(fileBuffer, 0, len);
                }
            } finally {
                if (is != null) try { is.close(); } catch(IOException ex) {}
            }
            out.write(newLineBytes);
            
         // 마지막 Delimeter 전송
            out.write(twoDashBytes);
            out.write(delimeterBytes);
            out.write(twoDashBytes);
            out.write(newLineBytes);
            
            out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
        } finally {
            if (out != null) out.close();
        }

        //전송완료 후 리턴되는 스트림데이터 수신
        is = conn.getInputStream();
        try {
            byte[] fileBuffer = new byte[1024 * 8]; // 8k
            int len = -1;
            System.out.println("file sucessfully transfered.");
            System.out.println("===> received message start.");
            while ( (len = is.read(fileBuffer)) != -1) {
                System.out.write(fileBuffer, 0, len);
            }
            System.out.println("===> received message end.");
        } finally {
            if (is != null) try { is.close(); } catch(IOException ex) {}
        }

        return true;
	}

	public long getFileSize(String file_name) throws Exception {
		return -1;
	}
}
