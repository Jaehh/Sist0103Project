package spring.day0507.rainy;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhotoUploadController {
	
	//업로드폼 1로 가기
	@GetMapping("/board/uploadform1")
	public String uploadform1() {
		return "board/uploadform1";
	}
	
	@PostMapping("/board/upload1")
	public ModelAndView read1(
			@RequestParam String title,
			@RequestParam MultipartFile photo,
		    HttpServletRequest request) {
	   ModelAndView mview = new ModelAndView();
	
	   //업로드할 실제경로 구하기
	   String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
	   System.out.println(path);
	   String fileName = photo.getOriginalFilename(); //업로드한 파일명
	   
	   //현재날짜와 시간을 이용해 파일명 저장
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	   
	   if(!fileName.equals("")) {
		   fileName = sdf.format(new Date())+"_"+fileName;
		   
		   //path에 업로드
		   try {
			photo.transferTo(new File(path+"\\"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }else {
		   fileName="no"; //업로드 안했을경우
	   }
	   
	   mview.addObject("fileName", fileName);
	   mview.addObject("title", title);
	   mview.addObject("path", path);
	   
	   mview.setViewName("/board/uploadresult1");
	   
	   return mview;
	
	}
	
	@GetMapping("/board/uploadform2")
	public String uploadform2() {
		return "board/uploadform2";
	}
	
	@PostMapping("/board/upload2")
	public ModelAndView read2(
			@RequestParam String title,
			@RequestParam ArrayList<MultipartFile> photo,
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
	   mview.addObject("title", title);
	   mview.addObject("path", path);
	   
	   mview.setViewName("/board/uploadresult2");
	   
	   return mview;
	
	}
}
