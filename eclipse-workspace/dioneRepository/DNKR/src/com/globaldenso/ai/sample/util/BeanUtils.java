/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.ai.sample.util;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;

import com.globaldenso.ai.core.exception.ApplicationException;

/**
 * [EN] Utility class for treat Bean.<br>
 * [JP] Beanを扱うUtilityクラス。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class BeanUtils {
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     * 
     * <pre>
     * This class is utility, so the constructor of this class is private.
     * </pre>
     *
     */
    private BeanUtils() {
        // no process
    }
    
    /**
     * Copy properties from Domain to Form.
     * 
     * <pre>
     * Target Form must extend target Domain.
     * </pre>
     * 
     * @param <D> class of Domain
     * @param <F> class of Form
     * @param form Form
     * @param domain Domain
     * @throws ApplicationException ApplicationException
     */
    public static <D, F extends D> void copyPropertiesDomainToForm(
            F form, D domain) throws 
            ApplicationException {
        
        try {
            
            BeanUtilsBean beanUtilsBean = new BeanUtilsBean(
                new ConvertUtilsBean(), 
                BeanUtilsBean.getInstance().getPropertyUtils());
            beanUtilsBean.getConvertUtils().register(new IntegerConverter(null), Integer.class);
            beanUtilsBean.getConvertUtils().register(new BigDecimalConverter(null), BigDecimal.class);
            beanUtilsBean.getConvertUtils().register(new SqlTimestampConverter(null), Timestamp.class);
            beanUtilsBean.getConvertUtils().register(new DateConverter(null), Date.class);
            
            beanUtilsBean.copyProperties(form, domain);
            
        } catch (IllegalAccessException e) {
            throw new ApplicationException("");
        } catch (InvocationTargetException e) {
            throw new ApplicationException("");
        }
        
    }
    
    /**
     * Copy properties from Form to Form.
     * 
     * @param <F> class of Form
     * @param formTo Form (to)
     * @param formFrom Form (from)
     * @throws ApplicationException ApplicationException
     */
    public static <F> void copyPropertiesFormToForm(F formTo, F formFrom) throws ApplicationException {
        
        try {
            
            BeanUtilsBean beanUtilsBean = new BeanUtilsBean(
                new ConvertUtilsBean(), 
                BeanUtilsBean.getInstance().getPropertyUtils());
            beanUtilsBean.getConvertUtils().register(new IntegerConverter(null), Integer.class);
            beanUtilsBean.getConvertUtils().register(new BigDecimalConverter(null), BigDecimal.class);
            beanUtilsBean.getConvertUtils().register(new SqlTimestampConverter(null), Timestamp.class);
            beanUtilsBean.getConvertUtils().register(new DateConverter(null), Date.class);
            
            beanUtilsBean.copyProperties(formTo, formFrom);
            
        } catch (IllegalAccessException e) {
            throw new ApplicationException("");
        } catch (InvocationTargetException e) {
            throw new ApplicationException("");
        }
        
    }
    
}
