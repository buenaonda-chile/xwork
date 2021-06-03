/*
 * Project : DICAS
 *
 * junghwi.son
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.dto;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.dicas.business.domain.GroupDomain;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EN] Group class of Menu information.<br>
 * [JP] Group class of Menu information?<br>
 * @author TWOGOMS
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class GroupDto extends GroupDomain {

  private static final long serialVersionUID = 684506991514829440L;

  private int deptLvl;
  private int deptMaxLvl;
  private boolean expanded = true;
  private boolean enabled = true;
  List<GroupDto> subGroupItems = new ArrayList<>();

  public String getDeptNm() {

    String locale = DensoContext.get().getLocale().getLanguage();

    if ("ko".equals(locale))
      return getDeptKoNm();
    else if ("ja".equals(locale))
      return getDeptJaNm();
    else
      return getDeptEnNm();
  }

  public String getParentId() {
    if (!EgovStringUtil.isEmpty(getUpperDeptCd()))
      return getUpperDeptCd();
    else
      return null;
  }
}
