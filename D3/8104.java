import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			
			int[][] students = new int[N][K];
			int rank = 1;
			for (int i = 0; i < N; i++) {
				if((i + 1) % 2 != 0) {
					for (int j = 0; j < K; j++) {
						students[i][j] = rank++;
					}
				}else if((i+1) % 2 == 0) {
					for (int j = K-1; j >= 0; j--) {
						students[i][j] = rank++;
					}
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i < K; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += students[j][i];
				}
				bw.write(String.valueOf(sum)+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}



