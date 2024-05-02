package jstl.data;

public class Student {

	private String name;
	private String addr;
	private int score;
	
	public Student(String name,String addr,int score) {
		this.name=name;
		this.addr=addr;
		this.score=score;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
