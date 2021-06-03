package com.globaldenso.dnkr.presentation.form.basic;

import java.sql.Timestamp;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.globaldenso.dnkr.domain.EmpDomain;
/***
 * @author $Author$
 * @version $Revision$
 */
public class WAB002EmpCreateForm extends EmpDomain {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -7584973917640554085L;

    /**
     * 
     * Constructor.
     *
     */
    public WAB002EmpCreateForm(){
        super();
    }
    
    /**
     * @return the empNo
     */
    @Override
    @NotEmpty
    @Size(min = 1, max = 10)
    public String getEmpNumber() {
        return super.getEmpNumber();
    }

    @Override
    @Size(max = 45) 
    public String getLocCode() {
        return super.getLocCode();
    }

    @Override
    @Size(max = 45) 
    public String getClsCode() {
        return super.getClsCode();
    }

    @Override
    @Size(max = 45)  
    public String getTeamCode() {
        return super.getTeamCode();
    }

    @Override
    @Size(max = 45) 
    public String getAuthCode() {
        return super.getAuthCode();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getLastName() {
        return super.getLastName();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    @Size(max = 40) 
    public String getEmpName() {
        return super.getEmpName();
    }

    @Override
    @Size(max = 100)
    @Email 
    public String getEmpEmail() {
        return super.getEmpEmail();
    }

    @Override
    @Size(max = 20)  
    public String getEmpId() {
        return super.getEmpId();
    }

    @Override
    @Size(max = 1)
    public String getEmpUse() {
        return super.getEmpUse();
    }

    @Override 
    @DateTimeFormat
    public Timestamp getEmpSyncDate() {
        return super.getEmpSyncDate();
    }

    @Override
    @Size(max = 45) 
    public String getEmpPwd() {
        return super.getEmpPwd();
    }

    @Override 
    @Size(max = 1) 
    public String getEmpPrivateAuth() {
        return super.getEmpPrivateAuth();
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
