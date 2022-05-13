package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			String str = token.nextToken();
			StringBuilder sb = new StringBuilder();
			

			for (int j = str.length()-1; j >= 0; j--) {
				sb.append(str.charAt(j));
			}
			
			String reverse = sb.toString();
			
			if(reverse.equals(str)) bw.write("#"+String.valueOf(i)+" 1\n");
			else bw.write("#"+String.valueOf(i)+" 0\n");

		}

		bw.flush();
		bw.close();
	}
}
