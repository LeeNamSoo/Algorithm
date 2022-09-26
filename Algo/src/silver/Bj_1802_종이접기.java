package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_1802_종이접기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			boolean isPossible = isFold(str);
			sb.append(isPossible?"YES":"NO").append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean isFold(String str) {
		int length = str.length();
		if(length<=1) return true; 
		for(int j=0; j<length/2; j++) {
			if(str.charAt(j)==str.charAt(length-1-j)) {
				return false;
			}
		}
		return isFold(str.substring(length/2+1));
	}
}
