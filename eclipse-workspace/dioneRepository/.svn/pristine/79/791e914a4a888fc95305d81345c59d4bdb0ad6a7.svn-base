package com.globaldenso.dnkr.uxis;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * Describe the outline of this class.
 * 
 * <p>
 * Describe the detail of this class.
 * </p>
 *
 * @author $Author$
 * @version $Revision$
 */
public class UxisUtil {

    /**
     * 생성자
     * Constructor.
     *
     */
    public UxisUtil() {
        // no process
    }
    
    /**
     * 
     * Describe the outline of the function for this method.
     * 
     * <p>
     * Describe the detail of the function for this method.
     * </p>
     * 
     * @param request HttpServletRequest
     * @return boolean
     */
    public static boolean isMobile(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        boolean mobile1 = userAgent.matches(".*(iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
        boolean mobile2 = userAgent.matches(".*(LG|SAMSUNG|Samsung).*");
        if(mobile1 || mobile2) {
            return true;
        }
        return false;
    }
}
