package spring.di.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		System.out.println("1.자바방식 생성후 호출");
		MessageInter m1=new Message1();
		m1.sayHello("영자");
		
		MessageInter m2=new Message2();
		m2.sayHello("철희");
		
		System.out.println("2.스프링방식 생성후 호출");
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
		
		MessageInter m3=(Message1)context.getBean("msgBean1"); //방법1
		m3.sayHello("호동이");
		
		MessageInter m4=context.getBean("msgBean2", Message2.class);//방법2
		m4.sayHello("재석이");
		
	}

}
