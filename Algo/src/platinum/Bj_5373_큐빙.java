package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_5373_큐빙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				char[] direction = st.nextToken().toCharArray();
				switch (direction[0]) {
					case 'U': {
						up(direction[1]);
					}
					case 'D': {
						down(direction[1]);
					}
					case 'F': {
						front(direction[1]);
					}
					case 'B': {
						back(direction[1]);
					}
					case 'L': {
						left(direction[1]);
					}
					case 'R': {
						right(direction[1]);
					}
				}
			}
		}
	}

	private static void up(char c) {
		// TODO Auto-generated method stub

	}

	private static void down(char c) {
		// TODO Auto-generated method stub

	}

	private static void front(char c) {
		// TODO Auto-generated method stub

	}

	private static void back(char c) {
		// TODO Auto-generated method stub

	}

	private static void left(char c) {
		// TODO Auto-generated method stub

	}

	private static void right(char c) {
		// TODO Auto-generated method stub

	}
}
