package Main;

import java.io.*;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(token.nextToken());
			int U = Integer.parseInt(token.nextToken());
			int X = Integer.parseInt(token.nextToken());
			int bmi = Integer.MAX_VALUE;
			
			if(X < L) bmi = L - X;
			else if(X >= L && X <= U) bmi = 0;
			else bmi = -1;
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(bmi)+"\n");
			
		}

		bw.flush();
		bw.close();
	}
}
