package spring.mvc.may;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@GetMapping("/dtoform")
	public String dtoform() {
		return "shop/formdto";
	}
	
	//dto처리
	@PostMapping("/process1")
	public ModelAndView process(@RequestParam String sang,
			@RequestParam String su,
			@RequestParam String price,
			@RequestParam String color) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("sang", sang);
		model.addObject("su", su);
		model.addObject("price",price);
		model.addObject("color", color);
		
		//포워드
		model.setViewName("shop/dtoresult");
		
		return model;
	}
	
	@GetMapping("/mapform")
	public String mapform() {
		return "shop/formmap";
	}
	
	//map처리
	@PostMapping("/process2")
	public ModelAndView read3(@RequestParam Map<String, String> map)
	{
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("sang", map.get("sang"));
		mview.addObject("su", map.get("su"));
		mview.addObject("price", map.get("price"));
		mview.addObject("color", map.get("color"));
		
		mview.setViewName("shop/mapresult");
		return mview;
	}
}
