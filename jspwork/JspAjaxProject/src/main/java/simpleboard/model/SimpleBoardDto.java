package simpleboard.model;

import java.sql.Timestamp;

public class SimpleBoardDto {

	private String num;
	private String writer;
	private String subject;
	private String content;
	private String pass;
	private int readcount;
	private int answercount; //댓글개수 저장
	private Timestamp writeday;
	
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	public int getAnswercount() {
		return answercount;
	}
	public void setAnswercount(int answercount) {
		this.answercount = answercount;
	}
	
	
}
