/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.ai.sample.validation.constraint;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.globaldenso.ai.sample.validation.annotation.IntegerDigits;

/**
 * [EN] Check that the input is a significant figure.<br>
 * [JP] 桁数以下の整数かをチェックする。<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class IntegerDigitsValidatorForCharSequence implements ConstraintValidator<IntegerDigits, CharSequence> {
    
    /**
     * [EN] significant digit number.<br>
     * [JP] 指定桁数。<br>
     */
    private int number;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public IntegerDigitsValidatorForCharSequence() {
    }
    
    /**
     * {@inheritDoc}
     * 
     * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
     */
    @Override
    public void initialize(IntegerDigits constraint) {
        // If the constraint annotation has any data, save these data to private fields for isValid method.
        this.number = constraint.number();
    }
    
    /**
     * 
     * {@inheritDoc}
     * 
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
     */
    @Override
    public boolean isValid(CharSequence charSequence,
        ConstraintValidatorContext constraintValidatorContext) {
        if (charSequence == null) {
            return true;
        }

        if ("".equals(charSequence.toString())) {
            return true;
        }
        BigDecimal bigNum = getBigDecimalValue(charSequence);
        if (bigNum == null) {
            return false;
        }

        int integerPartLength = bigNum.precision() - bigNum.scale();
        int fractionPartLength = 0;
        if (0 <= bigNum.scale()) {
            fractionPartLength = bigNum.scale();
        }

        return integerPartLength <= number && fractionPartLength == 0;
    }

    /**
     * [EN] Convert a CharSequence to a BigDecimal.<br>
     * [JP] CharSequenceからBigDecimalに変換する。<br>
     *
     * @param charSequence 入力されるCharSequence
     * @return 変換されたBigDecimal
     */
    private BigDecimal getBigDecimalValue(CharSequence charSequence) {
        BigDecimal bd;
        try {
            bd = new BigDecimal(charSequence.toString());
        } catch (NumberFormatException nfe) {
            return null;
        }
        return bd;
    }
    
}
