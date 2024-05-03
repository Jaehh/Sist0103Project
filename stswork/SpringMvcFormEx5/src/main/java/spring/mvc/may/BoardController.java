package spring.mvc.may;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/form")
	public String form1() {
		return "board/writeform";
	}
	
	@PostMapping("/process")
	public ModelAndView process(@RequestParam String name,
			@RequestParam String date,
			@RequestParam String gender,
			//required는 기본이 true - 항목이 없으면 에러가 나기 때문에 기본값을 false로 바꿔줘야한다
			@RequestParam (required = false) String msg,
			//required 아니면 defaultValue를 사용
			@RequestParam(name="pageNum",defaultValue = "1")int currentPage) {

		ModelAndView model = new ModelAndView();
		
		model.addObject("name", name);
		model.addObject("date", date);
		model.addObject("gender",gender);
		model.addObject("msg", msg);
		model.addObject("currentPage", currentPage);
		
		//포워드
		model.setViewName("board/result");
		
		return model;
	}
	
	@GetMapping("/result2")
	public String result2(Model model) {
		
		model.addAttribute("myimg1", "../image/toy01.png");
		model.addAttribute("title", "내가 만든 고양이 캐릭터");
		
		return "board/result2";
	}
	
	//list.jsp로 포워드만
	@GetMapping("/list")
	public String list() {
		return "board/list";
	}
}
