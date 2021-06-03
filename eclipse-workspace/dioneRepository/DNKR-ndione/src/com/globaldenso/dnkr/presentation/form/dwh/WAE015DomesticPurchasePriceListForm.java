package com.globaldenso.dnkr.presentation.form.dwh;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.sample.util.BeanUtils;
import com.globaldenso.dnkr.domain.db2.DomesticPurchasePriceListDomain;

/**
 * @author $Author$
 * @version $Revision$
 */
public class WAE015DomesticPurchasePriceListForm extends DomesticPurchasePriceListDomain implements Cloneable{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1412191195461355328L;
	

	
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAE015DomesticPurchasePriceListForm(){
        super();
    }
    
    /**
     * 自身をディープコピーしたインスタンスを返します。
     * 
     * @return deep copy of this instance
     */
    @Override
    public WAE015DomesticPurchasePriceListForm clone() {
        WAE015DomesticPurchasePriceListForm clone = new WAE015DomesticPurchasePriceListForm();
        try {
            BeanUtils.copyPropertiesFormToForm(clone, this);
        } catch (ApplicationException e) {
            throw new SystemException("");
        }
        return clone;
    }
  
}
