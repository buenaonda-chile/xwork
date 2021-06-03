/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dto;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.dicas.business.domain.ResearchDomain;
import egovframework.rte.fdl.string.EgovStringUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EN] Research class of Menu information.<br>
 * [JP] Research class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class ResearchDto extends ResearchDomain {

  private static final long serialVersionUID = 284738473302646240L;

  AtchmnflDto atchmnflItem;

  public String getFlext() {
    if (atchmnflItem != null) {
      return atchmnflItem.getFlext();
    }
    return null;
  }

  public String getAtchmnflNm() {
    if (atchmnflItem != null)
      return atchmnflItem.getAtchmnflNm();
    else
      return null;
  }

  public void setAtchmnflNm(String value) {
    if (!EgovStringUtil.isEmpty(value))
      atchmnflItem.setAtchmnflNm(value);
  }

}
