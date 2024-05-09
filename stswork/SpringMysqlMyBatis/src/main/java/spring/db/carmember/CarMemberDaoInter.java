package spring.db.carmember;

import java.util.List;

public interface CarMemberDaoInter {

	public int getTotalCount();
	public void insertMem(CarMemberDto dto);
	public List<CarMemberDto> getAllMemDatas();
	public CarMemberDto getOneData(String num);
	public void updateCarMember(CarMemberDto dto);
	public void deleteMember(String num);
}
