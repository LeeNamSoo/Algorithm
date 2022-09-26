package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_17822_원판돌리기 {
	static int N,M,T;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//원판돌리기
		int x,d,k;
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			rotation(x,d,k);
			remove();
		}
		
		int result=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j]>0) result += map[i][j];
			}
		}
		
		System.out.println(result);
	}

	private static void rotation(int x, int d, int k) {
		k = d==0? k:M-k;
		for(int i=1; i<=N; i++) {
			if(i%x==0) {
				int temp;
				int[] row = new int[M];
				for(int j=0; j<M; j++) {
					row[(j+k)%M] = map[i][j+1];
				}
				for(int j=0; j<M; j++) {					
					map[i][j+1]=row[j];
				}
			}
		}
	}

	private static void remove() {
		int[][] temp = new int[N+1][M+1];
		boolean flag=true;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<M; j++) {
				if(map[i][j]==map[i][j+1] && map[i][j] != -1) {
					temp[i][j] = -1;
					temp[i][j+1] = -1;
					flag=false;
				}
			}
			if(map[i][1]==map[i][M] && map[i][1] != -1) {
				temp[i][1] = -1;
				temp[i][M] = -1;
				flag=false;
			}
		}
		for(int i=1; i<=M; i++) {
			for(int j=1; j<N; j++) {
				if(map[j][i]==map[j+1][i] && map[j][i]!= -1) {
					temp[j][i] = -1;
					temp[j+1][i] = -1;
					flag=false;
				}
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(temp[i][j] == -1) {
					map[i][j] = temp[i][j];
				}
			}
		}
		if(flag) {
			calcFromAvg();
		}
	}

	private static void calcFromAvg() {
		float count=0;
		float sum=0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j]>0) {
					count++;
					sum+=map[i][j];
				}
			}
		}
		float avg = sum/count;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j]>avg) {
					map[i][j] -= 1;
				}else if(map[i][j]<avg && map[i][j]!=-1) {
					map[i][j] += 1;
				}
			}
		}
	}
}
