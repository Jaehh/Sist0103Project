package Day0111;

import java.util.Scanner;

class Sawon{
	//private int tSawonSu; //총사원수
	private String sName; //사원명
	private int mPay; //월급여
	private int mSudang; //월수당
	
	//setter & getter
	/*
	 * public int gettSawonSu() { return tSawonSu; } public void settSawonSu(int
	 * tSawonSu) { this.tSawonSu = tSawonSu; }
	 */
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getmPay() {
		return mPay;
	}
	public void setmPay(int mPay) {
		this.mPay = mPay;
	}
	public int getmSudang() {
		return mSudang;
	}
	public void setmSudang(int mSudang) {
		this.mSudang = mSudang;
	}
	
	public static void showTitle() {
		System.out.println("[쌍용_1월 급여내역]");
		System.out.println();
		System.out.println("사원명\t기본급\t수당\t실수령액");
		System.out.println("==================================");
	}
	
}

public class QuizSawon_15 {

	public static void writeSawon(Sawon[] sawon) {
		Sawon.showTitle();
		for(Sawon s:sawon) {
			System.out.println(s.getsName()+"\t"+s.getmPay()+"\t"+s.getmSudang());
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sawonSu;
		Sawon[] sawon;
		
		System.out.println("입력할 직원수는?");
		sawonSu = Integer.parseInt(sc.nextLine());
	
		sawon = new Sawon[sawonSu];
		
		for(int i=0;i<sawonSu;i++) {
			sawon[i]=new Sawon();
			
			System.out.println("사원명");
			String sName = sc.nextLine();
			System.out.println("기본급");
			int mPay = sc.nextInt();
			System.out.println("수당");
			int mSudang = sc.nextInt();
			
		}

		
		
		
	}
}
