package boot.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemberDto;
import boot.data.dto.ReBoardDto;
import boot.data.service.ReBoardService;

@Controller
public class ReBoardController {

	@Autowired
	ReBoardService boardService;
	
	@GetMapping("/reboard/list")
	public ModelAndView list(@RequestParam(value="currentPage",defaultValue="1")int currentPage,
			@RequestParam(value="searchcolumn",required=false) String sc,
			@RequestParam(value="searchword",required=false) String sw) {
		ModelAndView mview = new ModelAndView();	
		
		//페이징에 필요한 변수
				int totalCount=dao.getTotalCount();
				int perPage=3; //한페이지당 보여질 글의 갯수
				int perBlock=5; //한블럭당 보여질 페이지 갯수
				int start; //db에서 가져올 글의 시작번호(mysql은 첫글이0번,오라클은 1번);
				int startPage; //각블럭당 보여질 시작페이지
				int endPage; //각블럭당 보여질 끝페이지
				int totalPage; //총페이지수
				int no; //각페이지당 출력할 시작번호

				//총페이지수 구한다
				//총글갯수/한페이지당보여질갯수로 나눔(7/5=1)
				//나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
				totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

				//각블럭당 보여질 시작페이지
				//perBlock=5일경우 현재페이지가 1~5일경우 시작페이지가1,끝페이지가 5
				//현재가 13일경우 시작:11 끝:15
				startPage=(currentPage-1)/perBlock*perBlock+1;
				endPage=startPage+perBlock-1;

				//총페이지가 23일경우 마지막블럭은 끝페이지가 25가 아니라 23
				if(endPage>totalPage)
					endPage=totalPage;

				//각페이지에서 보여질 시작번호
				//1페이지:0, 2페이지:5 3페이지: 10.....
				start=(currentPage-1)*perPage;

				//각페이지당 출력할 시작번호 구하기
				//총글개수가 23  , 1페이지:23 2페이지:18  3페이지:13
				no=totalCount-(currentPage-1)*perPage;

				//리스트
				//List<BoardDto> list=dao.getAllList();
				List<ReBoardDto> list=boardService.getPagingList(sc,sw,start, perPage);
				
				//저장
				mview.addObject("totalCount", totalCount);
				mview.addObject("list", list);
				mview.addObject("no", no);
				mview.addObject("startPage", startPage);
				mview.addObject("endPage", endPage);
				mview.addObject("currentPage", currentPage);
				mview.addObject("totalPage", totalPage);
				
				//포워드
				mview.setViewName("board/boardlist");
		
		return mview;
	}
}
