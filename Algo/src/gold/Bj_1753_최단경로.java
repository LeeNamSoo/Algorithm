package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj_1753_최단경로 {
	static class Node implements Comparable<Node>{
		int node;
		int dist;
		public Node(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.dist, o.dist);
		}
		
	}
	
	static int V,E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		HashMap<Integer, ArrayList<Node>> edge = new HashMap<>(); 
		int u,v,w;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			Node node = new Node(v, w);
			if(!edge.containsKey(u)) edge.put(u, new ArrayList<>());
			edge.get(u).add(node);
		}
		int[] result = dijkstra(start, edge);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			sb.append(result[i]==11?"INF":result[i]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static int[] dijkstra(int start, HashMap<Integer, ArrayList<Node>> edge) {
		int[] result = new int[V+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(result, 11);
		pq.offer(new Node(start, 0));
		while(!pq.isEmpty()){
			Node current = pq.poll();
			int currNode = current.node;
			int currDistance = current.dist;
			if(result[currNode]<currDistance || !edge.containsKey(currNode)) continue;
			for(int j=0; j<edge.get(currNode).size(); j++) {
				Node next = edge.get(currNode).get(j);
				int nextNode = next.node;
				int nextDistance = currDistance + next.dist;
				if(result[nextNode]>nextDistance) {
					result[nextNode] = nextDistance;
					if(start==currNode) {
						edge.get(currNode).add(new Node(nextNode,result[nextNode]));
					}else {
						edge.get(start).add(new Node(nextNode,result[nextNode]));
					}
					pq.offer(new Node(nextNode,result[nextNode]));
				}
			}
		}
		result[start]=0;
		return result;
	}
}


