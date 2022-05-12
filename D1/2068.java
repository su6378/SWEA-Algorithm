package Main;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(token.nextToken());

		for (int i = 1; i <= T; i++) {
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			int max = 0;

			for (int j = 0; j < 10; j++) {
				int num = Integer.parseInt(token2.nextToken());
				if (max < num) max = num;
			}

			bw.write("#" + String.valueOf(i) + " " + String.valueOf(max) + "\n");

		}

		bw.flush();
		bw.close();
	}
}