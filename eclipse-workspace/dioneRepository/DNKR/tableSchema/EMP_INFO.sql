ALTER TABLE DENSO.EMP_INFO
 DROP PRIMARY KEY CASCADE;

DROP TABLE DENSO.EMP_INFO CASCADE CONSTRAINTS;

CREATE TABLE DENSO.EMP_INFO
(
  EMP_NO            VARCHAR2(20 BYTE)           NOT NULL,
  LANGUAGE          VARCHAR2(2 BYTE)            NOT NULL,
  LAST_NAME         VARCHAR2(30 BYTE)           NOT NULL,
  FIRST_NAME        VARCHAR2(30 BYTE)           NOT NULL,
  DEPT_NO           VARCHAR2(2 BYTE)            NOT NULL,
  LOCATION_NO       VARCHAR2(20 BYTE)           NOT NULL,
  POSITION          VARCHAR2(30 BYTE),
  TEL               VARCHAR2(20 BYTE),
  E_MAIL            VARCHAR2(50 BYTE),
  JOB               VARCHAR2(150 BYTE),
  MGR_EMP_NO        VARCHAR2(20 BYTE),
  HIRE_DATE         DATE,
  SALARY            NUMBER(9),
  SUPPLEMENTATION   VARCHAR2(150 CHAR),
  CREATE_USER       VARCHAR2(20 BYTE)           NOT NULL,
  CREATE_DATE       TIMESTAMP(3)                NOT NULL,
  LAST_UPDATE_USER  VARCHAR2(20 BYTE)           NOT NULL,
  LAST_UPDATE_DATE  TIMESTAMP(3)                NOT NULL
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

COMMENT ON TABLE DENSO.EMP_INFO IS 'Employee information';

COMMENT ON COLUMN DENSO.EMP_INFO.EMP_NO IS 'Employee number';

COMMENT ON COLUMN DENSO.EMP_INFO.LANGUAGE IS 'Language';

COMMENT ON COLUMN DENSO.EMP_INFO.LAST_NAME IS 'Last name';

COMMENT ON COLUMN DENSO.EMP_INFO.FIRST_NAME IS 'First name';

COMMENT ON COLUMN DENSO.EMP_INFO.DEPT_NO IS 'Department number';

COMMENT ON COLUMN DENSO.EMP_INFO.LOCATION_NO IS 'Location number';

COMMENT ON COLUMN DENSO.EMP_INFO.POSITION IS 'Position';

COMMENT ON COLUMN DENSO.EMP_INFO.TEL IS 'Telephone number';

COMMENT ON COLUMN DENSO.EMP_INFO.E_MAIL IS 'E-mail address';

COMMENT ON COLUMN DENSO.EMP_INFO.JOB IS 'Work';

COMMENT ON COLUMN DENSO.EMP_INFO.MGR_EMP_NO IS 'Employee number of manager';

COMMENT ON COLUMN DENSO.EMP_INFO.HIRE_DATE IS 'Hire date';

COMMENT ON COLUMN DENSO.EMP_INFO.SALARY IS 'Salary';

COMMENT ON COLUMN DENSO.EMP_INFO.SUPPLEMENTATION IS 'Supplementation';

COMMENT ON COLUMN DENSO.EMP_INFO.CREATE_USER IS 'First created by';

COMMENT ON COLUMN DENSO.EMP_INFO.CREATE_DATE IS 'First created date';

COMMENT ON COLUMN DENSO.EMP_INFO.LAST_UPDATE_USER IS 'Last updated by';

COMMENT ON COLUMN DENSO.EMP_INFO.LAST_UPDATE_DATE IS 'Last updated date';


CREATE UNIQUE INDEX DENSO.EMP_INFO_PK ON DENSO.EMP_INFO
(EMP_NO, LANGUAGE)
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

ALTER TABLE DENSO.EMP_INFO ADD (
  CONSTRAINT EMP_INFO_PK
  PRIMARY KEY
  (EMP_NO, LANGUAGE)
  USING INDEX DENSO.EMP_INFO_PK
  ENABLE VALIDATE);