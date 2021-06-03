package com.globaldenso.dnkr.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.IntegrationLayerException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;
import com.globaldenso.dnkr.integration.dao.CodeDao;

/**
 * [KR] 코드관리 서비스 구현 <br>
 * [EN] Service implementation of code information.
 * [JP] 
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {

    /**
     * [KR] 코드관리 Dao <br>
     * [EN] A field of CommonCodeDao.<br>
     * [JP] CommonCodeDaoのフィールド。<br>
     */
    @Autowired
    private CodeDao codeDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CodeServiceImpl() {
        // no process
    }
    
    /**
     * [KO] 공통코드 Dao 의 setter 메소드
     * [EN] Set DAO of Common code information.<br>
     * [JP] 。<br>
     *
     * @param commonCodeDao 'CommonCodeDao' class 
     */
    public void setCodeDao(CodeDao commonCodeDao) {
        this.codeDao = commonCodeDao;
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchByKey(CodeDomain)
     */
    @Override
    public CodeDomain searchByKey(CodeDomain domain) throws ApplicationException {
        return codeDao.searchByKey(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchByCondition(CodeDomain)
     */
    @Override
    public List<CodeDomain> searchByCondition(CodeDomain domain) throws ApplicationException {
        return codeDao.searchByCondition(domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchCount(CodeDomain)
     */
    @Override
    public int searchCount(CodeDomain domain) throws ApplicationException {
        return codeDao.searchCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchCmcCount(CodeDomain)
     */
    @Override
    public int searchCmcCount(CodeDomain domain) throws ApplicationException {
        return codeDao.searchCmcCount(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#searchMaxCommonCode(CodeDomain)
     */
    @Override
    public String searchMaxCommonCode(CodeDomain domain) throws ApplicationException {
        return codeDao.searchMaxCommonCode(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#create(CodeDomain)
     */
    public void create(CodeDomain domain, List<String> langList) throws ApplicationException {
        try {
            codeDao.create(domain, langList);
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
     * @see com.globaldenso.dnkr.business.service.CodeService#update(CodeDomain)
     */
    public int update(CodeDomain domain) throws ApplicationException {
        int upResult = 0;
        upResult += updateCnm(domain);
        upResult += updateCmc(domain);
        return upResult;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#updateCmc(CodeDomain)
     */
    public int updateCmc(CodeDomain domain) throws ApplicationException {
        return codeDao.updateCmc(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#updateCnm(CodeDomain)
     */
    public int updateCnm(CodeDomain domain) throws ApplicationException {
        return codeDao.updateCnm(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#delete(CodeDomain)
     */
    public int delete(CodeDomain domain) throws ApplicationException {
        int delResult = 0;
        //공통코드명 삭제
        delResult += deleteCnm(domain);
        
        //공통코드 참조언어 삭제
        try {
            String cmcCode = domain.getCmcCode();
            CodeDomain fkLangDomain = new CodeDomain();
            fkLangDomain.setCnmLangCode(cmcCode);
            delResult += deleteCnm(fkLangDomain);
        } catch (Exception e) {
            System.out.println("언어코드를 지울때만 필요한 부분");
        }
        
        //공통코드 삭제
        delResult += deleteCmc(domain);
        
        return delResult;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#deleteCmc(CodeDomain)
     */
    public int deleteCmc(CodeDomain domain) throws ApplicationException {
        return codeDao.deleteCmc(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#deleteCnm(CodeDomain)
     */
    public int deleteCnm(CodeDomain domain) throws ApplicationException {
        return codeDao.deleteCnm(domain);
    }
    
    
    /*========================= DB2 ============================================*/
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#comCode(CodeDb2Domain)
     */
    @Override
    public List<CodeDb2Domain> comCode(CodeDb2Domain domain) throws ApplicationException {
        return codeDao.comCode(domain);
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#comCodeMst050(CodeDb2Domain)
     */
    @Override
    public List<CodeDb2Domain> comCodeMst050(CodeDb2Domain domain) throws ApplicationException {
        return codeDao.comCodeMst050(domain);
    }
   /**
    * {@inheritDoc}
    * 
    * @see com.globaldenso.dnkr.business.service.CodeService#comCodeJdeF0901(CodeDb2Domain)
    */
    @Override
	public List<CodeDb2Domain> comCodeJdeF0901(CodeDb2Domain domain) throws ApplicationException{
		return codeDao.comCodeJdeF0901 (domain);
	}
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.business.service.CodeService#comCodeJdeF0006LB(CodeDb2Domain)
     */
     @Override
 	public List<CodeDb2Domain> comCodeJdeF0006LB(CodeDb2Domain domain) throws ApplicationException{
 		return codeDao.comCodeJdeF0006LB (domain);
 	}
     
     /**
      * {@inheritDoc}
      * 
      * @see com.globaldenso.dnkr.business.service.CodeService#comCodeMst650PF(CodeDb2Domain)
      */
     @Override
     public List<CodeDb2Domain> comCodeMst650PF(CodeDb2Domain domain) throws ApplicationException{
  		return codeDao.comCodeMst650PF (domain);
  	}
    /*========================= // DB2 ============================================*/
}
