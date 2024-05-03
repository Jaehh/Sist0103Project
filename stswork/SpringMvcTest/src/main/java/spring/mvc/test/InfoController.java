package spring.mvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {
	
	@GetMapping("/info/myform")
	public String form() {
		return "infoform";
	}
	
	@PostMapping("/info/result")
	public ModelAndView info(@ModelAttribute InfoDto dto) {
		ModelAndView model = new ModelAndView();
		model.addObject("dto",dto);
		model.setViewName("infowrite");
		
		return model;
		
	}
}
