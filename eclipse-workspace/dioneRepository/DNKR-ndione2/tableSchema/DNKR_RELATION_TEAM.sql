ALTER TABLE DENSO.DNKR_RELATION_TEAM
 DROP PRIMARY KEY CASCADE;

DROP TABLE DENSO.DNKR_RELATION_TEAM CASCADE CONSTRAINTS;

CREATE TABLE DENSO.DNKR_RELATION_TEAM
(
  TEAM_CODE  VARCHAR2(45 BYTE)                  NOT NULL,
  LOC_CODE   VARCHAR2(45 BYTE),
  TEAM_USE   CHAR(1 BYTE)                       DEFAULT 'Y'                   NOT NULL
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

COMMENT ON COLUMN DENSO.DNKR_RELATION_TEAM.TEAM_CODE IS '부서(팀)코드';

COMMENT ON COLUMN DENSO.DNKR_RELATION_TEAM.LOC_CODE IS '상위사업장코드';

COMMENT ON COLUMN DENSO.DNKR_RELATION_TEAM.TEAM_USE IS '사용여부';


CREATE UNIQUE INDEX DENSO.DRM_RELATION_TEAM_PK ON DENSO.DNKR_RELATION_TEAM
(TEAM_CODE)
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

ALTER TABLE DENSO.DNKR_RELATION_TEAM ADD (
  CONSTRAINT DNKR_RELATION_TEAM_PK
  PRIMARY KEY
  (TEAM_CODE)
  USING INDEX DENSO.DRM_RELATION_TEAM_PK
  ENABLE VALIDATE);

ALTER TABLE DENSO.DNKR_RELATION_TEAM ADD (
  CONSTRAINT DNKR_RELATION_TEAM_FK1 
  FOREIGN KEY (LOC_CODE) 
  REFERENCES DENSO.DNKR_RELATION_LOCATION (LOC_CODE)
  ENABLE VALIDATE);