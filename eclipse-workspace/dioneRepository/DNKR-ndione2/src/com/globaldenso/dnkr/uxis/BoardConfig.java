package com.globaldenso.dnkr.uxis;

import java.util.LinkedHashMap;

/**
 * 게시판 관련 설정 변수 모음
 *  
 * @author $Author$
 * @version $Revision$
 */
public class BoardConfig {

    
    /** 게시판 타입 키 목록 */
    private final  LinkedHashMap<String, String> _boardType  = new LinkedHashMap<String, String>();
    /** 게시판 권한 키 목록 */
    private final  LinkedHashMap<String, String> _boardAuth  = new LinkedHashMap<String, String>();
    /** 신규 글 아이콘 노출일 목록 */
    private final  int[] _newIconDay    = {0, 1, 2, 3, 4, 5};
    /** 첨부파일 개수 목록 */
    private final  int[] _fileNum       = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    /** 첨부파일 용량 제한 목록  */
    private final  int[] _fileSize      = {10, 20, 30, 40, 50, 100};
    /** 한페이지 당 글 개수 */
    private final  int _pageSize        = 10;
    /** 한 블럭당 페이지 개수  */
    private final  int _pageUnit        = 10;
    /** 허용 파일 확장자 목록 */
    private final  String _fileExt      = "*.gif;*.jpg;*.jpeg;*.png;*.xls;*.xlsx;*.hwp;*.doc;*.docx;*.ppt;*.pptx;*.ods;*.zip;*.log;*.txt";

    /**
     * Constructor.
     */
    public BoardConfig() {
    }

    /**
     * 게시판 권한 키 목록 
     * @return LinkedHashMap<String, String>
     */
    public LinkedHashMap<String, String> get_boardAuth() {
//      "authnone", "mngrauth", "smngauth", "userauth", "비회원"
        _boardAuth.put("authnone", "사용안함");
        _boardAuth.put("mngrauth", "관리자");
        _boardAuth.put("smngauth", "부관리자");
        _boardAuth.put("userauth", "회원");
        _boardAuth.put("noneuser", "비회원");
        return _boardAuth;
    }

    /**
     * 게시판 타입 키 목록
     * @return  LinkedHashMap<String, String>
     */
    public LinkedHashMap<String, String> get_boardType() {
        _boardType.put("noml", "일반게시판");
        _boardType.put("qnab", "QNA게시판");
        _boardType.put("faqb", "FAQ게시판");
        return _boardType;
    } 
    
    /**
     * 신규 글 아이콘 노출일 목록 
     * @return  int[]
     */
    public int[] get_newIconDay() {
        return _newIconDay;
    }

    /**
     * 첨부파일 개수 목록
     * @return  int[]
     */
    public int[] get_fileNum() {
        return _fileNum;
    }

    /**
     * 첨부파일 용량 제한 목록 
     * @return  int[]
     */
    public int[] get_fileSize() {
        return _fileSize;
    }

    /**
     * 허용 파일 확장자 목록
     * @return String 구분자 ;
     */
    public String get_fileExt() {
        return _fileExt;
    }

    /**
     * 한페이지 당 글 개수
     * @return  int
     */
    public int get_pageSize() {
        return _pageSize;
    }

    /**
     * 한 블럭당 페이지 개수 
     * @return int
     */
    public int get_pageUnit() {
        return _pageUnit;
    }
}
