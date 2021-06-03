package com.globaldenso.dnkr.presentation.form.basic;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.sample.util.BeanUtils;

/**
 * @author $Author$
 * @version $Revision$
 */
public class WAN001DioneViewForm implements Cloneable{

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 6731630361939112358L;
    
    private String pgmId ="";
    private String company="";
    private String locCode="";
    private String forwardMenu;
    private String forwardURI;
    private String mode ="";
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAN001DioneViewForm(){
        super();
    }
    
    /**
     * 自身をディープコピーしたインスタンスを返します。
     * 
     * @return deep copy of this instance
     */
    @Override
    public WAN001DioneViewForm clone() {
        WAN001DioneViewForm clone = new WAN001DioneViewForm();
        try {
            BeanUtils.copyPropertiesFormToForm(clone, this);
        } catch (ApplicationException e) {
            throw new SystemException("");
        }
        return clone;
    }


	public String getPgmId() {
		return pgmId;
	}

	public void setPgmId(String pgmId) {
		this.pgmId = pgmId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocCode() {
		return locCode;
	}

	public void setLocCode(String locCode) {
		this.locCode = locCode;
	}

	public String getForwardMenu() {
		return forwardMenu;
	}

	public void setForwardMenu(String forwardMenu) {
		this.forwardMenu = forwardMenu;
	}

	public String getForwardURI() {
		return forwardURI;
	}

	public void setForwardURI(String forwardURI) {
		this.forwardURI = forwardURI;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
}
