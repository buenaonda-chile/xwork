package com.globaldenso.dicas.security.web.authentication;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.exception.ApplicationException;
import egovframework.rte.fdl.string.EgovStringUtil;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

public class CustomUsernamePasswordAuthenticationFilter extends
    AbstractAuthenticationProcessingFilter {

  public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";
  public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";
  public static final String SPRING_SECURITY_FORM_SERVICE_TYPE_KEY = "servicetype";

  private String usernameParameter = "username";
  private String passwordParameter = "password";
  private String servicetypeParameter = "servicetype";

  private boolean postOnly = false;

  public CustomUsernamePasswordAuthenticationFilter() {
    super(new AntPathRequestMatcher("/j_spring_security_check", "GET"));
    this.setRequiresAuthenticationRequestMatcher(
        new AntPathRequestMatcher("/j_spring_security_check"));
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {

    String username = this.obtainUsername(request);
    String password = this.obtainPassword(request);
    String servicetype = this.obtainServicetype(request);

    if (username == null) {
      username = "";
    }

    if (password == null) {
      password = "";
    }

    if (servicetype == null) {
      servicetype = "";
    }

    username = username.trim();
    servicetype = servicetype.trim();

    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
        username, password);

    this.setDetails(request, authRequest);
    Authentication authentication = null;

    try {
      authentication = this.getAuthenticationManager().authenticate(authRequest);
    } catch (AuthenticationException ex) {
      if (ex.getCause() instanceof SQLException || ex.getCause() instanceof InvalidResultSetAccessException)
        throw new AuthenticationServiceException(MessageSources.getInstance().value("JdbcDaoImpl.notFound"));
      else
        throw ex;
    } catch (Exception ex) {
      throw new AuthenticationServiceException(MessageSources.getInstance().value("JdbcDaoImpl.notFound"));
    }

    return authentication;
  }

  protected String obtainPassword(HttpServletRequest request) {
    return request.getParameter(this.passwordParameter);
  }

  protected String obtainUsername(HttpServletRequest request) {
    return request.getParameter(this.usernameParameter);
  }

  protected String obtainServicetype(HttpServletRequest request) {
    return request.getParameter(this.servicetypeParameter);
  }

  protected void setDetails(HttpServletRequest request,
      UsernamePasswordAuthenticationToken authRequest) {
    authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
  }

  public void setUsernameParameter(String usernameParameter) {
    Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
    this.usernameParameter = usernameParameter;
  }

  public void setPasswordParameter(String passwordParameter) {
    Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
    this.passwordParameter = passwordParameter;
  }

  public void setServicetypeParameter(String servicetypeParameter) {
    Assert.hasText(servicetypeParameter, "servicetype parameter must not be empty or null");
    this.servicetypeParameter = servicetypeParameter;
  }

  public void setPostOnly(boolean postOnly) {
    this.postOnly = postOnly;
  }

  public final String getUsernameParameter() {
    return this.usernameParameter;
  }

  public final String getPasswordParameter() {
    return this.passwordParameter;
  }

  public final String getServicetypeParameter() {
    return this.servicetypeParameter;
  }
}
