package com.globaldenso.dicas.presentation.servlet.view.document;

import java.util.Locale;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.LocalizedResourceHelper;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.AbstractView;

public abstract class CustomAbstractXlsView extends AbstractView {

  private String url;

  public CustomAbstractXlsView() {
    this.setContentType("application/vnd.ms-excel");
  }

  public void setUrl(String url) {this.url = url;}

  protected boolean generatesDownloadContent() {
    return true;
  }

  @Override
  protected void renderMergedOutputModel(Map<String, Object> map,
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
      throws Exception {
    HSSFWorkbook workbook;
    if (this.url != null) {
      workbook = this.getTemplateSource(this.url, httpServletRequest);
    } else {
      workbook = new HSSFWorkbook();
      this.logger.debug("Created Excel Workbook from scratch");
    }

    this.buildExcelDocument(map, workbook, httpServletRequest, httpServletResponse);
    httpServletResponse.setContentType(this.getContentType());
    ServletOutputStream out = httpServletResponse.getOutputStream();
    workbook.write(out);
    out.flush();

  }

  protected HSSFWorkbook getTemplateSource(String url, HttpServletRequest request)
      throws Exception {
    LocalizedResourceHelper helper = new LocalizedResourceHelper(this.getApplicationContext());
    Locale userLocale = RequestContextUtils.getLocale(request);
    Resource inputFile = helper.findLocalizedResource(url, ".xls", userLocale);
    if (this.logger.isDebugEnabled()) {
      this.logger.debug("Loading Excel workbook from " + inputFile);
    }

    return new HSSFWorkbook(inputFile.getInputStream());
  }

  protected abstract void buildExcelDocument(Map<String, Object> model, HSSFWorkbook hssfWorkbook,
      HttpServletRequest request, HttpServletResponse response) throws Exception;

  protected HSSFCell getCell(HSSFSheet sheet, int row, int col) {
    HSSFRow sheetRow = sheet.getRow(row);
    if (sheetRow == null) {
      sheetRow = sheet.createRow(row);
    }

    HSSFCell cell = sheetRow.getCell(col);
    if (cell == null) {
      cell = sheetRow.createCell(col);
    }

    return cell;
  }

  protected void setText(HSSFCell cell, String text) {
    cell.setCellType(Cell.CELL_TYPE_STRING);
    cell.setCellValue(text);
  }

  protected void setNumeric(HSSFCell cell, double value) {
    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
    cell.setCellValue(value);
  }
}
