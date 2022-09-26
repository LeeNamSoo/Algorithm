package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_11501_주식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			long[] costs = new long[N];
			for(int i=0; i<N; i++) {
				costs[i] = Long.parseLong(st.nextToken());
			}
			long maxBenefit=0;
			long temp = costs[N-1];
			for(int i=N-1; i>=0; i--) {
				if(costs[i]<=temp) {
					maxBenefit += temp-costs[i];
				}else {
					temp=costs[i];
				}
			}
			sb.append(maxBenefit);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
