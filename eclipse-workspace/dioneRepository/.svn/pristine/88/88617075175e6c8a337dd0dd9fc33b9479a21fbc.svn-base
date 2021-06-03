package com.globaldenso.dnkr.business.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globaldenso.ai.core.exception.ApplicationException;
import com.globaldenso.dnkr.constant.DnkrConstans;
import com.globaldenso.dnkr.domain.EmpDb2Domain;
import com.globaldenso.dnkr.domain.EmpDomain;
import com.globaldenso.dnkr.domain.NonOrderHostUpDomain;
import com.globaldenso.dnkr.domain.OrderCalendarDomain;
import com.globaldenso.dnkr.domain.OrderDaySaleCreateDomain;
import com.globaldenso.dnkr.domain.OrderDaySaleCreateDomain2;
import com.globaldenso.dnkr.domain.OrderHostUpDomain;
import com.globaldenso.dnkr.domain.db2.CommonDb2Domain;
import com.globaldenso.dnkr.integration.dao.NonOrderHostUpDao;
import com.globaldenso.dnkr.integration.dao.OrderDaySaleCreateDao;

/**
* [KR] 서열형 일일판매생성 서비스 구현 <br>
 *
 * @author $Author$
 * @version $Revision$
 */
@Service("orderDaySaleCreatekService")
public class OrderDaySaleCreateServiceImpl implements OrderDaySaleCreateService {

    /**
     * [KR] Dao 필드<br>
     * [EN] A field of OrderDaySaleCreateDao.<br>
     */
    @Autowired
    private OrderDaySaleCreateDao orderDaySaleCreateDao;        
    
    /**
     * [KR] Dao 필드<br>
     * [EN] A field of CustOrderTypeMstchDao.<br>
     */
    @Autowired
    private NonOrderHostUpDao nonOrderHostUpDao;
    
    
    /**
     * [EN] Default constructor.<br>
     * [JP] デフォルトコンストラクタ。<br>
     */
    public OrderDaySaleCreateServiceImpl() {
        // no process
    }

