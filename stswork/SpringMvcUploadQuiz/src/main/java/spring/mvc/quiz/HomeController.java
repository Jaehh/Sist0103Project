package spring.mvc.quiz;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/quiz")
public class HomeController {

	@GetMapping("/myshop")
	public String home() {
		
		return "quiz/quizUploadForm";
	}
	
	@PostMapping("/shopwrite")
	public ModelAndView shopwrite(
			@RequestParam String sang,
			@RequestParam ArrayList<MultipartFile> photo,
			@RequestParam String price,
			@RequestParam String ipgo,
		    HttpServletRequest request) {
	   ModelAndView mview = new ModelAndView();
	
	   //업로드할 실제경로 구하기
	   String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
	   
	   //현재날짜와 시간을 이용해 파일명 저장
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	   
	   ArrayList<String> files=new ArrayList<String>();
	   
	   //파일명 담기
	   for(MultipartFile f:photo) {
		   String fileName = sdf.format(new Date())+"_"+f.getOriginalFilename();
		   files.add(fileName);
		   
		   //실제업로드
		   try {
			f.transferTo(new File(path+"\\"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   mview.addObject("files", files);
	   mview.addObject("sang", sang);
	   mview.addObject("price", price);
	   mview.addObject("ipgo", ipgo);
	   mview.addObject("path", path);
	   
	   mview.setViewName("/quiz/quizUploadWrite");
	   
	   return mview;
	
	}
	
}
