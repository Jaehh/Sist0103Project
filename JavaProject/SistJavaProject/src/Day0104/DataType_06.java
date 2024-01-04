package Day0104;

public class DataType_06 {

	public static void main(String[] args) {
		//1.기본 자료형 8개
		
		boolean flag=false; //논리형 true, false
		//메서드 안에서는 boolean flag; 쓰면 안됨(클래스 안에서는 가능)
		
		
		//2.문자형
		//반드시 하나의 문자,16바이트 유니코드값 표현
		//2바이트 문자하나,한글 가능
		//기본적으로 정수형,아스키코드로 변경이 가능함
		//''로 표현
		char ch='가';
		
		
		//3.정수형
		byte a=-128;//1바이트 -128~127
		short b=32000;//16bit
		int c = 6700; //32bit
		long d=100L;//64bit 뒤에 L,l을 붙혀야 long인지 int인지를 의미
		
		//실수
		float f= 3.14159f; //32bit 뒤에 f를 붙히지 않으면 double을 의미
		
		double dou= 2345456.43673; //64bit 소수점을 가진 숫자를 의미 double이 기본
		
		
		
		
		//출력
		System.out.println("flag="+flag);
		System.out.println("문자형 ch="+ch);
		
		System.out.println("정수 a="+a);
		System.out.println("정수 b="+b);
		System.out.println("정수 c="+c);
		System.out.println("정수 d="+d);
		
		System.out.println("실수형 f="+f);
		System.out.println("실수형 dou="+dou);
		
		
		
		
	}

}
