package com.denso.util;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public class MybatisConfigurer {

	@Autowired
	private DataSource dataSource;
	
	private String configLocation;
	private String mapperLocations;
	
	
	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}
	
	public void setMapperLocations(String mapperLocations) {
		this.mapperLocations = mapperLocations;
	}
	
	@Bean
	public SqlSessionFactory _sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean obj = new SqlSessionFactoryBean();
		obj.setDataSource(dataSource);
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		obj.setConfigLocation(resolver.getResource(configLocation));
		
		Resource[] resources = resolver.getResources(mapperLocations);
		obj.setMapperLocations(resources);
		
		return obj.getObject();
	}
	
	@Bean
	public SqlSessionTemplate _sqlSession() throws Exception {
		return new SqlSessionTemplate(_sqlSessionFactory());
	}

}
