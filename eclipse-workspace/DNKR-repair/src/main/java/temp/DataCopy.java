package temp;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataCopy {

    // MSSQL에서 오라클로 카피 (테이블명 컬럼명 틀렸음)

    public static void main(String[] arge) {

        System.setProperty("file.encoding","UTF-8");
        String[] strTbl = {"TB_DC_VEHICLE_MSATER"};
        //TB_BA_BUSINESS_STD_TIME;
        /*String[] strTbl =
        {
            "TB_BA_ATTACHFILE_DIV",
                    "TB_BA_COMPLAINTS",
                    "TB_BA_CATEGORY",
                    "TB_BA_CURRENT_CODE",
                    "TB_BA_ENGINE_TYPE",
                    "TB_BA_EXCHANGE_PART",
                    "TB_BA_EXCHANGE_PART_NUMBER",
                    "TB_BA_INCIDENT_COST",
                    "TB_BA_MAIN_CATEGORY",
                    "TB_BA_MANAGE_DIV",
                    "TB_BA_MODELS",
                    "TB_BA_OFFICE_DETAIL",
                    "TB_BA_OFFICE_MASTER",
                    "TB_BA_QUALITY_PROBLEM_NM",
                    "TB_BA_RESEARCH_RESULT_DETAIL",
                    "TB_BA_RSMST_ATTCHFILE",
                    "TB_BA_SUB_CATEGORY"
        };*/

        //TB_CM_GROUP
        //TB_DC_CONSULTING
        //TB_DC_ITEM_INFO
        //TB_DC_PHENOMENON_MASTER
        //TB_DC_PHENOMENON_SUB
        //TB_DC_RESEARCH_MASTER
        //TB_DC_RESULT_MASTER
        //TB_DC_RESULT_MASTER_COST
        //TB_DC_SERVICE_MASTER
        //TB_DC_VEHICLE_MSATER

        for (String str : strTbl) {
            insertTbl(str);
        }

    }

    private static String getType(List<Map> colList, String colName) {

        for (Map map : colList) {
            if (map.get("ENG_NM").equals(colName)) {
                return String.valueOf(map.get("DATA_TYPE"));
            }
        }
        return "VARCHAR2";

    }

    private static void insertTbl(String strTbl) {

        System.out.println(strTbl + " INSERT START");

        // DB 정보 읽기
        List<Map> list = DBInfo2.selectTbl(strTbl);

        for (Map map : list) {

            List<Map> list2 = DBInfo2.selectCol(String.valueOf(map.get("TBL_NM")));

            // TO 컬럼
            StringBuffer sb = new StringBuffer("");
            List<String> toList = new ArrayList();
            for (Map map2 : list2) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(String.valueOf(map2.get("ENG_NM")));
                toList.add(String.valueOf(map2.get("ENG_NM")));
            }

            // FROM 컬럼
            StringBuffer sb2 = new StringBuffer("");
            for (Map map2 : list2) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(String.valueOf(map2.get("COL_NM")));
                //System.out.println(map2.get("COL_NM"));
            }

            StringBuffer sql = new StringBuffer();
            sql.append("SELECT ");
            sql.append(sb2.toString());
            sql.append(" FROM ");
            sql.append(map.get("ORI_NM"));

            System.out.println(sql.toString());

            // 실행
            List<Map> list3 = DBInfo2.selectData(sql.toString(), list2);
            System.out.println(strTbl + "SELECT COUNT : " + list3.size() );
            int cnt = 0;
            int cnt2 = 0;

            for (Map map3 : list3) {

                //insert 문 생성
                String insertSql = "INSERT INTO " + map.get("TBL_NM") + " (TRAN_YN, " + sb.toString() + " ) VALUES ('Y', ";

                StringBuffer sb3 = new StringBuffer();
                for (String key : toList) {

                    if (sb3.length() > 0) {
                        sb3.append(",");
                    }

                    String type = getType(list2, key);

                    if (type.equals("NUMBER")) {
                        sb3.append(map3.get(key));
                    } else if (type.equals("DATE")) {

                        String str = String.valueOf(map3.get(key));
                        if (map3.get(key) != null) {
                            if (str.length() > 19) {
                                str = str.substring(0, 19);
                            }

                            sb3.append("to_date('");
                            sb3.append(str);
                            sb3.append("', 'YYYY-MM-DD HH24:MI:SS')");
                        } else {
                            sb3.append("null");
                        }

                    } else {
                        if (map3.get(key) != null) {

                            String str = String.valueOf(map3.get(key));
                            str = str.replaceAll("'", "\"");
                            sb3.append("'");
                            sb3.append(str);
                            sb3.append("'");
                        } else {
                            sb3.append("null");
                        }

                    }

                }
                insertSql = insertSql + sb3.toString() + ")";
                //System.out.println(insertSql);

                try {
                    //등록
                    DBInfo2.insert(insertSql);
                    cnt++;
                } catch (Exception e) {
                    // 오류처리
                    System.out.println(insertSql);
                    e.printStackTrace();
                    cnt2++;
                }
            }

            System.out.println(strTbl + " SUCESS CNT : " + cnt);
            System.out.println(strTbl + " ERROR CNT : " + cnt2);

        }

        System.out.println(strTbl + " INSERT END");

    }

}
