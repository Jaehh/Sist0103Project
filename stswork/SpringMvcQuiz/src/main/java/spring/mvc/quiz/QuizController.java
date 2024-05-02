package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
	
	@GetMapping("/happy")
	public String happy() {
		
		return "happy"; //WEB-INF/data/happy.jsp
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("msg", "QuizController");
		
		return "hello";
	}
	
	@GetMapping("/nice/like")
	public String nice(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("hp", "010-2222-5555");
		model.addAttribute("addr", "서울시 강남구");
		return "nice";
	}
}
