package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_1193_분수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int count=0;
		String result;
		while(true) {
			if(X-count<=0) break;
			X-=count;
			count++;
		}
		if(X==0) result =  count%2==1? (count-1)+"/"+1 : 1+"/"+(count-1);
		if(count%2==1) result = (count-(X-1))+"/"+(1+(X-1));
		else result = (1+(X-1))+"/"+(count-(X-1));
		System.out.println(result);
	}
}
