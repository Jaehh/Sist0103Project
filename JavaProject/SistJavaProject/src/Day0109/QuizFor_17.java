package Day0109;

import java.util.Scanner;

public class QuizFor_17 {

	public static void main(String[] args) {
		//quiz1();
		//quiz2();
		quiz3();

	}
	
	public static void quiz1() {
		// 팩토리얼 구할 숫자 입력하여 해당 숫자에 대한 팩토리얼 구하기
		/*
		 * 팩토리얼 구할 숫자 입력하세요
		 * 3
		 * 3! 은 6입니다. 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int num,sum = 1;
		
		System.out.println("팩토리얼 구할 숫자를 입력하세요");
	    num =sc.nextInt();
	    
		for(int i=1;i<=num;i++) {
			sum*=i;
		}
		System.out.println(num+"!은 "+sum+"입니다.");
		
	}
	
	public static void quiz2() {
		// 두 수 x y를 입력 후 x의 y승(x를 y횟수만큼 곱하는 것) for문을 이용해서 구하시오
		/* 
		 * 두 수 x,y 를입력하시오
		 * 3 3
		 * 3의 3승은 27입니다.
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int x,y,result=1;
		
		System.out.println("두 수 x,y 를입력하시오");
		System.out.print("x값 : ");
		x= sc.nextInt();
		System.out.print("y값 : ");
		y= sc.nextInt();
		
		for(int i=1;i<=y;i++) {
			result *=x;
		}
		System.out.println(x+"의 "+y+"승은 "+result+"입니다.");
		

	}
	
	public static void quiz3() {
		// 1부터 100까지의 합을 구하는데 짝수의 합과 홀수의 합을 나눠서 출력하라
		
		int odd=0,even=0;
		
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				even+=i;
			} else {
				odd+=i;
			}
		}
		System.out.println("1부터 100까지 짝수의 합은 "+even+"입니다.");
		System.out.println("1부터 100까지 홀수의 합은 "+odd+"입니다.");

	}

}
