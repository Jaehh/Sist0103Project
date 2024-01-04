package Day0104;

import java.util.Scanner;

public class KeyBordIn_14 {

	public static void main(String[] args) {
		//키보드 입력에 필요한 Scanner 클래스를 import(클래스가 가진 메서드를 사용하기 위해서)
		//1.import
		Scanner sc=new Scanner(System.in);
		
		//2.변수선언
		String name;
		int age;
		
		//3.입력
		System.out.print("이름을 입력해 보세요==>");
		name=sc.nextLine(); //한 줄을 문자로 읽어온다(공백사용가능)
		
		System.out.print("나이 입력해 보세요==>");
		//age=sc.nextInt(); //숫자로 읽어온다
		//숫자 입력 후 엔터를 누르면 그 엔터가 키보드 버퍼로 저장되어 다음 문자열 읽을 때 먼저 읽어버리는 현상발생
		//그래서 다음 문자열 읽기전에 그 엔터 읽어서 없애기... sc.nextLine()
		age = Integer.parseInt(sc.nextLine());
		
		System.out.println("당신이 사는 지역은?");
		String city=sc.nextLine(); 
		
		//4.최종출력
		System.out.println(name+"님의 나이는 "+age+"세 이고 "+city+"지역에 삽니다");

	}

}
