package com.globaldenso.dnkr.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.BoardFileDomain;
import com.globaldenso.dnkr.domain.BoardInfoDomain;
import com.globaldenso.dnkr.domain.BoardTextDomain;
import com.globaldenso.dnkr.domain.EmpDomain;

/**
 * [KR] 게시판 서비스 인터페이스. 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface BoardService {

    /**
    * [EN] Search boardInfo information from DB table by any conditions, and return the count of the search result.<br>
    * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @return int Count of search results
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public BoardTextDomain searchById(BoardTextDomain domain) throws ApplicationException;
    
    /**
    * [EN] (For paging processing) Search boardInfo information from DB table by any conditions, and return the search results in a list.<br>
    * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @return List of 'BoardInfoDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public List<BoardTextDomain> searchByConditionForMain(BoardTextDomain domain) throws ApplicationException;

    /**
    * [EN] (For paging processing) Search boardInfo information from DB table by any conditions, and return the search results in a list.<br>
    * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @return List of 'BoardInfoDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public List<BoardTextDomain> searchByCondition(BoardTextDomain domain) throws ApplicationException;

    /**
    * [EN] Search boardText information from DB table by any conditions, and return the count of the search result.<br>
    * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
    * 
    * @param domain 'BoardTextDomain' class
    * @return int Count of search results
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int noticeCount(BoardTextDomain domain) throws ApplicationException;

    /**
    * [EN] (For paging processing) Search boardInfo information from DB table by any conditions, and return the search results in a list.<br>
    * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @return List of 'BoardInfoDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public List<BoardTextDomain> searchByConditionForPaging(BoardTextDomain domain) throws ApplicationException;

    /**
    * [EN] Search boardText information from DB table by any conditions, and return the count of the search result.<br>
    * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
    * 
    * @param domain 'BoardTextDomain' class
    * @return int Count of search results
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int searchCount(BoardTextDomain domain) throws ApplicationException;

    /**
    * [EN] Search boardText information from DB table by any conditions, and return the count of the search result.<br>
    * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
    * 
    * @param domain 'BoardTextDomain' class
    * @return int Count of search results
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int boardCount(BoardTextDomain domain) throws ApplicationException;

    /**
    * [EN] Create a record in boardInfo information table.<br>
    * [JP] 社員情報テーブルに1件のデータを登録します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @param multiRequest MultipartHttpServletRequest
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public void create(BoardTextDomain domain, MultipartHttpServletRequest multiRequest) throws ApplicationException;

    /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int hitsUpdate(BoardTextDomain domain) throws ApplicationException;

    /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @param multiRequest MultipartHttpServletRequest
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int update(BoardTextDomain domain, MultipartHttpServletRequest multiRequest) throws ApplicationException;

    /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int chkDelete(BoardTextDomain domain) throws ApplicationException;

    /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int delete(BoardTextDomain domain) throws ApplicationException;

    /**
    * [EN] Search boardInfo information from DB table by any conditions, and return the count of the search result.<br>
    * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @return int Count of search results
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public BoardInfoDomain searchInfoById(BoardInfoDomain domain) throws ApplicationException;

    /**
    * [EN] (For paging processing) Search boardInfo information from DB table by any conditions, and return the search results in a list.<br>
    * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @return List of 'BoardInfoDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public List<BoardInfoDomain> searchByInfoConditionForPaging(BoardInfoDomain domain) throws ApplicationException;

    /**
    * [EN] Search boardInfo information from DB table by any conditions, and return the count of the search result.<br>
    * [JP] 任意の条件を元にテーブルのデータを検索し、検索結果件数を返却します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @return int Count of search results
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int searchInfoCount(BoardInfoDomain domain) throws ApplicationException;

    /**
    * [EN] Create a record in boardInfo information table.<br>
    * [JP] 社員情報テーブルに1件のデータを登録します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public void infoCreate(BoardInfoDomain domain) throws ApplicationException;

    /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int infoUpdate(BoardInfoDomain domain) throws ApplicationException;

    /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int infoDelete(BoardInfoDomain domain) throws ApplicationException;

    /**
    * [EN] (For paging processing) Search boardInfo information from DB table by any conditions, and return the search results in a list.<br>
    * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @return List of 'BoardInfoDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public BoardFileDomain searchFileById(BoardFileDomain domain) throws ApplicationException;

    /**
    * [EN] (For paging processing) Search boardInfo information from DB table by any conditions, and return the search results in a list.<br>
    * [JP] (ページング処理用) 任意の条件を元にテーブルのデータを検索し、検索結果をリスト形式で返却します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @return List of 'BoardInfoDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public List<BoardFileDomain> searchFileList(BoardFileDomain domain) throws ApplicationException;

    /**
    * [EN] Create a record in boardInfo information table.<br>
    * [JP] 社員情報テーブルに1件のデータを登録します。<br>
    * 
    * @param domain 'BoardInfoDomain' class
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public void fileCreate(BoardFileDomain domain) throws ApplicationException;

    /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int fileUpdate(BoardFileDomain domain) throws ApplicationException;

    /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int downCntUpdate(BoardFileDomain domain) throws ApplicationException;

    /**
    * [EN] Delete a record in employee information table with the primary key.<br>
    * [JP] 主キーを条件に、社員情報テーブルのデータを1件物理削除します。<br>
    * 
    * @param domain 'EmpDomain' class
    * @return Count of the deleted record
    * @throws ApplicationException Application exception of 'Application Infrastructure'
    */
    public int fileDelete(BoardFileDomain domain) throws ApplicationException;
    /**
     * 
     * @param files Map<String, MultipartFile>
     * @param boardVO BoardFileDomain
     * @param fileExt String
     * @param fileSize int
    * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public String insertFileData(Map<String, MultipartFile> files, BoardFileDomain boardVO, String fileExt, int fileSize) throws ApplicationException;
}
