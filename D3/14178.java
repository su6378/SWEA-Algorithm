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
			int D = Integer.parseInt(token.nextToken());
			int count = 0;
			int mid = (int)Math.round((double)N /2);
			int idx = 0;
			if (mid + D >= N) count = 1;
			else {
				count = 1;
				idx = 1 + D;
				while(true) {
					if (idx + D >= N) {
						break;
					}else {
						idx += 2 * D + 1;
						count++;
					}
				}
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(count)+"\n");
		}
		bw.flush();
		bw.close();
	}
}











