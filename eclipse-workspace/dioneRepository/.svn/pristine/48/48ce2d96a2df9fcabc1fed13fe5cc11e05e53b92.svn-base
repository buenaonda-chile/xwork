package com.globaldenso.dicas.business.dto;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.dicas.business.domain.MenuDomain;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuDto extends MenuDomain {

  private static final long serialVersionUID = 3842918299605072615L;

  private String menuKoFulnm;
  private String menuEnFulnm;
  private String menuJaFulnm;
  private int menuLvl;
  private int menuMaxLvl;
  List<MenuDto> subMenuItems = new ArrayList<>();

  /**
   * [EN] It is a getter method of menuKey.<br>
   * [JP] It is a getter method of menuKey<br>
   *
   * @return the menuKey
   */
  public String getMenuKey() {
    if (get_id()!= null)
      return EgovStringUtil.long2string(get_id());
    else
      return null;
  }

  /**
   * [EN] It is a setter method of menuKey.<br>
   * [JP] It is a setter method of menuKey。<br>
   *
   * @param value menuKey
   */
  public void setMenuKey(String value) {
    if (!EgovStringUtil.isNull(value))
      set_id(Long.parseLong(value));
  }

  /**
   * [EN] It is a getter method of getMenuNm.<br>
   * [JP] It is a getter method of getMenuNm.<br>
   *
   * @return the getMenuNm
   */
  public String getMenuNm() {

    String locale = DensoContext.get().getLocale().getLanguage();

    if ("ko".equals(locale))
      return getMenuKoNm();
    else if ("ja".equals(locale))
      return getMenuJaNm();
    else
      return getMenuEnNm();
  }

  public String getMenuFulnm() {

    String locale = DensoContext.get().getLocale().getLanguage();

    if ("ko".equals(locale))
      return getMenuKoFulnm();
    else if ("ja".equals(locale))
      return getMenuJaFulnm();
    else
      return getMenuEnFulnm();
  }
}
