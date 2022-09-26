package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Bj_2258_정육점 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<int[]> meats = new ArrayList<>();
		int totalWeight=0;
		int minCost=Integer.MAX_VALUE;
		int result=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			meats.add(new int[] {cost,weight});
		}
		Collections.sort(meats, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0]==0 ? o2[1]-o1[1]:o1[0]-o2[0];
			}
		});
		for(int i=0; i<N; i++) {
			if(totalWeight<M) {
				totalWeight += meats.get(i)[1];
				if(minCost == meats.get(i)[0]) result+=minCost;
				else result = meats.get(i)[0];
				minCost=meats.get(i)[0];
			}else {
				if(result>meats.get(i)[0] && minCost!= meats.get(i)[0] ) result=meats.get(i)[0];
			}
//			System.out.println(result);
			//System.out.println(meats.get(i)[0]+", "+meats.get(i)[1]);
			//totalWeight -= meats.get(i)[1];
		}
		System.out.println(totalWeight>=M? result:-1);
	}
}
