package Day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuizFileException_15 {

	public static void fileRead() {
		String fName ="C:\\sist0103\\file\\fruitshop.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		int num = 0;
		
		try {
			fr = new FileReader(fName);
			br = new BufferedReader(fr);
			
			
			System.out.println("**과일 입고 목록**");
			System.out.println("번호\t과일명\t수량\t단가\t총금액");
			System.out.println("---------------------------------------");
			
				//br.readLine();
			
			
			while(true) {
		
				String s = br.readLine();
				num++;
				
				if(s == null) {
					break;
				}
				
				String[] data = s.split(",");
			
				System.out.println(num+"\t"+data[0]+"\t"+data[1]+"\t"+data[2]+"\t"+data[1] );
			}
			
			
		} catch (FileNotFoundException e) {
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		fileRead();
	}
}
