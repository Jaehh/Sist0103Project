package Day0117;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format_01 {

	public static void main(String[] args) {
		
		Date date= new Date();
		
		System.out.println(date);
		
		//날짜, 시간을 원하는 양식에 맞춰 출력하기
		//HH는 24시간표시 MM :월 mm:분
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(sdf1.format(date));
		
		//a: 오전/오후 hh:12시간 표시
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		System.out.println(sdf2.format(date));
		
		//EEE: 요일짧게(ex.월) EEEE:요일길게(ex.월요일)
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm EEEE");
		System.out.println(sdf3.format(date));
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ");
		System.out.println(sdf4.format(date));
		
		//NumberFormat 숫자를 문자열로 변환하여 출력(콤마나 소수점자리수 지정)
		
		int money = 459970204;
		double num = 53.6322;
		
		NumberFormat nf1 = NumberFormat.getCurrencyInstance();//화폐단위와 콤마 제공
		System.out.println(nf1.format(money));
		
		NumberFormat nf2 =  NumberFormat.getInstance(); //콤마제공
		System.out.println(nf2.format(money));
		System.out.println(nf2.format(num));
		
	
	}
	
}
