/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.presentation.form;

import com.globaldenso.dicas.business.dto.TotalAlnalysisDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EN] TotalAlnalysis class of Menu information.<br>
 * [JP] TotalAlnalysis class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class TotalAlnalysisSearchForm extends TotalAlnalysisDto {

  private static final long serialVersionUID = 2166542222124406038L;

  private String dateSearchOption;
  private String roSearchOption;
  private String csrsSearchOption;
}
