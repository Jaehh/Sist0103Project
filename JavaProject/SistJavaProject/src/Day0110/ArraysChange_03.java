package Day0110;

public class ArraysChange_03 {
	public static void main(String[] args) {
		// 순서바꾸기 연습
		
		int a=10,b=20;
		System.out.println("a="+a+" , b="+b);
		
		int temp=a; //temp에 a를 담으면 a 비어있음
		a=b; //비어있는 a에 b 담음
		b=temp; //tem에 담긴 a를 b에 담음
		System.out.println("a="+a+" , b="+b);
		
		int[] n= {5,2,6};
		
		for(int s:n) {
			System.out.print(s+"  ");
		}
		
		System.out.println("0번이랑 2번을 교환 후 출력");
		int temp2= n[0];
		n[0]=n[2];
		n[2]=temp2;
		
		for(int s:n) {
			System.out.print(s+"  ");
		}
		
	}
}
