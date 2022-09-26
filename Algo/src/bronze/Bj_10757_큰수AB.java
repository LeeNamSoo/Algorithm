package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Bj_10757_큰수AB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		
		//방법1--------------------------------
//		BigInteger ai  = new BigInteger(A);
//		BigInteger bi  = new BigInteger(B);
//		ai = ai.add(bi);
//		System.out.println(ai);
		//방법2---------------------------------
		StringBuilder sb = new StringBuilder();
		int indexA = A.length()-1;
		int indexB = B.length()-1;
		boolean flag=false;
		while(indexA>=0 || indexB>=0) {
			int a = indexA<0? 0 : A.charAt(indexA)-48;
			int b = indexB<0? 0 : B.charAt(indexB)-48;
			if(flag) a++;
			a+=b;
			if(a>=10) flag=true;
			else flag=false;
			indexA--;
			indexB--;
			sb.append(a%10);
		}
		if(flag)sb.append("1");
		System.out.println(sb.reverse());
	}
}
