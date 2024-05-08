package spring.mysql.coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	MyShopDaoInter daoInter;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		List<MyShopDto> list = daoInter.getAllList();
		
		model.addAttribute("list", list);
		model.addAttribute("totalCount", list.size());
		
		return "home";
	}
	
}
