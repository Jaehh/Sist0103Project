package Day0105;

import java.util.Scanner;

public class IfReturn_18 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int score;
		
		System.out.println("점수입력(1~100)");
		score=sc.nextInt();
	
		if(score<1 || score>100) {
			System.out.println("잘못입력했습니다");
			return; //현재의 메인함수 종료
		} else {
			System.out.println("점수 : "+score);
		}
	
	}

}
