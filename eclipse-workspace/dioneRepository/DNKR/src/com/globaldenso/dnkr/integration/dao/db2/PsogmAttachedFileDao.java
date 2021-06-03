package com.globaldenso.dnkr.integration.dao.db2;

import java.util.List;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.domain.db2.FileDb2Domain;

/**
 * 
 *
 * @author $Author$
 * @version $Revision$
 */
public interface PsogmAttachedFileDao {

    /**
     * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'FileDb2Domain' class
     * @return 'FileDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public FileDb2Domain searchById(FileDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'FileDb2Domain' class
     * @return 'FileDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public List<FileDb2Domain> selectOgm219_obj230pf(FileDb2Domain domain) throws ApplicationException;
    
    /**
     * [EN] Create a record in boardInfo information table.<br>
     * [JP] 社員情報テーブルに1件のデータを登録します。<br>
     * 
     * @param domain 'FileDb2Domain' class
     * @return int int
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int insertOgm206_sFile(FileDb2Domain domain) throws ApplicationException;

    /**
     * [KO] 기본키로 DB 테이블에서 권한 정보를 탐색하고 결과를 반환한다.<br>
     * [EN] Search auth information from DB table by the primary key, and return the search results.<br>
     * [JP] <br>
     * 
     * @param domain 'FileDb2Domain' class
     * @return 'FileDb2Domain' class
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int selectOgm206_maxSeq(FileDb2Domain domain) throws ApplicationException;
    
    /**
     * [KO] 기본키로  첨부파일정보－설비보전테이블(LIB2.OBJ230PF)의 레코드를 삭제한다.<br>
     * [EN] Delete a record in LIB2.OBJ230PF table with the primary key.<br>
     * [JP] <br>
     * 
     * @param domain 'FileDb2Domain' class
     * @return Count of the deleted record
     * @throws ApplicationException Application exception of 'Application Infrastructure'
     */
    public int deleteOgm206(FileDb2Domain domain) throws ApplicationException;
}
