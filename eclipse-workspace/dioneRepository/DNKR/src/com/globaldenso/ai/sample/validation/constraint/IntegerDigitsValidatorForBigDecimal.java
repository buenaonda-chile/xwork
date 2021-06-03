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
 * [JP] 桁数以下の整数かをチェックする<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
public class IntegerDigitsValidatorForBigDecimal implements
    ConstraintValidator<IntegerDigits, BigDecimal> {

    /**
     * [EN] significant digit number.<br>
     * [JP] 有効桁数。<br>
     */
    private int number;

    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public IntegerDigitsValidatorForBigDecimal() {
    }

    /**
     * {@inheritDoc}
     * 
     * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
     */
    @Override
    public void initialize(IntegerDigits constraint) {
        this.number = constraint.number();
    }

    /**
     * {@inheritDoc}
     * 
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
     */
    @Override
    public boolean isValid(BigDecimal bigNum,
        ConstraintValidatorContext constraintValidatorContext) {
        if (bigNum == null) {
            return true;
        }

        int integerPartLength = bigNum.precision() - bigNum.scale();
        int fractionPartLength = 0;
        if (0 <= bigNum.scale()) {
            fractionPartLength = bigNum.scale();
        }

        return integerPartLength <= number && fractionPartLength == 0;
    }

}
