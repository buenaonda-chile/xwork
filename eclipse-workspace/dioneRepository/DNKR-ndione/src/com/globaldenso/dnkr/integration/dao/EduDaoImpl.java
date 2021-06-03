package com.globaldenso.dnkr.integration.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.EmpDomain;

/**
 * 
 * @파일명		: EduDaoImpl.java 
 * @프로젝트	: DNKR
 * @날짜		: 2019. 9. 20. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 		관리자 교육 DaoImpl
 * </pre>
 */
@Repository("eduDao")
public class EduDaoImpl implements EduDao {

	private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.EduDao";
	
	@Autowired
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate = null;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
	
	/**
	 * 
	 * @메소드명	: getEduList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육목록 리스트	
	 * 	</pre>
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEduList(Map<String, Object> map) {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getEduList", map);
	}
	
	/**
	 * 
	 * @메소드명	: getEdu
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육상세 정보	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getEdu(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getEdu", map);
	}
	
	/**
	 * 
	 * @메소드명	: getEduPk
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육상세 수정을 위한 PK정보	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int getEduPk(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getEduPk", map);
	}
	
	
	/**
	 * 
	 * @메소드명	: getEmpNumber
	 * @날짜		: 2020. 08. 03.
	 * @작성자		: Kim GyeongJa
	 * @설명 
	 * 	<pre>
	 *		교육대상 팀의 코드로 사번 취득
	 * 	</pre>
	 * @param pDepCd
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	//public List<Map<String, Object>> getEmpNumber(Map<String, Object> map) throws ApplicationException {
	public List<Map<String, Object>> getEmpNumber(CaseInsensitiveMap empDomain) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getEmpNumber", empDomain);
	}

	/**
	 * 
	 * @메소드명	: eduInsert
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육상세 정보 입력	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int eduInsert(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".eduInsert", map);
	}
	
	/**
	 * 
	 * @메소드명	: eduAttchInsert
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육상세 첨부파일 입력	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int eduAttchInsert(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".eduAttchInsert", map);
	}

	/**
	 * 
	 * @메소드명	: eduUpdate
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육상세 수정	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int eduUpdate(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".eduUpdate", map);
	}
	
	/**
	 * 
	 * @메소드명	: eduAttachUpdate
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육상세 첨부파일 수정	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
//	@Override
//	public int eduAttachUpdate(Map<String, Object> map) throws ApplicationException {
//		return sqlSessionTemplate.insert(NAMESPACE + ".eduAttachUpdate", map);
//	}
	
	/**
	 * 
	 * @메소드명	: eduAttachAllDel
	 * @날짜		: 2020. 07. 25.
	 * @작성자	: Kim GyeongJa
	 * @설명 
	 * 	<pre>
	 *		교육상세 첨부파일 전체 논리 삭제	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int eduAttachAllDel(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.update(NAMESPACE + ".eduAttachAllDel", map);
	}
	
	/**
	 * 
	 * @메소드명	: eduAttachDel
	 * @날짜		: 2020. 07. 25.
	 * @작성자	: Kim GyeongJa
	 * @설명 
	 * 	<pre>
	 *		교육상세 첨부파일 1건 논리 삭제	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int eduAttachDel(Map<String, Object> map) throws ApplicationException {
		
		return sqlSessionTemplate.update(NAMESPACE + ".eduAttachDel", map);
	}


	/**
	 * 
	 * @메소드명	: eduDel
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육상세 삭제	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int eduDel(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.delete(NAMESPACE + ".eduDel", map);
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
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> getQueList(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getQueList", map);
	}
	
	/**
	 * 
	 * @메소드명	: queInsert
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제상세 입력	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int queInsert(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".queInsert", map);
	}

	/**
	 * 
	 * @메소드명	: queUpdate
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제상세 수정	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int queUpdate(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".queUpdate", map);
	}

	/**
	 * 
	 * @메소드명	: ansInsert
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제상세 수정을 위한 PK정보
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int ansInsert(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.insert(NAMESPACE + ".ansInsert", map);
	}

	/**
	 * 
	 * @메소드명	: getQuePk
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		답안지 입력	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int getQuePk(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getQuePk", map);
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
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public Map<String, Object> getQue(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectOne(NAMESPACE + ".getQue", map);
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
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> getAnsList(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getAnsList", map);
	}

	/**
	 * 
	 * @메소드명	: queDel
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제상세 삭제	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int queDel(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.delete(NAMESPACE + ".queDel", map);
	}
	
	/**
	 * 
	 * @메소드명	: ansDel
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		답안지 리스트 삭제	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int ansDel(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.delete(NAMESPACE + ".ansDel", map);
	}
	
	/**
	 * 
	 * @메소드명	: queToAnsDel
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제에 따른 답안지 삭제	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int queToAnsDel(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.delete(NAMESPACE + ".queToAnsDel", map);
	}
	
	/**
	 * 
	 * @메소드명	: queToQueDel
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		문제에 따른 문제 삭제	
	 * 	</pre>
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public int queToQueDel(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.delete(NAMESPACE + ".queToQueDel", map);
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
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> getClsCodeList(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getClsCodeList", map);
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
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> getLocCodeList(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getLocCodeList", map);
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
	 * @param map
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> getTeamCodeList(Map<String, Object> map) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getTeamCodeList", map);
	}
	
	/**
	 * 
	 * @메소드명	: getEduList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육목록 리스트	
	 * 	</pre>
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEduRltList(Map<String, Object> map) {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getEduList", map);
	}
	
	/**
	 * 
	 * @메소드명	: getEduList
	 * @날짜		: 2019. 9. 20.
	 * @작성자		: Cho HeumJun
	 * @설명 
	 * 	<pre>
	 *		교육현황상세목록 리스트	
	 * 	</pre>
	 * @param map
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getEduRltDtlList(Map<String, Object> map) {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getEduDtlRtlList", map);
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
	 * @메소드명	: getNoEduMailList
	 * @날짜		: 2020. 08. 14.
	 * @작성자		: Kim GyeongJa
	 * @설명 
	 * 	<pre>
	 *		교육대상자중 미완료자 메일 취득
	 * 	</pre>
	 * @param edu_pk
	 * @return
	 * @throws ApplicationException
	 */
	@Override
	public List<Map<String, Object>> getNoEduMailList(String edu_pk) throws ApplicationException {
		return sqlSessionTemplate.selectList(NAMESPACE + ".getNoEduMailList", edu_pk);
	}
}
