package com.denso.controller;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.denso.model.TblSJT;
import com.denso.service.intf.CSVOutputService;

@Controller
public class CSVOutputController {

	protected Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	CSVOutputService CSVOutputService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, HttpServletResponse response, Model model ) throws Exception{
		
		List<TblSJT> groupRlt = CSVOutputService.testGroup();
		
		List<String> monthList = getMonth();
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/test.csv"),"MS949"));
		
			writer.write("품목,");
			writer.write("CPRTN,");
			writer.write("ITDSC,");
			writer.write("BDYCD,");
			writer.write("CARCD,");
			writer.write("득의선코드,");
			writer.write("CUSNM,");
		
		for(String month: monthList){
			writer.write(month + "[수량]"+",[금액],");
		}
		
		String forwardKey  ="";
		
		List<TblSJT> taxqyList = new ArrayList<TblSJT>();
		int cnt = 0;
		int totalCnt = 1;
		for(TblSJT groupMap : groupRlt){
			
			String pspNo = String.valueOf(groupMap.getPspno());
			String pyvnd = String.valueOf(groupMap.getPyvnd());
			
			String key = pspNo + pyvnd;
			
			taxqyList.add(groupMap);
			
			if(cnt != 0 && !forwardKey.equals(key)){
				
				this.printData(taxqyList, writer, monthList, cnt);
			}
			
			if(totalCnt == groupRlt.size()){
				
				this.printData(taxqyList, writer, monthList, cnt);
			}
			
			forwardKey = pspNo + pyvnd;
			cnt++;
			totalCnt++;
		}
		writer.close();
		
		model.addAttribute("rltList", groupRlt);
		model.addAttribute("monthList", monthList);
		
		return "test/test";
	}
	
	private void printData(List<TblSJT> taxqyList, BufferedWriter writer, List<String> monthList, int cnt) throws Exception{
		TblSJT rltTt = taxqyList.get(0);
		
		writer.write("\r\n");
		writer.write(rltTt.getPspno());
		writer.write(","+setData(String.valueOf(rltTt.getCprtn())));
		writer.write(","+setData(String.valueOf(rltTt.getItdsc())));
		writer.write(","+setData(String.valueOf(rltTt.getBdycd())));
		writer.write(","+setData(String.valueOf(rltTt.getCarcd())));
		writer.write(","+setData(String.valueOf(rltTt.getPyvnd())));
		writer.write(","+setData(String.valueOf(rltTt.getCusnm())));
		
		for(String st : monthList){
			
			String taxqy = "0";
			String taxam = "0";
			
			for(TblSJT tt :taxqyList){
				if(rltTt.getPspno().equals(tt.getPspno()) && st.equals(tt.getTaxdtm())){
					taxqy = tt.getTaxqy();
					taxam = tt.getTaxam();
					break;
				}
			}
			writer.write("," + taxqy);
			writer.write("," + taxam);
			
		}	
		
		for(int i=(cnt-1); i >= 0; i--){
			taxqyList.remove(i);
		}
		cnt = 0;
	}
	
	
	private String setData(String temp){
		if(temp != null){
			temp = temp.replaceAll(",", "");
		}
		return temp;
	}
	private List<String> getMonth(){
		List<String> month = new ArrayList<String>();
		month.add("200201");
		month.add("200202");
		month.add("200203");
		month.add("200204");
		month.add("200205");
		month.add("200206");
		month.add("200207");
		month.add("200208");
		month.add("200209");
		month.add("200210");
		month.add("200211");
		month.add("200212");
		return month;
	}
	
}
