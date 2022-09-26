package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj_1911_흙길보수하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int result=0;
		int[][] ponds = new int[N][2];
		int start;
		int end;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			ponds[i][0]=start;
			ponds[i][1]=end;
		}
		Arrays.sort(ponds, Comparator.comparingInt(o1 -> o1[0]));
		int temp=0;
		for(int i=0; i<N; i++) {
			start = ponds[i][0];
			end = ponds[i][1];
			if(start<temp) start=temp;
			while(start<end) {
				start+=L;
				result++;
			}
			temp=start;
		}
		System.out.println(result);
	}
}
