package com.globaldenso.dnkr.uxis;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.globaldenso.dnkr.domain.db2.FileDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmImprvDDomain;
 
 
/**
 *
 * 파일 관련 Util 모음
 *
 * @author $Author$
 * @version $Revision$
 */
@Component("UxisFileMngUtil")
public class UxisFileMngUtil {
    /**
     * 경로 구분자 
     */
    final char FILE_SEPARATOR = File.separatorChar;
    
    /**
     * Constructor.
     */
    public UxisFileMngUtil() {
    }
    
    /**
     * 첨부파일에 대한 목록 정보를 취득한다. 
     * @param files         Map<String, MultipartFile>
     * @param KeyStr        String
     * @param fileKeyParam  int
     * @param atchFileId    String
     * @param storePath     String
     * @param site_id       String
     * @param table_nm      String
     * @return              List<UxisFileVO>
     * @throws Exception 
     */
    public List<UxisFileVO> parseFileInf(Map<String, MultipartFile> files, 
        String KeyStr, 
        int fileKeyParam, 
        String atchFileId, 
        String storePath,
        String site_id,
        String table_nm) throws Exception {

        int fileKey = fileKeyParam;

        String storePathString = "";
        String atchFileIdString = "";

        String RelativePathPrefix = ""; //파일경로
        
        storePathString = RelativePathPrefix +  storePath;
        storePathString = storePathString.replaceAll(" ", "");

        if ("".equals(atchFileId) || atchFileId == null) {
            //atchFileIdString = idgenService.getNextStringId();
        } else {
            atchFileIdString = atchFileId;
        }

        File saveFolder = new File(UxisCmmUtil.filePathBlackList(storePathString));
        if (!saveFolder.exists() || saveFolder.isFile()) {
            saveFolder.mkdirs();
        }

        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
        MultipartFile file;
        String filePath = "";
        List<UxisFileVO> result = new ArrayList<UxisFileVO>();
        UxisFileVO fvo;

        while (itr.hasNext()) {
            Entry<String, MultipartFile> entry = itr.next();

            String htmlId = entry.getKey();

            file = entry.getValue();
            String orginFileName = file.getOriginalFilename();
            
            //--------------------------------------
            // 원 파일명이 없는 경우 처리
            // (첨부가 되지 않은 input file type)
            //--------------------------------------
            if ("".equals(orginFileName)) {
                continue;
            }
            ////------------------------------------

            int index = orginFileName.lastIndexOf(".");
            //String fileName = orginFileName.substring(0, index);
            String fileExt = orginFileName.substring(index + 1);
            String newName = "";
            if(htmlId.indexOf("imgFile") != -1){
                newName = "sumnail_" + getTimeStamp() + fileKey;
            }else{
                newName = KeyStr + getTimeStamp() + fileKey;
            }
            long size = file.getSize();

            if (!"".equals(orginFileName)) {
                newName = newName.replaceAll(" ", "");
                filePath = storePathString + newName;
                filePath = filePath.replaceAll(" ", "");
                file.transferTo(new File(UxisCmmUtil.filePathBlackList(filePath)));

                /*if(htmlId.indexOf("imgFile") != -1){
                    sumNail(newName, storePathString, fileExt, 235);
                }*/
            }

            fvo = new UxisFileVO();
            fvo.setFileExtsn(fileExt);
            fvo.setFileStreCours(storePathString);
            fvo.setFileMg(Long.toString(size));
            fvo.setOrignlFileNm(orginFileName);
            fvo.setStreFileNm(newName);
            fvo.setAtchFileId(atchFileIdString);
            fvo.setFileSn(String.valueOf(fileKey));
            fvo.setSite_id(site_id);
            fvo.setTable_nm(table_nm);
            fvo.setHtmlID(entry.getKey());
            result.add(fvo);

            fileKey++;
        }
        return result;
    }

