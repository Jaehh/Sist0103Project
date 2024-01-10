package Day0110;

class Ipgo{
	private String sangName;
	private int price;
	
	//set 메서드
	public void setName(String sangName) {
		this.sangName = sangName;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	//get 메서드
	public String getName() {
		return sangName;
	}
	
	public int getPrice() {
		return price;
	}
	
}

public class SangpumIpgo_13 {

	public static void main(String[] args) {
		
		Ipgo in1 = new Ipgo();
		in1.setName("애플워치");
		in1.setPrice(580000);
		
		String name1= in1.getName();
		int price1 = in1.getPrice();
		
		Ipgo in2 = new Ipgo();
		in2.setName("에어팟");
		in2.setPrice(320000);
		
		String name2= in2.getName();
		int price2 = in2.getPrice();
		
		System.out.println(name1+","+price1+"원");
		System.out.println(name2+","+price2+"원");

	}

}
