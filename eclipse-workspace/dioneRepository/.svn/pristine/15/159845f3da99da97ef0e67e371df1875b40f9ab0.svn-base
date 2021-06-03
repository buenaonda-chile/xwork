/*
 * Project : DICAS
 *
 * $Id$
 *
 * Copyright (c) 2018 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dicas.business.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * [EN] Domain class of base information.<br>
 * [JP] Domain class of base information。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Data
@NoArgsConstructor
public class BaseDomain implements Serializable {

  /**
   * [EN] Serial Version UID.<br>
   * [JP] シリアルバージョンID。<br>
   */
  private static final long serialVersionUID = 1042307867534302416L;

  /**
   * [EN] Row No.<br>
   * [JP] Row No。<br>
   */
  private Integer rn;

  /**
   * [EN] Table PK.<br>
   * [JP] Table PK。<br>
   */
  @JsonIgnore
  private Long _id;


  /**
   * [EN] registration Id.<br>
   * [JP] registration Id.<br>
   */
  @JsonIgnore
  private Long rgstrId;

  /**
   * [EN] update Id.<br>
   * [JP] update Id.<br>
   */
  @JsonIgnore
  private Long updtrId;


  /**
   * [EN] registration account name.<br>
   * [JP] registration account name.<br>
   */
  private String rgstrAcctNm;

  /**
   * [EN] update account name.<br>
   * [JP] update account name.<br>
   */
  private String updtrAcctNm;

  /**
   * [EN] registration datetime.<br>
   * [JP] registration datetime.<br>
   */
  @Setter
  @JsonIgnore
  private LocalDateTime rgstDt;

  /**
   * [EN] update datetime.<br>
   * [JP] update datetime.<br>
   */
  @Setter
  @JsonIgnore
  private LocalDateTime updtDt;

  /**s
   * [EN] It is a getter method of rgstDt.<br>
   * [JP] It is a getter method of rgstDt。<br>
   */
  @JsonIgnore
  public LocalDateTime getRgstDt() {
    if (rgstDt != null)
      return rgstDt;
    else
      return LocalDateTime.now();
  }

  /**
   * [EN] It is a getter method of updtDt.<br>
   * [JP] It is a getter method of updtDt。<br>
   */
  @JsonIgnore
  public LocalDateTime getUpdtDt() {
    if (updtDt != null)
      return updtDt;
    else
      return LocalDateTime.now();
  }

  /**
   * [EN] It is a getter method of rgstDt's formatter.<br>
   * [JP] It is a getter method of rgstDt's formatter。<br>
   */
  public String getRgstDe() {
    return getRgstDt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }

  /**
   * [EN] It is a getter method of updtDt's formatter.<br>
   * [JP] It is a getter method of updtDt's formatter。<br>
   */
  public String getUpdtDe() {
    return getUpdtDt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }
}
