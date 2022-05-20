package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			int E = Integer.parseInt(token.nextToken());
			
			int count = 0;
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int sw = Integer.parseInt(token2.nextToken());
				if(B % sw == 0) count++;
				else {
					int pow = B / sw;
					if(sw * pow >= B - E && sw * pow <= B + E) count++;
					else if(sw * (pow+1) <= B + E) count++;
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
