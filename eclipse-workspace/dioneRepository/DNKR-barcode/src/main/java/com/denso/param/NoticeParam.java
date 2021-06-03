package com.denso.param;

import com.denso.model.TblBoard;

public class NoticeParam {

	private String seq;              			// seq
	private String title;    		 			// 제목
	private String writer;     		 			// 작성자
	private String boardDate;  	     			// 등록일
	private String displayYn;        			// 전시구분
	private String content;          			// 내용
	private String type;			 			// 게시판 구분
	private String faqProductType;	 			// 상품구분
	private String faqClass;		 			// 유형구분
	private String faqQuestion;		 			// 질문
	private String faqReply;		        	// 답변
	private String displayCondition;    		// 전시구분 조건 검색
	private String statusCondition;     		// 제목/작성자 조건 검색
	private String statusText;            		// 조건 검색 내용
	private String productDivision;    			// 상품 구분
	private String faqEncoding;					// 유형 구분
	private String faqProductTypeCondition; 	// FAQ 상품 구분
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getDisplayYn() {
		return displayYn;
	}

	public void setDisplayYn(String displayYn) {
		this.displayYn = displayYn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFaqProductType() {
		return faqProductType;
	}

	public void setFaqProductType(String faqProductType) {
		this.faqProductType = faqProductType;
	}

	public String getFaqClass() {
		return faqClass;
	}

	public void setFaqClass(String faqClass) {
		this.faqClass = faqClass;
	}

	public String getFaqQuestion() {
		return faqQuestion;
	}

	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}

	public String getFaqReply() {
		return faqReply;
	}

	public void setFaqReply(String faqReply) {
		this.faqReply = faqReply;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public TblBoard convertToTblBoard(){
		TblBoard tblBoard = new TblBoard();

		tblBoard.setSeq(seq);
		tblBoard.setTitle(title);
		tblBoard.setWriter(writer);
		tblBoard.setDisplayYn(displayYn);
		tblBoard.setContent(content);
		tblBoard.setType(type);
		tblBoard.setFaqProductType(faqProductType);
		tblBoard.setFaqClass(faqClass);
		tblBoard.setFaqQuestion(faqQuestion);
		tblBoard.setFaqReply(faqReply);
		tblBoard.setFaqEncoding(faqEncoding);
		
		return tblBoard;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getDisplayCondition() {
		return displayCondition;
	}

	public void setDisplayCondition(String displayCondition) {
		this.displayCondition = displayCondition;
	}

	public String getStatusCondition() {
		return statusCondition;
	}

	public void setStatusCondition(String statusCondition) {
		this.statusCondition = statusCondition;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getProductDivision() {
		return productDivision;
	}

	public void setProductDivision(String productDivision) {
		this.productDivision = productDivision;
	}
	public String getFaqEncoding() {
		return faqEncoding;
	}

	public void setFaqEncoding(String faqEncoding) {
		this.faqEncoding = faqEncoding;
	}

	public String getFaqProductTypeCondition() {
		return faqProductTypeCondition;
	}

	public void setFaqProductTypeCondition(String faqProductTypeCondition) {
		this.faqProductTypeCondition = faqProductTypeCondition;
	}
}
