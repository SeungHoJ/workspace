package array;

import java.util.Arrays;

public class Ex06 {
	public static void main(String[] args) {
		// 배열에서의최소값/최대값을 구하는 작업이 필요할때
		// 배열의 값들이 크기순으로 이미 정렬되어 있다면 훨씬 구하기 쉽다
		// 배열을 정렬하기 위해서는 서로 다른 두 값의크기를 비교하여 "자리를 바꿔야 한다"
		
		// 선택정렬 알고리즘
		// 배열의 각 자리에 맞는 값을 선택하여 자리를 교체하면서 정렬을 수행하는 알고리즘
		
		int[] arr = {4,8,2,7,6};
		
		System.out.println(Arrays.toString(arr));
		
		
		for(int i = 0;i<arr.length;i++) {
			for(int j = i+1;j<arr.length;j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
}
