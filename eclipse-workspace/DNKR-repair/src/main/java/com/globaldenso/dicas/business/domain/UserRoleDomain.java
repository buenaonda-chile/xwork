package com.globaldenso.dicas.business.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRoleDomain extends BaseDomain {

  private static final long serialVersionUID = 69923092066624830L;

  private Long userId;
  private String roleCd;

}
