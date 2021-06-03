--  Generate SQL 
--  Version:                   	V5R4M0 060210 
--  Generated on:              	18/03/22 19:48:08 
--  Relational Database:       	S6541EE0 
--  Standards Option:          	DB2 UDB iSeries 
CREATE TABLE PSEDBLIB.TME010PF ( 
--  SQL150B   10   REUSEDLT(*NO) in table TME010PF in PSEDBLIB ignored. 
	COMPS CHAR(2) CCSID 833 NOT NULL DEFAULT '' , 
	"GROUP" CHAR(1) CCSID 833 NOT NULL DEFAULT '' , 
	MNGNO CHAR(10) CCSID 833 NOT NULL DEFAULT '' , 
	MNAME CHAR(100) CCSID 933 NOT NULL DEFAULT '' , 
	MAKER CHAR(100) CCSID 933 NOT NULL DEFAULT '' , 
	MTYPE CHAR(100) CCSID 933 NOT NULL DEFAULT '' , 
	JNBNO CHAR(30) CCSID 933 NOT NULL DEFAULT ' ' , 
	IPDAT NUMERIC(8, 0) NOT NULL DEFAULT 0 , 
	DPTCD CHAR(6) CCSID 833 NOT NULL DEFAULT '' , 
	GUBUN CHAR(12) CCSID 933 NOT NULL DEFAULT '' , 
	DISYN CHAR(1) CCSID 833 NOT NULL DEFAULT '' , 
	DIDAT NUMERIC(8, 0) NOT NULL DEFAULT 0 , 
	DRESN CHAR(2) CCSID 833 NOT NULL DEFAULT '' , 
	J_GUB CHAR(2) CCSID 833 NOT NULL DEFAULT '' , 
	JKIND CHAR(2) CCSID 833 NOT NULL DEFAULT '' , 
	G_GUB CHAR(1) CCSID 833 NOT NULL DEFAULT '' , 
	GCYCL NUMERIC(2, 0) NOT NULL DEFAULT 0 , 
	GNAMT NUMERIC(12, 0) NOT NULL DEFAULT 0 , 
	JSPEC CHAR(40) CCSID 933 NOT NULL DEFAULT '' , 
	ACCNO CHAR(30) CCSID 933 NOT NULL DEFAULT '' , 
	CNOTE CHAR(200) CCSID 933 NOT NULL DEFAULT '' , 
	ADDAT CHAR(10) CCSID 833 NOT NULL DEFAULT '' , 
	ADTIM CHAR(8) CCSID 833 NOT NULL DEFAULT '' , 
	ADUSR NUMERIC(7, 0) NOT NULL DEFAULT 0 , 
	CHDAT CHAR(10) CCSID 833 NOT NULL DEFAULT '' , 
	CHTIM CHAR(8) CCSID 833 NOT NULL DEFAULT '' , 
	CHUSR NUMERIC(7, 0) NOT NULL DEFAULT 0 , 
	PRIMARY KEY( COMPS , "GROUP" , MNGNO ) )   
	  
	RCDFMT TME010R1   ; 
  
LABEL ON TABLE PSEDBLIB.TME010PF 
	IS '계측기관리－장비관리마스타' ; 
  
LABEL ON COLUMN PSEDBLIB.TME010PF 
( COMPS IS '�　�　부'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	"GROUP" IS '교정분야'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	MNGNO IS '관리번호'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	MNAME IS '장비명'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	MAKER IS '제조회사'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	MTYPE IS '형식'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	JNBNO IS '장비번호'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	IPDAT IS '입고일자'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	DPTCD IS '사용부서'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	GUBUN IS '교정번호'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	DISYN IS '폐기여부'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	DIDAT IS '폐기일자'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	DRESN IS '폐기사유'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	J_GUB IS '장비구분'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	JKIND IS '장비유형'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	G_GUB IS '교정구분'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	GCYCL IS '교정주기'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	GNAMT IS '취득금액'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	JSPEC IS '기기사양'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	ACCNO IS '자산번호'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	CNOTE IS '비　　　고'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	ADDAT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	ADTIM IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	ADUSR IS '�　�　�'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	CHDAT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	CHTIM IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	CHUSR IS '�　�　�'   
--  SQL0330   10   Character conversion cannot be performed. 
	) ; 
  
LABEL ON COLUMN PSEDBLIB.TME010PF 
( COMPS TEXT IS '�　�　부'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	"GROUP" TEXT IS '�비　분�'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	MNGNO TEXT IS '관�　번호'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	MNAME TEXT IS '�　비　�'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	MAKER TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	MTYPE TEXT IS '�　　　�'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	JNBNO TEXT IS '�비　번호'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	IPDAT TEXT IS '�고　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	DPTCD TEXT IS '��　부�'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	GUBUN TEXT IS '관�　�분'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	DISYN TEXT IS '��　�부'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	DIDAT TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	DRESN TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	J_GUB TEXT IS '�비　�분'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	JKIND TEXT IS '�비　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	G_GUB TEXT IS '��　�분'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	GCYCL TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	GNAMT TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	JSPEC TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	ACCNO TEXT IS '��　번호'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	CNOTE TEXT IS '비　　　고'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	ADDAT TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	ADTIM TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	ADUSR TEXT IS '�　�　�'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	CHDAT TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	CHTIM TEXT IS '��　��'   
--  SQL0330   10   Character conversion cannot be performed. 
	, 
	CHUSR TEXT IS '�　�　�'   
--  SQL0330   10   Character conversion cannot be performed. 
	) ;
