package spring.di.ex2;

public class MyInfo {

	String name;
	int age;
	String addr;
	
	//명시적생성자
	public MyInfo(String name,int age,String addr) {
		this.name=name;
		this.age=age;
		this.addr=addr;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MyInfo [name="+name+", age="+age+", addr="+addr+"]";
	}
	
}
