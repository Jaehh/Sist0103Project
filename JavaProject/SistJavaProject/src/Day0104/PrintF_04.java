/*
 10+20=30
num1의 값은 10,num2의 값은 20,result의 값은 30입니다
*/

package Day0104;

public class PrintF_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//%d : 정수 %f: 실수 %s : 문자열
		
		int num1=10,num2=20;
		int result=num1+num2;
		
		System.out.println(num1+"+"+num2+"="+result);
		
		System.out.printf("num1의 값은 %d,num2의 값은 %d,result의 값은 %d입니다\n",num1,num2,result);
		//결과를 10 + 20 = 30 출력
		System.out.printf("%d + %d = %d\n", num1,num2, result);
		
		
		
		//문자열 테스트
		String name="김선아";
		int age= 25;
		
		//출력
		//안녕하세요 제 이름은 김선아 입니다.
		//저의 나이는 25세 입니다.
		System.out.printf("안녕하세요 제 이름은 %s 입니다.\n저의 나이는 %d세 입니다",name,age);
	}

}
