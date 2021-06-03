package com.globaldenso.dnkr.integration.dao;

import java.util.HashMap;
import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.MaEmpDomain;
import com.globaldenso.dnkr.domain.db2.SsoAccountDb2Domain;

/**
 * [EN] DAO interface of Employee information.<br>
 * [JP] 社員情報のDAOインタフェース。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface EmpDao {

    /**
     * [EN] Search employee information from DB table by the LOGIN EMP_ID, and return the search results.<br>
     * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
     * 
     * @param domain 'EmpDomain' class
     * @return 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public EmpDomain searchById(EmpDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search employee information from DB table by the LOGIN EMP_ID, and return the search results.<br>
     * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
     * 
     * @param domain 'EmpDomain' class
     * @return 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public EmpDomain getTeamName(EmpDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search employee information from DB table by the primary key, and return the search results.<br>
     * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
     * 
     * @param domain 'EmpDomain' class
     * @return 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public EmpDomain searchByKey(EmpDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search employee information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'EmpDomain' class
     * @return List of 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<EmpDomain> searchByCondition(EmpDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) Search employee information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'EmpDomain' class
     * @return List of 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<EmpDomain> searchByConditionForPaging(EmpDomain domain) throws ApplicationException;   
    
    /**
     * [EN] Search employee information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'EmpDomain' class
     * @return List of 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<EmpDomain> searchByConditionForTeam(EmpDomain domain) throws ApplicationException;
    
    /**
     * [EN] <br>
     * [JP] <br>
     * 
     * @param domain 'EmpDomain' class
     * @return String
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String searchMaxEmpNumber(EmpDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search employee information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'EmpDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(EmpDomain domain) throws ApplicationException;
    
    /**
     * [EN] Create a record in employee information table.
     * [JP] 社員情報テーブルに1件のデータを登録します。
     * 
     * @param domain 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(EmpDomain domain) throws ApplicationException;
    
    /**
     * [EN] Update a record in employee information table with the primary key.<br>
     * [JP] 主キーを条件に、社員情報テーブルのデータを1件更新します。<br>
     * <p>
     * [EN] We have adopted optimistic exclusive control by LAST_UPDATE_DATE in this method.<br>
     * [JP] このメソッドは、最終更新日時による楽観的排他制御を採用しています。
     * </p>
     * 
     * @param domain 'EmpDomain' class
     * @return Count of the updated record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int update(EmpDomain domain) throws ApplicationException;
    
    /**
     * [EN] Delete a record in employee information table with the primary key.
     * [JP] 主キーを条件に、社員情報テーブルのレコードを1件物理削除します。
     * 
     * @param domain 'EmpDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(EmpDomain domain) throws ApplicationException;
    
    
    /**
     * 더존 ERP 회원정보 조회
     * @param domain MaEmpDomain
     * @return List<MaEmpDomain>
     * @throws ApplicationException 
     */
    public List<MaEmpDomain> searchMaEmpList(MaEmpDomain domain) throws ApplicationException;
    
    /**
     * 더존 ERP 회원정보를 DNKR_EMP_TMP에 삽입
     * @param maEmpDomain MaEmpDomain
     * @return int
     * @throws ApplicationException 
     */
    public int insertMaEmpToDnkrEmpTmp(MaEmpDomain maEmpDomain) throws ApplicationException;
    
    /**
     * DNKR_EMP_TMP 비움
     * @return int
     * @throws ApplicationException 
     */
    public int deleteDnkrEmpTmp() throws ApplicationException;
    
    /**
     * 
     * 
     * @param map HashMap
     * @throws ApplicationException 
     */
    public void procMergeEmp(HashMap map) throws ApplicationException;
    
    /**
     * 
     * 
     * @param map HashMap
     * @throws ApplicationException 
     */
    public void procDisableEmp(HashMap map) throws ApplicationException;

    /**
     * [EN] Search employee information from DB table by the LOGIN EMP_ID, and return the search results.<br>
     * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
     * 
     * @param domain 'EmpDomain' class
     * @return 'EmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public EmpDb2Domain searchByDb2Id(EmpDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] [EN] Search SSO information from DB table by the LOGIN EMP_ID and SYSTEM SEQ, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'SsoAccountDb2Domain' class
     * @return List of 'SsoAccountDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SsoAccountDb2Domain ssoAccounts(SsoAccountDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] Search SSO information from DB table by the SYSTEM SEQ and COMPANY, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'SsoAccountDb2Domain' class
     * @return List of 'SsoAccountDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SsoAccountDb2Domain ssoAccounts_OrderProd(SsoAccountDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] Search SSO information from DB table by the SYSTEM SEQ and COMPANY, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'EmpDb2Domain' class
     * @return List of 'EmpDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public EmpDb2Domain selectOgm200_hmd020pf(EmpDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] Search SSO information from DB table by the SYSTEM SEQ and COMPANY, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'EmpDb2Domain' class
     * @return List of 'EmpDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<EmpDb2Domain> selectOGMUserID(EmpDb2Domain domain) throws ApplicationException;
    
    
    /**
     * 더존 ERP 회원정보 조회
     * @param domain MaEmpDomain
     * @return List<MaEmpDomain>
     * @throws ApplicationException 
     */
    //20118.06.05 추가 IT.T 제혼복
    public MaEmpDomain searchEmpMaAccount(MaEmpDomain domain) throws ApplicationException;
    
    
    /**
     * [EN] [EN] Search SSO information from DB table by the LOGIN EMP_ID and SYSTEM SEQ, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'SsoAccountDb2Domain' class
     * @return List of 'SsoAccountDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchSsoDspSessionAccount(SsoAccountDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] [EN] Search SSO information from DB table by the LOGIN EMP_ID and SYSTEM SEQ, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'SsoAccountDb2Domain' class
     * @return List of 'SsoAccountDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SsoAccountDb2Domain searchSsoPrtSessionAccount(SsoAccountDb2Domain domain) throws ApplicationException;
        
    /**
     * [EN] [EN] Search SSO information from DB table by the LOGIN EMP_ID and SYSTEM SEQ, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'SsoAccountDb2Domain' class
     * @return List of 'SsoAccountDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<SsoAccountDb2Domain> searchDioneAccountCnt(SsoAccountDb2Domain domain) throws ApplicationException;
            
	//2018.12.18 추가 IT.T 제혼복(사업부이동자를 위한 Ldap체크)
    public EmpDomain searchByIdLdap(EmpDomain domain) throws ApplicationException;
}
