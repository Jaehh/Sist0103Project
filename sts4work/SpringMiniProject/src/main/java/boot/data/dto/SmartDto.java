package boot.data.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("SmartDto")
@Data
public class SmartDto {

	private int num;
	private int price;
	private String sangpum;
	private String color;
	private String content;
	private String ipgoday;
}
