package Day0111;

class Artist{
	
	//변수명
	private String groupName;
	private String mainMusic;
	
	static String agency;
	static int cnt = 0;
	
	//명시적 생성자
	public Artist(String name, String music) {
		this.groupName = name;
		this.mainMusic = music;
		
	}
	
	//출력메서드 한번에 만들기
	public void writeArtistInfo(){
		cnt++;
		System.out.println("** 아티스트 정보_"+cnt+"**");
		System.out.println("소속기획사 : "+Artist.agency);
		System.out.println("그룹명 : "+this.groupName);
		System.out.println("대표곡 : "+this.mainMusic);
		System.out.println("-----------------------------------");
	}
}

public class QuizInstance_06 {

	public static void main(String[] args) {
		
		Artist a1 = new Artist("bts","butter");
		Artist a2 = new Artist("뉴진스","Attention");
		
	    Artist.agency="하이브";
	    
	    a1.writeArtistInfo();
	    a2.writeArtistInfo();
		
	}
}
