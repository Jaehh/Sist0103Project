package spring.mvc.re;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.data.BoardDaoInter;
import spring.mvc.data.BoardDto;

@Controller
public class BoardWriteController {

	@Autowired
	BoardDaoInter dao;
	
	//���� ��� ��� �ش�
	
	@GetMapping("/board/writeform")
	public ModelAndView form(@RequestParam Map<String, String> map)
	{
		ModelAndView mview=new ModelAndView();
		
		//�Ʒ� 5���� ���� ����ϰ�쿡�� �Ѿ��(������ �ȳѾ��)
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String restep=map.get("restep");
		String relevel=map.get("relevel");
		
		System.out.println(currentPage+","+num);
		
		//�Է����� hidden���� �־������..����϶��� ���
		
		mview.addObject("currentPage", currentPage==null?"1":currentPage);
		mview.addObject("num", num==null?"0":num);
		mview.addObject("regroup", regroup==null?"0":regroup);
		mview.addObject("restep", restep==null?"0":restep);
		mview.addObject("relevel", relevel==null?"0":relevel);
		
		//0���� �־�� dao���� ���۷� �ν�
		
		
		mview.setViewName("board/writeform");
		return mview;
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute BoardDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session,
			@RequestParam String currentPage)
	{
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(path);
		
		String photo="";
		if(upload.get(0).getOriginalFilename().equals(""))
			photo="no";
		else {
			
			for(MultipartFile f:upload)
			{
				String fName=sdf.format(new Date())+f.getOriginalFilename();
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
			
			photo=photo.substring(0, photo.length()-1);
			
		}
		
		dto.setPhoto(photo);
		dao.insertBoard(dto);
		
		//insert 후 목록으로 가지말고 내용보기로 가려면
		int num = dao.getMaxNum();
		
		return "redirect:content?num="+num+"&currentPage="+currentPage;
	}
}