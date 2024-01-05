package Day0105;

import java.util.Scanner;

public class QuizOper_21 {

	public static void main(String[] args) {
		/*
		 * (평가는 90점 이상: 참잘함!! 80점 이상: 좀더 노력하세요~~ 80점미만 : 불합격)
		 * 이름을 입력하세요
		 * 손흥민
		 * 국어, 영어, 수학 점수를 입력하세요
		 * 88
		 * 99
		 * 77
		 * 
		 * ==================================
		 * [손흥민 님의 기말고사 성적]
		 * 총점: ** 점
		 * 평균: **.**점
		 * 평가: 좀 더 노력하세요~~~
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		String name,result;
		int kor,eng,mat,total;
		double avg;
		
		System.out.println("이름을 입력하세요");
		name = sc.nextLine();
		
		System.out.println("국어, 영어, 수학 점수를 입력하세요");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		total = kor+eng+mat;
		avg = (kor+eng+mat)/3;
		
		if(avg>=90) {
			result = "참잘함!!";
		} else if(avg>=80) {
			result = "좀더 노력하세요~~";
		} else {
			result = "불합격";
		}
		
		
		System.out.println("================================");
		System.out.println("["+name+"님의 기말고사 성적]");
		System.out.println("총점: "+total+"점");
		System.out.println("평균: "+avg+"점");
		System.out.println("평가: "+result);
		
	}

}
