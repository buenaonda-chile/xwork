package generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

public class DensoCodeGen {
	
	
	private static final String ID = "yoonjae.jeong";
    private static final String AUTHOR = "K-DATALAB";
    private static final String REVISION = "1.0";
    
    
    private static final String EXT = ".java";
    private static final String SRC_PATH = "src";
    private static final String TEMPLATE_PATH = "src/generator/template";
    private static final String XML_EXT = ".xml";
    private static final String JSP_EXT = ".jsp";
    private static final String JS_EXT = ".js";
    private static final String JSP_PATH = "WebContent/generator";
    
	private static final String DOMAIN_NAME = "Domain";
    private static final String DOMAIN_TEMPLATE = "Domain.template";
    private static final String DOMAIN_PACKAGE = "com.globaldenso.dnkr.domain";
    
    private static final String DAO_NAME = "Dao";
    private static final String DAO_TEMPLATE = "Dao.template";
    private static final String DAO_PACKAGE = "com.globaldenso.dnkr.integration.dao";
    
    private static final String DAO_IMPL_NAME = "DaoImpl";
    private static final String DAO_IMPL_TEMPLATE = "DaoImpl.template";
    private static final String DAO_IMPL_PACKAGE = "com.globaldenso.dnkr.integration.dao";
    
    private static final String SERVICE_NAME = "Service";
    private static final String SERVICE_TEMPLATE = "Service.template";
    private static final String SERVICE_PACKAGE = "com.globaldenso.dnkr.business.service";
    
    private static final String SERVICE_IMPL_NAME = "ServiceImpl";
    private static final String SERVICE_IMPL_TEMPLATE = "ServiceImpl.template";
    private static final String SERVICE_IMPL_PACKAGE = "com.globaldenso.dnkr.business.service";

    private static final String CONTROLLER_NAME = "Controller";
    private static final String CONTROLLER_TEMPLATE = "Controller.template";
    private static final String CONTROLLER_PACKAGE = "com.globaldenso.dnkr.presentation.controller.sal";

    private static final String AJAX_CONTROLLER_NAME = "Controller";
    private static final String AJAX_CONTROLLER_TEMPLATE = "AjaxController.template";
    private static final String AJAX_CONTROLLER_PACKAGE = "com.globaldenso.dnkr.presentation.controller.ajax";
    
    private static final String SQLMAP_NAME = "SqlMap-";
    private static final String SQLMAP_TEMPLATE = "SqlMap.template";
    private static final String SQLMAP_PACKAGE = "com.globaldenso.dnkr.integration.sqlmap";

    private static final String JSP_TEMPLATE = "Jsp.template";
    private static final String JS_TEMPLATE = "Js.template";
    
    /*
     * jsp, js 파일은  webcontent/generator 폴더에 생성됨.
     * 나머지 java 파일은 각자 폴더로 알아서 저장됨.
     * */
    public static void main(String[] arge) {
    	
    	// TODO START 아래의 명칭과 테이블명을 수정해서 실행하세요.
        String name = "CustTypeOrderExceptionMstGen";
        String tableName = "SVH310PF";
        String key[] = {"COMPS","PYVND"};  //테이블에서 키값
        String viewId = "WAN040";
        
        List<Map> list = DBInfo.selectInfo(tableName);
        
        domainGen(name, list);
        daoGen(name,list);
        daoImplGen(name,list);
        serviceGen(name, list);
        serviceImplGen(name,list);
        controllerGen(name, list, viewId);
        ajaxControllerGen(name, list, viewId);
        sqlmapGen(name, list, key, tableName);
        JspGen(name);
        JsGen(name,list,key);  
        
        
        
    }
    
