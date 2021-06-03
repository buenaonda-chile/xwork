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

import com.globaldenso.ai.miyabi.token.annotation.Token;
import com.globaldenso.dnkr.JsonView;
import com.globaldenso.dnkr.business.service.OrderDayShipQtyCheckListService;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.OrderDayShipQtyCheckListDomain;
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
@RequestMapping(value = "/ajaxOrderDayShipQtyCheckList")
public class AjaxOrderDayShipQtyCheckListController {

    /**
     * [KR] 서열형 일일출하및수주량 CHECK LIST서비스 <br> 
     * [EN] <br>
     * [JP] <br>    
     */
    @Autowired
    private OrderDayShipQtyCheckListService orderDayShipQtyCheckListService;

    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public AjaxOrderDayShipQtyCheckListController() {
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
        List<? extends OrderDayShipQtyCheckListDomain> domainlist = null;

        OrderDayShipQtyCheckListDomain criteria = new OrderDayShipQtyCheckListDomain();
        
        domainlist = orderDayShipQtyCheckListService.searchByCondition(criteria);

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
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response)
        throws Exception{

    	JSONObject jsonObj = new JSONObject();

        String getSelchk = ServletRequestUtils.getStringParameter(request, "getSelchk");
        String getComps = ServletRequestUtils.getStringParameter(request, "getComps");        
        String getGcomps = ServletRequestUtils.getStringParameter(request, "getGcomps");        
        String getChldt = ServletRequestUtils.getStringParameter(request, "getChldt");
        String getPyvnd1 = ServletRequestUtils.getStringParameter(request, "getPyvnd1");
        String getPyvnd2 = ServletRequestUtils.getStringParameter(request, "getPyvnd2");
        
        int getChkcnt = ServletRequestUtils.getIntParameter(request, "getChkcnt");
        String getChkdt = ServletRequestUtils.getStringParameter(request, "getChkdt");
        

        OrderDayShipQtyCheckListDomain criteria = new OrderDayShipQtyCheckListDomain();
        criteria.setSelchk(getSelchk);
        criteria.setComps(getComps);
        criteria.setGcomps(getGcomps);
        criteria.setChldt(getChldt);
        criteria.setPyvnd1(getPyvnd1);
        criteria.setPyvnd2(getPyvnd2);

        CommonDb2Domain empInfo = UxisUtil.getDB2Lib(getComps);
        
        criteria.setLib1(empInfo.getLib1());
        criteria.setLib2(empInfo.getLib2());

        
        // 1.
        List<? extends OrderDayShipQtyCheckListDomain> listMST040PF_HOUSE = orderDayShipQtyCheckListService.selectMST040PF_HOUSE(criteria);
        
        String arrHouse = "('";
        for (int i=0; i< listMST040PF_HOUSE.size(); i++) {
        	OrderDayShipQtyCheckListDomain houseDomain = (OrderDayShipQtyCheckListDomain) listMST040PF_HOUSE.get(i);

    		if(i == listMST040PF_HOUSE.size()-1){
    			arrHouse = arrHouse + houseDomain.getMajcd_h() + "')";
    		}else{
    			arrHouse = arrHouse + houseDomain.getMajcd_h() + "','";
    		}
        }
        
        criteria.setHouse(arrHouse);

        // 2.
        List<? extends OrderDayShipQtyCheckListDomain> listSPDE141Q_142PF = orderDayShipQtyCheckListService.selectSPDE141Q_142PF(criteria);
        List<? extends OrderDayShipQtyCheckListDomain> listSPDE141Q_148PF = orderDayShipQtyCheckListService.selectSPDE141Q_148PF(criteria);
        
        if(listSPDE141Q_142PF.size() > 0) {
        	OrderDayShipQtyCheckListDomain tempDomain = (OrderDayShipQtyCheckListDomain) listSPDE141Q_142PF.get(0);
    		
        	criteria.setPyvnd(tempDomain.getPyvnd());
        	criteria.setMakdt(tempDomain.getChldt());	//기준일자
        	criteria.setChkcnt(getChkcnt);	//리턴수

        	List<? extends OrderDayShipQtyCheckListDomain> listSAL100_SE = orderDayShipQtyCheckListService.selectSAL100_SE(criteria);
        	
            jsonObj.put("checkList", listSPDE141Q_142PF);
            jsonObj.put("checkTitle", listSAL100_SE);
        }
        else {
            jsonObj.put("checkList", "");
            jsonObj.put("checkTitle", "");
        }
        
        if(listSPDE141Q_148PF.size() > 0) {
        	OrderDayShipQtyCheckListDomain tempDomain = (OrderDayShipQtyCheckListDomain) listSPDE141Q_148PF.get(0);
        	
        	criteria.setPyvnd(tempDomain.getPyvnd());
        	criteria.setChkdt(getChkdt);	//시작일자 PARAM
        	criteria.setChkcnt(getChkcnt);	//리턴수
        	criteria.setStddt(tempDomain.getChldt());	//시작일자

        	List<? extends OrderDayShipQtyCheckListDomain> listMST090PF = orderDayShipQtyCheckListService.selectMST090PF(criteria);

            jsonObj.put("errorList", listSPDE141Q_148PF);
            jsonObj.put("errorTitle", listMST090PF);
        }
        else {
            jsonObj.put("errorList", "");
            jsonObj.put("errorTitle", "");
        }
		
        //response.setContentType("text/html;charset=utf-8");
        //response.getWriter().print(jsonObj.toJSONString());
        //return;
   
        ModelAndView mv = new ModelAndView(new JsonView());
        mv.addObject("jsonString", jsonObj.toString());
        return mv;
    }
}