package spring.mysql.coffee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyShopDao implements MyShopDaoInter{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<MyShopDto> getAllList(){
		return session.selectList("getAllMyShop");
	}
}
