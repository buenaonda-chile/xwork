package com.globaldenso.dicas.presentation.view;

import com.globaldenso.dicas.business.dto.TrainingAppcntStatDto;
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


@Component("trainingAppcntStatFormXlsView")
public class TrainingAppcntStatFormXlsView extends CustomAbstractXlsView {

    public TrainingAppcntStatFormXlsView() {
        super();
        setUrl("/WEB-INF/excel/trainingAppcntStatXlsForm");
    }
    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook hssfWorkbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

        String today = EgovDateUtil.getCurrentDateAsString();
        String strFileName = "교육신청자현황_" + today + ".xls";

        List<TrainingAppcntStatDto> codeDtos = new ArrayList<>();
        if (model.get("result") != null) {
            codeDtos = (List<TrainingAppcntStatDto>)model.get("result");
        }

        HSSFCell cell;
        HSSFSheet sheet =  hssfWorkbook.getSheetAt(0);

        int row = 1;

        for(TrainingAppcntStatDto item : codeDtos) {
            int col = 0;
            
            cell = getCell(sheet, row, col++);
            setNumeric(cell, item.getEduCnt());

            cell = getCell(sheet, row, col++);
            setNumeric(cell, item.getTraineeCnt());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReceiptEndDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getEduDt());

            row++;
        }

        NetworkUtil.setDisposition(strFileName, request, response);
        response.setHeader("Content-Transfer-Encoding", "binary");
    }

}
