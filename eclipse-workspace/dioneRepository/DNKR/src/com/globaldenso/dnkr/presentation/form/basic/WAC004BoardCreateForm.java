package com.globaldenso.dnkr.presentation.form.basic;

import javax.validation.constraints.Size;

import com.globaldenso.dnkr.domain.BoardTextDomain;
/**
 * @author $Author$
 * @version $Revision$
 */
public class WAC004BoardCreateForm extends BoardTextDomain {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -7584973917640554085L;

    /**
     * 
     * Constructor.
     *
     */
    public WAC004BoardCreateForm(){
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
    @Size(max = 10) 
    public String getIdx() {
        return super.getIdx();
    }
    
    /**
     * 
     * {@inheritDoc}
     */
    public String getPrntIdx() {
        return super.getPrntIdx();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getTitle() {
        return super.getTitle();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getCnts() {
        return super.getCnts();
    }


    /**
     * 
     * {@inheritDoc}
     */
    public String getPwd() {
        return super.getPwd();
    }


    /**
     * 
     * {@inheritDoc}
     */
    public String getUserIp() {
        return super.getUserIp();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getNoticeYn() {
        return super.getNoticeYn();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getSecretYn() {
        return super.getSecretYn();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getEditorYn() {
        return super.getEditorYn();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getItem() {
        return super.getItem();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getHits() {
        return super.getHits();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String getWriter() {
        return super.getWriter();
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getFileId() {
        return super.getFileId();
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
