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
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			
			int[][] puzzle = new int[N][N];
			for (int j = 0; j < puzzle.length; j++) {
				StringTokenizer token2	= new StringTokenizer(br.readLine());
				for (int k = 0; k < puzzle[j].length; k++) {
					int cell = Integer.parseInt(token2.nextToken());
					puzzle[j][k] = cell; 
				}
				
			}
			
			int w_count = 0;
			int h_count = 0;
			int count = 0;
			for (int j = 0; j < puzzle.length; j++) {
				for (int k = 0; k < puzzle[j].length; k++) {
					if (puzzle[j][k] == 1) w_count++;
					else {
						if(w_count == K) count++;
						w_count = 0;
					}
					if(puzzle[k][j] == 1) h_count++;
					else {
						if(h_count == K) count++;
						h_count = 0;
					}
				}
				if(w_count == K) {
					w_count = 0;
					count++;
				}
				if(h_count == K) {
					h_count = 0;
					count++;
				}
				h_count = 0;
				w_count = 0;
			}
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(count)+"\n");
		}

		bw.flush();
		bw.close();
	}
}
