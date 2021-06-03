package com.denso.common.file;

import java.io.InputStream;
import java.util.HashMap;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTPResource implements IResource {

	public final static String FTP_IP       = "FTP_IP";
	public final static String FTP_PORT     = "FTP_PORT";
	public final static String FTP_USERID   = "FTP_USERID";
	public final static String FTP_PASSWORD = "FTP_PASSWORD";

	private FTPClient ftp = null;
	private FTPFile[] files =  null;

	
	/**
	 * <pre>
	 *  현재 리소스의 연결상태 확인.
	 * </pre>
	 * @return boolean
	 */
	public boolean connected = false;

	/**
	 * <pre>
	 *  FTP 리소스에 연결<p>
	 *  아래의 예제코드를 참조하여 커넥션 정보를 작성해주어야 한다.
	 *  연결에 성공하였을경우 connected 속성이 true로 바뀜.
	 *  example code:
	 *  connect_info.put(FTPResource.FTP_IP,      "127.0.0.1");
	 *  connect_info.put(FTPResource.FTP_PORT,    "21");
	 *  connect_info.put(FTPResource.FTP_USERID,  "test");
	 *  connect_info.put(FTPResource.FTP_PASSWORD,"test");
	 *  ftpResource.connect(connect_info);
	 * </pre>
	 * @see ws.common.file.FTPResource#connected connected
	 * @throws Exception
	 */

	public boolean connect(HashMap connect_info) throws Exception {
		
		String ftp_ip     = (String)connect_info.get(FTPResource.FTP_IP);
		String ftp_port   = (String)connect_info.get(FTPResource.FTP_PORT);
		String ftp_userid = (String)connect_info.get(FTPResource.FTP_USERID);
		String ftp_passwd = (String)connect_info.get(FTPResource.FTP_PASSWORD);
		
		if (ftp==null) ftp = new FTPClient();
		//ftp.setControlEncoding("UTF-8"); // 한글 파일 인코딩 설정
		ftp.setControlEncoding("EUC-KR");  // 한글 파일 인코딩 설정
		ftp.connect(ftp_ip, Integer.parseInt(ftp_port)); // 서버 접속
		connected = ftp.login(ftp_userid, ftp_passwd); // 로그인 아이디 , 패스워드 설정
		
		if (!connected) {
			throw new Exception(ftp.getReplyString());
		}

		return false;
	}

	public boolean disconnect() throws Exception {
		boolean result = false;
		if (connected) {
			if (ftp.logout()) {
				ftp.disconnect();
				result = true;
			}
		}
		return result;
	}

	public boolean changePath(String folder_path) throws Exception {

		// 접속하는 서버 작업 디렉토리 변경
		ftp.changeWorkingDirectory(folder_path);
		
		//응답코드가 비정상이면 접속을 종료한다.
		int reply = ftp.getReplyCode();

		boolean result = FTPReply.isPositiveCompletion(reply);
		
		files =  ftp.listFiles(folder_path);
		
		return result;
	}


	public boolean createFolder(String folder_path) throws Exception {
		return ftp.makeDirectory(folder_path);
	}

	public boolean deleteFolder(String folder_path) throws Exception {
		return ftp.removeDirectory(folder_path);
	}

	public boolean deleteFile(String file_name) throws Exception {
		return ftp.deleteFile(file_name);
	}

	public InputStream getFile(String file_name) throws Exception {
		return ftp.retrieveFileStream(file_name);
	}

	public String[] listFile(String folder) throws Exception {
		return ftp.listNames();
	}

	public boolean setFile(String file_name, InputStream is) throws Exception {
		return ftp.storeFile(file_name, is);
	}

	public long getFileSize(String file_name) throws Exception {
		long result = -1;
		for (int i= 0; i<files.length; i++) {
			if (file_name.equals(files[i].getName())) {
				result = files[i].getSize();
				break;
			}
		}
		
		return result;
	}
}
