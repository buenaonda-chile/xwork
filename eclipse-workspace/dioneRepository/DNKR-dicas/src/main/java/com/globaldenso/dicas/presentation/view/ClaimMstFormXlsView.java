package com.globaldenso.dicas.presentation.view;

import com.globaldenso.dicas.business.dto.ClaimVehicleDto;
import com.globaldenso.dicas.business.dto.ResultMasterDto;
import com.globaldenso.dicas.presentation.servlet.view.document.CustomAbstractXlsView;
import com.globaldenso.dicas.util.NetworkUtil;
import egovframework.rte.fdl.string.EgovDateUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component("claimMstFormXlsView")
public class ClaimMstFormXlsView extends CustomAbstractXlsView {

    public ClaimMstFormXlsView() {
        super();
        setUrl("/WEB-INF/excel/claimMstXlsForm2");
    }
    @Override
    protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook hssfWorkbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {

        String today = EgovDateUtil.getCurrentDateAsString();
        String strFileName = "클레임현황정보_" + today + ".xls";

        List<ClaimVehicleDto> codeDtos = new ArrayList<>();
        if (model.get("result") != null) {
            codeDtos = (List<ClaimVehicleDto>)model.get("result");
        }

        HSSFCell cell;
        HSSFSheet sheet =  hssfWorkbook.getSheetAt(0);

        int row = 1;

        for(ClaimVehicleDto item : codeDtos) {
            int col = 0;

            cell = getCell(sheet, row, col++);
            setText(cell, item.getManageNo());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getTireStdNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getVinno());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getSaleCountry());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getMakerNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getModel());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getRemark());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getExhaustRegNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getEngineTypeNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getProdDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getSaleDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getCallStatus());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReceiptDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReceiptNm());              //접수자

            cell = getCell(sheet, row, col++);
            setText(cell, item.getInquiryGubunNm());         //부품구분

            cell = getCell(sheet, row, col++);
            setText(cell, item.getInquiry());                //문의품

            cell = getCell(sheet, row, col++);
            setText(cell, item.getOfficeCode());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getOfficeCityNm());            //소재지

            cell = getCell(sheet, row, col++);
            setText(cell, item.getOfficeNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getMileage().toString());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getWarrantState());            //보증

            cell = getCell(sheet, row, col++);
            setText(cell, item.getStatus());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getMainCategoryNm());          //현상대분류

            cell = getCell(sheet, row, col++);
            setText(cell, item.getSmallCategoryNm());         //현상소분류

            cell = getCell(sheet, row, col++);
            setText(cell, item.getDtc());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getConsultingDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getConsultingNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getSdAppoint());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getConsultingCont());            //정비소상담내용

            cell = getCell(sheet, row, col++);
            setText(cell, item.getResearchDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getResearchNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getResearchType());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getResearchCont());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getRoNo());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getRecallReqDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getGqnetIssueDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReceiveDate());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getEnginNo());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getRemoveNo());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getRepairDate());            //수리일

            cell = getCell(sheet, row, col++);
            setText(cell, item.getRoConfirmDate());

            cell = getCell(sheet, row, col++);              //결과구분
            setText(cell, item.getActionType());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getMatDiv());                //자재구분

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReplacePartNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReplacePartNo());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getReplacePartCnt());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getTotalAmt().toString());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getCsrs());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getGqnetNo());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getFieldWorkResult());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getFinalResearchResult());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getQualityProblemNm());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getTotalVal().toString());

            cell = getCell(sheet, row, col++);
            setText(cell, item.getRoSpecialFeature());

            row++;
        }

        NetworkUtil.setDisposition(strFileName, request, response);
        response.setHeader("Content-Transfer-Encoding", "binary");
    }

}
