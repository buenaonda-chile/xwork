package com.globaldenso.dicas.presentation.view;

import com.globaldenso.dicas.business.dto.TrainingAppcntViewDto;
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


@Component("trainingAppcntViewFormXlsView")
public class TrainingAppcntViewFormXlsView extends CustomAbstractXlsView {

    public TrainingAppcntViewFormXlsView() {
        super();
        setUrl("/WEB-INF/excel/trainingAppcntViewXlsForm");
    }
    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook hssfWorkbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

        String today = EgovDateUtil.getCurrentDateAsString();
        String strFileName = "교육신청자조회_" + today + ".xls";

        List<TrainingAppcntViewDto> codeDtos = new ArrayList<>();
        if (model.get("result") != null) {
            codeDtos = (List<TrainingAppcntViewDto>)model.get("result");
        }

        HSSFCell cell;
        HSSFSheet sheet =  hssfWorkbook.getSheetAt(0);

        int row = 1;

        for(TrainingAppcntViewDto item : codeDtos) {
            int col = 0;
            
            cell = getCell(sheet, row, col++);
            setNumeric(cell, item.getRn());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getEduNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getOfficeNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReprNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getTelNo());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getEmail());

            row++;
        }

        NetworkUtil.setDisposition(strFileName, request, response);
        response.setHeader("Content-Transfer-Encoding", "binary");
    }

}
