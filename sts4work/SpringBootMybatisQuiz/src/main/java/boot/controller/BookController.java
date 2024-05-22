package boot.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.BookDto;
import boot.data.BookMapperInter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BookController {
    
    @Autowired
    BookMapperInter mapper;
    
    @GetMapping("/")
    public String start() {
        return "redirect:book/list";
    }
    
    @GetMapping("/book/list")
    public ModelAndView list() {
        ModelAndView mview = new ModelAndView();
        
        // DB로부터 상품 목록 가져오기
        List<BookDto> bookList = mapper.getAllBooks();
        
        // DB로부터 총 갯수 얻기
        int totalBook = mapper.getTotalBook();
        
        mview.addObject("bookList", bookList);
        mview.addObject("totalCount", totalBook);
        
        mview.setViewName("book/booklist");
        return mview;
    }
    
    @GetMapping("/book/addform")
    public String form() {
        return "book/addform";
    }
    
    @PostMapping("/book/insert")
    public String insertBook(@ModelAttribute BookDto dto,
                             @RequestParam MultipartFile photo,
                             HttpServletRequest request) {
        
        String path = request.getServletContext().getRealPath("/bookphoto");
        
    	if(photo.getOriginalFilename().equals(""))
			dto.setBookname(null);
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String photoname=sdf.format(new Date())+photo.getOriginalFilename();
			dto.setBookname(photoname);
	
			try {
				photo.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
        
        // DB에 insert
        mapper.insertBook(dto);
        
        return "redirect:list";
    }
    
    // 수정 폼
    @GetMapping("/book/updateform")
    public ModelAndView uform(@RequestParam String num) {
        ModelAndView mview = new ModelAndView();
        
        BookDto dto = mapper.getBook(num);
        
        mview.addObject("dto", dto);
        mview.setViewName("book/updateform");
        return mview;
    }
    
    // update
    @PostMapping("/book/update")
    public String update(@ModelAttribute BookDto dto,
                         @RequestParam("bookimage") MultipartFile photo,
                         HttpServletRequest request) {
        
        String path = request.getServletContext().getRealPath("/bookphoto");
        
        if (!photo.isEmpty()) {
            // 수정 전에 이전에 저장된 사진 지우기
            String pre_photo = mapper.getBook(dto.getNum()).getBookimage();
            File file = new File(path + "\\" + pre_photo);
            
            if (file.exists()) {
                file.delete();
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String bookimage = sdf.format(new Date()) + "_" + photo.getOriginalFilename();
            dto.setBookimage(bookimage); // DTO의 필드에 파일 이름 설정
            
            try {
                photo.transferTo(new File(path + "\\" + bookimage));
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        
        mapper.updateBook(dto);
        return "redirect:list";
    }
    
    // delete
    @GetMapping("/book/delete")
    public String delete(@RequestParam String num, HttpSession session) {
        
        String photo = mapper.getBook(num).getBookimage();
        if (photo != null) {
            String path = session.getServletContext().getRealPath("/bookphoto");
            
            File file = new File(path + "\\" + photo);
            
            if (file.exists()) {
                file.delete();
            }
        }
        
        mapper.deleteBook(num);
        return "redirect:list";
    }
}