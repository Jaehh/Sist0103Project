package Day0115;

public class Board_09 {

	private String writer;
	private String subject;
	private String content;
	
	//디폴트생성자
	public Board_09() {
		
	}
	
	//명시적생성자
	public Board_09(String writer, String subject, String content) {
		this.writer = writer;
		this.subject = subject;
		this.content = content;
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
	
	
	
	
}
