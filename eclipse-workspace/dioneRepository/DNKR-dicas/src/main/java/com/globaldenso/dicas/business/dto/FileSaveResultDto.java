package com.globaldenso.dicas.business.dto;

import egovframework.rte.fdl.string.EgovStringUtil;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

public class FileSaveResultDto implements Serializable {

  private static final long serialVersionUID = -4301132435508672907L;

  private boolean uploaded;
  private String fileUid;
  private Long atchmnflId;

  public boolean getUploaded() {
    return uploaded;
  }

  public void setUploaded(boolean value) {
    uploaded = value;
  }

  public String getFileUid() {
    return fileUid;
  }

  public void setFileUid(String value) {
    fileUid = value;
  }

  public String getAtchmnflId() {
    if (atchmnflId != null)
      return String.valueOf(atchmnflId);
    else
      return null;
  }

  public void setAtchmnflId(String value) {
    if (!EgovStringUtil.isEmpty(value))
      atchmnflId = Long.parseLong(value);
  }
}
