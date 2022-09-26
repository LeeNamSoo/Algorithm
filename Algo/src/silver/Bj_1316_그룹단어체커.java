package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Bj_1316_그룹단어체커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int result=0;
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			Set<Character> set = new HashSet<Character>();
			char prev=' ';
			boolean flag=true;
			for(int i=0; i<str.length(); i++) {
				Character c = str.charAt(i);
				if(prev!=c && set.contains(c)) {
					flag = false;
					break;
				}
				prev=c;
				set.add(c);
			}
			if(flag) result++;
		}
		System.out.println(result);
	}
}
