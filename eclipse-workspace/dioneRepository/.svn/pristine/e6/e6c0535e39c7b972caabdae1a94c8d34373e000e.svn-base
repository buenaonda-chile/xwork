package com.denso.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.denso.common.Constants;
import com.denso.common.DateTime;
import com.denso.common.TextUtil;

import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;

public final class FileUpDown {

	private static Log log = LogFactory.getLog(FileUpDown.class);

    /**
     * Client의 파일을 서버로 저장한다. dataset을 통해 파일을 이진형태로 받아서 서버의 지정된경로로 파일을 write한다.
     * 
     * @param ds 파일정보를 담고 있는 Dataset
     * @return iRtn 파일 저장 갯 수
     * @throws Exception 예외처리
     */
    public static int setFileUp(Dataset ds) throws Exception {

        int iRtn = 0;

        String sFileNm;
        String sFilePath;

        byte[] baFile;
        byte[] baInput;

        int offset = 0;

        File file = null;

        ByteArrayInputStream baIns = null;
        FileOutputStream fOuts = null;

        try {
            for (int i = 0; i < ds.getRowCount(); i++) {

                baFile = ds.getColumnAsByteArray(i, "FILE_BLOB");
                
                sFileNm = TextUtil.isNull(ds.getColumnAsString(i, "FILE_NAME"));
                sFilePath = ds.getColumnAsString(i, "FILE_PATH");
                /*
                if("".equals(sFileNm)) {

                    sFileNm = setUniqueFileNm(ds.getColumnAsString(i, "NAME"));

                    ds.setColumn(i, "SAVE_NM", sFileNm);
                }
                */
                file = new File(sFilePath);

                if (!file.exists()) {

                    file.mkdirs();
                }

                baIns = new ByteArrayInputStream(baFile);
                fOuts = new FileOutputStream(sFilePath + "/" + sFileNm);

                baInput = new byte[baFile.length];

                while ((baIns.read(baInput, offset, baInput.length)) != -1);

                baIns.read(baInput, offset, baInput.length);

                fOuts.write(baInput); // 파일 쓰기!

                baIns.close();
                fOuts.close();
                
                iRtn++;
            }
        } catch(Exception e) {

            throw e;

        } finally {

            if(baIns!=null) baIns.close();
            if(fOuts!=null) fOuts.close();
        }
        return iRtn;
    }

    
    /**
     * Client의 파일을 서버로 저장한다. 이진형태로 받아서 서버의 지정된경로로 파일을 write한다.
     * 
     * @param byteFile 업로드 파일
     * @param sFullNm 파일명
     * @return iRtn 파일 저장 갯 수
     * @throws Exception 예외처리
     */
    public static int setFileUp(byte[] byteFile, String sFullNm) throws Exception {

        int iRtn = 0;

        byte[] baInput;

        int offset = 0;

        File file = null;

        ByteArrayInputStream baIns = null;
        FileOutputStream fOuts = null;

        try {
        	
        	//String sFilePath = sFullNm.substring(0, sFullNm.lastIndexOf(File.separator));
        	String sFilePath = sFullNm.substring(0, sFullNm.lastIndexOf("/"));

            file = new File(sFilePath);

            if (!file.exists()) {

                file.mkdirs();
            }
            
            baIns = new ByteArrayInputStream(byteFile);
            sFullNm = new String(sFullNm.getBytes("UTF-8"), "8859_1");
            log.debug("FileNameTest------------------->"+sFullNm);
            fOuts = new FileOutputStream(sFullNm);

            baInput = new byte[byteFile.length];

            while ((baIns.read(baInput, offset, baInput.length)) != -1);

            baIns.read(baInput, offset, baInput.length);

            fOuts.write(baInput); // 파일 쓰기!

            baIns.close();
            fOuts.close();
            
            iRtn++;

        } catch(Exception e) {

            throw e;

        } finally {

            if(baIns!=null) baIns.close();
            if(fOuts!=null) fOuts.close();
        }
        return iRtn;
    }

    
    /**
     * 지정된경로의 파일을 삭제한다.
     * 
     * @param sFullNm 파일 저장 경로명
     * @return iRtn 파일 삭제 건 수
     * @throws Exception 예외처리
     */
    public static int deleteFile(String sFullNm) throws Exception {

        int iRtn = 0;

        try {

            File file = new File(sFullNm);

            if (!file.exists()) {
            	
            	log.debug("존재하지 않는 파일. " + sFullNm);

            	return iRtn;
            }
            
            if(file.delete()) {
            	
                iRtn++;

            } else {
            	
            	log.debug("파일 삭제 실패. " + sFullNm);
            }
        } catch(Exception e) {

            throw e;

        } finally {

        }
        return iRtn;
    }

    
    /**
     * 서버의 지정된 파일을 dataset에 담아 돌려준다.
     * 
     * @param fullName 서버에 위치한 파일 full name
     * @return dsRtn 파일 정보를 담은 Dataset
     * @throws Exception 예외처리
     */
    public static Dataset setFileDown(String fullName) throws Exception {

        Dataset dsRtn = new Dataset("dsFile", Constants.CHAR_SET);

        dsRtn.addColumn("NAME", ColumnInfo.COLUMN_TYPE_STRING, 256);
        dsRtn.addColumn("SPATH", ColumnInfo.COLUMN_TYPE_STRING, 256);
        dsRtn.addColumn("SIZE", ColumnInfo.COLUMN_TYPE_LONG, 50);
        dsRtn.addColumn("CONTENT", ColumnInfo.COLUMN_TYPE_BLOB, 256);

        FileInputStream fIns = null;

        try {
            File file = new File(fullName); // File을 읽어온다.

            fIns = new FileInputStream(file); // File을 이용해서 FileInputStream을 생성한다.

            byte[] baBuff = new byte[(new Long(file.length())).intValue()];
            // byte[] baBuff = new byte[Integer.parseInt(String.valueOf(file.length()))];

            fIns.read(baBuff);

            int iRnum = dsRtn.appendRow();

            dsRtn.setColumn(iRnum, "NAME", file.getName());
            dsRtn.setColumn(iRnum, "SPATH", file.getPath());
            dsRtn.setColumn(iRnum, "SIZE", file.length());
            dsRtn.setColumn(iRnum, "CONTENT", baBuff);

        } catch (Exception e) {

            throw e;

        } finally {

            if (fIns != null) fIns.close();
        }
        return dsRtn;
    }


