package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PsogmPerSearchDomain;

/**
 * �꽕鍮꾨낫�쟾愿�由� - �꽕鍮껷o �떎�쟻 
 * Describe the outline of this class.
 * 
 * <p>
 * Describe the detail of this class.
 * </p>
 *-
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmPerSearchService {
    
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
    public List<Object> selectOgm312_textVal(HashMap<String, Object> map) throws ApplicationException; 
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param map Param
     * @return HashMap
     * @throws ApplicationException  
     */
    public Object selectOgm312_textVal_Obj(HashMap<String, Object> map) throws ApplicationException;
    
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
    public List<Object> selectOgm312_gridVal_Obj(HashMap<String, Object> map)  throws ApplicationException;
    
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     *  
     * @param domain 
     * @return List
     * @throws ApplicationException  
     */
    public List<PsogmPerSearchDomain> selectOgm312_gridVal(PsogmPerSearchDomain domain)  throws ApplicationException;
 
}
