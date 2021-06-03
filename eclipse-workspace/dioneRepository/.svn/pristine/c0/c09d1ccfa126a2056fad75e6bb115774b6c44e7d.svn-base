package temp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBInfo {

	public static List<Map> selectInfo(String tableName) {
		
		Connection connection = null;
		PreparedStatement preparedStmt = null;
        ResultSet rs = null;
        List<Map> list = null;

        DBConnectionMgr db = DBConnectionMgr.getInstance();

        try {
            
        	connection = db.getConnection();
 
            String sql = "SELECT LOWER(SUBSTR(REPLACE(INITCAP(column_name),'_'),1,1))\n" +
                    "       ||\n" +
                    "       SUBSTR(REPLACE(INITCAP(column_name),'_'),2) AS COLUMN_NAME, DATA_TYPE, COLUMN_NAME AS ORI_COLUMN_NAME, " +
                    " (select COMMENTS from USER_COL_COMMENTS where TABLE_NAME = A.TABLE_NAME and COLUMN_NAME = A.COLUMN_NAME and rownum = 1) COMMENTS" +
                    " FROM COLS A WHERE TABLE_NAME = ? order by column_id asc";
            preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1, tableName);

            rs = preparedStmt.executeQuery();
 
            list = new ArrayList<Map>();
            
            while (rs.next()) {

                Map map = new HashMap();
                map.put("COLUMN_NAME", rs.getString("COLUMN_NAME"));
                map.put("DATA_TYPE", rs.getString("DATA_TYPE"));
                map.put("ORI_COLUMN_NAME", rs.getString("ORI_COLUMN_NAME"));
                map.put("COMMENTS", rs.getString("COMMENTS"));

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

}
