package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.RelationDb2Domain;
import com.globaldenso.dnkr.domain.db2.FileDb2Domain;
import com.globaldenso.dnkr.domain.db2.MachineDb2Domain;
import com.globaldenso.dnkr.domain.db2.PsogmDomain;
import com.globaldenso.dnkr.domain.db2.SpareUnitDb2Domain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmDao {

    /**
     * [KO] 사업부 코드와 설비번호로  DB table 에서 설비 정보를 검색하고 결과를 반환한다<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'MachineDb2Domain' class
     * @return 'MachineDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public MachineDb2Domain selectOGM200_chk(MachineDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 사업부 코드와 지시No로  DB table 에서 보전이력을 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PsogmDomain selectOgm313_gms219(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업부 코드와 지시No로  DB table 에서 보전이력을 검색하고 결과를 반환한다(Ubi Report용).<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PsogmDomain selectOgm203_rep(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업부 코드와 지시No로  DB table 에서 교환품 목록을 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> select_obj220pf_InqParts(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드와 지시no로 테이블에서 재발방지정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public PsogmDomain selectOgm203_pepcdChk(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 라인 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> getogm313_cmbprtcd(RelationDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 DB 테이블에서 설비 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'MachineDb2Domain' class
     * @return 'MachineDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<MachineDb2Domain> selectOgm200_pop(MachineDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장 코드로 테이블에서 보전방법 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm200_method(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서 SUB Assy 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc230pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장 코드로 테이블에서 보전작업 실시부서 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm313_obc250pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서  COMPLITE부품분류정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc220pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서  분해불능부품분류정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc160pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서  분해불능부품분류정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc060pf_01(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드와 부품코드와 검색 - 음행(umhen)으로 테이블에서 검색 - COMPLETE 부품을 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc060pf_02(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서  분해불능부품분류정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc070pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 단위부품 - 사업장코드와 부품코드로 테이블에서 검색 - 음행을 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc050pf_01(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서 현상정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc190pf(PsogmDomain domain) throws ApplicationException;

    /**
     * [KO] 사업장코드로 테이블에서 원인정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc120pf(PsogmDomain domain) throws ApplicationException;

    /**
     * [KO] 사업장코드로 테이블에서 실원인정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc100pf(PsogmDomain domain) throws ApplicationException;

    /**
     * [KO] 사업장코드와 현상코드로 테이블에서 현상정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc180pf(PsogmDomain domain) throws ApplicationException;

    /**
     * [KO] 사업장코드와 원인분류코드로 테이블에서 원인정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc110pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드와 실원인분류코드로 테이블에서 실원인정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc090pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드와 실원인분류코드로 테이블에서 실원인정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm314_onload(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서 내외구분정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc020pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서 우선도정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc010pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서 품질확인정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc170pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드로 테이블에서 효과구분정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc210pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드와 효과구분코드로 테이블에서 효과분류정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc200pf(PsogmDomain domain) throws ApplicationException;

    /**
     * [KO] 사업장코드로 테이블에서 재발방지정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm203_obc150pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드와 지시no로 테이블에서 교환부품정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<PsogmDomain> selectOgm205_obj220pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드와 분류코드로 테이블에서 예비품정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SpareUnitDb2Domain> selectOGMPrtno(SpareUnitDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 예비품 구입선정보를 탐색하고 결과를 반환한다<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SpareUnitDb2Domain> selectOGMVndnr(SpareUnitDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장코드와 분류코드로 테이블에서 예비품 MAKER정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SpareUnitDb2Domain> selectOGMMaker(SpareUnitDb2Domain domain) throws ApplicationException;

    /**
     * [KO] 검색옵션값으로 DB 테이블에서 예비품 정보를 탐색하고 결과를 리스트로 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SpareUnitDb2Domain> selectOGM116(SpareUnitDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 첨부파일 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'FileDb2Domain' class
     * @return 'FileDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<FileDb2Domain> selectOgm219_obj230pf(FileDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 부품명과 maker명으로 부품 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SpareUnitDb2Domain> selectOgm205_pop(SpareUnitDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] prtno로 DB 테이블에서 예비품 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SpareUnitDb2Domain selectOGM116_JG(SpareUnitDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 사업부 코드와 prtno로  DB table 에서 예비품 정보를 검색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SpareUnitDb2Domain selectOgm010pf(SpareUnitDb2Domain domain) throws ApplicationException;

    /**
     * [KO] 사원아이디로 DB 테이블에서  관리자권한 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SpareUnitDb2Domain selectmanagerYN(SpareUnitDb2Domain domain) throws ApplicationException;

    /**
     * [KO] 입고일자로 DB 테이블에서 마감 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SpareUnitDb2Domain selectcloseYN(SpareUnitDb2Domain domain) throws ApplicationException;

    /**
     * [KO] 지시No로 DB 테이블에서 등록완료 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'String' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String selectOgm203_cmplt(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 사업장과 분류번호로 DB 테이블에서 max 자재입고번호를 탐색하고 1을 더한 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SpareUnitDb2Domain selectOGM115_maxNumber(SpareUnitDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 사업부로 DB 테이블에서 max jisno를 탐색하고 1을 더한 결과를 반환한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return 'PsogmDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String selectOgm_maxJisiNum(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 예비품 테이블(LIB2.OGM110PF)에 데이터를 추가한다.<br>
     * [EN] Create a record in LIB2.OGM110PF table.<br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void insertOGM115(SpareUnitDb2Domain domain) throws ApplicationException;

    /**
     * [KO] 이력 테이블(LIB2.OBJ200PF)에 데이터를 추가한다.<br>
     * [EN] Create a record in LIB2.OBJ200PF table.<br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void insertOgm203(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 이력 테이블(LIB2.OBJ200PF)에 데이터를 추가(재발방지 등록)한다.<br>
     * [EN] Create a record in LIB2.OBJ200PF table.<br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void insertOgm203_pepcd(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 교환부품 정보 테이블(LIB2.obj220pf)에 데이터를 추가(교환부품 등록)한다.<br>
     * [EN] Create a record in LIB2.OBJ220PF table.<br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void insertOgm205_obj220pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 예비품 테이블(LIB2.OGM010PF)에 데이터를 추가한다.<br>
     * [EN] Update a record in LIB2.OGM010PF table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'SpareUnitDb2Domain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateOGM115_1(SpareUnitDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 자동체번 테이블에 수정된 max값(max+1)을 update.<br>
     * [EN] Update a record in LIB2.OGM010PF table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateOgm_maxJisiNum(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 이력 테이블(LIB2.obj200pf)에 데이터를 업데이트한다.<br>
     * [EN] Update a record in LIB2.OBJ200PF table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateOgm203(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 이력 테이블(LIB2.obj200pf)에 데이터를 업데이트한다(재발방지업데이트).<br>
     * [EN] Update a record in LIB2.OBJ200PF table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateOgm203_pepcd(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 교환부품 정보 테이블(LIB2.obj220pf)에 데이터를 업데이트한다(교환부품 업데이트).<br>
     * [EN] Update a record in LIB2.OBJ220PF table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int updateOgm205_obj220pf(PsogmDomain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 교환부품정보 테이블의 레코드를 삭제한다.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'PsogmDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteOgm205_obj220pf(PsogmDomain domain) throws ApplicationException;
}
