package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_16236_아기상어 {
	static class Shark{
		int size;
		int eatedFish;
		int[] position;
		int moveTime;
		public Shark(int size, int x, int y) {
			this.size = size;
			eatedFish =0;
			position = new int[] {x,y};
			moveTime=0;
		}
		void eat() {
			eatedFish++;
			if(size==eatedFish) {
				size++;
				eatedFish=0;
			}
		}
		void move(int x, int y) {
			position[0]=x;
			position[1]=y;
		}
	}
	static int N;
	static int[][] delta = new int[][] {{-1,0},{0,-1},{0,1},{1,0}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+2][N+2];
		Shark shark=null;
		Arrays.fill(map[0], -1);
		Arrays.fill(map[N+1], -1);
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=N+1; j++) {
				if(j==0||j==N+1) map[i][j]=-1;
				else map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					shark = new Shark(2, i, j);
					map[i][j]=0;
				}
			}
		}
		int result;
		result = start(map, shark);
		
		System.out.println(result);
	}
	private static int start(int[][] map, Shark shark) {
		int result=0;
		boolean isStop=false;
		Queue<int[]> queue = new LinkedList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0]) return o1[0]-o2[0];
				else return o1[1]-o2[1];
			}
		});
		while(!isStop) {
			isStop=false;
			pq.clear();
			queue.clear();
			queue.offer(shark.position);
			boolean[][] isVisited = new boolean[map.length][map.length];
			boolean isEat=false;
			int step=0;//움직인 거리 체크
			while(!queue.isEmpty()) {//		1. 가장 가까운 먹을수 있는 물고기를 찾는다.
				int size = queue.size();
				step++;
				for(int s=0; s<size; s++) {
					int[] curr = queue.poll();
					//isVisited[curr[0]][curr[1]] = true;
					for(int i=0; i<4; i++) {//상하죄우 이동
						int nextRow = curr[0]+delta[i][0];
						int nextCol = curr[1]+delta[i][1];
						if(isVisited[nextRow][nextCol]||map[nextRow][nextCol]<0 || map[nextRow][nextCol]>shark.size) {//이미 확인했던 곳이거나 맵밖을 벗어나거나 나보다 큰 물고기를 만난 경우
							continue;
						}
						else if(map[nextRow][nextCol]>0 && map[nextRow][nextCol]<shark.size) {//나보다 작은 물고기를 만난 경우
							pq.offer(new int[] {nextRow, nextCol});
							isEat=true;
						}
						else {//물고기가 없거나 나람 크기가 같은 물고기를 만난 경우
							isVisited[nextRow][nextCol] = true;
							queue.offer(new int[] {nextRow,nextCol});
						}
					}
				}
				if(isEat) {
					int[] feed = pq.poll();
					shark.move(feed[0], feed[1]);//		2. 이동한다.
					shark.eat();//		3. 물고기를 먹는다.
					map[feed[0]][feed[1]]=0;
					//System.out.println("x:"+feed[0]+", y:"+feed[1]+", step:"+step+", size:"+shark.size);
					break;
				}
			}
			//System.out.println("isEat:"+isEat);
			if(!isEat) isStop=true;
			else result+=step;
		}//		4. 1-3을 반복한다.
		return result;
	}
}
