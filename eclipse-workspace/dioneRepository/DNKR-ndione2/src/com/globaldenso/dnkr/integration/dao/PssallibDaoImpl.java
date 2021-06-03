package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PssallibDomain;

/**
 * [JP] PssallibDao のDAO実装クラスです。<br>
 * [EN] It is DAO implementation class of PssallibDao.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("pssallibDao")
public class PssallibDaoImpl implements PssallibDao {
    
    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.PssallibDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public PssallibDaoImpl() {
        // no process
    }
    
    /**
     * [EN] It is a setter method of sqlSessionTemplate.<br>
     * [JP] sqlSessionTemplate のセッターメソッドです。<br>
     * 
     * @param sqlSessionTemplate sqlSessionTemplate に設定する
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate4 = sqlSessionTemplate;
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PssallibDao#selectSMDZ123P(PssallibDomain)
     */
    @Override
    public List<PssallibDomain> selectSMDZ123P(PssallibDomain form)
            throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSMDZ123P", form);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.PssallibDao#selectSMDZ123P_CHK(PssallibDomain)
     */
    @Override
    public List<PssallibDomain> selectSMDZ123P_CHK(PssallibDomain form)
            throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectSMDZ123P_CHK", form);
    }
            
}
