package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemBoardDto;
import boot.data.service.AnsMboardService;
import boot.data.service.MemBoardService;
import boot.data.service.MemberService;

@Controller
public class BoardController {

	@Autowired
	MemBoardService service;
	
	@Autowired
	MemberService mservice;
	
	@Autowired
	AnsMboardService aservice;
	
	
	@GetMapping("/board/list")
	public ModelAndView list(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage)
	{
		ModelAndView mview=new ModelAndView();
		
		int totalCount=service.getTotalCount();
		
		//페이징에 필요한 변수
				
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
				List<MemBoardDto> list=service.getList(start, perPage);
				
				//댓글개수
				for(MemBoardDto d:list)
				{
					d.setAcount(aservice.getAllAnswer(d.getNum()).size()); //댓글리스트에 포함
					System.out.println(aservice.getAllAnswer(d.getNum()).size());
				}
				
				
				//저장
				mview.addObject("totalCount", totalCount);
				mview.addObject("list", list);
				mview.addObject("no", no);
				mview.addObject("startPage", startPage);
				mview.addObject("endPage", endPage);
				mview.addObject("currentPage", currentPage);
				mview.addObject("totalPage", totalPage);
		
		
		mview.setViewName("/board/boardlist");
		return mview;
	}
	
	@GetMapping("/board/form")
	public String form()
	{
		return "/board/writeform";
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute MemBoardDto dto,HttpSession session)
	{
		String path=session.getServletContext().getRealPath("/boardphoto");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		if(dto.getUpload().getOriginalFilename().equals(""))
			dto.setUploadfile("no");
		else {
			String uploadfile=sdf.format(new Date())+dto.getUpload().getOriginalFilename();
			dto.setUploadfile(uploadfile);
			
			try {
				dto.getUpload().transferTo(new File(path+"\\"+uploadfile));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		//세션에서 아이디 얻어서 dto저장
		String myid=(String)session.getAttribute("myid");
		dto.setMyid(myid);
		
		//이름
		String name=mservice.getName(myid);
		dto.setName(name);
		
		//insert
		service.insertMemBoard(dto);
		
		
		
		return "redirect:list";
	}
	
	
	//content로이동
	//조회수,dto
	@GetMapping("/board/content")
	public ModelAndView content(String num,@RequestParam(defaultValue = "1") int currentPage)
	{
		ModelAndView mview=new ModelAndView();
		
		service.updateReadCount(num);
		MemBoardDto dto=service.getData(num);
		
		
		//업로드 파일의 확장자 얻기
		int dtoLoc=dto.getUploadfile().lastIndexOf('.');
		String ext=dto.getUploadfile().substring(dtoLoc+1); //다음글자부터 끝까지
		
		System.out.println(dtoLoc+","+ext);
		
		
		//이미지인지 아닌지 보고 출력하기위해서
		if(ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("gif") || ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpeg"))
			mview.addObject("bupload", true);
		else
			mview.addObject("bupload", false);
		
		
		mview.addObject("dto", dto);
		mview.addObject("currentPage", currentPage);
		
		mview.setViewName("/board/content");		
		return mview;
	}
}