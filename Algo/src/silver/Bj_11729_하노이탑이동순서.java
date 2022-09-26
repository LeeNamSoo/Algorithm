package silver;

import java.util.Scanner;

public class Bj_11729_하노이탑이동순서 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();	
		int count = hanoi(N,1,2,3,0,sb);
		System.out.println(count);
		System.out.println(sb);
	}
	
	static int hanoi(int N, int start, int temp, int destination, int count, StringBuilder sb) {
		count++;
		if(N==1) {
			sb.append(start+" "+destination+"\n");
			return count;
		}
		count = hanoi(N-1, start, destination, temp, count, sb);
		sb.append(start+" "+destination+"\n");
		count = hanoi(N-1, temp, start, destination, count, sb);
		return count;
	}
}
