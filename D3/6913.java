import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			
			int[][] programmer = new int[N][M];
			int[] score = new int[N];
			int solve_max = 0;
			for (int j = 0; j < N; j++) {
				StringTokenizer token2 = new StringTokenizer(br.readLine());
				int solve_sum = 0;
				for (int k = 0; k < M; k++) {
					int solve = Integer.parseInt(token2.nextToken());
					programmer[j][k] = solve;
					solve_sum += solve;
				}
				score[j] = solve_sum;
				if (solve_max < solve_sum) solve_max = solve_sum;
			}
			
			int person = 0;
			
			for (int j = 0; j < score.length; j++) {
				if (score[j] == solve_max) person++;
			}
			
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(person)+" "+String.valueOf(solve_max)+"\n");
		}

		bw.flush();
		bw.close();
	}
}







