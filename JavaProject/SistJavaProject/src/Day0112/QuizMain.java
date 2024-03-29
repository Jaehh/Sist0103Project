package Day0112;

import java.util.Scanner;

class Quiz{
	private String name;
	private int java;
	private int oracle;
	private int html;

	
	public Quiz(String name, int java, int oracle, int html) {
		this.name = name;
		this.java = java;
		this.oracle = oracle;
		this.html = html;
		
	}

	public Quiz() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getTotal() {
		
		int n= java +oracle+html;
		
		return n;
	}
	
	public double getAverge() {
		double n =  getTotal()/3;
		
		return n;
	}
	public String getPyungga() {
		if(getAverge()>=90) {
			return "장학생";
		} else if(getAverge()>=80) {
			return "합격";
		} else {
			return "불합격"; 
		}
	}
	
	public static void showTitle() {
		System.out.println("이름\tJAVA\tORACLE\tHTML\t총점\t평균\t평가");
		System.out.println("=====================================================");
	}
	
}

public class QuizMain {
	public static void writeQuiz(Quiz[] quiz) {
	Quiz.showTitle();
	for(Quiz q:quiz) {
		System.out.println(q.getName()+"\t"+q.getJava()+"\t"+q.getOracle()+"\t"+q.getHtml()+"\t"
	+q.getTotal()+"\t"+q.getAverge()+"\t"+q.getPyungga());
	}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int su;
		Quiz[] quiz;
		
		System.out.println("입력할 학생 수");
		su = Integer.parseInt(sc.nextLine());
		
		quiz = new Quiz[su];
		
		for(int i=0;i<su;i++) {
			quiz[i]= new Quiz();
			
			System.out.println("이름을 입력하시오");
			String name = sc.nextLine();
			System.out.println("JAVA 점수를 입력하시오");
			int java = Integer.parseInt(sc.nextLine());
			System.out.println("Oracle 점수를 입력하시오");
			int oracle = sc.nextInt();
			System.out.println("HTML 점수를 입력하시오");
			int html = sc.nextInt();
			
			quiz[i] = new Quiz(name,java,oracle,html);
			
			System.out.println();
		}
		writeQuiz(quiz);
	}

}
