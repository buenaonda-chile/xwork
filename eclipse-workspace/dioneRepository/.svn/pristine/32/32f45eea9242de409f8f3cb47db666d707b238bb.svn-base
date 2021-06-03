package com.globaldenso.dnkr.business.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.eclipse.jdt.internal.compiler.ast.CaseStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.constant.Constants;
import com.globaldenso.dnkr.constant.PageUtil;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.integration.dao.SalaryDao;
import com.globaldenso.dnkr.integration.dao.SalaryUserDao;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;
import com.globaldenso.dnkr.uxis.UxisExcelFileUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;

/**
 * 
 * @파일명 : SalaryServiceImpl.java
 * @프로젝트 : DNKR
 * @날짜 : 2019. 9. 20.
 * @작성자 : Cho HeumJun
 * @설명
 * 
 *     <pre>
 * 		관리자 교육 ServiceImpl
 *     </pre>
 */
@Service("salaryUserService")
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDao salaryDao;

	@Autowired
	private SalaryUserDao salaryUserDao;

	/**
	 * 
	 * @메소드명 : getSalaryList
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		문제목록 리스트
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getSalaryList(com.globaldenso.dnkr.constant.CommandMap commandMap)
			throws ApplicationException {

		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);

		List<Map<String, Object>> listData = salaryDao.getSalaryList(commandMap.getMap());

		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0) {
			listRowCnt = listData.get(0).get("CNT").toString();
		} else {
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging")) {
			lastPageCnt = PageUtil.getPageCount(pageSize, listRowCnt);
		}

		// 결과값 생성
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Constants.GRID_RESULT_CUR_PAGE, curPageNo);
		result.put(Constants.GRID_RESULT_LAST_PAGE, lastPageCnt);
		result.put(Constants.GRID_RESULT_RECORDS_CNT, listRowCnt);
		result.put(Constants.GRID_RESULT_DATA, listData);

		return result;
	}

	/**
	 * 
	 * @메소드명 : getSalary
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육에 대한 상세 정보 호출
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getSalary(CommandMap commandMap) throws ApplicationException, Exception {
		return salaryDao.getSalary(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명 : salarySave
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육 정보 저장
	 *     </pre>
	 * 
	 * @param commandMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, String> salarySave(CommandMap commandMap, MultipartHttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 결과값 최초
		String result = Constants.RESULT_FAIL;

		// 최초 저장인지 수정인지 확인
		if (commandMap.get("edu_pk").equals("")) {
			// 신규등록

			// 첨부파일 등록시 생성한 교육PK
			String eduPk = (String) commandMap.get("p_imagecours");
			// System.out.println("salaryPk : " + salaryPk);

			eduPk = request.getParameter("p_imagecours");
			// System.out.println("salaryPk : " + salaryPk);

			// 교육Pk가 없으면
			if (eduPk == null || eduPk.equals("")) {
				// 새로운 교육 PK취득
				int newSalaryPk = salaryDao.getSalaryPk(commandMap.getMap());
				commandMap.put("edu_pk", newSalaryPk);
			} else {
				commandMap.put("edu_pk", eduPk);
			}

			// 선택한 팀의 코드로 사번 취득
			// System.out.println("화면에서 선택한 팀코드 : "+commandMap.get("p_dept_cd"));

			// 분할처리 로직
			String temp = String.valueOf(commandMap.get("p_dept_cd"));
			// System.out.println("길이 : "+ temp.length());

			ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(temp.split(",")));

			CaseInsensitiveMap tempMap = new CaseInsensitiveMap();
			tempMap.put("deptList", arrayList);
			tempMap.put("empNation", String.valueOf(commandMap.get("p_emp_type_jp")));
			tempMap.put("empType", String.valueOf(commandMap.get("p_emp_type_step")));

			// 추가된 팀코드로 사번 취득
			List<Map<String, Object>> empNumberList = salaryDao.getEmpNumber(tempMap);

			// 리스트 총 사이즈를 구한다.
			int empNumberSize = empNumberList.size();
			// System.out.println("empNumberSize : "+ empNumberSize);

			// 리스트를 문자열로 변환 ,구분
			String empNumber = null;
			for (int i = 0; empNumberSize > i; i++) {

				if (i == 0) {
					empNumber = empNumberList.get(i).get("emp_Number").toString();
				} else {
					empNumber = empNumber + "," + empNumberList.get(i).get("emp_Number").toString();
				}
			}

			// System.out.println("empNumber : "+ empNumber);
			// 문자열로 변환한 사번을 디비 등록을 위해 셋팅
			commandMap.put("emp_number", empNumber);

			// 등록
			int insertResult = salaryDao.salaryInsert(commandMap.getMap());

			if (insertResult == 0) {
				result = Constants.RESULT_FAIL;
			} else {
				result = Constants.RESULT_SUCCESS;
			}
		} else {
			// 수정

			// DB등록되어 있는 데이터 취득
			Map<String, Object> getSalary = getSalary(commandMap);
			// DB팀코드
			String dbDept = (String) getSalary.get("DEPT");

			// 화면에서 넘어온 팀코드
			String screenDept = (String) commandMap.get("p_dept_cd");
			commandMap.put("p_dept_cd", screenDept);

			// 화면에서 선택한 팀의 코드
			// System.out.println("화면에서 선택한 팀코드 : "+ screenDept);
			// DB 등록되어 있는 팀코드 취득
			// System.out.println("DB 등록되어 있는 팀코드 : "+ dbDept);

			// DB 사번 취득
			String dbEmpNumber = (String) getSalary.get("EMP_NUMBER");
			// System.out.println("DB사번 : "+ dbEmpNumber);

			// 화면 선택한 팀코드와 DB 등록되어 있는 팀코드가 같지 않으면 비교해서 추가된 팀코드로 사번 취득
			if (!screenDept.equals(dbDept)) {

				int deptSize = dbDept.length();
				// 추가된 팀코드만 취득
				String setDept = screenDept.substring(deptSize + 1, screenDept.length());
				// System.out.println("추가된 팀코드 : "+ setDept);

				// 분할처리 로직
				String temp = String.valueOf(setDept);
				// System.out.println("길이 : "+ temp.length());

//				CodeDomain empDomain = new CodeDomain();
//				empDomain.setCmcCode(String.valueOf(commandMap.get("p_dept_cd")));
//				empDomain.setCmcType(String.valueOf(commandMap.get("p_emp_type_jp")));
//				empDomain.setCmcUseYN(String.valueOf(commandMap.get("p_emp_type_step")));

				ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(temp.split(",")));

				CaseInsensitiveMap tempMap = new CaseInsensitiveMap();
				tempMap.put("deptList", arrayList);
				tempMap.put("empNation", String.valueOf(commandMap.get("p_emp_type_jp")));
				tempMap.put("empType", String.valueOf(commandMap.get("p_emp_type_step")));

				// 추가된 팀코드로 사번취득 List
				List<Map<String, Object>> empNumberList = salaryDao.getEmpNumber(tempMap);

				// 사번 중복 체크 중복된 사번은 삭제
				List<String> empNumberList2 = new ArrayList<String>();
				String strDbEmpNumber = "," + dbEmpNumber + ",";

				for (Map<String, Object> empNumber : empNumberList) {

					String emp_Number = String.valueOf(empNumber.get("emp_Number"));
					if (strDbEmpNumber.indexOf("," + emp_Number + ",") == -1) {
						empNumberList2.add(emp_Number);
					}
				}

				// 리스트를 문자열로 변환 ,구분
				String empNumber = "";
				for (int i = 0; empNumberList2.size() > i; i++) {

					if (i == 0) {
						empNumber = empNumberList2.get(i).toString();
					} else {
						empNumber = empNumber + "," + empNumberList2.get(i).toString();
					}
				}

				// System.out.println("추가된 사번 : "+ empNumber);

				// 기존 사번에 추가된 사번을 추가
				// 추가할 사번이 있는 경우
				if (empNumber.length() != 0) {
					// DB사번이 없는 경우
					if (dbEmpNumber == null || dbEmpNumber.length() == 0) {
						dbEmpNumber = empNumber;
					} else {
						// DB사번에 추가할 사번 추가
						dbEmpNumber = dbEmpNumber + "," + empNumber;
					}

				}

			}

			// System.out.println("기존 + 추가 사번 : "+ dbEmpNumber);
			// DB 사번 업데이트 위해 셋팅
			commandMap.put("emp_number", dbEmpNumber);

			// 수정
			int updateResult = salaryDao.salaryUpdate(commandMap.getMap());

			if (updateResult == 0) {
				result = Constants.RESULT_FAIL;
			} else {
				result = Constants.RESULT_SUCCESS;
			}
		}

		if (result.equals(Constants.RESULT_SUCCESS)) {
			// 결과값에 따른 메시지를 담아 전송
			Map<String, String> map = new HashMap<String, String>();
			map.put(Constants.RESULT_KEY, Constants.RESULT_SUCCESS);
			map.put(Constants.RESULT_MASAGE_KEY, "처리가 완료되었습니다.");
			return map;
		} else if (result.equals(Constants.RESULT_FAIL)) {
			// 실패한경우(실패 메시지가 없는 경우)
			throw new Exception();
		} else {
			// 실패한경우(실패 메시지가 있는 경우)
			throw new Exception(result);
		}
	}

	/**
	 * 
	 * @메소드명 : getFileDataList
	 * @날짜 : 2020. 7. 25.
	 * @작성자 : Kim GyeongJa
	 * @설명
	 * 
	 *     <pre>
	 *		첨부파일 List로 취득
	 *     </pre>
	 * 
	 * @param edu_pk
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> getFileDataList(String edu_pk) throws ApplicationException {
		return salaryDao.getFileDataList(edu_pk);
	}

	/**
	 * 
	 * @메소드명 : saveAttachFile
	 * @날짜 : 2020. 7. 25.
	 * @작성자 : Kim GyeongJa
	 * @설명
	 * 
	 *     <pre>
	 *		파일 업로드. 업로드 후 정보를 return 하도록 구현
	 *     </pre>
	 * 
	 * @param file
	 * @param request
	 * @param commandMap
	 * @param edu_pk
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> saveAttachFile(MultipartFile file, MultipartHttpServletRequest request,
			CommandMap commandMap) throws Exception {

		// 결과값 최초
		String result = Constants.RESULT_FAIL;

		String uploadDir = UxisCmmUtil.getProperty("salary.uploadpath");
		File desti = new File(uploadDir);
		if (!desti.exists()) {
			desti.mkdirs();
		}

		MultipartFile mf = null;
		File uploadFile = null;
		// MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)
		// request;
		Map<String, MultipartFile> fileMap = ((MultipartRequest) request).getFileMap();

		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			mf = entity.getValue();

		}

		int size = (int) mf.getSize();

		Map<String, Object> map = new HashMap<String, Object>();

		// 첨부파일 사이즈 확인 후 있으면 저장
		if (size > 0) {

			String fileExt = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf('.'));
			String uuidFileName = UUID.randomUUID().toString() + fileExt;
			uploadFile = new File(uploadDir + uuidFileName);

			String salaryPk = (String) request.getParameter("edu_pk");
			// System.out.println("salaryPk : " + salaryPk);

			// 교육Pk가 없으면
			if (salaryPk == null || salaryPk.equals("")) {
				// 교육 PK취득
				int newSalaryPk = salaryDao.getSalaryPk(commandMap.getMap());

				// System.out.println("newSalaryPk : " + newSalaryPk);

				map.put("edu_pk", newSalaryPk);
			} else {
				map.put("edu_pk", salaryPk);
			}

			map.put("file_path", uploadDir + uuidFileName);
			map.put("file_name", uuidFileName);
			map.put("file_size", mf.getSize());
			map.put("file_ext", fileExt);
			map.put("reg_user", commandMap.get("user_name"));
			map.put("mod_user", commandMap.get("user_name"));
			map.put("org_file_name", mf.getOriginalFilename());
			map.put("delete_yn", "N");

			int attachInsertResult = salaryDao.salaryAttchInsert(map);

			if (attachInsertResult == 0) {
				result = Constants.RESULT_FAIL;
			} else {
				// 첨부파일 DB 저장 후 물리적 위치로 파일 업로드
				result = Constants.RESULT_SUCCESS;
				try {
					mf.transferTo(uploadFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}

			}

		}

		if (result.equals(Constants.RESULT_SUCCESS)) {
			// 성공 시 저장한 정보들 넘김
			return map;
		} else if (result.equals(Constants.RESULT_FAIL)) {
			// 실패한경우(실패 메시지가 없는 경우)
			throw new Exception();
		} else {
			// 실패한경우(실패 메시지가 있는 경우)
			throw new Exception(result);
		}
	}

	/**
	 * 
	 * @메소드명 : salaryAttachDel
	 * @날짜 : 2020. 7. 25.
	 * @작성자 : Kim GyeongJa
	 * @설명
	 * 
	 *     <pre>
	 *		첨부파일 1건 삭제
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	// 첨부파일 1건 삭제
	@Override
	public Map<String, String> salaryAttachDel(CommandMap commandMap) throws Exception {
		// 결과값 최초
		String result = Constants.RESULT_FAIL;

		// 1건삭제
		int saveResult = salaryDao.salaryAttachDel(commandMap.getMap());
		if (saveResult > 0) {
			result = Constants.RESULT_SUCCESS;
		} else {
			result = Constants.RESULT_FAIL;
		}

		// 결과값에 따른 메시지를 담아 전송
		Map<String, String> map1 = new HashMap<String, String>();
		if (result.equals(Constants.RESULT_SUCCESS)) {
			map1.put(Constants.RESULT_KEY, Constants.RESULT_SUCCESS);
			map1.put(Constants.RESULT_MASAGE_KEY, "처리가 완료되었습니다.");
			return map1;
		} else if (result.equals(Constants.RESULT_FAIL)) {
			map1.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map1.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map1;
		} else {
			map1.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map1.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map1;
		}
	}

	/**
	 * 
	 * @메소드명 : salaryDel
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육 정보 삭제
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, String> salaryDel(CommandMap commandMap) throws ApplicationException, Exception {

		// 결과값 최초
		String result = Constants.RESULT_FAIL;

		// 교육정보 삭제
		int delResult = salaryDao.salaryDel(commandMap.getMap());

		if (delResult == 0) {
			result = Constants.RESULT_FAIL;
		} else {
			result = Constants.RESULT_SUCCESS;

			// 교육 정보가 삭제 되었다면, 첨부파일전체도 함께 삭제
			int attachDelResult = salaryDao.salaryAttachAllDel(commandMap.getMap());

			if (attachDelResult == 0) {
				result = Constants.RESULT_FAIL;
			} else {
				result = Constants.RESULT_SUCCESS;
			}

			// 답안지 삭제
			// 꼭 답안지 삭제 후 문제지를 삭제 해야된다.
			// * 문제지를 먼저 삭제하면 문제지 Key를 손실하므로 답안지 삭제시 오류 발생. *
			int ansDelResult = salaryDao.ansDel(commandMap.getMap());

			if (ansDelResult == 0) {
				result = Constants.RESULT_FAIL;
			} else {
				result = Constants.RESULT_SUCCESS;
			}

			// 문제지 삭제
			// 위의 로직과 순서가 바뀌면 안된다.
			int queDelResult = salaryDao.queDel(commandMap.getMap());

			if (queDelResult == 0) {
				result = Constants.RESULT_FAIL;
			} else {
				result = Constants.RESULT_SUCCESS;
			}

		}

		// 결과값에 따른 메시지를 담아 전송
		Map<String, String> map = new HashMap<String, String>();
		if (result.equals(Constants.RESULT_SUCCESS)) {
			map.put(Constants.RESULT_KEY, Constants.RESULT_SUCCESS);
			map.put(Constants.RESULT_MASAGE_KEY, "처리가 완료되었습니다.");
			return map;
		} else if (result.equals(Constants.RESULT_FAIL)) {
			map.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map;
		} else {
			map.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map;
		}
	}

	/**
	 * 
	 * @메소드명 : getQueList
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		문제목록 리스트
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getQueList(CommandMap commandMap) throws ApplicationException {

		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);

		List<Map<String, Object>> listData = salaryDao.getQueList(commandMap.getMap());

		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0) {
			listRowCnt = listData.get(0).get("CNT").toString();
		} else {
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging")) {
			lastPageCnt = PageUtil.getPageCount(pageSize, listRowCnt);
		}

		// 결과값 생성
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Constants.GRID_RESULT_CUR_PAGE, curPageNo);
		result.put(Constants.GRID_RESULT_LAST_PAGE, lastPageCnt);
		result.put(Constants.GRID_RESULT_RECORDS_CNT, listRowCnt);
		result.put(Constants.GRID_RESULT_DATA, listData);

		return result;
	}

	/**
	 * 
	 * @메소드명 : queSave
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		문제상세 저장
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, String> queSave(CommandMap commandMap) throws ApplicationException, Exception {

		// 결과값 최초
		String result = Constants.RESULT_FAIL;

		if (commandMap.get("que_pk").equals("")) {

			int quePk = salaryDao.getQuePk(commandMap.getMap());

			commandMap.put("que_pk", quePk);

			// 등록
			int insertResult = salaryDao.queInsert(commandMap.getMap());

			if (insertResult == 0) {
				result = Constants.RESULT_FAIL;
			} else {
				result = Constants.RESULT_SUCCESS;

				// 문제를 등록했다면 그에따른 답안지 리스트를 저장
				String tableArray = (String) commandMap.get("tableArray");
				String[] ansList = tableArray.split(",");

				for (String data : ansList) {

					commandMap.put("ans_subject", data);

					int insertAnsResult = salaryDao.ansInsert(commandMap.getMap());

					if (insertAnsResult == 0) {
						result = Constants.RESULT_FAIL;
					} else {
						result = Constants.RESULT_SUCCESS;
					}

				}

			}
		} else {
			// 수정
			// 해당 부분 수정해야됨. 문제에 따른 답안지 채번이 바뀌므로 업데이트가 아닌
			// 문제에 대한 답안지 삭제 후 재 입력하는 방식으로 로직 변경

			int queToAnsDelResult = salaryDao.queToAnsDel(commandMap.getMap());

			if (queToAnsDelResult == 0) {
				result = Constants.RESULT_FAIL;
			} else {
				result = Constants.RESULT_SUCCESS;

				int updateResult = salaryDao.queUpdate(commandMap.getMap());

				if (updateResult == 0) {
					result = Constants.RESULT_FAIL;
				} else {
					result = Constants.RESULT_SUCCESS;
				}

				// 문제를 등록했다면 그에따른 답안지 리스트를 저장
				String tableArray = (String) commandMap.get("tableArray");
				String[] ansList = tableArray.split(",");

				for (String data : ansList) {

					commandMap.put("ans_subject", data);

					int insertAnsResult = salaryDao.ansInsert(commandMap.getMap());

					if (insertAnsResult == 0) {
						result = Constants.RESULT_FAIL;
					} else {
						result = Constants.RESULT_SUCCESS;
					}

				}

			}

		}

		if (result.equals(Constants.RESULT_SUCCESS)) {
			// 결과값에 따른 메시지를 담아 전송
			Map<String, String> map = new HashMap<String, String>();
			map.put(Constants.RESULT_KEY, Constants.RESULT_SUCCESS);
			map.put(Constants.RESULT_MASAGE_KEY, "처리가 완료되었습니다.");
			return map;
		} else if (result.equals(Constants.RESULT_FAIL)) {
			// 실패한경우(실패 메시지가 없는 경우)
			throw new Exception();
		} else {
			// 실패한경우(실패 메시지가 있는 경우)
			throw new Exception(result);
		}
	}

	/**
	 * 
	 * @메소드명 : getQue
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		문제상세 정보
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getQue(CommandMap commandMap) throws ApplicationException, Exception {
		return salaryDao.getQue(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명 : getAnsList
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		문제에 따른 답안지 리스트
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAnsList(CommandMap commandMap) throws ApplicationException, Exception {
		return salaryDao.getAnsList(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명 : queDel
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		문제 삭제
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, String> queDel(CommandMap commandMap) throws ApplicationException, Exception {

		// 결과값 최초
		String result = Constants.RESULT_FAIL;

		int queToAnsDelResult = salaryDao.queToAnsDel(commandMap.getMap());

		if (queToAnsDelResult == 0) {
			result = Constants.RESULT_FAIL;
		} else {
			// 문제지 삭제
			int queToQueDelResult = salaryDao.queToQueDel(commandMap.getMap());

			if (queToQueDelResult == 0) {
				result = Constants.RESULT_FAIL;
			} else {
				result = Constants.RESULT_SUCCESS;
			}

		}

		// 결과값에 따른 메시지를 담아 전송
		Map<String, String> map = new HashMap<String, String>();
		if (result.equals(Constants.RESULT_SUCCESS)) {
			map.put(Constants.RESULT_KEY, Constants.RESULT_SUCCESS);
			map.put(Constants.RESULT_MASAGE_KEY, "처리가 완료되었습니다.");
			return map;
		} else if (result.equals(Constants.RESULT_FAIL)) {
			map.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map;
		} else {
			map.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map;
		}
	}

	/**
	 * 
	 * @메소드명 : getClsCodeList
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육대상 사업부 리스트
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getClsCodeList(CommandMap commandMap) throws ApplicationException, Exception {

		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);

		List<Map<String, Object>> listData = salaryDao.getClsCodeList(commandMap.getMap());

		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0) {
			listRowCnt = listData.get(0).get("CNT").toString();
		} else {
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging")) {
			lastPageCnt = PageUtil.getPageCount(pageSize, listRowCnt);
		}

		// 결과값 생성
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Constants.GRID_RESULT_CUR_PAGE, curPageNo);
		result.put(Constants.GRID_RESULT_LAST_PAGE, lastPageCnt);
		result.put(Constants.GRID_RESULT_RECORDS_CNT, listRowCnt);
		result.put(Constants.GRID_RESULT_DATA, listData);

		return result;
	}

	/**
	 * 
	 * @메소드명 : getLocCodeList
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육대상 사업장 리스트
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getLocCodeList(CommandMap commandMap) throws ApplicationException, Exception {

		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);

		List<Map<String, Object>> listData = salaryDao.getLocCodeList(commandMap.getMap());

		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0) {
			listRowCnt = listData.get(0).get("CNT").toString();
		} else {
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging")) {
			lastPageCnt = PageUtil.getPageCount(pageSize, listRowCnt);
		}

		// 결과값 생성
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Constants.GRID_RESULT_CUR_PAGE, curPageNo);
		result.put(Constants.GRID_RESULT_LAST_PAGE, lastPageCnt);
		result.put(Constants.GRID_RESULT_RECORDS_CNT, listRowCnt);
		result.put(Constants.GRID_RESULT_DATA, listData);

		return result;
	}

	/**
	 * 
	 * @메소드명 : getTeamCodeList
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육대상 부서(팀) 리스트
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getTeamCodeList(CommandMap commandMap) throws ApplicationException, Exception {

		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);

		List<Map<String, Object>> listData = salaryDao.getTeamCodeList(commandMap.getMap());

		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0) {
			listRowCnt = listData.get(0).get("CNT").toString();
		} else {
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging")) {
			lastPageCnt = PageUtil.getPageCount(pageSize, listRowCnt);
		}

		// 결과값 생성
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Constants.GRID_RESULT_CUR_PAGE, curPageNo);
		result.put(Constants.GRID_RESULT_LAST_PAGE, lastPageCnt);
		result.put(Constants.GRID_RESULT_RECORDS_CNT, listRowCnt);
		result.put(Constants.GRID_RESULT_DATA, listData);

		return result;
	}

	/**
	 * 
	 * @메소드명 : getSalaryList
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육 현황 리스트
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getSalaryRltList(com.globaldenso.dnkr.constant.CommandMap commandMap)
			throws ApplicationException {

		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);

		List<Map<String, Object>> listData = salaryDao.getSalaryRltList(commandMap.getMap());

		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0) {
			listRowCnt = listData.get(0).get("CNT").toString();
		} else {
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging")) {
			lastPageCnt = PageUtil.getPageCount(pageSize, listRowCnt);
		}

		// 결과값 생성
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Constants.GRID_RESULT_CUR_PAGE, curPageNo);
		result.put(Constants.GRID_RESULT_LAST_PAGE, lastPageCnt);
		result.put(Constants.GRID_RESULT_RECORDS_CNT, listRowCnt);
		result.put(Constants.GRID_RESULT_DATA, listData);

		return result;
	}

	/**
	 * 
	 * @메소드명 : getSalaryDtlRltList
	 * @날짜 : 2019. 9. 20.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		교육 현황 리스트
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getSalaryDtlRltList(com.globaldenso.dnkr.constant.CommandMap commandMap)
			throws ApplicationException {

		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);

		List<Map<String, Object>> listData = salaryDao.getSalaryRltDtlList(commandMap.getMap());

		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0) {
			listRowCnt = listData.get(0).get("CNT").toString();
		} else {
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging")) {
			lastPageCnt = PageUtil.getPageCount(pageSize, listRowCnt);
		}

		// 결과값 생성
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Constants.GRID_RESULT_CUR_PAGE, curPageNo);
		result.put(Constants.GRID_RESULT_LAST_PAGE, lastPageCnt);
		result.put(Constants.GRID_RESULT_RECORDS_CNT, listRowCnt);
		result.put(Constants.GRID_RESULT_DATA, listData);

		return result;
	}

	/**
	 * 
	 * @날짜 : 2020. 8. 14.
	 * @작성자 : Kim GyeongJa
	 * @설명
	 * 
	 *     <pre>
	 *		교육대상자중 미완료자 메일 취득
	 *     </pre>
	 * 
	 * @param edu_pk
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> getNoSalaryMailList(String edu_pk) throws ApplicationException {

		return salaryDao.getNoSalaryMailList(edu_pk);
	}

	@Override
	public void saveAmountExcelInfo(String edu_pk, String userName) throws ApplicationException {

		UxisExcelFileUtil efUtil = new UxisExcelFileUtil();
		
		String fileName = salaryUserDao.getSalaryAttFileName(edu_pk);

		String uploadDir = UxisCmmUtil.getProperty("salary.uploadpath");
		
		List<Map<String, String>> excelData = efUtil.getExcelData(uploadDir + fileName, "order");

		for (int i = 0; i < excelData.size(); i++) {

			Map<String, String> map = excelData.get(i);

			// 액셀 정보 파싱하여 데이터 업로드
			if (i > 1) {
				Map<String, Object> udtMap = new HashMap<String, Object>();

				udtMap.put("edu_pk", edu_pk);
				udtMap.put("emp_number", map.get("G"));
				udtMap.put("user_name", map.get("E"));
				udtMap.put("salary_amt", map.get("J"));
				udtMap.put("salary_kr", map.get("K"));
				udtMap.put("capacity_rt", map.get("L"));
				udtMap.put("capacity_amt", map.get("M"));
				udtMap.put("perfor_rt", map.get("N"));
				udtMap.put("perfor_amt", map.get("O"));

				Map<String, Object> rltMap = salaryUserDao.getSalaryUserInfo(udtMap);
				if (rltMap == null) {
					salaryUserDao.setSalaryUserInfoInsert(udtMap);
				} else {
					salaryUserDao.setSalaryUserInfoUpdate(udtMap);
				}

			}

		}

	}

}
