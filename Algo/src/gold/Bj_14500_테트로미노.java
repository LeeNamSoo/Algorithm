package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_14500_테트로미노 {
	static int N,M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int maxLine = checkLine(map);
		int maxSquare = checkSquare(map);
		int maxRectangle = checkRectangle(map);
		
		System.out.println(Math.max(maxRectangle, Math.max(maxLine, maxSquare)));
	}

	private static int checkRectangle(int[][] map) {
		int result=0;
		int r=0;
		for(int i=0; i<N-1; i++) {
			int temp = map[i][0]+map[i][1]+map[i][2]+map[i+1][0]+map[i+1][1]+map[i+1][2];
			r = r>temp-map[i][0]-map[i][1] ? r:temp-map[i][0]-map[i][1];
			r = r>temp-map[i][1]-map[i][2] ? r:temp-map[i][1]-map[i][2];
			r = r>temp-map[i+1][0]-map[i+1][1] ? r:temp-map[i+1][0]-map[i+1][1];
			r = r>temp-map[i+1][1]-map[i+1][2] ? r:temp-map[i+1][1]-map[i+1][2];
			
			r = r>temp-map[i][0]-map[i+1][2] ? r:temp-map[i][0]-map[i+1][2];
			r = r>temp-map[i+1][0]-map[i][2] ? r:temp-map[i+1][0]-map[i][2];
			r = r>temp-map[i][0]-map[i][2] ? r:temp-map[i][0]-map[i][2];
			r = r>temp-map[i+1][0]-map[i+1][2] ? r:temp-map[i+1][0]-map[i+1][2];
			result = result>r ? result:r;
			for(int j=0; j<M-3; j++) {
				temp = temp - map[i][j]-map[i+1][j];
				temp = temp + map[i][j+3]+map[i+1][j+3];
				int I=i;
				int J=j+1;
				
				r = r>temp-map[I][J]-map[I][J+1] ? r:temp-map[I][J]-map[I][J+1];
				r = r>temp-map[I][J+1]-map[I][J+2] ? r:temp-map[I][J+1]-map[I][J+2];
				r = r>temp-map[I+1][J]-map[I+1][J+1] ? r:temp-map[I+1][J]-map[I+1][J+1];
				r = r>temp-map[I+1][J+1]-map[I+1][J+2] ? r:temp-map[I+1][J+1]-map[I+1][J+2];
				
				r = r>temp-map[I][J]-map[I+1][J+2] ? r:temp-map[I][J]-map[I+1][J+2];
				r = r>temp-map[I+1][J]-map[I][J+2] ? r:temp-map[I+1][J]-map[I][J+2];
				r = r>temp-map[I][J]-map[I][J+2] ? r:temp-map[I][J]-map[I][J+2];
				r = r>temp-map[I+1][J]-map[I+1][J+2] ? r:temp-map[I+1][J]-map[I+1][J+2];
				result = result>r ? result:r;
			}
		}

		r=0;
		for(int i=0; i<M-1; i++) {
			int temp = map[0][i]+map[1][i]+map[2][i]+map[0][i+1]+map[1][i+1]+map[2][i+1];
			r = r>temp-map[0][i]-map[1][i] ? r:temp-map[0][i]-map[1][i];
			r = r>temp-map[1][i]-map[2][i] ? r:temp-map[1][i]-map[2][i];
			r = r>temp-map[0][i+1]-map[1][i+1] ? r:temp-map[0][i+1]-map[1][i+1];
			r = r>temp-map[1][i+1]-map[2][i+1] ? r:temp-map[1][i+1]-map[2][i+1];
			
			r = r>temp-map[0][i]-map[2][i+1] ? r:temp-map[0][i]-map[2][i+1];
			r = r>temp-map[0][i+1]-map[2][i] ? r:temp-map[0][i+1]-map[2][i];
			r = r>temp-map[0][i]-map[2][i] ? r:temp-map[0][i]-map[2][i];
			r = r>temp-map[0][i+1]-map[2][i+1] ? r:temp-map[0][i+1]-map[2][i+1];
			result = result>r ? result:r;
			for(int j=0; j<N-3; j++) {
				temp = temp - map[j][i]-map[j][i+1];
				temp = temp + map[j+3][i]+map[j+3][i+1];
				int I=i;
				int J=j+1;

				r = r>temp-map[J][I]-map[J+1][I] ? r:temp-map[J][I]-map[J+1][I];
				r = r>temp-map[J+1][I]-map[J+2][I] ? r:temp-map[J+1][I]-map[J+2][I];
				r = r>temp-map[J][I+1]-map[J+1][I+1] ? r:temp-map[J][I+1]-map[J+1][I+1];
				r = r>temp-map[J+1][I+1]-map[J+2][I+1] ? r:temp-map[J+1][I+1]-map[J+2][I+1];
				
				r = r>temp-map[J][I]-map[J+2][I+1] ? r:temp-map[J][I]-map[J+2][I+1];
				r = r>temp-map[J][I+1]-map[J+2][I] ? r:temp-map[J][I+1]-map[J+2][I];
				r = r>temp-map[J][I]-map[J+2][I] ? r:temp-map[J][I]-map[J+2][I];
				r = r>temp-map[J][I+1]-map[J+2][I+1] ? r:temp-map[J][I+1]-map[J+2][I+1];
				result = result>r ? result:r;
			}
		}
		return result;
	}

	private static int checkSquare(int[][] map) {
		int result=0;
		int s;
		for(int i=0; i<N-1; i++) {
			s = map[i][0]+map[i][1]+map[i+1][0]+map[i+1][1];
			result = result>s ? result:s;
			for(int j=0; j<M-2; j++) {
				s = s - map[i][j]-map[i+1][j];
				s = s + map[i][j+2]+map[i+1][j+2];
				result = result>s ? result:s;
			}
		}
		return result;
	}

	private static int checkLine(int[][] map) {
		int w;
		int h;
		int result=0;
		for(int i=0; i<N; i++) {
			w = map[i][0]+map[i][1]+map[i][2]+map[i][3];
			result = result>w ? result:w;
			for(int j=0; j<M-4; j++) {
				w -= map[i][j];
				w += map[i][j+4];
				result = result>w ? result:w;
			}
		}

		for(int i=0; i<M; i++) {
			h = map[0][i]+map[1][i]+map[2][i]+map[3][i];
			result = result>h ? result:h;
			for(int j=0; j<N-4; j++) {
				h -= map[j][i];
				h += map[j+4][i];
				result = result>h ? result:h;
			}
		}
		return result;
	}
}
