package Main;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				int num = Integer.parseInt(token.nextToken());
				sum += num;
			}
			
			Double average = (double)sum / 10;
			bw.write("#"+String.valueOf(i)+" "+String.format("%.0f", average)+"\n");
		}

		bw.flush();
		bw.close();
	}
}