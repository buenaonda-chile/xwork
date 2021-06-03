package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.CodeDomain;
import com.globaldenso.dnkr.domain.db2.CodeDb2Domain;

/**
 * [KO] 코드 관리 DAO 구현
 * [EN] DAO implementation of code information.<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("codeDao")
public class CodeDaoImpl implements CodeDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.CodeDao";

    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate = null;
    
    /**
     * 
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public CodeDaoImpl() {
        // no process
    }
    
    
    /**
     * [EN] It is a setter method of sqlSessionTemplate.<br>
     * [JP] sqlSessionTemplate のセッターメソッドです。<br>
     * 
     * @param sqlSessionTemplate sqlSessionTemplate に設定する
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchByKey(CodeDomain)
     */
    @Override
    public CodeDomain searchByKey(CodeDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchByCondition(CodeDomain)
     */
    @Override
    public List<CodeDomain> searchByCondition(CodeDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchCount(CodeDomain)
     */
    @Override
    public int searchCount(CodeDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchCount(CodeDomain)
     */
    @Override
    public int searchCmcCount(CodeDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchCmcCount", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchMaxCommonCode(CodeDomain)
     */
    @Override
    public String searchMaxCommonCode(CodeDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchMaxCommonCode", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#create(CodeDomain)
     */
    public void create(CodeDomain domain, List<String> langList) throws ApplicationException {
        createCmc(domain);
        
        //언어별 common code name 레코드 추가
        if (langList.size() > 0) {
            for (String langCode : langList) {
                domain.setCnmLangCode(langCode);
                createCnm(domain);
            }
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#create(CodeDomain)
     */
    public void createCmc(CodeDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createCmc", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#create(CodeDomain)
     */
    public void createCnm(CodeDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".createCnm", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#update(CodeDomain)
     */
    public int update(CodeDomain domain) throws ApplicationException {
        return updateCnm(domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#updateCnm(CodeDomain)
     */
    public int updateCmc(CodeDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateCmc", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#updateCnm(CodeDomain)
     */
    public int updateCnm(CodeDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateCnm", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCmc(CodeDomain)
     */
    public int deleteCmc(CodeDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteCmc", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#deleteCnm(CodeDomain)
     */
    public int deleteCnm(CodeDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteCnm", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#searchByKey(CodeDomain)
     */
    @Override
    public List<CodeDb2Domain> comCode(CodeDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".comCode", domain);
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#comCodeMst050(CodeDb2Domain)
     */
    @Override
   public List<CodeDb2Domain> comCodeMst050(CodeDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".comCodeMst050", domain);
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#comCodeJdeF0901(CodeDb2Domain)
     */
    @Override
   public List<CodeDb2Domain> comCodeJdeF0901(CodeDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".comCodeJdeF0901", domain);
    }
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#comCodeJdeF0006LB(CodeDb2Domain)
     */
    @Override
   public List<CodeDb2Domain> comCodeJdeF0006LB(CodeDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".comCodeJdeF0006LB", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#comCodeMst650PF(CodeDb2Domain)
     */
    @Override
    public List<CodeDb2Domain> comCodeMst650PF(CodeDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".comCodeMst650PF", domain);
    }

}
