package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.MenuDomain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("menuDao")
public class MenuDaoImpl implements MenuDao {

    /**
     * [EN] Namespace of SQLMap.<br>
     * [JP] SQLMapの名前空間。<br>
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.MenuDao";
    
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
    public MenuDaoImpl() {
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
    
    @Override
    public MenuDomain searchByKey(MenuDomain domain)
        throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchByKey", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.MenuDao#searchByCondition(MenuDomain)
     */
    @Override
    public List<MenuDomain> searchByCondition(MenuDomain domain)
        throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchByCondition", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.MenuDao#searchCount(MenuDomain)
     */
    @Override
    public int searchCount(MenuDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchCount", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.MenuDao#searchCount(MenuDomain)
     */
    @Override
    public int searchMcdCount(MenuDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchMcdCount", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.MenuDao#searchMaxMcdSort(MenuDomain domain)
     */
    @Override
    public int searchMaxMcdSort(MenuDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchMaxMcdSort", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.MenuDao#searchSupetMenuMcdSort()
     */
    @Override
    public int searchSupetMenuMcdSort() throws ApplicationException {
        return sqlSessionTemplate.selectOne(NAMESPACE + ".searchSupetMenuMcdSort");
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.CodeDao#create(CodeDomain)
     */
    public void create(MenuDomain domain, List<String> langList) throws ApplicationException {
        createMenu(domain);
        
        //언어별 Menu code name 레코드 추가
        if (langList.size() > 0) {
            for (String langCode : langList) {
                domain.setLangCmc(langCode);
                createName(domain); 
            }
        }
    }
    
    /**
    * [KR] 메뉴 코드정보를 추가한다.<br>     
    * 
    * @param domain MenuDomain
    */
    @Override
    public void createMenu(MenuDomain domain) throws ApplicationException {     
        sqlSessionTemplate.insert(NAMESPACE + ".createMenu", domain);
    }
    
    /**
     * [KR] 메뉴 코드 언어별 명칭을 추가한다.<br>     
     * 
     * @param domain MenuDomain
     */
    @Override
    public void createName(MenuDomain domain) throws ApplicationException {     
        sqlSessionTemplate.insert(NAMESPACE + ".createName", domain);
    }

    @Override
    public int updateCode(MenuDomain domain) throws ApplicationException {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.update(NAMESPACE + ".updateCode", domain);    
    }

    @Override
    public int updateName(MenuDomain domain) throws ApplicationException {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.update(NAMESPACE + ".updateName", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.MenuDao#updateSortUp(MenuDomain)
     */
    public int updateSortUp(MenuDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateSortUp", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.MenuDao#updateSortDown(MenuDomain)
     */
    public int updateSortDown(MenuDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateSortDown", domain);
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see com.globaldenso.dnkr.integration.dao.MenuDao#updateDepth(MenuDomain)
     */
    public int updateDepth(MenuDomain domain) throws ApplicationException {
        return sqlSessionTemplate.update(NAMESPACE + ".updateDepth", domain);
    }

    @Override
    public int deleteName(MenuDomain domain) throws ApplicationException {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteName", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.MenuDao#deleteCode(MenuDomain)
     */
    @Override
    public int deleteCode(MenuDomain domain) throws ApplicationException {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.delete(NAMESPACE + ".deleteCode", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.MenuDao#searchSuperMenuList(MenuDomain)
     */
    @Override
    public List<MenuDomain> searchSuperMenuList(MenuDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchSuperMenuList", domain);
    }

    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.MenuDao#searchAuthMenuList()
     */
    @Override
    public List<MenuDomain> searchAuthMenuList() throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchAuthMenuList");
    }
    
    /**
     * {@inheritDoc}
     * 
     * * @see com.globaldenso.dnkr.integration.dao.MenuDao#searchAuthMenuList()
     */
    @Override
    public List<MenuDomain> searchAuthMenuList(MenuDomain domain) throws ApplicationException {
        return sqlSessionTemplate.selectList(NAMESPACE + ".searchAuthMenuList", domain);
    }
}
