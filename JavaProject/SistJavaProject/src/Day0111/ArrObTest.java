package Day0111;

class Student1{
	
	private String stuName;
	private String hp;
	private int score;
	
	
	  public Student1(String string, String string2, int i) { 
		  
	  }
	 

	//생성자 3개짜리
	private void Stuent1(String name, String hp, int score) {
		this.stuName=name;
		this.hp=hp;
		this.score=score;

	}
	
	//출력메서드
	public void writeData() {
		System.out.println("이름: "+stuName);
		System.out.println("전화번호: "+hp);
		System.out.println("점수: "+score);
	}
}

public class ArrObTest {

	public static void main(String[] args) {
		
		//배열변수 선언 초기화...
	/*	Student1[] stu = new Student1[3];
		
		stu[0] = new Student1("이민호","010-3434-4336",88);
		stu[1] =  new Student1("이영자","010-3434-4336",38);
		stu[2] =  new Student1("김민정","010-3434-4336",68);*/
		
		//생성과 동시에 초기화
		Student1[] stu={
				 new Student1("이민호","010-3434-4336",88),
				 new Student1("이영자","010-3434-4336",38),
				 new Student1("김민정","010-3434-4336",68)
			};
		
		//배열 출력
		for(int i=0;i<stu.length;i++) {
			/*
			 * Student1 s =stu[i]; s.writeData();
			 */
			stu[i].writeData();
			System.out.println("---------------------");
		}
		
		//배열출력(방법2)
		System.out.println("---------------------");
		for(Student1 s1:stu) {
			s1.writeData();
			System.out.println("---------------------");
		}
		
	}
}
