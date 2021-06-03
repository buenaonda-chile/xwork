/*
 * Project : DICAS
 *
 * ryan.lee
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dto;

import com.globaldenso.dicas.business.domain.DtcDomain;
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
public class DtcDto extends DtcDomain {

  private static final long serialVersionUID = 550898019948912512L;
  private String exhaustRegNm;
  private String engineTypeNm;

}
