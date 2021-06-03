/*
 * Project : dnkr
 *
 * $Id$
 *
 * Copyright (c) 2017 DENSO IT SOLUTIONS. All rights reserved.
 */
package com.globaldenso.dnkr.presentation.controller.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globaldenso.ai.core.bundle.MessageSources;
import com.globaldenso.ai.core.message.MessageManager;
import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.PrivateAuthDomain;
import com.globaldenso.dnkr.uxis.UxisStringUtil;

/**
 * [KO] <br>
 * [EN] <br>
 * [JP] <br>
 * 
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxEmp")
public class AjaxEmpController {

    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private EmpService empService;
    
    /**
     * [KR] 사원관리 서비스 <br>     
     */
    @Autowired
    private PrivateAuthService privateAuthService;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxEmpController() {
        //no process
    }
    
    
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST})
//    @Token(save = true)
    public void init(HttpServletRequest request, HttpServletResponse response)  throws Exception {
        
        //ModelAndView mv = new ModelAndView();
        
        String tabId = ServletRequestUtils.getStringParameter(request, "tabId");
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("{result:'OK'}");
        return;
    }
    /**
     * [KR] <br>     
     * 
     * @param request   HttpServletRequest
     * @param response  HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/teamName", method = {RequestMethod.GET, RequestMethod.POST})
//    @Token(save = true)
    public void find_teamname(HttpServletRequest request, HttpServletResponse response)  throws Exception {
        
        //System.out.println("test....+++++++++++++++++");
        JSONObject jsonObj = new JSONObject();
        EmpDomain empDomain = new EmpDomain();
        List<EmpDomain> empList = null;
        EmpDomain teamName = null;

        String teamCode = ServletRequestUtils.getStringParameter(request, "teamCode");

        empDomain.setTeamCode(teamCode);
        teamName = empService.getTeamName(empDomain);

        jsonObj.put("result", teamName.getRelName());
        
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
    
    
       /**
        * [KO] 공통코드 삭제.<br>
        * [EN] Main processing<br>
        * [EN] Delete from the DB the information displayed on the screen.<br>
        * [JP] 社員削除処理<br>
        * [JP] 画面上で選択された社員情報をDBから削除します。<br>
        * 
        * @param request HttpServletRequest
        * @param response HttpServletResponse
        * @throws Exception Exception
        */
    @RequestMapping(value = "/duplicateCheck", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAB001EmpSearch/init.do")
    public void duplicateCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
           
           /**
            * <pre>
            * 1.[KO] 권한 삭제 처리<br>
            *   [KO]   화면에서 선택된 권한을 DB에서 삭제합니다.<br>
            * 1.[EN] <br>
            *   [EN] <br>
            *   [JP]
            * </pre>
            */
        //System.out.println("AjaxEmp/duplicateCheck start");

        JSONObject jsonObj = new JSONObject();
        EmpDomain empDomain = new EmpDomain();

        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");
        String empId = ServletRequestUtils.getStringParameter(request, "empId");
        String rtnMsg = "";
        List<EmpDomain> empList = null;

        if(empNumber != null){
            empDomain.setEmpNumber(empNumber);
            empList = empService.searchByCondition(empDomain);
            if(!empList.isEmpty()) {
                jsonObj.put("errMsg", "중복사번이 존재합니다.");
            }
        }else if (empId != null) {

            rtnMsg = "";
            empDomain.setEmpId(empId);
            empList = empService.searchByCondition(empDomain);
            if(!empList.isEmpty()) {
                jsonObj.put("errMsg", "중복아이디가 존재합니다.");
            }
        }

        if(UxisStringUtil.isEmpty(empList)) {
            jsonObj.put("result", DnkrConstans.RESULT_OK);
        }
       
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
       
       /**
        * [EN] Main processing<br>
        * [EN] Register to DB information you have modified the screen.<br>
        * [JP] メイン処理<br>
        * [JP] 画面で変更した情報をDBに登録します。<br>
        * 
        * @param request HttpServletRequest
        * @param response HttpServletResponse
        * @throws Exception Exception
        */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ErrorBack(viewName = "forward:/WAB001EmpSearch/init.do")
//       @Token(check = true, save = true)
    public void update(HttpServletRequest request, HttpServletResponse response) throws 
               Exception {
           
           /**
            * <pre>
            * 1.[EN] Employee update process.
            *   [EN]   I update an employee with DB by input contents. 
            *   [JP] 社員更新処理
            *   [JP]  ・取得したフォームの部署番号から部署名を取得する
            *   [JP]       ・部署名が取得できなかったとき
            *   [JP]           ・存在しない部署として例外を返す。
            *   [JP]  ・取得したフォームの上司社員番号から社員情報を取得する
            *   [JP]       ・社員情報が取得できなかったとき
            *   [JP]           ・存在しない上司社員番号として例外を返す。
            *   [JP]  ・給料がNULLでない場合
            *   [JP]       ・給料が最低賃金より小さい場合
            *   [JP]           ・警告例を返す。
            *   [JP]  ・取得したフォームに最終更新者をセットする
            *   [JP]  ・取得したフォームの内容で社員情報を更新する。
            *   [JP]  ・更新完了メッセージをMessageManagerにセットする
            *   [JP]  ・更新画面を表示する。
            * </pre>
            */

        //System.out.println("ajaxEmp/update start");
        JSONObject jsonObj = new JSONObject();

        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");
        String empPwd = ServletRequestUtils.getStringParameter(request, "empPwd");
           
        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpNumber(empNumber);
        empDomain.setEmpPwd(empPwd);
        try {
            empService.update(empDomain);
            jsonObj.put("result", DnkrConstans.RESULT_OK);
        } catch (Exception e) {
            jsonObj.put("errMsg", "잠시후 시도해 주세요");
            System.out.println("잠시후 시도해 주세요");
        }
       
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return; 
    }
    
    /**
     * [KO] 공통코드 삭제.<br>
     * [EN] Main processing<br>
     * [EN] Delete from the DB the information displayed on the screen.<br>
     * [JP] 社員削除処理<br>
     * [JP] 画面上で選択された社員情報をDBから削除します。<br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAB001EmpSearch/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /**
         * <pre>
         * 1.[KO] 권한 삭제 처리<br>
         *   [KO]   화면에서 선택된 권한을 DB에서 삭제합니다.<br>
         * 1.[EN] <br>
         *   [EN] <br>
         *   [JP]
         * </pre>
         */

        //System.out.println("ajaxEmp/delete start");
        JSONObject jsonObj = new JSONObject();

        String empNumber = ServletRequestUtils.getStringParameter(request, "empNumber");

        PrivateAuthDomain privateAuthDomain = new PrivateAuthDomain();
        privateAuthDomain.setEmpNumber(empNumber);
        int count = privateAuthService.delete(privateAuthDomain);

        EmpDomain empDomain = new EmpDomain();
        empDomain.setEmpNumber(empNumber);
        int countEmp = empService.delete(empDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);
        MessageManager.setInformation("SMPL-I0-0002", new Object[] {
                MessageSources.getInstance().value("info.code"), 
                String.valueOf(count)});
    
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
    
    /**
     * [KO] DB2 사원정보 리스트 조회(ajax)
     * [EN] <br>
     * [JP] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @return ModelAndView 
     * @throws Exception Exception
     */
    @RequestMapping(value = "/getDb2empList", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAB001EmpSearch/init.do")
    public ModelAndView getDb2empList(HttpServletRequest request) throws Exception {
        
        /**
         * <pre>
         * 1.[KO] DB2 사원정보<br>
         * 1.[EN] <br>
         *   [EN] <br>
         *   [JP]
         * </pre>
         */

        //System.out.println("ajaxEmp/delete start");
        ModelAndView model = new ModelAndView(new JsonView());
        JSONObject jsonObj = new JSONObject();
        String result = DnkrConstans.RESULT_N;

        String pData = ServletRequestUtils.getStringParameter(request, "pData");

        EmpDb2Domain empInfo = (EmpDb2Domain)request.getSession().getAttribute("ACCOUNT_DB2");
        
        EmpDb2Domain criteria = new EmpDb2Domain();
        criteria.setPlantCd(empInfo.getPlantCd());
        criteria.setUserId(pData);
        criteria.setMcode("10073"); //MCODE=(10073 )예비품        (10083)설비보전이력
        
        List<EmpDb2Domain> list = null;
        System.out.println("11");
        try {
            System.out.println("22");
            list = empService.selectOGMUserID(criteria);
            System.out.println("33");
        } catch(Exception e) {
            System.out.println("error");
            e.printStackTrace();   
        }
        
        if(list != null) {
            result = DnkrConstans.RESULT_Y;
            jsonObj.put("list", list); 
        }
        
        jsonObj.put("result", result);
        model.addObject("jsonString", jsonObj.toString());
        return model;
    }
}
