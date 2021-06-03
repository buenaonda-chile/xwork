package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.domain.SurveyDomain;
import com.globaldenso.dnkr.domain.TargetDomain;

/**
 * [KR] 설문조사 관리 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface SurveyService {

    /**
     * @param form SurveyDomain
     * @return searchCount(SurveyDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(SurveyDomain form) throws ApplicationException;

    /**
     * @param form SurveyDomain
     * @return List<SurveyDomain> searchByConditionForPaging(
        SurveyDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SurveyDomain> searchByConditionForPaging(
        SurveyDomain form) throws ApplicationException;
    
    /**
     * @param form SurveyDomain
     * @param langList List<String>
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(SurveyDomain form, List<String> langList) throws ApplicationException;

    /**
     * @param form SurveyDomain
     * @return SurveyDomain view(SurveyDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SurveyDomain view(SurveyDomain form) throws ApplicationException;

    /**
     * @param form SurveyDomain
     * @return update(SurveyDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(SurveyDomain form) throws ApplicationException;

    /**
     * @param domain QuestionDomain
     * @param mode String
     * @return int of delete
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(QuestionDomain domain, String mode) throws ApplicationException;

    /**
     * @param form QuestionDomain
     * @param langList List<String>
     * @param aswTitle String[]
     * @return questionCreate(QuestionDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int questionCreate(QuestionDomain form, List<String> langList, String[] aswTitle) throws ApplicationException;

    /**
     * @param form QuestionDomain
     * @return List<QuestionDomain> questionView(QuestionDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<QuestionDomain> questionView(QuestionDomain form) throws ApplicationException;

    /**
     * @param form QuestionDomain
     * @return List<QuestionDomain> answerView(QuestionDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<QuestionDomain> answerView(QuestionDomain form) throws ApplicationException;

    /**
     * @param form QuestionDomain
     * @return QuestionDomain questionModi(QuestionDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public QuestionDomain questionModi(QuestionDomain form) throws ApplicationException;

    /**
     * @param form QuestionDomain
     * @param aswTitle String[]
     * @return int of questionUpdate
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int questionUpdate(QuestionDomain form, String[] aswTitle) throws ApplicationException;

    /**
     * @param form QuestionDomain
     * @return int of questionDelete
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int questionDelete(QuestionDomain form) throws ApplicationException;

    /**
     * @return String questionMaxCode
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String questionMaxCode() throws ApplicationException;

    /**
     * @param srvCode String
     * @param maxSrvCode String
     * @return Boolean
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public Boolean questionPrev(String srvCode, String maxSrvCode) throws ApplicationException;

    /**
     * @param form SurveyDomain
     * @return int of srvUseUpdate
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int srvUseUpdate(SurveyDomain form) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @return int of targetMulCreate
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int targetMulCreate(TargetDomain form) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @return int of targetDesCreate
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int targetDesCreate(TargetDomain form) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @return int of searchTargetCount
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchTargetCount(TargetDomain form) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @return int of searchTargetCount
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchAnonyTargetCount(TargetDomain form) throws ApplicationException;
    
    /**
     * @param form TargetDomain
     * @return List<TargetDomain> searchByTargetPaging(TargetDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<TargetDomain> searchByTargetPaging(TargetDomain form) throws ApplicationException;

    /**
     * @param aswCode String
     * @return int of answerTotalCount
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int answerTotalCount(String aswCode) throws ApplicationException;

    /**
     * @param targetDomain TargetDomain
     * @return List<String> answerTotalDesView(TargetDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<String> answerTotalDesView(TargetDomain targetDomain) throws ApplicationException;

    /**
     * @param target TargetDomain
     * @return answerTotalMulView(TargetDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String answerTotalMulView(TargetDomain target) throws ApplicationException;

    /**
     * @param target TargetDomain
     * @return answerDesView(TargetDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String answerDesView(TargetDomain target) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @return int of searchEmployCount
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchEmployCount(TargetDomain form) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @return List<TargetDomain> searchByConditionEmployForPaging(TargetDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<TargetDomain> searchByConditionEmployForPaging(TargetDomain form) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @param empNumberList String[]
     * @return createEmpTarget
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int createEmpTarget(TargetDomain form, String[] empNumberList) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @param empNumberList String[]
     * @return deleteEmpTarget
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteEmpTarget(TargetDomain form, String[] empNumberList) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @return List<TargetDomain> searchByTeamListCondition(TargetDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<TargetDomain> searchByTeamListCondition(TargetDomain form) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @param empNumberList String[]
     * @return createTeamTarget
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int createTeamTarget(TargetDomain form, String[] empNumberList) throws ApplicationException;

    /**
     * @param form TargetDomain
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchTargetTotCount(TargetDomain form) throws ApplicationException;
    
    /**
     * @param domain TargetDomain
     * @return String
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String searchMaxAnonyEmpNum(TargetDomain domain) throws ApplicationException;

    /**
     * @param form QuestionDomain
     * @return List<QuestionDomain> questionView(QuestionDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<QuestionDomain> searchByResponseEmpList(QuestionDomain form) throws ApplicationException;
    
    /**
     * @param form QuestionDomain
     * @return List<QuestionDomain> questionView(QuestionDomain)
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<QuestionDomain> searchByResponseList(QuestionDomain form) throws ApplicationException;
}
