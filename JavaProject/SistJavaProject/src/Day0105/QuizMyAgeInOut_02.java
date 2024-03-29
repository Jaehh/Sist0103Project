package Day0105;

import java.util.Calendar;
import java.util.Scanner;

public class QuizMyAgeInOut_02 {

	public static void main(String[] args) {
		/*
		 * 
		 * 당신의 이름은? ===> 이수연
		 * 당신이 태어난 연도는? ===> 1988
		 * 당신이 사는 지역은? ===> 경기
		 * 
		 * ============================
		 * [이수연 님의 개인정보]
		 * ============================
		 * 이름: 이수연
		 * 태어난년도: 1988
		 * 나이: **세
		 * 지역: 경기
		 * 
		 * */
		
		
		//import
		Calendar cal = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		
		//2.변수 선언
		String name,area;
		int curYear,year,age;
		
		//3.입력
		System.out.print("당신의 이름은? ===> ");
		name = sc.nextLine();
		
		System.out.print("당신이 태어난 연도는? ===> ");
		year = Integer.parseInt(sc.nextLine());
		//Integer.parseInt("1988")=1980 : String -> int
		//sc.nextLine() 는 키보드의 버퍼나 엔터를 먼저 읽어서 없애준다.
		
		System.out.print("당신이 사는 지역은? ===> ");
		area = sc.nextLine();
		
		//4.계산
		//age = cal.get(cal.YEAR)-year;
		curYear = cal.get(cal.YEAR);
		age = curYear-year;
		
		
		//5.출력
		System.out.println("=====================================");
		System.out.println("\t["+name+"님의 개인정보]");
		System.out.println("=====================================");
		System.out.println("이름: "+name);
		System.out.println("태어난년도: "+year);
		System.out.println("나이: "+age+"세");
		System.out.println("지역: "+area);
		
		
	}

}
