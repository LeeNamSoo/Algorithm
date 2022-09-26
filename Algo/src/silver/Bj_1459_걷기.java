package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_1459_걷기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		long W = Integer.parseInt(st.nextToken());
		long S = Integer.parseInt(st.nextToken());
		long result;
		if(W*2<S) result = straightMode(X,Y,W);
		else result = crossMode(X,Y,W,S);
		
		System.out.println(result);
	}

	private static long straightMode(long x, long y, long w) {
		return x*w+y*w;
	}

	private static long crossMode(long x, long y, long w, long s) {
		long min = x<y ? x:y;
		long max = x>y ? x:y;
		long result = min*s;
		if(w>s) result += (max-min)%2==0 ? (max-min)*s : (max-min)*s+w-s;
		else result += (max-min)*w;
		return result;
	}
}
