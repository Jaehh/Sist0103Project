package product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import product.dto.ProductDto;
import product.mapper.ProductMapper;

@Service
@AllArgsConstructor
public class ProductService {
	
	private ProductMapper productmapper;
	
	public int getTotalCount() {
		return productmapper.getTotalCount();
	}
	public void insertProduct(ProductDto dto) {
		productmapper.insertProduct(dto);
	}
	public List<ProductDto> getAllProducts(){
		return productmapper.getAllProducts();
	}
	 public ProductDto getProduct(int num) {
	        return productmapper.getProduct(num);
	    }
	
}
