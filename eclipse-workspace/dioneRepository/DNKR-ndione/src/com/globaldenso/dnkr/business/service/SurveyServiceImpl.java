package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.domain.SurveyDomain;
import com.globaldenso.dnkr.domain.TargetDomain;
import com.globaldenso.dnkr.integration.dao.SurveyDao;

/**
 * [KO] 설문조사 관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("surveyService")
public class SurveyServiceImpl implements SurveyService {
    
    /**
     * [KO] 설문조사 관리 Dao <br>
     */
    @Autowired
    private SurveyDao surveyDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public SurveyServiceImpl() {
        // no process
    }
    /**
     * 
     * @param surveyDao SurveyDao
     */
    public void setSurveyDao(SurveyDao surveyDao){
        this.surveyDao = surveyDao;     
    }


    @Override
    public int searchCount(SurveyDomain form)
        throws ApplicationException {
        return surveyDao.searchCount(form);
    }

    @Override
    public List<SurveyDomain> searchByConditionForPaging(
        SurveyDomain form) throws ApplicationException {
        return surveyDao.searchByConditionForPaging(form);
    }

    @Override
    public void create(SurveyDomain form, List<String> langList) throws ApplicationException {
        try{
            String srvCode = surveyDao.searchMaxCount(form);
            srvCode = Integer.toString( Integer.parseInt(srvCode) + 1 ) ;
            form.setSrvCode(srvCode);
            
            surveyDao.create(form);
            //언어별 Menu code name 레코드 추가
            if (langList.size() > 0) {
                for (String langCode : langList) {
                    form.setCmcCode(langCode);
                    createName(form);   
                }
            }
            
            //익명 설문 생성 일 시 팀선택 문항(주관식) 추가
            if(form.getSrvAnonymous().equals("Y")) {
	            QuestionDomain domain = new QuestionDomain();
	            domain.setSrvCode(srvCode);
	            domain.setQstType("text");
	            domain.setQstTitle(DnkrConstans.SURVEY_SELECT_TEAM_QST);
	            int result = questionCreate(domain, langList, null);
            }
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    /**
     * 
     * @param form SurveyDomain
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    private void createName(SurveyDomain form) throws ApplicationException{
        surveyDao.createName(form);
    }

    @Override
    public SurveyDomain view(SurveyDomain form) throws ApplicationException {
        return surveyDao.view(form);
    }

    @Override
    public int update(SurveyDomain form) throws ApplicationException {
        int cnt = 0;
        
        try{
            cnt = surveyDao.updateName(form);
            cnt *= surveyDao.update(form);
        }catch(Exception e){
            e.getMessage();
        }
        return cnt;
    }

    @Override
    public int delete(QuestionDomain domain, String mode) throws ApplicationException {
        int result = 0;
        
        if(mode.equals("QUESTION")) {//mode:QUESTION
            
            result = questionDelete(domain);
            
        } else if(mode.equals("ANSWER")) {//mode:ANSWER
            
            domain.setAswCode(domain.getQstCode());
            domain.setQstCode(null);
            result = answerDelete(domain);
            
        } else if(mode.equals("ALL")) {
            
            SurveyDomain surveyDomain = new SurveyDomain();
            surveyDomain.setSrvCode(domain.getSrvCode());
            result = answerDelete(domain);
            result = questionDelete(domain);
            result = surveyDao.deleteName(surveyDomain);
            result = surveyDao.delete(surveyDomain);
        }
        return result;
    }
    
    /*
    @Override
    public int delete(String srvCode, String mode) throws ApplicationException {
        HashMap rtnMap = new HashMap();
        rtnMap.put("srvCode", srvCode);
        rtnMap.put("mode", mode);
        int result = 0;
        surveyDao.procDelete(rtnMap);
        System.out.println("result : " + rtnMap.get("rtnCnt"));
        //result = Integer.parseInt((String) rtnMap.get("rtnCnt"));
        if(rtnMap.get("rtnCnt") != null){
            result = 1;
        }
        return result;
    }*/

    @Override
    public int questionCreate(QuestionDomain form, List<String> langList, String[] aswTitle)
            throws ApplicationException {
        String qstCode = surveyDao.questionMaxCode();
        qstCode = Integer.toString( Integer.parseInt(qstCode) + 1 );
        form.setQstCode(qstCode);
        int result = 0;
        try{
                //질문생성
            result = surveyDao.questionCreate(form);
            if (langList.size() > 0 && result != 0) {
                for (String langCode : langList) {
                    form.setCmcCode(langCode);
                    result *= surveyDao.questionCreateName(form);   
                }
            }
            //질문 답변 생성
            if(!form.getQstType().equals("text") && result != 0){
                if (langList.size() > 0) {
                    String aswCode = "";
                    for(int i = 0; i < aswTitle.length; i++){
                        aswCode = surveyDao.answerMaxCode();
                        aswCode = Integer.toString(Integer.parseInt(aswCode) + 1);
                        form.setAswCode(aswCode);
                        if(aswTitle[i] != null && ! aswTitle[i].trim().equals("")) {
	                        result *= surveyDao.answerCreate(form);
	                        form.setAswTitle(aswTitle[i]);
	                        for (String langCode : langList) {
	                            form.setCmcCode(langCode);
	                            if(form.getAswTitle() != null && !form.getAswTitle().equals("")){
	                                result *= surveyDao.answerCreateName(form);
	                            }
	                        }
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("설문조사 질문만드는 과정에서 에러발생");
            e.getMessage();
        }
        return result;
    }

    @Override
    public List<QuestionDomain> questionView(QuestionDomain form)
        throws ApplicationException {
        return surveyDao.questionView(form);
    }

    @Override
    public List<QuestionDomain> answerView(QuestionDomain form)
        throws ApplicationException {
        return surveyDao.answerView(form);
    }

    @Override
    public QuestionDomain questionModi(QuestionDomain form)
        throws ApplicationException {
        return surveyDao.questionModi(form);
    }

    @Override
    public int questionUpdate(QuestionDomain form, String[] aswTitle) throws ApplicationException {
        int result = 0;
        
        surveyDao.questionNameUpdate(form);
        
        if(!form.getQstType().equals("text") && form.getQstType() != null){//설물문항타입: 객관식
            if(form.getQstCode() != null && form.getSrvCode() != null){
                int aswCnt = surveyDao.answerCount(form);
                if(aswTitle.length > aswCnt){
                    String aswCode = "0";
                    for(int i = 0; i < aswTitle.length - aswCnt; i++){
                        aswCode = surveyDao.answerMaxCode();
                        aswCode = Integer.toString( Integer.parseInt( aswCode ) + 1 );
                        form.setAswCode(aswCode);
                        surveyDao.answerCreate(form);//설문답항 코드 만들기
                    }
                }
                
                List<String> list = surveyDao.answerCodeList(form);
                int count = 0;
                for (String answerCode : list) {
                    form.setAswTitle(aswTitle[count]);
                    form.setAswCode(answerCode);
                    result *= surveyDao.answerNameDelete(form);
                    if(form.getAswTitle() != null && !form.getAswTitle().equals("")){
                        result *= surveyDao.answerCreateName(form);
                    }
                    count++;
                }
            }
        }
        return result;
    }

    @Override
    public int questionDelete(QuestionDomain form)
        throws ApplicationException {
        int result = 0;
        if(form.getQstCode() != null && form.getSrvCode() != null){
            List<String> list = surveyDao.answerCodeList(form);
            for (String answerCode : list) {
                form.setAswCode(answerCode);
                if(form.getAswCode() != null){
                    result = answerDelete(form);
                }
            }
        }
//        result *= surveyDao.questionNameDelete(form);
        result = surveyDao.questionNameDelete(form);
        if(result != 0){
            result *= surveyDao.questionDelete(form);
        }
        return result;
    }

    /**
     * @param form QuestionDomain
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int answerDelete(QuestionDomain form) throws ApplicationException {
        int result = 0;
        result = surveyDao.answerNameDelete(form);
        System.out.println("answerNameDelete result:" + result);
        if(result != 0){
            result *= surveyDao.answerDelete(form);
        }
        return result;
    }

    @Override
    public String questionMaxCode() throws ApplicationException {
        return surveyDao.questionSrvMaxCode();
    }

    @Override
    public Boolean questionPrev(String srvCode, String maxSrvCode) throws ApplicationException {
        Boolean result = true;
        QuestionDomain form = new QuestionDomain();
        form.setSrvCode(srvCode);
        
        try{
            
            surveyDao.answerNameDelete(form);
            surveyDao.answerDelete(form);
            surveyDao.questionNameDelete(form);
            surveyDao.questionDelete(form);
            
            form.setSrvCode(maxSrvCode);
            List<QuestionDomain> questionList = surveyDao.questionList(form);
            
            for (QuestionDomain question : questionList) {
                form.setQstCode(question.getQstCode());
                String qstCode = surveyDao.questionMaxCode();
                qstCode = Integer.toString(Integer.parseInt(qstCode) + 1);
                question.setQstCode(qstCode);
                question.setSrvCode(srvCode);
                surveyDao.questionCreate(question);
                List<QuestionDomain> questionNameList = surveyDao.questionNameList(form);
                for (QuestionDomain questionName : questionNameList) {
                    questionName.setQstCode(question.getQstCode());
                    questionName.setSrvCode(question.getSrvCode());
                    surveyDao.questionCreateName(questionName);
                    
                }
                List<QuestionDomain> answerList = surveyDao.answerList(form);
                for (QuestionDomain answer : answerList) {
                    form.setAswCode(answer.getAswCode());
                    List<QuestionDomain> answerNameList = surveyDao.answerNameList(form);
                    String aswCode = surveyDao.answerMaxCode();
                    aswCode = Integer.toString(Integer.parseInt(aswCode) + 1);
                    answer.setAswCode(aswCode);
                    answer.setQstCode(question.getQstCode());
                    answer.setSrvCode(question.getSrvCode());
                    surveyDao.answerCreate(answer);
            
                    for (QuestionDomain answerName : answerNameList) {
                        answerName.setSrvCode(answer.getSrvCode());
                        answerName.setAswCode(answer.getAswCode());
                        surveyDao.answerCreateName(answerName);
                    }
                }
            }
        }catch(Exception e){
            result = false;
        }
        return result;
    }

    @Override
    public int srvUseUpdate(SurveyDomain form) throws ApplicationException {
        return surveyDao.srvUseUpdate(form);
    }

    @Override
    public int targetMulCreate(TargetDomain form) throws ApplicationException {
        return surveyDao.targetMulCreate(form);
    }

    @Override
    public int targetDesCreate(TargetDomain form) throws ApplicationException {
        return surveyDao.targetDesCreate(form);
    }

    @Override
    public int searchTargetCount(TargetDomain form) throws ApplicationException {
        return surveyDao.searchTargetCount(form);
    }
    
    @Override
    public int searchAnonyTargetCount(TargetDomain form) throws ApplicationException {
        return surveyDao.searchAnonyTargetCount(form);
    }

    @Override
    public List<TargetDomain> searchByTargetPaging(TargetDomain form)
            throws ApplicationException {
        return surveyDao.searchByTargetPaging(form);
    }

    @Override
    public int answerTotalCount(String aswCode) throws ApplicationException {
        return surveyDao.answerTotalCount(aswCode);
    }

    @Override
    public List<String> answerTotalDesView(TargetDomain targetDomain)
            throws ApplicationException {
        return surveyDao.answerTotalDesView(targetDomain);
    }

    @Override
    public String answerTotalMulView(TargetDomain target)
            throws ApplicationException {
        return surveyDao.answerTotalMulView(target);
    }

    @Override
    public String answerDesView(TargetDomain target)
            throws ApplicationException {
        return surveyDao.answerDesView(target);
    }

    @Override
    public int searchEmployCount(TargetDomain form) throws ApplicationException {
        return surveyDao.searchEmployCount(form);
    }

    @Override
    public List<TargetDomain> searchByConditionEmployForPaging(TargetDomain form)
            throws ApplicationException {
        return surveyDao.searchByConditionEmployForPaging(form);
    }

    @Override
    public int createEmpTarget(TargetDomain form, String[] empNumberList)
            throws ApplicationException {
        int result = 0;
        int cnt = 0;
        if(empNumberList != null){
            for(String empNumber:empNumberList){
                String[] empSplit = empNumber.split("§");
                form.setEmpNumber(empSplit[0]);
                if(empSplit.length > 1){
                    form.setEmpEmail(empSplit[1]);
                }
                int empCnt = surveyDao.searchTargetEmpCount(form);
                if(empCnt == 0){    
                    result = surveyDao.createEmpTarget(form);
                    cnt++;
                }
                
            }
        }
        return cnt;
    }
    
    @Override
    public int deleteEmpTarget(TargetDomain form, String[] empNumberList)
        throws ApplicationException {
        int result = 0;
        int cnt = 0;
        if(empNumberList != null){
            for(String empNumber:empNumberList){
                String[] empSplit = empNumber.split("§");
                form.setEmpNumber(empSplit[0]);
                if(empSplit.length > 1){
                    form.setEmpEmail(empSplit[1]);
                }
                System.out.println(form.getEmpNumber());
                System.out.println(form.getEmpEmail());
                
                result = surveyDao.deleteEmpTarget(form);
                
                cnt++;
            }
        }
        return cnt;
    }

    @Override
    public List<TargetDomain> searchByTeamListCondition(TargetDomain form)
            throws ApplicationException {
        return surveyDao.searchByTeamListCondition(form);
    }

    @Override
    public int createTeamTarget(TargetDomain form, String[] empNumberList)
            throws ApplicationException {
        int result = 0;
        int cnt = 0;
        for(String teamCode : empNumberList){
            form.setTeamCode(teamCode);
            List<TargetDomain> empList = surveyDao.createEmpTeamTarget(form);
            for(TargetDomain emp : empList){
                form.setEmpNumber(emp.getEmpNumber());
                form.setEmpEmail(emp.getEmpEmail());
                form.setTeamCode(form.getTeamCode());
                int empCnt = surveyDao.searchTargetEmpCount(form);
                if(empCnt == 0){    
                    result = surveyDao.createEmpTarget(form);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Override
    public int searchTargetTotCount(TargetDomain form) throws ApplicationException {
        return surveyDao.searchTargetTotCount(form);
    }

    
    @Override
    public String searchMaxAnonyEmpNum(TargetDomain domain) throws ApplicationException {
        return surveyDao.searchMaxAnonyEmpNum(domain);
    }
    
    @Override
    public List<QuestionDomain> searchByResponseEmpList(QuestionDomain form)
        throws ApplicationException {
        return surveyDao.searchByResponseEmpList(form);
    }
    
    @Override
    public List<QuestionDomain> searchByResponseList(QuestionDomain form)
        throws ApplicationException {
        return surveyDao.searchByResponseList(form);
    }
}
