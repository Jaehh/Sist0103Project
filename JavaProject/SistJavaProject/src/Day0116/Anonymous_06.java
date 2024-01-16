package Day0116;

//익명 내부클래스 : 클래스 선언과 객체생성을 동시에 하는 이름없는 클래스(일회용)
//이벤트가 발생시 생성했다가 끝나면 메모리에서 제거 --> 메모리 효율적 관리 쉽다

abstract class AbstEx{
	abstract public void draw();
}

class OuterEx{
	AbstEx ab = new AbstEx() {
		
		@Override
		public void draw() {
			System.out.println("익명 내부클래스");
			
		}
	};
}

public class Anonymous_06 {

	public static void main(String[] args) {
		OuterEx ex = new OuterEx();
		ex.ab.draw();
	}
}
