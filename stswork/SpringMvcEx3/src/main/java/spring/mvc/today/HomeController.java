package spring.mvc.today;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping(value="/")
	public String home(Model model) {
		
		model.addAttribute("msg","HomeController");
		model.addAttribute("today",new date());
		
		return "home";
	}
	
	@GetMapping("apple/list")
	public String applelist(Model model) {
		model.addAttribute("stuName","������");
		model.addAttribute("stuLoc","4������");
		
		return "stuResult1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana() {
		
		//ModelAndView�� request�� �����ϱ� ���� Model�� �����带 ���� View�� ���ĳ��� Ŭ����
		ModelAndView mview = new ModelAndView();
		
		//request�� ����
		mview.addObject("java",88);
		mview.addObject("mysql", 77);
		
		//�������� jsp���� ����
		mview.setViewName("scoreResult");
		
		return mview;
	}
	
	@GetMapping("/orange/select")
	public String orange(Model model,HttpSession session) {
		
		//request�� ����
		model.addAttribute("s_msg", "������ ���� ������!!");
		
		//session�� ����
		session.setAttribute("myid", "admin");
		return "orangeResult";
	}
	
	@GetMapping("/shop/detail") //today/shop/detail
	public String resShop() {
		
		return "resResult";
	}
	
	
}
