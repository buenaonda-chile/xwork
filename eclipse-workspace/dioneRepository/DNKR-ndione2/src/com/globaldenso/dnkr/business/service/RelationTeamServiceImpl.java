package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.MaDeptDomain;
import com.globaldenso.dnkr.domain.RelationClsDomain;
import com.globaldenso.dnkr.domain.RelationTeamDomain;
import com.globaldenso.dnkr.integration.dao.RelationTeamDao;

/**
 * [KR] 사업부서(팀) 관리 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("relationTeamService")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class RelationTeamServiceImpl implements RelationTeamService {

    /**
     * [KR] 사업부서(팀) Dao 필드<br>
     * [EN] A field of RelationTeamDao.<br>
     */
    @Autowired
    private RelationTeamDao relationTeamDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public RelationTeamServiceImpl() {
        // no process
    }
    
    
    /**
     * [EN] Set RelationTeamDao.<br>
     * [JP] <br>
     * 
     * @param relationTeamDao 'RelationTeamDao' class
     */
    public void setRelationTeamDao(RelationTeamDao relationTeamDao) {
        this.relationTeamDao = relationTeamDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#searchByKey(RelationTeamDomain)
     */
    public RelationTeamDomain searchByKey(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.searchByKey(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#searchByCondition(RelationTeamDomain)
     */
    public List<RelationTeamDomain> searchByCondition(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.searchByCondition(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#searchByConditionForPaging(RelationTeamDomain)
     */
    public List<RelationTeamDomain> searchByConditionForPaging(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.searchByConditionForPaging(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#searchCount(RelationTeamDomain)
     */
    public int searchCount(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchCmcCount(CodeDomain)
     */
    public int searchTeamCount(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.searchTeamCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#create(RelationTeamDomain)
     */
    public void create(RelationTeamDomain domain, List<String> langList) throws ApplicationException {
        try {
            relationTeamDao.create(domain, langList);
        } catch (ApplicationException e) {
            if (IntegrationLayerException.UNIQUE_CONSTRAINT_VIOLATION_CODE.equals(e.getCode())) {
                throw new ApplicationException(
                    "SMPL-E8-0004", 
                    MessageSources.getInstance().value("info.employee"));
            } else {
                throw e;
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#update(RelationTeamDomain)
     */
    public int update(RelationTeamDomain domain) throws ApplicationException {
        int upResult = 0;
        upResult += updateCode(domain);
        upResult += updateName(domain);
        return upResult;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#updateCode(RelationTeamDomain)
     */
    public int updateCode(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.updateCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#updateAuth(RelationTeamDomain)
     */
    public int updateAuth(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.updateAuth(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#updateName(RelationTeamDomain)
     */
    public int updateName(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.updateName(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#delete(RelationTeamDomain)
     */
    public int delete(RelationTeamDomain domain) throws ApplicationException {
        int delResult = 0;
        //조직도 명칭 삭제
        delResult += deleteName(domain);
                
        //조직도 삭제
        delResult += deleteCode(domain);
        
        return delResult;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#deleteCode(RelationClsDomain)
     */
    public int deleteCode(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.deleteCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationClsService#deleteName(RelationClsDomain)
     */
    public int deleteName(RelationTeamDomain domain) throws ApplicationException {
        return relationTeamDao.deleteName(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#delete(List)
     */
    public int delete(List<RelationTeamDomain> domainList) throws ApplicationException {
        int deleteCount = 0;
        for (RelationTeamDomain delDomain: domainList) {
            deleteCount += delete(delDomain);
        }
        return deleteCount;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.RelationTeamService#delete(List)
     */
    // 더존 회사코드변경시 수정필요
    public HashMap procMergeDept() throws ApplicationException {
        HashMap rtnMap = new HashMap();

        relationTeamDao.insertDeptTmpData();

        System.out.println("삭제 시작");

        //기존 데이터 삭제
        int delResult = relationTeamDao.deleteTmp();

        System.out.println("삭제 완료 result : " + delResult);

        List<MaDeptDomain> deptList = relationTeamDao.searchMaDeptList();

        System.out.println("데이터 받아오기  size : " + deptList.size());

        int result = relationTeamDao.insertDept(deptList);

        System.out.println("데이터 입력 result : " + result);

        //if(result > 0){
            System.out.println("프로시저 시작");
            relationTeamDao.procMergeTeam(rtnMap);
            System.out.println("프로시저 종료 : " + rtnMap.get("rtnMsg"));
        //}

        // 2020.09.11 : 현재 미사용중인 부서코드의 사용여부를 False로 변경
        String procRlt = rtnMap.get("rtnCd").toString();
        if(procRlt.equals("1")){	//정상적으로 처리된 경우
        	relationTeamDao.updateDeptUseTf(); //현재 미사용중인 부서코드의 사용여부를 False로 변경
        }
        return rtnMap;
    }
    /**
     * 
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    @Scheduled(cron = " 0 0 0 * * * ")
    public void procMergeDeptSch() throws ApplicationException {
        //System.out.println("----부서 스케쥴----");
        HashMap rtnMap = new HashMap();
  
        relationTeamDao.insertDeptTmpData();

        System.out.println("삭제 시작");

        //기존 데이터 삭제
        int delResult = relationTeamDao.deleteTmp();

        System.out.println("삭제 완료 result : " + delResult);

        List<MaDeptDomain> deptList = relationTeamDao.searchMaDeptList();

        System.out.println("데이터 받아오기  size : " + deptList.size());

        int result = relationTeamDao.insertDept(deptList);

        System.out.println("데이터 입력 result : " + result);

        //if(result > 0){
            System.out.println("프로시저 시작");
            relationTeamDao.procMergeTeam(rtnMap);
            System.out.println("프로시저 종료 : " + rtnMap.get("rtnMsg"));
        //}
        // 2020.09.11 : 현재 미사용중인 부서코드의 사용여부를 False로 변경
        String procRlt = rtnMap.get("rtnCd").toString();
        if(procRlt.equals("1")){	//정상적으로 처리된 경우
        	relationTeamDao.updateDeptUseTf(); //현재 미사용중인 부서코드의 사용여부를 False로 변경
        }
    }
    /**
     * 2019.04.17 JHB추가
     * 최신부서코드가 아닌 항목에 대해서는 사용여부를 False로 변경 
     */
    public void searchByClsLocCode() throws ApplicationException {
    	List<RelationTeamDomain> relationCodeList =  relationTeamDao.searchByClsLocCode();
    	 for (RelationTeamDomain rltDomain: relationCodeList) {
    		 int result =  relationTeamDao.updateTeamLatestYearUse(rltDomain);   		 
    		 //System.out.println(rltDomain.getClsCode()+"====" +rltDomain.getLocCode()+"===="+ result);
         }  	 
    }

}
