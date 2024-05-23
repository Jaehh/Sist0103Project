package myshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import myshop.dto.ShopDto;
import myshop.service.MyShopService;

@Controller
@RequiredArgsConstructor
public class MyShopController {
	
	private final MyShopService shopService;

	@GetMapping("/")
	public String list(Model model) {
		
		int totalCount=shopService.getTotalCount();
		
		List<ShopDto> list=shopService.getAllSangpums();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
				
		return "myshop/shoplist";
		
	}
	
	@GetMapping("/addform")
	public String form() {
		return "myshop/shopform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ShopDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		
		//실제경로
		String realPath = session.getServletContext().getRealPath("/photo");
		System.out.println(realPath);
		
		String photoname = upload.getOriginalFilename();
		dto.setPhoto(photoname);
		
		if(upload.isEmpty()) {
			dto.setPhoto("no");
		}else {
			dto.setPhoto(photoname);
			
			//실제업로드
			try {
				upload.transferTo(new File(realPath+"\\"+photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//db에 저장
		shopService.insertShop(dto);
		
		return "redirect:/";
	}
	
	 @GetMapping("/detail")
	    public String detail(@RequestParam int num, Model model) {
	        ShopDto dto = shopService.getData(num);
	        model.addAttribute("dto", dto);

	        return "myshop/shopdetail";
	    }
	
	 //삭제
	    @GetMapping("/delete")
	    public String delete(@RequestParam int num,Model dao,HttpSession session) {
	    	String oldFileName=shopService.getData(num).getPhoto();
	    	String realPath=session.getServletContext().getRealPath("/photo");
	    	
	    	File file = new File(realPath+"\\"+oldFileName);
	    	if(file.exists()) {
	    		file.delete();
	    	}
	    	
	    	shopService.deleteShop(num);
	    	
	    	return "redirect:/";
	    }
	
}
