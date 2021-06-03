/*
 * Project : ai_sample
 *
 * $Id$
 *
 * Copyright (c) 2015 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.ai.sample.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.globaldenso.ai.sample.validation.constraint.IntegerDigitsValidatorForBigDecimal;
import com.globaldenso.ai.sample.validation.constraint.IntegerDigitsValidatorForCharSequence;

/**
 * [EN] BeanValidation Annotation to to check Integer digits.<br>
 * [JP] 整数桁数をチェックするBeanValidationアノテーション。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Documented
// クラスに付けるものはElementType.TYPEで、それ以外は以下のように
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
    ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
// validateByの中にConstraintValidationクラスを指定する(複数可)
@Constraint(validatedBy = { IntegerDigitsValidatorForCharSequence.class,
    IntegerDigitsValidatorForBigDecimal.class })
public @interface IntegerDigits {

    /**
     * [EN] Defualt message of BeanValidation error.<br>
     * [JP] バリデーションエラーデフォルトメッセージ。<br>
     * 
     * @return String
     **/
    String message() default "{com.globaldenso.ai.sample.validation.IntegerDigits.message}";
    
    /**
     * [EN] Digit number.<br>
     * [JP] 桁数。<br>
     * 
     * @return int
     */
    int number();


    /**
     * [EN] Specify groups to verify in each group.<br>
     * [JP] ベリファイ対象のグループ。<br>
     * 
     * @return Class<?>[]
     */
    Class<?>[] groups() default { };

    /**
     * [EN] Specify payload to categorize validations.<br>
     * [JP] バリデーションを分類するペイロード。<br>
     * 
     * @return Class<? extends Payload>[]
     */
    Class<? extends Payload>[] payload() default { };
    
}
