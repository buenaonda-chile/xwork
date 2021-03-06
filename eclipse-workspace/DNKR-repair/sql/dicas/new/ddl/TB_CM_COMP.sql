CREATE TABLE TB_CM_COMP (
  COMP_ID     NUMBER(20) NOT NULL,
  RGSTR_ID    NUMBER(20) NOT NULL,
  RGST_DT     TIMESTAMP,
  UPDTR_ID    NUMBER(20) NOT NULL,
  UPDT_DT     TIMESTAMP,
  COMP_KO_NM  VARCHAR(255) NOT NULL,
  COMP_EN_NM  VARCHAR(255) NOT NULL,
  COMP_JA_NM  VARCHAR(255) NOT NULL,
  TEL_NO      VARCHAR(20) NOT NULL,
  FAX_NO      VARCHAR(20) NOT NULL,
  ZIP        VARCHAR(10),
  ADRES      VARCHAR(255),
  ROAD_ADRES VARCHAR(255),
  DTL_ADRES  VARCHAR(255),
  CONSTRAINT PK_CM_COMP
  UNIQUE (COMP_ID)
)
/
COMMENT ON TABLE TB_CM_COMP IS '회사'
/
COMMENT ON COLUMN TB_CM_COMP.COMP_ID IS '회사ID'
/
COMMENT ON COLUMN TB_CM_COMP.RGSTR_ID IS '등록자ID'
/
COMMENT ON COLUMN TB_CM_COMP.RGST_DT IS '등록일시'
/
COMMENT ON COLUMN TB_CM_COMP.UPDTR_ID IS '수정일자ID'
/
COMMENT ON COLUMN TB_CM_COMP.UPDT_DT IS '수정일시'
/
COMMENT ON COLUMN TB_CM_COMP.COMP_KO_NM IS '회사한글명'
/
COMMENT ON COLUMN TB_CM_COMP.COMP_EN_NM IS '회사영문명'
/
COMMENT ON COLUMN TB_CM_COMP.COMP_JA_NM IS '회사일문명'
/
COMMENT ON COLUMN TB_CM_COMP.TEL_NO IS '전화번호'
/
COMMENT ON COLUMN TB_CM_COMP.FAX_NO IS '팩스번호'
/
COMMENT ON COLUMN TB_CM_COMP.ZIP IS '우편번호'
/
COMMENT ON COLUMN TB_CM_COMP.ADRES IS '주소'
/
COMMENT ON COLUMN TB_CM_COMP.ROAD_ADRES IS '도로명주소'
/
COMMENT ON COLUMN TB_CM_COMP.DTL_ADRES IS '상세주소'
/