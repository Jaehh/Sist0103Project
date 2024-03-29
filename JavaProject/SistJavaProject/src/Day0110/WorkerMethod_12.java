package Day0110;

class Info{
	
	private String stuName;
	private int stuAge;
	
	//setter 메서드
	//1. 데이터를 수정할 목적 - set변수명
	//2. 저장 용도이므로 결과값 return 값이 없다
	//3. 리턴값이 없으므로 void라고 지정해야 한다
	public void setName(String stuName) {
		this.stuName = stuName; //이름이 다를 경우엔 this생략
		
	}
	
	public void setAge(int stuAge) {
		this.stuAge=stuAge;
	}
	
	//getter 메소드
	//1. 데이터를 조회할 목적 _get변수명
	//2. 데이터를 얻는 목적이므로 인자값이 없다
	//3. 실행 결과값을 돌려주므로 return 결과값으로 지정
	public String getName() {
		return stuName;
	}
	
	public int getAge() {
		return stuAge;
	}


}


public class WorkerMethod_12 {

	public static void main(String[] args) {
		
		Info in1 = new Info();
		//in1.stuName="홍길동"; 인스턴스 변수에 private이 붙으면 변수접근이 안된다(생성을 하더라도)
		//in1.stuAge=33;
		
		//setter 메서드 이용해서 값 수정
		in1.setName("최민영");
		in1.setAge(22);
		
		//getter 메서드 이용해서 값 얻기
		String name = in1.getName();
		int age = in1.getAge();
		
		System.out.println(name+","+age);

	}

}
