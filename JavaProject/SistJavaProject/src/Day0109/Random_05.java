package Day0109;

import java.util.Random;

public class Random_05 {

	public static void main(String[] args) {

		Random r = new Random();

		System.out.println("0~9사이의 난수 5개 발생");

		for(int i=1;i<=5;i++) {
			int a= r.nextInt(10); // 0~9 까지
			System.out.println(a);
		}
		System.out.println("-------------------------------------------");

		System.out.println("0~99사이의 난수 5개 발생");

		for(int i=1;i<=5;i++) {
			int a= r.nextInt(100); // 0~99 까지
			System.out.println(a);
		}
		System.out.println("-------------------------------------------");


		System.out.println("1~10사이의 난수 5개 발생");

		for(int i=1;i<=5;i++) {
			int a= r.nextInt(10)+1; // 1~10 까지
			System.out.println(a);
		}
		System.out.println("-------------------------------------------");
		
System.out.println("65~90사이의 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			int a= r.nextInt(26)+65; // 65가 시작점, 26= 90-65+1
			System.out.println((char)a);
		}
		System.out.println("-------------------------------------------");
	}

}
