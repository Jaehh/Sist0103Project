package Day0109;

public class ArrInt_10 {

	public static void main(String[] args) {
		// 배열 선언과 동시에 초기값을 지정할 수 있다
		
		int [] arr = {2,3,4,56,54,77,88,27,89};
		
		System.out.println("갯수: "+arr.length);
		
		
		System.out.println("출력1_for");
		for(int i=0;i<arr.length;i++) {
			System.out.printf("%5d ",arr[i]);
		}
		System.out.println();
		
		
		
		System.out.println("출력1_foreach");
		for(int a:arr) {
			System.out.printf("%5d",a);
		}

	}

}
