package temp;

import java.io.*;
import java.util.List;
import java.util.Map;

public class DensoCodeGen {

    // 폴더 패스
    private static final String SRC_PATH = "C:\\Temp\\dicas\\src\\main\\java";
    private static final String SQL_PATH = "C:\\Temp\\dicas\\src\\main\\mapper";
    private static final String JSP_PATH = "C:\\Temp\\dicas\\web\\WEB-INF\\jsp\\page\\cmmn";
    private static final String TEMPLATE_PATH = "C:\\Temp\\dicas\\temp";
    private static final String EXT = ".java";
    private static final String XML_EXT = ".xml";
    private static final String JSP_EXT = ".jsp";

    private static final String DOMAIN_NAME = "Domain";
    private static final String DOMAIN_TEMPLATE = "Domain.template";
    private static final String DOMAIN_PACKAGE = "com.globaldenso.dicas.business.domain";

    private static final String DTO_NAME = "Dto";
    private static final String DTO_TEMPLATE = "Dto.template";
    private static final String DTO_PACKAGE = "com.globaldenso.dicas.business.dto";

    private static final String DAO_NAME = "Dao";
    private static final String DAO_TEMPLATE = "Dao.template";
    private static final String DAO_PACKAGE = "com.globaldenso.dicas.business.dao";

    private static final String SERVICE_NAME = "Service";
    private static final String SERVICE_TEMPLATE = "Service.template";
    private static final String SERVICE_PACKAGE = "com.globaldenso.dicas.business.service";

    private static final String SERVICE_IMPL_NAME = "ServiceImpl";
    private static final String SERVICE_IMPL_TEMPLATE = "ServiceImpl.template";
    private static final String SERVICE_IMPL_PACKAGE = "com.globaldenso.dicas.business.service.impl";

    private static final String FORM_NAME = "Form";
    private static final String FORM_TEMPLATE = "Form.template";
    private static final String FORM_PACKAGE = "com.globaldenso.dicas.presentation.form";

    private static final String SEARCH_FORM_NAME = "SearchForm";
    private static final String SEARCH_FORM_TEMPLATE = "SearchForm.template";
    private static final String SEARCH_FORM_PACKAGE = "com.globaldenso.dicas.presentation.form";

    private static final String CONTROLLER_NAME = "Controller";
    private static final String CONTROLLER_TEMPLATE = "Controller.template";
    private static final String CONTROLLER_PACKAGE = "com.globaldenso.dicas.presentation.controller";

    private static final String SQLMAP_NAME = "SqlMap-";
    private static final String SQLMAP_TEMPLATE = "SqlMap.template";
    private static final String SQLMAP_PACKAGE = "com.globaldenso.dicas.integration.sqlmap";

    private static final String JSP_TEMPLATE = "Jsp.template";

    private static final String ID = "junghwi.son";
    private static final String AUTHOR = "TWOGOMS";
    private static final String REVISION = "1.0";

    public static void main(String[] arge) {

        //String uid = "";
        //String param = "";

        // TODO START 아래의 명칭과 테이블명을 수정해서 실행하세요.
        String name = "ResultMasterCost";
        String tableName = "TB_DC_RESULT_MASTER_COST";
        String key = "ID";
        String seqName = "SEQ_" + tableName;
        String viewId = "TEMP0099";

        // TODO END

        // DB 정보 읽기
        List<Map> list = DBInfo.selectInfo(tableName);

        domainGen(name, list);
        dtoGen(name, list);
        daoGen(name, list);
        formGen(name, list);
        searchFormGen(name, list);
        serviceGen(name, list);
        serviceImplGen(name, list);
        controllerGen(name, list, viewId, tableName);
        sqlmapGen(name, list, key, tableName, seqName);
        jspGen(name, list, viewId, key, tableName);

    }

