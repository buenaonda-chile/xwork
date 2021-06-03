package com.denso.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringBeanAccessor {

	private static BeanFactory bf;
	
	@Autowired
	private BeanFactory _bf;
	
	@PostConstruct
	void init() {
		bf = _bf;
	}
	
	public static <T> T getBean(Class<T> requiredType) {
		return bf.getBean(requiredType);
	}
	
}
