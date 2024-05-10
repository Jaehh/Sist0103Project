package spring.db.member;

import java.util.HashMap;
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

	@Override
	public MemberDto getMember(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfMember", num);
	}

	@Override
	public int passCheck(String num, String pass) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("num", num);
		map.put("pass", pass);
		
		return session.selectOne("passCheckOfMember", map);
	}

	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfMember", dto);
	}

	@Override
	public void deleteMember(String num) {
		session.delete("deleteOfMember", num);
	}

}