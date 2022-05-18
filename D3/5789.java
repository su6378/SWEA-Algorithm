import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int Q = Integer.parseInt(token.nextToken());
			int[] box = new int[N];
			
			for (int i = 0; i < box.length; i++) {
				box[i] = 0; 
			}
			
			for (int i = 1; i <= Q; i++) {
				StringTokenizer token2 = new StringTokenizer(br.readLine());
				int L = Integer.parseInt(token2.nextToken()) - 1;
				int R = Integer.parseInt(token2.nextToken()) - 1;
				
				for (int j = L; j <= R; j++) {
					box[j] = i; 
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" ");
			
			for (int i = 0; i < box.length; i++) {
				bw.write(String.valueOf(box[i])+" ");
			}
			
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
} 