    /**
     * 
     * @param files         Map<String, MultipartFile>
     * @param storePath     String
     * @return              List<UxisFileVO>
     * @throws Exception 
     */
    public List<UxisFileVO> parseFileInf(Map<String, MultipartFile> files, 
        String storePath) throws Exception {
        
        String storePathString = "";
        String atchFileIdString = "";

        String RelativePathPrefix = ""; //파일경로

        storePathString = RelativePathPrefix +  storePath;
        storePathString = storePathString.replaceAll(" ", "");


        File saveFolder = new File(UxisCmmUtil.filePathBlackList(storePathString));
        if (!saveFolder.exists() || saveFolder.isFile()) {
            saveFolder.mkdirs();
            saveFolder = null;
        }


        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
        MultipartFile file;
        String filePath = "";
        List<UxisFileVO> result = new ArrayList<UxisFileVO>();
        UxisFileVO fvo;

        while (itr.hasNext()) {
            Entry<String, MultipartFile> entry = itr.next();

            file = entry.getValue();
            String orginFileName = file.getOriginalFilename().replaceAll(" ", "");

            orginFileName = cheackFile(storePathString, orginFileName, 0);

            //--------------------------------------
            // 원 파일명이 없는 경우 처리
            // (첨부가 되지 않은 input file type)
            //--------------------------------------
            if ("".equals(orginFileName)) {
                continue;
            }
            ////------------------------------------

            int index = orginFileName.lastIndexOf(".");
            //String fileName = orginFileName.substring(0, index);
            String fileExt = orginFileName.substring(index + 1);
            String newName = "";
            long size = file.getSize();

            newName = getTimeStamp();

            if (!"".equals(orginFileName)) {
                newName = newName.replaceAll(" ", "");
                if(fileExt.toUpperCase().endsWith("XLS") || fileExt.toUpperCase().endsWith("XLSX") || fileExt.toUpperCase().endsWith("CSV")){
                	newName = newName + "." + fileExt;
                }
                
                filePath = storePathString + newName;
                filePath = filePath.replaceAll(" ", "");
                
                file.transferTo(new File(UxisCmmUtil.filePathBlackList(filePath)));
            }
            

            fvo = new UxisFileVO();
            fvo.setFileExtsn(fileExt);
            fvo.setFileStreCours(storePathString);
            fvo.setFileMg(Long.toString(size));
            fvo.setOrignlFileNm(orginFileName);
            fvo.setStreFileNm(newName);
            fvo.setAtchFileId(atchFileIdString);
            fvo.setHtmlID(entry.getKey());
            result.add(fvo);
            //System.out.println("atchFileIdString : " + atchFileIdString + "  , storePathString : " + storePathString );
        }
        
        return result;
    }
    
    
    /**
     * [KO] 신규이력등록 > 첨부파일 저장
     * 
     * @param files         Map<String, MultipartFile>
     * @param storePath     String
     * @param domain     	FileDb2Domain
     * @return              List<FileDb2Domain>
     * @throws Exception 
     */
    public List<FileDb2Domain> parseFileInfo(Map<String, MultipartFile> files, 
        String storePath, FileDb2Domain domain) throws Exception {
    	
        String storePathString = "";
        String atchFileIdString = "";

        String RelativePathPrefix = ""; //파일경로

        storePathString = RelativePathPrefix +  storePath;
        storePathString = storePathString.replaceAll(" ", "");


        File saveFolder = new File(UxisCmmUtil.filePathBlackList(storePathString));
        if (!saveFolder.exists() || saveFolder.isFile()) {
            saveFolder.mkdirs();
            saveFolder = null;
        }


        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
        MultipartFile file;
        String filePath = "";
        List<FileDb2Domain> result = new ArrayList<FileDb2Domain>();
        FileDb2Domain fvo;

        int seqNo = Integer.parseInt(domain.getSeqno());
        
        while (itr.hasNext()) {
        	System.out.println("seqNo:" + seqNo);
            Entry<String, MultipartFile> entry = itr.next();

            file = entry.getValue();
            String orginFileName = file.getOriginalFilename().replaceAll(" ", "");
            System.out.println("orginFileName:" + orginFileName);
            orginFileName = cheackFile(storePathString, orginFileName, 0);

            //--------------------------------------
            // 원 파일명이 없는 경우 처리
            // (첨부가 되지 않은 input file type)
            //--------------------------------------
            if ("".equals(orginFileName)) {
                continue;
            }
            ////------------------------------------

            int index = orginFileName.lastIndexOf(".");
            //String fileName = orginFileName.substring(0, index);
            String fileExt = orginFileName.substring(index + 1);
            String newName = "";
            long size = file.getSize();

            newName = domain.getJisno() + "_" + seqNo;

            if (!"".equals(orginFileName)) {
                newName = newName.replaceAll(" ", "");
//                if(fileExt.toUpperCase().endsWith("XLS") || fileExt.toUpperCase().endsWith("XLSX")){
                	newName = newName + "." + fileExt;
//                }
                
                filePath = storePathString + newName;
                filePath = filePath.replaceAll(" ", "");
                
                //파일저장
                file.transferTo(new File(UxisCmmUtil.filePathBlackList(filePath)));
            }
            

            fvo = new FileDb2Domain();
            fvo.setSeqno(seqNo + "");
            fvo.setFilnm(newName);
            result.add(fvo);
            
            seqNo += 1;
            //System.out.println("atchFileIdString : " + atchFileIdString + "  , storePathString : " + storePathString );
        }
        
        return result;
    }
    
