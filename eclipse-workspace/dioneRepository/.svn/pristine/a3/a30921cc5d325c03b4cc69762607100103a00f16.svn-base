package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.FileUploadParameterMstDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("fileUploadParameterMstDao")
public class FileUploadParameterMstDaoImpl implements FileUploadParameterMstDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;
    
    /**
     * [EN] SqlSessionTemplate4.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
   
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public FileUploadParameterMstDaoImpl() {
        //no process
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
     * @see com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao#searchByKey(FileUploadParameterMstDomain)
     */
    public FileUploadParameterMstDomain searchByKey(FileUploadParameterMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao#searchByCondition(FileUploadParameterMstDomain)
     */
    public List<FileUploadParameterMstDomain> searchByCondition(FileUploadParameterMstDomain domain) throws ApplicationException {
	    return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao#searchCount(FileUploadParameterMstDomain)
     */
    public List<FileUploadParameterMstDomain> searchByConditionForPaging(FileUploadParameterMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao#searchCount(FileUploadParameterMstDomain)
     */
    public int searchCount(FileUploadParameterMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);        
        return cnt;
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao#searchCount2(FileUploadParameterMstDomain)
     */
    public int searchCount2(FileUploadParameterMstDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount2", domain);
        return cnt;
    }
  
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao#create(FileUploadParameterMstDomain)
     */
    public void create(FileUploadParameterMstDomain domain) throws ApplicationException {
    	sqlSessionTemplate.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao#update(FileUploadParameterMstDomain)
     */
    public int update(FileUploadParameterMstDomain domain) throws ApplicationException {
    	return sqlSessionTemplate.update(NAMESPACE + ".update", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.FileUploadParameterMstDao#update(FileUploadParameterMstDomain)
     */
    public int delete(FileUploadParameterMstDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
}
