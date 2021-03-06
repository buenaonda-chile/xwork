package com.globaldenso.dnkr.constant;

/**
 * 
 * @파일명		: Constants.java 
 * @프로젝트	: EDU
 * @날짜		: 2019. 9. 05. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		공통상수 정의
 * </pre>
 */
public class Constants {

	// **************************************************
	// 각 메뉴의 URL정보(다른 매뉴에서도 불리어질때 사용)
	// **************************************************
	/** 실행 JSP명 */
	public static final String JSP_NAME = "jspName";
	/** BASEINFO */
	public static final String BASEINFO = "/baseInfo";
	/** MENU */
	public static final String MENU = "/menu";
	/** DLM */
	public static final String DLM = "/dlm";
	/** 주간실적관리 */
	public static final String WEEK_RESULT = "/weekResultMgr";
	/** 근태관리 */
	public static final String GEUNTAE = "/geuntaeMgr";
	/** 정보공유 */
	public static final String INFO = "/infoSharing";
	/** 공지사항 */
	public static final String NOTICE = "/noticeMgr";
	/** 자료실 */
	public static final String REFER_ROOM = "/referRoomMgr";
	/** 게시판 */
	public static final String BBS = "/boardMgr";
	/** 배포 */
	public static final String DISTB = "/distb";
	/** 배포 신청 */
	public static final String DISTB_REG = "/distbMgr";
	/** 템플릿(First) */
	public static final String TEMP_REG = "/tempMgr";
	/** 템플릿(First) */
	public static final String TEMP = "/temp";
	
	/** 로그인에서 사용되어지는 링크 : 로그인경로 */
	public static final String LOGIN_LINK = "/main/logIn/login";
	/** 개인정보 수정 */
	public static final String LOGIN_UPDATE = "/main/logIn/updateUserInfo";
	/** 회원가입 */
	public static final String REGISTER_LINK = "/main/memberJoin/memberJoin";
	/** 패스워드 초기화 */
	public static final String FORGOTPASSWORD_LINK = "/main/passwdInit/passwdInit";
	/** 팝업에서 사용되어질 링크 */
	public static final String POPUP = "/popUp";
	/** 자동 로그인 메인 화면 */
	public static final String AUTO_LOGIN_LINK = "/main/logIn/autoLogin";
	// **************************************************
	// 그리드변경 구분자
	// **************************************************
	/** I:신규 */
	public static final String INSERT = "I";
	/** U:수정 */
	public static final String UPDATE = "U";
	/** D:삭제 */
	public static final String DELETE = "D";

	// **************************************************
	// 뷰단에서 받을 결과값
	// **************************************************
	/** 결과 */
	public static final String RESULT_KEY = "result";
	/** 실행 결과에 사용되는 msg 명 */
	public static final String RESULT_MASAGE_KEY = "resultMsg";
	/** 실행 결과에 사용되는 obj 명 */
	public static final String RESULT_OBJECT_KEY = "resultObj";
	/** 결과 : 실패 */
	public static final String RESULT_FAIL = "fail";
	/** 결과 : 성공 */
	public static final String RESULT_SUCCESS = "success";
	/** 공통 : 리스트DB데이터를 뷰단으로 넘겨줄때의 키 */
	public static final String RESULT_LIST = "list";
	// **************************************************
	// 그리드 정보
	// **************************************************
	/** [oper] : 그리드변경 구분자로 I:신규 U:수정 D:삭제 를 취득하기위한 키 */
	public static final String FROM_GRID_OPER = "oper";
	/** [rows] : 그리드의 페이지 사이즈 */
	public static final String FROM_GRID_PAGE_SIZE = "rows";
	/** [page] : 그리드의 현재 페이지 */
	public static final String FROM_GRID_CUR_PAGE_NO = "page";
	/** [chmResultList] : 그리드의 신규,수정,삭제된 데이타 리스트 */
	public static final String FROM_GRID_DATA_LIST = "chmResultList";

	// **************************************************
	// DB에 조건문으로 입력될 그리드 정보, 유저정보 의 키값
	// **************************************************
	/** DB조건문 : 페이지 사이즈 */
	public static final String SET_DB_PAGE_SIZE = "pageSize";
	/** DB조건문 : 현재 페이지 */
	public static final String SET_DB_CUR_PAGE_NO = "curPageNo";
	/** DB조건문 : 로그인아이디 */
	public static final String SET_DB_LOGIN_ID = "loginId";
	/** 관리자아이디 */
	public static final String APPROVAL_ADMIN = "approvalAdmin";
	/** 관리자 폰 */
	public static final String APPROVAL_PHONE = "approvalPhone";
	

