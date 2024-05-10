package spring.db.board;

import java.util.List;

public interface BoardDaoInter {

	public int getTotalCount();
	public int getMaxNum();
	public void insertBoard(BoardDto dto);
	public List<BoardDto> getAllList();
	public BoardDto getData(int num);
	public void updateReadcount(int num);
	public List<BoardDto> getList(int start,int perpage);
	
}