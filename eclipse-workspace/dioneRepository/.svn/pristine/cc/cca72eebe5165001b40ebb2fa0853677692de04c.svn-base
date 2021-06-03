package com.globaldenso.dnkr.business.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.constant.Constants;
import com.globaldenso.dnkr.constant.PageUtil;
import com.globaldenso.dnkr.integration.dao.EduDao;
import com.globaldenso.dnkr.uxis.UxisCmmUtil;

/**
 * 
 * @파일명		: EduServiceImpl.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		관리자 교육 ServiceImpl
 * </pre>
 */
@Service("eduUserService")
public class EduServiceImpl implements EduService {
	
	@Autowired
    private EduDao eduDao;

	/**
	 * 
	 * @메소드명	: getEduList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제목록 리스트	
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getEduList(com.globaldenso.dnkr.constant.CommandMap commandMap) throws ApplicationException {
		
		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);
		
		List<Map<String, Object>> listData = eduDao.getEduList(commandMap.getMap());
		
		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0)
		{
			listRowCnt = listData.get(0).get("CNT").toString();
		}
		else
		{
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging"))
		{
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
	 * @메소드명	: getEdu
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육에 대한 상세 정보 호출	
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getEdu(CommandMap commandMap) throws ApplicationException, Exception {
		return eduDao.getEdu(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명	: eduSave
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육 정보 저장	
	 * 	</pre>
	 * @param commandMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, String> eduSave(CommandMap commandMap, MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 결과값 최초
		String result = Constants.RESULT_FAIL;
		
		MultipartFile mf = null;
		File uploadFile = null;
		//MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = request.getFileMap();
		
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet())
		{
			mf = entity.getValue();
		}
		
		String uploadDir = UxisCmmUtil.getProperty("edu.uploadpath");
		File desti = new File(uploadDir);
		if (!desti.exists())
		{
			desti.mkdirs();
		}
		
		int size = (int) mf.getSize();

		if(size > 0) {
			
			String fileExt = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf('.'));
			String uuidFileName = UUID.randomUUID().toString() + fileExt;
			uploadFile = new File(uploadDir + uuidFileName);
			
			commandMap.put("file_path", uploadDir + uuidFileName);
			commandMap.put("file_name", uuidFileName);
			commandMap.put("file_size", mf.getSize());
			commandMap.put("file_ext", fileExt);
			commandMap.put("org_file_name", mf.getOriginalFilename());
		}
		
		// 최초 저장인지 수정인지 확인
		if (commandMap.get("edu_pk").equals(""))
		{
			
			int eduPk = eduDao.getEduPk(commandMap.getMap());
			
			commandMap.put("edu_pk", eduPk);
			
			// 등록
			int insertResult = eduDao.eduInsert(commandMap.getMap());

			if (insertResult == 0)
			{
				result = Constants.RESULT_FAIL;
			}
			else
			{
				result = Constants.RESULT_SUCCESS;
				//System.out.println(size);
				
				// 첨부파일 사이즈 확인 후 있으면 저장
				if(size > 0) {
					
					int attachInsertResult = eduDao.eduAttchInsert(commandMap.getMap());
					
					if (attachInsertResult == 0)
					{
						result = Constants.RESULT_FAIL;
					}
					else
					{
						// 첨부파일 DB 저장 후 물리적 위치로 파일 업로드
						result = Constants.RESULT_SUCCESS;
						try
						{
							mf.transferTo(uploadFile);
						}
						catch (IllegalStateException | IOException e)
						{
							e.printStackTrace();
						}
			
					}
					
				}
				
			}
		}
		else
		{
			// 수정
			int updateResult = eduDao.eduUpdate(commandMap.getMap());

			if (updateResult == 0)
			{
				result = Constants.RESULT_FAIL;
			}
			else
			{
				result = Constants.RESULT_SUCCESS;
				
				// 첨부파일 사이즈 확인 후 업데이트 실행
				if(size > 0) {
					
					int attachUpdateResult = eduDao.eduAttachUpdate(commandMap.getMap());
					
					if (attachUpdateResult == 0)
					{
						result = Constants.RESULT_FAIL;
					}
					else
					{
						result = Constants.RESULT_SUCCESS;
						
						try
						{
							// 첨부파일 DB 저장 후 물리적 위치로 파일 업로드
							// 업데이터 이전 물리적 파일은 그대로 있음( * NAS PULL 주의)
							mf.transferTo(uploadFile);
						}
						catch (IllegalStateException | IOException e)
						{
							e.printStackTrace();
						}
						
					}
				}
				
			}
		}

		if (result.equals(Constants.RESULT_SUCCESS))
		{
			// 결과값에 따른 메시지를 담아 전송
			Map<String, String> map = new HashMap<String, String>();
			map.put(Constants.RESULT_KEY, Constants.RESULT_SUCCESS);
			map.put(Constants.RESULT_MASAGE_KEY, "처리가 완료되었습니다.");
			return map;
		}
		else if (result.equals(Constants.RESULT_FAIL))
		{
			// 실패한경우(실패 메시지가 없는 경우)
			throw new Exception();
		}
		else
		{
			// 실패한경우(실패 메시지가 있는 경우)
			throw new Exception(result);
		}
	}

	/**
	 * 
	 * @메소드명	: eduDel
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육 정보 삭제
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, String> eduDel(CommandMap commandMap) throws ApplicationException, Exception {
		
		// 결과값 최초
		String result = Constants.RESULT_FAIL;

		// 교육정보 삭제
		int delResult = eduDao.eduDel(commandMap.getMap());
		
		if (delResult == 0)
		{
			result = Constants.RESULT_FAIL;
		}
		else
		{
			result = Constants.RESULT_SUCCESS;
			
			// 교육 정보가 삭제 되었다면, 첨부파일도 함께 삭제
			int attachDelResult = eduDao.eduAttachDel(commandMap.getMap());
			
			if (attachDelResult == 0)
			{
				result = Constants.RESULT_FAIL;
			}
			else
			{
				result = Constants.RESULT_SUCCESS;
			}
			
			// 답안지 삭제
			// 꼭 답안지 삭제 후 문제지를 삭제 해야된다.
			// * 문제지를 먼저 삭제하면 문제지 Key를 손실하므로 답안지 삭제시 오류 발생. *
			int ansDelResult = eduDao.ansDel(commandMap.getMap());
			
			if (ansDelResult == 0)
			{
				result = Constants.RESULT_FAIL;
			}
			else
			{
				result = Constants.RESULT_SUCCESS;
			}
			
			// 문제지 삭제
			// 위의 로직과 순서가 바뀌면 안된다.
			int queDelResult = eduDao.queDel(commandMap.getMap());
			
			if (queDelResult == 0)
			{
				result = Constants.RESULT_FAIL;
			}
			else
			{
				result = Constants.RESULT_SUCCESS;
			}
			
		}

		// 결과값에 따른 메시지를 담아 전송
		Map<String, String> map = new HashMap<String, String>();
		if (result.equals(Constants.RESULT_SUCCESS))
		{
			map.put(Constants.RESULT_KEY, Constants.RESULT_SUCCESS);
			map.put(Constants.RESULT_MASAGE_KEY, "처리가 완료되었습니다.");
			return map;
		}
		else if (result.equals(Constants.RESULT_FAIL))
		{
			map.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map;
		}
		else
		{
			map.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map;
		}
	}

	/**
	 * 
	 * @메소드명	: getQueList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제목록 리스트	
	 * 	</pre>
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
		
		List<Map<String, Object>> listData = eduDao.getQueList(commandMap.getMap());
		
		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0)
		{
			listRowCnt = listData.get(0).get("CNT").toString();
		}
		else
		{
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging"))
		{
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
	 * @메소드명	: queSave
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제상세 저장	
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, String> queSave(CommandMap commandMap) throws ApplicationException, Exception {
		
		// 결과값 최초
		String result = Constants.RESULT_FAIL;
		
		if (commandMap.get("que_pk").equals(""))
		{
			
			int quePk = eduDao.getQuePk(commandMap.getMap());
			
			commandMap.put("que_pk", quePk);
			
			// 등록
			int insertResult = eduDao.queInsert(commandMap.getMap());

			if (insertResult == 0)
			{
				result = Constants.RESULT_FAIL;
			}
			else
			{
				result = Constants.RESULT_SUCCESS;
				
				// 문제를 등록했다면 그에따른 답안지 리스트를 저장
				String tableArray = (String) commandMap.get("tableArray");
		        String[] ansList = tableArray.split(",");
		        
		        for (String data : ansList) {
		        	
		        	commandMap.put("ans_subject", data);
		        	
		        	int insertAnsResult = eduDao.ansInsert(commandMap.getMap());
		        	
		        	if (insertAnsResult == 0)
					{
						result = Constants.RESULT_FAIL;
					}
					else
					{
						result = Constants.RESULT_SUCCESS;
					}
		        	
		        }
				
			}
		}
		else
		{
			// 수정
			// 해당 부분 수정해야됨. 문제에 따른 답안지 채번이 바뀌므로 업데이트가 아닌 
			// 문제에 대한 답안지 삭제 후 재 입력하는 방식으로 로직 변경
			
			int queToAnsDelResult = eduDao.queToAnsDel(commandMap.getMap());
			
			if (queToAnsDelResult == 0)
			{
				result = Constants.RESULT_FAIL;
			}
			else
			{
				result = Constants.RESULT_SUCCESS;
				
				int updateResult = eduDao.queUpdate(commandMap.getMap());

				if (updateResult == 0)
				{
					result = Constants.RESULT_FAIL;
				}
				else
				{
					result = Constants.RESULT_SUCCESS;
				}
				
				
				// 문제를 등록했다면 그에따른 답안지 리스트를 저장
				String tableArray = (String) commandMap.get("tableArray");
		        String[] ansList = tableArray.split(",");
		        
		        for (String data : ansList) {
		        	
		        	commandMap.put("ans_subject", data);
		        	
		        	int insertAnsResult = eduDao.ansInsert(commandMap.getMap());
		        	
		        	if (insertAnsResult == 0)
					{
						result = Constants.RESULT_FAIL;
					}
					else
					{
						result = Constants.RESULT_SUCCESS;
					}
		        	
		        }
		        
		        
			}
			
			
		}

		if (result.equals(Constants.RESULT_SUCCESS))
		{
			// 결과값에 따른 메시지를 담아 전송
			Map<String, String> map = new HashMap<String, String>();
			map.put(Constants.RESULT_KEY, Constants.RESULT_SUCCESS);
			map.put(Constants.RESULT_MASAGE_KEY, "처리가 완료되었습니다.");
			return map;
		}
		else if (result.equals(Constants.RESULT_FAIL))
		{
			// 실패한경우(실패 메시지가 없는 경우)
			throw new Exception();
		}
		else
		{
			// 실패한경우(실패 메시지가 있는 경우)
			throw new Exception(result);
		}
	}

	/**
	 * 
	 * @메소드명	: getQue
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제상세 정보	
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getQue(CommandMap commandMap) throws ApplicationException, Exception {
		return eduDao.getQue(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명	: getAnsList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제에 따른 답안지 리스트	
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> getAnsList(CommandMap commandMap) throws ApplicationException, Exception {
		return eduDao.getAnsList(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명	: queDel
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제 삭제	
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, String> queDel(CommandMap commandMap) throws ApplicationException, Exception {
		
		// 결과값 최초
		String result = Constants.RESULT_FAIL;

		int queToAnsDelResult = eduDao.queToAnsDel(commandMap.getMap());
		
		if (queToAnsDelResult == 0)
		{
			result = Constants.RESULT_FAIL;
		}
		else
		{
			// 문제지 삭제
			int queToQueDelResult = eduDao.queToQueDel(commandMap.getMap());
			
			if (queToQueDelResult == 0)
			{
				result = Constants.RESULT_FAIL;
			}
			else
			{
				result = Constants.RESULT_SUCCESS;
			}
			
		}

		// 결과값에 따른 메시지를 담아 전송
		Map<String, String> map = new HashMap<String, String>();
		if (result.equals(Constants.RESULT_SUCCESS))
		{
			map.put(Constants.RESULT_KEY, Constants.RESULT_SUCCESS);
			map.put(Constants.RESULT_MASAGE_KEY, "처리가 완료되었습니다.");
			return map;
		}
		else if (result.equals(Constants.RESULT_FAIL))
		{
			map.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map;
		}
		else
		{
			map.put(Constants.RESULT_KEY, Constants.RESULT_FAIL);
			map.put(Constants.RESULT_MASAGE_KEY, "삭제에 실패했습니다.");
			return map;
		}
	}

	/**
	 * 
	 * @메소드명	: getClsCodeList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육대상 사업부 리스트	
	 * 	</pre>
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
		
		List<Map<String, Object>> listData = eduDao.getClsCodeList(commandMap.getMap());
		
		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0)
		{
			listRowCnt = listData.get(0).get("CNT").toString();
		}
		else
		{
			listRowCnt = 0;
		}
	
		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging"))
		{
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
	 * @메소드명	: getLocCodeList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육대상 사업장 리스트	
	 * 	</pre>
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
		
		List<Map<String, Object>> listData = eduDao.getLocCodeList(commandMap.getMap());
		
		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0)
		{
			listRowCnt = listData.get(0).get("CNT").toString();
		}
		else
		{
			listRowCnt = 0;
		}
	
		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging"))
		{
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
	 * @메소드명	: getTeamCodeList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육대상 부서(팀) 리스트	
	 * 	</pre>
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
		
		List<Map<String, Object>> listData = eduDao.getTeamCodeList(commandMap.getMap());
		
		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0)
		{
			listRowCnt = listData.get(0).get("CNT").toString();
		}
		else
		{
			listRowCnt = 0;
		}
	
		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging"))
		{
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
	 * @메소드명	: getEduList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육 현황 리스트
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getEduRltList(com.globaldenso.dnkr.constant.CommandMap commandMap) throws ApplicationException {
		
		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);
		
		List<Map<String, Object>> listData = eduDao.getEduRltList(commandMap.getMap());
		
		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0)
		{
			listRowCnt = listData.get(0).get("CNT").toString();
		}
		else
		{
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging"))
		{
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
	 * @메소드명	: getEduDtlRltList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육 현황 리스트
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getEduDtlRltList(com.globaldenso.dnkr.constant.CommandMap commandMap) throws ApplicationException {
		
		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);
		
		List<Map<String, Object>> listData = eduDao.getEduRltDtlList(commandMap.getMap());
		
		// 리스트 총 사이즈를 구한다.
		Object listRowCnt = listData.size();
		if (listData.size() > 0)
		{
			listRowCnt = listData.get(0).get("CNT").toString();
		}
		else
		{
			listRowCnt = 0;
		}

		// 라스트 페이지를 구한다.
		Object lastPageCnt = "page>total";
		if (!Constants.NO.equals("isPaging"))
		{
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

}
