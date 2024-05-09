package spring.data;

public class PhotoDto {
	
	private String foodname;
	private String photo;
	
	//생성자
	public PhotoDto(String fname,String photo) {
		this.foodname=fname;
		this.photo=photo;
	}
	
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
}
