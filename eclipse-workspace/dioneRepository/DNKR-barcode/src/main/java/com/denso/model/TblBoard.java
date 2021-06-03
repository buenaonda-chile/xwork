package com.denso.model;

import java.io.Serializable;
import java.util.Date;

public class TblBoard implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4063738035258965594L;

	private String seq;             				// SEQ
	private String title;    						// 제목
	private String writer;     						// 작성자
	private Date   boardDate;						// 등록일
	private String displayYn;      					// 전시구분
	private String content;							// 내용
	private String type;							// 게시판 구분
	private String faqProductType;					// 상품구분
	private String faqClass;						// 유형구분
	private String faqQuestion;						// 질문
	private String faqReply;						// 답변
	private String faqEncoding;						// faq 국문,영문
	private String faqClassName; 					// 유형구분명
	private String faqProductTypeName;				// 상품구분
	private String groupCode;						// 그룹코드
	private String maxSeq;
	
	public TblBoard() {
	
	}
	
	public TblBoard(String title, String writer, String displayYn, String content, String type, String faqProductType, String faqClass, String faqQuestion, String faqReply){
		this.title = title;
		this.writer = writer;
		this.displayYn = displayYn;
		this.content = content;
		this.type = type;
		this.faqProductType = faqProductType;
		this.faqClass = faqClass;
		this.faqQuestion = faqQuestion;
		this.faqReply = faqReply;
	}
	
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
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
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

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getFaqEncoding() {
		return faqEncoding;
	}

	public void setFaqEncoding(String faqEncoding) {
		this.faqEncoding = faqEncoding;
	}

	public String getFaqClassName() {
		return faqClassName;
	}

	public void setFaqClassName(String faqClassName) {
		this.faqClassName = faqClassName;
	}

	public String getFaqProductTypeName() {
		return faqProductTypeName;
	}

	public void setFaqProductTypeName(String faqProductTypeName) {
		this.faqProductTypeName = faqProductTypeName;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getMaxSeq() {
		return maxSeq;
	}

	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}
	
}
