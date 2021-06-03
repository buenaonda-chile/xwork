/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dto;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.dicas.business.domain.RoleDomain;
import egovframework.rte.fdl.string.EgovStringUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EN] Role class of Menu information.<br>
 * [JP] Role class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class RoleDto extends RoleDomain {

  private static final long serialVersionUID = 990883205624535552L;

  public String getParentId() {
    if (EgovStringUtil.isEmpty(getUpperRoleCd()))
      return null;
    else
      return getUpperRoleCd();
  }

  public void setParentId(String value) {
    if (!EgovStringUtil.isEmpty(value))
      setUpperRoleCd(value);
  }
}
