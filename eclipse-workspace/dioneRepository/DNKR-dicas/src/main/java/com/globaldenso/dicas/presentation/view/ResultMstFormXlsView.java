package com.globaldenso.dicas.presentation.view;

import com.globaldenso.dicas.business.dto.ResultMasterDto;
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


@Component("resultMstFormXlsView")
public class ResultMstFormXlsView extends CustomAbstractXlsView {

    public ResultMstFormXlsView() {
        super();
        setUrl("/WEB-INF/excel/resultMstXlsForm");
    }
    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook hssfWorkbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

        String today = EgovDateUtil.getCurrentDateAsString();
        String strFileName = "처리상황정보_" + today + ".xls";

        List<ResultMasterDto> codeDtos = new ArrayList<>();
        if (model.get("result") != null) {
            codeDtos = (List<ResultMasterDto>)model.get("result");
        }

        HSSFCell cell;
        HSSFSheet sheet =  hssfWorkbook.getSheetAt(0);

        int row = 1;

        for(ResultMasterDto item : codeDtos) {
            int col = 0;

            cell = getCell(sheet, row, col++);
            setText(cell, item.getManageNo());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReceiptDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getResearchDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getOfficeNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getSdNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReplacePartNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getHmcPartNo());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getTotalAmts());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getApprovalStatus());


            row++;
        }

        NetworkUtil.setDisposition(strFileName, request, response);
        response.setHeader("Content-Transfer-Encoding", "binary");
    }

}
