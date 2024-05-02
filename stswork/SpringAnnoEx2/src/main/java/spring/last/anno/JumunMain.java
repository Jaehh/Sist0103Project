package spring.last.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JumunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext1.xml");
		
		OrderController order=(OrderController)app.getBean("orderController");
		
		order.jumunInsert("요가매트", 35000, "블랙");
		order.jumunDelete("2");
		order.jumunSelect("아령", 45000, "화이트");
	}

}
