ALTER TABLE DENSO.DNKR_SURVEY_CODE
 DROP PRIMARY KEY CASCADE;

DROP TABLE DENSO.DNKR_SURVEY_CODE CASCADE CONSTRAINTS;

CREATE TABLE DENSO.DNKR_SURVEY_CODE
(
  SRV_CODE       VARCHAR2(45 BYTE)              NOT NULL,
  SRV_START      DATE,
  SRV_END        DATE,
  SRV_USE        CHAR(1 BYTE)                   DEFAULT 'N',
  SRV_ANONYMOUS  CHAR(1 BYTE)                   DEFAULT 'Y'
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

COMMENT ON COLUMN DENSO.DNKR_SURVEY_CODE.SRV_CODE IS '설문지코드';

COMMENT ON COLUMN DENSO.DNKR_SURVEY_CODE.SRV_START IS '설문시작일자';

COMMENT ON COLUMN DENSO.DNKR_SURVEY_CODE.SRV_END IS '설문종료일자';

COMMENT ON COLUMN DENSO.DNKR_SURVEY_CODE.SRV_USE IS '설문활성여부';

COMMENT ON COLUMN DENSO.DNKR_SURVEY_CODE.SRV_ANONYMOUS IS '익명여부';


CREATE UNIQUE INDEX DENSO.DRM_SURVEY_CODE_PK ON DENSO.DNKR_SURVEY_CODE
(SRV_CODE)
LOGGING
TABLESPACE DRM
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           );

ALTER TABLE DENSO.DNKR_SURVEY_CODE ADD (
  CONSTRAINT DNKR_SURVEY_CODE_PK
  PRIMARY KEY
  (SRV_CODE)
  USING INDEX DENSO.DRM_SURVEY_CODE_PK
  ENABLE VALIDATE);