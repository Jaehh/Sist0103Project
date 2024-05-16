package boot.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {
	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mview = new ModelAndView();
		
		mview.addObject("name","이효리");
		mview.addObject("addr","제주시 애월음");
		
		mview.setViewName("list");
		
		return mview;
	}
	
}
