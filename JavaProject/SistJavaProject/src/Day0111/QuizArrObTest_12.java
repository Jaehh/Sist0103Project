package Day0111;

class MyInfo{
	private String name;
	private String mbti;
	private int age;
	
	public MyInfo(String name, String mbti,int age) {
		this.name = name;
		this.mbti = mbti;
		this.age = age;
	}
	
	public static void showTitle(){
		System.out.println("이름\tMBTI\t나이");
		System.out.println("=========================");
	}
	
	public void showMyInfo() {
		System.out.println(name+"\t"+mbti+"\t"+age+"세");
	}
}

public class QuizArrObTest_12 {

	public static void main(String[] args) {
		
		
		MyInfo[] myinfo = {
		
		 new MyInfo("이효리","ENTP",26),
		 new MyInfo("이효리","ESTP",27),
		 new MyInfo("이효리","INTP",28)
		};
		
		MyInfo.showTitle();
		for(MyInfo info:myinfo)
			info.showMyInfo();		
		
	}
}
