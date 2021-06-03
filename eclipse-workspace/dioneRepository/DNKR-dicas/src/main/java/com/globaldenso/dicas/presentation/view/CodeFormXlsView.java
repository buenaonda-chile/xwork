package com.globaldenso.dicas.presentation.view;

import com.globaldenso.dicas.business.dto.CodeDto;
import com.globaldenso.dicas.presentation.servlet.view.document.CustomAbstractXlsView;
import com.globaldenso.dicas.util.NetworkUtil;
import egovframework.rte.fdl.string.EgovDateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

@Component("codeFormXlsView")
public class CodeFormXlsView extends CustomAbstractXlsView {

  public CodeFormXlsView() {
    super();
    setUrl("/WEB-INF/excel/codeXlsForm");
  }

  @Override
  protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook hssfWorkbook,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    String today = EgovDateUtil.getCurrentDateAsString();
    String strFileName = "코드정보_" + today + ".xls";

    List<CodeDto> codeDtos = new ArrayList<>();
    if (model.get("result") != null) {
      codeDtos = (List<CodeDto>)model.get("result");
    }

    HSSFCell cell;
    HSSFSheet sheet =  hssfWorkbook.getSheetAt(0);

    int row = 1;

    for(CodeDto item : codeDtos) {
      int col = 0;

      cell = getCell(sheet, row, col++);
      setText(cell, item.getCodeKey());

      cell = getCell(sheet, row, col++);
      setText(cell, item.getCodeKoNm());

      cell = getCell(sheet, row, col++);
      setText(cell, item.getCodeEnNm());

      cell = getCell(sheet, row, col++);
      setText(cell, item.getCodeJaNm());

      cell = getCell(sheet, row, col++);
      setNumeric(cell, item.getCodeOrdr());

      cell = getCell(sheet, row, col++);
      setText(cell, item.getUseYn());

      cell = getCell(sheet, row, col++);
      setText(cell, item.getRef1());

      cell = getCell(sheet, row, col++);
      setText(cell, item.getRef2());

      cell = getCell(sheet, row, col++);
      setText(cell, item.getRef3());

      cell = getCell(sheet, row, col++);
      setText(cell, item.getRef4());

      cell = getCell(sheet, row, col++);
      setText(cell, item.getRef5());

      row++;
    }

    NetworkUtil.setDisposition(strFileName, request, response);
    response.setHeader("Content-Transfer-Encoding", "binary");
  }
}
