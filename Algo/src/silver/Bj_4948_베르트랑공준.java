package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_4948_베르트랑공준 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] primeNum = new int[246999];
		primeNum[0]=1;
		primeNum[1]=1;
		for(int i=2; i<primeNum.length; i++) {
			if(primeNum[i]==0) {
				for(int j=2; j<primeNum.length; j++) {
					if(i*j>=primeNum.length) break;
					primeNum[i*j]=1;
				}
			}
		}
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int result = 0;
			for(int i=N+1; i<=2*N; i++) {
				if(primeNum[i]==0) result++;
			}
			System.out.println(result);
		}
	}
}

