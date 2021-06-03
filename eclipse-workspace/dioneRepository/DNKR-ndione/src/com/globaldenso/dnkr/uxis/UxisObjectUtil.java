package com.globaldenso.dnkr.uxis;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UxisObjectUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UxisObjectUtil.class);
	
	/**
	 * 입력된 오브젝트를 맵(해쉬맵)으로 만들어 반환한다.
	 * @param obj
	 * @return
	 */
	public static Map convertObjectToMap(Object obj) throws IOException, SQLException, Exception{
		Map map = new HashMap();
		try{
			Field[] fields = obj.getClass().getDeclaredFields();
			for(int i=0; i < fields.length; i++){
				fields[i].setAccessible(true);
				map.put(fields[i].getName(), fields[i].get(obj));
				//System.out.println(i+">"+fields[i].getName()+" : "+fields[i].get(obj));
			}
		}catch(SecurityException e){
			LOGGER.error("UxisObjectUtil > convertObjectToMap : {}", e.getMessage());
		}catch(NullPointerException e){
			LOGGER.error("UxisObjectUtil > convertObjectToMap : {}", e.getMessage());
		}catch(Exception e){
			LOGGER.error("UxisObjectUtil > convertObjectToMap : {}", e.getMessage());
		}
		return map;
	}
	
	
	/**
	 * 천번째 인자로 입력되는 맵을 두번째 인자에 해당하는 오브젝트로 변환하여 반환하다.<br>
	 * map과 object의 맴버 명이 일치해야 한다. 
	 * @param map
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Object convertMapToObject(Map<String, Object> map, Object obj) throws IOException, SQLException, Exception{
		String keyAttribute = null;
		String setMethodString = "set";
		String methodString = null;
		Iterator itr = map.keySet().iterator();
		
		while(itr.hasNext()){
			keyAttribute = (String) itr.next();
			
			methodString = setMethodString + keyAttribute.substring(0, 1).toUpperCase() + keyAttribute.substring(1);
			
			Method[] methods = obj.getClass().getDeclaredMethods();
			for(int i=0; i < methods.length; i++){
				
				
				if(methodString.equals(methods[i].getName())){
					//System.out.println(methods[i] + " >>>>>>>>>>>>>> " + map.get(keyAttribute) + " <<<<<<<<<<<<<<");
					String classType = methods[i].getGenericParameterTypes()[0].toString().split("\\s+")[1];
					if("java.lang.Integer".equals(classType)){
						methods[i].invoke(obj, UxisNumberUtil.nullConvertToInt(map.get(keyAttribute)));
					}else if("java.lang.Double".equals(classType)){
						methods[i].invoke(obj, UxisNumberUtil.nullConvertToDouble(map.get(keyAttribute)));
					}else if("java.lang.Long".equals(classType)){
						methods[i].invoke(obj, UxisNumberUtil.nullConvertToLong(map.get(keyAttribute)));
					}else if("java.lang.String".equals(classType)){
						methods[i].invoke(obj, map.get(keyAttribute));
					}
					
					/*Claddddss cddls = Cldddass.forName(methods[i].getGenericParameterTypes()[0].toString().split("\\s+")[1]);
					if(cls.isInstance(new Integer(0))){
						methods[i].invoke(obj, UxisNumberUtil.nullConvertToInt(map.get(keyAttribute)));
					}else if(cls.isInstance(new Double(0))){
						methods[i].invoke(obj, UxisNumberUtil.nullConvertToDouble(map.get(keyAttribute)));
					}else if(cls.isInstance(new Long(0))){
						methods[i].invoke(obj, UxisNumberUtil.nullConvertToLong(map.get(keyAttribute)));
					}else if(cls.isInstance(new String())){
						methods[i].invoke(obj, map.get(keyAttribute));
					}*/
				}
			}
		}
		return obj;
	}	
}
