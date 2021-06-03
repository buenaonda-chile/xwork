package com.globaldenso.dicas.security.common;

import egovframework.rte.fdl.security.userdetails.EgovUserDetails;
import egovframework.rte.fdl.security.userdetails.jdbc.EgovUsersByUsernameMapping;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class DicasSessionMapping extends EgovUsersByUsernameMapping implements Serializable {

  private static final long serialVersionUID = 5254331043152644232L;

  public DicasSessionMapping(DataSource dataSource, String userByUsernameQuery) {
    super(dataSource, userByUsernameQuery);
  }

  @Override
  protected EgovUserDetails mapRow(ResultSet resultSet, int i) throws SQLException {

    if(logger.isDebugEnabled()) {
      logger.debug("## DicasUserByUsernameMapping mapRow ##");
    }

    String password = resultSet.getString("password");
    boolean enabled = resultSet.getBoolean("enabled");

    String uniqId = resultSet.getString("user_id");
    String username = resultSet.getString("username");
    String email = resultSet.getString("email");
    String fstNm = resultSet.getString("fst_nm");
    String mdlNm = resultSet.getString("mdl_nm");
    String lstNm = resultSet.getString("lst_nm");

    String deptCd = resultSet.getString("dept_cd");
    String deptKoNm = resultSet.getString("dept_ko_nm");
    String deptEnNm = resultSet.getString("dept_en_nm");
    String deptJaNm = resultSet.getString("dept_ja_nm");

    String officeCd = resultSet.getString("office_cd");
    String officeNm = resultSet.getString("office_nm");


    // 세션 항목 설정
    LoginVO loginVO = new LoginVO() {{
      setUniqId(uniqId);
      setUsername(username);
      setEmail(email);
      setFstNm(fstNm);
      setMdlNm(mdlNm);
      setLstNm(lstNm);
      setDeptCd(deptCd);
      setDeptKoNm(deptKoNm);
      setDeptEnNm(deptEnNm);
      setDeptJaNm(deptJaNm);
      setOfficeCd(officeCd);
      setOfficeNm(officeNm);
    }};

    return new EgovUserDetails(username, password, enabled, loginVO);
  }
}
