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

import com.globaldenso.ai.miyabi.errorback.annotation.ErrorBack;
import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.business.service.FileUploadParameterMstService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.FileUploadParameterMstDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.uxis.UxisUtil;
import com.globaldenso.dnkr.domain.EmpDb2Domain;

/**
 * [KO] ajax처리 컨트롤러를 정의하는 클래스.<br>
 * [EN] The class defines the controls ajax processing .<br>
 * [JP] <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Controller
@RequestMapping(value = "/ajaxFileUploadParameterMst")
public class AjaxFileUploadParameterMstController {

    /**
     * [KR] 파일업로드파라메터관리 서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private FileUploadParameterMstService fileUploadParameterMstService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxFileUploadParameterMstController() {
        // no process
    }
    
    
    /**
     * [KO] 조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/init", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void init(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

        JSONObject jsonObj = new JSONObject();
        
        /*
        List<? extends FileUploadParameterMstDomain> domainlist = null;

        FileUploadParameterMstDomain criteria = new FileUploadParameterMstDomain();
        
        domainlist = fileUploadParameterMstService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }
        */
        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }
    
    /**
     * [KO] 조회.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
    @Token(save = true)
    public void search(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();

        String getTplid = ServletRequestUtils.getStringParameter(request, "getTplid");

        List<? extends FileUploadParameterMstDomain> domainlist = null;

        FileUploadParameterMstDomain criteria = new FileUploadParameterMstDomain();
        criteria.setTplid(getTplid);
        
        domainlist = fileUploadParameterMstService.searchByCondition(criteria);

        if(domainlist != null) {
            jsonObj.put("list", domainlist);
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj.toJSONString());
        return;
    }

    /**
     * [KO] 삭제.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAN021FileUploadParameterMst/init.do")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
        JSONObject jsonObj = new JSONObject();
        
        String delTplid = ServletRequestUtils.getStringParameter(request, "tplid");
        String delColno = ServletRequestUtils.getStringParameter(request, "colno");
        String delColmn = ServletRequestUtils.getStringParameter(request, "colmn");
        
        //존재하는지 체크
        FileUploadParameterMstDomain cntDomain = new FileUploadParameterMstDomain();
        cntDomain.setTplid(delTplid);
        cntDomain.setColno(delColno);
        cntDomain.setColmn(delColmn);
        //cntDomain.setLib1(empInfo.getLib1());
        //cntDomain.setLib2(empInfo.getLib2());
        int cnt = fileUploadParameterMstService.searchCount(cntDomain);
        
        if(cnt == 0) {        	 
            //jsonObj.put("errMsg", "삭제불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_DEL_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        }

        FileUploadParameterMstDomain delDomain = new FileUploadParameterMstDomain();
        delDomain.setTplid(delTplid);
        delDomain.setColno(delColno);
        delDomain.setColmn(delColmn);
        //delDomain.setLib1(empInfo.getLib1());
        //delDomain.setLib2(empInfo.getLib2());
        fileUploadParameterMstService.delete(delDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }

    /**
     * [KO] 추가.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = "forward:/WAN021FileUploadParameterMst/init.do")
    public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonObj = new JSONObject();

        String insTplid = ServletRequestUtils.getStringParameter(request, "tplid");
        String insColno = ServletRequestUtils.getStringParameter(request, "colno");
        String insColmn = ServletRequestUtils.getStringParameter(request, "colmn");        
        String insComnt = ServletRequestUtils.getStringParameter(request, "comnt");
        String insReqyn = ServletRequestUtils.getStringParameter(request, "reqyn");
        String insStype = ServletRequestUtils.getStringParameter(request, "stype");
        String insLengh = ServletRequestUtils.getStringParameter(request, "lengh");
        
        //존재하는지 체크
        FileUploadParameterMstDomain cntDomain = new FileUploadParameterMstDomain();
        cntDomain.setTplid(insTplid);
        cntDomain.setColno(insColno);
        cntDomain.setColmn(insColmn);
        //cntDomain.setLib1(empInfo.getLib1());
        //cntDomain.setLib2(empInfo.getLib2());
        int cnt = fileUploadParameterMstService.searchCount(cntDomain);
        
        if(cnt > 0) {
            //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_INS_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;      	
        }        

        FileUploadParameterMstDomain insDomain = new FileUploadParameterMstDomain();
        insDomain.setTplid(insTplid);
        insDomain.setColno(insColno);
        insDomain.setColmn(insColmn);
        insDomain.setComnt(insComnt);
        insDomain.setReqyn(insReqyn);
        insDomain.setStype(insStype);
        insDomain.setLengh(insLengh);
        //insDomain.setLib1(empInfo.getLib1());
        //insDomain.setLib2(empInfo.getLib2());
        fileUploadParameterMstService.create(insDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
        
    }
    
    /**
     * [KO] 수정.<br>
     * [EN] <br>
     * [JP] <br>
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws Exception Exception
     */
    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    @ErrorBack(viewName = ".tiles.page.WAN021")
    public void update(HttpServletRequest request, HttpServletResponse response) 
        throws Exception {

        JSONObject jsonObj = new JSONObject();

        String updTplid = ServletRequestUtils.getStringParameter(request, "tplid");
        String updColno = ServletRequestUtils.getStringParameter(request, "colno");
        String updColmn = ServletRequestUtils.getStringParameter(request, "colmn");        
        String updComnt = ServletRequestUtils.getStringParameter(request, "comnt");
        String updReqyn = ServletRequestUtils.getStringParameter(request, "reqyn");
        String updStype = ServletRequestUtils.getStringParameter(request, "stype");
        String updLengh = ServletRequestUtils.getStringParameter(request, "lengh");
        
        String updOldTplid = ServletRequestUtils.getStringParameter(request, "oldTplid");
        String updOldColno = ServletRequestUtils.getStringParameter(request, "oldColno");
        String updOldColmn = ServletRequestUtils.getStringParameter(request, "oldColmn");
               
        //존재하는지 체크
        FileUploadParameterMstDomain cntDomain = new FileUploadParameterMstDomain();   
        cntDomain.setTplid(updTplid);
        cntDomain.setColno(updColno);
        cntDomain.setColmn(updColmn);        
        cntDomain.setOldTplid(updOldTplid);
        cntDomain.setOldColno(updOldColno);
        cntDomain.setOldColmn(updOldColmn);
        //cntDomain.setLib1(empInfo.getLib1());
        //cntDomain.setLib2(empInfo.getLib2());  
        int cnt2 = fileUploadParameterMstService.searchCount2(cntDomain);   
        
        if(cnt2 == 0) {
            //jsonObj.put("errMsg", "수정불가(미 등록된 자료입니다.)");
        	jsonObj.put("errMsg", "LN_UPD_CHK1");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print(jsonObj);
            return;
        } else {
        	if(!(updTplid.equals(updOldTplid) && updColno.equals(updOldColno) && updColmn.equals(updOldColmn))) {
	        	int cnt = fileUploadParameterMstService.searchCount(cntDomain);        	
	        	if(cnt > 0) {
	                //jsonObj.put("errMsg", "추가불가(이미 등록된 자료입니다.)");
	        		jsonObj.put("errMsg", "LN_UPD_CHK2");
	                response.setContentType("text/html;charset=utf-8");
	                response.getWriter().print(jsonObj);
	                return;
	            }
        	}
        }   

        FileUploadParameterMstDomain updDomain = new FileUploadParameterMstDomain();
        updDomain.setTplid(updTplid);
        updDomain.setColno(updColno);
        updDomain.setColmn(updColmn);
        updDomain.setComnt(updComnt);
        updDomain.setReqyn(updReqyn);
        updDomain.setStype(updStype);
        updDomain.setLengh(updLengh);
        updDomain.setOldTplid(updOldTplid);
        updDomain.setOldColno(updOldColno);
        updDomain.setOldColmn(updOldColmn);
        //updDomain.setLib1(empInfo.getLib1());
        //updDomain.setLib2(empInfo.getLib2());    
        fileUploadParameterMstService.update(updDomain);

        jsonObj.put("result", DnkrConstans.RESULT_OK);        
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(jsonObj);
        return;
    }
}
