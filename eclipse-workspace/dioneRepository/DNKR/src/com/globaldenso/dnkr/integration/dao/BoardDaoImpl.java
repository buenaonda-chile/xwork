package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BoardFileDomain;
import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.BoardTextDomain;
import com.globaldenso.dnkr.domain.EmpDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.BoardDao";
    
    /**
     * [EN] SqlSessionTemplate.<br>
     * [JP] DBにアクセスするためのSqlSessionTemplate。<br>
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate = null;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public BoardDaoImpl() {
        // no process
    }
    
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchCount(BoardInfoDomain)
     */
    public BoardTextDomain searchById(BoardTextDomain domain) throws ApplicationException {
        return  sqlSessionTemplate.selectOne(NAMESPACE + ".searchById", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchByConditionForPaging(BoardInfoDomain)
     */
    public List<BoardTextDomain> searchByConditionForMain(BoardTextDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForMain", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchByConditionForPaging(BoardInfoDomain)
     */
    public List<BoardTextDomain> searchByCondition(BoardTextDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchCount(BoardInfoDomain)
     */
    public int noticeCount(BoardTextDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".noticeCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchByConditionForPaging(BoardInfoDomain)
     */
    public List<BoardTextDomain> searchByConditionForPaging(BoardTextDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByConditionForPaging", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchCount(BoardInfoDomain)
     */
    public int searchCount(BoardTextDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchCount(BoardInfoDomain)
     */
    public int boardCount(BoardTextDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".boardCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchCount(BoardInfoDomain)
     */
    public String boardNextIdx(BoardTextDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".boardNextIdx", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#create(BoardInfoDomain)
     */
    public void create(BoardTextDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".create", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int update(BoardTextDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".update", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int hitsUpdate(BoardTextDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".hitsUpdate", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int chkDelete(BoardTextDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".chkDelete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int delete(BoardTextDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".delete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchCount(BoardInfoDomain)
     */
    public BoardInfoDomain searchInfoById(BoardInfoDomain domain) throws ApplicationException {
        return  sqlSessionTemplate.selectOne(NAMESPACE + ".searchInfoById", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchByConditionForPaging(BoardInfoDomain)
     */
    public List<BoardInfoDomain> searchByInfoConditionForPaging(BoardInfoDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByInfoConditionForPaging", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchCount(BoardInfoDomain)
     */
    public int searchInfoCount(BoardInfoDomain domain) throws ApplicationException {
        int cnt = sqlSessionTemplate.selectOne(NAMESPACE + ".searchInfoCount", domain);
        return cnt;
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#create(BoardInfoDomain)
     */
    public void infoCreate(BoardInfoDomain domain) throws ApplicationException {
        sqlSessionTemplate.insert(NAMESPACE + ".infoCreate", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int infoUpdate(BoardInfoDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".infoUpdate", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int infoDelete(BoardInfoDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".infoDelete", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchByConditionForPaging(BoardInfoDomain)
     */
    public BoardFileDomain searchFileById(BoardFileDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchFileById", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#searchByConditionForPaging(BoardInfoDomain)
     */
    public List<BoardFileDomain> searchFileList(BoardFileDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchFileList", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.BoardDao#create(BoardInfoDomain)
     */
    public int fileCreate(BoardFileDomain domain) throws ApplicationException {
        return sqlSessionTemplate.insert(NAMESPACE + ".fileCreate", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int fileUpdate(BoardFileDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".fileUpdate", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int downCntUpdate(BoardFileDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".downCntUpdate", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.ai.sample.integration.dao.EmpDao#delete(EmpDomain)
     */
    public int fileDelete(BoardFileDomain domain) throws ApplicationException {
        return sqlSessionTemplate.delete(NAMESPACE + ".fileDelete", domain);
    }
}
