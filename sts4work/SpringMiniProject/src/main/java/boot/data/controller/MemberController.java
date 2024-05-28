package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemberDto;
import boot.data.mapper.MemberMapperInter;
import boot.data.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@Autowired
	MemberMapperInter mapper;
	
	@GetMapping("/member/list")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		
		List<MemberDto> list = service.getAllMembers();
		
		mview.addObject("list", list);
		mview.addObject("mcount", list.size());
		
		mview.setViewName("/member/memberlist");
		return mview;
	}
	
	@GetMapping("/member/form")
	public String form()
	{
		return "/member/memberform";
	}
	
	//id체크
	 @GetMapping("/member/idcheck")
	    @ResponseBody
	    public Map<String, Integer> idcheckprocess(@RequestParam String id) {
	        Map<String, Integer> map = new HashMap<>();

	        // id 체크 메서드 호출
	        int n = service.getSerchId(id);

	        map.put("count", n); // 1 or 0

	        return map;
	    }
	 
	 @PostMapping("/member/insert")
		public String insert(@ModelAttribute MemberDto dto,
				MultipartFile myphoto,
				HttpSession session)
		{
			
			String path=session.getServletContext().getRealPath("/memberphoto");
			
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
					
					String fileName=sdf.format(new Date())+"_"+myphoto.getOriginalFilename();
			dto.setPhoto(fileName);
			
			try {
				myphoto.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mapper.insertMember(dto);
			return "redirect:list";
		}
	 
	 //회원정보로 가기
	 @GetMapping("/member/myinfo")
	 public String myinfo(Model model) {
		 
		 List<MemberDto> list = service.getAllMembers();
		 
		 model.addAttribute("list", list);
		 
		 return "/member/memberinfo";
	 }
}