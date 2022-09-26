package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj_2750_수정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		quickSort(nums);
		mergeSort(nums);
		insertionSort(nums);
		bubleSort(nums);
		selectSort(nums);
		heapSort(nums);
		Arrays.sort(nums);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(nums[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	

	private static void quickSort(int[] nums) {
		// TODO Auto-generated method stub
		
	}
	private static void mergeSort(int[] nums) {
		// TODO Auto-generated method stub
		
	}
	private static void insertionSort(int[] nums) {
		// TODO Auto-generated method stub
		
	}
	private static void bubleSort(int[] nums) {
		// TODO Auto-generated method stub
		
	}
	private static void selectSort(int[] nums) {
		// TODO Auto-generated method stub
		
	}
	private static void heapSort(int[] nums) {
		// TODO Auto-generated method stub
		
	}
}
