package Day0105;

import java.util.Scanner;

public class QuizOper_09 {

	public static void main(String[] args) {
		// 여러분이 받은 알바비를 입력한 후 만원, 천원, 백원, 십원, 일원의 갯수를 출력하시오
		/*
		 * 
		 * 알바비를 입력하시오. 568712
		 * 
		 * 만원: 56
		 * 천원: 8
		 * 백원: 7
		 * 십원: 1
		 * 일원: 2
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		int cost;
		
		System.out.print("알바비를 입력하시오. : ");
		cost = sc.nextInt();
		
		System.out.println("만원: "+(cost/10000));
		System.out.println("천원: "+(cost%10000)/1000);
		System.out.println("백원: "+(cost%1000)/100);
		System.out.println("십원: "+(cost%100)/10);
		System.out.println("일원: "+(cost%10)/1);
		
		
	}

}
