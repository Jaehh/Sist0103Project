package spring.day0502.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {
	
	@GetMapping("/")
	public String start() {
		return "redirect:login/form";
	}
	
	@GetMapping("/login/form")
	public String form() {
		return "form";
	}
	
	//폼전송
	@GetMapping("/login/read")
	public String process(Model model,@RequestParam(value="myid") String id,
			@RequestParam(value="mypass")String pass) {
		
		model.addAttribute("id", id);
		
		//비밀번호가 1234면 로그인성공, 아니면 실패
		String msg="";
		if(pass.equals("1234")) {
			msg="로그인성공!!";
		}else {
			msg="로그인실패!!";
		}
		
		model.addAttribute("msg", msg);
		
		return "result";
	}
}
