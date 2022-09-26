package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_14503_로봇청소기 {
	static int[][] map, delta = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N,M,direction;
	static int[] position;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		position = new int[2];
		position[0] = Integer.parseInt(st.nextToken());
		position[1] = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = cleanRoom();
		System.out.println(result);
	}
	private static int cleanRoom() {
		int result=0;
		boolean flag = true;
		while(flag) {
			//현재칸을 청소한다.
			if(map[position[0]][position[1]]==0) {
				map[position[0]][position[1]]=2;
				result++;
			}
			boolean isMove = false;
			for(int i=1; i<=4; i++) {
				direction = (direction+3)%4;
				int[] nextPositon = new int[2];
				nextPositon[0] = position[0]+delta[direction][0];
				nextPositon[1] = position[1]+delta[direction][1];
				if(map[nextPositon[0]][nextPositon[1]]==0) {
					position[0] = nextPositon[0];
					position[1] = nextPositon[1];
					isMove = true;
					break;
				}
			}
			if(!isMove && map[position[0]+delta[(direction+2)%4][0]][position[1]+delta[(direction+2)%4][1]]==1) {
				break;
			}
			else if(!isMove && map[position[0]+delta[(direction+2)%4][0]][position[1]+delta[(direction+2)%4][1]]==2) {
				position[0] = position[0]+delta[(direction+2)%4][0];
				position[1] = position[1]+delta[(direction+2)%4][1];
			}
		}
		return result;
	}
}
