/* *
 *	system : DCG Partner System
 *	cr.date: 2009-01-13
 *	author : oxygene
 */
package com.denso.common;

/* *
 * <pre>
 * @author oxygene 
 * 
 * 프로젝트 공통 상수 설정 .
 * 
 * </pre>
 */
public interface Constants {

	public final static String appClassPath = "wps.service.app.";
	public final static String appSuffix = "_App";

	public final static String CHAR_SET = "utf-8"; // Default Character Set

	public final static String INSERT = "I"; // DB work mode Insert
	public final static String UPDATE = "U"; // DB work mode Update
	public final static String DELETE = "D"; // DB work mode Delete

	public final static String APP_NAME  = "app_name"; // 필수 파라미터 명
	public final static String METHOD    = "method";   // 필수 파라미터 명 

	public final static String RES_CODE  = "result_code";    // 필수 처리 결과 파라미터명
	public final static String RES_MSG   = "result_message"; // 필수 처리 결과  파라미터명

	public final static String OK     = "0"; // Application Result Code
	public final static String ERROR  = "-1";// Application Result Code

	public final static String SEQ_FIELD  = "SEQ_FIELD";// Sequence Field
	public final static String SEQ_VALUE  = "SEQ_VALUE";// Sequence Field Value
}
