package Day0110;

class Mart{
	private String sangpum;
	int su;
	int dan;
	static String SHOPNAME="롯데마트";
	
	
	public Mart(){
		
	}
	/*
	 * public Mart(String sangpum, int su, int dan) { sangpum = sangpum; su = su;
	 * dan = dan; }
	 */
	
	//sangpum은 메서드가 아니면 다른 클래스에서 접근불가
	public void setSangpum(String sangpum) {
		this.sangpum=sangpum;
	}
	public String getSangpum(){
		return sangpum;
	}
	
	//su, dan은 private이 아니므로 다른 클래스에서 생성시 변수접근
	//static은 다른 클래스에서 접근시 클래스명.변수명으로 접근 가능
}
public class QuizClass_16 {
	
	public static void main(String[] args) {
		
		Mart m2 = new Mart();
		m2.setSangpum("초코파이");
        m2.su=10;
        m2.dan=4500;
        
        Mart m3 = new Mart();
		m3.setSangpum("엄마손파이");
        m3.su=5;
        m3.dan=2500;
        
        System.out.println("***"+Mart.SHOPNAME+" 입고상품***");
        
        System.out.println("상품명: "+m2.getSangpum());
        System.out.println("수량: "+m2.su+"개");
        System.out.println("가격: "+m2.dan+"원");
        System.out.println("-----------------------------------------");
        System.out.println("상품명: "+m3.getSangpum());
        System.out.println("수량: "+m3.su+"개");
        System.out.println("가격: "+m3.dan+"원");
		

	}

}