	// **************************************************
	// 그리드정보를 조회,저장시에 공통적으로 사용되는 맵핑 네임 정의
	// **************************************************
	/** 맵핑 정보를 취득할 키 */
	public static final String MAPPER_NAME = "mapperName";
	/** 맵핑 구분자 */
	public static final String MAPPER_SEPARATION = ".";
	/** 맵핑 네임 : 삭제 */
	public static final String MAPPER_DELETE = "delete";
	/** 맵핑 네임 : 업데이트 */
	public static final String MAPPER_UPDATE = "update";
	/** 맵핑 네임 : 신규 */
	public static final String MAPPER_INSERT = "insert";
	/** 맵핑 네임 : 중복 카운트 */
	public static final String MAPPER_GET_DUPLICATE_CNT = "duplicate";
	/** 맵핑 네임 : 리스트 */
	public static final String MAPPER_GET_LIST = "list";
	/** 공통 : 단일DB데이터를 뷰단으로 넘겨줄때의 키 */
	public static final String MEPPER_GET_SELECT = "select";
	/** 맵핑 네임 : 총 레코드 길이 */
	public static final String MEPPER_GET_TOTAL_RECORD = "selectTotalRecord";

	// **************************************************
	// 그리드에 넘겨줄 결과의 키값
	// **************************************************
	/** 그리드에서 필요한정보 : 현재페이지 */
	public static final String GRID_RESULT_CUR_PAGE = "page";
	/** 그리드에서 필요한정보 : 페이징처리의 마지막 페이지 */
	public static final String GRID_RESULT_LAST_PAGE = "total";
	/** 그리드에서 필요한정보 : 총 레코드 길이 */
	public static final String GRID_RESULT_RECORDS_CNT = "records";
	/** 그리드에서 필요한정보 : 데이터 */
	public static final String GRID_RESULT_DATA = "rows";

	// **************************************************
	// 세션에 저장될 로그인정보 키값
	// **************************************************
	/** 세션정보 : 유저의 로그인 아이디 */
	public static final String SESSION_LOGIN_ID = "login_id";
	/** 세션정보 : 유저 오브젝트 */
	public static final String SESSION_LOGIN_USER_OBJ = "loginUser";

	// **************************************************
	// 뷰에서 사용될 정보
	// **************************************************
	/** 유저의 권한정보의 키값 */
	public static final String VIEW_USER_ROLE_KEY = "userRole";
	/** 페이지 이동에 사용될 대메뉴의 URL키값 */
	public static final String VIEW_PARENT_URL = "up_link";
	/** 페이지 내의 페이지가 불러질경우 메뉴정보가 필요하므로 설정해두는 키값 */
	public static final String VIEW_MENU_ID = "menu_id";
	/** 뷰에서 불리어질 메뉴리스트의 키값 */
	public static final String VIEW_TREE_MENU_LIST = "treeMenuList";
	/** 메뉴관리에서 불리어질 상위 대매뉴의 키값 */
	public static final String MENU_UP_MENU_ID_KEY = "p_parent_menu_id";
	/** 초기 메인화면에서 불러어질 공지 정보의 키값 */
	public static final String MAIN_NOTICE_LIST = "noticeList";

