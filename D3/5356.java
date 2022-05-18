import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			String[] words = new String[5];
			int max = 0;
			for (int i = 0; i < 5; i++) {
				words[i] = br.readLine();
				if (max < words[i].length()) max = words[i].length();
			}
			bw.write("#"+String.valueOf(tc)+" ");
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < 5; j++) {
					if (i > words[j].length()-1) continue;
					else bw.write(String.valueOf(words[j].charAt(i))); 
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
