package Day0105;

import java.util.Scanner;

public class QuizOper_15 {

	public static void main(String[] args) {
		// 3개의 숫자를 입력하여 가장 큰 값 max값을 구하시오
		//if문 && 삼항연산자로도 구하라
		/*
		 * 
		 * 3개의 숫자를 입력하시오
		 * 3 4 5
		 * ***if문***
		 * max=5
		 * ***삼항연산자***
		 * max=5
		 * 
		 * */
		
		
		Scanner sc = new Scanner(System.in);
		
		int x,y,z,max;
		
		System.out.println("3개의 숫자를 입력");
		x= sc.nextInt();
		y=sc.nextInt();
		z=sc.nextInt();
		
		System.out.println("if문");
		if(x>y && x>z) 
			max=x;
			 else if(y>x && y>z) {
				max=y;
			} else {
			max=z;
			}
		
		System.out.println("max="+max);
		
		System.out.println("조건연산자");
		max=x>y&&x>z?x:y>x&&y>z?y:z;
		System.out.println("max="+max);
		
		
		
		
		}

	}


