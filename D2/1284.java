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
			int P = Integer.parseInt(token.nextToken());
			int Q = Integer.parseInt(token.nextToken());
			int R = Integer.parseInt(token.nextToken());
			int S = Integer.parseInt(token.nextToken());
			int W = Integer.parseInt(token.nextToken());

			int A = P * W;
			int B = 0;
			if (W <= R) B = Q;
			else B = Q + S * (W - R);
			
			if(A < B) bw.write("#" + String.valueOf(i) + " " + String.valueOf(A) + "\n");
			else bw.write("#" + String.valueOf(i) + " " + String.valueOf(B) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
