package spring.db.carmember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao implements CarMemberDaoInter{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("totalCountOfMem");
	}

	@Override
	public List<CarMemberDto> getAllMemDatas() {
		// TODO Auto-generated method stub
		return session.selectList("getAllOfMem");
	}

	@Override
	public void insertMem(CarMemberDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfMem", dto);
	}

	@Override
	public CarMemberDto getOneData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selctOneOfCarMember", num);
	}

	@Override
	public void updateCarMember(CarMemberDto dto) {
		session.update("updateOfCarMember", dto);
		
	}

	@Override
	public void deleteMember(String num) {
		session.delete("deleteOfCarMember", num);
		
	}

}
