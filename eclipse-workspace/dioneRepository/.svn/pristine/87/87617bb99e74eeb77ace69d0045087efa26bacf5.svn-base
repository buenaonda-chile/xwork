/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dto;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.dicas.business.domain.UserDomain;
import egovframework.rte.fdl.string.EgovStringUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EN] User class of Menu information.<br>
 * [JP] User class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class UserDto extends UserDomain {

  private static final long serialVersionUID = 662360895226528000L;

  private String fulnm;
  private String roleCd;
  private String officeNm;
  private String lstFulnm;
  private String fstFulnm;

  public String getUserId() {
    if (get_id() != null) {
      return String.valueOf(get_id());
    } else
      return null;
  }

  public void setUserId(String value) {
    if (!EgovStringUtil.isEmpty(value))
      set_id(Long.parseLong(value));
  }

  public String getFulnm() {

    if (!EgovStringUtil.isEmpty(getLstFulnm())) {
      String locale = DensoContext.get().getLocale().getLanguage();
      if ("ko".equals(locale))
        return getLstFulnm();
      else
        return getFstFulnm();
    } else
      return fulnm;
  }
}
