package Day0105;

import java.util.Scanner;

public class IfTest_12 {

	public static void main(String[] args) {
		// 숫자 하나를 입력하여 결과를 출력하시오
		/*
		 * 
		 * 당신이 좋아하는 숫자는?
		 * 99
		 * 
		 * 그 숫자는 홀수입니다.
		 * *~다음에 만나요~*
		 * 
		 * */

		Scanner sc = new Scanner(System.in);

		int num;
		String msg;

		System.out.println("당신이 좋아하는 숫자는?");
		num = sc.nextInt();


		
		 	
		 
		
		
		//삼항연산자
		//구하려는 값=수식1?"참":"거짓"
		//msg=num%2==0?"짝수:"홀수";
		
		System.out.println("***switch문***");
		
		switch(num%2) {
		case 0:
			System.out.println("짝수");
		    break;
		case 1:
			System.out.println("홀수");
			break;
		}
		
		
		
		
		
	}
}

