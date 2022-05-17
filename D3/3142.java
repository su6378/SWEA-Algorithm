import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc= 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			int unicon = 0;
			int twin = 0;
			
			for (int i = 0; i <= M; i++) {
				int one = 1 * (i);
				int two = 2 * (M - i);
				
				if (one + two == N) {
					unicon = i;
					twin = M - i;
					break;
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(unicon)+" "+String.valueOf(twin)+"\n");
			
			
		}
		bw.flush();
		bw.close();
	}
}

