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
			int M = Integer.parseInt(token.nextToken());
			int K = Integer.parseInt(token.nextToken());
			
			int[] customer = new int[N];
			StringTokenizer token2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				customer[i] = Integer.parseInt(token2.nextToken());
			}
			
			Arrays.sort(customer);
			
			int last = customer[customer.length-1];
			int carp_bread = 0;
			int idx = 0;
			boolean isPossible = true;
			if (customer[0] == 0) {
				isPossible = false;
			}else {
				for (int i = 1; i <= last; i++) {
					if(i % M == 0) carp_bread += K;
					
					if(i == customer[idx]) {
						if(carp_bread == 0) {
							isPossible = false;
							break;
						}
						else {
							carp_bread--;
							idx++;
						}
					}
				}
			}
		
			bw.write("#"+String.valueOf(tc)+" ");
			if(isPossible) bw.write("Possible\n");
			else bw.write("Impossible\n");
			
		}
		bw.flush();
		bw.close();
	}
}


