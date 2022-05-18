import java.io.*;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt((br.readLine().trim()));
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(token.nextToken());
			int E = Integer.parseInt(token.nextToken());
			int M = Integer.parseInt(token.nextToken());
			int year = 0;
			
			int sun = 0;
			int earth = 0;
			int moon = 0;
			while(true) {
				if (sun == S && earth == E && moon == M) break;
				
				sun++;
				earth++;
				moon++;
				year++;
				
				if (sun == 366) sun = 1;
				if (earth == 25) earth = 1;
				if (moon == 30) moon = 1;
			}
			
			bw.write("#"+String.valueOf(tc)+" "+String.valueOf(year)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}