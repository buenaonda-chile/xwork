package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.constant.CommandMap;
import com.globaldenso.dnkr.constant.Constants;
import com.globaldenso.dnkr.constant.PageUtil;
import com.globaldenso.dnkr.integration.dao.EduUserDao;

/**
 * 
 * @파일명		: EduUserServiceImpl.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		사용자 교육 ServiceImpl
 * </pre>
 */
@Service("eduService")
public class EduUserServiceImpl implements EduUserService {
	
	@Autowired
    private EduUserDao eduUserDao;

	/**
	 * 
	 * @메소드명	: getEduUserList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		사용자 교육화면 정보
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getEduUser(CommandMap commandMap) throws ApplicationException {
		return eduUserDao.getEduUser(commandMap.getMap());
	}
	
	/**
	 * 
	 * @메소드명	: getEduUserInfo
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		사용자 교육의 참여 정보
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getEduUserInfo(CommandMap commandMap) throws ApplicationException {
		return eduUserDao.getEduUserInfo(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명	: userQueList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육에 따른 문제 리스트	
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> userQueList(CommandMap commandMap) throws ApplicationException {
		return eduUserDao.userQueList(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명	: userAnsList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육에 따른 문제 리스트 - 답안지 리스트
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> userAnsList(CommandMap commandMap) throws ApplicationException {
		return eduUserDao.userAnsList(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명	: eduUserSave
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육이수 답안지 제출
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, String> eduUserSave(CommandMap commandMap) throws Exception {
		
		// 결과값 최초
		String result = Constants.RESULT_FAIL;
		
		//MultipartFile mf = null;
		//File uploadFile = null;
		
		/*Map<String, MultipartFile> fileMap = request.getFileMap();
		
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet())
		{
			mf = entity.getValue();
		}
		
		String uploadDir = UxisCmmUtil.getProperty("eduUser.uploadpath");
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
		}*/
		
		// 등록
		int insertResult = eduUserDao.eduUserInsert(commandMap.getMap());

		if (insertResult == 0)
		{
			result = Constants.RESULT_FAIL;
		}
		else
		{
			result = Constants.RESULT_SUCCESS;
			
			// 첨부파일 사이즈 확인 후 있으면 저장
			/*if(size > 0) {
				
				int attachInsertResult = eduUserDao.eduUserAttchInsert(commandMap.getMap());
				
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
				
			}*/
			
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
	 * @메소드명	: getEduAgree
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		사용자 동의서 내용	
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getEduAgree(CommandMap commandMap) throws ApplicationException, Exception {
		return eduUserDao.getEduAgree(commandMap.getMap());
	}

	/**
	 * 
	 * @메소드명	: agreeConfirm
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		사용자 동의서 확인	
	 * 	</pre>
	 * @param commandMap
	 * @return
	 * @throws ApplicationException
	 * @throws Exception
	 */
	@Override
	public Map<String, String> agreeConfirm(CommandMap commandMap) throws ApplicationException, Exception {
		
		// 결과값 최초
		String result = Constants.RESULT_FAIL;
		
		// 사용자가 제출한 교육에 대해서 동의상태 수정 : Flag(Y)
		int updateResult = eduUserDao.agreeConfirm(commandMap.getMap());
		

		if (updateResult == 0)
		{
			result = Constants.RESULT_FAIL;
		}
		else
		{
			result = Constants.RESULT_SUCCESS;
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

	@Override
	public Map<String, Object> getEduSelectList(CommandMap commandMap) throws ApplicationException {
		// 리스트를 취득한다.
		Object pageSize = commandMap.get(Constants.FROM_GRID_PAGE_SIZE);
		Object curPageNo = commandMap.get(Constants.FROM_GRID_CUR_PAGE_NO);
		commandMap.put(Constants.SET_DB_PAGE_SIZE, pageSize);
		commandMap.put(Constants.SET_DB_CUR_PAGE_NO, curPageNo);
		
		List<Map<String, Object>> listData = eduUserDao.getEduSelectList(commandMap.getMap());
		
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
