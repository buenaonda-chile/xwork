package com.globaldenso.dnkr.presentation.form.basic;

import java.sql.Timestamp;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.MenuDomain;
/***
 * @author $Author$
 * @version $Revision$
 */
public class WAD011MenuCreateForm extends MenuDomain {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -2337832007737072637L;

	/**
     * 
     * Constructor.
     *
     */
    public WAD011MenuCreateForm(){
        super();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getRowNumFrom() {
        return super.getRowNumFrom();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getRowNumTo() {
        return super.getRowNumTo();
    }
}
