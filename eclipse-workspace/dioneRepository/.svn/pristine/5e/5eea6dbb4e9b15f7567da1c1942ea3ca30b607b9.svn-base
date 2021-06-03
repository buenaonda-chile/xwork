package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BatchDomain;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.MaEmpDomain;
import com.globaldenso.dnkr.domain.BatchDomain;
import com.globaldenso.dnkr.domain.db2.SsoAccountDb2Domain;

/**
 * [JP] EMP_INFO のDAO実装クラスです。<br>
 * [EN] It is DAO implementation class of EMP_INFO.<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("empDao")
public class EmpDaoImpl implements EmpDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.EmpDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate = null;
    
    /**
     * [EN] SqlSessionTemplate2.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate2")
    private SqlSessionTemplate sqlSessionTemplate2 = null;
    
    /**
     * [EN] SqlSessionTemplate4.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4 = null;
    
    /**
     * [EN] SqlSessionTemplate4.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate5")
    private SqlSessionTemplate sqlSessionTemplate5 = null;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public EmpDaoImpl() {
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
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchByKey(EmpDomain)
     */
    public EmpDomain searchById(EmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchById", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchByKey(EmpDomain)
     */
    public EmpDomain getTeamName(EmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".getTeamName", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchByKey(EmpDomain)
     */
    public EmpDomain searchByKey(EmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchByCondition(EmpDomain)
     */
    public List<EmpDomain> searchByCondition(EmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchByConditionForPaging(EmpDomain)
     */
    public List<EmpDomain> searchByConditionForPaging(EmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#searchByCondition(EmpDomain)
     */
    public List<EmpDomain> searchByConditionForTeam(EmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForTeam", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#searchMaxEmpNumber(EmpDomain)
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchMaxEmpNumber(EmpDomain)
     */
    public String searchMaxEmpNumber(EmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchMaxEmpNumber", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchCount(EmpDomain)
     */
    public int searchCount(EmpDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#create(EmpDomain)
     */
    public void create(EmpDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#update(EmpDomain)
     */
    public int update(EmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".update", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int delete(EmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }


    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchMaEmpList(MaEmpDomain)
     */
    public List<MaEmpDomain> searchMaEmpList(MaEmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate2.selectList(NAMESPACE + ".searchEmpMaEmpList", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#insertMaEmpToDnkrEmpTmp(MaEmpDomain)
     */
    public int insertMaEmpToDnkrEmpTmp(MaEmpDomain maEmpDomain) throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".insertMaEmpToDnkrEmpTmp", maEmpDomain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#deleteDnkrEmpTmp()
     */
    public int deleteDnkrEmpTmp() throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteDnkrEmpTmp");
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#procMergeEmp(HashMap)
     */
    public void procMergeEmp(HashMap map) throws ApplicationException {
        sqlSessionTemplate.selectOne(NAMESPACE + ".procMergeEmp", map);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#procDisableEmp(HashMap)
     */
    public void procDisableEmp(HashMap map) throws ApplicationException {
        sqlSessionTemplate.selectOne(NAMESPACE + ".procDisableEmp", map);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.searchByDb2Id#searchByKey(EmpDomain)
     */
    public EmpDb2Domain searchByDb2Id(EmpDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchByDb2Id", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#ssoAccounts(SsoAccountDb2Domain)
     */
    public SsoAccountDb2Domain ssoAccounts(SsoAccountDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".ssoAccounts", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#ssoAccounts_OrderProd(SsoAccountDb2Domain)
     */
    public SsoAccountDb2Domain ssoAccounts_OrderProd(SsoAccountDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".ssoAccounts_OrderProd", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#selectOgm200_hmd020pf(EmpDb2Domain)
     */
    public EmpDb2Domain selectOgm200_hmd020pf(EmpDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm200_hmd020pf", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#selectOGMUserID(EmpDb2Domain)
     */
    public List<EmpDb2Domain> selectOGMUserID(EmpDb2Domain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOGMUserID", domain);

    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.EmpDao#searchMaEmpList(MaEmpDomain)
     */
    //20118.06.05 추가 IT.T 제혼복
   public MaEmpDomain searchEmpMaAccount(MaEmpDomain domain) throws ApplicationException {
        return sqlSessionTemplate2.selectOne(NAMESPACE + ".searchEmpMaAccount", domain);
    }


   /**
    * {@inheritDoc}
    * 
    * @see com.globaldenso.dnkr.integration.dao.EmpDao#ssoAccounts(SsoAccountDb2Domain)
    */
   public int searchSsoDspSessionAccount(SsoAccountDb2Domain domain) throws ApplicationException {
	   int cnt =sqlSessionTemplate4.selectOne(NAMESPACE + ".searchSsoDspSessionAccount", domain);
       return cnt;
   }

   /**
    * {@inheritDoc}
    * 
    * @see com.globaldenso.dnkr.integration.dao.EmpDao#ssoAccounts(SsoAccountDb2Domain)
    */
   public SsoAccountDb2Domain searchSsoPrtSessionAccount(SsoAccountDb2Domain domain) throws ApplicationException {
       return sqlSessionTemplate4.selectOne(NAMESPACE + ".searchSsoPrtSessionAccount", domain);
   }
   /**
    * {@inheritDoc}
    * 
    * @see com.globaldenso.dnkr.integration.dao.EmpDao#ssoAccounts(SsoAccountDb2Domain)
    */
   public List<SsoAccountDb2Domain> searchDioneAccountCnt(SsoAccountDb2Domain domain) throws ApplicationException{
       return sqlSessionTemplate4.selectList(NAMESPACE + ".searchDioneAccountCnt", domain);
   }
      
	//2018.12.18 추가 IT.T 제혼복(사업부이동자를 위한 Ldap체크)
   public EmpDomain searchByIdLdap(EmpDomain domain) throws ApplicationException {
       return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByIdLdap", domain);
   }

	@Override
	public Map<String, String> searchByBatchStatus(String string) {
		return sqlSessionTemplate5.selectOne(NAMESPACE + ".searchByBatchStatus", string);
	}
	
	
	/**
    * {@inheritDoc}
    * 
    * @see com.globaldenso.dnkr.integration.dao.EmpDao#ssoAccounts(SsoAccountDb2Domain)
    */
    public List<BatchDomain> selectBatchInfo(String string) throws ApplicationException{
       return sqlSessionTemplate2.selectList(NAMESPACE + ".", string);
    }
}
