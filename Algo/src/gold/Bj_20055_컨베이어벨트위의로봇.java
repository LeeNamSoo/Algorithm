package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_20055_컨베이어벨트위의로봇 {
	static int N,K,step,zeroDurability;
	static int[][] belt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		step=0;
		zeroDurability=0;
		belt = new int[N*2][2];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<belt.length; i++) {
			belt[i][0] = Integer.parseInt(st.nextToken());
		}
		while(zeroDurability<K) {
			step++;
//			1.벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			rotation();
//			2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
//				로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
			move();
//			3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			addRobot();
//			4.내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
		}
		System.out.println(step);
	}
	private static void addRobot() {
		if(belt[0][0]!=0) {
			belt[0][1]=1;
			belt[0][0]--;
			if(belt[0][0]==0) zeroDurability++;
		}
		
	}
	private static void move() {
//		if(belt[N-2][1]==1) belt[N-2][1]=0;
		
		for(int i=N-2; i>=0; i--) {
			if(belt[i][1]==1 && belt[i+1][1]==0 && belt[i+1][0]!=0) {
				belt[i+1][0]--;
				belt[i+1][1] = 1;				
				belt[i][1] = 0;		
				if(i+1==N-1) belt[i+1][1] = 0;
				if(belt[i+1][0]==0) zeroDurability++;
			}
		}
	}
	private static void rotation() {
		int temp_durability = belt[N*2-1][0];
		int temp_robot = belt[N*2-1][1];
		if(belt[N-2][1]==1) belt[N-2][1]=0;
		
		for(int i=belt.length-1; i>0; i--) {
			belt[i][0] = belt[i-1][0];
			belt[i][1] = belt[i-1][1];
		}
		belt[0][0] = temp_durability;
		belt[0][1] = temp_robot;
	}
}
