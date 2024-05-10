package spring.db.member;

import java.util.List;

public interface MemberDaoInter {

	public int getIdCheck(String id);
	public int getTotalCount();
	public List<MemberDto> getAllMemDatas();
	public void insertMem(MemberDto dto);
	public MemberDto getMember(String num);
	public int passCheck(String num, String pass);
	public void updateMember(MemberDto dto);
	public void deleteMember(String num);
}