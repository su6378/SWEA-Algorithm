import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc= 1; tc <= T; tc++) {
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			sb.reverse();
			
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) == 'q') sb.setCharAt(i, 'p');
				else if (sb.charAt(i) == 'p') sb.setCharAt(i, 'q');
				else if (sb.charAt(i) == 'd') sb.setCharAt(i, 'b');
				else sb.setCharAt(i, 'd');
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(sb.toString())+"\n");
		}
		bw.flush();
		bw.close();
	}
}
