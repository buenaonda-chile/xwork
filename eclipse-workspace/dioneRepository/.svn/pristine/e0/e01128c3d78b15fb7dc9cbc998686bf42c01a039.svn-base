package com.globaldenso.dicas.security.common;

import com.globaldenso.ai.core.context.DensoContext;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginVO implements Serializable {

  private static final long serialVersionUID = 1393227789623408976L;

  private String uniqId;
  private String username;
  private String email;
  private String fstNm;
  private String mdlNm;
  private String lstNm;

  private String serviceType;

  private String deptCd;
  private String deptKoNm;
  private String deptEnNm;
  private String deptJaNm;

  private String officeCd;
  private String officeNm;

  private String loginIp;

  public String getFulnm() {

    String locale = DensoContext.get().getLocale().getLanguage();

    if ("ko".equals(locale))
      return lstNm + fstNm;
    else
      return fstNm + " " + lstNm;
  }

  public String getDeptNm() {

    String locale = DensoContext.get().getLocale().getLanguage();

    if ("ko".equals(locale))
      return deptKoNm;
    else if ("ja".equals(locale))
      return deptJaNm;
    else
      return deptEnNm;
  }
}
