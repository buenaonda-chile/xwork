package com.denso.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.denso.common.intf.Page;
import com.denso.common.vo.AjaxResult;
import com.denso.common.vo.PageVo;
import com.denso.model.TblBoard;
import com.denso.param.CodeInqueryParam;
import com.denso.param.NoticeParam;
import com.denso.service.intf.NoticeService;

@Controller
@RequestMapping(value="/notice")
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	// noticeType (뉴스/공지 관리 : news, press관리 : press, FAQ관리 : faq)
	@RequestMapping(value="/{noticeType}/list", method=RequestMethod.GET)
	public String getNoticeList(@PathVariable String noticeType,NoticeParam noticeParam, PageVo pageVo, boolean isResponseBodyData, Model model, HttpServletResponse response){
		
		noticeParam.setType(noticeType); // 게시판 타입
		
		Page<TblBoard> noticePage = noticeService.getNoticePage(noticeParam, pageVo.getPageable());
		
		model.addAttribute("noticePage", noticePage);
		model.addAttribute("pageVo", pageVo);
		model.addAttribute("noticeParam", noticeParam);
		
		// FAQ 게시판일 경우
		if(noticeType.equals("faq")){
			//model.addAttribute("pdtList", codeManager.getProductList(null));
			model.addAttribute("pdtList", "");
		}
		return "/notice/" + noticeType + "List.tiles";
	}
	
	@RequestMapping(value="/{noticeType}/detail", method=RequestMethod.GET)
	public String getNoticeDetail(@PathVariable String noticeType, @RequestParam(required=false) String seq, @RequestParam(required=false) String type, Model model){
		
		TblBoard noticeInfo = null; 
		if(seq != null){
			noticeInfo = noticeService.getNoticeInfo(seq);
		}
		model.addAttribute("noticeInfo", noticeInfo);
		model.addAttribute("type", type);
		return "/notice/" + noticeType + "Detail.tiles";
	}
	
	
	@RequestMapping(value="/{noticeType}/proc", method=RequestMethod.GET)
	public String noticeProcGet(@PathVariable String noticeType, @RequestParam(required=false) String seq, @RequestParam(required=false) String type, Model model){
		TblBoard noticeInfo = null;
		if(seq != null){
			noticeInfo = noticeService.getNoticeInfo(seq);
		}
		
		model.addAttribute("noticeInfo", noticeInfo);
		model.addAttribute("type", type);
		
		// FAQ 게시판일 경우
		if(noticeType.equals("faq")){
			// model.addAttribute("pdtList", codeManager.getProductList(null));
			
			model.addAttribute("pdtList", "");
			
			if(seq != null){
				//model.addAttribute("typeList", codeManager.getCodeMaster(noticeInfo.getGroupCode()).getList());
			} else {
				//model.addAttribute("typeList", codeManager.getCodeMaster(GrpCd.FAQSK.getGrpCd()).getList());	
			}
			model.addAttribute("typeList", "");
		}
		return "/notice/" + noticeType + "Insert.tiles";
	}
	
	// type (regist : 등록, update : 수정)
	@RequestMapping(value="/{noticeType}/proc", method=RequestMethod.POST)
	public ModelAndView noticeProcPost(@PathVariable String noticeType, @RequestParam(required=false) String type, NoticeParam noticeParam, Model model){
		
		noticeParam.setType(noticeType); // 게시판 타입
		noticeService.noticeProc(noticeParam.convertToTblBoard(), type);

		return new ModelAndView(new RedirectView("/notice/" + noticeType + "/list", true));
	}
	
	// code List 검색
	@RequestMapping(value="/{noticeType}/typeList", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult reqReputation(CodeInqueryParam regParam){
		AjaxResult ajaxResult = new AjaxResult();
		try {
			
			//ajaxResult.setResult(codeManager.getCodeMaster(regParam));
			ajaxResult.setResult("OK");
			ajaxResult.setCode(AjaxResult.SUCCESS_CODE);
			ajaxResult.setMsg("정상처리되었습니다.");
			
		} catch (Exception e) {
			ajaxResult.setCode(AjaxResult.FAIL_CODE);
			ajaxResult.setMsg("실패하였습니다.");
		}
		
		return ajaxResult;
	}
}
