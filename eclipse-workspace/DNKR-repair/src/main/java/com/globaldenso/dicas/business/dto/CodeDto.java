package com.globaldenso.dicas.business.dto;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.dicas.business.domain.CodeDomain;
import egovframework.rte.fdl.string.EgovStringUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class CodeDto extends CodeDomain {

  private static final long serialVersionUID = -4995304423496256765L;

  /**
   * [EN] It is a getter method of codeKey.<br>
   * [JP] It is a getter method of codeKey<br>
   *
   * @return the codeKey
   */
  public String getCodeKey() {
    if (get_id() != null)
      return EgovStringUtil.long2string(get_id());
    else
      return null;
  }

  /**
   * [EN] It is a setter method of codeKey.<br>
   * [JP] It is a setter method of codeKey。<br>
   *
   * @param value codeKey
   */
  public void setCodeKey(String value) {
    if (!EgovStringUtil.isNull(value))
      set_id(Long.parseLong(value));
  }

  /**
   * [EN] It is a getter method of getCodeNm.<br>
   * [JP] It is a getter method of getCodeNm.<br>
   *
   * @return the getCodeNm
   */
  public String getCodeNm() {

    String locale = DensoContext.get().getLocale().getLanguage();

    if ("ko".equals(locale))
      return getCodeKoNm();
    else if ("ja".equals(locale))
      return getCodeJaNm();
    else
      return getCodeEnNm();
  }

  /**
   * [EN] It is a setter method of getCodeNm.<br>
   * [JP] It is a setter method of getCodeNm.<br>
   * @param value codeNm
   */
  public void setCodeNm(String value) {
    if (!EgovStringUtil.isNull(value)) {

      String locale = DensoContext.get().getLocale().getLanguage();
      if ("ko".equals(locale))
        setCodeKoNm(value);
      else if ("ja".equals(locale))
        setCodeJaNm(value);
      else
        setCodeEnNm(value);
    }
  }

}
