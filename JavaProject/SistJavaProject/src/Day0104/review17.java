package Day0104;

import java.util.Scanner;

public class review17 {

	public static void main(String[] args) {
		//변수는 args를 이용할 것
				/*
				 * 학생명 : 김선호 님
				 * 지역 : 부산
				 * 나이 : 23 세 
				 * 
				 * ================================================
				 * 김선호님의 자바점수는 88점 오라클점수는 77점 총 165점입니다.
				 * 
				 * */
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		String area;
		int age;
		int java;
		int oracle;
		int total;
		
		System.out.print("학생명 :  ");
		name = sc.nextLine();
		
		System.out.print("지역 : ");
		area = sc.nextLine();
		
		System.out.print("나이 : ");
		age = sc.nextInt();
		
		System.out.println("자바점수 : ");
		java = sc.nextInt();
		
		System.out.println("오라클점수 : ");
		oracle = sc.nextInt();
		
		total = java+oracle;
		
		System.out.println("학생명 : "+name+"님");
		System.out.println("지역 : "+area);
		System.out.println("나이 : "+age+"세");
		
		System.out.println(name+"님의 자바점수는 "+java+"점 오라클점수는"+oracle+"점 총"+total+"점 입니다");
		
		

	}

}
