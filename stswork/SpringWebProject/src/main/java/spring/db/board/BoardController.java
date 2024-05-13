package spring.db.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardDaoInter dao;
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam(value = "currentPage",defaultValue = "1")int currentPage)
	{
		ModelAndView mview=new ModelAndView();
		
		//����¡�� �ʿ��� ����
		int totalCount=dao.getTotalCount();
		int perPage=3; //���������� ������ ���� ����
		int perBlock=5; //�Ѻ����� ������ ������ ����
		int start; //db���� ������ ���� ���۹�ȣ(mysql�� ù����0��,����Ŭ�� 1��);
		int startPage; //�������� ������ ����������
		int endPage; //�������� ������ ��������
		int totalPage; //����������
		int no; //���������� ����� ���۹�ȣ

		//���������� ���Ѵ�
		//�ѱ۰���/���������纸���������� ����(7/5=1)
		//�������� 1�̶� ������ ������ 1������ �߰�(1+1=2�������� �ʿ�)
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

		//�������� ������ ����������
		//perBlock=5�ϰ�� ������������ 1~5�ϰ�� ������������1,���������� 5
		//���簡 13�ϰ�� ����:11 ��:15
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;

		//���������� 23�ϰ�� ������������ ���������� 25�� �ƴ϶� 23
		if(endPage>totalPage)
			endPage=totalPage;

		//������������ ������ ���۹�ȣ
		//1������:0, 2������:5 3������: 10.....
		start=(currentPage-1)*perPage;

		//���������� ����� ���۹�ȣ ���ϱ�
		//�ѱ۰����� 23  , 1������:23 2������:18  3������:13
		no=totalCount-(currentPage-1)*perPage;

		//����Ʈ
		//List<BoardDto> list=dao.getAllList();
		List<BoardDto> list=dao.getList(start, perPage);
		
		//����
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		mview.addObject("no", no);
		mview.addObject("startPage", startPage);
		mview.addObject("endPage", endPage);
		mview.addObject("currentPage", currentPage);
		mview.addObject("totalPage", totalPage);
		
		//������
		mview.setViewName("board/boardlist");
		
		return mview;
	}
	
	//�۾��� ��
	@GetMapping("/addform")
	public String addform()
	{
		
		return "board/writeform";
	}
	
	
	//insert
	@PostMapping("/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session,
			@RequestParam String currentPage)
	{
		//�̹����� ���ε�� ����
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		//�̹��� ���ε� ��������� null or "no"
		String photo="";
		
		//���������� �ϸ� ,�γ���
		if(upload.get(0).getOriginalFilename().equals(""))
			photo="no";
		else {
			
			for(MultipartFile f:upload)
			{
				String fName=f.getOriginalFilename();
				photo+=fName+",";
				
				//���ε�
				try {
					f.transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//photo���� ������ �ĸ�����
			photo=photo.substring(0, photo.length()-1);
		}
		
		//dto�� photo�� �־��ֱ�
		dto.setPhoto(photo);
		
		//insert
		dao.insertBoard(dto);
		
		//����� �ƴ� ���뺸��� ������
		int num=dao.getMaxNum();
		
		return "redirect:content?num="+num+"&currentPage="+1;
	}
	
	//�󼼺���� ����
	@GetMapping("/content")
	public String content(@RequestParam int num,Model model,
			@RequestParam String currentPage)
	{
		dao.updateReadcount(num);
		
		//dto�����ͼ� request�� ����
		BoardDto dto=dao.getData(num);
		
		model.addAttribute("dto", dto);
		model.addAttribute("currentPage", currentPage);
		
		return "board/content";
	}
	
	
	@GetMapping("/updateform")
	public  ModelAndView uform(@RequestParam int num,
			@RequestParam String currentPage) {
		ModelAndView model = new ModelAndView();
		
		BoardDto dto = dao.getData(num);
		model.addObject("dto", dto);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("board/updateform");
		return model;
	}
	
	//update
		@PostMapping("/update")
		public String update(@ModelAttribute BoardDto dto,
				@RequestParam ArrayList<MultipartFile> upload,
				HttpSession session,
				@RequestParam String currentPage)
		{
			//�̹����� ���ε�� ����
			String path=session.getServletContext().getRealPath("/WEB-INF/photo");
			System.out.println(path);
			
			//�̹��� ���ε� ��������� null or "no"
			String photo="";
			
			//사진 선택 안했을 경우는 null, 사진선택을 하면,로 나열
			if(upload.get(0).getOriginalFilename().equals(""))
				photo=null;
			else {
				
				for(MultipartFile f:upload)
				{
					String fName=f.getOriginalFilename();
					photo+=fName+",";
					
					//���ε�
					try {
						f.transferTo(new File(path+"\\"+fName));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//photo���� ������ �ĸ�����
				photo=photo.substring(0, photo.length()-1);
			}
			
			//dto�� photo�� �־��ֱ�
			dto.setPhoto(photo);
			
			//update
			dao.updateBoard(dto);
			
			//����� �ƴ� ���뺸��� ������
			int num=dao.getMaxNum();
			
			return "redirect:content?num="+num+"&currentPage="+currentPage;
		}
		
		@GetMapping("/delete")
		public String delte(@RequestParam int num,
				@RequestParam String currentPage,
				HttpSession session) {
			
			String photo=dao.getData(num).getPhoto();
			if(!photo.equals("no")) {
				String []fName=photo.split(",");
				
				//실제업로드경로
				String path=session.getServletContext().getRealPath("/WEB-INF/photo");
				
				for(String f:fName) {
					File file=new File(path+"\\"+f);
					file.delete();
				}
				
			}
			
			//db삭제
			dao.deleteBoard(num);
			
			return "redirect:list?currentPage="+currentPage;
		}
		
		@GetMapping("/list2")
		public String list2() {
			
			return "/board/ajaxlist";
		}
	
}