    private static void domainGen(String name, List<Map> list) {

        // 파일읽기
        String str = readFile(DOMAIN_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        StringBuffer sb = new StringBuffer("");
        for (Map map : list) {

            if ("rgstrId".equals(map.get("COLUMN_NAME")) ||
                    "rgstDt".equals(map.get("COLUMN_NAME")) ||
                    "updtrId".equals(map.get("COLUMN_NAME")) ||
                    "updtDt".equals(map.get("COLUMN_NAME")) ||
                    "tranYn".equals(map.get("COLUMN_NAME")) ) {

                continue;
            }

            sb.append("\t");
            sb.append("private ");

            String type = "String";
            if ("NUMBER".equals(map.get("DATA_TYPE"))) {
                type = "Long";
            } else if ("TIMESTAMP(6)".equals(map.get("DATA_TYPE"))) {
                type = "LocalDateTime";
            } else if ("DATE".equals(map.get("DATA_TYPE"))) {
                type = "Date";
            }
            sb.append(type + " ");
            sb.append(map.get("COLUMN_NAME") + ";");
            sb.append("\n");
        }

        str = str.replaceAll("\\$param\\$", sb.toString());

        // 파일 생성
        createFile(SRC_PATH, DOMAIN_PACKAGE, name + DOMAIN_NAME + EXT, str);
    }

    private static void dtoGen(String name, List<Map> list) {

        // 파일읽기
        String str = readFile(DTO_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        // 파일 생성
        createFile(SRC_PATH, DTO_PACKAGE, name + DTO_NAME + EXT, str);
    }

    private static void daoGen(String name, List<Map> list) {

        // 파일읽기
        String str = readFile(DAO_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        // 파일 생성
        createFile(SRC_PATH, DAO_PACKAGE, name + DAO_NAME + EXT, str);
    }

    private static void serviceGen(String name, List<Map> list) {

        // 파일읽기
        String str = readFile(SERVICE_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        // 파일 생성
        createFile(SRC_PATH, SERVICE_PACKAGE, name + SERVICE_NAME + EXT, str);
    }

    private static void serviceImplGen(String name, List<Map> list) {

        // 파일읽기
        String str = readFile(SERVICE_IMPL_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        // 파일 생성
        createFile(SRC_PATH, SERVICE_IMPL_PACKAGE, name + SERVICE_IMPL_NAME + EXT, str);
    }

    private static void formGen(String name, List<Map> list) {

        // 파일읽기
        String str = readFile(FORM_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        // 파일 생성
        createFile(SRC_PATH, FORM_PACKAGE, name + FORM_NAME + EXT, str);
    }

    private static void searchFormGen(String name, List<Map> list) {

        // 파일읽기
        String str = readFile(SEARCH_FORM_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        // 파일 생성
        createFile(SRC_PATH, SEARCH_FORM_PACKAGE, name + SEARCH_FORM_NAME + EXT, str);
    }

    private static void controllerGen(String name, List<Map> list, String viewId, String tableName) {

        // 파일읽기
        String str = readFile(CONTROLLER_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        str = str.replaceAll("\\$viewId\\$", viewId);

        StringBuffer sb = new StringBuffer("");
        int index = 1;
        for (Map map : list) {

            if (!isCode(tableName, (String)map.get("ORI_COLUMN_NAME"))) {
                continue;
            }

            sb.append("\tCodeSearchForm searchForm" + index + " = new CodeSearchForm();\n");
            sb.append("\tsearchForm" + index + ".setGrpCds(Arrays.asList(new String[] {\n");
            sb.append("\t\tDicasConstant.CodeGroupAttribute." + map.get("ORI_COLUMN_NAME") + "\n");
            sb.append("\t}));\n");
            sb.append("\tList<CodeDto> codeList" + index + " = codeService.searchCodeByCondition(searchForm" + index + ");\n");
            sb.append("\tList<CodeDto> " + map.get("COLUMN_NAME") + "List = codeList" + index + "\n");
            sb.append("\t\t.stream()\n");
            sb.append("\t\t.filter(item -> item.getGrpCd().equals(DicasConstant.CodeGroupAttribute." + map.get("ORI_COLUMN_NAME") + "))");
            sb.append("\t\t.collect(Collectors.toList());");

            index++;
        }
        str = str.replaceAll("\\$selectCode\\$", sb.toString());

        sb = new StringBuffer("");
        for (Map map : list) {

            if (!isCode(tableName, (String)map.get("ORI_COLUMN_NAME"))) {
                continue;
            }

            sb.append("\tmv.addObject(\""+map.get("COLUMN_NAME")+"Items\", "+map.get("COLUMN_NAME")+"List);\n");
        }
        str = str.replaceAll("\\$setCode\\$", sb.toString());

        // 파일 생성
        createFile(SRC_PATH, CONTROLLER_PACKAGE, name + CONTROLLER_NAME + EXT, str);
    }

    private static boolean isCode(String tableName, String param) {

        if ("USE_YN".equals(param)) {
            return true;
        }
        return false;
    }

    private static void sqlmapGen(String name, List<Map> list, String key, String tableName, String seqName) {

        // 파일읽기
        String str = readFile(SQLMAP_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        str = str.replaceAll("\\$key\\$", key);
        str = str.replaceAll("\\$lKey\\$", key.toLowerCase());
        str = str.replaceAll("\\$keyValue\\$", key+" = #{" + key.toLowerCase() + "}");
        str = str.replaceAll("\\$table\\$", tableName);
        str = str.replaceAll("\\$seq\\$", seqName);

        StringBuffer sb = new StringBuffer("");
        int index = 0;
        for (Map map : list) {

            sb.append("\t\t");
            if (index != 0 ) sb.append(",");
            sb.append(map.get("ORI_COLUMN_NAME"));
            sb.append("\n");
            index++;
        }
        str = str.replaceAll("\\$column\\$", sb.toString());

        sb = new StringBuffer("");
        index = 0;
        for (Map map : list) {

            sb.append("\t\t");
            if (index != 0 ) sb.append(",");
            sb.append("#{" + map.get("COLUMN_NAME") + "}");
            sb.append("\n");
            index++;
        }
        str = str.replaceAll("\\$values\\$", sb.toString());

        sb = new StringBuffer("");
        index = 0;
        for (Map map : list) {

            if (key.equals(map.get("ORI_COLUMN_NAME"))) {
                continue;
            }

            if ("RGSTR_ID".equals(map.get("ORI_COLUMN_NAME")) ||
                    "RGST_DT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "TRAN_YN".equals(map.get("ORI_COLUMN_NAME"))) {
                continue;
            }

            sb.append("\t\t");
            if (index != 0 ) sb.append(",");

            sb.append(map.get("ORI_COLUMN_NAME") + " = ");
            sb.append("#{" + map.get("COLUMN_NAME") + "}");
            sb.append("\n");
            index++;
        }
        str = str.replaceAll("\\$updateValue\\$", sb.toString());

        sb = new StringBuffer("");
        for (Map map : list) {

            sb.append("\t\t");

            if (key.equals(map.get("ORI_COLUMN_NAME"))) {
                sb.append("<id ");
            } else {
                sb.append("<result ");
            }

            sb.append("property=\"" + map.get("COLUMN_NAME") + "\" column=\"");
            sb.append(map.get("ORI_COLUMN_NAME") + "\" javaType=\"");

            String type = "java.lang.String";
            if ("NUMBER".equals(map.get("DATA_TYPE"))) {
                type = "java.lang.Long";
            } else if ("TIMESTAMP(6)".equals(map.get("DATA_TYPE"))) {
                type = "java.time.LocalDateTime";
            } else if ("DATE".equals(map.get("DATA_TYPE"))) {
                type = "java.sql.Date";
            }
            sb.append(type + "\" />");
            sb.append("\n");
        }
        str = str.replaceAll("\\$dbParam\\$", sb.toString());

        // 파일 생성
        createFile(SQL_PATH, SQLMAP_PACKAGE, SQLMAP_NAME + name + XML_EXT, str);
    }

    private static void jspGen(String name, List<Map> list, String viewId, String key, String tableName) {

        // 파일읽기
        String str = readFile(JSP_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        str = str.replaceAll("\\$key\\$", key);

        StringBuffer sb = new StringBuffer("");
        for (Map map : list) {

            if ("AUTOINSERT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "RGSTR_ID".equals(map.get("ORI_COLUMN_NAME")) ||
                    "RGST_DT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "UPDTR_ID".equals(map.get("ORI_COLUMN_NAME")) ||
                    "UPDT_DT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "TRAN_YN".equals(map.get("ORI_COLUMN_NAME"))
                    ) {
                continue;
            }

            sb.append("\t\t");
            if (isCode(tableName, (String)map.get("ORI_COLUMN_NAME"))) {
                sb.append("            <tr>\n" +
                        "              <th scope=\"row\">\n" +
                        "                <label for=\"cmb_" + map.get("COLUMN_NAME") + "_input\">" + map.get("COMMENTS") + "</label>\n" +
                        "              </th>\n" +
                        "              <td>\n" +
                        "                <kendo:dropDownList name=\"cmb_" + map.get("COLUMN_NAME") + "_input\" dataTextField=\"codeNm\"\n" +
                        "                                    dataValueField=\"codeCd\"\n" +
                        "                                    data-value-primitive=\"true\"\n" +
                        "                                    data-bind=\"value: data." + map.get("COLUMN_NAME") + "\">\n" +
                        "                  <kendo:dataSource data=\"\\${" + map.get("COLUMN_NAME") + "Items}\"/>\n" +
                        "                </kendo:dropDownList>\n" +
                        "              </td>\n" +
                        "            </tr>");
            } else {

                if ("ID".equals(map.get("ORI_COLUMN_NAME"))) {
                    sb.append("\n" +
                            "            <tr>\n" +
                            "              <th scope=\"row\"><label for=\""+map.get("COLUMN_NAME")+"_input\">"+map.get("COMMENTS")+"</label>\n" +
                            "              </th>\n" +
                            "              <td>\n" +
                            "                <input type=\"text\" id=\""+map.get("COLUMN_NAME")+"_input\" data-bind=\"value: data."+map.get("COLUMN_NAME")+"\" disabled='disabled' /> \n" +
                            "              </td>\n" +
                            "            </tr>");
                } else {
                    sb.append("\n" +
                            "            <tr>\n" +
                            "              <th scope=\"row\"><label for=\""+map.get("COLUMN_NAME")+"_input\">"+map.get("COMMENTS")+"</label>\n" +
                            "              </th>\n" +
                            "              <td>\n" +
                            "                <input type=\"text\" id=\""+map.get("COLUMN_NAME")+"_input\" data-bind=\"value: data."+map.get("COLUMN_NAME")+"\" />\n" +
                            "              </td>\n" +
                            "            </tr>");
                }
            }

            sb.append("\n");
        }
        str = str.replaceAll("\\$param\\$", sb.toString());

        int index = 0;
        sb = new StringBuffer("");
        for (Map map : list) {

            if (key.equals(map.get("ORI_COLUMN_NAME"))) {
                continue;
            }

            if ("AUTOINSERT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "RGSTR_ID".equals(map.get("ORI_COLUMN_NAME")) ||
                    "RGST_DT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "UPDTR_ID".equals(map.get("ORI_COLUMN_NAME")) ||
                    "UPDT_DT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "TRAN_YN".equals(map.get("ORI_COLUMN_NAME"))
                    ) {
                continue;
            }

            sb.append("\t");
            if (index != 0 ) sb.append(",");

            String type = "string";
            if ("NUMBER".equals(map.get("DATA_TYPE"))) {
                type = "number";
            }

            sb.append(      map.get("COLUMN_NAME") +": { type: '"+type+"' }");

            sb.append("\n");
            index++;
        }
        str = str.replaceAll("\\$dataSet\\$", sb.toString());

        index = 0;
        sb = new StringBuffer("");
        for (Map map : list) {

            if ("AUTOINSERT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "RGSTR_ID".equals(map.get("ORI_COLUMN_NAME")) ||
                    "RGST_DT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "UPDTR_ID".equals(map.get("ORI_COLUMN_NAME")) ||
                    "UPDT_DT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "TRAN_YN".equals(map.get("ORI_COLUMN_NAME"))
                    ) {
                continue;
            }

            sb.append("\t");
            if (index != 0 ) sb.append(",");

            if (isCode(tableName, (String)map.get("ORI_COLUMN_NAME"))) {
                sb.append("{\n" +
                        "          title: '"+map.get("COMMENTS")+"',\n" +
                        "          name: '"+map.get("COLUMN_NAME")+"',\n" +
                        "          align: 'center',\n" +
                        "          editOptions: {\n" +
                        "            type: 'select',\n" +
                        "            listItems: "+map.get("COLUMN_NAME")+"Items,\n" +
                        "            useViewMode: true\n" +
                        "          }\n" +
                        "        }");
            } else {
                sb.append("{ title: '"+map.get("COMMENTS")+"', name: '"+map.get("COLUMN_NAME")+"', align: 'center' }");
            }

            sb.append("\n");
            index++;
        }
        str = str.replaceAll("\\$columns\\$", sb.toString());

        index = 0;
        sb = new StringBuffer("");
        for (Map map : list) {

            if ("AUTOINSERT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "RGSTR_ID".equals(map.get("ORI_COLUMN_NAME")) ||
                    "RGST_DT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "UPDTR_ID".equals(map.get("ORI_COLUMN_NAME")) ||
                    "UPDT_DT".equals(map.get("ORI_COLUMN_NAME")) ||
                    "TRAN_YN".equals(map.get("ORI_COLUMN_NAME"))
                    ) {
                continue;
            }

            sb.append("\t");

            if (isCode(tableName, (String)map.get("ORI_COLUMN_NAME"))) {
                sb.append("cmb"+map.get("COLUMN_NAME")+"Input = \\$(\"#cmb_"+map.get("COLUMN_NAME")+"_input\", \"#frm_input\").data(\"kendoDropDownList\");");
                sb.append("var "+map.get("COLUMN_NAME")+"Data = cmb"+map.get("COLUMN_NAME")+"Input.dataSource.data(), "+map.get("COLUMN_NAME")+"Items = _dicasPage.getEditOptions("+map.get("COLUMN_NAME")+"Data);");
                sb.append("\n");
            }
            index++;
        }
        str = str.replaceAll("\\$dropDownCode\\$", sb.toString());

        // 파일 생성
        createFile(JSP_PATH, "", viewId + JSP_EXT, str);
    }

    // 유틸

    private static String replace(String str, String name) {

        str = str.replaceAll("\\$Id\\$", ID);
        str = str.replaceAll("\\$Author\\$", AUTHOR);
        str = str.replaceAll("\\$Revision\\$", REVISION);
        str = str.replaceAll("\\$name\\$", name);
        str = str.replaceAll("\\$lName\\$", name.toLowerCase());

        double d = (double)(Math.random()*1000000000000000000L);
        long l = Math.round(d);
        str = str.replaceAll("\\$uid\\$", String.valueOf(l)+"L");

        return str;
    }

    private static String readFile(String fileName) {

        File inFile = new File(TEMPLATE_PATH, fileName);
        StringBuffer sb = new StringBuffer("");

        //==========================//
        // 텍스트 파일 읽기
        //==========================//
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile.getPath()),"UTF8"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) try {br.close(); } catch (IOException e) {}
        }

        return sb.toString();

    }

    private static void createFile(String root, String packageName, String fileName, String str) {

        File outFile = new File(root + "\\" + packageName.replace(".","\\"), fileName);

        //==========================//
        // 텍스트 파일 쓰기
        //==========================//
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile.getPath()),"UTF8"));
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw != null) try {bw.close(); } catch (IOException e) {}
        }

    }
}
