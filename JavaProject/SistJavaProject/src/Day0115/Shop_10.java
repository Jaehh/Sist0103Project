package Day0115;

public class Shop_10 {
	private String sangName;
	private int su;
	private int dan;
	
	public Shop_10() {
		
	}
	
	public Shop_10(String sanName, int su, int dan) {
		this.sangName = sangName;
		this.su = su;
		this.dan = dan;
	}

	public String getSangName() {
		return sangName;
	}

	public void setSangName(String sangName) {
		this.sangName = sangName;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	public int getTot() {
		int s = this.su*this.dan;
		return s;
	}
	
	
}
