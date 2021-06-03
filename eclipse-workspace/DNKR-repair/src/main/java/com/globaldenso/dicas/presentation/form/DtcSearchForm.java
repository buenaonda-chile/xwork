/*
 * Project : DICAS
 *
 * ryan.lee
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.presentation.form;

import com.globaldenso.dicas.business.dto.DtcDto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EN] Models class of Menu information.<br>
 * [JP] Models class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class DtcSearchForm extends DtcDto {

  private static final long serialVersionUID = 2166542222124406038L;

  private String dateSearchOption;

}
