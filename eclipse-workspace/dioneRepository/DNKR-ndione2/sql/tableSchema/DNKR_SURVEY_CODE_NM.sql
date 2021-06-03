DROP TABLE DENSO.DNKR_SURVEY_CODE_NM CASCADE CONSTRAINTS;

CREATE TABLE DENSO.DNKR_SURVEY_CODE_NM
(
  SRV_CODE   VARCHAR2(45 BYTE),
  CMC_CODE   VARCHAR2(45 BYTE),
  SRV_TITLE  VARCHAR2(200 BYTE)
)
TABLESPACE DRM
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
MONITORING;

COMMENT ON COLUMN DENSO.DNKR_SURVEY_CODE_NM.SRV_CODE IS '설문지코드';

COMMENT ON COLUMN DENSO.DNKR_SURVEY_CODE_NM.CMC_CODE IS '언어코드';

COMMENT ON COLUMN DENSO.DNKR_SURVEY_CODE_NM.SRV_TITLE IS '설문지명';


ALTER TABLE DENSO.DNKR_SURVEY_CODE_NM ADD (
  CONSTRAINT DNKR_SURVEY_CODE_NM_FK1 
  FOREIGN KEY (SRV_CODE) 
  REFERENCES DENSO.DNKR_SURVEY_CODE (SRV_CODE)
  ENABLE VALIDATE,
  CONSTRAINT DNKR_SURVEY_CODE_NM_FK2 
  FOREIGN KEY (CMC_CODE) 
  REFERENCES DENSO.DNKR_COMMON_CODE (CMC_CODE)
  ENABLE VALIDATE);