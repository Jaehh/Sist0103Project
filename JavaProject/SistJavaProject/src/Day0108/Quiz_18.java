package Day0108;

import java.util.Scanner;

public class Quiz_18 {

public static void main(String[] args) {
		
		//quiz_1();
		quiz_2();

	}

	public static void quiz_1() {

		//Q. 반복해서 숫자를 입력하여 양수의 갯수와 음수의 갯수를 구하시오(0입력시 종료) 
		/*
		 * 6
		 * -10
		 * 88
		 * 120
		 * -130
		 * 0
		 * 양수의 갯수: 3개
		 * 음수의 갯수: 2개
		 * 
		 * 
		 * */
		
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		int po=0, ne=0;
		
		System.out.println("숫자를 입력하시오 ");
		
		while(true) {
			num = sc.nextInt();
			if(num==0) {
				break;
			}
			if(num>0) {
				po++;
				continue;
			}
			if(num<0) {
				ne++;
				continue;
			}
			
		}
		System.out.println("양수의 갯수: "+po+"개");
		System.out.println("음수의 갯수: "+ne+"개");
		
	}

	public static void quiz_2() {
		
		// 반복해서 점수를 입력하고(1~100) 0을 입력시 빠져나와 갯수와 합계와 평균을 구하시오
		// 범위에 맞지않는 점수는 횟수에서 제외되어야 한다.
		
		Scanner sc = new Scanner(System.in);
		
		int score,count=0,sum=0,avg=0;
		
		System.out.println("점수를 입력하시오(1~100)");
		
		while(true) {
			score=sc.nextInt();
			if(score==0) {
				break;
			}
			if(score<1 || score>100) {
				continue;
				
			}
			count++;
			sum+=score;
			avg=sum/count;
		}
		System.out.println("갯수는 "+count+"입니다");
		System.out.println("합계는 "+sum+"입니다");
		System.out.println("평균은 "+avg+"입니다");
		
		
	}



}