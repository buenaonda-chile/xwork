package com.globaldenso.dnkr.business.service;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.MaEmpDomain;
import com.globaldenso.dnkr.domain.db2.SsoAccountDb2Domain;


/**
 * [KR] 사원관리 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface EmpService {
    

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
    * @return int Count of search results
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int searchCount(EmpDomain domain) throws ApplicationException;
   
   /**
    * [EN] Create a record in employee information table.<br>
    * [JP] 社員情報テーブルに1件のデータを登録します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public void create(EmpDomain domain) throws ApplicationException;
   
   /**
    * [EN] Update a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件更新します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the updated record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int update(EmpDomain domain) throws ApplicationException;
   
   /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int delete(EmpDomain domain) throws ApplicationException;
   
   /**
    * [EN] Delete records in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを複数件物理削除します。<br>
    * 
    * @param domainList List of 'EmpDomain' class
    * @return Count of the deleted records
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int delete(List<EmpDomain> domainList) throws ApplicationException;

   /**
    * [EN] Search employee information from DB table by any conditions, and return the search results in a list.<br>
    * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
    * 
    * @param domain 'MaEmpDomain' class
    * @return List of 'MaEmpDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public List<MaEmpDomain> searchMaEmpList(MaEmpDomain domain) throws ApplicationException;
   
    /**
     * 더존 ERP 회원정보를 DNKR_EMP_TMP에 저장
     * @param maEmpDomain MaEmpDomain
     * @return int of insertMaEmpToDnkrEmpTmp
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int insertMaEmpToDnkrEmpTmp(MaEmpDomain maEmpDomain) throws ApplicationException;
   /**
    * @return int of deleteDnkrEmpTmp
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int deleteDnkrEmpTmp() throws ApplicationException;
   /**
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public void procDnkrEmpTmpToMaEmp() throws ApplicationException;
    
    
    /**
     * [EN] Search employee information from DB table by the LOGIN EMP_ID, and return the search results.<br>
     * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
     * 
     * @param domain 'EmpDb2Domain' class
     * @return 'EmpDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public EmpDb2Domain searchByDb2Id(EmpDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] Search SSO information from DB table by the LOGIN EMP_ID, and return the search results.<br>
     * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
     * 
     * @param domain 'SsoAccountDb2Domain' class
     * @return 'EmpDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SsoAccountDb2Domain ssoAccounts(SsoAccountDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] Search SSO information from DB table by the SYSTEM SEQ, and return the search results.<br>
     * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
     * 
     * @param domain 'SsoAccountDb2Domain' class
     * @return 'SsoAccountDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public SsoAccountDb2Domain ssoAccounts_OrderProd(SsoAccountDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] Search SSO information from DB table by the SYSTEM SEQ, and return the search results.<br>
     * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
     * 
     * @param domain 'EmpDb2Domain' class
     * @return 'EmpDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public EmpDb2Domain selectOgm200_hmd020pf(EmpDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] Search employee information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'EmpDb2Domain' class
     * @return 'EmpDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<EmpDb2Domain> selectOGMUserID(EmpDb2Domain domain) throws ApplicationException;
    
    
    /**
     * [EN] Search employee information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'MaEmpDomain' class
     * @return List of 'MaEmpDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    //20118.06.05 추가 IT.T 제혼복
     public MaEmpDomain searchEmpMaAccount(MaEmpDomain domain) throws ApplicationException;
     
     
     /**
      * [EN] Search SSO information from DB table by the LOGIN EMP_ID, and return the search results.<br>
      * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
      * 
      * @param domain 'SsoAccountDb2Domain' class
      * @return 'EmpDb2Domain' class
      * @throws ApplicationException Application exception of 'Application Infrastructure'
      */
     public int searchSsoDspSessionAccount(SsoAccountDb2Domain domain) throws ApplicationException;
     
     /**
      * [EN] Search SSO information from DB table by the LOGIN EMP_ID, and return the search results.<br>
      * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
      * 
      * @param domain 'SsoAccountDb2Domain' class
      * @return 'EmpDb2Domain' class
      * @throws ApplicationException Application exception of 'Application Infrastructure'
      */
     public SsoAccountDb2Domain searchSsoPrtSessionAccount(SsoAccountDb2Domain domain) throws ApplicationException;
     
     
     /**
      * [EN] Search SSO information from DB table by the LOGIN EMP_ID, and return the search results.<br>
      * [JP] 主キーを条件にDBテーブルから社員情報を検索し、検索結果を返却します。<br>
      * 
      * @param domain 'SsoAccountDb2Domain' class
      * @return 'EmpDb2Domain' class
      * @throws ApplicationException Application exception of 'Application Infrastructure'
      */
     public List<SsoAccountDb2Domain> searchDioneAccountCnt(SsoAccountDb2Domain domain) throws ApplicationException;
     
     //2018.12.18 추가 IT.T 제혼복(사업부이동자를 위한 Ldap체크)
     public EmpDomain searchByIdLdap(EmpDomain domain) throws ApplicationException;

     
}
