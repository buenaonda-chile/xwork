package com.globaldenso.dicas.constant;

public class DicasConstant {

  public static class ParamAttribute {
    public static final String CRITERIA = "criteria";
    public static final String PAGEABLE = "pageable";
  }

  public static class MenuAttribute {
    public static final String MENU_ID = "__dicas_menu_id__";
  }

  public static class CodeGroupAttribute {
    public static final String USE_YN = "C020";
    public static final String MAKER = "CAMAK";
    public static final String OFFICE_DIV = "COGROUPDIV";
    public static final String OFFICE_CITY = "CLRSN";
    public static final String MATERIAL_DIV = "CASEPMATR";
    public static final String OFFICE_PERSON_NM = "C020";

    public static final String GROUP_ID = "COGROUPID";
    public static final String PART_DIV = "CAQPD";
    public static final String TEL_AREA = "COAREACODE";

    public static final String EXHAUS_REG = "C006";
    public static final String INCIDENT_COST_DIV = "CLPART";

    public static final String TIRE_STD = "CAUTY";
    public static final String ENGINE_TYPE = "C021";
    public static final String MODEL =  "CAMDL";
    public static final String SERVICE_TYPE =  "CLINV";

    public static final String SALE_COUNTRY =  "CASCO";
    public static final String SERVICE_CONDITION =  "C010";
    public static final String AUDIT_INFO =  "CLINS";

    public static final String PUB_YN = "PUBYN";
    public static final String DIV = "CLINV"; //클레임 콜대상.미상담

    public static final String RESEARCH_TYPE = "CLIND"; //클레임조사 조사유형
    public static final String APPROVAL = "CLWTY"; //클레임결과 결과구분
    public static final String MATDIV = "C008"; //클레임결과 자재선택
    public static final String WORK_RESULT= "C017"; //클레임결과 TF,NTF
    public static final String RECALL_TYPE =  "C022";
    public static final String CATEGORY =  "COCATEGORY";
    
    public static final String EDUCATION =  "EDUCATION";
    public static final String ONOFFYN =  "ONOFFYN";
    public static final String RANCD =  "C001";	// 직위
    
    public static final String RECEIPT_STATUS = "RECEIPT_STATUS"; //접수상태
    public static final String ORDER_STATUS = "ORDER_STATUS"; //발주상태
    public static final String REPAIR_STATUS = "REPAIR_STATUS"; //수리상태
    public static final String NG_TYPE = "NG_TYPE"; //불량타입
  }
}
