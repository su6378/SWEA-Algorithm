import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			int[] B = new int[N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer token = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(token.nextToken());
				B[i] = Integer.parseInt(token.nextToken());
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (A[i] > A[j] && B[i] < B[j] ) count ++;
					else if(A[i] < A[j] && B[i] > B[j] ) count++;
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
			
			

		}
		bw.flush();
		bw.close();
	}
}




