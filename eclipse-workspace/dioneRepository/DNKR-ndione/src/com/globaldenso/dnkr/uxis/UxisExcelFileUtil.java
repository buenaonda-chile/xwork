package com.globaldenso.dnkr.uxis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.multipart.MultipartFile;
 
/**
 * 
 * @author $Author$
 * @version $Revision$
 */
public class UxisExcelFileUtil {
    
    /** Constructor.    */
    public UxisExcelFileUtil() {
        // TODO Auto-generated constructor stub
    }

    /**
     * [KO] 저장경로
     */
    String rootPath = UxisCmmUtil.getProperty("system.uploadpath");
    
    /**
     * <pre>파일 확장자가 허용된 파일확장자(fileExt)일 경우 파일을 서버에 올린다.</pre>
     * <pre>처리 결과를 String 형태로 리턴한다. 성공여부(Y/N)§처리결과메세지 형태로 리턴한다.</pre>
     * @param files                 Map<String, MultipartFile>
     * @param fileExt               허용 파일 확장자, 다수의 파일 확장자일 경우 ,로 구분 한다.
     * @param fileUtil              UxisFileMngUtil Class,  UxisFileMngUtil.parseFileInf로 파일을 업로드 처리 함
     * @return  String              JSON Type의 처리 결과 
     */
    public String uploadFileData(Map<String, MultipartFile> files, String fileExt, UxisFileMngUtil fileUtil){
        //String saveDir = "C:/develop/workspace/DNKR/WebContent/data/excel/";
        String saveDir = rootPath + "data/excel/";
        try{
            if(!files.isEmpty()){
                if(checkFileExt(files, fileExt)){
                    //파일 업로드
                    List<UxisFileVO> fresult = fileUtil.parseFileInf(files, saveDir);
                    if(fresult.size() <= 0){
                        return "N§첨부파일 등록이 실패되었습니다.";
                    }
                    UxisFileVO vo = fresult.get(0);
                    return "Y§" + vo.getFileStreCours() + vo.getStreFileNm();
                }else{
                    return "N§허용하지 않은 파일입니다.";
                }
            }else{
                return "N§첨부된 파일이 없습니다.";
            }
        }catch(Exception e){
            e.printStackTrace();
            return "N§첨부파일 등록이 실패되었습니다.";
        }
    }

    /**
     * 엑셀 데이터 읽어오기
     * @param fileName      String
     * @param type      String
     * @return  List<Map<String, String>>
     */
    public List<Map<String, String>> getExcelData(String fileName, String type){
        List<Map<String, String>> excelData = null;
        try{
            CommonExcelRead excelRead = new CommonExcelRead();
            excelData = excelRead.read(fileName, type);
        }catch(Exception e){
            e.printStackTrace();
        }

        return excelData;
    }

    /**
     * 허용된 확장자 파일 여부 확인
     * @param files         Map<String, MultipartFile> files
     * @param fileExt       String fileExt
     * @return  boolean
     */
    private boolean checkFileExt(Map<String, MultipartFile> files, String fileExt){
        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
        MultipartFile file;
        while (itr.hasNext()) {
            Entry<String, MultipartFile> entry = itr.next();

            file = entry.getValue();

            String orginFileName = file.getOriginalFilename();
            //System.out.println("orginFileName  " + orginFileName);
            if ("".equals(orginFileName)) {
                continue;
            }

            int pos = orginFileName.lastIndexOf( "." );
            String ext = orginFileName.substring( pos + 1 );
            ext = ext.toLowerCase();
            //System.out.println("ext : " + ext + "   fileExt : " + fileExt);
            if(!eregi(ext, fileExt)){
                return false;
            }
        }
        return true;
    }
    
    /**
     * ext 문자열에 fileExt에 있는 파일 확장자 존재 여부
     * @param ext           String
     * @param fileExt       String
     * @return              boolean
     */
    private boolean eregi(String ext, String fileExt){
        String[] useFilter = fileExt.split(";");
        for(String str : useFilter){
            if(ext.equals(str)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Map Type 변수에 key값으로 저장된 문자열 타입 날짜를 UNIX Time 값으로 변경 
     * @param map       Map<String, String> map
     * @param key       String
     */
    public void setDate(Map<String, String> map, String key){
        try{
            String temp = UxisStringUtil.isNullToString(map.get(key));
            String[] dateStrs = null;
            if(temp.indexOf("-") != -1){
                dateStrs = temp.split("-");
            }

            if(dateStrs != null && dateStrs.length > 1){
                map.put(key, UxisCmmUtil.mktime(0, 0, 0, Integer.parseInt(dateStrs[2]), 
                    Integer.parseInt(dateStrs[1]), 
                    Integer.parseInt(dateStrs[0])) + "");
            }else if(temp.length() == 8){
                map.put(key, UxisCmmUtil.mktime(0, 0, 0, Integer.parseInt(temp.substring(6, 8)), 
                    Integer.parseInt(temp.substring(4, 6)), 
                    Integer.parseInt(temp.substring(0, 4))) + "");
            }else{
                map.put(key, "0");
            }
        }catch(Exception e){
            e.printStackTrace();
            map.put(key, "0");
        }
    }
    
    /**
     * Map Type 변수에 key값으로 저장된 문자열의 숫자를 숫자 관련 처리
     * @param map       Map<String, String>
     * @param key       String
     */
    public void setNumber(Map<String, String> map, String key){
        String temp = UxisStringUtil.isNullToString(map.get(key));
        map.put(key, temp.replace(".0", "").replace("E7", "").replace(".", ""));
    }
}
