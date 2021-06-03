package com.globaldenso.dnkr.presentation.form.dwh;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.sample.util.BeanUtils;
import com.globaldenso.dnkr.domain.db2.MaterialCostByPeriodDomain;
import com.globaldenso.dnkr.domain.db2.PurchasePriceDomain;
import com.globaldenso.dnkr.domain.db2.SalesPlanMaterialCostDomain;

/**
 * @author $Author$
 * @version $Revision$
 */
public class WAE004MaterialCostByPeriodForm extends MaterialCostByPeriodDomain implements Cloneable{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1412191195461355328L;
    
	private String division;
	
	
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAE004MaterialCostByPeriodForm(){
        super();
    }
    
    /**
     * 自身をディープコピーしたインスタンスを返します。
     * 
     * @return deep copy of this instance
     */
    @Override
    public WAE004MaterialCostByPeriodForm clone() {
        WAE004MaterialCostByPeriodForm clone = new WAE004MaterialCostByPeriodForm();
        try {
            BeanUtils.copyPropertiesFormToForm(clone, this);
        } catch (ApplicationException e) {
            throw new SystemException("");
        }
        return clone;
    }

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
  
}
