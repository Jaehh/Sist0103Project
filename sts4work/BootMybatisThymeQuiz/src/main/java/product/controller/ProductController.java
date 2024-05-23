package product.controller;

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
import product.dto.ProductDto;
import product.service.ProductService;


@Controller
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

	@GetMapping("/")
	public String list(Model model) {
		
		int totalCount=productService.getTotalCount();
		
		List<ProductDto> list=productService.getAllProducts();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
				
		return "product/productlist";
		
	}
	
	@GetMapping("/addform")
	public String form() {
		return "product/addform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ProductDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		
		//실제경로
		String realPath = session.getServletContext().getRealPath("/productimage");
		System.out.println(realPath);
		
		String photoname = upload.getOriginalFilename();
		dto.setPro_image(photoname);
		
		if(upload.isEmpty()) {
			dto.setPro_image("no");
		}else {
			dto.setPro_image(photoname);
			
			//실제업로드
			try {
				upload.transferTo(new File(realPath+"\\"+photoname));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//db에 저장
		productService.insertProduct(dto);
		
		return "redirect:/";
	}
	
	 @GetMapping("/detail")
	    public String detail(@RequestParam int num, Model model) {
	        ProductDto dto = productService.getProduct(num);
	        model.addAttribute("dto", dto);

	        return "product/productdetail";
	    }
	
}
