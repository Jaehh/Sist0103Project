package Day0110;

public class ArraySortString_05 {

	public static void main(String[] args) {
		
		String[] data= {"김남준","김석진","민윤기","정호석","박지민","김태형","전정국"};
		
		System.out.println("** 정렬 전 출력 **");
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+"  ");
		}
		System.out.println();
		
		System.out.println("** 오름차순 출력 **");
		
		//System.out.println("a".compareTo("b")); //-1
		//같으면 0, i>j 양수 i<j 음수 int 반환
		
		for(int i=0;i<data.length-1;i++) {
			for(int j=i+1;j<data.length;j++) {
				if(data[i].compareTo(data[j])>0) {
					String temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}
			}
		}
		
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+"  ");
		}
		System.out.println();
		
	}
}
