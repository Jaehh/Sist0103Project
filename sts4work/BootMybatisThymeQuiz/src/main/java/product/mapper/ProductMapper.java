package product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import product.dto.ProductDto;

public interface ProductMapper {

	public int getTotalCount();
	public void insertProduct(ProductDto dto);
	
	@Select("select * from product order by pro_num asc")
	public List<ProductDto> getAllProducts();
	
	 @Select("select * from product where pro_num = #{pro_num}")
	 public ProductDto getProduct(int num);
}
