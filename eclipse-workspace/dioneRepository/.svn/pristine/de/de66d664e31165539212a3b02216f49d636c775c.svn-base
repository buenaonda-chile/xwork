/*
 * Project : DICAS
 *
 * $Id$
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.domain;

import egovframework.rte.fdl.string.EgovStringUtil;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EN] Domain class of Menu information.<br>
 * [JP] Domain class of Menu information。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Data
@NoArgsConstructor
public class MenuDomain extends BaseDomain {

  /**
   * [EN] Serial Version UID.<br>
   * [JP] シリアルバージョンID。<br>
   */
  private static final long serialVersionUID = 504875995696807251L;

  private String menuKoNm;
  private String menuEnNm;
  private String menuJaNm;
  private String menuCd;
  private int menuOrdr;
  private String menuUrl;
  private String pubYn;
  private Long upperMenuId;
  private String menuIcon;

  /**
   * [EN] It is a getter method of upperMenuKey.<br>
   * [JP] It is a getter method of upperMenuKey.<br>
   * @return the upperMenuKey
   */
  public String getUpperMenuKey() {
    if (upperMenuId != null)
      return EgovStringUtil.long2string(upperMenuId);
    else
      return null;
  }

  /**
   * [EN] It is a setter method of upperMenuKey.<br>
   * [JP] It is a setter method of upperMenuKey。<br>
   * @param value upperMenuKey
   */
  public void setUpperMenuKey(String value) {
    if (!EgovStringUtil.isNull(value))
      upperMenuId = Long.parseLong(value);
  }
}
