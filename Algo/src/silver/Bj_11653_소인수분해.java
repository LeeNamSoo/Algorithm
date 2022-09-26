package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_11653_소인수분해 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] primeNum = new int[10000001];
		primeNum[0]=1;
		primeNum[1]=1;
		for(int i=0; i<primeNum.length; i++) {
			if(primeNum[i]==0) {
				for(int j=2; j<primeNum.length; j++) {
					if(i*j>primeNum.length-1) break;
					primeNum[i*j]=1;
				}
			}
		}
		int num=2;
		while(true) {
			if(N==1) break;
			if(primeNum[num]!=0 || N%num!=0) {
				num++;
				continue;
			}
			N /= num;
			sb.append(num);
			sb.append("\n");
		}
		if(sb.length()>0) sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}