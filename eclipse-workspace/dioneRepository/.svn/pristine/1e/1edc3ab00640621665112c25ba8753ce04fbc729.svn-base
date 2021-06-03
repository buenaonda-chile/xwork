package com.denso.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CopyOfLoginInterceptor extends HandlerInterceptorAdapter {

	public Logger logger = LoggerFactory.getLogger(getClass());
	
	private final static String NONE_SECURE_PROTOCOL = "http://";
	private final static String SECURE_PROTOCOL = "https://";
	
	@Autowired
	private Environment env;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		boolean isSecure = request.isSecure();
		
		// URI 체크
		logger.debug("##### pos0 requestURI:" + uri);
		if(uri.matches("(\\S)*/login(Proc)?$") || uri.matches("(\\S)*/logout(Proc)?$")){
			logger.debug("##### pos1");
			if( isDev() || isStage() || (isSecure && url.startsWith(SECURE_PROTOCOL)) ){
				logger.debug("##### pos2");
				return true;
			} else{
				logger.debug("##### pos3 redirect to:" + SECURE_PROTOCOL+serverName+(serverPort!=80 ? ":"+serverPort : "")+uri);
				response.sendRedirect(SECURE_PROTOCOL+serverName+(serverPort!=80 ? ":"+serverPort : "")+uri);
				return false;
			}
		} else{
			logger.debug("##### pos4");
			if ( !isProd() && isSecure && url.startsWith(SECURE_PROTOCOL) ) {
				logger.debug("##### pos5 redirect to:" + NONE_SECURE_PROTOCOL+serverName+(serverPort!=80 ? ":"+serverPort : "")+uri+(queryString != null ? "?"+queryString : ""));
                response.sendRedirect(NONE_SECURE_PROTOCOL+serverName+(serverPort!=80 ? ":"+serverPort : "")+uri+(queryString != null ? "?"+queryString : ""));
                return false;
            }
		}
		
		if (request.getSession().getAttribute("SESSION_MEMBER") == null) {
			logger.info("SESSION IS NULL");
			response.sendRedirect("/lifeware/login/login");
			return false;
		}
		
		/*// SESSION 체크
		logger.debug("##### pos6 loginedMember ID:" + (tblMember.getId()==null ? null : tblMember.getPwd()));
		if (loginedMember == null || loginedMember.getLoginUser() == null) {
			logger.debug("##### pos7");
			response.sendRedirect("/recruit_admin/login");
			return false;
		}*/
		
		logger.debug("##### pos8");
		return true;
	}
	
	private boolean isProd(){
		if(ObjectUtils.containsElement(env.getActiveProfiles(), "prod")) {
			return true;
		}
		return false;
	}
	
	private boolean isStage(){
		if(ObjectUtils.containsElement(env.getActiveProfiles(), "stage")) {
			return true;
		}
		return false;
	}
	
	private boolean isDev(){
		if(ObjectUtils.containsElement(env.getActiveProfiles(), "dev")) {
			return true;
		}
		return false;
	}
	
}
