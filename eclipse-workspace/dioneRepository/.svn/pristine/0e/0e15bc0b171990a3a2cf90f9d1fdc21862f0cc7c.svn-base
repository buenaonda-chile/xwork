package com.globaldenso.dnkr.presentation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.context.DensoContext;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.viewid.annotation.ViewId;
import com.globaldenso.dnkr.business.service.SurveyService;
import com.globaldenso.dnkr.domain.QuestionDomain;
import com.globaldenso.dnkr.domain.SurveyDomain;
import com.globaldenso.dnkr.domain.TargetDomain;
import com.globaldenso.dnkr.presentation.form.basic.WAB001EmpSearchForm;

/**
 * [KR] 설문조사 전체결과 조회 페이지 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAG007SurveyTotalSelect")
@ViewId(value = "WAG007")
public class WAG007SurveyTotalSelectController {
    /**
     * [KR] 설문조사 서비스 <br>     
     */
    @Autowired
    private SurveyService surveyService;
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAG007SurveyTotalSelectController() {
        // no process
    }
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @return ModelAndView
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView init(HttpServletRequest request)  throws Exception {
        
        ModelAndView mv = new ModelAndView();    
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        String menu = ServletRequestUtils.getStringParameter(request, "menu");
        String srvCode = ServletRequestUtils.getStringParameter(request, "srvCode");
        String qstCode = ServletRequestUtils.getStringParameter(request, "qstCode");
        
        //설문정보
        SurveyDomain surveyCodeDomain = new SurveyDomain(); 
        surveyCodeDomain.setSrvCode(srvCode);
        surveyCodeDomain = surveyService.view(surveyCodeDomain);
        
        QuestionDomain form = new QuestionDomain();
        
        
        form.setCmcCode(DensoContext.get().getLocale().getLanguage());
        form.setSrvCode(srvCode);
        
        //해당 설문의 질문을 출력
        String aswTitle = "";
        String aswCode = "";
        String aswTotalCnt = "";
        int totalCount = 0;
        
        TargetDomain targetForm = new TargetDomain();
        targetForm.setSrvCode(srvCode);
        if(surveyCodeDomain.getSrvAnonymous() != null && surveyCodeDomain.getSrvAnonymous().equals("Y")) {
            totalCount = surveyService.searchAnonyTargetCount(targetForm);
        } else {
            totalCount = surveyService.searchTargetCount(targetForm);
        }
        mv.addObject("totalCount", totalCount);
        
        if(qstCode != null && !qstCode.equals("")){
            QuestionDomain domain = new QuestionDomain();
            form.setQstCode(qstCode);
            domain = surveyService.questionModi(form);

            List<QuestionDomain> answerModiList = new ArrayList<QuestionDomain>();
            answerModiList = surveyService.answerView(form);
//            System.out.println(answerModiList.size());
            for(int i = 0; i < answerModiList.size(); i++){
                aswTitle += answerModiList.get(i).getAswTitle() + "|";
                aswCode += answerModiList.get(i).getAswCode() + "|";
            }
            domain.setAswCode(aswCode);
            domain.setAswTitle(aswTitle);
            mv.addObject("domain", domain);
        }
        
        List<QuestionDomain> questionList = surveyService.questionView(form);
        TargetDomain targetDomain = new TargetDomain();
        if(questionList != null && questionList.size() > 0){
            for(int i = 0; i < questionList.size(); i++){
                aswTitle = "";
                aswCode = "";
                aswTotalCnt = "";
                String answerTotalPercent = "";
                List<String> desAnswerList = new ArrayList<String>();
                
                if(questionList.get(i).getQstType().equals("text")){
                    targetDomain.setQstCode(questionList.get(i).getQstCode());
                    desAnswerList = surveyService.answerTotalDesView(targetDomain);
                    if(desAnswerList != null){
                        questionList.get(i).setDrAnswerList(desAnswerList);
                    }
                } else if(!questionList.get(i).getQstType().equals("text")){                //타입이 text를 제외한 질문문항을 찾는다
                    form.setQstCode(questionList.get(i).getQstCode());
                    List<QuestionDomain> answerList = new ArrayList<QuestionDomain>();
                    answerList = surveyService.answerView(form);
                    //qstCode 및 srvCode 에 해당하는 질문타이틀을 가져온다
                    if(answerList != null && answerList.size() > 0){
                        for(int j = 0; j < answerList.size(); j++){
                            aswTitle += answerList.get(j).getAswTitle() + "|";
                            aswCode += answerList.get(j).getAswCode() + "|";
                            //개별답항 카운트
                            int answerCount = surveyService.answerTotalCount(answerList.get(j).getAswCode());
                            aswTotalCnt += answerCount + "|";
                            //퍼센트
                            float answerPercent = 0;
                            if(totalCount > 0){
                                answerPercent = ((float)answerCount / (float)totalCount) * 100; // 개별 답항 답변인원수  / 전체 참여인원수
                                answerTotalPercent += answerPercent + "|";
                            }else{
                                answerTotalPercent += answerPercent + "|";
                            }
                        }
                    }
                    //qstCode 및 srvCode 에 해당하는 질문타이틀을 가져온다 끝!!
                    
                    questionList.get(i).setAswCode(aswCode);
                    questionList.get(i).setAswTitle(aswTitle);
                    questionList.get(i).setAswTotalCount(aswTotalCnt);
                    questionList.get(i).setAswTotalPercent(answerTotalPercent);
                }
                //타입이 text를 제외한 질문문항을 찾는다 끝!!
            }
        }
        
        mv.addObject("questionList", questionList);
        mv.addObject("srvCode", srvCode);
        mv.addObject("menu", menu);
        mv.addObject("tabId", tabId);
        mv.addObject("url", "WAG007SurveyTotalSelect.jsp");
        mv.setViewName(".tiles.page.WAG007");
        return mv;
        
    }
    
    /**
     * [KO] 결과보기 화면 - 엑셀 다운로드
     * 
     * @param response          HttpServletResponse
     * @param request           HttpServletRequest
     * @throws Exception 
     */
    @RequestMapping(value = "/excel.do", method = {RequestMethod.GET})
    @ErrorBack(viewName = "forward:init.do")
    public void empExcel(HttpServletResponse response, HttpServletRequest request)  throws Exception {

        String srvCode = ServletRequestUtils.getStringParameter(request, "srvCode");
        String filename = ServletRequestUtils.getStringParameter(request, "filename");
        
        //설문정보
        SurveyDomain surveyCodeDomain = new SurveyDomain(); 
        surveyCodeDomain.setSrvCode(srvCode);
        surveyCodeDomain = surveyService.view(surveyCodeDomain);
        
        QuestionDomain questionDomain = new QuestionDomain();
//        QuestionDomain form = new QuestionDomain();
        questionDomain.setCmcCode(DensoContext.get().getLocale().getLanguage());
        questionDomain.setSrvCode(srvCode);
        
        int totalCount = 0; //해당설문 총 참여인원수
        int targetCount = 0; //해당설문 총 대상인원수
        float joinPercent = 0; //해당설문 총 대상인원수
        String strJoinPercent = "0"; //해당설문 총 대상인원수
        List<QuestionDomain> questionList = null;
        
        TargetDomain targetForm = new TargetDomain();
        targetForm.setSrvCode(srvCode);
        targetCount = surveyService.searchTargetTotCount(targetForm);
        if(surveyCodeDomain.getSrvAnonymous() != null && surveyCodeDomain.getSrvAnonymous().equals("Y")) { //익명성 설문조사
            totalCount = surveyService.searchAnonyTargetCount(targetForm); //익명성 설문조사 전체참여인원
        } else {
            totalCount = surveyService.searchTargetCount(targetForm); //기명성 설문조사 전체참여인원
        }
        
        if(totalCount > 0 && targetCount > 0) {
            joinPercent = ((float)totalCount / (float)targetCount) * 100; // 총 참여 인원수  / 총 대상인원수
            strJoinPercent = String.format("%.2f" , joinPercent);
        }
        
        try {
            questionList = surveyService.questionView(questionDomain); //설문 질문 리스트
        } catch (Exception e) {
            System.out.println("데이터가 없습니다.");
        }
        
        
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Result of survey");
        Row row = null;
        Cell cell = null;
        int rowNo = 3;
        
        CellStyle titleStyle = wb.createCellStyle();
        titleStyle.setFillForegroundColor(HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        
        CellStyle headStyle = wb.createCellStyle();
        headStyle.setFillForegroundColor(HSSFColorPredefined.GOLD.getIndex());
        headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headStyle.setBorderTop(BorderStyle.THIN);
        headStyle.setBorderBottom(BorderStyle.THIN);
        headStyle.setBorderLeft(BorderStyle.THIN);
        headStyle.setBorderRight(BorderStyle.THIN);
        headStyle.setAlignment(HorizontalAlignment.CENTER);
        
        CellStyle bodyStyle = wb.createCellStyle();
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);
        
        sheet.setColumnWidth(0, 1000); // 0부터 시작
        sheet.setColumnWidth(1, 10000); // 0부터 시작
        sheet.setColumnWidth(2, 10000); // 0부터 시작
        
        row = sheet.createRow(1);
        cell = row.createCell(1);
        cell.setCellValue("설문결과");
        
        String AnonyYN = "";
        if(surveyCodeDomain.getSrvAnonymous().equals("Y")) {
            AnonyYN = "무기명 설문조사";
        } else {
            AnonyYN = "기명 설문조사";
        }
        
        String[] mainTitleArr = {"설문제목",  "설문기간", "설문유형", "설문문항수", "참여수"};
        String[] mainValueArr = {
            surveyCodeDomain.getSrvTitle(),  
            surveyCodeDomain.getSrvStart() + " ~ " + surveyCodeDomain.getSrvEnd(),
            AnonyYN,
            questionList.size() + "",
            totalCount + ""
        };
        /*
        String[] mainTitleArr = {"설문제목",  "설문기간", "설문유형", "설문문항수", "대상수", "참여수", "참여율(%)"};
        String[] mainValueArr = {
            surveyCodeDomain.getSrvTitle(),  
            surveyCodeDomain.getSrvStart() + " ~ " + surveyCodeDomain.getSrvEnd(),
            AnonyYN,
            questionList.size() + "",
            targetCount + "",
            totalCount + "",
            strJoinPercent + "%",
            };
        */
        for(int i = 0; i < mainTitleArr.length; i++) {
            sheet.addMergedRegion(new CellRangeAddress(rowNo, rowNo, 2, 4));
            row = sheet.createRow(rowNo++);
            cell = row.createCell(1);
            cell.setCellStyle(titleStyle);
            cell.setCellValue(mainTitleArr[i]);
            cell = row.createCell(2);
            cell.setCellStyle(bodyStyle);
            cell.setCellValue(mainValueArr[i]);
            for(int j = 3; j < 5; j++) {
                cell = row.createCell(j);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue("");
            }
        }
        
        row = sheet.createRow(rowNo++);
        
        row = sheet.createRow(rowNo++);
        cell = row.createCell(1);
        cell.setCellStyle(headStyle);
        cell.setCellValue("문항");
        cell = row.createCell(2);
        cell.setCellStyle(headStyle);
        cell.setCellValue("답항");
        cell = row.createCell(3);
        cell.setCellStyle(headStyle);
        cell.setCellValue("투표수");
        cell = row.createCell(4);
        cell.setCellStyle(headStyle);
        cell.setCellValue("투표율");
        
        
        if(questionList != null && questionList.size() > 0){
            
            for(int i = 0; i < questionList.size(); i++){
                
                row = sheet.createRow(rowNo++);
                cell = row.createCell(1);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue((i + 1) + questionList.get(i).getQstTitle());
                
                if(questionList.get(i).getQstType().equals("text")){ //질문타입:주관식
                
                    cell = row.createCell(2);
                    cell.setCellStyle(bodyStyle); 
                    cell.setCellValue("주관식"); //답항
                    
                    cell = row.createCell(3);
                    cell.setCellStyle(bodyStyle);
                    cell.setCellValue(""); //개별답항 카운트
                    
                    cell = row.createCell(4);
                    cell.setCellStyle(bodyStyle);
                    cell.setCellValue(""); //답항별 투표율
                    
                } else if (!questionList.get(i).getQstType().equals("text")){ //질문타입:객관식
                    
                    questionDomain.setQstCode(questionList.get(i).getQstCode());
                    
                    List<QuestionDomain> answerList = null;
                    int answerListCnt = 0;
                    try {
                        answerList = surveyService.answerView(questionDomain); //답항리스트
                        answerListCnt = answerList.size();
                    } catch (Exception e) {
                        System.out.println("답항 데이터가 없습니다.");
                    }
                    
                     
                    
                    //qstCode 및 srvCode 에 해당하는 질문타이틀을 가져온다
                    if(answerList != null && answerListCnt > 0){
                        
                        for(int j = 0; j < answerListCnt; j++){
                            if(answerListCnt > 1 && j > 0) {
                                row = sheet.createRow(rowNo++);
                                cell = row.createCell(1);
                                cell.setCellStyle(bodyStyle);
                                cell.setCellValue("");
                            }
                                
                            //개별답항 카운트
                            int answerCount = surveyService.answerTotalCount(answerList.get(j).getAswCode());
                            
                            float answerPercent = 0; //투표율
                            String strAnswerPercent = "";
                            if(totalCount > 0){
                                answerPercent = ((float)answerCount / (float)totalCount) * 100; // 개별 답항 답변인원수  / 전체 참여인원수
                                strAnswerPercent = String.format("%.2f" , answerPercent);
                            }
                            
                            cell = row.createCell(2);
                            cell.setCellStyle(bodyStyle);
                            cell.setCellValue(answerList.get(j).getAswTitle());
                            
                            cell = row.createCell(3);
                            cell.setCellStyle(bodyStyle);
                            cell.setCellValue(answerCount); //개별답항 카운트
                            
//                            cell = row.createCell(4);
//                            cell.setCellStyle(bodyStyle);
//                            cell.setCellValue(totalCount); //해당설문 총 참여인원수
                            
                            cell = row.createCell(4);
                            cell.setCellStyle(bodyStyle);
                            cell.setCellValue(strAnswerPercent); //답항별 투표율
                            
                            
                        }
                    }
                }
            }
        }
        
        
        
        
        XSSFSheet sheet2 = wb.createSheet("Result of survey(detail)");
        Row row2 = null;
        Cell cell2 = null;
        int rowNo2 = 3;
        
        CellStyle titleStyle2 = wb.createCellStyle();
        titleStyle2.setFillForegroundColor(HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        titleStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle2.setBorderTop(BorderStyle.THIN);
        titleStyle2.setBorderBottom(BorderStyle.THIN);
        titleStyle2.setBorderLeft(BorderStyle.THIN);
        titleStyle2.setBorderRight(BorderStyle.THIN);
        titleStyle2.setAlignment(HorizontalAlignment.CENTER);
        
        CellStyle headStyle2 = wb.createCellStyle();
        headStyle2.setFillForegroundColor(HSSFColorPredefined.GOLD.getIndex());
        headStyle2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headStyle2.setBorderTop(BorderStyle.THIN);
        headStyle2.setBorderBottom(BorderStyle.THIN);
        headStyle2.setBorderLeft(BorderStyle.THIN);
        headStyle2.setBorderRight(BorderStyle.THIN);
        headStyle2.setAlignment(HorizontalAlignment.CENTER);
        
        CellStyle bodyStyle2 = wb.createCellStyle();
        bodyStyle2.setBorderTop(BorderStyle.THIN);
        bodyStyle2.setBorderBottom(BorderStyle.THIN);
        bodyStyle2.setBorderLeft(BorderStyle.THIN);
        bodyStyle2.setBorderRight(BorderStyle.THIN);
        
        sheet2.setColumnWidth(0, 1000); // 0부터 시작
        sheet2.setColumnWidth(1, 10000); // 0부터 시작
        sheet2.setColumnWidth(2, 10000); // 0부터 시작
        
        row2 = sheet2.createRow(1);
        cell2 = row2.createCell(1);
        cell2.setCellValue("설문결과");
        
        String AnonyYN2 = "";
        if(surveyCodeDomain.getSrvAnonymous().equals("Y")) {
            AnonyYN2 = "무기명 설문조사";
        } else {
            AnonyYN2 = "기명 설문조사";
        }
        
        String[] mainTitleArr2 = {"설문제목",  "설문기간", "설문유형", "설문문항수", "참여수"};
        String[] mainValueArr2 = {
            surveyCodeDomain.getSrvTitle(),  
            surveyCodeDomain.getSrvStart() + " ~ " + surveyCodeDomain.getSrvEnd(),
            AnonyYN,
            questionList.size() + "",
            totalCount + ""
            };
        
        for(int i = 0; i < mainTitleArr.length; i++) {
            sheet2.addMergedRegion(new CellRangeAddress(rowNo2, rowNo2, 2, 4));
            row2 = sheet2.createRow(rowNo2++);
            cell2 = row2.createCell(1);
            cell2.setCellStyle(titleStyle);
            cell2.setCellValue(mainTitleArr[i]);
            cell2 = row2.createCell(2);
            cell2.setCellStyle(bodyStyle);
            cell2.setCellValue(mainValueArr[i]);
            for(int j = 3; j < 5; j++) {
                cell2 = row2.createCell(j);
                cell2.setCellStyle(bodyStyle);
                cell2.setCellValue("");
            }
        }
        
        row2 = sheet2.createRow(rowNo2++);
        
        sheet2.addMergedRegion(new CellRangeAddress(rowNo2, rowNo2, 1, 2));
        row2 = sheet2.createRow(rowNo2++);
        
        cell2 = row2.createCell(1);
        cell2.setCellStyle(headStyle);
        cell2.setCellValue("문항");
        
        cell2 = row2.createCell(2);
        cell2.setCellStyle(headStyle);
        cell2.setCellValue("");
        
        //설문에  참여한 사번리스트 구하기 - start
        QuestionDomain srvDomain = new QuestionDomain();
        srvDomain.setSrvCode(srvCode);
        List<QuestionDomain> empList = surveyService.searchByResponseEmpList(srvDomain);
        //설문에  참여한 사번리스트 구하기 - end
        
        if(!empList.isEmpty()){
        	for(int i = 0; i < empList.size(); i++) {
        		//System.out.println("사번 :" + empList.get(i).getEmpNumber());
        		sheet2.setColumnWidth(i + 3, 3000); // 0부터 시작
        		
        		cell2 = row2.createCell(i + 3);
                cell2.setCellStyle(headStyle);
                cell2.setCellValue(empList.get(i).getEmpNumber());
        	}
        }
        
        //결과리스트 - start
        List<QuestionDomain> responseList = surveyService.searchByResponseList(srvDomain);
        //결과리스트 - end
        
        int responseListCnt = 0;
        if(questionList != null && questionList.size() > 0){
            
            for(int i = 0; i < questionList.size(); i++){
                
            	sheet2.addMergedRegion(new CellRangeAddress(rowNo2, rowNo2, 1, 2));
                row2 = sheet2.createRow(rowNo2++);
                //질문 문항 - start
                cell2 = row2.createCell(1);
                cell2.setCellStyle(bodyStyle2);
                cell2.setCellValue((i + 1) + questionList.get(i).getQstTitle());
                //질문 문항 - end
                
                //빈칸삽입 - start
                cell2 = row2.createCell(2);
                cell2.setCellStyle(bodyStyle2); 
                cell2.setCellValue("");
                //빈칸삽입 - end
                
                //답변 - start
                if(!empList.isEmpty()){
                	for(int j = 0; j < empList.size(); j++) {
                		//System.out.println("사번 :" + empList.get(j).getEmpNumber());
                		cell2 = row2.createCell(j + 3);
                        cell2.setCellStyle(bodyStyle2);
                        
                        //설문 참여자가 없거나 응답이 없을 때
                        if(responseList.isEmpty() || responseListCnt == responseList.size()) {
                        	cell2.setCellValue("");
                        }
                        //설문 문항.참여자에 따른 답변 
                        else if(responseList.get(responseListCnt).getQstCode().equals(questionList.get(i).getQstCode()) //문항이 같고
                        		&& responseList.get(responseListCnt).getEmpNumber().equals(empList.get(j).getEmpNumber())) {//사원번호가 같으면
                        	
                        	if(questionList.get(i).getQstType().equals("text")){ //질문타입:주관식
                            	cell2.setCellValue(responseList.get(responseListCnt).getDrAnswer());
                            } else if (!questionList.get(i).getQstType().equals("text")){ //질문타입:객관식
                            	cell2.setCellValue(responseList.get(responseListCnt).getAswCode());
                            }
                        	responseListCnt++;
                        } else {
                        	cell2.setCellValue("");
                        }
                        
                	}
                }
                //답변 - start
                
            }
        }
        
        
        response.reset();
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + filename + "_excel.xls");
        
        wb.write(response.getOutputStream());
        wb.close();
        
    }
   
}
