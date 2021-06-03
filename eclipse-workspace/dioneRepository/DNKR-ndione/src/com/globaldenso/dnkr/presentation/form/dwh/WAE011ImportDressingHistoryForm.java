package com.globaldenso.dnkr.presentation.form.dwh;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.ai.core.exception.SystemException;
import com.globaldenso.ai.sample.util.BeanUtils;
import com.globaldenso.dnkr.domain.db2.ImportDressingHistoryDomain;

/**
 * @author $Author$
 * @version $Revision$
 */
public class WAE011ImportDressingHistoryForm extends ImportDressingHistoryDomain implements Cloneable{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1412191195461355328L;
	

	
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAE011ImportDressingHistoryForm(){
        super();
    }
    
    /**
     * 自身をディープコピーしたインスタンスを返します。
     * 
     * @return deep copy of this instance
     */
    @Override
    public WAE011ImportDressingHistoryForm clone() {
        WAE011ImportDressingHistoryForm clone = new WAE011ImportDressingHistoryForm();
        try {
            BeanUtils.copyPropertiesFormToForm(clone, this);
        } catch (ApplicationException e) {
            throw new SystemException("");
        }
        return clone;
    }
  
}