	// **************************************************
	// 시스템 정보
	// **************************************************
	/** 시스템에 적용되어있는 서블릿 경로 */
	public static final String SERVLET_PRE_PATH = "/";
	/** 시스템에 적용되어있는 서블릿 구분어 */
	public static final String SERVLET_TAIL_PATH = "[.]do";
	/** 리졸버에서 선택된 메뉴의 링크를 입력할 키 */
	public static final String NEXT_VIEW_LINK = "nextViewLink";
	/** 메뉴에서 사용되어지는 링크 */
	public static final String MENU_URL = "menu";
	/** 메뉴에서 사용되어지는 링크 */
	public static final String MAINSCREEN_URL = "main/mainScreen";
	/** 메뉴에서 사용되어지는 링크 : JSP명 */
	public static final String JSP_MAINFRAME = "/mainFrame";
	/** 파일 업로드 경로 */
	public static final String EXCEL = "uploaddata/temp";
	/** 관리자 메일 주소 */
	public static final String ADMIN_ADDRESS = "admin@nate.com";
	/** 페이징 정보 키 */
	public static final String IS_PAGING = "isPaging";
	/** no */
	public static final String NO = "no";
	/** yes */
	public static final String YES = "yes";
	/** Y */
	public static final String Y = "Y";
	/** mapper를 직접 넣어주는경우 */
	public static final String MAPPER = "mapper";
	/** JSP에서 에러 판단 KEY */
	public static final String IS_ERROR_KEY = "error_yn";
	/** JSP에서 에러 메세지 KEY */
	public static final String ERROR_MSG_KEY = "error_msg";
	/** Servlet path */
	public static final String SERVLET_PATH = "pgm_link";	
	
	// **************************************************
	// SEQ_ID 정의
	// **************************************************
	public static final String SEQ_ID = "seq_id";
	/** 유저테이블 SEQ */
	public static final String USER_SEQ = "USER_SEQ";
	/** 메뉴테이블 SEQ */
	public static final String MENU_SEQ = "MENU_SEQ";
	/** 표준권한 마스터 테이블 SEQ */
	public static final String STAND_AUTH_M_SEQ = "STAND_AUTH_M_SEQ";
	/** 표준권한 상세 테이블 SEQ */
	public static final String STAND_AUTH_D_SEQ = "STAND_AUTH_D_SEQ";
	/** 개별권한 테이블 SEQ */
	public static final String INDI_AUTH_SEQ = "INDI_AUTH_SEQ";
	/** 공통 코드 마스터 테이블 SEQ */
	public static final String CODE_M_SEQ = "CODE_M_SEQ";
	/** 공통 코드 상세 테이블 SEQ */
	public static final String CODE_D_SEQ = "CODE_D_SEQ";
	/** 주간실적 관리 테이블 SEQ */
	public static final String DLM_WEEK_SEQ = "DLM_WEEK_SEQ";
	/** 근태관리기준정보 테이블 SEQ */
	public static final String DLM_BASE_SEQ = "DLM_BASE_SEQ";
	/** 근태관리휴가보너스정보 테이블 SEQ */
	public static final String DLM_BONUS_SEQ = "DLM_BONUS_SEQ";
	/** 근태관리신청정보 테이블 SEQ */
	public static final String DLM_REQ_SEQ = "DLM_REQ_SEQ";
	/** SMS 통보이력 테이블 SEQ */
	public static final String SMS_SEQ = "SMS_SEQ";
	/** 공지사항 테이블 SEQ */
	public static final String NOTICE_SEQ = "NOTICE_SEQ";
	/** 게시판 테이블 SEQ */
	public static final String BBS_SEQ = "BBS_SEQ";
	/** 자료실 테이블 SEQ */
	public static final String RESOURCE_SEQ = "RESOURCE_SEQ";
	/** 첨부파일 테이블 SEQ */
	public static final String ATTACH_SEQ = "ATTACH_SEQ";
	/** 1년미만자기준정보 테이블 SEQ */
	public static final String OYU_BASE_INFO_SEQ = "OYU_BASE_INFO_SEQ";
	/** 게시판 댓글 테이블 SEQ */
	public static final String BBS_REPLY_SEQ = "BBS_REPLY_SEQ";
	/** 공휴일 테이블 SEQ */
	public static final String HOLIDAY_SEQ = "HOLIDAY_SEQ";
	/** 배포 테이블 SEQ */
	public static final String DISTB_SEQ = "DISTB_SEQ";
	/** 템플릿 테이블 SEQ */
	public static final String TEMP_SEQ = "TEMP_SEQ";
	/** Mail 통보이력 테이블 SEQ */
	public static final String MAIL_SEQ = "MAIL_SEQ";
	
	// **************************************************
	// SMS 상수 정의
	// **************************************************
	/** 받는 사람 */
	public static final String SEND_PHONE = "send_phone";
	/** 보내는 메세지 */
	public static final String MSG_BODY = "msg_body";
	/** SMS Type (ex. 근태관리: B 등) */
	public static final String SMS_TYPE = "sms_type";
	
}
