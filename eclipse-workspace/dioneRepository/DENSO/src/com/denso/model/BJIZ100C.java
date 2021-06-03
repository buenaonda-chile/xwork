package com.denso.model;
/********************************************************************** 
 * 저장품입고TX 테이블 모델 
 * - 테이블 명 : BJI100PF
 * @see
 * 	- 2015-03-02	:	yk kim
***********************************************************************/ 	
public class BJIZ100C {
	
	private String  comps;			// 사　업　　부
	private String  rpijp;			// 입고전표번호
	private String  rpivn;			// 입고업체코드
	private String  rpidt;	     	// 입고　　일자
	private String  rpicl;			// 입고계정분류
	private String  rpipn;			// 입고　　품번
	private String  rpiqy;		    // 양품　　수량
	private String  rpoqy;		    // 입고    수량
	private String  ipiqy;		    // 출고    누계	
	private String  rpist;			// 입고　　단가
	private String  rpbal;			// 입고발주번호
	private String  rpadt;		    // 등록　　일자	
	private String  rpjym;			// 입고마감년월
	private String  rpgub;			// 입고마감구분
	
	public String getComps() {
		return comps;
	}
	public void setComps(String comps) {
		this.comps = comps;
	}
	public String getRpijp() {
		return rpijp;
	}
	public void setRpijp(String rpijp) {
		this.rpijp = rpijp;
	}
	public String getRpivn() {
		return rpivn;
	}
	public void setRpivn(String rpivn) {
		this.rpivn = rpivn;
	}
	public String getRpidt() {
		return rpidt;
	}
	public void setRpidt(String rpidt) {
		this.rpidt = rpidt;
	}
	public String getRpicl() {
		return rpicl;
	}
	public void setRpicl(String rpicl) {
		this.rpicl = rpicl;
	}
	public String getRpipn() {
		return rpipn;
	}
	public void setRpipn(String rpipn) {
		this.rpipn = rpipn;
	}
	public String getRpiqy() {
		return rpiqy;
	}
	public void setRpiqy(String rpiqy) {
		this.rpiqy = rpiqy;
	}
	public String getRpoqy() {
		return rpoqy;
	}
	public void setRpoqy(String rpoqy) {
		this.rpoqy = rpoqy;
	}
	public String getIpiqy() {
		return ipiqy;
	}
	public void setIpiqy(String ipiqy) {
		this.ipiqy = ipiqy;
	}
	public String getRpist() {
		return rpist;
	}
	public void setRpist(String rpist) {
		this.rpist = rpist;
	}
	public String getRpbal() {
		return rpbal;
	}
	public void setRpbal(String rpbal) {
		this.rpbal = rpbal;
	}
	public String getRpadt() {
		return rpadt;
	}
	public void setRpadt(String rpadt) {
		this.rpadt = rpadt;
	}
	public String getRpjym() {
		return rpjym;
	}
	public void setRpjym(String rpjym) {
		this.rpjym = rpjym;
	}
	public String getRpgub() {
		return rpgub;
	}
	public void setRpgub(String rpgub) {
		this.rpgub = rpgub;
	}
	
	
	
}
