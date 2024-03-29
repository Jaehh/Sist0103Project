package Day0112;


//부모클래스
class Car{
	private String carCompany; //제조회사
	private String carKind;//종류
	
    
	// 디폴트 생성자
	public Car() {
		this("현대","전기차");
	}
	
	//명시적 생성자
	public Car(String cCompany, String cKind) {
		this.carCompany = cCompany;
		this.carKind = cKind;
	}

	//setter & getter
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	public String getCarKind() {
		return carKind;
	}
	public void setCarKind(String carKind) {
		this.carKind = carKind;
	}
	
	//메서드
	public void writeData() {
		System.out.println("회사명: "+this.carCompany);
		System.out.println("종류: "+this.carKind);
	}

}

class MyCar extends Car{
	private String carName;
	private String carColor;
	private int carPrice;

	public MyCar() {

	}
	public MyCar(String ccompany, String ckind,String cName,String cColor, int cPrice) {
		super(ccompany,ckind);
		this.carName = cName;
		this.carColor = cColor;
		this.carPrice = cPrice;

	}
    
	//setter & getter
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	//메서드 재정의
	@Override
	public void writeData() {

		super.writeData();
		System.out.println("자동차명: "+carName);
		System.out.println("색상: "+carColor);
		System.out.println("가격: "+carPrice+"원");
	}

}
public class Inherit_08 {

	public static void main(String[] args) {
		
		System.out.println("**디폴트 생성자로 생성**");
		MyCar c1 = new MyCar();
		c1.setCarName("아이오닉5");
		c1.setCarColor("블랙");
		c1.setCarPrice(350000000);
		c1.writeData();
		
		System.out.println("**명시적 생성자로 생성**");
		MyCar c2 = new MyCar("기아","가솔린","코나","화이트",25000000);
		c2.writeData();
		
		System.out.println("**부모 메서드 출력**");
		Car car1=new Car();
		car1.writeData();


	}

}
