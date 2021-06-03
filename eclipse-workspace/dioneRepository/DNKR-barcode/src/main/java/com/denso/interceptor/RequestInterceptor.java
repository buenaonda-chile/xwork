package com.denso.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.util.UrlPathHelper;

public class RequestInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);


	private UrlPathHelper urlPathHelper = new UrlPathHelper();

	private PathMatcher pathMatcher = new AntPathMatcher();
	
	/** excludes */
	private Set<String> excludes = new HashSet<String>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		/*if (!isExcluded(request)){
			PlatformRequest pReq 	= new PlatformRequest(request, "UTF-8");
			pReq.receiveData();	
			HashMap<String, String> pData = DataConverter.getMiPlatformData(pReq);
			request.setAttribute("pData", pData);
		}*/
	
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) throws Exception {
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}

	/**
	 * 로깅에서 제외할 URL
	 */
	public void setExcludes(Set<String> excludes) {
		this.excludes = excludes;
	}

	/**
	 * 무시된 요청인지 검증한다.
	 * 
	 * @param request
	 *            {@link HttpServletRequest}
	 * @return true or false
	 */
	public boolean isExcluded(HttpServletRequest request) {
		final String path = urlPathHelper.getLookupPathForRequest(request);
		logger.debug("path: {}",path);
		if (!excludes.isEmpty()) {
			if (excludes.contains(path))
				return true;
			for (String urlMapping : excludes) {
//				logger.debug(urlMapping);
				if (pathMatcher.match(urlMapping, path))
					return true;
			}
		}
		return false;
	}
	

}
