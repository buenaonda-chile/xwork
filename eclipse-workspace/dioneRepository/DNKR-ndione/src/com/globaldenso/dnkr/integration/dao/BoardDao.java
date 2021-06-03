package com.globaldenso.dnkr.integration.dao;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BoardFileDomain;
import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.BoardTextDomain;

/**
 * [EN] DAO interface of Employee information.<br>
 * [JP] 社員情報のDAOインタフェース。<br>
 *
 * @author $Author$
 * @version $Revision$
 */
public interface BoardDao {

    /**
     * [EN] Search boardinfo information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public BoardTextDomain searchById(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) Search boardinfo information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return List of 'BoardInfoDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<BoardTextDomain> searchByConditionForMain(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) Search boardinfo information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return List of 'BoardInfoDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<BoardTextDomain> searchByCondition(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search boardinfo information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int noticeCount(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) Search boardinfo information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return List of 'BoardInfoDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<BoardTextDomain> searchByConditionForPaging(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search boardinfo information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchCount(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search boardinfo information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int boardCount(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search boardinfo information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String boardNextIdx(BoardTextDomain domain) throws ApplicationException;

    /**
     * [EN] Create a record in boardinfo information table.
     * [JP] 社員情報テーブルに1件のデータを登録します。
     * 
     * @param domain 'BoardInfoDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void create(BoardTextDomain domain) throws ApplicationException;
    
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
    public int update(BoardTextDomain domain) throws ApplicationException;
    
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
    public int hitsUpdate(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] Delete a record in employee information table with the primary key.
     * [JP] 主キーを条件に、社員情報テーブルのレコードを1件物理削除します。
     * 
     * @param domain 'EmpDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int chkDelete(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] Delete a record in employee information table with the primary key.
     * [JP] 主キーを条件に、社員情報テーブルのレコードを1件物理削除します。
     * 
     * @param domain 'EmpDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int delete(BoardTextDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search boardinfo information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public BoardInfoDomain searchInfoById(BoardInfoDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) Search boardinfo information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return List of 'BoardInfoDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<BoardInfoDomain> searchByInfoConditionForPaging(BoardInfoDomain domain) throws ApplicationException;
    
    /**
     * [EN] Search boardinfo information from DB table by any conditions, and return the count of the search result.<br>
     * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return Count of search results
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int searchInfoCount(BoardInfoDomain domain) throws ApplicationException;
    
    /**
     * [EN] Create a record in boardinfo information table.
     * [JP] 社員情報テーブルに1件のデータを登録します。
     * 
     * @param domain 'BoardInfoDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public void infoCreate(BoardInfoDomain domain) throws ApplicationException;
    
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
    public int infoUpdate(BoardInfoDomain domain) throws ApplicationException;
    
    /**
     * [EN] Delete a record in employee information table with the primary key.
     * [JP] 主キーを条件に、社員情報テーブルのレコードを1件物理削除します。
     * 
     * @param domain 'EmpDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int infoDelete(BoardInfoDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) Search boardinfo information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return List of 'BoardInfoDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public BoardFileDomain searchFileById(BoardFileDomain domain) throws ApplicationException;
    
    /**
     * [EN] (For paging processing) Search boardinfo information from DB table by any conditions, and return the search results in a list.<br>
     * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
     * 
     * @param domain 'BoardInfoDomain' class
     * @return List of 'BoardInfoDomain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<BoardFileDomain> searchFileList(BoardFileDomain domain) throws ApplicationException;
    
    /**
     * [EN] Create a record in boardinfo information table.
     * [JP] 社員情報テーブルに1件のデータを登録します。
     * 
     * @param domain 'BoardInfoDomain' class
     * @return int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int fileCreate(BoardFileDomain domain) throws ApplicationException;
    
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
    public int fileUpdate(BoardFileDomain domain) throws ApplicationException;
    
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
    public int downCntUpdate(BoardFileDomain domain) throws ApplicationException;
    
    /**
     * [EN] Delete a record in employee information table with the primary key.
     * [JP] 主キーを条件に、社員情報テーブルのレコードを1件物理削除します。
     * 
     * @param domain 'EmpDomain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int fileDelete(BoardFileDomain domain) throws ApplicationException;
}
