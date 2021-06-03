package com.globaldenso.dnkr.uxis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * POI 방식을 이용한 엑셀 파일 읽기 방식
 * @author GBS
 * @version 1.0
 */
public class CommonExcelRead {
    /** Constructor. */
    public CommonExcelRead() {
    }

    /**
     * 엑셀 파일 내용 읽어오기
     * @param filePath  String Type의 파일 경로
     * @return  List<Map<String, String>>
     */
    public List<Map<String, String>> read(String filePath, String type){

        /**
         * 엑셀 파일 자체
         * 엑셀파일을 읽어 들인다.
         * getWorkbook()함수로 파일의 확장자에 따라서 적절하게 가져온다.
         */
        Workbook wb = getWorkbook(filePath);

        if(wb == null){
        	//System.out.println("return null");
            return null;
        }

        /** 엑셀 파일에서 첫번째 시트를 가지고 온다. */
        Sheet sheet = wb.getSheetAt(0);

        /**   sheet에서 유효한(데이터가 있는) 행의 개수를 가져온다.   */
        int numOfRows = sheet.getPhysicalNumberOfRows();
        int numOfCells = 0;

        //System.out.println("numOfRows : " + numOfRows);
        Row row     = null;
        Cell cell   = null;

        String cellName = "";

        /**
         * 각 row마다의 값을 저장할 맵 객체
         * 저장되는 형식은 다음과 같다.
         * put("A","이름")
         * put("B","성별")
         */
        Map<String, String> map = null;

        /**
         * 각 Row를 리스트에 담는다.
         * 하나의 Row를 하나의 Map으로 표현되며
         * List에는 모든 Row가 포함될 것이다.
         */
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        
        int rowIndexTmp = 1;
        
        if("order".equals(type)){
        	rowIndexTmp = 0;
        }
        /**
         * 각 Row만큼 반복을 한다.
         */
        for(int rowIndex = rowIndexTmp; rowIndex < numOfRows; rowIndex++){
            /**
             * 워크북에서 가져온 시트에 rowIndex에 해당하는 Row를 가져온다.
             * 하나의 Row는 여러개의 Cell을 가진다.
             */
            row = sheet.getRow(rowIndex);

            if(row != null){
                /** 가져온 Row의 Cell의 개수를 구한다. */
                numOfCells = row.getPhysicalNumberOfCells();
                /** 데이터를 담을 맵 객체 초기화    */
                map = new HashMap<String, String>();
                /** cell의 수 만큼 반복한다.    */
                for(int cellIndex = 0; cellIndex < numOfCells; cellIndex++){
                    /** Row에서 CellIndex에 해당하는 Cell을 가져온다.   */
                    cell = row.getCell(cellIndex);
                    /**
                     * 현재 cell의 이름을 가져온다.
                     * 이름의 예 :A,B,C,D
                     */
                    cellName = getName(cell, cellIndex);
                    /**
                     * 추출 대상 컬럼인지 확인한다.
                     * 추출 대상 컬럼이 아니라면
                     * for로 다시 올라간다.
                     */
                    //if( )
                        //continue;
                    /** map객체의 Cell의 이름을 키(key)로 데이터를 담는다.. */
                    map.put(cellName, getValue(cell));
                }
                /** 만들어진 Map객체를 List로 넣는다.  */
                result.add(map);
            }
        }
        return result;
    }

    /**
     * 엑셀파일을 확장자에 따라 가져온다
     * XLS , XLSX
     * @param filePath  String
     * @return  Workbook
     */
    private Workbook getWorkbook(String filePath){

        FileInputStream fis = null;

        try{
            fis = new FileInputStream(filePath);
        }catch(FileNotFoundException e){
            throw new RuntimeException(e.getMessage(), e);
        }

        Workbook wb = null;

        if(filePath.toUpperCase().endsWith(".XLS")){
            try{
                wb = new HSSFWorkbook(fis);
            }catch(IOException e){
                throw new RuntimeException(e.getMessage(), e);
            }
        }else if(filePath.toUpperCase().endsWith(".XLSX")){
            try{
                wb = new XSSFWorkbook(fis);
            }catch(IOException e){
                throw new RuntimeException(e.getMessage(), e);
            }
        }else{
            wb = null;
        }
        return wb;
    }
    
    /**
     * Cell 명칭 가져오기
     * @param cell          Cell
     * @param cellIndex     int
     * @return              String
     */
    private String getName(Cell cell, int cellIndex){
        int cellNum = 0;
        if(cell != null){
            cellNum = cell.getColumnIndex();
        }else{
            cellNum = cellIndex;
        }
        
        return CellReference.convertNumToColString(cellNum);
    }

    /**
     * Cell 값 가져오기 
     * @param cell  Cell
     * @return      String
     */
    @SuppressWarnings("deprecation")
    public String getValue(Cell cell){
        String value = "";
        
        if(cell == null){
            value = "";
        }else{
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_FORMULA:
                    value = cell.getCellFormula();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    value = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue() + "";
                    break;
                case Cell.CELL_TYPE_ERROR:
                    value = cell.getErrorCellValue() + "";
                    break;
                case Cell.CELL_TYPE_BLANK:
                    value = "";
                    break;

                default:
                    value = cell.getStringCellValue();
                    break;
            }
        }

        return value;
    }
}
