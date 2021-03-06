ALTER TABLE DENSO.LOCATION_INFO
 DROP PRIMARY KEY CASCADE;

DROP TABLE DENSO.LOCATION_INFO CASCADE CONSTRAINTS;

CREATE TABLE DENSO.LOCATION_INFO
(
  LOCATION_NO       VARCHAR2(20 BYTE)           NOT NULL,
  LANGUAGE          VARCHAR2(2 BYTE)            NOT NULL,
  LOCATION_NAME     VARCHAR2(50 BYTE)           NOT NULL,
  ADDRESS           VARCHAR2(150 CHAR),
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

COMMENT ON TABLE DENSO.LOCATION_INFO IS 'Location information';

COMMENT ON COLUMN DENSO.LOCATION_INFO.LOCATION_NO IS 'Location number';

COMMENT ON COLUMN DENSO.LOCATION_INFO.LANGUAGE IS 'Language';

COMMENT ON COLUMN DENSO.LOCATION_INFO.LOCATION_NAME IS 'Location name';

COMMENT ON COLUMN DENSO.LOCATION_INFO.ADDRESS IS 'Address';

COMMENT ON COLUMN DENSO.LOCATION_INFO.CREATE_USER IS 'First created by';

COMMENT ON COLUMN DENSO.LOCATION_INFO.CREATE_DATE IS 'First created date';

COMMENT ON COLUMN DENSO.LOCATION_INFO.LAST_UPDATE_USER IS 'Last updated by';

COMMENT ON COLUMN DENSO.LOCATION_INFO.LAST_UPDATE_DATE IS 'Last updated date';


CREATE UNIQUE INDEX DENSO.LOCATION_INFO_PK ON DENSO.LOCATION_INFO
(LOCATION_NO, LANGUAGE)
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

ALTER TABLE DENSO.LOCATION_INFO ADD (
  CONSTRAINT LOCATION_INFO_PK
  PRIMARY KEY
  (LOCATION_NO, LANGUAGE)
  USING INDEX DENSO.LOCATION_INFO_PK
  ENABLE VALIDATE);