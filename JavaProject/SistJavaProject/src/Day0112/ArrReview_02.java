package Day0112;

class Shop{
	private String productName;
	private int price;
	private String color;
	
	private static int no;
	
	static String shopName = "쌍용";
	
	//명시적 생성자
	public Shop(String name, int price,String color) {
		this.productName = name;
		this.price = price;
		this.color = color;
	}
	
	//제목
	public static void showTitle() {
		System.out.println("["+shopName+"매장 입고상품]");
		System.out.println();
		System.out.println("번호\t상품명\t가격\t색상");
		System.out.println("====================================");
	}
	
	//출력
	public void show() {
		no++;
		System.out.println(no+"\t"+productName+"\t"+price+"\t"+color);
	}
}

public class ArrReview_02 {

	public static void main(String[] args) {
		
		Shop[] shop = new Shop[4];
		
		shop[0] = new Shop("요가매트",25000,"핑크");
		shop[1] = new Shop("아령",30000,"블랙");
		shop[2] = new Shop("요가매트",45000,"베이지");
		shop[3] = new Shop("요가매트",22000,"화이트");
		
		
		Shop.showTitle();
		
		for(Shop s:shop) {
			s.show();
		}
		
		for(int i=0;i<shop.length;i++) {
			shop[i].show();
		}
	}
}
