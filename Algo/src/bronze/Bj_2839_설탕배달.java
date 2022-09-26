package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		if(N<5) {
			if(N==3) System.out.println(1);
			else System.out.println(-1);
			return;
		}
		int inf=9999;
		int[] dp = new int[N+2];
		Arrays.fill(dp, inf);
		dp[3]=1;
		dp[5]=1;
		for(int i=6; i<=N; i++) {
			dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
//			System.out.println(dp[i]==inf ? -1:dp[i]);
		}
		if(dp[N]>inf) System.out.println(-1);
		else System.out.println(dp[N]==inf ? -1:dp[N]);
	}
}
