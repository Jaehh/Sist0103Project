package Day0112;

//부모
class Color{
	
	public void hello() {
		System.out.println("안녕하세요~~~");
	}
	
}

class Red extends Color{
	
	public void process() {
		System.out.println("나의 차는 빨강색이야");
	}
}

class Green extends Color{
	public void process() {
	System.out.println("나의 차는 초록색이야");
	}
}

class Blue extends Color{
	public void process() {
	System.out.println("나의 차는 파랑색이야");
	}
}
class Pink extends Color{
	public void process() {
	System.out.println("나의 차는 핑크색이야");
	}
}


public class Inherit_09 {

	public static void main(String[] args) {
		
		//자식클래스 extends 부모
		System.out.println("1. Red로 선언하고 Red 로 생성한 경우");
		Red red = new Red();
		red.hello();
		red.process();
		
		System.out.println("2. Green로 선언하고 Green 로 생성한 경우");
		Green green = new Green();
		green.hello();
		green.process();
		
		System.out.println("3. Blue로 선언하고 Blue 로 생성한 경우");
		Blue blue = new Blue();
		blue.hello();
		blue.process();
		
		System.out.println("4. Pink로 선언하고 Pink 로 생성한 경우");
		Pink pink = new Pink();
		pink.hello();
		pink.process();
		
		//부모로 선언하고 자식클래스로 생성
		//부모가 가지고 있는 메소드 호출 ok
		//메서드가 오버라이드 된 경우 호출 ok
		//부모한테는 없고 자식만 가지고 있는 경우 메서드 호출 안됨
		Color color;
		color = new Red();
		
		color.hello();
		//color.process(); 호출안됨(부모한테는 없고 자식만 가지고 있는 경우 메서드)
	}

}
