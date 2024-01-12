package Day0112;


//클래스를 객체 생성할 때는 자동으로 부모에서 자식순이다 
// ---> 자식이 부모의 멤버를 사용할 수 있기 때문이다
public class MainEmp_04 {

	public static void main(String[] args) {
		Manager_04 manager = new Manager_04("이효리",2800000,"경영기획부");
		
		System.out.println(manager.getEmployee());
	}

}
