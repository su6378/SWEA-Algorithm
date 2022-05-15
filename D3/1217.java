package Main;

import java.io.*;
import java.util.*;

class Solution {
	public int power(int a, int b) {
		if (b == 0) {
			return 1;
		}
		else {
			return a * power(a, b - 1);
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			
			Solution solution = new Solution();
			int answer = solution.power(N, M);
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(answer)+"\n");
		}
		bw.flush();
		bw.close();
	}

}
