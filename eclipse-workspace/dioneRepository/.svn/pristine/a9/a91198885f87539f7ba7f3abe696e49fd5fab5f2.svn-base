package com.denso.common.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;

public class LocalResource implements IResource {

	private String filePath = "";
	
	public boolean changePath(String folder_path) throws Exception {
		File f = new File(folder_path);
		if (!f.exists()) {
			throw new Exception("path not found. " + folder_path);
		}
		filePath = folder_path;
		return true;
	}

	public boolean connect(HashMap connect_info) throws Exception {
		return true;
	}

	public boolean disconnect() throws Exception {
		return true;
	}

	public boolean createFolder(String folder_path) throws Exception {
		File 			d 		= new File(folder_path); 
		d.mkdirs();
		return false;
	}

	public boolean deleteFile(String file_name) throws Exception {
		File 			f 		= new File(filePath+file_name);
		if (f.exists()) f.delete();
		return false;
	}

	public boolean deleteFolder(String folder_path) throws Exception {
		File f = new File(folder_path);		// 폴더의 모든 파일을 읽어온다.
		String[] fnameList = f.list();		// 폴더의 모든 파일 목록을 읽어온다.
		String childPath = "";	  			// 폴더의 하위 파일을 읽어온다.
		
		if (f.exists()){
			for (int i = 0; i < fnameList.length; i++) {
				childPath = folder_path+fnameList[i];
				File file = new File(childPath);
				if ( !file.isDirectory()) {			// 읽어온 파일이 폴더가 아닐경우 삭제
					file.delete();
				}else {
					deleteFolder(childPath);		// 읽어온 파일이 폴더일경우 하위파일 목록읽어서 삭제한다.
				}
		    }			
			f.delete();
		}
		return false;
	}

	public InputStream getFile(String file_name) throws Exception {
		File 			f 		= new File(filePath+file_name); // File을 읽어온다
		FileInputStream f_in	= new FileInputStream(f); 		// File을 이용해서 FileInputStream을 생성한다
		return f_in;
	}

	public String[] listFile(String folder) throws Exception {
		File			f		= new File(folder);				// 폴더의 모든 파일을 읽어온다.
		String[] 		f_list	= f.list();						// 폴더의 모든 파일 목록을 읽어온다.
		return f_list;
	}

	public boolean setFile(String file_name, InputStream is) throws Exception {
		FileOutputStream	f_out	= null;
		
		try {
			f_out = new FileOutputStream(filePath+file_name);	// FileOutputStream을 생성한다
			byte[] buf					= new byte[1024];		// 1024버퍼 배열 생성
			for (int i; (i=is.read(buf))!=-1; ) {
					f_out.write(buf, 0, i);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (f_out != null) try { f_out.close(); } catch (Exception e) {}
		}
		
		return false;
	}

	public long getFileSize(String file_name) throws Exception {
		File 			f 		= new File(filePath+file_name); // File을 읽어온다
		return f.length();
	}
}