    /**
     * 서버의 지정된 파일을 읽어서 Byte Array로 돌려준다.
     * 
     * @param fullName 서버에 위치한 파일 full name
     * @return file Byte Array
     * @throws Exception 예외처리
     */
    public static byte[] getFileCont(String fullName) throws Exception {

        FileInputStream fIns = null;
        byte[] baBuff = null;

        try {
            File file = new File(fullName); // File을 읽어온다.

            fIns = new FileInputStream(file); // File을 이용해서 FileInputStream을 생성한다.

            baBuff = new byte[(new Long(file.length())).intValue()];

            fIns.read(baBuff);

        } catch (FileNotFoundException e) {

        	log.debug(e.toString() + " FileNm :: '" + fullName + "'");

        } catch (Exception e) {

            throw e;

        } finally {

            if (fIns != null) fIns.close();
        }

        return baBuff;
    }
    
    
    /**
     * 유일한 파일명을 생성한다.
     * 
     * @param ds 파일 정보가 담겨진 Dataset
     * @return ds 유일한 파일명으로 변경된 Dataset
     * @throws Exception
     */
    public static Dataset setUniqueFileNm(Dataset ds) throws Exception {

        for (int i = 0; i < ds.getRowCount(); i++) {

            //ds.setColumn(i, "NAME", DateTime.getDateString("yyyyMMddHHmmssSSS") + i + "_" + ds.getColumnAsString(i, "NAME"));
            ds.setColumn(i, "SAVE_NM", setUniqueFileNm(ds.getColumnAsString(i, "NAME")));
        }
        return ds;
    }

    /**
     * 유일한 파일명을 생성한다.
     * 
     * @param sFileNm - 원래 파일명
     * @return sRtn - 유일한 파일명
     * @throws Exception
     */
    public static String setUniqueFileNm(String sFileNm) throws Exception {

        if(sFileNm==null || sFileNm.length()<1) throw new Exception("파일명이 없습니다.");

        return DateTime.getDateString("yyyyMMddHHmmss") + generateRandomNumber(4) + "_" + sFileNm;
    }


    /**
     * 난수 문자열을 생성하여 돌려준다.
     * 
     * @param int - 문자열 길이
     * @return sRtn - 난수 문자열
     * @throws Exception
     */
    public static String generateRandomNumber(int len) throws Exception {

    	double digit = Math.pow(10.0, len);

    	int num = (int) (Math.random() * digit);

    	return TextUtil.lpad(num, len);
    }

}
