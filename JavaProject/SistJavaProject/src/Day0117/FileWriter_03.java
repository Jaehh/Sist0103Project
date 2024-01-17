package Day0117;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileWriter_03 {

	public static void fileWrite() {
		FileWriter fw = null;
		String fileName = "C:\\sist0103\\file\\test1.txt";
		
		try {
			fw = new FileWriter(fileName);
			
			fw.write("Have a Nice Day~~\n");//메모장 줄넘김
			fw.write("오늘은 수요일\n");
			fw.write(new Date().toString());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void fileWrite2() {
		FileWriter fw = null;
		String fileName="C:\\sist0103\\file\\test1.txt";
		try {
			fw = new FileWriter(fileName,true);
			
			fw.write("내 이름은 홍재희\n");
			fw.write("------------------------\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		fileWrite();
		fileWrite2();
	}
}