    /**
     * [KO] 신규이력등록 > 개선상세 - 도면등록변경
     * 
     * @param files         Map<String, MultipartFile>
     * @param storePath     String
     * @param domain     PsogmImprvDDomain
     * @return              List<PsogmImprvDDomain>
     * @throws Exception 
     */
    public List<PsogmImprvDDomain> parseFileInfo(Map<String, MultipartFile> files, 
        String storePath, PsogmImprvDDomain domain) throws Exception {
    	
        String storePathString = "";
        String atchFileIdString = "";

        String RelativePathPrefix = ""; //파일경로

        storePathString = RelativePathPrefix +  storePath;
        storePathString = storePathString.replaceAll(" ", "");


        File saveFolder = new File(UxisCmmUtil.filePathBlackList(storePathString));
        if (!saveFolder.exists() || saveFolder.isFile()) {
            saveFolder.mkdirs();
            saveFolder = null;
        }


        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
        MultipartFile file;
        String filePath = "";
        List<PsogmImprvDDomain> result = new ArrayList<PsogmImprvDDomain>();
        PsogmImprvDDomain fvo;
        
        while (itr.hasNext()) {
            Entry<String, MultipartFile> entry = itr.next();

            file = entry.getValue();
            String orginFileName = file.getOriginalFilename().replaceAll(" ", "");
            System.out.println("orginFileName:" + orginFileName);
            orginFileName = cheackFile(storePathString, orginFileName, 0);

            //--------------------------------------
            // 원 파일명이 없는 경우 처리
            // (첨부가 되지 않은 input file type)
            //--------------------------------------
            if ("".equals(orginFileName)) {
                continue;
            }
            ////------------------------------------

            int index = orginFileName.lastIndexOf(".");
            //String fileName = orginFileName.substring(0, index);
            String fileExt = orginFileName.substring(index + 1);
            String newName = "";
            long size = file.getSize();

            if(domain.getImgbf() != null && !"".equals(domain.getImgbf())) {
            	newName = domain.getJisno() + "_BFO";
            } else if(domain.getImgaf() != null && !"".equals(domain.getImgaf())) {
            	newName = domain.getJisno() + "_AFT";
            }

            if (!"".equals(orginFileName)) {
                newName = newName.replaceAll(" ", "");
//                if(fileExt.toUpperCase().endsWith("XLS") || fileExt.toUpperCase().endsWith("XLSX")){
                	newName = newName + "." + fileExt;
//                }
                
                filePath = storePathString + newName;
                filePath = filePath.replaceAll(" ", "");
                
                //파일저장
                file.transferTo(new File(UxisCmmUtil.filePathBlackList(filePath)));
            }
            

            fvo = new PsogmImprvDDomain();
            if(domain.getImgbf() != null && !"".equals(domain.getImgbf())) {
            	System.out.println("if(.equals(domain.getImgbf())) {");
            	fvo.setImgbf(newName);
            } else if(domain.getImgaf() != null && !"".equals(domain.getImgaf())) {
            	System.out.println("else if(.equals(domain.getImgaf())) {");
            	fvo.setImgaf(newName);
            }
            result.add(fvo);
            //System.out.println("atchFileIdString : " + atchFileIdString + "  , storePathString : " + storePathString );
        }
        
        return result;
    }
    

    /**
     * @param path          String
     * @param fileName      String
     * @param cnt           int
     * @return              String
     */
    private String cheackFile(String path, String fileName, int cnt){
        File saveFolder = new File(UxisCmmUtil.filePathBlackList(path + fileName));
        if(!saveFolder.isFile()){
            return fileName;
        }else{
            int num = 0;
            if(cnt > 0){
                num = 3;
            }

            int index = fileName.lastIndexOf(".");
            //String fileName = orginFileName.substring(0, index);
            String fileExt = fileName.substring(index + 1);
            fileName = fileName.substring(0, index - num) + "[" + (cnt++) + "]" + "." + fileExt;
            return cheackFile(path, fileName, cnt);
        }
    }

