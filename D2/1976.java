package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer token = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(token.nextToken());

		for (int i = 1; i <= T; i++) {
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			int hour1 = Integer.parseInt(token2.nextToken());
			int min1 = Integer.parseInt(token2.nextToken());
			int hour2 = Integer.parseInt(token2.nextToken());
			int min2 = Integer.parseInt(token2.nextToken());
			int hour = 0;
			int min = 0;

			if (min1 + min2 >= 60) {
				min = (min1 + min2) % 60;
				hour += (min1 + min2) / 60;
			} else min = min1 + min2;

			if (hour1 + hour2 + hour > 12) hour += (hour1 + hour2) % 12;
			else hour += hour1 + hour2;

			bw.write("#" + String.valueOf(i) + " " + String.valueOf(hour) + " " + String.valueOf(min) + "\n");
		}

		bw.flush();
		bw.close();
	}
}
