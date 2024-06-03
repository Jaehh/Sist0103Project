package boot.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.ReBoardDto;
import boot.data.mapper.ReBoardMapperInter;

@Service
public class ReBoardService implements ReBoardServiceInter {

	@Autowired
	ReBoardMapperInter mapperInter;
	
	public int getTotalCount(String searchcolumn, String searchword) {
		
		Map<String, String> map=new HashMap<>();
		map.put("searchcolumn", searchword);
		map.put("searchword",searchword);
		
		return mapperInter.getTotalCount(map);
	}

	@Override
	public void insertReBoard(ReBoardDto dto) {
		
		int num = dto.getNum(); //새글이면 이미 0이 들어가 있음
		int regroup = dto.getRegroup();
		int restep = dto.getRestep();
		int relevel = dto.getRelevel();
		
		if(num==0) {  //새글인경우
			regroup=this.getmaxNum()+1;
			restep=0;
			relevel=0;
		}else { //답긍일경우
			//같은 그룹 중에서 전달받은 restep보다 큰값들은 모두 일괄 +1
			this.updateRestep(regroup, restep);
			//그리고나서 전달받은 값보다 1크게 db에 저장
			restep++;
			relevel++;
		}
		//변경된 값들을 다시 dto에 넣는다
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//insert
		mapperInter.insertReBoard(dto);
		
		mapperInter.insertReBoard(dto);
		
	}

	@Override
	public List<ReBoardDto> getPagingList(String searchcolumn, String searchword, int startnum, int perpage) {
		Map<String, Object> map=new HashMap<>();
		map.put("searchcolumn", searchcolumn);
		map.put("searchword", searchword);
		map.put("startnum", startnum);
		map.put("perpage", perpage);
		
		return mapperInter.getPagingList(map);
	}

	@Override
	public ReBoardDto getData(int num) {
		
		return mapperInter.getData(num);
	}

	@Override
	public void updateRestep(int regroup, int restep) {
		Map<String, Integer> map = new HashMap<>();
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		mapperInter.updateRestep(map);
	}

	@Override
	public void updateReadCount(int num) {
		mapperInter.updateReadCount(num);
	}

	@Override
	public int getmaxNum() {
		
		return mapperInter.getmaxNum();
	}

	@Override
	public void deleteBoard(int num) {
		
	}

	@Override
	public void likesUpdate(int num) {
		// TODO Auto-generated method stub
		
	}
}
