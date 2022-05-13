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
			int M = Integer.parseInt(token.nextToken());
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			StringTokenizer aToken = new StringTokenizer(br.readLine());
			for (int a = 0; a < N; a++) {
				int a_num = Integer.parseInt(aToken.nextToken());
				A[a] = a_num;
			}
			
			StringTokenizer bToken = new StringTokenizer(br.readLine());
			for (int b = 0; b < M; b++) {
				int b_num = Integer.parseInt(bToken.nextToken());
				B[b] = b_num;
			}
			
			int max = 0;
			if(N < M) {
				for (int j = 0; j <= M-N; j++) {
					int sum = 0;
					for (int k = j; k < j+N ; k++) {
						sum += A[k-j] * B[k];
					}
					if(max < sum) max = sum;
				}
			}else {
				for (int j = 0; j <= N-M; j++) {
					int sum = 0;
					for (int k = j; k < j+M ; k++) {
						sum += A[k] * B[k-j];
					}
					if(max < sum) max = sum;
				}
			}
			bw.write("#"+String.valueOf(i)+" "+String.valueOf(max)+"\n");
		}

		bw.flush();
		bw.close();
	}
}
