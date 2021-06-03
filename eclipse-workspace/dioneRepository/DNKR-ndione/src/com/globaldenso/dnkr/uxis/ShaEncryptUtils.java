package com.globaldenso.dnkr.uxis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * SHA2 encoding
 * @author $Author$
 * @version $Revision$
 */
public class ShaEncryptUtils {
    /** log Create */
    protected static final Log logger = LogFactory.getLog(ShaEncryptUtils.class);

    /**    Constructor.    */
    public ShaEncryptUtils() {
    }
    
    /**
     * SHA2 encoding String (method 1)
     * @param strData   String
     * @return encode String
     */
    public static String encrypt(String strData) {
        if (strData == null || "".equals(strData)){
            return "";
        }
        StringBuffer sb = new StringBuffer();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(strData.getBytes());

            byte[] byteData = md.digest();

            //convert the byte to hex format method 1
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            logger.debug("encrypt오류발생");
        }
        
        return sb.toString();
    }

}
