package info.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {
	
	@Autowired
	InfoDao dao;
	
	@GetMapping("/info/list")
	public ModelAndView list() {
		ModelAndView model = new ModelAndView();
		
		List<InfoDto> list = dao.getAlldatas();
		
		model.addObject("list", list);
		model.addObject("count", list.size());
		
		model.setViewName("info/infolist");
		return model;
	}
	
	//폼
	@GetMapping("/info/addform")
	public String form() {
        return "info/addform";
    }
	
	//insert
	@PostMapping("/info/insert")
	public String add(@ModelAttribute InfoDto dto) {
		dao.insertinfo(dto);
		return "redirect:list";
	}
	
	// 수정 폼
	@GetMapping("/info/updateform")
	public ModelAndView updateform(@RequestParam("num") Integer num) {
	    ModelAndView model = new ModelAndView();
	    
	    InfoDto dto = dao.getData(num);
	    
	    model.addObject("dto", dto);
	    model.setViewName("info/updateform");
	    
	    return model;
	}



    // update
    @PostMapping("/info/update")
    public String update(@ModelAttribute InfoDto dto) {
        dao.updateInfo(dto);
        return "redirect:list";
    }

    // delete
    @GetMapping("/info/delete")
    public String delete(@RequestParam("num") Integer num) {
        dao.deleteInfo(num);
        return "redirect:list";
    }
	
}
