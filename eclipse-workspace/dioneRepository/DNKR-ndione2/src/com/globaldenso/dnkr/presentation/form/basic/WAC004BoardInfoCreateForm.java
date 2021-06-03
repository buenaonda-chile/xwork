package com.globaldenso.dnkr.presentation.form.basic;

import java.sql.Timestamp;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.EmpDomain;
/**
 * @author $Author$
 * @version $Revision$
 */
public class WAC004BoardInfoCreateForm extends BoardInfoDomain {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -7584973917640554085L;

    /**
     * 
     * Constructor.
     *
     */
    public WAC004BoardInfoCreateForm(){
        super();
    }

    /**
     * @return the empNo
     */
    @Override
    @Size(max = 7)
    public String getBoardId() {
        return super.getBoardId();
    }

    @Override
    @Size(max = 50) 
    public String getBoardNm() {
        return super.getBoardNm();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getBoardGrp() {
        return super.getBoardGrp();
    }

    @Override
    @Size(max = 4) 
    public String getBoardType() {
        return super.getBoardType();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getBoardSkin() {
        return super.getBoardSkin();
    }


    /**
     * 
     * {@inheritDoc}
     */
    public String getWriteAuth() {
        return super.getWriteAuth();
    }


    /**
     * 
     * {@inheritDoc}
     */
    public String getReadAuth() {
        return super.getReadAuth();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getNotiAuth() {
        return super.getNotiAuth();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getNsrAuth() {
        return super.getNsrAuth();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getMemoAuth() {
        return super.getMemoAuth();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getSecretUse() {
        return super.getSecretUse();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getEditorUse() {
        return super.getEditorUse();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getItemUse() {
        return super.getItemUse();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getFileNum() {
        return super.getFileNum();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getFileSize() {
        return super.getFileSize();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getFileExt() {
        return super.getFileExt();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getNewiconDay() {
        return super.getNewiconDay();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getItems() {
        return super.getItems();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getRowCnt() {
        return super.getRowCnt();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getPageCnt() {
        return super.getPageCnt();
    }

    @Override
    @Size(max = 30) 
    public String getRegiId() {
        return super.getRegiId();
    }

    @Override 
    @Size(max = 100) 
    public String getRegiDtm() {
        return super.getRegiDtm();
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
