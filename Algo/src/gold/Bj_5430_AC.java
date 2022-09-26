package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bj_5430_AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		char[] functions;
		Deque<Integer> dequeue;
		for(int t=0; t<T; t++) {
			dequeue = new LinkedList<>();
			functions = br.readLine().toCharArray();
			br.readLine();
			String str = br.readLine();
			st = new StringTokenizer(str.substring(1, str.length()-1),",");
			while(st.hasMoreTokens()) {
				dequeue.offer(Integer.parseInt(st.nextToken()));
			}
			sb.append(excuteFunction(functions,dequeue)).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}

	private static String excuteFunction(char[] functions, Deque<Integer> dequeue) {
		boolean top=false;
		for(char c : functions) {
			if(c=='R') {
				top = top? false:true;
			}else {
				if(dequeue.size()==0) return "error";
				if(top) {
					dequeue.pollLast();
				}else {
					dequeue.pollFirst();
				}
			}
		}
		if(dequeue.isEmpty()) return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while(!dequeue.isEmpty()) {
			int num;
			if(top) {
				num = dequeue.pollLast();
			}else {
				num = dequeue.pollFirst();
			}
			sb.append(num).append(",");
		}
		sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
}
