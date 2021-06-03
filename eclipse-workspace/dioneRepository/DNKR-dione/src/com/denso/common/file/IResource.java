/* *
 *	system : DCG Patrner System
 *	cr.date: 2009-09-15
 *	author : oxygene
 */
package com.denso.common.file;

import java.io.InputStream;
import java.util.HashMap;

/**
 * <pre>
 *  파일 업로드, 다운로드를 위한 리소스 컨트롤 인터페이스
 * </pre>
 * @see ws.common.file.LocalResource 
 * @see ws.common.file.FTPResource 
 * @see ws.common.file.WEBResource
 * @since JDK 1.4.1
 * @author oxygene
 */
public interface IResource {

	/**
	 * <pre>
	 *  리소스에 연결
	 * </pre>
	 * @see ws.common.file.LocalResource#connect LocalResource.connect
	 * @see ws.common.file.FTPResource#connect FTPResource.connect
	 * @see ws.common.file.WEBResource#connect WEBResource.connect
	 * @throws Exception
	 */
	public boolean connect(HashMap connect_info) throws Exception;

	/**
	 * <pre>
	 *  리소스에 연결해제
	 * </pre>
	 * @see ws.common.file.LocalResource#disconnect LocalResource.disconnect
	 * @see ws.common.file.FTPResource#disconnect FTPResource.disconnect
	 * @see ws.common.file.WEBResource#disconnect WEBResource.disconnect
	 * @throws Exception
	 */
	public boolean disconnect() throws Exception;

	/**
	 * <pre>
	 *  작업경로 변경
	 * </pre>
	 * @see ws.common.file.LocalResource#changePath LocalResource.changePath
	 * @see ws.common.file.FTPResource#changePath FTPResource.changePath
	 * @see ws.common.file.WEBResource#changePath WEBResource.changePath
	 * @throws Exception
	 */
	public boolean changePath(String folder_path) throws Exception;

	/**
	 * <pre>
	 *  연결된 리소스에 새로운 폴더 생성
	 * </pre>
	 * @see ws.common.file.LocalResource#createFolder LocalResource.createFolder
	 * @see ws.common.file.FTPResource#createFolder FTPResource.changePath
	 * @see ws.common.file.WEBResource#createFolder WEBResource.createFolder
	 * @throws Exception
	 */
	public boolean createFolder(String folder_path) throws Exception;

	/**
	 * <pre>
	 *  연결된 리소스에서 지정된 폴더 삭제
	 * </pre>
	 * @see ws.common.file.LocalResource#deleteFolder LocalResource.deleteFolder
	 * @see ws.common.file.FTPResource#deleteFolder FTPResource.deleteFolder
	 * @see ws.common.file.WEBResource#deleteFolder WEBResource.deleteFolder
	 * @throws Exception
	 */
	public boolean deleteFolder(String folder_path) throws Exception;

	/**
	 * <pre>
	 *  지정된 폴더내의 파일목록 조회
	 * </pre>
	 * @see ws.common.file.LocalResource#listFile LocalResource.listFile
	 * @see ws.common.file.FTPResource#listFile FTPResource.listFile
	 * @see ws.common.file.WEBResource#listFile WEBResource.listFile
	 * @throws Exception
	 */
	public String[] listFile(String folder) throws Exception;

	/**
	 * <pre>
	 *  연결된 리소스에 파일 업로드
	 * </pre>
	 * @see ws.common.file.LocalResource#setFile LocalResource.setFile
	 * @see ws.common.file.FTPResource#setFile FTPResource.setFile
	 * @see ws.common.file.WEBResource#setFile WEBResource.setFile
	 * @throws Exception
	 */
	public boolean setFile(String file_name, InputStream is) throws Exception;

	/**
	 * <pre>
	 *  연결된 리소스에서 파일 다운로드
	 * </pre>
	 * @see ws.common.file.LocalResource#getFile LocalResource.getFile
	 * @see ws.common.file.FTPResource#getFile FTPResource.getFile
	 * @see ws.common.file.WEBResource#getFile WEBResource.getFile
	 * @throws Exception
	 */
	public InputStream getFile(String file_name) throws Exception;

	/**
	 * <pre>
	 *  연결된 리소스에서 지정된 파일 삭제
	 * </pre>
	 * @see ws.common.file.LocalResource#deleteFile LocalResource.deleteFile
	 * @see ws.common.file.FTPResource#deleteFile FTPResource.deleteFile
	 * @see ws.common.file.WEBResource#deleteFile WEBResource.deleteFile
	 * @throws Exception
	 */
	public boolean deleteFile(String file_name) throws Exception;

	/**
	 * <pre>
	 *  연결된 리소스에서 파일 다운로드
	 * </pre>
	 * @see ws.common.file.LocalResource#getFileSize LocalResource.getFileSize
	 * @see ws.common.file.FTPResource#getFileSize FTPResource.getFileSize
	 * @see ws.common.file.WEBResource#getFileSize WEBResource.getFileSize
	 * @throws Exception
	 */
	public long getFileSize(String file_name) throws Exception;

}
