package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_5622_다이얼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int result = 0;
		for(int i=0; i<str.length(); i++) {
			String s = str.substring(i, i+1);
			if("ABC".contains(s)) result+=3;
			else if("DEF".contains(s)) result+=4;
			else if("GHI".contains(s)) result+=5;
			else if("JKL".contains(s)) result+=6;
			else if("MNO".contains(s)) result+=7;
			else if("PQRS".contains(s)) result+=8;
			else if("TUV".contains(s)) result+=9;
			else if("WXYZ".contains(s)) result+=10;
		}
		System.out.println(result);
	}
}
