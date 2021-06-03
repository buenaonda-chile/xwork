package com.globaldenso.dicas.business.dto;

import com.globaldenso.dicas.business.domain.BoardDomain;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto extends BoardDomain {

  private static final long serialVersionUID = 2648591331774966411L;

  private String files;
  private List<AtchmnflDto> atchmnflItems;

  public String getBoardSeq() {
    if (getSeq() != null)
      return String.valueOf(getSeq());
    else
      return null;
  }

  public void setBoardSeq(String value) {
    if (!EgovStringUtil.isEmpty(value))
      setSeq(Long.parseLong(value));
  }

  public boolean getIsNotice() {
    if (EgovStringUtil.isEmpty(getNoticeYn()))
      return false;
    else {
      if ("Y".equals(getNoticeYn()))
        return true;
      else
        return false;
    }
  }

  public void setIsNotice(Boolean value) {
    if (value == null)
      setNoticeYn("N");
    else {
      if (value.booleanValue()) {
        setNoticeYn("Y");
      } else {
        setNoticeYn("N");
      }
    }
  }

  public boolean getIsSd(){
    if(EgovStringUtil.isEmpty(getSdYn())){
      return false;
    }else{
      if ("Y".equals(getSdYn())){
        return true;
      }else{
        return false;
      }
    }
  }

  public void setIsSd(Boolean value){
    if (value == null){
      setSdYn("N");
    }else{
      if(value.booleanValue()){
        setSdYn("Y");
      }else{
        setSdYn("N");
      }
    }
  }
}
