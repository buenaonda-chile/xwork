package com.globaldenso.dnkr.presentation.form.basic;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import com.globaldenso.dnkr.domain.AuthDomain;

/**
 * @author $Author$
 * @version $Revision$
 */
public class WAD001AuthCreateForm extends AuthDomain {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -4298288204069228300L;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAD001AuthCreateForm() {
        super();
    }
    
    /**
    * {@inheritDoc}
    * @see com.globaldenso.dnkr.domain.AuthDoamain#getAuthName()
    */
    @Override
    @NotEmpty
    @Size(max = 30)
    public String getAuthName() {
        return super.getAuthName();
    }

}
