package com.globaldenso.dicas.util;

import com.globaldenso.dicas.business.dto.AtchmnflDto;
import com.globaldenso.dicas.business.service.AtchmnflService;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component("dicasFileMngUtil")
public class DicasFileMngUtil {

  private static final Logger LOGGER = LoggerFactory.getLogger(DicasFileMngUtil.class);

  public static final int BUFF_SIZE = 2048;

  public static void downFile(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    String downFileName = "";
    String orgFileName = "";

    if ((String) request.getAttribute("downFile") == null) {
      downFileName = "";
    } else {
      downFileName = (String) request.getAttribute("downFile");
    }

    if ((String) request.getAttribute("orginFile") == null) {
      orgFileName = "";
    } else {
      orgFileName = (String) request.getAttribute("orginFile");
    }

    orgFileName = orgFileName.replaceAll("\r", "").replaceAll("\n", "");

    File file = new File(DicasWebUtil.filePathBlackList(downFileName));

    if (!file.exists()) {
      throw new FileNotFoundException(downFileName);
    }

    if (!file.isFile()) {
      throw new FileNotFoundException(downFileName);
    }

    byte[] buffer = new byte[BUFF_SIZE]; //buffer size 2K.

    response.setContentType("application/x-msdownload");
    setDisposition(orgFileName, request, response);
    //response.setHeader("Content-Disposition:", "attachment; filename=" + new String(orgFileName.getBytes(), "UTF-8"));
    response.setHeader("Content-Transfer-Encoding", "binary");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");

    BufferedInputStream fin = null;
    BufferedOutputStream outs = null;

    try {
      fin = new BufferedInputStream(new FileInputStream(file));
      outs = new BufferedOutputStream(response.getOutputStream());
      int read = 0;

      while ((read = fin.read(buffer)) != -1) {
        outs.write(buffer, 0, read);
      }
    } finally {
      DicasResourceCloseHelper.close(outs, fin);
    }
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
