package Day0111;

class Shop{
	private String sangpum;
	private int price;
	private String sangColor;
	
	public Shop(String s, int p, String c) {
		sangpum = s;
		price = p;
		sangColor =c;
	}
	
	//제목
	public static void showTitle() {
		System.out.println("상품명\t가격\t색상");
	    System.out.println("=======================");
	}
	
	//생성한 갯수만큼 출력
	public void showShop() {
		System.out.println(sangpum+"\t"+price+"원\t"+sangColor);
	}
}

public class ArrObTest_11 {

	public static void main(String[] args) {
		//4개 생성해서 출력할 것
		
		Shop[] shop = new Shop[4];
		
		//4개의 shop배열에 생성자를 통해서 생성
		shop[0]= new Shop("노트북", 20000, "white");
		shop[1]= new Shop("키보드", 20000, "black");
		shop[2]=new Shop("마우스", 60000, "gray");	
		shop[3]=new Shop("마우스", 70000, "blue");
		
		//출력
		Shop.showTitle();
		
		for(Shop s:shop) {
			s.showShop();
			System.out.println("-----------------------");
			
			Shop.showTitle();
			for(int i=0;i<shop.length;i++) {
				shop[i].showShop();
			}
		}
		
	}
}
