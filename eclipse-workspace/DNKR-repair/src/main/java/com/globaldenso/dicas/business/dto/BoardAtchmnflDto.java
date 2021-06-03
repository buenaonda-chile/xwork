package com.globaldenso.dicas.business.dto;

import com.globaldenso.dicas.business.domain.BoardAtchmnflDomain;
import egovframework.rte.fdl.string.EgovStringUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardAtchmnflDto extends BoardAtchmnflDomain {

  private static final long serialVersionUID = 144421280660679849L;

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