    public boolean procCreate(HashMap<String, String> param, HttpServletRequest request) throws ApplicationException {
    	
    	// STEP 처리 구분
    	//String mode = "CIGMA";
    	String mode = "JAVA";
    	
    	boolean result = false;
    	
    	System.out.println("param : " + param);
    	
    	if ("JAVA".equals(mode)) {
    	
	    	// java 처리 (STEP2) 
	    	
	    	// 1. 일일판매계획 WORK FILE CLEAR  
	    	// COMPS(사업　부), TYPCD (분 류(AA:서열, BB:비서열, CC:확정오더)) , PYVND (업체　　코드) 
	    	// PSZDBLIB.SPD149PFX 삭제  
    		
    		// E1_20210104_00001100
    		
    		System.out.println("STEP START");
	    	
    		String strParam = String.valueOf(param.get("param"));
    		
    		System.out.println("strParam : " + strParam);
    		
    		String comps = strParam.substring(0, 2);
    		String baseDay = strParam.substring(2, 10);
    		String pyvnd = strParam.substring(14, 18);
    		
    		System.out.println("comps : " + comps);
    		System.out.println("pyvnd : " + pyvnd);
    		
    		// 자르기
    		
	    	// AA
	    	// E1 업체코드	    	
	    	OrderHostUpDomain domain = new OrderHostUpDomain();
	    	domain.setComps(comps);
	    	domain.setTypcd("AA"); // AA:서열
	    	domain.setPyvnd(pyvnd);
	    	
	    	//로그인 사용자 사업부에 따른 데이터베이스
	        //세션 저장된 데이터 불러오기
	    	EmpDomain empInfo = (EmpDomain)request.getSession().getAttribute("EMP_DOMAIN");	        
	        CommonDb2Domain cdc = new CommonDb2Domain();

	    	// LIB 셋팅
	    	if(comps.equals(DnkrConstans.COMPS_MASAN)) {
	        	cdc.setLib1(DnkrConstans.DNKE_LIB1);
	        	cdc.setLib2(DnkrConstans.DNKE_LIB2);
	    	} else {
	        	cdc.setLib1(DnkrConstans.DNKA_LIB1);
	        	cdc.setLib2(DnkrConstans.DNKA_LIB2);
	    	}
	    	
	    	domain.setLib1(cdc.getLib1());
	    	domain.setLib2(cdc.getLib2());
	    	
	    	int result01 = 0;	    			
			try {				
				//result01 = orderDaySaleCreateDao.deleteSPD149PFX(domain);				
				System.out.println("STEP01 : " + result01);				
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("STEP01 : " + e.getMessage());
			}
	    	
	    	// 2. SPDE140U1
	    	// HKMC VAN 일일판매 WORK FILE CLEAR CLEAR(SPD141PF, SPD148PF, SPD142PF) 업체코드별 삭제  
	    	// COMPS(사업　부), PYVND (업체　　코드) 
	    	// PSZDBLIB.SPD141PF 삭제 
	    	// PSZDBLIB.SPD142PF 삭제 
	    	// PSZDBLIB.SPD148PF 삭제 
	    	
	    	int result02 = 0;	    			
			try {
				result02 = orderDaySaleCreateDao.deleteSPD141PF(domain);				
				System.out.println("STEP02-1 : " + result02);				
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("STEP02-1 : " + e.getMessage());				
			}
			
	    	int result03 = 0;	    			
			try {
				result03 = orderDaySaleCreateDao.deleteSPD142PF(domain);				
				System.out.println("STEP02-2 : " + result03);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("STEP02-2 : " + e.getMessage());
			}
			
	    	int result04 = 0;	    			
			try {
				result04 = orderDaySaleCreateDao.deleteSPD148PF(domain);
				System.out.println("STEP02-3 : " + result04);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("STEP02-3 : " + e.getMessage());
			}
	    	    	
	    	// 3.SPDE140U2 
	    	// HKMC VAN 일일판매 WORK FILE(1)생성 (상세용)     	
	    	// SVH310PF -> SPD141PF
	    	// MST100PF, EM000LR0 체크 
	    	
	    	int result05 = 0;	    			
			try {
				result05 = orderDaySaleCreateDao.deleteSHK200PF(domain);
				System.out.println("STEP03-1 : " + result05);
			} catch (Exception e) {
				e.printStackTrace();
				//System.out.println("STEP03-1 : " + e.getMessage());
			}
	    	
			// SVH310PF -> SHK200PF
	    	orderDaySaleCreateDao.insertSHK200PF(domain);
	    	System.out.println("STEP03-2 : ");
	    	// SHK200PF -> SPD141PF
	    	orderDaySaleCreateDao.insertSPD141PF(domain);
	    	System.out.println("STEP03-3 : ");
	    	    	
	    	// 4.SPDE140U3 
	    	// HKMC VAN 일일판매 WORK FILE(1)생성 (종합용)     	
	    	// SVH320PF -> SPD141PF
	    	// MST100PF, EM000LR0 체크     	 	
	    	
	    	int result06 = 0;	    			
			try {
				result06 = orderDaySaleCreateDao.deleteSHK210PF(domain);
				System.out.println("STEP04-1 : " + result06);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("STEP04-1 : " + e.getMessage());
			}
	    	
			// SVH320PF -> SHK210PF
	    	orderDaySaleCreateDao.insertSHK210PF(domain);
	    	System.out.println("STEP04-2 : ");

	    	// SHK210PF -> SPD141PF
	    	// INSERT OR UPDATE  
	    	List<OrderDaySaleCreateDomain> shk210pfList = orderDaySaleCreateDao.selectSHK210PF(domain);
	    	System.out.println("STEP04-3 : " + shk210pfList.size());
	    	
	    	List<OrderDaySaleCreateDomain> spd141pfList = orderDaySaleCreateDao.selectSPD141PF(domain);
	    	System.out.println("STEP04-4 : " + spd141pfList.size());
	    	
	    	for (OrderDaySaleCreateDomain domain2 : shk210pfList) {
	    		
	    		domain2.setLib1(cdc.getLib1());
	    		domain2.setLib2(cdc.getLib2());
	    		
	    		//존재체크
	    		boolean result2 = false;
	    		for (OrderDaySaleCreateDomain domain3 : spd141pfList) { 
	    			
	    			if (domain3.getComps().equals(domain2.getComps()) && 
	    					domain3.getPyvnd().equals(domain2.getPyvnd()) && 
	    					domain3.getPspno().equals(domain2.getPspno()) &&
	    					domain3.getSeycd().equals(domain2.getDsecd()) &&
	    					domain3.getSeyno().equals(domain2.getDseno()) &&
	    					domain3.getFaccd().equals(domain2.getDfacd()) &&
	    					domain3.getMkcar().equals(domain2.getDmkcr()) 
	    					) { 
	    				result2 = true;
	    				break;
	    			} 
	    		} 
	    		
	    		if (!result2) {
		    		//없으면 insert 
	    			// domain2 
	    			
	    			orderDaySaleCreateDao.insertSPD141PF_3(domain2);
	    			
	    		} else {
		    		//있으면 update 
	    			// domain2 
	    			
	    			orderDaySaleCreateDao.updateSPD141PF(domain2);
	    			
	    		}
	    			    		
	    	}
	    	
	    	//개별처리로 변경.
	    	//orderDaySaleCreateDao.insertSPD141PF_2(domain);
	    	
	    	
	    	// 5.SPDE140U4
			// HKMC VAN 일일판매 TX 생성및 ERROR FILE 생성
	    	// SPD141PF -> SPD142PF (정상)
	    	// SPD148PF (오류)   
	    	// SAL160PF, SVZ040PF, BM009PR 체크
	    	    	
	    	// select     	
	    	List<OrderDaySaleCreateDomain> list = orderDaySaleCreateDao.selectSPD141PF(domain);
	    	System.out.println("STEP05-1 : " + list.size());
	    	
	    	for (OrderDaySaleCreateDomain domain2 : list) {        
	    		
	    		domain2.setLib1(cdc.getLib1());
	    		domain2.setLib2(cdc.getLib2());
                         
	    		domain2.setComps(comps);

	    		int cnt1 = 0;
	    		// *<상세DATA종합DATA비교>
	    		if (domain2.getPbsqyd().equals(domain2.getPbsqyt()) &&
	    				domain2.getDatq0d().equals(domain2.getDatq0t()) &&
	    				domain2.getDatq1d().equals(domain2.getDatq1t()) &&
	    				domain2.getDatq2d().equals(domain2.getDatq2t()) &&
	    				domain2.getDatq3d().equals(domain2.getDatq3t())) {
	    			//test
	    			//cnt1 = 1;
	    			cnt1 = 0;
	    		}
	    					    		
	    		// 체크1 SAL160PF *<출하정보TABLE마스타에　없을경우ERROR FILE작성>                                           
	    		int cnt2 = orderDaySaleCreateDao.countSAL160PF(domain2);
	    		
	        	// 체크2 SVZ040PF <일일수주갱신ITEM제어마스타에　존재>                                                      
	    		int cnt3 = orderDaySaleCreateDao.countSVZ040PF(domain2);
	        	
	        	// 체크3 BM009PR 
	    		// int cnt3 = orderDaySaleCreateDao.countBM009PR(domain2);
	    		
	    		// 오류인 경우 ERRPR LIST로
	    		//if (cnt1 == 0 || cnt2 == 0 || cnt3 == 0 ) {    			
	    		if (cnt1 > 0 || cnt2 == 0 || cnt3 > 0 ) {
	    			
	    			if (cnt1 > 0) {
	    				domain2.setErrcd("1");
	    			} else if (cnt2 == 0) {
	    				domain2.setErrcd("2");
	    			} else if (cnt3 > 0) {
	    				domain2.setErrcd("3");
	    			}
	    			
	            	// insert
	        		orderDaySaleCreateDao.insertSPD148PF(domain2);
	        		
	    		} else {
	            	// insert
	        		orderDaySaleCreateDao.insertSPD142PF(domain2);
	    		}
	
	    	}
	    	    	
	    	// 6.SPDE140U5 
	    	// 부족분산출 
	    	// SPD142PF -> SPD142PF 업데이트 
	    	// SAL160PF, SAL200PF, SAL100PF 
	    	
	    	// select     	
	    	List<OrderDaySaleCreateDomain2> list2 = orderDaySaleCreateDao.selectSPD142PF(domain);
	    	System.out.println("STEP06-1 : " + list2.size());
	    	
	    	for (OrderDaySaleCreateDomain2 domain2 : list2) {
	    		
	    		OrderDaySaleCreateDomain2 domain3 = new OrderDaySaleCreateDomain2();
	    		
	    		domain3.setComps(domain2.getComps());
	    		domain3.setPyvnd(domain2.getPyvnd());
	    		domain3.setPspno(domain2.getPspno());
	    		domain3.setMkpno(domain2.getMkpno());	   
	    		
	    		domain3.setMakqy(domain2.getMakqy());
	    		domain3.setImfdt(domain2.getImfdt());
	    		domain3.setClhct(domain2.getClhct());
	    		
	    		//CHLDT
	    		// 갱신일수 및 갱신일자
	    		domain3.setUptdt(domain2.getImfdt());
	    		
	    		try {
	    			DateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		    		Date date = dateformat.parse(domain2.getChldt());
		    		Calendar cal = Calendar.getInstance();
		    		cal.setTime(date);
		    		cal.add(Calendar.DATE, Integer.parseInt(domain2.getImfdt()) - 1);
		    		domain3.setUpdat(dateformat.format(cal.getTime()));
	    		} catch (Exception e) {
					// 스킵
	    			domain3.setUpdat("0");
	    			System.out.println("갱신일수 오류");
				}
	    		
	    		// 부족분산출
	    		int dapq0 = domain2.getMakqy() - domain2.getPbsqy() - domain2.getDatq0();
	    		domain3.setDapq0(dapq0);
	    		int dap11 = domain3.getDapq0() - domain2.getDat11();
	    		domain3.setDap11(dap11);
	    		int dap12 = domain3.getDap11() - domain2.getDat12();
	    		domain3.setDap12(dap12);
	    		int dap21 = domain3.getDap12() - domain2.getDat21();
	    		domain3.setDap21(dap21);
	    		int dap22 = domain3.getDap21() - domain2.getDat22();
	    		domain3.setDap22(dap22);
	    		int dap31 = domain3.getDap22() - domain2.getDat31();
	    		domain3.setDap31(dap31);
	    		int dap32 = domain3.getDap31() - domain2.getDat32();
	    		domain3.setDap32(dap32);
	    		int dap41 = domain3.getDap32() - domain2.getDat41();
	    		domain3.setDap41(dap41);
	    		int dap42 = domain3.getDap41() - domain2.getDat42();
	    		domain3.setDap42(dap42);
	    		int dap51 = domain3.getDap42() - domain2.getDat51();
	    		domain3.setDap51(dap51);
	    		int dap52 = domain3.getDap51() - domain2.getDat52();
	    		domain3.setDap52(dap52);
	    		int dap61 = domain3.getDap52() - domain2.getDat61();
	    		domain3.setDap61(dap61);
	    		int dap62 = domain3.getDap61() - domain2.getDat62();
	    		domain3.setDap62(dap62);
	    		int dap71 = domain3.getDap62() - domain2.getDat71();
	    		domain3.setDap71(dap71);
	    		int dap72 = domain3.getDap71() - domain2.getDat72();
	    		domain3.setDap72(dap72);
	    		int dap81 = domain3.getDap72() - domain2.getDat81();
	    		domain3.setDap81(dap81);
	    		int dap82 = domain3.getDap81() - domain2.getDat82();
	    		domain3.setDap82(dap82);
	    		int dap91 = domain3.getDap82() - domain2.getDat91();
	    		domain3.setDap91(dap91);
	    		int dap92 = domain3.getDap91() - domain2.getDat92();
	    		domain3.setDap92(dap92);
	    		int dapa1 = domain3.getDap92() - domain2.getData1();
	    		domain3.setDapa1(dapa1);
	    		int dapa2 = domain3.getDapa1() - domain2.getData2();
	    		domain3.setDapa2(dapa2);
	    		int dapb1 = domain3.getDapa2() - domain2.getDatb1();
	    		domain3.setDapb1(dapb1);
	    		int dapb2 = domain3.getDapb1() - domain2.getDatb2();
	    		domain3.setDapb2(dapb2);
	    		int dapc1 = domain3.getDapb2() - domain2.getDatc1();
	    		domain3.setDapc1(dapc1);
	    		int dapc2 = domain3.getDapc1() - domain2.getDatc2();
	    		domain3.setDapc2(dapc2);    		
	    		
	    		domain3.setClpq1(getNum(dap11));
	    		domain3.setCldq1(getNum(dap11));
	    		domain3.setCllq1(dap11);
	    		
		    	int result07 = 0;	    			
				try {
					result07 = orderDaySaleCreateDao.updateSPD142PF(domain3);
				} catch (Exception e) {
					e.printStackTrace();
				}
	    			    		
	    	}
	    	    	
	    	// 7.SPDE140U6 
	    	// 수주량산출
	    	// SPD142PF -> SPD142PF 업데이트 
	    	// SAL100PF, SAL160PF     	   	
	    	
	    	// select     	
	    	List<OrderDaySaleCreateDomain2> list3 = orderDaySaleCreateDao.selectSPD142PF(domain);
	    	System.out.println("STEP07-1 : " + list3.size());	    	
	    	
	    	for (OrderDaySaleCreateDomain2 domain2 : list3) {
	    		
	    		OrderDaySaleCreateDomain2 domain3 = new OrderDaySaleCreateDomain2();
	    		
	    		domain3.setComps(domain2.getComps());
	    		domain3.setPyvnd(domain2.getPyvnd());
	    		domain3.setPspno(domain2.getPspno());
	    		domain3.setMkpno(domain2.getMkpno());	   
	    		
	    		int sujq0 = domain2.getClpq1() + domain2.getCldq1() + domain2.getDapq0();
	    		domain3.setSujq0(sujq0);    		
	    		int sujq1 = getNum(domain2.getDap41()) - getNum(domain2.getDap31());
	    		domain3.setSujq1(sujq1);
	    		int sujq2 = getNum(domain2.getDap51()) - getNum(domain2.getDap41());
	    		domain3.setSujq2(sujq2);
	    		int sujq3 = getNum(domain2.getDap61()) - getNum(domain2.getDap51());
	    		domain3.setSujq3(sujq3);
	    		int sujq4 = getNum(domain2.getDap71()) - getNum(domain2.getDap61());
	    		domain3.setSujq4(sujq4);
	    		int sujq5 = getNum(domain2.getDapa1()) - getNum(domain2.getDap71());
	    		domain3.setSujq5(sujq5);
	    		int sujq6 = getNum(domain2.getDapb1()) - getNum(domain2.getDapa1());
	    		domain3.setSujq6(sujq6);
	    		int sujq7 = getNum(domain2.getDapc1()) - getNum(domain2.getDapb1());
	    		domain3.setSujq7(sujq7);
	    		int sujq8 = 0;
	    		domain3.setSujq8(sujq8);
	    		int sujq9 = 0;
	    		domain3.setSujq9(sujq9);
	    		int sujq10 = 0;
	    		domain3.setSujqa(sujq10);
	    		int sujq11 = 0;
	    		domain3.setSujqb(sujq11);
	    		int sujq12 = 0;
	    		domain3.setSujqc(sujq12);
		    		
		    	int result07 = 0;	    			
				try {
					result07 = orderDaySaleCreateDao.updateSPD142PF_2(domain3);
				} catch (Exception e) {
					e.printStackTrace();
				}
	    		
	    	}
	    	    	
	    	// 7. 추가로직 -> 일자별수주계획생성
	    	// SPD142PF -> SVZ600PF 
	    	// SAL100PF 
	    	
	    	// select     	
	    	List<OrderDaySaleCreateDomain2> list4 = orderDaySaleCreateDao.selectSPD142PF(domain);
	    	System.out.println("STEP07-2 : " + list4.size());
	    	
	    	NonOrderHostUpDomain nonOrderHostUpDomain = new NonOrderHostUpDomain();
	    	nonOrderHostUpDomain.setComps(domain.getComps());
	    	nonOrderHostUpDomain.setPyvnd(domain.getPyvnd());
	    	nonOrderHostUpDomain.setPlndt(baseDay);
	    	// 서열형
	    	nonOrderHostUpDomain.setTypcd("AA");
	    	
	    	nonOrderHostUpDomain.setLib1(cdc.getLib1());
	    	nonOrderHostUpDomain.setLib2(cdc.getLib2());
	    		    		    	
	    	int result08 = 0;	    			
			try {
				result08 = nonOrderHostUpDao.deleteSVZ600PF(nonOrderHostUpDomain);
				System.out.println("STEP07-3 : " + result08);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("STEP07-3 : " + e.getMessage());
			}
	    	
			nonOrderHostUpDomain.setRows(13);
			
	    	List<OrderCalendarDomain> list5 = orderDaySaleCreateDao.selectSAL100PF(nonOrderHostUpDomain);
	    	System.out.println("STEP07-4 : " + list5.size());
	    	
	    	for (OrderDaySaleCreateDomain2 domain2 : list4) {
	    		
	    		
	    		int index = 0;
	    		
	    		for (OrderCalendarDomain domain3 : list5) {
	    			
		    		NonOrderHostUpDomain nonOrderHostUpDomain2 = new NonOrderHostUpDomain();
		    		
		    		nonOrderHostUpDomain2.setComps(comps);
		    		nonOrderHostUpDomain2.setTypcd("AA");
		    		nonOrderHostUpDomain2.setPyvnd(domain2.getPyvnd());
		    		nonOrderHostUpDomain2.setShpto(0);		    		
		    		nonOrderHostUpDomain2.setPspno(domain2.getPspno());
		    		
		    		nonOrderHostUpDomain2.setPlndt(domain3.getMakdt());
		    		
		    		if (index == 0) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq0()));
		    		} else if (index == 1) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq1()));
		    		} else if (index == 2) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq2()));
		    		} else if (index == 3) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq3()));
		    		} else if (index == 4) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq4()));
		    		} else if (index == 5) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq5()));
		    		} else if (index == 6) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq6()));
		    		} else if (index == 7) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq7()));
		    		} else if (index == 8) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq8()));
		    		} else if (index == 9) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujq9()));
		    		} else if (index == 10) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujqa()));
		    		} else if (index == 11) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujqb()));
		    		} else if (index == 12) {
		    			nonOrderHostUpDomain2.setBasqy(String.valueOf(domain2.getSujqc()));
		    		}
		    		
		    		nonOrderHostUpDomain2.setInpid(empInfo.getEmpNumber());
		    		nonOrderHostUpDomain2.setChpid(empInfo.getEmpNumber());

		    		nonOrderHostUpDomain2.setPlncd("P");
		    		
		    		try {
		    			orderDaySaleCreateDao.insertSVZ600PF_2(nonOrderHostUpDomain2);
		    		} catch (Exception e) {
		    			System.out.println(e.getMessage());
		    		}
		    		
		    		index++;
	    		}
	    				    	
		    	// 월잔여수주계획 : (월판매계획- 당월누적수주계획수량)/잔여근무일수
				
				// 월 판매계획 
		    	// 계산일 마지막 날짜
		    	int lastData = list5.size();
		    	lastData = lastData - 1 ; 
		    	String lastDay = list5.get(lastData).getMakdt();
		    	System.out.println("계산일 마지막 날짜 : " + lastDay);
		    	
				String base_ym = lastDay.substring(0, 6);
				System.out.println("계산일 마지막 년월 취득 : " + base_ym);
				
	    		// 잔여근무일수 (라스트일자 ~ 월마지막일자 까지의 근무일수 계산)
				OrderDaySaleCreateDomain getWorkDaysDomain = new OrderDaySaleCreateDomain();
				getWorkDaysDomain.setComps(comps);
				getWorkDaysDomain.setPyvnd(pyvnd);
				getWorkDaysDomain.setDaseymd(lastDay);
				getWorkDaysDomain.setDaseym(base_ym);
				
				getWorkDaysDomain.setLib1(cdc.getLib1());
				getWorkDaysDomain.setLib2(cdc.getLib2());
				
				List<OrderDaySaleCreateDomain> WorkDayslist = orderDaySaleCreateDao.getWorkDays(getWorkDaysDomain);
				int WorkDays = WorkDayslist.size();
				
				System.out.println("월의 남은 근무일수 : " + WorkDays);
				
				// 당월누적수주계획수량 (getSujq0~getSujqc 까지의 합)
	    		int sum = domain2.getSujq0() + domain2.getSujq1() + domain2.getSujq2() + domain2.getSujq3() + domain2.getSujq4() 
	    			+ domain2.getSujq5() + domain2.getSujq6() + domain2.getSujq7() + domain2.getSujq8()  + domain2.getSujq9() 
	    			+ domain2.getSujqa()  + domain2.getSujqb() + domain2.getSujqc();
	    		
	    		System.out.println("당월누적수주계획수량 : " + sum);
	    		
	    		// 월 판매계획 취득 품번별 취득
				OrderDaySaleCreateDomain getDomain = new OrderDaySaleCreateDomain();
				getDomain.setDaseym(base_ym);
				getDomain.setComps(comps);
				getDomain.setPspno(domain2.getPspno());
				
				getDomain.setLib1(cdc.getLib1());
				getDomain.setLib2(cdc.getLib2());
				
				List<OrderDaySaleCreateDomain> plnMlist = orderDaySaleCreateDao.getPlnM(getDomain);
				int p_qty_m = 0;
				if(plnMlist.size() != 0) {
					p_qty_m =  Integer.parseInt(plnMlist.get(0).getpqtym());
					System.out.println("품번별 월 판매계획 값 : " + p_qty_m);
				} else {
					System.out.println("데이터 없음 조회품번 : "+ domain2.getPspno());
				}
				
				int MPlan = 0;
				// 월 판매계획 값이 0 이외일때 월잔여수주계획을 계산한다. 0일경우 월잔여수주계획 0으로 등록
				if (p_qty_m != 0) {
					// 월잔여수주계획 : (월판매계획- 당월누적수주계획수량)/잔여근무일수
					MPlan = (p_qty_m - sum ) / WorkDays;
					System.out.println("월 잔여수주계획 : " + MPlan);
				}
				
				nonOrderHostUpDomain.setPlndt(lastDay);
				nonOrderHostUpDomain.setRows(WorkDays + 1);
				
		    	List<OrderCalendarDomain> list6 = orderDaySaleCreateDao.selectSAL100PF(nonOrderHostUpDomain);
	    		
	    		for (OrderCalendarDomain domain3 : list6) {
	    			
		    		NonOrderHostUpDomain nonOrderHostUpDomain2 = new NonOrderHostUpDomain();
		    		
		    		nonOrderHostUpDomain2.setComps(comps);
		    		nonOrderHostUpDomain2.setTypcd("AA");
		    		nonOrderHostUpDomain2.setPyvnd(domain2.getPyvnd());
		    		nonOrderHostUpDomain2.setShpto(0);		    		
		    		nonOrderHostUpDomain2.setPspno(domain2.getPspno());
		    		
		    		nonOrderHostUpDomain2.setPlndt(domain3.getMakdt());
		    		
		    		// 월잔여수주계획
		    		nonOrderHostUpDomain2.setBasqy(String.valueOf(MPlan));
		    		
		    		nonOrderHostUpDomain2.setInpid(empInfo.getEmpNumber());
		    		nonOrderHostUpDomain2.setChpid(empInfo.getEmpNumber());		    		
		    		
		    		// 고객사 계획은 P, 자동생성 계획은 F 
		    		nonOrderHostUpDomain2.setPlncd("F");
		    		
		    		try {
		    			orderDaySaleCreateDao.insertSVZ600PF_2(nonOrderHostUpDomain2);
		    		} catch (Exception e) {
		    			//System.out.println(e.getMessage());
		    		}

	    		}	    		
	    		
	    	}
	    	
	    	System.out.println("STEP END");
	    
	    	result = true;
	    	
    	} else {
        	// CIGMA 호출 - 주석처리
        	result = orderDaySaleCreateDao.procCreate(param);
    	}    	
    	
    	return result;
    }
    
    private int getNum(int i) {
    	
		// <부족분>                                                                     
		// 부호처리:( - )==>양수처리                                                        
		//        ( + )==>０
    	
    	if (i < 0) {
    		return i * -1;
    	} else {
    		return 0;
    	}
    	
    	
    }

}
