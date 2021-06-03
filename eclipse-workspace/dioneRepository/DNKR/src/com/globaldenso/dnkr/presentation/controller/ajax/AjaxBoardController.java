package com.globaldenso.dnkr.presentation.controller.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.dnkr.business.service.BoardService;
import com.globaldenso.dnkr.business.service.EmpService;
import com.globaldenso.dnkr.business.service.PrivateAuthService;
import com.globaldenso.dnkr.domain.BoardFileDomain;

/**
 * [KO] 공통코드의  ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing of common code (WAC015).<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxBoard")
public class AjaxBoardController {

    /**
     * [KR] 게시판 서비스 <br>     
     */
    @Autowired
    private BoardService boardService;

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
    public AjaxBoardController() {
        // no process
    }
    /**
     * [KO] 첨부파일삭제.<br>
     * [EN] Main processing<br>
     * [EN] Delete from the DB the information displayed on the screen.<br>
     * [JP] 社員削除処理<br>
     * [JP] 画面上で選択された社員情報をDBから削除します。<br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/fileDelete", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAC001BoardSearch/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        /**
         * <pre>
         * 1.[KO] 조직도 삭제 처리<br>
         *   [KO]   화면에서 선택된 조직도를 DB에서 삭제합니다.<br>
         * 1.[EN] <br>
         *   [JP] <br>
         * </pre>
         */

        //System.out.println("delete start");
        JSONObject jsonObj = new JSONObject();
        String fidx = ServletRequestUtils.getStringParameter(request, "fidx");
        BoardFileDomain domain = new BoardFileDomain();
        domain.setFidx(Integer.parseInt(fidx));
        int result = boardService.fileDelete(domain);

        response.setContentType("text/html;charset=utf-8");

        //System.out.println("result : " + result);
        
        jsonObj.put("result", result);
        response.getWriter().print(jsonObj);
        return;
    }
}
