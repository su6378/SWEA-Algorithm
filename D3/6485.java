package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < N; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(token.nextToken());
				int B = Integer.parseInt(token.nextToken());

				for (int j = A; j <= B; j++) {
					if (map.containsKey(j)) {
						map.put(j, map.get(j) + 1);
					} else
						map.put(j, 1);
				}
			}
			
			int P = Integer.parseInt(br.readLine());
			
			bw.write("#"+String.valueOf(tc)+" ");
			for (int i = 0; i < P; i++) {
				int C = Integer.parseInt(br.readLine());
				if(map.get(C) == null) bw.write("0 ");
				else bw.write(String.valueOf(map.get(C))+" ");
			} bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