    private static void JsGen(String name, List<Map> list, String[] key) {
		// TODO Auto-generated method stub
    	//파일읽기
        String str = readFile(JS_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        
        //column
        StringBuffer sb = new StringBuffer("");
        int index = 0;
        boolean primary;
        for (Map map : list) {
        	if (index != 0 ) sb.append(",\n");
        	sb.append("{")
        	  .append("binding:'"+map.get("COLUMN_NAME")+"',")
        	  .append(" header: ");
        	primary = false;
        	for(String value:key) {
        		if (value.equals(map.get("ORI_COLUMN_NAME"))) {
        			sb.append("'* ").append(map.get("COMMENTS")).append("',");
        			primary = true;
        			continue;
        		}
    		}
        	if(!primary) {
        		sb.append("'"+map.get("COMMENTS")+"',");
        	}
        	sb.append(" width: '*',");
        	
        	switch(map.get("DATA_TYPE").toString()) {
        		case "NUMBER":
        			sb.append(" dataType:'").append("Number").append("',").append(" format:'n0'");
        			break;
        		default:
        			sb.append(" dataType:'").append("String'");
        	}
        	sb.append("}");
        	
        	
        	index++;
        	
        }
        str = str.replaceAll("\\$column\\$", sb.toString());
        
        createFile(JSP_PATH+"/js", "", name + JS_EXT, str);
        
	}

	private static void JspGen(String name) {
		// TODO Auto-generated method stub
    	
    	// 파일읽기
        String str = readFile(JSP_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        
    	
    	createFile(JSP_PATH+"/jsp", "", name + JSP_EXT, str);
	}

	private static void sqlmapGen(String name, List<Map> list, String[] key, String tableName) {
    	
    	// 파일읽기
        String str = readFile(SQLMAP_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        
        str = str.replaceAll("\\$table\\$", tableName);
        
        //column
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
        
                
        //values
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

        
        //update values
        sb = new StringBuffer("");
        index = 0;
        loop:for (Map map : list) {
        	
        	for(String value : key) {
        		if(value.equals(map.get("ORI_COLUMN_NAME"))){
        			continue loop;
        		}
        				
        	}
        	
            sb.append("\t\t");
            if (index != 0 ) sb.append(",");

            sb.append(map.get("ORI_COLUMN_NAME") + " = ");
            sb.append("#{" + map.get("COLUMN_NAME") + "}");
            sb.append("\n");
            index++;
        }
        str = str.replaceAll("\\$updateValue\\$", sb.toString());
        
        //keyvalue
        sb = new StringBuffer("");
        for(String value: key) {
        	sb.append("\t and ")
        	  .append(value+" = #{"+value.toLowerCase()+"}\n");
        }
        str = str.replaceAll("\\$keyValue\\$", sb.toString());
        
        
        //파일 생성
        createFile(SRC_PATH, SQLMAP_PACKAGE, SQLMAP_NAME + name + XML_EXT, str);
    	
    }
	private static void ajaxControllerGen(String name, List<Map> list, String viewId) {
		// TODO Auto-generated method stub
		String str = readFile(AJAX_CONTROLLER_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        
        str = str.replaceAll("\\$viewId\\$", viewId);
        
        str = str.replaceAll("\\$package\\$", AJAX_CONTROLLER_PACKAGE);

        // 파일 생성
        createFile(SRC_PATH, AJAX_CONTROLLER_PACKAGE, "Ajax"+name + AJAX_CONTROLLER_NAME + EXT, str);

	}


	private static void controllerGen(String name, List<Map> list, String viewId) {
		// TODO Auto-generated method stub
		String str = readFile(CONTROLLER_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        
        str = str.replaceAll("\\$viewId\\$", viewId);
        
        str = str.replaceAll("\\$package\\$", CONTROLLER_PACKAGE);

        // 파일 생성
        createFile(SRC_PATH, CONTROLLER_PACKAGE, viewId+name + CONTROLLER_NAME + EXT, str);
	}


	private static void domainGen(String name, List<Map> list) {
		// TODO Auto-generated method stub
		// 파일읽기
        String str = readFile(DOMAIN_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        
        str = str.replaceAll("\\$package\\$",DOMAIN_PACKAGE);
        
        StringBuffer sb = new StringBuffer("");
        StringBuffer sb2 = new StringBuffer("");
        StringBuffer sb3 = new StringBuffer("");
        
        
        sb3.append("\t").append("public String toString() {\n")
           .append("\t\t").append("JSONObject jsonObj = new JSONObject();\n");
        
        for (Map map : list) {
        	
        	String type = ""; 
        	
        	switch(map.get("DATA_TYPE").toString()) {
        		case "NUMBER":
        			type = "Long";
        			break;
        		case "DATE": case "TIMESTAMP":
        			type = "LocalDateTime";
        			break;
        		default:type = "String";
        	}
        	//필드 선언
        	sb.append("\t/**\n")
        	  .append("\t * ")
        	  .append(" ").append(map.get("COMMENTS")+"\n")
        	  .append("\t */ \n")
        	  .append("\t"+"private ")
        	  .append(type + " ")
              .append(map.get("COLUMN_NAME") + ";")
              .append("\n\n");
        	
            //getter,setter 생성
        	sb2.append("\t"+"public ").append(type + " ")
        	   .append("get"+upperCaseFirst(map.get("COLUMN_NAME").toString())).append("() {\n")
        	   .append("\t\t"+"return "+map.get("COLUMN_NAME")+";\n")
        	   .append("\t}\n")
        	   .append("\n")
        	   .append("\t"+"public void ").append("set"+upperCaseFirst(map.get("COLUMN_NAME").toString()))
        	   .append("(").append(type + " ").append(map.get("COLUMN_NAME") + ") {\n")
        	   .append("\t\t").append("this.").append(map.get("COLUMN_NAME"))
        	   .append(" = ").append(map.get("COLUMN_NAME")+";\n")
        	   .append("\t}")
        	   .append("\n")
        	   .append("\n");

        	sb3.append("\t\t").append("jsonObj.put(\""+map.get("COLUMN_NAME")+"\", this."+map.get("COLUMN_NAME")+");\n");
        	   		
        }
        
        for(int ii=1;ii<4;ii++) {
        	sb.append("\t"+"private String lib"+ii+";\n\n");
        	
        	sb2.append("\t"+"public String getLib"+ii+"() {\n")
               .append("\t\t"+"return lib"+ii+";\n")
               .append("\t}\n\n");
        	
        	sb2.append("\t"+"public void setLib"+ii+"(String lib"+ii+") {\n")
               .append("\t\t"+"this.lib"+ii+" = lib"+ii+";\n")
               .append("\t}\n\n");
        }
        
        sb3.append("\t\t").append("String rtnStr = jsonObj.toJSONString();\n")
           .append("\t\t return rtnStr;\n")
           .append("\t}");
        
        
        str = str.replaceAll("\\$param\\$", sb.append(sb2).append(sb3).toString());
        
        //파일 생성
        createFile(SRC_PATH, DOMAIN_PACKAGE, name + DOMAIN_NAME + EXT, str);
		
	}
	
	
	private static void daoImplGen(String name, List<Map> list) {
		// TODO Auto-generated method stub
		//파일읽기
        String str = readFile(DAO_IMPL_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        
        str = str.replaceAll("\\$package\\$", DAO_IMPL_PACKAGE);
        
        // 파일 생성
        createFile(SRC_PATH, DAO_IMPL_PACKAGE, name + DAO_IMPL_NAME + EXT, str);
	}


	private static void daoGen(String name, List<Map> list) {
		// TODO Auto-generated method stub
		// 파일읽기
        String str = readFile(DAO_TEMPLATE);
        // 기본 치환
        str = replace(str, name);

        str = str.replaceAll("\\$package\\$", DAO_PACKAGE);
        
        // 파일 생성
        createFile(SRC_PATH, DAO_PACKAGE, name + DAO_NAME + EXT, str);
	}
	
	private static void serviceGen(String name, List<Map> list) {
		// TODO Auto-generated method stub
		// 파일읽기
        String str = readFile(SERVICE_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        
        str = str.replaceAll("\\$package\\$", SERVICE_PACKAGE);
        
        createFile(SRC_PATH, SERVICE_PACKAGE, name + SERVICE_NAME + EXT, str);

	}
	
	private static void serviceImplGen(String name, List<Map> list) {

        // 파일읽기
        String str = readFile(SERVICE_IMPL_TEMPLATE);
        // 기본 치환
        str = replace(str, name);
        
        str = str.replaceAll("\\$package\\$", SERVICE_IMPL_PACKAGE);
        
        // 파일 생성
        createFile(SRC_PATH, SERVICE_IMPL_PACKAGE, name + SERVICE_IMPL_NAME + EXT, str);
    }
	
	private static void createFile(String root, String packageName, String fileName, String str) {
		
		// TODO Auto-generated method stub
		File outFile = new File(root+"/"+packageName.replace(".", "/"),fileName);

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


	/**
	 * 첫글자 대문자 변환
	 * @param val
	 * @return
	 */
	public static String upperCaseFirst(String val) {
		char[] arr = val.toCharArray();
		arr[0] = Character.toUpperCase(arr[0]);
		return new String(arr);
	}
	
	/**
	 * 첫글자 소문자 변환
	 * @param val
	 * @return
	 */
	public static String lowerCaseFirst(String val) {
		char[] arr = val.toCharArray();
		arr[0] = Character.toLowerCase(arr[0]);
		return new String(arr);
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
                //System.out.println(line);
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
    
	
    private static String replace(String str, String name) {

        str = str.replaceAll("\\$Id\\$", ID);
        str = str.replaceAll("\\$Author\\$", AUTHOR);
        str = str.replaceAll("\\$Revision\\$", REVISION);
        str = str.replaceAll("\\$name\\$", name);
        //str = str.replaceAll("\\$lName\\$", name.toLowerCase());
        str = str.replaceAll("\\$lName\\$", lowerCaseFirst(name));
        

        double d = (double)(Math.random()*1000000000000000000L);
        long l = Math.round(d);
        str = str.replaceAll("\\$uid\\$", String.valueOf(l)+"L");

        return str;
    }
}
