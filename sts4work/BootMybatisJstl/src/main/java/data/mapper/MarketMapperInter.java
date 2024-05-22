package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import data.dto.MarketDto;

@Mapper
public interface MarketMapperInter {

	public int getTotalCount();
	public void insertMarket(MarketDto dto);
	public List<MarketDto> getAllDatas();
	public MarketDto getData(String num);
	public void updateMarket(MarketDto dto);
	public void deleteMarket(String num);
}
