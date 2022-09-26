package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj_9020_골드바흐의추측 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		boolean[] isPrime = getPrime(10000);
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] partition = getPartition(N, isPrime);
			sb.append(partition[0]);
			sb.append(" ");
			sb.append(partition[1]);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

	private static int[] getPartition(int N, boolean[] isPrime) {
		int[] result = new int[2];
		for(int i=N/2; i>0; i--) {
			if(isPrime[i]) {
				for(int j=N/2; j<N; j++) {
					if(isPrime[j] && i+j==N) {
//						System.out.println(i+", "+j);
						result[0] = i;
						result[1] = j;
						return result;
					}
				}
			}
		}
		return result;
	}

	private static boolean[] getPrime(int num) {
		boolean[] result = new boolean[num+1];
		Arrays.fill(result, true);
		result[0]=false;
		result[1]=false;
		for(int i=2; i<result.length; i++) {
			if(result[i]) {
//				System.out.println(i);
				for(int j=2; j<result.length; j++) {
					if(i*j>=result.length) break;
					result[i*j]=false;
				}
			}
		}
		return result;
	}
}
