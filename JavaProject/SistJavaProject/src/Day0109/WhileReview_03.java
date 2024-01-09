package Day0109;

import java.util.Scanner;

public class WhileReview_03 {

	public static void main(String[] args) {
		/*
		 * 
		 * 반복적으로 나이를 입력한다/ 0이되면 종료
		 * 나이가 50세 이상일 경우 a변수 증가
		 * 나이가 30세 이상이면 b변수 증가
		 * 그 이외에는 c변수 증가
		 * 
		 * 빠져나온 후 출력내용
		 * 50세 이상: 3명
		 * 30세 이상: 2명
		 * 그외 : 3명
		 * 
		 * */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하시오");
		
		int age, a = 0,b=0,c=0;
		
		while(true) {
			age= sc.nextInt();
			
			//break
			if(age == 0) { //0이되면 종료
				break;
			}
			
			//조건
			if(age>=50) { //나이가 50세 이상일 경우 
				a++; //a변수 증가
			} else if(age>=30) { //나이가 30세 이상이면 
				b++; //b변수 증가
			} else { //그 이외에는 
				c++; //c변수 증가
			}
			
		}
		
		System.out.println("50세 이상: "+a+"명");
		System.out.println("30세 이상: "+b+"명");
		System.out.println("그외: "+c+"명");

	}

}
