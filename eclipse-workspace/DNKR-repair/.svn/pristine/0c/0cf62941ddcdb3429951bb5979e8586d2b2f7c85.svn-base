package temp;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBInfo2 {

	public static List<Map> selectTbl(String strTbl) {
		
		Connection connection = null;
		PreparedStatement preparedStmt = null;
        ResultSet rs = null;
        List<Map> list = null;

        DBConnectionMgr db = DBConnectionMgr.getInstance();

        try {
            
        	connection = db.getConnection();
 
            String sql = "SELECT TBL_NM, ORI_NM, DESC_CONT " +
                    " FROM TEMP_CONVERT_TBL A WHERE TBL_NM = '"+strTbl+"'";
            preparedStmt = connection.prepareStatement(sql);

            rs = preparedStmt.executeQuery();
 
            list = new ArrayList<Map>();
            
            while (rs.next()) {

                Map map = new HashMap();
                map.put("TBL_NM", rs.getString("TBL_NM"));
                map.put("ORI_NM", rs.getString("ORI_NM"));
                map.put("DESC_CONT", rs.getString("DESC_CONT"));

                list.add(map);
            }
 
        } catch (SQLException se1) {
            se1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
			db.freeConnection(connection, preparedStmt, rs);
        }    
        
        return list;
	}

    public static List<Map> selectCol(String tbl) {

        Connection connection = null;
        PreparedStatement preparedStmt = null;
        ResultSet rs = null;
        List<Map> list = null;

        DBConnectionMgr db = DBConnectionMgr.getInstance();

        try {

            connection = db.getConnection();

            String sql = "SELECT B.TBL_NM, B.COL_NM, B.ENG_NM, B.DESC_CONT, B.ID, C.DATA_TYPE " +
                    "FROM " +
                    "TEMP_CONVERT_TBL A, " +
                    "TEMP_CONVERT_COL B, " +
                    "COLS C " +
                    "WHERE " +
                    "A.ORI_NM = B.TBL_NM " +
                    "AND A.TBL_NM = C.TABLE_NAME " +
                    "AND B.ENG_NM = C.COLUMN_NAME " +
                    "AND A.TBL_NM = ? ";
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, tbl);

            rs = preparedStmt.executeQuery();

            list = new ArrayList<Map>();

            while (rs.next()) {

                Map map = new HashMap();
                map.put("TBL_NM", rs.getString("TBL_NM"));
                map.put("COL_NM", rs.getString("COL_NM"));
                map.put("ENG_NM", rs.getString("ENG_NM"));
                map.put("DESC_CONT", rs.getString("DESC_CONT"));
                map.put("ID", rs.getString("ID"));
                map.put("DATA_TYPE", rs.getString("DATA_TYPE"));

                list.add(map);
            }

        } catch (SQLException se1) {
            se1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.freeConnection(connection, preparedStmt, rs);
        }

        return list;
    }

    public static List<Map> selectData(String sql, List<Map> mapList) {

        Connection connection = null;
        PreparedStatement preparedStmt = null;
        ResultSet rs = null;
        List<Map> list = null;

        DBConnectionMgr2 db = DBConnectionMgr2.getInstance();

        try {

            connection = db.getConnection();

            preparedStmt = connection.prepareStatement(sql);

            rs = preparedStmt.executeQuery();

            list = new ArrayList<Map>();

            while (rs.next()) {

                Map map2 = new HashMap();
                for( Map map3 : mapList ){
                    map2.put(map3.get("ENG_NM"), rs.getString(String.valueOf(map3.get("COL_NM"))));
                }

                list.add(map2);
            }

        } catch (SQLException se1) {
            se1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.freeConnection(connection, preparedStmt, rs);
        }

        return list;
    }

    public static void insert(String sql) throws SQLException {

        Connection connection = null;

        DBConnectionMgr db = DBConnectionMgr.getInstance();
        Statement statement = null;

        try {

            connection = db.getConnection();

            statement = connection.createStatement();
            // execute insert SQL stetement
            statement.executeUpdate(sql);
            //System.out.println("Record is inserted into DBUSER table!");

            connection.commit();

        } catch (SQLException se1) {
            se1.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.freeConnection(connection, statement, null);
        }

    }

}
