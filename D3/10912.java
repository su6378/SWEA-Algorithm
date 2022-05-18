import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			List<Character> list = new LinkedList<>();
			
			for (int i = 0; i < str.length(); i++) {
				if (list.contains(Character.valueOf(str.charAt(i)))) {
					list.remove(Character.valueOf(str.charAt(i)));
				}else list.add(str.charAt(i));
			}
			bw.write("#"+String.valueOf(tc)+" ");
			if (list.isEmpty()) bw.write("Good\n");
			else {
				Collections.sort(list);
				for (int i = 0; i < list.size(); i++) {
					bw.write(String.valueOf(list.get(i)));
				}
				bw.write("\n");
			}
			
		}
		bw.flush();
		bw.close();
	}
}
