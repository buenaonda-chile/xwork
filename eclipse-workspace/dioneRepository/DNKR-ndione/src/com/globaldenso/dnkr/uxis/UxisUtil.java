package com.globaldenso.dnkr.uxis;

import javax.servlet.http.HttpServletRequest;

import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;

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
    
    public static CommonDb2Domain getDB2Lib (String comps) {
    	
        CommonDb2Domain empInfo = new CommonDb2Domain();

    	// LIB 셋팅
    	if(comps.equals(DnkrConstans.COMPS_MASAN)) {
    		empInfo.setLib1(DnkrConstans.DNKE_LIB1);
    		empInfo.setLib2(DnkrConstans.DNKE_LIB2);
    	} else {
    		empInfo.setLib1(DnkrConstans.DNKA_LIB1);
    		empInfo.setLib2(DnkrConstans.DNKA_LIB2);
    	}
    	
    	return empInfo;
    	
    }
}
