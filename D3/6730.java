package Main;

import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer token = new StringTokenizer(br.readLine());
			int[] blocks = new int[N];
			
			for (int j = 0; j < N; j++) {
				blocks[j] = Integer.parseInt(token.nextToken());
			}
			
			int up = 0;
			int down = 0;
			
			for (int j = 1; j < blocks.length; j++) {
				if(blocks[j] > blocks[j-1]) up = Math.max(up, blocks[j] - blocks[j-1]);
				else down = Math.max(down, blocks[j-1] - blocks[j]);
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(up)+" "+String.valueOf(down)+"\n");
			
			
		}
		bw.flush();
		bw.close();
	}
}
