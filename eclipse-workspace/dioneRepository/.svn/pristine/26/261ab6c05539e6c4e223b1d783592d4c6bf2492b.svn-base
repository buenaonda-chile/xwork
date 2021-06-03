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
 * @파일명		: SalaryUserDaoImpl.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		사용자 교육 DaoImpl
 * </pre>
 */
@Repository("salaryUserDao")
public class SalaryUserDaoImpl implements SalaryUserDao {

	private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.SalaryUserDao";
	
	@Autowired
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate = null;

	/**
	 * 
	 * @메소드명	: getSalaryUserList
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
	public Map<String, Object> getSalaryUser(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getSalaryUser", map);
	}
	
	/**
	 * 
	 * @메소드명	: getFileDataList
	 * @날짜		: 2020. 07. 20.
	 * @작성자		: Kim GyeongJa
	 * @설명 
	 * 	<pre>
	 *		교육현황상세 첨부파일 리스트 취득
	 * 	</pre>
	 * @param edu_pk
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> getFileDataList(String edu_pk) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getFileDataList", edu_pk);
	}
	
	/**
	 * 
	 * @메소드명	: getSalaryUserInfo
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
	public Map<String, Object> getSalaryUserInfo(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getSalaryUserInfo", map);
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
	 * @메소드명	: salaryUserInsert
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
	public int salaryUserUpdate(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.update(NAMESPACE + ".salaryUserUpdate", map);
	}
	
	@Override
	public int setSalaryUserInfoInsert(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".setSalaryUserInfoInsert", map);
	}
	
	@Override
	public int setSalaryUserInfoUpdate(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.update(NAMESPACE + ".setSalaryUserInfoUpdate", map);
	}
	
	
	
	/**
	 * 
	 * @메소드명	: getSalaryAgree
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
	public Map<String, Object> getSalaryAgree(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getSalaryAgree", map);
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
	public int salaryUserAttchInsert(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".salaryUserAttchInsert", map);
	}

	@Override
	public List<Map<String, Object>> getSalarySelectList(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getSalarySelectList", map);
	}

	@Override
	public String getSalaryAttFileName(String edu_pk) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getSalaryAttFileName", edu_pk);
	}
	
}
