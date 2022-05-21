import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt((br.readLine().trim()));

		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer token = new StringTokenizer(br.readLine());
			long N = Long.parseLong(token.nextToken());
			long A = Long.parseLong(token.nextToken());
			long B = Long.parseLong(token.nextToken());
			long min = Long.MAX_VALUE;
			
			if((long)Math.sqrt(N) == Math.sqrt(N)) {
				min = 0;
			}else {
				for (long i = 1; i <= (long)Math.sqrt(N); ++i) {
					for (long j = i; (long)j*i <= N; ++j) {
						long sik =  A *(long) (j -i) + B * (long)(N - (long)i*j);
						if(sik < min) min = sik;
					}
				}
			}

			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(min)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
	
	
}
