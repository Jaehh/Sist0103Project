package Day0109;

public class ForStar_02 {

	public static void main(String[] args) {
	 //quiz_1();
	 //quiz_2();
	 quiz_3();
		
	}
	
	public static void quiz_1() {
		// TODO Auto-generated method stub
		System.out.println("** 다중 for문으로 star(*) 출력하기 **");
		
		for(int i=1;i<=5;i++) { //행갯수
			for(int j=1;j<=5;j++) { //열갯수
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void quiz_2() {
		//삼각
		System.out.println("** 다중 for문으로 star(*) 출력하기 **");
		
		for(int i=1;i<=5;i++) { //행갯수
			for(int j=1;j<=i;j++) { //열갯수(i값 만큼만 반복)
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void quiz_3() {
		// 역삼각
		System.out.println("** 다중 for문으로 star(*) 출력하기 **");
		
		for(int i=1;i<=5;i++) { //행갯수
			for(int j=i;j<=5;j++) { //열갯수(i값 1일때 5번, i가 2일때 4번...)
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
