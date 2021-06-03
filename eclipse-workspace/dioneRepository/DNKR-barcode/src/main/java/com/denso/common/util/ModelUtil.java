package com.denso.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;

public class ModelUtil {

	public static Map<String, Object> getParameterMap(Class<?> clazz, final Object model){
		final Map<String, Object> parameterMap = new HashMap<String, Object>();
		
		ReflectionUtils.doWithFields(clazz, new FieldCallback() {
			@Override
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				ReflectionUtils.makeAccessible(field);
				parameterMap.put(field.getName(), ReflectionUtils.getField(field, model));
			}
		}, new FieldFilter() {
			@Override
			public boolean matches(Field field) {
				if(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) 
					return false;
				return true;
			}
		});
		
		return parameterMap;
	}
	
}
