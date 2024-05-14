package spring.mvc.answer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.answerdata.AnswerDao;
import spring.mvc.answerdata.AnswerDto;

@Controller
public class AnswerController {

	@Autowired
	AnswerDao adao;
	
	@PostMapping("/board/ainsert")
	public String answerinsert(@ModelAttribute AnswerDto dto,
			@RequestParam String currentPage) {
		
		//db추가
		adao.insertAnswer(dto);
		
		//내용보기로 리다이렉트
		return "redirect:content?num="+dto.getNum()+"&currentPage="+currentPage;
	}
	
	
	
}
