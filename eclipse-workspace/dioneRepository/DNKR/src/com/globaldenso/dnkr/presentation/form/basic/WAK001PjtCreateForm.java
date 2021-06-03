package com.globaldenso.dnkr.presentation.form.basic;


import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import com.globaldenso.dnkr.domain.PjtDomain;
/**
 * @author $Author$
 * @version $Revision$
 */
public class WAK001PjtCreateForm extends PjtDomain {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 2061184600210287301L;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAK001PjtCreateForm() {
        super();
    }
    /**
     * {@inheritDoc}
     * @see com.globaldenso.dnkr.domain.PjtDoamain#getEmpNumber()
     */
//    @Override
//    @NotEmpty
//    @Size(max = 30)
//    public String getEmpNumber() {
//        return super.getEmpNumber();
//    }
    
    /**
     * {@inheritDoc}
     * @see com.globaldenso.dnkr.domain.PjtDoamain#getWorkHour()
     */
//    @Override
//    @NotEmpty
////    @Max(value=(long) 24.0) //: 지정된 값보다 아래일 경우만 통과 가능
////    @Min(value=0) //: 지정된 값보다 이상일 경우만 통과 가능
////    @Digits(integer=2,fraction=1) //: 지정된 값 이상의 실수만 통과 가능
//    public Float getWorkHour() {
//        return super.getWorkHour();
//    }
    
    /**
     * {@inheritDoc}
     * @see com.globaldenso.dnkr.domain.PjtDoamain#getWorkCode()
     */
    @Override
    @NotEmpty
    @Size(max = 10)
    public String getWorkCode() {
        return super.getWorkCode();
    }

}
