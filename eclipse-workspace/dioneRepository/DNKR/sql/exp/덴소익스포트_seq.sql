--------------------------------------------------------
--  파일이 생성됨 - 수요일-2월-28-2018   
--------------------------------------------------------
DROP SEQUENCE "DNKR_AUTH_CODE_SEQ";
DROP SEQUENCE "DNKR_BOARD_FILE_SEQ";
DROP SEQUENCE "DNKR_BOARD_INFO_SEQ";
DROP SEQUENCE "DNKR_BOARD_TEXT_SEQ";
DROP SEQUENCE "DNKR_MENU_CODE_SEQ";
DROP SEQUENCE "DNKR_RELATION_CLASS_SEQ";
DROP SEQUENCE "DNKR_RELATION_LOCATION_SEQ";
DROP SEQUENCE "DNKR_RELATION_TEAM_SEQ";
DROP SEQUENCE "DNRK_LOG_TBL_SEQ";
--------------------------------------------------------
--  DDL for Sequence DNKR_AUTH_CODE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DNKR_AUTH_CODE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 341 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DNKR_BOARD_FILE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DNKR_BOARD_FILE_SEQ"  MINVALUE 1 MAXVALUE 99999999999999999999 INCREMENT BY 1 START WITH 81 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DNKR_BOARD_INFO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DNKR_BOARD_INFO_SEQ"  MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 START WITH 43 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DNKR_BOARD_TEXT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DNKR_BOARD_TEXT_SEQ"  MINVALUE 1 MAXVALUE 9999999 INCREMENT BY 1 START WITH 157 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DNKR_MENU_CODE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DNKR_MENU_CODE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 501 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DNKR_RELATION_CLASS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DNKR_RELATION_CLASS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 241 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DNKR_RELATION_LOCATION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DNKR_RELATION_LOCATION_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 161 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DNKR_RELATION_TEAM_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DNKR_RELATION_TEAM_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1141 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence DNRK_LOG_TBL_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "DNRK_LOG_TBL_SEQ"  MINVALUE 0 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 111 NOCACHE  NOORDER  NOCYCLE ;
