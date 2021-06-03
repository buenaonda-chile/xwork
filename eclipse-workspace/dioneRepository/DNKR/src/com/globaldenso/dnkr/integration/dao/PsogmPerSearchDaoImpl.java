package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PsogmPerSearchDomain;

/**
 * 
 * Describe the outline of this class.
 * 
 * <p>
 * Describe the detail of this class.
 * </p>
 *
 * @author $Author$
 * @version $Revision$
 */
@Repository("psogmPerSearchDao")
public class PsogmPerSearchDaoImpl implements PsogmPerSearchDao{

    /**
     * sql str
     */
    private static final String NAMESPACE = "com.globaldenso.dnkr.integration.dao.PsogmPerSearchDao";
    
    /**
     * 
     */
    @Autowired
    @Resource(name = "sqlSessionTemplate4")
    private SqlSessionTemplate sqlSessionTemplate4;
   
    /**
     * 
     * Constructor.
     *
     */
    public PsogmPerSearchDaoImpl(){
        
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     *  
     * @param sqlSessionTemplate 
     */
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate4 = sqlSessionTemplate;
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param map param
     * @return List
     * @throws ApplicationException 
     */
    public List<Object> selectOgm312_textVal(HashMap<String, Object> map) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm312_textVal", map);
    }
    
    
   /**
    * 
    * {@inheritDoc}
    */
    public Object selectOgm312_textVal_Obj(HashMap<String, Object> map) throws ApplicationException {
        
        return sqlSessionTemplate4.selectOne(NAMESPACE + ".selectOgm312_textVal_Obj", map);
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param map param
     * @return List
     * @throws ApplicationException 
     */
    public List<Object> selectOgm312_gridVal_Obj(HashMap<String, Object> map) throws ApplicationException {
        
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm312_gridVal_Obj", map);
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param domain 
     * @return list 
     * @throws ApplicationException  
     */
    public List<PsogmPerSearchDomain> selectOgm312_gridVal(PsogmPerSearchDomain domain) throws ApplicationException {
        return sqlSessionTemplate4.selectList(NAMESPACE + ".selectOgm312_gridVal", domain);
    }
    
}
