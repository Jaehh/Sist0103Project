package Day0104;

import java.util.Scanner;

public class QuizKeyBordIn_16 {

	public static void main(String[] args) {
	/*
	 * 상품명을 입력하세요 ===> 아이폰15
	 * 가격은 얼마입니까? ===> 1200000
	 * 수량은 몇개입니까? ===> 5
	 * 
	 * 상품입고
	 * =================================
	 * 입고상품명: 아이폰13
	 * 수량: 5개
	 * 가격: 1200000원
	 * =================================
	 * 총가격: 6000000원
	 * 
	 * */
		
		Scanner sc= new Scanner(System.in);
		
		//변수선언
		String product;
		int price;
		int num;
		int total;
		
		//입력
		System.out.print("상품명을 입력하세요 ===> ");
		product=sc.nextLine();
		
		System.out.print("가격은 얼마입니까? ===> ");
		price=sc.nextInt();
		
		System.out.print("수량은 몇 개 입니까? ===> ");
		num=sc.nextInt();
		
		//계산
		total = price*num;
		
		//최종출력
		System.out.println("\t[상품 입고]");
		System.out.println("====================================");
		System.out.println("입고상품명: "+product);
		System.out.println("수량: "+num+"개");
		System.out.println("가격: "+price+"원");
		System.out.println("====================================");
		System.out.println("총가격: "+total+"원");
		
	}

}
