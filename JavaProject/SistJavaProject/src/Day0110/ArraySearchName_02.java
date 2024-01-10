package Day0110;

import java.util.Scanner;

public class ArraySearchName_02 {

	public static void main(String[] args) {
		
		String[] names = {"김남준","김석진","민윤기","정호석","박지민","김태형","전정국"};
		
		boolean flag;
		
	   Scanner sc = new Scanner(System.in);
	   
	   String name;
	   
	   while(true) {
		   System.out.println("이름을 입력하세요");
		   name=sc.nextLine();
		   
		   if(name.equalsIgnoreCase("q")) { //문자열 비교는 메서드로 
			   System.out.println("종료하겠습니다");
			   break;
		   }
		   
		   flag = false;
		   
		   for(int i=0;i<names.length;i++) {
			   if(name.equals(names[i])) {
				   flag=true;
				   System.out.println(i+1+"번째 검색");
			   }
		   }
		   if(!flag) {
			   System.out.println("검색할 이름이 없습니다");
		   }
	   }
	}
}
