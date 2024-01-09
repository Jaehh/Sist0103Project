package Day0109;

public class ArrString_11 {

	public static void main(String[] args) {
		
		//문자열 배열
		String [] str1 = {"텀블러","키보드","핸드크림","칫솔","우산"};
		String [] strColors = {"red","pink","blue","yello","gray","white"};
		
		//str1은 1번째:텀블러
		System.out.println("str_출력1_for");
		for(int i=0;i<str1.length;i++) {
			System.out.println(i+"번째:"+str1[i]);
		}
		
		System.out.println("str_출력2_foreach");
		for(String a : str1) {
			System.out.println(a);
		}
		
		//strColors 0번지 색: red
		System.out.println("strColors_출력1_for");
		for(int i=0;i<strColors.length;i++) {
			System.out.println(i+"번째:"+strColors[i]);
		}
		
		System.out.println("strColors_출력2_foreach");
		for(String a : strColors) {
			System.out.println(a);
		}
	}

}
