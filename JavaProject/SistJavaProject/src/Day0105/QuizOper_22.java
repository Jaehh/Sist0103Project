package Day0105;

import java.util.Scanner;

public class QuizOper_22 {

	public static void main(String[] args) {
		/*
		 * 
		 * 상품명 : 키보드
		 * 수량 : 5
		 * 가격: 20000
		 * 
		 * ==========================
		 * **5개 이상 구매시 10% 할인됩니다
		 * 키보드 5개는 총 90000원 입니다.
		 * 할인된 금액 : 10000원
		 * 
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		String product;
		int num,cost,total,discount = 0;
		
		System.out.print("상품명 : ");
		product = sc.nextLine();
		
		System.out.print("수량 : ");
		num = sc.nextInt();
		
		System.out.print("가격 : ");
		cost = sc.nextInt();
		
		if(num>=5) {
			total = (int) (num*cost*0.9);
			discount = (int) (num*cost*0.1);
		} else {
			total = num*cost;
		}
		
		
		System.out.println("==============================");
		System.out.println("**5개 이상 구매시 10% 할인됩니다");
		System.out.println(product+num+"개는 총 "+total+"원 입니다.");
		System.out.println("할인된 금액 : "+discount+"원");

	}

}
