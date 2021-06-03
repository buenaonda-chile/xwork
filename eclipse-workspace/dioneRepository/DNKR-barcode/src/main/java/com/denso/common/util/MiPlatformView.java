package com.denso.common.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.view.AbstractView;

import com.tobesoft.platform.PlatformConstants;
import com.tobesoft.platform.PlatformResponse;
import com.tobesoft.platform.data.ColumnInfo;
import com.tobesoft.platform.data.Dataset;
import com.tobesoft.platform.data.DatasetList;
import com.tobesoft.platform.data.PlatformData;
import com.tobesoft.platform.data.VariableList;


public class MiPlatformView extends AbstractView {

	protected Log log = LogFactory.getLog(this.getClass());
	
	protected VariableList miVariableList = new VariableList();
	protected DatasetList miDatasetList = new DatasetList();

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map model, HttpServletRequest request, HttpServletResponse response)
	        throws Exception {
		
		PlatformData platformData = new PlatformData(miVariableList, miDatasetList);
	
		Set set = model.keySet();		
		Iterator it=set.iterator();
		
		Dataset dataset = null;
		while(it.hasNext()){
			String key = (String)it.next();
			Object obj = model.get(key);
           
            if(obj instanceof List){
            	dataset =  new Dataset(key);    			
            	List list = (List)obj;
            	
            	if(list.size() > 0){
            		Map hp2 = (Map)list.get(0);
            		Set<String> ss = hp2.keySet();
            		for(String columnKey : ss){
            		dataset.addColumn(columnKey, ColumnInfo.COLUMN_TYPE_STRING, (short) 255); 
            		}	
            	}
            	
            	Iterator dataIt = list.iterator();
            	while(dataIt.hasNext()){
             		Map hp = (Map)dataIt.next();
            		
            		int ColCnt = dataset.getColumnCount();
            		int row = dataset.appendRow();
    				for (int j=0; j < ColCnt; j++){
    					if(hp.get(dataset.getColumnID(j))!= null)
    						dataset.setColumn(row, dataset.getColumnID(j) ,  hp.get(dataset.getColumnID(j)).toString());    					
    				}
            		
            	}
            	miDatasetList.add(dataset);
            }else if(obj instanceof Map){
            	dataset =  new Dataset(key);    			
            	Map map = (Map)obj;  		
            	
        		Set<String> ss = map.keySet();
        		for(String columnKey : ss){
        			dataset.addColumn(columnKey, ColumnInfo.COLUMN_TYPE_STRING, (short) 255); 
        		}	
            	            		
        		int ColCnt = dataset.getColumnCount();
        		int row = dataset.appendRow();
				for (int j=0; j < ColCnt; j++){
					if(map.get(dataset.getColumnID(j))!= null)
						dataset.setColumn(row, dataset.getColumnID(j) ,  map.get(dataset.getColumnID(j)).toString());	
            	}
            	miDatasetList.add(dataset);
            }else if(obj instanceof String){
  
            	miVariableList.add(key, (String)obj );
            }
		}



		

		try {

			new PlatformResponse(response, PlatformConstants.CHARSET_UTF8).sendData(platformData);

		} catch (IOException ex) {
			if (log.isErrorEnabled()) {
				log.error("Exception occurred while writing xml to MiPlatform Stream.", ex);
			}

			throw new Exception();
		}

	}
	

}