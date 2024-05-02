package spring.last.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderController {

	@Autowired
	ShopDaoInter shopInter;
	
	int cnt=20;
	String name="주문자";
	
	public void jumunInsert(String sang,int price,String color)
	{
		shopInter.insertShop(sang, price, color);
		System.out.println(name+"님이 "+cnt+"개를 주문완료!!!");
	}
	
	public void jumunDelete(String num)
	{
		System.out.println(num+"번 삭제완료!!");
	}
	
	public void jumunSelect(String sang,int price,String color)
	{
		shopInter.selectShop(sang, price, color);
		System.out.println("주문자: "+name);
		System.out.println("주문갯수: "+cnt);
	}
}
