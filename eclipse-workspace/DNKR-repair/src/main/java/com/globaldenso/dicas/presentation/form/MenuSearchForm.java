package com.globaldenso.dicas.presentation.form;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.dicas.business.dto.MenuDto;
import egovframework.rte.fdl.string.EgovStringUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuSearchForm extends MenuDto {

  private static final long serialVersionUID = 8047293921165814305L;

  private Long upperMenuId;
  private Long userId;

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
