package Day0105;

import java.util.Scanner;

public class OperTest_04 {
	
	public static void main(String[] args) {
		// 두 수를 입력해서 산술연산자를 이용해서 출력(+,-,*,/,%)
		/*
		 * 
		 * 두 수를 입력해주세요
		 * 6
		 * 2
		 * 
		 * [산술연산자 결과]
		 * 더하기 : 8
		 * 빼기 : 4
		 * 곱하기 :
		 * 나누기 :
		 * 나머지값 :
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int x,y;
		
		System.out.print("첫번째 숫자: ");
		x = sc.nextInt();
		
		System.out.print("두번째 숫자: ");
		y = sc.nextInt();
		
		System.out.println("[산술연산자 결과]");
		System.out.println("더하기 : "+(x+y));
		System.out.println("빼기 : "+(x-y));
		System.out.println("곱하기 : "+(x*y));
		System.out.println("나누기 : "+(double)x/y);
		System.out.println("나머지값 : "+(x%y));
		
		
		
		
		
	}

}
