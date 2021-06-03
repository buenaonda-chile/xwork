package com.denso.common.vo;

public enum GrpCd {
	PDTLT("pdtlt", "유형 구분"),
	FAQSK("faqsk", "스마트빔상품"),
	FAQNK("faqnk", "스마트 로봇-누리아띠"),
	FAQAK("faqak", "스마트 로복-알버트"),
	FAQHK("faqhk", "헤스온샤인"),
	FAQSE("faqse", "Smart Beam"),
	FAQNE("faqne", "nuri Atti"),
	FAQAE("faqae", "Albert"),
	FAQHE("faqhe", "Helth-On-Shine");
			
	private final String grpCd;
	private final String grpCdNm;
	
	private GrpCd(String grpCd, String grpCdNm){
		this.grpCd = grpCd;
		this.grpCdNm = grpCdNm;
	}
	
	public String getGrpCd() {
		return grpCd;
	}
	
	public String getGrpCdNm() {
		return grpCdNm;
	}
	
}
