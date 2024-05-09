package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.data.PhotoDto;

@Controller
public class JsonTestController {
	
	@GetMapping("/list1")
	@ResponseBody
	public Map<String, String> list1(){
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name","홍길동");
		map.put("hp","010-1111-2222");
		map.put("addr", "서울시 강남구");

		return map;
	}


		@GetMapping("/foodlist2")
		@ResponseBody
		public List<PhotoDto> list2(){
			List<PhotoDto> list = new ArrayList<PhotoDto>();
			
			list.add(new PhotoDto("샌드위치","1.jpg"));
			list.add(new PhotoDto("꼬치구이","2.jpg"));
			list.add(new PhotoDto("망고빙수","11.jpg"));
			list.add(new PhotoDto("포테이토리조또","5.jpg"));
			list.add(new PhotoDto("토마토스튜","7.jpg"));
			
			return list;
		}


}