package Day0110;

public class ArrChangeDats_04 {

	public static void main(String[] args) {
		 
		int[] arr = {5,2,7,6,354,34,21,43,67,90};
		
		System.out.println("**원래 데이터**");
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
		
		System.out.println("** 거꾸로 변경하기**");
		
		
		for(int i=0;i<arr.length/2;i++) { //arr.length 의 반만 반복함
			int temp = arr[i];
			arr[i]=arr[arr.length-1-i]; //10개일때 0하고 9번하고 바꾸기
			arr[arr.length-1-i]=temp;
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
		
		System.out.println("** 오름차순 정렬 **");
		//선택정렬 : 가장 작은 수를 맨 앞으로 보냄
		//Arrays.sort(arr); 배열 arr을 정렬한다.
		
		for(int i=0;i<arr.length-1;i++) { //기준 데이터는 0부터 끝에서 두번째까지
			
			for(int j=i+1;j<arr.length;j++) {//비교하는 데이터는 기준다음값부터 끝까지
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
			
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
		
	}
	
}
