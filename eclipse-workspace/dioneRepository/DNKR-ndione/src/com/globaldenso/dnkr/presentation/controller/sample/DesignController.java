package com.globaldenso.dnkr.presentation.controller.sample;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
 
import com.globaldenso.dnkr.uxis.UxisExcelFileUtil;
import com.globaldenso.dnkr.uxis.UxisFileMngUtil;
import com.globaldenso.dnkr.uxis.UxisStringUtil;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/design") 
public class DesignController {

    /** Constructor. */
    public DesignController(){

    }

    /**
     * 
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/design1", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView design1(HttpServletRequest request, HttpServletResponse response) 
        throws Exception{

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        ModelAndView mv = new ModelAndView();

        mv.setViewName(".tiles.page.design1");
        
        mv.addObject("tabId", tabId);
        return mv;
    }

    /**
     * 
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/design2", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView design2(HttpServletRequest request, HttpServletResponse response) 
        throws Exception{
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        ModelAndView mv = new ModelAndView();

        mv.setViewName(".tiles.page.design2");

        mv.addObject("tabId", tabId);
        return mv;
    }
    /**
     * 
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/design3", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView design3(HttpServletRequest request, HttpServletResponse response)
        throws Exception{


        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        ModelAndView mv = new ModelAndView();

        mv.setViewName(".tiles.page.design3");

        mv.addObject("tabId", tabId);
        return mv;
    }
    
    /**
     * 
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/design4", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView design4(HttpServletRequest request, HttpServletResponse response)
        throws Exception{


        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        ModelAndView mv = new ModelAndView();

        mv.setViewName(".tiles.page.design4");

        mv.addObject("tabId", tabId);
        return mv;
    }
    
    /**
     * 
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/design5", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView design5(HttpServletRequest request, HttpServletResponse response)
        throws Exception{


        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        ModelAndView mv = new ModelAndView();

        mv.setViewName(".tiles.page.design5");

        mv.addObject("tabId", tabId);
        return mv;
    }

    /**
     * 
     * 
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/excelUpload", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView excelUploadForm(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");

        ModelAndView mv = new ModelAndView();

        mv.setViewName(".tiles.page.excelUpload");

        mv.addObject("tabId", tabId);
        return mv;
    }

    /**
     * 
     * 
     * @param request       HttpServletRequest
     * @param response      HttpServletResponse
     * @param multiRequest  MultipartHttpServletRequest
     * @return ModelAndView
     * @throws Exception 
     */
    @RequestMapping(value = "/procExcelUpload", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView procExcelUpload(HttpServletRequest request, 
        HttpServletResponse response, 
        MultipartHttpServletRequest multiRequest) throws Exception{

        System.out.println("-------------------------------------------------");

        String fileName = "";   //파일명을 담을 변수 선언
        UxisExcelFileUtil efUtil = new UxisExcelFileUtil();

        /** 파일 업로드 처리 **/
        //파일 업로드 처리를 하고 그 결과 내용을 받는다.
        String uploadResult = efUtil.uploadFileData(multiRequest.getFileMap(), "xls,xlsx", new UxisFileMngUtil());

        try{
            //파일업로드 결과 내용이 없을 경우 메소드내에서 오류가 발생한 것이기때문에 업로드 실패로 강주하고 첨부파일 업로드 실패 처리를 한다.
            if(UxisStringUtil.isEmpty(uploadResult)){ 
                //return UxisCmmUtil.jsonMessage("첨부파일 업로드에 실패했습니다.", "N");
            }else{  //파일 업로드 결과 내용이 있을 경우 내용에 따라 처리한다.
                String[] splitStr = uploadResult.split("§");                        //결과 내용이 § 구분자로 하여 성공여부, 메세지로 나눠진다. 
                if(splitStr.length <= 0){
                    //return UxisCmmUtil.jsonMessage("첨부파일 업로드에 실패했습니다.", "N");     //§ 구분자로 나눠지지 않을 경우 메소드 내에서 오류가 발생한 것이기 때문에 업로드 실패로 강주하고 첨부파일 업로드 실패 처리한다.
                }else{
                    String type = splitStr[0];                                      //성공여부
                    if("Y".equals(type)){
                        fileName = splitStr[1];                                     //성공일 경우 파일명을 변수에 담는다.
                    }else{
                        //return UxisCmmUtil.jsonMessage(splitStr[1],"N");          //실패일 경우 처리실패로 메세지를 담아서 json형태의 값을 리턴한다.
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        /** 액셀 내용 읽기 및 데이터 등록 **/
        //파일명 값이 있을 경우 업로드 된 액셀내용을 읽어서 데이터 등록/수정 처리를 한다.
        if(!UxisStringUtil.isEmpty(fileName)){
            System.out.println("=================Excel Data===============");
            System.out.println(fileName);
            //fileName의 엑셀 파일을 읽어서 변수에 데이터를 담는다.
            List<Map<String, String>> excelData = efUtil.getExcelData(fileName, "");
            System.out.println("=================Excel Data===============");
            System.out.println(excelData);
            System.out.println("=================Excel Data===============");
            //엑셀에서 읽은 데이터를 가지고  등록 또는 수정 처리를 한다.해당 처리 결과를 Json형태로 리턴 처리 한다.
            //return excelDataProcess(excelData);
            //return "";
        }else{
            //return UxisCmmUtil.jsonMessage("첨부파일 읽어오기에 실패하였습니다.","N");
        } 

        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        ModelAndView mv = new ModelAndView();
        mv.setViewName(".tiles.page.excelUpload");
        mv.addObject("tabId", tabId);
        return mv;
    }

    /*private String excelDataProcess(List<Map<String, String>> excelData){

            //엑셀데이터가 없을 경우 오류 처리 
            if(excelData == null || excelData.size() <= 0){
                return UxisCmmUtil.jsonMessage("읽은 데이터가 없습니다.", "N");
            }

            int addSucessCnt    = 0;                                            //등록 성공 개수 관리 변수
            int modiSucessCnt   = 0;                                         //수정 성공 개수 관리 변수


            List<VO> insertDataLst = null;  //등록 처리 데이터 모음 변수 선언
            List<VO> updateDataLst = null;  //수정 처리 데이터 모음 변수 선언

            //아이디 값 존재 유무로  등록, 수정 처리를 분류한다.
            VO vo = null;

            LinkedHashMap<String, String> gradeCode = cmmDao.selectCommCodeList("gradeCode_type");

            for(Map<String, String> tempMap : excelData){
                vo = new VO();
                if(!checkProcess(tempMap, vo, gradeCode)){
                    updateDataLst = addMap(updateDataLst, vo);
                }else{
                    insertDataLst = addMap(insertDataLst, vo);
                }
            }

            StringBuffer messageBf = new StringBuffer();            //메세지를 담을 변수 선언

            if(insertDataLst != null) addSucessCnt = excelDataInsert(insertDataLst, messageBf);                     //등록처리
            if(updateDataLst != null) modiSucessCnt = excelDataUpdate(updateDataLst, messageBf);                    //수정처리
            String message = "";
            if(messageBf != null){
                message = messageBf.toString();
            }

            //json 형태로 결과 메세지 처리 
            return UxisCmmUtil.jsonMessage(excelData.size() + "건 데이터 중 " + addSucessCnt + "건의 등록과 " + modiSucessCnt + "건의 수정이 처리 되었습니다. \n" + message, "Y");
        }

        protected List<VO> addMap(List<VO> lst, VO vo){
            if(lst == null)lst = new ArrayList<VO>();
            lst.add(vo);

            return lst;
        }

        private boolean checkProcess(Map<String, String> map, VO vo, LinkedHashMap<String, String> gradeCode){

             *//**      엑셀데이터를 VO에 담는다.         **//*
            vo.setSubjIdx(setSubjectIdx(UxisStringUtil.isNullToString(map.get("G"))));       //과목분류고유키
            vo.setSubjoName(         UxisStringUtil.isNullToString(map.get("H")));           //과목명
            vo.setDiv(               UxisStringUtil.isNullToString(map.get("I")));           //구분
            vo.setGradeName(         UxisStringUtil.isNullToString(map.get("J")));           //학년명
            vo.setGradeIdx(getLinkedHashMapKey(gradeCode, 
                                     UxisStringUtil.isNullToString(vo.getGradeName())));    //학년고유키
            vo.setGradePoint(        UxisStringUtil.isNullToInt(map.get("K")));             //학점
            vo.setGradePointReco(    UxisStringUtil.isNullToString(map.get("L")));          //학점인정
            vo.setSubjIntroduce(     UxisStringUtil.isNullToString(map.get("M")));          //과목소개
            vo.setWeek(              UxisStringUtil.isNullToString(map.get("O")));          //요일
            vo.setWeekCount(         UxisStringUtil.isNullToInt(map.get("Q")));             //주수
            vo.setSubjTime(          UxisStringUtil.isNullToInt(map.get("R")));             //시간
            vo.setCompletionTime(    UxisStringUtil.isNullToInt(map.get("S")));             //이수시간
            vo.setClassRoom(         UxisStringUtil.isNullToString(map.get("T")));          //강의실
            vo.setTuition(           UxisStringUtil.isNullToInt(map.get("U")));             //수강료
            vo.setPersonnel(         UxisStringUtil.isNullToInt(map.get("V")));             //정원
            vo.setSubjState(         UxisStringUtil.isNullToString("W"));                   //상태

            setTurnData(vo, map);                                                           //년도, 학기, 회차, 회차 교유키 값을 넣는다.
            setData(vo, map);                                                               //강의기간, 강의시간 시간, 종료 데이터 값을 넣는다.

            *//**           년도, 학기, 회차 과목분류, 과목명이 동일한 데이터가 있을 경우 해당 고유키를 가져온다.          **//*
            try{
                vo.setSubjOpenIdx(osDao.selectExcelDataCheck(vo));
            }catch(Exception e){e.printStackTrace();}

            //고유키 존재 여부를 리턴한다. (있으면 false, 없으면 true)
            return UxisStringUtil.isEmpty(vo.getSubjOpenIdx());
        }*/
}
