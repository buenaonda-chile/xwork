package com.globaldenso.dnkr.integration.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;

/**
 * 
 * @파일명		: EduUserDaoImpl.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		사용자 교육 DaoImpl
 * </pre>
 */
@Repository("eduUserDao")
public class EduUserDaoImpl implements EduUserDao {

	private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.EduUserDao";
	
	@Autowired
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate = null;

	/**
	 * 
	 * @메소드명	: getEduUserList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		사용자 교육화면 정보	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getEduUser(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getEduUser", map);
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
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getEduUserInfo(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getEduUserInfo", map);
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
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> userQueList(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".userQueList", map);
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
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> userAnsList(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".userAnsList", map);
	}

	/**
	 * 
	 * @메소드명	: eduUserInsert
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육이수 답안지 제출	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int eduUserInsert(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".eduUserInsert", map);
	}

	/**
	 * 
	 * @메소드명	: getEduAgree
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		동의서 내용 	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getEduAgree(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getEduAgree", map);
	}

	/**
	 * 
	 * @메소드명	: agreeConfirm
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		동의서 확인	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int agreeConfirm(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.update(NAMESPACE + ".agreeConfirm", map);
	}

	@Override
	public int eduUserAttchInsert(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".eduUserAttchInsert", map);
	}

	@Override
	public List<Map<String, Object>> getEduSelectList(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getEduSelectList", map);
	}
	
}
