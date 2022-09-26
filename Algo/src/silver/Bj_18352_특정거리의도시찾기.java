package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_18352_특정거리의도시찾기 {
	static int N,M,K,X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(!graph.containsKey(s)) graph.put(s, new ArrayList<>());
			graph.get(s).add(e);
		}
		int[] result;
		result = BFS(graph);
		for(int i=1; i<=N; i++) {
			System.out.println("result["+i+"] : " + result[i]);
			if(result[i]==1) sb.append(i).append("\n");
		}
		
		System.out.println(sb.length()==0?"-1":sb.toString());
	}
	private static int[] BFS(HashMap<Integer, ArrayList<Integer>> graph) {
		boolean[] isVisited = new boolean[N+1];
		int[] result = new int[N+1];
		int step=0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(X);
		isVisited[X] = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			step++;
			for(int i=0; i<size; i++) {
				int curr = queue.poll();
				if(!graph.containsKey(curr)) continue;
				for(int j=0; j<graph.get(curr).size(); j++) {
					int next = graph.get(curr).get(j);
					if(!isVisited[next]) {
						isVisited[next] = true;
						queue.add(next);
						if(step==K) result[next]=1;
					}
				}
			}
			if(step==K) break;
		}
		return result;
	}
}
