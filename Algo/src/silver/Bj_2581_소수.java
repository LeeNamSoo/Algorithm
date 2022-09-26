package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_2581_소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] primeNum = new int[10001];
		primeNum[0]=1;
		primeNum[1]=1;
		for(int i=0; i<10001; i++) {
			if(primeNum[i]==0) {
				for(int j=2; j<10001; j++) {
					if(i*j>10000) break;
					primeNum[i*j]=1;
				}
			}
		}
		int minPrime=0,primeSum=0;
		for(int i=N; i>=M; i--) {
			if(primeNum[i]==0) {
				primeSum+=i;
				minPrime=i;
			}
		}
		if(minPrime==0) System.out.println(-1);
		else System.out.println(primeSum+"\n"+minPrime);
	}
}
