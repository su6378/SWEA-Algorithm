import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			int win = 0;
			int lose = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'o') win++;
				else lose++;
			}
			
			int rest_match = 15 - (win + lose);
			
			win += rest_match;
			
			bw.write("#"+String.valueOf(tc)+" ");
			if (win > lose) {
				bw.write("YES\n");
			}else bw.write("NO\n");
			
		}
		bw.flush();
		bw.close();
	}
}











