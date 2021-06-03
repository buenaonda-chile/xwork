/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dto;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.dicas.business.domain.MenuRoleDomain;
import egovframework.rte.fdl.string.EgovStringUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EN] MenuRole class of Menu information.<br>
 * [JP] MenuRole class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class MenuRoleDto extends MenuRoleDomain {

  private static final long serialVersionUID = 802823487022238848L;

  private Long upperMenuId;
  private String menuKoNm;
  private String menuEnNm;
  private String menuJaNm;
  private boolean isUse;

  public String getMenuKey() {
    if (getMenuId() != null)
      return String.valueOf(getMenuId());
    else
      return null;
  }

  public void setMenuKey(String value) {
    if (!EgovStringUtil.isEmpty(value))
      setMenuId(Long.parseLong(value));
  }

  public String getUpperMenuKey() {
    if (upperMenuId != null)
      return String.valueOf(upperMenuId);
    else
      return null;
  }

  public void setUpperMenuKey(String value) {
    if (!EgovStringUtil.isEmpty(value))
      setUpperMenuId(Long.parseLong(value));
  }

}
