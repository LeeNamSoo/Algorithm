package silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Bj_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Set<String> set = new HashSet<String>();
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");
		set.add("z=");
		int result=0;
		while(str.length()>0) {
			if(str.length()==1) {
				result++;
				break;
			}
			String temp = str.substring(0, 2);
			if(temp.equals("dz") && str.length()>2 && str.charAt(2)=='=') str=str.substring(3, str.length());
			else if(set.contains(temp)) str=str.substring(2, str.length());
			else str=str.substring(1, str.length());
			result++;
		}
		System.out.println(result);
	}
}
