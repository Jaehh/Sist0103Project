package spring.mvc.quiz2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Quiz2Controller {
	
	@GetMapping("/")
	public String sawonform() {
		return "testform";
	}
	
	@PostMapping("/info")
	public ModelAndView info(@ModelAttribute SawonDto dto) {
		ModelAndView model = new ModelAndView();
		model.addObject("dto",dto);
		model.setViewName("sawoninfo");
		
		return model;
		
	}

}