    /**
     * 공통 컴포넌트 utl.fcc 패키지와 Dependency제거를 위해 내부 메서드로 추가 정의함
     * 응용어플리케이션에서 고유값을 사용하기 위해 시스템에서17자리의TIMESTAMP값을 구하는 기능
     *
     * @return Timestamp 값
     */
    public static String getTimeStamp() {

        String rtnStr = null;

        // 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
        String pattern = "yyyyMMddhhmmssSSS";

        SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
        Timestamp ts = new Timestamp(System.currentTimeMillis());

        rtnStr = sdfCurrent.format(ts.getTime());

        return rtnStr;
    }

    /**
     * 
     * @param response              HttpServletResponse
     * @param request               HttpServletRequest
     * @param saveDir               String
     * @param saveName              String
     * @param realName              String
     * @throws Exception 
     */
    public void downLoadProcess(HttpServletResponse response, 
        HttpServletRequest request, 
        String saveDir, 
        String saveName, 
        String realName) throws Exception{
    	
        File uFile = new File(saveDir, saveName);
        int fSize = (int) uFile.length();

        if (fSize > 0) {
            String mimetype = "application/x-msdownload";
            //String mimetype = "doesn/matter; charset=utf-8";
            //response.flushBuffer();
            //response.getWriter();
            response.setBufferSize(fSize);  // OutOfMemeory 발생
            response.setContentType(mimetype);
            //response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fvo.getOrignlFileNm(), "utf-8") + "\"");
            setDisposition(realName, request, response);
            response.setContentLength(fSize);

            /*
             * FileCopyUtils.copy(in, response.getOutputStream());
             * in.close();
             * response.getOutputStream().flush();
             * response.getOutputStream().close();
             */
            BufferedInputStream in = null;
            BufferedOutputStream out = null;

            try {


                in = new BufferedInputStream(new FileInputStream(uFile));
                out = new BufferedOutputStream(response.getOutputStream());

                FileCopyUtils.copy(in, out);
                out.flush();
                //jw.clear();
            } catch (IOException ex) {
                // 다음 Exception 무시 처리
                // Connection reset by peer: socket write error
                //EgovBasicLogger.ignore("IO Exception", ex);
            } finally {
                response.flushBuffer();
                if(in != null){
                    in.close();
                }
                if(out != null){
                    out.close();
                }
                response.getOutputStream().close();
            }

        } else {
            response.setContentType("application/x-msdownload");

            PrintWriter printwriter = response.getWriter();

            printwriter.println("<html>");
            printwriter.println("<h2>Could not get file name:<br>" + realName + "</h2>");
            printwriter.println("<center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
            printwriter.println("<br>&copy; webAccess");
            printwriter.println("</html>");

            printwriter.flush();
            printwriter.close();
        }
    }

    /**
     * 
     * @param filename      String
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @throws Exception 
     */
    public void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String browser = getBrowser(request);

        String dispositionPrefix = "attachment; filename=";
        String encodedFilename = null;

        if (browser.equals("MSIE")) {
            encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
        } else if (browser.equals("Trident")) { // IE11 문자열 깨짐 방지
            encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
        } else if (browser.equals("Firefox")) {
            encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
        } else if (browser.equals("Opera")) {
            encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
        } else if (browser.equals("Chrome")) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < filename.length(); i++) {
                char c = filename.charAt(i);
                if (c > '~') {
                    sb.append(URLEncoder.encode("" + c, "UTF-8"));
                } else {
                    sb.append(c);
                }
            }
            encodedFilename = sb.toString();
        }else if(browser.equals("Safari")){

            encodedFilename = URLEncoder.encode(filename, "UTF-8") + ";";
            //dispositionPrefix = "filename=";
            //response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
            //response.setHeader("Content-Type", "doesn/matter; charset=utf-8");
            //response.setContentType("application/octet-stream;charset=UTF-8");
            //response.setHeader("Content-Type", "doesn/matter; charset=utf-8");
        }else {
            throw new IOException("Not supported browser");
        }
        /*
        String fileType = "";

        if (fileType.equals("hwp")){
          response.setContentType("application/x-hwp");
        } else if (fileType.equals("pdf")){
          response.setContentType("application/pdf");
        } else if (fileType.equals("ppt") || fileType.equals("pptx")){
          response.setContentType("application/vnd.ms-powerpoint");
        } else if (fileType.equals("doc") || fileType.equals("docx")){
          response.setContentType("application/msword");
        } else if (fileType.equals("xls") || fileType.equals("xlsx")){
          response.setContentType("application/vnd.ms-excel");
        } else {
          response.setContentType("application/octet-stream");
        }*/
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Description", "JSP Generated Data");
        response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
        if ("Opera".equals(browser)) {
            response.setContentType("application/octet-stream;charset=UTF-8");
        }
    }

    /**
     * 
     * @param request   HttpServletRequest
     * @return          String
     */
    private String getBrowser(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        if (header.indexOf("MSIE") > -1) {
            return "MSIE";
        } else if (header.indexOf("Trident") > -1) { // IE11 문자열 깨짐 방지
            return "Trident";
        } else if (header.indexOf("Chrome") > -1) {
            return "Chrome";
        } else if (header.indexOf("Opera") > -1) {
            return "Opera";
        } else if(header.indexOf("Safari") > -1){
            return "Safari";
        }
        return "Firefox";
    }

    /**
     * 디렉토리에 파일이 존재하는지 체크하는 기능
     *
     * @param dir   String 디렉토리
     * @param file  String  파일
     * @return boolean result 존재여부 True / False
     * @exception Exception 
     */
    public boolean checkFileExstByName(String dir, String file) throws Exception {

        // 파일 존재 여부
        boolean result = false;

        // 디렉토리 오픈
        String drctry = dir.replace('\\', FILE_SEPARATOR).replace('/', FILE_SEPARATOR);
        File srcDrctry = new File(UxisCmmUtil.filePathBlackList(drctry));

        // 디렉토리이면서, 존재하면
        if (srcDrctry.exists() && srcDrctry.isDirectory()) {
            // 디렉토리 안 목록을 조회한다. (파일명)
            File[] fileArray = srcDrctry.listFiles();
            List<String> list = null;
            if(fileArray != null){
                list = getSubFilesByName(fileArray, file);
            }
            if (list != null && list.size() > 0) {
                result = true;
            }
        }

        return result;
    }

    /**
     * 디렉토리 내부 하위목록들 중에서 파일을 찾는 기능(파일명)
     *
     * @param fileArray File[]  파일목록
     * @param file  String  파일명
     * @return ArrayList list 파일목록(절대경로)
     * @exception Exception 
     */
    public static List<String> getSubFilesByName(File[] fileArray, String file) throws Exception {

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < fileArray.length; i++) {
            // 디렉토리 안에 디렉토리면 그 안의 파일목록에서 찾도록 재귀호출한다.
            if (fileArray[i].isDirectory()) {
                File[] tmpArray = fileArray[i].listFiles();
                list.addAll(getSubFilesByName(tmpArray, file));
                // 파일이면 파일명이 같은지 비교한다.
            } else {
                if (fileArray[i].getName().equals(file)) {
                    list.add(fileArray[i].getAbsolutePath());
                }
            }
        }

        return list;
    }

    /**
     * <pre>
     * Comment : 파일을 삭제한다.
     * </pre>
     *
     * @param fileDeletePath 삭제하고자 하는파일의 절대경로
     * @return 성공하면 삭제된 파일의 절대경로, 아니면블랭크
     */
    public String deleteFile(String fileDeletePath) {

        // 인자값 유효하지 않은 경우 블랭크 리턴
        if (fileDeletePath == null || fileDeletePath.equals("")) {
            return "";
        }
        String result = "";
        File file = new File(UxisCmmUtil.filePathBlackList(fileDeletePath));
        if (file.isFile()) {
            result = deletePath(fileDeletePath);
        } else {
            result = "";
        }

        return result;
    }

    /**
     * 
     * @param filePath      String
     * @return              String
     */
    public String deletePath(String filePath) {
        File file = new File(UxisCmmUtil.filePathBlackList(filePath));
        String result = "";

        if (file.exists()) {
            result = file.getAbsolutePath();
            if (!file.delete()) {
                result = "";
            }
        }

        return result;
    }


    /**
     * 
     * @param x1        int
     * @param y1        int
     * @param x2        int
     * @param y2        int
     * @param type      int
     * @return          HashMap<String, Integer>
     */
    private HashMap<String, Integer> getLocationXY(int x1, int y1, int x2, int y2, int type){
        int returnX = 0;
        int returnY = 0;
        
        if(type == 0){
            if(x1 > x2){
                returnX = x2;
                returnY = (int)Math.floor((y1 * x2) / x1);
            }else{
                returnX = x1;
                returnY = y1;
            }
        }else{
            if(y1 > y2){
                returnY = y2;
                returnX = (int)Math.floor((y2 * x1) / y1);
            }else{
                returnX = x1;
                returnY = y1;
            }
        }

        HashMap<String, Integer> locationXY = new HashMap<String, Integer>();
        locationXY.put("X", returnX);
        locationXY.put("Y", returnY);

        return locationXY;
    }
}
