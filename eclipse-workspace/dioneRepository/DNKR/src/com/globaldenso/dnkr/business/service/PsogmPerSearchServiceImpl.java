package com.globaldenso.dnkr.business.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.PsogmPerSearchDomain;
import com.globaldenso.dnkr.integration.dao.PsogmPerSearchDao;

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
@Service("psogmPerSearchService")
public class PsogmPerSearchServiceImpl implements PsogmPerSearchService{

    /**
     * 
     */
    @Autowired
    private PsogmPerSearchDao psogmPerSearchDao;
    
    /**
     * 
     * Constructor.
     *
     */
    public PsogmPerSearchServiceImpl(){
        
    }

    /**
     * text val
     * {@inheritDoc}
     */
    @Override
    public List<Object> selectOgm312_textVal(HashMap<String, Object> map) throws ApplicationException {
        return psogmPerSearchDao.selectOgm312_textVal(map);
    }
    
    /**
     * text val
     * {@inheritDoc}
     */
    @Override
    public Object selectOgm312_textVal_Obj(HashMap<String, Object> map) throws ApplicationException {
        return psogmPerSearchDao.selectOgm312_textVal_Obj(map);
    }

    /**
     * grid val
     * {@inheritDoc}
     */
    @Override
    public List<Object> selectOgm312_gridVal_Obj(HashMap<String, Object> map) throws ApplicationException {
        return psogmPerSearchDao.selectOgm312_gridVal_Obj(map);
    }
    
    /**
     * grid val
     * {@inheritDoc}
     */
    @Override
    public List<PsogmPerSearchDomain> selectOgm312_gridVal(PsogmPerSearchDomain domain) throws ApplicationException {
        return psogmPerSearchDao.selectOgm312_gridVal(domain);
    }
}
