package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("mdto")
public class MarketDto {

	private String num;
	private String sang;
	private String dan;
	private String photoname;
	private Timestamp ipgoday;
	
}
