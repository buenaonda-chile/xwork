package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.domain.SurveyDomain;
import com.globaldenso.dnkr.domain.TargetDomain;

/**
 * [KO] 설문조사 정보의 DAO interface.<br>
 * [EN] <br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface SurveyDao {

    /**
     * 
     * 
     * @param form SurveyDomain
     * @return int
     * @throws ApplicationException 
     */
    public int searchCount(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @return List<SurveyDomain>
     * @throws ApplicationException 
     */
    public List<SurveyDomain> searchByConditionForPaging(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @throws ApplicationException 
     */
    public void create(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @return String
     * @throws ApplicationException 
     */
    public String searchMaxCount(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @throws ApplicationException 
     */
    public void createName(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @return SurveyDomain
     * @throws ApplicationException 
     */
    public SurveyDomain view(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @return int
     * @throws ApplicationException 
     */
    public int update(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @return int
     * @throws ApplicationException 
     */
    public int updateName(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @return int
     * @throws ApplicationException 
     */
    public int delete(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @return int
     * @throws ApplicationException 
     */
    public int deleteName(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int questionCreate(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @return String
     * @throws ApplicationException 
     */
    public String questionMaxCode() throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int questionCreateName(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int answerCreate(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @return String
     * @throws ApplicationException 
     */
    public String answerMaxCode() throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int answerCreateName(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return List<QuestionDomain>
     * @throws ApplicationException 
     */
    public List<QuestionDomain> questionView(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return List<QuestionDomain>
     * @throws ApplicationException 
     */
    public List<QuestionDomain> answerView(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return QuestionDomain
     * @throws ApplicationException 
     */
    public QuestionDomain questionModi(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int questionNameUpdate(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int answerNameDelete(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int answerDelete(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return String
     * @throws ApplicationException 
     */
    public String getAswCode(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int questionDelete(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int questionNameDelete(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException 
     */
    public int answerCount(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return List<String>
     * @throws ApplicationException 
     */
    public List<String> answerCodeList(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @return String
     * @throws ApplicationException 
     */
    public String questionSrvMaxCode() throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return List<QuestionDomain>
     * @throws ApplicationException 
     */
    public List<QuestionDomain> questionList(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return  List<QuestionDomain>
     * @throws ApplicationException 
     */
    public List<QuestionDomain> questionNameList(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form QuestionDomain
     * @return List<QuestionDomain>
     * @throws ApplicationException 
     */
    public List<QuestionDomain> answerList(QuestionDomain form) throws ApplicationException;
    
    /**
     * 
     * 
     * @param form QuestionDomain
     * @return List<QuestionDomain>
     * @throws ApplicationException 
     */
    public List<QuestionDomain> answerNameList(QuestionDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form SurveyDomain
     * @return int
     * @throws ApplicationException 
     */
    public int srvUseUpdate(SurveyDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return int
     * @throws ApplicationException 
     */
    public int targetMulCreate(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return int
     * @throws ApplicationException 
     */
    public int targetDesCreate(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return int
     * @throws ApplicationException 
     */
    public int searchTargetCount(TargetDomain form) throws ApplicationException;
    
    /**
     * 
     * 
     * @param form TargetDomain
     * @return int
     * @throws ApplicationException 
     */
    public int searchAnonyTargetCount(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return List<TargetDomain>
     * @throws ApplicationException 
     */
    public List<TargetDomain> searchByTargetPaging(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param aswCode String
     * @return int
     * @throws ApplicationException 
     */
    public int answerTotalCount(String aswCode) throws ApplicationException;

    /**
     * 
     * 
     * @param targetDomain TargetDomain
     * @return List<String>
     * @throws ApplicationException 
     */
    public List<String> answerTotalDesView(TargetDomain targetDomain) throws ApplicationException;

    /**
     * 
     * 
     * @param targetDomain TargetDomain
     * @return String
     * @throws ApplicationException 
     */
    public String answerTotalMulView(TargetDomain targetDomain) throws ApplicationException;

    /**
     * 
     * 
     * @param target TargetDomain
     * @return String
     * @throws ApplicationException 
     */
    public String answerDesView(TargetDomain target) throws ApplicationException;

    /**
     * 
     * 
     * @param rtnMap HashMap
     * @return HashMap
     * @throws ApplicationException 
     */
    public HashMap procDelete(HashMap rtnMap) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return int
     */
    public int searchEmployCount(TargetDomain form);

    /**
     * 
     * 
     * @param form TargetDomain
     * @return List<TargetDomain>
     * @throws ApplicationException 
     */
    public List<TargetDomain> searchByConditionEmployForPaging(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return int
     * @throws ApplicationException 
     */
    public int createEmpTarget(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return int
     * @throws ApplicationException 
     */
    public int deleteEmpTarget(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return List<TargetDomain>
     * @throws ApplicationException 
     */
    public List<TargetDomain> searchByTeamListCondition(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return List<TargetDomain>
     * @throws ApplicationException 
     */
    public List<TargetDomain> createEmpTeamTarget(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param form TargetDomain
     * @return int
     * @throws ApplicationException 
     */
    public int searchTargetEmpCount(TargetDomain form) throws ApplicationException;

    /**
     * 
     * 
     * @param domain TargetDomain
     * @return int
     * @throws ApplicationException 
     */
    public int searchTargetTotCount(TargetDomain domain) throws ApplicationException;
    
    /**
     * 
     * 
     * @param domain TargetDomain
     * @return String
     * @throws ApplicationException 
     */
    public String searchMaxAnonyEmpNum(TargetDomain domain) throws ApplicationException;
    
    /**
     * 
     * 
     * @param form QuestionDomain
     * @return List<QuestionDomain>
     * @throws ApplicationException 
     */
    public List<QuestionDomain> searchByResponseEmpList(QuestionDomain form) throws ApplicationException;
    
    /**
     * 
     * 
     * @param form QuestionDomain
     * @return List<QuestionDomain>
     * @throws ApplicationException 
     */
    public List<QuestionDomain> searchByResponseList(QuestionDomain form) throws ApplicationException;
}
