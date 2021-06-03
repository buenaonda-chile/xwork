package com.denso.common.dao;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.nio.charset.Charset;

public class SqlMapConfig {
    private static final SqlMapClient sqlMap1;
    private static final SqlMapClient sqlMap2;
    private static final SqlMapClient sqlMap3;
    private static final SqlMapClient sqlMap4;
    // for GATE
    private static final SqlMapClient sqlMap5;
    private static final SqlMapClient sqlMap6;
    //GATE KAC
    private static final SqlMapClient sqlMap7;
    //GATE KAS
    private static final SqlMapClient sqlMap8;
 
    //Duzon HR DB
    //private static final SqlMapClient sqlMap9;
    
    //KAC -BOJEN Repair DB
    private static final SqlMapClient sqlMap10;
    
    static {
        try {
        	Charset charset = Charset.forName("UTF-8");
        	Resources.setCharset(charset);
            String resource = "com/denso/common/dao/sqlMapConfig1.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlMap1 = SqlMapClientBuilder.buildSqlMapClient(reader);
            //reader.close();
            //System.out.println("dao3");
            resource = "com/denso/common/dao/sqlMapConfig2.xml";
            reader = Resources.getResourceAsReader(resource);
            sqlMap2 = SqlMapClientBuilder.buildSqlMapClient(reader);
            
            resource = "com/denso/common/dao/sqlMapConfig3.xml";
            reader = Resources.getResourceAsReader(resource);
            sqlMap3 = SqlMapClientBuilder.buildSqlMapClient(reader);
            
            resource = "com/denso/common/dao/sqlMapConfig4.xml";
            reader = Resources.getResourceAsReader(resource);
            sqlMap4 = SqlMapClientBuilder.buildSqlMapClient(reader);
            
            resource = "com/denso/common/dao/sqlMapConfig5.xml";
            reader = Resources.getResourceAsReader(resource);
            sqlMap5 = SqlMapClientBuilder.buildSqlMapClient(reader);
            
            resource = "com/denso/common/dao/sqlMapConfig6.xml";
            reader = Resources.getResourceAsReader(resource);
            sqlMap6 = SqlMapClientBuilder.buildSqlMapClient(reader);
            
            resource = "com/denso/common/dao/sqlMapConfig7.xml";
            reader = Resources.getResourceAsReader(resource);
            sqlMap7 = SqlMapClientBuilder.buildSqlMapClient(reader);
            
            resource = "com/denso/common/dao/sqlMapConfig8.xml";
            reader = Resources.getResourceAsReader(resource);
            sqlMap8 = SqlMapClientBuilder.buildSqlMapClient(reader);
            
/*
            resource = "com/denso/common/dao/sqlMapConfig9.xml";
            reader = Resources.getResourceAsReader(resource);
            sqlMap9 = SqlMapClientBuilder.buildSqlMapClient(reader);
*/            
            resource = "com/denso/common/dao/sqlMapConfig10.xml";
            reader = Resources.getResourceAsReader(resource);
            sqlMap10 = SqlMapClientBuilder.buildSqlMapClient(reader);
            
         } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing class. Cause:" + e);
         }
    }

    public static SqlMapClient getSqlMapInstance(int num) {
    	if(num==1) return sqlMap1;
    	else if(num==2) return sqlMap2;
    	else if(num==3) return sqlMap3;
    	else if(num==4) return sqlMap4;
    	else if(num==5) return sqlMap5;
    	else if(num==6) return sqlMap6;
    	else if(num==7) return sqlMap7;
    	else if(num==8) return sqlMap8;
    	//else if(num==9) return sqlMap9;
    	else if(num==10) return sqlMap10;
    	
    	//return sqlMap1;
    	return sqlMap1;
    }
}