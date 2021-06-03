package com.globaldenso.dicas.presentation.form;

import com.globaldenso.dicas.business.dto.CodeDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CodeSearchForm extends CodeDto {

  private static final long serialVersionUID = 2166542222124406038L;

  private List<String> grpCds;
}
