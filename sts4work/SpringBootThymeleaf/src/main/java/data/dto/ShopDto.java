package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만듦
@Builder
public class ShopDto {
	
	private int num;
	private String sangpum;
	private int su;
	private int dan;
	private String color;
	
}
