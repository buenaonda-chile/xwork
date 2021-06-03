package com.globaldenso.dicas.business.domain;

import egovframework.rte.fdl.string.EgovStringUtil;
import java.text.Normalizer;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtchmnflDomain extends BaseDomain{

  private static final long serialVersionUID = 3791864328672380240L;

  private String atchmnflNm;
  public String getAtchmnflNm() {
    if (!EgovStringUtil.isEmpty(atchmnflNm))
      return Normalizer.normalize(atchmnflNm, Normalizer.Form.NFC);
    else
      return null;
  }

  private String flstreNm;
  private String flpth;
  private long atchmnflSize;
  private String flext;
  private String atchmnflUid;
  private String delYn = "N";
}
