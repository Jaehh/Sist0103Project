package Day0116;

import java.util.Scanner;

class SawonOuter{
	
	private String sawonName;
	private int giboonPay, familySu,timeSu;
	
	public void process() {
		//데이터입력
		InputInner input = new InputInner();
		input.inputData();
		
		//결과출력
		SudangInner output = new SudangInner();
		output.writeSawonData();
	}
	
	class InputInner{
		public void inputData() {
			Scanner sc = new Scanner(System.in);
			System.out.println("사원명 입력");
			sawonName = sc.nextLine();
			System.out.println("기본급?");
			giboonPay= sc.nextInt();
			System.out.println("초과시간?");
			timeSu = sc.nextInt();
			System.out.println("가족수?");
			familySu = sc.nextInt();
		}
	}
	
	
	class SudangInner{
		public int getTimeSudang() {
			return timeSu*30000;
		}
		
		public int getFamilySudang() {
			if(familySu<=4) {
				return 200000;
			} else {
				return 300000;
			}
		}
		
		public int getTex() {
			return (int)(giboonPay*0.03);
		}
		
		public int getTotalPay() {
			return giboonPay+getFamilySudang()+getTimeSudang()-getTex();
		}
		
		public void writeSawonData() {
			System.out.println("사원명\t기본급\t초과근무시간\t가족수\t시간수당\t가족수당\t세금\t총급여");
			System.out.println(sawonName+"\t"+giboonPay+"\t"+timeSu+"\t"+familySu+"\t"+getTimeSudang()+"\t"+getFamilySudang()+"\t"+getTex()+"\t"+getTotalPay());
		}
	}
}

public class QuizInnerClass_10 {

	public static void main(String[] args) {
		//방법1 : 내부클래스를 외부클래스 통해서 생성 후 메서드 호출
//		SawonOuter sawon= new SawonOuter();
//		
//		SawonOuter.InputInner input = sawon.new InputInner();
//		input.inputData(); //데이터 입력
//		
//		
//		SawonOuter.SudangInner output = sawon.new SudangInner();
//		output.writeSawonData();
		
		// 방법2 : 외부클래스의 멤버에서 내부클래스의 멤버를 호출 후 메인에서는 외부클래스 호춯
		SawonOuter sawon = new SawonOuter();
		sawon.process();
	}
}
