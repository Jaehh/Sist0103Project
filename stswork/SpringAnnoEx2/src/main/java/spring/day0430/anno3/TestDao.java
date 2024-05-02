package spring.day0430.anno3;

import org.springframework.stereotype.Component;

@Component
public class TestDao {

	public void insert(String name)
	{
		System.out.println(name+"님을 db에 추가함");
	}
	
	public void delete(String num)
	{
		System.out.println(num+"번 데이타 삭제완료!!!");
	}
	public void select(String name)
	{
		System.out.println(name+"님은 쌍용교육센터에서 교육중~~");
	}
}
