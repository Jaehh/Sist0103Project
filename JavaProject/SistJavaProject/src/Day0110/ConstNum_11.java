package Day0110;


//생성자(Constructor) : 객체 생성시 자동 호출되는 메서드
//1. 일반메서드롸 차이점: 리턴형이 없다
//2. 반드시 클래스명과 같다
//3. Overloading(여러개의 생성자(이름이 같지만 인자가 다른..)를 만들 수 있다)이 가능하다.
//4. 생성자가 없을 경우 기본생성자로 생성가능
//5. 멤버값들이 주로 초기화를 담당
class Numb{
	
	int num; //0
	
	//디폴트 생성자
	public Numb() {
		System.out.println("디폴트 생성자 호출");
	}
	
	//인자있는 생성자
	public Numb(int num) {
		this.num=num;
		System.out.println("인자있는 생성자 호출");
	}
	
	//메서드
	public int getNumber() {
		num=50;
		return num;
	}
}

public class ConstNum_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Numb n1= new Numb();
		
		Numb n2 = new Numb(30);
		System.out.println(n2.num);
		
		Numb n3 = new Numb();
		System.out.println(n3.getNumber());
	}

}
