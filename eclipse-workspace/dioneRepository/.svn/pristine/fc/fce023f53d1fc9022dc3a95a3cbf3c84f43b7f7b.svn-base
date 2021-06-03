package com.globaldenso.dnkr.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.RelationClsService;
import com.globaldenso.dnkr.business.service.RelationLocService;
import com.globaldenso.dnkr.business.service.RelationTeamService;

/**
 * [KR] 사원 추가 컨트롤러<br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/WAB002EmpRltn") 
public class WAB002EmpRltnController {

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] 사원부 관리 서비스 <br>     
     */
    @Autowired
    private RelationClsService clsService;
    
    /**
     * [KR] 사원장 관리 서비스 <br>     
     */
    @Autowired
    private RelationLocService locService;
    
    /**
     * [KR] 사원부서(팀) 관리 서비스 <br>     
     */
    @Autowired
    private RelationTeamService teamService;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public WAB002EmpRltnController() 
    {
    }
    
    
    /**
     * [KR] 사용자정보 입력화면<br>     
     * 
     * @throws Exception Exception
     */
    @Scheduled(cron = "15 10 * * * *")
    public void init() throws Exception {
        System.out.println("======================");
    }
    
}
