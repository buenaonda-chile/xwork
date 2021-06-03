package com.globaldenso.dicas.business.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeptTreeDto implements Serializable {

  private String deptCd;
  private String deptNm;
  private String upperDeptCd;
  private String groupId;
  private String useYn;
  private boolean expanded = true;
  private List<DeptTreeDto> items;
}
