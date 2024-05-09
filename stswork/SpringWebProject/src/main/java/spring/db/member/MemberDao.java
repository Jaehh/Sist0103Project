package spring.db.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao implements MemberDaoInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public int getIdCheck(String id) {
		return session.selectOne("idCheckOfMember", id);
	}

	@Override
	public int getTotalCount() {
		return session.selectOne("totalCountOfMem");
	}

	@Override
	public List<MemberDto> getAllMemDatas() {
		return session.selectList("getAllOfMem");
	}

	@Override
	public void insertMem(MemberDto dto) {
	session.insert("insertOfMem", dto);
	}

}