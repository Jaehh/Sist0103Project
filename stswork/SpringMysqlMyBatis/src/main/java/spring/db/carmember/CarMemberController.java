package spring.db.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/carmember")
public class CarMemberController {
	
	@Autowired
	CarMemberDaoInter memInter;
	
	@GetMapping("/list")
	public String list(Model model) {
		int totalCount = memInter.getTotalCount();
		
		List<CarMemberDto> list = memInter.getAllMemDatas();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "carmember/memberlist";
	}
	
	@GetMapping("/writeform")
	public String memform()
	{
		return "carmember/memberform";
	}
	
	@PostMapping("/write")
	public String insert(@ModelAttribute("dto") CarMemberDto dto)
	{
		memInter.insertMem(dto);
		return "redirect:list";
	}
	
	@GetMapping("/updateform")
	public String uform(@RequestParam String num, Model model) {
		
		CarMemberDto dto = memInter.getOneData(num);
		model.addAttribute("dto",dto);
		return "carmember/updateform";
	}
	
	@PostMapping("update")
	public String update(@ModelAttribute CarMemberDto dto) {
		
		memInter.updateCarMember(dto);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String num) {
		memInter.deleteMember(num);
		return "redirect:list";
	}
}
