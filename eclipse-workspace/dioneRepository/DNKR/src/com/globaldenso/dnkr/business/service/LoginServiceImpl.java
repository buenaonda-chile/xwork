package com.globaldenso.dnkr.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.globaldenso.dnkr.integration.dao.LoginDao;

/**
 * [KR] 로그인 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    /**
     * [KR] 로그 관리 Dao <br>
     */
    @Autowired
    private LoginDao loginDao;
    
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public LoginServiceImpl() {
        // no process
    }
}
