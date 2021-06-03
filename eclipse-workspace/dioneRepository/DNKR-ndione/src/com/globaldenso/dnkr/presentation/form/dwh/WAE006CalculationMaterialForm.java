package com.globaldenso.dnkr.presentation.form.dwh;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.sample.util.BeanUtils;
import com.globaldenso.dnkr.domain.db2.CalculationMaterialDomain;
import com.globaldenso.dnkr.domain.db2.MaterialCostByPeriodDomain;

/**
 * @author $Author$
 * @version $Revision$
 */
public class WAE006CalculationMaterialForm extends CalculationMaterialDomain implements Cloneable{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1412191195461355328L;
	

	
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAE006CalculationMaterialForm(){
        super();
    }
    
    /**
     * 自身をディープコピーしたインスタンスを返します。
     * 
     * @return deep copy of this instance
     */
    @Override
    public WAE006CalculationMaterialForm clone() {
        WAE006CalculationMaterialForm clone = new WAE006CalculationMaterialForm();
        try {
            BeanUtils.copyPropertiesFormToForm(clone, this);
        } catch (ApplicationException e) {
            throw new SystemException("");
        }
        return clone;
    }
  
}
