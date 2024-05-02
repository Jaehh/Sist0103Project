package spring.di.coffee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("자바방식으로 Hello메서드 호출하기");
		
		Hello hello1=new Hello();
		Hello hello2=new Hello();
		
		System.out.println(hello1.getMessage());
		
		System.out.println(hello1==hello2); //레퍼런스 주소 비교
		//자바에서는 new로 생성할때마다 새로운 영역에 생성한다
		
		System.out.println("스프링 방식으로 Hello메서드 호출하기");
		//설정xml파일 가져온다..어플리케이션 실행시에만 필요하다
		//웹으로 실행시 web.xml에 설정되어 있으므로 필요없다
		
		ApplicationContext app1=new ClassPathXmlApplicationContext("helloContext1.xml");
		
		//객체생성
		Hello h1=(Hello)app1.getBean("hello"); //방법2
		System.out.println(h1.getMessage());
		
		Hello h2=app1.getBean("hello",Hello.class); //방법2
		System.out.println(h2.getMessage());
		
		System.out.println(h1==h2); //생성되는 주소가 같다..스프링에서는 기본이 싱글턴이다
		
	}

}
