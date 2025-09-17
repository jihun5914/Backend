package cs.dit.member;

import java.sql.Date;

/**
 * 패키지명 : cs.dit.member
 * 파일명 : BoardDTO.java
 * 작성일 : 2025. 9. 17.
 * 작성자 : jhkim
 * 변경이력 :
 * 프로그램 설명 : Board 테이블의 데이터를 담는 용기 
 *
 */
public class BoardDTO {
	
	private int bcode;
	private String subject;
	private String content;
	private String writer;
	private Date regdate;
	
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	// 생성자
	public BoardDTO(int bcode, String subject, String content, String writer, Date regdate) {
		this.bcode = bcode;
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}
	
	public BoardDTO() {}
}