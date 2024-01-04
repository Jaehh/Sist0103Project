package Day0104;

public class DataType_09 {

	public static void main(String[] args) {
		//args를 이용한 연산
		
		//변수 선언
		int java = Integer.parseInt(args[0]);
		int jsp = Integer.parseInt(args[1]);
		int spring = Integer.parseInt(args[2]);
		
		//계산
		int tot= java+jsp+spring;
		int count = 3; //3과목을 의미하는 변수
		
		double avg1 = tot/3; //결과는 무조건 int 작은 건 큰 거에 담기므로 double 생략가능
		double avg2 = (double)tot/count; //결과는 double
		
		System.out.println(avg1);
		System.out.println(avg2);
		
		//printf를 이용해서
		//총점은 99
		System.out.printf("총점은 %d",(int)avg1);
		
		System.out.printf("java=%d, jsp=%d, spring=%d\n",java,jsp,spring);
		System.out.println("총점="+tot);
		
		System.out.printf("평균은=%.2f",avg1);
	}

}
