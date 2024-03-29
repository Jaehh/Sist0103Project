package Day0115;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopArrayList_10 {

	List<Shop_10> list = new ArrayList<Shop_10>();
	
	public void ipgo() {
		Scanner sc = new Scanner(System.in);
		String sangName;
		int su,dan;
		
		System.out.print("상품명: ");
		 sangName = sc.nextLine();
		 System.out.print("가격: ");
		 dan = Integer.parseInt(sc.nextLine());
		 System.out.print("수량: ");
		 su = Integer.parseInt(sc.nextLine());
		 
		 Shop_10 shop = new Shop_10();
		 shop.setSangName(sangName);
		 shop.setDan(dan);
		 shop.setSu(su);
		 
		 list.add(shop);
		 
		 System.out.println("현재입고된 상품개수: "+list.size()+"개 입니다");
	}
	
	public void jego() {
		System.out.println("상품 재고 현황");
		System.out.println();
		System.out.println("No.\t상품명\t가격\t수량\t총액");
		System.out.println("=======================================");
		for(int i=0;i<list.size();i++) {
			Shop_10 s = list.get(i);
			System.out.println((i+1)+"\t"+s.getSangName()+"\t"+s.getDan()+"\t"+s.getSu()+"\t"+s.getTot());
			System.out.println("===================================");
		}
	}
	
	public static void main(String[] args) {
		ShopArrayList_10 sa = new ShopArrayList_10();
		Scanner sc = new Scanner(System.in);
		
		int n;
		
		while(true) {
			System.out.println("1.상품입고 2.상품재고 9.종료");
			n = Integer.parseInt(sc.nextLine());
			
			if(n==1) {
				sa.ipgo();
			} else if(n==2) {
				sa.jego();
			}else if(n==9) {
				System.out.println("종료합니다");
				break;
			}
		}
		

	}

}
