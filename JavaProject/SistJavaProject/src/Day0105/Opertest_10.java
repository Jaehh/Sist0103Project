package Day0105;

import java.util.Scanner;

public class Opertest_10 {

	public static void main(String[] args) {
		// 신체검사를 하는데 이름과 키, 몸무게를 입력하면
		//표준 몸무게를 출력해보기(키-110*0.9) 
		//표준몸무게는 소수점 한자리로 출력
		/*
		 * 
		 * 당신의 이름? 이효리
		 * 키? 165 
		 * 
		 * 
		 * ============================
		 * 이효리님의 표준몸무게는 55.2kg입니다.
		 * 
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		String name;
	    double k,w;
		
		System.out.print("당신의 이름? ");
		name = sc.nextLine();
		
		System.out.print("키?");
		k = sc.nextDouble();
		
		
		w=(k-110)*0.9;
		
		System.out.println("==========================");
		System.out.printf("%s님의 표준몸무게는 %.1fkg입니다.",name,w);
		
	}

}
