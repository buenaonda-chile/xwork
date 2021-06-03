package com.globaldenso.dicas.util;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;

public class NetworkUtil {

  public static boolean isAjax(HttpServletRequest httpServletRequest) {
    String requestedWithHeader = httpServletRequest.getHeader("X-Requested-With");
    return "XMLHttpRequest".equals(requestedWithHeader);
  }

  public static void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String browser = getBrowser(request);

    String dispositionPrefix = "attachment; filename=";
    String encodedFilename = null;

    if ("msie".equalsIgnoreCase(browser)) {
      encodedFilename = URLEncoder.encode(filename, "UTF-8").replace("\\+", "%20");
    } else if ("firefox".equalsIgnoreCase(browser)
        || "opera".equalsIgnoreCase(browser)) {
      encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
    } else if ("chrome".equalsIgnoreCase(browser)) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < filename.length(); i++) {
        char c = filename.charAt(i);
        if (c > '~') {
          sb.append(URLEncoder.encode("" + c, "UTF-8"));
        } else {
          sb.append(c);
        }
      }

      encodedFilename = sb.toString();
    } else {
      throw new IOException("Not Supported browser");
    }

    response.setHeader(HttpHeaders.CONTENT_DISPOSITION, dispositionPrefix + encodedFilename);

    if ("opera".equalsIgnoreCase(browser)) {
      response.setContentType("application/octet-stream;charset=UTF-8");
    }
  }

  public static String getBrowser(HttpServletRequest request) {

    String header = request.getHeader(HttpHeaders.USER_AGENT);
    if (header.indexOf("MSIE") > -1 || header.indexOf("Trident/") > 0) {
      return "MSIE";
    } else if (header.indexOf("Chrome") > -1) {
      return "Chrome";
    } else if (header.indexOf("Opera") > -1) {
      return "Opera";
    }

    return "Firefox";
  }
}
