package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14501_퇴사 {
	static int N,result;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		result=0;
		
		dfs(0,0);
		
		System.out.println(result);
	}

	private static int dfs(int money, int day) {
		if(day>=N) return money;
		int temp;
		for(int i=day; i<N; i++) {
			if(i+map[i][0]>N) continue;
			if(i+map[i][0]==N) {
				temp = money+map[day][1];
				result = result>temp ? result:temp;
			}else {
				temp = dfs(money+map[day][1], i+map[i][0]);
				result = result>temp ? result:temp;
			}
//			System.out.println("temp : "+temp);
		}
		return money;
	}
}
