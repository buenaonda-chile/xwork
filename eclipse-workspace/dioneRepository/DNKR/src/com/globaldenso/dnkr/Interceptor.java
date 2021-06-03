package com.globaldenso.dnkr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.globaldenso.dnkr.constant.DnkrConstans;

public class Interceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			if (null == request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_SETUP) ||
				"INITIALIZE" == request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_SETUP)) {
				
				request.getSession().setAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_PGM_ID, ServletRequestUtils.getStringParameter(request, "pgmId"));
				request.getSession().setAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_COMPANY_CODE, ServletRequestUtils.getStringParameter(request, "company"));
				//마이플렛폼 기본컨텐츠와 팝업컨텐츠 분계 - 2019.05.08 JHB
				request.getSession().setAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_PGM_MODE, ServletRequestUtils.getStringParameter(request, "mode"));
				String pgmMode= request.getSession().getAttribute(DnkrConstans.ATTRIB_KEY_MIPLATFORM_PGM_MODE).toString();				
				//System.out.println("modeType="+pgmMode);
				/*
				if("MI".equals(pgmMode)){
					System.out.println("modeType=MI=="+pgmMode);
					response.sendRedirect("/WAN002MiPlatform/init.do");
				}else{
					System.out.println("modeType=MIPOP=="+pgmMode);
					response.sendRedirect("/WAN002MiPlatform/init.do");
				}
				*/
				response.sendRedirect("/WAN002MiPlatform/init.do");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
}
