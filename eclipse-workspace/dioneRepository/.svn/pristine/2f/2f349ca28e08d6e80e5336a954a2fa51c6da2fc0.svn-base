package com.denso.common.dao;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import com.denso.common.dao.SqlMapConfig;

public class CommonDAO {
	
	private SqlMapClient sqlMap;
	
	public CommonDAO(int num){
		this.sqlMap = SqlMapConfig.getSqlMapInstance(num);
		//System.out.println(num);
		//System.out.println("dao1");
	}
	
    public static CommonDAO getInstance(int num) {
    	//System.out.println(num);
		//System.out.println("dao2");
        return new CommonDAO(num);
    }
    // ******************************************************************
    //start batch
    public void startBatch() throws Exception{
    	sqlMap.startBatch();
    }
    //execute batch
    public void executeBatch() throws Exception{
    	sqlMap.executeBatch();
    }
    
    // ******************************************************************
	// 트랜잭션 시작
    public void startTransaction() throws Exception {
		try {
			
		   sqlMap.startTransaction();
		     //sqlMap.getCurrentConnection().setAutoCommit(false);
		     //sqlMap.getCurrentConnection().setTransactionIsolation(sqlMap.getCurrentConnection().TRANSACTION_READ_UNCOMMITTED);
			 //sqlMap.commitTransaction();
		}catch(Exception e){
		   sqlMap.endTransaction();
		   throw e;
		}
    }
    // 트랜잭션 커밋
    public void endTransaction() throws Exception {
		try {		   
		   sqlMap.commitTransaction();
			//System.out.println("commit18");
		    //sqlMap.getCurrentConnection().commit();
		}catch(Exception e){
		   throw e;
		}finally{
			//System.out.println("endTransaction18");
		   sqlMap.endTransaction();
		    //sqlMap.getCurrentConnection().close();
		}
    }
    public void jdbccommit() throws Exception {
		try {		   
		   //sqlMap.getCurrentConnection().commit();
		   sqlMap.getCurrentConnection().close();
		}catch(Exception e){
		   throw e;
		}
    }
	// ******************************************************************
	// 데이터 추가
/*    public void insertData(String id, Object pData) throws Exception {
		try {
    	   sqlMap.insert(id, pData);  // return Object
		}catch(Exception e){
		   sqlMap.endTransaction();
		   throw e;
		}
    }
*/
    public void insertData(String id, Object pData) throws Exception, SQLException {
		try {
    	   sqlMap.insert(id, pData);  // return Object
		}catch(Exception e){
			//System.out.println("ErrorMsg->"+e.getMessage());
		   sqlMap.endTransaction();
		   throw e;
		}
    }
    /*
    public void insertData(String id, Object pData) throws Exception, SQLException {
		try {
			sqlMap.startTransaction();	
    	    sqlMap.insert(id, pData);  // return Object
    	    sqlMap.commitTransaction();
		}catch(Exception e){
			//System.out.println("ErrorMsg->"+e.getMessage());
		   sqlMap.endTransaction();
		   throw e;
		}finally {	

			//에러가 생겨도 무조건 트랜잭션을 끝내라
			sqlMap.endTransaction();
		}
    }
    */
	// ******************************************************************
	// 데이터 수정
    public int updateData(String id, Object pData) throws Exception {
		int result = 0;
		try {
    	   result = sqlMap.update(id, pData);
		}catch(Exception e){
		   sqlMap.endTransaction();
		   throw e;
		}

		return result;
    }
    public int updateData(String id, Map<String, Object> map) throws Exception {
		int result = 0;
		try {
    	   result = sqlMap.update(id, map);
		}catch(Exception e){
		   sqlMap.endTransaction();
		   throw e;
		}
		return result;
    }
    
	// ******************************************************************
	// 데이터 삭제
	public int deleteData(String id, Object pData) throws Exception,SQLException {
		int result = 0;
		try {
    	   result = sqlMap.delete(id, pData);
		}catch(SQLException e1){
			//System.out.println("ErrorMsg->"+e.getMessage());
			System.out.println("toString SQL ErrorMsg->"+e1.toString());
			System.out.println("getSQLState SQLErrorMsg->"+e1.getSQLState());
			System.out.println("getErrorCode SQLErrorMsg->"+e1.getErrorCode());
		   sqlMap.endTransaction();
		   throw e1;
		}catch(Exception e){
		   sqlMap.endTransaction();
		   throw e;
		}
		return result;
    }
	public int deleteAll(String id) throws Exception {
		int result = 0;
		try {
    	   result = sqlMap.delete(id);
		}catch(Exception e){
		   sqlMap.endTransaction();
		   throw e;
		}
		return result;
    }

	// ******************************************************************
	// 레 코드 수 / 최대 값 구하기
	public int getIntValue(String id) throws Exception {
		return ((Integer)sqlMap.queryForObject(id)).intValue();
    }
	public int getIntValue(String id, Object pData) throws Exception {
		return ((Integer)sqlMap.queryForObject(id, pData)).intValue();
    }

	
	// ******************************************************************
	// 테이블의 레코드를 리스트에 저장
	@SuppressWarnings("unchecked")
	public List<Object> getListData(String id) throws SQLException {
		return (List<Object>) sqlMap.queryForList(id);	
	}
	@SuppressWarnings("unchecked")
	public List<Object> getListData(String id, Object pData) throws SQLException {
		return (List<Object>) sqlMap.queryForList(id, pData);	
	}
	@SuppressWarnings("unchecked")
	public List getListDataModel(String id, Object pData) throws SQLException {
		return (List) sqlMap.queryForList(id, pData);	
	}
	
	// ******************************************************************
	// 해당 레코드 가져오기
	public Object getReadData(String id) throws SQLException {
		return  sqlMap.queryForObject(id);
	}
	public Object getReadData(String id, Object pData) throws SQLException {
		return  sqlMap.queryForObject(id, pData);
	}
	//2015.04.09추가 제환복
	// 오류명 : executeQueryForObject returned too many results
	// queryForObject => queryForList로 변경
	public List<Object> getReadData2(String id) throws SQLException {
		return  sqlMap.queryForList(id);
	}
	public List<Object> getReadData2(String id, Object pData) throws SQLException {
		return  sqlMap.queryForList(id, pData);
	}

}
