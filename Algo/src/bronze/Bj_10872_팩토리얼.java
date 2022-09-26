package bronze;

import java.util.Scanner;

public class Bj_10872_팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	
		int[] fibonachi = new int[21];
		fibonachi[0]=0;
		fibonachi[1]=1;
		for(int i=2; i<fibonachi.length; i++) {
			fibonachi[i] = fibonachi[i-1]+fibonachi[i-2];
		}
		System.out.println(fibonachi[N]);
	}
}
