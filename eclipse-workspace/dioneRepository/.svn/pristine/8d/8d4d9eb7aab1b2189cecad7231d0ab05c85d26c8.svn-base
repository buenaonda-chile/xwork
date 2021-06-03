package com.globaldenso.dicas.security.authentication.encoding;

import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class CustomMessageDigestPasswordEncoder extends MessageDigestPasswordEncoder {

  public CustomMessageDigestPasswordEncoder(String algorithm) {
    super(algorithm);
  }

  public CustomMessageDigestPasswordEncoder(String algorithm, boolean encodeHashAsBase64)
      throws IllegalArgumentException {
    super(algorithm, encodeHashAsBase64);
  }

  @Override
  public boolean isPasswordValid(String encPass, String rawPass, Object salt) {

    HttpSession httpSession = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();

    salt = (String) salt;
//    salt = ((String) salt).substring(0, ((String) salt).indexOf("#@#")).trim();

    return super.isPasswordValid(encPass, rawPass, salt);
  }
}
