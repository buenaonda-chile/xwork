package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.domain.SurveyDomain;
import com.globaldenso.dnkr.domain.TargetDomain;

/**
 * [KO] 설문조자 관리 DAO 구현
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("surveyDao")
public class SurveyDaoImpl implements SurveyDao {
    
    /** */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.SurveyDao";
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    
    @Autowired
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate = null;
    /** Constructor. */
    public SurveyDaoImpl() {
        // no process
    }

    @Override
    public int searchCount(SurveyDomain form)
            throws ApplicationException {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", form);
    }

    @Override
    public List<SurveyDomain> searchByConditionForPaging(SurveyDomain form) {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", form);
    }

    @Override
    public void create(SurveyDomain form) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".create", form);
        
    }

    @Override
    public String searchMaxCount(SurveyDomain form) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchMaxCount", form);
    }

    @Override
    public void createName(SurveyDomain form) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createName", form);
    }

    @Override
    public SurveyDomain view(SurveyDomain form) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".view", form);
    }

    @Override
    public int update(SurveyDomain form) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".update", form);
    }

    @Override
    public int updateName(SurveyDomain form) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateName", form);
    }

    @Override
    public int delete(SurveyDomain form) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", form);
    }

    @Override
    public int deleteName(SurveyDomain form) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteName", form);
    }

    @Override
    public int questionCreate(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".questionCreate", form);
    }

    @Override
    public String questionMaxCode() throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".questionMaxCode");
    }

    @Override
    public int questionCreateName(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".questionCreateName", form);
    }

    @Override
    public int answerCreate(QuestionDomain form) throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".answerCreate", form);
    }

    @Override
    public String answerMaxCode() throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".answerMaxCode");
    }

    @Override
    public int answerCreateName(QuestionDomain form) throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".answerCreateName", form);
    }

    @Override
    public List<QuestionDomain> questionView(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".questionView", form);
    }

    @Override
    public List<QuestionDomain> answerView(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".answerView", form);
    }

    @Override
    public QuestionDomain questionModi(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".questionModi", form);
    }


    @Override
    public int questionNameUpdate(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".questionNameUpdate", form);
    }

    @Override
    public int answerNameDelete(QuestionDomain form) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".answerNameDelete", form);
    }

    @Override
    public int answerDelete(QuestionDomain form) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".answerDelete", form);
    }

    @Override
    public String getAswCode(QuestionDomain form) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".getAswCode", form);
    }

    @Override
    public int questionDelete(QuestionDomain form) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".questionDelete", form);
    }

    @Override
    public int questionNameDelete(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".questionNameDelete", form);
    }

    @Override
    public int answerCount(QuestionDomain form) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".answerCount", form);
    }

    @Override
    public List<String> answerCodeList(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".answerCodeList", form);
    }

    @Override
    public String questionSrvMaxCode() throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".questionSrvMaxCode");
    }

    @Override
    public List<QuestionDomain> questionList(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".questionList", form);
    }

    @Override
    public List<QuestionDomain> questionNameList(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".questionNameList", form);
    }

    @Override
    public List<QuestionDomain> answerList(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".answerList", form);
    }
    
    @Override
    public List<QuestionDomain> answerNameList(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".answerNameList", form);
    }

    @Override
    public int srvUseUpdate(SurveyDomain form) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".srvUseUpdate", form);
    }

    @Override
    public int targetMulCreate(TargetDomain form) throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".targetMulCreate", form);
    }

    @Override
    public int targetDesCreate(TargetDomain form) throws ApplicationException {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.insert(NAMESPACE + ".targetDesCreate", form);
    }

    @Override
    public int searchTargetCount(TargetDomain form) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchTargetCount", form);
    }
    
    @Override
    public int searchAnonyTargetCount(TargetDomain form) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchAnonyTargetCount", form);
    }

    @Override
    public List<TargetDomain> searchByTargetPaging(TargetDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByTargetPaging", form);
    }

    @Override
    public int answerTotalCount(String aswCode) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".answerTotalCount", aswCode);
    }

    @Override
    public List<String> answerTotalDesView(TargetDomain targetDomain)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".answerTotalDesView", targetDomain);
    }

    @Override
    public String answerTotalMulView(TargetDomain targetDomain)
            throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".answerTotalMulView", targetDomain);
    }

    @Override
    public String answerDesView(TargetDomain target)
            throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".answerDesView", target);
    }

    @Override
    public HashMap procDelete(HashMap rtnMap) {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.selectOne(NAMESPACE + ".procDelete", rtnMap);
    }

    @Override
    public int searchEmployCount(TargetDomain form) {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchEmployCount", form);
    }

    @Override
    public List<TargetDomain> searchByConditionEmployForPaging(TargetDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionEmployForPaging", form);
    }

    @Override
    public int createEmpTarget(TargetDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".createEmpTarget", form);
    }
    
    @Override
    public int deleteEmpTarget(TargetDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteEmpTarget", form);
    }

    @Override
    public List<TargetDomain> searchByTeamListCondition(TargetDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByTeamListCondition", form);
    }

    @Override
    public List<TargetDomain> createEmpTeamTarget(TargetDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".createEmpTeamTarget", form);
    }

    @Override
    public int searchTargetEmpCount(TargetDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchTargetEmpCount", form);
    }

    @Override
    public int searchTargetTotCount(TargetDomain domain) {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchTargetTotCount", domain);
    }
    
    @Override
    public String searchMaxAnonyEmpNum(TargetDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchMaxAnonyEmpNum", domain);
    }
    
    @Override
    public List<QuestionDomain> searchByResponseEmpList(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByResponseEmpList", form);
    }
    
    @Override
    public List<QuestionDomain> searchByResponseList(QuestionDomain form)
            throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByResponseList", form);
    }
}
