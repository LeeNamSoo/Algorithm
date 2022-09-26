package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_2447_별찍기10 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String result = makeStars(N);
		System.out.println(result);
	}

	private static String makeStars(int n) {
		if(n==0) return "";
		if(n==1) return "*";
		
		StringBuilder sb = new StringBuilder();
		
			String str = makeStars(n/3);
			StringTokenizer st = new StringTokenizer(str);
			String subStr;
			String subEmptyStr;
			while(st.hasMoreTokens()) {
				subStr = st.nextToken("\n");
				System.out.println(subStr + ", N : " + n);
				sb.append(subStr);
				sb.append(subStr);
				sb.append(subStr);
				sb.append("\n");
			}
			st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				subStr=st.nextToken("\n");
				subEmptyStr = subStr;
				subEmptyStr = subEmptyStr.replace('*', ' ');
				sb.append(subStr);
				sb.append(subEmptyStr);
				sb.append(subStr);
				sb.append("\n");
			}
			st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				subStr = st.nextToken("\n");
				sb.append(subStr);
				sb.append(subStr);
				sb.append(subStr);
				sb.append("\n");
			}
			sb.setLength(sb.length()-2);
			return sb.toString();
	}

}
